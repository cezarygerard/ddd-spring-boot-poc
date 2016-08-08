package com.cgz.assignment.application;

import com.cgz.assignment.domain.services.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by czarek on 08.08.16.
 */
@RestController
public class BugsController {

    private BugService bugService;

    @Autowired
    public BugsController(BugService bugService) {
        this.bugService = bugService;
    }

    @RequestMapping(value = "/bug", method = RequestMethod.POST)
    public void submitBug(@RequestParam long deviceId, @RequestParam long testerId) {
        bugService.submitBug(deviceId, testerId);
    }
}
