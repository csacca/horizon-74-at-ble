package com.xpg.a.a;

import java.io.Serializable;
import java.util.Arrays;

public class CustomHRProgramReceive implements Serializable {
    private int userId;
    private int totalTime;
    private int age;
    private Segment[] segmentArray;

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int arg1) {
        this.userId = arg1;
    }

    public void a(Segment[] arg1) {
        this.segmentArray = arg1;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(int arg1) {
        this.totalTime = arg1;
    }

    public Segment[] getSegments() {
        return this.segmentArray;
    }

    @Override
    public String toString() {
        return "CustomHRProgramReceive{userId=" + this.userId + ", totalTime=" + this.totalTime + ", age=" + this.age + ", segmentArray=" + Arrays.toString(this.segmentArray) + '}';
    }
}
