package com.xtremeprog.shell.treadmillv2.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apps.activity.base.AppsRootActivity;
import apps.c.ContextSharedPreferences;
import apps.c.d;
import apps.c.f;
import apps.c.j;
import apps.c.n;
import apps.database.entity.UserArticle;
import com.xpg.a.b.DeviceCommand;
import com.xpg.a.c.Factory;
import com.xpg.b.BLEManager;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import com.xtremeprog.shell.treadmillv2.views.AppsMeterRulerView_Phone;
import com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone2.a;
import com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone2;
import com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone;
import java.util.Date;

public class AppsSettingCustomHREditPhoneActivity extends AppsRootActivity implements View.OnTouchListener {
    private Button A;
    private Button B;
    private Button C;
    private Button D;
    private String[] E;
    private String[] F;
    private int G;
    private float[] H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private BroadcastReceiver M;
    private int N;
    private int O;
    private RelativeLayout P;
    final Handler i;
    final Handler j;
    private Button k;
    private Button l;
    private Button m;
    private Button n;
    private Button o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private RelativeLayout t;
    private RelativeLayout[] u;
    private int[] v;
    private Button w;
    private Button x;
    private Button y;
    private Button z;

    public AppsSettingCustomHREditPhoneActivity() {
        this.u = null;
        this.v = new int[]{0x7F0701BC, 0x7F0701BD, 0x7F0701BE, 0x7F0701BF};  // id:setting_custom_hr_heart_rate_bpm_view1
        this.E = new String[4];
        this.F = new String[21];
        this.H = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        this.I = false;
        this.J = false;
        this.K = 0;
        this.L = true;
        this.M = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg2, Intent arg3) {
                String v2 = arg3.getAction();
                if(v2.equals("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS")) {
                    int v2_1 = AppsRunner.get(AppsSettingCustomHREditPhoneActivity.this.getApplicationContext()).l(AppsSettingCustomHREditPhoneActivity.this.getApplicationContext());
                    if(AppsSettingCustomHREditPhoneActivity.c(AppsSettingCustomHREditPhoneActivity.this) != v2_1) {
                        AppsSettingCustomHREditPhoneActivity.this.a(v2_1);
                        return;
                    }
                }
                else {
                    if(v2.equals("NOTIFICATION_DID_SET_CUSTOM_HR")) {
                        AppsSettingCustomHREditPhoneActivity.this.l();
                        AppsSettingCustomHREditPhoneActivity.this.D();
                        return;
                    }

                    if(v2.equals("NOTIFICATION_DIDCONNECT")) {
                        AppsSettingCustomHREditPhoneActivity.d(AppsSettingCustomHREditPhoneActivity.this);
                        return;
                    }

                    if(v2.equals("NOTIFICATION_DISCONNECT")) {
                        if(AppsSettingCustomHREditPhoneActivity.d(AppsSettingCustomHREditPhoneActivity.this)) {
                            AppsSettingCustomHREditPhoneActivity.this.b(true);
                            return;
                        }
                    }
                    else if(v2.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                        if(AppsSettingCustomHREditPhoneActivity.d(AppsSettingCustomHREditPhoneActivity.this)) {
                            AppsSettingCustomHREditPhoneActivity.this.b(false);
                            AppsSettingCustomHREditPhoneActivity.this.j.removeMessages(0x6F);
                            Intent v2_2 = AppsSettingCustomHREditPhoneActivity.this.getIntent();
                            v2_2.putExtra("isBack", "1");
                            AppsSettingCustomHREditPhoneActivity.this.setResult(-1, v2_2);
                            AppsSettingCustomHREditPhoneActivity.this.finish();
                            return;
                        }
                    }
                    else if(v2.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                        AppsSettingCustomHREditPhoneActivity.this.j.removeMessages(0x6F);
                    }
                }
            }
        };
        this.N = 0;
        this.O = 0;
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x12FD1) {
                    AppsSettingCustomHREditPhoneActivity.this.n();
                    return;
                }

                if(arg3.what == 88888) {
                    AppsSettingCustomHREditPhoneActivity.this.o();
                    return;
                }

                if(arg3.what == 0x2B67) {
                    AppsSettingCustomHREditPhoneActivity.this.m();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsSettingCustomHREditPhoneActivity.this.p();
                    return;
                }

                if(arg3.what == 0x8235) {
                    AppsSettingCustomHREditPhoneActivity.this.u();
                    return;
                }

                if(arg3.what == 0xAD9C) {
                    AppsSettingCustomHREditPhoneActivity.this.v();
                    return;
                }

                if(arg3.what == 0xD903) {
                    AppsSettingCustomHREditPhoneActivity.this.y();
                    return;
                }

                if(arg3.what == 0x1046A) {
                    AppsSettingCustomHREditPhoneActivity.this.z();
                }
            }
        };
        this.j = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    Intent v4 = new Intent(AppsSettingCustomHREditPhoneActivity.this, AppsDeviceListPhoneActivity.class);
                    AppsSettingCustomHREditPhoneActivity.this.startActivity(v4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsSettingCustomHREditPhoneActivity.this.b(false);
                        }
                    }, 500L);
                }
            }
        };
    }

    public void A() {
        this.i.removeMessages(0xD903);
    }

    public void B() {
        this.i.removeMessages(0x1046A);
    }

    // Detected as a lambda impl.
    public void C() {
        float v0 = (float)(((int)this.L ? ((AppsMeterView_Phone2)this.t).a : ((AppsMeterView_Phone)this.t).b.j));
        int v1 = (int)(60.0f * v0);
        String v1_1 = d.d(v1) <= 0 ? d.c(v1 + "") : d.d(v1 + "") + ":00";
        this.n.setText(v1_1);
        this.p.setText(((int)v0) + "");
    }

    public void D() {
        AppsMeterRulerView_Phone v3;
        String v4;
        Intent v0 = this.getIntent();
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < this.v.length; ++v2) {
            if(this.L) {
                v4 = "heartRateBPM" + (v2 + 1);
                v3 = ((AppsMeterView_Phone2)this.u[v2]).a;
            }
            else {
                v4 = "heartRateBPM" + (v2 + 1);
                v3 = ((AppsMeterView_Phone)this.u[v2]).b;
            }

            v0.putExtra(v4, v3.j);
        }

        while(v1 < this.H.length) {
            int v3_1 = v1 + 1;
            v0.putExtra("segmentLength" + v3_1, this.H[v1]);
            v1 = v3_1;
        }

        v0.putExtra("maxHeartRate", this.o.getText().toString());
        v0.putExtra("segment", "4");
        v0.putExtra("age", this.q.getText().toString());
        v0.putExtra("time", ((int)(this.L ? ((AppsMeterView_Phone2)this.t).a : ((AppsMeterView_Phone)this.t).b.j * 60.0)));
        this.setResult(-1, v0);
        this.finish();
    }

    public void E() {
        float v6;
        int v14;
        int v1;
        int v13;
        int v9_2;
        int v11_1;
        int v10_1;
        int v5;
        int v4_1;
        int v2_1;
        AppsSettingCustomHREditPhoneActivity v0 = this;
        if(v0.J) {
            return;
        }

        v0.J = true;
        int v3 = AppsRunner.get(this).getPref_CurrentUserID(v0);
        double v4 = 60.0;
        if(v0.L) {
            AppsMeterView_Phone2 v2 = (AppsMeterView_Phone2)v0.t;
            RelativeLayout[] v9 = v0.u;
            AppsMeterView_Phone2 v10 = (AppsMeterView_Phone2)v9[0];
            AppsMeterView_Phone2 v11 = (AppsMeterView_Phone2)v9[1];
            AppsMeterView_Phone2 v12 = (AppsMeterView_Phone2)v9[2];
            AppsMeterView_Phone2 v9_1 = (AppsMeterView_Phone2)v9[3];
            v2_1 = (int)(v2.a.j * v4);
            v4_1 = (int)d.a(v0.q.getText().toString());
            v5 = (int)v10.a.j;
            v10_1 = (int)v11.a.j;
            v11_1 = (int)v12.a.j;
            v9_2 = (int)v9_1.a.j;
            float[] v12_1 = v0.H;
            v13 = (int)(v12_1[0] * 60.0f);
            v1 = (int)(v12_1[1] * 60.0f);
            v14 = (int)(v12_1[2] * 60.0f);
            v6 = v12_1[3];
        }
        else {
            AppsMeterView_Phone v2_2 = (AppsMeterView_Phone)v0.t;
            RelativeLayout[] v9_3 = v0.u;
            AppsMeterView_Phone v10_2 = (AppsMeterView_Phone)v9_3[0];
            AppsMeterView_Phone v11_2 = (AppsMeterView_Phone)v9_3[1];
            AppsMeterView_Phone v12_2 = (AppsMeterView_Phone)v9_3[2];
            AppsMeterView_Phone v9_4 = (AppsMeterView_Phone)v9_3[3];
            v2_1 = (int)(v2_2.b.j * v4);
            v4_1 = (int)d.a(v0.q.getText().toString());
            v5 = (int)v10_2.b.j;
            v10_1 = (int)v11_2.b.j;
            v11_1 = (int)v12_2.b.j;
            v9_2 = (int)v9_4.b.j;
            float[] v12_3 = v0.H;
            v13 = (int)(v12_3[0] * 60.0f);
            v1 = (int)(v12_3[1] * 60.0f);
            v14 = (int)(v12_3[2] * 60.0f);
            v6 = v12_3[3];
        }

        int v12_4 = v11_1;
        int v11_3 = (int)(v6 * 60.0f);
        int v6_1 = v5;
        int v10_3 = v1;
        int v1_1 = v9_2;
        int v9_5 = v10_1;
        int v4_2 = v2_1;
        int v2_3 = v14;
        int v14_1 = v4_1;
        j.a("===setCustomProgram===", v3 + " | " + v4_2 + " | " + v14_1 + " | " + v6_1 + " | " + v9_5 + " | " + v12_4 + " | " + v1_1 + " | " + v13 + " | " + v10_3 + " | " + v2_3 + " | " + v11_3);
        if(v4_2 < v13 + v10_3 + v2_3 + v11_3 + 480) {
            v0.J = false;
            v0.a(this.getResources().getString(0x7F0B00E3));  // string:STR_TOTAL_TIME_IS_LESS_THAN_PROGRAM_SEGMENTS "TOTAL TIME IS LESS THAN PROGRAM SEGMENTS"
            return;
        }

        BLEManager.get(this).maybe_send_message2(DeviceCommand.setCustomHRProgramMsg(Factory.a(v3, v4_2, v14_1, v6_1, v13, v14_1, v9_5, v10_3, v14_1, v12_4, v2_3, v14_1, v1_1, v11_3)), 2, 4000);
        new Handler().postDelayed(() -> {
            AppsSettingCustomHREditPhoneActivity.this.J = false;
            return false;
        }, 1000L);

        class com.xtremeprog.shell.treadmillv2.activity.AppsSettingCustomHREditPhoneActivity.7 implements Runnable {
            @Override
            public void run() {
                AppsSettingCustomHREditPhoneActivity.a(AppsSettingCustomHREditPhoneActivity.this, false);
            }
        }

    }

    private void F() {
        this.b();
        this.k = n.a().a(this, 0x7F0700C8, this);  // id:homeButton
        this.l = n.a().a(this, 0x7F0700C9, this);  // id:homeButton2
        this.m = n.a().a(this, 0x7F07019F, this);  // id:saveButton
        this.n = n.a().a(this, 0x7F070062);  // id:customHRTotalTimeButton
        this.o = n.a().a(this, 0x7F070054);  // id:customHRMaxHeartRateButton
        this.w = n.a().a(this, 0x7F07005F, this);  // id:customHRTimeLeftButton
        this.x = n.a().a(this, 0x7F070060, this);  // id:customHRTimeRightButton
        this.y = n.a().a(this, 0x7F070052, this);  // id:customHRAgeLeftButton
        this.z = n.a().a(this, 0x7F070053, this);  // id:customHRAgeRightButton
        this.A = n.a().a(this, 0x7F07005B, this);  // id:customHRSegmentNumberLeftButton
        this.B = n.a().a(this, 0x7F07005C, this);  // id:customHRSegmentNumberRightButton
        this.C = n.a().a(this, 0x7F070058, this);  // id:customHRSegmentLengthLeftButton
        this.D = n.a().a(this, 0x7F070059, this);  // id:customHRSegmentLengthRightButton
        this.p = n.a().e(this, 0x7F070061);  // id:customHRTimeTextView
        this.q = n.a().e(this, 0x7F070013);  // id:ageTextView
        this.s = n.a().e(this, 0x7F07005A);  // id:customHRSegmentLengthTextView
        this.r = n.a().e(this, 0x7F07005D);  // id:customHRSegmentNumberTextView
        this.P = n.a().c(this, 0x7F070176);  // id:noBluetoothLayout
        if(this.L) {
            this.t = (AppsMeterView_Phone2)n.a().g(this, 0x7F0701C0);  // id:setting_custom_hr_total_time_view
            int v0;
            for(v0 = 0; v0 < this.v.length; ++v0) {
                RelativeLayout[] v1 = this.u;
                v1[v0] = (AppsMeterView_Phone2)n.a().g(this, this.v[v0]);
            }
        }
        else {
            this.t = (AppsMeterView_Phone)n.a().g(this, 0x7F0701C0);  // id:setting_custom_hr_total_time_view
            int v0_1;
            for(v0_1 = 0; v0_1 < this.v.length; ++v0_1) {
                RelativeLayout[] v1_1 = this.u;
                v1_1[v0_1] = (AppsMeterView_Phone)n.a().g(this, this.v[v0_1]);
            }
        }

        AppsRunner.get(this).getPref_CurrentUserID(this);
        int v0_2 = AppsRunner.get(this).ad();
        this.K = v0_2;
        this.q.setText(v0_2 + "");
        int v0_3 = AppsRunner.get(this).l(this);
        this.G = v0_3;
        this.a(v0_3);
        this.E = new String[]{"1", "2", "3", "4"};
        this.F = new String[]{"0.0", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0", "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.0", "8.5", "9.0", "9.5", "10.0"};
        this.G();
        this.C();
        this.c(true);
    }

    private void G() {
        int v1;
        for(v1 = 0; v1 < this.v.length; ++v1) {
            if(v1 == this.N) {
                this.u[v1].setVisibility(0);
            }
            else {
                this.u[v1].setVisibility(8);
            }
        }
    }

    private void H() {
        int v0;
        for(v0 = 0; v0 < this.v.length; ++v0) {
            if(this.L) {
                ((AppsMeterView_Phone2)this.u[v0]).setListener(new a() {
                    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone2$a
                    public void a(AppsMeterView_Phone2 arg3, double arg4) {
                        int v3 = 220 - ((int)d.a(AppsSettingCustomHREditPhoneActivity.a(AppsSettingCustomHREditPhoneActivity.this).getText().toString(), 30));
                        AppsSettingCustomHREditPhoneActivity.b(AppsSettingCustomHREditPhoneActivity.this).setText(d.doubleToStr(v3, 0));
                    }
                });
            }
            else {
                ((AppsMeterView_Phone)this.u[v0]).setListener(new com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone.a() {
                    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone$a
                    public void a(AppsMeterView_Phone arg3, double arg4) {
                        int v3 = 220 - ((int)d.a(AppsSettingCustomHREditPhoneActivity.a(AppsSettingCustomHREditPhoneActivity.this).getText().toString(), 30));
                        AppsSettingCustomHREditPhoneActivity.b(AppsSettingCustomHREditPhoneActivity.this).setText(d.doubleToStr(v3, 0));
                    }
                });
            }
        }

        if(this.L) {
            ((AppsMeterView_Phone2)this.t).setListener((/* MISSING LAMBDA PARAMETER */, /* MISSING LAMBDA PARAMETER */) -> {
                float v0 = (float)(((int)AppsSettingCustomHREditPhoneActivity.this.L ? ((AppsMeterView_Phone2)AppsSettingCustomHREditPhoneActivity.this.t).a : ((AppsMeterView_Phone)AppsSettingCustomHREditPhoneActivity.this.t).b.j));
                int v1 = (int)(60.0f * v0);
                String v1_1 = d.d(v1) <= 0 ? d.c(v1 + "") : d.d(v1 + "") + ":00";
                AppsSettingCustomHREditPhoneActivity.this.n.setText(v1_1);
                AppsSettingCustomHREditPhoneActivity.this.p.setText(((int)v0) + "");
            });
            return;
        }

        ((AppsMeterView_Phone)this.t).setListener((/* MISSING LAMBDA PARAMETER */, /* MISSING LAMBDA PARAMETER */) -> {
            float v0 = (float)(((int)AppsSettingCustomHREditPhoneActivity.this.L ? ((AppsMeterView_Phone2)AppsSettingCustomHREditPhoneActivity.this.t).a : ((AppsMeterView_Phone)AppsSettingCustomHREditPhoneActivity.this.t).b.j));
            int v1 = (int)(60.0f * v0);
            String v1_1 = d.d(v1) <= 0 ? d.c(v1 + "") : d.d(v1 + "") + ":00";
            AppsSettingCustomHREditPhoneActivity.this.n.setText(v1_1);
            AppsSettingCustomHREditPhoneActivity.this.p.setText(((int)v0) + "");
        });

        class com.xtremeprog.shell.treadmillv2.activity.AppsSettingCustomHREditPhoneActivity.3 implements a {
            @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone2$a
            public void a(AppsMeterView_Phone2 arg1, double arg2) {
                AppsSettingCustomHREditPhoneActivity.this.C();
            }
        }


        class com.xtremeprog.shell.treadmillv2.activity.AppsSettingCustomHREditPhoneActivity.4 implements com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone.a {
            @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone$a
            public void a(AppsMeterView_Phone arg1, double arg2) {
                AppsSettingCustomHREditPhoneActivity.this.C();
            }
        }

    }

    static TextView a(AppsSettingCustomHREditPhoneActivity arg0) {
        return arg0.q;
    }

    public void a(int arg10) {
        int v0 = AppsRunner.get(this).k(this);
        int v4 = 0;
        if(this.L) {
            AppsMeterView_Phone2 v1 = (AppsMeterView_Phone2)this.t;
            v1.a(0x7F0B00E4, v0, arg10, 20);  // string:STR_TOTAL_TIME_MIN "Total Time\n(Min)"
            v1.setCurrentValue(((float)(((int)(((Integer)ContextSharedPreferences.SharedPreferences(this, AppsRunner.get(this).getPref_CurrentUserID(this) + "_time_hr", Integer.valueOf(600), 1)))) / 60)));
            while(v4 < this.v.length) {
                ((AppsMeterView_Phone2)this.u[v4]).a(0x7F0B006C, v0, arg10, 21);  // string:STR_HEART_RATE_BPM "Heart\nRate\nBpm"
                ++v4;
            }
        }
        else {
            AppsMeterView_Phone v1_1 = (AppsMeterView_Phone)this.t;
            v1_1.a(0x7F0B00E4, v0, arg10, 20);  // string:STR_TOTAL_TIME_MIN "Total Time\n(Min)"
            v1_1.setCurrentValue(((float)(((int)(((Integer)ContextSharedPreferences.SharedPreferences(this, AppsRunner.get(this).getPref_CurrentUserID(this) + "_time_hr", Integer.valueOf(600), 1)))) / 60)));
            while(v4 < this.v.length) {
                ((AppsMeterView_Phone)this.u[v4]).a(0x7F0B006C, v0, arg10, 21);  // string:STR_HEART_RATE_BPM "Heart\nRate\nBpm"
                ++v4;
            }
        }
    }

    public void a(boolean arg2) {
        if(!arg2) {
            goto label_38;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS");
            this.registerReceiver(this.M, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DID_SET_CUSTOM_HR");
            this.registerReceiver(this.M, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.M, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.M, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.M, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.M, v2_6);
            return;
        label_38:
            this.unregisterReceiver(this.M);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static Button b(AppsSettingCustomHREditPhoneActivity arg0) {
        return arg0.o;
    }

    public void b(boolean arg4) {
        j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)arg4))));
        if(arg4) {
            this.P.setVisibility(0);
            this.j.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.j.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.P.setVisibility(8);
        this.j.removeMessages(0x6F);
    }

    static int c(AppsSettingCustomHREditPhoneActivity arg0) {
        return arg0.G;
    }

    private void c(boolean arg15) {
        AppsMeterRulerView_Phone v6_1;
        int v6;
        int v0 = 220 - ((int)d.a(this.q.getText().toString(), 30));
        float v1 = (float)v0;
        int v2 = (int)(0.9f * v1);
        int v1_1 = (int)(v1 * 0.75f);
        j.a("==resetHeartRateBPM==", v1_1 + " |");
        int v3 = AppsRunner.get(this).getPref_CurrentUserID(this);
        int v5;
        for(v5 = 0; v5 < this.v.length; ++v5) {
            if(arg15) {
                int v7 = v5 + 1;
                v6 = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v3 + "_hr_hr_" + v7, Float.valueOf(((float)v1_1) * 1.0f), 3)))));
                this.H[v5] = (float)(((Float)ContextSharedPreferences.SharedPreferences(this, v3 + "_segmentLength_hr_" + v7, Float.valueOf(0.5f), 3)));
            }
            else {
                v6 = v1_1;
            }

            double v8 = 1.0;
            if(this.L) {
                AppsMeterView_Phone2 v7_1 = (AppsMeterView_Phone2)this.u[v5];
                v7_1.a.i = 2.470000E-322;
                v7_1.a.d = v0;
                v7_1.a.e = v2;
                v7_1.a.h = (double)v6;
                v7_1.a.g = v8;
                v6_1 = v7_1.a;
            }
            else {
                AppsMeterView_Phone v7_2 = (AppsMeterView_Phone)this.u[v5];
                v7_2.b.i = 2.470000E-322;
                v7_2.b.d = v0;
                v7_2.b.e = v2;
                v7_2.b.h = (double)v6;
                v7_2.b.g = v8;
                v6_1 = v7_2.b;
            }

            v6_1.a(false);
        }

        this.o.setText(d.doubleToStr(v0, 0));
        this.s.setText(d.doubleToStr(this.H[this.N], 1));
    }

    static boolean d(AppsSettingCustomHREditPhoneActivity arg0) {
        return arg0.I;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        n.a().e(this, 0x7F0701A1).setText(this.getResources().getString(0x7F0B00B8));  // id:saveTextView
        n.a().e(this, 0x7F07028D).setText(this.getResources().getString(0x7F0B00BE));  // id:titleTextView
        n.a().e(this, 0x7F0702C6).setText(this.getResources().getString(0x7F0B0090));  // id:tv_title
        n.a().e(this, 0x7F0702BF).setText(this.getResources().getString(0x7F0B0026));  // id:tv_step1
        n.a().e(this, 0x7F0702C0).setText(this.getResources().getString(0x7F0B0027));  // id:tv_step2
        n.a().e(this, 0x7F0702C1).setText(this.getResources().getString(0x7F0B0028));  // id:tv_step3
        n.a().e(this, 0x7F0702C2).setText(this.getResources().getString(0x7F0B0029));  // id:tv_step4
        n.a().e(this, 0x7F0702C3).setText(this.getResources().getString(0x7F0B002A));  // id:tv_step5
        n.a().e(this, 0x7F0702B5).setText(this.getResources().getString(0x7F0B0086));  // id:tv_minutes
        n.a().e(this, 0x7F0702B2).setText(this.getResources().getString(0x7F0B0083));  // id:tv_max_heart_rate
        if(this.L) {
            ((AppsMeterView_Phone2)this.t).a();
        }
        else {
            ((AppsMeterView_Phone)this.t).a();
        }

        int v0;
        for(v0 = 0; v0 < this.v.length; ++v0) {
            if(this.L) {
                ((AppsMeterView_Phone2)this.u[v0]).a();
            }
            else {
                ((AppsMeterView_Phone)this.u[v0]).a();
            }
        }
    }

    public void l() {
        int v0 = AppsRunner.get(this).ad();
        int v0_1 = (int)d.a(this.q.getText().toString(), v0);
        int v1 = this.K - v0_1;
        j.a("==年龄改变了吗==", v1 + " = " + this.K + " - " + v0_1);
        if(v1 != 0) {
            String v0_2 = AppsRunner.get(this).ae();
            Date v2 = f.stringToDate(v0_2, "yyyy/MM/dd");
            if(v2 == null) {
                v2 = f.stringToDate("2000-01-01", "yyyy-MM-dd");
            }

            int v3 = AppsRunner.get(this).getPref_CurrentUserID(this);
            String v4 = f.a(v2, "yyyy");
            String v2_1 = f.a(v2, "MM/dd");
            String v1_1 = ((int)d.a(v4, 2000)) + v1 + "/" + v2_1;
            int v4_1 = v3 + 1;
            UserArticle v2_2 = apps.database.d.a().b(this, v4_1);
            v2_2.setBirthday(v1_1);
            j.a(v3 + "==修改user的birthday==" + v2_2.getId(), v1_1 + " |" + v0_2);
            apps.database.d.a().a(this, v2_2);
            j.a("==newBirthday==", apps.database.d.a().b(this, v4_1).getBirthday() + " |||");
        }
    }

    public void m() {
        ++this.N;
        String[] v2 = this.E;
        if(this.N > v2.length - 1) {
            this.N = v2.length - 1;
        }

        this.r.setText(this.E[this.N]);
        this.s.setText(d.doubleToStr(this.H[this.N], 1));
        this.G();
        this.i.removeMessages(0x2B67);
        Message v0 = new Message();
        v0.what = 0x2B67;
        this.i.sendMessageDelayed(v0, 0xFAL);
    }

    public void n() {
        if(this.L) {
            ((AppsMeterView_Phone2)this.t).b();
        }
        else {
            ((AppsMeterView_Phone)this.t).b();
        }

        this.i.removeMessages(0x12FD1);
        Message v0 = new Message();
        v0.what = 0x12FD1;
        this.i.sendMessageDelayed(v0, 0xFAL);
    }

    public void o() {
        if(this.L) {
            ((AppsMeterView_Phone2)this.t).c();
        }
        else {
            ((AppsMeterView_Phone)this.t).c();
        }

        this.i.removeMessages(88888);
        Message v0 = new Message();
        v0.what = 88888;
        this.i.sendMessageDelayed(v0, 0xFAL);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        this.j.removeMessages(0x6F);
        super.onBackPressed();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg3) {
        AppsMeterView_Phone2[] v3;
        AppsRunner.get(this).b(this);
        super.onCreate(arg3);
        this.getWindow().setFlags(0x80, 0x80);
        if(this.L) {
            j.a("===galaxyS7===", "==S7==");
            this.setContentView(d.a(this) ? 0x7F09004A : 0x7F090049);  // layout:activity_setting_custom_hr_edit_phone_s7_with_menu_bar
            v3 = new AppsMeterView_Phone2[4];
        }
        else {
            j.a("===NgalaxyS7===", "==NS7==");
            this.setContentView(0x7F090048);  // layout:activity_setting_custom_hr_edit_phone
            v3 = new AppsMeterView_Phone[4];
        }

        this.u = v3;
        this.F();
        this.H();
        this.a(true);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        super.onDestroy();
        this.a(false);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        int v0 = 1;
        this.I = true;
        AppsRunner.get(this).b(this);
        AppsApplication v1 = (AppsApplication)this.getApplication();
        if((AppsRunnerConnector.get(this).isConnected()) && (v1.n())) {
            j.a("===", "===CustomHREdit已连接===");
            v0 = 0;
        }
        else {
            j.a("===", "===CustomHREdit未连接===");
        }

        this.b(((boolean)v0));
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        this.I = false;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg5, MotionEvent arg6) {
        if(arg6.getAction() == 0) {
            if(arg5 == this.k || arg5 == this.l) {
                if(arg5 == this.l) {
                    this.j.removeMessages(0x6F);
                    ((AppsApplication)this.getApplication()).h(true);
                }

                Intent v0 = this.getIntent();
                v0.putExtra("isBack", "1");
                this.setResult(-1, v0);
                this.finish();
            }
            else if(arg5 == this.m) {
                this.E();
            }
        }

        if(arg6.getAction() == 0) {
            if(arg5 == this.w) {
                this.o();
                return true;
            }

            if(arg5 == this.x) {
                this.n();
                return true;
            }

            if(arg5 == this.A) {
                this.p();
                return true;
            }

            if(arg5 == this.B) {
                this.m();
                return true;
            }

            if(arg5 == this.C) {
                this.v();
                return true;
            }

            if(arg5 == this.D) {
                this.u();
                return true;
            }

            if(arg5 == this.y) {
                this.z();
                return true;
            }

            if(arg5 == this.z) {
                this.y();
                return true;
            }
        }
        else if(arg6.getAction() == 1 || arg6.getAction() == 3) {
            if(arg5 == this.w) {
                this.r();
                return true;
            }

            if(arg5 == this.x) {
                this.q();
                return true;
            }

            if(arg5 == this.A) {
                this.t();
                return true;
            }

            if(arg5 == this.B) {
                this.s();
                return true;
            }

            if(arg5 == this.C) {
                this.x();
                return true;
            }

            if(arg5 == this.D) {
                this.w();
                return true;
            }

            if(arg5 == this.y) {
                this.B();
                return true;
            }

            if(arg5 == this.z) {
                this.A();
            }
        }

        return true;
    }

    public void p() {
        --this.N;
        if(this.N < 0) {
            this.N = 0;
        }

        this.r.setText(this.E[this.N]);
        this.s.setText(d.doubleToStr(this.H[this.N], 1));
        this.G();
        this.i.removeMessages(0x56CE);
        Message v0 = new Message();
        v0.what = 0x56CE;
        this.i.sendMessageDelayed(v0, 0xFAL);
    }

    public void q() {
        this.i.removeMessages(0x12FD1);
    }

    public void r() {
        this.i.removeMessages(88888);
    }

    public void s() {
        this.i.removeMessages(0x2B67);
    }

    public void t() {
        this.i.removeMessages(0x56CE);
    }

    public void u() {
        ++this.O;
        if(this.O > 3) {
            this.O = 0;
        }

        this.s.setText(this.F[this.O]);
        float v0 = this.H[this.N] + 0.5f;
        if(v0 > 10.0f) {
            v0 = 10.0f;
        }

        if(v0 < 0.5f) {
            v0 = 0.5f;
        }

        this.H[this.N] = v0;
        this.s.setText(d.doubleToStr(v0, 1));
        this.i.removeMessages(0x8235);
        Message v0_1 = new Message();
        v0_1.what = 0x8235;
        this.i.sendMessageDelayed(v0_1, 0xFAL);
    }

    public void v() {
        --this.O;
        if(this.O < 0) {
            this.O = 0;
        }

        this.s.setText(this.F[this.O]);
        float v0 = this.H[this.N] - 0.5f;
        if(v0 > 10.0f) {
            v0 = 10.0f;
        }

        if(v0 < 0.5f) {
            v0 = 0.5f;
        }

        this.H[this.N] = v0;
        this.s.setText(d.doubleToStr(v0, 1));
        this.i.removeMessages(0xAD9C);
        Message v0_1 = new Message();
        v0_1.what = 0xAD9C;
        this.i.sendMessageDelayed(v0_1, 0xFAL);
    }

    public void w() {
        this.i.removeMessages(0x8235);
    }

    public void x() {
        this.i.removeMessages(0xAD9C);
    }

    public void y() {
        int v0 = ((int)d.a(this.q.getText().toString(), 30)) + 1;
        if(v0 > 99) {
            v0 = 99;
        }

        this.q.setText(v0 + "");
        this.c(false);
        this.i.removeMessages(0xD903);
        Message v0_1 = new Message();
        v0_1.what = 0xD903;
        this.i.sendMessageDelayed(v0_1, 0xFAL);
    }

    public void z() {
        int v0 = ((int)d.a(this.q.getText().toString(), 30)) - 1;
        if(v0 < 13) {
            v0 = 13;
        }

        this.q.setText(v0 + "");
        this.c(false);
        this.i.removeMessages(0x1046A);
        Message v0_1 = new Message();
        v0_1.what = 0x1046A;
        this.i.sendMessageDelayed(v0_1, 0xFAL);
    }
}
