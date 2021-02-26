package com.cn.mistletoe.common;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Java计时器
 */
public class TimerTest {
    static String str="HH:mm:ss";
    static SimpleDateFormat dateFormat = new SimpleDateFormat(str);

    public static void main(String[] args) {
        Timer timer = new Timer();
        String now1 = dateFormat.format(System.currentTimeMillis());
        System.out.println(now1);
        //延迟3秒后执行任务
        timer.schedule(new MyTask(),0,3000);//单位是毫秒 period参数为 安排指定任务在指定延迟后开始重复执行 该任务
    }
}
class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("该起床了");
        String now2 = TimerTest.dateFormat.format(System.currentTimeMillis());
        System.out.println(now2);
    }
}
