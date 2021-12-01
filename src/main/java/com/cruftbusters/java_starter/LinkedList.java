package com.cruftbusters.java_starter;

public class LinkedList {
    Node head;
    void add(String string) {
        if (head == null) {
            head = new Node();
            head.item = string;
        }
        else {
            head.next = new Node();
            head.next.item = string;
        }
    }
    String get(int i){
        if (i == 0) {
            return head.item;
        }
        return head.next.item;
    }
    private static class Node {
        String item;
        Node next;
    }
}
