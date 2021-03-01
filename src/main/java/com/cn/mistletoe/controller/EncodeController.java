package com.cn.mistletoe.controller;

import com.cn.mistletoe.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Encode")
/**
 * 测试加密接口
 * 后将改为注册接口
 */
public class EncodeController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/check")
    public void register(@RequestBody User user) {
        String password = user.getPassword();
         String encode = passwordEncoder.encode(password);
        System.out.println(encode);
    }
}
