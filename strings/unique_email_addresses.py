#! /usr/bin/env python3

class Solution:
    def numUniqueEmails(self, emails: list[str]) -> int:
        map = set()
        if emails:
            for email in emails:
                # split address into local and domain components
                at_index = email.find("@")
                local = email[:at_index]
                domain = email[at_index:]

                # remove everything from '+' on in local
                plus_index = local.find("+")
                if plus_index > 0:
                    local = local[:plus_index]

                # remove '.'s in local
                local = local.replace(".", "")

                # add to to map
                map.add(local + domain)
        return len(map)


if __name__ == "__main__":
    s = Solution()
    emails = ["chris@example.ca",
              "chris.lyon@example.ca",
              "chrislyon@example.ca",
              "chris+lyon@example.ca",
              "ch.ris+lyon@example.ca"
              ]
    print(s.numUniqueEmails(emails))
