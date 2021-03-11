package com.cn.mistletoe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mistletoe.config.JwtAuthenticationTokenFilter;
import com.cn.mistletoe.mapper.SignMapper;
import com.cn.mistletoe.mapper.TeamMapper;
import com.cn.mistletoe.model.Sign;
import com.cn.mistletoe.model.Team;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.service.ISignService;
import com.cn.mistletoe.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Vector;

@Service
public class SignServiceImpl extends ServiceImpl<SignMapper, Sign> implements ISignService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignServiceImpl.class);
    @Autowired
    SignMapper signMapper;

    @Autowired
    RedisService redisService;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 提交到redis数据库
     * @param sign
     * @return
     */
    @Override
    public Boolean insertSignRecord(Sign sign) {
        Boolean sb = false;
        // 查询团队ID
        List<Team> numbers = teamMapper.selectTeamNumbers();
        for (Team team : numbers) {
            int numbers1 = team.getNumbers();
            if (redisService.hasKey("RBAC_SYSTEM:SIGN:TODAY_TEAM" + numbers1)) {
                if (sign.getSign().equals("normal")) {
                    sign.setSign("正常");
                }
                if (sign.getSign().equals("ask_for_leave")) {
                    sign.setSign("请假");
                }
                if (sign.getSign().equals("late")) {
                    sign.setSign("迟到");
                }
                if (sign.getSign().equals("leave_early")) {
                    sign.setSign("早退");
                }
                if (sign.getSign().equals("absenteeism")) {
                    sign.setSign("旷工");
                }
                Integer userId = sign.getUserId();// 查询用户当前团队名
                String teamName = signMapper.select(userId);
                String username = signMapper.selectUserName(userId); // 查询用户名
                sign.setNowNumbers(numbers1);
/*                Object o = redisService.get("RBAC_SYSTEM:SIGN:TODAY_TEAM" + numbers1);
                System.out.println(o);*/
                List<Sign> signs = (List<Sign>) redisService.get("RBAC_SYSTEM:SIGN:TODAY_TEAM" + sign.getNowNumbers());
                for (Sign s : signs) {
                    if (s.getUserId().intValue() == sign.getUserId().intValue()) {
                        s.setSignTime(sign.getSignTime());
                        s.setSign(sign.getSign());
                        s.setTeamName(teamName);
                        s.setUsername(username);
                    }
                }
                sb = redisService.set("RBAC_SYSTEM:SIGN:TODAY_TEAM" + numbers1, signs);

            } else {
                LOGGER.info("checking Redis KEY RBAC_SYSTEM:SIGN:TODAY_TEAM HAS ? :{}", "无小队签到记录");
            }
        }
        return sb;
    }

    /**
     * 提交到 sql数据库
     * @param signList
     * @return
     */
    @Override
    public Integer putAll(List<Sign> signList) {
         Integer integer = signMapper.putAll(signList);
        return integer;
    }


}
