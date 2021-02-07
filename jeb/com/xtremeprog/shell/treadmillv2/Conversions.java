package com.xtremeprog.shell.treadmillv2;

import android.content.Context;

public class Conversions {
    public static double a(double arg4) {
        return arg4 == 0.0 ? 0.0 : arg4 * 1000.0 * 125000.0 / 201168.0 / 1000.0 + 0.01;
    }

    public static double km_to_mi(float km) {
        return (double)(km / 1.609f);
    }

    public static int a(int arg1) {
        return 0;
    }

    public static int a(Context arg4) {
        int v4 = AppsRunner.get(arg4).m(arg4);
        if(v4 == 51) {
            return 0x94;
        }

        if(v4 == 52) {
            return 0x93;
        }

        if(v4 == 54) {
            return 0x9F;
        }

        if(v4 == 55) {
            return 170;
        }

        if(v4 == 57) {
            return 0x94;
        }

        return v4 == 58 ? 0x93 : 0x9F;
    }

    public static int kilocalorie_to_joule(Context arg0, int kilocalorie) {
        return kilocalorie * 0x105A;
    }

    public static double b(double arg4) {
        return arg4 == 0.0 ? 0.0 : (arg4 * 1000.0 * 201168.0 / 125000.0 + 2.0) / 1000.0;
    }

    public static int b(int arg1) {
        return 0;
    }

    public static int b(Context arg3) {
        int v3 = AppsRunner.get(arg3).m(arg3);
        if(v3 == 51) {
            return 325;
        }

        if(v3 == 52) {
            return 325;
        }

        if(v3 == 54) {
            return 350;
        }

        if(v3 == 55) {
            return 375;
        }

        if(v3 == 57) {
            return 325;
        }

        return v3 == 58 ? 325 : 350;
    }

    public static double mi_to_km(double mi) {
        return mi * 1.609;
    }

    public static int c(Context arg0) {
        return 23;
    }

    public static int lb_to_kg(double lb) {
        return (int)Math.round(lb * 0.453592);
    }

    public static int d(Context arg0) {
        return 50;
    }

    public static int kg_to_lb(double kg) {
        return (int)Math.round(kg / 0.453592);
    }
}
