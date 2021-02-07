package com.xtremeprog.shell.treadmillv2.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import apps.activity.base.AppsRootActivity;
import apps.c.ContextSharedPreferences;
import apps.c.f;
import apps.c.j;
import apps.c.k;
import apps.c.m;
import apps.c.n;
import apps.c.o;
import apps.database.c;
import apps.database.entity.SummaryArticle;
import apps.views.d;
import apps.vo.AppsArticle;
import com.xpg.a.a.StopWorkoutInfo;
import com.xpg.a.a.WorkoutListMember;
import com.xpg.a.b.CustomProgram.b;
import com.xpg.a.b.CustomProgram;
import com.xpg.a.b.DeviceCommand;
import com.xpg.a.c.Factory;
import com.xpg.b.BLEManager;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import com.xtremeprog.shell.treadmillv2.Conversions;
import com.xtremeprog.shell.treadmillv2.ShareFitness;
import com.xtremeprog.shell.treadmillv2.h;
import com.xtremeprog.shell.treadmillv2.views.AppsMeterView.a;
import com.xtremeprog.shell.treadmillv2.views.AppsMeterView;
import com.xtremeprog.shell.treadmillv2.views.AppsRunningView;
import com.xtremeprog.shell.treadmillv2.views.SprintLevelView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AppsSettingActivity extends AppsRootActivity implements View.OnTouchListener, a {
    private RelativeLayout A;
    private RelativeLayout B;
    private RelativeLayout C;
    private Button D;
    private Button E;
    private RelativeLayout F;
    private RelativeLayout G;
    private RelativeLayout H;
    private RelativeLayout I;
    private RelativeLayout J;
    private RelativeLayout K;
    private RelativeLayout L;
    private RelativeLayout M;
    private RelativeLayout N;
    private RelativeLayout O;
    private ImageView P;
    private ImageView Q;
    private ImageView R;
    private ImageView S;
    private ImageView T;
    private ImageView U;
    private ImageView V;
    private ImageView W;
    private ImageView X;
    private ImageView Y;
    private LinearLayout Z;
    private SprintLevelView aA;
    private AppsMeterView aB;
    private AppsMeterView aC;
    private AppsMeterView aD;
    private AppsMeterView aE;
    private AppsMeterView aF;
    private AppsMeterView aG;
    private Button aH;
    private Button aI;
    private int[] aJ;
    private Double[] aK;
    private Double[] aL;
    private TextView aM;
    private TextView aN;
    private AppsMeterView aO;
    private AppsMeterView aP;
    private AppsMeterView aQ;
    private AppsMeterView aR;
    private AppsMeterView aS;
    private AppsMeterView aT;
    private AppsMeterView aU;
    private AppsMeterView aV;
    private AppsMeterView aW;
    private AppsMeterView aX;
    private AppsMeterView myFirst5k_walkSpeed;
    private AppsMeterView myFirst5k_jogSpeed;
    private LinearLayout aa;
    private LinearLayout ab;
    private LinearLayout ac;
    private LinearLayout ad;
    private LinearLayout ae;
    private LinearLayout af;
    private LinearLayout ag;
    private LinearLayout ah;
    private LinearLayout ai;
    private LinearLayout aj;
    private RelativeLayout ak;
    private LinearLayout al;
    private LinearLayout am;
    private LinearLayout an;
    private AppsRunningView ao;
    private AppsRunningView ap;
    private AppsRunningView aq;
    private Button ar;
    private ScrollView as;
    private ScrollView at;
    private TextView au;
    private AppsMeterView av;
    private AppsMeterView aw;
    private TextView ax;
    private TextView ay;
    private TextView az;
    private boolean bA;
    private boolean bB;
    private boolean bC;
    private boolean bD;
    private boolean bE;
    private boolean bF;
    private d bG;
    private Date bH;
    private int bI;
    private BroadcastReceiver bJ;
    private int bK;
    private int bL;
    private RelativeLayout bM;
    private AppsMeterView ba;
    private Button myFirst5k_week;
    private Button myFirst5k_workout;
    private Button bd;
    private Button be;
    private Button bf;
    private Button bg;
    private Button bh;
    private TextView bi;
    private TextView bj;
    private TextView bk;
    private RelativeLayout bl;
    private int bm;
    private Button bn;
    private Button bo;
    private LinearLayout bp;
    private int bq;
    private int br;
    private boolean bs;
    private String bt;
    private boolean bu;
    private StopWorkoutInfo bv;
    private String bw;
    private boolean bx;
    private boolean by;
    private boolean bz;
    int i;
    final Handler j;
    final Handler k;
    final Handler l;
    final Handler m;
    final Handler n;
    final Handler o;
    final Handler p;
    private LinearLayout q;
    private LinearLayout r;
    private Button s;
    private Button t;
    private Button u;
    private Button v;
    private Button w;
    private Button x;
    private TextView y;
    private TextView z;

    public AppsSettingActivity() {
        this.aJ = new int[13];
        this.aK = new Double[13];
        this.aL = new Double[13];
        this.bm = 0;
        this.bq = 0;
        this.br = -1;
        this.bs = false;
        this.bt = null;
        this.bu = false;
        this.bv = null;
        this.bw = null;
        this.bx = true;
        this.by = true;
        this.bz = false;
        this.bA = false;
        this.bB = false;
        this.bC = false;
        this.bD = false;
        this.bE = false;
        this.bF = false;
        this.bG = null;
        this.j = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg5) {
                if(arg5.what == 1) {
                    AppsSettingActivity.this.f();
                    if(!apps.c.d.strNotEmpty(((String)arg5.obj))) {
                        Intent v5 = new Intent(AppsSettingActivity.this, AppsHistoryActivity.class);
                        v5.putExtra("Extra_Key_fromRunning", false);
                        v5.putExtra("Extra_Key_fromAppStop", true);
                        v5.putExtra("Extra_Key_fromRunningDate", f.a(AppsSettingActivity.f(AppsSettingActivity.this), "yyyy-MM-dd HH:mm:ss"));
                        AppsSettingActivity.this.startActivity(v5);
                        AppsSettingActivity.this.finish();
                        return;
                    }

                    AppsRunner.get(AppsSettingActivity.this.getApplicationContext()).clear();
                    com.xtremeprog.shell.treadmillv2.f v5_1 = AppsSettingActivity.g(AppsSettingActivity.this);
                    AppsRunner.get(AppsSettingActivity.this).a(v5_1);
                    AppsSettingActivity.a(AppsSettingActivity.this, true);
                    AppsSettingActivity.a(AppsSettingActivity.this, 0);
                    AppsSettingActivity.this.n();
                    AppsRunner.get(AppsSettingActivity.this).startWorkout();
                }
            }
        };
        this.bH = null;
        this.bI = 0;
        this.bJ = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg7, Intent arg8) {
                long v0;
                Handler v8_2;
                Message v7_6;
                Handler v8_1;
                Message v7_5;
                String v7 = arg8.getAction();
                if(v7.equals("NOTIFICATION_DID_START_WORKOUT")) {
                    j.a("=====已经START WORKOUT了======" + AppsSettingActivity.l(AppsSettingActivity.this), "==========");
                    AppsSettingActivity.this.l.removeMessages(88888);
                    com.xtremeprog.shell.treadmillv2.f v7_1 = AppsSettingActivity.g(AppsSettingActivity.this);
                    AppsRunner.get(AppsSettingActivity.this).a(v7_1);
                    AppsSettingActivity.this.finish();
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS")) {
                    int v7_2 = AppsRunner.get(AppsSettingActivity.this.getApplicationContext()).l(AppsSettingActivity.this.getApplicationContext());
                    if(AppsSettingActivity.m(AppsSettingActivity.this) == v7_2) {
                        return;
                    }

                    AppsSettingActivity.this.a(v7_2);
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_SET_USER_DATA")) {
                    j.a("=====收到USER DATA了，现在可以发START了======" + AppsSettingActivity.l(AppsSettingActivity.this), "==========");
                    if(!AppsSettingActivity.l(AppsSettingActivity.this)) {
                        return;
                    }

                    AppsSettingActivity.this.l.removeMessages(88888);
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_FINISH_KM")) {
                    AppsSettingActivity.b(AppsSettingActivity.this, 5);
                    AppsRunner.get(AppsSettingActivity.this).f(AppsSettingActivity.this, 5);
                    AppsSettingActivity.this.a(false, false);
                    AppsSettingActivity.n(AppsSettingActivity.this).setVisibility(8);
                    AppsSettingActivity.o(AppsSettingActivity.this).setVisibility(0);
                    AppsSettingActivity.p(AppsSettingActivity.this).setVisibility(8);
                    AppsSettingActivity.q(AppsSettingActivity.this).setVisibility(8);
                    AppsSettingActivity.r(AppsSettingActivity.this).setVisibility(4);
                    if(arg8.getExtras() == null || arg8.getExtras().get("Extra_Key_fromRunningDate") == null) {
                        return;
                    }

                    String v8 = (String)arg8.getExtras().get("Extra_Key_fromRunningDate");
                    AppsSettingActivity.a(AppsSettingActivity.this, v8);
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_GET_USER")) {
                    AppsSettingActivity.this.setTextWeekWorkout();
                    return;
                }

                if(v7.equals("NOTIFICATION_DIDCONNECT")) {
                    AppsSettingActivity.s(AppsSettingActivity.this);
                    return;
                }

                if(v7.equals("NOTIFICATION_DISCONNECT")) {
                    if(!AppsSettingActivity.s(AppsSettingActivity.this)) {
                        return;
                    }

                    AppsSettingActivity.this.c(true);
                    return;
                }

                if(v7.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                    if(!AppsSettingActivity.s(AppsSettingActivity.this)) {
                        return;
                    }

                    AppsSettingActivity.this.c(false);
                    AppsSettingActivity.this.n.removeMessages(0x6F);
                    AppsSettingActivity.this.onBackPressed();
                    return;
                }

                if(v7.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                    AppsSettingActivity.this.n.removeMessages(0x6F);
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_GET_SETCUSTOMPROGRAM")) {
                    AppsApplication v7_3 = (AppsApplication)AppsSettingActivity.this.getApplication();
                    j.a("===", "====didSetCustomProgram : " + v7_3.i());
                    if(!v7_3.i()) {
                        return;
                    }

                    AppsSettingActivity.t(AppsSettingActivity.this);
                    AppsSettingActivity.this.o();
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_GET_SETCUSTOMHRPROGRAM")) {
                    AppsApplication v7_4 = (AppsApplication)AppsSettingActivity.this.getApplication();
                    j.a("===", "====didSetCustomHRProgram : " + v7_4.j());
                    if(!v7_4.j()) {
                        return;
                    }

                    AppsSettingActivity.u(AppsSettingActivity.this);
                    AppsSettingActivity.this.b(false);
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_SET_CUSTOM")) {
                    AppsSettingActivity.this.o();
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_SET_CUSTOM_HR")) {
                    AppsSettingActivity.this.b(true);
                    return;
                }

                long v4 = 0L;
                if(v7.equals("NOTIFICATION_DID_SET_MY_FIRST_5K")) {
                    AppsSettingActivity.this.w();
                    j.a("===收到set5K2==", "解锁");
                    AppsSettingActivity.this.o.removeMessages(0x6F);
                    v7_5 = new Message();
                    goto label_229;
                }

                if(v7.equals("NOTIFICATION_DID_DEVICE_SET_CUSTOM_PROGRAM")) {
                    j.a("===收到setCustom2==", "解锁");
                    AppsSettingActivity.this.o.removeMessages(0x6F);
                    v7_5 = new Message();
                label_229:
                    v7_5.what = 0x6F;
                    v8_1 = AppsSettingActivity.this.o;
                    v8_1.sendMessageDelayed(v7_5, v4);
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_DEVICE_SET_CUSTOM_HR_PROGRAM")) {
                    j.a("===收到setHRCustom==", "解锁");
                    AppsSettingActivity.this.p.removeMessages(0xDE);
                    v7_5 = new Message();
                    v7_5.what = 0xDE;
                    v8_1 = AppsSettingActivity.this.p;
                    v8_1.sendMessageDelayed(v7_5, v4);
                    return;
                }

                if(!v7.equals("NOTIFICATION_DID_START_WORKOUT_TIMEOUT") && !v7.equals("NOTIFICATION_DID_START_WORKOUT_FAIL")) {
                    if(v7.equals("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE_BEFORE_SHOW")) {
                        if(!AppsSettingActivity.s(AppsSettingActivity.this)) {
                            return;
                        }

                        AppsSettingActivity.this.onBackPressed();
                        AppsSettingActivity.this.k.removeMessages(0x1B207);
                        v7_6 = new Message();
                        v7_6.what = 0x1B207;
                        v8_2 = AppsSettingActivity.this.k;
                        v0 = 0xFAL;
                    }
                    else {
                        if(!v7.equals("NOTIFICATION_RE_SHOW_LOADING")) {
                            goto label_302;
                        }

                        if(!AppsSettingActivity.s(AppsSettingActivity.this)) {
                            return;
                        }

                        AppsSettingActivity.c(AppsSettingActivity.this, true);
                        AppsSettingActivity.this.a(AppsSettingActivity.this, "", false);
                        AppsSettingActivity.this.o.removeMessages(0x6F);
                        v7_6 = new Message();
                        v7_6.what = 0x6F;
                        v8_2 = AppsSettingActivity.this.o;
                        v0 = 12000L;
                    }

                    v8_2.sendMessageDelayed(v7_6, v0);
                    return;
                label_302:
                    if(!v7.equals("NOTIFICATION_DID_APP_START_WORKOUT") && (v7.equals("NOTIFICATION_DID_SELECT_PROGRAM"))) {
                        int v7_7 = (int)(((Integer)arg8.getExtras().get("responseCode")));
                        j.a("HOME SELECT PROGRAM RESPONSE CODE", v7_7 + " |");
                        if(v7_7 == 0) {
                            AppsSettingActivity.d(AppsSettingActivity.this, false);
                            return;
                        }

                        AppsSettingActivity.d(AppsSettingActivity.this, true);
                    }

                    return;
                }

                AppsSettingActivity.b(AppsSettingActivity.this, false);
            }
        };
        this.k = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                Intent v2 = new Intent();
                v2.setAction("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE_SHOULD_RESHOW");
                AppsSettingActivity.this.getApplicationContext().sendBroadcast(v2);
            }
        };
        this.bK = 0;
        this.l = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                if(arg2.what == 88888) {
                    AppsSettingActivity.this.setUser();
                }
            }
        };
        this.bL = 0;
        this.m = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x2B67) {
                    AppsSettingActivity.this.q();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsSettingActivity.this.r();
                }
            }
        };
        this.n = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    j.a("==SettingActivity==", "==跳DeviceListActivity==");
                    Intent v4 = new Intent(AppsSettingActivity.this, AppsDeviceListActivity.class);
                    v4.putExtra("doNoClearData", ((boolean)AppsSettingActivity.o(AppsSettingActivity.this).getVisibility() == 0 ? 1 : 0));
                    AppsSettingActivity.this.startActivity(v4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsSettingActivity.this.c(false);
                        }
                    }, 500L);
                }
            }
        };
        this.o = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsSettingActivity.c(AppsSettingActivity.this, false);
                AppsSettingActivity.this.g();
                j.a("===delayHandler stopLoading2()===", "===delayHandler stopLoading2()===");
            }
        };
        this.p = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsSettingActivity.g(AppsSettingActivity.this, false);
                AppsSettingActivity.this.g();
                j.a("===delayHandler2 stopLoading2()===", "===delayHandler2 stopLoading2()===");
            }
        };
    }

    public void A() {
        ((AppsApplication)this.getApplication()).get_setcustomhrprogram();
    }

    public void B() {
        ((AppsApplication)this.getApplication()).get_setcustomprogram();
    }

    public void C() {
        int v2 = AppsRunner.get(this).getPref_CurrentUserID(this);
        int v13 = AppsRunner.get(this).ad();
        int v3 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(this, v2 + "_time_hr", Integer.valueOf(600), 1)));
        float v1 = ((float)(((int)(((float)(220 - v13)) * 0.75f)))) * 1.0f;
        int v5 = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_hr_hr_1", Float.valueOf(v1), 3)))));
        int v8 = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_hr_hr_2", Float.valueOf(v1), 3)))));
        int v11 = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_hr_hr_3", Float.valueOf(v1), 3)))));
        int v14 = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_hr_hr_4", Float.valueOf(v1), 3)))));
        int v1_1 = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_segmentLength_hr_1", Float.valueOf(0.5f), 3)))) * 60.0f);
        int v9 = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_segmentLength_hr_2", Float.valueOf(0.5f), 3)))) * 60.0f);
        int v12 = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_segmentLength_hr_3", Float.valueOf(0.5f), 3)))) * 60.0f);
        int v15 = (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_segmentLength_hr_4", Float.valueOf(0.5f), 3)))) * 60.0f);
        j.a("===setCustomHRProgram===", v2 + " | " + v3 + " | " + v13 + " | " + v5 + " | " + v8 + " | " + v11 + " | " + v14 + " | " + v1_1 + " | " + v9 + " | " + v12 + " | " + v15);
        BLEManager.get(this).maybe_send_message2(DeviceCommand.setCustomHRProgramMsg(Factory.a(v2, v3, v13, v5, v1_1, v13, v8, v9, v13, v11, v12, v13, v14, v15)), 2, 4000);
    }

    public void D() {
        double v21;
        double v1_4;
        float v14_2;
        ArrayList v13;
        ArrayList v27;
        float v8_1;
        double v11;
        double v6_1;
        double v19;
        int v23;
        ArrayList v1 = new ArrayList();
        ArrayList v2 = new ArrayList();
        boolean v3 = AppsRunner.get(this).inclineSupportsHalfDegree(this);
        CustomProgram v4 = new CustomProgram();
        int v5 = AppsRunner.get(this).getPref_CurrentUserID(this);
        int v9 = 1;
        Integer v6 = (Integer)ContextSharedPreferences.SharedPreferences(this, v5 + "_saveProgramUnit", Integer.valueOf(0), 1);
        int v8 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(this, v5 + "_maxSegment", Integer.valueOf(1), 1)));
        int v10 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(this, v5 + "_maxSegmentDis", Integer.valueOf(1), 1)));
        if(v8 <= 0) {
            v8 = 1;
        }

        if(v10 > 0) {
            v9 = v10;
        }

        j.a("==app send maxSegment==", v8 + " |");
        j.a("==app send maxSegmentDis==", v9 + " |");
        int v10_1 = 0;
        while(v10_1 < 16) {
            double v16 = 0.0;
            if(v10_1 < v8) {
                int v14 = v10_1 + 1;
                v23 = v8;
                v19 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v5 + "_speed_" + v14, Float.valueOf(0.5f), 3)))));
                v6_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v5 + "_incline_" + v14, Float.valueOf(0.0f), 3)))));
                v11 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v5 + "_resistance_" + v14, Float.valueOf(1.0f), 3)))));
                v8_1 = (float)(((Float)ContextSharedPreferences.SharedPreferences(this, v5 + "_segmentLength_" + v14, Float.valueOf(1.0f), 3)));
            }
            else {
                v23 = v8;
                v6_1 = v16;
                v8_1 = 1.0f;
                v11 = 1.0;
                v19 = 0.5;
            }

            if(v10_1 < v9) {
                int v14_1 = v10_1 + 1;
                v27 = v2;
                v13 = v1;
                double v1_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v5 + "_speed_dis_" + v14_1, Float.valueOf(0.5f), 3)))));
                double v1_2 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v5 + "_incline_dis_" + v14_1, Float.valueOf(0.0f), 3)))));
                double v1_3 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v5 + "_resistance_dis_" + v14_1, Float.valueOf(1.0f), 3)))));
                v14_2 = (float)(((Float)ContextSharedPreferences.SharedPreferences(this, v5 + "_segmentLengthDis_" + v14_1, Float.valueOf(0.1f), 3)));
                v1_4 = v1_3;
                v16 = v1_2;
                v21 = v1_1;
            }
            else {
                v13 = v1;
                v27 = v2;
                v1_4 = v16;
                v14_2 = 0.1f;
                v21 = 0.5;
            }

            v4.getClass();
            b v15 = new b(v4);
            v15.c(((int)v3 ? v6_1 * 5.0 : v6_1 * 10.0));
            if(!v3) {
                v23 = v23;
                v11 = v19 * 1000.0;
            }

            v15.b(((int)v11));
            v15.a(((int)(v8_1 * 60.0f)));
            v13.add(v15);
            v4.getClass();
            com.xpg.a.b.CustomProgram.a v8_2 = new com.xpg.a.b.CustomProgram.a(v4);
            v8_2.c(((int)v3 ? v16 * 5.0 : v16 * 10.0));
            if(!v3) {
                v1_4 = v10_1 >= v9 ? 500.0 : v21 * 1000.0;
            }

            v8_2.b(((int)v1_4));
            v8_2.a(((int)(v14_2 * 1000.0f)));
            v27.add(v8_2);
            ++v10_1;
            v2 = v27;
            v1 = v13;
            v8 = v23;
        }

        CustomProgram v2_1 = Factory.customProgram(AppsRunner.get(this).getPref_CurrentUserID(this), v1, v2);
        v2_1.b(v8);
        v2_1.c(v9);
        v2_1.d(v5);
        v2_1.a(0);
        j.a("===appSetCustomProgram.userSlot===", v2_1.getUserId() + " |");
        j.a("===appSetCustomProgram.unit===", v2_1.getUnit() + " |");
        j.a("===appSetCustomProgram.timeSegment===", v2_1.getTimeSegmentNumber() + " |");
        j.a("===appSetCustomProgram.distanceSegment===", v2_1.getDistanceSegmentNumber() + " |");
        j.a("===appSetCustomProgram.setCustomProgram===", v1 + " | " + v2);
        j.a("===appSetCustomProgram.setCustomProgram2===", v2_1 + " |");
        BLEManager.get(this).maybe_send_message2(DeviceCommand.setCustomProgramMsg(v2_1), 2, 4000);
    }

    public boolean E() {
        if(AppsRunner.get(this).g()) {
            int v0 = AppsRunner.get(this).b();
            if(v0 != 3 && v0 != 11 && v0 != 7 && v0 != 10 && v0 != 5 && v0 != 8) {
                this.L.setAlpha(0.5f);
                this.M.setAlpha(0.5f);
                this.N.setAlpha(0.5f);
                this.O.setAlpha(0.5f);
                this.L.setOnTouchListener(null);
                this.M.setOnTouchListener(null);
                this.N.setOnTouchListener(null);
                this.O.setOnTouchListener(null);
                return false;
            }
        }

        this.L.setAlpha(1.0f);
        this.M.setAlpha(1.0f);
        this.N.setAlpha(1.0f);
        this.O.setAlpha(1.0f);
        this.L.setOnTouchListener(this);
        this.M.setOnTouchListener(this);
        this.N.setOnTouchListener(this);
        this.O.setOnTouchListener(this);
        return true;
    }

    public void F() {
        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        int v1 = AppsRunner.get(this).Y();
        ContextSharedPreferences.SharedPreferencesEditor(this, v0 + "_saveProgramUnit", Integer.valueOf(v1), 1);
        int v1_1 = AppsRunnerConnector.get(this).getCustomCRC(v0 + "", v1);
        AppsRunner.get(this).m(this, v1_1, v0);
    }

    public void G() {
        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        int v1 = AppsRunner.get(this).Y();
        int v2 = AppsRunner.get(this).ad();
        int v1_1 = AppsRunnerConnector.get(this).customHRCRCStra(v0 + "", v1, v2);
        AppsRunner.get(this).n(this, v1_1, v0);
    }

    private void H() {
        String v0 = "";
        int v1 = this.bq;
        if(v1 == 9) {
            v0 = this.getResources().getString(0x7F0B00A0);  // string:STR_MODE_NEW_SPRINTS "Sprint 8"
        }
        else if(v1 == 0) {
            v0 = this.getResources().getString(0x7F0B009A);  // string:STR_MODE_NEW_MANUAL "Manual"
        }
        else if(v1 == 2) {
            v0 = this.getResources().getString(0x7F0B0091);  // string:STR_MODE_NEW_DISTANCE "Distance"
        }
        else if(v1 == 4) {
            v0 = this.getResources().getString(0x7F0B0087);  // string:STR_MODE_NEW_CALORIES "Calories"
        }
        else if(v1 == 6) {
            v0 = this.getResources().getString(0x7F0B0094);  // string:STR_MODE_NEW_FAT_BURN "Fat Burn"
        }
        else if(v1 == 1) {
            v0 = this.getResources().getString(0x7F0B0097);  // string:STR_MODE_NEW_HILL_CLIMB "Hill Climb"
        }
        else if(v1 == 3) {
            v0 = this.getResources().getString(0x7F0B00A3);  // string:STR_MODE_NEW_TARGET_HEART_RATE "Target HR"
        }
        else if(v1 == 5) {
            v0 = this.getResources().getString(0x7F0B009D);  // string:STR_MODE_NEW_MY_FIRST_5KM "My First 5k"
        }
        else if(v1 == 11 || v1 == 7 || v1 == 10) {
            v0 = this.getResources().getString(0x7F0B008A);  // string:STR_MODE_NEW_CUSTOM "Custom"
        }
        else if(v1 == 8) {
            v0 = this.getResources().getString(0x7F0B0090);  // string:STR_MODE_NEW_CUSTOM_HR "Custom HR"
        }

        n.a().e(this, 0x7F07028D).setText(v0);  // id:titleTextView
        n.a().e(this, 0x7F07028E).setText(v0);  // id:titleTextView_2
    }

    private int I() {
        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        int v1 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(this, v0 + "_maxSegment", Integer.valueOf(1), 1)));
        if(v1 <= 0) {
            v1 = 1;
        }

        j.a("==getCustomSettingTime==", v1 + " |");
        int v2 = 0;
        int v3;
        for(v3 = 0; v2 < v1; v3 += (int)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v0 + "_segmentLength_" + v2, Float.valueOf(1.0f), 3)))) * 60.0f)) {
            ++v2;
        }

        return v3;
    }

    private int J() {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(this, AppsRunner.get(this).getPref_CurrentUserID(this) + "_time_hr", Integer.valueOf(600), 1)));
    }

    private void K() {
        int v2_1;
        AppsRunningView v1_1;
        float v7_2;
        float v24;
        int v20_1;
        float v6_1;
        int v0_2;
        int v22_1;
        boolean v21_1;
        float v0_1;
        float v23;
        int v11;
        AppsSettingActivity v0 = this;
        HashMap v1 = new HashMap();
        HashMap v2 = new HashMap();
        HashMap v3 = new HashMap();
        new HashMap();
        int v4 = AppsRunner.get(this).getPref_CurrentUserID(v0);
        boolean v5 = AppsRunner.get(this).inclineSupportsHalfDegree(v0);
        int v6 = AppsRunner.get(this).Y();
        if(v0.bm == 0) {
            int v9 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(v0, v4 + "_maxSegment", Integer.valueOf(1), 1)));
            if(v9 <= 0) {
                v9 = 1;
            }

            j.a("==initCustomLineView maxSegment==", v9 + " |");
            int v10 = 0;
            v11 = 0;
            int v14 = 0;
            while(v10 < v9) {
                int v10_1 = v10 + 1;
                double v12 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4 + "_speed_" + v10_1, Float.valueOf(0.5f), 3)))));
                if(v6 == 0 && v12 > 12.0) {
                    v12 = 12.0;
                }

                if(v6 == 1) {
                    v12 = Conversions.b(v12);
                }

                int v20 = v9;
                double v7 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4 + "_incline_" + v10_1, Float.valueOf(0.0f), 3)))));
                boolean v21 = v5;
                double v5_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4 + "_resistance_" + v10_1, Float.valueOf(1.0f), 3)))));
                int v22 = v6;
                int v16 = v10_1;
                float v9_1 = (float)(((Float)ContextSharedPreferences.SharedPreferences(v0, v4 + "_segmentLength_" + v10_1, Float.valueOf(1.0f), 3)));
                int v10_2 = v14;
                while(true) {
                    v23 = 60.0f * v9_1 * 20.0f;
                    v0_1 = ((float)v14) + v23;
                    if(((float)v10_2) >= v0_1) {
                        break;
                    }

                    ++v10_2;
                    v1.put(Integer.valueOf(v10_2), Double.valueOf(v12));
                    v3.put(Integer.valueOf(v10_2), Double.valueOf(v7));
                    v2.put(Integer.valueOf(v10_2), Double.valueOf(v5_1));
                }

                v11 = (int)(((float)v11) + v23);
                v14 = (int)v0_1;
                v10 = v16;
                v9 = v20;
                v5 = v21;
                v6 = v22;
                v0 = this;
            }

            v21_1 = v5;
            v22_1 = v6;
            v0_2 = v9;
            v6_1 = 0.0f;
            v20_1 = v4;
        }
        else {
            v21_1 = v5;
            v22_1 = v6;
            AppsSettingActivity v7_1 = this;
            int v0_3 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(v7_1, v4 + "_maxSegmentDis", Integer.valueOf(1), 1)));
            int v9_2 = v0_3 > 0 ? v0_3 : 1;
            j.a("==initCustomLineView maxSegmentDis==", v9_2 + " |");
            int v0_4 = 0;
            int v5_2 = 0;
            v6_1 = 0.0f;
            v11 = 0;
            while(v0_4 < v9_2) {
                int v0_5 = v0_4 + 1;
                double v12_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v7_1, v4 + "_speed_dis_" + v0_5, Float.valueOf(0.5f), 3)))));
                if(v22_1 == 0) {
                    double v18 = 12.0;
                    if(v12_1 > v18) {
                        v12_1 = v18;
                    }
                }

                int v8 = v22_1;
                if(v8 == 1) {
                    v12_1 = Conversions.b(v12_1);
                }

                double v14_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v7_1, v4 + "_incline_dis_" + v0_5, Float.valueOf(0.0f), 3)))));
                int v16_1 = v9_2;
                v22_1 = v8;
                double v8_1 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(v7_1, v4 + "_resistance_dis_" + v0_5, Float.valueOf(1.0f), 3)))));
                int v20_2 = v4;
                int v23_1 = v0_5;
                float v4_1 = (float)(((Float)ContextSharedPreferences.SharedPreferences(v7_1, v4 + "_segmentLengthDis_" + v0_5, Float.valueOf(0.1f), 3)));
                int v10_3 = v5_2;
                while(true) {
                    v24 = 200.0f * v4_1 * 20.0f;
                    v7_2 = ((float)v5_2) + v24;
                    if(((float)v10_3) >= v7_2) {
                        break;
                    }

                    ++v10_3;
                    v1.put(Integer.valueOf(v10_3), Double.valueOf(v12_1));
                    v3.put(Integer.valueOf(v10_3), Double.valueOf(v14_1));
                    v2.put(Integer.valueOf(v10_3), Double.valueOf(v8_1));
                }

                v6_1 += v4_1;
                v11 = (int)(((float)v11) + v24);
                v5_2 = (int)v7_2;
                v9_2 = v16_1;
                v4 = v20_2;
                v0_4 = v23_1;
                v7_1 = this;
            }

            v20_1 = v4;
            v0_2 = v9_2;
        }

        boolean v7_3 = v21_1;
        int v8_2 = v22_1;
        AppsSettingActivity v9_3 = this;
        j.a("==initCustomLineView==", ((boolean)(((int)v7_3))) + " |  | " + v20_1 + " | " + v8_2 + " | " + v9_3.bm + " | " + v0_2);
        j.a("==initCustomLineView dataSource==", v1 + " | " + v3 + " | " + v2);
        float v14_2 = v7_3 ? 20.0f : 15.0f;
        float v0_6 = (float)AppsRunner.get(this).W();
        j.a("==initCustomLineView max==", v0_6 + " | " + v14_2 + " | " + 20.0f);
        if(v7_3) {
            v9_3.ao.setFateResistanceDataSource(v2);
        }
        else {
            v9_3.ao.setFateSpeedDataSource(v1);
        }

        v9_3.ao.setFateInclineDataSource(v3);
        v9_3.ao.setFateTotalTime(v11);
        v9_3.ao.setTotalTime(v11);
        v9_3.ao.setCurrentTime(v11);
        if(v9_3.bm == 0) {
            v9_3.ao.setZeroTimeStr("00:00");
            v9_3.ao.setTotalTimeStr(apps.c.d.a(v11 / 20));
        }
        else {
            v9_3.ao.setZeroTimeStr("0");
            v9_3.ao.setTotalTimeStr(apps.c.d.doubleToStr(v6_1, 1) + "");
        }

        if(v8_2 != 1 && !v7_3) {
            v1_1 = v9_3.ao;
            v2_1 = 12;
        }
        else {
            v1_1 = v9_3.ao;
            v2_1 = 15;
        }

        v1_1.setExtraMaxHRDraw(v2_1);
        v9_3.ao.setMaxSpeed(((int)v0_6));
        v9_3.ao.setMaxResistance(20);
        v9_3.ao.setMaxIncline(((int)v14_2));
        v9_3.ao.invalidate();
    }

    private void L() {
        int v4_4;
        AppsRunningView v2_3;
        float v6_1;
        double v30;
        float v5_1;
        float v29;
        float v28;
        int v27;
        int v24;
        double v22;
        HashMap v1 = new HashMap();
        int v2 = AppsRunner.get(this).getPref_CurrentUserID(this);
        int v3 = (int)(((float)(220 - AppsRunner.get(this).ad())) * 0.75f);
        int v4 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(this, v2 + "_time_hr", Integer.valueOf(600), 1)));
        float v5 = (float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_segmentLength_hr_" + 1, Float.valueOf(0.5f), 3)));
        float v8 = (float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_segmentLength_hr_" + 2, Float.valueOf(0.5f), 3)));
        float v11 = (float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_segmentLength_hr_" + 3, Float.valueOf(0.5f), 3)));
        float v14 = ((float)v3) * 1.0f;
        float v16 = (float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_segmentLength_hr_" + 4, Float.valueOf(0.5f), 3)));
        double v6 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_hr_hr_" + 1, Float.valueOf(v14), 3)))));
        double v13 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_hr_hr_" + 2, Float.valueOf(v14), 3)))));
        double v17 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_hr_hr_" + 3, Float.valueOf(v14), 3)))));
        double v9 = (double)(((float)(((Float)ContextSharedPreferences.SharedPreferences(this, v2 + "_hr_hr_" + 4, Float.valueOf(v14), 3)))));
        int v2_1 = v4 - 0xF0;
        float v15 = v5 * 60.0f;
        int v12 = (int)(v15 + v8 * 60.0f + v11 * 60.0f + v16 * 60.0f);
        int v19 = v2_1 / v12;
        if(v2_1 % v12 != 0) {
            ++v19;
        }

        int v0 = v19;
        int v19_1 = 0;
        int v20 = v4;
        int v4_1 = 0;
        while(true) {
            v22 = 1.0;
            v24 = v12;
            if(v4_1 >= 0xF0) {
                break;
            }

            ++v4_1;
            v1.put(Integer.valueOf(v4_1), Double.valueOf(((double)v3) * v22));
            v12 = v24;
            v9 = v9;
        }

        double v25 = v9;
        int v4_2 = 0;
        while(v4_2 < v0) {
            int v9_1 = 0xF0 + v19_1;
            int v10 = v9_1;
            while(true) {
                v27 = v0;
                float v0_1 = (float)v9_1;
                if(((float)v10) > v0_1 + v15 || v10 >= v2_1) {
                    break;
                }

                ++v10;
                v1.put(Integer.valueOf(v10), Double.valueOf(v6));
                v0 = v27;
            }

            int v10_1 = ((int)v15) + v9_1;
            while(true) {
                v28 = v5 + v8;
                v29 = v5;
                v5_1 = v28 * 60.0f;
                if(((float)v10_1) > v0_1 + v5_1 || v10_1 >= v2_1) {
                    break;
                }

                ++v10_1;
                v1.put(Integer.valueOf(v10_1), Double.valueOf(v13));
                v5 = v29;
            }

            int v5_2 = ((int)v5_1) + v9_1;
            while(true) {
                float v12_1 = v28 + v11;
                v30 = v6;
                v6_1 = v12_1 * 60.0f;
                if(((float)v5_2) > v0_1 + v6_1 || v5_2 >= v2_1) {
                    break;
                }

                ++v5_2;
                v1.put(Integer.valueOf(v5_2), Double.valueOf(v17));
                v6 = v30;
            }

            int v9_2 = v9_1 + ((int)v6_1);
            while(((float)v9_2) <= (v12_1 + v16) * 60.0f + v0_1 && v9_2 < v2_1) {
                ++v9_2;
                v1.put(Integer.valueOf(v9_2), Double.valueOf(v25));
            }

            v19_1 += v24;
            ++v4_2;
            v0 = v27;
            v5 = v29;
            v6 = v30;
        }

        int v0_2 = v20;
        while(v2_1 < v0_2) {
            ++v2_1;
            v1.put(Integer.valueOf(v2_1), Double.valueOf(((double)v3) * v22));
        }

        AppsSettingActivity v3_1 = this;
        boolean v2_2 = AppsRunner.get(this).inclineSupportsHalfDegree(v3_1);
        int v4_3 = AppsRunner.get(this).Y();
        j.a("====2222====", v4_3 + " | " + ((boolean)(((int)v2_2))));
        if(v4_3 != 1 && !v2_2) {
            v2_3 = v3_1.ap;
            v4_4 = 12;
        }
        else {
            v2_3 = v3_1.ap;
            v4_4 = 15;
        }

        v2_3.setExtraMaxHRDraw(v4_4);
        v3_1.ap.setFateHeartRateDataSource(v1);
        v3_1.ap.setFateTotalTime(v0_2);
        v3_1.ap.setTotalTime(v0_2);
        v3_1.ap.setCurrentTime(v0_2);
        v3_1.ap.invalidate();
    }

    private void M() {
        int v8_1;
        int v5;
        Resources v4_1;
        TextView v1_1;
        List v4;
        StringBuilder v3;
        TextView v1;
        AppsSettingActivity v0 = this;
        this.b();
        this.c();
        v0.ak = n.a().c(v0, 0x7F070196);  // id:rl_afterStartLine
        v0.q = n.a().b(v0, 0x7F070293);  // id:topLayout1
        v0.r = n.a().b(v0, 0x7F070294);  // id:topLayout2
        v0.s = n.a().a(v0, 0x7F07009B, v0);  // id:editButton_2
        v0.t = n.a().a(v0, 0x7F07026B, v0);  // id:startButton
        v0.u = n.a().a(v0, 0x7F070270, v0);  // id:startButton_2
        v0.v = n.a().a(v0, 0x7F0700C8, v0);  // id:homeButton
        v0.w = n.a().a(v0, 0x7F0700C9, v0);  // id:homeButton2
        v0.x = n.a().a(v0, 0x7F0700CC, v0);  // id:homeButton_2
        v0.y = n.a().e(v0, 0x7F07028D);  // id:titleTextView
        v0.z = n.a().e(v0, 0x7F07028E);  // id:titleTextView_2
        v0.bp = n.a().b(v0, 0x7F07011A);  // id:menuLayout
        v0.ar = n.a().a(v0, 0x7F0700E8, v0);  // id:kmSummaryButton
        v0.as = n.a().h(v0, 0x7F07006A);  // id:customScrollView
        v0.at = n.a().h(v0, 0x7F070057);  // id:customHRScrollView
        v0.au = n.a().e(v0, 0x7F070275);  // id:startTextView
        v0.A = n.a().c(v0, 0x7F07026E);  // id:startButtonLayout
        v0.B = n.a().c(v0, 0x7F07026F);  // id:startButtonLayout_2
        v0.C = n.a().c(v0, 0x7F07009A);  // id:editButtonLayout_2
        v0.s = n.a().a(v0, 0x7F07009B, v0);  // id:editButton_2
        v0.D = n.a().a(v0, 0x7F070000, v0);  // id:ackStartButton
        v0.E = n.a().a(v0, 0x7F070001, v0);  // id:ackStopButton
        v0.F = n.a().c(v0, 0x7F070120, v0);  // id:modeButton1
        v0.G = n.a().c(v0, 0x7F070122, v0);  // id:modeButton2
        v0.H = n.a().c(v0, 0x7F070123, v0);  // id:modeButton3
        v0.I = n.a().c(v0, 0x7F070124, v0);  // id:modeButton4
        v0.J = n.a().c(v0, 0x7F070125, v0);  // id:modeButton5
        v0.K = n.a().c(v0, 0x7F070126, v0);  // id:modeButton6
        v0.L = n.a().c(v0, 0x7F070127, v0);  // id:modeButton7
        v0.M = n.a().c(v0, 0x7F070128, v0);  // id:modeButton8
        v0.N = n.a().c(v0, 0x7F070129, v0);  // id:modeButton9
        v0.O = n.a().c(v0, 0x7F070121, v0);  // id:modeButton10
        v0.P = n.a().d(v0, 0x7F070141);  // id:modeImageView1
        v0.Q = n.a().d(v0, 0x7F070143);  // id:modeImageView2
        v0.R = n.a().d(v0, 0x7F070144);  // id:modeImageView3
        v0.S = n.a().d(v0, 0x7F070145);  // id:modeImageView4
        v0.T = n.a().d(v0, 0x7F070146);  // id:modeImageView5
        v0.U = n.a().d(v0, 0x7F070147);  // id:modeImageView6
        v0.V = n.a().d(v0, 0x7F070148);  // id:modeImageView7
        v0.W = n.a().d(v0, 0x7F070149);  // id:modeImageView8
        v0.X = n.a().d(v0, 0x7F07014A);  // id:modeImageView9
        v0.Y = n.a().d(v0, 0x7F070142);  // id:modeImageView10
        v0.bn = n.a().a(v0, 0x7F070078, v0);  // id:customTimeButton
        v0.bo = n.a().a(v0, 0x7F07004F, v0);  // id:customDistanceButton
        v0.al = n.a().b(v0, 0x7F070068);  // id:customRunningLayout
        v0.am = n.a().b(v0, 0x7F070055);  // id:customHRRunningLayout
        v0.an = n.a().b(v0, 0x7F0700E5);  // id:kmRunningLayout
        v0.ao = (AppsRunningView)n.a().g(v0, 0x7F070069);  // id:customRunningView
        v0.ap = (AppsRunningView)n.a().g(v0, 0x7F070056);  // id:customHRRunningView
        v0.aq = (AppsRunningView)n.a().g(v0, 0x7F0700E6);  // id:kmRunningView
        v0.af = n.a().b(v0, 0x7F070261);  // id:sprintsSettingLayout
        v0.Z = n.a().b(v0, 0x7F070117);  // id:manualSettingLayout
        v0.ai = n.a().b(v0, 0x7F070093);  // id:distanceSettingLayout
        v0.aj = n.a().b(v0, 0x7F07003C);  // id:caloriesSettingLayout
        v0.ac = n.a().b(v0, 0x7F070171);  // id:myFirst5kSettingLayout
        v0.ad = n.a().b(v0, 0x7F070170);  // id:myFirst5kSettingFinishLayout
        v0.ag = n.a().b(v0, 0x7F070071);  // id:customSettingLayout
        v0.ah = n.a().b(v0, 0x7F07005E);  // id:customHRSettingLayout
        v0.Z = n.a().b(v0, 0x7F070117);  // id:manualSettingLayout
        v0.aa = n.a().b(v0, 0x7F0700AF);  // id:fatBurnSettingLayout
        v0.ab = n.a().b(v0, 0x7F0700C2);  // id:hillClimbSettingLayout
        v0.ae = n.a().b(v0, 0x7F0700BF);  // id:heartRateSettingLayout
        v0.bl = n.a().c(v0, 0x7F070175);  // id:nextWorkoutInLayout
        v0.bM = n.a().c(v0, 0x7F070176);  // id:noBluetoothLayout
        v0.av = (AppsMeterView)n.a().g(v0, 0x7F070233);  // id:setting_sprints_time_view
        v0.aw = (AppsMeterView)n.a().g(v0, 0x7F070232);  // id:setting_sprints_level_view
        v0.aw.setListener(v0);
        v0.ax = (TextView)n.a().g(v0, 0x7F070259);  // id:sprint8_max_speed
        v0.ay = (TextView)n.a().g(v0, 0x7F07025A);  // id:sprint8_max_speed_value
        v0.az = (TextView)n.a().g(v0, 0x7F070258);  // id:sprint8_max_incline_value
        v0.aA = (SprintLevelView)n.a().g(v0, 0x7F0702FD);  // id:view_sprint_chart
        if(AppsRunner.get(this).inclineSupportsHalfDegree(v0)) {
            v0.ax.setText(this.getResources().getString(0x7F0B0132));  // string:max_resistance "max.resistance"
            v0.ay.setText(((com.xtremeprog.shell.treadmillv2.views.b)h.c.get(0)).j() + "");
            v1 = v0.az;
            v3 = new StringBuilder();
            v4 = h.d;
        }
        else {
            v0.ax.setText(this.getResources().getString(0x7F0B0133));  // string:max_speed "max.speed"
            v0.ay.setText(((com.xtremeprog.shell.treadmillv2.views.b)h.a.get(0)).j() + "");
            v1 = v0.az;
            v3 = new StringBuilder();
            v4 = h.b;
        }

        v3.append(((com.xtremeprog.shell.treadmillv2.views.b)v4.get(0)).j());
        v3.append("");
        v1.setText(v3.toString());
        v0.aB = (AppsMeterView)n.a().g(v0, 0x7F07022E);  // id:setting_manual_time_view
        v0.aC = (AppsMeterView)n.a().g(v0, 0x7F07022D);  // id:setting_manual_speed_view
        v0.aD = (AppsMeterView)n.a().g(v0, 0x7F07022C);  // id:setting_manual_resistance_view
        v0.aE = (AppsMeterView)n.a().g(v0, 0x7F07022B);  // id:setting_manual_incline_view
        v0.aD.setTitleViewLines(1);
        v0.aF = (AppsMeterView)n.a().g(v0, 0x7F070222);  // id:setting_distance_level_view
        v0.aG = (AppsMeterView)n.a().g(v0, 0x7F070223);  // id:setting_distance_speed_view
        v0.aH = n.a().a(v0, 0x7F070090, v0);  // id:distanceProgramLeftButton
        v0.aI = n.a().a(v0, 0x7F070091, v0);  // id:distanceProgramRightButton
        v0.aM = n.a().e(v0, 0x7F070092);  // id:distanceProgramTextView
        v0.aN = n.a().e(v0, 0x7F070094);  // id:distanceStep2TipTextView
        if(AppsRunner.get(this).inclineSupportsHalfDegree(v0)) {
            v1_1 = v0.aN;
            v4_1 = this.getResources();
            v5 = 0x7F0B0047;  // string:STR_DISTANCE_STEP2_TIP2 "Step 2. Select level"
        }
        else {
            v1_1 = v0.aN;
            v4_1 = this.getResources();
            v5 = 0x7F0B0046;  // string:STR_DISTANCE_STEP2_TIP "Step 2. Select level & speed"
        }

        v1_1.setText(v4_1.getString(v5));
        v0.aO = (AppsMeterView)n.a().g(v0, 0x7F0701B8);  // id:setting_calories_calories_view
        v0.aP = (AppsMeterView)n.a().g(v0, 0x7F0701B9);  // id:setting_calories_level_view
        v0.aQ = (AppsMeterView)n.a().g(v0, 0x7F0701BA);  // id:setting_calories_speed_view
        v0.aR = (AppsMeterView)n.a().g(v0, 0x7F070225);  // id:setting_fatburn_time_view
        v0.aS = (AppsMeterView)n.a().g(v0, 0x7F070224);  // id:setting_fatburn_level_view
        v0.aT = (AppsMeterView)n.a().g(v0, 0x7F07022A);  // id:setting_hillclimb_time_view
        v0.aU = (AppsMeterView)n.a().g(v0, 0x7F070229);  // id:setting_hillclimb_level_view
        v0.myFirst5k_walkSpeed = (AppsMeterView)n.a().g(v0, 0x7F070231);  // id:setting_myFirst5k_walkSpeed_view
        v0.myFirst5k_jogSpeed = (AppsMeterView)n.a().g(v0, 0x7F070230);  // id:setting_myFirst5k_jogSpeed_view
        v0.ba = (AppsMeterView)n.a().g(v0, 0x7F07022F);  // id:setting_myFirst5k_incline_view
        v0.myFirst5k_week = n.a().a(v0, 0x7F0700E9, v0);  // id:kmWeekButton
        v0.myFirst5k_workout = n.a().a(v0, 0x7F0700EA, v0);  // id:kmWorkoutButton
        v0.bd = n.a().a(v0, 0x7F0700E4, v0);  // id:kmResetButton
        v0.be = n.a().a(v0, 0x7F0700DD);  // id:kmFinishButton
        v0.bf = n.a().a(v0, 0x7F0700E0, v0);  // id:kmFinishWeekButton
        v0.bg = n.a().a(v0, 0x7F0700E2, v0);  // id:kmFinishWorkoutButton
        v0.bh = n.a().a(v0, 0x7F0700DE, v0);  // id:kmFinishNextDaysButton
        v0.bi = n.a().e(v0, 0x7F0700E1);  // id:kmFinishWeekTextView
        v0.bj = n.a().e(v0, 0x7F0700E3);  // id:kmFinishWorkoutTextView
        v0.bk = n.a().e(v0, 0x7F0700DF);  // id:kmFinishNextWorkoutTextView
        v0.aV = (AppsMeterView)n.a().g(v0, 0x7F070228);  // id:setting_heartrate_time_view
        v0.aW = (AppsMeterView)n.a().g(v0, 0x7F070226);  // id:setting_heartrate_age_view
        v0.aX = (AppsMeterView)n.a().g(v0, 0x7F070227);  // id:setting_heartrate_hr_view
        v0.ao.setIsFate(true);
        v0.ao.setMaxSpeed(20);
        v0.ao.setMaxResistance(20);
        v0.ao.setMaxIncline(20);
        v0.ao.setMaxHeartRate(0xFA);
        v0.ao.setTotalTime(0);
        v0.ao.setCurrentTime(0);
        v0.ao.setTotalTimeStr("00:00:00");
        v0.ao.invalidate();
        v0.ao.a();
        boolean v1_2 = apps.c.d.h(this);
        boolean v6 = apps.c.d.b();
        boolean v7 = apps.c.d.a();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(((boolean)(((int)v1_2)))) {
                    LinearLayout v1 = AppsSettingActivity.a(AppsSettingActivity.this);
                    AppsSettingActivity.a(AppsSettingActivity.this, v1, 0.8f, 0.78f);
                    return;
                }

                if(!((boolean)(((int)v6))) && (((boolean)(((int)v7))))) {
                    LinearLayout v1_1 = AppsSettingActivity.a(AppsSettingActivity.this);
                    AppsSettingActivity.a(AppsSettingActivity.this, v1_1, 0.73f, 0.73f);
                    return;
                }

                LinearLayout v2 = AppsSettingActivity.a(AppsSettingActivity.this);
                AppsSettingActivity.a(AppsSettingActivity.this, v2, 0.83f, 0.83f);
            }
        }, 0L);
        v0.ap.setIsFate(true);
        v0.ap.setMaxSpeed(20);
        v0.ap.setMaxResistance(20);
        v0.ap.setMaxIncline(20);
        v0.ap.setMaxHeartRate(0xFA);
        v0.ap.setTotalTime(0);
        v0.ap.setCurrentTime(0);
        v0.ap.invalidate();
        v0.ap.a();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(((boolean)(((int)v1_2)))) {
                    LinearLayout v2 = AppsSettingActivity.b(AppsSettingActivity.this);
                    AppsSettingActivity.a(AppsSettingActivity.this, v2, 0.83f, 0.78f);
                    return;
                }

                if(!((boolean)(((int)v6))) && (((boolean)(((int)v7))))) {
                    LinearLayout v1 = AppsSettingActivity.b(AppsSettingActivity.this);
                    AppsSettingActivity.a(AppsSettingActivity.this, v1, 0.73f, 0.73f);
                    return;
                }

                LinearLayout v2_1 = AppsSettingActivity.b(AppsSettingActivity.this);
                AppsSettingActivity.a(AppsSettingActivity.this, v2_1, 0.83f, 0.83f);
            }
        }, 0L);
        int v8 = AppsRunner.get(this).l(v0);
        v0.bq = AppsRunner.get(this).k(v0);
        v0.a(v8);
        if(v0.bA) {
            v8_1 = 0;
        }
        else {
            v8_1 = v0.bz ? 0 : 1;
        }

        v0.a(((boolean)v8_1), false);
        v0.aJ = new int[]{0x7F0B0038, 0x7F0B003D, 0x7F0B003E, 0x7F0B003F, 0x7F0B0040, 0x7F0B0041, 0x7F0B0042, 0x7F0B0043, 0x7F0B0044, 0x7F0B0039, 0x7F0B003A, 0x7F0B003B, 0x7F0B003C};  // string:STR_DISTANCE_PROGRAM_TYPE1 "1 MILE"
        v0.aL = new Double[]{((double)1000.0), ((double)2000.0), ((double)3125.0), ((double)5000.0), ((double)6250.0), ((double)8000.0), ((double)9375.0), ((double)10000.0), ((double)12500.0), ((double)13100.0), ((double)15000.0), ((double)20000.0), ((double)26200.0)};
        v0.aK = new Double[]{((double)Conversions.mi_to_km(1.0)), ((double)Conversions.mi_to_km(2.0)), ((double)5.0), ((double)Conversions.mi_to_km(5.0)), ((double)10.0), ((double)Conversions.mi_to_km(8.0)), ((double)15.0), ((double)Conversions.mi_to_km(10.0)), ((double)20.0), ((double)Conversions.mi_to_km(13.0)), ((double)Conversions.mi_to_km(15.0)), ((double)Conversions.mi_to_km(20.0)), ((double)Conversions.mi_to_km(26.0))};
        j.a("==settingActivity==", "currentStopWorkoutInfo : " + v0.bv);
        StopWorkoutInfo v8_2 = v0.bv;
        if(v8_2 != null) {
            int v8_3 = v8_2.c();
            int v9 = v0.bv.d();
            int v11 = v0.bv.e();
            v0.bf.setText(v8_3 + "");
            v0.bg.setText(v9 + "");
            v0.bh.setText(v11 + "");
            v0.bq = 5;
            AppsRunner.get(this).f(v0, 5);
            v0.a(false, true);
            v0.ac.setVisibility(8);
            v0.ad.setVisibility(0);
            v0.t.setVisibility(8);
            v0.au.setVisibility(8);
            v0.ak.setVisibility(4);
            if(this.getIntent().getExtras() != null && this.getIntent().getExtras().get("Extra_Key_fromRunningDate") != null) {
                v0.bt = (String)this.getIntent().getExtras().get("Extra_Key_fromRunningDate");
            }

            int v5_1 = AppsRunner.get(this).z();
            AppsRunner.get(this).A();
            int v8_4 = v0.bv.g();
            v0.aq.setIsFate(false);
            v0.aq.setMaxSpeed(20);
            v0.aq.setMaxResistance(20);
            v0.aq.setMaxIncline(20);
            v0.aq.setMaxHeartRate(0xFA);
            v0.aq.setTotalTime(v5_1);
            v0.aq.setCurrentTime(v8_4);
            v0.aq.setShowTimeTipTitle(false);
            v0.aq.invalidate();
            v0.aq.a();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    LinearLayout v2 = AppsSettingActivity.c(AppsSettingActivity.this);
                    AppsSettingActivity.b(AppsSettingActivity.this, v2, 0.7f, 0.7f);
                }
            }, 0L);
            v0.i = v0.bv.f();
            if(v0.i == 1) {
                v0.bl.setVisibility(4);
                this.m();
            }
            else {
                v0.bl.setVisibility(0);
            }

            if(v0.i != 0 && v0.i != 1) {
                v0.be.setText(this.getResources().getString(0x7F0B0007));  // string:STR_ABORTED "Aborted!"
            }
            else {
                v0.be.setText(this.getResources().getString(0x7F0B0060));  // string:STR_FINISHED "Finished!"
                int v1_3 = AppsRunner.get(this).getPref_CurrentUserID(v0);
                int v2 = AppsRunner.get(this).h(v0);
                int v4_2 = AppsRunner.get(this).i(v0);
                j.a("==5K finish了，要APP保存一下walkSpeed和jogSpeed==" + v1_3, v2 + "===" + v4_2);
                if(v2 != -1 && v4_2 != -1) {
                    AppsRunner.get(this).setWalkSpeed(v0, v2, v1_3);
                    AppsRunner.get(this).setJogSpeed(v0, v4_2, v1_3);
                }

                this.w();
            }

            int v1_4 = AppsRunner.get(this).getPref_CurrentUserID(v0);
            String v2_1 = ShareFitness.get(this).getPrefsMapMyFitnessTokenKey(v1_4 + "");
            String v4_3 = ShareFitness.get(this).getPrefsMFPTokenId(v1_4 + "");
            String v1_5 = ShareFitness.get(this).getPrefsFitbitTokenId(v1_4 + "");
            if(apps.c.d.strNotEmpty(v2_1)) {
                j.a("===", "==setting mmf为空，不用分享==");
            }
            else {
                j.a("===", "==setting mmf不为空，要分享==");
                v0.a(1, true);
            }

            if(apps.c.d.strNotEmpty(v4_3)) {
                j.a("===", "==setting mfp为空，不用分享==");
            }
            else {
                j.a("===", "==setting mfp不为空，要分享==");
                v0.b(1, true);
            }

            if(apps.c.d.strNotEmpty(v1_5)) {
                j.a("===", "==setting fb为空，不用分享==");
            }
            else {
                j.a("===", "==setting fb不为空，要分享==");
                v0.c(1, true);
            }
        }

        this.l();
        ((ScrollView)v0.findViewById(0x7F0700E7)).setOnTouchListener(new View.OnTouchListener() {  // id:kmScrollView
            @Override  // android.view.View$OnTouchListener
            public boolean onTouch(View arg1, MotionEvent arg2) {
                return true;
            }
        });
    }

    private void N() {
        this.aW.setListener(new a() {
            @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterView$a
            public void a(AppsMeterView arg5, double arg6) {
                int v5 = (int)((220.0 - AppsSettingActivity.d(AppsSettingActivity.this).getValue()) * 0.9);
                int v6 = (int)((220.0 - AppsSettingActivity.d(AppsSettingActivity.this).getValue()) * 0.75);
                AppsSettingActivity.e(AppsSettingActivity.this).a.i = 2.470000E-322;
                AppsSettingActivity.e(AppsSettingActivity.this).a.d = v5;
                AppsSettingActivity.e(AppsSettingActivity.this).a.e = v5;
                AppsSettingActivity.e(AppsSettingActivity.this).a.h = (double)v6;
                AppsSettingActivity.e(AppsSettingActivity.this).a.g = 1.0;
                AppsSettingActivity.e(AppsSettingActivity.this).a.a(false);
                j.a("---", 50 + " : " + v5 + " : " + v6);
            }
        });
        if(this.aW.b != null) {
            this.aW.b.a(this.aW, this.aW.getValue());
        }

        this.as.setOnTouchListener(new View.OnTouchListener() {
            @Override  // android.view.View$OnTouchListener
            public boolean onTouch(View arg1, MotionEvent arg2) {
                return true;
            }
        });
        this.at.setOnTouchListener(new View.OnTouchListener() {
            @Override  // android.view.View$OnTouchListener
            public boolean onTouch(View arg1, MotionEvent arg2) {
                return true;
            }
        });
    }

    private com.xtremeprog.shell.treadmillv2.f O() {
        float v15_5;
        float v2_7;
        float v4_5;
        float v3_5;
        float v15_4;
        float v2_6;
        float v15_3;
        float v2_5;
        float v15_2;
        float v2_4;
        float v4_2;
        float v3_3;
        AppsMeterView v12_1;
        float v15_1;
        float v2_3;
        float v11_1;
        float v5_3;
        float v4_1;
        int v3_2;
        float v15;
        float v2_2;
        List v3;
        AppsSettingActivity v0 = this;
        com.xtremeprog.shell.treadmillv2.f v1 = new com.xtremeprog.shell.treadmillv2.f();
        boolean v2 = AppsRunner.get(this).inclineSupportsHalfDegree(v0);
        v1.u = 900;
        v1.t = 900;
        v1.H = 0;
        v1.f = 1;
        v1.c = (int)v0.aX.getValue();
        int v5 = v0.bq;
        if(v5 == 9) {
            v1.a = ((int)v0.av.getValue()) * 60;
            AppsRunner.get(this).W();
            float v2_1 = (float)AppsRunner.get(this).aa();
            apps.database.d.a().e(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
            v1.f = (int)v0.aw.getValue();
            if(AppsRunner.get(this).inclineSupportsHalfDegree(v0)) {
                v1.p = ((com.xtremeprog.shell.treadmillv2.views.b)h.d.get(v1.f - 1)).j();
                v3 = h.d;
            }
            else {
                v1.p = ((com.xtremeprog.shell.treadmillv2.views.b)h.b.get(v1.f - 1)).j();
                v3 = h.b;
            }

            v1.l = ((com.xtremeprog.shell.treadmillv2.views.b)v3.get(v1.f - 1)).a();
            v1.q = 0.0f;
            v1.w = 0.0f;
            v1.E = 0.0f;
            v1.n = ((com.xtremeprog.shell.treadmillv2.views.b)h.a.get(v1.f - 1)).j();
            v1.o = v2_1;
            v1.v = 0.5f;
            v1.k = ((com.xtremeprog.shell.treadmillv2.views.b)h.a.get(v1.f - 1)).a();
            v1.D = 0.1f;
            v1.m = ((com.xtremeprog.shell.treadmillv2.views.b)h.c.get(v1.f - 1)).j();
            v1.r = ((com.xtremeprog.shell.treadmillv2.views.b)h.c.get(v1.f - 1)).j();
            goto label_461;
        }
        else {
            float v14 = 15.0f;
            if(v5 == 0) {
                int v5_1 = ((int)v0.aB.getValue()) * 60;
                j.a("===setting maual params===", v5_1 + " |");
                if(v5_1 < 300) {
                    v5_1 = 5940;
                    v1.H = 1;
                }
                else {
                    v1.H = 0;
                }

                j.a("===setting maual params play mode===", v1.H + " |");
                v1.a = v5_1;
                float v3_1 = (float)AppsRunner.get(this).W();
                float v4 = (float)AppsRunner.get(this).aa();
                float v5_2 = (float)v0.aC.getValue();
                apps.database.d.a().e(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
                float v11 = (float)v0.aD.getValue();
                float v12 = (float)v0.aE.getValue();
                if(v2) {
                    v2_2 = 120.0f;
                    v14 = 100.0f;
                    v15 = 5.0f;
                }
                else {
                    v2_2 = 15.0f;
                    v15 = 0.5f;
                }

                v1.p = v14;
                v1.q = v2_2;
                v1.w = 0.0f;
                v1.l = v12;
                v1.E = v15;
                v1.n = v3_1;
                v1.o = v4;
                v1.v = 0.5f;
                v1.k = v5_2;
                v1.D = 0.1f;
                v1.m = v11;
            }
            else {
                if(v5 == 2) {
                    v1.a = 0;
                    AppsRunner.get(this).Y();
                    v3_2 = (int)(((double)v0.aL[v0.bL]));
                    v4_1 = (float)AppsRunner.get(this).W();
                    v5_3 = (float)AppsRunner.get(this).aa();
                    v11_1 = (float)v0.aG.getValue();
                    if(v2) {
                        v2_3 = 120.0f;
                        v14 = 100.0f;
                        v15_1 = 5.0f;
                    }
                    else {
                        v2_3 = 15.0f;
                        v15_1 = 0.5f;
                    }

                    v12_1 = v0.aF;
                    goto label_231;
                }

                if(v5 == 4) {
                    v1.a = 0;
                    v3_2 = (int)v0.aO.getValue();
                    v4_1 = (float)AppsRunner.get(this).W();
                    v5_3 = (float)AppsRunner.get(this).aa();
                    v11_1 = (float)v0.aQ.getValue();
                    apps.database.d.a().e(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
                    if(v2) {
                        v2_3 = 120.0f;
                        v14 = 100.0f;
                        v15_1 = 5.0f;
                    }
                    else {
                        v2_3 = 15.0f;
                        v15_1 = 0.5f;
                    }

                    v1.h = (int)v0.aO.getValue();
                    v12_1 = v0.aP;
                label_231:
                    v1.f = (int)v12_1.getValue();
                    v1.p = v14;
                    v1.q = v2_3;
                    v1.w = 0.0f;
                    v1.l = 0.0f;
                    v1.E = v15_1;
                    v1.n = v4_1;
                    v1.o = v5_3;
                    v1.v = 0.5f;
                    v1.k = v11_1;
                    goto label_395;
                }

                if(v5 == 6) {
                    v1.a = ((int)v0.aR.getValue()) * 60;
                    v1.f = (int)v0.aS.getValue();
                    v3_3 = (float)AppsRunner.get(this).W();
                    v4_2 = (float)AppsRunner.get(this).aa();
                    apps.database.d.a().e(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
                    if(!v2) {
                        goto label_293;
                    }

                    goto label_288;
                }

                if(v5 == 1) {
                    v1.a = ((int)v0.aT.getValue()) * 60;
                    v1.f = (int)v0.aU.getValue();
                    v3_3 = (float)AppsRunner.get(this).W();
                    v4_2 = (float)AppsRunner.get(this).aa();
                    apps.database.d.a().e(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
                    if(v2) {
                    label_288:
                        v2_4 = 120.0f;
                        v14 = 100.0f;
                        v15_2 = 5.0f;
                    }
                    else {
                    label_293:
                        v2_4 = 15.0f;
                        v15_2 = 0.5f;
                    }

                    v1.p = v14;
                    v1.q = v2_4;
                    v1.w = 0.0f;
                    v1.l = 0.0f;
                    v1.E = v15_2;
                    v1.n = v3_3;
                    v1.o = v4_2;
                    v1.v = 0.5f;
                    v1.k = 0.5f;
                    v1.D = 0.1f;
                    v1.r = 20.0f;
                    v1.s = 20.0f;
                    v1.x = 1.0f;
                    v1.m = 1.0f;
                    goto label_464;
                }

                if(v5 == 5) {
                    v1.a = 0;
                    float v3_4 = (float)AppsRunner.get(this).W();
                    float v4_3 = (float)AppsRunner.get(this).aa();
                    apps.database.d.a().e(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
                    if(v2) {
                        v2_5 = 120.0f;
                        v14 = 100.0f;
                        v15_3 = 5.0f;
                    }
                    else {
                        v2_5 = 15.0f;
                        v15_3 = 0.5f;
                    }

                    v1.i = (double)(((float)v0.myFirst5k_walkSpeed.getValue()));
                    v1.j = (double)(((float)v0.myFirst5k_jogSpeed.getValue()));
                    v1.p = v14;
                    v1.q = v2_5;
                    v1.w = 0.0f;
                    v1.l = (float)v0.ba.getValue();
                    v1.E = v15_3;
                    v1.n = v3_4;
                    v1.o = v4_3;
                    v1.v = 0.5f;
                    v1.k = 0.0f;
                }
                else {
                    if(v5 == 3) {
                        v1.a = ((int)v0.aV.getValue()) * 60;
                        v1.b = (int)v0.aW.getValue();
                        v3_2 = (int)v0.aX.getValue();
                        v1.g = v3_2;
                        float v4_4 = (float)AppsRunner.get(this).W();
                        float v5_4 = (float)AppsRunner.get(this).aa();
                        apps.database.d.a().e(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
                        if(v2) {
                            v2_6 = 120.0f;
                            v14 = 100.0f;
                            v15_4 = 5.0f;
                        }
                        else {
                            v2_6 = 15.0f;
                            v15_4 = 0.5f;
                        }

                        v1.p = v14;
                        v1.q = v2_6;
                        v1.w = 0.0f;
                        v1.l = 0.0f;
                        v1.E = v15_4;
                        v1.n = v4_4;
                        v1.o = v5_4;
                        v1.v = 0.5f;
                        v1.k = 0.5f;
                    label_395:
                        v1.D = 0.1f;
                        v1.m = 1.0f;
                        v1.r = 20.0f;
                        v1.s = 20.0f;
                        v1.x = 1.0f;
                        v1.g = v3_2;
                        goto label_464;
                    }

                    if(v5 != 11 && v5 != 7 && v5 != 10) {
                        if(v5 != 8) {
                            goto label_464;
                        }

                        v1.a = 0;
                        v1.a = this.J();
                        v3_5 = (float)AppsRunner.get(this).W();
                        v4_5 = (float)AppsRunner.get(this).aa();
                        apps.database.d.a().e(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
                        if(!v2) {
                            goto label_444;
                        }

                        goto label_440;
                    }

                    v1.a = 0;
                    v1.a = this.I();
                    v3_5 = (float)AppsRunner.get(this).W();
                    v4_5 = (float)AppsRunner.get(this).aa();
                    apps.database.d.a().e(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
                    if(v2) {
                    label_440:
                        v2_7 = 120.0f;
                        v14 = 100.0f;
                        v15_5 = 5.0f;
                    }
                    else {
                    label_444:
                        v2_7 = 15.0f;
                        v15_5 = 0.5f;
                    }

                    v1.p = v14;
                    v1.q = v2_7;
                    v1.w = 0.0f;
                    v1.l = 0.0f;
                    v1.E = v15_5;
                    v1.n = v3_5;
                    v1.o = v4_5;
                    v1.v = 0.5f;
                    v1.k = 0.5f;
                }

                v1.D = 0.1f;
                v1.m = 1.0f;
            }

            v1.r = 20.0f;
        label_461:
            v1.s = 20.0f;
            v1.x = 1.0f;
        }

    label_464:
        v1.b = apps.database.d.a().g(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
        v1.e = apps.database.d.a().d(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
        v1.d = apps.database.d.a().f(v0, AppsRunner.get(this).getPref_CurrentUserID(v0));
        v1.C = (int)v0.aX.getValue();
        return v1;
    }

    static int a(AppsSettingActivity arg0, int arg1) {
        arg0.bK = arg1;
        return arg1;
    }

    static LinearLayout a(AppsSettingActivity arg0) {
        return arg0.al;
    }

    static String a(AppsSettingActivity arg0, String arg1) {
        arg0.bt = arg1;
        return arg1;
    }

    private void a(LinearLayout arg7, float arg8, float arg9) {
        int v8;
        AnimatorSet v0 = new AnimatorSet();
        Animator[] v1 = new Animator[3];
        float[] v4 = new float[1];
        int v5 = 0;
        v4[0] = arg8;
        v1[0] = ObjectAnimator.ofFloat(arg7, "scaleX", v4);
        v1[1] = ObjectAnimator.ofFloat(arg7, "scaleY", new float[]{arg9});
        v1[2] = ObjectAnimator.ofFloat(arg7, "y", new float[]{0.0f});
        v0.playTogether(v1);
        v0.setDuration(0L);
        v0.start();
        boolean v9 = apps.c.d.h(this);
        boolean v0_1 = apps.c.d.b();
        boolean v1_1 = apps.c.d.a();
        if(v9) {
            v8 = 0;
        }
        else if(v0_1) {
            v5 = arg7 == this.al ? ((int)(((float)(k.a(this, 300.0f) / 4)) * arg8)) : ((int)(((float)(k.a(this, 300.0f) / 4)) * arg8)) + k.a(this, 20.0f);
            v8 = k.a(this, 80.0f) / 4 - k.a(this, 10.0f);
        }
        else if(v1_1) {
            v5 = ((int)(((float)(k.a(this, 1000.0f) / 4)) * arg8)) - 150;
            v8 = k.a(this, 230.0f) / 4 - 80 - k.a(this, 20.0f);
        }
        else {
            v5 = ((int)(((float)(k.a(this, 1000.0f) / 4)) * arg8)) - 150;
            v8 = k.a(this, 230.0f) / 4 - 80;
        }

        FrameLayout.LayoutParams v9_1 = (FrameLayout.LayoutParams)arg7.getLayoutParams();
        v9_1.leftMargin = -v5;
        v9_1.topMargin = -v8;
        arg7.setLayoutParams(v9_1);
    }

    static void a(AppsSettingActivity arg0, LinearLayout arg1, float arg2, float arg3) {
        arg0.a(arg1, arg2, arg3);
    }

    static boolean a(AppsSettingActivity arg0, boolean arg1) {
        arg0.bs = arg1;
        return arg1;
    }

    public int a(View arg2) {
        if(arg2 == this.F) {
            return 0;
        }

        if(arg2 == this.G) {
            return 1;
        }

        if(arg2 == this.H) {
            return 2;
        }

        if(arg2 == this.I) {
            return 3;
        }

        if(arg2 == this.J) {
            return 4;
        }

        return arg2 == this.K ? 5 : -1;
    }

    public void a(int arg9) {
        int v0 = this.bq;
        this.br = arg9;
        this.av.a(0x7F0B00D9, v0, arg9, 18);  // string:STR_TITLE_TIME "Time"
        this.aw.a(0x7F0B00D4, v0, arg9, 19);  // string:STR_TITLE_LEVEL "Level"
        this.aB.a(0x7F0B00D9, v0, arg9, 1);  // string:STR_TITLE_TIME "Time"
        this.aC.a(0x7F0B00D8, v0, arg9, 2);  // string:STR_TITLE_SPEED "Speed"
        this.aD.a(0x7F0B00D6, v0, arg9, 3);  // string:STR_TITLE_RESISTENCE "Resistance"
        this.aE.a(0x7F0B00D2, v0, arg9, 4);  // string:STR_TITLE_INCLINE "Incline"
        this.aD.setTitleViewLines(1);
        this.aF.a(0x7F0B00D4, v0, arg9, 6);  // string:STR_TITLE_LEVEL "Level"
        this.aG.a(0x7F0B00D8, v0, arg9, 7);  // string:STR_TITLE_SPEED "Speed"
        this.aO.a(0x7F0B001F, v0, arg9, 10);  // string:STR_COLORIES "Calories"
        this.aP.a(0x7F0B00D4, v0, arg9, 11);  // string:STR_TITLE_LEVEL "Level"
        this.aQ.a(0x7F0B00D8, v0, arg9, 12);  // string:STR_TITLE_SPEED "Speed"
        this.aR.a(0x7F0B00D9, v0, arg9, 8);  // string:STR_TITLE_TIME "Time"
        this.aS.a(0x7F0B00D4, v0, arg9, 9);  // string:STR_TITLE_LEVEL "Level"
        this.aT.a(0x7F0B00D9, v0, arg9, 5);  // string:STR_TITLE_TIME "Time"
        this.aU.a(0x7F0B00D4, v0, arg9, 26);  // string:STR_TITLE_LEVEL "Level"
        this.aV.a(0x7F0B00D9, v0, arg9, 15);  // string:STR_TITLE_TIME "Time"
        this.aW.a(0x7F0B00D0, v0, arg9, 16);  // string:STR_TITLE_AGE "Age"
        this.aX.a(0x7F0B00D1, v0, arg9, 17);  // string:STR_TITLE_HR "HR"
        this.myFirst5k_walkSpeed.a(0x7F0B00DA, v0, arg9, 22);  // string:STR_TITLE_WALK_SPEED "Walk Speed"
        this.myFirst5k_jogSpeed.a(0x7F0B00D3, v0, arg9, 23);  // string:STR_TITLE_JOB_SPEED "Jog Speed"
        this.ba.a(0x7F0B00D2, v0, arg9, 24);  // string:STR_TITLE_INCLINE "Incline"
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.N();
        this.w();
    }

    public void a(int arg27, boolean arg28) {
        AppsSettingActivity v15 = this;
        StopWorkoutInfo v0 = v15.bv;
        if(v0 == null) {
            return;
        }

        WorkoutListMember v0_1 = v0.a();
        int v1 = v0_1.getCalories();
        int v2 = v0_1.getAverageHR();
        double v3 = (double)(((float)v0_1.getDistance()) / 100.0f);
        double v5 = (double)(((float)v0_1.getAverageSpeed()) / 10.0f);
        Date v7 = AppsRunner.get(this).getRunDate();
        int v14 = AppsRunner.get(this).getPref_CurrentUserID(v15);
        String v8 = ShareFitness.get(this).getPrefsMapMyFitnessTokenKey(v14 + "");
        int v0_2 = (int)apps.c.d.a(v1 + "", 0);
        int v9 = AppsRunner.get(this).A();
        int v10 = AppsRunner.get(this).z();
        StopWorkoutInfo v11 = v15.bv;
        if(v11 != null) {
            v9 = v11.g();
        }

        double v16 = 1.0;
        double v3_1 = apps.c.d.a(v3 + "", 0.0) * v16;
        double v11_1 = apps.c.d.a(v5 + "", 0.0);
        int v13 = (int)apps.c.d.a(v2 + "", 0);
        boolean v6 = AppsRunner.get(this).inclineSupportsHalfDegree(v15);
        int v5_1 = AppsRunner.get(this).Y();
        double v18 = 1000.0;
        double v1_1 = v5_1 == 0 ? Conversions.b(v11_1) * v18 : v11_1 * v18 / 3600.0;
        int v20 = v14;
        int v21 = v5_1;
        j.a("===", "3_mmf avg_speed : " + v11_1 + "  " + v1_1);
        if(!apps.c.d.d(this)) {
            SummaryArticle v1_2 = new SummaryArticle();
            v1_2.setSummaryDate(f.a(v7, "yyyy-MM-dd HH:mm:ss"));
            v1_2.setMmfToken(v8);
            v1_2.setMfpToken("");
            v1_2.setMfpUserId("");
            v1_2.setCalories(v0_2);
            v1_2.setElapsedTime(v9);
            v1_2.setTotalTime(v10);
            v1_2.setTotalDistance(((float)v3_1));
            v1_2.setAverageSpeed(((float)v11_1));
            v1_2.setAverageHR(v13);
            v1_2.setIsEp(((int)v6));
            v1_2.setUnits(v21);
            v1_2.setUserid(v20 + "");
            c.a().a(this, v20 + "", v1_2);
            j.a("====", "无网络，先保存到本地ＭMF : " + v1_2);
            return;
        }

        int v14_1 = v20;
        int v5_2 = v21;
        AppsSettingActivity v15_1 = this;
        if(v9 > 0 && !apps.c.d.strNotEmpty(v8)) {
            boolean v20_1 = v6;
            if(!apps.c.d.a(v8, "0000000000000000000000000000000000000000")) {
                int v6_1 = Conversions.kilocalorie_to_joule(v15_1, v0_2);
                if(v5_2 == 0) {
                    v3_1 = Conversions.mi_to_km(v3_1);
                }

                j.a("==开始分享==", "====" + v8 + " ||| " + ShareFitness.get(this).p(v8));
                HashMap v0_3 = new HashMap();
                v0_3.put("startDate", v7);
                v0_3.put("totalTime", Integer.valueOf(v10));
                v0_3.put("elapsedTime", Integer.valueOf(v9));
                v0_3.put("totalDistance", Float.valueOf(((float)(v3_1 * v18))));
                v0_3.put("averageSpeed", Float.valueOf(((float)(v1_1 * v16))));
                v0_3.put("averageHR", Integer.valueOf(v13));
                v0_3.put("calories", Integer.valueOf(v6_1));
                com.xtremeprog.shell.treadmillv2.activity.AppsSettingActivity.28 v24 = new apps.c.m.a() {
                    @Override  // apps.c.m$a
                    public Object a() {
                        String v0 = o.a().a(AppsSettingActivity.this, "55xtz5n5kmdphxxsmbvgn68byrvnqbxj", "t8WV9adqUT6D47yvqd9gFu65MZUFcNKWtNwC9GCHJG6", v8, ((int)AppsRunner.get(this).inclineSupportsHalfDegree(v15_1)), v0_3);
                        if(!apps.c.d.strNotEmpty(v0)) {
                            AppsArticle v1 = AppsArticle.toAppsArticle(v0);
                            if(v1 != null) {
                                v1.setJson(v0);
                            }

                            j.a("==MMF json ==", v0 + " |");
                            return v1;
                        }

                        return null;
                    }
                };
                new apps.c.m.b() {
                    @Override  // apps.c.m$b
                    public void a(Object arg8) {
                        int v0 = 0;
                        if(arg8 != null) {
                            try {
                                AppsArticle v8_1 = (AppsArticle)arg8;
                                String v2 = v8_1.getStart_datetime();
                                String v3 = v8_1.getJson();
                                if(apps.c.d.b(v3).indexOf("ACCESSTOKEN_EXPIRED") != -1 || apps.c.d.b(v3).indexOf("ACCESSTOKEN_NOT_FOUND") != -1) {
                                    goto label_20;
                                }

                                if(!apps.c.d.strNotEmpty(v2)) {
                                    v0 = 1;
                                    goto label_96;
                                label_20:
                                    SummaryArticle v2_1 = new SummaryArticle();
                                    v2_1.setSummaryDate(f.a(v7, "yyyy-MM-dd HH:mm:ss"));
                                    v2_1.setMmfToken(v8);
                                    v2_1.setMfpToken("");
                                    v2_1.setMfpUserId("");
                                    v2_1.setCalories(v6_1);
                                    v2_1.setElapsedTime(v9);
                                    v2_1.setTotalTime(v10);
                                    v2_1.setTotalDistance(((float)v3_1));
                                    v2_1.setAverageSpeed(((float)v11_1));
                                    v2_1.setAverageHR(v13);
                                    v2_1.setIsEp(v20_1 ? 1 : 0);
                                    v2_1.setUnits(v5_2);
                                    v2_1.setUserid(v14_1 + "");
                                    c.a().a(AppsSettingActivity.this, v14_1 + "", v2_1);
                                    j.a("====", "等MMF refresh token，先保存到本地MMF : " + v8_1);
                                    ((AppsApplication)AppsSettingActivity.this.getApplication()).doRefreshMMFToken2(v14_1 + "", 1);
                                    return;
                                }
                            }
                            catch(Exception v8) {
                                v8.printStackTrace();
                            }
                        }

                    label_96:
                        if(v0 == 0) {
                            if(arg27 < 999) {
                                j.a("====", "MMF RETRY TO SHARE");
                                AppsSettingActivity.this.a(arg27 + 1, arg28);
                                return;
                            }

                            j.a("====", "MMF FAILED TO SHARE");
                        }
                        else {
                            j.a("====", "MMF SUCCESS TO SHARE");
                            if(arg28) {
                                String v0_1 = AppsSettingActivity.this.getResources().getString(0x7F0B00BF);  // string:STR_SHARE_SUCCESS "Successfully Shared"
                                AppsSettingActivity.this.b(v0_1);
                                return;
                            }
                        }
                    }
                };
                m.a(v24, null);
                return;
            }
        }

        j.a("==mmfToken为空或其他==", "==暂不分享MMF===");
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterView$a
    public void a(AppsMeterView arg3, double arg4) {
        List v5;
        SprintLevelView v3;
        int v4;
        if(this.bq == 9) {
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                v4 = ((int)arg4) - 1;
                this.ay.setText(((com.xtremeprog.shell.treadmillv2.views.b)h.c.get(v4)).j() + "");
                this.az.setText(((com.xtremeprog.shell.treadmillv2.views.b)h.d.get(v4)).j() + "");
                v3 = this.aA;
                v5 = h.c;
            }
            else {
                v4 = ((int)arg4) - 1;
                this.ay.setText(((com.xtremeprog.shell.treadmillv2.views.b)h.a.get(v4)).j() + "");
                this.az.setText(((com.xtremeprog.shell.treadmillv2.views.b)h.b.get(v4)).j() + "");
                v3 = this.aA;
                v5 = h.a;
            }

            v3.setData(((com.xtremeprog.shell.treadmillv2.views.b)v5.get(v4)));
        }
    }

    public void a(boolean arg2) {
        if(!arg2) {
            goto label_128;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DID_START_WORKOUT");
            this.registerReceiver(this.bJ, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS");
            this.registerReceiver(this.bJ, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_DID_SET_USER_DATA");
            this.registerReceiver(this.bJ, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_DID_FINISH_KM");
            this.registerReceiver(this.bJ, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_DID_GET_USER");
            this.registerReceiver(this.bJ, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.bJ, v2_6);
            IntentFilter v2_7 = new IntentFilter();
            v2_7.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.bJ, v2_7);
            IntentFilter v2_8 = new IntentFilter();
            v2_8.addAction("NOTIFICATION_DID_SET_MY_FIRST_5K");
            this.registerReceiver(this.bJ, v2_8);
            IntentFilter v2_9 = new IntentFilter();
            v2_9.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.bJ, v2_9);
            IntentFilter v2_10 = new IntentFilter();
            v2_10.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.bJ, v2_10);
            IntentFilter v2_11 = new IntentFilter();
            v2_11.addAction("NOTIFICATION_DID_GET_SETCUSTOMPROGRAM");
            this.registerReceiver(this.bJ, v2_11);
            IntentFilter v2_12 = new IntentFilter();
            v2_12.addAction("NOTIFICATION_DID_GET_SETCUSTOMHRPROGRAM");
            this.registerReceiver(this.bJ, v2_12);
            IntentFilter v2_13 = new IntentFilter();
            v2_13.addAction("NOTIFICATION_DID_SET_CUSTOM");
            this.registerReceiver(this.bJ, v2_13);
            IntentFilter v2_14 = new IntentFilter();
            v2_14.addAction("NOTIFICATION_DID_DEVICE_SET_CUSTOM_PROGRAM");
            this.registerReceiver(this.bJ, v2_14);
            IntentFilter v2_15 = new IntentFilter();
            v2_15.addAction("NOTIFICATION_DID_START_WORKOUT_TIMEOUT");
            this.registerReceiver(this.bJ, v2_15);
            IntentFilter v2_16 = new IntentFilter();
            v2_16.addAction("NOTIFICATION_DID_START_WORKOUT_FAIL");
            this.registerReceiver(this.bJ, v2_16);
            IntentFilter v2_17 = new IntentFilter();
            v2_17.addAction("NOTIFICATION_DID_SET_CUSTOM_HR");
            this.registerReceiver(this.bJ, v2_17);
            IntentFilter v2_18 = new IntentFilter();
            v2_18.addAction("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE_BEFORE_SHOW");
            this.registerReceiver(this.bJ, v2_18);
            IntentFilter v2_19 = new IntentFilter();
            v2_19.addAction("NOTIFICATION_RE_SHOW_LOADING");
            this.registerReceiver(this.bJ, v2_19);
            IntentFilter v2_20 = new IntentFilter();
            v2_20.addAction("NOTIFICATION_DID_APP_START_WORKOUT");
            this.registerReceiver(this.bJ, v2_20);
            IntentFilter v2_21 = new IntentFilter();
            v2_21.addAction("NOTIFICATION_DID_SELECT_PROGRAM");
            this.registerReceiver(this.bJ, v2_21);
            return;
        label_128:
            this.unregisterReceiver(this.bJ);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    public void a(boolean arg11, boolean arg12) {
        j.a("===", "===initui==");
        this.F.setEnabled(true);
        this.G.setEnabled(true);
        this.H.setEnabled(true);
        this.I.setEnabled(true);
        this.J.setEnabled(true);
        this.K.setEnabled(true);
        this.L.setEnabled(true);
        this.M.setEnabled(true);
        this.N.setEnabled(true);
        this.O.setEnabled(true);
        this.af.setVisibility(8);
        this.Z.setVisibility(8);
        this.ai.setVisibility(8);
        this.aj.setVisibility(8);
        this.ag.setVisibility(8);
        this.ah.setVisibility(8);
        this.aa.setVisibility(8);
        this.ab.setVisibility(8);
        this.ac.setVisibility(8);
        this.ae.setVisibility(8);
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.P.setBackgroundResource(0x7F0601C4);  // drawable:sprint8
        this.Q.setBackgroundResource(0x7F06013F);  // drawable:pad_select_program1_nor
        this.R.setBackgroundResource(0x7F060141);  // drawable:pad_select_program1_nor_67
        this.S.setBackgroundResource(0x7F060143);  // drawable:pad_select_program1_nor_69
        this.T.setBackgroundResource(0x7F060145);  // drawable:pad_select_program1_nor_71
        this.U.setBackgroundResource(0x7F060140);  // drawable:pad_select_program1_nor_66
        this.V.setBackgroundResource(0x7F060142);  // drawable:pad_select_program1_nor_68
        this.W.setBackgroundResource(0x7F060144);  // drawable:pad_select_program1_nor_70
        this.X.setBackgroundResource(0x7F060146);  // drawable:pad_select_program1_nor_72
        this.Y.setBackgroundResource(0x7F060148);  // drawable:pad_select_program1_nor_74
        if(!arg12 && this.ad.getVisibility() == 0) {
            AppsRunner.get(this).clear();
            AppsRunner.get(this).setCurrentStopWorkoutInfo(null);
        }

        this.ad.setVisibility(8);
        this.t.setVisibility(0);
        this.au.setVisibility(0);
        this.ak.setVisibility(0);
        int v12 = this.bq;
        if(v12 == 9) {
            this.F.setEnabled(false);
            this.af.setVisibility(0);
            this.q.setVisibility(0);
            this.P.setBackgroundResource(0x7F0601C5);  // drawable:sprint8_choice
        }
        else if(v12 == 0) {
            this.G.setEnabled(false);
            this.Z.setVisibility(0);
            this.q.setVisibility(0);
            this.Q.setBackgroundResource(0x7F060149);  // drawable:pad_select_program1_sel
        }
        else if(v12 == 2) {
            this.H.setEnabled(false);
            this.ai.setVisibility(0);
            this.q.setVisibility(0);
            this.R.setBackgroundResource(0x7F06014B);  // drawable:pad_select_program3_sel
        }
        else if(v12 == 4) {
            this.I.setEnabled(false);
            this.aj.setVisibility(0);
            this.q.setVisibility(0);
            this.S.setBackgroundResource(0x7F06014D);  // drawable:pad_select_program5_sel
        }
        else if(v12 == 6) {
            this.J.setEnabled(false);
            this.aa.setVisibility(0);
            this.q.setVisibility(0);
            this.T.setBackgroundResource(0x7F06014F);  // drawable:pad_select_program7_sel
        }
        else if(v12 == 1) {
            this.K.setEnabled(false);
            this.ab.setVisibility(0);
            this.q.setVisibility(0);
            this.U.setBackgroundResource(0x7F06014A);  // drawable:pad_select_program2_sel
        }
        else if(v12 == 3) {
            this.L.setEnabled(false);
            this.ae.setVisibility(0);
            this.q.setVisibility(0);
            this.V.setBackgroundResource(0x7F06014C);  // drawable:pad_select_program4_sel
        }
        else if(v12 == 5) {
            this.M.setEnabled(false);
            this.ac.setVisibility(0);
            this.q.setVisibility(0);
            this.W.setBackgroundResource(0x7F06014E);  // drawable:pad_select_program6_sel
            if(arg11) {
                int v12_1 = AppsRunner.get(this).getPref_CurrentUserID(this);
                int v3 = AppsRunner.get(this).b(this, v12_1);
                int v7 = AppsRunner.get(this)._2weekmissed(this, v12_1);
                int v8 = AppsRunner.get(this).getPref_CurrentUserID_1weekmissed_time(this, v12_1);
                int v9 = AppsRunner.get(this).e(this, v12_1);
                if(v3 == 1) {
                    this.a(this.getResources().getString(0x7F0B0002), v8);  // string:STR_1_WEEK_MISSED "1 WEEK MISSED.\nREPEAT LAST WEEK."
                    AppsRunner.get(this).o(this, 0, v12_1);
                }
                else if(v7 == 1) {
                    this.a(this.getResources().getString(0x7F0B0003), v9);  // string:STR_2_WEEKS_MISSED "2 WEEKS MISSED.\nSTART OVER."
                    AppsRunner.get(this).q(this, 0, v12_1);
                }
            }
        }
        else if(v12 == 11 || v12 == 7 || v12 == 10) {
            this.N.setEnabled(false);
            this.ag.setVisibility(0);
            this.r.setVisibility(0);
            this.X.setBackgroundResource(0x7F060150);  // drawable:pad_select_program8_sel
        }
        else if(v12 == 8) {
            this.O.setEnabled(false);
            this.ah.setVisibility(0);
            this.r.setVisibility(0);
            this.Y.setBackgroundResource(0x7F06013E);  // drawable:pad_select_program10_sel
        }

        this.H();
        if(arg11) {
            AppsApplication v11 = (AppsApplication)this.getApplication();
            if(v11.isConnectionCorrect()) {
                int v12_2 = this.bq;
                if(v12_2 == 11 || v12_2 == 7) {
                    this.bq = 7;
                }
                else if(v12_2 == 10) {
                    this.bq = 10;
                }

                int v12_3 = this.bq;
                AppsRunner.get(this).f(this, v12_3);
                int v1 = this.bq;
                if(v1 == 11 || v1 == 7 || v1 == 10) {
                    j.a("===", "==选择CUSTOM，稍会将会收到setCustomProgram的ack==");
                    v11.i(false);
                    v11.c();
                }
                else if(v1 == 8) {
                    j.a("===", "==选择CUSTOM HR，稍会将会收到setCustomHRProgram的ack==");
                    v11.j(false);
                    v11.d();
                }

                AppsRunnerConnector.get(this).selectProgram(v12_3);
            }
        }
    }

    public void a(boolean arg3, boolean arg4, String arg5) {
        if(arg3) {
            this.b(this, this.getResources().getString(0x7F0B000F), false);  // string:STR_ALERT_TIP_SAVE_SESSION "Save workout result..."
        }

        this.bH = new Date();
        new Thread() {
            @Override
            public void run() {
                AppsRunner.get(AppsSettingActivity.this.getApplicationContext()).a(AppsSettingActivity.this.getApplicationContext(), AppsSettingActivity.f(AppsSettingActivity.this));
                if(((boolean)(((int)arg4)))) {
                    AppsRunner.get(AppsSettingActivity.this.getApplicationContext()).s();
                }

                Message v0 = new Message();
                v0.what = ((boolean)(((int)arg3)));
                v0.obj = arg5;
                AppsSettingActivity.this.j.sendMessage(v0);
            }
        }.start();
    }

    static int b(AppsSettingActivity arg0, int arg1) {
        arg0.bq = arg1;
        return arg1;
    }

    static LinearLayout b(AppsSettingActivity arg0) {
        return arg0.am;
    }

    private void b(LinearLayout arg7, float arg8, float arg9) {
        int v9_1;
        int v8;
        AnimatorSet v0 = new AnimatorSet();
        v0.playTogether(new Animator[]{ObjectAnimator.ofFloat(arg7, "scaleX", new float[]{arg8}), ObjectAnimator.ofFloat(arg7, "scaleY", new float[]{arg9}), ObjectAnimator.ofFloat(arg7, "y", new float[]{0.0f})});
        v0.setDuration(0L);
        v0.start();
        boolean v9 = apps.c.d.h(this);
        boolean v0_1 = apps.c.d.b();
        boolean v1 = apps.c.d.a();
        if(v9) {
            v8 = (int)(((float)(k.a(this, 1200.0f) / 4)) * arg8);
            v9_1 = k.a(this, 230.0f) / 4 - 100;
        }
        else if(v0_1) {
            v8 = (int)(((float)(k.a(this, 620.0f) / 4)) * arg8);
            v9_1 = k.a(this, 100.0f) / 4;
        }
        else {
            v8 = v1 ? ((int)(((float)(k.a(this, 1000.0f) / 4)) * arg8)) - 150 : ((int)(((float)(k.a(this, 1000.0f) / 4)) * arg8)) - 100;
            v9_1 = k.a(this, 230.0f) / 4 - 60;
        }

        FrameLayout.LayoutParams v0_2 = (FrameLayout.LayoutParams)arg7.getLayoutParams();
        v0_2.leftMargin = -v8;
        v0_2.topMargin = -v9_1;
        arg7.setLayoutParams(v0_2);
    }

    static void b(AppsSettingActivity arg0, LinearLayout arg1, float arg2, float arg3) {
        arg0.b(arg1, arg2, arg3);
    }

    static boolean b(AppsSettingActivity arg0, boolean arg1) {
        arg0.bE = arg1;
        return arg1;
    }

    public void b(int arg24, boolean arg25) {
        AppsSettingActivity v15 = this;
        StopWorkoutInfo v0 = v15.bv;
        if(v0 == null) {
            return;
        }

        WorkoutListMember v0_1 = v0.a();
        int v7 = v0_1.getCalories();
        int v1 = v0_1.getAverageHR();
        double v2 = (double)(((float)v0_1.getDistance()) / 100.0f);
        double v4 = (double)(((float)v0_1.getAverageSpeed()) / 10.0f);
        Date v8 = AppsRunner.get(this).getRunDate();
        int v13 = AppsRunner.get(this).getPref_CurrentUserID(v15);
        int v12 = apps.database.d.a().e(v15, v13);
        String v9 = ShareFitness.get(this).getPrefsMFP_UserId(v13 + "");
        boolean v11 = AppsRunner.get(this).inclineSupportsHalfDegree(v15);
        String v10 = ShareFitness.get(this).getPrefsMFPTokenId(v13 + "");
        int v14 = AppsRunner.get(this).B();
        int v0_2 = v15.bv == null ? 0 : v15.bv.g();
        int v18 = v12;
        int v17 = v13;
        float v6 = (float)(apps.c.d.a(v2 + "", 0.0) * 1.0);
        float v12_1 = (float)(apps.c.d.a(v4 + "", 0.0) * 1.0);
        int v2_1 = (int)apps.c.d.a(v1 + "", 0);
        float v3 = AppsRunner.get(this).T();
        float v4_1 = AppsRunner.get(this).U();
        int v5 = AppsRunner.get(this).V();
        int v13_1 = (int)apps.c.d.a(v1 + "", 0);
        if(!apps.c.d.d(this)) {
            SummaryArticle v1_1 = new SummaryArticle();
            v1_1.setSummaryDate(f.a(v8, "yyyy-MM-dd HH:mm:ss"));
            v1_1.setMmfToken("");
            v1_1.setMfpToken(v10);
            v1_1.setMfpUserId(v9);
            v1_1.setCalories(v7);
            v1_1.setElapsedTime(v0_2);
            v1_1.setTotalTime(v14);
            v1_1.setTotalDistance(v6);
            v1_1.setAverageSpeed(v12_1);
            v1_1.setAverageHR(v13_1);
            v1_1.setIsEp(((int)v11));
            v1_1.setUnits(v18);
            v1_1.setUserid(v17 + "");
            c.a().a(v15, v17 + "", v1_1);
            j.a("====", "无网络，先保存到本地ＭFP : " + v1_1);
            return;
        }

        int v16 = v17;
        int v17_1 = v18;
        if(v7 > 0 && v0_2 > 0 && !apps.c.d.strNotEmpty(v10) && !apps.c.d.a(v10, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
            int v18_1 = v0_2 >= 60 ? v0_2 : 60;
            j.a("==开始分享==", "====" + v10 + "  ||| " + ShareFitness.get(this).q(v10));
            HashMap v13_2 = new HashMap();
            v13_2.put("startDate", v8);
            v13_2.put("totalTime", Integer.valueOf(v14));
            v13_2.put("elapsedTime", Integer.valueOf(v18_1));
            v13_2.put("totalDistance", Float.valueOf(v6));
            v13_2.put("averageSpeed", Float.valueOf(v12_1));
            v13_2.put("averageHR", Integer.valueOf(v2_1));
            v13_2.put("calories", Integer.valueOf(v7));
            v13_2.put("maxSpeed", Float.valueOf(v3));
            v13_2.put("maxSpeedKPH", Float.valueOf(v4_1));
            v13_2.put("maxHR", Integer.valueOf(v5));
            com.xtremeprog.shell.treadmillv2.activity.AppsSettingActivity.31 v22 = new apps.c.m.a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().a(AppsSettingActivity.this, "afgfitness", "c7e6915ed48f7befbaa3", v10, ((int)v11), v17_1, v9, v13_2);
                    if(!apps.c.d.strNotEmpty(v0)) {
                        AppsArticle v1 = AppsArticle.toAppsArticle(v0);
                        if(v1 != null) {
                            v1.setJson(v0);
                        }

                        j.a("==MFP json ==", v0 + " |");
                        return v1;
                    }

                    return null;
                }
            };
            new apps.c.m.b() {
                @Override  // apps.c.m$b
                public void a(Object arg8) {
                    int v0 = 0;
                    if(arg8 != null) {
                        try {
                            AppsArticle v8_1 = (AppsArticle)arg8;
                            String v2 = v8_1.getError();
                            if(apps.c.d.b(v8_1.getJson()).indexOf("Expired token") != -1) {
                                SummaryArticle v2_1 = new SummaryArticle();
                                v2_1.setSummaryDate(f.a(v8, "yyyy-MM-dd HH:mm:ss"));
                                v2_1.setMmfToken("");
                                v2_1.setMfpToken(v10);
                                v2_1.setMfpUserId(v9);
                                v2_1.setCalories(v7);
                                v2_1.setElapsedTime(v18_1);
                                v2_1.setTotalTime(v14);
                                v2_1.setTotalDistance(v6);
                                v2_1.setAverageSpeed(v12_1);
                                v2_1.setAverageHR(v13_1);
                                v2_1.setIsEp(((int)v11));
                                v2_1.setUnits(v17_1);
                                v2_1.setUserid(v16 + "");
                                c.a().a(AppsSettingActivity.this, v16 + "", v2_1);
                                j.a("====", "等MFP refresh token，先保存到本地MFP : " + v8_1);
                                ((AppsApplication)AppsSettingActivity.this.getApplication()).doRefreshMFPToken2(v16 + "", 1);
                                return;
                            }

                            boolean v8_2 = apps.c.d.strNotEmpty(v2);
                        }
                        catch(Exception v8) {
                            v8.printStackTrace();
                            goto label_85;
                        }

                        if(v8_2) {
                            v0 = 1;
                        }
                    }

                label_85:
                    if(v0 == 0) {
                        if(arg24 < 999) {
                            j.a("====", "MFP RETRY TO SHARE");
                            AppsSettingActivity.this.b(arg24 + 1, arg25);
                            return;
                        }

                        j.a("====", "MFP FAILED TO SHARE");
                    }
                    else {
                        j.a("====", "MFP SUCCESS TO SHARE");
                        if(arg25) {
                            String v0_1 = AppsSettingActivity.this.getResources().getString(0x7F0B00BF);  // string:STR_SHARE_SUCCESS "Successfully Shared"
                            AppsSettingActivity.this.b(v0_1);
                            return;
                        }
                    }
                }
            };
            m.a(v22, null);
            return;
        }

        j.a("==mfpToken为空或其他==", "==暂不分享MFP===");
    }

    public void b(boolean arg7) {
        if(!this.bu) {
            return;
        }

        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        if(v0 == 0) {
            return;
        }

        int v1 = AppsRunner.get(this).Y();
        int v2 = AppsRunner.get(this).ad();
        int v1_1 = AppsRunnerConnector.get(this).customHRCRCStra(v0 + "", v1, v2);
        if(arg7) {
            AppsRunner.get(this).n(this, v1_1, v0);
        }
    }

    static LinearLayout c(AppsSettingActivity arg0) {
        return arg0.an;
    }

    static boolean c(AppsSettingActivity arg0, boolean arg1) {
        arg0.bC = arg1;
        return arg1;
    }

    public void c(int arg24, boolean arg25) {
        AppsSettingActivity v15 = this;
        StopWorkoutInfo v0 = v15.bv;
        if(v0 == null) {
            return;
        }

        WorkoutListMember v0_1 = v0.a();
        int v7 = v0_1.getCalories();
        int v1 = v0_1.getAverageHR();
        double v2 = (double)(((float)v0_1.getDistance()) / 100.0f);
        double v4 = (double)(((float)v0_1.getAverageSpeed()) / 10.0f);
        Date v8 = AppsRunner.get(this).getRunDate();
        int v13 = AppsRunner.get(this).getPref_CurrentUserID(v15);
        int v12 = apps.database.d.a().e(v15, v13);
        String v9 = ShareFitness.get(this).getPrefsFitbitUserId(v13 + "");
        boolean v11 = AppsRunner.get(this).inclineSupportsHalfDegree(v15);
        String v10 = ShareFitness.get(this).getPrefsFitbitTokenId(v13 + "");
        int v14 = AppsRunner.get(this).B();
        int v0_2 = v15.bv == null ? 0 : v15.bv.g();
        int v18 = v12;
        int v17 = v13;
        float v6 = (float)(apps.c.d.a(v2 + "", 0.0) * 1.0);
        float v12_1 = (float)(apps.c.d.a(v4 + "", 0.0) * 1.0);
        int v2_1 = (int)apps.c.d.a(v1 + "", 0);
        float v3 = AppsRunner.get(this).T();
        float v4_1 = AppsRunner.get(this).U();
        int v5 = AppsRunner.get(this).V();
        int v13_1 = (int)apps.c.d.a(v1 + "", 0);
        if(!apps.c.d.d(this)) {
            SummaryArticle v1_1 = new SummaryArticle();
            v1_1.setSummaryDate(f.a(v8, "yyyy-MM-dd HH:mm:ss"));
            v1_1.setMmfToken("");
            v1_1.setFitbitToken(v10);
            v1_1.setFitbitUserId(v9);
            v1_1.setCalories(v7);
            v1_1.setElapsedTime(v0_2);
            v1_1.setTotalTime(v14);
            v1_1.setTotalDistance(v6);
            v1_1.setAverageSpeed(v12_1);
            v1_1.setAverageHR(v13_1);
            v1_1.setIsEp(((int)v11));
            v1_1.setUnits(v18);
            v1_1.setUserid(v17 + "");
            c.a().a(v15, v17 + "", v1_1);
            j.a("====", "无网络，先保存到本地FB : " + v1_1);
            return;
        }

        int v16 = v17;
        int v17_1 = v18;
        if(v7 > 0 && v0_2 > 0 && !apps.c.d.strNotEmpty(v10) && !apps.c.d.a(v10, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
            int v18_1 = v0_2 >= 60 ? v0_2 : 60;
            j.a("==开始分享==", "====" + v10 + "  ||| " + ShareFitness.get(this).r(v10));
            HashMap v13_2 = new HashMap();
            v13_2.put("startDate", v8);
            v13_2.put("totalTime", Integer.valueOf(v14));
            v13_2.put("elapsedTime", Integer.valueOf(v18_1));
            v13_2.put("totalDistance", Float.valueOf(v6));
            v13_2.put("averageSpeed", Float.valueOf(v12_1));
            v13_2.put("averageHR", Integer.valueOf(v2_1));
            v13_2.put("calories", Integer.valueOf(v7));
            v13_2.put("maxSpeed", Float.valueOf(v3));
            v13_2.put("maxSpeedKPH", Float.valueOf(v4_1));
            v13_2.put("maxHR", Integer.valueOf(v5));
            com.xtremeprog.shell.treadmillv2.activity.AppsSettingActivity.33 v22 = new apps.c.m.a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().b(AppsSettingActivity.this, "227WN7", "2a036801e9f03a1186a4204415354c90", v10, ((int)v11), v17_1, v9, v13_2);
                    if(!apps.c.d.strNotEmpty(v0)) {
                        AppsArticle v1 = AppsArticle.toAppsArticle(v0);
                        if(v1 != null) {
                            v1.setJson(v0);
                        }

                        j.a("==FB json ==", v0 + " |");
                        return v1;
                    }

                    return null;
                }
            };
            new apps.c.m.b() {
                @Override  // apps.c.m$b
                public void a(Object arg8) {
                    int v0 = 0;
                    if(arg8 != null) {
                        try {
                            AppsArticle v8_1 = (AppsArticle)arg8;
                            String v2 = v8_1.getError();
                            String v3 = v8_1.getJson();
                            if(apps.c.d.b(v3).indexOf("Expired token") != -1 || apps.c.d.b(v3).indexOf("ACCESSTOKEN_EXPIRED") != -1 || apps.c.d.b(v3).indexOf("ACCESSTOKEN_NOT_FOUND") != -1) {
                                goto label_24;
                            }

                            if(apps.c.d.strNotEmpty(v2)) {
                                v0 = 1;
                                goto label_94;
                            label_24:
                                SummaryArticle v2_1 = new SummaryArticle();
                                v2_1.setSummaryDate(f.a(v8, "yyyy-MM-dd HH:mm:ss"));
                                v2_1.setMmfToken("");
                                v2_1.setFitbitToken(v10);
                                v2_1.setFitbitUserId(v9);
                                v2_1.setCalories(v7);
                                v2_1.setElapsedTime(v18_1);
                                v2_1.setTotalTime(v14);
                                v2_1.setTotalDistance(v6);
                                v2_1.setAverageSpeed(v12_1);
                                v2_1.setAverageHR(v13_1);
                                v2_1.setIsEp(((int)v11));
                                v2_1.setUnits(v17_1);
                                v2_1.setUserid(v16 + "");
                                c.a().a(AppsSettingActivity.this, v16 + "", v2_1);
                                j.a("====", "等FB refresh token，先保存到本地FB : " + v8_1);
                                ((AppsApplication)AppsSettingActivity.this.getApplication()).doRefreshFBToken2(v16 + "", 1);
                                return;
                            }
                        }
                        catch(Exception v8) {
                            v8.printStackTrace();
                        }
                    }

                label_94:
                    if(v0 == 0) {
                        if(arg24 < 999) {
                            j.a("====", "FB RETRY TO SHARE");
                            AppsSettingActivity.this.c(arg24 + 1, arg25);
                            return;
                        }

                        j.a("====", "FB FAILED TO SHARE");
                    }
                    else {
                        j.a("====", "FB SUCCESS TO SHARE");
                        if(arg25) {
                            String v0_1 = AppsSettingActivity.this.getResources().getString(0x7F0B00BF);  // string:STR_SHARE_SUCCESS "Successfully Shared"
                            AppsSettingActivity.this.b(v0_1);
                            return;
                        }
                    }
                }
            };
            m.a(v22, null);
            return;
        }

        j.a("==fbToken为空或其他==", "==暂不分享FB===");
    }

    public void c(boolean arg4) {
        j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)arg4))));
        if(arg4) {
            this.bM.setVisibility(0);
            this.n.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.n.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.bM.setVisibility(8);
        this.n.removeMessages(0x6F);
    }

    static AppsMeterView d(AppsSettingActivity arg0) {
        return arg0.aW;
    }

    static boolean d(AppsSettingActivity arg0, boolean arg1) {
        arg0.bF = arg1;
        return arg1;
    }

    static AppsMeterView e(AppsSettingActivity arg0) {
        return arg0.aX;
    }

    static boolean e(AppsSettingActivity arg0, boolean arg1) {
        arg0.bx = arg1;
        return arg1;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        int v2;
        Resources v1_1;
        TextView v0_3;
        String v8;
        TextView v0_1;
        int v1;
        Button v0;
        if(this.i != 0 && this.i != 1) {
            v0 = n.a().a(this, 0x7F0700DD);  // id:kmFinishButton
            v1 = 0x7F0B0007;  // string:STR_ABORTED "Aborted!"
        }
        else {
            v0 = n.a().a(this, 0x7F0700DD);  // id:kmFinishButton
            v1 = 0x7F0B0060;  // string:STR_FINISHED "Finished!"
        }

        v0.setText(v1);
        n.a().e(this, 0x7F0700E1).setText(0x7F0B00DB);  // id:kmFinishWeekTextView
        n.a().e(this, 0x7F0700E3).setText(0x7F0B0105);  // id:kmFinishWorkoutTextView
        n.a().e(this, 0x7F0700DF).setText(0x7F0B00AB);  // id:kmFinishNextWorkoutTextView
        n.a().a(this, 0x7F0700E8).setText(0x7F0B00CA);  // id:kmSummaryButton
        n.a().e(this, 0x7F070275).setText(this.getResources().getString(0x7F0B00C5));  // id:startTextView
        n.a().e(this, 0x7F070276).setText(this.getResources().getString(0x7F0B00C5));  // id:startTextView_2
        n.a().e(this, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        n.a().e(this, 0x7F0700D0).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView_2
        n.a().e(this, 0x7F07009F).setText(this.getResources().getString(0x7F0B0048));  // id:editTextView_2
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F07007A).setText(this.getResources().getString(0x7F0B00CD));  // id:customTimeTextView
        n.a().e(this, 0x7F070051).setText(this.getResources().getString(0x7F0B0037));  // id:customDistanceTextView
        n.a().e(this, 0x7F070164).setText(this.getResources().getString(0x7F0B00A0));  // id:modeTextView1
        n.a().e(this, 0x7F070166).setText(this.getResources().getString(0x7F0B009A));  // id:modeTextView2
        n.a().e(this, 0x7F070167).setText(this.getResources().getString(0x7F0B0091));  // id:modeTextView3
        n.a().e(this, 0x7F070168).setText(this.getResources().getString(0x7F0B0087));  // id:modeTextView4
        n.a().e(this, 0x7F070169).setText(this.getResources().getString(0x7F0B0094));  // id:modeTextView5
        n.a().e(this, 0x7F07016A).setText(this.getResources().getString(0x7F0B0097));  // id:modeTextView6
        n.a().e(this, 0x7F07016B).setText(this.getResources().getString(0x7F0B00A7));  // id:modeTextView7
        n.a().e(this, 0x7F07016C).setText(this.getResources().getString(0x7F0B009D));  // id:modeTextView8
        n.a().e(this, 0x7F07016D).setText(this.getResources().getString(0x7F0B008A));  // id:modeTextView9
        n.a().e(this, 0x7F070165).setText(this.getResources().getString(0x7F0B0090));  // id:modeTextView10
        n.a().e(this, 0x7F0702BF).setText(this.getResources().getString(0x7F0B0045));  // id:tv_step1
        n.a().e(this, 0x7F070094).setText(this.getResources().getString(0x7F0B0046));  // id:distanceStep2TipTextView
        n.a().e(this, 0x7F0702AB).setText(this.getResources().getString(0x7F0B0046));  // id:tv_distance_step2_tip
        n.a().e(this, 0x7F07025B).setText(this.getResources().getString(0x7F0B0138));  // id:sprint8_note1
        n.a().e(this, 0x7F07025C).setText(this.getResources().getString(0x7F0B0139));  // id:sprint8_note2
        n.a().e(this, 0x7F07025D).setText(this.getResources().getString(0x7F0B013A));  // id:sprint8_note3
        if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
            v0_1 = n.a().e(this, 0x7F070094);  // id:distanceStep2TipTextView
            v8 = this.getResources().getString(0x7F0B0047);  // string:STR_DISTANCE_STEP2_TIP2 "Step 2. Select level"
        }
        else {
            v0_1 = n.a().e(this, 0x7F070094);  // id:distanceStep2TipTextView
            v8 = this.getResources().getString(0x7F0B0046);  // string:STR_DISTANCE_STEP2_TIP "Step 2. Select level & speed"
        }

        v0_1.setText(v8);
        n.a().e(this, 0x7F0702BF).setText(this.getResources().getString(0x7F0B0045));  // id:tv_step1
        n.a().e(this, 0x7F07029A).setText(this.getResources().getString(0x7F0B00DB));  // id:tv_5k_week
        n.a().e(this, 0x7F07029B).setText(this.getResources().getString(0x7F0B0105));  // id:tv_5k_workout
        n.a().e(this, 0x7F0702AA).setText(this.getResources().getString(0x7F0B0033));  // id:tv_days
        String v0_2 = this.getResources().getString(this.aJ[this.bL]);
        n.a().e(this, 0x7F070092).setText(v0_2);  // id:distanceProgramTextView
        n.a().e(this, 0x7F070257).setText(0x7F0B0131);  // id:sprint8_max_incline
        if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
            n.a().e(this, 0x7F070094).setText(this.getResources().getString(0x7F0B0047));  // id:distanceStep2TipTextView
            v0_3 = n.a().e(this, 0x7F070259);  // id:sprint8_max_speed
            v1_1 = this.getResources();
            v2 = 0x7F0B0132;  // string:max_resistance "max.resistance"
        }
        else {
            n.a().e(this, 0x7F070094).setText(this.getResources().getString(0x7F0B0046));  // id:distanceStep2TipTextView
            v0_3 = n.a().e(this, 0x7F070259);  // id:sprint8_max_speed
            v1_1 = this.getResources();
            v2 = 0x7F0B0133;  // string:max_speed "max.speed"
        }

        v0_3.setText(v1_1.getString(v2));
        this.H();
        this.av.a();
        this.aw.a();
        this.aB.a();
        this.aC.a();
        this.aD.a();
        this.aE.a();
        this.aF.a();
        this.aG.a();
        this.aO.a();
        this.aP.a();
        this.aQ.a();
        this.aR.a();
        this.aS.a();
        this.aT.a();
        this.aU.a();
        this.aV.a();
        this.aW.a();
        this.aX.a();
        this.myFirst5k_walkSpeed.a();
        this.myFirst5k_jogSpeed.a();
        this.ba.a();
        this.ao.b();
        this.ap.b();
        this.aq.b();
    }

    static Date f(AppsSettingActivity arg0) {
        return arg0.bH;
    }

    static boolean f(AppsSettingActivity arg0, boolean arg1) {
        arg0.by = arg1;
        return arg1;
    }

    static com.xtremeprog.shell.treadmillv2.f g(AppsSettingActivity arg0) {
        return arg0.O();
    }

    static boolean g(AppsSettingActivity arg0, boolean arg1) {
        arg0.bD = arg1;
        return arg1;
    }

    static int h(AppsSettingActivity arg0) {
        return arg0.bm;
    }

    static AppsMeterView i(AppsSettingActivity arg0) {
        return arg0.myFirst5k_walkSpeed;
    }

    static AppsMeterView j(AppsSettingActivity arg0) {
        return arg0.myFirst5k_jogSpeed;
    }

    static AppsMeterView k(AppsSettingActivity arg0) {
        return arg0.ba;
    }

    static boolean l(AppsSettingActivity arg0) {
        return arg0.bs;
    }

    public void l() {
        int v0 = this.bm;
        if(v0 == 0) {
            this.bn.setBackgroundResource(0x7F060116);  // drawable:pad_data_display_l3
            this.bo.setBackgroundResource(0x7F060114);  // drawable:pad_data_display_l
            this.bn.setOnTouchListener(null);
            this.bo.setOnTouchListener(this);
            return;
        }

        if(v0 == 1) {
            this.bo.setBackgroundResource(0x7F060116);  // drawable:pad_data_display_l3
            this.bn.setBackgroundResource(0x7F060114);  // drawable:pad_data_display_l
            this.bn.setOnTouchListener(this);
            this.bo.setOnTouchListener(null);
        }
    }

    static int m(AppsSettingActivity arg0) {
        return arg0.br;
    }

    public void m() {
        try {
            if(this.bG != null && (this.bG.isShowing())) {
                this.bG.dismiss();
                this.bG = null;
            }

            apps.views.d.a v0_1 = new apps.views.d.a(this);
            v0_1.b(0x7F0B0134);  // string:prompt "Warning"
            v0_1.a(0x7F0B0020);  // string:STR_CONGRATULATIONS "CONGRATULATIONS"
            v0_1.a(true);
            this.bG = v0_1.a();
            this.bG.setCancelable(true);
            this.bG.setCanceledOnTouchOutside(true);
            this.bG.show();
        }
        catch(Exception v0) {
            v0.printStackTrace();
        }
    }

    static LinearLayout n(AppsSettingActivity arg0) {
        return arg0.ac;
    }

    public void n() {
        if(this.bq == 5) {
            double v0 = this.myFirst5k_walkSpeed.getValue();
            double v2 = this.myFirst5k_jogSpeed.getValue();
            if(AppsRunner.get(this).Y() == 1) {
                v0 = Conversions.a(v0);
                v2 = Conversions.a(v2);
            }

            int v4 = AppsRunner.get(this).getPref_CurrentUserID(this);
            int v0_1 = (int)(v0 * 10.0);
            int v1 = (int)(v2 * 10.0);
            AppsRunner.get(this).f(this, v0_1, v4);
            AppsRunner.get(this).g(this, v1, v4);
            j.a("==APP start,保存下5k的speed==", v4 + " : " + v0_1 + " , " + v1);
        }
    }

    static LinearLayout o(AppsSettingActivity arg0) {
        return arg0.ad;
    }

    public void o() {
        if(!this.bu) {
            return;
        }

        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        if(v0 == 0) {
            return;
        }

        int v1 = AppsRunner.get(this).Y();
        int v1_1 = AppsRunnerConnector.get(this).getCustomCRC(v0 + "", v1);
        AppsRunner.get(this).m(this, v1_1, v0);
    }

    @Override  // android.app.Activity
    public void onActivityResult(int arg35, int arg36, Intent arg37) {
        float v5_5;
        float v32;
        float v4_6;
        float v31;
        float v30;
        int v21;
        float v8_1;
        int v27_1;
        AppsSettingActivity v6;
        float v12_2;
        float v28;
        int v36;
        AppsSettingActivity v0 = this;
        int v1 = arg35;
        if(arg36 == -1) {
            if(v1 == 0x6F) {
                if(arg37.getExtras() != null) {
                    if(arg37.getExtras().get("isBack") != null) {
                        this.onBackPressed();
                        return;
                    }

                    if(arg37.getExtras().get("doNotSendSelectProgramAfterSaveProgramSuccess") != null) {
                        v0.bA = ((Boolean)arg37.getExtras().get("doNotSendSelectProgramAfterSaveProgramSuccess")).booleanValue();
                    }
                }

                HashMap v1_1 = new HashMap();
                HashMap v2 = new HashMap();
                HashMap v9 = new HashMap();
                int v10 = AppsRunner.get(this).Y();
                double v17 = 0.5;
                if(apps.c.d.a(arg37.getExtras().getString("type"), "TIME")) {
                    v0.bm = 0;
                    int v11 = AppsRunner.get(this).getPref_CurrentUserID(v0);
                    int v4 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(v0, v11 + "_maxSegment", Integer.valueOf(1), 1)));
                    if(v4 <= 0) {
                        v4 = 1;
                    }

                    j.a("==onActivityResult maxSegment==", v4 + " |");
                    int v12 = 0;
                    int v13 = 0;
                    int v15 = 0;
                    while(v12 < v4) {
                        int v12_1 = v12 + 1;
                        double v5 = arg37.getExtras().getDouble("speed" + v12_1);
                        double v7 = arg37.getExtras().getDouble("resistance" + v12_1);
                        int v26 = v4;
                        double v3 = arg37.getExtras().getDouble("incline" + v12_1);
                        int v27 = v11;
                        float v0_1 = arg37.getExtras().getFloat("segmentLength" + v12_1);
                        int v11_1 = v13;
                        while(true) {
                            v36 = v12_1;
                            v28 = v0_1 * 60.0f * 20.0f;
                            v12_2 = ((float)v13) + v28;
                            if(((float)v11_1) >= v12_2) {
                                break;
                            }

                            ++v11_1;
                            v1_1.put(Integer.valueOf(v11_1), Double.valueOf(v5));
                            v9.put(Integer.valueOf(v11_1), Double.valueOf(v3));
                            v2.put(Integer.valueOf(v11_1), Double.valueOf(v7));
                            v12_1 = v36;
                        }

                        v15 = (int)(((float)v15) + v28);
                        int v13_1 = (int)v12_2;
                        if(v10 == 1) {
                            v5 = apps.c.d.a(Conversions.a(v5), 3);
                        }

                        ContextSharedPreferences.SharedPreferencesEditor(this, v27 + "_speed_" + v36, Float.valueOf(((float)(v5 * 1.0))), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(this, v27 + "_resistance_" + v36, Float.valueOf(((float)(v7 * 1.0))), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(this, v27 + "_incline_" + v36, Float.valueOf(((float)(v3 * 1.0))), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(this, v27 + "_segmentLength_" + v36, Float.valueOf(v0_1), 3);
                        v0 = this;
                        v11 = v27;
                        v12 = v36;
                        v4 = v26;
                        v13 = v13_1;
                    }

                    v6 = v0;
                    int v26_1 = v4;
                    int v12_3 = v11;
                    if(v10 == 1) {
                        v17 = 0.8;
                    }

                    int v3_1 = v26_1;
                    while(v3_1 < 16) {
                        ++v3_1;
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v12_3 + "_speed_" + v3_1, Float.valueOf(((float)(v10 == 1 ? Conversions.a(v17) : v17 * 1.0))), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v12_3 + "_resistance_" + v3_1, Float.valueOf(1.0f), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v12_3 + "_incline_" + v3_1, Float.valueOf(0.0f), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v12_3 + "_segmentLength_" + v3_1, Float.valueOf(1.0f), 3);
                    }

                    int v0_2 = arg37.getExtras().getInt("time");
                    float v3_2 = arg37.getExtras().getFloat("maxSpeed");
                    float v4_1 = arg37.getExtras().getFloat("maxResistance");
                    float v5_1 = arg37.getExtras().getFloat("maxIncline");
                    v6.ao.setMaxSpeed(((int)v3_2));
                    v6.ao.setMaxResistance(((int)v4_1));
                    v6.ao.setMaxIncline(((int)v5_1));
                    ContextSharedPreferences.SharedPreferencesEditor(v6, v12_3 + "_time", Integer.valueOf(v0_2), 1);
                    ContextSharedPreferences.SharedPreferencesEditor(v6, v12_3 + "_maxSpeed", Float.valueOf(v3_2), 3);
                    ContextSharedPreferences.SharedPreferencesEditor(v6, v12_3 + "_maxResistance", Float.valueOf(v4_1), 3);
                    ContextSharedPreferences.SharedPreferencesEditor(v6, v12_3 + "_maxIncline", Float.valueOf(v5_1), 3);
                    if(AppsRunner.get(this).inclineSupportsHalfDegree(v6)) {
                        v6.ao.setFateResistanceDataSource(v2);
                    }
                    else {
                        v6.ao.setFateSpeedDataSource(v1_1);
                    }

                    v6.ao.setFateInclineDataSource(v9);
                    v6.ao.setFateTotalTime(v15);
                    v6.ao.setTotalTime(v15);
                    v6.ao.setCurrentTime(v15);
                    v6.ao.setZeroTimeStr("00:00");
                    v6.ao.setTotalTimeStr(apps.c.d.a(v15 / 20));
                }
                else {
                    v6 = v0;
                    v6.bm = 1;
                    int v3_3 = AppsRunner.get(this).getPref_CurrentUserID(v6);
                    int v8 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(v6, v3_3 + "_maxSegmentDis", Integer.valueOf(1), 1)));
                    if(v8 <= 0) {
                        v8 = 1;
                    }

                    j.a("==onActivityResult maxSegmentDis==", v8 + " |");
                    int v0_3 = 0;
                    int v4_2 = 0;
                    while(v0_3 < v8) {
                        ++v0_3;
                        double v11_2 = arg37.getExtras().getDouble("speed_dis" + v0_3);
                        double v13_2 = arg37.getExtras().getDouble("resistance_dis" + v0_3);
                        double v25 = arg37.getExtras().getDouble("incline_dis" + v0_3);
                        float v5_2 = arg37.getExtras().getFloat("segmentLengthDis" + v0_3);
                        int v7_1 = v4_2;
                        while(true) {
                            v27_1 = v8;
                            v8_1 = ((float)v4_2) + 200.0f * v5_2 * 20.0f;
                            if(((float)v7_1) >= v8_1) {
                                break;
                            }

                            ++v7_1;
                            v1_1.put(Integer.valueOf(v7_1), Double.valueOf(v11_2));
                            v9.put(Integer.valueOf(v7_1), Double.valueOf(v25));
                            v2.put(Integer.valueOf(v7_1), Double.valueOf(v13_2));
                            v8 = v27_1;
                        }

                        v4_2 = (int)v8_1;
                        if(v10 == 1) {
                            v11_2 = Conversions.a(v11_2);
                        }

                        ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_speed_dis_" + v0_3, Float.valueOf(((float)(v11_2 * 1.0))), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_resistance_dis_" + v0_3, Float.valueOf(((float)(v13_2 * 1.0))), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_incline_dis_" + v0_3, Float.valueOf(((float)(v25 * 1.0))), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_segmentLengthDis_" + v0_3, Float.valueOf(v5_2), 3);
                        v8 = v27_1;
                    }

                    int v27_2 = v8;
                    if(v10 == 1) {
                        v17 = 0.8;
                    }

                    int v4_3 = v27_2;
                    while(v4_3 < 16) {
                        ++v4_3;
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_speed_dis_" + v4_3, Float.valueOf(((float)(v10 == 1 ? Conversions.a(v17) : v17 * 1.0))), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_resistance_dis_" + v4_3, Float.valueOf(1.0f), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_incline_dis_" + v4_3, Float.valueOf(0.0f), 3);
                        ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_segmentLengthDis_" + v4_3, Float.valueOf(0.1f), 3);
                    }

                    int v0_4 = arg37.getExtras().getInt("distance");
                    float v4_4 = arg37.getExtras().getFloat("maxSpeed");
                    float v5_3 = arg37.getExtras().getFloat("maxResistance");
                    float v7_2 = arg37.getExtras().getFloat("maxIncline");
                    ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_distance", Integer.valueOf(v0_4), 1);
                    ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_maxSpeed", Float.valueOf(v4_4), 3);
                    ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_maxResistance", Float.valueOf(v5_3), 3);
                    ContextSharedPreferences.SharedPreferencesEditor(v6, v3_3 + "_maxIncline", Float.valueOf(v7_2), 3);
                    v6.ao.setMaxSpeed(((int)v4_4));
                    v6.ao.setMaxResistance(((int)v5_3));
                    v6.ao.setMaxIncline(((int)v7_2));
                    if(AppsRunner.get(this).inclineSupportsHalfDegree(v6)) {
                        v6.ao.setFateResistanceDataSource(v2);
                    }
                    else {
                        v6.ao.setFateSpeedDataSource(v1_1);
                    }

                    v6.ao.setFateInclineDataSource(v9);
                    int v2_1 = v0_4 * 20 * 20;
                    v6.ao.setFateTotalTime(v2_1);
                    v6.ao.setTotalTime(v2_1);
                    v6.ao.setCurrentTime(v2_1);
                    v6.ao.setZeroTimeStr("0");
                    v6.ao.setTotalTimeStr(apps.c.d.doubleToStr(((float)v0_4) / 10.0f, 1) + "");
                }

                v6.ao.invalidate();
                this.F();
                return;
            }

            v6 = v0;
            if(v1 == 0xDE) {
                if(arg37.getExtras() != null && arg37.getExtras().get("isBack") != null) {
                    this.onBackPressed();
                    return;
                }

                HashMap v0_5 = new HashMap();
                int v1_2 = AppsRunner.get(this).getPref_CurrentUserID(v6);
                arg37.getExtras().getString("maxHeartRate");
                arg37.getExtras().getString("segment");
                String v2_2 = arg37.getExtras().getString("age");
                int v3_4 = arg37.getExtras().getInt("time");
                float v4_5 = arg37.getExtras().getFloat("segmentLength1");
                float v5_4 = arg37.getExtras().getFloat("segmentLength2");
                float v7_3 = arg37.getExtras().getFloat("segmentLength3");
                float v8_2 = arg37.getExtras().getFloat("segmentLength4");
                double v9_1 = arg37.getExtras().getDouble("heartRateBPM1");
                double v11_3 = arg37.getExtras().getDouble("heartRateBPM2");
                double v13_3 = arg37.getExtras().getDouble("heartRateBPM3");
                String v35 = v2_2;
                double v15_1 = arg37.getExtras().getDouble("heartRateBPM4");
                int v2_3 = v3_4 - 0xF0;
                float v6_1 = v4_5 * 60.0f;
                int v17_1 = v1_2;
                int v1_3 = (int)(v6_1 + v5_4 * 60.0f + v7_3 * 60.0f + v8_2 * 60.0f);
                int v19 = v2_3 / v1_3;
                if(v2_3 % v1_3 != 0) {
                    ++v19;
                }

                int v20 = v3_4;
                int v3_5 = v19;
                int v24 = v1_3;
                int v1_4 = (int)(((float)(220 - AppsRunner.get(this).ad())) * 0.75f);
                double v26_2 = v15_1;
                float v16 = v8_2;
                int v8_3 = 0;
                while(v8_3 < 0xF0) {
                    ++v8_3;
                    v0_5.put(Integer.valueOf(v8_3), Double.valueOf(((double)v1_4) * 1.0));
                    v13_3 = v13_3;
                }

                double v28_1 = v13_3;
                int v8_4 = 0;
                int v13_4 = 0;
                while(v8_4 < v3_5) {
                    int v15_2 = 0xF0 + v13_4;
                    int v19_1 = v3_5;
                    int v14 = v15_2;
                    while(true) {
                        v21 = v1_4;
                        float v1_5 = (float)v15_2;
                        if(((float)v14) > v1_5 + v6_1 || v14 >= v2_3) {
                            break;
                        }

                        ++v14;
                        v0_5.put(Integer.valueOf(v14), Double.valueOf(v9_1));
                        v1_4 = v21;
                    }

                    int v3_6 = ((int)v6_1) + v15_2;
                    while(true) {
                        v30 = v4_5 + v5_4;
                        v31 = v4_5;
                        v4_6 = v30 * 60.0f;
                        if(((float)v3_6) > v1_5 + v4_6 || v3_6 >= v2_3) {
                            break;
                        }

                        ++v3_6;
                        v0_5.put(Integer.valueOf(v3_6), Double.valueOf(v11_3));
                        v4_5 = v31;
                    }

                    int v3_7 = ((int)v4_6) + v15_2;
                    while(true) {
                        float v14_1 = v30 + v7_3;
                        v32 = v5_4;
                        v5_5 = v14_1 * 60.0f;
                        if(((float)v3_7) > v1_5 + v5_5 || v3_7 >= v2_3) {
                            break;
                        }

                        ++v3_7;
                        v0_5.put(Integer.valueOf(v3_7), Double.valueOf(v28_1));
                        v5_4 = v32;
                    }

                    int v15_3 = v15_2 + ((int)v5_5);
                    while(((float)v15_3) <= (v14_1 + v16) * 60.0f + v1_5 && v15_3 < v2_3) {
                        ++v15_3;
                        v0_5.put(Integer.valueOf(v15_3), Double.valueOf(v26_2));
                    }

                    v13_4 += v24;
                    ++v8_4;
                    v3_5 = v19_1;
                    v1_4 = v21;
                    v4_5 = v31;
                    v5_4 = v32;
                }

                int v21_1 = v1_4;
                int v1_6 = v20;
                while(v2_3 < v1_6) {
                    ++v2_3;
                    v0_5.put(Integer.valueOf(v2_3), Double.valueOf(((double)v21_1) * 1.0));
                }

                int v2_4 = 0;
                while(v2_4 < 4) {
                    ++v2_4;
                    double v3_8 = arg37.getExtras().getDouble("heartRateBPM" + v2_4);
                    float v5_6 = arg37.getExtras().getFloat("segmentLength" + v2_4);
                    ContextSharedPreferences.SharedPreferencesEditor(this, v17_1 + "_hr_hr_" + v2_4, Float.valueOf(((float)(v3_8 * 1.0))), 3);
                    ContextSharedPreferences.SharedPreferencesEditor(this, v17_1 + "_segmentLength_hr_" + v2_4, Float.valueOf(v5_6), 3);
                }

                ContextSharedPreferences.SharedPreferencesEditor(this, v17_1 + "_age_hr", apps.c.d.a(v35), 1);
                ContextSharedPreferences.SharedPreferencesEditor(this, v17_1 + "_time_hr", Integer.valueOf(v1_6), 1);
                this.ap.setFateHeartRateDataSource(v0_5);
                this.ap.setFateTotalTime(v1_6);
                this.ap.setTotalTime(v1_6);
                this.ap.setCurrentTime(v1_6);
                this.ap.invalidate();
                this.G();
                return;
            }

            return;
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        if(this.ad.getVisibility() == 0) {
            AppsRunner.get(this).clear();
            AppsRunner.get(this).setCurrentStopWorkoutInfo(null);
        }

        this.n.removeMessages(0x6F);
        super.onBackPressed();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg4) {
        AppsRunner.get(this).b(this);
        j.a("===SettingActivity===", "====");
        super.onCreate(arg4);
        this.getWindow().setFlags(0x80, 0x80);
        this.a(0x7F09003D, 0x7F09004B, 0x7F09004D, 0x7F09004C);  // layout:activity_setting
        if(this.getIntent().getExtras() != null) {
            if(this.getIntent().getExtras().get("StopWorkoutInfo") != null) {
                this.bv = (StopWorkoutInfo)this.getIntent().getExtras().get("StopWorkoutInfo");
                this.bz = true;
            }

            if(this.getIntent().getExtras().get("Extra_Key_fromRunningDate") != null) {
                this.bw = (String)this.getIntent().getExtras().get("Extra_Key_fromRunningDate");
            }
        }

        this.M();
        this.K();
        this.L();
        this.N();
        this.a(true);
        int v4 = this.bq;
        if(v4 != 11 && v4 != 7 && v4 != 10) {
            if(v4 == 8) {
                this.z();
                return;
            }

            if(v4 == 5) {
                this.x();
                return;
            }
        }
        else {
            this.checkAppDeviceCRCs();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        super.onDestroy();
        this.a(false);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        int v15_1;
        AppsSettingActivity v0 = this;
        super.onResume();
        AppsApplication v1 = (AppsApplication)this.getApplication();
        v1.d(true);
        v0.bu = true;
        v0.bE = false;
        AppsRunner.get(this).b(v0);
        LinearLayout.LayoutParams v4 = (LinearLayout.LayoutParams)v0.F.getLayoutParams();
        LinearLayout.LayoutParams v5 = (LinearLayout.LayoutParams)v0.G.getLayoutParams();
        LinearLayout.LayoutParams v6 = (LinearLayout.LayoutParams)v0.H.getLayoutParams();
        LinearLayout.LayoutParams v7 = (LinearLayout.LayoutParams)v0.I.getLayoutParams();
        LinearLayout.LayoutParams v8 = (LinearLayout.LayoutParams)v0.J.getLayoutParams();
        LinearLayout.LayoutParams v9 = (LinearLayout.LayoutParams)v0.K.getLayoutParams();
        LinearLayout.LayoutParams v10 = (LinearLayout.LayoutParams)v0.L.getLayoutParams();
        LinearLayout.LayoutParams v11 = (LinearLayout.LayoutParams)v0.M.getLayoutParams();
        LinearLayout.LayoutParams v12 = (LinearLayout.LayoutParams)v0.N.getLayoutParams();
        LinearLayout.LayoutParams v13 = (LinearLayout.LayoutParams)v0.O.getLayoutParams();
        boolean v14 = AppsRunner.get(this).r(v0);
        boolean v15 = apps.c.d.h(this);
        boolean v16 = apps.c.d.b();
        boolean v17 = apps.c.d.a();
        if(v15) {
            v15_1 = 80;
            if(!v14) {
                v15_1 = 0x5F;
            }
        }
        else if(v16) {
            v15_1 = 75;
            if(!v14) {
                v15_1 = 90;
            }
        }
        else if(v17) {
            v15_1 = 0x30;
            if(!v14) {
                v15_1 = 0x3F;
            }
        }
        else {
            v15_1 = 55;
            if(!v14) {
                v15_1 = 70;
            }
        }

        if(v14) {
            v0.F.setVisibility(0);
            v0.O.setVisibility(0);
        }
        else {
            v0.F.setVisibility(8);
            v0.O.setVisibility(8);
        }

        float v2 = (float)v15_1;
        v4.width = k.a(v0, v2);
        v5.width = k.a(v0, v2);
        v6.width = k.a(v0, v2);
        v7.width = k.a(v0, v2);
        v8.width = k.a(v0, v2);
        v9.width = k.a(v0, v2);
        v10.width = k.a(v0, v2);
        v11.width = k.a(v0, v2);
        v12.width = k.a(v0, v2);
        v13.width = k.a(v0, v2);
        v0.F.setLayoutParams(v4);
        v0.G.setLayoutParams(v5);
        v0.H.setLayoutParams(v6);
        v0.I.setLayoutParams(v7);
        v0.J.setLayoutParams(v8);
        v0.K.setLayoutParams(v9);
        v0.L.setLayoutParams(v10);
        v0.M.setLayoutParams(v11);
        v0.N.setLayoutParams(v12);
        v0.O.setLayoutParams(v13);
        boolean v2_1 = AppsRunner.get(this).inclineSupportsHalfDegree(v0);
        if(v2_1) {
            v0.ao.setShowSpeedTipTitle(false);
            v0.ao.setShowResistanceTipTitle(true);
        }
        else {
            v0.ao.setShowSpeedTipTitle(true);
            v0.ao.setShowResistanceTipTitle(false);
        }

        v0.ao.setShowInclineTipTitle(true);
        v0.ao.setShowHeartRateTipTitle(false);
        v0.ao.setShowCaloriesTipTitle(false);
        v0.ao.setShowTimeTipTitle(false);
        v0.ao.setShowDisplayTimeTipTitle(false);
        v0.ao.setShowDisplayElapsedTimeTipTitle(false);
        v0.ap.setShowSpeedTipTitle(false);
        v0.ap.setShowInclineTipTitle(false);
        v0.ap.setShowResistanceTipTitle(false);
        v0.ap.setShowCaloriesTipTitle(false);
        v0.ap.setShowTimeTipTitle(false);
        v0.ap.setShowDisplayTimeTipTitle(false);
        v0.ap.setShowDisplayElapsedTimeTipTitle(false);
        v0.aq.setShowSpeedTipTitle(true);
        v0.aq.setShowInclineTipTitle(true);
        v0.aq.setShowCaloriesTipTitle(true);
        v0.aq.setShowTimeTipTitle(false);
        v0.aq.setShowDisplayTimeTipTitle(false);
        v0.aq.setShowDisplayElapsedTimeTipTitle(false);
        if(v2_1) {
            v0.aq.setShowResistanceTipTitle(true);
        }
        else {
            v0.aq.setShowResistanceTipTitle(false);
        }

        this.setTextWeekWorkout();
        if((AppsRunnerConnector.get(this).isConnected()) && (v1.n())) {
            j.a("===", "===Setting已连接===");
            v0.c(false);
        }
        else {
            j.a("===", "===Setting未连接===");
            v0.c(true);
        }

        v0.bA = false;
        this.E();
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        ((AppsApplication)this.getApplication()).d(false);
        this.bu = false;
        this.bs = false;
        this.l.removeMessages(88888);
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg17, MotionEvent arg18) {
        AppsApplication v0_11;
        Handler v5_1;
        Message v0_7;
        AppsRunner v0_6;
        AppsSettingActivity v1 = this;
        View v2 = arg17;
        if(arg18.getAction() == 0) {
            int v5 = 2;
            if(v2 == v1.F || v2 == v1.G || v2 == v1.H || v2 == v1.I || v2 == v1.J || v2 == v1.K || v2 == v1.L || v2 == v1.M || v2 == v1.N || v2 == v1.O) {
                v1.bI = this.a(arg17);
                int shouldStopWhenChangeRunMode = AppsRunner.get(this).shouldStopWhenChangeRunMode(v1.bI);
                j.a("-----切换了模式-----", shouldStopWhenChangeRunMode + " |");  // Switched mode
                if(shouldStopWhenChangeRunMode > 0) {
                    try {
                        apps.views.d.a v2_1 = new apps.views.d.a(v1);
                        v2_1.b(0x7F0B0134);  // string:prompt "Warning"
                        Resources v3 = this.getResources();
                        int v0_2 = shouldStopWhenChangeRunMode == 2 ? 0x7F0B0014 : 0x7F0B0013;  // string:STR_ALERT_TIP_STOP_RUN3 "If you change to the Fit Test program, your current workout information will be lost. Do you wish to end your current workout?"
                        v2_1.a(v3.getString(v0_2));
                        v2_1.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                            @Override  // android.content.DialogInterface$OnClickListener
                            public void onClick(DialogInterface arg3, int arg4) {
                                try {
                                    arg3.dismiss();
                                }
                                catch(Exception v3) {
                                    v3.printStackTrace();
                                }

                                AppsSettingActivity.this.a(true, false, "");
                            }
                        });
                        v2_1.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
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
                        v2_1.a().show();
                    }
                    catch(Exception v0_1) {
                        v0_1.printStackTrace();
                    }

                    return true;
                }
            }

            if(v2 == v1.v || v2 == v1.w || v2 == v1.x) {
                if(v1.ad.getVisibility() == 0) {
                    AppsRunner.get(this).clear();
                    AppsRunner.get(this).setCurrentStopWorkoutInfo(null);
                    j.a("===", AppsRunner.get(this).getPref_CurrentUserID(v1) == 0 ? "setting 按 home set user" : "setting 按 home select user");
                    AppsRunner.get(this).selectUserInfo();
                }

                if(v2 == v1.w) {
                    v1.n.removeMessages(0x6F);
                    ((AppsApplication)this.getApplication()).h(true);
                }

                this.onBackPressed();
            }
            else if(v2 == v1.s) {
                int v0_3 = v1.bq;
                if(v0_3 == 11 || v0_3 == 7 || v0_3 == 10) {
                    if(!v1.bx) {
                        AppsApplication v0_5 = (AppsApplication)this.getApplication();
                        if(!v0_5.i()) {
                            j.a("===", "==还没有收到setCustomProgram的回调==");
                            v1.a(this.getResources().getString(0x7F0B00CB));  // string:STR_SYNCING_CUSTOM_PROGRAM_FROM_CONSOLE "SYNCING CUSTOM PROGRAM FROM CONSOLE"
                            if(v0_5.isConnectionCorrect()) {
                                j.a("===", "==由于还未收到setCustom，再发一次select program2==");
                                AppsRunnerConnector.get(this).selectProgram(v1.bq);
                            }

                            return true;
                        }

                        j.a("===", "==收到了setCustomProgram的回调==");
                    }

                    v1.b(v1, "", false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent v0 = new Intent(AppsSettingActivity.this, AppsSettingCustomEditActivity.class);
                            v0.putExtra("segmentType", AppsSettingActivity.h(AppsSettingActivity.this));
                            AppsSettingActivity.this.startActivityForResult(v0, 0x6F);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    AppsSettingActivity.this.f();
                                }
                            }, 500L);
                        }
                    }, 500L);
                }
                else if(v0_3 == 8) {
                    if(!v1.by) {
                        AppsApplication v0_4 = (AppsApplication)this.getApplication();
                        if(!v0_4.j()) {
                            j.a("===", "==还没有收到setCustomHRProgram的回调==");
                            v1.a(this.getResources().getString(0x7F0B00CB));  // string:STR_SYNCING_CUSTOM_PROGRAM_FROM_CONSOLE "SYNCING CUSTOM PROGRAM FROM CONSOLE"
                            if(v0_4.isConnectionCorrect()) {
                                j.a("===", "==由于还未收到setCustomHR，再发一次select program3==");
                                AppsRunnerConnector.get(this).selectProgram(v1.bq);
                            }

                            return true;
                        }

                        j.a("===", "==收到了setCustomHRProgram的回调==");
                    }

                    v1.b(v1, "", false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent v0 = new Intent(AppsSettingActivity.this, AppsSettingCustomHREditActivity.class);
                            AppsSettingActivity.this.startActivityForResult(v0, 0xDE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    AppsSettingActivity.this.f();
                                }
                            }, 500L);
                        }
                    }, 500L);
                }
            }
            else if(v2 == v1.t || v2 == v1.u) {
                if(!AppsRunnerConnector.get(this.getApplicationContext()).G()) {
                    j.a("===蓝牙未打开==", "==不能发startWorkout==");
                    v1.a(this.getResources().getString(0x7F0B000C));  // string:STR_ALERT_TIP_NOT_OPEN_BLUETOOTH "Please turn on your bluetooth within the device"
                    return true;
                }

                if(!AppsRunnerConnector.get(this).isConnected()) {
                    j.a("===蓝牙未连接==", "==不能发startWorkout==");
                    v1.a(this.getResources().getString(0x7F0B000B));  // string:STR_ALERT_TIP_CONNECT_DEVICE "Please connect your device"
                    return true;
                }

                if(AppsRunner.get(this).securitySwitch == 1) {
                    j.a("===安全锁拨出==", "==不能发startWorkout==");
                    ((AppsApplication)this.getApplication()).showSafetyAlert(AppsRunner.get(this).securitySwitch, -1, true);
                    return true;
                }

                if(v1.bF) {
                    v1.a("PLEASE CONFIRM THE DEVICE PROGRAM IS THE SAME TO THE APP PROGRAM");
                    return true;
                }

                com.xtremeprog.shell.treadmillv2.f v0_12 = this.O();
                if((v1.bq == 10 || v1.bq == 7 || v1.bq == 11) && !v1.bx) {
                    AppsApplication v9 = (AppsApplication)this.getApplication();
                    if(!v9.i()) {
                        j.a("===", "==还没有收到setCustomProgram的回调==");  // Have not received the callback of setCustomProgram
                        v1.a(this.getResources().getString(0x7F0B00CB));  // string:STR_SYNCING_CUSTOM_PROGRAM_FROM_CONSOLE "SYNCING CUSTOM PROGRAM FROM CONSOLE"
                        if(v9.isConnectionCorrect()) {
                            j.a("===", "==由于还未收到setCustom，再发一次select program1==");  // Since setCustom has not been received yet, send select program1 again
                            AppsRunnerConnector.get(this).selectProgram(v1.bq);
                        }

                        return true;
                    }

                    j.a("===", "==收到了setCustomProgram的回调==");  // Received the callback of setCustomProgram
                }

                if(AppsRunner.get(this).g()) {
                    int v9_1 = v1.bq;
                    if(v9_1 == 2) {
                        int v5_2 = AppsRunner.get(this).b(v0_12);
                        double v9_2 = AppsRunner.get(this).w();
                        int v11 = ((double)v5_2) > v9_2 ? 0 : 1;
                        j.a("==比较Distance==", v5_2 + " ? " + v9_2 + " = " + ((boolean)v11));
                        if(v11 != 0) {
                            try {
                                apps.views.d.a v0_14 = new apps.views.d.a(v1);
                                v0_14.b(0x7F0B0134);  // string:prompt "Warning"
                                v0_14.a(this.getResources().getString(0x7F0B0011));  // string:STR_ALERT_TIP_STOP_DUE_TO_DISTANCE "GOAL IS SHORTER THAN THE CURRENT WORKOUT SELECT YES TO END CURRENT WORKOUT SELECT NO TO ADJUST WORKOUT"
                                v0_14.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                                    @Override  // android.content.DialogInterface$OnClickListener
                                    public void onClick(DialogInterface arg3, int arg4) {
                                        try {
                                            arg3.dismiss();
                                        }
                                        catch(Exception v3) {
                                            v3.printStackTrace();
                                        }

                                        AppsSettingActivity.this.a(true, false, "Jump");
                                    }
                                });
                                v0_14.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
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
                                v0_14.a().show();
                            }
                            catch(Exception v0_13) {
                                v0_13.printStackTrace();
                            }

                            return true;
                        }
                    }
                    else if(v9_1 == 5 || v9_1 == 10 || v9_1 == 7 || v9_1 == 11 || v9_1 == 3 || v9_1 == 8) {
                        j.a("==不比较==", "==直接save==");
                        v1.a(true, false, "Jump");
                    }
                    else if(v9_1 == 4) {
                        int v5_3 = AppsRunner.get(this).b(v0_12);
                        double v9_3 = (double)AppsRunner.get(this).x();
                        int v11_1 = ((double)v5_3) > v9_3 ? 0 : 1;
                        j.a("==比较calories==", v5_3 + " ? " + v9_3 + " = " + ((boolean)v11_1));
                        if(v11_1 != 0) {
                            try {
                                apps.views.d.a v0_16 = new apps.views.d.a(v1);
                                v0_16.b(0x7F0B0134);  // string:prompt "Warning"
                                v0_16.a(this.getResources().getString(0x7F0B0010));  // string:STR_ALERT_TIP_STOP_DUE_TO_CALORIES "GOAL IS SHORTER THAN THE CURRENT WORKOUT SELECT YES TO END CURRENT WORKOUT SELECT NO TO ADJUST WORKOUT"
                                v0_16.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                                    @Override  // android.content.DialogInterface$OnClickListener
                                    public void onClick(DialogInterface arg3, int arg4) {
                                        try {
                                            arg3.dismiss();
                                        }
                                        catch(Exception v3) {
                                            v3.printStackTrace();
                                        }

                                        AppsSettingActivity.this.a(true, false, "Jump");
                                    }
                                });
                                v0_16.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
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
                                v0_16.a().show();
                            }
                            catch(Exception v0_15) {
                                v0_15.printStackTrace();
                            }

                            return true;
                        }
                    }
                    else {
                        int v5_4 = AppsRunner.get(this).b(v0_12);
                        int v9_4 = AppsRunner.get(this).A();
                        int v10 = v5_4 > v9_4 ? 0 : 1;
                        j.a("==比较时间==", v5_4 + " ? " + v9_4 + " = " + ((boolean)v10));
                        if(v10 != 0) {
                            try {
                                apps.views.d.a v0_18 = new apps.views.d.a(v1);
                                v0_18.b(0x7F0B0134);  // string:prompt "Warning"
                                v0_18.a(this.getResources().getString(0x7F0B0012));  // string:STR_ALERT_TIP_STOP_DUE_TO_TIME "GOAL IS SHORTER THAN THE CURRENT WORKOUT SELECT YES TO END CURRENT WORKOUT SELECT NO TO ADJUST WORKOUT"
                                v0_18.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                                    @Override  // android.content.DialogInterface$OnClickListener
                                    public void onClick(DialogInterface arg3, int arg4) {
                                        try {
                                            arg3.dismiss();
                                        }
                                        catch(Exception v3) {
                                            v3.printStackTrace();
                                        }

                                        AppsSettingActivity.this.a(true, false, "Jump");
                                    }
                                });
                                v0_18.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
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
                                v0_18.a().show();
                            }
                            catch(Exception v0_17) {
                                v0_17.printStackTrace();
                            }

                            return true;
                        }
                    }
                }

                if(v1.bE) {
                    j.a("===已经锁住==", "==不可以发startWorkout==");
                }
                else {
                    j.a("===未锁住==", "==可以发startWorkout==");
                    v1.bE = true;
                    AppsRunner.get(this).a(v0_12);
                    this.n();
                    AppsRunner.get(this).startWorkout();
                }
            }
            else if(v2 == v1.D) {
                com.xtremeprog.shell.treadmillv2.a.startWorkout(this);
            }
            else if(v2 == v1.E) {
                com.xtremeprog.shell.treadmillv2.a.stopWorkout(this);
            }
            else if(v2 == v1.F) {
                v1.bq = 9;
                v0_6 = AppsRunner.get(this);
                v5 = 9;
                v0_6.f(v1, v5);
                v1.a(true, false);
            }
            else {
                if(v2 == v1.G) {
                    v1.bq = 0;
                    AppsRunner.get(this).f(v1, 0);
                    v1.a(true, false);
                    goto label_650;
                }

                if(v2 == v1.H) {
                    v1.bq = 2;
                    v0_6 = AppsRunner.get(this);
                    v0_6.f(v1, v5);
                    v1.a(true, false);
                    goto label_650;
                }

                if(v2 == v1.I) {
                    v1.bq = 4;
                    AppsRunner.get(this).f(v1, 4);
                    v1.a(true, false);
                    goto label_650;
                }

                if(v2 == v1.J) {
                    v1.bq = 6;
                    v0_6 = AppsRunner.get(this);
                    v5 = 6;
                    v0_6.f(v1, v5);
                    v1.a(true, false);
                    goto label_650;
                }

                if(v2 == v1.K) {
                    v1.bq = 1;
                    AppsRunner.get(this).f(v1, 1);
                    v1.a(true, false);
                }
                else if(v2 == v1.L) {
                    v1.bq = 3;
                    AppsRunner.get(this).f(v1, 3);
                    v1.a(true, false);
                }
                else if(v2 == v1.M) {
                    v1.bC = true;
                    v1.a(v1, "", false);
                    v1.bq = 5;
                    AppsRunner.get(this).f(v1, 5);
                    v1.a(true, false);
                    this.x();
                    v1.o.removeMessages(0x6F);
                    v0_7 = new Message();
                    v0_7.what = 0x6F;
                    v1.o.sendMessageDelayed(v0_7, 18000L);
                }
                else if(v2 == v1.N) {
                    v1.bC = true;
                    v1.a(v1, "", false);
                    v1.bq = 11;
                    v1.a(true, false);
                    this.checkAppDeviceCRCs();
                    v1.o.removeMessages(0x6F);
                    v0_7 = new Message();
                    v0_7.what = 0x6F;
                    v5_1 = v1.o;
                    v5_1.sendMessageDelayed(v0_7, 12000L);
                }
                else {
                    if(v2 == v1.O) {
                        v1.bD = true;
                        v1.bq = 8;
                        AppsRunner.get(this).f(v1, 8);
                        v1.a(true, false);
                        this.z();
                        v1.a(v1, "", false);
                        v1.p.removeMessages(0xDE);
                        v0_7 = new Message();
                        v0_7.what = 0xDE;
                        v5_1 = v1.p;
                        v5_1.sendMessageDelayed(v0_7, 12000L);
                        goto label_650;
                    }

                    if(v2 != v1.myFirst5k_week && v2 != v1.myFirst5k_workout) {
                        if(v2 == v1.bd) {
                            try {
                                apps.views.d.a v0_9 = new apps.views.d.a(v1);
                                v0_9.b(0x7F0B0134);  // string:prompt "Warning"
                                v0_9.a(this.getResources().getString(0x7F0B00B5));  // string:STR_RESET_CONFIRM "ARE YOU SURE YOU WANT TO RESET?"
                                v0_9.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                                    @Override  // android.content.DialogInterface$OnClickListener
                                    public void onClick(DialogInterface arg3, int arg4) {
                                        float v0;
                                        AppsMeterView v3_1;
                                        try {
                                            arg3.dismiss();
                                        }
                                        catch(Exception v3) {
                                            v3.printStackTrace();
                                        }

                                        if(AppsRunner.get(AppsSettingActivity.this).Y() == 1) {
                                            AppsSettingActivity.i(AppsSettingActivity.this).setCurrentValue(3.2f);
                                            v3_1 = AppsSettingActivity.j(AppsSettingActivity.this);
                                            v0 = 5.6f;
                                        }
                                        else {
                                            AppsSettingActivity.i(AppsSettingActivity.this).setCurrentValue(2.0f);
                                            v3_1 = AppsSettingActivity.j(AppsSettingActivity.this);
                                            v0 = 3.5f;
                                        }

                                        v3_1.setCurrentValue(v0);
                                        AppsSettingActivity.k(AppsSettingActivity.this).setCurrentValue(0.0f);
                                        int v3_2 = AppsRunner.get(AppsSettingActivity.this).getPref_CurrentUserID(AppsSettingActivity.this);
                                        AppsRunner.get(AppsSettingActivity.this).setDeviceWeek(AppsSettingActivity.this, 1, v3_2);
                                        AppsRunner.get(AppsSettingActivity.this).setDeviceWorkout(AppsSettingActivity.this, 1, v3_2);
                                        AppsSettingActivity.this.setTextWeekWorkout();
                                        AppsSettingActivity.this.send_setMyFirst5k();
                                    }
                                });
                                v0_9.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
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
                                v0_9.a().show();
                            }
                            catch(Exception v0_8) {
                                v0_8.printStackTrace();
                            }
                        }
                        else if(v2 == v1.ar) {
                            if(!apps.c.d.strNotEmpty(v1.bt)) {
                                Intent v0_10 = new Intent(v1, AppsHistoryActivity.class);
                                v0_10.putExtra("Extra_Key_fromRunning", false);
                                v0_10.putExtra("Extra_Key_fromAppStop", true);
                                v0_10.putExtra("Extra_Key_from5KStop", true);
                                v0_10.putExtra("Extra_Key_fromRunningDate", v1.bt);
                                v1.startActivity(v0_10);
                                this.finish();
                            }
                        }
                        else if(v2 == v1.bo) {
                            v1.bm = 1;
                            v1.bq = 10;
                            AppsRunner.get(this).f(v1, v1.bq);
                            v1.a(false, false);
                            v0_11 = (AppsApplication)this.getApplication();
                            if(!v0_11.isConnectionCorrect()) {
                                goto label_374;
                            }

                            goto label_365;
                        }
                        else {
                            if(v2 != v1.bn) {
                                goto label_650;
                            }

                            v1.bm = 0;
                            v1.bq = 7;
                            AppsRunner.get(this).f(v1, v1.bq);
                            v1.a(false, false);
                            v0_11 = (AppsApplication)this.getApplication();
                            if(v0_11.isConnectionCorrect()) {
                            label_365:
                                j.a("===", "==选择CUSTOM，稍会将会收到setCustomProgram的ack==");
                                v0_11.i(false);
                                v0_11.c();
                                AppsRunnerConnector.get(this).selectProgram(v1.bq);
                            }

                        label_374:
                            this.l();
                            this.K();
                        }
                    }
                }
            }
        }

    label_650:
        if(arg18.getAction() == 0) {
            if(v2 == v1.aH) {
                this.r();
                return true;
            }

            if(v2 == v1.aI) {
                this.q();
                return true;
            }
        }
        else if(arg18.getAction() == 1 || arg18.getAction() == 3) {
            if(v2 == v1.aH) {
                this.t();
                return true;
            }

            if(v2 == v1.aI) {
                this.s();
            }
        }

        return true;
    }

    static Button p(AppsSettingActivity arg0) {
        return arg0.t;
    }

    public void setUser() {
        j.a("=====START前发SET USER======", "==========");
        ++this.bK;
        this.bs = true;
        AppsRunner.get(this).setUserInfo();
        if(this.bK > 4) {
            this.l.removeMessages(88888);
            return;
        }

        this.l.removeMessages(88888);
        Message v0 = new Message();
        v0.what = 88888;
        this.l.sendMessageDelayed(v0, 2000L);
    }

    static TextView q(AppsSettingActivity arg0) {
        return arg0.au;
    }

    public void q() {
        ++this.bL;
        if(this.bL > 12) {
            this.bL = 0;
        }

        String v0 = this.getResources().getString(this.aJ[this.bL]);
        this.aM.setText(v0);
        this.m.removeMessages(0x2B67);
        Message v0_1 = new Message();
        v0_1.what = 0x2B67;
        this.m.sendMessageDelayed(v0_1, 0xFAL);
    }

    static RelativeLayout r(AppsSettingActivity arg0) {
        return arg0.ak;
    }

    public void r() {
        --this.bL;
        if(this.bL < 0) {
            this.bL = 12;
        }

        String v0 = this.getResources().getString(this.aJ[this.bL]);
        this.aM.setText(v0);
        this.m.removeMessages(0x56CE);
        Message v0_1 = new Message();
        v0_1.what = 0x56CE;
        this.m.sendMessageDelayed(v0_1, 0xFAL);
    }

    static boolean s(AppsSettingActivity arg0) {
        return arg0.bu;
    }

    public void s() {
        this.m.removeMessages(0x2B67);
    }

    static void t(AppsSettingActivity arg0) {
        arg0.K();
    }

    public void t() {
        this.m.removeMessages(0x56CE);
    }

    static void u(AppsSettingActivity arg0) {
        arg0.L();
    }

    public void send_setMyFirst5k() {
        int currentUserId = AppsRunner.get(this).getPref_CurrentUserID(this);
        int week = (int)apps.c.d.a(this.myFirst5k_week.getText().toString(), 1);
        int workout = (int)apps.c.d.a(this.myFirst5k_workout.getText().toString(), 1);
        double walkspeed = this.myFirst5k_walkSpeed.getValue();
        double jogSpeed = this.myFirst5k_jogSpeed.getValue();
        double v8 = this.ba.getValue();
        int oldResetCount = AppsRunner.get(this).j(this);
        if(AppsRunner.get(this).Y() == 1) {
            walkspeed = Conversions.a(walkspeed);
            jogSpeed = Conversions.a(jogSpeed);
        }

        int resetCount = oldResetCount + 1;
        int _currentUserId = AppsRunner.get(this).getPref_CurrentUserID(this);
        AppsRunner.get(this).setDeviceResetCount(this, resetCount, _currentUserId);
        j.a("===setMyFirst5K===", currentUserId + " | " + week + " | " + workout + " | " + walkspeed + " | " + jogSpeed + " | " + v8);
        AppsApplication app = (AppsApplication)this.getApplication();
        app.myFirst5k_userId = currentUserId;
        app.myFirst5k_week = week;
        app.myFirst5k_workout = workout;
        app.myFirst5k_walkSpeed = walkspeed;
        app.myFirst5k_jogSpeed = jogSpeed;
        app.myFirst5k_resetCount = resetCount;
        BLEManager.get(this).maybe_send_message2(DeviceCommand.setMyFirst5K(Factory.MyFirst5K(currentUserId, week, workout, walkspeed, jogSpeed, resetCount)), 4, 1000);
    }

    public void setTextWeekWorkout() {
        int week = AppsRunner.get(this)._week(this);
        int workout = AppsRunner.get(this)._workout(this);
        AppsRunner.get(this).j(this);
        this.myFirst5k_week.setText(week + "");
        this.myFirst5k_workout.setText(workout + "");
    }

    public void w() {
        int v0 = AppsRunner.get(this)._week(this);
        int v1 = AppsRunner.get(this)._workout(this);
        double v5 = (double)(((float)AppsRunner.get(this).f(this)) / 10.0f);
        double v2 = (double)(((float)AppsRunner.get(this).g(this)) / 10.0f);
        if(AppsRunner.get(this).Y() == 1) {
            v5 = Conversions.b(v5);
            v2 = Conversions.b(v2);
        }

        this.myFirst5k_week.setText(v0 + "");
        this.myFirst5k_workout.setText(v1 + "");
        this.myFirst5k_walkSpeed.setCurrentValue(((float)(v5 * 1.0)));
        this.myFirst5k_jogSpeed.setCurrentValue(((float)(v2 * 1.0)));
    }

    public void x() {
    }

    public void checkAppDeviceCRCs() {
        if(this.bq == 11 || this.bq == 7 || this.bq == 10) {
            int v0 = AppsRunner.get(this).Y();
            int v1 = AppsRunner.get(this).getPref_CurrentUserID(this);
            if(v1 == 0) {
                return;
            }

            if(this.bA) {
                return;
            }

            int CRC1 = AppsRunnerConnector.get(this).getCustomCRC(v1 + "", v0);
            int CRC2 = AppsRunnerConnector.get(this)._maybe_getCRC();
            j.a("===开始比较校验码===", CRC1 + " == " + CRC2);  // Start comparing checksum
            if(CRC1 != CRC2) {
                j.a("===", "==APP和设备校验码不一致");  // APP and device check codes are inconsistent
                try {
                    apps.views.d.a v0_3 = new apps.views.d.a(this);
                    v0_3.b(0x7F0B0134);  // string:prompt "Warning"
                    v0_3.a(this.getResources().getString(0x7F0B0024));  // string:STR_CUSTOM_CHOOSE_CONSOLE_OR_APP "DO YOU WANT TO USE THE CUSTOM PROGRAM SAVED IN THE CONSOLE OR THE AFG APP?"
                    v0_3.a(this.getResources().getString(0x7F0B0015), new DialogInterface.OnClickListener() {  // string:STR_APP "APP"
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface arg1, int arg2) {
                            try {
                                arg1.dismiss();
                            }
                            catch(Exception v1) {
                                v1.printStackTrace();
                            }

                            j.a("===", "选择APP");
                            AppsSettingActivity.e(AppsSettingActivity.this, true);
                            AppsSettingActivity.this.D();
                        }
                    });
                    v0_3.b(this.getResources().getString(0x7F0B0023), new DialogInterface.OnClickListener() {  // string:STR_CONSOLE "CONSOLE"
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface arg1, int arg2) {
                            try {
                                arg1.dismiss();
                            }
                            catch(Exception v1) {
                                v1.printStackTrace();
                            }

                            j.a("===", "选择CONSOLE");
                            AppsSettingActivity.e(AppsSettingActivity.this, false);
                            AppsSettingActivity.this.B();
                        }
                    });
                    d v0_4 = v0_3.a();
                    v0_4.setCancelable(false);
                    v0_4.show();
                }
                catch(Exception v0_2) {
                    v0_2.printStackTrace();
                }

                return;
            }

            j.a("===", "==APP和设备校验码是一致的");  // APP and device check codes are the same
        }
    }

    public void z() {
        if(this.bq == 8) {
            int v0 = AppsRunner.get(this).Y();
            int v1 = AppsRunner.get(this).getPref_CurrentUserID(this);
            int v2 = AppsRunner.get(this).ad();
            if(v1 == 0) {
                return;
            }

            if(this.bA) {
                return;
            }

            int v0_1 = AppsRunnerConnector.get(this).customHRCRCStra(v1 + "", v0, v2);
            int v1_1 = AppsRunnerConnector.get(this).s();
            j.a("===开始比较HR校验码===", v0_1 + " == " + v1_1);
            if(v0_1 != v1_1) {
                j.a("===", "==APP和设备HR校验码不一致");
                try {
                    apps.views.d.a v0_3 = new apps.views.d.a(this);
                    v0_3.b(0x7F0B0134);  // string:prompt "Warning"
                    v0_3.a(this.getResources().getString(0x7F0B0025));  // string:STR_CUSTOM_CHOOSE_HR_CONSOLE_OR_APP "DO YOU WANT TO USE THE CUSTOM HEART RATE PROGRAM SAVED IN THE CONSOLE OR THE AFG APP?"
                    v0_3.a(this.getResources().getString(0x7F0B0015), new DialogInterface.OnClickListener() {  // string:STR_APP "APP"
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface arg1, int arg2) {
                            try {
                                arg1.dismiss();
                            }
                            catch(Exception v1) {
                                v1.printStackTrace();
                            }

                            j.a("===", "选择HRAPP");
                            AppsSettingActivity.f(AppsSettingActivity.this, true);
                            AppsSettingActivity.this.C();
                        }
                    });
                    v0_3.b(this.getResources().getString(0x7F0B0023), new DialogInterface.OnClickListener() {  // string:STR_CONSOLE "CONSOLE"
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface arg1, int arg2) {
                            try {
                                arg1.dismiss();
                            }
                            catch(Exception v1) {
                                v1.printStackTrace();
                            }

                            j.a("===", "选择HRCONSOLE");
                            AppsSettingActivity.f(AppsSettingActivity.this, false);
                            AppsSettingActivity.this.A();
                        }
                    });
                    d v0_4 = v0_3.a();
                    v0_4.setCancelable(false);
                    v0_4.show();
                }
                catch(Exception v0_2) {
                    v0_2.printStackTrace();
                }

                return;
            }

            j.a("===", "==APP和设备HR校验码是一致的");
        }
    }
}
