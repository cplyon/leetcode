#! /usr/bin/env python3

# Given a set of non-overlapping intervals,
# insert a new interval into the intervals (merge if necessary).
# You may assume that the intervals were initially sorted
# according to their start times.

class Solution:

    def insert(self, intervals: list[list[int]], newInterval: list[int]) -> list[list[int]]:
        if not intervals and not newInterval:
            return []
        if not intervals:
            return [newInterval]
        if not newInterval:
            return intervals

        result = []
        inserted = False

        # add newInterval at correct position
        for i in range(len(intervals)):
            interval = intervals[i]
            if newInterval[0] < interval[0]:
                inserted = True
                result.append(newInterval)
                result.extend(intervals[i:])
                break
            else:
                result.append(interval)
        if not inserted:
            result.append(newInterval)

        # merge intervals as appropriate
        i = 0
        while i < len(result)-1:
            cur = result[i]
            next = result[i+1]
            if cur[1] >= next[1]:
                # next is swallowed by cur
                del(result[i+1])
            elif cur[1] >= next[0]:
                # extend cur right
                cur[1] = next[1]
                del(result[i+1])
            else:
                i += 1
        return result


if __name__ == "__main__":
    s = Solution()
    intervals = [[1, 3], [6, 9]]
    newInterval = [2, 5]
    print(s.insert(intervals, newInterval))
