package ru.nacu.mongodb;

import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
class Config extends AbstractReactiveMongoConfiguration {
    public com.mongodb.reactivestreams.client.MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://localhost");
    }

    protected String getDatabaseName() {
        return "immutable_test";
    }
}
