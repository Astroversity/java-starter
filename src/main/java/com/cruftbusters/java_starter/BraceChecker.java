package com.cruftbusters.java_starter;

import java.util.regex.Pattern;

public class BraceChecker {
    public boolean isValid(String braces) {
        int count = 0;
        for (char brace : braces.toCharArray()) {
            if (brace == '{'||brace == '[') {
                count++;
            }
            if (brace == '}'||brace == ']') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
