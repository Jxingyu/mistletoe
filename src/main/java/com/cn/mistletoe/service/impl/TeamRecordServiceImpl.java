package com.cn.mistletoe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mistletoe.mapper.TeamRecordMapper;
import com.cn.mistletoe.model.TeamRecord;

import com.cn.mistletoe.service.TeamRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class TeamRecordServiceImpl extends ServiceImpl<TeamRecordMapper, TeamRecord>implements TeamRecordService {
    @Autowired
    TeamRecordMapper teamRecordMapper;

    @Override
    public Vector<TeamRecord> findTeamRecord() {
        return teamRecordMapper.findTeamRecord();
    }
}
