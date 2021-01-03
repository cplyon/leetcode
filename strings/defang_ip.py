#! /usr/bin/env python3

class Solution:
    def defangIPaddr(self, address: str) -> str:
        return "".join(["[.]" if x == "." else x for x in address])


if __name__ == "__main__":
    s = Solution()
    address = "100.100.100.100"
    print(s.defangIPaddr(address))
