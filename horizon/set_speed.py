from .message import Message


class SetSpeed(Message):
    msg10: int = 0
    speed: int = 0
    msg13: int = 0

    def __init__(self, msg: bytes) -> None:
        super().__init__(msg)
        self.msg10 = msg[10]
        self.speed = int.from_bytes(msg[11:13], "little")
        self.msg13 = msg[13]

    def format_body(self):
        return (
            "Set Speed:\n"
            f"  Speed: {self.speed/10.0:.1f}\n"
            f"  msg[10]: {self.msg10:02x}  msg[13]: {self.msg13:02x}"
        )
