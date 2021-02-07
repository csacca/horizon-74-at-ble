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
import com.xtremeprog.shell.treadmillv2.AppsUnMatchPhoneActivity;
import com.xtremeprog.shell.treadmillv2.ShareFitness;
import java.util.Date;

public class AppsModeChoosePhoneActivity extends AppsRootActivity implements View.OnTouchListener {
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
    private int ak;
    private int al;
    private int am;
    private int an;
    private int ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private boolean as;
    private int at;
    private BroadcastReceiver au;
    private boolean av;
    private Date aw;
    private d ax;
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

    public AppsModeChoosePhoneActivity() {
        this.ak = 0x7F0B009A;  // string:STR_MODE_NEW_MANUAL "Manual"
        this.al = 0x7F0B009B;  // string:STR_MODE_NEW_MANUAL_DESC "Control everything about your workout – from start to finish. This program is a basic workout with no pre-defined settings. It begins with an incline at 0 and speed at 0.5 mph. It’s up to you where you go from there and for how long."
        this.am = 0x7F060083;  // drawable:afg2_manual_down
        this.an = 0;
        this.ao = 0;
        this.ap = false;
        this.aq = false;
        this.ar = false;
        this.as = false;
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    j.a("===-=-开始跳到设备列表=-=-=", "===跳到设备列表====");
                    Intent v4 = new Intent(AppsModeChoosePhoneActivity.this, AppsDeviceListPhoneActivity.class);
                    AppsModeChoosePhoneActivity.this.startActivity(v4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsModeChoosePhoneActivity.this.b(false);
                        }
                    }, 500L);
                }
            }
        };
        this.au = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg7, Intent arg8) {
                Message v8_1;
                Handler v7_8;
                Handler v8;
                Message v7_3;
                Intent v7_1;
                String v7 = arg8.getAction();
                if(v7.equals("NOTIFICATION_DIDCONNECT")) {
                    AppsModeChoosePhoneActivity.this.m();
                    return;
                }

                if(v7.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                    if(!AppsModeChoosePhoneActivity.a(AppsModeChoosePhoneActivity.this)) {
                        return;
                    }

                    AppsModeChoosePhoneActivity.this.b(false);
                    AppsModeChoosePhoneActivity.this.m();
                    return;
                }

                if(v7.equals("NOTIFICATION_DISCONNECT")) {
                    AppsModeChoosePhoneActivity.a(AppsModeChoosePhoneActivity.this);
                    AppsModeChoosePhoneActivity.this.m();
                    return;
                }

                if(v7.equals("NOTIFICATION_DID_GET_USER")) {
                    AppsModeChoosePhoneActivity.this.e();
                    return;
                }

                if(v7.equals("NOTIFICATION_RECEIVE_START_RUNNING_ACTIVITY")) {
                    v7_1 = new Intent(AppsModeChoosePhoneActivity.this, Apps321PhoneActivity.class);
                    AppsModeChoosePhoneActivity.this.startActivity(v7_1);
                    return;
                }

                if(!v7.equals("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE")) {
                    goto label_51;
                }

                if(((int)(((Integer)arg8.getExtras().get("Extra_Key_SafetyKey_State")))) == 1 && !AppsRunner.get(AppsModeChoosePhoneActivity.this.getApplicationContext()).a) {
                    AppsModeChoosePhoneActivity.this.a(false, true);
                    return;
                label_51:
                    if(v7.equals("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS")) {
                        AppsModeChoosePhoneActivity.this.a(false);
                        return;
                    }

                    if(v7.equals("NOTIFICATION_DID_RESTART_WORKOUT")) {
                        if((AppsRunner.get(AppsModeChoosePhoneActivity.this.getApplicationContext()).a) || !AppsRunner.get(AppsModeChoosePhoneActivity.this.getApplicationContext()).g()) {
                            return;
                        }

                        int v7_2 = AppsRunner.get(AppsModeChoosePhoneActivity.this.getApplicationContext()).U;
                        AppsRunner.get(AppsModeChoosePhoneActivity.this.getApplicationContext()).f(AppsModeChoosePhoneActivity.this.getApplicationContext(), v7_2);
                        v7_1 = new Intent(AppsModeChoosePhoneActivity.this, Apps321PhoneActivity.class);
                        AppsModeChoosePhoneActivity.this.startActivity(v7_1);
                        return;
                    }

                    if(v7.equals("NOTIFICATION_UN_MATCH_MACHINE")) {
                        v7_1 = new Intent(AppsModeChoosePhoneActivity.this, AppsUnMatchPhoneActivity.class);
                        AppsModeChoosePhoneActivity.this.startActivity(v7_1);
                        return;
                    }

                    if(v7.equals("NOTIFICATION_DID_TIME_OUT")) {
                        return;
                    }

                    if(v7.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                        j.a("=[=-=取消延时===", "取消延时");
                        AppsModeChoosePhoneActivity.this.i.removeMessages(0x6F);
                        return;
                    }

                    long v4 = 0L;
                    if(v7.equals("NOTIFICATION_DID_SET_MY_FIRST_5K")) {
                        j.a("===收到set5K==", "解锁");
                        AppsModeChoosePhoneActivity.this.l.removeMessages(0x6F);
                        v7_3 = new Message();
                        goto label_136;
                    }

                    if(v7.equals("NOTIFICATION_DID_DEVICE_SET_CUSTOM_PROGRAM")) {
                        j.a("===收到setCustom==", "解锁");
                        AppsModeChoosePhoneActivity.this.l.removeMessages(0x6F);
                        v7_3 = new Message();
                    label_136:
                        v7_3.what = 0x6F;
                        v8 = AppsModeChoosePhoneActivity.this.l;
                        v8.sendMessageDelayed(v7_3, v4);
                        return;
                    }

                    if(v7.equals("NOTIFICATION_DID_DEVICE_SET_CUSTOM_HR_PROGRAM")) {
                        j.a("===收到setCustomHR==", "解锁");
                        AppsModeChoosePhoneActivity.this.m.removeMessages(0xDE);
                        v7_3 = new Message();
                        v7_3.what = 0xDE;
                        v8 = AppsModeChoosePhoneActivity.this.m;
                        v8.sendMessageDelayed(v7_3, v4);
                        return;
                    }

                    if(v7.equals("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER")) {
                        AppsModeChoosePhoneActivity.this.m();
                        return;
                    }

                    if(!v7.equals("NOTIFICATION_JUST_KNOW_WORKOUT")) {
                        goto label_185;
                    }

                    if(AppsRunner.get(AppsModeChoosePhoneActivity.this).k(AppsModeChoosePhoneActivity.this) == 5 || !AppsRunner.get(AppsModeChoosePhoneActivity.this).g()) {
                        AppsRunner.get(AppsModeChoosePhoneActivity.this).clear();
                        AppsRunner.get(AppsModeChoosePhoneActivity.this).setCurrentStopWorkoutInfo(null);
                        return;
                    label_185:
                        if(v7.equals("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER")) {
                            if(!AppsModeChoosePhoneActivity.a(AppsModeChoosePhoneActivity.this)) {
                                return;
                            }

                            AppsModeChoosePhoneActivity.this.b(false);
                            AppsModeChoosePhoneActivity.this.m();
                            return;
                        }

                        if(v7.equals("NOTIFICATION_DID_STOP_WORKOUT_FINISH")) {
                            if(!AppsModeChoosePhoneActivity.a(AppsModeChoosePhoneActivity.this)) {
                                return;
                            }

                            AppsModeChoosePhoneActivity.this.m();
                            return;
                        }

                        if(v7.equals("NOTIFICATION_SHOULD_TO_DEVICE_LIST")) {
                            if(!AppsModeChoosePhoneActivity.b(AppsModeChoosePhoneActivity.this)) {
                                AppsModeChoosePhoneActivity.a(AppsModeChoosePhoneActivity.this, true);
                                Intent v7_4 = new Intent(AppsModeChoosePhoneActivity.this, AppsDeviceListPhoneActivity.class);
                                AppsModeChoosePhoneActivity.this.startActivity(v7_4);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        AppsModeChoosePhoneActivity.this.b(false);
                                    }
                                }, 500L);
                                return;
                            }
                        }
                        else if(!v7.equals("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE_SHOULD_RESHOW")) {
                            if(v7.equals("NOTIFICATION_RE_SHOW_LOADING")) {
                                if(!AppsModeChoosePhoneActivity.a(AppsModeChoosePhoneActivity.this)) {
                                    return;
                                }

                                AppsModeChoosePhoneActivity.b(AppsModeChoosePhoneActivity.this, true);
                                AppsModeChoosePhoneActivity.this.a(AppsModeChoosePhoneActivity.this, "", false);
                                AppsModeChoosePhoneActivity.this.l.removeMessages(0x6F);
                                Message v7_6 = new Message();
                                v7_6.what = 0x6F;
                                AppsModeChoosePhoneActivity.this.l.sendMessageDelayed(v7_6, 12000L);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_DID_SELECT_PROGRAM")) {
                                int v7_7 = (int)(((Integer)arg8.getExtras().get("responseCode")));
                                j.a("HOME SELECT PROGRAM RESPONSE CODE", v7_7 + " |");
                                if(v7_7 == 0) {
                                    AppsModeChoosePhoneActivity.c(AppsModeChoosePhoneActivity.this, false);
                                    return;
                                }

                                AppsModeChoosePhoneActivity.c(AppsModeChoosePhoneActivity.this, true);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_REFRESH_MMF_TOKEN_FAILED_5_TIMES")) {
                                ((AppsApplication)AppsModeChoosePhoneActivity.this.getApplication()).c(((String)arg8.getExtras().get("userId")));
                                return;
                            }

                            if(v7.equals("NOTIFICATION_REFRESH_MFP_TOKEN_FAILED_5_TIMES")) {
                                ((AppsApplication)AppsModeChoosePhoneActivity.this.getApplication()).e(((String)arg8.getExtras().get("userId")));
                                return;
                            }

                            if(v7.equals("NOTIFICATION_TO_MMF_LOGIN")) {
                                ShareFitness.get(AppsModeChoosePhoneActivity.this).a(0);
                                ShareFitness.get(AppsModeChoosePhoneActivity.this).b();
                                v7_8 = AppsModeChoosePhoneActivity.this.k;
                                v8_1 = new Message();
                            }
                            else {
                                if(!v7.equals("NOTIFICATION_TO_MFP_LOGIN")) {
                                    return;
                                }

                                ShareFitness.get(AppsModeChoosePhoneActivity.this).a(1);
                                ShareFitness.get(AppsModeChoosePhoneActivity.this).b();
                                v7_8 = AppsModeChoosePhoneActivity.this.k;
                                v8_1 = new Message();
                            }

                            v7_8.sendMessage(v8_1);
                            return;
                            AppsModeChoosePhoneActivity.this.m();
                            return;
                        }
                        else if(AppsModeChoosePhoneActivity.a(AppsModeChoosePhoneActivity.this)) {
                            int v7_5 = AppsRunner.get(AppsModeChoosePhoneActivity.this).securitySwitch;
                            j.a("==来到mode了==", v7_5 + " |");
                            if(v7_5 == 1) {
                                ((AppsApplication)AppsModeChoosePhoneActivity.this.getApplication()).showSafetyAlert(1, -1, false);
                                return;
                            }
                        }
                    }
                }
            }
        };
        this.av = false;
        this.j = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsRunner.get(AppsModeChoosePhoneActivity.this.getApplicationContext()).clear();
                if(arg2.what == 1) {
                    AppsModeChoosePhoneActivity.this.f();
                }
            }
        };
        this.k = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                Intent v3 = new Intent(AppsModeChoosePhoneActivity.this, AppsShareAuthActivity.class);
                v3.putExtra("isFromRefreshToken", true);
                AppsModeChoosePhoneActivity.this.startActivity(v3);
            }
        };
        this.aw = null;
        this.ax = null;
        this.l = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsModeChoosePhoneActivity.b(AppsModeChoosePhoneActivity.this, false);
                AppsModeChoosePhoneActivity.this.g();
            }
        };
        this.m = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsModeChoosePhoneActivity.d(AppsModeChoosePhoneActivity.this, false);
                AppsModeChoosePhoneActivity.this.g();
            }
        };
    }

    static boolean a(AppsModeChoosePhoneActivity arg0) {
        return arg0.ap;
    }

    static boolean a(AppsModeChoosePhoneActivity arg0, boolean arg1) {
        arg0.as = arg1;
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
            this.an = 0;
            this.am = 0x7F060083;  // drawable:afg2_manual_down
            this.ak = 0x7F0B009A;  // string:STR_MODE_NEW_MANUAL "Manual"
            this.al = v4 ? 0x7F0B009C : 0x7F0B009B;  // string:STR_MODE_NEW_MANUAL_DESC_EP "Control everything about your workout – from start to finish. This program is a basic workout with no pre-defined settings. It begins with resistance at 1. It’s up to you where you go from there and for how long."
            AppsRunner.get(this).f(this, 0);
            return;
        }

        int v0 = 1;
        if(arg3 == 1) {
            this.an = 1;
            this.am = 0x7F06006F;  // drawable:afg2_hill_climb__down
            this.ak = 0x7F0B0097;  // string:STR_MODE_NEW_HILL_CLIMB "Hill Climb"
            v3 = v4 ? 0x7F0B0099 : 0x7F0B0098;  // string:STR_MODE_NEW_HILL_CLIMB_DESC_EP "Simulates a hill ascent and descent. This program helps tone muscle and improve cardiovascular ability. Incline and resistance change and segments repeat every 60 seconds."
        }
        else {
            v0 = 2;
            if(arg3 == 2) {
                this.an = 2;
                this.am = 0x7F060060;  // drawable:afg2_distance__down
                this.ak = 0x7F0B0091;  // string:STR_MODE_NEW_DISTANCE "Distance"
                v3 = v4 ? 0x7F0B0093 : 0x7F0B0092;  // string:STR_MODE_NEW_DISTANCE_DESC_EP "Push yourself and go further during your workout with 13 distance workouts. Choose from 1 mile, 2 miles, 5k, 5 miles, 10k, 8 miles, 15k, 10 miles, 20k, half marathon, 15 miles, 20 miles, and marathon goals. You set your level."
            }
            else {
                v0 = 3;
                if(arg3 == 3) {
                    this.an = 3;
                    this.am = 0x7F060095;  // drawable:afg2_target_hreat_rate__down
                    this.ak = 0x7F0B00A4;  // string:STR_MODE_NEW_TARGET_HEART_RATE2 "Target Heart Rate"
                    v3 = v4 ? 0x7F0B00A6 : 0x7F0B00A5;  // string:STR_MODE_NEW_TARGET_HEART_RATE_DESC_EP "Automatically adjusts resistance to maintain your Target Heart Rate. Perfect for simulating the intensity of your favorite sport or everyday activity. This is a time-based goal program."
                }
                else {
                    v0 = 4;
                    if(arg3 == 4) {
                        this.an = 4;
                        this.am = 0x7F06005A;  // drawable:afg2_calories__down
                        this.ak = 0x7F0B0087;  // string:STR_MODE_NEW_CALORIES "Calories"
                        v3 = v4 ? 0x7F0B0089 : 0x7F0B0088;  // string:STR_MODE_NEW_CALORIES_DESC_EP "Set goals for burning calories from 20 to 980 calories in 20 calorie increments. You set your level to keep you in your fat burning zone."
                    }
                    else {
                        v0 = 5;
                        if(arg3 == 5) {
                            this.an = 5;
                            this.am = 0x7F060086;  // drawable:afg2_my_frist_5k__down
                            this.ak = 0x7F0B009D;  // string:STR_MODE_NEW_MY_FIRST_5KM "My First 5k"
                            v3 = v4 ? 0x7F0B009F : 0x7F0B009E;  // string:STR_MODE_NEW_MY_FIRST_5KM_DESC_EP "This program is intended for inexperienced runners looking to run their first 5k or simply begin an exercise routine. This 9 week program is designed specifically to keep you motivated and engaged."
                        }
                        else {
                            v0 = 6;
                            if(arg3 == 6) {
                                this.an = 6;
                                this.am = 0x7F060066;  // drawable:afg2_fat_burn__down
                                this.ak = 0x7F0B0094;  // string:STR_MODE_NEW_FAT_BURN "Fat Burn"
                                v3 = v4 ? 0x7F0B0096 : 0x7F0B0095;  // string:STR_MODE_NEW_FAT_BURN_DESC_EP "Promotes weight loss by increasing and decreasing the resistance, while keeping you in your fat burning zone. Segments repeat every 60 seconds."
                            }
                            else {
                                v0 = 11;
                                if(arg3 != 11 && arg3 != 7 && arg3 != 10) {
                                    v0 = 9;
                                    if(arg3 == 9) {
                                        this.an = 9;
                                        this.am = 0x7F06008C;  // drawable:afg2_prints_down
                                        this.ak = 0x7F0B00A0;  // string:STR_MODE_NEW_SPRINTS "Sprint 8"
                                        v3 = v4 ? 0x7F0B00A2 : 0x7F0B00A1;  // string:STR_MODE_NEW_SPRINTS_DESC_EP "Improves your strength, speed and endurance by increasing and decreasing the resistance throughout your workout to involve your heart and other muscles. The resistance changes and the program consists of repeating segments of 90 seconds and 30 seconds."
                                    }
                                    else {
                                        v0 = 8;
                                        if(arg3 != 8) {
                                            return;
                                        }

                                        this.an = 8;
                                        this.am = 0x7F06005D;  // drawable:afg2_custom_heart_rate__down
                                        this.ak = 0x7F0B008D;  // string:STR_MODE_NEW_CUSTOM_HEART_RATE "Custom Heart Rate"
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
                                    this.an = 11;
                                    this.am = 0x7F06005C;  // drawable:afg2_custom__down
                                    this.ak = 0x7F0B008A;  // string:STR_MODE_NEW_CUSTOM "Custom"
                                    v3 = v4 ? 0x7F0B008C : 0x7F0B008B;  // string:STR_MODE_NEW_CUSTOM_DESC_EP "Lets you create and reuse your perfect workout with a combination of a specific resistance, incline and time or distance. The ultimate in personal programming. This is a time or distance based goal program."
                                }
                            }
                        }
                    }
                }
            }
        }

    label_131:
        this.al = v3;
        AppsRunner.get(this).f(this, v0);
    }

    public void a(boolean arg27) {
        float v3_1;
        int v2_1;
        LinearLayout v1_1;
        AppsModeChoosePhoneActivity v0 = this;
        int v1 = AppsRunner.get(this).k(v0);
        int v2 = AppsRunner.get(this).l(v0);
        boolean v3 = AppsRunner.get(this).r(v0);
        v0.ao = v2;
        v0.an = v1;
        if(v3) {
            v1_1 = v0.aj;
            v2_1 = 0;
        }
        else {
            v1_1 = v0.aj;
            v2_1 = 8;
        }

        v1_1.setVisibility(v2_1);
        v0.a(v0.an, arg27);
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
        RelativeLayout.LayoutParams v15 = (RelativeLayout.LayoutParams)v0.P.getLayoutParams();
        LinearLayout.LayoutParams v27 = v11;
        RelativeLayout.LayoutParams v11_1 = (RelativeLayout.LayoutParams)v0.Q.getLayoutParams();
        LinearLayout.LayoutParams v16 = v10;
        RelativeLayout.LayoutParams v10_1 = (RelativeLayout.LayoutParams)v0.R.getLayoutParams();
        LinearLayout.LayoutParams v17 = v9;
        RelativeLayout.LayoutParams v9_1 = (RelativeLayout.LayoutParams)v0.S.getLayoutParams();
        LinearLayout.LayoutParams v18 = v8;
        RelativeLayout.LayoutParams v8_1 = (RelativeLayout.LayoutParams)v0.T.getLayoutParams();
        LinearLayout.LayoutParams v19 = v7;
        RelativeLayout.LayoutParams v7_1 = (RelativeLayout.LayoutParams)v0.U.getLayoutParams();
        LinearLayout.LayoutParams v20 = v6;
        RelativeLayout.LayoutParams v6_1 = (RelativeLayout.LayoutParams)v0.V.getLayoutParams();
        LinearLayout.LayoutParams v21 = v5;
        RelativeLayout.LayoutParams v5_1 = (RelativeLayout.LayoutParams)v0.W.getLayoutParams();
        RelativeLayout.LayoutParams v5_2 = (RelativeLayout.LayoutParams)v0.X.getLayoutParams();
        LinearLayout.LayoutParams v22 = v4;
        RelativeLayout.LayoutParams v4_1 = (RelativeLayout.LayoutParams)v0.Y.getLayoutParams();
        LinearLayout.LayoutParams v23 = v2_2;
        RelativeLayout.LayoutParams v2_3 = (RelativeLayout.LayoutParams)v0.Z.getLayoutParams();
        LinearLayout.LayoutParams v24 = v1_2;
        RelativeLayout.LayoutParams v1_3 = (RelativeLayout.LayoutParams)v0.aj.getLayoutParams();
        RelativeLayout.LayoutParams v25 = v8_1;
        if(v3) {
            v12.rightMargin = k.a(v0, 10.0f);
            v11_1.rightMargin = k.a(v0, 10.0f);
            v7_1.rightMargin = k.a(v0, 10.0f);
            v13.leftMargin = k.a(v0, 10.0f);
            v10_1.leftMargin = k.a(v0, 10.0f);
            v6_1.leftMargin = k.a(v0, 10.0f);
            v5_2.topMargin = k.a(v0, 90.0f);
            v4_1.topMargin = k.a(v0, 180.0f);
            v2_3.topMargin = k.a(v0, 270.0f);
            v3_1 = 360.0f;
        }
        else {
            v12.rightMargin = k.a(v0, 10.0f);
            v11_1.rightMargin = k.a(v0, 10.0f);
            v7_1.rightMargin = k.a(v0, 10.0f);
            v13.leftMargin = k.a(v0, 10.0f);
            v10_1.leftMargin = k.a(v0, 10.0f);
            v6_1.leftMargin = k.a(v0, 10.0f);
            v5_2.topMargin = k.a(v0, 100.0f);
            v4_1.topMargin = k.a(v0, 200.0f);
            v2_3.topMargin = k.a(v0, 300.0f);
            v3_1 = 400.0f;
        }

        v1_3.topMargin = k.a(v0, v3_1);
        v0.M.setLayoutParams(v12);
        v0.N.setLayoutParams(v13);
        v0.O.setLayoutParams(v14);
        v0.P.setLayoutParams(v15);
        v0.Q.setLayoutParams(v11_1);
        v0.R.setLayoutParams(v10_1);
        v0.S.setLayoutParams(v9_1);
        v0.T.setLayoutParams(v25);
        v0.U.setLayoutParams(v7_1);
        v0.V.setLayoutParams(v6_1);
        v0.p.setLayoutParams(v24);
        v0.q.setLayoutParams(v23);
        v0.r.setLayoutParams(v22);
        v0.s.setLayoutParams(v21);
        v0.t.setLayoutParams(v20);
        v0.u.setLayoutParams(v19);
        v0.v.setLayoutParams(v18);
        v0.w.setLayoutParams(v17);
        v0.x.setLayoutParams(v16);
        v0.y.setLayoutParams(v27);
        v0.X.setLayoutParams(v5_2);
        v0.Y.setLayoutParams(v4_1);
        v0.Z.setLayoutParams(v2_3);
        v0.aa.setLayoutParams(v1_3);
        this.m();
    }

    public void a(boolean arg3, boolean arg4) {
        if(arg3) {
            this.b(this, this.getResources().getString(0x7F0B000F), false);  // string:STR_ALERT_TIP_SAVE_SESSION "Save workout result..."
        }

        this.aw = new Date();
        new Thread() {
            @Override
            public void run() {
                AppsRunner.get(AppsModeChoosePhoneActivity.this.getApplicationContext()).a(AppsModeChoosePhoneActivity.this.getApplicationContext(), AppsModeChoosePhoneActivity.c(AppsModeChoosePhoneActivity.this));
                if(((boolean)(((int)arg4)))) {
                    AppsRunner.get(AppsModeChoosePhoneActivity.this.getApplicationContext()).s();
                }

                Message v0 = new Message();
                v0.what = ((boolean)(((int)arg3)));
                AppsModeChoosePhoneActivity.this.j.sendMessage(v0);
            }
        }.start();
    }

    static boolean b(AppsModeChoosePhoneActivity arg0) {
        return arg0.as;
    }

    static boolean b(AppsModeChoosePhoneActivity arg0, boolean arg1) {
        arg0.aq = arg1;
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

    static Date c(AppsModeChoosePhoneActivity arg0) {
        return arg0.aw;
    }

    static boolean c(AppsModeChoosePhoneActivity arg0, boolean arg1) {
        arg0.av = arg1;
        return arg1;
    }

    public void c(boolean arg2) {
        if(!arg2) {
            goto label_170;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.au, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.au, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_DID_GET_USER");
            this.registerReceiver(this.au, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_RECEIVE_START_RUNNING_ACTIVITY");
            this.registerReceiver(this.au, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE");
            this.registerReceiver(this.au, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS");
            this.registerReceiver(this.au, v2_6);
            IntentFilter v2_7 = new IntentFilter();
            v2_7.addAction("NOTIFICATION_DID_RESTART_WORKOUT");
            this.registerReceiver(this.au, v2_7);
            IntentFilter v2_8 = new IntentFilter();
            v2_8.addAction("NOTIFICATION_UN_MATCH_MACHINE");
            this.registerReceiver(this.au, v2_8);
            IntentFilter v2_9 = new IntentFilter();
            v2_9.addAction("NOTIFICATION_DID_TIME_OUT");
            this.registerReceiver(this.au, v2_9);
            IntentFilter v2_10 = new IntentFilter();
            v2_10.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.au, v2_10);
            IntentFilter v2_11 = new IntentFilter();
            v2_11.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.au, v2_11);
            IntentFilter v2_12 = new IntentFilter();
            v2_12.addAction("NOTIFICATION_DID_SET_MY_FIRST_5K");
            this.registerReceiver(this.au, v2_12);
            IntentFilter v2_13 = new IntentFilter();
            v2_13.addAction("NOTIFICATION_DID_DEVICE_SET_CUSTOM_PROGRAM");
            this.registerReceiver(this.au, v2_13);
            IntentFilter v2_14 = new IntentFilter();
            v2_14.addAction("NOTIFICATION_DID_DEVICE_SET_CUSTOM_HR_PROGRAM");
            this.registerReceiver(this.au, v2_14);
            IntentFilter v2_15 = new IntentFilter();
            v2_15.addAction("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER");
            this.registerReceiver(this.au, v2_15);
            IntentFilter v2_16 = new IntentFilter();
            v2_16.addAction("NOTIFICATION_JUST_KNOW_WORKOUT");
            this.registerReceiver(this.au, v2_16);
            IntentFilter v2_17 = new IntentFilter();
            v2_17.addAction("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER");
            this.registerReceiver(this.au, v2_17);
            IntentFilter v2_18 = new IntentFilter();
            v2_18.addAction("NOTIFICATION_DID_STOP_WORKOUT_FINISH");
            this.registerReceiver(this.au, v2_18);
            IntentFilter v2_19 = new IntentFilter();
            v2_19.addAction("NOTIFICATION_SHOULD_TO_DEVICE_LIST");
            this.registerReceiver(this.au, v2_19);
            IntentFilter v2_20 = new IntentFilter();
            v2_20.addAction("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE_SHOULD_RESHOW");
            this.registerReceiver(this.au, v2_20);
            IntentFilter v2_21 = new IntentFilter();
            v2_21.addAction("NOTIFICATION_RE_SHOW_LOADING");
            this.registerReceiver(this.au, v2_21);
            IntentFilter v2_22 = new IntentFilter();
            v2_22.addAction("NOTIFICATION_DID_SELECT_PROGRAM");
            this.registerReceiver(this.au, v2_22);
            IntentFilter v2_23 = new IntentFilter();
            v2_23.addAction("NOTIFICATION_REFRESH_MMF_TOKEN_FAILED_5_TIMES");
            this.registerReceiver(this.au, v2_23);
            IntentFilter v2_24 = new IntentFilter();
            v2_24.addAction("NOTIFICATION_REFRESH_MFP_TOKEN_FAILED_5_TIMES");
            this.registerReceiver(this.au, v2_24);
            IntentFilter v2_25 = new IntentFilter();
            v2_25.addAction("NOTIFICATION_TO_MMF_LOGIN");
            this.registerReceiver(this.au, v2_25);
            IntentFilter v2_26 = new IntentFilter();
            v2_26.addAction("NOTIFICATION_TO_MFP_LOGIN");
            this.registerReceiver(this.au, v2_26);
            IntentFilter v2_27 = new IntentFilter();
            v2_27.addAction("NOTIFICATION_TO_MMF_LOGIN_BUT_NOT_JUMP");
            this.registerReceiver(this.au, v2_27);
            IntentFilter v2_28 = new IntentFilter();
            v2_28.addAction("NOTIFICATION_TO_MFP_LOGIN_BUT_NOT_JUMP");
            this.registerReceiver(this.au, v2_28);
            return;
        label_170:
            this.unregisterReceiver(this.au);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static int d(AppsModeChoosePhoneActivity arg0) {
        return arg0.at;
    }

    static boolean d(AppsModeChoosePhoneActivity arg0, boolean arg1) {
        arg0.ar = arg1;
        return arg1;
    }

    static void e(AppsModeChoosePhoneActivity arg0) {
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
        n.a().e(this, 0x7F0700C5).setText(this.getResources().getString(0x7F0B0073));  // id:historyTextView
        n.a().e(this, 0x7F070275).setText(this.getResources().getString(0x7F0B00C5));  // id:startTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0702C6).setText(this.getResources().getString(0x7F0B00B3));  // id:tv_title
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
        int v1;
        ImageView v0_1;
        this.p.setEnabled(true);
        this.q.setEnabled(true);
        this.r.setEnabled(true);
        this.s.setEnabled(true);
        this.t.setEnabled(true);
        this.u.setEnabled(true);
        this.v.setEnabled(true);
        this.w.setEnabled(true);
        this.x.setEnabled(true);
        this.y.setEnabled(true);
        this.M.setBackgroundResource(0x7F06013F);  // drawable:pad_select_program1_nor
        this.N.setBackgroundResource(0x7F060140);  // drawable:pad_select_program1_nor_66
        this.O.setBackgroundResource(0x7F060141);  // drawable:pad_select_program1_nor_67
        this.P.setBackgroundResource(0x7F060142);  // drawable:pad_select_program1_nor_68
        this.Q.setBackgroundResource(0x7F060143);  // drawable:pad_select_program1_nor_69
        this.R.setBackgroundResource(0x7F060144);  // drawable:pad_select_program1_nor_70
        this.S.setBackgroundResource(0x7F060145);  // drawable:pad_select_program1_nor_71
        this.T.setBackgroundResource(0x7F060146);  // drawable:pad_select_program1_nor_72
        this.U.setBackgroundResource(0x7F0601C4);  // drawable:sprint8
        this.V.setBackgroundResource(0x7F060148);  // drawable:pad_select_program1_nor_74
        int v0 = this.an;
        if(v0 == 0) {
            this.p.setEnabled(false);
            v0_1 = this.M;
            v1 = 0x7F060149;  // drawable:pad_select_program1_sel
        }
        else if(v0 == 1) {
            this.q.setEnabled(false);
            v0_1 = this.N;
            v1 = 0x7F06014A;  // drawable:pad_select_program2_sel
        }
        else if(v0 == 2) {
            this.r.setEnabled(false);
            v0_1 = this.O;
            v1 = 0x7F06014B;  // drawable:pad_select_program3_sel
        }
        else if(v0 == 3) {
            this.s.setEnabled(false);
            v0_1 = this.P;
            v1 = 0x7F06014C;  // drawable:pad_select_program4_sel
        }
        else if(v0 == 4) {
            this.t.setEnabled(false);
            v0_1 = this.Q;
            v1 = 0x7F06014D;  // drawable:pad_select_program5_sel
        }
        else if(v0 == 5) {
            this.u.setEnabled(false);
            v0_1 = this.R;
            v1 = 0x7F06014E;  // drawable:pad_select_program6_sel
        }
        else if(v0 == 6) {
            this.v.setEnabled(false);
            v0_1 = this.S;
            v1 = 0x7F06014F;  // drawable:pad_select_program7_sel
        }
        else if(v0 == 11 || v0 == 7 || v0 == 10) {
            this.w.setEnabled(false);
            v0_1 = this.T;
            v1 = 0x7F060150;  // drawable:pad_select_program8_sel
        }
        else if(v0 == 9) {
            this.x.setEnabled(false);
            v0_1 = this.U;
            v1 = 0x7F0601C5;  // drawable:sprint8_choice
        }
        else {
            if(v0 == 8) {
                this.y.setEnabled(false);
                v0_1 = this.V;
                v1 = 0x7F06013E;  // drawable:pad_select_program10_sel
                goto label_127;
            }

            return;
        }

    label_127:
        v0_1.setBackgroundResource(v1);
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
        this.startActivity(new Intent(this, AppsDeviceListPhoneActivity.class));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AppsModeChoosePhoneActivity.this.b(false);
                AppsModeChoosePhoneActivity.this.f();
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

                    AppsModeChoosePhoneActivity.this.i();
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
        this.getWindow().setFlags(0x80, 0x80);
        this.setContentView(0x7F090031);  // layout:activity_mode_choose_phone
        AppsRunner.get(this).f(this, 0);
        this.p();
        this.c(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!AppsRunnerConnector.get(AppsModeChoosePhoneActivity.this).G()) {
                    String v1 = AppsModeChoosePhoneActivity.this.getResources().getString(0x7F0B000C);  // string:STR_ALERT_TIP_NOT_OPEN_BLUETOOTH "Please turn on your bluetooth within the device"
                    AppsModeChoosePhoneActivity.this.a(v1);
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

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        ((AppsApplication)this.getApplication()).f(true);
        this.ap = true;
        AppsRunner.get(this).b(this);
        this.a(false);
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        ((AppsApplication)this.getApplication()).f(false);
        this.ap = false;
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
                this.at = this.a(arg8);
                int v9 = AppsRunner.get(this).shouldStopWhenChangeRunMode(this.at);
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
                                AppsModeChoosePhoneActivity.this.a(true, false);
                                int v0 = AppsModeChoosePhoneActivity.d(AppsModeChoosePhoneActivity.this);
                                AppsModeChoosePhoneActivity.this.a(v0, true);
                                AppsModeChoosePhoneActivity.this.e();
                                AppsModeChoosePhoneActivity.this.l();
                                if(((AppsApplication)AppsModeChoosePhoneActivity.this.getApplication()).isConnectionCorrect()) {
                                    AppsModeChoosePhoneActivity.e(AppsModeChoosePhoneActivity.this);
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
                if(this.aq) {
                    return true;
                }

                if(this.ar) {
                    return true;
                }

                this.an = 0;
                this.am = 0x7F060083;  // drawable:afg2_manual_down
                this.ak = 0x7F0B009A;  // string:STR_MODE_NEW_MANUAL "Manual"
                this.al = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B009C : 0x7F0B009B;  // string:STR_MODE_NEW_MANUAL_DESC_EP "Control everything about your workout – from start to finish. This program is a basic workout with no pre-defined settings. It begins with resistance at 1. It’s up to you where you go from there and for how long."
                AppsRunner.get(this).f(this, 0);
                if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                    this.q();
                }
            }
            else if(arg8 == this.q) {
                if(this.aq) {
                    return true;
                }

                if(this.ar) {
                    return true;
                }

                this.an = 1;
                this.am = 0x7F06006F;  // drawable:afg2_hill_climb__down
                this.ak = 0x7F0B0097;  // string:STR_MODE_NEW_HILL_CLIMB "Hill Climb"
                this.al = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B0099 : 0x7F0B0098;  // string:STR_MODE_NEW_HILL_CLIMB_DESC_EP "Simulates a hill ascent and descent. This program helps tone muscle and improve cardiovascular ability. Incline and resistance change and segments repeat every 60 seconds."
                AppsRunner.get(this).f(this, 1);
                if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                    this.q();
                }
            }
            else if(arg8 == this.r) {
                if(this.aq) {
                    return true;
                }

                if(this.ar) {
                    return true;
                }

                this.an = 2;
                this.am = 0x7F060060;  // drawable:afg2_distance__down
                this.ak = 0x7F0B0091;  // string:STR_MODE_NEW_DISTANCE "Distance"
                this.al = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B0093 : 0x7F0B0092;  // string:STR_MODE_NEW_DISTANCE_DESC_EP "Push yourself and go further during your workout with 13 distance workouts. Choose from 1 mile, 2 miles, 5k, 5 miles, 10k, 8 miles, 15k, 10 miles, 20k, half marathon, 15 miles, 20 miles, and marathon goals. You set your level."
                AppsRunner.get(this).f(this, 2);
                if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                    this.q();
                }
            }
            else if(arg8 == this.s) {
                if(this.aq) {
                    return true;
                }

                if(this.ar) {
                    return true;
                }

                this.an = 3;
                this.am = 0x7F060095;  // drawable:afg2_target_hreat_rate__down
                this.ak = 0x7F0B00A4;  // string:STR_MODE_NEW_TARGET_HEART_RATE2 "Target Heart Rate"
                this.al = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B00A6 : 0x7F0B00A5;  // string:STR_MODE_NEW_TARGET_HEART_RATE_DESC_EP "Automatically adjusts resistance to maintain your Target Heart Rate. Perfect for simulating the intensity of your favorite sport or everyday activity. This is a time-based goal program."
                AppsRunner.get(this).f(this, 3);
                if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                    this.q();
                }
            }
            else if(arg8 == this.t) {
                if(this.aq) {
                    return true;
                }

                if(this.ar) {
                    return true;
                }

                this.an = 4;
                this.am = 0x7F06005A;  // drawable:afg2_calories__down
                this.ak = 0x7F0B0087;  // string:STR_MODE_NEW_CALORIES "Calories"
                this.al = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B0089 : 0x7F0B0088;  // string:STR_MODE_NEW_CALORIES_DESC_EP "Set goals for burning calories from 20 to 980 calories in 20 calorie increments. You set your level to keep you in your fat burning zone."
                AppsRunner.get(this).f(this, 4);
                if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                    this.q();
                }
            }
            else {
                long v5 = 12000L;
                if(arg8 == this.u) {
                    this.aq = true;
                    this.a(this, "", false);
                    this.an = 5;
                    this.am = 0x7F060086;  // drawable:afg2_my_frist_5k__down
                    this.ak = 0x7F0B009D;  // string:STR_MODE_NEW_MY_FIRST_5KM "My First 5k"
                    this.al = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B009F : 0x7F0B009E;  // string:STR_MODE_NEW_MY_FIRST_5KM_DESC_EP "This program is intended for inexperienced runners looking to run their first 5k or simply begin an exercise routine. This 9 week program is designed specifically to keep you motivated and engaged."
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

                    if(this.aq) {
                        return true;
                    }

                    if(this.ar) {
                        return true;
                    }

                    this.an = 6;
                    this.am = 0x7F060066;  // drawable:afg2_fat_burn__down
                    this.ak = 0x7F0B0094;  // string:STR_MODE_NEW_FAT_BURN "Fat Burn"
                    this.al = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B0096 : 0x7F0B0095;  // string:STR_MODE_NEW_FAT_BURN_DESC_EP "Promotes weight loss by increasing and decreasing the resistance, while keeping you in your fat burning zone. Segments repeat every 60 seconds."
                    AppsRunner.get(this).f(this, 6);
                    if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                        this.q();
                        goto label_404;
                    label_284:
                        if(arg8 == this.w) {
                            this.aq = true;
                            this.a(this, "", false);
                            this.an = 11;
                            this.am = 0x7F06005C;  // drawable:afg2_custom__down
                            this.ak = 0x7F0B008A;  // string:STR_MODE_NEW_CUSTOM "Custom"
                            this.al = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B008C : 0x7F0B008B;  // string:STR_MODE_NEW_CUSTOM_DESC_EP "Lets you create and reuse your perfect workout with a combination of a specific resistance, incline and time or distance. The ultimate in personal programming. This is a time or distance based goal program."
                            AppsRunner.get(this).f(this, 11);
                            if(((AppsApplication)this.getApplication()).isConnectionCorrect()) {
                                this.q();
                            }

                            this.l.removeMessages(0x6F);
                            v9_2 = new Message();
                            v9_2.what = 0x6F;
                            this.l.sendMessageDelayed(v9_2, v5);
                            goto label_404;
                        }

                        if(arg8 == this.x) {
                            if(this.aq) {
                                return true;
                            }

                            if(this.ar) {
                                return true;
                            }

                            this.an = 9;
                            this.am = 0x7F06008C;  // drawable:afg2_prints_down
                            this.ak = 0x7F0B00A0;  // string:STR_MODE_NEW_SPRINTS "Sprint 8"
                            this.al = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B00A2 : 0x7F0B00A1;  // string:STR_MODE_NEW_SPRINTS_DESC_EP "Improves your strength, speed and endurance by increasing and decreasing the resistance throughout your workout to involve your heart and other muscles. The resistance changes and the program consists of repeating segments of 90 seconds and 30 seconds."
                            AppsRunner.get(this).f(this, 9);
                            this.q();
                        }
                        else if(arg8 == this.y) {
                            this.ar = true;
                            this.a(this, "", false);
                            this.an = 8;
                            this.am = 0x7F06005D;  // drawable:afg2_custom_heart_rate__down
                            this.ak = 0x7F0B0090;  // string:STR_MODE_NEW_CUSTOM_HR "Custom HR"
                            this.al = AppsRunner.get(this).inclineSupportsHalfDegree(this) ? 0x7F0B008F : 0x7F0B008E;  // string:STR_MODE_NEW_CUSTOM_HEART_RATE_DESC_EP "Allows you to program up to 4 segments and set each segment with a targeted heart rate. The program automatically adjusts the resistance in each segment to maintain your target heart rate. This is a time-based goal program."
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
                            this.startActivity(new Intent(this, AppsUserPhoneActivity.class));
                        }
                        else if(arg8 == this.ac) {
                            this.startActivity(new Intent(this, AppsHistoryPhoneActivity.class));
                        }
                        else if(arg8 == this.ah) {
                            Intent v9_3 = new Intent();
                            v9_3.setAction("NOTIFICATION_DIDCONNECT");
                            this.getApplicationContext().sendBroadcast(v9_3);
                        }
                    }
                }
            }

        label_404:
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
                        this.startActivity(new Intent(this, AppsDeviceListPhoneActivity.class));
                        new Handler().postDelayed(() -> {
                            j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)false))));
                            if(false) {
                                AppsModeChoosePhoneActivity.this.af.setVisibility(0);
                                AppsModeChoosePhoneActivity.this.i.removeMessages(0x6F);
                                if(((AppsApplication)AppsModeChoosePhoneActivity.this.getApplication()).m()) {
                                    return true;
                                }

                                Message v5 = new Message();
                                v5.what = 0x6F;
                                AppsModeChoosePhoneActivity.this.i.sendMessageDelayed(v5, 30000L);
                                return true;
                            }

                            AppsModeChoosePhoneActivity.this.af.setVisibility(8);
                            AppsModeChoosePhoneActivity.this.i.removeMessages(0x6F);
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
                    j.a("==selectProgramFailedFlag==", this.av + " |");
                    if(this.av) {
                        this.a("PLEASE CONFIRM THE DEVICE PROGRAM IS THE SAME TO THE APP PROGRAM");
                        return true;
                    }

                    this.b(this, "", false);
                    new Handler().postDelayed(() -> {
                        AppsModeChoosePhoneActivity.this.startActivity(new Intent(AppsModeChoosePhoneActivity.this, AppsDeviceListPhoneActivity.class));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                AppsModeChoosePhoneActivity.this.b(false);
                                AppsModeChoosePhoneActivity.this.f();
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

        class com.xtremeprog.shell.treadmillv2.activity.AppsModeChoosePhoneActivity.3 implements Runnable {
            @Override
            public void run() {
                AppsModeChoosePhoneActivity.this.b(false);
            }
        }


        class com.xtremeprog.shell.treadmillv2.activity.AppsModeChoosePhoneActivity.4 implements Runnable {
            @Override
            public void run() {
                AppsModeChoosePhoneActivity.this.n();
            }
        }

    }

    private void p() {
        this.b();
        this.c();
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
        this.W = n.a().b(this, 0x7F07014B);  // id:modeLayout12
        this.X = n.a().b(this, 0x7F07014C);  // id:modeLayout34
        this.Y = n.a().b(this, 0x7F07014D);  // id:modeLayout56
        this.Z = n.a().b(this, 0x7F07014E);  // id:modeLayout78
        this.aa = n.a().b(this, 0x7F0700A6);  // id:epLayout
        this.an = AppsRunner.get(this).k(this);
        this.l();
        this.e();
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.ah.setVisibility(8);
        this.ai.setVisibility(8);
    }

    private void q() {
        AppsRunnerConnector.get(this).selectProgram(this.an);
    }
}
