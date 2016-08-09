package com.cgz.assignment.domain.services;

import com.cgz.assignment.domain.dto.tester.TesterDto;
import com.cgz.assignment.domain.dto.tester.TesterDtoFactory;
import com.cgz.assignment.domain.model.bug.events.BugCreatedEvent;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by czarek on 07.08.16.
 */
@Service
public class TesterService {

    private TesterRepository testerRepository;

    private DeviceRepository deviceRepository;

    private TesterDtoFactory dtoFactory;

    @Autowired
    public TesterService(TesterRepository testerRepository, DeviceRepository deviceRepository, TesterDtoFactory dtoFactory) {
        this.testerRepository = testerRepository;
        this.deviceRepository = deviceRepository;
        this.dtoFactory = dtoFactory;
    }

    private void increaseExperience(Long deviceId, Long testerId) {
        Tester tester = testerRepository.findOne(testerId);
        Device device = deviceRepository.findOne(deviceId);
        tester.increaseExperienceInDevice(device);
    }

    @EventListener
    public void handleBugCreatedEvent(BugCreatedEvent event) {
        increaseExperience(event.getTesterId(), event.getDeviceId());
    }

    public Iterable<TesterDto> findTesters(List<Long> deviceIds, List<String> countryCodes) {
        List<Tester> testers = findTestersInRepo(deviceIds, countryCodes);
        return testers.stream().map(dtoFactory::getDto).collect(Collectors.toList());
    }

    private List<Tester> findTestersInRepo(List<Long> deviceIds, List<String> countryCodes) {
        boolean devicesEmpty = CollectionUtils.isEmpty(deviceIds);
        boolean countriesEmpty = CollectionUtils.isEmpty(countryCodes);
        boolean devicesPresent = !devicesEmpty;
        boolean countriesPresent = !countriesEmpty;

        if (devicesPresent && countriesPresent) {
            return testerRepository.findByDeviceAndCountryOrderByExperience(deviceIds, countryCodes);
        }

        if (devicesEmpty && countriesPresent) {
            return testerRepository.findByCountryOrderByExperience(countryCodes);
        }

        if (devicesPresent && countriesEmpty) {
            return testerRepository.findByDeviceOrderByExperience(deviceIds);
        }

        //devicesEmpty && countriesEmpty
        return testerRepository.findAllOrderByExperience();
    }
}
