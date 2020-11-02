package com.boot.demo.demo.service;

import com.boot.demo.demo.entity.NotificationEntity;
import com.boot.demo.demo.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createNewRandomNotification() {
        NotificationEntity first = notificationRepository.findAll().sort((o1, o2) -> o1.getId().compareTo(o2.getId()))
                .blockFirst();
        long nextId = first != null ? first.getId() + 1 : 1;
        NotificationEntity newNotif = new NotificationEntity(nextId, "web", "Test notification " + nextId);
        notificationRepository.save(newNotif).block();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Flux<NotificationEntity> getAll() {
        return notificationRepository.findAll().sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
    }
}
