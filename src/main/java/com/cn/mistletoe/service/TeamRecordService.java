package com.cn.mistletoe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.mistletoe.model.TeamRecord;

import java.util.Vector;

public interface TeamRecordService extends IService<TeamRecord> {
    Vector<TeamRecord> findTeamRecord();

}
