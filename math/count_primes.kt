fun main() {
    println(countPrimes(149))
    println(countPrimes_dp(149))
}

fun countPrimes(n: Int): Int {
    var primeCount = 0
    outer@ for (i in 2 until n) {
        if (i > 2) {
            val halfway = Math.sqrt(i.toDouble()).toInt()
            for (j in 2..halfway) {
                if (i % j == 0) {
                    continue@outer
                }
            }
        }
        primeCount++
    }
    return primeCount
}


fun countPrimes_dp(n: Int): Int {
    // input validation
    if (n <= 2) {
        return 0
    }

    // dp[i] is whether i is prime
    // default all to true, and disprove
    val dp = Array<Boolean>(n) { true }

    // base cases
    dp[0] = false
    dp[1] = false
    dp[2] = true

    // count the number of primes by marking false
    // all values > i that are the product of i
    var primeCount = 0
    for (i in 2 until n) {
        if (dp[i]) {
            primeCount++
            // don't need to check all values, just multiples of i
            // that are less than j
            for (j in i until n step i) {
                if (j > i && j % i == 0) {
                    dp[j] = false
                }
            }
        }
    }
    return primeCount
}