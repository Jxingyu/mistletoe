package com.cn.mistletoe.service.impl;

import com.cn.mistletoe.model.Permission;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService") // 提供从数据库查出来的用户(根据用户名或者账号)查出来的实体
public class MyUserDetailsImpl implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);// 查出用户
        List<Permission> permissionList = userService.getPermissionByRoleId(user.getId());// 查出权限
//        HashSet<Permission> permissions = new HashSet<>(permissionList);
        List<Permission> permissions= new ArrayList (permissionList);
        user.setAuthorities((List) permissions);
        return (UserDetails) user; // UserDetails类型
    }
}
