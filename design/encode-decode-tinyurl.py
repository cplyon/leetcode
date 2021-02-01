#! /usr/bin/env python3

import random

class Codec:

    def __init__(self):
        self.ht = {}
        self.PREFIX = "http://tinyurl.com/"

    def gen_random(self):
        rand = ""
        for _ in range(4):
            rand += chr(random.randrange(60, 123))
            rand += str(random.randrange(0, 10))
        return rand


    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        rand = self.gen_random()
        while rand in self.ht:
            rand = self.gen_random()
        self.ht[self.PREFIX + rand] = longUrl
        return self.PREFIX + rand



    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        return self.ht[shortUrl]


if __name__ == "__main__":
    codec = Codec()
    url = "https://cplyon.ca"
    print(codec.decode(codec.encode(url)))
