package com.cn.mistletoe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.mistletoe.model.LoginRecodes;

import java.util.Vector;

public interface ILoginRecodesService extends IService<LoginRecodes> {
    Vector<LoginRecodes> SelectAllLoginRecodes(LoginRecodes loginRecodes);
}
