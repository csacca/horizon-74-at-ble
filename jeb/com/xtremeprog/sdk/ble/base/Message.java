package com.xtremeprog.sdk.ble.base;

public class Message {
    public static enum ACK_TYPE {
        START_WORK_OUT,
        STOP_WORK_OUT,
        GET_MACHINEINFO,
        PAUSE_WORKOUT,
        RESTART_WORKOUT,
        SELECT_PROGRAM,
        CHANGE_WORKOUT,
        SET_SPEED,
        SET_INCLINE,
        SET_RESISTANCE,
        SET_DEFAULTS,
        GET_WORKOUT_DATA,
        SET_USER_DATA,
        GET_USER_DATA;

    }

    public static enum BLE_LINGO {
        BLE_LINGO_MUDULE_SETTINGS(0),
        BLE_LINGO_GENERAL(1),
        BLE_LINGO_REMOTE(2),
        BLE_LINGO_SYSTEM_SETTINGS(3),
        BLE_LINGO_WORKOUT_TRACKING(0x80);

        private int value;

        private BLE_LINGO(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static enum BLE_LINGO_GENERAL_COMMANDS {
        BLE_GET_MACHINE_INFO(2),
        BLE_SET_USER_DATA(15),
        BLE_GET_USER_DATA(16),
        BLE_GET_WORKOUT_DATA(18),
        BLE_STOP_WORKOUT(20);

        private int value;

        private BLE_LINGO_GENERAL_COMMANDS(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static enum BLE_LINGO_REMOTE_COMMANDS {
        BLE_REMOTE_ACKNOWLEDGMENT(0),
        BLE_SET_CURRENT_USER(1),
        BLE_START_WORKOUT(2),
        BLE_PAUSE_WORKOUT(3),
        BLE_CHANGE_WORKOUT(4),
        BLE_SET_SPEED(5),
        BLE_SET_INCLINE(6),
        BLE_SET_RESISTANCE(7),
        BLE_SELECT_PROGRAM(10),
        BLE_KEY_PRESS(11);

        private int value;

        private BLE_LINGO_REMOTE_COMMANDS(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static enum BLE_LINGO_SETTINGS_COMMANDS {
        BLE_SETTINGS_SET_DEFAULTS(1);

        private int value;

        private BLE_LINGO_SETTINGS_COMMANDS(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static enum BleHeader {
        SyncWord(43605);

        private int value;

        private BleHeader(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static enum RGenderType {
        RGender_Male(0),
        RGender_Female(1);

        private int value;

        private RGenderType(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static enum RLanguageType {
        RLanguageType_US(0),
        RLanguageType_UK(1);

        private int value;

        private RLanguageType(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static enum RProgramType {
        RProgramType_Manual(0),
        RProgramType_WeightLoss(1),
        RProgramType_WeightLossPlus(2),
        RProgramType_SpeedIntervals(3),
        RProgramType_EnduranceIntervals(4),
        RProgramType_PeakIntervals(5),
        RProgramType_HeartRateIntervals(6),
        RProgramType_FootHills(7),
        RProgramType_MountainClimb(10),
        RProgramType_5K(11),
        RProgramType_GerkinFitnessTest(30),
        RProgramType_TargetHeartRateZone(0x20),
        RProgramType_ArmyFitnessTest(33),
        RProgramType_NavyFitnessTest(34),
        RProgramType_AirForceFitnessTest(35),
        RProgramType_MarinesFitnewwTest(36),
        RProgramType_PEBFitnessTest(37),
        RProgramType_CooperFitnessTest(38),
        RProgramType_TargetHeartRateSpeedBased(39),
        RProgramType_TargetHeartRateIncline(45),
        RProgramType_TargetHeartRateResistance(46);

        private int value;

        private RProgramType(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static enum RSwitch {
        RSwitch_Off(0),
        RSwitch_On(1);

        private int value;

        private RSwitch(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static enum RTimeFormat {
        RTimeFormat_24H(0),
        RTimeFormat_12H(1);

        private int value;

        private RTimeFormat(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static enum RUnitsType {
        STANDARD(0),
        METRIC(1);

        private int value;

        private RUnitsType(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    public static int[] CRC_TABLE;
    public static int transactionId;

    static {
        Message.CRC_TABLE = new int[]{0, 0x1021, 0x2042, 0x3063, 0x4084, 0x50A5, 0x60C6, 0x70E7, 0x8108, 0x9129, 41290, 0xB16B, 0xC18C, 0xD1AD, 57806, 0xF1EF, 4657, 0x210, 0x3273, 8786, 0x52B5, 17044, 0x72F7, 25302, 0x9339, 33560, 0xB37B, 0xA35A, 54205, 50076, 0xF3FF, 0xE3DE, 9314, 0x3443, 0x420, 0x1401, 25830, 0x74C7, 0x44A4, 0x5485, 0xA56A, 0xB54B, 34088, 0x9509, 0xE5EE, 0xF5CF, 50604, 0xD58D, 13907, 9842, 5649, 0x630, 30423, 0x66F6, 0x5695, 18100, 0xB75B, 0xA77A, 0x9719, 0x8738, 0xF7DF, 0xE7FE, 0xD79D, 0xC7BC, 0x48C4, 0x58E5, 0x6886, 30887, 0x840, 6241, 0x2802, 0x3823, 51660, 0xD9ED, 59790, 0xF9AF, 0x8948, 0x9969, 0xA90A, 47403, 0x5AF5, 0x4AD4, 0x7AB7, 0x6A96, 6769, 0xA50, 0x3A33, 10770, 0xDBFD, 0xCBDC, 0xFBBF, 60318, 39801, 0x8B58, 0xBB3B, 43802, 0x6CA6, 0x7C87, 0x4CE4, 0x5CC5, 0x2C22, 0x3C03, 0xC60, 7233, 60846, 0xFD8F, 0xCDEC, 0xDDCD, 44330, 0xBD0B, 36200, 40265, 32407, 0x6EB6, 0x5ED5, 0x4EF4, 0x3E13, 0x2E32, 7761, 0xE70, 0xFF9F, 0xEFBE, 0xDFDD, 0xCFFC, 0xBF1B, 0xAF3A, 0x9F59, 0x8F78, 0x9188, 0x81A9, 0xB1CA, 0xA1EB, 0xD10C, 0xC12D, 0xF14E, 0xE16F, 0x1080, 0xA1, 0x30C2, 0x20E3, 0x5004, 0x4025, 0x7046, 0x6067, 0x83B9, 0x9398, 0xA3FB, 46042, 0xC33D, 54044, 0xE37F, 0xF35E, 689, 0x1290, 0x22F3, 13010, 0x4235, 21012, 25207, 29270, 46570, 0xA5CB, 0x95A8, 0x8589, 0xF56E, 0xE54F, 0xD52C, 0xC50D, 0x34E2, 9411, 5280, 0x481, 0x7466, 0x6447, 21540, 0x4405, 0xA7DB, 0xB7FA, 0x8799, 38840, 0xE75F, 0xF77E, 50973, 55100, 9939, 0x36F2, 0x691, 5808, 0x6657, 30326, 0x4615, 22068, 0xD94C, 0xC96D, 0xF90E, 0xE92F, 0x99C8, 35305, 0xB98A, 0xA9AB, 0x5844, 0x4865, 0x7806, 0x6827, 0x18C0, 0x8E1, 0x3882, 10403, 52093, 0xDB5C, 0xEB3F, 0xFB1E, 0x8BF9, 0x9BD8, 0xABBB, 48026, 19061, 0x5A54, 0x6A37, 0x7A16, 0xAF1, 0x1AD0, 10931, 0x3A92, 0xFD2E, 0xED0F, 0xDD6C, 0xCD4D, 0xBDAA, 0xAD8B, 40424, 0x8DC9, 0x7C26, 0x6C07, 0x5C64, 0x4C45, 0x3CA2, 0x2C83, 0x1CE0, 0xCC1, 0xEF1F, 0xFF3E, 0xCF5D, 0xDF7C, 0xAF9B, 0xBFBA, 0x8FD9, 0x9FF8, 0x6E17, 32310, 20053, 24180, 0x2E93, 16050, 0xED1, 0x1EF0};
        Message.transactionId = 0;
    }
}
