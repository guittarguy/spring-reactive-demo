package com.boot.demo.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.swing.text.AbstractDocument;
import javax.swing.text.Element;

@Document("demo")
public class DemoEntity {

    @Id
    @Field("id")
    private Integer id;
    @Field("name")
    @Indexed(unique = true)
    private String name;

    public DemoEntity() {}

    public DemoEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
