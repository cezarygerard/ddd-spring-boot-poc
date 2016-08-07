package com.cgz.assignment.domain.model.bug;

import com.cgz.assignment.domain.model.Device.Device;
import com.cgz.assignment.domain.model.Tester.Tester;
import org.springframework.stereotype.Component;

/**
 * Created by czarek on 07.08.16.
 */
@Component
public class BugFactory {

    public Bug create(Device device, Tester tester) {
        return new Bug(device, tester);
    }
}
