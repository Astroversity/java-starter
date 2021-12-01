package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntroToTreesTest {
    @Test
    void addAndGet1(){
        new LinkedList() {{
            add("Apples");
            Assertions.assertEquals("Apples", get(0));

        }};
    }
    @Test
    void addAndGet2(){
        new LinkedList() {{
            add("Apples");
            add("Oranges");
            Assertions.assertEquals("Apples", get(0));
            Assertions.assertEquals("Oranges", get(1));
        }};
    }
    @Test
    void addAndGet3(){
        new LinkedList() {{
            add("Apples");
            add("Oranges");
            add("Potatoes");
            Assertions.assertEquals("Apples", get(0));
            Assertions.assertEquals("Oranges", get(1));
            Assertions.assertEquals("Potatoes", get(2));
            get(3);
        }};
    }
}

//remove elements. add method for size and return size of list.