#! /usr/bin/env python3

import random

class Solution2:
    # prefix array
    def __init__(self, w: list[int]):
        # O(n) time, O(n) extra space
        self.w = w
        self.prefix = []
        self.prefix.append(w[0])
        for i in range(1, len(self.w)):
            self.prefix.append(self.prefix[i-1]+self.w[i])

    def pickIndex1(self) -> int:
        # O(n) - linear scan
        target = self.prefix[-1] * random.random()
        for i, n in enumerate(self.prefix):
            if target < n:
                return i

    def pickIndex2(self) -> int:
        # O(nlgn) - binary search
        target = self.prefix[-1] * random.random()
        left = 0
        right = len(self.prefix)-1

        while left <= right:
            mid = (left + right) // 2
            if self.prefix[mid] == target:
                return mid
            if self.prefix[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return left


class Solution1:
    # extend the array to choose from proportional to the element weights
    # runtime: O(1) to pick index, O(n) to populate data structures
    # space: O(n) additional space (200*n)
    def __init__(self, w: list[int]):
        self.full_array = []
        s = sum(w)
        for i, n in enumerate(w):
            prob = int((n / s) * 100)
            if prob == 0:
                # round up when element weight makes up < 1%
                prob += 1
            # store a tuple of the proportional value and the original index
            self.full_array.extend([(n, i)] * prob)

    def pickIndex(self) -> int:
        r = random.randrange(len(self.full_array))
        # return the original index
        return self.full_array[r][1]


if __name__ == "__main__":
    w = [10, 5, 75]
    s1 = Solution1(w)
    print(s1.pickIndex())
    print(s1.pickIndex())
    print(s1.pickIndex())
    print(s1.pickIndex())
    print(s1.pickIndex())
    print(s1.pickIndex())

    s2 = Solution2(w)
    print(s2.pickIndex())
    print(s2.pickIndex())
    print(s2.pickIndex())
    print(s2.pickIndex())
    print(s2.pickIndex())
    print(s2.pickIndex())
