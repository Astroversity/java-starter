package com.cruftbusters.java_starter;

import java.util.List;
import java.util.Objects;

public class TokenToTree {
    public BiNode parse(List<String> tokens) {
        BiNode root = new BiNode();
        for (String token : tokens) {
            if (root.token == null) {
                root.token = token;
            } else if (Objects.equals(token, "+") || root.left == null) {
                BiNode newRoot = new BiNode();
                newRoot.left = root;
                newRoot.token = token;
                root = newRoot;
            } else if (Objects.equals(token, "*")) {
                BiNode newRight = new BiNode();
                newRight.token = token;
                newRight.left = root.right;
                root.right = newRight;
            } else {
                BiNode newRight = new BiNode();
                newRight.token = token;
                Append(root, newRight);
            }
        }
        return root;
    }

    private void Append(BiNode root, BiNode newRight) {
        if (root.right == null) {
            root.right = newRight;
        } else {
            Append(root.right, newRight);
        }
    }
}