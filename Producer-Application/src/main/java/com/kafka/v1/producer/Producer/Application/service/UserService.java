package com.kafka.v1.producer.Producer.Application.service;

import com.kafka.v1.producer.Producer.Application.model.UserEntity;

public interface UserService {

    UserEntity saveData(UserEntity userEntity);
    UserEntity getDataById(String userId);
}
