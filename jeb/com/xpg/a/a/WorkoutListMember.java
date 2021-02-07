package com.xpg.a.a;

import java.io.Serializable;

public class WorkoutListMember implements Serializable {
    private int time;
    private int calories;
    private int distance;
    private int maxSpeed;
    private int averageSpeed;
    private int maxHR;
    private int averageHR;
    private int h;
    private int units;
    private int startYear;
    private int startMonth;
    private int startDay;
    private int startHour;
    private int startMinute;
    private int startSecond;

    public int getTime() {
        return this.time;
    }

    public void setTime(int arg1) {
        this.time = arg1;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setCalories(int arg1) {
        this.calories = arg1;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int arg1) {
        this.distance = arg1;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setMaxSpeed(int arg1) {
        this.maxSpeed = arg1;
    }

    public int getAverageSpeed() {
        return this.averageSpeed;
    }

    public void setAverageSpeed(int arg1) {
        this.averageSpeed = arg1;
    }

    public int getMaxHR() {
        return this.maxHR;
    }

    public void setMaxHR(int arg1) {
        this.maxHR = arg1;
    }

    public int getAverageHR() {
        return this.averageHR;
    }

    public void setAverageHR(int arg1) {
        this.averageHR = arg1;
    }

    public int getUnits() {
        return this.units;
    }

    public void h(int arg1) {
        this.h = arg1;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public void setUnits(int arg1) {
        this.units = arg1;
    }

    public int getStartMonth() {
        return this.startMonth;
    }

    public void setStartYear(int arg1) {
        this.startYear = arg1;
    }

    public int getStartDay() {
        return this.startDay;
    }

    public void setStartMonth(int arg1) {
        this.startMonth = arg1;
    }

    public int getStartHour() {
        return this.startHour;
    }

    public void setStartDay(int arg1) {
        this.startDay = arg1;
    }

    public int getStartMinute() {
        return this.startMinute;
    }

    public void setStartHour(int arg1) {
        this.startHour = arg1;
    }

    public int getStartSecond() {
        return this.startSecond;
    }

    public void setStartMinute(int arg1) {
        this.startMinute = arg1;
    }

    public void setStartSecond(int arg1) {
        this.startSecond = arg1;
    }
}
