package com.xpg.a.a;

import java.io.Serializable;

public class WorkoutData implements Serializable {
    private int nextSpeed;
    private int nextResistance;
    private int totalTime;
    private int sprintCount;
    private String userExternalId;
    private int programType;
    private int workoutState;
    private int workoutStage;
    private int stageTime;
    private int workoutTime;
    private int warmUpTime;
    private int coolDownTime;
    private int timeInState;
    private int timeInStage;
    private int MPH;
    private int incline;
    private int averagePace;
    private int totalCalories;
    private int caloriesPerHour;
    private int mets;
    private int watts;
    private int miles;
    private int HeartRate;
    private int averageHeartRate;
    private int RPM;
    private int programLevel;
    private int resistanceLevel;
    private int targetHeartRate;
    private int targetWatts;
    private int nextIncline;

    public void setNextSpeed(int arg1) {
        this.nextSpeed = arg1;
    }

    public void setNextResistance(int arg1) {
        this.nextResistance = arg1;
    }

    public void setTotalTime(int arg1) {
        this.totalTime = arg1;
    }

    public int getSprintCount() {
        return this.sprintCount;
    }

    public void setSprintCount(int arg1) {
        this.sprintCount = arg1;
    }

    public void setUserExternalId(String arg1) {
        this.userExternalId = arg1;
    }

    public int getWorkoutTime() {
        return this.workoutTime;
    }

    public void setProgramType(int arg1) {
        this.programType = arg1;
    }

    public int getMPH() {
        return this.MPH;
    }

    public void setWorkoutState(int arg1) {
        this.workoutState = arg1;
    }

    public int getIncline() {
        return this.incline;
    }

    public void setWorkoutStage(int arg1) {
        this.workoutStage = arg1;
    }

    public int getAveragePace() {
        return this.averagePace;
    }

    public void setStageTime(int arg1) {
        this.stageTime = arg1;
    }

    public int getTotalCalories() {
        return this.totalCalories;
    }

    public void setWorkoutTime(int arg1) {
        this.workoutTime = arg1;
    }

    public int getCaloriesPerHour() {
        return this.caloriesPerHour;
    }

    public void setWarmUpTime(int arg1) {
        this.warmUpTime = arg1;
    }

    public int getMets() {
        return this.mets;
    }

    public void setCoolDownTime(int arg1) {
        this.coolDownTime = arg1;
    }

    public int getWatts() {
        return this.watts;
    }

    public void setTimeInState(int arg1) {
        this.timeInState = arg1;
    }

    public int getMiles() {
        return this.miles;
    }

    public void setTimeInStage(int arg1) {
        this.timeInStage = arg1;
    }

    public int getHeartRate() {
        return this.HeartRate;
    }

    public void setMPH(int arg1) {
        this.MPH = arg1;
    }

    public int getAverageHeartRate() {
        return this.averageHeartRate;
    }

    public void setIncline(int arg1) {
        this.incline = arg1;
    }

    public int getRPM() {
        return this.RPM;
    }

    public void setAveragePace(int arg1) {
        this.averagePace = arg1;
    }

    public int getResistanceLevel() {
        return this.resistanceLevel;
    }

    public void setTotalCalories(int arg1) {
        this.totalCalories = arg1;
    }

    public int getTargetHeartRate() {
        return this.targetHeartRate;
    }

    public void setCaloriesPerHour(int arg1) {
        this.caloriesPerHour = arg1;
    }

    public int getNextIncline() {
        return this.nextIncline;
    }

    public void setMets(int arg1) {
        this.mets = arg1;
    }

    public int setTotalTime() {
        return this.totalTime;
    }

    public void setWatts(int arg1) {
        this.watts = arg1;
    }

    public void clear() {
        this.userExternalId = "";
        this.programType = 0;
        this.workoutState = 0;
        this.workoutStage = 0;
        this.stageTime = 0;
        this.workoutTime = 0;
        this.warmUpTime = 0;
        this.coolDownTime = 0;
        this.timeInState = 0;
        this.timeInStage = 0;
        this.MPH = 0;
        this.incline = 0;
        this.averagePace = 0;
        this.totalCalories = 0;
        this.caloriesPerHour = 0;
        this.mets = 0;
        this.watts = 0;
        this.miles = 0;
        this.HeartRate = 0;
        this.averageHeartRate = 0;
        this.RPM = 0;
        this.programLevel = 0;
        this.resistanceLevel = 0;
        this.targetHeartRate = 0;
        this.targetWatts = 0;
        this.nextIncline = 0;
        this.nextSpeed = 0;
        this.nextResistance = 0;
        this.totalTime = 0;
    }

    public void setMiles(int arg1) {
        this.miles = arg1;
    }

    public void setHeartRate(int arg1) {
        this.HeartRate = arg1;
    }

    public void setAverageHeartRate(int arg1) {
        this.averageHeartRate = arg1;
    }

    @Override
    public String toString() {
        return "WorkoutData{userExternalId=\'" + this.userExternalId + '\'' + ", programType=" + this.programType + ", workoutState=" + this.workoutState + ", workoutStage=" + this.workoutStage + ", stageTime=" + this.stageTime + ", workoutTime=" + this.workoutTime + ", warmUpTime=" + this.warmUpTime + ", coolDownTime=" + this.coolDownTime + ", timeInState=" + this.timeInState + ", timeInStage=" + this.timeInStage + ", MPH=" + this.MPH + ", incline=" + this.incline + ", averagePace=" + this.averagePace + ", totalCalories=" + this.totalCalories + ", caloriesPerHour=" + this.caloriesPerHour + ", mets=" + this.mets + ", watts=" + this.watts + ", miles=" + this.miles + ", HeartRate=" + this.HeartRate + ", averageHeartRate=" + this.averageHeartRate + ", RPM=" + this.RPM + ", programLevel=" + this.programLevel + ", resistanceLevel=" + this.resistanceLevel + ", targetHeartRate=" + this.targetHeartRate + ", targetWatts=" + this.targetWatts + ", nextIncline=" + this.nextIncline + ", nextSpeed=" + this.nextSpeed + ", nextResistance=" + this.nextResistance + ", totalTime=" + this.totalTime + ", sprintCount=" + this.sprintCount + '}';
    }

    public void setRPM(int arg1) {
        this.RPM = arg1;
    }

    public void setProgramLevel(int arg1) {
        this.programLevel = arg1;
    }

    public void setResistanceLevel(int arg1) {
        this.resistanceLevel = arg1;
    }

    public void setTargetHeartRate(int arg1) {
        this.targetHeartRate = arg1;
    }

    public void setTargetWatts(int arg1) {
        this.targetWatts = arg1;
    }

    public void setNextIncline(int arg1) {
        this.nextIncline = arg1;
    }
}
