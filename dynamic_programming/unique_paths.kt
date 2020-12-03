fun main() {
    val s = Solution()
    val m = 5
    val n = 5
    println(s.uniquePaths_recursive(m, n))
    println(s.uniquePaths(m, n))
}

class Solution {

    fun uniquePaths(m: Int, n: Int): Int {
        // dynamic programming solution

        // f(i,j) is the number of ways to get to cell i,j from 0,0

        // initialize base cases
        val dp = Array(m) {
            IntArray(n) { 1 }
        }

        // recurrence relation:
        // f(i,j) = f(i-1, j) + f(i, j-1)
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }
        }

        return dp[m-1][n-1]

    }


    fun uniquePaths_recursive(m: Int, n: Int): Int {
        // recursive solution
        if (m == 1 && n == 1) {
            return 1
        }

        if (m == 1) {
            return uniquePaths_recursive(m, n-1)
        }

        if (n == 1) {
            return uniquePaths_recursive(m-1, n)
        }

        return uniquePaths_recursive(m-1, n) + uniquePaths_recursive(m, n-1)
    }
}