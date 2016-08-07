package com.cgz.assignment.application;

import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.bug.BugRepository;
import com.cgz.assignment.domain.model.device.DeviceRepository;
import com.cgz.assignment.domain.model.tester.Tester;
import com.cgz.assignment.domain.model.tester.TesterRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * Created by czarek on 07.08.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerIntegrationTest {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private TesterRepository testerRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Before
    public void setup() throws IOException {
        readTestData();
    }

    @Test
    public void test() {
    }

    private void readTestData() throws IOException {

        File file = new File(this.getClass().getClassLoader().getResource("test_data/testers.csv").getFile());

        FileInputStream fis = new FileInputStream(file);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        br.readLine();
        while ((line = br.readLine()) != null) {
            line = line.replace("\"", "");
            String[] splited = line.split(",");
            Tester tester = new Tester(Long.valueOf(splited[0]), splited[1], splited[2], Country.valueOf(splited[3]), null);

            testerRepository.save(tester);
        }


    }


}