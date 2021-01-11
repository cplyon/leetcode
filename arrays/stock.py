#! /usr/bin/env python3

# Say you have an array for which the ith element is the price of a given
# stock on day i.
# If you were only permitted to complete at most one transaction
# (i.e., buy one and sell one share of the stock), design an algorithm to find
# the maximum profit.
# Note that you cannot sell a stock before you buy one.

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        if not prices:
            return 0

        buy = 0
        max_profit = -2**31
        for i in range(1, len(prices)):
            cur_profit = prices[i] - prices[buy]
            if cur_profit < 0:
                buy = i
            else:
                max_profit = max(max_profit, cur_profit)

        return max_profit if max_profit > 0 else 0


if __name__ == "__main__":
    s = Solution()
    prices = [7, 2, 0, 1, 6]
    print(s.maxProfit(prices))
