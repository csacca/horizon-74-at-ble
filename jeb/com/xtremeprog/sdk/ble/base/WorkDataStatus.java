package com.xtremeprog.sdk.ble.base;

public class WorkDataStatus {
    public static enum BLE_WORK_STATUS {
        BLE_WORK_STATUS_STOPPED(0),
        BLE_WORK_STATUS_STARTED(1),
        BLE_WORK_STATUS_PAUSED(2);

        private int value;

        private BLE_WORK_STATUS(int arg3) {
            this.value = arg3;
        }

        public int getInt() {
            return this.value;
        }
    }

    private int coolDownTime;
    private int headTag;
    private int pauseTag;
    private int programType;
    private int startInclineX10;
    private int startResistance;
    private int startSpeedX10;
    private int units;
    private int warmUpTime;
    private int workoutTime;

    public WorkDataStatus() {
    }

    public WorkDataStatus(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
        this.headTag = arg1;
        this.programType = arg2;
        this.workoutTime = arg3;
        this.warmUpTime = arg4;
        this.coolDownTime = arg5;
        this.units = arg6;
        this.startSpeedX10 = arg7;
        this.startInclineX10 = arg8;
        this.startResistance = arg9;
        this.pauseTag = arg10;
    }

    public int getCoolDownTime() {
        return this.coolDownTime;
    }

    public int getHeadTag() {
        return this.headTag;
    }

    public int getPauseTag() {
        return this.pauseTag;
    }

    public int getProgramType() {
        return this.programType;
    }

    public int getStartInclineX10() {
        return this.startInclineX10;
    }

    public int getStartResistance() {
        return this.startResistance;
    }

    public int getStartSpeedX10() {
        return this.startSpeedX10;
    }

    public int getUnits() {
        return this.units;
    }

    public int getWarmUpTime() {
        return this.warmUpTime;
    }

    public int getWorkoutTime() {
        return this.workoutTime;
    }

    public void setCoolDownTime(int arg1) {
        this.coolDownTime = arg1;
    }

    public void setHeadTag(int arg1) {
        this.headTag = arg1;
    }

    public void setPauseTag(int arg1) {
        this.pauseTag = arg1;
    }

    public void setProgramType(int arg1) {
        this.programType = arg1;
    }

    public void setStartInclineX10(int arg1) {
        this.startInclineX10 = arg1;
    }

    public void setStartResistance(int arg1) {
        this.startResistance = arg1;
    }

    public void setStartSpeedX10(int arg1) {
        this.startSpeedX10 = arg1;
    }

    public void setUnits(int arg1) {
        this.units = arg1;
    }

    public void setWarmUpTime(int arg1) {
        this.warmUpTime = arg1;
    }

    public void setWorkoutTime(int arg1) {
        this.workoutTime = arg1;
    }

    @Override
    public String toString() {
        return "WorkDataStatus [headTag=" + this.headTag + ", programType=" + this.programType + ", workoutTime=" + this.workoutTime + ", warmUpTime=" + this.warmUpTime + ", coolDownTime=" + this.coolDownTime + ", units=" + this.units + ", startSpeedX10=" + this.startSpeedX10 + ", startInclineX10=" + this.startInclineX10 + ", startResistance=" + this.startResistance + ", pauseTag=" + this.pauseTag + "]";
    }
}
