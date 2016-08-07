package com.cgz.assignment.domain.model.Tester;

import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.Device.Device;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by czarek on 07.08.16.
 */
public class Tester {

    private String id;

    private String firstName;

    private String lastName;

    private Country country;

    private LocalDateTime lastLogin;

    private ConcurrentMap<Device, Long> experiences = new ConcurrentHashMap<>();

    public long getExperienceInDevice(Device device) {
        return experiences.getOrDefault(device, 0L);
    }

    public void increaseExpInDevice(Device device) {
        Long currentExp = experiences.getOrDefault(device, 0L);
        experiences.put(device, currentExp + 1);
    }
}
