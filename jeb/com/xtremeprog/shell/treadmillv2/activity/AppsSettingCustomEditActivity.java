package com.xtremeprog.shell.treadmillv2.activity;

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
import com.xpg.a.b.CustomProgram.a;
import com.xpg.a.b.CustomProgram.b;
import com.xpg.a.b.CustomProgram;
import com.xpg.a.b.DeviceCommand;
import com.xpg.a.c.Factory;
import com.xpg.b.BLEManager;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import com.xtremeprog.shell.treadmillv2.Conversions;
import com.xtremeprog.shell.treadmillv2.views.AppsMeterView;
import java.util.ArrayList;

public class AppsSettingCustomEditActivity extends AppsRootActivity implements View.OnTouchListener {
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private AppsMeterView[] E;
    private AppsMeterView[] F;
    private AppsMeterView[] G;
    private AppsMeterView[] H;
    private AppsMeterView[] I;
    private AppsMeterView[] J;
    private Button K;
    private Button L;
    private Button M;
    private Button N;
    private String[] O;
    private String[] P;
    private int[] Q;
    private int[] R;
    private int[] S;
    private int[] T;
    private int[] U;
    private int[] V;
    private int W;
    private int X;
    private float[] Y;
    private float[] Z;
    private boolean aa;
    private int ab;
    private int ac;
    private boolean ad;
    private BroadcastReceiver ae;
    private int af;
    private int ag;
    private RelativeLayout ah;
    final Handler i;
    final Handler j;
    private Button k;
    private Button l;
    private Button m;
    private Button n;
    private Button o;
    private Button p;
    private Button q;
    private Button r;
    private TextView s;
    private TextView t;
    private LinearLayout u;
    private LinearLayout v;
    private TextView w;
    private TextView x;
    private LinearLayout y;
    private LinearLayout z;

    public AppsSettingCustomEditActivity() {
        this.O = new String[16];
        this.P = new String[21];
        this.Q = new int[]{0x7F070201, 0x7F070211, 0x7F070213, 0x7F070215, 0x7F070217, 0x7F070219, 0x7F07021B, 0x7F07021D, 0x7F07021F, 0x7F070202, 0x7F070204, 0x7F070206, 0x7F070208, 0x7F07020A, 0x7F07020C, 0x7F07020E};  // id:setting_custom_speed_view1
        this.R = new int[]{0x7F0701E1, 0x7F0701F1, 0x7F0701F3, 0x7F0701F5, 0x7F0701F7, 0x7F0701F9, 0x7F0701FB, 0x7F0701FD, 0x7F0701FF, 0x7F0701E2, 0x7F0701E4, 0x7F0701E6, 0x7F0701E8, 0x7F0701EA, 0x7F0701EC, 0x7F0701EE};  // id:setting_custom_resistance_view1
        this.S = new int[]{0x7F0701C1, 0x7F0701D1, 0x7F0701D3, 0x7F0701D5, 0x7F0701D7, 0x7F0701D9, 0x7F0701DB, 0x7F0701DD, 0x7F0701DF, 0x7F0701C2, 0x7F0701C4, 0x7F0701C6, 0x7F0701C8, 0x7F0701CA, 0x7F0701CC, 0x7F0701CE};  // id:setting_custom_incline_view1
        this.T = new int[]{0x7F070210, 0x7F070212, 0x7F070214, 0x7F070216, 0x7F070218, 0x7F07021A, 0x7F07021C, 0x7F07021E, 0x7F070220, 0x7F070203, 0x7F070205, 0x7F070207, 0x7F070209, 0x7F07020B, 0x7F07020D, 0x7F07020F};  // id:setting_custom_speed_view1_dis
        this.U = new int[]{0x7F0701F0, 0x7F0701F2, 0x7F0701F4, 0x7F0701F6, 0x7F0701F8, 0x7F0701FA, 0x7F0701FC, 0x7F0701FE, 0x7F070200, 0x7F0701E3, 0x7F0701E5, 0x7F0701E7, 0x7F0701E9, 0x7F0701EB, 0x7F0701ED, 0x7F0701EF};  // id:setting_custom_resistance_view1_dis
        this.V = new int[]{0x7F0701D0, 0x7F0701D2, 0x7F0701D4, 0x7F0701D6, 0x7F0701D8, 0x7F0701DA, 0x7F0701DC, 0x7F0701DE, 0x7F0701E0, 0x7F0701C3, 0x7F0701C5, 0x7F0701C7, 0x7F0701C9, 0x7F0701CB, 0x7F0701CD, 0x7F0701CF};  // id:setting_custom_incline_view1_dis
        this.X = 0;
        this.Y = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        this.Z = new float[]{0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f};
        this.aa = false;
        this.ab = 1;
        this.ac = 1;
        this.ad = false;
        this.ae = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg2, Intent arg3) {
                String v2 = arg3.getAction();
                if(v2.equals("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS")) {
                    int v2_1 = AppsRunner.get(AppsSettingCustomEditActivity.this.getApplicationContext()).l(AppsSettingCustomEditActivity.this.getApplicationContext());
                    if(AppsSettingCustomEditActivity.a(AppsSettingCustomEditActivity.this) != v2_1) {
                        AppsSettingCustomEditActivity.this.a(v2_1);
                        return;
                    }
                }
                else {
                    if(v2.equals("NOTIFICATION_DID_SET_CUSTOM")) {
                        AppsSettingCustomEditActivity.this.p();
                        AppsSettingCustomEditActivity.this.A();
                        return;
                    }

                    if(v2.equals("NOTIFICATION_DIDCONNECT")) {
                        if(AppsSettingCustomEditActivity.b(AppsSettingCustomEditActivity.this)) {
                            AppsSettingCustomEditActivity.c(AppsSettingCustomEditActivity.this);
                            return;
                        }
                    }
                    else if(v2.equals("NOTIFICATION_DISCONNECT")) {
                        if(AppsSettingCustomEditActivity.b(AppsSettingCustomEditActivity.this)) {
                            AppsSettingCustomEditActivity.this.b(true);
                            return;
                        }
                    }
                    else if(v2.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                        if(AppsSettingCustomEditActivity.b(AppsSettingCustomEditActivity.this)) {
                            AppsSettingCustomEditActivity.this.b(false);
                            AppsSettingCustomEditActivity.this.j.removeMessages(0x6F);
                            Intent v2_2 = AppsSettingCustomEditActivity.this.getIntent();
                            v2_2.putExtra("isBack", "1");
                            AppsSettingCustomEditActivity.this.setResult(-1, v2_2);
                            AppsSettingCustomEditActivity.this.finish();
                            return;
                        }
                    }
                    else if(v2.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                        AppsSettingCustomEditActivity.this.j.removeMessages(0x6F);
                    }
                }
            }
        };
        this.af = 0;
        this.ag = 0;
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x2B67) {
                    AppsSettingCustomEditActivity.this.q();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsSettingCustomEditActivity.this.r();
                    return;
                }

                if(arg3.what == 0x8235) {
                    AppsSettingCustomEditActivity.this.u();
                    return;
                }

                if(arg3.what == 0xAD9C) {
                    AppsSettingCustomEditActivity.this.v();
                }
            }
        };
        this.j = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    Intent v4 = new Intent(AppsSettingCustomEditActivity.this, AppsDeviceListActivity.class);
                    AppsSettingCustomEditActivity.this.startActivity(v4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsSettingCustomEditActivity.this.b(false);
                        }
                    }, 500L);
                }
            }
        };
    }

    public void A() {
        int v5;
        StringBuilder v4;
        String v1_1;
        AppsSettingCustomEditActivity v0 = this;
        int v1 = AppsRunner.get(this).getPref_CurrentUserID(v0);
        int v2 = (int)d.a(v0.s.getText().toString(), 1);
        if(v0.X == 0) {
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
        v1_2.putExtra("type", v0.X == 0 ? "TIME" : "DISTANCE");
        int v6 = 0;
        float v7 = 0.0f;
        float v8 = 0.0f;
        float v9 = 0.0f;
        while(true) {
            AppsMeterView[] v10 = v0.E;
            if(v6 >= v10.length) {
                break;
            }

            AppsMeterView v7_1 = v10[v6];
            AppsMeterView v8_1 = v0.F[v6];
            AppsMeterView v9_1 = v0.G[v6];
            AppsMeterView v10_1 = v0.H[v6];
            AppsMeterView v11 = v0.I[v6];
            AppsMeterView v12 = v0.J[v6];
            double v13 = d.a(v7_1.a.j, 1);
            double v4_1 = d.a(v8_1.a.j, 1);
            double v8_2 = d.a(v9_1.a.j, 1);
            double v7_2 = d.a(v10_1.a.j, 1);
            double v9_2 = d.a(v11.a.j, 1);
            double v11_1 = d.a(v12.a.j, 1);
            j.a("==speedValue" + v6 + "==", v13 + " | " + v7_2);
            ++v6;
            v1_2.putExtra("speed" + v6, v13);
            v1_2.putExtra("resistance" + v6, v4_1);
            v1_2.putExtra("incline" + v6, v8_2);
            v1_2.putExtra("speed_dis" + v6, v7_2);
            v1_2.putExtra("resistance_dis" + v6, v9_2);
            v1_2.putExtra("incline_dis" + v6, v11_1);
            v8 = (float)v7_1.a.d;
            v9 = (float)v8_1.a.d;
            v7 = (float)v9_1.a.d;
            v2 = v2;
        }

        int v22 = v2;
        int v2_1;
        for(v2_1 = 0; v2_1 < v0.Y.length; v2_1 = v4_2) {
            int v4_2 = v2_1 + 1;
            v1_2.putExtra("segmentLength" + v4_2, v0.Y[v2_1]);
            v1_2.putExtra("segmentLengthDis" + v4_2, v0.Z[v2_1]);
        }

        int v2_2 = 0;
        float v3 = 0.0f;
        while(true) {
            float[] v4_3 = v0.Y;
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
            float[] v4_4 = v0.Z;
            if(v2_3 >= v4_4.length || v2_3 >= v5) {
                break;
            }

            v16 += v4_4[v2_3];
            ++v2_3;
        }

        v1_2.putExtra("time", ((int)(v3 * 60.0f)));
        v1_2.putExtra("distance", ((int)(10.0f * v16)));
        v1_2.putExtra("totalSegments", v0.s.getText().toString());
        v1_2.putExtra("totalDistance", v0.q.getText().toString());
        v1_2.putExtra("maxSpeed", v8);
        v1_2.putExtra("maxResistance", v9);
        v1_2.putExtra("maxIncline", v7);
        v1_2.putExtra("doNotSendSelectProgramAfterSaveProgramSuccess", true);
        v0.setResult(-1, v1_2);
        this.finish();
    }

    public void B() {
        double v2_6;
        int v1_5;
        int v1_3;
        ArrayList v8_2;
        b v15_1;
        int v1_2;
        a v10_1;
        double v28;
        double v2_2;
        ArrayList v26;
        ArrayList v25;
        b v15;
        AppsSettingCustomEditActivity v0 = this;
        if(v0.ad) {
            return;
        }

        v0.ad = true;
        ArrayList v2 = new ArrayList();
        ArrayList v3 = new ArrayList();
        boolean v4 = AppsRunner.get(this).inclineSupportsHalfDegree(v0);
        int v5 = AppsRunner.get(this).Y();
        int v6 = AppsRunner.get(this).getPref_CurrentUserID(v0);
        CustomProgram v7 = Factory.customProgram(AppsRunner.get(this).getPref_CurrentUserID(v0), v2, v3);
        v7.d(v6);
        v7.a(v5);
        int v8 = (int)d.a(v0.s.getText().toString(), 1);
        if(v0.X == 0) {
            v7.b(v8);
            v7.c(v0.ac);
        }
        else {
            v7.b(v0.ab);
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
            if(v0.X == 0) {
                if(v14 < v8) {
                    AppsMeterView v9_1 = v0.E[v14];
                    AppsMeterView v10 = v0.F[v14];
                    AppsMeterView v13 = v0.G[v14];
                    v7.getClass();
                    v15 = new b(v7);
                    v25 = v2;
                    v26 = v3;
                    double v2_1 = d.a(v13.a.j, 1);
                    v15.c(((int)v4 ? v2_1 * v19 : v2_1 * v21));
                    if(v4) {
                        v2_2 = d.a(v10.a.j, 1);
                    }
                    else {
                        double v2_3 = d.a(v9_1.a.j, 1);
                        if(v5 == 1) {
                            v2_3 = d.a(Conversions.a(v2_3), 3);
                        }

                        v2_2 = v2_3 * v23;
                    }

                    v15.b(((int)v2_2));
                    v15.a(((int)(v0.Y[v14] * 60.0f)));
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
                v10_1 = new a(v7);
                if(v14 < v0.ac) {
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
                if(v14 < v0.ab) {
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
                    AppsMeterView v2_5 = v0.H[v14];
                    AppsMeterView v3_3 = v0.I[v14];
                    AppsMeterView v8_5 = v0.J[v14];
                    v7.getClass();
                    v10_1 = new a(v7);
                    double v8_6 = d.a(v8_5.a.j, 1);
                    v10_1.c(((int)v4 ? v8_6 * v19 : v8_6 * v21));
                    if(v4) {
                        v2_6 = d.a(v3_3.a.j, 1);
                    }
                    else {
                        double v2_7 = d.a(v2_5.a.j, 1);
                        if(v5 == 1) {
                            v2_7 = d.a(Conversions.a(v2_7), 3);
                        }

                        v2_6 = v2_7 * v23;
                    }

                    v10_1.b(((int)v2_6));
                    v10_1.a(((int)(v0.Z[v14] * 1000.0f)));
                }
                else {
                    v7.getClass();
                    v10_1 = new a(v7);
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

        j.a("===setCustomCRC.segmentType===", v0.X + " |");
        j.a("===setCustomCRC.userSlot===", v7.getUserId() + " |");
        j.a("===setCustomCRC.unit===", v7.getUnit() + " |");
        j.a("===setCustomCRC.timeSegment===", v7.getTimeSegmentNumber() + " |");
        j.a("===setCustomCRC.distanceSegment===", v7.getDistanceSegmentNumber() + " |");
        j.a("===setCustomCRC.setCustomProgram===", v2 + " | " + v3);
        j.a("===setCustomCRC.setCustomProgram2===", v7 + " |");
        BLEManager.get(this).maybe_send_message2(DeviceCommand.setCustomProgramMsg(v7), 2, 4000);
        new Handler().postDelayed(() -> {
            AppsSettingCustomEditActivity.this.ad = false;
            return false;
        }, 1000L);

        class com.xtremeprog.shell.treadmillv2.activity.AppsSettingCustomEditActivity.3 implements Runnable {
            @Override
            public void run() {
                AppsSettingCustomEditActivity.a(AppsSettingCustomEditActivity.this, false);
            }
        }

    }

    private void C() {
        boolean v0 = AppsRunner.get(this).inclineSupportsHalfDegree(this);
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        if(v0) {
            this.y.setVisibility(8);
            this.z.setVisibility(8);
            if(this.X == 0) {
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
            if(this.X == 0) {
                this.y.setVisibility(0);
                this.z.setVisibility(8);
            }
            else {
                this.y.setVisibility(8);
                this.z.setVisibility(0);
            }
        }

        if(this.X == 0) {
            this.A.setVisibility(0);
            this.B.setVisibility(8);
            return;
        }

        this.A.setVisibility(8);
        this.B.setVisibility(0);
    }

    private void D() {
        double v11;
        int v9;
        StringBuilder v7;
        Button v6;
        int v5;
        Resources v4;
        TextView v3;
        AppsSettingCustomEditActivity v0 = this;
        this.b();
        v0.k = n.a().a(v0, 0x7F0700C8, v0);  // id:homeButton
        v0.l = n.a().a(v0, 0x7F0700C9, v0);  // id:homeButton2
        v0.m = n.a().a(v0, 0x7F070078, v0);  // id:customTimeButton
        v0.n = n.a().a(v0, 0x7F07004F, v0);  // id:customDistanceButton
        v0.o = n.a().a(v0, 0x7F07019F, v0);  // id:saveButton
        v0.r = n.a().a(v0, 0x7F070080);  // id:customTotalSegmentsButton
        v0.p = n.a().a(v0, 0x7F070081);  // id:customTotalTimeButton
        v0.q = n.a().a(v0, 0x7F07007B);  // id:customTotalDistanceButton
        v0.w = n.a().e(v0, 0x7F07028A);  // id:timeUnitTextView
        v0.x = n.a().e(v0, 0x7F070096);  // id:distanceUnitTextView
        v0.ah = n.a().c(v0, 0x7F070176);  // id:noBluetoothLayout
        int v1 = AppsRunner.get(this).Y();
        if(v1 == 1) {
            v3 = v0.x;
            v4 = this.getResources();
            v5 = 0x7F0B007A;  // string:STR_KM "km"
        }
        else {
            v3 = v0.x;
            v4 = this.getResources();
            v5 = 0x7F0B0085;  // string:STR_MILES "Miles"
        }

        v3.setText(v4.getString(v5));
        v0.u = n.a().b(v0, 0x7F070297);  // id:totalTimeLayout
        v0.v = n.a().b(v0, 0x7F070296);  // id:totalDistanceLayout
        v0.K = n.a().a(v0, 0x7F07006E, v0);  // id:customSegmentNumberLeftButton
        v0.L = n.a().a(v0, 0x7F07006F, v0);  // id:customSegmentNumberRightButton
        v0.M = n.a().a(v0, 0x7F07006B, v0);  // id:customSegmentLengthLeftButton
        v0.N = n.a().a(v0, 0x7F07006C, v0);  // id:customSegmentLengthRightButton
        v0.t = n.a().e(v0, 0x7F07006D);  // id:customSegmentLengthTextView
        v0.s = n.a().e(v0, 0x7F070070);  // id:customSegmentNumberTextView
        v0.y = n.a().b(v0, 0x7F070072);  // id:customSpeedMeterViewLayout
        v0.z = n.a().b(v0, 0x7F070073);  // id:customSpeedMeterViewLayout_dis
        v0.C = n.a().b(v0, 0x7F070066);  // id:customResistanceMeterViewLayout
        v0.D = n.a().b(v0, 0x7F070067);  // id:customResistanceMeterViewLayout_dis
        v0.A = n.a().b(v0, 0x7F070063);  // id:customInclineMeterViewLayout
        v0.B = n.a().b(v0, 0x7F070064);  // id:customInclineMeterViewLayout_dis
        v0.E = new AppsMeterView[16];
        v0.F = new AppsMeterView[16];
        v0.G = new AppsMeterView[16];
        v0.H = new AppsMeterView[16];
        v0.I = new AppsMeterView[16];
        v0.J = new AppsMeterView[16];
        int v5_1;
        for(v5_1 = 0; v5_1 < v0.E.length; ++v5_1) {
            v0.E[v5_1] = (AppsMeterView)n.a().g(v0, v0.Q[v5_1]);
        }

        int v5_2;
        for(v5_2 = 0; v5_2 < v0.F.length; ++v5_2) {
            v0.F[v5_2] = (AppsMeterView)n.a().g(v0, v0.R[v5_2]);
        }

        int v5_3;
        for(v5_3 = 0; v5_3 < v0.G.length; ++v5_3) {
            v0.G[v5_3] = (AppsMeterView)n.a().g(v0, v0.S[v5_3]);
        }

        int v5_4;
        for(v5_4 = 0; v5_4 < v0.H.length; ++v5_4) {
            v0.H[v5_4] = (AppsMeterView)n.a().g(v0, v0.T[v5_4]);
        }

        int v5_5;
        for(v5_5 = 0; v5_5 < v0.I.length; ++v5_5) {
            v0.I[v5_5] = (AppsMeterView)n.a().g(v0, v0.U[v5_5]);
        }

        int v5_6;
        for(v5_6 = 0; v5_6 < v0.J.length; ++v5_6) {
            v0.J[v5_6] = (AppsMeterView)n.a().g(v0, v0.V[v5_6]);
        }

        int v5_7 = AppsRunner.get(this).l(v0);
        v0.W = v5_7;
        v0.a(v5_7);
        v0.O = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        v0.P = new String[]{"0.0", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0", "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.0", "8.5", "9.0", "9.5", "10.0"};
        if(v0.X == 0) {
            v0.m.setEnabled(false);
            v0.n.setEnabled(true);
            v0.m.setBackgroundResource(0x7F060116);  // drawable:pad_data_display_l3
            v0.n.setBackgroundResource(0x7F060114);  // drawable:pad_data_display_l
            this.y();
        }
        else {
            v0.m.setEnabled(true);
            v0.n.setEnabled(false);
            v0.m.setBackgroundResource(0x7F060114);  // drawable:pad_data_display_l
            v0.n.setBackgroundResource(0x7F060116);  // drawable:pad_data_display_l3
            this.z();
        }

        int v5_8 = AppsRunner.get(this).getPref_CurrentUserID(v0);
        v0.ab = 1;
        v0.ac = 1;
        v0.ab = (int)(((Integer)ContextSharedPreferences.SharedPreferences(v0, v5_8 + "_maxSegment", Integer.valueOf(1), 1)));
        v0.ac = (int)(((Integer)ContextSharedPreferences.SharedPreferences(v0, v5_8 + "_maxSegmentDis", Integer.valueOf(1), 1)));
        if(v0.ab <= 0) {
            v0.ab = 1;
        }

        if(v0.ac <= 0) {
            v0.ac = 1;
        }

        if(v0.X == 0) {
            v6 = v0.r;
            v7 = new StringBuilder();
            v9 = v0.ab;
        }
        else {
            v6 = v0.r;
            v7 = new StringBuilder();
            v9 = v0.ac;
        }

        v7.append(v9);
        v7.append("");
        v6.setText(v7.toString());
        j.a("_maxSegment_2", v0.ab + " |");
        j.a("_maxSegmentDis_2", v0.ac + " |");
        j.a("customTotalSegmentsButton_2", v0.r.getText() + " |");
        int v6_1 = 0;
        while(true) {
            v11 = 12.0;
            if(v6_1 >= v0.ab) {
                break;
            }

            int v14 = v6_1 + 1;
            double v3_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v5_8 + "_speed_" + v14, Float.valueOf(0.5f), 3)))));
            if(v1 == 0 && v3_1 > v11) {
                v3_1 = v11;
            }

            if(v1 == 1) {
                v3_1 = Conversions.b(v3_1);
            }

            double v11_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v5_8 + "_incline_" + v14, Float.valueOf(0.0f), 3)))));
            double v2 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v5_8 + "_resistance_" + v14, Float.valueOf(1.0f), 3)))));
            double v8 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v5_8 + "_incline_dis_" + v14, Float.valueOf(0.0f), 3)))));
            float v4_1 = (float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v5_8 + "_segmentLength_" + v14, Float.valueOf(1.0f), 3)));
            v0.Y[v6_1] = v4_1;
            AppsMeterView v10 = v0.E[v6_1];
            AppsMeterView v7_1 = v0.G[v6_1];
            AppsMeterView v15 = v0.F[v6_1];
            AppsMeterView v13 = v0.J[v6_1];
            float v20 = v4_1;
            int v19 = v5_8;
            v10.setCurrentValue(((float)v3_1));
            v7_1.setCurrentValue(((float)v11_1));
            v15.setCurrentValue(((float)v2));
            v13.setCurrentValue(((float)v8));
            if(v0.X == 0 && v6_1 == 0) {
                v0.t.setText(d.doubleToStr(v20, 1));
            }

            v6_1 = v14;
            v5_8 = v19;
        }

        int v19_1 = v5_8;
        int v2_1 = 0;
        while(v2_1 < v0.ac) {
            int v4_2 = v19_1;
            int v5_9 = v2_1 + 1;
            double v8_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4_2 + "_speed_dis_" + v5_9, Float.valueOf(0.5f), 3)))));
            if(v1 == 0 && v8_1 > v11) {
                v8_1 = v11;
            }

            if(v1 == 1) {
                v8_1 = Conversions.b(v8_1);
            }

            double v13_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4_2 + "_incline_dis_" + v5_9, Float.valueOf(0.0f), 3)))));
            double v10_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4_2 + "_resistance_dis_" + v5_9, Float.valueOf(1.0f), 3)))));
            float v3_2 = (float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4_2 + "_segmentLengthDis_" + v5_9, Float.valueOf(0.1f), 3)));
            v0.Z[v2_1] = v3_2;
            AppsMeterView v12 = v0.H[v2_1];
            AppsMeterView v6_2 = v0.J[v2_1];
            AppsMeterView v7_2 = v0.I[v2_1];
            v12.setCurrentValue(((float)v8_1));
            v6_2.setCurrentValue(((float)v13_1));
            v7_2.setCurrentValue(((float)v10_1));
            if(v0.X == 1 && v2_1 == 0) {
                v0.t.setText(d.doubleToStr(v3_2, 1));
            }

            v19_1 = v4_2;
            v2_1 = v5_9;
            v11 = 12.0;
        }

        this.n();
        this.m();
        if(v0.X == 0) {
            v0.m.setVisibility(0);
            v0.n.setVisibility(8);
            return;
        }

        v0.m.setVisibility(8);
        v0.n.setVisibility(0);
    }

    static int a(AppsSettingCustomEditActivity arg0) {
        return arg0.W;
    }

    public void a(int arg13) {
        int v0 = AppsRunner.get(this).k(this);
        int v1 = 0;
        int v2;
        for(v2 = 0; true; ++v2) {
            AppsMeterView[] v3 = this.E;
            if(v2 >= v3.length) {
                break;
            }

            v3[v2].a(0x7F0B00D8, v0, arg13, 13);  // string:STR_TITLE_SPEED "Speed"
        }

        int v2_1;
        for(v2_1 = 0; true; ++v2_1) {
            AppsMeterView[] v3_1 = this.F;
            if(v2_1 >= v3_1.length) {
                break;
            }

            v3_1[v2_1].a(0x7F0B00D6, v0, arg13, 25);  // string:STR_TITLE_RESISTENCE "Resistance"
            this.F[v2_1].setTitleViewLines(1);
        }

        int v2_2;
        for(v2_2 = 0; true; ++v2_2) {
            AppsMeterView[] v3_2 = this.G;
            if(v2_2 >= v3_2.length) {
                break;
            }

            v3_2[v2_2].a(0x7F0B00D2, v0, arg13, 14);  // string:STR_TITLE_INCLINE "Incline"
        }

        int v2_3;
        for(v2_3 = 0; true; ++v2_3) {
            AppsMeterView[] v3_3 = this.H;
            if(v2_3 >= v3_3.length) {
                break;
            }

            v3_3[v2_3].a(0x7F0B00D8, v0, arg13, 13);  // string:STR_TITLE_SPEED "Speed"
        }

        int v2_4;
        for(v2_4 = 0; true; ++v2_4) {
            AppsMeterView[] v3_4 = this.I;
            if(v2_4 >= v3_4.length) {
                break;
            }

            v3_4[v2_4].a(0x7F0B00D6, v0, arg13, 25);  // string:STR_TITLE_RESISTENCE "Resistance"
            this.I[v2_4].setTitleViewLines(1);
        }

        while(true) {
            AppsMeterView[] v2_5 = this.J;
            if(v1 >= v2_5.length) {
                return;
            }

            v2_5[v1].a(0x7F0B00D2, v0, arg13, 14);  // string:STR_TITLE_INCLINE "Incline"
            ++v1;
        }
    }

    public void a(boolean arg2) {
        if(!arg2) {
            goto label_38;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS");
            this.registerReceiver(this.ae, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DID_SET_CUSTOM");
            this.registerReceiver(this.ae, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.ae, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.ae, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.ae, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.ae, v2_6);
            return;
        label_38:
            this.unregisterReceiver(this.ae);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static boolean b(AppsSettingCustomEditActivity arg0) {
        return arg0.aa;
    }

    public void b(boolean arg4) {
        j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)arg4))));
        if(arg4) {
            this.ah.setVisibility(0);
            this.j.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.j.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.ah.setVisibility(8);
        this.j.removeMessages(0x6F);
    }

    static void c(AppsSettingCustomEditActivity arg0) {
        arg0.C();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        int v2;
        Resources v1;
        TextView v0;
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        n.a().e(this, 0x7F070078).setText(this.getResources().getString(0x7F0B00CD));  // id:customTimeButton
        n.a().e(this, 0x7F07004F).setText(this.getResources().getString(0x7F0B0037));  // id:customDistanceButton
        n.a().e(this, 0x7F0701A1).setText(this.getResources().getString(0x7F0B00B8));  // id:saveTextView
        n.a().e(this, 0x7F07028D).setText(this.getResources().getString(0x7F0B008A));  // id:titleTextView
        n.a().e(this, 0x7F0702DC).setText(this.getResources().getString(0x7F0B00DF));  // id:tv_total_segment
        n.a().e(this, 0x7F0702DD).setText(this.getResources().getString(0x7F0B00E1));  // id:tv_total_time
        n.a().e(this, 0x7F0702DB).setText(this.getResources().getString(0x7F0B00DD));  // id:tv_total_distance
        n.a().e(this, 0x7F0702BF).setText(this.getResources().getString(0x7F0B002E));  // id:tv_step1
        n.a().e(this, 0x7F0702C0).setText(this.getResources().getString(0x7F0B002F));  // id:tv_step2
        n.a().e(this, 0x7F0702C1).setText(this.getResources().getString(0x7F0B0030));  // id:tv_step3
        n.a().e(this, 0x7F070074).setText(this.getResources().getString(0x7F0B0032));  // id:customStep4TipTextView1
        n.a().e(this, 0x7F070075).setText(this.getResources().getString(0x7F0B0032));  // id:customStep4TipTextView1_dis
        n.a().e(this, 0x7F070076).setText(this.getResources().getString(0x7F0B0031));  // id:customStep4TipTextView2
        n.a().e(this, 0x7F070077).setText(this.getResources().getString(0x7F0B0031));  // id:customStep4TipTextView2_dis
        n.a().e(this, 0x7F07028A).setText(this.getResources().getString(0x7F0B0086));  // id:timeUnitTextView
        if(AppsRunner.get(this).Y() == 1) {
            v0 = this.x;
            v1 = this.getResources();
            v2 = 0x7F0B007A;  // string:STR_KM "km"
        }
        else {
            v0 = this.x;
            v1 = this.getResources();
            v2 = 0x7F0B0085;  // string:STR_MILES "Miles"
        }

        v0.setText(v1.getString(v2));
        int v0_1 = 0;
        int v1_1;
        for(v1_1 = 0; v1_1 < this.E.length; ++v1_1) {
            ((AppsMeterView)n.a().g(this, this.Q[v1_1])).a();
        }

        int v1_2;
        for(v1_2 = 0; v1_2 < this.F.length; ++v1_2) {
            ((AppsMeterView)n.a().g(this, this.R[v1_2])).a();
        }

        int v1_3;
        for(v1_3 = 0; v1_3 < this.G.length; ++v1_3) {
            ((AppsMeterView)n.a().g(this, this.S[v1_3])).a();
        }

        int v1_4;
        for(v1_4 = 0; v1_4 < this.H.length; ++v1_4) {
            ((AppsMeterView)n.a().g(this, this.T[v1_4])).a();
        }

        int v1_5;
        for(v1_5 = 0; v1_5 < this.I.length; ++v1_5) {
            ((AppsMeterView)n.a().g(this, this.U[v1_5])).a();
        }

        while(v0_1 < this.J.length) {
            ((AppsMeterView)n.a().g(this, this.V[v0_1])).a();
            ++v0_1;
        }
    }

    public void l() {
        AppsSettingCustomEditActivity v0 = this;
        int v1 = AppsRunner.get(this).Y();
        int v4 = AppsRunner.get(this).getPref_CurrentUserID(v0);
        int v5 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(v0, v4 + "_maxSegment", Integer.valueOf(1), 1)));
        int v6 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(v0, v4 + "_maxSegmentDis", Integer.valueOf(1), 1)));
        j.a("_maxSegment_1", v5 + " |");
        j.a("_maxSegmentDis_1", v6 + " |");
        j.a("customTotalSegmentsButton_1", v0.r.getText() + " |");
        if(v5 <= 0) {
            v5 = 1;
        }

        int v6_1;
        for(v6_1 = 0; v6_1 < v5; v6_1 = v8) {
            int v8 = v6_1 + 1;
            double v11 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4 + "_speed_" + v8, Float.valueOf(0.5f), 3)))));
            double v13 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4 + "_speed_dis_" + v8, Float.valueOf(0.5f), 3)))));
            double v15 = 12.0;
            if(v1 == 0) {
                if(v11 > v15) {
                    v11 = v15;
                }

                if(v13 > v15) {
                    v13 = v15;
                }
            }

            if(v1 == 1) {
                v11 = Conversions.b(v11);
                v13 = Conversions.b(v13);
            }

            double v2 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4 + "_incline_" + v8, Float.valueOf(0.0f), 3)))));
            double v10 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4 + "_resistance_" + v8, Float.valueOf(1.0f), 3)))));
            double v9 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4 + "_incline_dis_" + v8, Float.valueOf(0.0f), 3)))));
            double v11_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4 + "_resistance_dis_" + v8, Float.valueOf(1.0f), 3)))));
            AppsMeterView v7 = v0.E[v6_1];
            AppsMeterView v15_1 = v0.G[v6_1];
            AppsMeterView v1_1 = v0.F[v6_1];
            AppsMeterView v4_1 = v0.H[v6_1];
            AppsMeterView v5_1 = v0.J[v6_1];
            AppsMeterView v6_2 = v0.I[v6_1];
            v7.setCurrentValue(((float)v11));
            v15_1.setCurrentValue(((float)v2));
            v1_1.setCurrentValue(((float)v10));
            v4_1.setCurrentValue(((float)v13));
            v5_1.setCurrentValue(((float)v9));
            v6_2.setCurrentValue(((float)v11_1));
            v1 = v1;
            v4 = v4;
            v5 = v5;
        }
    }

    public void m() {
        if(this.X == 0) {
            this.u.setVisibility(0);
            this.v.setVisibility(8);
            this.w.setVisibility(0);
            this.x.setVisibility(8);
        }
        else {
            this.u.setVisibility(8);
            this.v.setVisibility(0);
            this.w.setVisibility(8);
            this.x.setVisibility(0);
        }

        this.y();
        this.z();
    }

    public void n() {
        AppsMeterView v3_2;
        AppsMeterView v3_1;
        boolean v0 = AppsRunner.get(this).inclineSupportsHalfDegree(this);
        int v2;
        for(v2 = 0; true; ++v2) {
            AppsMeterView[] v3 = this.E;
            if(v2 >= v3.length) {
                return;
            }

            if(this.X == 0) {
                if(v2 == this.af) {
                    if(v0) {
                        this.F[v2].setVisibility(0);
                        v3_1 = this.E[v2];
                    }
                    else {
                        v3[v2].setVisibility(0);
                        v3_1 = this.F[v2];
                    }

                    v3_1.setVisibility(8);
                    this.G[v2].setVisibility(0);
                }
                else {
                    this.F[v2].setVisibility(8);
                    this.E[v2].setVisibility(8);
                    this.G[v2].setVisibility(8);
                }
            }
            else if(v2 == this.af) {
                if(v0) {
                    this.I[v2].setVisibility(0);
                    v3_2 = this.H[v2];
                }
                else {
                    this.H[v2].setVisibility(0);
                    v3_2 = this.I[v2];
                }

                v3_2.setVisibility(8);
                this.J[v2].setVisibility(0);
            }
            else {
                this.I[v2].setVisibility(8);
                this.H[v2].setVisibility(8);
                this.J[v2].setVisibility(8);
            }
        }
    }

    public void o() {
        StringBuilder v2;
        TextView v1;
        float v0;
        this.W = AppsRunner.get(this).l(this);
        if(this.X == 0) {
            this.af = 0;
            v0 = this.Y[this.af];
            this.Y = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
            v1 = this.s;
            v2 = new StringBuilder();
        }
        else {
            this.af = 0;
            v0 = this.Z[this.af];
            this.Z = new float[]{0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f};
            v1 = this.s;
            v2 = new StringBuilder();
        }

        v2.append(this.af + 1);
        v2.append("");
        v1.setText(v2.toString());
        this.t.setText(d.doubleToStr(v0, 1));
        this.r.setText(this.t.getText().toString());
        this.m();
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
        this.a(0x7F09003E, 0x7F09003F, 0x7F090040);  // layout:activity_setting_custom_edit
        if(this.getIntent().getExtras() != null && this.getIntent().getExtras().get("segmentType") != null) {
            this.X = (int)(((Integer)this.getIntent().getExtras().get("segmentType")));
        }

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
        this.aa = true;
        AppsRunner.get(this).b(this);
        this.C();
        this.n();
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
        this.aa = false;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg6, MotionEvent arg7) {
        if(arg7.getAction() == 0) {
            if(arg6 != this.k && arg6 != this.l) {
                Button v0 = this.m;
                if(arg6 == v0) {
                    this.X = 0;
                    v0.setEnabled(false);
                    this.n.setEnabled(true);
                    this.C();
                    this.m();
                    this.o();
                    this.n();
                    this.l();
                    this.t.setText(d.doubleToStr(this.X == 0 ? this.Y[this.af] : this.Z[this.af], 1));
                }
                else if(arg6 == this.n) {
                    this.X = 1;
                    v0.setEnabled(true);
                    this.n.setEnabled(false);
                    this.C();
                    this.m();
                    this.o();
                    this.n();
                    this.l();
                    if(this.X == 0) {
                        this.t.setText(d.doubleToStr(this.Y[this.af], 1));
                    }
                    else {
                        this.t.setText(d.doubleToStr(this.Z[this.af], 1));
                    }
                }
                else if(arg6 == this.o) {
                    this.a(this, "");
                    this.B();
                }
            }
            else {
                if(arg6 == this.l) {
                    this.j.removeMessages(0x6F);
                    ((AppsApplication)this.getApplication()).h(true);
                }

                Intent v0_1 = this.getIntent();
                v0_1.putExtra("isBack", "1");
                this.setResult(-1, v0_1);
                this.finish();
            }
        }

        if(arg7.getAction() == 0) {
            if(arg6 == this.K) {
                this.r();
                return true;
            }

            if(arg6 == this.L) {
                this.q();
                return true;
            }

            if(arg6 == this.M) {
                this.v();
                return true;
            }

            if(arg6 == this.N) {
                this.u();
                return true;
            }
        }
        else if(arg7.getAction() == 1 || arg7.getAction() == 3) {
            if(arg6 == this.K) {
                this.t();
                return true;
            }

            if(arg6 == this.L) {
                this.s();
                return true;
            }

            if(arg6 == this.M) {
                this.x();
                return true;
            }

            if(arg6 == this.N) {
                this.w();
            }
        }

        return true;
    }

    public void p() {
        this.f();
    }

    public void q() {
        ++this.af;
        String[] v2 = this.O;
        if(this.af > v2.length - 1) {
            this.af = v2.length - 1;
        }

        String v0 = this.O[this.af];
        this.s.setText(v0);
        int v0_1 = (int)d.a(v0, 1);
        if(this.X == 0) {
            if(v0_1 > this.ab) {
                this.ab = v0_1;
            }
        }
        else if(v0_1 > this.ac) {
            this.ac = v0_1;
        }

        if(this.X == 0) {
            this.t.setText(d.doubleToStr(this.Y[this.af], 1));
            this.y();
        }
        else {
            this.t.setText(d.doubleToStr(this.Z[this.af], 1));
            this.z();
        }

        this.n();
        this.i.removeMessages(0x2B67);
        Message v0_2 = new Message();
        v0_2.what = 0x2B67;
        this.i.sendMessageDelayed(v0_2, 0xFAL);
    }

    public void r() {
        --this.af;
        if(this.af < 0) {
            this.af = 0;
        }

        this.s.setText(this.O[this.af]);
        if(this.X == 0) {
            this.t.setText(d.doubleToStr(this.Y[this.af], 1));
            this.y();
        }
        else {
            this.t.setText(d.doubleToStr(this.Z[this.af], 1));
            this.z();
        }

        this.n();
        this.i.removeMessages(0x56CE);
        Message v0 = new Message();
        v0.what = 0x56CE;
        this.i.sendMessageDelayed(v0, 0xFAL);
    }

    public void s() {
        this.i.removeMessages(0x2B67);
    }

    public void t() {
        this.i.removeMessages(0x56CE);
    }

    public void u() {
        ++this.ag;
        if(this.ag > this.X == 0 ? this.Y.length : this.Z.length - 1) {
            this.ag = 0;
        }

        this.t.setText(this.P[this.ag]);
        if(this.X == 0) {
            float v0 = this.Y[this.af] + 0.5f;
            if(v0 > 10.0f) {
                v0 = 10.0f;
            }

            if(v0 < 0.5f) {
                v0 = 0.5f;
            }

            this.Y[this.af] = v0;
            this.t.setText(d.doubleToStr(v0, 1));
            this.y();
        }
        else {
            float v0_1 = this.Z[this.af] + 0.1f;
            if(v0_1 > 2.0f) {
                v0_1 = 2.0f;
            }

            if(v0_1 < 0.1f) {
                v0_1 = 0.1f;
            }

            this.Z[this.af] = v0_1;
            this.t.setText(d.doubleToStr(v0_1, 1));
            this.z();
        }

        this.n();
        this.i.removeMessages(0x8235);
        Message v0_2 = new Message();
        v0_2.what = 0x8235;
        this.i.sendMessageDelayed(v0_2, 0xFAL);
    }

    public void v() {
        --this.ag;
        if(this.ag < 0) {
            this.ag = this.X == 0 ? this.Y.length : this.Z.length - 1;
        }

        this.t.setText(this.P[this.ag]);
        if(this.X == 0) {
            float v0 = this.Y[this.af] - 0.5f;
            if(v0 > 10.0f) {
                v0 = 10.0f;
            }

            if(v0 < 0.5f) {
                v0 = 0.5f;
            }

            this.Y[this.af] = v0;
            this.t.setText(d.doubleToStr(v0, 1));
            this.y();
        }
        else {
            float v0_1 = this.Z[this.af] - 0.1f;
            if(v0_1 > 2.0f) {
                v0_1 = 2.0f;
            }

            if(v0_1 < 0.1f) {
                v0_1 = 0.1f;
            }

            this.Z[this.af] = v0_1;
            this.t.setText(d.doubleToStr(v0_1, 1));
            this.z();
        }

        this.i.removeMessages(0xAD9C);
        Message v0_2 = new Message();
        v0_2.what = 0xAD9C;
        this.i.sendMessageDelayed(v0_2, 0xFAL);
    }

    public void w() {
        this.i.removeMessages(0x8235);
    }

    public void x() {
        this.i.removeMessages(0xAD9C);
    }

    public void y() {
        float v2_2;
        Button v1_2;
        String v0_3;
        int v2;
        StringBuilder v1;
        Button v0;
        if(this.X == 0) {
            v0 = this.r;
            v1 = new StringBuilder();
            v2 = this.ab;
        }
        else {
            v0 = this.r;
            v1 = new StringBuilder();
            v2 = this.ac;
        }

        v1.append(v2);
        v1.append("");
        v0.setText(v1.toString());
        float v0_1 = 0.0f;
        int v1_1;
        for(v1_1 = 0; true; ++v1_1) {
            float[] v2_1 = this.Y;
            if(v1_1 >= v2_1.length || v1_1 >= this.ab) {
                break;
            }

            v0_1 += v2_1[v1_1];
        }

        int v0_2 = (int)(v0_1 * 60.0f);
        if(d.d(v0_2) > 0) {
            v0_3 = d.a(v0_2);
            v1_2 = this.p;
            v2_2 = 14.0f;
        }
        else {
            v0_3 = d.c(v0_2 + "");
            v1_2 = this.p;
            v2_2 = 18.0f;
        }

        v1_2.setTextSize(v2_2);
        this.p.setText(v0_3);
    }

    public void z() {
        int v2;
        StringBuilder v1;
        Button v0;
        if(this.X == 0) {
            v0 = this.r;
            v1 = new StringBuilder();
            v2 = this.ab;
        }
        else {
            v0 = this.r;
            v1 = new StringBuilder();
            v2 = this.ac;
        }

        v1.append(v2);
        v1.append("");
        v0.setText(v1.toString());
        float v0_1 = 0.0f;
        int v1_1;
        for(v1_1 = 0; true; ++v1_1) {
            float[] v2_1 = this.Z;
            if(v1_1 >= v2_1.length || v1_1 >= this.ac) {
                break;
            }

            v0_1 += v2_1[v1_1];
        }

        this.q.setText(d.doubleToStr(v0_1, 1));
    }
}
