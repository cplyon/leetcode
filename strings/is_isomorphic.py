#! /usr/bin/env python3

class Solution:

    def isIsomorphic(self, s: str, t: str) -> bool:
        if not s and not t:
            return True
        if not s or not t:
            return False
        if len(s) != len(t):
            return False

        s_letters = {}
        t_letters = {}

        for i in range(len(s)):

            if t[i] in t_letters and t_letters[t[i]] != s[i]:
                return False

            if s[i] in s_letters and s_letters[s[i]] != t[i]:
                return False

            t_letters[t[i]] = s[i]
            s_letters[s[i]] = t[i]

        return True

if __name__ == "__main__":
    solution = Solution()
    s = "ab"
    t = "aa"
    print(solution.isIsomorphic(s, t))
