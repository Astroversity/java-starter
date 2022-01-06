package com.cruftbusters.java_starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TokenToTree {
    public BiNode parse(List<String> tokens) {
        List<BiNode> nodes = new ArrayList<>();
        nodes.add(new BiNode());
        for (String token : tokens) {
            if (nodes.size()>1) {
                if (nodes.get(1).token == null) {
                    nodes.get(1).token = token;
                } else if (Objects.equals(token, ")")) {
                    Append(nodes.get(0), nodes.get(1));
                    nodes.remove(1);
                } else if (Objects.equals(token, "+") || nodes.get(1).left == null) {
                    BiNode newRoot = new BiNode();
                    newRoot.left = nodes.get(1);
                    newRoot.token = token;
                    nodes.set(1, newRoot);
                } else if (Objects.equals(token, "*")) {
                    BiNode newRight = new BiNode();
                    newRight.token = token;
                    newRight.left = nodes.get(1).right;
                    nodes.get(1).right = newRight;
                } else {
                    BiNode newRight = new BiNode();
                    newRight.token = token;
                    Append(nodes.get(1), newRight);
                }
            } else {
                if (nodes.get(0).token == null) {
                    nodes.get(0).token = token;
                } else if (Objects.equals(token, "(")) {
                    nodes.add(new BiNode());
                } else if (Objects.equals(token, "+") || nodes.get(0).left == null) {
                    BiNode newRoot = new BiNode();
                    newRoot.left = nodes.get(0);
                    newRoot.token = token;
                    nodes.set(0, newRoot);
                } else if (Objects.equals(token, "*")) {
                    BiNode newRight = new BiNode();
                    newRight.token = token;
                    newRight.left = nodes.get(0).right;
                    nodes.get(0).right = newRight;
                } else {
                    BiNode newRight = new BiNode();
                    newRight.token = token;
                    Append(nodes.get(0), newRight);
                }
            }
        }
        return nodes.get(0);
    }

    private void Append(BiNode root, BiNode newRight) {
        if (root.right == null) {
            root.right = newRight;
        } else {
            Append(root.right, newRight);
        }
    }
}