package com.cn.mistletoe.service.impl;

import com.cn.mistletoe.model.UserRoleRelation;
import com.cn.mistletoe.mapper.UserRoleRelationMapper;
import com.cn.mistletoe.service.UserRoleRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和角色关系表 服务实现类
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
@Service
public class UserRoleRelationServiceImpl extends ServiceImpl<UserRoleRelationMapper, UserRoleRelation> implements UserRoleRelationService {

}
