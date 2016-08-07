package com.cgz.assignment.domain.model.bug;

import com.cgz.assignment.domain.model.Device.Device;
import com.cgz.assignment.domain.model.Tester.Tester;

/**
 * Created by czarek on 07.08.16.
 */

public class Bug {

    private Long id;

    private Device device;

    private Tester tester;

    Bug(Device device, Tester tester) {
        this.device = device;
        this.tester = tester;

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
