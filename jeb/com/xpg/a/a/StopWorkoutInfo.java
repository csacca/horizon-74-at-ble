package com.xpg.a.a;

import java.io.Serializable;

public class StopWorkoutInfo implements Serializable {
    private WorkoutListMember a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public WorkoutListMember a() {
        return this.a;
    }

    public void a(int arg1) {
        this.b = arg1;
    }

    public void a(WorkoutListMember arg1) {
        this.a = arg1;
    }

    public int b() {
        return this.b;
    }

    public void b(int arg1) {
        this.c = arg1;
    }

    public int c() {
        return this.c;
    }

    public void c(int arg1) {
        this.d = arg1;
    }

    public int d() {
        return this.d;
    }

    public void d(int arg1) {
        this.e = arg1;
    }

    public int e() {
        return this.e;
    }

    public void e(int arg1) {
        this.f = arg1;
    }

    public int f() {
        return this.f;
    }

    public void f(int arg1) {
        this.g = arg1;
    }

    public int g() {
        return this.h;
    }

    public void g(int arg1) {
        this.h = arg1;
    }

    @Override
    public String toString() {
        return "StopWorkoutInfo [workoutInfo=" + this.a + ", pace=" + this.b + ", myFirst5kWeek=" + this.c + ", myFirst5kWorkout=" + this.d + ", myFirst5kNextWorkoutInDays=" + this.e + ", myFirst5kFinished=" + this.f + "]";
    }
}
