package com.cn.mistletoe.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
/**
 * 注册接口
 */
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserService userService;

    /**
     * 个人信息注册
     * @param user
     * @return
     */
    @PostMapping("/check")
    public CommonResult register(@RequestBody User user){
        CommonResult result = userService.register(user);
        return CommonResult.success(result,"200");
    }
}
