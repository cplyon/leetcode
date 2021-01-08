#! /usr/bin/env python3

class Solution:
    def maximumWealth(self, accounts: list[list[int]]) -> int:
        max_wealth = 0
        for customer in accounts:
            max_wealth = max(max_wealth, sum(customer))
        return max_wealth


if __name__ == "__main__":
    s = Solution()
    accounts = [[2, 8, 7], [7, 1, 3], [1, 9, 5]]
    print(s.maximumWealth(accounts))
