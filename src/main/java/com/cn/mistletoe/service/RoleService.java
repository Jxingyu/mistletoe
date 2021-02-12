package com.cn.mistletoe.service;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Vector;

/**
 * <p>
 * 后台用户角色表 服务类
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
public interface RoleService extends IService<Role> {

    List findRoleNameById(Integer id);

    List findNowRoleByUserId(Integer id);

    Integer updateUserRole(Role role);

    Integer updateUserRoleTwo(Role role);

    List findAll();
}
