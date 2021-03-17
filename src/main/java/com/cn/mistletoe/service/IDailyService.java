package com.cn.mistletoe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.mistletoe.model.Daily;

import javax.servlet.http.HttpServletResponse;
import java.util.Vector;

public interface IDailyService extends IService<Daily> {
    Vector<Daily> selectDailyAll(Integer userId);

    Integer selectDailyId(String username);

    Vector<Daily> selectDailyEditMes(Integer userId);

   int  insertDaily(Daily daily);

    int saveDailyInRedis(Daily daily);

    Vector<Daily> selectDailyById(int id);

    int updateDraftDaily(Daily daily);

    int updateDailyStatus(int id,String status);

    String ExportWord(Daily daily, HttpServletResponse response);
}
