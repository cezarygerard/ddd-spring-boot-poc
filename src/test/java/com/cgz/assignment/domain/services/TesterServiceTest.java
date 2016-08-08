package com.cgz.assignment.domain.services;

import com.cgz.assignment.domain.model.bug.events.BugCreatedEvent;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by czarek on 07.08.16.
 */
public class TesterServiceTest {

    private final Long DEVICE_ID = 1L;
    private final Long TESTER_ID = 5L;
    private DeviceRepository deviceRepository = mock(DeviceRepository.class);
    private TesterRepository testerRepository = mock(TesterRepository.class);
    private Tester tester = mock(Tester.class);
    private Device device = mock(Device.class);
    private TesterService testerService = new TesterService(testerRepository, deviceRepository);

    @Before
    public void setup() {
        when(testerRepository.findOne(TESTER_ID)).thenReturn(tester);
        when(deviceRepository.findOne(DEVICE_ID)).thenReturn(device);
    }

    @Test
    public void shouldhandleBugCreatedEvent() {
        testerService.handleBugCreatedEvent(new BugCreatedEvent(TESTER_ID, DEVICE_ID));
        verify(tester, times(1)).increaseExpInDevice(device);
    }

    //TODO test search

    //TODO test method for event handling


}
