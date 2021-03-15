package com.cn.mistletoe.controller;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.Daily;
import com.cn.mistletoe.service.IDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Vector;

@RestController
@RequestMapping("/daily")
public class DailyController {
    @Autowired
    IDailyService iDailyService;

    /**
     * 查询用户id By 用户名
     *
     * @param username
     * @return
     */
    @GetMapping(path = {"/selectDailyId"})
    public CommonResult selectDailyId(@RequestParam("username") String username) {
        Integer id = iDailyService.selectDailyId(username);
        return CommonResult.success(id, "200");
    }

    /**
     * 查询该用户所有日报
     *
     * @param userId
     * @return
     */
    @GetMapping(value = {"/selectDailyAll/{username}"})
    public CommonResult selectDailyAll(@PathVariable("username") Integer userId) {
        Vector<Daily> vector = iDailyService.selectDailyAll(userId);
        return CommonResult.success(vector, "200");
    }

    /**
     * 查询出当前写日报用户的
     * 教练 助理
     *
     * @param userId
     * @return
     */
    @GetMapping(value = {"/selectDailyEditMesByUserId/{userId}"})
    public CommonResult selectDailyEditMseByUserId(@PathVariable("userId") Integer userId) {
        Vector<Daily> vector = iDailyService.selectDailyEditMes(userId);
        return CommonResult.success(vector, "200");
    }
}
