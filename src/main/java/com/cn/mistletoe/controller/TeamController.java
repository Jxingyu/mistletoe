package com.cn.mistletoe.controller;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService teamServiceImpl;

    @GetMapping("/findTeamAll")
    public CommonResult findTeamAll(){
        Vector vector = teamServiceImpl.findTeamAll();
        return CommonResult.success(vector,"200");
    }
}
