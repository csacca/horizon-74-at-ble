from .message import Message


class UserInfo(Message):
    ble_version: int = 0
    userSlot = 0
    userName = ""
    userWeight = 0
    userBirthYear = 0
    userBirthMonth = 0
    userBirthDay = 0
    units = 0
    customProgramCRC = 0
    customHeartrateCRC = 0
    myFirst5kWeek = 0
    myFirst5kWorkout = 0
    myFirst5kWalkSpeed = 0
    myFirst5kJogSpeed = 0
    myFirst5kResetCounter = 0
    MMFTokenId = ""
    MFPTokenId = ""
    MFPUserId = ""
    FitbitToken = ""

    def __init__(self, msg) -> None:
        super().__init__(msg)

        self.ble_version = 0
        if self.length == 731:
            self.ble_version = 1
        self.userSlot = msg[10]
        self.userName = msg[11:76].decode("utf-8").rstrip("\x00")
        self.userWeight = int.from_bytes(msg[76:78], "little")
        self.userBirthYear = int.from_bytes(msg[78:80], "little")
        self.userBirthMonth = msg[80]
        self.userBirthDay = msg[81]
        self.units = msg[82]
        self.customProgramCRC = int.from_bytes(msg[83:85], "little")
        self.customHeartrateCRC = int.from_bytes(msg[85:87], "little")
        self.myFirst5kWeek = msg[87]
        self.myFirst5kWorkout = msg[88]
        self.myFirst5kWalkSpeed = msg[89]
        self.myFirst5kJogSpeed = msg[90]
        self.myFirst5kResetCounter = int.from_bytes(msg[91:93], "little")
        self.MMFTokenId = msg[93:133].decode("utf-8").rstrip("\x00")
        self.MFPTokenId = msg[133:453].decode("utf-8").rstrip("\x00")

        if self.ble_version == 1:
            self.FitbitToken = msg[453:726].decode("utf-8").rstrip("\x00")

    def format_body(self) -> str:
        fitbitToken = self.FitbitToken.split("\x00", 1)[0]
        return (
            "UserInfo:\n"
            f"  User Slot: {self.userSlot:d}\n"
            f"  User Name: {self.userName!r}\n"
            f"  User Weight: {self.userWeight:d}\n"
            f"  User Birth Year: {self.userBirthYear:d}  User Birth Month: {self.userBirthMonth:d}  "
            f"User Birth Day: {self.userBirthDay:d}\n"
            f"  Units: {self.units:d}\n"
            f"  Custom Program CRC: {self.customProgramCRC:04x}  Custom Heartrate CRC: "
            f"{self.customHeartrateCRC:04x}\n"
            f"  My First 5k Week: {self.myFirst5kWeek:d}  My First 5k Workout: "
            f"{self.myFirst5kWorkout:d}\n"
            f"  My First 5k Walk Speed: {self.myFirst5kWalkSpeed:d}  My First 5k Jog Speed: "
            f"{self.myFirst5kJogSpeed:d}\n"
            f"  My First 5k Reset Counter: {self.myFirst5kResetCounter:d}\n"
            f"  Map My Fitness Token ID: {self.MMFTokenId!r}\n"
            f"  My Fitness Pal Token ID: {self.MFPTokenId!r}\n"
            f"  My Fitness Pal User ID: {self.MFPUserId!r}\n"
            f"  Fitbit Token: {fitbitToken!r}"
        )
