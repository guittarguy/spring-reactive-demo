package com.boot.demo.demo.service;

import com.boot.demo.demo.entity.DemoEntity;
import com.boot.demo.demo.pojo.Demo;
import com.boot.demo.demo.repository.DemoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class DemoServiceImplTest {

    private DemoService demoService;
    @MockBean
    private DemoRepository demoRepository;

    @BeforeEach
    public void init() {
        demoService = new DemoServiceImpl(demoRepository);
    }

    @Test
    void getDemo() {
        Mockito.when(demoRepository.findById(1)).thenReturn(Mono.just(new DemoEntity(1, "test")));
        Demo demo = demoService.getDemo(1);
        assertTrue(demo.getId().equals(1));
        assertTrue(demo.getName().equals("test"));
    }

    @Test
    void addDemo() {
        int size = demoService.getAll().size();
        demoService.addDemo(new Demo(2, "random"));
        assertTrue(!demoService.getAll().isEmpty());
        assertEquals(size + 1, demoService.getAll().size());
    }
}