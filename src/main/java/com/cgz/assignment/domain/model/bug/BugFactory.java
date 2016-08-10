package com.cgz.assignment.domain.model.bug;

import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.tester.Tester;
import org.springframework.stereotype.Component;

/**
 * Created by czarek on 07.08.16.
 */
@Component
public class BugFactory {

    public Bug createBug(Device device, Tester tester) {
        return new Bug(device, tester);
    }
}
