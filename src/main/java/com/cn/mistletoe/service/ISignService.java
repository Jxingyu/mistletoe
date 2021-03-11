package com.cn.mistletoe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.mistletoe.model.Sign;

import java.util.List;
import java.util.Set;


public interface ISignService extends IService<Sign> {
    Boolean insertSignRecord(Sign sign);

    Integer putAll(List<Sign> signList);
}
