package com.cruftbusters.java_starter;

import com.google.errorprone.annotations.ForOverride;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InputCalc {

    int result(String userInput) {
        List<Integer> numbersToMath = new ArrayList<>();
        int result = 0;
        String[] userInputArray = userInput.split("[+\\-/*]", 10);
        for (String splitString : userInputArray) {
            int number = Integer.valueOf(splitString.trim());
            numbersToMath.add(number);
        }
        for (int i = 0; i < numbersToMath.size(); i++) {
            if (userInput.contains("+")) {
                result += numbersToMath.get(i);
            }
            else if (userInput.contains("-")) {
                if (i == numbersToMath.size() -1) {
                    result = -1*result;
                }
                result -= numbersToMath.get(i);
            }
            else if (userInput.contains("*")) {
                if (i == numbersToMath.size() -1) {
                    result = numbersToMath.get(0);
                }
                result *= numbersToMath.get(i);
            }
            else if (userInput.contains("/")) {
                if (i > 0)
                    if (numbersToMath.get(i) == 0) {
                        System.out.println("Undefined with division by 0");
                        break;
                    }
                if (i == numbersToMath.size() -1) {
                    result = numbersToMath.get(0);
                }
                result /= numbersToMath.get(i);
            }
        }
        return result;
    }
}
