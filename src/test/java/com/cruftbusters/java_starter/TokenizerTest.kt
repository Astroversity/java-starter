package com.cruftbusters.java_starter

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TokenizerTest {
    @Test
    fun `Takes String to Token`() {
        Tokenizer().stringToToken("1+1") shouldBe listOf("1", "+", "1")
    }
    @Test
    fun `Takes double digits to Token`() {
        Tokenizer().stringToToken("12+13") shouldBe listOf("12", "+", "13")
    }
    @Test
    fun `Takes multiple operators to Token`() {
        Tokenizer().stringToToken("2-1*3/4") shouldBe listOf("2", "-", "1", "*", "3", "/", "4")
    }
    @Test
    fun `Takes spaces to Token`() {
        Tokenizer().stringToToken("2    - 1* 3/   4") shouldBe listOf("2", "-", "1", "*", "3", "/", "4")
    }
    @Test
    fun `Takes Parenthesis`() {
        Tokenizer().stringToToken("(2(*3)") shouldBe listOf("(", "2", "(", "*", "3", ")")
    }
}