package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.model.device.Device;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by czarek on 07.08.16.
 */
public class TesterTest {

    private Tester tester = new Tester();
    private Device device = mock(Device.class);

    @Test
    public void shouldIncreaseIncreaseExperienceForNewDevice() throws Exception {
        long oldExp = tester.getExperienceInDevice(device);
        assertThat(oldExp).isEqualTo(0);

        tester.increaseExperienceInDevice(device);

        long newExp = tester.getExperienceInDevice(device);
        assertThat(newExp).isEqualTo(1);
    }

    @Test
    public void shouldIncreaseIncreaseExperienceForExistingDevice() throws Exception {
        tester.increaseExperienceInDevice(device);

        long oldExp = tester.getExperienceInDevice(device);
        assertThat(oldExp).isEqualTo(1);

        tester.increaseExperienceInDevice(device);

        long newExp = tester.getExperienceInDevice(device);
        assertThat(newExp).isEqualTo(2);
    }

}