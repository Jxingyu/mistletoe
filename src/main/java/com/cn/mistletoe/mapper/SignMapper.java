package com.cn.mistletoe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.mistletoe.model.Sign;

import java.util.List;


public interface SignMapper extends BaseMapper<Sign> {
    String select(Integer userId);

    String selectUserName(Integer userId);


    Integer putAll(List<Sign> signList);
}
