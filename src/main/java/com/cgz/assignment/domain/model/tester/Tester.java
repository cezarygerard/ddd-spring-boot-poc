package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.exception.EntityNotFoundDomainException;
import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.device.Device;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by czarek on 07.08.16.
 */

//TODO make this class pure domain entity, move persistence concerns to infrastructure leyer

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

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin = new Date(0);

    @Version
    private int version;


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
        Experience experience = experiences.stream()
                .filter(exp -> exp.getDevice().equals(device))
                .findFirst()
                .orElseThrow(() ->
                        new EntityNotFoundDomainException("Cannot increase experience. Tester does not posses device: " + device.getId()));

        experience.increaseExperience();
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

    public Set<Experience> getExperiences() {
        return experiences;
    }
}
