package com.cgz.assignment.domain.model.bug.events;

import com.cgz.assignment.domain.model.bug.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by czarek on 08.08.16.
 */
@Component
public class BugEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public BugEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.applicationEventPublisher = eventPublisher;
    }

    public void publishBugCreatedEvemt(Bug bug) {
        Long deviceId = bug.getDevice().getId();
        Long testerId = bug.getTester().getId();
        applicationEventPublisher.publishEvent(new BugCreatedEvent(deviceId, testerId));
    }
}
