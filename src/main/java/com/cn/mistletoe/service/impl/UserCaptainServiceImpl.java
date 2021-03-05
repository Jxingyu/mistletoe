package com.cn.mistletoe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mistletoe.mapper.UserCaptainMapper;
import com.cn.mistletoe.model.UserCaptainRelation;
import com.cn.mistletoe.service.UserCaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCaptainServiceImpl extends ServiceImpl<UserCaptainMapper, UserCaptainRelation> implements UserCaptainService {
    @Autowired
    private UserCaptainMapper userCaptainMapper;

    @Override
    public int updateNowCaptain(List<UserCaptainRelation> ucr) {
        // 更新team表的队长列
        ucr.stream().forEach(x->{
            userCaptainMapper.updateTeamCaptainColumn(x.getUserId(),x.getNumbers());
        });
        int i = userCaptainMapper.updateNowCaptain(ucr);
        return i;
    }
}
