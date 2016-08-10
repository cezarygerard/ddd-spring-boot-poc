package com.cgz.assignment.domain.event.bug;

import java.io.Serializable;

/**
 * Created by czarek on 07.08.16.
 */
public class BugCreatedEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long deviceId;

    private final Long testerId;

    public BugCreatedEvent(Long deviceId, Long testerId) {
        this.deviceId = deviceId;
        this.testerId = testerId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public Long getTesterId() {
        return testerId;
    }
}
