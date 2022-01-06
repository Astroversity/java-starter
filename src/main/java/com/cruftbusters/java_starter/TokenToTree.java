package com.cruftbusters.java_starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TokenToTree {
    public BiNode parse(List<String> tokens) {
        List<BiNode> nodes = new ArrayList<>();
        nodes.add(new BiNode());
        for (String token : tokens) {
            BiNode lastNode = nodes.get(nodes.size() - 1);
            if (Objects.equals(token, "(")) {
                nodes.add(new BiNode());
            } else if (lastNode.token == null) {
                lastNode.token = token;
            } else if (Objects.equals(token, ")")) {
                Append(nodes.get(nodes.size() - 2), lastNode);
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
        return nodes.get(0);
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
}