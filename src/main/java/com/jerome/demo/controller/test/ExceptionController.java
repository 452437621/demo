package com.jerome.demo.controller.test;

import com.jerome.demo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

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
        if (path == null) {
            throw new ResourceNotFoundException("path is null!");
        }
        return path;
    }
}
