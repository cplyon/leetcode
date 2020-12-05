fun main() {
    val s = Solution()
    val coins = intArrayOf(1,3,5,11,17)
    val amount = 21
    println(s.coinChange(coins, amount))
    println(s.coinChange_dp(coins, amount))

}

class Solution {

    fun coinChange_dp(coins: IntArray, amount: Int): Int {
        // Dynamic programming solution
        // O(n*m) where n = amount, m = coins.size
        if (coins.isEmpty() || amount < 0) {
            return -1
        }

        if (amount == 0) {
            return 0
        }

        // f(i) is the min number of coins to reach amount i
        val dp = IntArray(amount+1) {0}

        // base cases
        for (c in coins) {
            if (c < dp.size) {
                dp[c] = 1
            }
        }

        // f(i) = min(f(i-coins[0]), ..., f(i-coins[n])) + 1
        for (i in 2..amount) {
            var curMin = Int.MAX_VALUE
            for (c in coins) {

                // current coin is greater than the amount we're aiming for
                if (c > i) continue

                // if adding c to the last amount gets us at least to amount
                // then it's a candidate for the new minimum
                if ((dp[i-c]+1)*c >= i) {
                    curMin = minOf(curMin, dp[i-c])
                }
            }

            // if we found a new minimum, memoize it plus one
            if (curMin < Int.MAX_VALUE) {
                dp[i] = curMin + 1
            }
        }

        // return the last memoized item, or -1 if no coins can get us to amount
        return if (dp.last() > 0) dp.last() else -1
    }


    fun coinChange(coins: IntArray, amount: Int): Int {
        // O(n*m*k) - where n = amount, m = coins.size, k = number of unique sums of coins
        if (coins.isEmpty() || amount < 0) {
            return -1
        }

        if (amount == 0) {
            return 0
        }

        var prev = mutableSetOf<Int>(0)
        for (i in 1..amount) {
            var cur = mutableSetOf<Int>()
            for (j in prev) {
                for (c in coins) {
                    val curSum = j + c
                    if (curSum == amount) {
                        // we found the mininum number of coins!
                        return i
                    }
                    if (curSum < amount) {
                        cur.add(curSum)
                    }
                }
            }
            prev = cur
        }

        // cannot make amount out of coins
        return -1
    }
}