package com.jerome.demo.controller.test;

import com.jerome.demo.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/template")
public class TemplateController {

    @GetMapping("/hello")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/book")
    @ResponseBody
    public Book getBoot() {
        Book book = Book.builder().id(1).name("Effective Java").build();
        return book;
    }

}
