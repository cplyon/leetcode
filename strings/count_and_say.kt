fun main() {
    val n = 6
    println(countAndSay(n))
}


fun countAndSay(n: Int): String {
    if (n <= 1) {
        // base case
        return "1"
    }

    val result = countAndSay(n-1)

    var count = 1
    var newResult = ""
    for (i in 1..result.length-1) {
        if (result[i] != result[i-1]) {
            newResult += count.toString() + result[i-1]
            count = 1
        } else {
            count++
        }
    }
    return newResult + count.toString() + result.last()
}