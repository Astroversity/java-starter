package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracesTest{
    @Test
    void ReadValidCurlyBrace(){
         new BraceChecker(){{
            assertTrue(isValid("{}"));
            assertTrue(isValid("{{}}"));
        }};
    }
    @Test
    void ReadInvalidCurlyBrace() {
        new BraceChecker() {{
            assertFalse(isValid("}{"));
            assertFalse(isValid("{"));
            assertFalse(isValid("{{}"));
            assertFalse(isValid("}}}}}"));
        }};
    }
    @Test
    void ReadValidSquareBrace(){
         new BraceChecker(){{
            assertTrue(isValid("[]"));
            assertTrue(isValid("[[]]"));
        }};
    }
    @Test
    void ReadInvalidSquareBrace(){
         new BraceChecker(){{
            assertFalse(isValid("]["));
            assertFalse(isValid("["));
            assertFalse(isValid("[[]"));
            assertFalse(isValid("{{{]]]]]"));
        }};
    }
    @Test
    void ReadDifferingBrace(){
        new BraceChecker(){{
            assertFalse(isValid("{[][][][]][]}}"));
            assertFalse(isValid("{}}}[}[[[{{}{]]]{"));
            assertFalse(isValid("}]"));
            assertFalse(isValid("[}"));
            assertFalse(isValid("]}"));
            assertFalse(isValid("}}"));
            assertFalse(isValid("[[}"));
        }};
    }
    @Test
    void ReadDifferingBraceTwo(){
        new BraceChecker(){{
            assertFalse(isValid("{{]"));
        }};
    }
}
