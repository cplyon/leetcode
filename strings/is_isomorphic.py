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
<<<<<<< HEAD

            if t[i] in t_letters and t_letters[t[i]] != s[i]:
                return False

            if s[i] in s_letters and s_letters[s[i]] != t[i]:
                return False

            t_letters[t[i]] = s[i]
            s_letters[s[i]] = t[i]
=======
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
>>>>>>> 199a70c03ce28dd23c1e7b2de3cc3279ef9cc4f6

        return True

if __name__ == "__main__":
    solution = Solution()
<<<<<<< HEAD
    s = "aa"
    t = "ab"
=======
    s = "ab"
    t = "aa"
>>>>>>> 199a70c03ce28dd23c1e7b2de3cc3279ef9cc4f6
    print(solution.isIsomorphic(s, t))
