package com.cn.mistletoe.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mistletoe.common.CommonResult;
import com.cn.mistletoe.mapper.TeamMapper;
import com.cn.mistletoe.mapper.TeamRecordMapper;
import com.cn.mistletoe.mapper.UserTeamMapper;
import com.cn.mistletoe.model.Team;
import com.cn.mistletoe.model.User;
import com.cn.mistletoe.model.UserCaptainRelation;
import com.cn.mistletoe.model.UserTeamRelation;
import com.cn.mistletoe.service.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;

import static com.cn.mistletoe.common.DateUtils.getCurrentDay;

@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeamRelation> implements UserTeamService {
    @Autowired
    private UserTeamMapper userTeamMapper;

    @Autowired
    private TeamRecordMapper teamRecordMapper;

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
    public CommonResult insertUserTeam(List<UserTeamRelation> utr) {
        // 该队员已在队判断
      /*  utr.stream().forEach(v -> {
            Integer userId = v.getUserId();
            if (userId == userTeamMapper.getUsername(userId)) ;
            return;
        });
*/
        // 查询队员之前数据(调队记录)
        utr.stream().forEach(u -> {
            int uUserId = u.getUserId();
            List<UserTeamRelation> list = userTeamMapper.findPastTeamRecord(uUserId);
            // 且先 删除该队员之前所在的队
            userTeamMapper.deleteOldUTR(uUserId);
            // 分队的numbers 用于区别来自的团队名称
            Consumer<UserTeamRelation> userTeamRelationConsumer = x -> {
                Integer xUserId = x.getUserId();
                Integer xNumbers = x.getNumbers();// 得到之前的团队ID
                // 插入队员掉队之前数据(调队记录)
                System.out.println(xUserId + "::" + xNumbers);
                Integer sUserId = 0;
                sUserId = xUserId;
                teamRecordMapper.insertPastTeamRecord(sUserId, xUserId, xNumbers);
            };
            list.stream().forEach(userTeamRelationConsumer);
        });

        // 将队员插入新团队(utr)
        userTeamMapper.insertUserTeam(utr);

        // 更新! 将队员插入新团队(utr)队员调队后当前数据(调队记录)
        utr.stream().forEach(i -> {
            Integer iNumbers = i.getNumbers();// 当前团队编号
            Integer iUserId = i.getUserId();
            teamRecordMapper.updateCurrentTeamRecord(iNumbers, iUserId);

        });

        return CommonResult.success(200, "200");
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
    public List<UserCaptainRelation> selectUcr(int id) {
        return userTeamMapper.selectUcr(id);
    }

}
