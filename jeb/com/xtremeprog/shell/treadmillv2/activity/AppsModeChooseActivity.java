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
import android.os.Process;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apps.activity.base.AppsRootActivity;
import apps.c.ContextSharedPreferences;
import apps.c.j;
import apps.c.k;
import apps.c.n;
import apps.views.d.a;
import apps.views.d;
import com.xpg.b.BLEManager;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import com.xtremeprog.shell.treadmillv2.AppsUnMatchActivity;
import com.xtremeprog.shell.treadmillv2.ShareFitness;
import java.util.Date;

public class AppsModeChooseActivity extends AppsRootActivity implements View.OnTouchListener {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private ImageView M;
    private ImageView N;
    private ImageView O;
    private ImageView P;
    private ImageView Q;
    private ImageView R;
    private ImageView S;
    private ImageView T;
    private ImageView U;
    private ImageView V;
    private LinearLayout W;
    private LinearLayout X;
    private LinearLayout Y;
    private LinearLayout Z;
    private View aA;
    private View aB;
    private View aC;
    private View aD;
    private View aE;
    private View aF;
    private int aG;
    private int aH;
    private int aI;
    private int aJ;
    private int aK;
    private boolean aL;
    private boolean aM;
    private boolean aN;
    private boolean aO;
    private int aP;
    private BroadcastReceiver aQ;
    private boolean aR;
    private Date aS;
    private d aT;
    private LinearLayout aa;
    private RelativeLayout ab;
    private RelativeLayout ac;
    private Button ad;
    private TextView ae;
    private RelativeLayout af;
    private TextView ag;
    private Button ah;
    private LinearLayout ai;
    private LinearLayout aj;
    private RelativeLayout ak;
    private RelativeLayout al;
    private View am;
    private View an;
    private View ao;
    private View ap;
    private View aq;
    private View ar;
    private View as;
    private View at;
    private View au;
    private View av;
    private View aw;
    private View ax;
    private View ay;
    private View az;
    final Handler i;
    final Handler j;
    final Handler k;
    final Handler l;
    final Handler m;
    private Button n;
    private TextView o;
    private RelativeLayout p;
    private RelativeLayout q;
    private RelativeLayout r;
    private RelativeLayout s;
    private RelativeLayout t;
    private RelativeLayout u;
    private RelativeLayout v;
    private RelativeLayout w;
    private RelativeLayout x;
    private RelativeLayout y;
    private TextView z;

    public AppsModeChooseActivity() {
        this.aG = 0x7F0B009A;  // string:STR_MODE_NEW_MANUAL "Manual"
        this.aH = 0x7F0B009B;  // string:STR_MODE_NEW_MANUAL_DESC "Control everything about your workout – from start to finish. This program is a basic workout with no pre-defined settings. It begins with an incline at 0 and speed at 0.5 mph. It’s up to you where you go from there and for how long."
        this.aI = 0x7F060083;  // drawable:afg2_manual_down
        this.aJ = 0;
        this.aK = 0;
        this.aL = false;
        this.aM = false;
        this.aN = false;
        this.aO = false;
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    j.a("===-=-开始跳到设备列表=-=-=", "===跳到设备列表====");
                    Intent v4 = new Intent(AppsModeChooseActivity.this, AppsDeviceListActivity.class);
                    AppsModeChooseActivity.this.startActivity(v4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsModeChooseActivity.this.b(false);
                        }
                    }, 500L);
                }
            }
        };
        this.aQ = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg7, Intent arg8) {
                Message v8_1;
                Handler v7_8;
                Handler v8;
                Message v7_3;
                Intent v7_1;
                String v7 = arg8.getAction();
                if(v7.equals("NOTIFICATION_DIDCONNECT")) {
                    AppsModeChooseActivity.this.m();
                    return;
                }

                if(v7.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                    if(!AppsModeChooseActivity.a(AppsModeChooseActivity.this)) {
                        return;
                    }

                    AppsModeChooseActivity.this.b(false);
                    AppsModeChooseActivity.this.m();
                    return;
                }

                if(v7.equals("NOTIFICATION_DISCONNECT")) {
                    AppsModeChooseActivity.a(AppsModeChooseActivity.this);
                    AppsModeChooseActivity.this.m();
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_GET_USER")) {
                    AppsModeChooseActivity.this.e();
                    return;
                }

                if(v7.equals("NOTIFICATION_RECEIVE_START_RUNNING_ACTIVITY")) {
                    v7_1 = new Intent(AppsModeChooseActivity.this, Apps321Activity.class);
                    AppsModeChooseActivity.this.startActivity(v7_1);
                    return;
                }

                if(!v7.equals("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE")) {
                    goto label_51;
                }

                if(((int)(((Integer)arg8.getExtras().get("Extra_Key_SafetyKey_State")))) == 1 && !AppsRunner.get(AppsModeChooseActivity.this.getApplicationContext()).a) {
                    AppsModeChooseActivity.this.a(false, true);
                    return;
                label_51:
                    if(v7.equals("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS")) {
                        AppsModeChooseActivity.this.a(false);
                        return;
                    }

                    if(v7.equals("NOTIFICATION_DID_RESTART_WORKOUT")) {
                        if((AppsRunner.get(AppsModeChooseActivity.this.getApplicationContext()).a) || !AppsRunner.get(AppsModeChooseActivity.this.getApplicationContext()).g()) {
                            return;
                        }

                        int v7_2 = AppsRunner.get(AppsModeChooseActivity.this.getApplicationContext()).U;
                        AppsRunner.get(AppsModeChooseActivity.this.getApplicationContext()).f(AppsModeChooseActivity.this.getApplicationContext(), v7_2);
                        v7_1 = new Intent(AppsModeChooseActivity.this, Apps321Activity.class);
                        AppsModeChooseActivity.this.startActivity(v7_1);
                        return;
                    }

                    if(v7.equals("NOTIFICATION_UN_MATCH_MACHINE")) {
                        v7_1 = new Intent(AppsModeChooseActivity.this, AppsUnMatchActivity.class);
                        AppsModeChooseActivity.this.startActivity(v7_1);
                        return;
                    }

                    if(v7.equals("NOTIFICATION_DID_TIME_OUT")) {
                        return;
                    }

                    if(v7.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                        j.a("=[=-=取消延时===", "取消延时");
                        AppsModeChooseActivity.this.i.removeMessages(0x6F);
                        return;
                    }

                    long v4 = 0L;
                    if(v7.equals("NOTIFICATION_DID_SET_MY_FIRST_5K")) {
                        j.a("===收到set5K==", "解锁");
                        AppsModeChooseActivity.this.l.removeMessages(0x6F);
                        v7_3 = new Message();
                        goto label_136;
                    }

                    if(v7.equals("NOTIFICATION_DID_DEVICE_SET_CUSTOM_PROGRAM")) {
                        j.a("===收到setCustom==", "解锁");
                        AppsModeChooseActivity.this.l.removeMessages(0x6F);
                        v7_3 = new Message();
                    label_136:
                        v7_3.what = 0x6F;
                        v8 = AppsModeChooseActivity.this.l;
                        v8.sendMessageDelayed(v7_3, v4);
                        return;
                    }

                    if(v7.equals("NOTIFICATION_DID_DEVICE_SET_CUSTOM_HR_PROGRAM")) {
                        j.a("===收到setCustomHR==", "解锁");
                        AppsModeChooseActivity.this.m.removeMessages(0xDE);
                        v7_3 = new Message();
                        v7_3.what = 0xDE;
                        v8 = AppsModeChooseActivity.this.m;
                        v8.sendMessageDelayed(v7_3, v4);
                        return;
                    }

                    if(v7.equals("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER")) {
                        AppsModeChooseActivity.this.m();
                        return;
                    }

                    if(!v7.equals("NOTIFICATION_JUST_KNOW_WORKOUT")) {
                        goto label_185;
                    }

                    if(AppsRunner.get(AppsModeChooseActivity.this).k(AppsModeChooseActivity.this) == 5 || !AppsRunner.get(AppsModeChooseActivity.this).g()) {
                        AppsRunner.get(AppsModeChooseActivity.this).clear();
                        AppsRunner.get(AppsModeChooseActivity.this).setCurrentStopWorkoutInfo(null);
                        return;
                    label_185:
                        if(v7.equals("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER")) {
                            if(!AppsModeChooseActivity.a(AppsModeChooseActivity.this)) {
                                return;
                            }

                            AppsModeChooseActivity.this.b(false);
                            AppsModeChooseActivity.this.m();
                            return;
                        }

                        if(v7.equals("NOTIFICATION_DID_STOP_WORKOUT_FINISH")) {
                            if(!AppsModeChooseActivity.a(AppsModeChooseActivity.this)) {
                                return;
                            }

                            AppsModeChooseActivity.this.m();
                            return;
                        }

                        if(v7.equals("NOTIFICATION_SHOULD_TO_DEVICE_LIST")) {
                            if(!AppsModeChooseActivity.b(AppsModeChooseActivity.this)) {
                                AppsModeChooseActivity.a(AppsModeChooseActivity.this, true);
                                Intent v7_4 = new Intent(AppsModeChooseActivity.this, AppsDeviceListActivity.class);
                                AppsModeChooseActivity.this.startActivity(v7_4);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        AppsModeChooseActivity.this.b(false);
                                    }
                                }, 500L);
                                return;
                            }
                        }
                        else if(!v7.equals("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE_SHOULD_RESHOW")) {
                            if(v7.equals("NOTIFICATION_RE_SHOW_LOADING")) {
                                if(!AppsModeChooseActivity.a(AppsModeChooseActivity.this)) {
                                    return;
                                }

                                AppsModeChooseActivity.b(AppsModeChooseActivity.this, true);
                                AppsModeChooseActivity.this.a(AppsModeChooseActivity.this, "", false);
                                AppsModeChooseActivity.this.l.removeMessages(0x6F);
                                Message v7_6 = new Message();
                                v7_6.what = 0x6F;
                                AppsModeChooseActivity.this.l.sendMessageDelayed(v7_6, 12000L);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_DID_SELECT_PROGRAM")) {
                                int v7_7 = (int)(((Integer)arg8.getExtras().get("responseCode")));
                                j.a("HOME SELECT PROGRAM RESPONSE CODE", v7_7 + " |");
                                if(v7_7 == 0) {
                                    AppsModeChooseActivity.c(AppsModeChooseActivity.this, false);
                                    return;
                                }

                                AppsModeChooseActivity.c(AppsModeChooseActivity.this, true);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_REFRESH_MMF_TOKEN_FAILED_5_TIMES")) {
                                ((AppsApplication)AppsModeChooseActivity.this.getApplication()).c(((String)arg8.getExtras().get("userId")));
                                return;
                            }

                            if(v7.equals("NOTIFICATION_REFRESH_MFP_TOKEN_FAILED_5_TIMES")) {
                                ((AppsApplication)AppsModeChooseActivity.this.getApplication()).e(((String)arg8.getExtras().get("userId")));
                                return;
                            }

                            if(v7.equals("NOTIFICATION_TO_MMF_LOGIN")) {
                                ShareFitness.get(AppsModeChooseActivity.this).a(0);
                                ShareFitness.get(AppsModeChooseActivity.this).b();
                                v7_8 = AppsModeChooseActivity.this.k;
                                v8_1 = new Message();
                            }
                            else {
                                if(!v7.equals("NOTIFICATION_TO_MFP_LOGIN")) {
                                    return;
                                }

                                ShareFitness.get(AppsModeChooseActivity.this).a(1);
                                ShareFitness.get(AppsModeChooseActivity.this).b();
                                v7_8 = AppsModeChooseActivity.this.k;
                                v8_1 = new Message();
                            }

                            v7_8.sendMessage(v8_1);
                            return;
                            AppsModeChooseActivity.this.m();
                            return;
                        }
                        else if(AppsModeChooseActivity.a(AppsModeChooseActivity.this)) {
                            int v7_5 = AppsRunner.get(AppsModeChooseActivity.this).securitySwitch;
                            j.a("==来到mode了==", v7_5 + " |");
                            if(v7_5 == 1) {
                                ((AppsApplication)AppsModeChooseActivity.this.getApplication()).showSafetyAlert(1, -1, false);
                                return;
                            }
                        }
                    }
                }
            }
        };
        this.aR = false;
        this.j = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsRunner.get(AppsModeChooseActivity.this.getApplicationContext()).clear();
                if(arg2.what == 1) {
                    AppsModeChooseActivity.this.f();
                }
            }
        };
        this.k = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                Intent v3 = new Intent(AppsModeChooseActivity.this, AppsShareAuthActivity.class);
                v3.putExtra("isFromRefreshToken", true);
                AppsModeChooseActivity.this.startActivity(v3);
            }
        };
        this.aS = null;
        this.aT = null;
        this.l = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsModeChooseActivity.b(AppsModeChooseActivity.this, false);
                AppsModeChooseActivity.this.g();
            }
        };
        this.m = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsModeChooseActivity.d(AppsModeChooseActivity.this, false);
                AppsModeChooseActivity.this.g();
            }
        };
    }

    static boolean a(AppsModeChooseActivity arg0) {
        return arg0.aL;
    }

    static boolean a(AppsModeChooseActivity arg0, boolean arg1) {
        arg0.aO = arg1;
        return arg1;
    }

    public int a(View arg2) {
        if(arg2 == this.p) {
            return 0;
        }

        if(arg2 == this.q) {
            return 1;
        }

        if(arg2 == this.r) {
            return 2;
        }

        if(arg2 == this.s) {
            return 3;
        }

        if(arg2 == this.t) {
            return 4;
        }

        if(arg2 == this.u) {
            return 5;
        }

        if(arg2 == this.v) {
            return 6;
        }

        if(arg2 == this.w) {
            return 11;
        }

        if(arg2 == this.x) {
            return 9;
        }

        return arg2 == this.y ? 8 : -1;
    }

    public void a(int arg3, boolean arg4) {
        int v3;
        boolean v4 = AppsRunner.get(this).inclineSupportsHalfDegree(this);
        if(arg3 == 0) {
            this.aJ = 0;
            this.aI = 0x7F060083;  // drawable:afg2_manual_down
            this.aG = 0x7F0B009A;  // string:STR_MODE_NEW_MANUAL "Manual"
            this.aH = v4 ? 0x7F0B009C : 0x7F0B009B;  // string:STR_MODE_NEW_MANUAL_DESC_EP "Control everything about your workout – from start to finish. This program is a basic workout with no pre-defined settings. It begins with resistance at 1. It’s up to you where you go from there and for how long."
            AppsRunner.get(this).f(this, 0);
            return;
        }

        int v0 = 1;
        if(arg3 == 1) {
            this.aJ = 1;
            this.aI = 0x7F06006F;  // drawable:afg2_hill_climb__down
            this.aG = 0x7F0B0097;  // string:STR_MODE_NEW_HILL_CLIMB "Hill Climb"
            v3 = v4 ? 0x7F0B0099 : 0x7F0B0098;  // string:STR_MODE_NEW_HILL_CLIMB_DESC_EP "Simulates a hill ascent and descent. This program helps tone muscle and improve cardiovascular ability. Incline and resistance change and segments repeat every 60 seconds."
        }
        else {
            v0 = 2;
            if(arg3 == 2) {
                this.aJ = 2;
                this.aI = 0x7F060060;  // drawable:afg2_distance__down
                this.aG = 0x7F0B0091;  // string:STR_MODE_NEW_DISTANCE "Distance"
                v3 = v4 ? 0x7F0B0093 : 0x7F0B0092;  // string:STR_MODE_NEW_DISTANCE_DESC_EP "Push yourself and go further during your workout with 13 distance workouts. Choose from 1 mile, 2 miles, 5k, 5 miles, 10k, 8 miles, 15k, 10 miles, 20k, half marathon, 15 miles, 20 miles, and marathon goals. You set your level."
            }
            else {
                v0 = 3;
                if(arg3 == 3) {
                    this.aJ = 3;
                    this.aI = 0x7F060095;  // drawable:afg2_target_hreat_rate__down
                    this.aG = 0x7F0B00A4;  // string:STR_MODE_NEW_TARGET_HEART_RATE2 "Target Heart Rate"
                    v3 = v4 ? 0x7F0B00A6 : 0x7F0B00A5;  // string:STR_MODE_NEW_TARGET_HEART_RATE_DESC_EP "Automatically adjusts resistance to maintain your Target Heart Rate. Perfect for simulating the intensity of your favorite sport or everyday activity. This is a time-based goal program."
                }
                else {
                    v0 = 4;
                    if(arg3 == 4) {
                        this.aJ = 4;
                        this.aI = 0x7F06005A;  // drawable:afg2_calories__down
                        this.aG = 0x7F0B0087;  // string:STR_MODE_NEW_CALORIES "Calories"
                        v3 = v4 ? 0x7F0B0089 : 0x7F0B0088;  // string:STR_MODE_NEW_CALORIES_DESC_EP "Set goals for burning calories from 20 to 980 calories in 20 calorie increments. You set your level to keep you in your fat burning zone."
                    }
                    else {
                        v0 = 5;
                        if(arg3 == 5) {
                            this.aJ = 5;
                            this.aI = 0x7F060086;  // drawable:afg2_my_frist_5k__down
                            this.aG = 0x7F0B009D;  // string:STR_MODE_NEW_MY_FIRST_5KM "My First 5k"
                            v3 = v4 ? 0x7F0B009F : 0x7F0B009E;  // string:STR_MODE_NEW_MY_FIRST_5KM_DESC_EP "This program is intended for inexperienced runners looking to run their first 5k or simply begin an exercise routine. This 9 week program is designed specifically to keep you motivated and engaged."
                        }
                        else {
                            v0 = 6;
                            if(arg3 == 6) {
                                this.aJ = 6;
                                this.aI = 0x7F060066;  // drawable:afg2_fat_burn__down
                                this.aG = 0x7F0B0094;  // string:STR_MODE_NEW_FAT_BURN "Fat Burn"
                                v3 = v4 ? 0x7F0B0096 : 0x7F0B0095;  // string:STR_MODE_NEW_FAT_BURN_DESC_EP "Promotes weight loss by increasing and decreasing the resistance, while keeping you in your fat burning zone. Segments repeat every 60 seconds."
                            }
                            else {
                                v0 = 11;
                                if(arg3 != 11 && arg3 != 7 && arg3 != 10) {
                                    v0 = 9;
                                    if(arg3 == 9) {
                                        this.aJ = 9;
                                        this.aI = 0x7F06008C;  // drawable:afg2_prints_down
                                        this.aG = 0x7F0B00A0;  // string:STR_MODE_NEW_SPRINTS "Sprint 8"
                                        v3 = v4 ? 0x7F0B00A2 : 0x7F0B00A1;  // string:STR_MODE_NEW_SPRINTS_DESC_EP "Improves your strength, speed and endurance by increasing and decreasing the resistance throughout your workout to involve your heart and other muscles. The resistance changes and the program consists of repeating segments of 90 seconds and 30 seconds."
                                    }
                                    else {
                                        v0 = 8;
                                        if(arg3 != 8) {
                                            return;
                                        }

                                        this.aJ = 8;
                                        this.aI = 0x7F06005D;  // drawable:afg2_custom_heart_rate__down
                                        this.aG = 0x7F0B008D;  // string:STR_MODE_NEW_CUSTOM_HEART_RATE "Custom Heart Rate"
                                        if(v4) {
                                            v3 = 0x7F0B008F;  // string:STR_MODE_NEW_CUSTOM_HEART_RATE_DESC_EP "Allows you to program up to 4 segments and set each segment with a targeted heart rate. The program automatically adjusts the resistance in each segment to maintain your target heart rate. This is a time-based goal program."
                                        }
                                        else {
                                            v3 = 0x7F0B008E;  // string:STR_MODE_NEW_CUSTOM_HEART_RATE_DESC "Allows you to program up to 4 segments and set each segment with a targeted heart rate. The program automatically adjusts the incline in each segment to maintain your target heart rate. This is a time-based goal program."
                                            goto label_131;
                                            return;
                                        }
                                    }
                                }
                                else {
                                    this.aJ = 11;
                                    this.aI = 0x7F06005C;  // drawable:afg2_custom__down
                                    this.aG = 0x7F0B008A;  // string:STR_MODE_NEW_CUSTOM "Custom"
                                    v3 = v4 ? 0x7F0B008C : 0x7F0B008B;  // string:STR_MODE_NEW_CUSTOM_DESC_EP "Lets you create and reuse your perfect workout with a combination of a specific resistance, incline and time or distance. The ultimate in personal programming. This is a time or distance based goal program."
                                }
                            }
                        }
                    }
                }
            }
        }

    label_131:
        this.aH = v3;
        AppsRunner.get(this).f(this, v0);
    }

    public void a(boolean arg24) {
        LinearLayout.LayoutParams v1_4;
        RelativeLayout.LayoutParams v20_1;
        LinearLayout.LayoutParams v14_2;
        RelativeLayout.LayoutParams v21;
        LinearLayout.LayoutParams v11_2;
        RelativeLayout.LayoutParams v22;
        int v2_1;
        LinearLayout v1_1;
        AppsModeChooseActivity v0 = this;
        int v1 = AppsRunner.get(this).k(v0);
        int v2 = AppsRunner.get(this).l(v0);
        boolean v3 = AppsRunner.get(this).r(v0);
        v0.aK = v2;
        v0.aJ = v1;
        if(v3) {
            v1_1 = v0.aj;
            v2_1 = 0;
        }
        else {
            v1_1 = v0.aj;
            v2_1 = 8;
        }

        v1_1.setVisibility(v2_1);
        v0.a(v0.aJ, arg24);
        this.e();
        this.l();
        LinearLayout.LayoutParams v1_2 = (LinearLayout.LayoutParams)v0.p.getLayoutParams();
        LinearLayout.LayoutParams v2_2 = (LinearLayout.LayoutParams)v0.q.getLayoutParams();
        LinearLayout.LayoutParams v4 = (LinearLayout.LayoutParams)v0.r.getLayoutParams();
        LinearLayout.LayoutParams v5 = (LinearLayout.LayoutParams)v0.s.getLayoutParams();
        LinearLayout.LayoutParams v6 = (LinearLayout.LayoutParams)v0.t.getLayoutParams();
        LinearLayout.LayoutParams v7 = (LinearLayout.LayoutParams)v0.u.getLayoutParams();
        LinearLayout.LayoutParams v8 = (LinearLayout.LayoutParams)v0.v.getLayoutParams();
        LinearLayout.LayoutParams v9 = (LinearLayout.LayoutParams)v0.w.getLayoutParams();
        LinearLayout.LayoutParams v10 = (LinearLayout.LayoutParams)v0.x.getLayoutParams();
        LinearLayout.LayoutParams v11 = (LinearLayout.LayoutParams)v0.y.getLayoutParams();
        RelativeLayout.LayoutParams v12 = (RelativeLayout.LayoutParams)v0.M.getLayoutParams();
        RelativeLayout.LayoutParams v13 = (RelativeLayout.LayoutParams)v0.N.getLayoutParams();
        RelativeLayout.LayoutParams v14 = (RelativeLayout.LayoutParams)v0.O.getLayoutParams();
        RelativeLayout.LayoutParams v24 = (RelativeLayout.LayoutParams)v0.P.getLayoutParams();
        RelativeLayout.LayoutParams v15 = (RelativeLayout.LayoutParams)v0.Q.getLayoutParams();
        RelativeLayout.LayoutParams v16 = v14;
        RelativeLayout.LayoutParams v14_1 = (RelativeLayout.LayoutParams)v0.R.getLayoutParams();
        LinearLayout.LayoutParams v17 = v1_2;
        RelativeLayout.LayoutParams v18 = (RelativeLayout.LayoutParams)v0.S.getLayoutParams();
        RelativeLayout.LayoutParams v19 = (RelativeLayout.LayoutParams)v0.T.getLayoutParams();
        RelativeLayout.LayoutParams v1_3 = (RelativeLayout.LayoutParams)v0.U.getLayoutParams();
        LinearLayout.LayoutParams v20 = v11;
        RelativeLayout.LayoutParams v11_1 = (RelativeLayout.LayoutParams)v0.V.getLayoutParams();
        if(v3) {
            v12.rightMargin = k.a(v0, 50.0f);
            v15.rightMargin = k.a(v0, 50.0f);
            v1_3.rightMargin = k.a(v0, 50.0f);
            v13.leftMargin = k.a(v0, 50.0f);
            v14_1.leftMargin = k.a(v0, 50.0f);
            v11_1.leftMargin = k.a(v0, 50.0f);
            v4.topMargin = k.a(v0, 0.0f);
            v6.topMargin = k.a(v0, 0.0f);
            v8.topMargin = k.a(v0, 0.0f);
            v10.topMargin = k.a(v0, 0.0f);
            v2_2.topMargin = k.a(v0, 0.0f);
            v5.topMargin = k.a(v0, 0.0f);
            v7.topMargin = k.a(v0, 0.0f);
            v22 = v11_1;
            v11_2 = v9;
            v11_2.topMargin = k.a(v0, 0.0f);
            v21 = v14_1;
            v14_2 = v20;
            v14_2.topMargin = k.a(v0, 0.0f);
            v4.bottomMargin = k.a(v0, 0.0f);
            v6.bottomMargin = k.a(v0, 0.0f);
            v8.bottomMargin = k.a(v0, 0.0f);
            v10.bottomMargin = k.a(v0, 0.0f);
            v2_2.bottomMargin = k.a(v0, 0.0f);
            v5.bottomMargin = k.a(v0, 0.0f);
            v7.bottomMargin = k.a(v0, 0.0f);
            v11_2.bottomMargin = k.a(v0, 0.0f);
            v14_2.bottomMargin = k.a(v0, 0.0f);
            v20_1 = v1_3;
            v1_4 = v17;
        }
        else {
            v22 = v11_1;
            v21 = v14_1;
            v14_2 = v20;
            v11_2 = v9;
            v12.rightMargin = k.a(v0, 10.0f);
            v15.rightMargin = k.a(v0, 10.0f);
            v1_3.rightMargin = k.a(v0, 10.0f);
            v13.leftMargin = k.a(v0, 10.0f);
            v20_1 = v1_3;
            v21.leftMargin = k.a(v0, 10.0f);
            v22.leftMargin = k.a(v0, 10.0f);
            v1_4 = v17;
            v1_4.topMargin = k.a(v0, 5.0f);
            v4.topMargin = k.a(v0, 5.0f);
            v6.topMargin = k.a(v0, 5.0f);
            v8.topMargin = k.a(v0, 5.0f);
            v10.topMargin = k.a(v0, 5.0f);
            v2_2.topMargin = k.a(v0, 5.0f);
            v5.topMargin = k.a(v0, 5.0f);
            v7.topMargin = k.a(v0, 5.0f);
            v11_2.topMargin = k.a(v0, 5.0f);
            v14_2.topMargin = k.a(v0, 5.0f);
            v1_4.bottomMargin = k.a(v0, 5.0f);
            v4.bottomMargin = k.a(v0, 5.0f);
            v6.bottomMargin = k.a(v0, 5.0f);
            v8.bottomMargin = k.a(v0, 5.0f);
            v10.bottomMargin = k.a(v0, 5.0f);
            v2_2.bottomMargin = k.a(v0, 5.0f);
            v5.bottomMargin = k.a(v0, 5.0f);
            v7.bottomMargin = k.a(v0, 5.0f);
            v11_2.bottomMargin = k.a(v0, 5.0f);
            v14_2.bottomMargin = k.a(v0, 5.0f);
        }

        v0.M.setLayoutParams(v12);
        v0.N.setLayoutParams(v13);
        v0.O.setLayoutParams(v16);
        v0.P.setLayoutParams(v24);
        v0.Q.setLayoutParams(v15);
        v0.R.setLayoutParams(v21);
        v0.S.setLayoutParams(v18);
        v0.T.setLayoutParams(v19);
        v0.U.setLayoutParams(v20_1);
        v0.V.setLayoutParams(v22);
        v0.p.setLayoutParams(v1_4);
        v0.q.setLayoutParams(v2_2);
        v0.r.setLayoutParams(v4);
        v0.s.setLayoutParams(v5);
        v0.t.setLayoutParams(v6);
        v0.u.setLayoutParams(v7);
        v0.v.setLayoutParams(v8);
        v0.w.setLayoutParams(v11_2);
        v0.x.setLayoutParams(v10);
        v0.y.setLayoutParams(v14_2);
        this.m();
    }

    public void a(boolean arg3, boolean arg4) {
        if(arg3) {
            this.b(this, this.getResources().getString(0x7F0B000F), false);  // string:STR_ALERT_TIP_SAVE_SESSION "Save workout result..."
        }

        this.aS = new Date();
        new Thread() {
            @Override
            public void run() {
                AppsRunner.get(AppsModeChooseActivity.this.getApplicationContext()).a(AppsModeChooseActivity.this.getApplicationContext(), AppsModeChooseActivity.c(AppsModeChooseActivity.this));
                if(((boolean)(((int)arg4)))) {
                    AppsRunner.get(AppsModeChooseActivity.this.getApplicationContext()).s();
                }

                Message v0 = new Message();
                v0.what = ((boolean)(((int)arg3)));
                AppsModeChooseActivity.this.j.sendMessage(v0);
            }
        }.start();
    }

    static boolean b(AppsModeChooseActivity arg0) {
        return arg0.aO;
    }

    static boolean b(AppsModeChooseActivity arg0, boolean arg1) {
        arg0.aM = arg1;
        return arg1;
    }

    // Detected as a lambda impl.
    public boolean b(boolean arg5) {
        j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)arg5))));
        if(arg5) {
            this.af.setVisibility(0);
            this.i.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return true;
            }

            Message v5 = new Message();
            v5.what = 0x6F;
            this.i.sendMessageDelayed(v5, 30000L);
            return true;
        }

        this.af.setVisibility(8);
        this.i.removeMessages(0x6F);
        return false;
    }

    static Date c(AppsModeChooseActivity arg0) {
        return arg0.aS;
    }

    static boolean c(AppsModeChooseActivity arg0, boolean arg1) {
        arg0.aR = arg1;
        return arg1;
    }

    public void c(boolean arg2) {
        if(!arg2) {
            goto label_170;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.aQ, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.aQ, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_DID_GET_USER");
            this.registerReceiver(this.aQ, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_RECEIVE_START_RUNNING_ACTIVITY");
            this.registerReceiver(this.aQ, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE");
            this.registerReceiver(this.aQ, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS");
            this.registerReceiver(this.aQ, v2_6);
            IntentFilter v2_7 = new IntentFilter();
            v2_7.addAction("NOTIFICATION_DID_RESTART_WORKOUT");
            this.registerReceiver(this.aQ, v2_7);
            IntentFilter v2_8 = new IntentFilter();
            v2_8.addAction("NOTIFICATION_UN_MATCH_MACHINE");
            this.registerReceiver(this.aQ, v2_8);
            IntentFilter v2_9 = new IntentFilter();
            v2_9.addAction("NOTIFICATION_DID_TIME_OUT");
            this.registerReceiver(this.aQ, v2_9);
            IntentFilter v2_10 = new IntentFilter();
            v2_10.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.aQ, v2_10);
            IntentFilter v2_11 = new IntentFilter();
            v2_11.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.aQ, v2_11);
            IntentFilter v2_12 = new IntentFilter();
            v2_12.addAction("NOTIFICATION_DID_SET_MY_FIRST_5K");
            this.registerReceiver(this.aQ, v2_12);
            IntentFilter v2_13 = new IntentFilter();
            v2_13.addAction("NOTIFICATION_DID_DEVICE_SET_CUSTOM_PROGRAM");
            this.registerReceiver(this.aQ, v2_13);
            IntentFilter v2_14 = new IntentFilter();
            v2_14.addAction("NOTIFICATION_DID_DEVICE_SET_CUSTOM_HR_PROGRAM");
            this.registerReceiver(this.aQ, v2_14);
            IntentFilter v2_15 = new IntentFilter();
            v2_15.addAction("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER");
            this.registerReceiver(this.aQ, v2_15);
            IntentFilter v2_16 = new IntentFilter();
            v2_16.addAction("NOTIFICATION_JUST_KNOW_WORKOUT");
            this.registerReceiver(this.aQ, v2_16);
            IntentFilter v2_17 = new IntentFilter();
            v2_17.addAction("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER");
            this.registerReceiver(this.aQ, v2_17);
            IntentFilter v2_18 = new IntentFilter();
            v2_18.addAction("NOTIFICATION_DID_STOP_WORKOUT_FINISH");
            this.registerReceiver(this.aQ, v2_18);
            IntentFilter v2_19 = new IntentFilter();
            v2_19.addAction("NOTIFICATION_SHOULD_TO_DEVICE_LIST");
            this.registerReceiver(this.aQ, v2_19);
            IntentFilter v2_20 = new IntentFilter();
            v2_20.addAction("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE_SHOULD_RESHOW");
            this.registerReceiver(this.aQ, v2_20);
            IntentFilter v2_21 = new IntentFilter();
            v2_21.addAction("NOTIFICATION_RE_SHOW_LOADING");
            this.registerReceiver(this.aQ, v2_21);
            IntentFilter v2_22 = new IntentFilter();
            v2_22.addAction("NOTIFICATION_DID_SELECT_PROGRAM");
            this.registerReceiver(this.aQ, v2_22);
            IntentFilter v2_23 = new IntentFilter();
            v2_23.addAction("NOTIFICATION_REFRESH_MMF_TOKEN_FAILED_5_TIMES");
            this.registerReceiver(this.aQ, v2_23);
            IntentFilter v2_24 = new IntentFilter();
            v2_24.addAction("NOTIFICATION_REFRESH_MFP_TOKEN_FAILED_5_TIMES");
            this.registerReceiver(this.aQ, v2_24);
            IntentFilter v2_25 = new IntentFilter();
            v2_25.addAction("NOTIFICATION_TO_MMF_LOGIN");
            this.registerReceiver(this.aQ, v2_25);
            IntentFilter v2_26 = new IntentFilter();
            v2_26.addAction("NOTIFICATION_TO_MFP_LOGIN");
            this.registerReceiver(this.aQ, v2_26);
            IntentFilter v2_27 = new IntentFilter();
            v2_27.addAction("NOTIFICATION_TO_MMF_LOGIN_BUT_NOT_JUMP");
            this.registerReceiver(this.aQ, v2_27);
            IntentFilter v2_28 = new IntentFilter();
            v2_28.addAction("NOTIFICATION_TO_MFP_LOGIN_BUT_NOT_JUMP");
            this.registerReceiver(this.aQ, v2_28);
            return;
        label_170:
            this.unregisterReceiver(this.aQ);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static int d(AppsModeChooseActivity arg0) {
        return arg0.aP;
    }

    static boolean d(AppsModeChooseActivity arg0, boolean arg1) {
        arg0.aN = arg1;
        return arg1;
    }

    static void e(AppsModeChooseActivity arg0) {
        arg0.q();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        n.a().e(this, 0x7F070164).setText(this.getResources().getString(0x7F0B009A));  // id:modeTextView1
        n.a().e(this, 0x7F070166).setText(this.getResources().getString(0x7F0B0097));  // id:modeTextView2
        n.a().e(this, 0x7F070167).setText(this.getResources().getString(0x7F0B0091));  // id:modeTextView3
        n.a().e(this, 0x7F070168).setText(this.getResources().getString(0x7F0B00A4));  // id:modeTextView4
        n.a().e(this, 0x7F070169).setText(this.getResources().getString(0x7F0B0087));  // id:modeTextView5
        n.a().e(this, 0x7F07016A).setText(this.getResources().getString(0x7F0B009D));  // id:modeTextView6
        n.a().e(this, 0x7F07016B).setText(this.getResources().getString(0x7F0B0094));  // id:modeTextView7
        n.a().e(this, 0x7F07016C).setText(this.getResources().getString(0x7F0B008A));  // id:modeTextView8
        n.a().e(this, 0x7F07016D).setText(this.getResources().getString(0x7F0B00A0));  // id:modeTextView9
        n.a().e(this, 0x7F070165).setText(this.getResources().getString(0x7F0B008D));  // id:modeTextView10
        n.a().e(this, 0x7F0702F5).setText(this.getResources().getString(0x7F0B00F9) + ":");  // id:userTextView
        n.a().e(this, 0x7F0700C5).setText(this.getResources().getString(0x7F0B0072));  // id:historyTextView
        n.a().e(this, 0x7F070275).setText(this.getResources().getString(0x7F0B00C5));  // id:startTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0702B9).setText(this.getResources().getString(0x7F0B00B2));  // id:tv_program
        n.a().e(this, 0x7F0702BD).setText(this.getResources().getString(0x7F0B00BB));  // id:tv_selection
        n.a().e(this, 0x7F07012D).setText(this.getResources().getString(0x7F0B009B));  // id:modeDescTextView1
        n.a().e(this, 0x7F07012F).setText(this.getResources().getString(0x7F0B0098));  // id:modeDescTextView2
        n.a().e(this, 0x7F070130).setText(this.getResources().getString(0x7F0B0092));  // id:modeDescTextView3
        n.a().e(this, 0x7F070131).setText(this.getResources().getString(0x7F0B00A5));  // id:modeDescTextView4
        n.a().e(this, 0x7F070132).setText(this.getResources().getString(0x7F0B0088));  // id:modeDescTextView5
        n.a().e(this, 0x7F070133).setText(this.getResources().getString(0x7F0B009E));  // id:modeDescTextView6
        n.a().e(this, 0x7F070134).setText(this.getResources().getString(0x7F0B0095));  // id:modeDescTextView7
        n.a().e(this, 0x7F070135).setText(this.getResources().getString(0x7F0B008B));  // id:modeDescTextView8
        n.a().e(this, 0x7F070136).setText(this.getResources().getString(0x7F0B00A1));  // id:modeDescTextView9
        n.a().e(this, 0x7F07012E).setText(this.getResources().getString(0x7F0B008E));  // id:modeDescTextView10
        String v0 = apps.database.d.a().c(this, AppsRunner.get(this).getPref_CurrentUserID(this));
        try {
            if((apps.c.d.a(v0, "USER 1")) || (apps.c.d.a(v0, "User 1"))) {
                v0 = "USER1";
            }
            else if((apps.c.d.a(v0, "USER 2")) || (apps.c.d.a(v0, "User 2"))) {
                v0 = "USER2";
            }
            else if((apps.c.d.a(v0, "USER 3")) || (apps.c.d.a(v0, "User 3"))) {
                v0 = "USER3";
            }
            else if((apps.c.d.a(v0, "USER 4")) || (apps.c.d.a(v0, "User 4"))) {
                v0 = "USER4";
            }
            else if((apps.c.d.a(v0, "USER 5")) || (apps.c.d.a(v0, "User 5"))) {
                v0 = "USER5";
            }
            else if((apps.c.d.a(v0, "USER 6")) || (apps.c.d.a(v0, "User 6"))) {
                v0 = "USER6";
            }
            else if(apps.c.d.a(v0, "Usuario 1")) {
                v0 = "Usuario1";
            }
            else if(apps.c.d.a(v0, "Usuario 2")) {
                v0 = "Usuario2";
            }
            else if(apps.c.d.a(v0, "Usuario 3")) {
                v0 = "Usuario3";
            }
            else if(apps.c.d.a(v0, "Usuario 4")) {
                v0 = "Usuario4";
            }
            else if(apps.c.d.a(v0, "Usuario 5")) {
                v0 = "Usuario5";
            }
            else if(apps.c.d.a(v0, "Usuario 6")) {
                v0 = "Usuario6";
            }
            else if(apps.c.d.a(v0, "Utilisateur 1")) {
                v0 = "Utilisateur1";
            }
            else if(apps.c.d.a(v0, "Utilisateur 2")) {
                v0 = "Utilisateur2";
            }
            else if(apps.c.d.a(v0, "Utilisateur 3")) {
                v0 = "Utilisateur3";
            }
            else if(apps.c.d.a(v0, "Utilisateur 4")) {
                v0 = "Utilisateur4";
            }
            else if(apps.c.d.a(v0, "Utilisateur 5")) {
                v0 = "Utilisateur5";
            }
            else if(apps.c.d.a(v0, "Utilisateur 6")) {
                v0 = "Utilisateur6";
            }

            int v1_1 = apps.c.d.a(this.getApplicationContext(), "string", v0);
            v0 = this.getResources().getString(v1_1);
        }
        catch(Exception v1) {
            v1.printStackTrace();
        }

        this.getResources().getString(0x7F0B00F9);  // string:STR_USER "User"
        this.J.setText(v0);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void i() {
        AppsRunnerConnector.get(this).j();
        AppsRunnerConnector.get(this).maybe_onMIODisconnect();
        this.finish();
        try {
            Process.killProcess(Process.myPid());
        }
        catch(Exception unused_ex) {
        }

        try {
            System.exit(0);
        }
        catch(Exception unused_ex) {
        }
    }

    public void l() {
        int v15_2;
        int v12_1;
        int v8;
        int v7;
        int v10;
        AppsModeChooseActivity v0 = this;
        v0.p.setEnabled(true);
        v0.q.setEnabled(true);
        v0.r.setEnabled(true);
        v0.s.setEnabled(true);
        v0.t.setEnabled(true);
        v0.u.setEnabled(true);
        v0.v.setEnabled(true);
        v0.w.setEnabled(true);
        v0.x.setEnabled(true);
        v0.y.setEnabled(true);
        v0.M.setBackgroundResource(0x7F06013F);  // drawable:pad_select_program1_nor
        v0.N.setBackgroundResource(0x7F060140);  // drawable:pad_select_program1_nor_66
        v0.O.setBackgroundResource(0x7F060141);  // drawable:pad_select_program1_nor_67
        v0.P.setBackgroundResource(0x7F060142);  // drawable:pad_select_program1_nor_68
        v0.Q.setBackgroundResource(0x7F060143);  // drawable:pad_select_program1_nor_69
        v0.R.setBackgroundResource(0x7F060144);  // drawable:pad_select_program1_nor_70
        v0.S.setBackgroundResource(0x7F060145);  // drawable:pad_select_program1_nor_71
        v0.T.setBackgroundResource(0x7F060146);  // drawable:pad_select_program1_nor_72
        v0.U.setBackgroundResource(0x7F0601C4);  // drawable:sprint8
        v0.V.setBackgroundResource(0x7F060148);  // drawable:pad_select_program1_nor_74
        v0.aw.setVisibility(0);
        v0.ax.setVisibility(0);
        v0.ay.setVisibility(0);
        v0.az.setVisibility(0);
        v0.aA.setVisibility(0);
        v0.aB.setVisibility(0);
        v0.aC.setVisibility(0);
        v0.aD.setVisibility(0);
        v0.aE.setVisibility(0);
        v0.aF.setVisibility(0);
        v0.am.setVisibility(4);
        v0.an.setVisibility(4);
        v0.ao.setVisibility(4);
        v0.ap.setVisibility(4);
        v0.aq.setVisibility(4);
        v0.ar.setVisibility(4);
        v0.as.setVisibility(4);
        v0.at.setVisibility(4);
        v0.au.setVisibility(4);
        v0.av.setVisibility(4);
        n.a().e(v0, 0x7F07012D).setVisibility(4);  // id:modeDescTextView1
        n.a().e(v0, 0x7F07012F).setVisibility(4);  // id:modeDescTextView2
        n.a().e(v0, 0x7F070130).setVisibility(4);  // id:modeDescTextView3
        n.a().e(v0, 0x7F070131).setVisibility(4);  // id:modeDescTextView4
        n.a().e(v0, 0x7F070132).setVisibility(4);  // id:modeDescTextView5
        n.a().e(v0, 0x7F070133).setVisibility(4);  // id:modeDescTextView6
        n.a().e(v0, 0x7F070134).setVisibility(4);  // id:modeDescTextView7
        n.a().e(v0, 0x7F070135).setVisibility(4);  // id:modeDescTextView8
        n.a().e(v0, 0x7F070136).setVisibility(4);  // id:modeDescTextView9
        n.a().e(v0, 0x7F07012E).setVisibility(4);  // id:modeDescTextView10
        boolean v1 = apps.c.d.h(this);
        boolean v11 = apps.c.d.b();
        boolean v12 = apps.c.d.a();
        boolean v13 = AppsRunner.get(this).r(v0);
        int v14 = v13 ? 0 : 10;
        int v17 = v13 ? 56 : 61;
        int v18 = 30;
        int v15 = k.a(v0, 120.0f);
        int v19 = k.a(v0, 30.0f);
        int v9 = k.a(v0, 90.0f);
        int v21 = 110;
        if(v1) {
            v18 = 40;
            int v15_1 = k.a(v0, 150.0f);
            v19 = k.a(v0, 30.0f);
            v9 = k.a(v0, 110.0f);
            v10 = v15_1;
            v7 = v13 ? 65 : 70;
            v8 = 440;
            v12_1 = 0;
            v15_2 = 110;
            v21 = 130;
        }
        else if(v11) {
            v15_2 = 100;
            v21 = 130;
            v18 = 40;
            int v9_1 = k.a(v0, 140.0f);
            v19 = k.a(v0, 30.0f);
            v10 = v9_1;
            v7 = v13 ? 65 : 70;
            v12_1 = 0;
            v9 = k.a(v0, 110.0f);
            v8 = 400;
        }
        else if(v12) {
            v18 = 30;
            int v15_3 = k.a(v0, 110.0f);
            v19 = k.a(v0, 10.0f);
            v9 = k.a(v0, 90.0f);
            v12_1 = v13 ? 0 : k.a(v0, 10.0f);
            v10 = v15_3;
            v7 = v13 ? 56 : 61;
            v8 = 280;
            v15_2 = 70;
        }
        else {
            v10 = v15;
            v7 = v17;
            v8 = 320;
            v12_1 = 0;
            v15_2 = 80;
        }

        RelativeLayout.LayoutParams v6 = (RelativeLayout.LayoutParams)v0.ak.getLayoutParams();
        RelativeLayout.LayoutParams v2 = (RelativeLayout.LayoutParams)v0.al.getLayoutParams();
        int v5 = apps.c.d.b(this);
        int v4 = k.a(v0, ((float)v13 ? v8 + v21 : v8 + v18 + v14 * 3));
        int v3 = v15_2 / 2;
        int v21_1 = v14;
        int v23 = v15_2;
        int v22 = (v5 - v9 - v4 - v10) / 2 + v10 + k.a(v0, ((float)v3)) - v19;
        int v12_2 = v22 - k.a(v0, 1.0f) - v12_1;
        if(v1) {
            v12_2 = v22;
        }
        else if(v11) {
            v12_2 = v22;
        }

        j.a("====1234====", v5 + " , " + v4 + " , " + v10 + " , " + v9 + " , " + v12_2);
        v2.height = v12_2;
        v0.al.setLayoutParams(v2);
        int v1_1 = v0.aJ;
        if(v1_1 == 0) {
            v0.p.setEnabled(false);
            v0.M.setBackgroundResource(0x7F060149);  // drawable:pad_select_program1_sel
            v0.am.setVisibility(0);
            v0.aw.setVisibility(4);
            n.a().e(v0, 0x7F07012D).setVisibility(0);  // id:modeDescTextView1
            v6.topMargin = k.a(v0, ((float)v7));
            v6.height = v13 ? k.a(v0, ((float)v8)) : k.a(v0, ((float)(v8 - v3)));
        }
        else if(v1_1 == 1) {
            v0.q.setEnabled(false);
            v0.N.setBackgroundResource(0x7F06014A);  // drawable:pad_select_program2_sel
            v0.an.setVisibility(0);
            v0.ax.setVisibility(4);
            n.a().e(v0, 0x7F07012F).setVisibility(0);  // id:modeDescTextView2
            v6.topMargin = k.a(v0, ((float)v7));
            v6.height = v13 ? k.a(v0, ((float)v8)) : k.a(v0, ((float)(v8 - v3)));
        }
        else if(v1_1 == 2) {
            v0.r.setEnabled(false);
            v0.O.setBackgroundResource(0x7F06014B);  // drawable:pad_select_program3_sel
            v0.ao.setVisibility(0);
            v0.ay.setVisibility(4);
            n.a().e(v0, 0x7F070130).setVisibility(0);  // id:modeDescTextView3
            v6.topMargin = k.a(v0, ((float)(v7 + v23 + v21_1)));
            v6.height = v13 ? k.a(v0, ((float)(v8 - v23))) : k.a(v0, ((float)(v8 - v23 - v23 + v21_1 * 3)));
        }
        else if(v1_1 == 3) {
            v0.s.setEnabled(false);
            v0.P.setBackgroundResource(0x7F06014C);  // drawable:pad_select_program4_sel
            v0.ap.setVisibility(0);
            v0.az.setVisibility(4);
            n.a().e(v0, 0x7F070131).setVisibility(0);  // id:modeDescTextView4
            v6.topMargin = k.a(v0, ((float)(v7 + v23 + v21_1)));
            v6.height = v13 ? k.a(v0, ((float)(v8 - v23))) : k.a(v0, ((float)(v8 - v23 - v23 + v21_1 * 3)));
        }
        else if(v1_1 == 4) {
            v0.t.setEnabled(false);
            v0.Q.setBackgroundResource(0x7F06014D);  // drawable:pad_select_program5_sel
            v0.aq.setVisibility(0);
            v0.aA.setVisibility(4);
            n.a().e(v0, 0x7F070132).setVisibility(0);  // id:modeDescTextView5
            int v14_1 = v21_1 * 2;
            v6.topMargin = k.a(v0, ((float)(v7 + v23 + v23 + v14_1)));
            v6.height = v13 ? k.a(v0, ((float)(v8 - v23 - v23))) : k.a(v0, ((float)(v8 - v23 - v23 - v23 + v14_1)));
        }
        else if(v1_1 == 5) {
            v0.u.setEnabled(false);
            v0.R.setBackgroundResource(0x7F06014E);  // drawable:pad_select_program6_sel
            v0.ar.setVisibility(0);
            v0.aB.setVisibility(4);
            n.a().e(v0, 0x7F070133).setVisibility(0);  // id:modeDescTextView6
            int v14_2 = v21_1 * 2;
            v6.topMargin = k.a(v0, ((float)(v7 + v23 + v23 + v14_2)));
            v6.height = v13 ? k.a(v0, ((float)(v8 - v23 - v23))) : k.a(v0, ((float)(v8 - v23 - v23 - v23 + v14_2)));
        }
        else if(v1_1 == 6) {
            v0.v.setEnabled(false);
            v0.S.setBackgroundResource(0x7F06014F);  // drawable:pad_select_program7_sel
            v0.as.setVisibility(0);
            v0.aC.setVisibility(4);
            n.a().e(v0, 0x7F070134).setVisibility(0);  // id:modeDescTextView7
            v6.topMargin = k.a(v0, ((float)(v7 + v23 + v23 + v23 + v21_1 * 3)));
            v6.height = v13 ? k.a(v0, ((float)(v8 - v23 - v23 - v23))) : k.a(v0, ((float)(v8 - v23 - v23 - v23 - v23 + v21_1)));
        }
        else if(v1_1 == 11 || v1_1 == 7 || v1_1 == 10) {
            v0.w.setEnabled(false);
            v0.T.setBackgroundResource(0x7F060150);  // drawable:pad_select_program8_sel
            v0.at.setVisibility(0);
            v0.aD.setVisibility(4);
            n.a().e(v0, 0x7F070135).setVisibility(0);  // id:modeDescTextView8
            v6.topMargin = k.a(v0, ((float)(v7 + v23 + v23 + v23 + v21_1 * 3)));
            v6.height = v13 ? k.a(v0, ((float)(v8 - v23 - v23 - v23))) : k.a(v0, ((float)(v8 - v23 - v23 - v23 - v23 + v21_1)));
        }
        else if(v1_1 == 9) {
            v0.x.setEnabled(false);
            v0.U.setBackgroundResource(0x7F0601C5);  // drawable:sprint8_choice
            v0.au.setVisibility(0);
            v0.aE.setVisibility(4);
            n.a().e(v0, 0x7F070136).setVisibility(0);  // id:modeDescTextView9
            v6.topMargin = k.a(v0, ((float)(v7 + v23 + v23 + v23 + v23 + v21_1 * 4)));
            v6.height = v13 ? k.a(v0, ((float)(v8 - v23 - v23 - v23 - v23))) : k.a(v0, ((float)(v8 - v23 - v23 - v23 - v23 - v23)));
        }
        else if(v1_1 == 8) {
            v0.y.setEnabled(false);
            v0.V.setBackgroundResource(0x7F06013E);  // drawable:pad_select_program10_sel
            v0.av.setVisibility(0);
            v0.aF.setVisibility(4);
            n.a().e(v0, 0x7F07012E).setVisibility(0);  // id:modeDescTextView10
            v6.topMargin = k.a(v0, ((float)(v7 + v23 + v23 + v23 + v23 + v21_1 * 4)));
            v6.height = v13 ? k.a(v0, ((float)(v8 - v23 - v23 - v23 - v23))) : k.a(v0, ((float)(v8 - v23 - v23 - v23 - v23 - v23)));
        }

        v0.ak.setLayoutParams(v6);
        RelativeLayout.LayoutParams v1_2 = (RelativeLayout.LayoutParams)v0.X.getLayoutParams();
        RelativeLayout.LayoutParams v2_1 = (RelativeLayout.LayoutParams)v0.Y.getLayoutParams();
        RelativeLayout.LayoutParams v3_1 = (RelativeLayout.LayoutParams)v0.Z.getLayoutParams();
        RelativeLayout.LayoutParams v4_1 = (RelativeLayout.LayoutParams)v0.aa.getLayoutParams();
        v1_2.topMargin = k.a(v0, ((float)(v23 + v21_1)));
        v2_1.topMargin = k.a(v0, ((float)(v23 * 2 + v21_1 * 2)));
        v3_1.topMargin = k.a(v0, ((float)(v23 * 3 + v21_1 * 3)));
        v4_1.topMargin = k.a(v0, ((float)(v23 * 4 + v21_1 * 4)));
        v0.X.setLayoutParams(v1_2);
        v0.Y.setLayoutParams(v2_1);
        v0.Z.setLayoutParams(v3_1);
        v0.aa.setLayoutParams(v4_1);
    }

    public void m() {
        AppsApplication v0 = (AppsApplication)this.getApplication();
        if((AppsRunnerConnector.get(this).isConnected()) && (v0.n())) {
            this.p.setAlpha(1.0f);
            this.q.setAlpha(1.0f);
            this.r.setAlpha(1.0f);
            this.s.setAlpha(1.0f);
            this.t.setAlpha(1.0f);
            this.u.setAlpha(1.0f);
            this.v.setAlpha(1.0f);
            this.w.setAlpha(1.0f);
            this.x.setAlpha(1.0f);
            this.y.setAlpha(1.0f);
            this.p.setOnTouchListener(this);
            this.q.setOnTouchListener(this);
            this.r.setOnTouchListener(this);
            this.s.setOnTouchListener(this);
            this.t.setOnTouchListener(this);
            this.u.setOnTouchListener(this);
            this.v.setOnTouchListener(this);
            this.w.setOnTouchListener(this);
            this.x.setOnTouchListener(this);
            this.y.setOnTouchListener(this);
        }
        else {
            this.p.setAlpha(0.5f);
            this.q.setAlpha(0.5f);
            this.r.setAlpha(0.5f);
            this.s.setAlpha(0.5f);
            this.t.setAlpha(0.5f);
            this.u.setAlpha(0.5f);
            this.v.setAlpha(0.5f);
            this.w.setAlpha(0.5f);
            this.x.setAlpha(0.5f);
            this.y.setAlpha(0.5f);
            this.p.setOnTouchListener(null);
            this.q.setOnTouchListener(null);
            this.r.setOnTouchListener(null);
            this.s.setOnTouchListener(null);
            this.t.setOnTouchListener(null);
            this.u.setOnTouchListener(null);
            this.v.setOnTouchListener(null);
            this.w.setOnTouchListener(null);
            this.x.setOnTouchListener(null);
            this.y.setOnTouchListener(null);
        }

        this.o();
    }

    // Detected as a lambda impl.
    public void n() {
        this.startActivity(new Intent(this, AppsDeviceListActivity.class));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AppsModeChooseActivity.this.b(false);
                AppsModeChooseActivity.this.f();
            }
        }, 500L);
    }

    public boolean o() {
        if(!AppsRunner.get(this).g()) {
            AppsApplication v0 = (AppsApplication)this.getApplication();
            if((AppsRunnerConnector.get(this).isConnected()) && (v0.n())) {
                this.s.setAlpha(1.0f);
                this.u.setAlpha(1.0f);
                this.w.setAlpha(1.0f);
                this.y.setAlpha(1.0f);
                this.s.setOnTouchListener(this);
                this.u.setOnTouchListener(this);
                this.w.setOnTouchListener(this);
                this.y.setOnTouchListener(this);
            }

            return true;
        }

        int v0_1 = AppsRunner.get(this).b();
        if(v0_1 != 3 && v0_1 != 11 && v0_1 != 7 && v0_1 != 10 && v0_1 != 5 && v0_1 != 8) {
            this.s.setAlpha(0.5f);
            this.u.setAlpha(0.5f);
            this.w.setAlpha(0.5f);
            this.y.setAlpha(0.5f);
            this.s.setOnTouchListener(null);
            this.u.setOnTouchListener(null);
            this.w.setOnTouchListener(null);
            this.y.setOnTouchListener(null);
            return false;
        }

        AppsApplication v0_2 = (AppsApplication)this.getApplication();
        if((AppsRunnerConnector.get(this).isConnected()) && (v0_2.n())) {
            this.s.setAlpha(1.0f);
            this.u.setAlpha(1.0f);
            this.w.setAlpha(1.0f);
            this.y.setAlpha(1.0f);
            this.s.setOnTouchListener(this);
            this.u.setOnTouchListener(this);
            this.w.setOnTouchListener(this);
            this.y.setOnTouchListener(this);
        }

        return true;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        this.i.removeMessages(0x6F);
        if(((AppsApplication)this.getApplication()).m()) {
            return;
        }

        try {
            a v0_1 = new a(this);
            v0_1.b(0x7F0B0134);  // string:prompt "Warning"
            v0_1.a(0x7F0B004C);  // string:STR_EXIT "Exit?"
            v0_1.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                @Override  // android.content.DialogInterface$OnClickListener
                public void onClick(DialogInterface arg1, int arg2) {
                    try {
                        arg1.dismiss();
                    }
                    catch(Exception v1) {
                        v1.printStackTrace();
                    }

                    AppsModeChooseActivity.this.i();
                }
            });
            v0_1.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
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
            v0_1.a().show();
        }
        catch(Exception v0) {
            v0.printStackTrace();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg4) {
        if(!AppsRunnerConnector.get(this).G()) {
            BLEManager.get(this).enableAdapter();
        }

        AppsRunner.get(this).b(this);
        super.onCreate(arg4);
        this.k();
        this.getWindow().setFlags(0x80, 0x80);
        this.a(0x7F09002D, 0x7F09002E, 0x7F090030, 0x7F09002F);  // layout:activity_mode_choose
        AppsRunner.get(this).f(this, 0);
        this.p();
        this.c(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!AppsRunnerConnector.get(AppsModeChooseActivity.this).G()) {
                    String v1 = AppsModeChooseActivity.this.getResources().getString(0x7F0B000C);  // string:STR_ALERT_TIP_NOT_OPEN_BLUETOOTH "Please turn on your bluetooth within the device"
                    AppsModeChooseActivity.this.a(v1);
                }
            }
        }, 2000L);
        ((AppsApplication)this.getApplication()).doRefreshToken(this);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        super.onDestroy();
        this.c(false);
    }

    @Override  // android.app.Activity
    public void onRequestPermissionsResult(int arg2, String[] arg3, int[] arg4) {
        if(arg2 != 1) {
            super.onRequestPermissionsResult(arg2, arg3, arg4);
        }
        else if(arg4.length > 0 && arg4[0] == 0) {
            if(!AppsRunnerConnector.get(this).G()) {
                BLEManager.get(this).enableAdapter();
                return;
            }

            BLEManager.get(this).startScan();
            return;
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        ((AppsApplication)this.getApplication()).f(true);
        this.aL = true;
        AppsRunner.get(this).b(this);
        this.a(false);
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        ((AppsApplication)this.getApplication()).f(false);
        this.aL = false;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg8, MotionEvent arg9) {
        Message v9_2;
        if(arg9.getAction() == 0) {
            if(arg8 == this.n) {
                this.i.removeMessages(0x6F);
                this.b(false);
            }
            else if(arg8 == this.p || arg8 == this.q || arg8 == this.r || arg8 == this.s || arg8 == this.t || arg8 == this.u || arg8 == this.v || arg8 == this.w || arg8 == this.x || arg8 == this.y) {
                this.aP = this.a(arg8);
                int v9 = AppsRunner.get(this).shouldStopWhenChangeRunMode(this.aP);
                j.a("-----切换了模式-----", v9 + " |");
                if(v9 > 0) {
                    try {
                        a v8_1 = new a(this);
                        v8_1.b(0x7F0B0134);  // string:prompt "Warning"
                        Resources v2 = this.getResources();
                        int v9_1 = v9 == 2 ? 0x7F0B0014 : 0x7F0B0013;  // string:STR_ALERT_TIP_STOP_RUN3 "If you change to the Fit Test program, your current workout information will be lost. Do you wish to end your current workout?"
                        v8_1.a(v2.getString(v9_1));
                        v8_1.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                            @Override  // android.content.DialogInterface$OnClickListener
                            public void onClick(DialogInterface arg2, int arg3) {
                                arg2.dismiss();
                                AppsModeChooseActivity.this.a(true, false);
                                int v0 = AppsModeChooseActivity.d(AppsModeChooseActivity.this);
                                AppsModeChooseActivity.this.a(v0, true);
                                AppsModeChooseActivity.this.e();
                                AppsModeChooseActivity.this.l();
                                if(((AppsApplication)AppsModeChooseActivity.this.getApplication()).isConnectionCorrect()) {
                                    AppsModeChooseActivity.e(AppsModeChooseActivity.this);
                                }
                            }
                        });
                        v8_1.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
                            @Override  // android.content.DialogInterface$OnClickListener
                            public void onClick(DialogInterface arg1, int arg2) {
                                arg1.dismiss();
                            }
                        });
                        v8_1.a().show();
                    }
                    catch(Exception v8) {
                        v8.printStackTrace();
                    }

                    return true;
                }
            }

            if(arg8 == this.p) {
                if(this.aM) {
                    return true;
                }

                if(this.aN) {
                    return true;
                }

                this.aJ = 0;
                this.aI = 0x7F060083;  // drawable:afg2_manual_down
                this.aG = 0x7F0B009A;  // string:STR_MODE_NEW_MANUAL "Manual"
                this.aH = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B009C : 0x7F0B009B;  // string:STR_MODE_NEW_MANUAL_DESC_EP "Control everything about your workout – from start to finish. This program is a basic workout with no pre-defined settings. It begins with resistance at 1. It’s up to you where you go from there and for how long."
                AppsRunner.get(this).f(this, 0);
                if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                    this.q();
                }
            }
            else if(arg8 == this.q) {
                if(this.aM) {
                    return true;
                }

                if(this.aN) {
                    return true;
                }

                this.aJ = 1;
                this.aI = 0x7F06006F;  // drawable:afg2_hill_climb__down
                this.aG = 0x7F0B0097;  // string:STR_MODE_NEW_HILL_CLIMB "Hill Climb"
                this.aH = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B0099 : 0x7F0B0098;  // string:STR_MODE_NEW_HILL_CLIMB_DESC_EP "Simulates a hill ascent and descent. This program helps tone muscle and improve cardiovascular ability. Incline and resistance change and segments repeat every 60 seconds."
                AppsRunner.get(this).f(this, 1);
                if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                    this.q();
                }
            }
            else if(arg8 == this.r) {
                if(this.aM) {
                    return true;
                }

                if(this.aN) {
                    return true;
                }

                this.aJ = 2;
                this.aI = 0x7F060060;  // drawable:afg2_distance__down
                this.aG = 0x7F0B0091;  // string:STR_MODE_NEW_DISTANCE "Distance"
                this.aH = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B0093 : 0x7F0B0092;  // string:STR_MODE_NEW_DISTANCE_DESC_EP "Push yourself and go further during your workout with 13 distance workouts. Choose from 1 mile, 2 miles, 5k, 5 miles, 10k, 8 miles, 15k, 10 miles, 20k, half marathon, 15 miles, 20 miles, and marathon goals. You set your level."
                AppsRunner.get(this).f(this, 2);
                if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                    this.q();
                }
            }
            else if(arg8 == this.s) {
                if(this.aM) {
                    return true;
                }

                if(this.aN) {
                    return true;
                }

                this.aJ = 3;
                this.aI = 0x7F060095;  // drawable:afg2_target_hreat_rate__down
                this.aG = 0x7F0B00A4;  // string:STR_MODE_NEW_TARGET_HEART_RATE2 "Target Heart Rate"
                this.aH = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B00A6 : 0x7F0B00A5;  // string:STR_MODE_NEW_TARGET_HEART_RATE_DESC_EP "Automatically adjusts resistance to maintain your Target Heart Rate. Perfect for simulating the intensity of your favorite sport or everyday activity. This is a time-based goal program."
                AppsRunner.get(this).f(this, 3);
                if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                    this.q();
                }
            }
            else if(arg8 == this.t) {
                if(this.aM) {
                    return true;
                }

                if(this.aN) {
                    return true;
                }

                this.aJ = 4;
                this.aI = 0x7F06005A;  // drawable:afg2_calories__down
                this.aG = 0x7F0B0087;  // string:STR_MODE_NEW_CALORIES "Calories"
                this.aH = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B0089 : 0x7F0B0088;  // string:STR_MODE_NEW_CALORIES_DESC_EP "Set goals for burning calories from 20 to 980 calories in 20 calorie increments. You set your level to keep you in your fat burning zone."
                AppsRunner.get(this).f(this, 4);
                if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                    this.q();
                }
            }
            else {
                long v5 = 12000L;
                if(arg8 == this.u) {
                    this.aM = true;
                    this.a(this, "", false);
                    this.aJ = 5;
                    this.aI = 0x7F060086;  // drawable:afg2_my_frist_5k__down
                    this.aG = 0x7F0B009D;  // string:STR_MODE_NEW_MY_FIRST_5KM "My First 5k"
                    this.aH = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B009F : 0x7F0B009E;  // string:STR_MODE_NEW_MY_FIRST_5KM_DESC_EP "This program is intended for inexperienced runners looking to run their first 5k or simply begin an exercise routine. This 9 week program is designed specifically to keep you motivated and engaged."
                    AppsRunner.get(this).f(this, 5);
                    if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                        this.q();
                    }

                    this.l.removeMessages(0x6F);
                    v9_2 = new Message();
                    v9_2.what = 0x6F;
                    this.l.sendMessageDelayed(v9_2, v5);
                }
                else {
                    if(arg8 != this.v) {
                        goto label_284;
                    }

                    if(this.aM) {
                        return true;
                    }

                    if(this.aN) {
                        return true;
                    }

                    this.aJ = 6;
                    this.aI = 0x7F060066;  // drawable:afg2_fat_burn__down
                    this.aG = 0x7F0B0094;  // string:STR_MODE_NEW_FAT_BURN "Fat Burn"
                    this.aH = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B0096 : 0x7F0B0095;  // string:STR_MODE_NEW_FAT_BURN_DESC_EP "Promotes weight loss by increasing and decreasing the resistance, while keeping you in your fat burning zone. Segments repeat every 60 seconds."
                    AppsRunner.get(this).f(this, 6);
                    if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                        this.q();
                        goto label_409;
                    label_284:
                        if(arg8 == this.w) {
                            this.aM = true;
                            this.a(this, "", false);
                            this.aJ = 11;
                            this.aI = 0x7F06005C;  // drawable:afg2_custom__down
                            this.aG = 0x7F0B008A;  // string:STR_MODE_NEW_CUSTOM "Custom"
                            this.aH = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B008C : 0x7F0B008B;  // string:STR_MODE_NEW_CUSTOM_DESC_EP "Lets you create and reuse your perfect workout with a combination of a specific resistance, incline and time or distance. The ultimate in personal programming. This is a time or distance based goal program."
                            AppsRunner.get(this).f(this, 11);
                            if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                                this.q();
                            }

                            this.l.removeMessages(0x6F);
                            v9_2 = new Message();
                            v9_2.what = 0x6F;
                            this.l.sendMessageDelayed(v9_2, v5);
                            goto label_409;
                        }

                        if(arg8 == this.x) {
                            if(this.aM) {
                                return true;
                            }

                            if(this.aN) {
                                return true;
                            }

                            this.aJ = 9;
                            this.aI = 0x7F06008C;  // drawable:afg2_prints_down
                            this.aG = 0x7F0B00A0;  // string:STR_MODE_NEW_SPRINTS "Sprint 8"
                            this.aH = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B00A2 : 0x7F0B00A1;  // string:STR_MODE_NEW_SPRINTS_DESC_EP "Improves your strength, speed and endurance by increasing and decreasing the resistance throughout your workout to involve your heart and other muscles. The resistance changes and the program consists of repeating segments of 90 seconds and 30 seconds."
                            AppsRunner.get(this).f(this, 9);
                            if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                                this.q();
                            }
                        }
                        else if(arg8 == this.y) {
                            this.aN = true;
                            this.a(this, "", false);
                            this.aJ = 8;
                            this.aI = 0x7F06005D;  // drawable:afg2_custom_heart_rate__down
                            this.aG = 0x7F0B0090;  // string:STR_MODE_NEW_CUSTOM_HR "Custom HR"
                            this.aH = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B008F : 0x7F0B008E;  // string:STR_MODE_NEW_CUSTOM_HEART_RATE_DESC_EP "Allows you to program up to 4 segments and set each segment with a targeted heart rate. The program automatically adjusts the resistance in each segment to maintain your target heart rate. This is a time-based goal program."
                            AppsRunner.get(this).f(this, 8);
                            if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                                this.q();
                            }

                            this.m.removeMessages(0x6F);
                            v9_2 = new Message();
                            v9_2.what = 0xDE;
                            this.m.sendMessageDelayed(v9_2, v5);
                        }
                        else if(arg8 == this.ab) {
                            this.startActivity(new Intent(this, AppsUserActivity.class));
                        }
                        else if(arg8 == this.ac) {
                            this.startActivity(new Intent(this, AppsHistoryActivity.class));
                        }
                        else if(arg8 == this.ah) {
                            Intent v9_3 = new Intent();
                            v9_3.setAction("NOTIFICATION_DIDCONNECT");
                            this.getApplicationContext().sendBroadcast(v9_3);
                        }
                    }
                }
            }

        label_409:
            if(arg8 == this.p || arg8 == this.q || arg8 == this.r || arg8 == this.s || arg8 == this.t || arg8 == this.u || arg8 == this.v || arg8 == this.w || arg8 == this.x || arg8 == this.y || arg8 == this.ad) {
                long v1 = 500L;
                if(arg8 == this.ad) {
                    if(!AppsRunnerConnector.get(this.getApplicationContext()).G()) {
                        this.a(this.getResources().getString(0x7F0B000C));  // string:STR_ALERT_TIP_NOT_OPEN_BLUETOOTH "Please turn on your bluetooth within the device"
                        return true;
                    }

                    AppsApplication v9_4 = (AppsApplication)this.getApplication();
                    if((!AppsRunnerConnector.get(this).isConnected() || !v9_4.n() || !v9_4.o()) && (this.b(true))) {
                        return true;
                    }

                    String v9_5 = (String)ContextSharedPreferences.SharedPreferences(this, "PREVIOUS_CONNECTED_DEVICE", "", 5);
                    j.a("==按了开始==", v9_5 + " ||");
                    if(apps.c.d.strNotEmpty(v9_5)) {
                        j.a("==之前没连接过设备==", "==跳到设备列表去==");
                        this.startActivity(new Intent(this, AppsDeviceListActivity.class));
                        new Handler().postDelayed(() -> {
                            j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)false))));
                            if(false) {
                                AppsModeChooseActivity.this.af.setVisibility(0);
                                AppsModeChooseActivity.this.i.removeMessages(0x6F);
                                if(((AppsApplication)AppsModeChooseActivity.this.getApplication()).m()) {
                                    return true;
                                }

                                Message v5 = new Message();
                                v5.what = 0x6F;
                                AppsModeChooseActivity.this.i.sendMessageDelayed(v5, 30000L);
                                return true;
                            }

                            AppsModeChooseActivity.this.af.setVisibility(8);
                            AppsModeChooseActivity.this.i.removeMessages(0x6F);
                            return false;
                        }, v1);
                        return true;
                    }

                    j.a("==之前有连接过设备==", "====");
                }

                boolean v9_6 = AppsRunnerConnector.get(this).B();
                if(!AppsRunnerConnector.get(this).isConnected() && (v9_6)) {
                    this.b(true);
                    return true;
                }

                if(arg8 == this.ad) {
                    j.a("==selectProgramFailedFlag==", this.aR + " |");
                    if(this.aR) {
                        this.a("PLEASE CONFIRM THE DEVICE PROGRAM IS THE SAME TO THE APP PROGRAM");
                        return true;
                    }

                    this.b(this, "", false);
                    new Handler().postDelayed(() -> {
                        AppsModeChooseActivity.this.startActivity(new Intent(AppsModeChooseActivity.this, AppsDeviceListActivity.class));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                AppsModeChooseActivity.this.b(false);
                                AppsModeChooseActivity.this.f();
                            }
                        }, 500L);
                    }, v1);
                }
            }

            if(arg8 == this.p || arg8 == this.q || arg8 == this.r || arg8 == this.s || arg8 == this.t || arg8 == this.u || arg8 == this.v || arg8 == this.w || arg8 == this.x || arg8 == this.y) {
                this.e();
                this.l();
            }
        }

        return true;

        class com.xtremeprog.shell.treadmillv2.activity.AppsModeChooseActivity.3 implements Runnable {
            @Override
            public void run() {
                AppsModeChooseActivity.this.b(false);
            }
        }


        class com.xtremeprog.shell.treadmillv2.activity.AppsModeChooseActivity.4 implements Runnable {
            @Override
            public void run() {
                AppsModeChooseActivity.this.n();
            }
        }

    }

    private void p() {
        this.b();
        this.n = n.a().a(this, 0x7F0700C9, this);  // id:homeButton2
        this.o = n.a().e(this, 0x7F0700CF);  // id:homeTextView2
        this.M = n.a().d(this, 0x7F070137);  // id:modeIconImageView1
        this.N = n.a().d(this, 0x7F070139);  // id:modeIconImageView2
        this.O = n.a().d(this, 0x7F07013A);  // id:modeIconImageView3
        this.P = n.a().d(this, 0x7F07013B);  // id:modeIconImageView4
        this.Q = n.a().d(this, 0x7F07013C);  // id:modeIconImageView5
        this.R = n.a().d(this, 0x7F07013D);  // id:modeIconImageView6
        this.S = n.a().d(this, 0x7F07013E);  // id:modeIconImageView7
        this.T = n.a().d(this, 0x7F07013F);  // id:modeIconImageView8
        this.U = n.a().d(this, 0x7F070140);  // id:modeIconImageView9
        this.V = n.a().d(this, 0x7F070138);  // id:modeIconImageView10
        this.ad = n.a().a(this, 0x7F07026B, this);  // id:startButton
        this.ae = n.a().e(this, 0x7F070275);  // id:startTextView
        this.p = n.a().c(this, 0x7F070120, this);  // id:modeButton1
        this.q = n.a().c(this, 0x7F070122, this);  // id:modeButton2
        this.r = n.a().c(this, 0x7F070123, this);  // id:modeButton3
        this.s = n.a().c(this, 0x7F070124, this);  // id:modeButton4
        this.t = n.a().c(this, 0x7F070125, this);  // id:modeButton5
        this.u = n.a().c(this, 0x7F070126, this);  // id:modeButton6
        this.v = n.a().c(this, 0x7F070127, this);  // id:modeButton7
        this.w = n.a().c(this, 0x7F070128, this);  // id:modeButton8
        this.x = n.a().c(this, 0x7F070129, this);  // id:modeButton9
        this.y = n.a().c(this, 0x7F070121, this);  // id:modeButton10
        this.ab = n.a().c(this, 0x7F0702F3, this);  // id:userLayout
        this.ac = n.a().c(this, 0x7F0700C4, this);  // id:historyLayout
        this.z = n.a().e(this, 0x7F070164);  // id:modeTextView1
        this.A = n.a().e(this, 0x7F070166);  // id:modeTextView2
        this.B = n.a().e(this, 0x7F070167);  // id:modeTextView3
        this.C = n.a().e(this, 0x7F070168);  // id:modeTextView4
        this.D = n.a().e(this, 0x7F070169);  // id:modeTextView5
        this.E = n.a().e(this, 0x7F07016A);  // id:modeTextView6
        this.F = n.a().e(this, 0x7F07016B);  // id:modeTextView7
        this.G = n.a().e(this, 0x7F07016C);  // id:modeTextView8
        this.H = n.a().e(this, 0x7F07016D);  // id:modeTextView9
        this.I = n.a().e(this, 0x7F070165);  // id:modeTextView10
        this.K = n.a().e(this, 0x7F0702F5);  // id:userTextView
        this.L = n.a().e(this, 0x7F0700C5);  // id:historyTextView
        this.J = n.a().e(this, 0x7F0702F4);  // id:userNameTextView
        this.ag = n.a().e(this, 0x7F070177);  // id:noBluetoothTextView
        this.af = n.a().c(this, 0x7F070176);  // id:noBluetoothLayout
        this.ah = n.a().a(this, 0x7F070280, this);  // id:testConnectButton
        this.ai = n.a().b(this, 0x7F070282, this);  // id:testStartLayout
        this.aj = n.a().b(this, 0x7F0700A6);  // id:epLayout
        this.ak = n.a().c(this, 0x7F070108);  // id:lineLayout1
        this.al = n.a().c(this, 0x7F070109);  // id:lineLayout2
        this.am = n.a().g(this, 0x7F07014F);  // id:modeLineLayout1
        this.an = n.a().g(this, 0x7F070153);  // id:modeLineLayout2
        this.ao = n.a().g(this, 0x7F070155);  // id:modeLineLayout3
        this.ap = n.a().g(this, 0x7F070157);  // id:modeLineLayout4
        this.aq = n.a().g(this, 0x7F070159);  // id:modeLineLayout5
        this.ar = n.a().g(this, 0x7F07015B);  // id:modeLineLayout6
        this.as = n.a().g(this, 0x7F07015D);  // id:modeLineLayout7
        this.at = n.a().g(this, 0x7F07015F);  // id:modeLineLayout8
        this.au = n.a().g(this, 0x7F070161);  // id:modeLineLayout9
        this.av = n.a().g(this, 0x7F070150);  // id:modeLineLayout10
        this.aw = n.a().g(this, 0x7F070152);  // id:modeLineLayout11
        this.ax = n.a().g(this, 0x7F070154);  // id:modeLineLayout22
        this.ay = n.a().g(this, 0x7F070156);  // id:modeLineLayout33
        this.az = n.a().g(this, 0x7F070158);  // id:modeLineLayout44
        this.aA = n.a().g(this, 0x7F07015A);  // id:modeLineLayout55
        this.aB = n.a().g(this, 0x7F07015C);  // id:modeLineLayout66
        this.aC = n.a().g(this, 0x7F07015E);  // id:modeLineLayout77
        this.aD = n.a().g(this, 0x7F070160);  // id:modeLineLayout88
        this.aE = n.a().g(this, 0x7F070162);  // id:modeLineLayout99
        this.aF = n.a().g(this, 0x7F070151);  // id:modeLineLayout1010
        this.W = n.a().b(this, 0x7F07014B);  // id:modeLayout12
        this.X = n.a().b(this, 0x7F07014C);  // id:modeLayout34
        this.Y = n.a().b(this, 0x7F07014D);  // id:modeLayout56
        this.Z = n.a().b(this, 0x7F07014E);  // id:modeLayout78
        this.aa = n.a().b(this, 0x7F0700A6);  // id:epLayout
        this.aJ = AppsRunner.get(this).k(this);
        this.l();
        this.e();
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.ah.setVisibility(8);
        this.ai.setVisibility(8);
    }

    private void q() {
        AppsRunnerConnector.get(this).selectProgram(this.aJ);
    }
}
