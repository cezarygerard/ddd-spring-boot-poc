package com.cgz.assignment.domain.model.bug;

import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.tester.Tester;

import javax.persistence.*;

/**
 * Created by czarek on 07.08.16.
 */

@Entity
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Device device;

    @ManyToOne
    private Tester tester;

    Bug(Device device, Tester tester) {
        this.device = device;
        this.tester = tester;
    }

    private Bug() {
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public Tester getTester() {
        return tester;
    }
}
