package com.cn.mistletoe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mistletoe.mapper.DailyMapper;
import com.cn.mistletoe.model.Daily;
import com.cn.mistletoe.service.IDailyService;
import com.cn.mistletoe.service.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements IDailyService {
    @Autowired
    DailyMapper dailyMapper;

    @Autowired
    RedisService redisService;

    @Override
    public Integer selectDailyId(String username) {
        Integer id = dailyMapper.selectDailyId(username);
        return id;
    }

    @Override
    public Vector<Daily> selectDailyAll(Integer userId) {
        Vector<Daily> vector = dailyMapper.selectDailyAll(userId);
        return vector;
    }

    @Override
    public Vector<Daily> selectDailyEditMes(Integer userId) {
        // 查询团队区分用numbers
        Integer numbers = dailyMapper.selectNumbersByUserId(userId);
        Vector<Daily> dailies = dailyMapper.selectDailyEditMes(numbers);
        return dailies;
    }

    @Override
    public int insertDaily(Daily daily) {
        int i = dailyMapper.insertDaily(daily);
        return i;
    }

    @Override
    public int saveDailyInRedis(Daily daily) {
        /*List<Daily> list = Collections.singletonList(daily);
        list.stream().forEach(x -> {
            redisService.set("RBAC_SYSTEM:DAILY:DRAFT_TEAM" +"_"+ x.getUserId(), x);

        });*/
        int i = dailyMapper.saveDailyInRedis(daily);
        return i;
    }

    @Override
    public Vector<Daily> selectDailyById(int id) {
        return dailyMapper.selectDailyById(id);
    }

    @Override
    public int updateDraftDaily(Daily daily) {
        return dailyMapper.updateDraftDaily(daily);
    }

    @Override
    public int updateDailyStatus(int id, String status) {
        return dailyMapper.updateDailyStatus(id, status);
    }

    @Override
    public String ExportWord(Daily daily, HttpServletResponse response) {
        Map<String, String> dataMap = new HashMap();

        //姓名
        dataMap.put("username", daily.getUsername());
        //日期
        dataMap.put("submitDate", daily.getSubmitDate());
        // 教练
        dataMap.put("coach", daily.getCoach());
        // 助理
        dataMap.put("assistant", daily.getAssistant());
        //学习内容
        dataMap.put("dailyTitle", daily.getDailyTitle());
        //学习收获
        dataMap.put("dailyContent", daily.getDailyContent());
        //不足
        dataMap.put("shortage", daily.getShortage());

        return "0";
/*        Map<String, String> dataMap = new HashMap();
        try {
            //姓名
            dataMap.put("username", daily.getUsername());
            //日期
            dataMap.put("submitDate", daily.getSubmitDate());
            // 教练
            dataMap.put("coach", daily.getCoach());
            // 助理
            dataMap.put("assistant", daily.getAssistant());
            //学习内容
            dataMap.put("dailyTitle", daily.getDailyTitle());
            //学习收获
            dataMap.put("dailyContent", daily.getDailyContent());
            //不足
            dataMap.put("shortage", daily.getShortage());
            //Configuration 用于读取ftl文件
            Configuration configuration = new Configuration(new Version("2.3.0"));
            configuration.setDefaultEncoding("utf-8");

            *//**
         * 指定ftl文件所在目录的路径，而不是ftl文件的路径
         *//*
            //我的路径是F：/idea_demo/日报.ftl
            configuration.setDirectoryForTemplateLoading(new File("D:\\JavaProject\\CreateWord"));

            //输出文档路径及名称
            File outFile = new File("D:\\JavaProject\\CreateWord\\新日报.doc");

            //以utf-8的编码读取ftl文件
            Template template = configuration.getTemplate("模板.ftl", "utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "0";*/


    }
/*        //模板路径
        String inputUrl = "D:\\JavaProject\\CreateWord\\模板.ftl";
        //生成文件名字
        String wordName = daily.getUsername() + ".docx";
        //生成新word路径
        String outFile = new String(new File("D:\\JavaProject\\CreateWord") + wordName);
//        String outputUrl = CommonPath.WORD_DAILY.getValue() + wordName;
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("username", daily.getUsername());
        tempMap.put("submitDate", daily.getSubmitDate());
        tempMap.put("coach", daily.getCoach());
        tempMap.put("assistant", daily.getAssistant());
        tempMap.put("dailyTitle", daily.getDailyTitle());
        tempMap.put("dailyContent", daily.getDailyContent());
        tempMap.put("harvest", daily.getHarvest());
        tempMap.put("shortage", daily.getShortage());
        List<String[]> sList = new ArrayList<String[]>();
        boolean b = WordUtil.changWord(inputUrl, outFile, tempMap, sList);
        if (b) {
            return wordName;
        }
        return null;*/

}
