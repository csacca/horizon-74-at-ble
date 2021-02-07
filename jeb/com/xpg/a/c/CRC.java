package com.xpg.a.c;

import com.xpg.a.b.CustomHRProgram;
import com.xpg.a.b.CustomProgram.a;
import com.xpg.a.b.CustomProgram.b;
import com.xpg.a.b.CustomProgram;
import java.util.List;

public class CRC {
    static String a = "7F BE 6C 6D 09 DF 09 A8 09 FB 00 00 00 01 37 02 A5 02 75 02 18 00 46 00 9F 00 99 00 19 00 1A 00 0F 03 AD 03 DA 03 E3 00 46 00 9F 00 99 00 19 00 1A 00 0F 00";
    public static int[] crc16_ccitt_table;

    static {
        CRC.crc16_ccitt_table = new int[]{0, 0x1021, 0x2042, 0x3063, 0x4084, 0x50A5, 0x60C6, 0x70E7, 0x8108, 0x9129, 41290, 0xB16B, 0xC18C, 0xD1AD, 57806, 0xF1EF, 4657, 0x210, 0x3273, 8786, 0x52B5, 17044, 0x72F7, 25302, 0x9339, 33560, 0xB37B, 0xA35A, 54205, 50076, 0xF3FF, 0xE3DE, 9314, 0x3443, 0x420, 0x1401, 25830, 0x74C7, 0x44A4, 0x5485, 0xA56A, 0xB54B, 34088, 0x9509, 0xE5EE, 0xF5CF, 50604, 0xD58D, 13907, 9842, 5649, 0x630, 30423, 0x66F6, 0x5695, 18100, 0xB75B, 0xA77A, 0x9719, 0x8738, 0xF7DF, 0xE7FE, 0xD79D, 0xC7BC, 0x48C4, 0x58E5, 0x6886, 30887, 0x840, 6241, 0x2802, 0x3823, 51660, 0xD9ED, 59790, 0xF9AF, 0x8948, 0x9969, 0xA90A, 47403, 0x5AF5, 0x4AD4, 0x7AB7, 0x6A96, 6769, 0xA50, 0x3A33, 10770, 0xDBFD, 0xCBDC, 0xFBBF, 60318, 39801, 0x8B58, 0xBB3B, 43802, 0x6CA6, 0x7C87, 0x4CE4, 0x5CC5, 0x2C22, 0x3C03, 0xC60, 7233, 60846, 0xFD8F, 0xCDEC, 0xDDCD, 44330, 0xBD0B, 36200, 40265, 32407, 0x6EB6, 0x5ED5, 0x4EF4, 0x3E13, 0x2E32, 7761, 0xE70, 0xFF9F, 0xEFBE, 0xDFDD, 0xCFFC, 0xBF1B, 0xAF3A, 0x9F59, 0x8F78, 0x9188, 0x81A9, 0xB1CA, 0xA1EB, 0xD10C, 0xC12D, 0xF14E, 0xE16F, 0x1080, 0xA1, 0x30C2, 0x20E3, 0x5004, 0x4025, 0x7046, 0x6067, 0x83B9, 0x9398, 0xA3FB, 46042, 0xC33D, 54044, 0xE37F, 0xF35E, 689, 0x1290, 0x22F3, 13010, 0x4235, 21012, 25207, 29270, 46570, 0xA5CB, 0x95A8, 0x8589, 0xF56E, 0xE54F, 0xD52C, 0xC50D, 0x34E2, 9411, 5280, 0x481, 0x7466, 0x6447, 21540, 0x4405, 0xA7DB, 0xB7FA, 0x8799, 38840, 0xE75F, 0xF77E, 50973, 55100, 9939, 0x36F2, 0x691, 5808, 0x6657, 30326, 0x4615, 22068, 0xD94C, 0xC96D, 0xF90E, 0xE92F, 0x99C8, 35305, 0xB98A, 0xA9AB, 0x5844, 0x4865, 0x7806, 0x6827, 0x18C0, 0x8E1, 0x3882, 10403, 52093, 0xDB5C, 0xEB3F, 0xFB1E, 0x8BF9, 0x9BD8, 0xABBB, 48026, 19061, 0x5A54, 0x6A37, 0x7A16, 0xAF1, 0x1AD0, 10931, 0x3A92, 0xFD2E, 0xED0F, 0xDD6C, 0xCD4D, 0xBDAA, 0xAD8B, 40424, 0x8DC9, 0x7C26, 0x6C07, 0x5C64, 0x4C45, 0x3CA2, 0x2C83, 0x1CE0, 0xCC1, 0xEF1F, 0xFF3E, 0xCF5D, 0xDF7C, 0xAF9B, 0xBFBA, 0x8FD9, 0x9FF8, 0x6E17, 32310, 20053, 24180, 0x2E93, 16050, 0xED1, 0x1EF0};
    }

    public static int getCustomHRProgramCRC(CustomHRProgram arg5) {
        byte[] v0 = new byte[16];
        int v2 = 0;
        v0[0] = (byte)arg5.a();
        v0[1] = LEBE_Int.encode(arg5.b())[0];
        v0[2] = LEBE_Int.encode(arg5.b())[1];
        v0[3] = (byte)arg5.c();
        v0[4] = LEBE_Int.encode(arg5.d())[0];
        v0[5] = LEBE_Int.encode(arg5.d())[1];
        v0[6] = (byte)arg5.e();
        v0[7] = LEBE_Int.encode(arg5.g())[0];
        v0[8] = LEBE_Int.encode(arg5.g())[1];
        v0[9] = (byte)arg5.h();
        v0[10] = LEBE_Int.encode(arg5.j())[0];
        v0[11] = LEBE_Int.encode(arg5.j())[1];
        v0[12] = (byte)arg5.k();
        v0[13] = LEBE_Int.encode(arg5.m())[0];
        v0[14] = LEBE_Int.encode(arg5.m())[1];
        v0[15] = (byte)arg5.n();
        System.out.println("SDK_log:");
        while(v2 < v0.length) {
            System.out.print("" + Integer.toHexString(v0[v2] & 0xFF) + " ");
            ++v2;
        }

        System.out.println();
        int v5 = CRC.getCRC(v0, v0.length);
        System.out.println("CRC:" + v5);
        return v5;
    }

    public static int getCustomProgramCRC(CustomProgram arg9) {
        List v0 = arg9.setCustom1();
        List v1 = arg9.setCustom2();
        byte[] v2 = new byte[v0.size() * 5 + 1 + v1.size() * 5 + 2];
        int v6 = 0;
        v2[0] = (byte)arg9.getUserId();
        v2[1] = (byte)arg9.getTimeSegmentNumber();
        v2[2] = (byte)arg9.getDistanceSegmentNumber();
        int v9;
        for(v9 = 0; v9 < v0.size(); ++v9) {
            int v5 = v9 * 5;
            v2[v5 + 3] = LEBE_Int.encode(((b)v0.get(v9)).a())[0];
            v2[v5 + 4] = LEBE_Int.encode(((b)v0.get(v9)).a())[1];
            v2[v5 + 5] = LEBE_Int.encode(((b)v0.get(v9)).b())[0];
            v2[v5 + 6] = LEBE_Int.encode(((b)v0.get(v9)).b())[1];
            v2[v5 + 7] = (byte)((b)v0.get(v9)).c();
        }

        int v9_1;
        for(v9_1 = 0; v9_1 < v1.size(); ++v9_1) {
            int v7 = v9_1 * 5;
            v2[v0.size() * 5 + v7 + 3] = LEBE_Int.encode(((a)v1.get(v9_1)).a())[0];
            v2[v0.size() * 5 + v7 + 4] = LEBE_Int.encode(((a)v1.get(v9_1)).a())[1];
            v2[v0.size() * 5 + v7 + 5] = LEBE_Int.encode(((a)v1.get(v9_1)).b())[0];
            v2[v0.size() * 5 + v7 + 6] = LEBE_Int.encode(((a)v1.get(v9_1)).b())[1];
            v2[v0.size() * 5 + v7 + 7] = (byte)((a)v1.get(v9_1)).c();
        }

        System.out.println("SDK_log:");
        while(v6 < v2.length) {
            System.out.print("" + Integer.toHexString(v2[v6] & 0xFF) + " ");
            ++v6;
        }

        System.out.println();
        int v9_2 = CRC.getCRC(v2, v2.length);
        System.out.println("CRC:" + v9_2);
        return v9_2;
    }

    public static int getCRC(byte[] buf, int len) {
        int v0 = 0;
        if(len == 0) {
            return 0;
        }

        int crc16 = 0xFFFF;
        while(v0 < len) {
            crc16 = crc16 << 8 & 0xFF00 ^ CRC.crc16_ccitt_table[buf[v0] & 0xFF & 0xFF ^ (crc16 & 0xFF00) >> 8];
            ++v0;
        }

        return crc16;
    }
}
