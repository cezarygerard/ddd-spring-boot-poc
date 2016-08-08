package com.cgz.assignment.application;

import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.services.BugService;
import com.cgz.assignment.domain.services.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private BugService bugService;

    private TesterService testerService;


    @Autowired
    public Controller(BugService bugService, TesterService testerService) {
        this.bugService = bugService;
        this.testerService = testerService;
    }

    //TODO move to separate controller
    @RequestMapping(value = "/bug", method = RequestMethod.POST)
    public void submitBug(@RequestParam long deviceId, @RequestParam long testerId) {
        bugService.submitBug(deviceId, testerId);
    }

    @RequestMapping(value = "/tester", method = RequestMethod.GET)
    //TODO return DTOS not entities
    public Iterable<Tester> findTesters(@RequestParam(name = "deviceId") long device, @RequestParam("country") String country) {
        return testerService.findTesters(device, country);
    }


}
