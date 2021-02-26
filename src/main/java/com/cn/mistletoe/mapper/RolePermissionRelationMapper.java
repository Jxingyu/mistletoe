package com.cn.mistletoe.mapper;

import com.cn.mistletoe.model.Permission;
import com.cn.mistletoe.model.RolePermissionRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 后台用户角色和权限关系表 Mapper 接口
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
public interface RolePermissionRelationMapper extends BaseMapper<RolePermissionRelation> {

    Integer insertRolePms(@Param("rpr") List<RolePermissionRelation> rpr);

    Integer deleteRpr(@Param("rpr")List<RolePermissionRelation> rpr);

    ArrayList<Permission> findPermissionsByRoleId(Integer roleId);

    ArrayList<Permission> findAllPermission();
}
