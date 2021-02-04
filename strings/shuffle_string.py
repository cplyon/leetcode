#! /usr/bin/env python3

class Solution:
    def restoreString(self, s: str, indices: list[int]) -> str:
        if not s or not indices or len(s) != len(indices):
            return s

        result = ["" for x in range(len(s))]
        for i, n in enumerate(indices):
            result[n] = s[i]

        return "".join(result)


if __name__ == "__main__":
    s = Solution()
    st = "abcd"
    indices = [3,2,1,0]
    print(s.restoreString(st, indices))
