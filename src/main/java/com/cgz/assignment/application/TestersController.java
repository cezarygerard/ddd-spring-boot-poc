package com.cgz.assignment.application;

import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.services.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestersController {

    private TesterService testerService;

    @Autowired
    public TestersController(TesterService testerService) {
        this.testerService = testerService;
    }

    @RequestMapping(value = "/tester", method = RequestMethod.GET)
    //TODO return DTOS not entities
    public Iterable<Tester> findTesters(@RequestParam(name = "deviceId") long device, @RequestParam("country") String country) {
        return testerService.findTesters(device, country);
    }


}
