package com.jerome.demo.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(JUnit4.class)
public class TestLambda {

    @Test
    public void testMathOption() throws Exception {
        TestLambda test = new TestLambda();

        MathOption add = (int a, int b) -> a + b;
        MathOption subtraction = (c, d) -> c -d;
        MathOption multiplication = (a, b) -> {
            System.out.println("a = " + a + " b =" + b);
            return Math.multiplyExact(a, b);
        };
        MathOption division = (int a, int b) -> {
            return Math.floorDiv(a, b);
        };

        int result = test.operator(10, 2, (a, b) -> {
            System.out.println("a = " + a + " b =" + b);
            return Math.max(a, b);
        });
        System.out.println("max is " + result);

    }

    interface MathOption {
        int operator(int a, int b);
    }

    interface GreetingService {
        void sendMessage(String msg);
    }

    private int operator(int a, int b, MathOption option) {
        return option.operator(a, b);
    }

}
