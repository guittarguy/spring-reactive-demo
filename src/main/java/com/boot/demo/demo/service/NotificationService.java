package com.boot.demo.demo.service;

import com.boot.demo.demo.entity.NotificationEntity;
import reactor.core.publisher.Flux;

public interface NotificationService {

    void createNewRandomNotification();

    Flux<NotificationEntity> getAll();
}
