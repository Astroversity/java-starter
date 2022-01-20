package com.cruftbusters.java_starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TokenTreeBuilder {
    private final List<BiNode> nodes = new ArrayList<>() {{
        add(new BiNode());
    }};

    public void push(String token) {
        BiNode lastNode = nodes.get(nodes.size() - 1);
        if (Objects.equals(token, "(")) {
            if (isNumber(rightMost(lastNode).token)) {
                push("*");
            }
            nodes.add(new BiNode());
        } else if (lastNode.token == null) {
            lastNode.token = token;
        } else if (Objects.equals(token, ")")) {
            BiNode secondToLast = nodes.get(nodes.size() - 2);
            Append(secondToLast, lastNode);
            nodes.remove(nodes.size() - 1);
        } else if (Objects.equals(token, "+") || lastNode.left == null) {
            BiNode newRoot = new BiNode();
            newRoot.left = lastNode;
            newRoot.token = token;
            nodes.set(nodes.size() - 1, newRoot);
        } else if (Objects.equals(token, "*")) {
            BiNode newRight = new BiNode();
            newRight.token = token;
            newRight.left = lastNode.right;
            lastNode.right = newRight;
        } else {
            BiNode newRight = new BiNode();
            newRight.token = token;
            Append(lastNode, newRight);
        }
    }

    private BiNode rightMost(BiNode lastNode) {
         if (lastNode.right == null) {
             return lastNode;
         } else return rightMost(lastNode.right);
    }

    private boolean isNumber(String token) {
        if (token == null) {
            return false;
        }
        return token.matches("[0-9]+");
    }

    private void Append(BiNode root, BiNode newRight) {
        if (root.left == null) {
            root.left = newRight;
        } else if (root.right == null) {
            root.right = newRight;
        } else {
            Append(root.right, newRight);
        }
    }

    public BiNode getRoot() {
        return nodes.get(0);
    }
}