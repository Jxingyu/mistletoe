package com.cn.mistletoe.service.impl;

import com.cn.mistletoe.mapper.RolePermissionRelationMapper;
import com.cn.mistletoe.model.Permission;
import com.cn.mistletoe.mapper.PermissionMapper;
import com.cn.mistletoe.model.RolePermissionRelation;
import com.cn.mistletoe.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
@Autowired
PermissionMapper permissionMapper;
@Autowired
RolePermissionRelationMapper rolePermissionRelationMapper;
    @Override
    public List selectPermission() {
        return permissionMapper.selectPermission();
    }

    @Override
    public List selectPmsByRoleId(Long id) {
        return permissionMapper.selectPmsByRoleId(id);
    }

    @Override
    public Integer insertRolePms(List<RolePermissionRelation> rpr) {
        //@Transactional 添加在实现层 和 启动类后开启事务 实现混滚 commit 去插入数据
        /*for(RolePermissionRelation relation:rpr){
            rolePermissionRelationMapper.insert(relation);
        }
        return rpr.size();*/
        return rolePermissionRelationMapper.insertRolePms(rpr);
    }

    @Override
    public List selectRpr(Long id) {
        return permissionMapper.selectRpr(id);
    }

    @Override
    public Integer deleteRpr(List<RolePermissionRelation> rpr) {
        return rolePermissionRelationMapper.deleteRpr(rpr);
    }
}
