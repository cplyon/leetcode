fun main()
{
    val twitter = Twitter()
    twitter.postTweet(1,5)
    println(twitter.getNewsFeed(1))
    twitter.follow(1,2)
    twitter.follow(1,2)
    twitter.postTweet(2,6)
    twitter.postTweet(2,10)
    twitter.postTweet(3,15)
    println(twitter.getNewsFeed(1))
    twitter.unfollow(1,2)
    twitter.unfollow(1,2)
    println(twitter.getNewsFeed(1))
}

class Twitter() {
    // list of all tweetIds, in the order they were posted
    val tweetStream = mutableListOf<Int>()
    // userId -> list of indices into tweetStream, most recent first
    val tweetMap = mutableMapOf<Int, ArrayDeque<Int>>()
    // userId -> Set of userIds of followees
    val followMap = mutableMapOf<Int, MutableSet<Int>>()

    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        tweetStream.add(tweetId)
        val tweetIndices = tweetMap.getOrDefault(userId, ArrayDeque<Int>())
        // store this tweet's index in the stream
        tweetIndices.addFirst(tweetStream.size - 1)
        tweetMap[userId] = tweetIndices
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    fun getNewsFeed(userId: Int): List<Int> {
        // populate the feed with 10 most recent of user's own tweets
        val ownTweetIndices = tweetMap.getOrDefault(userId, ArrayDeque<Int>()).toList<Int>()
        val feed = ownTweetIndices.slice(0..Math.min(10, ownTweetIndices.size)-1).toMutableList<Int>()

        // get each followee's tweets
        followMap.getOrDefault(userId, mutableSetOf<Int>()).forEach { f ->
            // add 10 most recent tweet indices to the feed
            val tweetIndices = tweetMap.getOrDefault(f, ArrayDeque<Int>()).toList<Int>()
            feed.addAll(tweetIndices.slice(0..Math.min(10, tweetIndices.size)-1))
        }

        // return most recent 10 in feed by mapping indices to actual tweets
        return feed.sortedDescending().slice(0..Math.min(10, feed.size)-1).map { tweetStream[it] }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        // every user implicitly follows themself
        if (followerId != followeeId) {
            val followees = followMap.getOrDefault(followerId, mutableSetOf<Int>())
            if (followees.add(followeeId)) {
                followMap[followerId] = followees
            }
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        val followees = followMap.getOrDefault(followerId, mutableSetOf<Int>())
        if (followees.remove(followeeId)) {
            followMap[followerId] = followees
        }
    }
}