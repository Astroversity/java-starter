package com.cruftbusters.java_starter;

import java.util.List;

public class Subtractor {
    public List<String> subtract(List<String> someList, String StringToRemove) {
        someList.remove(StringToRemove);
        return someList;
    }
}
