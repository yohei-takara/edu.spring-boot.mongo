package com.mongo.edu.demo.service;

import com.mongo.edu.demo.configration.MongoDemoConfig;
import com.mongo.edu.demo.model.Demo;
import com.mongo.edu.demo.repository.DemoRepository;
import com.mongodb.MongoOptions;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;
    @Autowired
    private MongoDemoConfig mongoDemoConfig;


    public void saveMongo() throws Exception {
        MongoTemplate template = mongoDemoConfig.mongoTemplate();

        Query query = new Query(Criteria.where("_id").is("59cd213bd7bc93e5cc5b96d8"));
        Update update = new Update();
        update.set("name", "tokk");

        WriteResult result = template.updateFirst(query, update, "demo");

//        Demo demo = new Demo();
//        demo.setObjectId("59cd213bd7bc93e5cc5b96d8");
//        demo.setName("tokk");

//        template.save(demo);

//        getDemoRepository().save(demo);

        List<Demo> demos = getDemoRepository().findAll();
        System.out.println("aaaa");
    }

    private DemoRepository getDemoRepository() {
        return this.demoRepository;
    }

}
