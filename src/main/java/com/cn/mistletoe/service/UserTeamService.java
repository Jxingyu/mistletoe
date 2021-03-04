package com.cn.mistletoe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.mistletoe.model.*;

import java.util.List;
import java.util.Vector;

public interface UserTeamService extends IService<UserTeamRelation> {

    List<User> selectUserByTeamNumber();

    Vector<User> selectUserByTeamId(int id);

    Vector<UserTeamRelation> selectUtr(int id);

    Integer insertUserTeam(List<UserTeamRelation> utr);

    Integer deleteUtrIdInUtr(List<UserTeamRelation> utr);

    List<User> selectCaptainInUser();

    List<Team> selectCaptainIsUsername(int id);

    int updateNowCaptain(List<UserCaptainRelation> ucr);

    List<UserCaptainRelation> selectUcr(int id);
}
