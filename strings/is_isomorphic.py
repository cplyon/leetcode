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
            if t[i] not in t_letters:
                t_letters[t[i]] = s[i]
            else:
                if t_letters[t[i]] != s[i]:
                    return False

            if s[i] not in s_letters:
                s_letters[s[i]] = t[i]
            else:
                if s_letters[s[i]] != t[i]:
                    return False

        return True

if __name__ == "__main__":
    solution = Solution()
    s = "ab"
    t = "aa"
    print(solution.isIsomorphic(s, t))
