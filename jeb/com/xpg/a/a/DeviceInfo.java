package com.xpg.a.a;

import java.io.Serializable;

public class DeviceInfo implements Serializable {
    private int machineType;
    private int modelType;
    private int securitySwitch;
    private int runStatus;

    public int getMachineType() {
        return this.machineType;
    }

    public void setMachineType(int arg1) {
        this.machineType = arg1;
    }

    public int getModelType() {
        return this.modelType;
    }

    public void setModelType(int arg1) {
        this.modelType = arg1;
    }

    public int getSecuritySwitch() {
        return this.securitySwitch;
    }

    public void setSecuritySwitch(int arg1) {
        this.securitySwitch = arg1;
    }

    public int getRunStatus() {
        return this.runStatus;
    }

    public void setRunStatus(int arg1) {
        this.runStatus = arg1;
    }

    @Override
    public String toString() {
        return "DeviceInfo [machineType=" + this.machineType + ", modelType=" + this.modelType + ", securitySwitch=" + this.securitySwitch + ", runStatus=" + this.runStatus + "]";
    }
}
