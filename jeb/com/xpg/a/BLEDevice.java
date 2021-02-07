package com.xpg.a;

public class BLEDevice {
    private String mDeviceName;
    private String mDeviceAddress;
    private int mDeviceRSSI;
    private Object mDevice;

    public BLEDevice(String deviceName, String deviceAddress, int deviceRSSI, Object device) {
        this.mDeviceName = deviceName;
        this.mDeviceAddress = deviceAddress;
        this.mDeviceRSSI = deviceRSSI;
        this.mDevice = device;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public String getDeviceAddress() {
        return this.mDeviceAddress;
    }

    public int getDeviceRSSI() {
        return this.mDeviceRSSI;
    }

    public Object getDevice() {
        return this.mDevice;
    }
}
