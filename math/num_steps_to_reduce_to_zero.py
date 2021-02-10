#! /usr/bin/env python3

class Solution:
    def numberOfSteps(self, num: int) -> int:
        if num < 0:
            return -1

        count = 0
        while num > 0:
            if num % 2 == 0:
                num /= 2
            else:
                num -= 1
            count += 1

        return count


if __name__ == "__main__":
    s = Solution()
    num = 101
    print(s.numberOfSteps(num))
