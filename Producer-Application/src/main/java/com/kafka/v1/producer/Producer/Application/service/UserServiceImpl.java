package com.kafka.v1.producer.Producer.Application.service;

import com.kafka.v1.producer.Producer.Application.model.UserEntity;
import com.kafka.v1.producer.Producer.Application.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public UserEntity saveData(UserEntity userEntity) {
        return userRepositories.save(userEntity);
    }

    @Override
    public UserEntity getDataById(String userId) {
        return userRepositories.findById(userId).orElseThrow();
    }
}
