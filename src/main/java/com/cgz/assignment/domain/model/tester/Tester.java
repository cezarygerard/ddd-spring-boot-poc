package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.device.Device;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by czarek on 07.08.16.
 */

@Entity
@Table(indexes = {@Index(name = "tester_cuntry", columnList = "country")})
public class Tester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Country country;

    private Date lastLogin;

    @OneToMany(/*mappedBy = "tester", */fetch = FetchType.EAGER)
    @JoinColumn(name = "tester_id")
    private List<Experience> experiences = new ArrayList<>();

    Tester() {
    }

    public Tester(String firstName, String lastName, Country country, Date lastLogin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.lastLogin = lastLogin;
    }

    public long getExperienceInDevice(Device device) {
        Optional<Experience> exp = experiences.stream().filter(experience -> experience.getDevice().equals(device)).findFirst();
        if (exp.isPresent()) {
            return exp.get().getExperiencePoints();
        }
        return 0;
    }

    public void increaseExpInDevice(Device device) {
        Optional<Experience> exp = experiences.stream().filter(experience -> experience.getDevice().equals(device)).findFirst();
        if (exp.isPresent()) {
            exp.get().increase();
        }
        experiences.add(new Experience(device, 1L));
    }

}
