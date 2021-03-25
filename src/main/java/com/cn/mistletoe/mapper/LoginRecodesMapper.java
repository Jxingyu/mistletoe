package com.cn.mistletoe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.mistletoe.model.LoginRecodes;

import java.util.Vector;

/**
 * <p>
 * 后台登录日志 Mapper 接口
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
public interface LoginRecodesMapper extends BaseMapper<LoginRecodes> {
    Vector<LoginRecodes> SelectAllLoginRecodes(LoginRecodes loginRecodes);
}
