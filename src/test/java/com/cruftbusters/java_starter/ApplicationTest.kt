package com.cruftbusters.java_starter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.launch
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PipedInputStream
import java.io.PipedOutputStream

class ApplicationTest : FunSpec({
    test("Add Some Numbers") {
        val inputstream = ByteArrayInputStream("1+1".toByteArray())
        val outputstream = ByteArrayOutputStream()
        doTheWorkNow(inputstream, outputstream)
        outputstream.toString() shouldBe "2\n"
    }
    test("Two Lines") {
        val inputstream = ByteArrayInputStream("1+1\n2+2".toByteArray())
        val outputstream = ByteArrayOutputStream()
        doTheWorkNow(inputstream, outputstream)
        outputstream.toString() shouldBe "2\n4\n"
    }
    test("Stream i/o") {
        val inputSink = PipedOutputStream()
        val inputStream = PipedInputStream(inputSink)
        val outputSink = PipedOutputStream()
        val outputStream = PipedInputStream(outputSink)
        launch { doTheWorkNow(inputStream, outputSink) }
        inputSink.writer().use {
            it.write("1+1\n")
        }
        inputSink.close()
        outputStream.reader().use {
            it.read() shouldBe "2\n"
        }
    }
})