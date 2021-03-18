package com.cn.mistletoe.controller;

import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.model.TeamRecord;
import com.cn.mistletoe.service.TeamRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;

/**
 * 调队记录控制层
 */
@RestController
@RequestMapping("/teamRecord")
public class TeamRecordController {
    @Autowired
    TeamRecordService teamRecordService;

    /**
     * 调队记录
     * @return
     */
    @GetMapping("/findTeamRecord")
    @PreAuthorize("hasAuthority('team:change:notes')")
    public CommonResult findTeamRecord() {
        Vector<TeamRecord> vector = teamRecordService.findTeamRecord();
        return CommonResult.success(vector, "200");
    }
}
