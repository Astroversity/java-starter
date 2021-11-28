package com.cruftbusters.java_starter;

import java.util.regex.Pattern;

public class BraceChecker {
    public boolean isValid(String braces) {
        int count = 0;
        // different opening combo
        if (braces.contains("{") && (braces.contains("["))) {
            return false;
        }
        // different closing combo
        if (braces.contains("}") && (braces.contains("]"))) {
            return false;
        }
        // different pair combo 1
        if (braces.contains("{") && (braces.contains("]"))) {
            return false;
        }
        // different pair combo 2
        if (braces.contains("[") && (braces.contains("}"))) {
            return false;
        }
        for (char brace : braces.toCharArray()) {
            if (brace == '{'|| brace == '[') {
                count++;
            }
            if (brace == '}' || brace == ']') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
