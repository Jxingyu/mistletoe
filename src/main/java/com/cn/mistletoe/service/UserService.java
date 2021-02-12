package com.cn.mistletoe.service;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.Permission;
import com.cn.mistletoe.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

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

    CommonResult login(User user);

    User getUserByUsername(String username);

    List<Permission> getPermissionByRoleId(Integer id);

    Vector findAll();

}
