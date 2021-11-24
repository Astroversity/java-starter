package com.cruftbusters.java_starter;

public class InputCalc {

    int result(String userInput) {
        int result = 0;
        char operator = '+';
        for (char character : userInput.toCharArray()) {
            if ("0123456789".contains(Character.toString(character))) {
                int number = Character.getNumericValue(character);
                if (operator == '+') {
                    result += number;
                } else if (operator == '-') {
                    result -= number;
                } else if (operator == '*') {
                    result *= number;
                } else if (operator == '/') {
                    result /= number;
                }
            } else if ("+-*/".contains(Character.toString(character))) {
                operator = character;
            }
        }
        return result;
    }
}
