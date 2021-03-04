package com.cn.mistletoe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.mistletoe.model.Team;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.model.UserCaptainRelation;
import com.cn.mistletoe.model.UserTeamRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Vector;

public interface UserTeamMapper extends BaseMapper<UserTeamRelation> {
    List<User> selectUserByTeamNumber();

    Vector<User> selectUserByTeamId(int id);

    Vector<UserTeamRelation> selectUtr(int id);

    Integer insertUserTeam(@Param("utr") List<UserTeamRelation> utr);

    Integer deleteUtrIdInUtr(@Param("utr") List<UserTeamRelation> utr);

    List<User> selectCaptainInUser();

    List<Team> selectCaptainIsUsername(int id);

    List<UserCaptainRelation> selectUcr(int id);

   int  updateNowCaptain(@Param("ucr") List<UserCaptainRelation> ucr);

}
