package com.cgz.assignment.application;

import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.bug.BugRepository;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by czarek on 07.08.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerIntegrationTest {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private TesterRepository testerRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Test
    public void test() {
        List<Tester> testers2 = testerRepository.findByCountryAndExperiencesDeviceOrderByExperiencesExperiencePointsDesc(Country.US, deviceRepository.findOne(8L));
        //TODO
    }


}