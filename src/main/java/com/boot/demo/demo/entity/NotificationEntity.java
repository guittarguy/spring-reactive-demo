package com.boot.demo.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("notification")
public class NotificationEntity {

    @Id
    @Field("id")
    private Long id;
    @Field("type")
    private String type;
    @Field("message")
    private String message;

    public NotificationEntity() {
    }

    public NotificationEntity(Long id, String type, String message) {
        this.id = id;
        this.type = type;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
