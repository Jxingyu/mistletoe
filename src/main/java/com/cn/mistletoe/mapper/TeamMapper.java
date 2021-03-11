package com.cn.mistletoe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.mistletoe.model.Team;
import com.cn.mistletoe.model.User;

import java.util.List;
import java.util.Vector;

public interface TeamMapper extends BaseMapper<Team> {

    Vector<Team> findTeamAll();

    Integer editUpdate(Team team);

    Vector<Team> findTeamById(int numbers);

    int deleteTeam(int numbers);

    List<Team> findAllTeam();

    List<Team> selectTeamNumbers();
}
