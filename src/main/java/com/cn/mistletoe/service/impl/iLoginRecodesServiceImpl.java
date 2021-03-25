package com.cn.mistletoe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mistletoe.mapper.LoginRecodesMapper;
import com.cn.mistletoe.model.LoginRecodes;
import com.cn.mistletoe.service.ILoginRecodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class iLoginRecodesServiceImpl extends ServiceImpl<LoginRecodesMapper, LoginRecodes> implements ILoginRecodesService {
    @Autowired
    private LoginRecodesMapper loginRecodesMapper;
    @Override
    public Vector<LoginRecodes> SelectAllLoginRecodes(LoginRecodes loginRecodes) {
        Vector<LoginRecodes>  vector = loginRecodesMapper.SelectAllLoginRecodes(loginRecodes);
        return vector;
    }
}
