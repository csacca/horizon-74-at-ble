package com.xtremeprog.shell.treadmillv2.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import apps.a.b;
import apps.activity.base.AppsRootActivity;
import apps.c.j;
import apps.c.n;
import apps.views.AppsListView;
import apps.views.d.a;
import com.xpg.a.BLEDevice;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;

public class AppsDeviceListPhoneActivity extends AppsRootActivity implements View.OnTouchListener, AdapterView.OnItemClickListener {
    private Button i;
    private Button j;
    private AppsListView k;
    private b l;
    private BLEDevice m;
    private Button n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private boolean s;
    private BroadcastReceiver t;
    private int u;

    public AppsDeviceListPhoneActivity() {
        this.m = null;
        this.o = false;
        this.p = false;
        this.r = false;
        this.s = false;
        this.t = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg3, Intent arg4) {
                Intent v3_2;
                String v3 = arg4.getAction();
                if(!v3.equals("NOTIFICATION_DID_FIND_DEVICE") && (!v3.equals("NOTIFICATION_STATE_DIDCONNECTSTATE") && !v3.equals("NOTIFICATION_DIDCONNECT"))) {
                    if(v3.equals("NOTIFICATION_DISCONNECT")) {
                        AppsDeviceListPhoneActivity.a(AppsDeviceListPhoneActivity.this, 0);
                    }
                    else if(!v3.equals("NOTIFICATION_STATE_DIDCONNECT") && !v3.equals("NOTIFICATION_REFRESH_DEVICE_LIST_DATA")) {
                        if(v3.equals("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS")) {
                            j.a("====收到machine info===", AppsDeviceListPhoneActivity.b(AppsDeviceListPhoneActivity.this) + " |");
                            if(!AppsDeviceListPhoneActivity.b(AppsDeviceListPhoneActivity.this)) {
                                return;
                            }

                            int v3_1 = (int)(((Integer)arg4.getExtras().get("Extra_Key_Workout_State")));
                            AppsDeviceListPhoneActivity.b(AppsDeviceListPhoneActivity.this, v3_1);
                            return;
                        }

                        if(!v3.equals("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER")) {
                            goto label_112;
                        }

                        if(AppsDeviceListPhoneActivity.c(AppsDeviceListPhoneActivity.this)) {
                            j.a("===同步完成===", "要进行跳转动作 : " + AppsDeviceListPhoneActivity.b(AppsDeviceListPhoneActivity.this) + "  状态：" + AppsDeviceListPhoneActivity.d(AppsDeviceListPhoneActivity.this));
                            if(AppsDeviceListPhoneActivity.b(AppsDeviceListPhoneActivity.this)) {
                                goto label_86;
                            }

                            if(!AppsDeviceListPhoneActivity.e(AppsDeviceListPhoneActivity.this)) {
                                AppsRunner.get(AppsDeviceListPhoneActivity.this).clear();
                                AppsDeviceListPhoneActivity.this.finish();
                                return;
                            label_86:
                                AppsDeviceListPhoneActivity.f(AppsDeviceListPhoneActivity.this);
                                j.a("====bluetoothReConnectedLock 1===", AppsDeviceListPhoneActivity.g(AppsDeviceListPhoneActivity.this) + " |");
                                if(AppsDeviceListPhoneActivity.d(AppsDeviceListPhoneActivity.this) != 1) {
                                    j.a("====bluetoothReConnectedLock 4===", "IDLE |");
                                    AppsRunner.get(AppsDeviceListPhoneActivity.this).clear();
                                    AppsDeviceListPhoneActivity.this.finish();
                                    return;
                                }

                                j.a("====bluetoothReConnectedLock 2===", "RUN |");
                                if(AppsDeviceListPhoneActivity.g(AppsDeviceListPhoneActivity.this) > 1) {
                                    return;
                                }

                                v3_2 = new Intent(AppsDeviceListPhoneActivity.this, Apps321PhoneActivity.class);
                                AppsDeviceListPhoneActivity.this.startActivity(v3_2);
                                AppsDeviceListPhoneActivity.this.finish();
                                return;
                            label_112:
                                if(!v3.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                                    goto label_184;
                                }

                                if(!AppsDeviceListPhoneActivity.c(AppsDeviceListPhoneActivity.this)) {
                                    return;
                                }

                                j.a("===同步完成===", "要进行跳转动作 : " + AppsDeviceListPhoneActivity.b(AppsDeviceListPhoneActivity.this) + "  状态：" + AppsDeviceListPhoneActivity.d(AppsDeviceListPhoneActivity.this));
                                if(AppsDeviceListPhoneActivity.b(AppsDeviceListPhoneActivity.this)) {
                                    goto label_146;
                                }

                                if(!AppsDeviceListPhoneActivity.e(AppsDeviceListPhoneActivity.this)) {
                                    AppsRunner.get(AppsDeviceListPhoneActivity.this).clear();
                                }
                            }

                            AppsDeviceListPhoneActivity.this.finish();
                            return;
                        label_146:
                            AppsDeviceListPhoneActivity.f(AppsDeviceListPhoneActivity.this);
                            j.a("====bluetoothReConnectedLock 1===", AppsDeviceListPhoneActivity.g(AppsDeviceListPhoneActivity.this) + " |");
                            if(AppsDeviceListPhoneActivity.d(AppsDeviceListPhoneActivity.this) == 1) {
                                j.a("====bluetoothReConnectedLock 2===", "RUN |");
                                if(AppsDeviceListPhoneActivity.g(AppsDeviceListPhoneActivity.this) > 1) {
                                    return;
                                }

                                v3_2 = new Intent(AppsDeviceListPhoneActivity.this, Apps321PhoneActivity.class);
                                AppsDeviceListPhoneActivity.this.startActivity(v3_2);
                            }
                            else {
                                j.a("====bluetoothReConnectedLock 4===", "IDLE |");
                                AppsRunner.get(AppsDeviceListPhoneActivity.this).clear();
                            }

                            AppsDeviceListPhoneActivity.this.finish();
                            return;
                        label_184:
                            if(v3.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                                AppsDeviceListPhoneActivity.c(AppsDeviceListPhoneActivity.this);
                            }
                        }

                        return;
                    }
                }

                AppsDeviceListPhoneActivity.a(AppsDeviceListPhoneActivity.this).notifyDataSetChanged();
            }
        };
        this.u = 0;
    }

    static int a(AppsDeviceListPhoneActivity arg0, int arg1) {
        arg0.u = arg1;
        return arg1;
    }

    static b a(AppsDeviceListPhoneActivity arg0) {
        return arg0.l;
    }

    public void a(boolean arg2) {
        if(!arg2) {
            goto label_62;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DID_FIND_DEVICE");
            this.registerReceiver(this.t, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.t, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.t, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_STATE_DIDCONNECT");
            this.registerReceiver(this.t, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_STATE_DIDCONNECTSTATE");
            this.registerReceiver(this.t, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_REFRESH_DEVICE_LIST_DATA");
            this.registerReceiver(this.t, v2_6);
            IntentFilter v2_7 = new IntentFilter();
            v2_7.addAction("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS");
            this.registerReceiver(this.t, v2_7);
            IntentFilter v2_8 = new IntentFilter();
            v2_8.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.t, v2_8);
            IntentFilter v2_9 = new IntentFilter();
            v2_9.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.t, v2_9);
            IntentFilter v2_10 = new IntentFilter();
            v2_10.addAction("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER");
            this.registerReceiver(this.t, v2_10);
            return;
        label_62:
            this.unregisterReceiver(this.t);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static int b(AppsDeviceListPhoneActivity arg0, int arg1) {
        arg0.q = arg1;
        return arg1;
    }

    static boolean b(AppsDeviceListPhoneActivity arg0) {
        return arg0.p;
    }

    static boolean c(AppsDeviceListPhoneActivity arg0) {
        return arg0.o;
    }

    static int d(AppsDeviceListPhoneActivity arg0) {
        return arg0.q;
    }

    static boolean e(AppsDeviceListPhoneActivity arg0) {
        return arg0.s;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        n.a().e(this, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(this, 0x7F070275).setText(this.getResources().getString(0x7F0B00C5));  // id:startTextView
        this.l.notifyDataSetChanged();
    }

    static int f(AppsDeviceListPhoneActivity arg2) {
        int v0 = arg2.u;
        arg2.u = v0 + 1;
        return v0;
    }

    static int g(AppsDeviceListPhoneActivity arg0) {
        return arg0.u;
    }

    public void l() {
        if(!AppsRunnerConnector.get(this.getApplicationContext()).G()) {
            this.a(this.getResources().getString(0x7F0B000C));  // string:STR_ALERT_TIP_NOT_OPEN_BLUETOOTH "Please turn on your bluetooth within the device"
            return;
        }

        AppsApplication v0 = (AppsApplication)this.getApplication();
        boolean v1 = AppsRunnerConnector.get(this.getApplicationContext()).isConnected();
        boolean v2 = v0.n();
        if(!v1) {
            this.a(this.getResources().getString(0x7F0B000B));  // string:STR_ALERT_TIP_CONNECT_DEVICE "Please connect your device"
            return;
        }

        if(!v2) {
            v0.start_sync_user_info();
            return;
        }

        AppsRunner.get(this).clear();
        this.finish();
    }

    private void m() {
        this.b();
        this.i = n.a().a(this, 0x7F0700C8, this);  // id:homeButton
        this.j = n.a().a(this, 0x7F07026B, this);  // id:startButton
        this.k = (AppsListView)n.a().g(this, 0x7F070087);  // id:dataListView
        this.k.setOnItemClickListener(this);
        this.l = new b(this, 0, 0, AppsRunnerConnector.get(this).f());
        this.k.setAdapter(this.l);
        this.n = n.a().a(this, 0x7F070281, this);  // id:testGetMachineInfoButton
        this.n.setVisibility(8);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        if(!AppsRunnerConnector.get(this).isConnected()) {
            AppsRunnerConnector.get(this).tryToConnectPreviousDevice();
            ((AppsApplication)this.getApplication()).b(true);
        }

        super.onBackPressed();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg3) {
        AppsRunner.get(this).b(this);
        super.onCreate(arg3);
        this.getWindow().setFlags(0x80, 0x80);
        this.setContentView(0x7F090021);  // layout:activity_device_list_phone
        if(this.getIntent().getExtras() != null) {
            if(this.getIntent().getExtras().get("Extra_Key_isFromRunning") != null) {
                this.p = ((Boolean)this.getIntent().getExtras().get("Extra_Key_isFromRunning")).booleanValue();
            }

            if(this.getIntent().getExtras().get("doNoClearData") != null) {
                this.s = ((Boolean)this.getIntent().getExtras().get("doNoClearData")).booleanValue();
            }
        }

        j.a("==DeviceListActivity doNoClearData==", this.s + " |");
        this.m();
        this.a(true);
        AppsApplication v3 = (AppsApplication)this.getApplication();
        if((AppsRunnerConnector.get(this).isConnected()) && (v3.n())) {
            this.startActivity(new Intent(this, AppsSettingPhoneActivity.class));
            this.finish();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        super.onDestroy();
        this.a(false);
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView arg1, View arg2, int arg3, long arg4) {
        if(!AppsRunnerConnector.get(this.getApplicationContext()).G()) {
            this.a(this.getResources().getString(0x7F0B000C));  // string:STR_ALERT_TIP_NOT_OPEN_BLUETOOTH "Please turn on your bluetooth within the device"
            return;
        }

        BLEDevice v1 = (BLEDevice)AppsRunnerConnector.get(this).f().get(arg3);
        j.a("==onItemClick==", arg3 + " : " + v1 + " | " + v1.getDeviceName() + "=" + v1.getDeviceAddress());
        boolean v2 = AppsRunnerConnector.get(this).a(v1);
        this.m = v1;
        try {
            a v3 = new a(this);
            v3.b(0x7F0B0134);  // string:prompt "Warning"
            String v4 = v2 ? this.getResources().getString(0x7F0B0102) : this.getResources().getString(0x7F0B0101);  // string:STR_WANT_TO_DISCONNECT "Would you like to disconnect?"
            v3.a(v4);
            v3.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                @Override  // android.content.DialogInterface$OnClickListener
                public void onClick(DialogInterface arg1, int arg2) {
                    try {
                        arg1.dismiss();
                    }
                    catch(Exception v1) {
                        v1.printStackTrace();
                    }

                    if(((boolean)(((int)v2)))) {
                        ((AppsApplication)AppsDeviceListPhoneActivity.this.getApplication()).l(true);
                        AppsRunnerConnector.get(AppsDeviceListPhoneActivity.this).j();
                        return;
                    }

                    AppsRunnerConnector.get(AppsDeviceListPhoneActivity.this).maybe_IsCurrentConnectingDevice(v1);
                }
            });
            v3.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
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
            v3.a().show();
        }
        catch(Exception v1_1) {
            v1_1.printStackTrace();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        this.o = true;
        AppsRunner.get(this).b(this);
        this.u = 0;
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        this.o = false;
        this.s = false;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg2, MotionEvent arg3) {
        if(arg3.getAction() == 0) {
            if(arg2 == this.i) {
                ((AppsApplication)this.getApplication()).h(true);
                this.onBackPressed();
                return true;
            }

            if(arg2 == this.j) {
                this.l();
                return true;
            }

            if(arg2 == this.n) {
                AppsRunnerConnector.get(this).getMachineInfo();
            }
        }

        return true;
    }
}
