package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CalculationParserTest {
    @Test
    void parseOnePlusOne() {
        new CalculationParser() {{
            BiNode biNode = parse(Arrays.asList("1","+","1"));
            Assertions.assertEquals(
                    new BiNode() {{
                        left = new BiNode() {{
                            token = "1";
                        }};
                        token = "+";
                        right = new BiNode() {{
                            token = "1";
                        }};
                    }},
                    biNode
            );
        }};
    }
}
