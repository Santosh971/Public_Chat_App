package com.example.demo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDbConfig {
    @Bean
    public MongoClient mongoClient() {
        String uri = System.getenv("mongodb://localhost:27017/chatapp");
        return MongoClients.create(uri);
    }
}
