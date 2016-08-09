package com.cgz.assignment.domain.services;

import com.cgz.assignment.domain.model.bug.Bug;
import com.cgz.assignment.domain.model.bug.BugFactory;
import com.cgz.assignment.domain.model.bug.BugRepository;
import com.cgz.assignment.domain.model.bug.events.BugEventPublisher;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by czarek on 07.08.16.
 */
@Service
public class BugService {

    private final BugEventPublisher bugEventPublisher;
    private final DeviceRepository deviceRepository;
    private final BugRepository bugRepository;
    private final TesterRepository testerRepository;
    private final BugFactory bugFactory;

    @Autowired
    public BugService(DeviceRepository deviceRepository, BugRepository bugRepository, TesterRepository testerRepository, BugFactory bugFactory, BugEventPublisher eventPublisher) {
        this.deviceRepository = deviceRepository;
        this.bugRepository = bugRepository;
        this.testerRepository = testerRepository;
        this.bugFactory = bugFactory;
        this.bugEventPublisher = eventPublisher;
    }

    public void submitBug(Long deviceId, Long testerId) {
        //TODO VALIDATE INPUT
        Tester tester = testerRepository.findOne(testerId);
        Device device = deviceRepository.findOne(deviceId);
        //TODO VALIDATE
        Bug bug = bugFactory.create(device, tester);
        bugRepository.save(bug);
        bugEventPublisher.publishBugCreatedEvent(bug);
    }

}
