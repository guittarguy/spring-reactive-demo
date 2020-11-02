package com.boot.demo.demo.repository;

import com.boot.demo.demo.entity.NotificationEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class NotificationRepositoryTest {

    @Autowired
    private NotificationRepository notificationRepository;

    @Test
    public void testSave() {
        notificationRepository.save(new NotificationEntity(1l, "web", "test notification")).block();
    }
}