package com.cn.mistletoe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mistletoe.mapper.TeamMapper;
import com.cn.mistletoe.model.Team;
import com.cn.mistletoe.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {
    @Autowired
    TeamMapper teamMapper;

    @Override
    public Vector findTeamAll() {
        return teamMapper.findTeamAll();
    }
}
