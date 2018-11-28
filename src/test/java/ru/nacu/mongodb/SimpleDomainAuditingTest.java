package ru.nacu.mongodb;

import static org.testng.Assert.assertNotNull;

public class SimpleDomainAuditingTest extends AbstractIntegrationTest {
    public void datesFilled() {
        SimpleDomain saved = mongo.save(new SimpleDomain(null, "test", null, null)).block();
        assertNotNull(saved);
        assertNotNull(saved.getCreateDate());
        assertNotNull(saved.getUpdateDate());

        SimpleDomain found = mongo.findById(saved.getId(), SimpleDomain.class).block();
        assertNotNull(found);
        assertNotNull(found.getCreateDate());
        assertNotNull(found.getUpdateDate());
    }
}
