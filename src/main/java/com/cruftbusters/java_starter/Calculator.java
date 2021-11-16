package com.cruftbusters.java_starter;

public class Calculator {
    public int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
