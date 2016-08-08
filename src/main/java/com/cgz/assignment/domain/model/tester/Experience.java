package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.model.device.Device;

import javax.persistence.*;

/**
 * Created by czarek on 07.08.16.
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"tester_id", "device_id"})
})
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @Column(nullable = false)
    private Long experiencePoints = 0L;

    private Experience() {
    }

    public Experience(Device device, Long experiencePoints) {
        this.device = device;
        this.experiencePoints = experiencePoints;
    }

    Device getDevice() {
        return device;
    }

    Long getExperiencePoints() {
        return experiencePoints;
    }

    void increaseExperience() {
        experiencePoints++;
    }



}
