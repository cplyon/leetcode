#! /usr/bin/env python3

class Solution:

    def __init__(self):
        self.memo = {}
        self.costs = None

    def minCost(self, costs: list[list[int]]) -> int:
        if not costs:
            return 0

        self.costs = costs
        return min(self.paint_cost(0, 0),
                   self.paint_cost(0, 1),
                   self.paint_cost(0, 2))

    def paint_cost(self, n: int, color: int) -> int:
        if (n, color) in self.memo:
            return self.memo[(n, color)]

        cost = self.costs[n][color]
        if n < len(self.costs)-1:
            if color == 0:
                cost += min(self.paint_cost(n+1, 1), self.paint_cost(n+1, 2))
            elif color == 1:
                cost += min(self.paint_cost(n+1, 0), self.paint_cost(n+1, 2))
            else:
                cost += min(self.paint_cost(n+1, 0), self.paint_cost(n+1, 1))
            self.memo[(n, color)] = cost

        return cost



if __name__ == "__main__":
    s = Solution()
    costs = [[17,2,17],[16,16,5],[14,3,19]]
    print(s.minCost(costs))