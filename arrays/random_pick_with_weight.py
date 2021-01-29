#! /usr/bin/env python3

from random import randrange


class Solution1:
    # extend the array to choose from proportional to the element weights
    # runtime: O(1) to pick index, O(n) to populate data structures
    # space: O(n) additional space
    def __init__(self, w: list[int]):

        self.full_array = []
        self.map = {}
        s = sum(w)
        for i, n in enumerate(w):
            prob = int((n / s) * 100)
            if prob == 0:
                # round up when element weight makes up < 1%
                prob += 1
            start = len(self.full_array)
            self.full_array.extend([n] * prob)
            for j in range(start, len(self.full_array)):
                self.map[j] = i

    def pickIndex(self) -> int:
        r = randrange(len(self.full_array))
        return self.map[r]


if __name__ == "__main__":
    w = [10, 5, 75]
    s1 = Solution1(w)
    print(s1.pickIndex())
    print(s1.pickIndex())
    print(s1.pickIndex())
    print(s1.pickIndex())
    print(s1.pickIndex())
    print(s1.pickIndex())
