package com.chuan.kafka.thread;

import com.chuan.kafka.config.BeanContext;
import com.chuan.kafka.kafuka.KafkaSender;


/**
 * @Author yuchuankai
 * @Date 2022/9/23 16:12
 * @Description:
 */
public class SendMessage implements Runnable {

    private KafkaSender kafkaSender;

    public SendMessage(){
        kafkaSender = BeanContext.getApplicationContext().getBean(KafkaSender.class);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            //System.out.println(Thread.currentThread().getName()+"-- Send:"+i);
            kafkaSender.send(Thread.currentThread().getName()+"-- Send:"+i);
        }
    }
}
