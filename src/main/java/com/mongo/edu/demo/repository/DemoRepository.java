package com.mongo.edu.demo.repository;

import com.mongo.edu.demo.model.Demo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemoRepository extends MongoRepository<Demo, String> {
    public Demo findByName(String name);
}
