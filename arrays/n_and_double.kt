fun main() {
    val arr = intArrayOf(-2,0,10,-19,4,6,-8)
    println(checkIfExist(arr))
}

fun checkIfExist(arr: IntArray): Boolean {
    for (i in arr.indices) {
        for (j in i+1..arr.size-1) {
            if ((arr[j] == arr[i]*2) || (arr[i]%2 == 0 && arr[j] == arr[i]/2)) {
                return true
            }
        }
    }
    return false
}