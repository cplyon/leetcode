#! /usr/bin/env python3

class TweetCounts:

    def __init__(self):
        self.tweet_times = {}
        self.intervals = {
            "day": 60*60*24,
            "hour": 60*60,
            "minute": 60
        }

    def recordTweet(self, tweetName: str, time: int) -> None:
        if time < 0:
            return
        if tweetName not in self.tweet_times:
            self.tweet_times[tweetName] = []
        self.tweet_times[tweetName].append(time)

    def getTweetCountsPerFrequency(self, freq: str, tweetName: str, startTime: int, endTime: int) -> list[int]:
        if endTime < startTime or startTime < 0:
            return [0]

        if tweetName not in self.tweet_times or freq not in self.intervals:
            return [0]

        interval = self.intervals[freq]
        times = self.tweet_times[tweetName]
        result = [0] * ((endTime-startTime) // interval+1)
        for t in [x for x in times if startTime <= x <= endTime]:
            result[(t-startTime)//interval] += 1

        return result


if __name__ == "__main__":
    tc = TweetCounts()
    tc.recordTweet("t1", 0)
    tc.recordTweet("t1", 1000)
    tc.recordTweet("t1", 2000)
    tc.recordTweet("t1", 4000)
    print(tc.getTweetCountsPerFrequency("minute", "t1", 1000, 1001))
    print(tc.getTweetCountsPerFrequency("hour", "t1", 0, 5000))
    print(tc.getTweetCountsPerFrequency("day", "t1", 0, 5000))
