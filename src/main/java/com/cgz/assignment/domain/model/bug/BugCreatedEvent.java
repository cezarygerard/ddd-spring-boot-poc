package com.cgz.assignment.domain.model.bug;

import com.cgz.assignment.domain.events.DomainEvent;

/**
 * Created by czarek on 07.08.16.
 */
public class BugCreatedEvent extends DomainEvent {

    private long deviceId;

    private long testerId;

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
