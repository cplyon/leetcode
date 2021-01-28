#! /usr/bin/env python3

class Solution:
    def maxDepth(self, s: str) -> int:
        if not s:
            return 0

        depth = 0
        max_depth = 0
        for c in s:
            if c == "(":
                depth += 1
                max_depth = max(max_depth, depth)
            elif c == ")":
                depth -= 1

        return max_depth


if __name__ == "__main__":
    s = Solution()
    st = "(1+(2*3)+((8)/4))+1"
    print(s.maxDepth(st))
