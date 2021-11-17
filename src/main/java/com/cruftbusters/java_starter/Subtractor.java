package com.cruftbusters.java_starter;

import java.util.List;

public class Subtractor {
    public List<String> subtract(List<String> someList, List<String> stringsToRemove) {
        for (String stringToRemove : stringsToRemove) {
          someList.remove(stringToRemove);
        }
        return someList;
    }
}
