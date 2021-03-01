package com.cn.mistletoe.controller;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping("/check")
    public CommonResult register(@RequestBody User user) {
        int result = userService.register(user);
        return CommonResult.success(result,"200");
    }
}
