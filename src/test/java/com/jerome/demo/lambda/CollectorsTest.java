package com.jerome.demo.lambda;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(JUnit4.class)
public class CollectorsTest {

    @Test
    public void testSort() {
        List<String> strList = Arrays.asList("a", "ab", "abc", "abcd");
        log.info("strList=" + strList);
        strList.sort((String a, String b) -> {
            return b.length() - a.length();
        });
        log.info("strList=" + strList);
        log.info(String.format("OX%x", 10));
    }

}
