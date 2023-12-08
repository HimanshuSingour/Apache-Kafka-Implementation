package com.kafka.v1.consumer.Consumer.Application.events;

import com.kafka.v1.consumer.Consumer.Application.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class ListnerK {

    @KafkaListener(topics = "BNFS-KAFKA", groupId = "group-id")
    public String consumeMessage(UserEntity userEntity) {
        System.out.println(userEntity);
        log.info(userEntity.getUserName());

        return "Reciving Data from topic";
    }
}
