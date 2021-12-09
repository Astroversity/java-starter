package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeSolverTest {
    @Test
    void AdditionWithBiNode() {
        new TreeSolver() {{
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
        new TreeSolver() {{
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
        new TreeSolver() {{
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
        new TreeSolver() {{
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
        new TreeSolver() {{
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
        new TreeSolver() {{
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

    @Test
    void EmptyBiNode() {
        new TreeSolver() {{
            Assertions.assertEquals(42, result(
                    new BiNode()
            ));
        }};
    }
}