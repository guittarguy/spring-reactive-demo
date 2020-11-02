package com.boot.demo.demo.repository;

import com.boot.demo.demo.entity.DemoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface DemoRepository extends ReactiveMongoRepository<DemoEntity, Integer> {

    @Query("{name: '?0'}")
    Mono<DemoEntity> findFirstByName(String name);
}
