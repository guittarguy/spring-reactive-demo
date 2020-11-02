package com.boot.demo.demo.repository;

import com.boot.demo.demo.entity.NotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface NotificationRepository extends ReactiveMongoRepository<NotificationEntity, Long> {
}
