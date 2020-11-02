package com.boot.demo.demo.service;

import com.boot.demo.demo.pojo.Demo;

import java.util.List;

public interface DemoService {

    Demo getDemo(Integer id);

    List<Demo> getAll();

    void addDemo(Demo demo);
}
