package com.cruftbusters.java_starter

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.slf4j.Logger
import java.lang.RuntimeException

class SolverControllerKtTest : FunSpec({
    val mockSolver = mockk<Solver>()
    val mockLogger = mockk<Logger>()
    embeddedServer(Netty, port = 8079) {
        solverController(
            mockSolver,
            mockLogger,
        )
    }.start()
    val httpClient = HttpClient {
        defaultRequest {
            url.protocol = URLProtocol.HTTP
            url.host = "localhost"
            url.port = 8079
        }
    }
    test("Testing Hello World!") {
        every { mockSolver.solve("1+1") } returns 2
        httpClient.get<String>("/") {
            parameter("equation", "1+1")
        } shouldBe "2"
    }
    test("Log Error") {
        val error = RuntimeException("oopsy whoopsy")
        every { mockSolver.solve("6*9") } throws error
        val someException = shouldThrow<ServerResponseException> {
            httpClient.get<Unit>("/") {
                parameter("equation", "6*9")
            }
        }
        someException.response.status.shouldBe(HttpStatusCode.InternalServerError)
        verify { mockLogger.error("There was an error while solving an equation", error) }
    }
})
