package com.cruftbusters.java_starter

class Solver(
    private val tokenToTree: TokenToTree,
    private val treeSolver: TreeSolver,
) {
    fun solve(tokens: List<String>): Int {
        val tree = tokenToTree.parse(tokens)
        return treeSolver.result(tree)
    }
}