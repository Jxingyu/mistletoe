package com.cn.mistletoe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.mistletoe.model.UserCaptainRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCaptainMapper extends BaseMapper<UserCaptainRelation> {
    int updateNowCaptain(@Param("ucr") List<UserCaptainRelation> ucr);
}
