fun main() {
    val tc = TweetCounts()
    tc.recordTweet("a", 27)
    println(tc.getTweetCountsPerFrequency("hour", "a", 27, 5573))
}


class TweetCounts() {

    val tweetMap = HashMap<String, MutableList<Int>>()
    val intervals = mapOf("minute" to 60, "hour" to 60*60, "day" to 60*60*24)

    fun recordTweet(tweetName: String, time: Int) {
        tweetMap.getOrPut(tweetName, { mutableListOf<Int>() }).add(time)
    }

    fun getTweetCountsPerFrequency(freq: String, tweetName: String, startTime: Int, endTime: Int): List<Int> {
        val interval = intervals.getOrElse(freq, {
                // invalid freq, bail out now
                return listOf<Int>()
            })
        val numTimeUnits = (endTime - startTime) / interval + 1
        val frequencies = MutableList<Int>(numTimeUnits, {0})
        tweetMap[tweetName]?.let { times ->
            for (t in times) {
                if (t >= startTime && t <= endTime) {
                    val index = (t - startTime) / interval
                    frequencies[index]++
                }
            }
        }
        return frequencies
    }

}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * var obj = TweetCounts()
 * obj.recordTweet(tweetName,time)
 * var param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime)
 */