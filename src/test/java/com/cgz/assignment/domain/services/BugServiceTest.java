package com.cgz.assignment.domain.services;

import com.cgz.assignment.domain.model.bug.Bug;
import com.cgz.assignment.domain.model.bug.BugFactory;
import com.cgz.assignment.domain.model.bug.BugRepository;
import com.cgz.assignment.domain.model.bug.events.BugEventPublisher;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Created by czarek on 07.08.16.
 */
public class BugServiceTest {

    private final Long DEVICE_ID = 1L;
    private final Long TESTER_ID = 5L;
    private DeviceRepository deviceRepository = mock(DeviceRepository.class);
    private BugRepository bugRepository = mock(BugRepository.class);
    private TesterRepository testerRepository = mock(TesterRepository.class);
    private BugFactory bugFactory = mock(BugFactory.class);
    private BugEventPublisher bugEventPublisher = mock(BugEventPublisher.class);

    private BugService bugService = new BugService(deviceRepository, bugRepository, testerRepository, bugFactory, bugEventPublisher);

    private Device device = mock(Device.class);
    private Tester tester = mock(Tester.class);
    private Bug bug = mock(Bug.class);

    @Before
    public void setUp() {
        when(bugFactory.create(device, tester)).thenReturn(bug);
        when(deviceRepository.findOne(anyLong())).thenReturn(device);
        when(testerRepository.findOne(anyLong())).thenReturn(tester);
    }

    @Test
    public void shouldCreateNewBug() {
        bugService.submitBug(DEVICE_ID, TESTER_ID);
        verify(bugFactory, times(1)).create(device, tester);
    }

    @Test
    public void shouldPersistNewBug() {
        bugService.submitBug(DEVICE_ID, TESTER_ID);
        verify(bugRepository, times(1)).save(bug);
    }

    @Test
    public void shouldPublishEvent() {
        bugService.submitBug(DEVICE_ID, TESTER_ID);
        verify(bugEventPublisher, times(1)).publishBugCreatedEvent(bug);
    }


}