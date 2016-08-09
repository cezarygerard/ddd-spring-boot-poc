package com.cgz.assignment.domain.dto.tester;

import java.io.Serializable;

/**
 * Created by czarek on 08.08.16.
 */
public class DeviceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long deviceId;

    private String deviceDescription;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }


}
