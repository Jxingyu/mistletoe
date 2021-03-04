package com.cn.mistletoe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.mistletoe.model.UserCaptainRelation;

import java.util.List;

public interface UserCaptainService extends IService<UserCaptainRelation> {
    int updateNowCaptain(List<UserCaptainRelation>ucr);
}
