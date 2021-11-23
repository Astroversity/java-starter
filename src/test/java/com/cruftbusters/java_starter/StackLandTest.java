package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackLandTest {
    @Test
    void Stack() {
        new Stack(){{
            add("Apples");
            add("Oranges");
        assertEquals("Oranges", peek());
        }};
    }
    @Test
    void Pop() {
        Stack stack = new Stack() {{
            add("Apples");
            add("Oranges");
        }};
        assertEquals("Oranges", stack.pop());
        assertEquals("Apples", stack.pop());
    }
    @Test
    void PopMore() {
        Stack stack = new Stack() {{
            add("Apples");
            add("Oranges");
        }};
        assertEquals("Oranges", stack.pop());
        assertEquals("Apples", stack.pop());
        Exception exception = Assertions.assertThrows(Exception.class, stack::pop);
        assertEquals("Ehh wrong", exception.getMessage());
    }
}
