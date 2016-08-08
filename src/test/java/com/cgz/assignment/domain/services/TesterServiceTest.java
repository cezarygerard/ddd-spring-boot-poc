package com.cgz.assignment.domain.services;

import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by czarek on 07.08.16.
 */
public class TesterServiceTest {

    private final Long DEVICE_ID = 1L;
    private final Long TESTER_ID = 5L;
    private DeviceRepository deviceRepositoryMock = mock(DeviceRepository.class);
    private TesterRepository testerRepositoryMock = mock(TesterRepository.class);
    private Tester testerMock = mock(Tester.class);
    private Device deviceMock = mock(Device.class);
    private ConcurrentHashMap<Device, Long> experience = new ConcurrentHashMap<>();
    private TesterService testerService = new TesterService(testerRepositoryMock, deviceRepositoryMock);

    @Before
    public void setup() {
        when(testerRepositoryMock.findOne(TESTER_ID)).thenReturn(testerMock);
        when(testerMock).thenReturn(testerMock);
    }

    @Test
    public void shouldIncreaseExperienceForExistingDevice() {
        experience.put(deviceMock, 3L);

        testerService.increaseExperience(DEVICE_ID, TESTER_ID);

        assertThat(experience).contains(new AbstractMap.SimpleEntry<>(deviceMock, 4L));
    }

    //TODO test search

}
