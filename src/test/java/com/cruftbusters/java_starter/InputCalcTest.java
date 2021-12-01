package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputCalcTest {
    @Test
    void Addition() {
        new InputCalc() {{
            Assertions.assertEquals(2, result("1+1"));
            Assertions.assertEquals(4, result("2+2"));
            Assertions.assertEquals(13, result("4+9"));
        }};
    }
    @Test
    void Subtraction() {
        new InputCalc() {{
            Assertions.assertEquals(4, result("8-4"));
            Assertions.assertEquals(1, result("6-5"));
            Assertions.assertEquals(3, result("3-0"));
        }};
    }
    @Test
    void Multiply() {
        new InputCalc() {{
            Assertions.assertEquals(6, result("3*2"));
            Assertions.assertEquals(4, result("2*2"));
            Assertions.assertEquals(63, result("7*9"));
        }};
    }
    @Test
    void Divide() throws ArithmeticException {
        new InputCalc() {{
            Assertions.assertEquals(4, result("8/2"));
            Assertions.assertEquals(2, result("8/4"));
            ArithmeticException exception = Assertions.assertThrows(
                    ArithmeticException.class,
                    () -> result("8/0"));
            Assertions.assertEquals("Can't be divided by 0", exception.getMessage());
        }};
    }
    @Test
    void InputWithSpaces() {
        new InputCalc() {{
            Assertions.assertEquals(14, result("5 + 9"));
            Assertions.assertEquals(7, result(" 4 + 3 "));
        }};
    }
    @Test
    void DoubleDigits() {
        new InputCalc() {{
            Assertions.assertEquals(68, result("23 + 45"));
            Assertions.assertEquals(1035, result("23 * 45"));
            Assertions.assertEquals(4, result("48 / 12"));
        }};
    }
    @Test
    void TripleDigits() {
        new InputCalc() {{
            Assertions.assertEquals(1300, result("721 + 123 + 456"));
            Assertions.assertEquals(142, result("721 - 123 - 456"));
            Assertions.assertEquals(40439448, result("721 * 123 * 456"));
        }};
    }
}
