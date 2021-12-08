package com.cruftbusters.java_starter

import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class SolverTest {
    @Test
    fun `Solve for list of tokens`() {
        val someList = listOf("1", "+", "1")
        val solver = Solver(
            TokenToTree(),
            TreeSolver(),
        )
        val result = solver.solve(someList)
        Assertions.assertEquals(2, result)
    }
}
