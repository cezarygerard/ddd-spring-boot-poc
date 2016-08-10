package com.cgz.assignment.application.bug;

import com.cgz.assignment.domain.dto.bug.BugDto;
import com.cgz.assignment.domain.services.bug.BugService;
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
    public BugDto submitBug(@RequestParam long deviceId, @RequestParam long testerId) {
        return bugService.submitBug(deviceId, testerId);
    }
}
