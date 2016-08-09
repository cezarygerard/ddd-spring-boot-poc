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
import org.springframework.data.domain.PageRequest;
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
        Long[] devices = {1L, 2L, 3L, 6L};

        List<Country> countries = Arrays.asList(Country.US, Country.JP);

        List<Long> inputAsList = Arrays.asList(devices);

        List<Tester> res = testerRepository.findByDeviceAndCountryOrderByExperience(inputAsList, countries, new PageRequest(2, 2));

        System.out.println(Arrays.toString(res.toArray()));

    }

//    TODO INTEGRATION TESTS

}