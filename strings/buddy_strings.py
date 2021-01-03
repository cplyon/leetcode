#! /usr/bin/env python3

class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:

        if not A or not B or len(A) != len(B) or len(A) < 2:
            return False

        a1 = ""
        a2 = ""
        b1 = ""
        b2 = ""

        diff_count = 0
        letter_counts = {}
        max_count = 0

        for i in range(len(A)):
            if A[i] != B[i]:
                diff_count += 1
                if diff_count > 2:
                    return False

                if len(a1) == 0:
                    a1 = A[i]
                    b1 = B[i]
                elif len(a2) == 0:
                    a2 = A[i]
                    b2 = B[i]

            if A[i] not in letter_counts:
                letter_counts[A[i]] = 0
            letter_counts[A[i]] = letter_counts[A[i]] + 1
            max_count = max(max_count, letter_counts[A[i]])

        if diff_count == 0 and max_count >= 2:
            return True

        return diff_count == 2 and a1 == b2 and b1 == a2


if __name__ == "__main__":
    s = Solution()
    A = "ab"
    B = "ba"
    print(s.buddyStrings(A, B))
