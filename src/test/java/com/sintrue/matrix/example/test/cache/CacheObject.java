package com.sintrue.matrix.example.test.cache;

import java.io.Serializable;

/**
 * @author Liangchen.Wang 2022-07-27 20:54
 */
public class CacheObject implements Serializable {
    private Long objectId;
    private String objectName;

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
