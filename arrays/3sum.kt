fun main() {
    val s = Solution()
    val nums = intArrayOf(1,-1,2,-1)
    println(s.threeSum(nums))

}

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {

        if (nums.size < 3) {
            return emptyList<List<Int>>()
        }

        val returnList = mutableListOf<List<Int>>()

        // separate the neg and pos numbers, and count the zeroes
        val negatives = mutableListOf<Int>()
        val positives = mutableListOf<Int>()
        var numZeroes = 0
        for (n in nums) {
            when {
                n < 0 -> negatives.add(n)
                n > 0 -> positives.add(n)
                else -> numZeroes++
            }
        }

        // handle the zeroes
        if (numZeroes > 0) {
            // if we have 3 or more zeroes, add [0,0,0]
            if (numZeroes >=3 ) {
                returnList.add(listOf<Int>(0,0,0))
            }
            // since we have at least one zero, we can just see if there are any
            // negs that equal -pos
            for (n in negatives) {
                if (-n in positives) {
                    returnList.add(listOf<Int>(n,0,-n))
                }
            }
        }

        // a + b + c = 0
        // a + b = -c

        // we only need to check that two positives + one negative equal zero
        // and two negatives + one positive equal zero
        returnList.addAll(TwoSum(positives, negatives))
        returnList.addAll(TwoSum(negatives, positives))

        return returnList.distinct()
    }

    fun TwoSum(targets: List<Int>, values: List<Int>) : List<List<Int>> {

        val returnList = mutableListOf<List<Int>>()
        for (i in 0..targets.size-1) {
            val target = -targets[i]
            val map = mutableMapOf<Int, Int>()
            values.forEach {
                map.put(it, target-it)
            }

            var duped = false
            for (v in values) {
                if (v == target-v && !duped) {
                    duped = true
                    continue
                }

                if (map.contains(target-v)) {
                    val result = mutableListOf<Int>(v, target-v, -target)
                    result.sort()
                    returnList.add(result)
                }
            }
        }
        return returnList

    }

}