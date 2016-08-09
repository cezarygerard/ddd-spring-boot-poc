package com.cgz.assignment.application;

import com.cgz.assignment.domain.dto.tester.TesterDto;
import com.cgz.assignment.domain.services.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestersController {

    private TesterService testerService;

    @Autowired
    public TestersController(TesterService testerService) {
        this.testerService = testerService;
    }

    @RequestMapping(value = "/tester", method = RequestMethod.GET)
    public Iterable<TesterDto> findTesters(@RequestParam(name = "deviceId", defaultValue = "") List<Long> devices,
                                           @RequestParam(name = "country", defaultValue = "") List<String> countries,
                                           @RequestParam int page, @RequestParam int size) {

        Pageable pageable = new PageRequest(page, size);
        return testerService.findTesters(devices, countries, pageable);
    }


}
