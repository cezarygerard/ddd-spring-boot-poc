package com.cgz.assignment.domain.model.bug.events;

import com.cgz.assignment.domain.model.bug.Bug;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.tester.Tester;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.context.ApplicationEventPublisher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by czarek on 08.08.16.
 */
public class BugEventPublisherTest {

    private final Long DEVICE_ID = 11L;
    private final Long TESTER_ID = 51L;
    private ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    private BugEventPublisher bugEventPublisher = new BugEventPublisher(applicationEventPublisher);
    private Bug bug = mock(Bug.class);

    @Before
    public void setUp() {
        when(bug.getDevice()).thenReturn(mock(Device.class));
        when(bug.getTester()).thenReturn(mock(Tester.class));
    }

    @Test
    public void shouldPublishEventViaApplicationEventPublisher() {
        bugEventPublisher.publishBugCreatedEvent(bug);
        verify(applicationEventPublisher, times(1)).publishEvent(any(BugCreatedEvent.class));
    }


    @Test
    public void shouldPublishEventWithTesterIdAndDeviceId() {
        when(bug.getDevice().getId()).thenReturn(DEVICE_ID);
        when(bug.getTester().getId()).thenReturn(TESTER_ID);

        bugEventPublisher.publishBugCreatedEvent(bug);

        ArgumentCaptor<BugCreatedEvent> argument = ArgumentCaptor.forClass(BugCreatedEvent.class);
        verify(applicationEventPublisher, times(1)).publishEvent(argument.capture());
        assertThat(argument.getValue().getDeviceId()).isEqualTo(DEVICE_ID);
        assertThat(argument.getValue().getTesterId()).isEqualTo(TESTER_ID);

    }
}