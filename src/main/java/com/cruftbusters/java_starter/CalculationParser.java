package com.cruftbusters.java_starter;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

public class CalculationParser {
    BiNode parse(List<String> tokens) {
        return new BiNode() {{
            left = new BiNode() {{
                token = tokens.get(0);
            }};
            token = tokens.get(1);
            right = new BiNode() {{
                token = tokens.get(2);
            }};
        }};
    }
}
@EqualsAndHashCode
@ToString
class BiNode {
    BiNode left;
    String token;
    BiNode right;
}
