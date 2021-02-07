package com.xtremeprog.shell.treadmillv2.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import apps.a.c;
import apps.activity.base.AppsRootActivity;
import apps.c.j;
import apps.c.n;
import apps.views.AppsListView;
import apps.views.d.a;
import com.xpg.a.BLEDevice;
import com.xpg.b.BLEManagerMIO;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import java.util.List;

public class AppsMIODeviceListPhoneActivity extends AppsRootActivity implements View.OnTouchListener, AdapterView.OnItemClickListener {
    final Handler i;
    private Button j;
    private Button k;
    private Button l;
    private AppsListView m;
    private c n;
    private BLEDevice o;
    private List p;
    private boolean q;
    private BroadcastReceiver r;
    private RelativeLayout s;

    public AppsMIODeviceListPhoneActivity() {
        this.o = null;
        this.p = null;
        this.q = false;
        this.r = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg2, Intent arg3) {
                String v2 = arg3.getAction();
                if(!v2.equals("NOTIFICATION_MIO_DID_FIND_DEVICE") && (!v2.equals("NOTIFICATION_STATE_MIO_DIDCONNECTSTATE") && !v2.equals("NOTIFICATION_MIO_DIDCONNECT") && !v2.equals("NOTIFICATION_MIO_DISCONNECT") && !v2.equals("NOTIFICATION_STATE_MIO_DIDCONNECT") && !v2.equals("NOTIFICATION_REFRESH_MIO_DEVICE_LIST_DATA"))) {
                    if(v2.equals("NOTIFICATION_DIDCONNECT")) {
                        AppsMIODeviceListPhoneActivity.b(AppsMIODeviceListPhoneActivity.this);
                        return;
                    }

                    if(v2.equals("NOTIFICATION_DISCONNECT")) {
                        if(!AppsMIODeviceListPhoneActivity.b(AppsMIODeviceListPhoneActivity.this)) {
                            return;
                        }

                        AppsMIODeviceListPhoneActivity.this.b(true);
                        return;
                    }

                    if(v2.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                        if(!AppsMIODeviceListPhoneActivity.b(AppsMIODeviceListPhoneActivity.this)) {
                            return;
                        }

                        AppsMIODeviceListPhoneActivity.this.b(false);
                        AppsMIODeviceListPhoneActivity.this.i.removeMessages(0x6F);
                        Intent v0 = AppsMIODeviceListPhoneActivity.this.getIntent();
                        AppsMIODeviceListPhoneActivity.this.setResult(-1, v0);
                        AppsMIODeviceListPhoneActivity.this.finish();
                        return;
                    }

                    if(v2.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                        AppsMIODeviceListPhoneActivity.this.i.removeMessages(0x6F);
                    }

                    return;
                }

                AppsMIODeviceListPhoneActivity.a(AppsMIODeviceListPhoneActivity.this).notifyDataSetChanged();
            }
        };
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    Intent v4 = new Intent(AppsMIODeviceListPhoneActivity.this, AppsDeviceListPhoneActivity.class);
                    AppsMIODeviceListPhoneActivity.this.startActivity(v4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsMIODeviceListPhoneActivity.this.b(false);
                        }
                    }, 500L);
                }
            }
        };
    }

    static c a(AppsMIODeviceListPhoneActivity arg0) {
        return arg0.n;
    }

    public void a(boolean arg2) {
        if(!arg2) {
            goto label_62;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_MIO_DID_FIND_DEVICE");
            this.registerReceiver(this.r, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_MIO_DIDCONNECT");
            this.registerReceiver(this.r, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_MIO_DISCONNECT");
            this.registerReceiver(this.r, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_STATE_MIO_DIDCONNECT");
            this.registerReceiver(this.r, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_STATE_MIO_DIDCONNECTSTATE");
            this.registerReceiver(this.r, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_REFRESH_MIO_DEVICE_LIST_DATA");
            this.registerReceiver(this.r, v2_6);
            IntentFilter v2_7 = new IntentFilter();
            v2_7.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.r, v2_7);
            IntentFilter v2_8 = new IntentFilter();
            v2_8.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.r, v2_8);
            IntentFilter v2_9 = new IntentFilter();
            v2_9.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.r, v2_9);
            IntentFilter v2_10 = new IntentFilter();
            v2_10.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.r, v2_10);
            return;
        label_62:
            this.unregisterReceiver(this.r);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static boolean b(AppsMIODeviceListPhoneActivity arg0) {
        return arg0.q;
    }

    public void b(boolean arg4) {
        j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)arg4))));
        if(arg4) {
            this.s.setVisibility(0);
            this.i.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.i.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.s.setVisibility(8);
        this.i.removeMessages(0x6F);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        n.a().e(this, 0x7F070019).setText(this.getResources().getString(0x7F0B0018));  // id:backTextView
        n.a().e(this, 0x7F07018D).setText(this.getResources().getString(0x7F0B00B4));  // id:refreshTextView
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        this.n.notifyDataSetChanged();
    }

    public void l() {
        List v0 = AppsRunnerConnector.get(this).g();
        List v1 = AppsRunnerConnector.get(this).getDeviceNameList();
        List v2 = AppsRunnerConnector.get(this).i();
        BLEDevice v5 = null;
        String v6 = null;
        String v7 = null;
        int v4;
        for(v4 = 0; v4 < v0.size(); ++v4) {
            BLEDevice v8 = (BLEDevice)v0.get(v4);
            if(AppsRunnerConnector.get(this).b(v8)) {
                String v5_1 = v8.getDeviceName();
                v7 = v8.getDeviceAddress();
                v6 = v5_1;
                v5 = v8;
            }
        }

        v0.clear();
        v1.clear();
        v2.clear();
        if(v5 != null) {
            v0.add(v5);
        }

        if(v6 != null) {
            v1.add(v6);
        }

        if(v7 != null) {
            v2.add(v7);
        }

        this.n.notifyDataSetChanged();
        BLEManagerMIO.get(this).a(0);
    }

    private void m() {
        this.b();
        this.j = n.a().a(this, 0x7F070017, this);  // id:backButton
        this.l = n.a().a(this, 0x7F0700C9, this);  // id:homeButton2
        this.k = n.a().a(this, 0x7F07018B, this);  // id:refreshButton
        this.m = (AppsListView)n.a().g(this, 0x7F070087);  // id:dataListView
        this.m.setOnItemClickListener(this);
        this.n = new c(this, 0, 0, this.p);
        this.m.setAdapter(this.n);
        this.s = n.a().c(this, 0x7F070176);  // id:noBluetoothLayout
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        this.i.removeMessages(0x6F);
        super.onBackPressed();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg2) {
        AppsRunner.get(this).b(this);
        super.onCreate(arg2);
        this.getWindow().setFlags(0x80, 0x80);
        this.setContentView(0x7F09002C);  // layout:activity_mio_device_list_phone
        this.p = AppsRunnerConnector.get(this).g();
        this.m();
        this.a(true);
        BLEManagerMIO.get(this).a(0);
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

        BLEDevice v1 = (BLEDevice)this.p.get(arg3);
        boolean v2 = AppsRunnerConnector.get(this).b(v1);
        this.o = v1;
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
                        ((AppsApplication)AppsMIODeviceListPhoneActivity.this.getApplication()).m(true);
                        AppsRunnerConnector.get(AppsMIODeviceListPhoneActivity.this).maybe_onMIODisconnect();
                        return;
                    }

                    AppsRunnerConnector.get(AppsMIODeviceListPhoneActivity.this).maybe_IsCurrentConnectingMIODevice(v1);
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
        int v0 = 1;
        this.q = true;
        AppsRunner.get(this).b(this);
        AppsApplication v1 = (AppsApplication)this.getApplication();
        if((AppsRunnerConnector.get(this).isConnected()) && (v1.n())) {
            j.a("===", "===MIODevice已连接===");
            v0 = 0;
        }
        else {
            j.a("===", "===MIODevice未连接===");
        }

        this.b(((boolean)v0));
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        this.q = false;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg1, MotionEvent arg2) {
        if(arg2.getAction() == 0) {
            if(arg1 == this.j) {
                BLEManagerMIO.get(this).a();
                this.onBackPressed();
                return true;
            }

            if(arg1 == this.l) {
                this.i.removeMessages(0x6F);
                this.setResult(-1, this.getIntent());
                this.finish();
                return true;
            }

            if(arg1 == this.k) {
                this.l();
            }
        }

        return true;
    }
}
