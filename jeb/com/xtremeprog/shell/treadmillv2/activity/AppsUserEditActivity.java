package com.xtremeprog.shell.treadmillv2.activity;

import android.app.DatePickerDialog.OnDateSetListener;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apps.activity.base.AppsRootActivity;
import apps.b.b;
import apps.c.ContextSharedPreferences;
import apps.c.d;
import apps.c.f;
import apps.c.j;
import apps.c.n;
import apps.database.entity.UserArticle;
import com.xpg.a.a.ReceiveData;
import com.xpg.a.bleVersionEnum;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import com.xtremeprog.shell.treadmillv2.Conversions;
import com.xtremeprog.shell.treadmillv2.ShareFitness;
import com.xtremeprog.shell.treadmillv2.views.a;
import java.util.Calendar;
import java.util.Date;

public class AppsUserEditActivity extends AppsRootActivity implements View.OnTouchListener {
    private Button A;
    private Button B;
    private RelativeLayout C;
    private RelativeLayout D;
    private RelativeLayout E;
    private RelativeLayout F;
    private RelativeLayout G;
    private RelativeLayout H;
    private RelativeLayout I;
    private TextView J;
    private int K;
    private int L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private int R;
    private a S;
    private DatePickerDialog.OnDateSetListener T;
    private BroadcastReceiver U;
    final Handler i;
    private UserArticle j;
    private UserArticle k;
    private String l;
    private EditText m;
    private EditText n;
    private TextView o;
    private TextView p;
    private TextView q;
    private ImageView r;
    private ImageView s;
    private Button t;
    private Button u;
    private Button v;
    private Button w;
    private RelativeLayout x;
    private RelativeLayout y;
    private LinearLayout z;

    public AppsUserEditActivity() {
        this.l = "";
        this.K = 0;
        this.L = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.T = new DatePickerDialog.OnDateSetListener() {
            @Override  // android.app.DatePickerDialog$OnDateSetListener
            public void onDateSet(DatePicker arg7, int arg8, int arg9, int arg10) {
                StringBuilder v7 = new StringBuilder();
                v7.append(arg8);
                v7.append("/");
                int v9 = arg9 + 1;
                String v9_1 = v9 < 10 ? "0" + v9 : ((int)v9);
                v7.append(v9_1);
                v7.append("/");
                String v8 = arg10 < 10 ? "0" + arg10 : ((int)arg10);
                v7.append(v8);
                String v7_1 = v7.toString();
                int v8_1 = (int)d.a("2021");
                String v9_2 = v8_1 - 99 + "/01/01";
                String v8_2 = v8_1 - 13 + "/12/31";
                Date v10 = f.stringToDate(v7_1, "yyyy/MM/dd");
                Date v0 = f.stringToDate(v9_2, "yyyy/MM/dd");
                Date v1 = f.stringToDate(v8_2, "yyyy/MM/dd");
                long v2 = v10.getTime();
                long v4 = v0.getTime();
                long v0_1 = v1.getTime();
                if(v2 < v4) {
                    v7_1 = v9_2;
                }

                if(v2 > v0_1) {
                    v7_1 = v8_2;
                }

                AppsUserEditActivity.a(AppsUserEditActivity.this).setText(v7_1);
            }
        };
        this.U = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg5, Intent arg6) {
                String v5 = arg6.getAction();
                if(v5.equals("NOTIFICATION_DID_GET_USER")) {
                    AppsUserEditActivity.c(AppsUserEditActivity.this, true);
                    return;
                }

                if(v5.equals("NOTIFICATION_DID_SET_USER_DATA")) {
                    if(!AppsUserEditActivity.b(AppsUserEditActivity.this)) {
                        return;
                    }

                    if(((int)(((Integer)arg6.getExtras().get("responseCode")))) == 0) {
                        AppsUserEditActivity.this.l();
                        int v5_1 = AppsRunner.get(AppsUserEditActivity.this).getPref_CurrentUserID(AppsUserEditActivity.this);
                        boolean v5_2 = ShareFitness.get(AppsUserEditActivity.this).k(v5_1 + "");
                        AppsUserEditActivity.c(AppsUserEditActivity.this);
                        AppsUserEditActivity.this.n();
                        if(AppsUserEditActivity.d(AppsUserEditActivity.this)) {
                            if(AppsUserEditActivity.e(AppsUserEditActivity.this)) {
                                if((AppsUserEditActivity.f(AppsUserEditActivity.this)) && (v5_2)) {
                                    ShareFitness.get(AppsUserEditActivity.this).b();
                                    Intent v5_3 = new Intent(AppsUserEditActivity.this, AppsShareAuthActivity.class);
                                    AppsUserEditActivity.this.startActivityForResult(v5_3, 0x6F);
                                }
                            }
                            else if(AppsUserEditActivity.f(AppsUserEditActivity.this)) {
                                AppsUserEditActivity.this.finish();
                            }

                            AppsUserEditActivity.d(AppsUserEditActivity.this, false);
                            AppsUserEditActivity.b(AppsUserEditActivity.this, false);
                        }
                    }
                    else {
                        if(AppsUserEditActivity.d(AppsUserEditActivity.this)) {
                            AppsUserEditActivity.b(AppsUserEditActivity.this, false);
                        }

                        AppsUserEditActivity.d(AppsUserEditActivity.this, true);
                        if(AppsUserEditActivity.g(AppsUserEditActivity.this)) {
                            j.a("==恢复用户信息:" + AppsUserEditActivity.g(AppsUserEditActivity.this), "| " + AppsUserEditActivity.h(AppsUserEditActivity.this));
                            apps.database.d v5_4 = apps.database.d.a();
                            UserArticle v0 = AppsUserEditActivity.h(AppsUserEditActivity.this);
                            v5_4.a(AppsUserEditActivity.this, v0);
                            AppsUserEditActivity.c(AppsUserEditActivity.this, false);
                            AppsUserEditActivity.c(AppsUserEditActivity.this);
                            AppsUserEditActivity.d(AppsUserEditActivity.this, false);
                        }
                    }

                    AppsUserEditActivity.e(AppsUserEditActivity.this, false);
                    return;
                }

                if(!v5.equals("NOTIFICATION_DID_START_WORKOUT")) {
                    if(!v5.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                        goto label_141;
                    }

                    if(!AppsUserEditActivity.f(AppsUserEditActivity.this)) {
                        return;
                    }

                    AppsUserEditActivity.this.c(false);
                    AppsUserEditActivity.this.i.removeMessages(0x6F);
                    d.a(AppsUserEditActivity.i(AppsUserEditActivity.this), 1000, AppsUserEditActivity.this);
                    Intent v5_5 = AppsUserEditActivity.this.getIntent();
                    AppsUserEditActivity.this.setResult(-1, v5_5);
                }

                AppsUserEditActivity.this.finish();
                return;
            label_141:
                if(!v5.equals("NOTIFICATION_DISCONNECT")) {
                    if(v5.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                        AppsUserEditActivity.this.i.removeMessages(0x6F);
                        return;
                    }

                    if(v5.equals("NOTIFICATION_DID_GET_SHARE_ACCESS_TOKEN")) {
                        AppsUserEditActivity.this.l();
                    }
                }
                else if(AppsUserEditActivity.f(AppsUserEditActivity.this)) {
                    AppsUserEditActivity.this.c(true);
                    return;
                }
            }
        };
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    Intent v4 = new Intent(AppsUserEditActivity.this, AppsDeviceListActivity.class);
                    AppsUserEditActivity.this.startActivity(v4);
                    AppsUserEditActivity.this.finish();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsUserEditActivity.this.c(false);
                        }
                    }, 500L);
                }
            }
        };
    }

    static TextView a(AppsUserEditActivity arg0) {
        return arg0.q;
    }

    static boolean a(AppsUserEditActivity arg0, boolean arg1) {
        arg0.P = arg1;
        return arg1;
    }

    public boolean a(boolean arg25) {
        String v0_4;
        int v3;
        Resources v0;
        AppsUserEditActivity v1 = this;
        if(!AppsRunnerConnector.get(this.getApplicationContext()).isConnected()) {
            v0 = this.getResources();
            v3 = 0x7F0B000B;  // string:STR_ALERT_TIP_CONNECT_DEVICE "Please connect your device"
            v1.a(v0.getString(v3));
            return true;
        }

        v1.Q = true;
        int v0_1 = v1.j.getGuest();
        int v3_1 = v1.j.getId();
        String v4 = v1.q.getText().toString();
        String v5 = v1.n.getText().toString();
        String v6 = v1.m.getText().toString().trim();
        if(d.strNotEmpty(v6)) {
            v0 = this.getResources();
            v3 = 0x7F0B0077;  // string:STR_INPUT_USR_NAME "Please input user name"
            v1.a(v0.getString(v3));
            return true;
        }

        if(d.strNotEmpty(v5)) {
            v0 = this.getResources();
            v3 = 0x7F0B0078;  // string:STR_INPUT_USR_WEIGHT "Please input user weight"
            v1.a(v0.getString(v3));
            return true;
        }

        int v5_1 = (int)d.a(v5, 0);
        if(v1.L == 1) {
            if(v5_1 < Conversions.c(this)) {
                v5_1 = Conversions.c(this);
            }
            else if(v5_1 > Conversions.a(this)) {
                v5_1 = Conversions.a(this);
            }
        }
        else if(v5_1 < Conversions.d(this)) {
            v5_1 = Conversions.d(this);
        }
        else if(v5_1 > Conversions.b(this)) {
            v5_1 = Conversions.b(this);
        }

        v1.n.setText(v5_1 + "");
        String v5_2 = v1.n.getText().toString();
        v1.j.setGender(v1.K);
        v1.j.setBirthday(v4);
        v1.j.setWeight(v5_2);
        v1.j.setUnit(v1.L);
        int v8 = v1.j.getModifyflag();
        if(v0_1 == 1) {
            try {
                int v0_3 = d.a(v1, "string", v6);
                if(v0_3 != 0) {
                    v0_4 = this.getResources().getString(v0_3);
                    goto label_101;
                }
            }
            catch(Exception v0_2) {
                v0_2.printStackTrace();
            }

            goto label_103;
        label_101:
            v6 = v0_4;
        }
        else if(!d.a(v6, v1.l) && v8 == 0) {
            v1.j.setNickname(v1.m.getText().toString());
            v8 = 1;
        }

    label_103:
        v1.j.setModifyflag(v8);
        v1.j.setNickname(v6);
        apps.database.d.a().a(v1, v1.j);
        int v0_5 = v1.L;
        int v10 = v1.K;
        Date v4_1 = f.stringToDate(v4, "yyyy/MM/dd");
        if(v4_1 == null) {
            v4_1 = f.stringToDate("2000-01-01", "yyyy-MM-dd");
        }

        int v13 = (int)d.a(f.a(v4_1, "yyyy"), 1970);
        int v14 = (int)d.a(f.a(v4_1, "MM"), 1);
        int v15 = (int)d.a(f.a(v4_1, "dd"), 1);
        int v12 = d.a(v4_1);
        int v4_2 = (int)d.a(v5_2, 0);
        if(v0_5 == 1) {
            v4_2 = Conversions.kg_to_lb(v4_2);
        }

        if(d.a(v6, "INVITÉ")) {
            v6 = "INVITE";
        }

        int v5_3 = AppsRunner.get(this).getPref_CurrentUserID(v1);
        AppsApplication v8_1 = (AppsApplication)this.getApplication();
        if(arg25) {
            int v3_2 = v3_1 - 1;
            j.a("===USER DELETE===", v3_2 + " | " + v6 + " | " + v1.L + " | " + v10 + " | " + v13 + " | " + v14 + " | " + v15 + " | " + v12 + " | " + v4_2 * 10);
            v8_1.F = v3_2;
            ShareFitness.get(this).l(v5_3 + "");
            this.l();
            AppsRunner.get(this).g(v3_2);
            return true;
        }

        String v7 = ShareFitness.get(this).getPrefsMapMyFitnessTokenKey(v5_3 + "");
        String v2 = ShareFitness.get(this).getPrefsMFPTokenId(v5_3 + "");
        int v17 = v0_5;
        String v0_6 = ShareFitness.get(this).getPrefsFitbitTokenId(v5_3 + "");
        AppsApplication v18 = v8_1;
        String v8_2 = ShareFitness.get(this).getPrefsMFP_UserId(v5_3 + "");
        String v5_4 = ShareFitness.get(this).getPrefsFitbitUserId(v5_3 + "");
        if(d.strNotEmpty(v7)) {
            v7 = "0000000000000000000000000000000000000000";
        }

        if(d.strNotEmpty(v2)) {
            v2 = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        }

        if(d.strNotEmpty(v0_6)) {
            v0_6 = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        }

        if(d.strNotEmpty(v8_2)) {
            v8_2 = "000000000000000";
        }

        String v11 = v8_2;
        if(d.strNotEmpty(v5_4)) {
            v5_4 = "000000";
        }

        j.a("==三个token为==", "MMF : " + v7 + "  |   MFP:" + v2 + "  |   FB:" + v0_6 + "  |  " + v11);
        int v5_5 = b.a().c(v1);
        int v3_3 = v3_1 - 1;
        int v0_7 = v4_2 * 10;
        j.a("===USER EDIT===", v3_3 + " | " + v6 + " | " + v1.L + " | " + v10 + " | " + v13 + " | " + v14 + " | " + v15 + " | " + v12 + " | " + v0_7 + " | " + v7 + " | " + v2);
        v18.H = v3_3;
        v18.I = v10;
        v18.J = v0_7;
        v18.K = v12;
        v18.L = v13;
        v18.M = v14;
        v18.N = v15;
        v18.O = v5_5;
        v18.P = v17;
        v18.Q = v6;
        v18.R = v11;
        v18.S = v5_4;
        v18.g(false);
        AppsRunner.get(this).setUserData(v3_3, v10, v0_7, v12, v13, v14, v15, v5_5, v1.L, v6, v7, v2, v11, v0_6, v5_4);
        return true;
    }

    static boolean b(AppsUserEditActivity arg0) {
        return arg0.Q;
    }

    static boolean b(AppsUserEditActivity arg0, boolean arg1) {
        arg0.M = arg1;
        return arg1;
    }

    public void b(boolean arg2) {
        if(!arg2) {
            goto label_44;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DID_GET_USER");
            this.registerReceiver(this.U, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DID_SET_USER_DATA");
            this.registerReceiver(this.U, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_DID_START_WORKOUT");
            this.registerReceiver(this.U, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.U, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.U, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.U, v2_6);
            IntentFilter v2_7 = new IntentFilter();
            v2_7.addAction("NOTIFICATION_DID_GET_SHARE_ACCESS_TOKEN");
            this.registerReceiver(this.U, v2_7);
            return;
        label_44:
            this.unregisterReceiver(this.U);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static void c(AppsUserEditActivity arg0) {
        arg0.p();
    }

    static void c(AppsUserEditActivity arg0, boolean arg1) {
        arg0.d(((boolean)(((int)arg1))));
    }

    public void c(boolean arg4) {
        if(arg4) {
            this.C.setVisibility(0);
            this.i.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.i.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.C.setVisibility(8);
        this.i.removeMessages(0x6F);
    }

    private void d(boolean arg8) {
        if(arg8) {
            this.j = apps.database.d.a().b(this, this.j.getId());
        }

        UserArticle v8 = this.j;
        if(v8 != null) {
            String v0 = v8.getNickname();
            String v1 = v8.getBirthday();
            String v2 = v8.getWeight();
            int v3 = v8.getGuest();
            int v4 = v8.getGender();
            v8.getModifyflag();
            int v8_1 = v8.getUnit();
            if((d.a(v0, "USER 1")) || (d.a(v0, "User 1"))) {
                v0 = "USER1";
            }
            else if((d.a(v0, "USER 2")) || (d.a(v0, "User 2"))) {
                v0 = "USER2";
            }
            else if((d.a(v0, "USER 3")) || (d.a(v0, "User 3"))) {
                v0 = "USER3";
            }
            else if((d.a(v0, "USER 4")) || (d.a(v0, "User 4"))) {
                v0 = "USER4";
            }
            else if((d.a(v0, "USER 5")) || (d.a(v0, "User 5"))) {
                v0 = "USER5";
            }
            else if((d.a(v0, "USER 6")) || (d.a(v0, "User 6"))) {
                v0 = "USER6";
            }
            else if(d.a(v0, "Usuario 1")) {
                v0 = "Usuario1";
            }
            else if(d.a(v0, "Usuario 2")) {
                v0 = "Usuario2";
            }
            else if(d.a(v0, "Usuario 3")) {
                v0 = "Usuario3";
            }
            else if(d.a(v0, "Usuario 4")) {
                v0 = "Usuario4";
            }
            else if(d.a(v0, "Usuario 5")) {
                v0 = "Usuario5";
            }
            else if(d.a(v0, "Usuario 6")) {
                v0 = "Usuario6";
            }
            else if(d.a(v0, "Utilisateur 1")) {
                v0 = "Utilisateur1";
            }
            else if(d.a(v0, "Utilisateur 2")) {
                v0 = "Utilisateur2";
            }
            else if(d.a(v0, "Utilisateur 3")) {
                v0 = "Utilisateur3";
            }
            else if(d.a(v0, "Utilisateur 4")) {
                v0 = "Utilisateur4";
            }
            else if(d.a(v0, "Utilisateur 5")) {
                v0 = "Utilisateur5";
            }
            else if(d.a(v0, "Utilisateur 6")) {
                v0 = "Utilisateur6";
            }

            int v5 = d.a(this.getApplicationContext(), "string", v0);
            if(v5 == 0) {
                this.m.setText(v0);
            }
            else {
                this.m.setText(v5);
            }

            this.n.setText(v2);
            this.q.setText(v1);
            this.K = v4;
            if(v3 == 1) {
                this.m.setEnabled(false);
            }
            else {
                this.m.setEnabled(true);
            }

            this.L = v8_1;
            if(v8_1 == 1) {
                this.A.setBackgroundResource(0x7F060152);  // drawable:pad_setup_btn_nor
                this.B.setBackgroundResource(0x7F060153);  // drawable:pad_setup_btn_sel
                this.A.setEnabled(true);
                this.B.setEnabled(false);
            }
            else {
                this.A.setBackgroundResource(0x7F060153);  // drawable:pad_setup_btn_sel
                this.B.setBackgroundResource(0x7F060152);  // drawable:pad_setup_btn_nor
                this.A.setEnabled(false);
                this.B.setEnabled(true);
            }

            this.R = AppsRunner.get(this).ad();
            this.s();
        }

        this.l();
    }

    static boolean d(AppsUserEditActivity arg0) {
        return arg0.M;
    }

    static boolean d(AppsUserEditActivity arg0, boolean arg1) {
        arg0.O = arg1;
        return arg1;
    }

    static boolean e(AppsUserEditActivity arg0) {
        return arg0.P;
    }

    static boolean e(AppsUserEditActivity arg0, boolean arg1) {
        arg0.Q = arg1;
        return arg1;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        n.a().e(this, 0x7F0702A3).setText(this.getResources().getString(0x7F0B00A8));  // id:tv_before_name
        n.a().e(this, 0x7F0702A0).setText(this.getResources().getString(0x7F0B0019));  // id:tv_before_birthday
        n.a().e(this, 0x7F0702A5).setText(this.getResources().getString(0x7F0B0104));  // id:tv_before_weight
        n.a().e(this, 0x7F07028D).setText(this.getResources().getString(0x7F0B0049));  // id:titleTextView
        n.a().e(this, 0x7F0701A1).setText(this.getResources().getString(0x7F0B00B7));  // id:saveTextView
        n.a().e(this, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(this, 0x7F07008B).setText(this.getResources().getString(0x7F0B0034));  // id:deleteTextView
        n.a().e(this, 0x7F0702AD).setText(this.getResources().getString(0x7F0B0067));  // id:tv_forget
        n.a().e(this, 0x7F0700B9).setText(this.getResources().getString(0x7F0B007E));  // id:genderTextView1
        n.a().e(this, 0x7F0700BA).setText(this.getResources().getString(0x7F0B005E));  // id:genderTextView2
        n.a().e(this, 0x7F0702E9).setText(this.getResources().getString(0x7F0B00F5));  // id:unitTextView1
        n.a().e(this, 0x7F0702EA).setText(this.getResources().getString(0x7F0B00F0));  // id:unitTextView2
        n.a().e(this, 0x7F0700B3).setText(this.getResources().getString(0x7F0B0066));  // id:forgetTextView
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        this.d(false);
    }

    static boolean f(AppsUserEditActivity arg0) {
        return arg0.N;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void finish() {
        super.finish();
    }

    static boolean g(AppsUserEditActivity arg0) {
        return arg0.O;
    }

    static UserArticle h(AppsUserEditActivity arg0) {
        return arg0.k;
    }

    static Button i(AppsUserEditActivity arg0) {
        return arg0.t;
    }

    public void l() {
        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        ShareFitness.get(this).getPrefsMapMyFitnessTokenKey(v0 + "");
        ShareFitness.get(this).getPrefsMFPTokenId(v0 + "");
        ShareFitness.get(this).getPrefsFitbitTokenId(v0 + "");
        this.D.setOnTouchListener(this);
        this.E.setOnTouchListener(this);
        this.F.setOnTouchListener(this);
        this.G.setOnTouchListener(this);
        this.H.setOnTouchListener(this);
    }

    public void m() {
        if(d.strNotEmpty(this.q.getText().toString())) {
            this.S = new a(this, this.T, Calendar.getInstance().get(1), Calendar.getInstance().get(2), Calendar.getInstance().get(5));
        }
        else {
            Calendar v0 = Calendar.getInstance();
            Date v4 = f.stringToDate(this.q.getText().toString(), "yyyy/MM/dd");
            int v5 = (int)d.a("2021");
            Date v6 = f.stringToDate(v5 - 99 + "/01/01", "yyyy/MM/dd");
            Date v5_1 = f.stringToDate(v5 - 13 + "/12/31", "yyyy/MM/dd");
            if(v4.getTime() < v6.getTime()) {
                v4 = v6;
            }
            else if(v4.getTime() > v5_1.getTime()) {
                v4 = v5_1;
            }

            v0.setTime(v4);
            this.S = new a(this, this.T, v0.get(1), v0.get(2), v0.get(5));
            this.S.getDatePicker().setMinDate(v6.getTime());
            this.S.getDatePicker().setMaxDate(v5_1.getTime());
        }

        this.S.getDatePicker().setCalendarViewShown(false);
        this.S.show();
    }

    public void n() {
        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        Date v1 = f.stringToDate(this.j.getBirthday(), "yyyy/MM/dd");
        if(v1 == null) {
            v1 = f.stringToDate("2000-01-01", "yyyy-MM-dd");
        }

        int v1_1 = d.a(v1);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_age_hr", d.a(Integer.valueOf(v1_1)), 1);
        if(this.R != v1_1) {
            float v1_2 = (float)(((int)(((float)(220 - v1_1)) * 0.75f)));
            float v3 = 1.0f * v1_2;
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_hr_hr_" + 1, Float.valueOf(v3), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_hr_hr_" + 2, Float.valueOf(v1_2), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_hr_hr_" + 3, Float.valueOf(v3), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_hr_hr_" + 4, Float.valueOf(v3), 3);
        }
    }

    public void o() {
        int v4_2;
        int v2_1;
        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        int v1 = AppsRunner.get(this).ad();
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_maxSegment", Integer.valueOf(1), 1);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_maxSegmentDis", Integer.valueOf(1), 1);
        boolean v2 = AppsRunner.get(this).inclineSupportsHalfDegree(this);
        int v4 = 0;
        while(v4 < 16) {
            ++v4;
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "time" + v4, Float.valueOf(0.5f), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_speed_" + v4, Float.valueOf(0.5f), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_resistance_" + v4, Float.valueOf(1.0f), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_incline_" + v4, Float.valueOf(0.0f), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_segmentLength_" + v4, Float.valueOf(1.0f), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_speed_dis_" + v4, Float.valueOf(0.5f), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_resistance_dis_" + v4, Float.valueOf(1.0f), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_incline_dis_" + v4, Float.valueOf(0.0f), 3);
            ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_segmentLengthDis_" + v4, Float.valueOf(0.1f), 3);
        }

        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_time", Integer.valueOf(60), 1);
        float v5 = 20.0f;
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_maxSpeed", Float.valueOf(v2 ? 20.0f : 12.0f), 3);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_maxResistance", Float.valueOf(20.0f), 3);
        String v4_1 = v0 + "_maxIncline";
        if(!v2) {
            v5 = 15.0f;
        }

        ContextSharedPreferences.SharedPreferencesEditor(this, v4_1, Float.valueOf(v5), 3);
        if(AppsRunner.get(this).Y() == 1) {
            v2_1 = 0x20;
            v4_2 = 56;
        }
        else {
            v2_1 = 20;
            v4_2 = 35;
        }

        int v5_1 = AppsRunner.get(this).getPref_CurrentUserID(this);
        AppsRunner.get(this).setDeviceWeek(this, 1, v5_1);
        AppsRunner.get(this).setDeviceWorkout(this, 1, v5_1);
        AppsRunner.get(this).setDeviceResetCount(this, 1, v5_1);
        AppsRunner.get(this).setWalkSpeed(this, v2_1, v5_1);
        AppsRunner.get(this).setJogSpeed(this, v4_2, v5_1);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_age_hr", Integer.valueOf(v1), 1);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_time_hr", Integer.valueOf(900), 1);
        float v2_2 = ((float)(((int)(((float)(220 - v1)) * 0.75f)))) * 1.0f;
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_hr_hr_1", Float.valueOf(v2_2), 3);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_segmentLength_hr_1", Float.valueOf(1.0f), 3);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_hr_hr_2", Float.valueOf(v2_2), 3);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_segmentLength_hr_2", Float.valueOf(1.0f), 3);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_hr_hr_3", Float.valueOf(v2_2), 3);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_segmentLength_hr_3", Float.valueOf(1.0f), 3);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_hr_hr_4", Float.valueOf(v2_2), 3);
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_segmentLength_hr_4", Float.valueOf(1.0f), 3);
    }

    @Override  // android.app.Activity
    public void onActivityResult(int arg1, int arg2, Intent arg3) {
        if(arg2 == -1 && arg1 == 0x6F) {
            this.setResult(-1, this.getIntent());
            this.finish();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        this.i.removeMessages(0x6F);
        super.onBackPressed();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg3) {
        AppsRunner.get(this).b(this);
        super.onCreate(arg3);
        this.getWindow().setFlags(0x80, 0x80);
        this.a(0x7F09005F, 0x7F090060, 0x7F090061);  // layout:activity_user_edit
        if(this.getIntent().getExtras() != null && this.getIntent().getExtras().get("Extra_Key_editUser") != null) {
            this.j = (UserArticle)this.getIntent().getExtras().get("Extra_Key_editUser");
            int v3 = d.a(this.getApplicationContext(), "string", this.j.getNickname());
            if(v3 != 0) {
                this.l = this.getResources().getString(v3);
            }
        }

        this.r();
        this.d(false);
        this.q();
        this.b(true);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        super.onDestroy();
        this.b(false);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        this.N = true;
        AppsRunner.get(this).b(this);
        this.d(false);
        AppsApplication v2 = (AppsApplication)this.getApplication();
        if((AppsRunnerConnector.get(this).isConnected()) && (v2.n())) {
            j.a("===", "===UserEdit已连接===");
            this.c(false);
            return;
        }

        j.a("===", "===UserEdit未连接===");
        this.c(true);
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        this.N = false;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg8, MotionEvent arg9) {
        String v9_5;
        String v9_4;
        String v8_5;
        EditText v9_3;
        int v8_3;
        int v9_1;
        Resources v8;
        if(arg9.getAction() == 0) {
            Button v9 = this.w;
            int v1 = 0x7F0B000C;  // string:STR_ALERT_TIP_NOT_OPEN_BLUETOOTH "Please turn on your bluetooth within the device"
            if(arg8 == v9) {
                d.a(v9, 1000, this);
                if(!AppsRunnerConnector.get(this.getApplicationContext()).G()) {
                    v8_5 = this.getResources().getString(v1);
                    this.a(v8_5);
                    return true;
                }

                if(!AppsRunnerConnector.get(this.getApplicationContext()).isConnected()) {
                    v8 = this.getResources();
                    v9_1 = 0x7F0B000B;  // string:STR_ALERT_TIP_CONNECT_DEVICE "Please connect your device"
                    goto label_165;
                }

                try {
                    apps.views.d.a v8_2 = new apps.views.d.a(this);
                    v8_2.b(0x7F0B0134);  // string:prompt "Warning"
                    v8_2.a(0x7F0B0036);  // string:STR_DELETE_USER_MSG "Would you like to delete this user?"
                    v8_2.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface arg5, int arg6) {
                            try {
                                arg5.dismiss();
                            }
                            catch(Exception v5) {
                                v5.printStackTrace();
                            }

                            AppsUserEditActivity.a(AppsUserEditActivity.this, false);
                            AppsUserEditActivity.b(AppsUserEditActivity.this, true);
                            int v5_1 = AppsRunner.get(AppsUserEditActivity.this.getApplicationContext()).getPref_CurrentUserID(AppsUserEditActivity.this.getApplicationContext());
                            apps.database.b.a().a(AppsUserEditActivity.this.getApplicationContext(), AppsRunner.get(AppsUserEditActivity.this.getApplicationContext()).getPref_CurrentUserID(AppsUserEditActivity.this.getApplicationContext()));
                            apps.database.d.a().a(AppsUserEditActivity.this.getApplicationContext(), v5_1);
                            AppsUserEditActivity.this.o();
                            AppsUserEditActivity.c(AppsUserEditActivity.this, true);
                            AppsUserEditActivity.this.a(true);
                        }
                    });
                    v8_2.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
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
                    v8_2.a().show();
                }
                catch(Exception v8_1) {
                    v8_1.printStackTrace();
                }

                return true;
            }

            if(arg8 == this.t || arg8 == this.u) {
                goto label_235;
            }

            if(arg8 == this.v) {
                if(!AppsRunnerConnector.get(this.getApplicationContext()).G()) {
                    v8_5 = this.getResources().getString(v1);
                    this.a(v8_5);
                    return true;
                }

                this.P = false;
                this.M = true;
                this.b(this, "", false);
                d.a(this.v, 1000, this);
                return this.a(false);
            }

            if(arg8 == this.x) {
                this.K = 0;
                this.s();
                return true;
            }

            if(arg8 == this.y) {
                this.K = 1;
                this.s();
                return true;
            }

            if(arg8 == this.z) {
                this.m();
                return true;
            }

            Button v9_2 = this.A;
            double v1_1 = 0.0;
            if(arg8 == v9_2) {
                v9_2.setBackgroundResource(0x7F060153);  // drawable:pad_setup_btn_sel
                this.B.setBackgroundResource(0x7F060152);  // drawable:pad_setup_btn_nor
                this.A.setEnabled(false);
                this.B.setEnabled(true);
                this.L = 0;
                v8_3 = Conversions.kg_to_lb(d.a(this.n.getText().toString(), v1_1));
                v9_3 = this.n;
                v9_3.setText(v8_3 + "");
                return true;
            }

            if(arg8 == this.B) {
                v9_2.setBackgroundResource(0x7F060152);  // drawable:pad_setup_btn_nor
                this.B.setBackgroundResource(0x7F060153);  // drawable:pad_setup_btn_sel
                this.A.setEnabled(true);
                this.B.setEnabled(false);
                this.L = 1;
                v8_3 = Conversions.lb_to_kg(d.a(this.n.getText().toString(), v1_1));
                v9_3 = this.n;
                v9_3.setText(v8_3 + "");
                return true;
            }

            v1 = 0x7F0B00B1;  // string:STR_PLEASE_CONNECT_TO_INTERNET_TO_SHARE_WORKOUTS "PLEASE CONNECT TO INTERNET TO SHARE WORKOUTS"
            if(arg8 == this.D || arg8 == this.F || arg8 == this.H) {
                goto label_202;
            }

            if(arg8 == this.E) {
                if(!d.d(this)) {
                    v8_5 = this.getResources().getString(v1);
                    this.a(v8_5);
                    return true;
                }

                int v8_4 = AppsRunner.get(this).getPref_CurrentUserID(this);
                ShareFitness.get(this).a(1);
                if(!ShareFitness.get(this).k(v8_4 + "")) {
                    goto label_185;
                }

                goto label_181;
            }

            if(arg8 == this.G) {
                if(!d.d(this)) {
                    v8_5 = this.getResources().getString(v1);
                    this.a(v8_5);
                    return true;
                }

                if(ReceiveData.bleVersion != bleVersionEnum.BleVersion_FITBIT) {
                    v8 = this.getResources();
                    v9_1 = 0x7F0B00F8;  // string:STR_UPDATE_CONSOLE "Please update console software to activate fitbit. For the latest version please visit http://www.afgfitness.com/support/software-update"
                label_165:
                    v8_5 = v8.getString(v9_1);
                    this.a(v8_5);
                    return true;
                }

                int v8_6 = AppsRunner.get(this).getPref_CurrentUserID(this);
                ShareFitness.get(this).a(2);
                if(ShareFitness.get(this).k(v8_6 + "")) {
                label_181:
                    v9_4 = "==还未授权，授权前发setUser_2==";
                    goto label_221;
                }

            label_185:
                v9_5 = "==已经授权过，不用再授权_2==";
                j.a("===", v9_5);
                return true;
            }

            if(arg8 == this.I) {
                int v8_7 = AppsRunner.get(this).getPref_CurrentUserID(this);
                ShareFitness.get(this).l(v8_7 + "");
                this.l();
                return true;
            label_202:
                if(d.d(this)) {
                    int v8_8 = AppsRunner.get(this).getPref_CurrentUserID(this);
                    ShareFitness.get(this).a(0);
                    if(ShareFitness.get(this).k(v8_8 + "")) {
                        v9_4 = "==还未授权，授权前发setUser_1==";
                    label_221:
                        j.a("===", v9_4);
                        this.M = true;
                        this.P = true;
                        this.a(false);
                        return true;
                    }

                    v9_5 = "==已经授权过，不用再授权_1==";
                    j.a("===", v9_5);
                    return true;
                }

                v8_5 = this.getResources().getString(v1);
                this.a(v8_5);
                return true;
            label_235:
                if(arg8 == this.u) {
                    this.i.removeMessages(0x6F);
                    ((AppsApplication)this.getApplication()).h(true);
                }

                d.a(this.t, 1000, this);
                this.setResult(-1, this.getIntent());
                this.finish();
            }
        }

        return true;
    }

    private void p() {
        this.j = apps.database.d.a().b(this, this.j.getId());
        this.q();
    }

    private void q() {
        this.k = new UserArticle();
        this.k.setId(this.j.getId());
        this.k.setUserid(this.j.getUserid());
        this.k.setNickname(this.j.getNickname());
        this.k.setBirthday(this.j.getBirthday());
        this.k.setWeight(this.j.getWeight());
        this.k.setHeight(this.j.getHeight());
        this.k.setGender(this.j.getGender());
        this.k.setModifyflag(this.j.getModifyflag());
        this.k.setGuest(this.j.getGuest());
        this.k.setUnit(this.j.getUnit());
        this.k.setKey1(this.j.getKey1());
        this.k.setKey2(this.j.getKey2());
        this.k.setKey3(this.j.getKey3());
        this.k.setKey4(this.j.getKey4());
        this.k.setKey5(this.j.getKey5());
        this.k.setKey6(this.j.getKey6());
        this.k.setKey7(this.j.getKey7());
        this.k.setKey8(this.j.getKey8());
        this.k.setKey9(this.j.getKey9());
        this.k.setKey10(this.j.getKey10());
    }

    private void r() {
        this.b();
        this.t = n.a().a(this, 0x7F0700C8, this);  // id:homeButton
        this.u = n.a().a(this, 0x7F0700C9, this);  // id:homeButton2
        this.v = n.a().a(this, 0x7F07019F, this);  // id:saveButton
        this.w = n.a().a(this, 0x7F07018E, this);  // id:resetButton
        this.m = n.a().f(this, 0x7F0702F4);  // id:userNameTextView
        this.o = n.a().e(this, 0x7F0700B9);  // id:genderTextView1
        this.p = n.a().e(this, 0x7F0700BA);  // id:genderTextView2
        this.q = n.a().e(this, 0x7F07001C);  // id:birthdayTextView
        this.n = n.a().f(this, 0x7F0702FF);  // id:weightTextView
        this.x = n.a().c(this, 0x7F0700B6, this);  // id:genderLayout1
        this.y = n.a().c(this, 0x7F0700B7, this);  // id:genderLayout2
        this.z = n.a().b(this, 0x7F07001B, this);  // id:birthdayLayout
        this.A = n.a().a(this, 0x7F0702E7, this);  // id:unitButton1
        this.B = n.a().a(this, 0x7F0702E8, this);  // id:unitButton2
        this.D = n.a().c(this, 0x7F070234, this);  // id:shareLayout1
        this.E = n.a().c(this, 0x7F070235, this);  // id:shareLayout2
        this.F = n.a().c(this, 0x7F070236, this);  // id:shareLayout3
        this.G = n.a().c(this, 0x7F070237, this);  // id:shareLayout4
        this.H = n.a().c(this, 0x7F070238, this);  // id:shareLayout5
        this.I = n.a().c(this, 0x7F0700B2, this);  // id:forgetLayout
        this.J = n.a().e(this, 0x7F0700B3);  // id:forgetTextView
        this.C = n.a().c(this, 0x7F070176);  // id:noBluetoothLayout
        this.r = n.a().d(this, 0x7F070116);  // id:maleGenderImageView
        this.s = n.a().d(this, 0x7F0700B0);  // id:femaleGenderImageView
    }

    private void s() {
        int v1;
        ImageView v0;
        if(this.K == 1) {
            this.r.setBackgroundResource(0x7F060156);  // drawable:pad_setup_male_nor
            v0 = this.s;
            v1 = 0x7F060155;  // drawable:pad_setup_female_sel
        }
        else {
            this.r.setBackgroundResource(0x7F060157);  // drawable:pad_setup_male_sel
            v0 = this.s;
            v1 = 0x7F060154;  // drawable:pad_setup_female_nor
        }

        v0.setBackgroundResource(v1);
    }
}
