package com.demo.test.config;

import com.fantasy.clash.framework.configuration.Configurator;
import com.fantasy.clash.framework.mongo.MongoConfiguration;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.PostConstruct;

@Configuration
public class MongoConfig {

    @Autowired
    private MongoConfiguration mongoConfiguration;

    @Autowired
    private Configurator config;

    private MongoClient mongoClient;
    private MongoTemplate mongoTemplatePrimary;

    @PostConstruct
    public void init() throws Exception {
        mongoClient = mongoConfiguration.createMongoClient("primary", true);
        mongoTemplatePrimary = mongoConfiguration.createMongoTemplate(mongoClient, "Employee");
    }

    @Bean
    public MongoTemplate getMongoTemplate() {
        return mongoTemplatePrimary;
    }
}
