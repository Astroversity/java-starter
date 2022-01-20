package com.cruftbusters.java_starter;

import java.util.List;

public class TokenToTree {
    public BiNode parse(List<String> tokens) {
        TokenTreeBuilder tokenTreeBuilder = new TokenTreeBuilder();
        for (String token : tokens) {
            tokenTreeBuilder.push(token);
        }
        return tokenTreeBuilder.getRoot();
    }
}