fun main() {
    val nums1 = intArrayOf(1,2,3,0,0,0)
    val nums2 = intArrayOf(2,5,6)
    merge(nums1, 1, nums2, 1)
    printArray(nums1)
}

fun printArray(array: IntArray) = array.forEach {
    print("$it ")
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

    val retArray = IntArray(m+n)
    var i = 0
    var j = 0
    var k = 0
    while (i < m && j < n) {
        if (nums1[i] <= nums2[j]) {
            retArray[k] = nums1[i]
            i++
        } else {
            retArray[k] = nums2[j]
            j++
        }
        k++
    }
    while (i < m) {
        retArray[k] = nums1[i]
        i++        
        k++
    }
    while (j < n) {
        retArray[k] = nums2[j]
        j++     
        k++   
    }    

    for (x in retArray.indices) {
        nums1[x] = retArray[x]
    }
}