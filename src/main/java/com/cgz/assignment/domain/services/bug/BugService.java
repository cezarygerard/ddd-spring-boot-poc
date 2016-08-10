package com.cgz.assignment.domain.services.bug;

import com.cgz.assignment.domain.dto.bug.BugDto;
import com.cgz.assignment.domain.exception.EntityNotFoundDomainException;
import com.cgz.assignment.domain.model.bug.Bug;
import com.cgz.assignment.domain.model.bug.BugFactory;
import com.cgz.assignment.domain.model.bug.BugRepository;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by czarek on 07.08.16.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
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

    public BugDto submitBug(long deviceId, long testerId) {
        Tester tester = Optional.ofNullable(testerRepository.findOne(testerId))
                .orElseThrow(() ->
                        new EntityNotFoundDomainException("BugService submitBug didn't find tester: " + testerId)
                );

        Device device = Optional.ofNullable(deviceRepository.findOne(deviceId))
                .orElseThrow(() ->
                        new EntityNotFoundDomainException("BugService submitBug didn't find device: " + deviceId)
                );

        Bug bug = bugFactory.createBug(device, tester);
        bugRepository.save(bug);
        bugEventPublisher.publishBugCreatedEvent(bug);
        return new BugDto(bug.getId(), bug.getDevice().getId(), bug.getTester().getId());
    }

}
