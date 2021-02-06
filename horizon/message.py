class Message:
    msg: bytes = b""
    type: str = ""
    signature: bytes = b""
    seq_num: int = 0
    msg4: int = 0
    msg5: int = 0
    length: int = 0

    # Note crc is a unreflected CRC-16 checksum using the CCITT CRC16 table
    crc: int = 0

    def __init__(self, msg: bytes) -> None:
        self.msg = msg
        self.signature = msg[0:2]
        self.seq_num = int.from_bytes(msg[2:4], "little")
        self.msg4 = msg[4]
        self.msg5 = msg[5]
        self.length = int.from_bytes(msg[6:8], "little")
        self.crc = int.from_bytes(msg[8:10], "little")

        self.parse_msg_type()

    def format_header(self) -> str:
        return (
            "Header\n"
            f"  signature:       0x{self.signature.hex()}"
            f"  sequence number: 0x{self.seq_num:04x}\n"
            f"  msg[4]: 0x{self.msg4:02x}\n"
            f"  msg[5]: 0x{self.msg5:02x}\n"
            f"  length:          0x{self.length:04x}\n"
            f"  CRC:             0x{self.crc:04x}"
        )

    def format_type(self) -> str:
        return f"Message Type: {self.type}"

    def format_body(self) -> str:
        return ""

    def format_raw_msg(self) -> str:
        string = ""
        while self.msg:
            line = self.msg[0:20]
            while line:
                string += line[0:2].hex() + " "
                line = line[2:]
            string += "\n"
            self.msg = self.msg[20:]
        return string

    def __str__(self) -> str:
        return (
            self.format_type() + "\n" + self.format_header() + "\n" + self.format_body()
        )

    def parse_msg_type(self) -> None:
        msg_type = ""
        if self.msg[5] == 0x00:
            if self.msg[10] == 0x01:
                msg_type = "response_selectUser"
            elif self.msg[10] == 0x02:
                msg_type = "response_startWorkout"
            elif self.msg[10] == 0x03:
                if self.msg[11] == 0x00 or self.msg[11] == 0x02:
                    msg_type = "response_pauseWorkout"
                else:
                    msg_type = "response_continueWorkout"
            elif self.msg[10] == 0x04:
                msg_type = "response_changeWorkout"
            elif self.msg[10] == 0x05:
                msg_type = "response_setSpeed"
            elif self.msg[10] == 0x06:
                msg_type = "response_setIncline"
            elif self.msg[10] == 0x07:
                msg_type = "response_setResistance"
            elif self.msg[10] == 0x0F:
                msg_type = "response_setUser"
            elif self.msg[10] == 0x10:
                msg_type = "response_selectProgram"
            elif self.msg[10] == 0x12:
                msg_type = "response_deleteUser"
            elif self.msg[10] == 0x13:
                msg_type = "response_setHeartValue"
            elif self.msg[10] == 0x14:
                msg_type = "response_stopWorkout"
            elif self.msg[10] == 0x17:
                msg_type = "response_setMyFirst5k"
            elif self.msg[10] == 0x18:
                msg_type = "response_customProgram"
            elif self.msg[10] == 0x19:
                msg_type = "response_setCustomHRProgram"
            elif self.msg[10] == 0x1A:
                msg_type = "response_workoutProgram"
            elif self.msg[10] == 0x1B:
                msg_type = "response_setPopupInfo"

        elif self.msg[5] == 0x01:
            if self.msg[4] == 0x03:
                msg_type = "selectUser"

        elif self.msg[5] == 0x02:
            if self.msg[4] == 0x01:
                msg_type = "getMachineInfo"
            elif self.msg[4] == 0x03:
                msg_type = "startWorkout"

        elif self.msg[5] == 0x03:
            if self.msg[10] == 0x01:
                msg_type = "continueWorkout"
            else:
                msg_type = "pauseWorkout"

        elif self.msg[5] == 0x04:
            if self.msg[4] == 0x03:
                msg_type = "changeWorkout"

        elif self.msg[5] == 0x05:
            if self.msg[4] == 0x03:
                msg_type = "setSpeed"

        elif self.msg[5] == 0x06:
            if self.msg[4] == 0x03:
                msg_type = "setIncline"

        elif self.msg[5] == 0x07:
            if self.msg[4] == 0x03:
                msg_type = "setResistance"

        elif self.msg[5] == 0x10:
            if self.msg[4] == 0x03:
                msg_type = "selectProgram"

        elif self.msg[5] == 0x11:
            msg_type = "keyPress"

        elif self.msg[5] == 0x12:
            msg_type = "workoutData"

        elif self.msg[5] == 0x13:
            if self.msg[4] == 0x03:
                msg_type = "setHeartValue"

        elif self.msg[5] == 0x14:
            if self.msg[4] == 0x01:
                msg_type = "stopWorkout"
            elif self.msg[4] == 0x03:
                msg_type = "timeSync"

        elif self.msg[5] == 0x16:
            msg_type = "userInfo"

        elif self.msg[5] == 0x17:
            msg_type = "setMyFirst5k"

        elif self.msg[5] == 0x18:
            msg_type = "setCustomProgram"

        elif self.msg[5] == 0x19:
            msg_type = "setCustomHRProgram"

        elif self.msg[5] == 0x1A:
            if self.msg[4] == 0x01:
                msg_type = "workoutSummary"

        elif self.msg[5] == 0x1B:
            msg_type = "setPopupInfo"

        if msg_type == "":
            msg_type = (
                f"Unknown: msg[4]: {self.msg[4:5].hex()}"
                f"  msg[5]: {self.msg[5:6].hex()}"
                f"  msg[10]: {self.msg[10:11].hex()}"
                f"  msg[11]: {self.msg[11:12].hex()}"
            )

        self.type = msg_type
