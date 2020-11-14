fun main() {
    val digits = intArrayOf(8,9,9)
    plusOne(digits).forEach {
        print(it)
    }
    println()
}

fun plusOne(digits: IntArray): IntArray {
    var index = digits.size - 1
    var carry = false
    while (index >= 0) {
        if (digits[index] != 9) {
            digits[index] = digits[index] + 1
            carry = false
            break
        }
        digits[index] = 0
        carry = true
        index--
    }

    if (carry) {
        val retArray = IntArray(digits.size + 1)
        retArray[0] = 1
        var i = 1
        digits.forEach {
            retArray[i] = it
            i++
        }
        return retArray
    }

    return digits
}