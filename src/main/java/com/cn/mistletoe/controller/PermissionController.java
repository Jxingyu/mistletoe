package com.cn.mistletoe.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.RolePermissionRelation;
import com.cn.mistletoe.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 后台用户权限表 前端控制器
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping("/selectPermission")
    public void selectPermission(HttpServletResponse response) throws IOException {
        List list = permissionService.selectPermission();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }

    @GetMapping("/selectPmsByRoleId")
    public void selectPmsByRoleId(@RequestParam Long id, HttpServletResponse response) throws IOException {
        List list = permissionService.selectPmsByRoleId(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }

    /**
     * 查询当前角色rpr关联表数据
     * @param id
     * @param response
     * @throws IOException
     */
    @GetMapping("/selectRpr")
    public void selectRpr(@RequestParam Long id, HttpServletResponse response) throws IOException {
        List list = permissionService.selectRpr(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }

    /**
     * 权限关联表 数据insert 可改为update
     * @param rpr
     * @param response
     * @throws IOException
     */
    @PostMapping("/insertRolePms")
    public void insertRolePms(@RequestBody List<RolePermissionRelation> rpr, HttpServletResponse response) throws IOException {
        Integer integer = permissionService.insertRolePms(rpr);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", integer);
        //response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }
    @PostMapping("/deleteRpr")
    public CommonResult deleteRpr(@RequestBody List<RolePermissionRelation>rpr){
        Integer integer = permissionService.deleteRpr(rpr);
        return CommonResult.success(integer,"delSuccess");
    }
}
