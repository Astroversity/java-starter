package com.cruftbusters.java_starter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class ApplicationTest : FunSpec({
    test("Add Some Numbers") {
        val inputstream = ByteArrayInputStream("1+1".toByteArray())
        val outputstream = ByteArrayOutputStream()
        doTheWorkNow (inputstream, outputstream)
        outputstream.toString() shouldBe "2"
    }
    test("Two Lines") {
        val inputstream = ByteArrayInputStream("1+1\n2+2".toByteArray())
        val outputstream = ByteArrayOutputStream()
        doTheWorkNow (inputstream, outputstream)
        outputstream.toString() shouldBe "2\n4"
    }
})