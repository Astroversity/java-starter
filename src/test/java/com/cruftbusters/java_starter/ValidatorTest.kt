package com.cruftbusters.java_starter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ValidatorTest : FunSpec({
    test("Valid Equation") {
        Validator().validate("(1+1)") shouldBe ""
    }
    test("Invalid Equation with One Opening Parenthesis") {
        Validator().validate("(1+1") shouldBe "Invalid Parenthesis"
    }
    test("Invalid Equation with Inverted Parenthesis") {
        Validator().validate(")1+1(") shouldBe "Invalid Parenthesis"
    }
    test("Invalid Equation with Two Openers") {
        Validator().validate("(1+1(") shouldBe "Invalid Parenthesis"
    }
})
