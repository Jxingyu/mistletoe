package com.cn.mistletoe.mapper;

import com.cn.mistletoe.model.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.mistletoe.model.Role;
import com.cn.mistletoe.model.RolePermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 后台用户权限表 Mapper 接口
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
public interface PermissionMapper extends BaseMapper<Permission> {


    List selectPermission();

    ArrayList selectPmsByRoleId(Long id);

    Integer insertRolePms(@Param("rpr") List<RolePermissionRelation> rpr);

    List selectRpr(Long id);

    String selectRoleById(Long id);
}
