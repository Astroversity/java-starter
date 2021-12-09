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
fun main (args:Array<String>) {
    while (true) {
        val result = Solver(
            Tokenizer(),
            TokenToTree(),
            TreeSolver(),
        )
            .solve(readLine()!!)
        println(result)
    }
}
