package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputCalcTest {
    @Test
    void Addition() {
        new InputCalc() {{
            Assertions.assertEquals(2, result("1+1"));
            Assertions.assertEquals(4, result("2+2"));
        }};
    }
    @Test
    void Subtraction() {
        new InputCalc() {{
            Assertions.assertEquals(0, result("1-1"));
        }};
    }
    @Test
    void Multiply() {
        new InputCalc() {{
            Assertions.assertEquals(6, result("3*2"));
            Assertions.assertEquals(4, result("2*2"));
        }};
    }
    @Test
    void Divide() {
        new InputCalc() {{
            Assertions.assertEquals(4, result("8/2"));
            Assertions.assertEquals(2, result("8/4"));
        }};
    }
}
