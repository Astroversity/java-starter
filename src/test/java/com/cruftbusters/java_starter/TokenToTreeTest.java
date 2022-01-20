package com.cruftbusters.java_starter;

import io.kotest.core.spec.style.AnnotationSpec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    void parseEmptyList() {
        new TokenToTree() {{
            BiNode biNode = parse(List.of());
            Assertions.assertEquals(
                    new BiNode(),
                    biNode
            );
        }};
    }

    @Test
    void parseParenthesis() {
        new TokenToTree() {{
            BiNode biNode = parse(Arrays.asList("1", "*", "(", "2", "+", "3", ")", "+", "4"));
            Assertions.assertEquals(
                    new BiNode() {{
                        left = new BiNode() {{
                            left = new BiNode() {{
                                token = "1";
                            }};
                            token = "*";
                            right = new BiNode() {
                                {
                                    left = new BiNode() {{
                                        token = "2";
                                    }};
                                    token = "+";
                                    right = new BiNode() {{
                                        token = "3";
                                    }};
                                }
                            };
                        }};
                        token = "+";
                        right = new BiNode() {{
                            token = "4";
                        }};
                    }},
                    biNode
            );
        }};
    }
    @Test
    void nestedParenthesis() {
        new TokenToTree() {{
            BiNode biNode = parse(Arrays.asList("1", "*", "(", "(", "2", "+", "3", ")", "+", "4", ")"));
            Assertions.assertEquals(
                    new BiNode() {{
                        left= new BiNode() {{
                            token = "1";
                        }};
                        token = "*";
                        right = new BiNode() {{
                            left = new BiNode() {{
                                    left = new BiNode() {{
                                        token = "2";
                                    }};
                                    token = "+";
                                    right = new BiNode() {{
                                        token = "3";
                                    }};
                                }};
                            token = "+";
                            right = new BiNode() {{
                                token = "4";
                            }};
                        }};
                    }},
                    biNode
            );
        }};
    }
    @Test
    void parseOneNumberThanOpenParenthesis() {
        new TokenToTree() {{
            BiNode biNode = parse(Arrays.asList("1", "(", "2", ")"));
            Assertions.assertEquals(
                    new BiNode() {{
                        left = new BiNode() {{
                            token = "1";
                        }};
                        token = "*";
                        right = new BiNode() {{
                            token = "2";
                        }};
                    }},
                    biNode
            );
        }};
    }

}
