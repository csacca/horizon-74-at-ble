package com.xtremeprog.shell.treadmillv2.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import apps.activity.base.AppsRootActivity;
import apps.c.ContextSharedPreferences;
import apps.c.d;
import apps.c.f;
import apps.c.j;
import apps.c.n;
import apps.database.entity.UserArticle;
import apps.views.d.a;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppsUserActivity extends AppsRootActivity implements View.OnTouchListener {
    private Button A;
    private Button B;
    private Button C;
    private Button D;
    private Button E;
    private RelativeLayout F;
    private Button G;
    private List H;
    private List I;
    private List J;
    private int K;
    private boolean L;
    private BroadcastReceiver M;
    private Date N;
    private int O;
    final Handler i;
    final Handler j;
    private Button k;
    private Button l;
    private Button m;
    private Button n;
    private Button o;
    private Button p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public AppsUserActivity() {
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.K = 0;
        this.L = false;
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    Intent v4 = new Intent(AppsUserActivity.this, AppsDeviceListActivity.class);
                    AppsUserActivity.this.startActivity(v4);
                    AppsUserActivity.this.finish();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsUserActivity.this.a(false);
                        }
                    }, 500L);
                }
            }
        };
        this.M = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg3, Intent arg4) {
                String v3 = arg4.getAction();
                if(!v3.equals("NOTIFICATION_DIDCONNECT")) {
                    if(!v3.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                        if(v3.equals("NOTIFICATION_DISCONNECT")) {
                            AppsUserActivity.a(AppsUserActivity.this);
                            return;
                        }

                        if(!v3.equals("NOTIFICATION_DID_GET_USER")) {
                            if((v3.equals("NOTIFICATION_DID_START_WORKOUT")) || (v3.equals("NOTIFICATION_HISTORY_HOME"))) {
                                AppsUserActivity.this.finish();
                                return;
                            }

                            if(v3.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                                AppsUserActivity.this.i.removeMessages(0x6F);
                                return;
                            }

                            if(!v3.equals("NOTIFICATION_DID_SET_USER_DATA")) {
                                if(v3.equals("NOTIFICATION_CANCEL_SELECT_USER_LOADING")) {
                                    if(AppsUserActivity.a(AppsUserActivity.this)) {
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                AppsUserActivity.this.g();
                                            }
                                        }, 0xFAL);
                                        return;
                                    }
                                }
                                else if((v3.equals("NOTIFICATION_SHOW_SELECT_USER_LOADING_WHEN_RESEND")) && (AppsUserActivity.a(AppsUserActivity.this))) {
                                    AppsUserActivity.this.a(AppsUserActivity.this, "", false);
                                    return;
                                    AppsUserActivity.this.finish();
                                    return;
                                }
                            }
                        }
                    }
                    else if(AppsUserActivity.a(AppsUserActivity.this)) {
                        AppsUserActivity.this.a(false);
                        AppsUserActivity.this.i.removeMessages(0x6F);
                        AppsUserActivity.this.onBackPressed();
                        return;
                    }
                }
            }
        };
        this.j = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg1) {
                AppsRunner.get(AppsUserActivity.this.getApplicationContext()).clear();
                AppsUserActivity.this.f();
            }
        };
        this.N = null;
        this.O = 0;
    }

    private int a(int arg2, boolean arg3) {
        if(arg2 == 1) {
            return arg3 ? 0x7F06015D : 0x7F06015C;  // drawable:pad_user_ic_female_nor_91
        }

        return arg3 ? 0x7F060160 : 0x7F06015F;  // drawable:pad_user_ic_male_sel
    }

    private void a(int arg7) {
        TextView v7_1;
        TextView v7;
        UserArticle v0 = (UserArticle)this.H.get(arg7);
        int v1 = this.a(v0.getGender(), false);
        String v2 = v0.getNickname();
        v0.getModifyflag();
        if((d.a(v2, "USER 1")) || (d.a(v2, "User 1"))) {
            v2 = "USER1";
        }
        else if((d.a(v2, "USER 2")) || (d.a(v2, "User 2"))) {
            v2 = "USER2";
        }
        else if((d.a(v2, "USER 3")) || (d.a(v2, "User 3"))) {
            v2 = "USER3";
        }
        else if((d.a(v2, "USER 4")) || (d.a(v2, "User 4"))) {
            v2 = "USER4";
        }
        else if((d.a(v2, "USER 5")) || (d.a(v2, "User 5"))) {
            v2 = "USER5";
        }
        else if((d.a(v2, "USER 6")) || (d.a(v2, "User 6"))) {
            v2 = "USER6";
        }
        else if(d.a(v2, "Usuario 1")) {
            v2 = "Usuario1";
        }
        else if(d.a(v2, "Usuario 2")) {
            v2 = "Usuario2";
        }
        else if(d.a(v2, "Usuario 3")) {
            v2 = "Usuario3";
        }
        else if(d.a(v2, "Usuario 4")) {
            v2 = "Usuario4";
        }
        else if(d.a(v2, "Usuario 5")) {
            v2 = "Usuario5";
        }
        else if(d.a(v2, "Usuario 6")) {
            v2 = "Usuario6";
        }
        else if(d.a(v2, "Utilisateur 1")) {
            v2 = "Utilisateur1";
        }
        else if(d.a(v2, "Utilisateur 2")) {
            v2 = "Utilisateur2";
        }
        else if(d.a(v2, "Utilisateur 3")) {
            v2 = "Utilisateur3";
        }
        else if(d.a(v2, "Utilisateur 4")) {
            v2 = "Utilisateur4";
        }
        else if(d.a(v2, "Utilisateur 5")) {
            v2 = "Utilisateur5";
        }
        else if(d.a(v2, "Utilisateur 6")) {
            v2 = "Utilisateur6";
        }

        int v0_1 = d.a(this.getApplicationContext(), "string", v2);
        if(arg7 == 0) {
            this.k.setBackgroundResource(v1);
            this.k.setEnabled(true);
            this.q.setTextColor(this.getResources().getColor(0x7F040015));  // color:blue
            if(v0_1 != 0) {
                v7 = this.q;
                v7.setText(v0_1);
                return;
            }

            v7_1 = this.q;
            v7_1.setText(v2);
            return;
        }

        if(arg7 == 1) {
            this.l.setBackgroundResource(v1);
            this.l.setEnabled(true);
            this.r.setTextColor(this.getResources().getColor(0x7F040015));  // color:blue
            if(v0_1 != 0) {
                v7 = this.r;
                v7.setText(v0_1);
                return;
            }

            v7_1 = this.r;
            v7_1.setText(v2);
            return;
        }

        if(arg7 == 2) {
            this.m.setBackgroundResource(v1);
            this.m.setEnabled(true);
            this.s.setTextColor(this.getResources().getColor(0x7F040015));  // color:blue
            if(v0_1 != 0) {
                v7 = this.s;
                v7.setText(v0_1);
                return;
            }

            v7_1 = this.s;
            v7_1.setText(v2);
            return;
        }

        if(arg7 == 3) {
            this.n.setBackgroundResource(v1);
            this.n.setEnabled(true);
            this.t.setTextColor(this.getResources().getColor(0x7F040015));  // color:blue
            if(v0_1 != 0) {
                v7 = this.t;
                v7.setText(v0_1);
                return;
            }

            v7_1 = this.t;
            v7_1.setText(v2);
            return;
        }

        if(arg7 == 4) {
            this.o.setBackgroundResource(v1);
            this.o.setEnabled(true);
            this.u.setTextColor(this.getResources().getColor(0x7F040015));  // color:blue
            if(v0_1 != 0) {
                v7 = this.u;
                v7.setText(v0_1);
                return;
            }

            v7_1 = this.u;
            v7_1.setText(v2);
            return;
        }

        if(arg7 == 5) {
            this.p.setBackgroundResource(v1);
            this.p.setEnabled(true);
            this.v.setTextColor(this.getResources().getColor(0x7F040015));  // color:blue
            if(v0_1 != 0) {
                v7 = this.v;
                v7.setText(v0_1);
                return;
            }

            v7_1 = this.v;
            v7_1.setText(v2);
            return;
        }
    }

    static boolean a(AppsUserActivity arg0) {
        return arg0.L;
    }

    public void a(boolean arg4) {
        if(arg4) {
            this.F.setVisibility(0);
            this.i.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.i.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.F.setVisibility(8);
        this.i.removeMessages(0x6F);
    }

    static Date b(AppsUserActivity arg0) {
        return arg0.N;
    }

    private void b(int arg13) {
        int v3_1;
        TextView v2_1;
        int v1;
        for(v1 = 0; v1 < this.H.size(); ++v1) {
            Button v2 = (Button)this.I.get(v1);
            TextView v3 = (TextView)this.J.get(v1);
            UserArticle v4 = (UserArticle)this.H.get(v1);
            String v5 = v4.getNickname();
            String v6 = v4.getBirthday();
            String v7 = v4.getWeight();
            int v8 = v4.getGender();
            v4.getModifyflag();
            Date v9 = f.stringToDate(v6, "yyyy/MM/dd");
            if(v9 == null) {
                v9 = f.stringToDate("2000-01-01", "yyyy-MM-dd");
            }

            int v9_1 = d.a(v9);
            j.a("==selectUserByIndex==", v6 + " | " + v4.getId());
            if((d.a(v5, "USER 1")) || (d.a(v5, "User 1"))) {
                v5 = "USER1";
            }
            else if((d.a(v5, "USER 2")) || (d.a(v5, "User 2"))) {
                v5 = "USER2";
            }
            else if((d.a(v5, "USER 3")) || (d.a(v5, "User 3"))) {
                v5 = "USER3";
            }
            else if((d.a(v5, "USER 4")) || (d.a(v5, "User 4"))) {
                v5 = "USER4";
            }
            else if((d.a(v5, "USER 5")) || (d.a(v5, "User 5"))) {
                v5 = "USER5";
            }
            else if((d.a(v5, "USER 6")) || (d.a(v5, "User 6"))) {
                v5 = "USER6";
            }
            else if(d.a(v5, "Usuario 1")) {
                v5 = "Usuario1";
            }
            else if(d.a(v5, "Usuario 2")) {
                v5 = "Usuario2";
            }
            else if(d.a(v5, "Usuario 3")) {
                v5 = "Usuario3";
            }
            else if(d.a(v5, "Usuario 4")) {
                v5 = "Usuario4";
            }
            else if(d.a(v5, "Usuario 5")) {
                v5 = "Usuario5";
            }
            else if(d.a(v5, "Usuario 6")) {
                v5 = "Usuario6";
            }
            else if(d.a(v5, "Utilisateur 1")) {
                v5 = "Utilisateur1";
            }
            else if(d.a(v5, "Utilisateur 2")) {
                v5 = "Utilisateur2";
            }
            else if(d.a(v5, "Utilisateur 3")) {
                v5 = "Utilisateur3";
            }
            else if(d.a(v5, "Utilisateur 4")) {
                v5 = "Utilisateur4";
            }
            else if(d.a(v5, "Utilisateur 5")) {
                v5 = "Utilisateur5";
            }
            else if(d.a(v5, "Utilisateur 6")) {
                v5 = "Utilisateur6";
            }

            int v6_1 = d.a(this.getApplicationContext(), "string", v5);
            if(arg13 == v1) {
                v2.setBackgroundResource(this.a(v4.getGender(), true));
                v2.setEnabled(false);
                v3.setTextColor(this.getResources().getColor(0x7F04006F));  // color:white
                if(v6_1 == 0) {
                    this.w.setText(v5);
                }
                else {
                    this.w.setText(v6_1);
                }

                this.z.setText(v7);
                this.x.setText(v9_1 + "");
                if(v8 == 1) {
                    v2_1 = this.y;
                    v3_1 = 0x7F0B005E;  // string:STR_FEMALE "Female"
                }
                else {
                    v2_1 = this.y;
                    v3_1 = 0x7F0B007E;  // string:STR_MALE "Male"
                }

                v2_1.setText(v3_1);
            }
            else {
                v2.setBackgroundResource(this.a(v4.getGender(), false));
                v2.setEnabled(true);
                v3.setTextColor(this.getResources().getColor(0x7F040015));  // color:blue
            }
        }
    }

    public void b(boolean arg2) {
        if(!arg2) {
            goto label_62;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.M, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.M, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_DID_GET_USER");
            this.registerReceiver(this.M, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_DID_START_WORKOUT");
            this.registerReceiver(this.M, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.M, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_HISTORY_HOME");
            this.registerReceiver(this.M, v2_6);
            IntentFilter v2_7 = new IntentFilter();
            v2_7.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.M, v2_7);
            IntentFilter v2_8 = new IntentFilter();
            v2_8.addAction("NOTIFICATION_DID_SET_USER_DATA");
            this.registerReceiver(this.M, v2_8);
            IntentFilter v2_9 = new IntentFilter();
            v2_9.addAction("NOTIFICATION_CANCEL_SELECT_USER_LOADING");
            this.registerReceiver(this.M, v2_9);
            IntentFilter v2_10 = new IntentFilter();
            v2_10.addAction("NOTIFICATION_SHOW_SELECT_USER_LOADING_WHEN_RESEND");
            this.registerReceiver(this.M, v2_10);
            return;
        label_62:
            this.unregisterReceiver(this.M);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        n.a().e(this, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(this, 0x7F070275).setText(this.getResources().getString(0x7F0B00C5));  // id:startTextView
        n.a().e(this, 0x7F07009E).setText(this.getResources().getString(0x7F0B0048));  // id:editTextView
        n.a().e(this, 0x7F0700C5).setText(this.getResources().getString(0x7F0B0072));  // id:historyTextView
        n.a().e(this, 0x7F07029F).setText(this.getResources().getString(0x7F0B0008));  // id:tv_before_age
        n.a().e(this, 0x7F0702A5).setText(this.getResources().getString(0x7F0B0104));  // id:tv_before_weight
        n.a().e(this, 0x7F0702A2).setText(this.getResources().getString(0x7F0B0068));  // id:tv_before_gender
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        n.a().e(this, 0x7F07028D).setText(this.getResources().getString(0x7F0B00BD));  // id:titleTextView
        if(this.O == 0) {
            n.a().e(this, 0x7F0702F4).setText(0x7F0B0069);  // id:userNameTextView
        }

        n.a().e(this, 0x7F07029F).setText(0x7F0B0008);  // id:tv_before_age
        n.a().e(this, 0x7F0702A5).setText(0x7F0B0104);  // id:tv_before_weight
        n.a().e(this, 0x7F0702A2).setText(0x7F0B0068);  // id:tv_before_gender
        this.o();
    }

    public void l() {
        this.b(this, this.getResources().getString(0x7F0B000F), false);  // string:STR_ALERT_TIP_SAVE_SESSION "Save workout result..."
        this.N = new Date();
        new Thread() {
            @Override
            public void run() {
                AppsRunner.get(AppsUserActivity.this.getApplicationContext()).a(AppsUserActivity.this.getApplicationContext(), AppsUserActivity.b(AppsUserActivity.this));
                Message v0 = new Message();
                AppsUserActivity.this.j.sendMessage(v0);
            }
        }.start();
    }

    public boolean m() {
        AppsApplication v0 = (AppsApplication)this.getApplication();
        boolean v1 = AppsRunner.get(this).g();
        boolean v0_1 = v0.C();
        j.a("===", "==切换用户，暂停：" + ((boolean)(((int)v1))) + " , " + ((boolean)(((int)v0_1))) + "==");
        if(!v1 && !v0_1) {
            return false;
        }

        try {
            a v0_3 = new a(this);
            v0_3.b(0x7F0B0134);  // string:prompt "Warning"
            v0_3.a(0x7F0B00C9);  // string:STR_STOP_PROGRAM_BEFORE_CHANGE_USER "Please Stop Program Before Changing User"
            v0_3.a(this.getResources().getString(0x7F0B000D), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_OK "OK"
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
            v0_3.a().show();
        }
        catch(Exception v0_2) {
            v0_2.printStackTrace();
        }

        return true;
    }

    private void n() {
        this.b();
        this.C = n.a().a(this, 0x7F0700C8, this);  // id:homeButton
        this.D = n.a().a(this, 0x7F0700C9, this);  // id:homeButton2
        this.E = n.a().a(this, 0x7F07026B, this);  // id:startButton
        this.A = n.a().a(this, 0x7F070097, this);  // id:editButton
        this.B = n.a().a(this, 0x7F0700C3, this);  // id:historyButton
        this.k = n.a().a(this, 0x7F0702ED, this);  // id:userButton1
        this.l = n.a().a(this, 0x7F0702EE, this);  // id:userButton2
        this.m = n.a().a(this, 0x7F0702EF, this);  // id:userButton3
        this.n = n.a().a(this, 0x7F0702F0, this);  // id:userButton4
        this.o = n.a().a(this, 0x7F0702F1, this);  // id:userButton5
        this.p = n.a().a(this, 0x7F0702F2, this);  // id:userButton6
        this.q = n.a().e(this, 0x7F0702F6);  // id:userTextView1
        this.r = n.a().e(this, 0x7F0702F7);  // id:userTextView2
        this.s = n.a().e(this, 0x7F0702F8);  // id:userTextView3
        this.t = n.a().e(this, 0x7F0702F9);  // id:userTextView4
        this.u = n.a().e(this, 0x7F0702FA);  // id:userTextView5
        this.v = n.a().e(this, 0x7F0702FB);  // id:userTextView6
        this.w = n.a().e(this, 0x7F0702F4);  // id:userNameTextView
        this.x = n.a().e(this, 0x7F070013);  // id:ageTextView
        this.y = n.a().e(this, 0x7F0700B8);  // id:genderTextView
        this.z = n.a().e(this, 0x7F0702FF);  // id:weightTextView
        this.F = n.a().c(this, 0x7F070176);  // id:noBluetoothLayout
        this.G = n.a().a(this, 0x7F070280, this);  // id:testConnectButton
        this.I.add(this.k);
        this.I.add(this.l);
        this.I.add(this.m);
        this.I.add(this.n);
        this.I.add(this.o);
        this.I.add(this.p);
        this.J.add(this.q);
        this.J.add(this.r);
        this.J.add(this.s);
        this.J.add(this.t);
        this.J.add(this.u);
        this.J.add(this.v);
        this.G.setVisibility(8);
    }

    private void o() {
        this.K = AppsRunner.get(this).getPref_CurrentUserID(this);
        this.H = apps.database.d.a().b(this);
        int v0;
        for(v0 = 0; v0 < this.H.size(); ++v0) {
            this.a(v0);
        }

        this.b(this.K);
    }

    @Override  // android.app.Activity
    public void onActivityResult(int arg1, int arg2, Intent arg3) {
        if(arg2 == -1 && arg1 == 0x6F) {
            this.finish();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        this.i.removeMessages(0x6F);
        super.onBackPressed();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg6) {
        AppsRunner.get(this).b(this);
        super.onCreate(arg6);
        this.getWindow().setFlags(0x80, 0x80);
        this.a(0x7F09005E, 0x7F090063, 0x7F090065, 0x7F090064);  // layout:activity_user
        this.n();
        this.b(true);
        AppsApplication v0 = (AppsApplication)this.getApplication();
        v0.g(false);
        this.K = AppsRunner.get(this).getPref_CurrentUserID(this);
        if((AppsRunnerConnector.get(this).isConnected()) && (v0.n())) {
            this.a(this, "", false);
            AppsRunner.get(this).selectUserInfo();
        }

        int v1 = AppsRunner.get(this).getPref_CurrentUserID(this);
        if(v0.isConnectionCorrect()) {
            j.a("==切换用户，同步完的，可以刷新token==", "==" + v1);
            v0.doRefreshMMFToken2WithCallbackWithStep(v1 + "", 1);
            v0.doRefreshMFPToken2WithCallbackWithStep(v1 + "", 1);
            v0.doRefreshFBToken2WithCallbackWithStep(v1 + "", 1);
            return;
        }

        j.a("==切换用户，未同步完，不刷新token==", "==" + v1);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        super.onDestroy();
        this.b(false);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        ((AppsApplication)this.getApplication()).e(true);
        this.L = true;
        AppsRunner.get(this).b(this);
        this.o();
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        ((AppsApplication)this.getApplication()).e(false);
        this.L = false;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg6, MotionEvent arg7) {
        Intent v6_4;
        int v7;
        AppsApplication v6;
        if(arg7.getAction() == 0) {
            if(arg6 == this.k) {
                this.O = 0;
                if(this.m()) {
                    return true;
                }

                j.a("===", "==切换用户：" + this.O);
                this.b(this.O);
                AppsRunner.get(this).a(this, this.O);
                this.K = AppsRunner.get(this).getPref_CurrentUserID(this);
                v6 = (AppsApplication)this.getApplication();
                v6.g(false);
                if((AppsRunnerConnector.get(this).isConnected()) && (v6.n())) {
                    this.a(this, "", false);
                    AppsRunner.get(this).selectUserInfo();
                }

                this.o();
                v7 = AppsRunner.get(this).getPref_CurrentUserID(this);
                if(v6.isConnectionCorrect()) {
                    j.a("==切换用户，同步完的，可以刷新token==", "==" + v7);
                    v6.doRefreshMMFToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshMFPToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshFBToken2WithCallbackWithStep(v7 + "", 1);
                    return true;
                }

                j.a("==切换用户，未同步完，不刷新token==", "==" + v7);
                return true;
            }

            if(arg6 == this.l) {
                this.O = 1;
                if(this.m()) {
                    return true;
                }

                j.a("===", "==切换用户：" + this.O);
                this.b(this.O);
                AppsRunner.get(this).a(this, this.O);
                this.K = AppsRunner.get(this).getPref_CurrentUserID(this);
                v6 = (AppsApplication)this.getApplication();
                v6.g(false);
                if((AppsRunnerConnector.get(this).isConnected()) && (v6.n())) {
                    this.a(this, "", false);
                    AppsRunner.get(this).selectUserInfo();
                }

                this.o();
                v7 = AppsRunner.get(this).getPref_CurrentUserID(this);
                if(v6.isConnectionCorrect()) {
                    j.a("==切换用户，同步完的，可以刷新token==", "==" + v7);
                    v6.doRefreshMMFToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshMFPToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshFBToken2WithCallbackWithStep(v7 + "", 1);
                    return true;
                }

                j.a("==切换用户，未同步完，不刷新token==", "==" + v7);
                return true;
            }

            if(arg6 == this.m) {
                this.O = 2;
                if(this.m()) {
                    return true;
                }

                j.a("===", "==切换用户：" + this.O);
                this.b(this.O);
                AppsRunner.get(this).a(this, this.O);
                this.K = AppsRunner.get(this).getPref_CurrentUserID(this);
                v6 = (AppsApplication)this.getApplication();
                v6.g(false);
                if((AppsRunnerConnector.get(this).isConnected()) && (v6.n())) {
                    this.a(this, "", false);
                    AppsRunner.get(this).selectUserInfo();
                }

                this.o();
                v7 = AppsRunner.get(this).getPref_CurrentUserID(this);
                if(v6.isConnectionCorrect()) {
                    j.a("==切换用户，同步完的，可以刷新token==", "==" + v7);
                    v6.doRefreshMMFToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshMFPToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshFBToken2WithCallbackWithStep(v7 + "", 1);
                    return true;
                }

                j.a("==切换用户，未同步完，不刷新token==", "==" + v7);
                return true;
            }

            if(arg6 == this.n) {
                this.O = 3;
                if(this.m()) {
                    return true;
                }

                j.a("===", "==切换用户：" + this.O);
                this.b(this.O);
                AppsRunner.get(this).a(this, this.O);
                this.K = AppsRunner.get(this).getPref_CurrentUserID(this);
                v6 = (AppsApplication)this.getApplication();
                v6.g(false);
                if((AppsRunnerConnector.get(this).isConnected()) && (v6.n())) {
                    this.a(this, "", false);
                    AppsRunner.get(this).selectUserInfo();
                }

                this.o();
                v7 = AppsRunner.get(this).getPref_CurrentUserID(this);
                if(v6.isConnectionCorrect()) {
                    j.a("==切换用户，同步完的，可以刷新token==", "==" + v7);
                    v6.doRefreshMMFToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshMFPToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshFBToken2WithCallbackWithStep(v7 + "", 1);
                    return true;
                }

                j.a("==切换用户，未同步完，不刷新token==", "==" + v7);
                return true;
            }

            if(arg6 == this.o) {
                this.O = 4;
                if(this.m()) {
                    return true;
                }

                j.a("===", "==切换用户：" + this.O);
                this.b(this.O);
                AppsRunner.get(this).a(this, this.O);
                this.K = AppsRunner.get(this).getPref_CurrentUserID(this);
                v6 = (AppsApplication)this.getApplication();
                v6.g(false);
                if((AppsRunnerConnector.get(this).isConnected()) && (v6.n())) {
                    this.a(this, "", false);
                    AppsRunner.get(this).selectUserInfo();
                }

                this.o();
                v7 = AppsRunner.get(this).getPref_CurrentUserID(this);
                if(v6.isConnectionCorrect()) {
                    j.a("==切换用户，同步完的，可以刷新token==", "==" + v7);
                    v6.doRefreshMMFToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshMFPToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshFBToken2WithCallbackWithStep(v7 + "", 1);
                    return true;
                }

                j.a("==切换用户，未同步完，不刷新token==", "==" + v7);
                return true;
            }

            if(arg6 == this.p) {
                this.O = 5;
                if(this.m()) {
                    return true;
                }

                j.a("===", "==切换用户：" + this.O);
                this.b(this.O);
                AppsRunner.get(this).a(this, this.O);
                this.K = AppsRunner.get(this).getPref_CurrentUserID(this);
                v6 = (AppsApplication)this.getApplication();
                v6.g(false);
                if((AppsRunnerConnector.get(this).isConnected()) && (v6.n())) {
                    this.a(this, "", false);
                    AppsRunner.get(this).selectUserInfo();
                }

                this.o();
                v7 = AppsRunner.get(this).getPref_CurrentUserID(this);
                if(v6.isConnectionCorrect()) {
                    j.a("==切换用户，同步完的，可以刷新token==", "==" + v7);
                    v6.doRefreshMMFToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshMFPToken2WithCallbackWithStep(v7 + "", 1);
                    v6.doRefreshFBToken2WithCallbackWithStep(v7 + "", 1);
                    return true;
                }

                j.a("==切换用户，未同步完，不刷新token==", "==" + v7);
                return true;
            }

            if(arg6 != this.C && arg6 != this.D) {
                if(arg6 == this.E) {
                    if(!AppsRunnerConnector.get(this.getApplicationContext()).G()) {
                        this.a(this.getResources().getString(0x7F0B000C));  // string:STR_ALERT_TIP_NOT_OPEN_BLUETOOTH "Please turn on your bluetooth within the device"
                        return true;
                    }

                    if(!AppsRunnerConnector.get(this).isConnected()) {
                        this.a(true);
                        return true;
                    }

                    int v6_1 = AppsRunner.get(this).shouldStopWhenChangeRunMode(6);
                    if(v6_1 > 0) {
                        try {
                            a v7_1 = new a(this);
                            v7_1.b(0x7F0B0134);  // string:prompt "Warning"
                            Resources v1_2 = this.getResources();
                            int v6_3 = v6_1 == 2 ? 0x7F0B0014 : 0x7F0B0013;  // string:STR_ALERT_TIP_STOP_RUN3 "If you change to the Fit Test program, your current workout information will be lost. Do you wish to end your current workout?"
                            v7_1.a(v1_2.getString(v6_3));
                            v7_1.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                                @Override  // android.content.DialogInterface$OnClickListener
                                public void onClick(DialogInterface arg1, int arg2) {
                                    try {
                                        arg1.dismiss();
                                    }
                                    catch(Exception v1) {
                                        v1.printStackTrace();
                                    }

                                    AppsUserActivity.this.l();
                                }
                            });
                            v7_1.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
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
                            v7_1.a().show();
                        }
                        catch(Exception v6_2) {
                            v6_2.printStackTrace();
                        }

                        return true;
                    }

                    if(d.strNotEmpty(((String)ContextSharedPreferences.SharedPreferences(this, "PREVIOUS_CONNECTED_DEVICE", "", 5)))) {
                        this.startActivity(new Intent(this, AppsDeviceListActivity.class));
                        this.finish();
                        return true;
                    }

                    this.startActivity(new Intent(this, AppsDeviceListActivity.class));
                    this.finish();
                    return true;
                }

                if(arg6 == this.A) {
                    if(!AppsRunnerConnector.get(this.getApplicationContext()).G()) {
                        this.a(this.getResources().getString(0x7F0B000C));  // string:STR_ALERT_TIP_NOT_OPEN_BLUETOOTH "Please turn on your bluetooth within the device"
                        return true;
                    }

                    if(!AppsRunnerConnector.get(this).isConnected()) {
                        this.a(true);
                        return true;
                    }

                    v6_4 = new Intent(this, AppsUserEditActivity.class);
                    v6_4.putExtra("Extra_Key_editUser", ((Serializable)this.H.get(this.K)));
                    this.startActivityForResult(v6_4, 0x6F);
                    return true;
                }

                if(arg6 == this.B) {
                    v6_4 = new Intent(this, AppsHistoryActivity.class);
                    v6_4.putExtra("Extra_Key_fromHomeScreen", true);
                    v6_4.putExtra("Extra_Key_from", "fromUser");
                    this.startActivityForResult(v6_4, 0x6F);
                    return true;
                }

                if(arg6 == this.G) {
                    Intent v6_5 = new Intent();
                    v6_5.setAction("NOTIFICATION_DIDCONNECT");
                    this.getApplicationContext().sendBroadcast(v6_5);
                    return true;
                }
            }
            else {
                if(arg6 == this.D) {
                    this.i.removeMessages(0x6F);
                    ((AppsApplication)this.getApplication()).h(true);
                }

                this.onBackPressed();
            }
        }

        return true;
    }
}
