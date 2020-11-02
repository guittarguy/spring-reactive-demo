package com.boot.demo.demo.pojo;

import java.io.Serializable;

public class Demo implements Serializable {
    private Integer id;
    private String name;

    public Demo() {
    }

    public Demo(Integer id, String name) {
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