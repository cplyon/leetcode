#! /usr/bin/env python3

# Given two equal-size strings s and t. In one step you can choose any
# character of t and replace it with another character.
# Return the minimum number of steps to make t an anagram of s.
# An Anagram of a string is a string that contains the same characters
# with a different (or the same) ordering.

class Solution:
    def minSteps(self, s: str, t: str) -> int:
        # O(n) + O(n) = O(n)
        if not s or not t:
            return 0
        if len(s) != len(t):
            return 0

        count = 0
        t_counts = {}
        for c in t:
            if c not in t_counts:
                t_counts[c] = 0
            t_counts[c] += 1

        for c in s:
            if c not in t_counts or t_counts[c] == 0:
                count += 1
            else:
                t_counts[c] -= 1

        return count


if __name__ == "__main__":
    solution = Solution()
    s = "bab"
    t = "aba"
    print(solution.minSteps(s, t))
