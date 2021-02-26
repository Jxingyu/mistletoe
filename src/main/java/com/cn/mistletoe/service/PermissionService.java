package com.cn.mistletoe.service;

import com.cn.mistletoe.model.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.mistletoe.model.RolePermissionRelation;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 后台用户权限表 服务类
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
public interface PermissionService extends IService<Permission> {

    List selectPermission();

    ArrayList selectPmsByRoleId(Long id);

    Integer insertRolePms(List<RolePermissionRelation> rpr);

    List selectRpr(Long id);

    Integer deleteRpr(List<RolePermissionRelation> rpr);

    ArrayList<Permission> findPermissionsByRoleId(Integer roleId);

    ArrayList<Permission> findAllPermission();
}
