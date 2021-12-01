package com.cruftbusters.java_starter;

public class LinkedList {
    Node head;
    void add(String string) {
        if (head == null) {
            head = new Node();
            head.item = string;
        }
        else if (head.next == null){
            head.next = new Node();
            head.next.item = string;
        }
        else {
            head.next.next = new Node();
            head.next.next.item = string;
        }
    }
    String get(int i){
        Node current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current.item;
    }
    private static class Node {
        String item;
        Node next;
    }
}
