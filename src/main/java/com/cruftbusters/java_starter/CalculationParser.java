package com.cruftbusters.java_starter;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

public class CalculationParser {
    BiNode parse(List<String> tokens) {
        BiNode root = null;
        for (String token : tokens) {
            if (root == null) {
                root = new BiNode();
                root.token = token;
            } else if (Objects.equals(token, "*")) {
                BiNode newRight = new BiNode();
                newRight.token = token;
                newRight.left = root.right;
                root.right = newRight;
            } else if (Objects.equals(token, "+")) {
                BiNode newRoot = new BiNode();
                newRoot.left = root;
                newRoot.token = token;
                root = newRoot;
            } else if (root.right == null ){
                root.right = new BiNode();
                root.right.token = token;
            } else {
                root.right.right = new BiNode();
                root.right.right.token = token;
            }
        }
        return root;
    }
}

@EqualsAndHashCode
@ToString
class BiNode {
    BiNode left;
    String token;
    BiNode right;
}
