package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.exception.EntityNotFoundDomainException;
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
    public void shouldIncreaseIncreaseExperienceForExistingDevice() throws Exception {
        Experience experience = new Experience(device, 1L);
        tester.getExperiences().add(experience);

        long oldExp = tester.getExperienceInDevice(device);
        assertThat(oldExp).isEqualTo(1);

        tester.increaseExperienceInDevice(device);

        long newExp = tester.getExperienceInDevice(device);
        assertThat(newExp).isEqualTo(2);
    }


    @Test(expected = EntityNotFoundDomainException.class)
    public void shouldThrowExceptionIfNoDevice() throws Exception {
        long oldExp = tester.getExperienceInDevice(device);
        assertThat(oldExp).isEqualTo(0);
        tester.increaseExperienceInDevice(device);
    }

}