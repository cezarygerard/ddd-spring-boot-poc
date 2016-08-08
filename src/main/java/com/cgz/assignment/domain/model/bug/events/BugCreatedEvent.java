package com.cgz.assignment.domain.model.bug.events;

import java.io.Serializable;

/**
 * Created by czarek on 07.08.16.
 */
public class BugCreatedEvent implements Serializable {

    private final long deviceId;

    private final long testerId;

    public BugCreatedEvent(long deviceId, long testerId) {
        this.deviceId = deviceId;
        this.testerId = testerId;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public long getTesterId() {
        return testerId;
    }
}
