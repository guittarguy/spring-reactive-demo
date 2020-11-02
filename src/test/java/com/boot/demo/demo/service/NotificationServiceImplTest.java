package com.boot.demo.demo.service;

import com.boot.demo.demo.entity.NotificationEntity;
import com.boot.demo.demo.repository.NotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;

@ExtendWith(SpringExtension.class)
class NotificationServiceImplTest {

    @MockBean
    private NotificationRepository notificationRepository;

    private NotificationService notificationService;

    @BeforeEach
    public void init() {
        notificationService = new NotificationServiceImpl(notificationRepository);
    }

    @Test
    void createNewRandomNotification() {
        Mockito.when(notificationRepository.findAll())
                .thenReturn(Flux.just(new NotificationEntity(1l, "web", "test")));
        Mockito.when(notificationRepository.save(any()))
                .thenReturn(Mono.just(new NotificationEntity(1l, "web", "test")));
        notificationService.createNewRandomNotification();
    }

    @Test
    void getAll() {
        Mockito.when(notificationRepository.findAll())
                .thenReturn(Flux.just(new NotificationEntity(1l, "web", "test")));
        Flux<NotificationEntity> notifications = notificationService.getAll();
        assertTrue(!notifications.collectList().block().isEmpty());
    }
}