package com.cn.mistletoe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.mistletoe.model.Team;

import java.util.Vector;

public interface TeamMapper extends BaseMapper<Team> {
    Vector<Team> findTeamAll();


}
