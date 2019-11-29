package com.jerome.demo.controller;

import com.jerome.demo.controller.test.HelloWorldController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWordControllerTest {

    private MockMvc mvc;

    @Test
    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void contextLoads() {}

    @Test
    public void getHello() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
        mvc.perform(builder).andExpect(status().isOk()).andExpect(content().string(equalTo("Hello Word")));
    }

}
