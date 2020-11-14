fun main() {
    var arr = intArrayOf(1,0,1)
    duplicateZeros(arr)
    printArray(arr)
}

fun printArray(array: IntArray) = array.forEach {
    print("$it ")
}

fun duplicateZeros(arr: IntArray): Unit {
    var i = 0
    while (i < arr.size-1) {
        if (arr[i] == 0) {
            for (j in arr.size-1 downTo i+1) {
                arr[j] = arr[j-1]
            }
            arr[++i] = 0
        }
        i++
    }
}