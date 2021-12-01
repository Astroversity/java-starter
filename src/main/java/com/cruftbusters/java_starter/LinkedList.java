package com.cruftbusters.java_starter;

public class LinkedList {
    Node head;
    void add(String string) {
        if (head == null) {
            head = new Node();
            head.item = string;
            return;
        }
        for (Node current = head;;current = current.next){
            if (current.next == null) {
                current.next = new Node();
                current.next.item = string;
                break;
            }
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
