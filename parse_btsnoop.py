from binascii import unhexlify

import pyshark

from horizon import (
    HEADER_LENGTH,
    DeviceInfo,
    Message,
    SetIncline,
    SetSpeed,
    State,
    UserInfo,
    WorkoutData,
    WorkoutSummary,
)


def format_raw_msg(msg: bytes):
    string = ""
    while msg:
        line = msg[0:20]
        while line:
            string += line[0:2].hex() + " "
            line = line[2:]
        string += "\n"
        msg = msg[20:]
    return string


def print_pkt_info(pkt):
    print(
        (
            f"BLE Packet #{pkt.number}  "
            f"{pkt.bthci_acl.src_bd_addr} "
            f"({pkt.bthci_acl.src_name})  "
            f"->  {pkt.bthci_acl.dst_bd_addr} "
            f"({pkt.bthci_acl.dst_name})"
        )
    )


def process_msg(msg: bytes):
    message = Message(msg)

    if message.type == "workoutData":
        workoutData = WorkoutData(msg)
        print(workoutData)
        print()
    elif message.type == "userInfo":
        userInfo = UserInfo(msg)
        print(userInfo)
        print()
    elif message.type == "getMachineInfo":
        deviceInfo = DeviceInfo(msg)
        print(deviceInfo)
        print()
    elif message.type == "setSpeed":
        setSpeed = SetSpeed(msg)
        print(setSpeed)
        print()
    elif message.type == "setIncline":
        setIncline = SetIncline(msg)
        print(setIncline)
        print()
    elif message.type == "workoutSummary":
        workoutSummary = WorkoutSummary(msg)
        print(workoutSummary)
        print()
    else:
        print(message)
        print(message.format_raw_msg())
        print()


def main():
    filename = "btsnoop_hci.log"
    mac = None

    cap = pyshark.FileCapture(filename)

    state = State.SCANNING
    msg_buf = None
    bytes_remaining = None
    for pkt in cap:
        if state == State.SCANNING:
            if (
                pkt.highest_layer == "BTHCI_EVT"
                and int(pkt.bthci_evt.code, 10) == 0x3E
                and int(pkt.bthci_evt.le_meta_subevent, 16) == 0x02
                and int(pkt.bthci_evt.le_advts_event_type, 16) == 0x04
                and "btcommon_eir_ad_entry_device_name" in pkt.bthci_evt.field_names
                and pkt.bthci_evt.btcommon_eir_ad_entry_device_name.lower().startswith("horizon")
            ):
                # pkt.pretty_print()
                mac = pkt.bthci_evt.bd_addr
                state = State.FOUND

        elif state == State.FOUND:
            if (
                pkt.highest_layer == "BTHCI_CMD"
                and int(pkt.bthci_cmd.opcode, 10) == 0x2043
                and pkt.bthci_cmd.bd_addr == mac
            ):
                # pkt.pretty_print()
                state = State.CONNECTING

        elif state == State.CONNECTING:
            if (
                pkt.highest_layer == "BTHCI_EVT"
                and int(pkt.bthci_evt.code, 10) == 0x3E
                and int(pkt.bthci_evt.le_meta_subevent, 16) == 0x0A
                and int(pkt.bthci_evt.status, 10) == 0x00
                and pkt.bthci_evt.bd_addr == mac
            ):
                # pkt.pretty_print()
                state = State.CONNECTED

        elif state == State.CONNECTED:
            if (
                pkt.highest_layer == "BTATT"
                and int(pkt.btatt.opcode, 16) == 0x12  # Write Request
                and int(pkt.btatt.service_uuid16, 10) == 0xFFF0
            ):
                if int(pkt.btatt.uuid16, 10) == 0x2902:
                    # Client Characteristic Configuration
                    # probably requesting notification on 0xfff4
                    # pkt.pretty_print()
                    pass

                elif int(pkt.btatt.uuid16, 10) == 0xFFF3:
                    # Pkt sent to treadmill
                    msg_buf = unhexlify(pkt.btatt.value.raw_value)
                    if msg_buf[0:2] == b"\x55\xAA":
                        # start of message 0x55AA
                        message = Message(msg_buf)
                        bytes_remaining = message.length + HEADER_LENGTH - len(msg_buf)
                        if bytes_remaining > 0:
                            state = State.SENDING_MULTIPLE
                        else:
                            print_pkt_info(pkt)
                            process_msg(msg_buf)
                else:
                    # unexpected write request
                    # pkt.pretty_print()
                    pass
            elif (
                pkt.highest_layer == "BTATT"
                and int(pkt.btatt.opcode, 16) == 0x1B  # Handle Value Notification
                and int(pkt.btatt.service_uuid16, 10) == 0xFFF0
            ):
                if int(pkt.btatt.uuid16, 10) == 0xFFF4:
                    # Pkt received from treadmill
                    msg_buf = unhexlify(pkt.btatt.value.raw_value)
                    if msg_buf[0:2] == b"\x55\xAA":
                        # start of message 0x55AA
                        message = Message(msg_buf)
                        bytes_remaining = message.length + HEADER_LENGTH - len(msg_buf)
                        if bytes_remaining > 0:
                            state = State.RECEIVING_MULTIPLE
                        else:
                            print_pkt_info(pkt)
                            process_msg(msg_buf)
                elif int(pkt.btatt.uuid16, 10) == 0xFFF3:
                    # ignore for now
                    pass
                else:
                    # unexpected write request
                    # pkt.pretty_print()
                    pass

        elif state == State.SENDING_MULTIPLE:
            if (
                pkt.highest_layer == "BTATT"
                and int(pkt.btatt.opcode, 16) == 0x12  # Write Request
                and int(pkt.btatt.service_uuid16, 10) == 0xFFF0
                and int(pkt.btatt.uuid16, 10) == 0xFFF3
            ):
                msg = unhexlify(pkt.btatt.value.raw_value)
                msg_buf += msg
                bytes_remaining -= len(msg)
                if bytes_remaining <= 0:
                    print_pkt_info(pkt)
                    process_msg(msg_buf)
                    state = State.CONNECTED

        elif state == State.RECEIVING_MULTIPLE:
            if (
                pkt.highest_layer == "BTATT"
                and int(pkt.btatt.opcode, 16) == 0x1B  # Handle Value Notification
                and int(pkt.btatt.service_uuid16, 10) == 0xFFF0
                and int(pkt.btatt.uuid16, 10) == 0xFFF4
            ):
                msg = unhexlify(pkt.btatt.value.raw_value)
                msg_buf += msg
                bytes_remaining -= len(msg)
                if bytes_remaining <= 0:
                    print_pkt_info(pkt)
                    process_msg(msg_buf)
                    state = State.CONNECTED
    cap.close()


if __name__ == "__main__":
    main()
