package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntroToTreesTest {
    @Test
    void addAndGet1(){
        new LinkedList() {{
            add("1");
            Assertions.assertEquals("1", get(0));

        }};
    }
    @Test
    void addAndGet2(){
        new LinkedList() {{
            add("1");
            add("2");
            Assertions.assertEquals("1", get(0));
            Assertions.assertEquals("2", get(1));
        }};
    }
    @Test
    void addAndGet3(){
        new LinkedList() {{
            add("1");
            add("2");
            add("3");
            Assertions.assertEquals("1", get(0));
            Assertions.assertEquals("2", get(1));
            Assertions.assertEquals("3", get(2));
        }};
    }
}
