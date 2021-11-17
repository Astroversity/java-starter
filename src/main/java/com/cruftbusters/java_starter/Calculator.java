package com.cruftbusters.java_starter;

public class Calculator {
    public int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
    public int max(int[] compArray){
        int max = Integer.MIN_VALUE;
        for (int number : compArray) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println(max);
        return max;
    }
}
