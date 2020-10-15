fun main() {
    val matrix = arrayOf<IntArray>(
        intArrayOf(1,2,3,4),
        intArrayOf(5,6,7,8),
        intArrayOf(9,10,11,12),
        intArrayOf(13,14,15,16),
    )
    printMatrix(matrix)
    println()
    rotate(matrix)
    printMatrix(matrix)    
}

fun printMatrix(matrix: Array<IntArray>) {
    matrix.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }    
}

fun swap(matrix: Array<IntArray>, first: Pair<Int, Int>, second: Pair<Int, Int>) {
    val temp = matrix[first.first][first.second]
    matrix[first.first][first.second] = matrix[second.first][second.second]
    matrix[second.first][second.second] = temp
}

fun rotate(matrix: Array<IntArray>) {
    var n1 = matrix.size - 1
    var n2 = n1

    for (t1 in 0 until n1) {
        for (t2 in t1 until n1) {
            swap(matrix, Pair(t1, t2), Pair(t2, n1))
            swap(matrix, Pair(t1, t2), Pair(n1, n2))
            swap(matrix, Pair(t1, t2), Pair(n2, t1))
            n2--
        }
        n1--
        n2 = n1
    }
}