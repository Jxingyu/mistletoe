package com.cn.mistletoe.common;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.util.*;

/**
 * cron表达式校验工具类
 * @auther: HuangQing
 * @date: 2018/12/22 13:44
 */
public class ScheduledCronCheckUtil {

    /**
     * 根据cron表达式在某个时间点之后的counter次执行时间列表
     * @param cronExpression cron表达式
     * @param startDate 任务开始的时间
     * @param counter 执行次数
     * @return
     */
    public static List<Date> getRuntimeList(String cronExpression, Date startDate, int counter){
        List<Date> timeList = new ArrayList(counter);
        Calendar calendar = new GregorianCalendar();
        TimeZone timeZone = calendar.getTimeZone();
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cronExpression, timeZone);
        Date next = cronSequenceGenerator.next(startDate);
        for (int i = 0; i < counter; i++) {
            timeList.add(next);
            next = cronSequenceGenerator.next(next);
        }
        return timeList;
    }
}
