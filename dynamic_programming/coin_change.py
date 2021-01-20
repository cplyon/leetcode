#! /usr/bin/env python3

class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        if not coins or amount < 0:
            return -1

        if amount == 0:
            return 0

        coin_set = set(coins)
        # we can bail early if there is a coin that matches amount
        if amount in coin_set:
            return 1

        # memo[i] = minimum number of coins to make i
        # base case: 1 if there is a coin of value i
        memo = [1 if x in coin_set else 0 for x in range(amount+1)]

        for i in range(2, amount+1):
            cur_min = amount+1
            for c in coins:
                if c > i:
                    continue
                if (memo[i-c]+1)*c >= i:
                    cur_min = min(cur_min, memo[i-c])

            if cur_min < amount + 1:
                memo[i] = cur_min + 1

        return -1 if memo[-1] == 0 else memo[-1]

    def coinChange2(self, coins: list[int], amount: int) -> int:
        if not coins or amount < 0:
            return -1

        memo = [amount+1] * (amount+1)
        memo[0] = 0
        for c in coins:
            for i in range(c, amount+1):
                memo[i] = min(memo[i], memo[i-c]+1)

        if memo[-1] == amount+1:
            return -1
        return memo[-1]


if __name__ == "__main__":
    s = Solution()
    coins = [2, 5]
    amount = 3
    print(s.coinChange(coins, amount))
