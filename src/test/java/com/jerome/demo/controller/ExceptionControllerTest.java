package com.jerome.demo.controller;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ExceptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    @BeforeEach
//    public void beforeEach() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(new ExceptionController()).build();
//    }

    @Test
    public void should_return_400_if_param_not_valid() throws Exception {
       mockMvc.perform(get("/exception/illegalArgs/"))
               .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
               .andExpect(jsonPath("${message}").value("参数错误"));
    }

}
