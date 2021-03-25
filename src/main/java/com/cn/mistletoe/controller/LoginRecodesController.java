package com.cn.mistletoe.controller;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.LoginRecodes;
import com.cn.mistletoe.service.ILoginRecodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;

@RestController
@RequestMapping("/LoginRecodes")
public class LoginRecodesController {
    @Autowired
    private ILoginRecodesService iLoginRecodesService;

    @GetMapping(value = {"/SelectAll"})
    @PreAuthorize("hasAuthority('login:logs')")
    public CommonResult SelectAllLoginRecodes(LoginRecodes loginRecodes) {
        Vector<LoginRecodes> vector = iLoginRecodesService.SelectAllLoginRecodes(loginRecodes);
        return CommonResult.success(vector, "200");
    }
}
