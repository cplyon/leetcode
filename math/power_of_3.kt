fun main() {
    println(isPowerOfThree_recursive(9))
    println(isPowerOfThree_iterative(9))
}

fun isPowerOfThree_recursive(n: Int): Boolean {
    if (n <= 0) {
        return false
    }
    if (n == 1) {
        return true
    }
    if (n % 3 != 0) {
        return false
    }
    return isPowerOfThree_recursive(n/3)
}

fun isPowerOfThree_iterative(n: Int): Boolean {
    if (n <= 0) {
        return false
    }

    var m = n
    while (m > 1) {
        if (m % 3 != 0) {
            return false
        }
        m = m / 3
    }
    return true
}