package com.cn.mistletoe.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.Role;
import com.cn.mistletoe.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * <p>
 * 后台用户角色表 前端控制器
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    /**
     * 查询权限模块 用户存在的所有角色
     *
     * @param id
     * @param response
     * @throws IOException
     */
    @GetMapping("/findRoleName")
    public void findRoleName(@RequestParam Integer id, HttpServletResponse response) throws IOException {
        List vector = roleService.findRoleNameById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", vector);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }

    /**
     * 权限模块--用户当前所属角色 编辑窗口查看
     * @param id
     * @param response
     * @throws IOException
     */
    @GetMapping("/findNameByUserId")
    @PreAuthorize("hasAuthority('role:edit:read')")
    public void findNowRoleById(@RequestParam Integer id, HttpServletResponse response) throws IOException {
        List vector = roleService.findNowRoleByUserId(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("findNameByUserId", vector);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }

    /**
     * 权限模块 穿梭框左边数据移至右边（分配角色）
     *
     * @param role
     * @param response
     * @throws IOException
     */
    @PostMapping("/updateUserRole")
    @PreAuthorize("hasAuthority('user:update')")
    public void updateUserRole(@RequestBody Role role, HttpServletResponse response) throws IOException {
        Integer tat = roleService.updateUserRole(role);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", tat);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }

    /**
     * 权限模块 穿梭框 右边数据移至左边(移除角色)
     * @param role
     * @param response
     * @throws IOException
     */
    @PostMapping("/updateUserRoleTwo")
    @PreAuthorize("hasAuthority('user:update')")
    public void updateUserRoleTwo(@RequestBody Role role, HttpServletResponse response) throws IOException {
        Integer tat = roleService.updateUserRoleTwo(role);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", tat);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }

    @GetMapping("findAll")
    @PreAuthorize("hasAuthority('role:list')")
    public void findAll(HttpServletResponse response) throws IOException {
        List<Role> RoleSelectAllVector = roleService.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", RoleSelectAllVector);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
//        return CommonResult.success(RoleSelectAllVector,"success");
    }
}
