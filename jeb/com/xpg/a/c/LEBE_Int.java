package com.xpg.a.c;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class LEBE_Int {
    public static int decode(byte arg3, byte arg4) {
        return ByteBuffer.wrap(new byte[]{0, 0, arg3, arg4}).getInt();
    }

    public static String toString(byte[] src, int srcPos, int length) {
        byte[] dest = new byte[length];
        System.arraycopy(src, srcPos, dest, 0, length);
        int i = 1;
        byte[] v4;
        for(v4 = new byte[]{1}; i < dest.length; v4 = dest) {
            if(dest[i] == 0) {
                v4 = new byte[i];
                System.arraycopy(dest, 0, v4, 0, v4.length);
                break;
            }

            ++i;
        }

        try {
            return new String(v4, "ASCII");
        }
        catch(UnsupportedEncodingException v3_1) {
            v3_1.printStackTrace();
            return "";
        }
    }

    // String Decryptor: 2 succeeded, 0 failed
    public static byte[] encode(int arg4) {
        byte[] v0 = new byte[2];
        int v1;
        for(v1 = 0; v1 < v0.length; ++v1) {
            v0[v1] = new Integer(arg4 & 0xFF).byteValue();
            arg4 >>= 8;
        }

        return v0;
    }
}
