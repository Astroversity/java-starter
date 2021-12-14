package com.cruftbusters.java_starter

class Solver(
    private val tokenizer: Tokenizer,
    private val tokenToTree: TokenToTree,
    private val treeSolver: TreeSolver,
) {
    fun solve(string: String): Int {
        val tokens = tokenizer.stringToToken(string)
        val tree = tokenToTree.parse(tokens)
        return treeSolver.result(tree)
    }
}
