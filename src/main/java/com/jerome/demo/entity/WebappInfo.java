package com.jerome.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Component
public class WebappInfo {

    @Value("${com.neo.project.info.name}")
    private String name;

    @Value("${com.neo.project.info.company}")
    private String company;

    @Value("${com.neo.title}")
    private String title;

    @Value("${com.neo.description}")
    private String description;

}
