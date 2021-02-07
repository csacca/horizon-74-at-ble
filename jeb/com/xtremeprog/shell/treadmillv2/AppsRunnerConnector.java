package com.xtremeprog.shell.treadmillv2;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import apps.c.ContextSharedPreferences;
import apps.c.d;
import apps.c.f;
import apps.c.j;
import apps.database.entity.UserArticle;
import com.xpg.a.BLEDevice;
import com.xpg.a.b.CustomHRProgram;
import com.xpg.a.b.CustomProgram.a;
import com.xpg.a.b.CustomProgram.b;
import com.xpg.a.b.CustomProgram;
import com.xpg.a.b.DeviceCommand;
import com.xpg.a.b.UserSync;
import com.xpg.a.c.CRC;
import com.xpg.a.c.Factory;
import com.xpg.b.BLEManager;
import com.xpg.b.BLEManagerMIO;
import com.xpg.c.UserSlow;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppsRunnerConnector {
    private boolean MIOIsConnected;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private Handler connectHandler_54321;
    private Handler MIOConnectHandler_654321;
    private Handler handler_12345;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    public boolean a;
    public boolean b;
    public boolean c;
    boolean d;
    public Map mHashMap;
    public List mDeviceList;
    public List mDeviceNameList;
    public List mDeviceAddressList;
    public List i;
    public List j;
    public List k;
    public int l;
    public int m;
    protected static Context ctx;
    public boolean o;
    public boolean p;
    final Handler handle_11111;
    final Handler handle_111111;
    final Handler handler_222222;
    final Handler handler_unk4;
    private static AppsRunnerConnector s_instance;
    private BLEDevice currentConnectedDevice;
    private BLEDevice currentConnectingDevice;
    private BLEDevice currentConnectedMIODevice;
    private BLEDevice currentConnectingMIODevice;
    private boolean mIsConnected;

    static {
    }

    public AppsRunnerConnector() {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.mHashMap = new HashMap();
        this.mDeviceList = new ArrayList();
        this.mDeviceNameList = new ArrayList();
        this.mDeviceAddressList = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.currentConnectedDevice = null;
        this.currentConnectingDevice = null;
        this.currentConnectedMIODevice = null;
        this.currentConnectingMIODevice = null;
        this.mIsConnected = false;
        this.MIOIsConnected = false;
        this.l = 0;
        this.m = 0;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.o = false;
        this.p = false;
        this.connectHandler_54321 = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                if(arg2.what == 0xD431) {
                    j.a("==connectHandler==", "===");
                    AppsRunnerConnector.this.o = false;
                    if(!AppsRunnerConnector.this.isConnected()) {
                        j.a("AppsRunnerConnector", "==现在还没连接上==");
                    }

                    AppsRunnerConnector.get(AppsRunnerConnector.ctx).tryToConnectPreviousDevice();
                }
            }
        };
        this.MIOConnectHandler_654321 = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                if(arg2.what == 0x9FBF1) {
                    AppsRunnerConnector.this.p = false;
                    if(!AppsRunnerConnector.this.e()) {
                        j.a("AppsRunnerConnector", "==现在还没连接上MIO==");
                    }

                    AppsRunnerConnector.get(AppsRunnerConnector.ctx).connectMIODevice();
                }
            }
        };
        this.handler_12345 = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                if(arg2.what == 0x3039) {
                    AppsRunnerConnector.this.o();
                }
            }
        };
        this.K = false;
        this.handle_11111 = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                AppsRunnerConnector.b(AppsRunnerConnector.this);
                j.a("==waitTryConnectFirstDeviceCount++==", AppsRunnerConnector.c(AppsRunnerConnector.this) + " |");
                AppsRunnerConnector.a(AppsRunnerConnector.this, false);
                AppsRunnerConnector.this.tryToConnectPreviousDevice2();
            }
        };
        this.L = false;
        this.M = false;
        this.handle_111111 = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg5) {
                j.a("====", "==第" + (AppsRunnerConnector.c(AppsRunnerConnector.this) + 1) + "次等待方法执行完");  // First, Wait for the method to finish
                AppsRunnerConnector.b(AppsRunnerConnector.this);
                int v0 = 0;
                AppsRunnerConnector.b(AppsRunnerConnector.this, false);
                String v5 = (String)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, "PREVIOUS_CONNECTED_DEVICE", "", 5);
                if(!d.strNotEmpty(v5)) {
                    BLEDevice v1 = null;
                    while(v0 < AppsRunnerConnector.this.mDeviceList.size()) {
                        BLEDevice v2 = (BLEDevice)AppsRunnerConnector.this.mDeviceList.get(v0);
                        if(((String)AppsRunnerConnector.this.mDeviceAddressList.get(v0)).equals(v5)) {
                            v1 = v2;
                            break;
                        }

                        ++v0;
                    }

                    if(v1 != null) {
                        AppsRunnerConnector.this.maybe_IsCurrentConnectingDevice(v1);
                        return;
                    }

                    if(AppsRunnerConnector.c(AppsRunnerConnector.this) < 3) {
                        j.a("==没搜到上一次的设备==", "==尝试2次等待==");  // The last device was not found, Try 2 times and wait
                        AppsRunnerConnector.this.a(v5);
                    }
                }
            }
        };
        this.handler_222222 = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg5) {
                j.a("====", "==MIO第" + (AppsRunnerConnector.d(AppsRunnerConnector.this) + 1) + "次等待方法执行完");
                AppsRunnerConnector.e(AppsRunnerConnector.this);
                int v0 = 0;
                AppsRunnerConnector.c(AppsRunnerConnector.this, false);
                String v5 = (String)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, "PREVIOUS_CONNECTED_MIO_DEVICE", "", 5);
                if(!d.strNotEmpty(v5)) {
                    BLEDevice v1 = null;
                    while(v0 < AppsRunnerConnector.this.i.size()) {
                        BLEDevice v2 = (BLEDevice)AppsRunnerConnector.this.i.get(v0);
                        if(((String)AppsRunnerConnector.this.k.get(v0)).equals(v5)) {
                            v1 = v2;
                            break;
                        }

                        ++v0;
                    }

                    if(v1 != null) {
                        if(AppsRunnerConnector.this.E()) {
                            j.a("==仪表连接上的==", "==尝试去连接MIO==");
                            AppsRunnerConnector.this.maybe_IsCurrentConnectingMIODevice(v1);
                            return;
                        }

                        j.a("==仪表未连接上的==", "==不尝试去连接MIO==");
                        return;
                    }

                    if(AppsRunnerConnector.d(AppsRunnerConnector.this) < 3) {
                        j.a("==没搜到上一次的MIO设备==", "==尝试2次等待==");
                        AppsRunnerConnector.this.b(v5);
                    }
                }
            }
        };
        this.N = false;
        this.handler_unk4 = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                this.sendEmptyMessageDelayed(0, 3000L);
                j.a("===5秒检测==", "===");
                if(AppsRunnerConnector.this.G()) {
                    if(!AppsRunnerConnector.f(AppsRunnerConnector.this)) {
                        j.a("AppsRunnerConnector", "==蓝牙正开启==");
                    }

                    AppsRunnerConnector.d(AppsRunnerConnector.this, true);
                    if(AppsRunnerConnector.this.isConnected()) {
                        if(BLEManager.get(AppsRunnerConnector.ctx).something_about_ble_scanning) {
                            BLEManager.get(AppsRunnerConnector.ctx).stopScan();
                            if(AppsRunnerConnector.this.e()) {
                                BLEManagerMIO.get(AppsRunnerConnector.ctx).a();
                            }
                            else {
                                BLEManagerMIO.get(AppsRunnerConnector.ctx).a(0);
                            }
                        }
                    }
                    else if(!BLEManager.get(AppsRunnerConnector.ctx).something_about_ble_scanning) {
                        BLEManager.get(AppsRunnerConnector.ctx).startScan();
                        BLEManagerMIO.get(AppsRunnerConnector.ctx).a();
                    }

                    if(AppsRunnerConnector.this.e()) {
                        if(BLEManagerMIO.get(AppsRunnerConnector.ctx).c) {
                            BLEManagerMIO.get(AppsRunnerConnector.ctx).a();
                            return;
                        }
                    }
                    else if(!BLEManagerMIO.get(AppsRunnerConnector.ctx).c && (AppsRunnerConnector.this.isConnected())) {
                        BLEManagerMIO.get(AppsRunnerConnector.ctx).a(0);
                        return;
                    }
                }
                else {
                    j.a("AppsRunnerConnector", "==蓝牙已开闭==");
                    AppsRunnerConnector.d(AppsRunnerConnector.this, false);
                    AppsRunnerConnector.this.mDeviceList.clear();
                    AppsRunnerConnector.this.mDeviceAddressList.clear();
                    AppsRunnerConnector.this.mDeviceNameList.clear();
                    AppsRunnerConnector.a(AppsRunnerConnector.this, null);
                    AppsRunnerConnector.b(AppsRunnerConnector.this, null);
                    AppsRunnerConnector.this.i.clear();
                    AppsRunnerConnector.this.k.clear();
                    AppsRunnerConnector.this.j.clear();
                    AppsRunnerConnector.c(AppsRunnerConnector.this, null);
                    AppsRunnerConnector.setCurrentConnectingMIODevice(AppsRunnerConnector.this, null);
                    Intent v3 = new Intent();
                    v3.setAction("NOTIFICATION_REFRESH_DEVICE_LIST_DATA");
                    AppsRunnerConnector.ctx.sendBroadcast(v3);
                    Intent v3_1 = new Intent();
                    v3_1.setAction("NOTIFICATION_REFRESH_MIO_DEVICE_LIST_DATA");
                    AppsRunnerConnector.ctx.sendBroadcast(v3_1);
                }
            }
        };
    }

    public void A() {
        BLEDevice v0 = this.currentConnectingMIODevice;
        if(v0 != null) {
            this.currentConnectedMIODevice = v0;
        }
    }

    public boolean B() {
        return !d.strNotEmpty(((String)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, "PREVIOUS_CONNECTED_DEVICE", "", 5)));
    }

    public void tryToConnectPreviousDevice() {
        String v5_1;
        StringBuilder v4_1;
        String v1;
        String v0;
        if(this.o) {
            v0 = "----正在连接中----";
            v1 = "-----请等待----" + this.currentConnectingDevice;
            j.a(v0, v1);
            return;
        }

        j.a("==tryToConnectPreviousDevice==", "====");
        int v0_1 = 1;
        this.o = true;
        Message v1_1 = new Message();
        v1_1.what = 0xD431;
        this.connectHandler_54321.removeMessages(0xD431);
        this.connectHandler_54321.sendMessageDelayed(v1_1, this.mDeviceList.size() == 0 ? 5000L : 20000L);
        if(this.isConnected()) {
            this.o = false;
            v0 = "----已经连接上----";
            v1 = "-----已经连接上----";
            j.a(v0, v1);
            return;
        }

        BLEDevice v1_2 = null;
        String v3 = (String)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, "PREVIOUS_CONNECTED_DEVICE", "", 5);
        if(this.mDeviceList.size() <= 0) {
            v0 = "AppsRunnerConnector";
            v1 = "---暂时没有搜索到设备---";
            j.a(v0, v1);
            return;
        }

        j.a("AppsRunnerConnector", "-----尝试连接上一次连接的设备------" + this.mDeviceList.size() + " | " + v3);
        if(d.strNotEmpty(v3)) {
            v0_1 = 0;
        }
        else {
            int v4;
            for(v4 = 0; v4 < this.mDeviceList.size(); ++v4) {
                BLEDevice v5 = (BLEDevice)this.mDeviceList.get(v4);
                if(((String)this.mDeviceAddressList.get(v4)).equals(v3)) {
                    v1_2 = v5;
                    break;
                }
            }
        }

        if(v0_1 == 0) {
            v4_1 = new StringBuilder();
            v5_1 = "-----检测到上次没连接过设备------";
        }
        else {
            v4_1 = new StringBuilder();
            v5_1 = "-----检测到上次连接过设备，将开始连接旧设备------";
        }

        v4_1.append(v5_1);
        v4_1.append(this.mDeviceList.size());
        v4_1.append(" | ");
        v4_1.append(v3);
        j.a("AppsRunnerConnector", v4_1.toString());
        if(v1_2 == null && this.mDeviceList.size() > 0) {
            v1_2 = (BLEDevice)this.mDeviceList.get(0);
        }

        if(v1_2 != null) {
            this.maybe_IsCurrentConnectingDevice(v1_2);
        }
    }

    public void tryToConnectPreviousDevice2() {
        Message v1_1;
        String v7;
        StringBuilder v6_1;
        int v4_1;
        String v1;  // Please wait 2
        String v0;  // Connecting 2
        if(this.o) {
            v0 = "----正在连接中2----";  // Connecting 2
            v1 = "-----请等待2----" + this.currentConnectingDevice;  // Please wait 2
            j.a(v0, v1);
            return;
        }

        if(this.isConnected()) {
            this.o = false;
            this.handle_11111.removeMessages(0x2B67);
            v0 = "----已经连接上2----";
            v1 = "-----已经连接上2----";
            j.a(v0, v1);
            return;
        }

        BLEDevice v0_1 = null;
        String v3 = (String)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, "PREVIOUS_CONNECTED_DEVICE", "", 5);
        if(this.mDeviceList.size() <= 0) {
            v0 = "==tryToConnectPreviousDevice2 device list is 0==";
            v1 = "==";
            j.a(v0, v1);
            return;
        }

        j.a("AppsRunnerConnector", "-----尝试连接上一次连接的设备2------" + this.mDeviceList.size() + " | " + v3);
        if(d.strNotEmpty(v3)) {
            v4_1 = 0;
        }
        else {
            int v4;
            for(v4 = 0; v4 < this.mDeviceList.size(); ++v4) {
                BLEDevice v6 = (BLEDevice)this.mDeviceList.get(v4);
                if(((String)this.mDeviceAddressList.get(v4)).equals(v3)) {
                    break;
                }
            }

            v4_1 = 1;
        }

        if(v4_1 == 0) {
            v6_1 = new StringBuilder();
            v7 = "-----检测到上次没连接过设备2------";
        }
        else {
            v6_1 = new StringBuilder();
            v7 = "-----检测到上次连接过设备，将开始连接旧设备2------";
        }

        v6_1.append(v7);
        v6_1.append(this.mDeviceList.size());
        v6_1.append(" | ");
        v6_1.append(v3);
        j.a("AppsRunnerConnector", v6_1.toString());
        int v3_1 = this.B;
        if(v3_1 < 3) {
            j.a("==", "==这里先等等，要先尝试连接上一台设备先 : " + this.B + "==");
            if(this.K) {
                goto label_193;
            }

            this.K = true;
            this.handle_11111.removeMessages(0x2B67);
            v1_1 = new Message();
            v1_1.what = 0x2B67;
            this.handle_11111.sendMessageDelayed(v1_1, 1000L);
        }
        else if(v3_1 == 3) {
            j.a("==" + this.mDeviceList.size(), "==这里已经等过了，尝试连接或跳到列表 : " + this.B + "==" + this.D);
            if(this.D) {
                goto label_188;
            }

            j.a("==2s连接检测==", "==");
            this.handle_11111.removeMessages(0x2B67);
            if(this.mDeviceList.size() <= 1) {
                goto label_162;
            }

            j.a("==2s检测到多于1个设备==", "===");
            if(this.a()) {
                j.a("==已经知道设备是不正确的了==", "==");
                goto label_193;
            label_162:
                if(this.mDeviceList.size() <= 0) {
                    goto label_172;
                }

                j.a("==2s检测到只有1个设备==", "===");
                BLEDevice v1_3 = this.getFirstAFGProScanDevice();
                if(v1_3 != null) {
                    v0_1 = v1_3;
                    goto label_193;
                label_172:
                    j.a("==2s检测到0个设备==", "===");
                    this.B = 0;
                    if(this.K) {
                        goto label_193;
                    }

                    this.K = true;
                    this.handle_11111.removeMessages(0x2B67);
                    v1_1 = new Message();
                    v1_1.what = 0x2B67;
                    this.handle_11111.sendMessageDelayed(v1_1, 1000L);
                    goto label_193;
                label_188:
                    j.a("==手动断开的==", "==");
                    this.handle_11111.removeMessages(0x2B67);
                }
            }
            else {
                j.a("==设备型号还是正常的==", "==");
                Intent v1_2 = new Intent();
                v1_2.setAction("NOTIFICATION_SHOULD_TO_DEVICE_LIST");
                AppsRunnerConnector.ctx.sendBroadcast(v1_2);
            }
        }

    label_193:
        if(v0_1 != null) {
            this.o = true;
            Message v1_4 = new Message();
            v1_4.what = 0xD431;
            this.connectHandler_54321.removeMessages(0xD431);
            this.connectHandler_54321.sendMessageDelayed(v1_4, this.mDeviceList.size() == 0 ? 5000L : 20000L);
            this.maybe_IsCurrentConnectingDevice(v0_1);
        }
    }

    public boolean E() {
        return (this.isConnected()) && (this.b) && (this.F) && (this.c);
    }

    public void connectMIODevice() {
        String v5_1;  // It was detected that the MIO device was not connected last time
        StringBuilder v4_1;
        String v1;  // Please wait
        String v0;  // Connecting to MIO
        if(this.p) {
            v0 = "----正在连接MIO中----";  // Connecting to MIO
            v1 = "-----请等待----" + this.currentConnectingMIODevice;  // Please wait
            j.a(v0, v1);
            return;
        }

        int v0_1 = 1;
        this.p = true;
        Message v1_1 = new Message();
        v1_1.what = 0x9FBF1;
        this.MIOConnectHandler_654321.removeMessages(0x9FBF1);
        this.MIOConnectHandler_654321.sendMessageDelayed(v1_1, this.i.size() == 0 ? 5000L : 20000L);
        if(this.e()) {
            this.p = false;
            v0 = "----已经连接上MIO----";  // MIO connected
            v1 = "-----已经连接上MIO----";  // Connected to MIO
            j.a(v0, v1);
            return;
        }

        BLEDevice v1_2 = null;
        String v3 = (String)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, "PREVIOUS_CONNECTED_MIO_DEVICE", "", 5);
        if(this.i.size() <= 0) {
            v0 = "AppsRunnerConnector";
            v1 = "---暂时没有搜索到MIO设备---";  // No MIO device is found
            j.a(v0, v1);
            return;
        }

        j.a("AppsRunnerConnector", "-----尝试连接上一次连接的MIO设备------" + this.i.size() + " | " + v3);  // Try to connect to the last connected MIO device
        if(d.strNotEmpty(v3)) {
            v0_1 = 0;
        }
        else {
            int v4;
            for(v4 = 0; v4 < this.i.size(); ++v4) {
                BLEDevice v5 = (BLEDevice)this.i.get(v4);
                if(((String)this.k.get(v4)).equals(v3)) {
                    v1_2 = v5;
                    break;
                }
            }
        }

        if(v0_1 == 0) {
            v4_1 = new StringBuilder();
            v5_1 = "-----检测到上次没连接过MIO设备------";  // It was detected that the MIO device was not connected last time
        }
        else {
            v4_1 = new StringBuilder();
            v5_1 = "-----检测到上次连接过MIO设备，将开始连接旧MIO设备------";  // It is detected that the MIO device has been connected last time, and the old MIO device will be connected
        }

        v4_1.append(v5_1);
        v4_1.append(this.i.size());
        v4_1.append(" | ");
        v4_1.append(v3);
        j.a("AppsRunnerConnector", v4_1.toString());
        if(v1_2 == null && this.i.size() > 0) {
            v1_2 = (BLEDevice)this.i.get(0);
        }

        if(v1_2 != null) {
            if(this.E()) {
                j.a("==仪表同步完==", "==尝试连接手表==");  // Finished synchronization of the meter, try to connect to the watch
                this.maybe_IsCurrentConnectingMIODevice(v1_2);
                return;
            }

            j.a("==仪表同步未完==", "==不尝试连接手表==");  // Meter synchronized unfinished, not try to connect the watch
        }
    }

    public boolean G() {
        return BluetoothAdapter.getDefaultAdapter().isEnabled();
    }

    public void H() {
        if(d.c(AppsRunnerConnector.ctx)) {
            this.a(false, 0, 0);
        }

        if(!this.handler_unk4.hasMessages(0)) {
            this.handler_unk4.sendEmptyMessage(0);
        }
    }

    public void I() {
        this.handler_unk4.removeMessages(0);
    }

    public BLEDevice getFirstAFGProScanDevice() {
        int v0 = 0;
        while(v0 < this.mDeviceList.size()) {
            BLEDevice v1 = (BLEDevice)this.mDeviceList.get(v0);
            String v2 = v1.getDeviceName();
            j.a("==getFirstAFGProScanDevice==", v2 + " |");
            int v3 = d.b(v2).toLowerCase().indexOf("afg pro");
            int v4 = d.b(v2).toLowerCase().indexOf("horizon");
            if(v3 == -1 && v4 == -1) {
                ++v0;
                continue;
            }

            j.a("==getFirstAFGProScanDevice found==", v3 + " | " + v4 + " | " + v2);
            return v1;
        }

        return null;
    }

    static Handler a(AppsRunnerConnector arg0) {
        return arg0.handler_12345;
    }

    static BLEDevice a(AppsRunnerConnector arg0, BLEDevice arg1) {
        arg0.currentConnectedDevice = arg1;
        return arg1;
    }

    public static AppsRunnerConnector get(Context context) {
        AppsRunnerConnector.ctx = context;
        synchronized("AppsRunnerConnector") {
            if(AppsRunnerConnector.s_instance == null) {
                AppsRunnerConnector.s_instance = new AppsRunnerConnector();
            }

            return AppsRunnerConnector.s_instance;
        }
    }

    static boolean a(AppsRunnerConnector arg0, boolean arg1) {
        arg0.K = arg1;
        return arg1;
    }

    public int getCustomCRC(String arg33, int arg34) {
        int v1_2;
        double v24_1;
        int v3_1;
        int v0_1;
        double v17;
        String v0 = arg33;
        Integer v1 = (Integer)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, v0 + "_saveProgramUnit", Integer.valueOf(0), 1);
        int v1_1 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, v0 + "_saveProgramUnit", Integer.valueOf(0), 1)));
        double v6 = v1_1 == 1 ? 0.8 : 0.5;
        boolean v4 = AppsRunner.get(AppsRunnerConnector.ctx).inclineSupportsHalfDegree(AppsRunnerConnector.ctx);
        int v8 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, v0 + "_maxSegment", Integer.valueOf(1), 1)));
        int v9 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, v0 + "_maxSegmentDis", Integer.valueOf(1), 1)));
        if(v8 <= 0) {
            v8 = 1;
        }

        if(v9 <= 0) {
            v9 = 1;
        }

        j.a("==crc segment==", v8 + " | " + v9);
        CustomProgram v10 = new CustomProgram();
        v10.d(d.a(arg33).intValue());
        v10.a(0);
        v10.b(v8);
        v10.c(v9);
        ArrayList v11 = new ArrayList();
        ArrayList v12 = new ArrayList();
        int v13 = 0;
        while(true) {
            v17 = 1000.0;
            double v20 = 0.0;
            if(v13 >= 16) {
                break;
            }

            v10.getClass();
            b v14 = new b(v10);
            v11.add(v14);
            int v3 = v13 + 1;
            ArrayList v23 = v11;
            double v11_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, v0 + "_speed_" + v3, Float.valueOf(-999.0f), 3)))));
            double v24 = d.a(v11_1, 3);
            int v26 = v9;
            ArrayList v27 = v12;
            double v9_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, v0 + "_incline_" + v3, Float.valueOf(-999.0f), 3)))));
            CustomProgram v28 = v10;
            double v29 = v6;
            double v5 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, v0 + "_resistance_" + v3, Float.valueOf(-999.0f), 3)))));
            int v31 = v3;
            float v2 = (float)(((Float)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, v0 + "_segmentLength_" + v3, Float.valueOf(-999.0f), 3)));
            if(v4) {
                v0_1 = (int)v5;
                v3_1 = v1_1;
            }
            else {
                v3_1 = v1_1;
                v0_1 = (int)(v24 * v17);
            }

            if(v4) {
                v24_1 = v11_1;
                v1_2 = 5;
            }
            else {
                v24_1 = v11_1;
                v1_2 = 10;
            }

            int v1_3 = (int)(((double)v1_2) * v9_1);
            int v7 = (int)(60.0f * v2);
            if(v13 < v8) {
                if(v2 < 0.0f) {
                    v14.a(60);
                }
                else {
                    v14.a(v7);
                }

                if(v9_1 < v20) {
                    v14.c(0);
                }
                else {
                    v14.c(v1_3);
                }

                if(v4) {
                    if(v5 < v20) {
                        v14.b(1);
                    }
                    else {
                        v14.b(v0_1);
                    }
                }
                else if(v24_1 >= v20) {
                    v14.b(v0_1);
                }
                else if(v3_1 == 1) {
                    v14.b(((int)(Conversions.a(v29) * v17)));
                }
                else {
                    v14.b(((int)(0.5 * v17)));
                }
            }
            else {
                if(v9_1 < v20) {
                    v14.c(0);
                }
                else {
                    v14.c(v1_3);
                }

                if(v2 < 0.0f) {
                    v14.a(60);
                }
                else {
                    v14.a(v7);
                }

                if(v4) {
                    if(v5 < v20) {
                        v14.b(1);
                    }
                    else {
                        v14.b(v0_1);
                    }
                }
                else if(v24_1 >= v20) {
                    v14.b(v0_1);
                }
                else if(v3_1 == 1) {
                    v14.b(((int)(Conversions.a(v29) * v17)));
                }
                else {
                    v14.b(((int)(0.5 * v17)));
                }
            }

            v1_1 = v3_1;
            v11 = v23;
            v9 = v26;
            v12 = v27;
            v10 = v28;
            v6 = v29;
            v13 = v31;
            v0 = arg33;
        }

        int v3_2 = v1_1;
        double v29_1 = v6;
        int v26_1 = v9;
        CustomProgram v28_1 = v10;
        ArrayList v23_1 = v11;
        ArrayList v27_1 = v12;
        int v0_2;
        for(v0_2 = 0; v0_2 < 16; v0_2 = v25) {
            v28_1.getClass();
            a v1_4 = new a(v28_1);
            v27_1.add(v1_4);
            int v9_2 = v0_2 + 1;
            double v6_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, arg33 + "_speed_dis_" + v9_2, Float.valueOf(-999.0f), 3)))));
            double v12_1 = d.a(v6_1, 3);
            double v10_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, arg33 + "_incline_dis_" + v9_2, Float.valueOf(-999.0f), 3)))));
            v28_1 = v28_1;
            v27_1 = v27_1;
            double v14_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, arg33 + "_resistance_dis_" + v9_2, Float.valueOf(-999.0f), 3)))));
            int v25 = v9_2;
            float v2_1 = (float)(((Float)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, arg33 + "_segmentLengthDis_" + v9_2, Float.valueOf(-999.0f), 3)));
            int v5_1 = (int)(1000.0f * v2_1);
            int v8_1 = v4 ? ((int)v14_1) : ((int)(v12_1 * v17));
            int v12_2 = (int)(((double)v4 ? 5 : 10) * v10_1);
            int v9_3 = v26_1;
            if(v0_2 < v9_3) {
                if(v2_1 < 0.0f) {
                    v1_4.a(100);
                }
                else {
                    v1_4.a(v5_1);
                }

                if(v4) {
                    if(v14_1 < v20) {
                        v1_4.b(1);
                    }
                    else {
                        v1_4.b(v8_1);
                    }
                }
                else if(v6_1 < v20) {
                    v1_4.b(((int)(v3_2 == 1 ? Conversions.a(v29_1) : 0.5 * v17)));
                }
                else {
                    v1_4.b(v8_1);
                }

                if(v10_1 < v20) {
                    v1_4.c(0);
                }
                else {
                    v1_4.c(v12_2);
                }
            }
            else {
                if(v10_1 < v20) {
                    v1_4.c(0);
                }
                else {
                    v1_4.c(v12_2);
                }

                if(v4) {
                    if(v14_1 < v20) {
                        v1_4.b(1);
                    }
                    else {
                        v1_4.b(v8_1);
                    }
                }
                else if(v6_1 < v20) {
                    v1_4.b(((int)(v3_2 == 1 ? Conversions.a(v29_1) : 0.5 * v17)));
                }
                else {
                    v1_4.b(v8_1);
                }

                if(v2_1 < 0.0f) {
                    v1_4.a(100);
                }
                else {
                    v1_4.a(v5_1);
                }
            }

            v26_1 = v9_3;
        }

        v28_1.b(v27_1);
        v28_1.a(v23_1);
        int v4_1 = CRC.getCustomProgramCRC(v28_1);
        j.a("===getCustomCRC.userSlot===", v28_1.getUserId() + " |");
        j.a("===getCustomCRC.unit===", v28_1.getUnit() + " |");
        j.a("===getCustomCRC.unit2===", v3_2 + " |");
        j.a("===getCustomCRC.timeSegment===", v28_1.getTimeSegmentNumber() + " |");
        j.a("===getCustomCRC.distanceSegment===", v28_1.getDistanceSegmentNumber() + " |");
        j.a("===getCustomCRC.setCustomProgram===", v23_1 + " | " + v27_1 + " | crc = " + v4_1);
        j.a("===getCustomCRC.setCustomProgram2===", v28_1 + " |");
        return v4_1;
    }

    public int customHRCRCStra(String userId, int arg12, int age) {
        int max_hr = (int)(((float)(220 - age)) * 0.75f);
        int totalTime = (int)(((Integer)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, userId + "_time_hr", Integer.valueOf(900), 1)));
        CustomHRProgram v1 = new CustomHRProgram();
        v1.a(d.a(userId, -1).intValue());
        v1.b(totalTime);
        j.a("==customHRCRCStr userId", userId + " |");
        j.a("==customHRCRCStr age", age + " |");
        j.a("==customHRCRCStr totalTime", totalTime + " |");
        int v0_1;
        for(v0_1 = 0; v0_1 < 4; v0_1 = v5) {
            int v5 = v0_1 + 1;
            int hr = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, userId + "_hr_hr_" + v5, Float.valueOf(((float)max_hr) * 1.0f), 3)))));
            int segmentLength = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(AppsRunnerConnector.ctx, userId + "_segmentLength_hr_" + v5, Float.valueOf(1.0f), 3)))) * 60.0f);
            j.a("==customHRCRCStr hr", hr + " |");
            j.a("==customHRCRCStr segmentLength", segmentLength + " |");
            if(v0_1 == 0) {
                v1.c(age);
                v1.e(hr);
                v1.d(segmentLength);
            }
            else if(v0_1 == 1) {
                v1.f(age);
                v1.h(hr);
                v1.g(segmentLength);
            }
            else if(v0_1 == 2) {
                v1.i(age);
                v1.k(hr);
                v1.j(segmentLength);
            }
            else if(v0_1 == 3) {
                v1.l(age);
                v1.n(hr);
                v1.m(segmentLength);
            }
        }

        int v11 = CRC.getCustomHRProgramCRC(v1);
        j.a("==customHRCRC==", v11 + " |");
        return v11;
    }

    public void selectProgram(int arg4) {
        byte[] selectProgramMsg;
        BLEManager v0;
        j.a("===selectProgram===", "select program : " + arg4 + " |");
        int v1 = 2000;
        if((d.f(AppsRunnerConnector.ctx)) && arg4 == 5) {
            v0 = BLEManager.get(AppsRunnerConnector.ctx);
            selectProgramMsg = DeviceCommand.selectProgramMsg(arg4);
            v1 = 3000;
        }
        else {
            v0 = BLEManager.get(AppsRunnerConnector.ctx);
            selectProgramMsg = DeviceCommand.selectProgramMsg(arg4);
        }

        v0.maybe_send_message2(selectProgramMsg, 5, v1);
    }

    public void incline(int incline, int arg5) {
        j.a("AppsRunnerConnector", "==调整incline : " + incline + "== " + arg5);
        BLEManager.get(AppsRunnerConnector.ctx).maybe_send_message1(DeviceCommand.setInclineMsg(((short)incline), arg5));
    }

    public void speed(int arg4, int speed, int arg6) {
        j.a("AppsRunnerConnector", "==调整Speed : " + speed + "== " + arg6);
        BLEManager.get(AppsRunnerConnector.ctx).maybe_send_message1(DeviceCommand.setSpeedMsg(((byte)arg4), ((short)speed), arg6));
    }

    public void changeWorkout(int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13) {
        j.a("===Change Workout===", "change workout : " + arg4 + " | " + arg5 + " | " + arg6 + " | " + arg7 + " | " + arg8 + " | " + arg9 + " | " + arg10 + " | " + arg11 + " | " + arg13);
        BLEManager.get(AppsRunnerConnector.ctx).maybe_send_message1(DeviceCommand.changeWorkoutMsg(Factory.workout(arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13)));
    }

    public void setUserData(int arg17, int arg18, int arg19, int arg20, int arg21, int arg22, int arg23, int arg24, int arg25, String arg26, String arg27, String arg28, String arg29, String arg30, String arg31) {
        j.a("===setUserData===", arg17 + " | " + arg18 + " | " + arg19 + " | " + arg20 + " | " + arg21 + " | " + arg22 + " | " + arg23 + " | " + arg24 + " | " + arg26 + " | " + arg27 + " | " + arg28 + " | " + arg29 + " | " + arg30 + " | " + arg31);
        BLEManager.get(AppsRunnerConnector.ctx).maybe_send_message2(DeviceCommand.setUser(Factory.userData(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31)), 2, 5000);
    }

    public void a(String arg4) {
        if(!this.L) {
            j.a("==先hold一下==", "==尝试第" + (this.B + 1) + "次等待是否搜到连接过的上一次的设备==");  // Hold it first, Try the first, Waiting for the last connected device
            this.L = true;
            this.handle_111111.removeMessages(0x1B207);
            Message v4 = new Message();
            v4.what = 0x1B207;
            this.handle_111111.sendMessageDelayed(v4, 2000L);
            return;
        }

        j.a("==先hold一下==", "==第" + (this.B + 1) + "次等待正在执行中==");
    }

    public void a(boolean arg1) {
        this.G = arg1;
    }

    public void a(boolean arg1, int arg2, int arg3) {
        if(!arg1) {
            goto label_4;
        }

        try {
            this.I();
            this.H();
            return;
        label_4:
            this.I();
        }
        catch(Exception v1) {
            v1.printStackTrace();
        }
    }

    public boolean a() {
        return this.G;
    }

    public boolean a(BLEDevice arg2) {
        return arg2 != null && (this.currentConnectedDevice != null && (this.currentConnectedDevice.getDeviceAddress().equals(arg2.getDeviceAddress())));
    }

    static int b(AppsRunnerConnector arg2) {
        int v0 = arg2.B;
        arg2.B = v0 + 1;
        return v0;
    }

    static BLEDevice b(AppsRunnerConnector arg0, BLEDevice arg1) {
        arg0.currentConnectingDevice = arg1;
        return arg1;
    }

    static boolean b(AppsRunnerConnector arg0, boolean arg1) {
        arg0.L = arg1;
        return arg1;
    }

    public void b() {
        this.a(false, 0, 0);
        this.a(true, 0, 3000);
    }

    public void deleteUserData(int arg4) {
        j.a("===deleteUserData===", arg4 + " |");
        BLEManager.get(AppsRunnerConnector.ctx).maybe_send_message2(DeviceCommand.deleteUserDataMsg(arg4), 2, 2000);
    }

    public void resistance(int resistance, int arg5) {
        j.a("AppsRunnerConnector", "==调整Resistance : " + resistance + "== " + arg5);
        BLEManager.get(AppsRunnerConnector.ctx).maybe_send_message1(DeviceCommand.setResistanceMsg(((byte)resistance), arg5));
    }

    public void startWorkout(int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13) {
        j.a("===Start Workout===", "start workout : " + arg4 + " | " + arg5 + " | " + arg6 + " | " + arg7 + " | " + arg8 + " | " + arg9 + " | " + arg10 + " | " + arg11 + " | " + arg12 + " | " + arg13);
        BLEManager.get(AppsRunnerConnector.ctx).maybe_send_message2(DeviceCommand.startWorkoutMsg(Factory.workout(arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13)), 4, 3000);
    }

    public void b(String arg4) {
        if(!this.M) {
            j.a("==MIO先hold一下==", "==尝试第" + (this.C + 1) + "次等待是否搜到连接过的上一次的设备==");
            this.M = true;
            this.handler_222222.removeMessages(0x3640E);
            Message v4 = new Message();
            v4.what = 0x3640E;
            this.handler_222222.sendMessageDelayed(v4, 2000L);
            return;
        }

        j.a("==MIO先hold一下==", "==第" + (this.C + 1) + "次等待正在执行中==");
    }

    public void b(boolean arg1) {
        this.F = arg1;
    }

    public boolean b(BLEDevice arg2) {
        return arg2 != null && (this.currentConnectedMIODevice != null && (this.currentConnectedMIODevice.getDeviceAddress().equals(arg2.getDeviceAddress())));
    }

    static int c(AppsRunnerConnector arg0) {
        return arg0.B;
    }

    static BLEDevice c(AppsRunnerConnector arg0, BLEDevice arg1) {
        arg0.currentConnectedMIODevice = arg1;
        return arg1;
    }

    static boolean c(AppsRunnerConnector arg0, boolean arg1) {
        arg0.M = arg1;
        return arg1;
    }

    public void c() {
        this.connectHandler_54321.removeMessages(0xD431);
        this.MIOConnectHandler_654321.removeMessages(0x9FBF1);
        this.a(false, 0, 0);
    }

    public void c(boolean arg1) {
        this.D = arg1;
    }

    public boolean c(BLEDevice arg1) {
        return this.a(arg1) ? this.isConnected() : false;
    }

    static int d(AppsRunnerConnector arg0) {
        return arg0.C;
    }

    static BLEDevice setCurrentConnectingMIODevice(AppsRunnerConnector arg0, BLEDevice arg1) {
        arg0.currentConnectingMIODevice = arg1;
        return arg1;
    }

    static boolean d(AppsRunnerConnector arg0, boolean arg1) {
        arg0.N = arg1;
        return arg1;
    }

    public void d(boolean arg1) {
        this.E = arg1;
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }

    public boolean d(BLEDevice arg1) {
        return this.b(arg1) ? this.e() : false;
    }

    static int e(AppsRunnerConnector arg2) {
        int v0 = arg2.C;
        arg2.C = v0 + 1;
        return v0;
    }

    public int e(BLEDevice arg1) {
        return this.a(arg1) ? this.l : 0;
    }

    public void setIsConnected(boolean isConnected) {
        j.a("AppsRunnerConnector", "setIsConnected: " + ((boolean)(((int)isConnected))) + " ｜ " + this.currentConnectingDevice);
        this.mIsConnected = isConnected;
        if(this.isConnected()) {
            this.currentConnectedDevice = this.currentConnectingDevice;
            AppsRunnerConnector.get(AppsRunnerConnector.ctx).rememberThisDevicew();
            this.currentConnectingDevice = null;
            return;
        }

        this.currentConnectedDevice = null;
    }

    public boolean e() {
        return this.MIOIsConnected;
    }

    static boolean f(AppsRunnerConnector arg0) {
        return arg0.N;
    }

    public int f(BLEDevice arg1) {
        return this.b(arg1) ? this.m : 0;
    }

    public List f() {
        return this.mDeviceList;
    }

    public void setMIOIsConnected(boolean arg4) {
        j.a("AppsRunnerConnector", "setMIOIsConnected: " + ((boolean)(((int)arg4))) + " ｜ " + this.currentConnectingMIODevice);
        this.MIOIsConnected = arg4;
        if(this.e()) {
            this.currentConnectedMIODevice = this.currentConnectingMIODevice;
            AppsRunnerConnector.get(AppsRunnerConnector.ctx).rememberThisMIODevicey();
            this.currentConnectingMIODevice = null;
            return;
        }

        this.currentConnectedMIODevice = null;
    }

    public List g() {
        return this.i;
    }

    public void parseDeviceVersion(BLEDevice device) {
        String ver;
        Map hashMap;
        if(device == null) {
            return;
        }

        int alreadySeen = 0;
        int i;
        for(i = 0; i < this.mDeviceList.size(); ++i) {
            if(((BLEDevice)this.mDeviceList.get(i)).getDeviceAddress().equals(device.getDeviceAddress())) {
                alreadySeen = 1;
                break;
            }
        }

        if(alreadySeen == 0) {
            this.mDeviceList.add(device);
            this.mDeviceNameList.add(device.getDeviceName());
            this.mDeviceAddressList.add(device.getDeviceAddress());
            String deviceName = device.getDeviceName();
            String deviceAddress = device.getDeviceAddress();
            if(d.b(deviceName).toLowerCase().indexOf("afg sport") == -1) {
                hashMap = this.mHashMap;
                ver = "V2";
            }
            else {
                hashMap = this.mHashMap;
                ver = "V1";
            }

            hashMap.put(deviceAddress, ver);
        }
    }

    // Detected as a lambda impl.
    public void setScan(boolean tf) {
        if(tf) {
            j.a("AppsRunnerConnector", "==开始搜索==");  // Start search
            BLEManager.get(AppsRunnerConnector.ctx).startScan();
            BLEManagerMIO.get(AppsRunnerConnector.ctx).a(0);
            return;
        }

        j.a("AppsRunnerConnector", "==停止搜索==");  // Stop searching
        BLEManager.get(AppsRunnerConnector.ctx).stopScan();
        BLEManagerMIO.get(AppsRunnerConnector.ctx).a();
    }

    public List getDeviceNameList() {
        return this.mDeviceNameList;
    }

    public void h(BLEDevice device) {
        if(device == null) {
            return;
        }

        int v0 = 0;
        int v1;
        for(v1 = 0; v1 < this.i.size(); ++v1) {
            if(((BLEDevice)this.i.get(v1)).getDeviceAddress().equals(device.getDeviceAddress())) {
                v0 = 1;
                break;
            }
        }

        if(v0 == 0) {
            this.i.add(device);
            this.j.add(device.getDeviceName());
            this.k.add(device.getDeviceAddress());
        }
    }

    public List i() {
        return this.k;
    }

    public boolean maybe_IsCurrentConnectingDevice(BLEDevice currentConnectingDevice) {
        if(currentConnectingDevice == null) {
            return false;
        }

        this.currentConnectingDevice = currentConnectingDevice;
        j.a("AppsRunnerConnector", "==开始连接设备：" + currentConnectingDevice.getDeviceName() + ":" + currentConnectingDevice.getDeviceAddress() + "==" + AppsRunnerConnector.get(AppsRunnerConnector.ctx).l);
        j.a("AppsRunnerConnector", "==this.currentConnectingDevice: " + this.currentConnectingDevice);
        if(this.currentConnectedDevice != null && (this.currentConnectedDevice.getDeviceAddress().equals(currentConnectingDevice.getDeviceAddress())) && (this.isConnected())) {
            return true;
        }

        j.a("===处于未连接状态===", "==尝试连接==");
        BLEManager.get(AppsRunnerConnector.ctx).connect(currentConnectingDevice.getDeviceAddress());
        return false;
    }

    public void j() {
        BLEManager.get(AppsRunnerConnector.ctx).disconnect();
        this.setIsConnected(false);
    }

    public boolean maybe_IsCurrentConnectingMIODevice(BLEDevice arg5) {
        if(arg5 == null) {
            return false;
        }

        this.currentConnectingMIODevice = arg5;
        j.a("AppsRunnerConnector", "==开始连接MIO设备：" + arg5.getDeviceName() + ":" + arg5.getDeviceAddress() + "==" + AppsRunnerConnector.get(AppsRunnerConnector.ctx).m);
        j.a("AppsRunnerConnector", "==this.currentConnectingMIODevice: " + this.currentConnectingMIODevice);
        if(this.currentConnectedMIODevice != null && (this.currentConnectedMIODevice.getDeviceAddress().equals(arg5.getDeviceAddress())) && (this.e())) {
            return true;
        }

        j.a("===MIO处于未连接状态===", "==尝试连接MIO==");
        BLEManagerMIO.get(AppsRunnerConnector.ctx).a(arg5.getDeviceAddress());
        return false;
    }

    public void maybe_onDisconnect() {
        BLEManager.get(AppsRunnerConnector.ctx).disconnect();
        this.setIsConnected(false);
        Intent v0 = new Intent();
        v0.setAction("NOTIFICATION_DISCONNECT");
        AppsRunnerConnector.ctx.sendBroadcast(v0);
    }

    public void maybe_onMIODisconnect() {
        BLEManagerMIO.get(AppsRunnerConnector.ctx).b();
        this.setMIOIsConnected(false);
    }

    public void m() {
        this.j();
        this.setScan(true);
        this.connectMIODevice();
    }

    public void n() {
        AppsRunnerConnector.s_instance = null;
    }

    public void o() {
        new Handler().postDelayed(() -> {
            if(true) {
                j.a("AppsRunnerConnector", "==开始搜索==");  // Start search
                BLEManager.get(AppsRunnerConnector.ctx).startScan();
                BLEManagerMIO.get(AppsRunnerConnector.ctx).a(0);
                return;
            }

            j.a("AppsRunnerConnector", "==停止搜索==");  // Stop searching
            BLEManager.get(AppsRunnerConnector.ctx).stopScan();
            BLEManagerMIO.get(AppsRunnerConnector.ctx).a();
        }, 2000L);

        class com.xtremeprog.shell.treadmillv2.AppsRunnerConnector.5 implements Runnable {
            @Override
            public void run() {
                AppsRunnerConnector.get(AppsRunnerConnector.ctx).setScan(true);
            }
        }

    }

    public boolean p() {
        if(!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            try {
                apps.views.d.a v0_1 = new apps.views.d.a(AppsRunnerConnector.ctx);
                v0_1.b(0x7F0B0134);  // string:prompt "Warning"
                v0_1.a(AppsRunnerConnector.ctx.getResources().getString(0x7F0B000C));  // string:STR_ALERT_TIP_NOT_OPEN_BLUETOOTH "Please turn on your bluetooth within the device"
                v0_1.a(AppsRunnerConnector.ctx.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        new AsyncTask() {
                            protected Void a(Void[] arg2) {
                                BluetoothAdapter.getDefaultAdapter().enable();
                                Message v2 = new Message();
                                v2.what = 0x3039;
                                AppsRunnerConnector.a(AppsRunnerConnector.this).sendMessage(v2);
                                return null;
                            }
                        }.execute(new Void[0]);
                    }
                });
                v0_1.b(AppsRunnerConnector.ctx.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }
                    }
                });
                apps.views.d v0_2 = v0_1.a();
                v0_2.setCancelable(false);
                v0_2.show();
            }
            catch(Exception v0) {
                v0.printStackTrace();
            }

            return false;
        }

        AppsRunnerConnector.get(AppsRunnerConnector.ctx).setScan(true);
        return true;
    }

    public void getMachineInfo() {
        int customHRCRCStr;
        AppsRunnerConnector v0 = this;
        j.a("AppsRunnerConnector", "==Get Machine Info==");
        List v1 = apps.database.d.a().b(AppsRunnerConnector.ctx);
        UserSync[] userSyncArray = new UserSync[6];
        int userSlot = 0;
        while(userSlot < userSyncArray.length) {
            UserArticle user = (UserArticle)v1.get(userSlot);
            userSyncArray[userSlot] = new UserSync();
            Date v6 = f.stringToDate(user.getBirthday(), "yyyy/MM/dd");
            if(v6 == null) {
                v6 = f.stringToDate("2000-01-01", "yyyy-MM-dd");
            }

            int userBirthYear = (int)d.a(f.a(v6, "yyyy"), 1970);
            int userBirthMonth = (int)d.a(f.a(v6, "MM"), 1);
            int v10 = (int)d.a(f.a(v6, "dd"), 1);
            int v6_1 = d.a(v6);
            int units = user.getUnit();
            int v15 = userSlot + 1;
            int v3 = AppsRunner.get(AppsRunnerConnector.ctx).a(AppsRunnerConnector.ctx, v15 + "");
            int v9 = AppsRunner.get(AppsRunnerConnector.ctx).b(AppsRunnerConnector.ctx, v15 + "");
            List v16 = v1;
            int v1_1 = AppsRunner.get(AppsRunnerConnector.ctx).getPref_CurrentUserID_walkSpeed(AppsRunnerConnector.ctx, v15 + "");
            int myFirst5kWorkout = v9;
            int v9_1 = AppsRunner.get(AppsRunnerConnector.ctx)._jogSpeed(AppsRunnerConnector.ctx, v15 + "");
            int v18 = v15;
            int v12 = AppsRunner.get(AppsRunnerConnector.ctx).e(AppsRunnerConnector.ctx, v15 + "");
            int customCRCStr = v0.getCustomCRC(userSlot + "", units);
            int myFirst5kWalkSpeed = v1_1;
            j.a("======customCRCStr====", "===" + customCRCStr + "====");
            if(AppsRunner.get(AppsRunnerConnector.ctx).aj()) {
                j.a("====", "==支持CustomHRSprints,customHRCRC要算==");
                customHRCRCStr = v0.customHRCRCStra(userSlot + "", units, v6_1);
            }
            else {
                j.a("====", "==不支持CustomHRSprints,customHRCRC社为0==");
                customHRCRCStr = 0;
            }

            j.a("======customHRCRCStr====", "===" + customHRCRCStr + "====");
            j.a("==getMachineInfo==CRC", customCRCStr + " | " + customHRCRCStr);
            String MMFTokenId = ShareFitness.get(AppsRunnerConnector.ctx).getPrefsMapMyFitnessTokenKey(userSlot + "");
            String MFPTokenId = ShareFitness.get(AppsRunnerConnector.ctx).getPrefsMFPTokenId(userSlot + "");
            int myFirst5kWeek = v3;
            String FitbitTokenId = ShareFitness.get(AppsRunnerConnector.ctx).getPrefsFitbitTokenId(userSlot + "");
            int myFirst5kResetCounter = v12;
            String MFP_UserId = ShareFitness.get(AppsRunnerConnector.ctx).getPrefsMFP_UserId(userSlot + "");
            int myFirst5kJogSpeed = v9_1;
            String v9_2 = ShareFitness.get(AppsRunnerConnector.ctx).getPrefsFitbitUserId(userSlot + "");
            if(d.strNotEmpty(MMFTokenId)) {
                MMFTokenId = "0000000000000000000000000000000000000000";
            }

            if(d.strNotEmpty(MFPTokenId)) {
                MFPTokenId = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
            }

            if(d.strNotEmpty(FitbitTokenId)) {
                FitbitTokenId = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
            }

            if(d.strNotEmpty(MFP_UserId)) {
                MFP_UserId = "000000000000000";
            }

            d.strNotEmpty(v9_2);
            String userName = user.getNickname();
            if((d.a(userName, "USER 1")) || (d.a(userName, "User 1"))) {
                userName = "USER1";
            }
            else if((d.a(userName, "USER 2")) || (d.a(userName, "User 2"))) {
                userName = "USER2";
            }
            else if((d.a(userName, "USER 3")) || (d.a(userName, "User 3"))) {
                userName = "USER3";
            }
            else if((d.a(userName, "USER 4")) || (d.a(userName, "User 4"))) {
                userName = "USER4";
            }
            else if((d.a(userName, "USER 5")) || (d.a(userName, "User 5"))) {
                userName = "USER5";
            }
            else if((d.a(userName, "USER 6")) || (d.a(userName, "User 6"))) {
                userName = "USER6";
            }
            else if(d.a(userName, "Usuario 1")) {
                userName = "Usuario1";
            }
            else if(d.a(userName, "Usuario 2")) {
                userName = "Usuario2";
            }
            else if(d.a(userName, "Usuario 3")) {
                userName = "Usuario3";
            }
            else if(d.a(userName, "Usuario 4")) {
                userName = "Usuario4";
            }
            else if(d.a(userName, "Usuario 5")) {
                userName = "Usuario5";
            }
            else if(d.a(userName, "Usuario 6")) {
                userName = "Usuario6";
            }
            else if(d.a(userName, "Utilisateur 1")) {
                userName = "Utilisateur1";
            }
            else if(d.a(userName, "Utilisateur 2")) {
                userName = "Utilisateur2";
            }
            else if(d.a(userName, "Utilisateur 3")) {
                userName = "Utilisateur3";
            }
            else if(d.a(userName, "Utilisateur 4")) {
                userName = "Utilisateur4";
            }
            else if(d.a(userName, "Utilisateur 5")) {
                userName = "Utilisateur5";
            }
            else if(d.a(userName, "Utilisateur 6")) {
                userName = "Utilisateur6";
            }

            int v14 = d.a(AppsRunnerConnector.ctx, "string", userName);
            if(v14 != 0) {
                userName = AppsRunnerConnector.ctx.getResources().getString(v14);
            }

            int userBirthDay = v10;
            j.a("==三个token为==", "MMF : " + MMFTokenId + "  |   MFP : " + MFPTokenId + "  FB:" + FitbitTokenId + " |  nickname : " + userName);
            userSyncArray[userSlot].setCustomHeartrateCRC(customHRCRCStr);
            userSyncArray[userSlot].setCustomProgramCRC(customCRCStr);
            userSyncArray[userSlot].setMFPTokenId(MFPTokenId);
            userSyncArray[userSlot].setMMFTokenId(MMFTokenId);
            userSyncArray[userSlot].setMFP_UserId(MFP_UserId);
            userSyncArray[userSlot].setUserSlot(userSlot);
            double userWeight = d.a(user.getWeight(), 0.0);
            if(units == 1) {
                userWeight = (double)Conversions.kg_to_lb(userWeight);
            }

            userSyncArray[userSlot].setUserWeight(((int)(userWeight * 10.0)));
            userSyncArray[userSlot].setUnits(units);
            userSyncArray[userSlot].setUserBirthYear(userBirthYear);
            userSyncArray[userSlot].setUserBirthMonth(userBirthMonth);
            userSyncArray[userSlot].setUserBirthDay(userBirthDay);
            userSyncArray[userSlot].setUserName(userName);
            userSyncArray[userSlot].setMyFirst5kJogSpeed(myFirst5kJogSpeed);
            userSyncArray[userSlot].setMyFirst5kResetCounter(myFirst5kResetCounter);
            userSyncArray[userSlot].setMyFirst5kWeek(myFirst5kWeek);
            userSyncArray[userSlot].setMyFirst5kWalkSpeed(myFirst5kWalkSpeed);
            userSyncArray[userSlot].setMyFirst5kWorkout(myFirst5kWorkout);
            v1 = v16;
            userSlot = v18;
            v0 = this;
        }

        UserSlow.get(AppsRunnerConnector.ctx).getMachineInfo(userSyncArray);
    }

    public int _maybe_getCRC() {
        int v0 = AppsRunner.get(AppsRunnerConnector.ctx).getPref_CurrentUserID(AppsRunnerConnector.ctx);
        return AppsRunner.get(AppsRunnerConnector.ctx).f(AppsRunnerConnector.ctx, v0 + "");
    }

    public int s() {
        int v0 = AppsRunner.get(AppsRunnerConnector.ctx).getPref_CurrentUserID(AppsRunnerConnector.ctx);
        return AppsRunner.get(AppsRunnerConnector.ctx).g(AppsRunnerConnector.ctx, v0 + "");
    }

    public void pauseWorkout() {
        j.a("===Pause Workout===", "pause workout");
        BLEManager.get(AppsRunnerConnector.ctx).maybe_send_message2(new byte[]{85, -86, 1, 0, 3, 3, 1, 0, -16, -31, 0}, 4, 1000);
    }

    public void continueWorkout() {
        j.a("===Continue Workout===", "continue workout");
        BLEManager.get(AppsRunnerConnector.ctx).maybe_send_message2(new byte[]{85, -86, 1, 0, 3, 3, 1, 0, -47, -15, 1}, 4, 1000);
    }

    public void v() {
    }

    public void rememberThisDevicew() {
        j.a("AppsRunnerConnector", "rememberThisDevice：" + this.currentConnectedDevice + " |");
        BLEDevice previousConnectedDevice = this.currentConnectedDevice;
        if(previousConnectedDevice != null) {
            String v0_1 = previousConnectedDevice.getDeviceAddress();
            if(!d.strNotEmpty(v0_1)) {
                ContextSharedPreferences.SharedPreferencesEditor(AppsRunnerConnector.ctx, "PREVIOUS_CONNECTED_DEVICE", v0_1, 5);
            }

            j.a("====记住这次连接的设备====", "| " + v0_1);
        }
    }

    public BLEDevice getCurrentConnectingDevice() {
        return this.currentConnectingDevice;
    }

    public void rememberThisMIODevicey() {
        j.a("AppsRunnerConnector", "rememberThisMIODevice：" + this.currentConnectedMIODevice + " |");
        BLEDevice previousConnectedMIODevice = this.currentConnectedMIODevice;
        if(previousConnectedMIODevice != null) {
            String v0_1 = previousConnectedMIODevice.getDeviceAddress();
            if(!d.strNotEmpty(v0_1)) {
                ContextSharedPreferences.SharedPreferencesEditor(AppsRunnerConnector.ctx, "PREVIOUS_CONNECTED_MIO_DEVICE", v0_1, 5);
            }

            j.a("====记住这次连接的MIO设备====", "| " + v0_1);
        }
    }

    public void maybeDeviceConnected() {
        BLEDevice v0 = this.currentConnectingDevice;
        if(v0 != null) {
            this.currentConnectedDevice = v0;
        }
    }
}
