package com.xpg.c;

import android.content.Context;
import apps.c.j;
import com.xpg.a.BLEDevice;
import com.xpg.a.b.DeviceCommand;
import com.xpg.b.BLEManager;
import com.xpg.b.BLEManagerMIO;
import com.xpg.b.interface_a;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;

public class running_hr_treadmill_class implements interface_a {
    int a;
    private interface_a b;
    private BLEManager bleManager;
    private BLEManagerMIO bleDevice;
    private static Context mContext;
    private static AppsApplication mApp;
    private static running_hr_treadmill_class s_instance;

    static {
    }

    private running_hr_treadmill_class(Context context, AppsApplication app) {
        this.a = 0;
        running_hr_treadmill_class.mContext = context;
        running_hr_treadmill_class.mApp = app;
        this.bleDevice = BLEManagerMIO.get(context);
        this.bleManager = BLEManager.get(context);
        this.bleDevice.a(((interface_a)this));
    }

    public static running_hr_treadmill_class get(Context context, AppsApplication app) {
        if(running_hr_treadmill_class.s_instance == null) {
            running_hr_treadmill_class.s_instance = new running_hr_treadmill_class(context, app);
        }

        running_hr_treadmill_class.mApp = app;
        running_hr_treadmill_class.mContext = context;
        return running_hr_treadmill_class.s_instance;
    }

    @Override  // com.xpg.b.interface_a
    public void sendMessage(BLEDevice arg2, int arg3) {
        interface_a v0 = this.b;
        if(v0 != null) {
            v0.sendMessage(arg2, arg3);
        }
    }

    public void set_b(interface_a arg1) {
        this.b = arg1;
    }

    @Override  // com.xpg.b.interface_a
    public void receiveData(Object data, int arg5) {
        int heart_rate_value = ((byte[])data)[0] & 0xFF;
        boolean treadmillConnected = this.bleManager.isConnected();
        j.a("===收到心率值===", "值为：" + heart_rate_value);  // ===Received heart rate value===  Value is:
        if(!treadmillConnected) {  // The treadmill is not connected, Do not send heart rate to the treadmill
            j.a("===跑步机没有连接上的===", "不发送心率给跑步机");
        }
        else if((running_hr_treadmill_class.mApp.n()) && (running_hr_treadmill_class.mApp.J()) && (running_hr_treadmill_class.mApp.o())) {
            if(running_hr_treadmill_class.mApp.a()) {  // HR is locked, no need to send to the meter
                j.a("===", "==HR处于锁住状态，无须发给仪表==");
                return;
            }

            if(!AppsRunner.get(running_hr_treadmill_class.mContext).a) {  // Not in the running interface, no heart rate
                j.a("===", "==不在running界面，不发心率：" + heart_rate_value);
                return;
            }

            int v5_1 = this.a;
            this.a = v5_1 + 1;
            if(v5_1 % 3 == 0) {  // The meter is synchronized, and the model is also normal, sending heart rate
                j.a("===", "==仪表是同步完成的，且型号也正常，发心率==");
                this.bleManager.maybe_send_message_1(DeviceCommand.setHeartValueMsg(heart_rate_value));
                return;
                j.a("===", "==不在running界面，不发心率：" + heart_rate_value);
                return;
                j.a("===", "==HR处于锁住状态，无须发给仪表==");
                return;
            }
        }
    }

    @Override  // com.xpg.b.interface_a
    public void handleConnection(boolean arg2, int arg3) {
        interface_a v0 = this.b;
        if(v0 != null) {
            v0.handleConnection(((boolean)(((int)arg2))), arg3);
        }
    }
}
