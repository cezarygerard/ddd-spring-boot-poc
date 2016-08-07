package com.cgz.assignment.domain.model.device;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by czarek on 07.08.16.
 */
@Entity
public class Device {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
}
