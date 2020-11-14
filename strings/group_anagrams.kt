fun main()
{
    val s = Solution()
    val strs = arrayOf<String>("abc", "cba", "ghi")
    println(s.groupAnagrams(strs))
}


class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val map = mutableMapOf<String, MutableList<String>>().withDefault( { mutableListOf<String>() } )
        for (s in strs) {
            val sorted = String(s.toCharArray().apply { sort() })
            val anagrams = map.getValue(sorted)
            anagrams.add(s)
            map.put(sorted, anagrams)
        }

        return map.values.toList()
    }
}