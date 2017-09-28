package com.mongo.edu.demo.configration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;

@Configuration
@EnableMongoRepositories("com.mongo.edu.demo.repository")
public class MongoDemoConfig extends AbstractMongoConfiguration {
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private String port;
    @Value("${spring.data.mongodb.authentication-database}")
    private String db;
    @Value("${spring.data.mongodb.username}")
    private String userName;
    @Value("${spring.data.mongodb.password}")
    private String password;

    @Override
    public MongoMappingContext mongoMappingContext()
            throws ClassNotFoundException {
        // TODO Auto-generated method stub
        return super.mongoMappingContext();
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        System.out.println("mongo host: " + host);
        System.out.println("mongo db: " + db);

        MongoCredential credential = MongoCredential.createCredential(userName, db, password.toCharArray());
        ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(port));

        return new MongoClient(serverAddress, new ArrayList<MongoCredential>() {{
            add(credential);
        }});
    }

    @Override
    protected String getDatabaseName() {
        // TODO Auto-generated method stub
        return db;
    }
}