package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BiNodeTest {
    @Test
    void toStringWithJustToken() {
        Assertions.assertEquals("\n1", new BiNode() {{
            token = "1";
        }}.toString());
    }

    @Test
    void toStringWithLeftBiNode() {
        Assertions.assertEquals("\n 5\n* ", new BiNode() {{
            left = new BiNode() {{
                token = "*";
            }};
            token = "5";
        }}.toString());
    }

    @Test
    void toStringWithRightBiNode() {
        Assertions.assertEquals("\n& \n !", new BiNode() {{
            token = "&";
            right = new BiNode() {{
                token = "!";
            }};
        }}.toString());
    }

    @Test
    void toStringWithLeftAndRightBiNode() {
        Assertions.assertEquals("\n - \n6 9", new BiNode() {{
            left = new BiNode() {{
                token = "6";
            }};
            token = "-";
            right = new BiNode() {{
                token = "9";
            }};
        }}.toString());
    }

    @Test
    void toStringWithTreeDeeperThanOne() {
        Assertions.assertEquals("\n  - \n 6 9\n8   ", new BiNode() {{
            left = new BiNode() {{
                left = new BiNode() {{
                    token = "8";
                }};
                token = "6";
            }};
            token = "-";
            right = new BiNode() {{
                token = "9";
            }};
        }}.toString());
    }

    @Test
    void toStringWithTreeDeepOneLeft() {
        Assertions.assertEquals("\n  - \n6  9\n 8  ", new BiNode() {{
            left = new BiNode() {{
                right = new BiNode() {{
                    token = "8";
                }};
                token = "6";
            }};
            token = "-";
            right = new BiNode() {{
                token = "9";
            }};
        }}.toString());
    }

    @Test
    void toStringRightLeft() {
        Assertions.assertEquals("\n -  \n9  6\n  8 ", new BiNode() {{
            left = new BiNode() {{
                token = "9";
            }};
            token = "-";
            right = new BiNode() {{
                left = new BiNode() {{
                    token = "8";
                }};
                token = "6";
            }};
        }}.toString());
    }

    @Test
    void toStringWithRightRight() {
        Assertions.assertEquals("\n -  \n9 6 \n   8", new BiNode() {{
            left = new BiNode() {{
                token = "9";
            }};
            token = "-";
            right = new BiNode() {{
                right = new BiNode() {{
                    token = "8";
                }};
                token = "6";
            }};
        }}.toString());
    }
    @Test
    void toStringWithDoubleDeeg() {
        Assertions.assertEquals("\n  wasd          \n69    8008135   \n             420", new BiNode() {{
            left = new BiNode() {{
                token = "69";
            }};
            token = "wasd";
            right = new BiNode() {{
                right = new BiNode() {{
                    token = "420";
                }};
                token = "8008135";
            }};
        }}.toString());
    }
    @Test
    void emptyBiNode() {
        Assertions.assertEquals("Empty BiNode", new BiNode().toString());
    }
}
