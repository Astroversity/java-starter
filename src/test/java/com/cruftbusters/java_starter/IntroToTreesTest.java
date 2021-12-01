package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntroToTreesTest {
    @Test
    void addAndGet(){
        new LinkedList() {{
            add("1");
            add("2");
            Assertions.assertEquals("1", get(0));
            Assertions.assertEquals("2", get(1));}};
    }
}
