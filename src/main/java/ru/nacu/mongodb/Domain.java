package ru.nacu.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.util.Date;

class Domain {
    @Id
    private final ObjectId id;
    private final String test;

    @Version
    private final Long version;
    @CreatedDate
    private final Date createDate;
    @LastModifiedDate
    private final Date updateDate;

    public Domain(ObjectId id, String test, Long version, Date createDate, Date updateDate) {
        this.id = id;
        this.test = test;
        this.version = version;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public ObjectId getId() {
        return id;
    }

    public String getTest() {
        return test;
    }

    public Long getVersion() {
        return version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Domain withId(ObjectId id) {
        return new Domain(id, test, version, createDate, updateDate);
    }

    public Domain withVersion(Long version) {
        return new Domain(id, test, version, createDate, updateDate);
    }

    public Domain withCreateDate(Date createDate) {
        return new Domain(id, test, version, createDate, updateDate);
    }

    public Domain withUpdateDate(Date updateDate) {
        return new Domain(id, test, version, createDate, updateDate);
    }
}
