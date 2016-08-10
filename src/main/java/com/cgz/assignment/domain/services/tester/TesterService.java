package com.cgz.assignment.domain.services.tester;

import com.cgz.assignment.domain.dto.tester.TesterDto;
import com.cgz.assignment.domain.dto.tester.TesterDtoFactory;
import com.cgz.assignment.domain.event.bug.BugCreatedEvent;
import com.cgz.assignment.domain.event.tester.TesterExperienceIncreasedEvent;
import com.cgz.assignment.domain.exception.EntityNotFoundDomainException;
import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by czarek on 07.08.16.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class TesterService {

    private final ApplicationEventPublisher applicationEventPublisher;
    private TesterRepository testerRepository;
    private DeviceRepository deviceRepository;
    private TesterDtoFactory dtoFactory;

    @Autowired
    public TesterService(TesterRepository testerRepository, DeviceRepository deviceRepository, TesterDtoFactory dtoFactory, ApplicationEventPublisher applicationEventPublisher) {
        this.testerRepository = testerRepository;
        this.deviceRepository = deviceRepository;
        this.dtoFactory = dtoFactory;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @EventListener
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handleBugCreatedEvent(BugCreatedEvent event) {
        increaseExperience(event.getTesterId(), event.getDeviceId());
    }

    public Iterable<TesterDto> findTesters(List<Long> deviceIds, List<String> countryCodes, Pageable pageable) {
        List<Country> countries = mapCountryCodesToEnums(countryCodes);
        List<Tester> testers = findTestersInRepo(deviceIds, countries, pageable);
        return testers.stream().map(dtoFactory::getDto).collect(Collectors.toList());
    }

    private void increaseExperience(long deviceId, long testerId) {
        Tester tester = Optional.ofNullable(testerRepository.findOne(testerId))
                .orElseThrow(() ->
                        new EntityNotFoundDomainException("TesterService increaseExperience didn't find tester")
                );

        Device device = Optional.ofNullable(deviceRepository.findOne(deviceId))
                .orElseThrow(() ->
                        new EntityNotFoundDomainException("TesterService increaseExperience didn't find device")
                );

        tester.increaseExperienceInDevice(device);
        //TODO move event publishing to Tester once it is pure domain entity
        applicationEventPublisher.publishEvent(new TesterExperienceIncreasedEvent(testerId));
    }


    private List<Tester> findTestersInRepo(List<Long> deviceIds, List<Country> countries, Pageable pageable) {
        boolean devicesEmpty = CollectionUtils.isEmpty(deviceIds);
        boolean countriesEmpty = CollectionUtils.isEmpty(countries);
        boolean devicesPresent = !devicesEmpty;
        boolean countriesPresent = !countriesEmpty;

        if (devicesEmpty && countriesEmpty) {
            return testerRepository.findAllOrderByExperience(pageable);
        }

        if (devicesPresent && countriesEmpty) {
            return testerRepository.findByDeviceOrderByExperience(deviceIds, pageable);
        }

        if (devicesEmpty && countriesPresent) {
            return testerRepository.findByCountryOrderByExperience(countries, pageable);
        }

        //devicesPresent && countriesPresent
        return testerRepository.findByDeviceAndCountryOrderByExperience(deviceIds, countries, pageable);

    }

    private List<Country> mapCountryCodesToEnums(List<String> countryCodes) {
        if (CollectionUtils.isEmpty(countryCodes)) {
            return Collections.<Country>emptyList();
        }
        return countryCodes.stream().map(Country::valueOf).collect(Collectors.toList());
    }


}
