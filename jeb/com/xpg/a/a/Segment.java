package com.xpg.a.a;

import java.io.Serializable;

public class Segment implements Serializable {
    private int a;
    private int b;
    private int c;

    public int getSegmentTime() {
        return this.a;
    }

    public void setSegmentTime(int arg1) {
        this.a = arg1;
    }

    public int getTargetHR() {
        return this.b;
    }

    public void setTargetHR(int arg1) {
        this.b = arg1;
    }

    public int getAge() {
        return this.c;
    }

    public void setAge(int arg1) {
        this.c = arg1;
    }

    @Override
    public String toString() {
        return "Segment + time=" + this.a + ", targetHR=" + this.b + "]";
    }
}
