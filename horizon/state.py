from enum import Enum


class State(Enum):
    SCANNING = 1
    FOUND = 2
    CONNECTING = 3
    CONNECTED = 4
    SENDING_MULTIPLE = 5
    RECEIVING_MULTIPLE = 6
