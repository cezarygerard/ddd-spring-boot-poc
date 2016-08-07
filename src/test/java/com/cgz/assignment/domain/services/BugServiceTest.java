package com.cgz.assignment.domain.services;

import com.cgz.assignment.domain.model.bug.Bug;
import com.cgz.assignment.domain.model.bug.BugFactory;
import com.cgz.assignment.domain.model.bug.BugRepository;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.junit.Test;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Created by czarek on 07.08.16.
 */
public class BugServiceTest {

    private final Long DEVICE_ID = 1L;
    private final Long TESTER_ID = 5L;
    private DeviceRepository deviceRepositoryMock = mock(DeviceRepository.class);
    private BugRepository bugRepositoryMock = mock(BugRepository.class);
    private TesterRepository testerRepository = mock(TesterRepository.class);
    private BugFactory bugFactory = mock(BugFactory.class);
    private BugService bugService = new BugService(deviceRepositoryMock, bugRepositoryMock, testerRepository, bugFactory, null);

    @Test
    public void shouldSaveNewBug() {
        Device deviceMock = mock(Device.class);
        when(deviceRepositoryMock.findOne(anyLong())).thenReturn(deviceMock);
        Tester testerMock = mock(Tester.class);
        when(testerRepository.findOne(anyLong())).thenReturn(testerMock);
        Bug bugMock = mock(Bug.class);
        when(bugFactory.create(deviceMock, testerMock)).thenReturn(bugMock);

        bugService.submitBug(DEVICE_ID, TESTER_ID);

        verify(bugFactory, times(1)).create(deviceMock, testerMock);
        verify(bugRepositoryMock, times(1)).save(bugMock);
    }


}