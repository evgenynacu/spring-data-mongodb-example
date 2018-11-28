package ru.nacu.mongodb;

import static org.testng.Assert.assertNotNull;

public class DomainAuditingTest extends AbstractIntegrationTest {
    public void datesFilled() {
        Domain saved = mongo.save(new Domain(null, "test", null, null, null)).block();
        assertNotNull(saved);
        assertNotNull(saved.getCreateDate());
        assertNotNull(saved.getUpdateDate());

        Domain found = mongo.findById(saved.getId(), Domain.class).block();
        assertNotNull(found);
        assertNotNull(found.getCreateDate());
        assertNotNull(found.getUpdateDate());
    }
}
