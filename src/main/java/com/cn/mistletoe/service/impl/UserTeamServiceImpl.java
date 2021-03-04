package com.cn.mistletoe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mistletoe.mapper.UserTeamMapper;
import com.cn.mistletoe.model.Team;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.model.UserCaptainRelation;
import com.cn.mistletoe.model.UserTeamRelation;
import com.cn.mistletoe.service.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeamRelation> implements UserTeamService {
    @Autowired
    private UserTeamMapper userTeamMapper;

    @Override
    public List<User> selectUserByTeamNumber() {
        return userTeamMapper.selectUserByTeamNumber();
    }

    @Override
    public Vector<User> selectUserByTeamId(int id) {
        return userTeamMapper.selectUserByTeamId(id);
    }

    @Override
    public Vector<UserTeamRelation> selectUtr(int id) {
        return userTeamMapper.selectUtr(id);
    }

    @Override
    public Integer insertUserTeam(List<UserTeamRelation> utr) {
        return userTeamMapper.insertUserTeam(utr);
    }

    @Override
    public Integer deleteUtrIdInUtr(List<UserTeamRelation> utr) {
        return userTeamMapper.deleteUtrIdInUtr(utr);
    }

    @Override
    public List<User> selectCaptainInUser() {
        return userTeamMapper.selectCaptainInUser();
    }

    @Override
    public List<Team> selectCaptainIsUsername(int id) {
        return userTeamMapper.selectCaptainIsUsername(id);
    }

    @Override
    public int updateNowCaptain(List<UserCaptainRelation> ucr) {
        return userTeamMapper.updateNowCaptain(ucr);
    }

    @Override
    public List<UserCaptainRelation> selectUcr(int id) {
        return userTeamMapper.selectUcr(id);
    }

}
