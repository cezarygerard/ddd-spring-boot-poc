package com.cgz.assignment.domain.dto.bug;

/**
 * Created by czarek on 10.08.16.
 */
public class BugDto {

    private long deviceId;

    private long testerId;

    public BugDto(long device, long tester) {
        this.deviceId = device;
        this.testerId = tester;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public long getTesterId() {
        return testerId;
    }

    public void setTesterId(long testerId) {
        this.testerId = testerId;
    }
}
