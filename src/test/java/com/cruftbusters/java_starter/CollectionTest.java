package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionTest {
    @Test
    void subrtractList() {
        Subtractor subtractor = new Subtractor();
        List<String> someList = new ArrayList<>();
        someList.add("Put another string in there");
        someList.add("Make something up");
        List<String> expected = new ArrayList<>();
        expected.add("Put another string in there");
        assertEquals(expected, subtractor.subtract(someList, "Make something up"));
    }
}
