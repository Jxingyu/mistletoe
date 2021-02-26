package com.cn.mistletoe.service.impl;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.Role;
import com.cn.mistletoe.mapper.RoleMapper;
import com.cn.mistletoe.service.PermissionService;
import com.cn.mistletoe.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RedisServiceImpl redisService;
    @Autowired
    PermissionService permissionService;
    @Override
    public List findRoleNameById(Integer id) {
        return roleMapper.findRoleNameById(id);
    }

    @Override
    public List findNowRoleByUserId(Integer id) {
        return roleMapper.findNowRoleByUserId(id);
    }

    @Override
    public Integer updateUserRole(Role role) {
        return roleMapper.updateUserRole(role);
    }

    @Override
    public Integer updateUserRoleTwo(Role role) {
        return roleMapper.updateUserRoleTwo(role);
    }

    @Override
    public List findAll() {

        return roleMapper.findAll();
    }

    @Override
    public ArrayList findAllRoles() {
        ArrayList<Role> roles;
        if (redisService.hasKey("RBAC_SYSTEM:ROLE:ROLES")){
            roles= (ArrayList<Role>) redisService.get("RBAC_SYSTEM:ROLE:ROLES");
        }else {
            ArrayList<Role> allRoles = roleMapper.findAllRoles();
            for (Role role:allRoles) {
                role.setPermissions(permissionService.findPermissionsByRoleId(role.getId()));
            }
            roles = allRoles;
            redisService.set("RBAC_SYSTEM:ROLE:ROLES",roles);
        }
            return roles;
    }
}
