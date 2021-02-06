from typing import List

from .message import Message


class WorkoutSummary(Message):
    userName: str = ""
    userId: int = 0
    MMFTokenId: str = ""
    MFPTokenId: str = ""
    MFPUserId: str = ""
    fitbitTokenId: str = ""
    workoutsCounter: int = 0
    workoutInfoList: List = []

    def __init__(self, msg: bytes):
        super().__init__(msg)

        self.ble_version = 0
        if self.length == 725:
            self.ble_version = 1

        self.userName = msg[10:75].decode("utf-8").rstrip("\x00")
        self.userId = msg[75]
        self.MMFTokenId = msg[76:116].decode("utf-8").rstrip("\x00")
        self.MFPTokenId = msg[116:436].decode("utf-8").rstrip("\x00")

        if self.ble_version == 1:
            self.fitbitTokenId = msg[436:709].decode("utf-8").rstrip("\x00")
            self.MFPUserId = msg[709:724].decode("utf-8").rstrip("\x00")
            self.workoutsCounter = msg[724]
        else:
            self.MFPUserId = msg[436:451].decode("utf-8").rstrip("\x00")
            self.workoutsCounter = msg[451]

        self.workoutInfoList = self.parse_workout_list(msg, self.workoutsCounter)

    def parse_workout_list(self, msg: bytes, workoutCounter: int) -> List:
        workoutList: List[WorkoutListMember] = []
        for i in range(0, workoutCounter):
            start = i * 19 + 452
            workout = WorkoutListMember(msg, start)
            workoutList.append(workout)
        return workoutList

    def format_body(self) -> str:
        s = (
            "Workout Summary:\n"
            f"  User Name: '{self.userName:s}'  User Id: {self.userId:d}\n"
            f"  MMFTokenId: {self.MMFTokenId:s}\n"
            f"  MFPTokenId: {self.MFPTokenId:s}\n"
            f"  MFPUserId: {self.MFPUserId:s}\n"
        )
        if self.fitbitTokenId != "":
            s += f"  FitbitTokenId: {self.fitbitTokenId:s}\n"
        s += f"Workout Count: {self.workoutsCounter:d}\n"
        if self.workoutsCounter > 0:
            for i in range(0, self.workoutsCounter):
                s += f"  Workout {i+1}:\n" + self.workoutInfoList[i] + "\n"
        return s


class WorkoutListMember:
    time: int = 0
    calories: int = 0
    distance: int = 0
    maxSpeed: int = 0
    averageSpeed: int = 0
    maxHR: int = 0
    averageHR: int = 0
    mem10: int = 0
    units: int = 0
    startYear: int = 0
    startMonth: int = 0
    startDay: int = 0
    startHour: int = 0
    startMinute: int = 0
    startSecond: int = 0

    def __init__(self, msg: bytes, start: int):
        self.time = int.from_bytes(msg[start : start + 2], "little")
        self.calories = int.from_bytes(msg[start + 2 : start + 4], "little")
        self.distance = int.from_bytes(msg[start + 4 : start + 6], "little")
        self.maxSpeed = msg[start + 6]
        self.averageSpeed = msg[start + 7]
        self.maxHR = msg[start + 8]
        self.averageHR = msg[start + 9]
        self.mem10 = msg[start + 10]
        self.units = msg[start + 11]
        self.startYear = int.from_bytes(msg[start + 12 : start + 14], "little")
        self.startMonth = msg[start + 14]
        self.startDay = msg[start + 15]
        self.startHour = msg[start + 16]
        self.startMinute = msg[start + 17]
        self.startSecond = msg[start + 18]

    def __str__(self) -> str:
        return (
            f"    Time: {self.time:d}  Calories: {self.calories:d}"
            f"  Distance: {self.distance:d}\n"
            f"    Max Speed: {self.maxSpeed:d}  Average Speed: {self.averageSpeed:d}\n"
            f"    Max HR: {self.maxHR:d}  Average HR: {self.averageHR:d}\n"
            f"    mem10: {self.mem10:d}  Units: {self.units:d}\n"
            f"    Start Year: {self.startYear:d}"
            f"  Start Month: {self.startMonth:d}"
            f"  Start Day: {self.startDay:d}\n"
            f"    Start Hour: {self.startHour:d}"
            f"  Start Minute: {self.startMinute:d}"
            f"  Start Second: {self.startSecond:d}"
        )
