from .message import Message


class SetIncline(Message):
    incline = 0
    msg12 = 0

    def __init__(self, msg: bytes) -> None:
        super().__init__(msg)
        self.incline = int.from_bytes(msg[10:12], "little")
        self.msg12 = msg[12]

    def format_body(self) -> str:
        return (
            f"Set Incline:\n  Incline: {self.incline/10.0:.1f}\n"
            f"  msg[12]: {self.msg12:02x}"
        )
