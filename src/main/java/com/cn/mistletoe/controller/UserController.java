package com.cn.mistletoe.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.common.MyImgLoad;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.service.UserService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findAll")
    public void findAll(HttpServletResponse response) throws IOException {
        Vector vector = userService.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", vector);
        response.setContentType("application/json;charset=utf-8");
//        String s = JSON.toJSONString(jsonObject);
        response.getWriter().write(JSON.toJSONString(jsonObject));
    }

    @PostMapping("/player/update")
    public CommonResult update(@RequestBody User user) {
        /*MyImgLoad.load(request);
        User user = new User();
        user.setId(Integer.parseInt((String) request.getAttribute("id")));
        user.setIcon((String) request.getAttribute("imgHref"));
        user.setUsername((String) request.getAttribute("username"));
        user.setSex((String) request.getAttribute("sex"));
        user.setPhone((String) request.getAttribute("phone"));
        user.setAddress((String) request.getAttribute("address"));
        user.setCreateTime((String) request.getAttribute("createDate"));
        user.setStatus(Integer.parseInt((String) request.getAttribute("status")) );
        user.setPassword((String) request.getAttribute("password"));*/
        Integer integer = userService.playerUpdate(user);
        return CommonResult.success(integer, "code:200");
    }
}