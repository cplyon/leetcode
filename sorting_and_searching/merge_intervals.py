#! /usr/bin/env python3

# Given an array of intervals where intervals[i] = [start_i, end_i], merge all
# overlapping intervals, and return an array of the non-overlapping intervals
# that cover all the intervals in the input.
class Solution:
    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        # O(nlgn) - sort, then iterate, merging when needed
        if not intervals:
            return []

        intervals.sort(key=lambda x: x[0])
        merged = [intervals[0]]
        for interval in intervals[1:]:
            # check if the end of the last merged interval is greater or equal
            # to the current interval's beginning
            if merged[-1][1] >= interval[0]:
                # update the end of the last merged interval
                merged[-1][1] = max(merged[-1][1], interval[1])
            else:
                # add new interval
                merged.append(interval)
        return merged


if __name__ == "__main__":
    s = Solution()
    intervals = [[1,3],[2,6],[8,10],[15,18]]
    #intervals = [[1,4],[4,5]]
    print(s.merge(intervals))
