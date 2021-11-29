package com.cruftbusters.java_starter;

import java.util.ArrayList;
import java.util.List;

public class InputCalc {

    int result(String userInput) {
        List<Integer> numbersToMath = new ArrayList<>();
        int result = 0;
        boolean isException = false;
        String[] userInputArray = userInput.split("[+\\-/*]", 10);
        for (String splitString : userInputArray) {
            int number = Integer.parseInt(splitString.trim());
            numbersToMath.add(number);
        }
        for (int i = 0; i < numbersToMath.size(); i++) {
            if (userInput.contains("+")) {
                result += numbersToMath.get(i);
            } else if (userInput.contains("-")) {
                if (i == 0) {
                    result = numbersToMath.get(0);
                } else result -= numbersToMath.get(i);
            } else if (userInput.contains("*")) {
                if (i == 0) {
                    result = numbersToMath.get(0);
                } else result *= numbersToMath.get(i);
            } else if (userInput.contains("/")) {
                if (i == 0) {
                    result = numbersToMath.get(0);
                } else try {
                    result /= numbersToMath.get(i);
                } catch (ArithmeticException e) {
                    isException = true;
                }
            }
        }
        if (isException) {
            throw new ArithmeticException("Can't be divided by 0");
        }
        else return result;
    }
}
