package com.cn.mistletoe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mistletoe.mapper.DailyMapper;
import com.cn.mistletoe.model.Daily;
import com.cn.mistletoe.service.IDailyService;
import com.cn.mistletoe.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Vector;

@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements IDailyService {
    @Autowired
    DailyMapper dailyMapper;

    @Autowired
    RedisService redisService;

    @Override
    public Integer selectDailyId(String username) {
        Integer id = dailyMapper.selectDailyId(username);
        return id;
    }

    @Override
    public Vector<Daily> selectDailyAll(Integer userId) {
        Vector<Daily> vector = dailyMapper.selectDailyAll(userId);
        return vector;
    }

    @Override
    public Vector<Daily> selectDailyEditMes(Integer userId) {
        // 查询团队区分用numbers
        Integer numbers = dailyMapper.selectNumbersByUserId(userId);
        Vector<Daily> dailies = dailyMapper.selectDailyEditMes(numbers);
        return dailies;
    }

    @Override
    public int insertDaily(Daily daily) {
        int i = dailyMapper.insertDaily(daily);
        return i;
    }

    @Override
    public int saveDailyInRedis(Daily daily) {
        /*List<Daily> list = Collections.singletonList(daily);
        list.stream().forEach(x -> {
            redisService.set("RBAC_SYSTEM:DAILY:DRAFT_TEAM" +"_"+ x.getUserId(), x);

        });*/
        int i = dailyMapper.saveDailyInRedis(daily);
        return i;
    }

    @Override
    public  Vector<Daily> selectDailyById(int id) {
        return dailyMapper.selectDailyById(id);
    }

    @Override
    public int updateDraftDaily(Daily daily) {
        return dailyMapper.updateDraftDaily(daily);
    }


}
