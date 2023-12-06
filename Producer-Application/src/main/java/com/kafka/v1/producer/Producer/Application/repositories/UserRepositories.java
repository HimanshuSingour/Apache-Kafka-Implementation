package com.kafka.v1.producer.Producer.Application.repositories;

import com.kafka.v1.producer.Producer.Application.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<UserEntity , String> {
}
