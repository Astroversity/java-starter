package com.cruftbusters.java_starter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PipedInputStream
import java.io.PipedOutputStream
import kotlin.time.Duration.Companion.seconds

class CommandLineAppTest : FunSpec({
    test("Add Some Numbers") {
        val inputStream = ByteArrayInputStream("1+1".toByteArray())
        val outputStream = ByteArrayOutputStream()
        commandLineApplication(inputStream, outputStream)
        outputStream.toString() shouldBe "2\n"
    }
    test("Two Lines") {
        val inputStream = ByteArrayInputStream("1+1\n2+2".toByteArray())
        val outputStream = ByteArrayOutputStream()
        commandLineApplication(inputStream, outputStream)
        outputStream.toString() shouldBe "2\n4\n"
    }
    test("Stream i/o").config(blockingTest = true, timeout = 1.seconds) {
        val inputSink = PipedOutputStream()
        val inputStream = PipedInputStream(inputSink)
        val outputSink = PipedOutputStream()
        val outputStream = PipedInputStream(outputSink)
        GlobalScope.launch { commandLineApplication(inputStream, outputSink) }
        inputSink.writer().use { writer ->
            outputStream.bufferedReader().use { reader ->
                writer.appendLine("1+1")
                writer.flush()
                reader.readLine() shouldBe "2"
                writer.appendLine("2+2")
                writer.flush()
                reader.readLine() shouldBe "4"
            }
        }
    }
    test("Empty Bitch") {
        val inputSink = PipedOutputStream()
        val inputStream = PipedInputStream(inputSink)
        val outputSink = PipedOutputStream()
        val outputStream = PipedInputStream(outputSink)
        GlobalScope.launch { commandLineApplication(inputStream, outputSink) }
        inputSink.writer().use { writer ->
            outputStream.bufferedReader().use { reader ->
                writer.appendLine("1+1")
                writer.flush()
                reader.readLine() shouldBe "2"
                writer.appendLine("")
                writer.flush()
                reader.readLine() shouldBe "Input must be an equation."
                writer.appendLine("1+3")
                writer.flush()
                reader.readLine() shouldBe "4"
            }
        }
    }
})