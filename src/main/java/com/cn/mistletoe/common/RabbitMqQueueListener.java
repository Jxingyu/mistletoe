/*
package com.cn.mistletoe.common;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

*/
/**
 * RabbitMq队列监听
 * 消费队列里的消息用
 * 写在了security项目代码里
 *//*

@Component
@RabbitListener(queues = {"LoginLogQueue"})
public class RabbitMqQueueListener {
    @Autowired
    private Queue LoginLogQueue;
    @RabbitHandler
    public void  process(String msg){
        System.out.println(msg);
    }
}
*/
