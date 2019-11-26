package com.jerome.demo.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Component
public class WebappInfo {

    @Value("${com.jerome.demo.title}")
    private String title;

    @Value("${com.jerome.demo.description}")
    private String description;

}
