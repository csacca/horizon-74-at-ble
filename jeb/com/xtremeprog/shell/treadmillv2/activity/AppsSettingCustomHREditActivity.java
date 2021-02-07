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
import com.xtremeprog.shell.treadmillv2.views.AppsMeterView.a;
import com.xtremeprog.shell.treadmillv2.views.AppsMeterView;
import java.util.Date;

public class AppsSettingCustomHREditActivity extends AppsRootActivity implements View.OnTouchListener {
    private Button A;
    private String[] B;
    private String[] C;
    private int D;
    private float[] E;
    private boolean F;
    private boolean G;
    private int H;
    private BroadcastReceiver I;
    private int J;
    private int K;
    private RelativeLayout L;
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
    private AppsMeterView s;
    private AppsMeterView[] t;
    private int[] u;
    private Button v;
    private Button w;
    private Button x;
    private Button y;
    private Button z;

    public AppsSettingCustomHREditActivity() {
        this.t = new AppsMeterView[4];
        this.u = new int[]{0x7F0701BC, 0x7F0701BD, 0x7F0701BE, 0x7F0701BF};  // id:setting_custom_hr_heart_rate_bpm_view1
        this.B = new String[4];
        this.C = new String[21];
        this.E = new float[]{0.5f, 0.5f, 0.5f, 0.5f};
        this.F = false;
        this.G = false;
        this.H = 0;
        this.I = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg2, Intent arg3) {
                String v2 = arg3.getAction();
                if(v2.equals("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS")) {
                    int v2_1 = AppsRunner.get(AppsSettingCustomHREditActivity.this.getApplicationContext()).l(AppsSettingCustomHREditActivity.this.getApplicationContext());
                    if(AppsSettingCustomHREditActivity.c(AppsSettingCustomHREditActivity.this) != v2_1) {
                        AppsSettingCustomHREditActivity.this.a(v2_1);
                        return;
                    }
                }
                else {
                    if(v2.equals("NOTIFICATION_DID_SET_CUSTOM_HR")) {
                        AppsSettingCustomHREditActivity.this.l();
                        AppsSettingCustomHREditActivity.this.z();
                        return;
                    }

                    if(v2.equals("NOTIFICATION_DIDCONNECT")) {
                        AppsSettingCustomHREditActivity.d(AppsSettingCustomHREditActivity.this);
                        return;
                    }

                    if(v2.equals("NOTIFICATION_DISCONNECT")) {
                        if(AppsSettingCustomHREditActivity.d(AppsSettingCustomHREditActivity.this)) {
                            AppsSettingCustomHREditActivity.this.b(true);
                            return;
                        }
                    }
                    else if(v2.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                        if(AppsSettingCustomHREditActivity.d(AppsSettingCustomHREditActivity.this)) {
                            AppsSettingCustomHREditActivity.this.b(false);
                            AppsSettingCustomHREditActivity.this.j.removeMessages(0x6F);
                            Intent v2_2 = AppsSettingCustomHREditActivity.this.getIntent();
                            v2_2.putExtra("isBack", "1");
                            AppsSettingCustomHREditActivity.this.setResult(-1, v2_2);
                            AppsSettingCustomHREditActivity.this.finish();
                            return;
                        }
                    }
                    else if(v2.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                        AppsSettingCustomHREditActivity.this.j.removeMessages(0x6F);
                    }
                }
            }
        };
        this.J = 0;
        this.K = 0;
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x2B67) {
                    AppsSettingCustomHREditActivity.this.m();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsSettingCustomHREditActivity.this.n();
                    return;
                }

                if(arg3.what == 0x8235) {
                    AppsSettingCustomHREditActivity.this.q();
                    return;
                }

                if(arg3.what == 0xAD9C) {
                    AppsSettingCustomHREditActivity.this.r();
                    return;
                }

                if(arg3.what == 0xD903) {
                    AppsSettingCustomHREditActivity.this.u();
                    return;
                }

                if(arg3.what == 0x1046A) {
                    AppsSettingCustomHREditActivity.this.v();
                }
            }
        };
        this.j = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    Intent v4 = new Intent(AppsSettingCustomHREditActivity.this, AppsDeviceListActivity.class);
                    AppsSettingCustomHREditActivity.this.startActivity(v4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsSettingCustomHREditActivity.this.b(false);
                        }
                    }, 500L);
                }
            }
        };
    }

    public void A() {
        AppsSettingCustomHREditActivity v0 = this;
        if(v0.G) {
            return;
        }

        v0.G = true;
        int v3 = AppsRunner.get(this).getPref_CurrentUserID(v0);
        int v4 = (int)(v0.s.a.j * 60.0);
        int v14 = (int)d.a(v0.p.getText().toString());
        int v6 = (int)v0.t[0].a.j;
        int v9 = (int)v0.t[1].a.j;
        int v12 = (int)v0.t[2].a.j;
        int v2 = (int)v0.t[3].a.j;
        float[] v8 = v0.E;
        int v10 = (int)(v8[0] * 60.0f);
        int v1 = (int)(v8[1] * 60.0f);
        int v13 = (int)(v8[2] * 60.0f);
        int v11 = (int)(v8[3] * 60.0f);
        j.a("===setCustomProgram===", v3 + " | " + v4 + " | " + v14 + " | " + v6 + " | " + v9 + " | " + v12 + " | " + v2 + " | " + v10 + " | " + v1 + " | " + v13 + " | " + v11);
        if(v4 < v10 + v1 + v13 + v11 + 480) {
            v0.G = false;
            v0.a(this.getResources().getString(0x7F0B00E3));  // string:STR_TOTAL_TIME_IS_LESS_THAN_PROGRAM_SEGMENTS "TOTAL TIME IS LESS THAN PROGRAM SEGMENTS"
            return;
        }

        BLEManager.get(this).maybe_send_message2(DeviceCommand.setCustomHRProgramMsg(Factory.a(v3, v4, v14, v6, v10, v14, v9, v1, v14, v12, v13, v14, v2, v11)), 2, 4000);
        new Handler().postDelayed(() -> {
            AppsSettingCustomHREditActivity.this.G = false;
            return false;
        }, 1000L);

        class com.xtremeprog.shell.treadmillv2.activity.AppsSettingCustomHREditActivity.5 implements Runnable {
            @Override
            public void run() {
                AppsSettingCustomHREditActivity.a(AppsSettingCustomHREditActivity.this, false);
            }
        }

    }

    private void B() {
        this.b();
        this.k = n.a().a(this, 0x7F0700C8, this);  // id:homeButton
        this.l = n.a().a(this, 0x7F0700C9, this);  // id:homeButton2
        this.m = n.a().a(this, 0x7F07019F, this);  // id:saveButton
        this.n = n.a().a(this, 0x7F070062);  // id:customHRTotalTimeButton
        this.o = n.a().a(this, 0x7F070054);  // id:customHRMaxHeartRateButton
        this.v = n.a().a(this, 0x7F070052, this);  // id:customHRAgeLeftButton
        this.w = n.a().a(this, 0x7F070053, this);  // id:customHRAgeRightButton
        this.x = n.a().a(this, 0x7F07005B, this);  // id:customHRSegmentNumberLeftButton
        this.y = n.a().a(this, 0x7F07005C, this);  // id:customHRSegmentNumberRightButton
        this.z = n.a().a(this, 0x7F070058, this);  // id:customHRSegmentLengthLeftButton
        this.A = n.a().a(this, 0x7F070059, this);  // id:customHRSegmentLengthRightButton
        this.p = n.a().e(this, 0x7F070013);  // id:ageTextView
        this.r = n.a().e(this, 0x7F07005A);  // id:customHRSegmentLengthTextView
        this.q = n.a().e(this, 0x7F07005D);  // id:customHRSegmentNumberTextView
        this.L = n.a().c(this, 0x7F070176);  // id:noBluetoothLayout
        this.s = (AppsMeterView)n.a().g(this, 0x7F0701C0);  // id:setting_custom_hr_total_time_view
        int v1;
        for(v1 = 0; v1 < this.u.length; ++v1) {
            AppsMeterView[] v2 = this.t;
            v2[v1] = (AppsMeterView)n.a().g(this, this.u[v1]);
        }

        AppsRunner.get(this).getPref_CurrentUserID(this);
        int v1_1 = AppsRunner.get(this).ad();
        this.H = v1_1;
        this.p.setText(v1_1 + "");
        int v1_2 = AppsRunner.get(this).l(this);
        this.D = v1_2;
        this.a(v1_2);
        this.B = new String[]{"1", "2", "3", "4"};
        this.C = new String[]{"0.0", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0", "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.0", "8.5", "9.0", "9.5", "10.0"};
        this.C();
        this.y();
        this.c(true);
    }

    private void C() {
        int v1;
        for(v1 = 0; v1 < this.u.length; ++v1) {
            if(v1 == this.J) {
                this.t[v1].setVisibility(0);
            }
            else {
                this.t[v1].setVisibility(8);
            }
        }
    }

    private void D() {
        int v0;
        for(v0 = 0; v0 < this.u.length; ++v0) {
            this.t[v0].setListener(new a() {
                @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterView$a
                public void a(AppsMeterView arg3, double arg4) {
                    int v3 = 220 - ((int)d.a(AppsSettingCustomHREditActivity.a(AppsSettingCustomHREditActivity.this).getText().toString(), 30));
                    AppsSettingCustomHREditActivity.b(AppsSettingCustomHREditActivity.this).setText(d.doubleToStr(v3, 0));
                }
            });
        }

        this.s.setListener((/* MISSING LAMBDA PARAMETER */, /* MISSING LAMBDA PARAMETER */) -> {
            int v0 = (int)(((float)(((int)AppsSettingCustomHREditActivity.this.s.a.j))) * 60.0f);
            String v0_1 = d.d(v0) <= 0 ? d.c(v0 + "") : d.d(v0 + "") + ":00";
            AppsSettingCustomHREditActivity.this.n.setText(v0_1);
        });

        class com.xtremeprog.shell.treadmillv2.activity.AppsSettingCustomHREditActivity.2 implements a {
            @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterView$a
            public void a(AppsMeterView arg1, double arg2) {
                AppsSettingCustomHREditActivity.this.y();
            }
        }

    }

    static TextView a(AppsSettingCustomHREditActivity arg0) {
        return arg0.p;
    }

    public void a(int arg6) {
        int v0 = AppsRunner.get(this).k(this);
        this.s.a(0x7F0B00E4, v0, arg6, 20);  // string:STR_TOTAL_TIME_MIN "Total Time\n(Min)"
        int v1 = ((int)(((Integer)ContextSharedPreferences.SharedPreferences(this, AppsRunner.get(this).getPref_CurrentUserID(this) + "_time_hr", Integer.valueOf(600), 1)))) / 60;
        this.s.setCurrentValue(((float)v1));
        int v1_1;
        for(v1_1 = 0; v1_1 < this.u.length; ++v1_1) {
            this.t[v1_1].a(0x7F0B006C, v0, arg6, 21);  // string:STR_HEART_RATE_BPM "Heart\nRate\nBpm"
        }
    }

    public void a(boolean arg2) {
        if(!arg2) {
            goto label_38;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS");
            this.registerReceiver(this.I, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DID_SET_CUSTOM_HR");
            this.registerReceiver(this.I, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.I, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.I, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.I, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.I, v2_6);
            return;
        label_38:
            this.unregisterReceiver(this.I);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static Button b(AppsSettingCustomHREditActivity arg0) {
        return arg0.o;
    }

    public void b(boolean arg4) {
        j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)arg4))));
        if(arg4) {
            this.L.setVisibility(0);
            this.j.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.j.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.L.setVisibility(8);
        this.j.removeMessages(0x6F);
    }

    static int c(AppsSettingCustomHREditActivity arg0) {
        return arg0.D;
    }

    private void c(boolean arg12) {
        int v6;
        int v0 = 220 - ((int)d.a(this.p.getText().toString(), 30));
        float v1 = (float)v0;
        int v2 = (int)(0.9f * v1);
        int v1_1 = (int)(v1 * 0.75f);
        j.a("==resetHeartRateBPM==", v1_1 + " |");
        int v3 = AppsRunner.get(this).getPref_CurrentUserID(this);
        int v5;
        for(v5 = 0; v5 < this.u.length; ++v5) {
            if(arg12) {
                int v7 = v5 + 1;
                v6 = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v3 + "_hr_hr_" + v7, Float.valueOf(((float)v1_1) * 1.0f), 3)))));
                this.E[v5] = (float)(((Float)ContextSharedPreferences.SharedPreferences(this, v3 + "_segmentLength_hr_" + v7, Float.valueOf(0.5f), 3)));
            }
            else {
                v6 = v1_1;
            }

            this.t[v5].a.i = 2.470000E-322;
            this.t[v5].a.d = v0;
            this.t[v5].a.e = v2;
            this.t[v5].a.h = (double)v6;
            this.t[v5].a.g = 1.0;
            this.t[v5].a.a(false);
        }

        this.o.setText(d.doubleToStr(v0, 0));
        this.r.setText(d.doubleToStr(this.E[this.J], 1));
    }

    static boolean d(AppsSettingCustomHREditActivity arg0) {
        return arg0.F;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        n.a().e(this, 0x7F0701A1).setText(this.getResources().getString(0x7F0B00B8));  // id:saveTextView
        n.a().e(this, 0x7F07028D).setText(this.getResources().getString(0x7F0B0090));  // id:titleTextView
        n.a().e(this, 0x7F0702BF).setText(this.getResources().getString(0x7F0B0026));  // id:tv_step1
        n.a().e(this, 0x7F0702C0).setText(this.getResources().getString(0x7F0B0027));  // id:tv_step2
        n.a().e(this, 0x7F0702C1).setText(this.getResources().getString(0x7F0B0028));  // id:tv_step3
        n.a().e(this, 0x7F0702C2).setText(this.getResources().getString(0x7F0B0029));  // id:tv_step4
        n.a().e(this, 0x7F0702C3).setText(this.getResources().getString(0x7F0B002A));  // id:tv_step5
        n.a().e(this, 0x7F0702B5).setText(this.getResources().getString(0x7F0B0086));  // id:tv_minutes
        this.s.a();
        int v0;
        for(v0 = 0; v0 < this.u.length; ++v0) {
            this.t[v0].a();
        }
    }

    public void l() {
        int v0 = AppsRunner.get(this).ad();
        int v0_1 = (int)d.a(this.p.getText().toString(), v0);
        int v1 = this.H - v0_1;
        j.a("==年龄改变了吗==", v1 + " = " + this.H + " - " + v0_1);
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
        ++this.J;
        String[] v2 = this.B;
        if(this.J > v2.length - 1) {
            this.J = v2.length - 1;
        }

        this.q.setText(this.B[this.J]);
        this.r.setText(d.doubleToStr(this.E[this.J], 1));
        this.C();
        this.i.removeMessages(0x2B67);
        Message v0 = new Message();
        v0.what = 0x2B67;
        this.i.sendMessageDelayed(v0, 0xFAL);
    }

    public void n() {
        --this.J;
        if(this.J < 0) {
            this.J = 0;
        }

        this.q.setText(this.B[this.J]);
        this.r.setText(d.doubleToStr(this.E[this.J], 1));
        this.C();
        this.i.removeMessages(0x56CE);
        Message v0 = new Message();
        v0.what = 0x56CE;
        this.i.sendMessageDelayed(v0, 0xFAL);
    }

    public void o() {
        this.i.removeMessages(0x2B67);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        this.j.removeMessages(0x6F);
        super.onBackPressed();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg3) {
        AppsRunner.get(this).b(this);
        super.onCreate(arg3);
        this.getWindow().setFlags(0x80, 0x80);
        this.a(0x7F090045, 0x7F090046, 0x7F090047);  // layout:activity_setting_custom_hr_edit
        this.B();
        this.D();
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
        this.F = true;
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
        this.F = false;
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
                this.A();
            }
        }

        if(arg6.getAction() == 0) {
            if(arg5 == this.x) {
                this.n();
                return true;
            }

            if(arg5 == this.y) {
                this.m();
                return true;
            }

            if(arg5 == this.z) {
                this.r();
                return true;
            }

            if(arg5 == this.A) {
                this.q();
                return true;
            }

            if(arg5 == this.v) {
                this.v();
                return true;
            }

            if(arg5 == this.w) {
                this.u();
                return true;
            }
        }
        else if(arg6.getAction() == 1 || arg6.getAction() == 3) {
            if(arg5 == this.x) {
                this.p();
                return true;
            }

            if(arg5 == this.y) {
                this.o();
                return true;
            }

            if(arg5 == this.z) {
                this.t();
                return true;
            }

            if(arg5 == this.A) {
                this.s();
                return true;
            }

            if(arg5 == this.v) {
                this.x();
                return true;
            }

            if(arg5 == this.w) {
                this.w();
            }
        }

        return true;
    }

    public void p() {
        this.i.removeMessages(0x56CE);
    }

    public void q() {
        ++this.K;
        if(this.K > 3) {
            this.K = 0;
        }

        this.r.setText(this.C[this.K]);
        float v0 = this.E[this.J] + 0.5f;
        if(v0 > 10.0f) {
            v0 = 10.0f;
        }

        if(v0 < 0.5f) {
            v0 = 0.5f;
        }

        this.E[this.J] = v0;
        this.r.setText(d.doubleToStr(v0, 1));
        this.i.removeMessages(0x8235);
        Message v0_1 = new Message();
        v0_1.what = 0x8235;
        this.i.sendMessageDelayed(v0_1, 0xFAL);
    }

    public void r() {
        --this.K;
        if(this.K < 0) {
            this.K = 0;
        }

        this.r.setText(this.C[this.K]);
        float v0 = this.E[this.J] - 0.5f;
        if(v0 > 10.0f) {
            v0 = 10.0f;
        }

        if(v0 < 0.5f) {
            v0 = 0.5f;
        }

        this.E[this.J] = v0;
        this.r.setText(d.doubleToStr(v0, 1));
        this.i.removeMessages(0xAD9C);
        Message v0_1 = new Message();
        v0_1.what = 0xAD9C;
        this.i.sendMessageDelayed(v0_1, 0xFAL);
    }

    public void s() {
        this.i.removeMessages(0x8235);
    }

    public void t() {
        this.i.removeMessages(0xAD9C);
    }

    public void u() {
        int v0 = ((int)d.a(this.p.getText().toString(), 30)) + 1;
        if(v0 > 99) {
            v0 = 99;
        }

        this.p.setText(v0 + "");
        this.c(false);
        this.i.removeMessages(0xD903);
        Message v0_1 = new Message();
        v0_1.what = 0xD903;
        this.i.sendMessageDelayed(v0_1, 0xFAL);
    }

    public void v() {
        int v0 = ((int)d.a(this.p.getText().toString(), 30)) - 1;
        if(v0 < 13) {
            v0 = 13;
        }

        this.p.setText(v0 + "");
        this.c(false);
        this.i.removeMessages(0x1046A);
        Message v0_1 = new Message();
        v0_1.what = 0x1046A;
        this.i.sendMessageDelayed(v0_1, 0xFAL);
    }

    public void w() {
        this.i.removeMessages(0xD903);
    }

    public void x() {
        this.i.removeMessages(0x1046A);
    }

    // Detected as a lambda impl.
    public void y() {
        int v0 = (int)(((float)(((int)this.s.a.j))) * 60.0f);
        String v0_1 = d.d(v0) <= 0 ? d.c(v0 + "") : d.d(v0 + "") + ":00";
        this.n.setText(v0_1);
    }

    public void z() {
        Intent v0 = this.getIntent();
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < this.u.length; v2 = v4) {
            int v4 = v2 + 1;
            v0.putExtra("heartRateBPM" + v4, this.t[v2].a.j);
        }

        while(v1 < this.E.length) {
            int v3 = v1 + 1;
            v0.putExtra("segmentLength" + v3, this.E[v1]);
            v1 = v3;
        }

        v0.putExtra("maxHeartRate", this.o.getText().toString());
        v0.putExtra("segment", "4");
        v0.putExtra("age", this.p.getText().toString());
        v0.putExtra("time", ((int)(this.s.a.j * 60.0)));
        this.setResult(-1, v0);
        this.finish();
    }
}
