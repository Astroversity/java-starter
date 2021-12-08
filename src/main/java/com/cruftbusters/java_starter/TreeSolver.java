package com.cruftbusters.java_starter;

import java.util.Objects;

public class TreeSolver {

    int result(BiNode biNode) {
        if (isOperator(biNode.token)) {
            int left = result(biNode.left);
            int right = result(biNode.right);
            if (Objects.equals(biNode.token, "*")) {
                return left * right;
            }
            return left + right;
        }
        return Integer.parseInt(biNode.token);
    }

    private boolean isOperator(String token) {
        return Objects.equals(token, "*") || Objects.equals(token, "+");
    }
}