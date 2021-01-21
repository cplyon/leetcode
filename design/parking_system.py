#! /usr/bin/env python3

class ParkingSystem:
    def __init__(self, big: int, medium: int, small: int):
        self.spots = {}
        for i in range(1,4):
            self.spots[i] = 0
        self.capacity = {}
        self.capacity[1] = big
        self.capacity[2] = medium
        self.capacity[3] = small

    def addCar(self, carType: int) -> bool:
        if 1 > carType > 3:
            return False

        if self.spots[carType] < self.capacity[carType]:
            self.spots[carType] += 1
            return True

        return False


if __name__ == "__main__":
    ps = ParkingSystem(1, 2, 3)
    print(ps.addCar(1))  # true
    print(ps.addCar(1))  # false
    print(ps.addCar(2))  # true
    print(ps.addCar(3))  # true
