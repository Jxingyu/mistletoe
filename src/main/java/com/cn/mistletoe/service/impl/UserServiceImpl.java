package com.cn.mistletoe.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.common.JwtTokenUtil;
import com.cn.mistletoe.model.Permission;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.mapper.UserMapper;
import com.cn.mistletoe.service.RedisService;
import com.cn.mistletoe.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Vector;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    /**
     * 返回一个加密后的密码
     */
    private PasswordEncoder passwordEncoder;
    @Autowired
    /**
     * JWT(Json Web Token)登录支持 用于产生token和解析token
     */
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    /**
     * 注入基于原生redisTemplate
     * 而封装在redisServiceImpl里的redisTemplate
     * 接口: RedisService
     */
    private RedisService redisService;

    /**
     * @param loginParams
     * @return
     * @Cacheable会先判断缓存是否有值 优则返回 无则去数据库
     * <p>
     * (实现一小时内用户登陆密码错误！时 错误三次以上冻结24小时的功能)
     */

    @Override
//    @Cacheable(key = "#user")// 变量 引用下面的形参id // 使用 springCache的注解实现缓存
    public CommonResult login(User loginParams) {
        String username = loginParams.getUsername();
        Assert.notNull(username, "登录账号不能为空");
        String password = loginParams.getPassword();
        Assert.notNull(password, "登录密码不能为空");
        // 登陆前先去Redis判断目前登录用户是否已被冻结
        if (redisService.hasKey("LOGIN_USER_NAME:" + loginParams.getUsername())) {
            int LoginCount = (int) redisService.get("LOGIN_USER_NAME:" + loginParams.getUsername());
            if (LoginCount >= 3) {
                return CommonResult.success(LoginCount, "Account has been frozen 24 h");// 账户已被冻结
            }
        }
        // 查询当前登录用户 数据(登陆用户的数据和数据库账号和密码是否匹配)
        User nowUser = userMapper.getUserByUsername(loginParams.getUsername());
        // 对比传入的密码和数据库查出来的密码 返回一个布尔类型
        boolean matches = passwordEncoder.matches(loginParams.getPassword(), nowUser.getPassword());
        if (!matches) {// 如果不匹配 ↓
            if (!redisService.hasKey("LOGIN_USER_NAME:" + loginParams.getUsername())) {
                redisService.set("LOGIN_USER_NAME:" + loginParams.getUsername(), 0);// 如果不存在 创建 防止redis 报异常
            }
            int count = (int) redisService.get("LOGIN_USER_NAME:" + loginParams.getUsername());
            redisService.set("LOGIN_USER_NAME:" + loginParams.getUsername(), count + 1, 3600L);// 记录登录失败第一次 一小时内用户登陆失败三次以上冻结24小时的功能记录 每次登录失败+1
            int countNow = (int) redisService.get("LOGIN_USER_NAME:" + loginParams.getUsername());// countNow 更新后的实时 count
            if (redisService.hasKey("LOGIN_USER_NAME:" + loginParams.getUsername())) {// 是否存在缓存里
                //每次登录对当前账户的登录次数 做缓存 登录60分钟内 登录错误次数超过3次，账户锁定24小时
                if (countNow >= 2) {
                    // 等于3 时代表开始冻结账户，设置过期时间为24小时，并且对 value+1
                    if (countNow >= 3) {
                        redisService.set("LOGIN_USER_NAME:" + loginParams.getUsername(), count + 1, 3600L * 24);
                        return CommonResult.success(loginParams.getUsername(), "Account has been frozen 24 h");
                    }
                    redisService.set("LOGIN_USER_NAME:" + loginParams.getUsername(), count + 1, 3600L);
                }
            }
        }
        if (!redisService.hasKey("LOGIN_USER_NAME:" + loginParams.getUsername())) {
            redisService.set("LOGIN_USER_NAME:" + loginParams.getUsername(), 0);// 如果不存在 创建 防止redis 报异常
        }
        int countNow = (int) redisService.get("LOGIN_USER_NAME:" + loginParams.getUsername());// countNow 更新后的实时 count
        if ((matches && countNow < 3) || !redisService.hasKey("LOGIN_USER_NAME:" + loginParams.getUsername())) {// || redis不存在冻结用key value
            /*如果密码匹配成功并且未冻结 生成Token*/
            String generateTokenOne = jwtTokenUtil.generateToken(loginParams);// 传入查出的用户数据 用于返回Token
            // 登录成功后 将Redis 登录失败次数设为0
            int countNowTwo = (int) redisService.get("LOGIN_USER_NAME:" + loginParams.getUsername());// countNowTwo 更新后的实时 count
            if (countNowTwo > 0) {
                redisService.set("LOGIN_USER_NAME:" + loginParams.getUsername(), 0);
            }
            return CommonResult.success(generateTokenOne, "TokenSuccess");// 成功后 可以存入前端的localStorage.setItem,localSession里
        }
        return CommonResult.failed("failed");
    }

//
//    /**
//     * cheackRedis
//     *
//     * @param loginParams
//     * @return 登陆时去数据库匹配账号和密码
//     * 然后不匹配的话 去redis+1
//     * 如果满三次就去修改当前用户名的状态 为冻结 (暂时抹去他的登录权限 )
//     */
//    public CommonResult cheackRedisPassWord(User loginParams) {
//
//
//        return CommonResult.success(loginParams.getStatus());
//    }


    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<Permission> getPermissionByRoleId(Integer id) {
        return userMapper.getPermissionByRoleId(id);
    }

    @Override
    /**
     * 用户查询所有
     */
    public Vector findAll() {
        return userMapper.findAll();
    }

    /**
     * 队员列表信息更新
     * 密码更新 单独走security自带的passwordEncoder类下的.encode方法-- 进行加密
     * 冻结权限 走Redis判断(更新Redis冻结次数(标识))
     *
     * @param user
     * @return
     */
    @Override
    public Integer playerUpdate(User user) {
        String password = user.getPassword();
        Assert.notNull(password, "修改密码不能为空");
        String nowEncode = passwordEncoder.encode(password);// 返回一个加密后密码
        user.setPassword(nowEncode);
        Integer nowStatus = user.getStatus();
        Assert.notNull(nowStatus, "修改状态不能为空");
        if (nowStatus == 0) { // 如果状态参数修改0 去Redis里直接冻结(登录失败次数修改为3)
            redisService.set("LOGIN_USER_NAME:" + user.getUsername(), 3);
        } else {// 解除冻结
            redisService.set("LOGIN_USER_NAME:" + user.getUsername(), 0);
        }
        return userMapper.playerUpdate(user);
    }

    /**
     * 单文件上传(用户图片更新)
     * @param user
     * @return
     */
    @Override
    public Integer uploadFile(User user) {
        return userMapper.uploadFile(user);
    }

    /**
     * 用户列表编辑窗口查询
     * @param id
     * @return
     */
    @Override
    public User findPlayerById(Integer id) {
        return userMapper.findPlayerById(id);
    }

}
