package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.device.Device;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by czarek on 07.08.16.
 */

@Entity
@Table(indexes = {@Index(name = "tester_country", columnList = "country")})
public class Tester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Country country;

    private Date lastLogin = new Date(0);

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "tester_id")
    private Set<Experience> experiences = new HashSet<>();

    Tester() {
    }

    public long getExperienceInDevice(Device device) {
        Optional<Experience> exp = experiences.stream().filter(experience -> experience.getDevice().equals(device)).findFirst();
        if (exp.isPresent()) {
            return exp.get().getExperiencePoints();
        }
        return 0;
    }

    public void increaseExperienceInDevice(Device device) {
        Optional<Experience> exp = experiences.stream().filter(experience -> experience.getDevice().equals(device)).findFirst();
        if (exp.isPresent()) {
            exp.get().increaseExperience();
        }
        experiences.add(new Experience(device, 1L));
    }

    public Set<Device> getAllDevices() {
        return experiences.stream().map(Experience::getDevice).collect(Collectors.toSet());
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

    public Date getLastLogin() {
        return new Date(lastLogin.getTime());
    }
}
