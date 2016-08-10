package com.cgz.assignment.domain.dto.bug;

/**
 * Created by czarek on 10.08.16.
 */
public class BugDto {

    private long id;

    private long deviceId;

    private long testerId;

    public BugDto(long id, long device, long tester) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
