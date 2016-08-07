package com.cgz.assignment.application;

import com.cgz.assignment.domain.model.bug.Bug;
import com.cgz.assignment.domain.model.bug.BugRepository;
import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.services.BugService;
import com.cgz.assignment.domain.services.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//TODO devide into a few classes
public class Controller {

    private BugService bugService;

    private BugRepository bugRepository;

    private TesterService testerService;

    private DeviceRepository deviceRepository;

    @Autowired
    public Controller(BugService bugService, BugRepository bugRepository, TesterService testerService, DeviceRepository deviceRepository) {
        this.bugService = bugService;
        this.bugRepository = bugRepository;
        this.testerService = testerService;
        this.deviceRepository = deviceRepository;
    }

    @RequestMapping(value = "/bug", method = RequestMethod.POST)
    public void submitBug(@RequestParam long deviceId, @RequestParam long testerId) {
        bugService.submitBug(deviceId, testerId);
    }

    @RequestMapping(value = "/bug", method = RequestMethod.GET)
    //TODO DTOS
    public Iterable<Bug> getAllBugs() {
        return bugRepository.findAll();
    }

    @RequestMapping(value = "/tester", method = RequestMethod.GET)
    //TODO DTOS
    public Iterable<Tester> findTesters(@RequestParam(name = "deviceId") long[] devices, @RequestParam("country") String[] countries) {
        return testerService.findTesters(devices, countries);
    }


    @RequestMapping(value = "/device", method = RequestMethod.GET)
    //TODO DTOS
    public Iterable<Device> getAllDevices() {
        return deviceRepository.findAll();
    }


}
