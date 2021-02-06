from capstone import CS_ARCH_ARM, CS_MODE_THUMB, Cs
from unicorn import (
    UC_ARCH_ARM,
    UC_HOOK_CODE,
    UC_HOOK_MEM_FETCH_UNMAPPED,
    UC_HOOK_MEM_READ_UNMAPPED,
    UC_HOOK_MEM_WRITE_UNMAPPED,
    UC_MODE_THUMB,
    Uc,
)
from unicorn.arm_const import (
    UC_ARM_REG_PC,
    UC_ARM_REG_R0,
    UC_ARM_REG_R1,
    UC_ARM_REG_R2,
    UC_ARM_REG_R3,
    UC_ARM_REG_R4,
    UC_ARM_REG_SP,
)

cs = Cs(CS_ARCH_ARM, CS_MODE_THUMB)

PAGE_SIZE = 0x1000
PAGE_MASK = 0xFFFFF000

STACK_SIZE = PAGE_SIZE
STACK_ADDR = 0xF0000000 + STACK_SIZE


def hook_block(uc, address, size, user_data):
    print(">>> Tracing basic block at 0x%X, block size = 0x%X" % (address, size))


def hook_mem_read(uc, access, address, size, value, user_data):
    print(">>> Memory READ at 0x%x, data size = %u" % (address, size))
    return True


def hook_mem_read_after(uc, access, address, size, value, user_data):
    if address < 0x38000:
        print(
            ">>> Memory READ at 0x%x, data size = %u, data value = 0x%x"
            % (address, size, value)
        )
    return True


def hook_mem_write(uc, access, address, size, value, user_data):
    if address < 0xF0000000:
        print(
            ">>> Memory WRITE at 0x%x, data size = %u, data value = 0x%x"
            % (address, size, value)
        )
    return True


def hook_mem_read_unmapped(uc, access, address, size, value, user_data):
    print(
        ">>> Unmapped memory READ at 0x%x, data size = %u, data value = 0x%x"
        % (address, size, value)
    )
    print(uc.last_instr)
    dump_hex_buf(uc, 0x20000000, 0x1000)
    return False


def hook_mem_write_unmapped(uc, access, address, size, value, user_data):
    print(
        ">>> Unmapped memory WRITE at 0x%x, data size = %u, data value = 0x%x"
        % (address, size, value)
    )
    print(uc.last_instr)
    dump_hex_buf(uc, 0x20000000, 0x1000)
    return False


def hook_mem_fetch_unmapped(uc, access, address, size, value, user_data):
    print(
        ">>> Unmapped memory FETCH at 0x%x, data size = %u, data value = 0x%x"
        % (address, size, value)
    )
    print(uc.last_instr)
    dump_hex_buf(uc, 0x20000000, 0x1000)
    return False


def hook_instr(mu: Uc, address, size, user_data):
    #  BL   sha1sum
    # if address == 0x0369F6:
    #     mu.reg_write(UC_ARM_REG_PC, address + size)
    # if address == 0x369F8:
    #     d = input()
    #     if d:
    #         dump_hex_buf(mu, 0x200000D8, 128)
    if address >= 0x3642A and address <= 0x3658A:
        # input()
        pass
    if address >= 0x0369E0 and address <= 0x36A00:
        print(
            ">>> Tracing instruction at 0x%X, instruction size = 0x%X" % (address, size)
        )
        R0 = mu.reg_read(UC_ARM_REG_R0)
        R1 = mu.reg_read(UC_ARM_REG_R1)
        R2 = mu.reg_read(UC_ARM_REG_R2)
        R3 = mu.reg_read(UC_ARM_REG_R3)
        R4 = mu.reg_read(UC_ARM_REG_R4)
        PC = mu.reg_read(UC_ARM_REG_PC)
        print(
            f"R0: {R0:08X}  R1: {R1:08X}  R2: {R2:08X}  "
            f"R3: {R3:08X}  R4: {R4:08X}  PC: {PC:08X}"
        )
        mem = mu.mem_read(address, size)
        for i in cs.disasm(mem, address):
            print(f"  0x{i.address:08X}:\t{i.mnemonic}\t{i.op_str}")
            # if i.mnemonic == "blx":
            #     print(f"[-] Skipping call to {R1:08X}")
            #     mu.reg_write(UC_ARM_REG_PC, address + size + 1)
        print()
        # dump_hex_buf(mu, R0, R1)

    mu.last_instr = (
        f">>> Tracing instruction at 0x{address:08X}, instruction size = 0x{size:X}\n"
    )
    R0 = mu.reg_read(UC_ARM_REG_R0)
    R1 = mu.reg_read(UC_ARM_REG_R1)
    R2 = mu.reg_read(UC_ARM_REG_R2)
    R3 = mu.reg_read(UC_ARM_REG_R3)
    R4 = mu.reg_read(UC_ARM_REG_R4)
    PC = mu.reg_read(UC_ARM_REG_PC)
    mu.last_instr += (
        f"R0: {R0:08X}  R1: {R1:08X}  R2: {R2:08X}  "
        f"R3: {R3:08X}  R4: {R4:08X}  PC: {PC:08X}\n"
    )

    # branch = False
    mem = mu.mem_read(address, size)
    for i in cs.disasm(mem, address):
        mu.last_instr += f"  0x{i.address:08X}:\t{i.mnemonic}\t{i.op_str}\n"
        # if i.mnemonic == "bl" or i.mnemonic == "blx":
        # print(mu.last_instr)
        # dump_hex_buf(mu, 0x200000D8, 128)


def dump_hex_buf(mu, addr, size):
    buf = mu.mem_read(addr, size)
    dump = ""
    i = 0
    while i < size:
        dump += f"{buf[i]:02X}"
        i += 1
        if i % 64 == 0:
            dump += "\n"
        elif i % 8 == 0:
            dump += "  "
        else:
            dump += " "
    print(dump)


def setup_hooks(mu: Uc):
    # tracing all basic blocks
    # mu.hook_add(UC_HOOK_BLOCK, hook_block)

    # hook select instructions
    mu.hook_add(UC_HOOK_CODE, hook_instr)

    # trace all memory reads
    # mu.hook_add(UC_HOOK_MEM_READ, hook_mem_read)
    # mu.hook_add(UC_HOOK_MEM_READ_AFTER, hook_mem_read_after)

    # mu.hook_add(UC_HOOK_MEM_WRITE, hook_mem_write)

    # hook unmapped memory operations
    mu.hook_add(UC_HOOK_MEM_READ_UNMAPPED, hook_mem_read_unmapped)
    mu.hook_add(UC_HOOK_MEM_WRITE_UNMAPPED, hook_mem_write_unmapped)
    mu.hook_add(UC_HOOK_MEM_FETCH_UNMAPPED, hook_mem_fetch_unmapped)


def setup_stack(mu: Uc):
    stack_base = STACK_ADDR - STACK_SIZE
    mu.mem_map(stack_base, STACK_SIZE)
    mu.reg_write(UC_ARM_REG_SP, STACK_ADDR)


def load_mem(mu: Uc, addr, size):
    filename = "7.4AT-02+V2.001.EFM.bin"
    data = None
    with open(filename, "rb") as fh:
        fh.seek(addr)
        data = fh.read(size)

    _addr = addr & PAGE_MASK
    _size = ((size) & PAGE_MASK) + PAGE_SIZE

    print(f"[+] Mapping Memory:\n\tAddress: {_addr:08X}\n\tSize: {_size:X}")
    mu.mem_map(_addr, _size)

    load_addr = addr
    load_size = size
    print(f"[>] Loading Memory:\n\tAddress: {load_addr:08X}\n\tSize: {load_size:X}")
    mu.mem_write(load_addr, data)


###########
# Main
###########
def main():
    mu = Uc(UC_ARCH_ARM, UC_MODE_THUMB)
    mu.last_instr = ""

    setup_hooks(mu)

    load_mem(mu, 0x9FD6, 0x9FF8 - 0x9FD6)
    load_mem(mu, 0x35000, 0x4000)

    sram_addr = 0x20000000 & PAGE_MASK
    sram_size = ((0x40000) & PAGE_MASK) + PAGE_SIZE
    mu.mem_map(sram_addr, sram_size)

    setup_stack(mu)

    # mu.reg_write(UC_ARM_REG_R0, gps_cfg['addr'])

    print("[Starting Emulation]")
    mu.emu_start(0x0369E0 | 1, 0x369FE)

    with open("data_0x200000D8_7bc.bin", "wb") as fh:
        mem = mu.mem_read(0x200000D8, 0x7BC)
        fh.write(mem)
        fh.close()

    print("[Done]")


if __name__ == "__main__":
    # execute only if run as a script
    main()

# zeroed
# 0x20000894
# 0x20002538

# 0x37196
# 0x3773D
# 0x200000D8
# 0x20000894
