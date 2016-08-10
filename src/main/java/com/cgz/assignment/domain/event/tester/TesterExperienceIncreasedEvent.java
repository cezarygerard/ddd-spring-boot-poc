package com.cgz.assignment.domain.event.tester;

import java.io.Serializable;

/**
 * Created by czarek on 10.08.16.
 */
public class TesterExperienceIncreasedEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long testerId;

    public TesterExperienceIncreasedEvent(long testerId) {
        this.testerId = testerId;
    }

    public long getTesterId() {
        return testerId;
    }
}
