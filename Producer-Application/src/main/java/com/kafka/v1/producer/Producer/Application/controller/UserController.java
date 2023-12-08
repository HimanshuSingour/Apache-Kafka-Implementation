package com.kafka.v1.producer.Producer.Application.controller;

import com.kafka.v1.producer.Producer.Application.model.UserEntity;
import com.kafka.v1.producer.Producer.Application.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/producer")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private KafkaTemplate<String, UserEntity> kafkaTemplate;

    public String TOPIC = "BNFS-KAFKA";


    @PostMapping("/save")
    ResponseEntity<UserEntity> save(@RequestBody UserEntity userEntity) {
        UserEntity response = userService.saveData(userEntity);
        kafkaTemplate.send(TOPIC, response);
        log.info("Data Has Been Send To The Kafka Topic Name : {} of {} , {} , {}" , TOPIC , userEntity.getUserId() , userEntity.getUserName() , userEntity.getUserEmail());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{userId}")
    ResponseEntity<UserEntity> save(@PathVariable String userId) {
        UserEntity reponse = userService.getDataById(userId);
        return new ResponseEntity<>(reponse, HttpStatus.ACCEPTED);
    }
}
