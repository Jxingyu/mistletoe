package com.cn.mistletoe.controller;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.UserCaptainRelation;
import com.cn.mistletoe.service.UserCaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ucr")
public class UserCaptainController {

    @Autowired
    UserCaptainService userCaptainService;

    @PostMapping("/update/NowCaptain")
    @PreAuthorize("hasAuthority('team:captain')")
    public CommonResult updateNowCaptain(@RequestBody List<UserCaptainRelation> ucr) {
        int result = userCaptainService.updateNowCaptain(ucr);
        return CommonResult.success(result, "200");
    }

}
