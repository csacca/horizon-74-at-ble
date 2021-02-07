package com.xpg.d;

import com.xpg.a.c.LEBE_Int;

public class a {
    public static String a(byte arg2) {
        String v2 = Integer.toHexString(arg2 & 0xFF);
        return v2.length() == 1 ? "0" + v2 : v2;
    }

    public static String a(byte[] arg3) {
        StringBuilder v0 = new StringBuilder();
        if(arg3 != null && arg3.length > 0) {
            int v1;
            for(v1 = 0; v1 < arg3.length; ++v1) {
                v0.append(a.a(arg3[v1]));
            }

            return v0.toString();
        }

        return null;
    }

    public static void log(String arg2, String arg3) {
        logger_maybe.log("jLog_" + arg2, arg2 + ":" + arg3);
    }

    public static void a(String arg3, byte[] arg4) {
        String v0 = "";
        int v1;
        for(v1 = 0; v1 < arg4.length; ++v1) {
            v0 = v0 + a.a(arg4[v1]) + " ";
        }

        a.log(arg3, v0);
    }

    public static byte[] byteStrToByteArray(String buf) {
        byte[] v0 = new byte[buf.length() / 2];
        int v1;
        for(v1 = 0; v1 < v0.length; ++v1) {
            int v2 = v1 * 2;
            v0[v1] = (byte)Integer.parseInt(buf.substring(v2, v2 + 2), 16);
        }

        return v0;
    }

    public static int decodeInt(String encodedInt) {
        return LEBE_Int.decode(((byte)Integer.parseInt(encodedInt.substring(2, 4), 16)), ((byte)Integer.parseInt(encodedInt.substring(0, 2), 16)));
    }
}
