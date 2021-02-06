from .message import Message


class DeviceInfo(Message):
    machineType: int = 0
    modelType: int = 0
    securitySwitch: int = 0
    runStatus: int = 0

    def __init__(self, msg: bytes) -> None:
        super().__init__(msg)

        if self.length > 0:
            self.machineType = msg[11]
            self.modelType = msg[12]
            self.securitySwitch = msg[141]
            self.runStatus = msg[142]

    def format_body(self) -> str:
        return (
            "Device Info:\n"
            f"  Machine Type:    {self.machineType:>3d}"
            f"  Model Type: {self.modelType:>3d}\n"
            f"  Security Switch: {self.securitySwitch:>3d}"
            f"  Run Status: {self.runStatus:>3d}"
        )
