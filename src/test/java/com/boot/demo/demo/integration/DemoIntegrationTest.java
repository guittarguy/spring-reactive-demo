package com.boot.demo.demo.integration;

import com.boot.demo.demo.DemoApplication;
import com.boot.demo.demo.pojo.Demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoIntegrationTest {
    private static final String HOST = "http://localhost:";
    @LocalServerPort
    private int port;
    private TestRestTemplate testRestTemplate = new TestRestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testDemoApi() {
        ResponseEntity<Demo> demoResponse = testRestTemplate.getForEntity(HOST + port + "/demo/1", Demo.class);
        assertTrue(demoResponse.hasBody());
        Demo demo = demoResponse.getBody();
        assertTrue(demo != null);
        assertTrue(demo.getId().equals(1));
        assertTrue(demo.getName().equals("test"));
    }

    @Test
    public void testGetAllApi() throws Exception {
        ResponseEntity<String> demos = testRestTemplate.getForEntity(HOST + port + "/demo/all", String.class);
        List<Demo> demoList = objectMapper.readValue(demos.getBody(), ArrayList.class);
        assertTrue(demoList.isEmpty());
        assertTrue(demoList.size() == 0);
    }
}
