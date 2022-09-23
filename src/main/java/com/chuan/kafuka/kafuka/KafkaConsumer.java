package com.chuan.kafuka.kafuka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author yuchuankai
 * @Date 2022/9/23 15:05
 * @Description:
 */
@Component
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = {"hello2"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional.ofNullable(record.value())
                .ifPresent(message -> {
                    log.info("【+++++++++++++++++ record = {} 】", record);
                    log.info("【+++++++++++++++++ message = {}】", message);
                });
    }
}
