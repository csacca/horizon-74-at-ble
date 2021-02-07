package com.xpg.a.c;

import com.xpg.a.b.CustomHRProgram;
import com.xpg.a.b.CustomProgram;
import com.xpg.a.b.MyFirst5k;
import com.xpg.a.b.UserInfo;
import com.xpg.a.b.Workout;
import java.util.List;

public class Factory {
    public static CustomHRProgram a(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14) {
        CustomHRProgram v0 = new CustomHRProgram();
        v0.a(arg1);
        v0.b(arg2);
        v0.c(arg3);
        v0.e(arg4);
        v0.d(arg5);
        v0.f(arg6);
        v0.h(arg7);
        v0.g(arg8);
        v0.i(arg9);
        v0.k(arg10);
        v0.j(arg11);
        v0.l(arg12);
        v0.n(arg13);
        v0.m(arg14);
        return v0;
    }

    public static CustomProgram customProgram(int arg1, List arg2, List arg3) {
        CustomProgram v0 = new CustomProgram();
        v0.d(arg1);
        v0.a(arg2);
        v0.b(arg3);
        return v0;
    }

    public static Workout a(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        Workout v0 = new Workout();
        v0.s_10_11(arg1);
        v0.s_12_13(arg2);
        v0.s_14_15(arg3);
        v0.s_16_17(arg4);
        v0.b_18(arg5);
        v0.s_19_20_maybe_speed(arg6);
        v0.s_21_22_maybe_incline(arg7);
        v0.b_23(arg8);
        v0.b_26(arg9);
        return v0;
    }

    public static Workout workout(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
        Workout v0 = new Workout();
        v0.s_10_11(arg1);
        v0.s_12_13(arg2);
        v0.s_14_15(arg3);
        v0.s_16_17(arg4);
        v0.b_18(arg5);
        v0.s_19_20_maybe_speed(arg6);
        v0.s_21_22_maybe_incline(arg7);
        v0.b_23(arg8);
        v0.s_24_25(arg9);
        v0.b_26(arg10);
        return v0;
    }

    public static MyFirst5k MyFirst5K(int userId, int week, int workout, double walkSpeed, double jogSpeed, int resetCount) {
        MyFirst5k v0 = new MyFirst5k();
        v0.setUserId(userId);
        v0.setWeek(week);
        v0.setWorkout(workout);
        v0.setWalkSpeed(((int)(walkSpeed * 10.0)));
        v0.setJogSpeed(((int)(jogSpeed * 10.0)));
        v0.setResetCount(resetCount);
        return v0;
    }

    public static UserInfo userData(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14) {
        UserInfo v14 = new UserInfo();
        v14.a(arg0);
        v14.b(arg1);
        v14.c(arg2);
        v14.d(arg3);
        v14.e(arg4);
        v14.f(arg5);
        v14.g(arg6);
        v14.h(arg7);
        v14.i(arg8);
        v14.a(arg9);
        v14.c(arg11);
        v14.b(arg10);
        v14.d(arg12);
        v14.e(arg13);
        return v14;
    }
}
