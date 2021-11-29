package com.cruftbusters.java_starter;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private final List<String> strings = new ArrayList<>();
    public void add(String string) {strings.add(string);}
    public String peek(){
        return strings.get(strings.size() - 1);
    }
    public String pop() {
        try {
        return strings.remove(strings.size() - 1);
    }
        catch(IndexOutOfBoundsException exception){
            throw new RuntimeException("Ehh wrong");
        }
    }
}
