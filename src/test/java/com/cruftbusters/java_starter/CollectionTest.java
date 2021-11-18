package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionTest {
    @Test
    void subrtractList() {
        List<String> stringToRemove = new ArrayList<>(){{
            add("Make something up");
        }};
        Subtractor subtractor = new Subtractor();
        List<String> someList = new ArrayList<>(){{
            add("Put another string in there");
            add("Make something up");
        }};
        List<String> expected = new ArrayList<>(){{
            add("Put another string in there");
        }};
        assertEquals(expected, subtractor.subtract(someList, stringToRemove));
    }
    @Test
    void anotherList() {
        List<String> stringsToRemove = new ArrayList<>() {{
            add("Make something up");
            add("Put another string in there");
        }};
        Subtractor subtractor = new Subtractor();
        List<String> someList = new ArrayList<>() {{
            add("Put another string in there");
            add("Make something up");
            add("Here's another line");
        }};
        List<String> expected = new ArrayList<>() {{
            add("Here's another line");
        }};
        assertEquals(expected, subtractor.subtract(someList, stringsToRemove));
    }
}
