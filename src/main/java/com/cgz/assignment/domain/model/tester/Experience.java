package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.model.device.Device;

import javax.persistence.*;

/**
 * Created by czarek on 07.08.16.
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"device_id", "tester_id"})
})
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id")
    private Device device;

    @Column(nullable = false)
    private long experiencePoints = 0L;

    @Version
    private int version;

    private Experience() {
    }

    public Experience(Device device, long experiencePoints) {
        this.device = device;
        this.experiencePoints = experiencePoints;
    }

    public Device getDevice() {
        return device;
    }

    public long getExperiencePoints() {
        return experiencePoints;
    }

    void increaseExperience() {
        experiencePoints++;
    }

}
