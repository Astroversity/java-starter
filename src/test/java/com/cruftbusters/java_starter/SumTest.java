package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class SumTest {
    @Test void sumSomeNumbers() {
        Calculator calculator = new Calculator();
        int[] numbers = new int[] {1, 2, 3, 4};
        assertEquals(10, calculator.sum(numbers));
    }
    @Test void numbersMax() {
        Calculator calculator = new Calculator();
        assertEquals(9, calculator.max(6, 9));
        assertEquals(9, calculator.max(9, 6));
    }
}
