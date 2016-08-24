package com.cgz.assignment.application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by czarek on 07.08.16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestersControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .alwaysExpect(status().isOk())
                .alwaysExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
                .build();
    }

    @Test
    public void testHappyPath() throws Exception {
        mockMvc.perform(get("/tester")
                .param("deviceId", "1", "2", "3", "6")
                .param("country", "US", "JP")
                .param("page", "1")
                .param("size", "3"))
                .andExpect(jsonPath("$[0].testerId", equalTo(5)))
                .andExpect(jsonPath("$[0].firstName", equalTo("Mingquan")))
                .andExpect(jsonPath("$[0].lastName", equalTo("Zheng")))
                .andExpect(jsonPath("$[0].country", equalTo("JP")))
                .andExpect(jsonPath("$[0].devices[*].deviceId", containsInAnyOrder(1, 10, 5, 6, 7)))
        ;
    }

}