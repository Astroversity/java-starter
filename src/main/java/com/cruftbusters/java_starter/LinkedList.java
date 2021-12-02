package com.cruftbusters.java_starter;

public class LinkedList {
    Node head;
    int size = 0;

    void add(String string) {
        if (head == null) {
            head = new Node();
            head.item = string;
            return;
        }
        for (Node current = head; ; current = current.next) {
            if (current.next == null) {
                current.next = new Node();
                current.next.item = string;
                size = size + 1;
                break;
            }
        }
    }

    String get(int i) {
        Node current = head;
        for (int j = 0; j < i; j++) {
            if (current.next == null) {
                throw new NullPointerException("Value for node has not been provided");
            }
            else current = current.next;
        }
        return current.item;
    }

    private static class Node {
        String item;
        Node next;
    }
}
