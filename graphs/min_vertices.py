#! /usr/local/bin/python3

class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: list[list[int]]) -> list[int]:
        incoming = set([x[1] for x in edges])
        return [x for x in range(0, n) if x not in incoming]


if __name__ == "__main__":
    s = Solution()
    n = 10
    edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
    print(s.findSmallestSetOfVertices(n, edges))
