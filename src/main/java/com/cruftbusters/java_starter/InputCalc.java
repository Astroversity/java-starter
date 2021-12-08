package com.cruftbusters.java_starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputCalc {

    int result(BiNode biNode) {
        if (isOperator(biNode.token)) {
            int left = result(biNode.left);
            int right = result(biNode.right);
            if (Objects.equals(biNode.token, "*")) {
                return left * right;
            }
            return left + right;
        }
        return Integer.parseInt(biNode.token);
    }

    private boolean isOperator(String token) {
        return Objects.equals(token, "*") || Objects.equals(token, "+");
    }

    int result(String userInput) {
        List<Integer> numbersToMath = new ArrayList<>();
        int result = 0;
        String[] userInputArray = userInput.split("[+\\-/*]");
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
                    throw new ArithmeticException("Can't be divided by 0");
                }
            }
        }
        return result;
    }
}
