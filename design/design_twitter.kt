fun main()
{
    val twitter = Twitter()
    twitter.postTweet(1,5)
    println(twitter.getNewsFeed(1))
    twitter.follow(1,2)
    twitter.postTweet(2,6)
    println(twitter.getNewsFeed(1))
    twitter.unfollow(1,2)
    println(twitter.getNewsFeed(1))
}

class Twitter() {

    val tweetStream = mutableListOf<Int>()

    // userId -> [indexes into tweetStream]
    val tweetMap = mutableMapOf<Int, ArrayDeque<Int>>()
    // userId -> [userIds of followees]

    val followMap = mutableMapOf<Int, MutableSet<Int>>()

    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        tweetStream.add(tweetId)
        val tweets = tweetMap.getOrDefault(userId, ArrayDeque<Int>())
        tweets.addFirst(tweetStream.size - 1) // store the tweet's index in the stream
        tweetMap[userId] = tweets
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    fun getNewsFeed(userId: Int): List<Int> {

        // populate the feed with 10 most recent of user's own tweets
        val ownTweets = tweetMap.getOrDefault(userId, ArrayDeque<Int>()).toList<Int>()
        val feed = ownTweets.slice(0..Math.min(10, ownTweets.size)-1).toMutableList<Int>()

        // get each followee's tweets
        followMap.getOrDefault(userId, mutableSetOf<Int>()).forEach { f ->

            // add 10 most recent tweets to the feed
            val tweets = tweetMap.getOrDefault(f, ArrayDeque<Int>()).toList<Int>()
            feed.addAll( tweets.slice(0..Math.min(10, tweets.size)-1) )
        }

        // return most recent 10 in feed by mapping indices to tweets
        return feed.sortedDescending().slice(0..Math.min(10, feed.size)-1).map { tweetStream[it] }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        if (followerId == followeeId) {
            // no-op, since every user implicitly follows themself
            return
        }

        val followees = followMap.getOrDefault(followerId, mutableSetOf<Int>())
        if (followeeId !in followees) {
            followees.add(followeeId)
            followMap[followerId] = followees
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        val followees = followMap.getOrDefault(followerId, mutableSetOf<Int>())
        if (followeeId in followees) {
            followees.remove(followeeId)
            followMap[followerId] = followees
        }

    }
}