# Reverse Engineering of the Horizon 7.4 AT (-02) Treadmill

## Analyzed software

- Horizon 7.4 AT Treadmill Firmware: [7.4AT-02 (TM746B or TM499B) Treadmill V2.001](https://cdn.horizonfitness.rocks/content/5321/Horizon-7.4.zip)
  - `7.4AT-02+V2.001.EFM.bin`
  - SHA-256: `f7e6f57a15f69bdf68c484cef338a42265723f788b140950ee169e0a3761e8c3`
- Android App: "AFG Pro Fitness" (com.xtremeprog.shell.treadmillv2)
  - `AFG Pro Fitness_v1.5.8_apkpure.com.apk`
  - SHA-256: `e296302f6766eb169b105b2406d0870124f015b2f2b55fb115409ffa480687ca`

## Reverse engineering artifacts

- IDA Pro 7.5 database: `ida/7.4AT-02+V2.001.EFM.bin.idb`
- JEB 3.28 project: `jeb/AFG Pro Fitness_v1.5.8_apkpure.com.apk.jdb2`

## Instantiating a virtual environment

    python3 -m venv ./env
    source ./env/bin/activate
    pip3 install -r requirements.txt

## Analyzing a Bluetooth HCI snoop log

    ./parse_btsnoop.py btsnoop_hci.log
