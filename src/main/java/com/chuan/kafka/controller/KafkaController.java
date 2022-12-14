package com.chuan.kafka.controller;

import com.chuan.kafka.kafuka.KafkaSender;
import com.chuan.kafka.thread.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yuchuankai
 * @Date 2022/9/23 15:09
 * @Description:
 */
@RestController
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaSender kafkaSender;


    @GetMapping("sendMessage/{msg}")
    public void sendMessage(@PathVariable("msg") String msg){
        //kafkaSender.send(msg);
        for (int i = 0; i < 10; i++) {
            new Thread(new SendMessage()).start();
        }

    }

}
