package com.cn.mistletoe.mapper;

import com.alibaba.fastjson.JSONObject;
import com.cn.mistletoe.model.Permission;
import com.cn.mistletoe.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Vector;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
public interface UserMapper extends BaseMapper<User> {

//    List<User> checkUser(User user);

    User getUserByUsername(String username);

    List<Permission> getPermissionByRoleId(Integer id);

    List<User> getUserById(Integer idOne);

    Vector<User> findAll();

    Integer playerUpdate(User user);

    Integer uploadFile(User user);

    User findPlayerById(Integer id);
}
