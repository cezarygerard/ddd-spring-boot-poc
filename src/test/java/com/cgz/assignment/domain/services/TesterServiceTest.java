package com.cgz.assignment.domain.services;

import com.cgz.assignment.domain.dto.tester.TesterDtoFactory;
import com.cgz.assignment.domain.event.bug.BugCreatedEvent;
import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import com.cgz.assignment.domain.services.tester.TesterService;
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

    @Test
    public void shouldHandleBugCreatedEvent() {
        Long DEVICE_ID = 1L;
        Long TESTER_ID = 5L;
        Tester tester = mock(Tester.class);
        Device device = mock(Device.class);
        when(testerRepository.findOne(TESTER_ID)).thenReturn(tester);
        when(deviceRepository.findOne(DEVICE_ID)).thenReturn(device);
        testerService.handleBugCreatedEvent(new BugCreatedEvent(TESTER_ID, DEVICE_ID));
        verify(tester, times(1)).increaseExperienceInDevice(device);
    }

    @Test
    public void shouldFindTestersByCountry() {
        List<String> countryCodes = Arrays.asList("US", "JP");
        List<Country> countryEnums = Arrays.asList(Country.US, Country.JP);
        testerService.findTesters(null, countryCodes, pageable);
        verify(testerRepository, times(1)).findByCountryOrderByExperience(eq(countryEnums), pageable);
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
        verify(testerRepository, times(1)).findByDeviceAndCountryOrderByExperience(devices, eq(countryEnums), pageable);
    }

    @Test
    public void shouldFindAllTesters() {
        testerService.findTesters(null, null, pageable);
        verify(testerRepository, times(1)).findAllOrderByExperience(pageable);
    }

    //todo test exceptions
    //todo test event publishing
}
