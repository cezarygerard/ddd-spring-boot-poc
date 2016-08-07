package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.device.Device;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by czarek on 07.08.16.
 */

@Entity
public class Tester {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private Country country;

    private LocalDateTime lastLogin;

    @OneToMany
    private ConcurrentMap<Device, Long> experiences = new ConcurrentHashMap<>();

    Tester() {
    }

    public Tester(Long id, String firstName, String lastName, Country country, LocalDateTime lastLogin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.lastLogin = lastLogin;
    }

    public long getExperienceInDevice(Device device) {
        return experiences.getOrDefault(device, 0L);
    }

    public void increaseExpInDevice(Device device) {
        Long currentExp = experiences.getOrDefault(device, 0L);
        experiences.put(device, currentExp + 1);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Country getCountry() {
        return country;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }
}
