package com.cn.mistletoe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.mistletoe.model.Sign;

import java.util.List;
import java.util.Vector;


public interface SignMapper extends BaseMapper<Sign> {
    String select(Integer userId);

    String selectUserName(Integer userId);


    Integer putAll(List<Sign> signList);

    Vector<Sign> selectSignRecord(Sign sign);

    int selectTotalCount(Sign sign);

    int updateSign(Sign sign);

    String findSignById(int id);
}
