fun main() {
    val arr = intArrayOf(17,18,5,4,6,1)
    printArray(replaceElements2(arr))
}

fun printArray(array: IntArray) = array.forEach {
    print("$it ")
}

fun replaceElements(arr: IntArray): IntArray {
    if (arr.size == 0) {
        return arr
    }

    for (i in arr.indices) {
        var max = Int.MIN_VALUE
        for (j in i+1..arr.size-1) {
            if (arr[j] > max) {
                max = arr[j]
            }
        }
        arr[i] = max
    }
    arr[arr.size-1] = -1

    return arr
}

fun replaceElements2(arr: IntArray): IntArray {
    for (i in arr.indices) {
        arr[i] = arr.sliceArray(i+1..arr.size-1).maxOrNull() ?: 0
    }
    if (arr.size > 0) {
        arr[arr.size-1] = -1
    }   
    return arr
}