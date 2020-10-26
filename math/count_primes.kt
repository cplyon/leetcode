fun main() {
    println(countPrimes(14))
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