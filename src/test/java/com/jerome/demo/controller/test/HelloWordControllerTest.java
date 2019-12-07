package com.jerome.demo.controller.test;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
public class HelloWordControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @BeforeEach
    public void setUp() {
        log.debug("start test!");
        log.debug("mvc = " + mvc);
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void contextLoads() {}

    @Test
    public void getHello() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/hello/world").accept(MediaType.APPLICATION_JSON);
        mvc.perform(builder).andExpect(status().isOk()).andExpect(content().string(equalTo("Hello Word")));
    }

}
