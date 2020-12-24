#! /usr/local/bin/python3

# Given an encoded string, return its decoded string.

# The encoding rule is: k[encoded_string], where the encoded_string inside the
# square brackets is being repeated exactly k times. Note that k is guaranteed
# to be a positive integer.

# You may assume that the input string is always valid; No extra white spaces,
# square brackets are well-formed, etc.

# Furthermore, you may assume that the original data does not contain any
# digits and that digits are only for those repeat numbers, k.
# For example, there won't be input like 3a or 2[4].

class Solution:

    def decodeString(self, s: str) -> str:
        stack = []
        result = ""
        factor = 0

        for c in s:
            if c == '[':
                stack.insert(0, (result, factor))
                result = ""
                factor = 0
            elif c == ']':
                prev_result, prev_factor = stack.pop(0)
                result = prev_result + prev_factor * result
            elif c.isdigit():
                factor = factor*10 + int(c)
            else:
                result += c

        return result





if __name__ == "__main__":
    s = Solution()
    st = "x3[a]2[b]z"
    print("->", s.decodeString(st))
