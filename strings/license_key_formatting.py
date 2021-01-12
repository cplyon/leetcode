#! /usr/bin/env python3

class Solution:
    def licenseKeyFormatting(self, S: str, K: int) -> str:
        if not S:
            return ""

        k = 0
        license = ""
        for i in range(len(S)-1, -1, -1):
            if S[i] != "-":
                if k < K:
                    k += 1
                else:
                    license = "-" + license
                    k = 1
                license = S[i].upper() + license

        return license


if __name__ == "__main__":
    s = Solution()
    S = "5-F3Z-2e-9-w"
    K = 4
    print(s.licenseKeyFormatting(S, K))
