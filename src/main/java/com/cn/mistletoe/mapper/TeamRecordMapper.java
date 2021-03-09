package com.cn.mistletoe.mapper;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.mistletoe.model.TeamRecord;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public interface TeamRecordMapper extends BaseMapper<TeamRecord> {
    Vector<TeamRecord> findTeamRecord();

    void insertPastTeamRecord(@Param("sUserId") Integer sUserId, @Param("xUserId") Integer xUserId, @Param("xNumbers") Integer xNumbers);

    void updateCurrentTeamRecord(@Param("iNumbers") Integer iNumbers, @Param("iUserId") Integer iUserId);
}
