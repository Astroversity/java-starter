package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TokenToTreeTest {
    @Test
    void parseOnePlusOne() {
        new TokenToTree() {{
            BiNode biNode = parse(Arrays.asList("1", "+", "1"));
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

    @Test
    void parseOnePlusOneTimesTwo() {
        new TokenToTree() {{
            BiNode biNode = parse(Arrays.asList("1", "+", "1", "*", "2"));
            Assertions.assertEquals(
                    new BiNode() {{
                        left = new BiNode() {{
                            token = "1";
                        }};
                        token = "+";
                        right = new BiNode() {{
                            left = new BiNode() {{
                                token = "1";
                            }};
                            token = "*";
                            right = new BiNode() {{
                                token = "2";
                            }};
                        }};
                    }},
                    biNode
            );
        }};
    }
    @Test
    void parseOnePlusOneTimesTwoVTwo() {
        new TokenToTree() {{
            BiNode biNode = parse(Arrays.asList("1", "*", "1", "+", "2"));
            Assertions.assertEquals(
                    new BiNode() {{
                        left = new BiNode() {{
                            left = new BiNode() {{
                                token = "1";
                            }};
                            token = "*";
                            right = new BiNode() {{
                                token = "1";
                            }};
                        }};
                        token = "+";
                        right = new BiNode() {{
                            token = "2";
                        }};
                    }},
                    biNode
            );
        }};
    }

}
