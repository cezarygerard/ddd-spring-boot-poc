package com.cgz.assignment.domain.services;

import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.bug.events.BugCreatedEvent;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by czarek on 07.08.16.
 */
@Service
public class TesterService {

    private TesterRepository testerRepository;

    private DeviceRepository deviceRepository;

    @Autowired
    public TesterService(TesterRepository testerRepository, DeviceRepository deviceRepository) {
        this.testerRepository = testerRepository;
        this.deviceRepository = deviceRepository;
    }

    private void increaseExperience(Long deviceId, Long testerId) {
        Tester tester = testerRepository.findOne(testerId);
        Device device = deviceRepository.findOne(deviceId);
        tester.increaseExpInDevice(device);
    }

    @EventListener
    public void handleBugCreatedEvent(BugCreatedEvent event) {
        increaseExperience(event.getTesterId(), event.getDeviceId());
    }

    public Iterable<Tester> findTesters(long deviceId, String country) {
        Device device = deviceRepository.findOne(deviceId);
        return testerRepository.findByCountryAndExperiencesDeviceOrderByExperiencesExperiencePointsDesc(Country.valueOf(country), device);
    }
}
