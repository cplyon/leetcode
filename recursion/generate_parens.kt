fun main() {
    val s = Solution()
    val n = 4
    println(s.generateParenthesis(n))
    println(s.generateParenthesis2(n))
    println(s.generateParenthesis_recursive(n))
    println(s.generateParenthesis_recursive2(n))
}

// Given n pairs of parentheses,
// write a function to generate all combinations of well-formed parentheses.
class Solution {

    fun generateParenthesis(n: Int): List<String> {
        // iterative solution
        if (n == 0) {
            return emptyList()
        }

        var prevCombos = mutableSetOf<String>("()")
        for (i in 2..n) {
            val curCombos = mutableSetOf<String>()
            for (p in prevCombos) {
                var index = 0
                while (index < p.length) {
                    index = p.indexOf("()", index)
                    if (index < 0) break
                    curCombos.add(p.replaceRange(index, index+2, "()()").toString())
                    curCombos.add(p.replaceRange(index, index+2, "(())").toString())
                    index+=2
                }
            }
            prevCombos = curCombos
        }
        return prevCombos.toList()
    }

    fun generateParenthesis2(n: Int): List<String> {
        // iterative solution
        if (n == 0) {
            return emptyList()
        }

        var prevCombos = mutableSetOf<String>("()")
        for (i in 2..n) {
            val curCombos = mutableSetOf<String>()
            for (p in prevCombos) {
                for (j in 0..p.length) {
                    curCombos.add(p.substring(0, j) + "()" + p.substring(j))
                }
            }
            prevCombos = curCombos
        }
        return prevCombos.toList()
    }


    fun generateParenthesis_recursive(n: Int): List<String> {
        // recursive solution

        // base case: n = 0
        if (n == 0) {
            return emptyList()
        }

        // base case: n = 1
        if (n == 1) {
            return listOf("()")
        }

        // recursive case:
        // f(i) = f(i-1) -> where each "()" is replaced with "()()" and with "(())"
        val combos = mutableSetOf<String>()
        for (p in generateParenthesis(n-1)) {
            var index = 0
            while (index < p.length) {
                index = p.indexOf("()", index)
                if (index < 0) break
                combos.add(p.replaceRange(index, index+2, "()()").toString())
                combos.add(p.replaceRange(index, index+2, "(())").toString())
                index+=2
            }
        }
        return combos.toList()
    }

    fun generateParenthesis_recursive2(n: Int): List<String> {
        // recursive solution

        // base case: n = 0
        if (n == 0) {
            return emptyList()
        }

        // base case: n = 1
        if (n == 1) {
            return listOf("()")
        }

        // recursive case:
        // f(i) = f(i-1) -> where "()" is inserted at every position
        val combos = mutableSetOf<String>()
        for (p in generateParenthesis(n-1)) {
            for (j in 0..p.length) {
                combos.add(p.substring(0, j) + "()" + p.substring(j))
            }
        }
        return combos.toList()
    }
}