import java.math.BigInteger

fun main() {
    val s = "2147483648"
    println(myAtoi2(s))
}

fun myAtoi(s: String): Int {

    var retVal = 0.toBigInteger()
    var isNegative = false
    var parsingNumber = false

    for (c in s) { 
        if (!parsingNumber) {
            if (c == ' ') {
                // skip to end of whitespace
                continue
            } else if (c == '-') {
                // found the first negative sign
                isNegative = true
                parsingNumber = true
                continue
            } else if (c == '+') {
                // found the first positive sign                
                parsingNumber = true
                continue                
            } else if (c.isDigit()) {
                // found the first digit a number
                parsingNumber = true
            } else {
                // encountered a non-numeric character before a numeric one
                // abort!
                break
            }
        }
        if (parsingNumber) {
            if (c.isDigit()) {
                // valid digit
                // shift current number left and add the digit
                retVal = (retVal * 10.toBigInteger()) + BigInteger(c.toString())
            } else {
                // encountered a non-numeric character
                // abort loop!
                break
            }
        }
    }

    if (isNegative) {
        // flip the sign
        retVal = -retVal
    }

    // truncate to an int
    if (retVal >= Integer.MAX_VALUE.toBigInteger()) {
        return Integer.MAX_VALUE
    }
    if (retVal <= Integer.MIN_VALUE.toBigInteger()) {
        return Integer.MIN_VALUE
    }

    // return as an int
    return retVal.toInt()
}


fun myAtoi2(s: String): Int {

    var retVal = 0
    var isNegative = false
    var parsingNumber = false

    for (c in s) { 
        if (!parsingNumber) {
            if (c == ' ') {
                // skip to end of whitespace
                continue
            } else if (c == '-') {
                // found the first negative sign
                isNegative = true
                parsingNumber = true
                continue
            } else if (c == '+') {
                // found the first positive sign                
                parsingNumber = true
                continue                
            } else if (c.isDigit()) {
                // found the first digit a number
                parsingNumber = true
            } else {
                // encountered a non-numeric character before a numeric one
                // abort!
                break
            }
        }
        if (parsingNumber) {
            if (c.isDigit()) {
                // valid digit
                // shift current number left and add the digit
                val sum : Long = (retVal * 10L) + c.toString().toLong()
                if (sum > Int.MAX_VALUE) {
                    // too big for an int
                    if (isNegative) {
                        return Int.MIN_VALUE
                    }
                    return Int.MAX_VALUE
                }
                retVal = sum.toInt()
            } else {
                // encountered a non-numeric character
                // abort loop!
                break
            }
        }
    }

    if (isNegative) {
        // flip the sign
        retVal = -retVal
    }

    return retVal
}