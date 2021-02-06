from .workout_data import WorkoutData
from .user_info import UserInfo
from .header import Header
from .device_info import DeviceInfo
from .set_speed import SetSpeed


def parse_header(msg: bytes) -> Header:
    header = Header()
    header.signature = msg[0:2]
    header.seq_num = int.from_bytes(msg[2:4], "little")
    header.type = msg[4:6]
    header.length = int.from_bytes(msg[6:8], "little")
    header.crc = int.from_bytes(msg[8:10], "little")
    return header


def parse_msg_type(msg: bytes):
    msg_type = ""
    if msg[5] == 0x00:
        if msg[10] == 0x01:
            msg_type = "response_selectUser"
        elif msg[10] == 0x02:
            msg_type = "response_startWorkout"
        elif msg[10] == 0x03:
            if msg[11] == 0x00 or msg[11] == 0x02:
                msg_type = "response_pauseWorkout"
            else:
                msg_type = "continueWorkout"
        elif msg[10] == 0x04:
            msg_type = "response_changeWorkout"
        elif msg[10] == 0x05:
            msg_type = "response_setSpeed"
        elif msg[10] == 0x06:
            msg_type = "response_setIncline"
        elif msg[10] == 0x07:
            msg_type = "response_setResistance"
        elif msg[10] == 0x0F:
            msg_type = "response_setUser"
        elif msg[10] == 0x10:
            msg_type = "response_selectProgram"
        elif msg[10] == 0x12:
            msg_type = "response_deleteUser"
        elif msg[10] == 0x13:
            msg_type = "response_setHeartValue"
        elif msg[10] == 0x14:
            msg_type = "response_stopWorkout"
        elif msg[10] == 0x17:
            msg_type = "response_setMyFirst5k"
        elif msg[10] == 0x18:
            msg_type = "response_customProgram"
        elif msg[10] == 0x19:
            msg_type = "response_setCustomHRProgram"
        elif msg[10] == 0x1A:
            msg_type = "workoutSummary"
        elif msg[10] == 0x1B:
            msg_type = "setPopupInfo"

    elif msg[5] == 0x01:
        if msg[4] == 0x03:
            msg_type = "selectUser"

    elif msg[5] == 0x02:
        if msg[4] == 0x01:
            msg_type = "response_getMachineInfo"
        elif msg[4] == 0x03:
            msg_type = "device_startWorkout"

    elif msg[5] == 0x03:
        if msg[10] == 0x01:
            msg_type = "deviceContinueWorkout"
        else:
            msg_type = "device_pauseWorkout"

    elif msg[5] == 0x04:
        if msg[4] == 0x03:
            msg_type = "changeWorkout"

    elif msg[5] == 0x05:
        if msg[4] == 0x03:
            msg_type = "setSpeed"

    elif msg[5] == 0x06:
        if msg[4] == 0x03:
            msg_type = "setIncline"

    elif msg[5] == 0x07:
        if msg[4] == 0x03:
            msg_type = "setResistance"

    elif msg[5] == 0x10:
        if msg[4] == 0x03:
            msg_type = "selectProgram"

    elif msg[5] == 0x11:
        msg_type = "keyPress"

    elif msg[5] == 0x12:
        msg_type = "device_workoutData"

    elif msg[5] == 0x13:
        if msg[4] == 0x03:
            msg_type = "setHeartValue"

    elif msg[5] == 0x14:
        if msg[4] == 0x01:
            msg_type = "stopWorkout"
        elif msg[4] == 0x03:
            msg_type = "device_timeSync"

    elif msg[5] == 0x16:
        msg_type = "userInfo"

    elif msg[5] == 0x17:
        msg_type = "setMyFirst5k"

    elif msg[5] == 0x18:
        msg_type = "setCustomProgram"

    elif msg[5] == 0x19:
        msg_type = "setCustomHRProgram"

    elif msg[5] == 0x1A:
        msg_type = "workoutSummary"

    elif msg[5] == 0x1B:
        msg_type = "setPopupInfo"

    if msg_type == "":
        msg_type = (
            f"Unknown: msg[4]: {msg[4:5].hex()}  msg[5]: {msg[5:6].hex()}  "
            f"msg[10]: {msg[10:11].hex()}  msg[11]: {msg[11:12].hex()}"
        )

    return msg_type


def parse_device_info(msg: bytes) -> DeviceInfo:
    assert msg[5] == 0x02 and msg[4] == 0x01

    header = parse_header(msg)
    deviceInfo = DeviceInfo()

    if header.length == 0:
        return deviceInfo

    deviceInfo.machineType = msg[11]
    deviceInfo.modelType = msg[12]
    deviceInfo.securitySwitch = msg[141]
    deviceInfo.runStatus = msg[142]


def parse_user_info(msg: bytes) -> UserInfo:
    assert msg[5] == 0x16
    header = parse_header(msg)
    ble_version = 0
    if header.length == 731:
        ble_version = 1

    userInfo = UserInfo()

    userInfo.userSlot = msg[10]
    userInfo.userName = msg[11:76].decode("utf-8").rstrip("\x00")
    userInfo.userWeight = int.from_bytes(msg[76:78], "little")
    userInfo.userBirthYear = int.from_bytes(msg[78:80], "little")
    userInfo.userBirthMonth = msg[80]
    userInfo.userBirthDay = msg[81]
    userInfo.units = msg[82]
    userInfo.customProgramCRC = int.from_bytes(msg[83:85], "little")
    userInfo.customHeartrateCRC = int.from_bytes(msg[85:87], "little")
    userInfo.myFirst5kWeek = msg[87]
    userInfo.myFirst5kWorkout = msg[88]
    userInfo.myFirst5kWalkSpeed = msg[89]
    userInfo.myFirst5kJogSpeed = msg[90]
    userInfo.myFirst5kResetCounter = int.from_bytes(msg[91:93], "little")
    userInfo.MMFTokenId = msg[93:133].decode("utf-8").rstrip("\x00")
    userInfo.MFPTokenId = msg[133:453].decode("utf-8").rstrip("\x00")
    if ble_version == 1:
        userInfo.FitbitToken = msg[453:726].decode("utf-8").rstrip("\x00")

    return userInfo


def parse_device_workoutData(msg: bytes) -> WorkoutData:
    assert msg[5] == 0x12
    header = parse_header(msg)
    workoutData = WorkoutData()

    workoutData.userExternalId = msg[10:46].decode("utf-8")
    workoutData.programType = msg[46]
    workoutData.workoutState = msg[47]
    workoutData.workoutStage = msg[48]
    workoutData.stageTime = int.from_bytes(msg[49:51], "little")
    workoutData.workoutTime = int.from_bytes(msg[51:53], "little")
    workoutData.warmUpTime = int.from_bytes(msg[53:55], "little")
    workoutData.coolDownTime = int.from_bytes(msg[55:57], "little")
    workoutData.timeInState = int.from_bytes(msg[57:59], "little")
    workoutData.timeInStage = int.from_bytes(msg[59:61], "little")
    workoutData.speed = int.from_bytes(msg[61:63], "little")
    workoutData.incline = int.from_bytes(msg[63:65], "little")
    workoutData.averagePace = int.from_bytes(msg[65:67], "little")
    workoutData.totalCalories = int.from_bytes(msg[67:69], "little")
    workoutData.caloriesPerHour = int.from_bytes(msg[69:71], "little")
    workoutData.mets = int.from_bytes(msg[71:73], "little")
    workoutData.watts = int.from_bytes(msg[73:75], "little")
    workoutData.miles = int.from_bytes(msg[75:77], "little")
    workoutData.heartRate = int.from_bytes(msg[77:79], "little")
    workoutData.averageHeartRate = int.from_bytes(msg[79:81], "little")
    workoutData.RPM = int.from_bytes(msg[81:83], "little")
    workoutData.programLevel = int.from_bytes(msg[83:85], "little")
    workoutData.resistanceLevel = int.from_bytes(msg[85:87], "little")
    workoutData.targetHeartRate = int.from_bytes(msg[87:89], "little")
    workoutData.targetWatts = int.from_bytes(msg[89:91], "little")
    workoutData.nextIncline = int.from_bytes(msg[91:93], "little")
    workoutData.nextSpeed = int.from_bytes(msg[93:95], "little")
    workoutData.nextResistance = msg[95]
    workoutData.totalTime = int.from_bytes(msg[96:98], "little")

    if header.length > 98:
        workoutData.sprintCount = msg[98]

    return workoutData


def parse_set_speed(msg: bytes) -> SetSpeed:
    assert msg[5] == 0x05

    setSpeed = SetSpeed()
    setSpeed.msg10 = msg[10]
    setSpeed.speed = int.from_bytes(msg[11:13], "little")
    setSpeed.msg13 = msg[13]

    return setSpeed
