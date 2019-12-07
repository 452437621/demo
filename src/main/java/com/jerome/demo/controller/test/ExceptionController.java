package com.jerome.demo.controller.test;

import com.jerome.demo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/illegalArgs/{id}")
    public long testIllegalArgs(@PathVariable Long id) {
        if (id == 0) {
            throw new IllegalArgumentException("参数错误");
        }
        return id;
    }

    @RequestMapping("/resourceNotFound")
    public String testResourceNotFound(String path) {
        if (path != null) {
            Map<String, Object> data = new HashMap<>(1);
            data.put("path", path);
            throw new ResourceNotFoundException(data);
        }
        return null;
    }
}
