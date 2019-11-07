package com.zja.rabbitmq.consumers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.MessageProperties;

import java.io.UnsupportedEncodingException;

/**
 * @author ZhengJa
 * @description 消费者接收字节数据
 * @data 2019/11/4
 */
public class ByteConsumer implements MessageListener {

    /**
     * 消费者接收消息
     * @param message 推荐使用字节
     * @return void
     */
    @Override
    public void onMessage(Message message) {
        System.out.println("进入ByteConsumer 的监听器");

        MessageProperties m=message.getMessageProperties();

        byte[] body = message.getBody();
        try {
            System.out.println("ByteConsumer消费掉了:  "+new String(body,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
