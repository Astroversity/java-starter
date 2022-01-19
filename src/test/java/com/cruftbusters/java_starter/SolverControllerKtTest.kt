package com.cruftbusters.java_starter

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.request.*
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
    val mockLogger = mockk<Logger>(relaxUnitFun = true)
    val mockValidator = mockk<Validator>(relaxed = true)
    embeddedServer(Netty, port = 8079) {
        solverController(
            mockValidator,
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
    test("Valid Equation") {
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
    test("Describe Invalid Equation") {
        val error = "Invalid Parenthesis"
        every { mockValidator.validate("(1+7") } returns error
        val someException = shouldThrow<ClientRequestException> {
            httpClient.get<Unit>("/") {
                parameter("equation", "(1+7")
            }
        }
        someException.response.status.shouldBe(HttpStatusCode.BadRequest)
        someException.response.receive<String>() shouldBe error
    }
})
