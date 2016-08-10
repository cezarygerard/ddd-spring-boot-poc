package com.cgz.assignment.domain.services.tester;

import com.cgz.assignment.domain.dto.tester.TesterDtoFactory;
import com.cgz.assignment.domain.event.bug.BugCreatedEvent;
import com.cgz.assignment.domain.event.tester.TesterExperienceIncreasedEvent;
import com.cgz.assignment.domain.exception.EntityNotFoundDomainException;
import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by czarek on 07.08.16.
 */
public class TesterServiceTest {


    private DeviceRepository deviceRepository = mock(DeviceRepository.class);
    private TesterRepository testerRepository = mock(TesterRepository.class);
    private TesterDtoFactory dtoFactory = mock(TesterDtoFactory.class);
    private ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);

    private TesterService testerService = new TesterService(testerRepository, deviceRepository, dtoFactory, applicationEventPublisher);

    private Pageable pageable = mock(Pageable.class);
    private Long DEVICE_ID = 1L;
    private Long TESTER_ID = 5L;
    private Tester tester = mock(Tester.class);
    private Device device = mock(Device.class);

    @Before
    public void setup() {
        when(testerRepository.findOne(TESTER_ID)).thenReturn(tester);
        when(deviceRepository.findOne(DEVICE_ID)).thenReturn(device);
        when(tester.getId()).thenReturn(TESTER_ID);
    }

    @Test
    public void shouldHandleBugCreatedEvent() {
        testerService.handleBugCreatedEvent(new BugCreatedEvent(DEVICE_ID, TESTER_ID));
        verify(deviceRepository, times(1)).findOne(DEVICE_ID);
        verify(testerRepository, times(1)).findOne(TESTER_ID);
        verify(tester, times(1)).increaseExperienceInDevice(device);
    }

    @Test
    public void shouldPublishEventOnExperienceIncreased() {
        testerService.handleBugCreatedEvent(new BugCreatedEvent(DEVICE_ID, TESTER_ID));
        verify(applicationEventPublisher, times(1)).publishEvent(refEq(new TesterExperienceIncreasedEvent(TESTER_ID)));
    }


    @Test(expected = EntityNotFoundDomainException.class)
    public void shouldThrowExceptionOnInvalidTesterId() {
        when(testerRepository.findOne(TESTER_ID)).thenReturn(null);
        testerService.handleBugCreatedEvent(new BugCreatedEvent(DEVICE_ID, TESTER_ID));
    }

    @Test(expected = EntityNotFoundDomainException.class)
    public void shouldThrowExceptionOnInvalidDeviceId() {
        when(deviceRepository.findOne(DEVICE_ID)).thenReturn(null);
        testerService.handleBugCreatedEvent(new BugCreatedEvent(DEVICE_ID, TESTER_ID));
    }

    @Test
    public void shouldFindTestersByCountry() {
        List<String> countryCodes = Arrays.asList("US", "JP");
        List<Country> countryEnums = Arrays.asList(Country.US, Country.JP);
        testerService.findTesters(null, countryCodes, pageable);
        verify(testerRepository, times(1)).findByCountryOrderByExperience(eq(countryEnums), eq(pageable));
    }

    @Test
    public void shouldFindTestersByDevice() {
        List<Long> devices = Arrays.asList(5L, 55L);
        testerService.findTesters(devices, null, pageable);
        verify(testerRepository, times(1)).findByDeviceOrderByExperience(devices, pageable);
    }

    @Test
    public void shouldFindTestersByDeviceAndCountry() {
        List<String> countryCodes = Arrays.asList("US", "JP");
        List<Country> countryEnums = Arrays.asList(Country.US, Country.JP);
        List<Long> devices = Arrays.asList(5L, 55L);
        testerService.findTesters(devices, countryCodes, pageable);
        verify(testerRepository, times(1)).findByDeviceAndCountryOrderByExperience(eq(devices), eq(countryEnums), eq(pageable));
    }

    @Test
    public void shouldFindAllTesters() {
        testerService.findTesters(null, null, pageable);
        verify(testerRepository, times(1)).findAllOrderByExperience(pageable);
    }

}
