package com.cn.mistletoe.controller;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.Sign;
import com.cn.mistletoe.service.ISignService;
import com.cn.mistletoe.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/sign")
public class SignController {
    @Autowired
    ISignService iSignService;

    @Autowired
    RedisService redisService;

    @PostMapping("/insertRecord")
    public CommonResult insertSignRecord(@RequestBody Sign sign) {

        Boolean b = iSignService.insertSignRecord(sign);
        return CommonResult.success(b, "200");
    }

}
