package com.xtremeprog.shell.treadmillv2.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apps.activity.base.AppsRootActivity;
import apps.c.ContextSharedPreferences;
import apps.c.d;
import apps.c.j;
import apps.c.n;
import com.xpg.a.b.CustomProgram.b;
import com.xpg.a.b.CustomProgram;
import com.xpg.a.b.DeviceCommand;
import com.xpg.a.c.Factory;
import com.xpg.b.BLEManager;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import com.xtremeprog.shell.treadmillv2.Conversions;
import com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone.a;
import com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone;
import java.util.ArrayList;

public class AppsSettingCustomEditPhoneActivity extends AppsRootActivity implements View.OnTouchListener, a {
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private RelativeLayout G;
    private LinearLayout H;
    private LinearLayout I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private TextView O;
    private AppsMeterView_Phone[] P;
    private AppsMeterView_Phone[] Q;
    private AppsMeterView_Phone[] R;
    private AppsMeterView_Phone[] S;
    private AppsMeterView_Phone[] T;
    private AppsMeterView_Phone[] U;
    private AppsMeterView_Phone V;
    private AppsMeterView_Phone W;
    private Button X;
    private Button Y;
    private String[] Z;
    private String[] aa;
    private int[] ab;
    private int[] ac;
    private int[] ad;
    private int[] ae;
    private int[] af;
    private int[] ag;
    private int ah;
    private int ai;
    private float[] aj;
    private float[] ak;
    private boolean al;
    private int am;
    private int an;
    private boolean ao;
    private float ap;
    private BroadcastReceiver aq;
    private int ar;
    private int as;
    private RelativeLayout at;
    final Handler i;
    final Handler j;
    private Button k;
    private Button l;
    private Button m;
    private Button n;
    private Button o;
    private Button p;
    private TextView q;
    private LinearLayout r;
    private LinearLayout s;
    private TextView t;
    private TextView u;
    private TextView v;
    private RelativeLayout w;
    private RelativeLayout x;
    private LinearLayout y;
    private LinearLayout z;

    public AppsSettingCustomEditPhoneActivity() {
        this.Z = new String[16];
        this.aa = new String[21];
        this.ab = new int[]{0x7F070201, 0x7F070211, 0x7F070213, 0x7F070215, 0x7F070217, 0x7F070219, 0x7F07021B, 0x7F07021D, 0x7F07021F, 0x7F070202, 0x7F070204, 0x7F070206, 0x7F070208, 0x7F07020A, 0x7F07020C, 0x7F07020E};  // id:setting_custom_speed_view1
        this.ac = new int[]{0x7F0701E1, 0x7F0701F1, 0x7F0701F3, 0x7F0701F5, 0x7F0701F7, 0x7F0701F9, 0x7F0701FB, 0x7F0701FD, 0x7F0701FF, 0x7F0701E2, 0x7F0701E4, 0x7F0701E6, 0x7F0701E8, 0x7F0701EA, 0x7F0701EC, 0x7F0701EE};  // id:setting_custom_resistance_view1
        this.ad = new int[]{0x7F0701C1, 0x7F0701D1, 0x7F0701D3, 0x7F0701D5, 0x7F0701D7, 0x7F0701D9, 0x7F0701DB, 0x7F0701DD, 0x7F0701DF, 0x7F0701C2, 0x7F0701C4, 0x7F0701C6, 0x7F0701C8, 0x7F0701CA, 0x7F0701CC, 0x7F0701CE};  // id:setting_custom_incline_view1
        this.ae = new int[]{0x7F070210, 0x7F070212, 0x7F070214, 0x7F070216, 0x7F070218, 0x7F07021A, 0x7F07021C, 0x7F07021E, 0x7F070220, 0x7F070203, 0x7F070205, 0x7F070207, 0x7F070209, 0x7F07020B, 0x7F07020D, 0x7F07020F};  // id:setting_custom_speed_view1_dis
        this.af = new int[]{0x7F0701F0, 0x7F0701F2, 0x7F0701F4, 0x7F0701F6, 0x7F0701F8, 0x7F0701FA, 0x7F0701FC, 0x7F0701FE, 0x7F070200, 0x7F0701E3, 0x7F0701E5, 0x7F0701E7, 0x7F0701E9, 0x7F0701EB, 0x7F0701ED, 0x7F0701EF};  // id:setting_custom_resistance_view1_dis
        this.ag = new int[]{0x7F0701D0, 0x7F0701D2, 0x7F0701D4, 0x7F0701D6, 0x7F0701D8, 0x7F0701DA, 0x7F0701DC, 0x7F0701DE, 0x7F0701E0, 0x7F0701C3, 0x7F0701C5, 0x7F0701C7, 0x7F0701C9, 0x7F0701CB, 0x7F0701CD, 0x7F0701CF};  // id:setting_custom_incline_view1_dis
        this.ai = 0;
        this.aj = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        this.ak = new float[]{0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f};
        this.al = false;
        this.am = 1;
        this.an = 1;
        this.ao = false;
        this.ap = 0.9f;
        this.aq = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg2, Intent arg3) {
                String v2 = arg3.getAction();
                if(v2.equals("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS")) {
                    int v2_1 = AppsRunner.get(AppsSettingCustomEditPhoneActivity.this.getApplicationContext()).l(AppsSettingCustomEditPhoneActivity.this.getApplicationContext());
                    if(AppsSettingCustomEditPhoneActivity.d(AppsSettingCustomEditPhoneActivity.this) != v2_1) {
                        AppsSettingCustomEditPhoneActivity.this.a(v2_1);
                        return;
                    }
                }
                else {
                    if(v2.equals("NOTIFICATION_DID_SET_CUSTOM")) {
                        AppsSettingCustomEditPhoneActivity.this.n();
                        AppsSettingCustomEditPhoneActivity.this.w();
                        return;
                    }

                    if(v2.equals("NOTIFICATION_DIDCONNECT")) {
                        if(AppsSettingCustomEditPhoneActivity.e(AppsSettingCustomEditPhoneActivity.this)) {
                            AppsSettingCustomEditPhoneActivity.f(AppsSettingCustomEditPhoneActivity.this);
                            return;
                        }
                    }
                    else if(v2.equals("NOTIFICATION_DISCONNECT")) {
                        if(AppsSettingCustomEditPhoneActivity.e(AppsSettingCustomEditPhoneActivity.this)) {
                            AppsSettingCustomEditPhoneActivity.this.b(true);
                            return;
                        }
                    }
                    else if(v2.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                        if(AppsSettingCustomEditPhoneActivity.e(AppsSettingCustomEditPhoneActivity.this)) {
                            AppsSettingCustomEditPhoneActivity.this.b(false);
                            AppsSettingCustomEditPhoneActivity.this.j.removeMessages(0x6F);
                            Intent v2_2 = AppsSettingCustomEditPhoneActivity.this.getIntent();
                            v2_2.putExtra("isBack", "1");
                            AppsSettingCustomEditPhoneActivity.this.setResult(-1, v2_2);
                            AppsSettingCustomEditPhoneActivity.this.finish();
                            return;
                        }
                    }
                    else if(v2.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                        AppsSettingCustomEditPhoneActivity.this.j.removeMessages(0x6F);
                    }
                }
            }
        };
        this.ar = 0;
        this.as = 0;
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x2B67) {
                    AppsSettingCustomEditPhoneActivity.this.o();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsSettingCustomEditPhoneActivity.this.p();
                    return;
                }

                if(arg3.what == 0x8235) {
                    AppsSettingCustomEditPhoneActivity.this.s();
                    return;
                }

                if(arg3.what == 0xAD9C) {
                    AppsSettingCustomEditPhoneActivity.this.t();
                }
            }
        };
        this.j = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    Intent v4 = new Intent(AppsSettingCustomEditPhoneActivity.this, AppsDeviceListPhoneActivity.class);
                    AppsSettingCustomEditPhoneActivity.this.startActivity(v4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsSettingCustomEditPhoneActivity.this.b(false);
                        }
                    }, 500L);
                }
            }
        };
    }

    static float a(AppsSettingCustomEditPhoneActivity arg0) {
        return arg0.ap;
    }

    private void a(View arg7, float arg8, float arg9) {
        AnimatorSet v0 = new AnimatorSet();
        v0.playTogether(new Animator[]{ObjectAnimator.ofFloat(arg7, "scaleX", new float[]{arg8}), ObjectAnimator.ofFloat(arg7, "scaleY", new float[]{arg9}), ObjectAnimator.ofFloat(arg7, "y", new float[]{0.0f})});
        v0.setDuration(0L);
        v0.start();
    }

    static void a(AppsSettingCustomEditPhoneActivity arg0, View arg1, float arg2, float arg3) {
        arg0.a(arg1, arg2, arg3);
    }

    public void a(int arg13) {
        int v0 = AppsRunner.get(this).k(this);
        int v1 = 0;
        int v2;
        for(v2 = 0; true; ++v2) {
            AppsMeterView_Phone[] v3 = this.P;
            if(v2 >= v3.length) {
                break;
            }

            v3[v2].a(0x7F0B00D8, v0, arg13, 13);  // string:STR_TITLE_SPEED "Speed"
        }

        int v2_1;
        for(v2_1 = 0; true; ++v2_1) {
            AppsMeterView_Phone[] v3_1 = this.Q;
            if(v2_1 >= v3_1.length) {
                break;
            }

            v3_1[v2_1].a(0x7F0B00D6, v0, arg13, 25);  // string:STR_TITLE_RESISTENCE "Resistance"
            this.Q[v2_1].setTitleViewLines(1);
        }

        int v2_2;
        for(v2_2 = 0; true; ++v2_2) {
            AppsMeterView_Phone[] v3_2 = this.R;
            if(v2_2 >= v3_2.length) {
                break;
            }

            v3_2[v2_2].a(0x7F0B00D2, v0, arg13, 14);  // string:STR_TITLE_INCLINE "Incline"
        }

        int v2_3;
        for(v2_3 = 0; true; ++v2_3) {
            AppsMeterView_Phone[] v3_3 = this.S;
            if(v2_3 >= v3_3.length) {
                break;
            }

            v3_3[v2_3].a(0x7F0B00D8, v0, arg13, 13);  // string:STR_TITLE_SPEED "Speed"
        }

        int v2_4;
        for(v2_4 = 0; true; ++v2_4) {
            AppsMeterView_Phone[] v3_4 = this.T;
            if(v2_4 >= v3_4.length) {
                break;
            }

            v3_4[v2_4].a(0x7F0B00D6, v0, arg13, 25);  // string:STR_TITLE_RESISTENCE "Resistance"
            this.T[v2_4].setTitleViewLines(1);
        }

        while(true) {
            AppsMeterView_Phone[] v2_5 = this.U;
            if(v1 >= v2_5.length) {
                return;
            }

            v2_5[v1].a(0x7F0B00D2, v0, arg13, 14);  // string:STR_TITLE_INCLINE "Incline"
            ++v1;
        }
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone$a
    public void a(AppsMeterView_Phone arg5, double arg6) {
        j.a("==meterViewDidChangeValue==", arg5.getValue() + " | " + arg6);
        if(arg5 == this.V) {
            float[] v6 = this.aj;
            int v7 = arg5.a;
            v6[v7] = (float)arg5.getValue();
            return;
        }

        if(arg5 == this.W) {
            float[] v6_1 = this.ak;
            int v7_1 = arg5.a;
            v6_1[v7_1] = (float)arg5.getValue();
        }
    }

    public void a(boolean arg2) {
        if(!arg2) {
            goto label_38;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS");
            this.registerReceiver(this.aq, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DID_SET_CUSTOM");
            this.registerReceiver(this.aq, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.aq, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.aq, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.aq, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.aq, v2_6);
            return;
        label_38:
            this.unregisterReceiver(this.aq);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static AppsMeterView_Phone b(AppsSettingCustomEditPhoneActivity arg0) {
        return arg0.V;
    }

    public void b(boolean arg4) {
        j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)arg4))));
        if(arg4) {
            this.at.setVisibility(0);
            this.j.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.j.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.at.setVisibility(8);
        this.j.removeMessages(0x6F);
    }

    static AppsMeterView_Phone c(AppsSettingCustomEditPhoneActivity arg0) {
        return arg0.W;
    }

    static int d(AppsSettingCustomEditPhoneActivity arg0) {
        return arg0.ah;
    }

    static boolean e(AppsSettingCustomEditPhoneActivity arg0) {
        return arg0.al;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        int v2_1;
        Resources v1_1;
        TextView v0_1;
        int v2;
        Resources v1;
        TextView v0;
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        n.a().e(this, 0x7F0701A1).setText(this.getResources().getString(0x7F0B00B8));  // id:saveTextView
        n.a().e(this, 0x7F07028D).setText(this.getResources().getString(0x7F0B00BE));  // id:titleTextView
        n.a().e(this, 0x7F0702DC).setText(this.getResources().getString(0x7F0B00DF));  // id:tv_total_segment
        n.a().e(this, 0x7F0702DD).setText(this.getResources().getString(0x7F0B00E1));  // id:tv_total_time
        n.a().e(this, 0x7F0702DB).setText(this.getResources().getString(0x7F0B00DD));  // id:tv_total_distance
        n.a().e(this, 0x7F0702C0).setText(this.getResources().getString(0x7F0B002D));  // id:tv_step2
        if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
            v0 = n.a().e(this, 0x7F0702C1);  // id:tv_step3
            v1 = this.getResources();
            v2 = 0x7F0B002B;  // string:STR_CUSTOM_SELECT_LENGTH_OF_SEGMENT_INCLINE_AND_RESISTANCE "Step 3. Select length of segment,incline and resistance"
        }
        else {
            v0 = n.a().e(this, 0x7F0702C1);  // id:tv_step3
            v1 = this.getResources();
            v2 = 0x7F0B002C;  // string:STR_CUSTOM_SELECT_LENGTH_OF_SEGMENT_INCLINE_AND_SPEED "Step 3. Select length of segment,incline and speed"
        }

        v0.setText(v1.getString(v2));
        n.a().e(this, 0x7F070074).setText(this.getResources().getString(0x7F0B0032));  // id:customStep4TipTextView1
        n.a().e(this, 0x7F070075).setText(this.getResources().getString(0x7F0B0032));  // id:customStep4TipTextView1_dis
        n.a().e(this, 0x7F070076).setText(this.getResources().getString(0x7F0B0031));  // id:customStep4TipTextView2
        n.a().e(this, 0x7F070077).setText(this.getResources().getString(0x7F0B0031));  // id:customStep4TipTextView2_dis
        n.a().e(this, 0x7F07028A).setText(this.getResources().getString(0x7F0B0086));  // id:timeUnitTextView
        n.a().e(this, 0x7F0702C6).setText(this.getResources().getString(0x7F0B008A));  // id:tv_title
        n.a().e(this, 0x7F0702B7).setText(this.getResources().getString(0x7F0B00AA));  // id:tv_next_segment
        if(AppsRunner.get(this).Y() == 1) {
            v0_1 = this.u;
            v1_1 = this.getResources();
            v2_1 = 0x7F0B007A;  // string:STR_KM "km"
        }
        else {
            v0_1 = this.u;
            v1_1 = this.getResources();
            v2_1 = 0x7F0B0085;  // string:STR_MILES "Miles"
        }

        v0_1.setText(v1_1.getString(v2_1));
        this.V.a();
        this.W.a();
        int v0_2 = 0;
        int v1_2;
        for(v1_2 = 0; v1_2 < this.P.length; ++v1_2) {
            ((AppsMeterView_Phone)n.a().g(this, this.ab[v1_2])).a();
        }

        int v1_3;
        for(v1_3 = 0; v1_3 < this.Q.length; ++v1_3) {
            ((AppsMeterView_Phone)n.a().g(this, this.ac[v1_3])).a();
        }

        int v1_4;
        for(v1_4 = 0; v1_4 < this.R.length; ++v1_4) {
            ((AppsMeterView_Phone)n.a().g(this, this.ad[v1_4])).a();
        }

        int v1_5;
        for(v1_5 = 0; v1_5 < this.S.length; ++v1_5) {
            ((AppsMeterView_Phone)n.a().g(this, this.ae[v1_5])).a();
        }

        int v1_6;
        for(v1_6 = 0; v1_6 < this.T.length; ++v1_6) {
            ((AppsMeterView_Phone)n.a().g(this, this.af[v1_6])).a();
        }

        while(v0_2 < this.U.length) {
            ((AppsMeterView_Phone)n.a().g(this, this.ag[v0_2])).a();
            ++v0_2;
        }
    }

    static void f(AppsSettingCustomEditPhoneActivity arg0) {
        arg0.y();
    }

    public void l() {
        if(this.ai == 0) {
            this.r.setVisibility(0);
            this.s.setVisibility(8);
            this.t.setVisibility(0);
            this.u.setVisibility(8);
        }
        else {
            this.r.setVisibility(8);
            this.s.setVisibility(0);
            this.t.setVisibility(8);
            this.u.setVisibility(0);
        }

        this.u();
        this.v();
    }

    public void m() {
        AppsMeterView_Phone v4_3;
        AppsMeterView_Phone v4_2;
        float v4;
        AppsMeterView_Phone v0;
        if(this.ai == 0) {
            j.a("==showMeterViews1==", ((float)d.a(this.aj[this.ar], 1)) + " |");
            this.V.setVisibility(0);
            this.W.setVisibility(8);
            v0 = this.V;
            v4 = this.aj[this.ar];
        }
        else {
            j.a("==showMeterViews2==", ((float)d.a(this.ak[this.ar], 1)) + " |");
            this.V.setVisibility(8);
            this.W.setVisibility(0);
            v0 = this.W;
            v4 = this.ak[this.ar];
        }

        v0.setCurrentValue(((float)d.a(v4, 1)));
        boolean v0_1 = AppsRunner.get(this).inclineSupportsHalfDegree(this);
        int v1;
        for(v1 = 0; true; ++v1) {
            AppsMeterView_Phone[] v4_1 = this.P;
            if(v1 >= v4_1.length) {
                return;
            }

            if(this.ai == 0) {
                if(v1 == this.ar) {
                    if(v0_1) {
                        this.Q[v1].setVisibility(0);
                        v4_2 = this.P[v1];
                    }
                    else {
                        v4_1[v1].setVisibility(0);
                        v4_2 = this.Q[v1];
                    }

                    v4_2.setVisibility(8);
                    this.R[v1].setVisibility(0);
                }
                else {
                    this.Q[v1].setVisibility(8);
                    this.P[v1].setVisibility(8);
                    this.R[v1].setVisibility(8);
                }
            }
            else if(v1 == this.ar) {
                if(v0_1) {
                    this.T[v1].setVisibility(0);
                    v4_3 = this.S[v1];
                }
                else {
                    this.S[v1].setVisibility(0);
                    v4_3 = this.T[v1];
                }

                v4_3.setVisibility(8);
                this.U[v1].setVisibility(0);
            }
            else {
                this.T[v1].setVisibility(8);
                this.S[v1].setVisibility(8);
                this.U[v1].setVisibility(8);
            }
        }
    }

    public void n() {
        this.f();
    }

    public void o() {
        ++this.ar;
        String[] v2 = this.Z;
        if(this.ar > v2.length - 1) {
            this.ar = v2.length - 1;
        }

        String v0 = this.Z[this.ar];
        this.q.setText(v0);
        int v0_1 = (int)d.a(v0, 1);
        if(this.ai == 0) {
            if(v0_1 > this.am) {
                this.am = v0_1;
            }
        }
        else if(v0_1 > this.an) {
            this.an = v0_1;
        }

        if(this.ai == 0) {
            int v1 = this.ar;
            float v0_2 = this.aj[v1];
            this.V.a = v1;
            this.u();
        }
        else {
            int v1_1 = this.ar;
            float v0_3 = this.ak[v1_1];
            this.W.a = v1_1;
            this.v();
        }

        this.m();
        this.i.removeMessages(0x2B67);
        Message v0_4 = new Message();
        v0_4.what = 0x2B67;
        this.i.sendMessageDelayed(v0_4, 0xFAL);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        this.j.removeMessages(0x6F);
        super.onBackPressed();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg2) {
        int v2;
        AppsRunner.get(this).b(this);
        super.onCreate(arg2);
        this.getWindow().setFlags(0x80, 0x80);
        if(d.c()) {
            v2 = 0x7F090042;  // layout:activity_setting_custom_edit_phone_s7
        }
        else if(d.d()) {
            v2 = 0x7F090043;  // layout:activity_setting_custom_edit_phone_s9
        }
        else {
            v2 = d.a(this) ? 0x7F090044 : 0x7F090041;  // layout:activity_setting_custom_edit_phone_with_menu_bar
        }

        this.setContentView(v2);
        if(this.getIntent().getExtras() != null && this.getIntent().getExtras().get("segmentType") != null) {
            this.ai = (int)(((Integer)this.getIntent().getExtras().get("segmentType")));
        }

        this.z();
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
        this.al = true;
        AppsRunner.get(this).b(this);
        this.y();
        this.m();
        AppsApplication v1 = (AppsApplication)this.getApplication();
        if((AppsRunnerConnector.get(this).isConnected()) && (v1.n())) {
            j.a("===", "===CustomEdit已连接===");
            v0 = 0;
        }
        else {
            j.a("===", "===CustomEdit未连接===");
        }

        this.b(((boolean)v0));
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        this.al = false;
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
            else if(arg5 == this.m || arg5 == this.x) {
                this.a(this, "");
                this.x();
            }
        }

        if(arg6.getAction() == 0) {
            if(arg5 == this.X) {
                this.p();
                return true;
            }

            if(arg5 == this.Y) {
                this.o();
                return true;
            }
        }
        else if(arg6.getAction() == 1 || arg6.getAction() == 3) {
            if(arg5 == this.X) {
                this.r();
                return true;
            }

            if(arg5 == this.Y) {
                this.q();
            }
        }

        return true;
    }

    public void p() {
        --this.ar;
        if(this.ar < 0) {
            this.ar = 0;
        }

        this.q.setText(this.Z[this.ar]);
        if(this.ai == 0) {
            int v1 = this.ar;
            float v0 = this.aj[v1];
            this.V.a = v1;
            this.u();
        }
        else {
            int v1_1 = this.ar;
            float v0_1 = this.ak[v1_1];
            this.W.a = v1_1;
            this.v();
        }

        this.m();
        this.i.removeMessages(0x56CE);
        Message v0_2 = new Message();
        v0_2.what = 0x56CE;
        this.i.sendMessageDelayed(v0_2, 0xFAL);
    }

    public void q() {
        this.i.removeMessages(0x2B67);
    }

    public void r() {
        this.i.removeMessages(0x56CE);
    }

    public void s() {
        ++this.as;
        if(this.as > this.ai == 0 ? this.aj.length : this.ak.length - 1) {
            this.as = 0;
        }

        if(this.ai == 0) {
            float v0 = this.aj[this.ar] + 0.5f;
            if(v0 > 10.0f) {
                v0 = 10.0f;
            }

            if(v0 < 0.5f) {
                v0 = 0.5f;
            }

            this.aj[this.ar] = v0;
            this.u();
        }
        else {
            float v0_1 = this.ak[this.ar] + 0.1f;
            if(v0_1 > 2.0f) {
                v0_1 = 2.0f;
            }

            if(v0_1 < 0.1f) {
                v0_1 = 0.1f;
            }

            this.ak[this.ar] = v0_1;
            this.v();
        }

        this.m();
        this.i.removeMessages(0x8235);
        Message v0_2 = new Message();
        v0_2.what = 0x8235;
        this.i.sendMessageDelayed(v0_2, 0xFAL);
    }

    public void t() {
        --this.as;
        if(this.as < 0) {
            this.as = this.ai == 0 ? this.aj.length : this.ak.length - 1;
        }

        if(this.ai == 0) {
            float v0 = this.aj[this.ar] - 0.5f;
            if(v0 > 10.0f) {
                v0 = 10.0f;
            }

            if(v0 < 0.5f) {
                v0 = 0.5f;
            }

            this.aj[this.ar] = v0;
            this.u();
        }
        else {
            float v0_1 = this.ak[this.ar] - 0.1f;
            if(v0_1 > 2.0f) {
                v0_1 = 2.0f;
            }

            if(v0_1 < 0.1f) {
                v0_1 = 0.1f;
            }

            this.ak[this.ar] = v0_1;
            this.v();
        }

        this.i.removeMessages(0xAD9C);
        Message v0_2 = new Message();
        v0_2.what = 0xAD9C;
        this.i.sendMessageDelayed(v0_2, 0xFAL);
    }

    public void u() {
        float v2_2;
        Button v1_2;
        String v0_3;
        int v2;
        StringBuilder v1;
        TextView v0;
        if(this.ai == 0) {
            this.p.setText(this.am + "");
            v0 = this.K;
            v1 = new StringBuilder();
            v2 = this.am;
        }
        else {
            this.p.setText(this.an + "");
            v0 = this.K;
            v1 = new StringBuilder();
            v2 = this.an;
        }

        v1.append(v2);
        v1.append("");
        v0.setText(v1.toString());
        float v0_1 = 0.0f;
        int v1_1;
        for(v1_1 = 0; true; ++v1_1) {
            float[] v2_1 = this.aj;
            if(v1_1 >= v2_1.length || v1_1 >= this.am) {
                break;
            }

            v0_1 += v2_1[v1_1];
        }

        int v0_2 = (int)(v0_1 * 60.0f);
        if(d.d(v0_2) > 0) {
            v0_3 = d.a(v0_2);
            v1_2 = this.n;
            v2_2 = 12.0f;
        }
        else {
            v0_3 = d.c(v0_2 + "");
            v1_2 = this.n;
            v2_2 = 18.0f;
        }

        v1_2.setTextSize(v2_2);
        this.v.setText(v0_3);
        this.N.setText(v0_3);
    }

    public void v() {
        int v2;
        StringBuilder v1;
        TextView v0;
        if(this.ai == 0) {
            this.p.setText(this.am + "");
            v0 = this.K;
            v1 = new StringBuilder();
            v2 = this.am;
        }
        else {
            this.p.setText(this.an + "");
            v0 = this.K;
            v1 = new StringBuilder();
            v2 = this.an;
        }

        v1.append(v2);
        v1.append("");
        v0.setText(v1.toString());
        float v0_1 = 0.0f;
        int v1_1;
        for(v1_1 = 0; true; ++v1_1) {
            float[] v2_1 = this.ak;
            if(v1_1 >= v2_1.length || v1_1 >= this.an) {
                break;
            }

            v0_1 += v2_1[v1_1];
        }

        String v0_2 = d.doubleToStr(v0_1, 1);
        this.o.setText(v0_2);
        this.O.setText(v0_2);
    }

    public void w() {
        int v5;
        StringBuilder v4;
        String v1_1;
        AppsSettingCustomEditPhoneActivity v0 = this;
        int v1 = AppsRunner.get(this).getPref_CurrentUserID(v0);
        int v2 = (int)d.a(v0.q.getText().toString(), 1);
        if(v0.ai == 0) {
            ContextSharedPreferences.SharedPreferencesEditor(v0, v1 + "_maxSegment", Integer.valueOf(v2), 1);
            v1_1 = "_maxSegment_save";
            v4 = new StringBuilder();
        }
        else {
            ContextSharedPreferences.SharedPreferencesEditor(v0, v1 + "_maxSegmentDis", Integer.valueOf(v2), 1);
            v1_1 = "_maxSegmentDis_save_1";
            v4 = new StringBuilder();
        }

        v4.append(v2);
        v4.append(" |");
        j.a(v1_1, v4.toString());
        Intent v1_2 = this.getIntent();
        v1_2.putExtra("type", v0.ai == 0 ? "TIME" : "DISTANCE");
        int v6 = 0;
        float v7 = 0.0f;
        float v8 = 0.0f;
        float v9 = 0.0f;
        while(true) {
            AppsMeterView_Phone[] v10 = v0.P;
            if(v6 >= v10.length) {
                break;
            }

            AppsMeterView_Phone v7_1 = v10[v6];
            AppsMeterView_Phone v8_1 = v0.Q[v6];
            AppsMeterView_Phone v9_1 = v0.R[v6];
            AppsMeterView_Phone v10_1 = v0.S[v6];
            AppsMeterView_Phone v11 = v0.T[v6];
            AppsMeterView_Phone v12 = v0.U[v6];
            double v13 = d.a(v7_1.b.j, 1);
            double v4_1 = d.a(v8_1.b.j, 1);
            double v8_2 = d.a(v9_1.b.j, 1);
            double v7_2 = d.a(v10_1.b.j, 1);
            double v9_2 = d.a(v11.b.j, 1);
            double v11_1 = d.a(v12.b.j, 1);
            j.a("==speedValue" + v6 + "==", v13 + " | " + v7_2);
            ++v6;
            v1_2.putExtra("speed" + v6, v13);
            v1_2.putExtra("resistance" + v6, v4_1);
            v1_2.putExtra("incline" + v6, v8_2);
            v1_2.putExtra("speed_dis" + v6, v7_2);
            v1_2.putExtra("resistance_dis" + v6, v9_2);
            v1_2.putExtra("incline_dis" + v6, v11_1);
            v8 = (float)v7_1.b.d;
            v9 = (float)v8_1.b.d;
            v7 = (float)v9_1.b.d;
            v2 = v2;
        }

        int v22 = v2;
        int v2_1;
        for(v2_1 = 0; v2_1 < v0.aj.length; v2_1 = v4_2) {
            int v4_2 = v2_1 + 1;
            v1_2.putExtra("segmentLength" + v4_2, v0.aj[v2_1]);
            v1_2.putExtra("segmentLengthDis" + v4_2, v0.ak[v2_1]);
        }

        int v2_2 = 0;
        float v3 = 0.0f;
        while(true) {
            float[] v4_3 = v0.aj;
            if(v2_2 >= v4_3.length) {
                break;
            }

            v5 = v22;
            if(v2_2 >= v5) {
                goto label_203;
            }

            v3 += v4_3[v2_2];
            ++v2_2;
            v22 = v5;
        }

        v5 = v22;
    label_203:
        int v2_3 = 0;
        float v16 = 0.0f;
        while(true) {
            float[] v4_4 = v0.ak;
            if(v2_3 >= v4_4.length || v2_3 >= v5) {
                break;
            }

            v16 += v4_4[v2_3];
            ++v2_3;
        }

        v1_2.putExtra("time", ((int)(v3 * 60.0f)));
        v1_2.putExtra("distance", ((int)(10.0f * v16)));
        v1_2.putExtra("totalSegments", v0.q.getText().toString());
        v1_2.putExtra("totalDistance", v0.o.getText().toString());
        v1_2.putExtra("maxSpeed", v8);
        v1_2.putExtra("maxResistance", v9);
        v1_2.putExtra("maxIncline", v7);
        v1_2.putExtra("doNotSendSelectProgramAfterSaveProgramSuccess", true);
        v0.setResult(-1, v1_2);
        this.finish();
    }

    public void x() {
        double v2_6;
        int v1_5;
        int v1_3;
        ArrayList v8_2;
        b v15_1;
        int v1_2;
        com.xpg.a.b.CustomProgram.a v10_1;
        double v28;
        double v2_2;
        ArrayList v26;
        ArrayList v25;
        b v15;
        AppsSettingCustomEditPhoneActivity v0 = this;
        if(v0.ao) {
            return;
        }

        v0.ao = true;
        ArrayList v2 = new ArrayList();
        ArrayList v3 = new ArrayList();
        boolean v4 = AppsRunner.get(this).inclineSupportsHalfDegree(v0);
        int v5 = AppsRunner.get(this).Y();
        int v6 = AppsRunner.get(this).getPref_CurrentUserID(v0);
        CustomProgram v7 = Factory.customProgram(AppsRunner.get(this).getPref_CurrentUserID(v0), v2, v3);
        v7.d(v6);
        v7.a(v5);
        int v8 = (int)d.a(v0.q.getText().toString(), 1);
        if(v0.ai == 0) {
            v7.b(v8);
            v7.c(v0.an);
        }
        else {
            v7.b(v0.am);
            v7.c(v8);
        }

        double v9 = 0.5;
        double v11 = v5 == 1 ? 0.8 : v9;
        int v14 = 0;
        while(v14 < 16) {
            if(v5 == 1) {
                Conversions.b(v9);
                Conversions.b(v9);
            }

            double v19 = 5.0;
            double v21 = 10.0;
            double v23 = 1000.0;
            if(v0.ai == 0) {
                if(v14 < v8) {
                    AppsMeterView_Phone v9_1 = v0.P[v14];
                    AppsMeterView_Phone v10 = v0.Q[v14];
                    AppsMeterView_Phone v13 = v0.R[v14];
                    v7.getClass();
                    v15 = new b(v7);
                    v25 = v2;
                    v26 = v3;
                    double v2_1 = d.a(v13.b.j, 1);
                    v15.c(((int)v4 ? v2_1 * v19 : v2_1 * v21));
                    if(v4) {
                        v2_2 = d.a(v10.b.j, 1);
                    }
                    else {
                        double v2_3 = d.a(v9_1.b.j, 1);
                        if(v5 == 1) {
                            v2_3 = d.a(Conversions.a(v2_3), 3);
                        }

                        v2_2 = v2_3 * v23;
                    }

                    v15.b(((int)v2_2));
                    v15.a(((int)(v0.aj[v14] * 60.0f)));
                }
                else {
                    v25 = v2;
                    v26 = v3;
                    v7.getClass();
                    v15 = new b(v7);
                    v15.c(0);
                    if(v4) {
                        v15.b(1);
                    }
                    else {
                        v15.b(((int)(v5 == 1 ? d.a(Conversions.a(v11), 3) : v11 * v23)));
                    }

                    v15.a(60);
                }

                int v3_1 = v14 + 1;
                double v9_2 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6 + "_speed_dis_" + v3_1, Float.valueOf(0.5f), 3)))));
                double v1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6 + "_incline_dis_" + v3_1, Float.valueOf(0.0f), 3)))));
                b v16 = v15;
                int v27 = v8;
                v28 = v11;
                double v11_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6 + "_resistance_dis_" + v3_1, Float.valueOf(1.0f), 3)))));
                float v3_2 = (float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6 + "_segmentLengthDis_" + v3_1, Float.valueOf(0.1f), 3)));
                double v8_1 = d.a(v9_2, 3);
                double v1_1 = d.a(v1, 1);
                double v11_2 = d.a(v11_1, 1);
                v7.getClass();
                v10_1 = new com.xpg.a.b.CustomProgram.a(v7);
                if(v14 < v0.an) {
                    v10_1.c(((int)v4 ? v1_1 * v19 : v1_1 * v21));
                    v10_1.b(v4 ? ((int)v11_2) : ((int)(v8_1 * v23)));
                    v1_2 = (int)(v3_2 * 1000.0f);
                }
                else {
                    v10_1.c(0);
                    v10_1.b(v4 ? 1 : ((int)(v5 == 1 ? d.a(Conversions.a(v28), 3) : v28 * v23)));
                    v1_2 = 100;
                }

                v10_1.a(v1_2);
                v15_1 = v16;
                v8_2 = v25;
                v1_3 = v27;
            }
            else {
                ArrayList v25_1 = v2;
                v26 = v3;
                int v27_1 = v8;
                v28 = v11;
                int v2_4 = v14 + 1;
                double v8_3 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6 + "_speed_" + v2_4, Float.valueOf(0.5f), 3)))));
                double v11_3 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6 + "_incline_" + v2_4, Float.valueOf(0.0f), 3)))));
                double v10_2 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6 + "_resistance_" + v2_4, Float.valueOf(1.0f), 3)))));
                float v1_4 = (float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6 + "_segmentLength_" + v2_4, Float.valueOf(1.0f), 3)));
                double v8_4 = d.a(v8_3, 3);
                double v12 = d.a(v11_3, 1);
                double v10_3 = d.a(v10_2, 1);
                v7.getClass();
                v15_1 = new b(v7);
                if(v14 < v0.am) {
                    v15_1.c(((int)v4 ? v12 * v19 : v12 * v21));
                    v15_1.b(v4 ? ((int)v10_3) : ((int)(v8_4 * v23)));
                    v1_5 = (int)(v1_4 * 60.0f);
                }
                else {
                    v15_1.c(0);
                    v15_1.b(v4 ? 1 : ((int)(v5 == 1 ? d.a(Conversions.a(v28), 3) : v28 * v23)));
                    v1_5 = 60;
                }

                v15_1.a(v1_5);
                v1_3 = v27_1;
                if(v14 < v1_3) {
                    AppsMeterView_Phone v2_5 = v0.S[v14];
                    AppsMeterView_Phone v3_3 = v0.T[v14];
                    AppsMeterView_Phone v8_5 = v0.U[v14];
                    v7.getClass();
                    v10_1 = new com.xpg.a.b.CustomProgram.a(v7);
                    double v8_6 = d.a(v8_5.b.j, 1);
                    v10_1.c(((int)v4 ? v8_6 * v19 : v8_6 * v21));
                    if(v4) {
                        v2_6 = d.a(v3_3.b.j, 1);
                    }
                    else {
                        double v2_7 = d.a(v2_5.b.j, 1);
                        if(v5 == 1) {
                            v2_7 = d.a(Conversions.a(v2_7), 3);
                        }

                        v2_6 = v2_7 * v23;
                    }

                    v10_1.b(((int)v2_6));
                    v10_1.a(((int)(v0.ak[v14] * 1000.0f)));
                }
                else {
                    v7.getClass();
                    v10_1 = new com.xpg.a.b.CustomProgram.a(v7);
                    v10_1.c(0);
                    if(v4) {
                        v10_1.b(1);
                    }
                    else {
                        v10_1.b(((int)(v5 == 1 ? d.a(Conversions.a(v28), 3) : v28 * v23)));
                    }

                    v10_1.a(100);
                }

                v8_2 = v25_1;
            }

            v8_2.add(v15_1);
            v26.add(v10_1);
            ++v14;
            v2 = v8_2;
            v3 = v26;
            v11 = v28;
            v9 = 0.5;
            v8 = v1_3;
        }

        j.a("===setCustomCRC.segmentType===", v0.ai + " |");
        j.a("===setCustomCRC.userSlot===", v7.getUserId() + " |");
        j.a("===setCustomCRC.unit===", v7.getUnit() + " |");
        j.a("===setCustomCRC.timeSegment===", v7.getTimeSegmentNumber() + " |");
        j.a("===setCustomCRC.distanceSegment===", v7.getDistanceSegmentNumber() + " |");
        j.a("===setCustomCRC.setCustomProgram===", v2 + " | " + v3);
        j.a("===setCustomCRC.setCustomProgram2===", v7 + " |");
        BLEManager.get(this).maybe_send_message2(DeviceCommand.setCustomProgramMsg(v7), 2, 4000);
        new Handler().postDelayed(() -> {
            AppsSettingCustomEditPhoneActivity.this.ao = false;
            return false;
        }, 1000L);

        class com.xtremeprog.shell.treadmillv2.activity.AppsSettingCustomEditPhoneActivity.3 implements Runnable {
            @Override
            public void run() {
                AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this, false);
            }
        }

    }

    private void y() {
        boolean v0 = AppsRunner.get(this).inclineSupportsHalfDegree(this);
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        if(v0) {
            this.y.setVisibility(8);
            this.z.setVisibility(8);
            if(this.ai == 0) {
                this.C.setVisibility(0);
                this.D.setVisibility(8);
            }
            else {
                this.C.setVisibility(8);
                this.D.setVisibility(0);
            }
        }
        else {
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            if(this.ai == 0) {
                this.y.setVisibility(0);
                this.z.setVisibility(8);
            }
            else {
                this.y.setVisibility(8);
                this.z.setVisibility(0);
            }
        }

        if(this.ai == 0) {
            this.A.setVisibility(0);
            this.B.setVisibility(8);
            return;
        }

        this.A.setVisibility(8);
        this.B.setVisibility(0);
    }

    private void z() {
        double v14;
        int v12;
        StringBuilder v8_6;
        TextView v7_7;
        long v9;
        int v7;
        Resources v6;
        TextView v5;
        AppsSettingCustomEditPhoneActivity v0 = this;
        this.b();
        v0.H = n.a().b(v0, 0x7F070086);  // id:custom_totalTimeLayout
        v0.I = n.a().b(v0, 0x7F070085);  // id:custom_totalDistanceLayout
        v0.L = n.a().e(v0, 0x7F070083);  // id:customTotalTimeTipTextView
        v0.M = n.a().e(v0, 0x7F07007C);  // id:customTotalDistanceTipTextView
        v0.N = n.a().e(v0, 0x7F070084);  // id:customTotalTimeValueTextView
        v0.O = n.a().e(v0, 0x7F07007D);  // id:customTotalDistanceValueTextView
        v0.J = n.a().e(v0, 0x7F07007E);  // id:customTotalSegmentTipTextView
        v0.K = n.a().e(v0, 0x7F07007F);  // id:customTotalSegmentValueTextView
        v0.G = n.a().c(v0, 0x7F07012A);  // id:modeButtonLayout
        v0.k = n.a().a(v0, 0x7F0700C8, v0);  // id:homeButton
        v0.l = n.a().a(v0, 0x7F0700C9, v0);  // id:homeButton2
        v0.m = n.a().a(v0, 0x7F07019F, v0);  // id:saveButton
        v0.p = n.a().a(v0, 0x7F070080);  // id:customTotalSegmentsButton
        v0.n = n.a().a(v0, 0x7F070081);  // id:customTotalTimeButton
        v0.v = n.a().e(v0, 0x7F070082);  // id:customTotalTimeTextView
        v0.o = n.a().a(v0, 0x7F07007B);  // id:customTotalDistanceButton
        v0.t = n.a().e(v0, 0x7F07028A);  // id:timeUnitTextView
        v0.u = n.a().e(v0, 0x7F070096);  // id:distanceUnitTextView
        v0.E = n.a().b(v0, 0x7F070115);  // id:lv_params
        v0.F = n.a().b(v0, 0x7F070113);  // id:lv_meters
        v0.at = n.a().c(v0, 0x7F070176);  // id:noBluetoothLayout
        v0.x = n.a().c(v0, 0x7F0701A0, v0);  // id:saveButtonLayout
        v0.w = n.a().c(v0, 0x7F07026E, v0);  // id:startButtonLayout
        v0.x.setVisibility(0);
        v0.w.setVisibility(8);
        int v1 = AppsRunner.get(this).Y();
        if(v1 == 1) {
            v5 = v0.u;
            v6 = this.getResources();
            v7 = 0x7F0B007A;  // string:STR_KM "km"
        }
        else {
            v5 = v0.u;
            v6 = this.getResources();
            v7 = 0x7F0B0085;  // string:STR_MILES "Miles"
        }

        v5.setText(v6.getString(v7));
        v0.r = n.a().b(v0, 0x7F070297);  // id:totalTimeLayout
        v0.s = n.a().b(v0, 0x7F070296);  // id:totalDistanceLayout
        v0.X = n.a().a(v0, 0x7F07006E, v0);  // id:customSegmentNumberLeftButton
        v0.Y = n.a().a(v0, 0x7F07006F, v0);  // id:customSegmentNumberRightButton
        v0.q = n.a().e(v0, 0x7F070070);  // id:customSegmentNumberTextView
        v0.y = n.a().b(v0, 0x7F070072);  // id:customSpeedMeterViewLayout
        v0.z = n.a().b(v0, 0x7F070073);  // id:customSpeedMeterViewLayout_dis
        v0.C = n.a().b(v0, 0x7F070066);  // id:customResistanceMeterViewLayout
        v0.D = n.a().b(v0, 0x7F070067);  // id:customResistanceMeterViewLayout_dis
        v0.A = n.a().b(v0, 0x7F070063);  // id:customInclineMeterViewLayout
        v0.B = n.a().b(v0, 0x7F070064);  // id:customInclineMeterViewLayout_dis
        v0.V = (AppsMeterView_Phone)n.a().g(v0, 0x7F070221);  // id:setting_custom_time_segment_length
        v0.W = (AppsMeterView_Phone)n.a().g(v0, 0x7F0701BB);  // id:setting_custom_distance_segment_length
        v0.V.setListener(v0);
        v0.W.setListener(v0);
        int v5_1 = AppsRunner.get(this).k(v0);
        int v6_1 = AppsRunner.get(this).l(v0);
        v0.V.a(0x7F0B007B, v5_1, v6_1, 27);  // string:STR_LENGTH_OF_SEGMENT "Length Of Segment"
        v0.W.a(0x7F0B007B, v5_1, v6_1, 28);  // string:STR_LENGTH_OF_SEGMENT "Length Of Segment"
        v0.P = new AppsMeterView_Phone[16];
        v0.Q = new AppsMeterView_Phone[16];
        v0.R = new AppsMeterView_Phone[16];
        v0.S = new AppsMeterView_Phone[16];
        v0.T = new AppsMeterView_Phone[16];
        v0.U = new AppsMeterView_Phone[16];
        int v7_1;
        for(v7_1 = 0; true; ++v7_1) {
            v9 = 0L;
            if(v7_1 >= v0.P.length) {
                break;
            }

            AppsMeterView_Phone v8 = (AppsMeterView_Phone)n.a().g(v0, v0.ab[v7_1]);
            v0.P[v7_1] = v8;
            if(d.a(this)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        float v2 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        float v3 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this, v8, v2, v3);
                    }
                }, v9);
            }
        }

        int v7_2;
        for(v7_2 = 0; v7_2 < v0.Q.length; ++v7_2) {
            AppsMeterView_Phone v8_1 = (AppsMeterView_Phone)n.a().g(v0, v0.ac[v7_2]);
            v0.Q[v7_2] = v8_1;
            if(d.a(this)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        float v2 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        float v3 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this, v8_1, v2, v3);
                    }
                }, v9);
            }
        }

        int v7_3;
        for(v7_3 = 0; v7_3 < v0.R.length; ++v7_3) {
            AppsMeterView_Phone v8_2 = (AppsMeterView_Phone)n.a().g(v0, v0.ad[v7_3]);
            v0.R[v7_3] = v8_2;
            if(d.a(this)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        float v2 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        float v3 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this, v8_2, v2, v3);
                    }
                }, v9);
            }
        }

        int v7_4;
        for(v7_4 = 0; v7_4 < v0.S.length; ++v7_4) {
            AppsMeterView_Phone v8_3 = (AppsMeterView_Phone)n.a().g(v0, v0.ae[v7_4]);
            v0.S[v7_4] = v8_3;
            if(d.a(this)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        float v2 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        float v3 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this, v8_3, v2, v3);
                    }
                }, v9);
            }
        }

        int v7_5;
        for(v7_5 = 0; v7_5 < v0.T.length; ++v7_5) {
            AppsMeterView_Phone v8_4 = (AppsMeterView_Phone)n.a().g(v0, v0.af[v7_5]);
            v0.T[v7_5] = v8_4;
            if(d.a(this)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        float v2 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        float v3 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this, v8_4, v2, v3);
                    }
                }, v9);
            }
        }

        int v7_6;
        for(v7_6 = 0; v7_6 < v0.U.length; ++v7_6) {
            AppsMeterView_Phone v8_5 = (AppsMeterView_Phone)n.a().g(v0, v0.ag[v7_6]);
            v0.U[v7_6] = v8_5;
            if(d.a(this)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        float v2 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        float v3 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                        AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this, v8_5, v2, v3);
                    }
                }, v9);
            }
        }

        v0.ah = v6_1;
        v0.a(v6_1);
        v0.Z = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        v0.aa = new String[]{"0.0", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0", "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.0", "8.5", "9.0", "9.5", "10.0"};
        if(v0.ai == 0) {
            this.u();
        }
        else {
            this.v();
        }

        int v6_2 = AppsRunner.get(this).getPref_CurrentUserID(v0);
        v0.am = 1;
        v0.an = 1;
        v0.am = (int)(((Integer)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_maxSegment", Integer.valueOf(1), 1)));
        v0.an = (int)(((Integer)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_maxSegmentDis", Integer.valueOf(1), 1)));
        if(v0.am <= 0) {
            v0.am = 1;
        }

        if(v0.an <= 0) {
            v0.an = 1;
        }

        if(v0.ai == 0) {
            v0.p.setText(v0.am + "");
            v7_7 = v0.K;
            v8_6 = new StringBuilder();
            v12 = v0.am;
        }
        else {
            v0.p.setText(v0.an + "");
            v7_7 = v0.K;
            v8_6 = new StringBuilder();
            v12 = v0.an;
        }

        v8_6.append(v12);
        v8_6.append("");
        v7_7.setText(v8_6.toString());
        j.a("_maxSegment_2", v0.am + " |");
        j.a("_maxSegmentDis_2", v0.an + " |");
        j.a("customTotalSegmentsButton_2", v0.p.getText() + " |");
        int v7_8;
        for(v7_8 = 0; true; v7_8 = v9_1) {
            v14 = 12.0;
            if(v7_8 >= v0.am) {
                break;
            }

            int v9_1 = v7_8 + 1;
            double v2 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_speed_" + v9_1, Float.valueOf(0.5f), 3)))));
            if(v1 == 0 && v2 > v14) {
                v2 = v14;
            }

            if(v1 == 1) {
                v2 = Conversions.b(v2);
            }

            double v14_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_incline_" + v9_1, Float.valueOf(0.0f), 3)))));
            double v4 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_resistance_" + v9_1, Float.valueOf(1.0f), 3)))));
            double v11 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_incline_dis_" + v9_1, Float.valueOf(0.0f), 3)))));
            v0.aj[v7_8] = (float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_segmentLength_" + v9_1, Float.valueOf(1.0f), 3)));
            AppsMeterView_Phone v8_7 = v0.P[v7_8];
            AppsMeterView_Phone v10 = v0.R[v7_8];
            AppsMeterView_Phone v13 = v0.Q[v7_8];
            AppsMeterView_Phone v7_9 = v0.U[v7_8];
            v8_7.setCurrentValue(((float)v2));
            v10.setCurrentValue(((float)v14_1));
            v13.setCurrentValue(((float)v4));
            v7_9.setCurrentValue(((float)v11));
        }

        int v2_1 = 0;
        while(v2_1 < v0.an) {
            int v4_1 = v2_1 + 1;
            double v7_10 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_speed_dis_" + v4_1, Float.valueOf(0.5f), 3)))));
            if(v1 == 0 && v7_10 > v14) {
                v7_10 = v14;
            }

            if(v1 == 1) {
                v7_10 = Conversions.b(v7_10);
            }

            double v11_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_incline_dis_" + v4_1, Float.valueOf(0.0f), 3)))));
            double v13_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_resistance_dis_" + v4_1, Float.valueOf(1.0f), 3)))));
            v0.ak[v2_1] = (float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v6_2 + "_segmentLengthDis_" + v4_1, Float.valueOf(0.1f), 3)));
            AppsMeterView_Phone v3 = v0.S[v2_1];
            AppsMeterView_Phone v9_2 = v0.U[v2_1];
            AppsMeterView_Phone v2_2 = v0.T[v2_1];
            v3.setCurrentValue(((float)v7_10));
            v9_2.setCurrentValue(((float)v11_1));
            v2_2.setCurrentValue(((float)v13_1));
            v2_1 = v4_1;
            v14 = 12.0;
        }

        this.m();
        this.l();
        v0.E.setVisibility(0);
        v0.F.setVisibility(8);
        if(d.a(this)) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AppsMeterView_Phone v1 = AppsSettingCustomEditPhoneActivity.b(AppsSettingCustomEditPhoneActivity.this);
                    float v2 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                    float v3 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                    AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this, v1, v2, v3);
                }
            }, 0L);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AppsMeterView_Phone v1 = AppsSettingCustomEditPhoneActivity.c(AppsSettingCustomEditPhoneActivity.this);
                    float v2 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                    float v3 = AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this);
                    AppsSettingCustomEditPhoneActivity.a(AppsSettingCustomEditPhoneActivity.this, v1, v2, v3);
                }
            }, 0L);
        }
    }
}
