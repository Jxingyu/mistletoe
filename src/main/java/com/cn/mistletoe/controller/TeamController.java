package com.cn.mistletoe.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.Team;
import com.cn.mistletoe.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Vector;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService teamService;

    /**
     * 团队模块——小队列表查询
     *
     * @return
     */
    @GetMapping("/findTeamAll")
    public CommonResult findTeamAll() {
        Vector<Team> vector = teamService.findTeamAll();
        return CommonResult.success(vector, "200");
    }

    /**
     * 团队模块——编辑窗口更新
     *
     * @param team
     * @return
     */
    @PostMapping("/edit/update")
    public CommonResult editUpdate(@RequestBody Team team) {
        Integer integer = teamService.editUpdate(team);
        return CommonResult.success(integer, "200");
    }

    /**
     * 通过当前团队ID查询 相应数据
     *
     * @param numbers
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/findTeamById")
    public CommonResult findTeamByNumbers(@RequestParam("numbers") int numbers, HttpServletResponse response) throws IOException {
        Vector<Team> vector = teamService.findTeamById(numbers);
        return CommonResult.success(vector, "200");
    }

/*    *//**
     * 删除团队
     * @param numbers
     * @param pageNum
     * @return
     *//*
    @PostMapping({"/deleteTeam/{numbers}","/deleteTeam/{numbers}/{pageNum}"})
    public CommonResult deleteTeam(@PathVariable("numbers") int numbers,@PathVariable(value = "pageNum",required = false) int pageNum) {
        int result = teamService.deleteTeam(numbers);
        return CommonResult.success(result, "200");
    }*/
    /**
     * 删除团队
     * @param numbers
     * @return
     */
    @PostMapping("/deleteTeam/{numbers}")
    public CommonResult deleteTeam(@PathVariable("numbers") int numbers) {
        int result = teamService.deleteTeam(numbers);
        return CommonResult.success(result, "200");
    }
}
