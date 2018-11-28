package ru.nacu.mongodb;

import static org.testng.Assert.assertEquals;

public class IdErrorTest extends AbstractIntegrationTest {

    public void idNotSaved() {
        Domain saved = mongo.save(new Domain(null, "test", null, null, null)).block();
        assertEquals(saved.getTest(), "test");

        Domain found = mongo.findById(saved.getId(), Domain.class).block();
        assertEquals(found.getTest(), "test");
    }
}
