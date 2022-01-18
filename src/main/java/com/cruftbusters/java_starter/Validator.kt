package com.cruftbusters.java_starter

class Validator {
    fun validate(equation: String): String {
        var count = 0
        equation.forEach {
            if (it == '(') count++
            if (it == ')') count--
            if (count < 0) return "Invalid Parenthesis"
        }
        return if (count != 0) "Invalid Parenthesis" else ""
    }
}
