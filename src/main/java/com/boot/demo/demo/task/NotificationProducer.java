package com.boot.demo.demo.task;

import com.boot.demo.demo.entity.NotificationEntity;
import com.boot.demo.demo.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationProducer {

    @Autowired
    private NotificationRepository notificationRepository;

    @Scheduled(fixedDelay = 10000l)
    public void produceNotification() {
        NotificationEntity first = notificationRepository.findAll().sort((o1, o2) -> o1.getId().compareTo(o2.getId()))
            .blockFirst();
        long nextId = first != null ? first.getId() + 1 : 1;
        NotificationEntity newNotif = new NotificationEntity(nextId, "web", "Test notification " + nextId);
        notificationRepository.save(newNotif).block();
    }
}
