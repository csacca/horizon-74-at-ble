from .message import Message


class WorkoutData(Message):
    RPM = 0
    averageHeartRate = 0
    averagePace = 0
    caloriesPerHour = 0
    coolDownTime = 0
    heartRate = 0
    incline = 0
    mets = 0
    miles = 0
    nextIncline = 0
    nextResistance = 0
    nextSpeed = 0
    programLevel = 0
    programType = 0
    resistanceLevel = 0
    speed = 0
    sprintCount = 0
    stageTime = 0
    targetHeartRate = 0
    targetWatts = 0
    timeInStage = 0
    timeInState = 0
    totalCalories = 0
    totalTime = 0
    userExternalId: str = ""
    warmUpTime = 0
    watts = 0
    workoutStage = 0
    workoutState = 0
    workoutTime = 0

    def __init__(self, msg):
        super().__init__(msg)

        self.userExternalId = msg[10:46].decode("utf-8").split("\x00", 1)[0]
        self.programType = msg[46]
        self.workoutState = msg[47]
        self.workoutStage = msg[48]
        self.stageTime = int.from_bytes(msg[49:51], "little")
        self.workoutTime = int.from_bytes(msg[51:53], "little")
        self.warmUpTime = int.from_bytes(msg[53:55], "little")
        self.coolDownTime = int.from_bytes(msg[55:57], "little")
        self.timeInState = int.from_bytes(msg[57:59], "little")
        self.timeInStage = int.from_bytes(msg[59:61], "little")
        self.speed = int.from_bytes(msg[61:63], "little")
        self.incline = int.from_bytes(msg[63:65], "little")
        self.averagePace = int.from_bytes(msg[65:67], "little")
        self.totalCalories = int.from_bytes(msg[67:69], "little")
        self.caloriesPerHour = int.from_bytes(msg[69:71], "little")
        self.mets = int.from_bytes(msg[71:73], "little")
        self.watts = int.from_bytes(msg[73:75], "little")
        self.miles = int.from_bytes(msg[75:77], "little")
        self.heartRate = int.from_bytes(msg[77:79], "little")
        self.averageHeartRate = int.from_bytes(msg[79:81], "little")
        self.RPM = int.from_bytes(msg[81:83], "little")
        self.programLevel = int.from_bytes(msg[83:85], "little")
        self.resistanceLevel = int.from_bytes(msg[85:87], "little")
        self.targetHeartRate = int.from_bytes(msg[87:89], "little")
        self.targetWatts = int.from_bytes(msg[89:91], "little")
        self.nextIncline = int.from_bytes(msg[91:93], "little")
        self.nextSpeed = int.from_bytes(msg[93:95], "little")
        self.nextResistance = msg[95]
        self.totalTime = int.from_bytes(msg[96:98], "little")

        if self.length > 98:
            self.sprintCount = msg[98]

    def format_body(self):
        return (
            "Workout Data:\n"
            f"  User External Id: {self.userExternalId:s}\n"
            f"  Program Type: {self.programType:<4d}"
            f"  Workout State: {self.workoutState:<5d}"
            f"  Workout Stage: {self.workoutStage:d}\n"
            f"  Stage Time: {self.stageTime:<6d}"
            f"  Workout Time: {self.workoutTime:<6d}"
            f"  Warm Up Time: {self.warmUpTime:<6d}"
            f"  Cool Down Time: {self.coolDownTime:d}\n"
            f"  Time In State: {self.timeInState:<3d}"
            f"  Time In Stage: {self.timeInStage:<5d}"
            f"  Speed: {self.speed:<13d}"
            f"  Incline: {self.incline:d}\n"
            f"  Average Page: {self.averagePace:<4d}"
            f"  Total Calories: {self.totalCalories:<4d}"
            f"  Cal. Per Hour: {self.caloriesPerHour:<5d}"
            f"  Mets: {self.mets:d}\n"
            f"  Watts: {self.watts:<11d}"
            f"  Miles: {self.miles:<13d}"
            f"  Heart Rate: {self.heartRate:<8d}"
            f"  Average Heart Rate: {self.averageHeartRate:d}\n"
            f"  RPM: {self.RPM:<13d}"
            f"  Program Level: {self.programLevel:<5d}"
            f"  Resistance Level: {self.resistanceLevel:<2d}"
            f"  Target Heart Rate: {self.targetHeartRate:d}\n"
            f"  Target Watts: {self.targetWatts:<4d}"
            f"  Next Incline: {self.nextIncline:<6d}"
            f"  Next Speed: {self.nextSpeed:<8d}"
            f"  Next Resistance: {self.nextResistance:d}\n"
            f"  Total Time: {self.totalTime:<6d}"
            f"  Sprint Count: {self.sprintCount:d}"
        )
