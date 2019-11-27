package com.jerome.demo.controller;

import com.jerome.demo.config.WebappInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    private WebappInfo webapp;

    @RequestMapping("/world")
    public String index() {
        return "Hello Word";
    }

    @RequestMapping("/webapp")
    public WebappInfo getWebappInfo() {
        return this.webapp;
    }

}
