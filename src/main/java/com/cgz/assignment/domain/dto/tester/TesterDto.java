package com.cgz.assignment.domain.dto.tester;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by czarek on 08.08.16.
 */
public class TesterDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long testerId;

    private String firstName;

    private String lastName;

    private String country;

    private Set<DeviceDto> devices;

    public Long getTesterId() {
        return testerId;
    }

    public void setTesterId(Long testerId) {
        this.testerId = testerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<DeviceDto> getDevices() {
        return devices;
    }

    public void setDevices(Set<DeviceDto> devices) {
        this.devices = devices;
    }

}
