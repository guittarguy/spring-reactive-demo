package com.boot.demo.demo.service;

import com.boot.demo.demo.entity.DemoEntity;
import com.boot.demo.demo.pojo.Demo;
import com.boot.demo.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public DemoServiceImpl(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
        this.demos = new ArrayList<>();
    }

    private List<Demo> demos;

    public DemoServiceImpl() {
        demos = new ArrayList<>();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Demo getDemo(Integer id) {
        Demo demo = null;
        Mono<DemoEntity> optionalDemoEntity = demoRepository.findById(id);
        if (optionalDemoEntity.hasElement().block()) {
            DemoEntity demoEntity = optionalDemoEntity.block();
            demo = new Demo();
            demo.setId(demoEntity.getId());
            demo.setName(demoEntity.getName());
            return demo;
        }
//        if (optionalDemoEntity.isPresent()) {
//            DemoEntity demoEntity = optionalDemoEntity.get();
//            demo = new Demo();
//            demo.setId(demoEntity.getId());
//            demo.setName(demoEntity.getName());
//            return demo;
//        }
        return demo;
    }

    @Override
    public List<Demo> getAll() {
        return demos;
    }

    @Override
    public void addDemo(Demo demo) {
        demos.add(demo);
    }
}
