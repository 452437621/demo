package com.jerome.demo.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Slf4j
@RunWith(JUnit4.class)
public class TestLambda {

    interface MathOption {
        int operator(int a, int b);
    }

    private int operator(int a, int b, MathOption option) {
        return option.operator(a, b);
    }

    @Test
    public void testMathOption() throws Exception {
        // 加法
        MathOption add = (int a, int b) -> a + b;
        // 减法
        MathOption subtraction = (c, d) -> c -d;
        // 乘法
        MathOption multiplication = (a, b) -> {
            return Math.multiplyExact(a, b);
        };
        // 除法
        MathOption division = (int a, int b) -> {
            return Math.floorDiv(a, b);
        };

        TestLambda test = new TestLambda();
        int a = 10;
        int b = 2;
        int addResult = test.operator(a, b, add);
        int subResult = test.operator(a, b, subtraction);
        int mulResult = test.operator(a, b, multiplication);
        int divResult = test.operator(a, b, division);
        log.info("addResult=" + addResult);
        log.info("subResult=" + subResult);
        log.info("mulResult=" + mulResult);
        log.info("divResult=" + divResult);
    }

}
