package com.boot.demo.demo.controller;

import com.boot.demo.demo.pojo.Demo;
import com.boot.demo.demo.service.DemoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DemoService demoService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getDemo() throws Exception {
        Mockito.when(demoService.getDemo(1)).thenReturn(new Demo(1, "test"));
        mockMvc.perform(MockMvcRequestBuilders.get("/demo/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(mvcResult -> {
                    String content = mvcResult.getResponse().getContentAsString();
                    assertTrue(content.contains("\"id\":"));
                });
    }

    @Test
    void getAllDemosTest() throws Exception {
        List<Demo> demos = new ArrayList<>();
        demos.add(new Demo(1, "test"));
        demos.add(new Demo(2, "random"));
        Mockito.when(demoService.getAll()).thenReturn(demos);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/demo/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        List<Demo> demoList = objectMapper.readValue(json, ArrayList.class);
        assertTrue(!demoList.isEmpty());
        assertEquals(demoList.size(), demos.size());
    }
}