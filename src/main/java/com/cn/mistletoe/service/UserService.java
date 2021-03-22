package com.cn.mistletoe.service;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.Permission;
import com.cn.mistletoe.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.mistletoe.model.UserTeamRelation;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Vector;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
public interface UserService extends IService<User> {

    Object login(User user, HttpServletRequest request);

    User getUserByUsername(String username);

    List<Permission> getPermissionByRoleId(Integer id);

    Vector findAll(User user);

    Integer playerUpdate(User user);

    Integer uploadFile(User user);

    User findPlayerById(Integer id);

    int findTotalCount(User user);

    Vector findPlayerAll(User user);

    CommonResult register(User user);

    Integer registerIconUpdate(User user);


    List<UserTeamRelation> findUserByTeamNumbers(Integer numbers);

    String selectTeamNameByNumbers(Integer numbers);

    String selectUsernameByUserId(Integer userId);
}
