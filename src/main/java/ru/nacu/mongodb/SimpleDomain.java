package ru.nacu.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "no_version")
class SimpleDomain {
    @Id
    private final ObjectId id;
    private final String test;

    @CreatedDate
    private final Date createDate;
    @LastModifiedDate
    private final Date updateDate;

    public SimpleDomain(ObjectId id, String test, Date createDate, Date updateDate) {
        this.id = id;
        this.test = test;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public ObjectId getId() {
        return id;
    }

    public String getTest() {
        return test;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public SimpleDomain withId(ObjectId id) {
        return new SimpleDomain(id, test, createDate, updateDate);
    }

    public SimpleDomain withCreateDate(Date createDate) {
        return new SimpleDomain(id, test, createDate, updateDate);
    }

    public SimpleDomain withUpdateDate(Date updateDate) {
        return new SimpleDomain(id, test, createDate, updateDate);
    }
}
