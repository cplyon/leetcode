#!  /usr/bin/env python3

#    The town judge trusts nobody.
#    Everybody (except for the town judge) trusts the town judge.
#    There is exactly one person that satisfies properties 1 and 2.

#!  /usr/bin/env python3

# Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
# find all possible paths from node 0 to node n - 1, and return them in any
# order.

# The graph is given as follows: graph[i] is a list of all nodes you can visit
# from node i (i.e., there is a directed edge from node i to node graph[i][j]).

class Solution:
    def allPathsSourceTarget(self, graph: list[list[int]]) -> list[list[int]]:
        # BFS
        if len(graph) == 0:
            return []
        if len(graph[0]) == 0:
            return []
        paths = []
        queue = [[0]]
        while len(queue) != 0:
            cur = queue.pop(0)
            for n in graph[cur[-1]]:
                if n == len(graph)-1:
                    paths.append(cur + [n])
                else:
                    queue.append(cur + [n])
        return paths


    def allPathsSourceTarget2(self, graph: list[list[int]]) -> list[list[int]]:
        # DFS
        if len(graph) == 0:
            return []
        if len(graph[0]) == 0:
            return []
        paths = []
        stack = [[0]]
        while len(stack) != 0:
            cur = stack.pop(0)
            for n in graph[cur[-1]]:
                if n == len(graph)-1:
                    paths.append(cur + [n])
                else:
                    stack.insert(0, cur + [n])
        return paths


if __name__ == "__main__":
    s = Solution()
    graph = [[4,3,1],[3,2,4],[3],[4],[]]
    print(s.allPathsSourceTarget(graph))
    print(s.allPathsSourceTarget2(graph))
