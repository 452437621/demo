package com.jerome.demo.controller;

import com.jerome.demo.config.WebappInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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

    @RequestMapping("/peng")
    public String helloPengpeng() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "陈鹏鹏");
        jsonObj.put("name2", "邓蛋蛋");
        return jsonObj.toString();
    }

    @RequestMapping("/person")
    public String getPerson() {
        JSONObject json = new JSONObject();
        try {
            json.put("name", "张三");
            json.put("age", 21);
            json.put("sex", "男");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    @RequestMapping("/webapp")
    public WebappInfo getWebappInfo() {
        return this.webapp;
    }

}
