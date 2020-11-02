package com.boot.demo.demo.controller;

import com.boot.demo.demo.pojo.Demo;
import com.boot.demo.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/demo/{id}")
    public ResponseEntity<Demo> getDemo(@PathVariable Integer id) {
        return ResponseEntity.ok(demoService.getDemo(id));
    }

    @GetMapping("/demo/all")
    public ResponseEntity<List<Demo>> getAll() {
        return ResponseEntity.ok(demoService.getAll());
    }
}
