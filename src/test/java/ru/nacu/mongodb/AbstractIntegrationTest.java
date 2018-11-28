package ru.nacu.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "integration")
@ContextConfiguration(classes = Config.class)
public class AbstractIntegrationTest extends AbstractTestNGSpringContextTests {
    @Autowired
    protected ReactiveMongoOperations mongo;
}
