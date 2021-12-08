package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputCalcTest {
    @Test
    void AdditionWithBiNode() {
        new InputCalc() {{
            Assertions.assertEquals(2, result(
                    new BiNode() {{
                        left = new BiNode() {{
                            token = "1";
                        }};
                        token = "+";
                        right = new BiNode() {{
                            token = "1";
                        }};
                    }}
            ));
        }};
    }

    @Test
    void TimesWithBiNode() {
        new InputCalc() {{
            Assertions.assertEquals(3, result(
                    new BiNode() {{
                        left = new BiNode() {{
                            token = "3";
                        }};
                        token = "*";
                        right = new BiNode() {{
                            token = "1";
                        }};
                    }}
            ));
        }};
    }

    @Test
    void PlusAndTimesLeftSubTree() {
        new InputCalc() {{
            Assertions.assertEquals(3, result(
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
                    }}
            ));
        }};
    }

    @Test
    void TwoSubTrees() {
        new InputCalc() {{
            Assertions.assertEquals(3, result(
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
                            left = new BiNode() {{
                                token = "1";
                            }};
                            token = "+";
                            right = new BiNode() {{
                                token = "1";
                            }};
                        }};
                    }}
            ));
        }};
    }

    @Test
    void PlusAndTimesRightSubTree() {
        new InputCalc() {{
            Assertions.assertEquals(3, result(
                    new BiNode() {{
                        left = new BiNode() {{
                            token = "2";
                        }};
                        token = "+";
                        right = new BiNode() {{
                            left = new BiNode() {{
                                token = "1";
                            }};
                            token = "*";
                            right = new BiNode() {{
                                token = "1";
                            }};
                        }};
                    }}
            ));
        }};
    }

    @Test
    void PlusAndPlusRightSubTree() {
        new InputCalc() {{
            Assertions.assertEquals(4, result(
                    new BiNode() {{
                        left = new BiNode() {{
                            token = "2";
                        }};
                        token = "+";
                        right = new BiNode() {{
                            left = new BiNode() {{
                                token = "1";
                            }};
                            token = "+";
                            right = new BiNode() {{
                                token = "1";
                            }};
                        }};
                    }}
            ));
        }};
    }
}