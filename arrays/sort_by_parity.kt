fun main() {

    val A = intArrayOf(2,3)
    printArray(sortArrayByParity(A))

}

fun printArray(array: IntArray) = array.forEach {
    print("$it ")
}

fun sortArrayByParity(A: IntArray): IntArray {
    var i = 0
    var j = A.size-1
    while (i < j) {
        if (A[i] % 2 != 0) {
            if (A[j] % 2 != 0) {
                j--
                continue
            } else {
                val temp = A[i]
                A[i] = A[j]
                A[j] = temp           
                j--
            }

        }
        i++
    }
    return A
}