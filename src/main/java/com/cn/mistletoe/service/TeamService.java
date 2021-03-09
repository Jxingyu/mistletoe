package com.cn.mistletoe.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.mistletoe.model.Team;

import java.util.Vector;

public interface TeamService extends IService<Team> {
    Vector<Team>  findTeamAll();


    Integer editUpdate(Team team);

    Vector<Team> findTeamById(int numbers);

    int deleteTeam(int numbers);
}
