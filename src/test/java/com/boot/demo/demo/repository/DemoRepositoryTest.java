package com.boot.demo.demo.repository;

import com.boot.demo.demo.entity.DemoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
class DemoRepositoryTest {

    @Autowired
    private DemoRepository demoRepository;

    @Test
    void save() {
        demoRepository.save(new DemoEntity(1, "test")).block();
    }

    @Test
    void findFirstByName() {
//        demoRepository.save(new DemoEntity(1, "test")).block();
        List<DemoEntity> all = demoRepository.findAll().collectList().block();
        DemoEntity test = demoRepository.findFirstByName("test").block();
        assertTrue(test != null);
        assertTrue(test.getName().equals("test"));
    }
}