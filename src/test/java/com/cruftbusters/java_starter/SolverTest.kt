package com.cruftbusters.java_starter

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class SolverTest {
    @Test
    fun `Solve for list of tokens`() {
        val solver = Solver(
            mockk{
                 every {stringToToken("1+1")} returns listOf("1","+","1")
            },
            TokenToTree(),
            TreeSolver(),
        )
        val result = solver.solve("1+1")
        Assertions.assertEquals(2, result)
    }
}

