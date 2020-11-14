fun main() {
    val A = intArrayOf(1,2,3)
    println(validMountainArray(A))
}

fun validMountainArray(A: IntArray): Boolean {
    if (A.size < 3) {
        return false
    }

    var ascending : Boolean? = null
    for (i in 0..A.size-2) {
        if (A[i] == A[i+1]) {
            return false
        }

        if (ascending == null) {
            if (A[i] > A[i+1]) {
                // started with the peak
                return false
            }
            ascending = true
        } else if (ascending) {
            if (A[i] > A[i+1]) {
                // reached the peak of the mountain
                ascending = false
            }
        } else {
            if (A[i] < A[i+1]) {
                // a second peak?
                return false
            }
        }

    }
    return if (ascending == null) false else !ascending
}