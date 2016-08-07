package com.cgz.assignment.domain.model.Tester;

import com.cgz.assignment.domain.model.Device.Device;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by czarek on 07.08.16.
 */
public class TesterTest {

    private Tester tester = new Tester();
    private Device deviceMock = mock(Device.class);

    @Test
    public void shouldIncreaseIncreaseExperienceForNewDevice() throws Exception {
        long oldExp = tester.getExperienceInDevice(deviceMock);
        assertThat(oldExp).isEqualTo(0);

        tester.increaseExpInDevice(deviceMock);

        long newExp = tester.getExperienceInDevice(deviceMock);
        assertThat(newExp).isEqualTo(1);
    }

    @Test
    public void shouldIncreaseIncreaseExperienceForExistingDevice() throws Exception {
        tester.increaseExpInDevice(deviceMock);

        long oldExp = tester.getExperienceInDevice(deviceMock);
        assertThat(oldExp).isEqualTo(1);

        tester.increaseExpInDevice(deviceMock);

        long newExp = tester.getExperienceInDevice(deviceMock);
        assertThat(newExp).isEqualTo(2);
    }

}