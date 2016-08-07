package com.cgz.assignment.application;

import com.cgz.assignment.domain.model.bug.Bug;
import com.cgz.assignment.domain.model.bug.BugRepository;
import com.cgz.assignment.domain.services.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private BugService bugService;

    private BugRepository bugRepository;

    @Autowired
    public Controller(BugService bugService, BugRepository bugRepository) {
        this.bugService = bugService;
        this.bugRepository = bugRepository;
    }

    @RequestMapping(value = "/bug", method = RequestMethod.POST)
    public void submitBug(@RequestParam long deviceId, @RequestParam long testerId) {
        bugService.submitBug(deviceId, testerId);
    }

    @RequestMapping(value = "/bug", method = RequestMethod.GET)
    public Iterable<Bug> getAll() {
        return bugRepository.findAll();
    }


}
