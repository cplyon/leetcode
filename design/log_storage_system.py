#! /usr/bin/env python3

from datetime import date, datetime
from calendar import monthrange

class LogSystem:

    def __init__(self):
        self.logs = []
        self.indices = {
            "Year": 5,
            "Month": 8,
            "Day": 11,
            "Hour": 14,
            "Minute": 17,
            "Second": 20
        }

    def put(self, id: int, timestamp: str) -> None:
        self.logs.append((id, timestamp))

    def retrieve(self, start: str, end: str, granularity: str) -> list[int]:
        results = []
        index = self.indices[granularity]
        for id, ts in self.logs:
            if start[:index] <= ts[:index] <= end[:index]:
                results.append(id)

        return results


# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(start,end,granularity)


class LogSystem2:

    def __init__(self):
        self.logs = {}

    def put(self, id: int, timestamp: str) -> None:
        if not timestamp or id < 1:
            return

        if timestamp not in self.logs:
            self.logs[timestamp] = []
        self.logs[timestamp].append(id)

    def retrieve(self, start: str, end: str, granularity: str) -> list[int]:
        start_increments = [int(s) for s in start.split(":")]
        end_increments = [int(s) for s in end.split(":")]
        result = []
        start_datetime = datetime(start_increments[0],  # year
                                    start_increments[1],  # month
                                    start_increments[2],  # day
                                    start_increments[3],
                                    start_increments[4],
                                    start_increments[5]
                                    )
        end_datetime = datetime(end_increments[0],  # year
                                end_increments[1],  # month
                                end_increments[2],
                                end_increments[3],
                                end_increments[4],
                                end_increments[5]
                                )
        for timestamp in self.logs:
            timestamp_increments = [int(s) for s in timestamp.split(":")]
            log_datetime = datetime(timestamp_increments[0],
                                    timestamp_increments[1],
                                    timestamp_increments[2],
                                    timestamp_increments[3],
                                    timestamp_increments[4],
                                    timestamp_increments[5]
                                    )

            if granularity == "Year":
                start_datetime = datetime(start_increments[0],  # year
                                          1,  # month
                                          1   # day
                                          )
                end_datetime = datetime(end_increments[0],  # year
                                        12,
                                        monthrange(end_increments[0], 12)[1]
                                        )

            elif granularity == "Month":
                start_datetime = datetime(start_increments[0],  # year
                                          start_increments[1],  # month
                                          1  # day
                                          )
                end_datetime = datetime(end_increments[0],  # year
                                        end_increments[1],  # month
                                        monthrange(end_increments[0],
                                                   end_increments[1])[1],
                                        23, 59, 59
                                        )
            elif granularity == "Day":
                start_datetime = datetime(start_increments[0],  # year
                                          start_increments[1],  # month
                                          start_increments[2]  # day
                                          )
                end_datetime = datetime(end_increments[0],  # year
                                        end_increments[1],  # month
                                        end_increments[2],
                                        23, 59, 59
                                        )
            elif granularity == "Hour":
                start_datetime = datetime(start_increments[0],  # year
                                          start_increments[1],  # month
                                          start_increments[2],  # day
                                          start_increments[3]  # hour
                                          )
                end_datetime = datetime(end_increments[0],  # year
                                        end_increments[1],  # month
                                        end_increments[2],
                                        end_increments[3],
                                        59,
                                        59
                                        )
            elif granularity == "Minute":
                start_datetime = datetime(start_increments[0],  # year
                                            start_increments[1],  # month
                                            start_increments[2],  # day
                                            start_increments[3],
                                            start_increments[4]
                                            )
                end_datetime = datetime(end_increments[0],  # year
                                        end_increments[1],  # month
                                        end_increments[2],  # day
                                        end_increments[3],  # hour
                                        end_increments[4],  # minute
                                        59
                                        )
            print(start_datetime, log_datetime, end_datetime)
            if start_datetime <= log_datetime <= end_datetime:
                result.extend(self.logs[timestamp])

        return result


if __name__ == "__main__":


    ls = LogSystem()
    l2 = LogSystem2()

    l2.put(1,"2017:01:01:23:59:59")
    l2.put(2,"2017:01:02:23:59:59")
    print(l2.retrieve("2017:01:01:23:59:59","2017:01:02:23:59:59","Day"))

    ls.put(1,"2017:01:01:23:59:59")
    ls.put(2,"2017:01:02:23:59:59")
    print(ls.retrieve("2017:01:01:23:59:59","2017:01:02:23:59:59","Day"))
