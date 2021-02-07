package com.xpg.d;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class b {
    private static b a;

    static {
    }

    public static b a() {
        if(b.a == null) {
            Class v0 = b.class;
            synchronized(v0) {
                if(b.a == null) {
                    b.a = new b();
                }

                return b.a;
            }
        }

        return b.a;
    }

    private void a(String arg2) {
        File v0 = new File(arg2);
        if(!v0.exists()) {
            v0.mkdirs();
        }
    }

    public void a(String arg4, String arg5) {
        try {
            this.a(arg5.substring(0, arg5.lastIndexOf("/") + 1));
            if(!new File(arg5).exists()) {
                this.b(arg5);
            }

            FileWriter v0 = new FileWriter(arg5, true);
            v0.write(arg4);
            v0.flush();
            v0.close();
        }
        catch(Exception v4) {
            v4.printStackTrace();
        }
    }

    private void b(String arg2) {
        FileOutputStream v0 = new FileOutputStream(arg2);
        v0.write("".getBytes());
        v0.flush();
        v0.close();
    }
}
