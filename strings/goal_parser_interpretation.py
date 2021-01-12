#! /usr/bin/env python3

class Solution:
    def interpret(self, command: str) -> str:
        if not command:
            return ""

        output = ""
        i = 0
        while i < len(command):
            if command[i] == "G":
                output += command[i]
            elif command[i] == "(":
                i += 1
                if command[i] == ")":
                    output += "o"
                else:
                    output += "al"
                    i += 2
            i += 1

        return output


if __name__ == "__main__":
    s = Solution()
    command = "G()(al)"
    print(s.interpret(command))
