package com.jerome.demo.lambda;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RunWith(JUnit4.class)
public class LambdaTest {

    @FunctionalInterface
    interface IFunction<T,K> {
        K convert(T t);

        default List<K> listConvert(List<T> list) {
            List<K> convertList = list.stream().map(t -> convert(t)).collect(Collectors.toList());
            return convertList;
        }
    }

    @Test
    public void testLambda() {
        IFunction<String, Integer> f = Integer::valueOf;
        List<String> strList = Arrays.asList("1", "2", "3", "100");
        List<Integer> intList = f.listConvert(strList);
        log.info(intList);
        int sum = strList.stream().mapToInt(Integer::parseInt).sum();
        log.info(String.format("count = %d", sum));
    }
}
