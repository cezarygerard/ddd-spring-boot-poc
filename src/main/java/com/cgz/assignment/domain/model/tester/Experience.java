package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.model.device.Device;

import javax.persistence.Entity;

/**
 * Created by czarek on 07.08.16.
 */
@Entity
public class Experience {

    private Long id;

    private Tester tester;

    private Device device;

    private Long experiencePoints;
}
