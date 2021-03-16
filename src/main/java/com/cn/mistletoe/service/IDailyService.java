package com.cn.mistletoe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.mistletoe.model.Daily;

import java.util.Vector;

public interface IDailyService extends IService<Daily> {
    Vector<Daily> selectDailyAll(Integer userId);

    Integer selectDailyId(String username);

    Vector<Daily> selectDailyEditMes(Integer userId);

   int  insertDaily(Daily daily);

    int saveDailyInRedis(Daily daily);

    Vector<Daily> selectDailyById(int id);

    int updateDraftDaily(Daily daily);
}