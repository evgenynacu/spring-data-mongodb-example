package ru.nacu.mongodb;

import com.mongodb.reactivestreams.client.MongoClients;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Config.class).start();
    }
}

@Configuration
@ComponentScan(basePackageClasses = Main.class)
@EnableReactiveMongoRepositories(basePackageClasses = Main.class)
class Config extends AbstractReactiveMongoConfiguration {
    public com.mongodb.reactivestreams.client.MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://localhost");
    }

    protected String getDatabaseName() {
        return "immutable_test";
    }
}

@Component
class Init {
    @Autowired
    private DomainRepository domainRepository;

    @PostConstruct
    public void init() {
        domainRepository.save(new Domain(null, "test")).block();
    }
}

class Domain {
    @Id
    private final ObjectId id;
    private final String test;

    public ObjectId getId() {
        return id;
    }

    public String getTest() {
        return test;
    }

    public Domain(ObjectId id, String test) {
        this.id = id;
        this.test = test;
    }
}

interface DomainRepository extends ReactiveCrudRepository<Domain, ObjectId> {

}