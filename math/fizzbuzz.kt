fun main() {
    println(fizzBuzz(100000))
}

fun fizzBuzz(n: Int): List<String> {
    val retVal = mutableListOf<String>()
    for (i in 1..n) {
        val result = 
            if (i % 3 == 0 && i % 5 == 0) {
                "FizzBuzz"
            } else if (i % 3 == 0) {
                "Fizz"
            } else if (i % 5 == 0) {
                "Buzz"
            } else {
                i.toString()
            }
        retVal.add(result)
    }
    return retVal
}