package com.cgz.assignment.application;

import com.cgz.assignment.domain.model.bug.BugRepository;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by czarek on 07.08.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestersControllerIntegrationTest {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private TesterRepository testerRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Test
    public void testSimpleFind() {
//        String[] countries = {"US",};
        Long[] devices = {1L, 2L, 3L, 6L};
//        List<Tester> testers = testerRepository.findByDeviceAndCountryOrderByExperience(devices, countries);

        List<String> countries = Arrays.asList("US", "JP");

        List<Long> inputAsList = Arrays.asList(devices);

        List<Tester> res = testerRepository.findByDeviceAndCountryOrderByExperience(inputAsList, countries);

        System.out.println(Arrays.toString(res.toArray()));

    }

//    TODO INTEGRATION TESTS

}