#! /usr/local/bin/python3

#    The town judge trusts nobody.
#    Everybody (except for the town judge) trusts the town judge.
#    There is exactly one person that satisfies properties 1 and 2.

class Solution:
    def findJudge(self, N: int, trust: list[list[int]]) -> int:
        if N == 1:
            return N
        if N < 1 or len(trust) == 0:
            return -1

        judge = -1
        trusters = set()
        trustees = {}
        for t in trust:
            trusters.add(t[0])
            if t[1] not in trustees:
                trustees[t[1]] = 0
            trustees[t[1]] = trustees[t[1]] + 1

        for n in range(1, N+1):
            if n not in trusters:
                if n not in trustees:
                    # not trusted, or trusting
                    return -1
                if trustees[n] == N-1:
                    # found a judge!
                    if judge > 0:
                        # too many judges!
                        return -1
                    judge = n

        return judge


if __name__ == "__main__":
    s = Solution()
    N = 4
    trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
    print(s.findJudge(N, trust))
