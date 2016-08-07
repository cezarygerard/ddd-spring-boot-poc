package com.cgz.assignment.domain.services;

import com.cgz.assignment.domain.model.bug.Bug;
import com.cgz.assignment.domain.model.bug.BugFactory;
import com.cgz.assignment.domain.model.bug.BugRepository;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Created by czarek on 07.08.16.
 */
@Service
public class BugService {

    private final ApplicationEventPublisher eventPublisher;
    private DeviceRepository deviceRepository;
    private BugRepository bugRepository;
    private TesterRepository testerRepository;
    private BugFactory bugFactory;

    @Autowired
    public BugService(DeviceRepository deviceRepository, BugRepository bugRepository, TesterRepository testerRepository, BugFactory bugFactory, ApplicationEventPublisher eventPublisher) {
        this.deviceRepository = deviceRepository;
        this.bugRepository = bugRepository;
        this.testerRepository = testerRepository;
        this.bugFactory = bugFactory;
        this.eventPublisher = eventPublisher;
    }


    public void submitBug(Long deviceId, Long testerId) {
        Tester tester = testerRepository.findOne(testerId);
        Device device = deviceRepository.findOne(deviceId);
        Bug bug = bugFactory.create(device, tester);
        bugRepository.save(bug);
    }

}
