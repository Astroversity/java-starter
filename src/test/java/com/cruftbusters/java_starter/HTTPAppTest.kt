package com.cruftbusters.java_starter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.mockk.every
import io.mockk.mockk

class HTTPAppTest : FunSpec({
    context("with embedded server") {
        withEmbeddedServer({ module() }) { httpClient ->
            test("http service should solve equation") {
                httpClient.get<String>("/") {
                    parameter("equation", "1+(2+(3+4))")
                } shouldBe "10"
            }
        }
    }
})