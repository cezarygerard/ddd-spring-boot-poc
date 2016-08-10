package com.cgz.assignment.domain.dto.tester;

import java.io.Serializable;

/**
 * Created by czarek on 08.08.16.
 */
public class DeviceExperienceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long deviceId;

    private String deviceDescription;

    private long experiencePoints;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public long getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(long experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
}
