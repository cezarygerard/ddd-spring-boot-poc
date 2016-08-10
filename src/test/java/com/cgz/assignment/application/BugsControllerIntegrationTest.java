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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by czarek on 09.08.16.
 */

//TODO INTEGRATION TESTS
//invalid params [2]

@RunWith(SpringRunner.class)
@SpringBootTest
public class BugsControllerIntegrationTest {

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
        mockMvc.perform(post("/bug")
                .param("deviceId", "5")
                .param("testerId", "2"))
                .andExpect(jsonPath("$.id", greaterThan(1000)))
                .andExpect(jsonPath("$.deviceId", equalTo(5)))
                .andExpect(jsonPath("$.testerId", equalTo(2)))
        ;
    }

}
