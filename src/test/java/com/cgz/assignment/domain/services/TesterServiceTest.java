package com.cgz.assignment.domain.services;

import com.cgz.assignment.domain.dto.tester.TesterDtoFactory;
import com.cgz.assignment.domain.model.bug.events.BugCreatedEvent;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by czarek on 07.08.16.
 */
public class TesterServiceTest {

    private final Long DEVICE_ID = 1L;
    private final Long TESTER_ID = 5L;
    private DeviceRepository deviceRepository = mock(DeviceRepository.class);
    private TesterRepository testerRepository = mock(TesterRepository.class);
    private TesterDtoFactory dtoFactory = mock(TesterDtoFactory.class);
    private Tester tester = mock(Tester.class);
    private Device device = mock(Device.class);
    private TesterService testerService = new TesterService(testerRepository, deviceRepository, dtoFactory);

    @Test
    public void shouldHandleBugCreatedEvent() {
        when(testerRepository.findOne(TESTER_ID)).thenReturn(tester);
        when(deviceRepository.findOne(DEVICE_ID)).thenReturn(device);
        testerService.handleBugCreatedEvent(new BugCreatedEvent(TESTER_ID, DEVICE_ID));
        verify(tester, times(1)).increaseExperienceInDevice(device);
    }

    @Test
    public void shouldFindTestersByCountry() {
        List<String> countries = Arrays.asList("US", "JP");
        testerService.findTesters(null, countries);
        verify(testerRepository, times(1)).findByCountryOrderByExperience(countries);
    }

    @Test
    public void shouldFindTestersByDevice() {
        List<Long> devices = Arrays.asList(5L, 55L);
        testerService.findTesters(devices, null);
        verify(testerRepository, times(1)).findByDeviceOrderByExperience(devices);
    }

//    @Test
//    public void shouldFindTestersByDeviceAndCountry() {
//        List<String> countries = Arrays.asList("US", "JP");
//        List<Long> devices = Arrays.asList(5L, 55L);
//        testerService.findTesters(devices,countries);
//        verify(testerRepository, times(1)).findByDeviceAndCountryOrderByExperience(devices,countries);
//    }

    @Test
    public void shouldFindAllTesters() {
        testerService.findTesters(null, null);
        verify(testerRepository, times(1)).findAllOrderByExperience();
    }


}
