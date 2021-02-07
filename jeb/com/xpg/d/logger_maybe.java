package com.xpg.d;

import android.os.Environment;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

public class logger_maybe {
    private static String a;
    private static boolean b;
    private static boolean c;
    private static String d;

    static {
        logger_maybe.a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/treadmillblesdk/";
        logger_maybe.b = true;
        logger_maybe.c = false;
        logger_maybe.d = "";
    }

    public static void a(String arg1, String arg2) {
        if(logger_maybe.b) {
            Log.v(arg1, arg2);
        }

        logger_maybe.f(arg1, arg2);
    }

    public static void b(String arg1, String arg2) {
        if(logger_maybe.b) {
            Log.d(arg1, arg2);
        }

        logger_maybe.f(arg1, arg2);
    }

    public static void log(String arg1, String arg2) {
        if(logger_maybe.b) {
            Log.i(arg1, arg2);
        }

        logger_maybe.f(arg1, arg2);
    }

    public static void d(String arg1, String arg2) {
        if(logger_maybe.b) {
            Log.w(arg1, arg2);
        }

        logger_maybe.f(arg1, arg2);
    }

    public static void e(String arg1, String arg2) {
        if(logger_maybe.b) {
            Log.e(arg1, arg2);
        }

        logger_maybe.f(arg1, arg2);
    }

    private static void f(String arg4, String arg5) {
        if((logger_maybe.c) && ((logger_maybe.d.equals("")) || (logger_maybe.d.equals(arg4)))) {
            String v4 = new SimpleDateFormat("MMddHH:mm:ss:SSS").format(new Date());
            b.a().a(v4.substring(4) + " - " + arg5 + "\n", logger_maybe.a + v4.substring(0, 4) + "log.txt");
        }
    }
}
