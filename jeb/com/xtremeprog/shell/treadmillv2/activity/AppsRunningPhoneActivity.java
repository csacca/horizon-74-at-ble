package com.xtremeprog.shell.treadmillv2.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import apps.activity.base.AppsRootActivity;
import apps.c.ContextSharedPreferences;
import apps.c.c;
import apps.c.f;
import apps.c.j;
import apps.c.k;
import apps.c.n;
import apps.views.d;
import com.xpg.a.Enums.deviceCommandEnum;
import com.xpg.a.a.StopWorkoutInfo;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner.a;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import com.xtremeprog.shell.treadmillv2.h;
import com.xtremeprog.shell.treadmillv2.views.AppsISMeterView;
import com.xtremeprog.shell.treadmillv2.views.AppsRunningDoubleTrackView;
import com.xtremeprog.shell.treadmillv2.views.b;
import java.util.Date;
import java.util.List;

public class AppsRunningPhoneActivity extends AppsRootActivity implements View.OnTouchListener, a, com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.a {
    private RelativeLayout A;
    private RelativeLayout B;
    private RelativeLayout C;
    private RelativeLayout D;
    private RelativeLayout E;
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
    private RelativeLayout P;
    private RelativeLayout Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;
    private RelativeLayout aA;
    private LinearLayout aB;
    private LinearLayout aC;
    private LinearLayout aD;
    private TextView aE;
    private TextView aF;
    private TextView aG;
    private TextView aH;
    private TextView aI;
    private TextView aJ;
    private TextView aK;
    private RelativeLayout aL;
    private int aM;
    private String aN;
    private String aO;
    private String aP;
    private String aQ;
    private String aR;
    private ImageView aS;
    private TextView aT;
    private ScrollView aU;
    private TextView aV;
    private int aW;
    private boolean aX;
    private boolean shouldStopSafetyKeyTip;
    private double aZ;
    private TextView aa;
    private TextView ab;
    private TextView ac;
    private TextView ad;
    private TextView ae;
    private TextView af;
    private TextView ag;
    private TextView ah;
    private TextView ai;
    private TextView aj;
    private RelativeLayout ak;
    private Button al;
    private RelativeLayout am;
    private LinearLayout an;
    private LinearLayout ao;
    private LinearLayout ap;
    private LinearLayout aq;
    private LinearLayout ar;
    private RelativeLayout noHRTip;
    private ImageView at;
    private ImageView au;
    private ImageView av;
    private ImageView aw;
    private TextView ax;
    private TextView ay;
    private RelativeLayout az;
    private int ba;
    private int bb;
    private int bc;
    private int bd;
    private d be;
    private RelativeLayout bf;
    private StopWorkoutInfo bg;
    private boolean bh;
    private boolean bi;
    private boolean bj;
    private int bk;
    private int bl;
    private Handler handleStartCoolDown_1_2_3;
    private int bn;
    private BroadcastReceiver bo;
    private Handler handle_showNoHR_111111;
    private boolean bq;
    private Date fromRunningDate;
    private boolean bs;
    private Handler bt;
    final Handler handleStartCoolDown_111;
    final Handler j;
    final Handler k;
    private Button l;
    private Button m;
    private Button n;
    private Button o;
    private Button p;
    private RelativeLayout q;
    private RelativeLayout r;
    private LinearLayout s;
    private TextView t;
    private TextView u;
    private TextView v;
    private AppsISMeterView w;
    private AppsISMeterView x;
    private AppsRunningDoubleTrackView y;
    private RelativeLayout z;

    public AppsRunningPhoneActivity() {
        this.aW = 0;
        this.aX = true;
        this.shouldStopSafetyKeyTip = false;
        this.aZ = 2.0;
        this.ba = 0;
        this.bc = 0;
        this.bd = 0;
        this.be = null;
        this.bg = null;
        this.bh = false;
        this.bi = false;
        this.bj = false;
        this.bk = 0;
        this.bl = 3;
        this.handleStartCoolDown_1_2_3 = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg5) {
                if(arg5.what == 1) {
                    AppsRunningPhoneActivity.a(AppsRunningPhoneActivity.this).setVisibility(8);
                    AppsRunningPhoneActivity.b(AppsRunningPhoneActivity.this).setVisibility(0);
                    AppsRunningPhoneActivity.c(AppsRunningPhoneActivity.this).setVisibility(8);
                    return;
                }

                if(arg5.what == 2) {
                    AppsRunningPhoneActivity.a(AppsRunningPhoneActivity.this).setVisibility(8);
                    AppsRunningPhoneActivity.b(AppsRunningPhoneActivity.this).setVisibility(8);
                    AppsRunningPhoneActivity.c(AppsRunningPhoneActivity.this).setVisibility(0);
                    return;
                }

                if(arg5.what == 3) {
                    AppsRunningPhoneActivity.this.startCooldown(false, false);
                    if(AppsRunningPhoneActivity.d(AppsRunningPhoneActivity.this)) {
                        AppsRunningPhoneActivity.a(AppsRunningPhoneActivity.this, false);
                        boolean v5 = AppsRunner.get(AppsRunningPhoneActivity.this).g();
                        j.a("======pauseRun===", ((boolean)(((int)v5))) + " |");
                        if(v5) {
                            AppsRunner.get(AppsRunningPhoneActivity.this).resumeRun();
                            return;
                        }

                        AppsRunner.get(AppsRunningPhoneActivity.this).startRun();
                        return;
                    }

                    j.a("===倒计时的justResumeRun", "===justResumeRun===");
                    AppsRunner.get(AppsRunningPhoneActivity.this).justResumeRun();
                }
            }
        };
        this.handleStartCoolDown_111 = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    AppsRunner.get(AppsRunningPhoneActivity.this).U = AppsRunner.get(AppsRunningPhoneActivity.this).k(AppsRunningPhoneActivity.this);
                    AppsRunner.get(AppsRunningPhoneActivity.this).i();
                    Intent v4 = new Intent(AppsRunningPhoneActivity.this, AppsDeviceListPhoneActivity.class);
                    v4.putExtra("Extra_Key_isFromRunning", true);
                    AppsRunningPhoneActivity.this.startActivity(v4);
                    AppsRunningPhoneActivity.this.finish();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsRunningPhoneActivity.this.b(false, false);
                        }
                    }, 500L);
                    return;
                }
            }
        };
        this.bn = 0;
        this.bo = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg7, Intent arg8) {
                String v7 = arg8.getAction();
                if(!v7.equals("NOTIFICATION_DIDCONNECT")) {
                    if(v7.equals("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER")) {
                        j.a("===Running0==", "NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER " + AppsRunner.get(AppsRunningPhoneActivity.this.getApplicationContext()).a);
                        if(!AppsRunner.get(AppsRunningPhoneActivity.this.getApplicationContext()).a) {
                            return;
                        }

                        int v7_1 = AppsRunningPhoneActivity.e(AppsRunningPhoneActivity.this);
                        j.a("==Running02==", v7_1 + " | " + AppsRunningPhoneActivity.f(AppsRunningPhoneActivity.this) + " | " + AppsRunningPhoneActivity.g(AppsRunningPhoneActivity.this).getVisibility());
                        if(v7_1 != 1 && v7_1 != 2) {
                            if(AppsRunningPhoneActivity.g(AppsRunningPhoneActivity.this).getVisibility() != 0) {
                                AppsRunningPhoneActivity.a(AppsRunningPhoneActivity.this, 0);
                                return;
                            }

                            AppsRunningPhoneActivity.h(AppsRunningPhoneActivity.this);
                            if(AppsRunningPhoneActivity.f(AppsRunningPhoneActivity.this) > 1) {
                                return;
                            }

                            AppsRunningPhoneActivity.this.handleStartCoolDown_111.removeMessages(0x6F);
                            AppsRunningPhoneActivity.this.finish();
                            return;
                        }

                        if(AppsRunningPhoneActivity.g(AppsRunningPhoneActivity.this).getVisibility() != 0) {
                            AppsRunningPhoneActivity.a(AppsRunningPhoneActivity.this, 0);
                            return;
                        }

                        AppsRunningPhoneActivity.h(AppsRunningPhoneActivity.this);
                        if(AppsRunningPhoneActivity.f(AppsRunningPhoneActivity.this) > 1) {
                            return;
                        }

                        AppsRunningPhoneActivity.this.handleStartCoolDown_111.removeMessages(0x6F);
                        AppsRunningPhoneActivity.this.b(false, true);
                        AppsRunningPhoneActivity.this.startCooldown(true, false);
                        return;
                    }
                    else {
                        if(v7.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                            j.a("===Running==", "NOTIFICATION_SYN_USER_INFO_FINISH " + AppsRunner.get(AppsRunningPhoneActivity.this.getApplicationContext()).a);
                            if(!AppsRunner.get(AppsRunningPhoneActivity.this.getApplicationContext()).a) {
                                return;
                            }

                            int v7_2 = AppsRunningPhoneActivity.e(AppsRunningPhoneActivity.this);
                            j.a("==Running2==", v7_2 + " | " + AppsRunningPhoneActivity.f(AppsRunningPhoneActivity.this) + " | " + AppsRunningPhoneActivity.g(AppsRunningPhoneActivity.this).getVisibility());
                            if(v7_2 != 1 && v7_2 != 2) {
                                if(AppsRunningPhoneActivity.g(AppsRunningPhoneActivity.this).getVisibility() != 0) {
                                    AppsRunningPhoneActivity.a(AppsRunningPhoneActivity.this, 0);
                                    return;
                                }

                                AppsRunningPhoneActivity.h(AppsRunningPhoneActivity.this);
                                if(AppsRunningPhoneActivity.f(AppsRunningPhoneActivity.this) > 1) {
                                    return;
                                }

                                AppsRunningPhoneActivity.this.handleStartCoolDown_111.removeMessages(0x6F);
                                AppsRunningPhoneActivity.this.finish();
                                return;
                            }

                            if(AppsRunningPhoneActivity.g(AppsRunningPhoneActivity.this).getVisibility() == 0) {
                                AppsRunningPhoneActivity.h(AppsRunningPhoneActivity.this);
                                if(AppsRunningPhoneActivity.f(AppsRunningPhoneActivity.this) > 1) {
                                    return;
                                }

                                AppsRunningPhoneActivity.this.handleStartCoolDown_111.removeMessages(0x6F);
                                AppsRunningPhoneActivity.this.b(false, true);
                                AppsRunningPhoneActivity.this.startCooldown(true, false);
                                return;
                            }

                            AppsRunningPhoneActivity.a(AppsRunningPhoneActivity.this, 0);
                            return;
                        }

                        if(v7.equals("NOTIFICATION_DISCONNECT")) {
                            AppsRunningPhoneActivity.b(AppsRunningPhoneActivity.this, false);
                            AppsRunningPhoneActivity.a(AppsRunningPhoneActivity.this, 0);
                            if(AppsRunningPhoneActivity.i(AppsRunningPhoneActivity.this)) {
                                AppsRunningPhoneActivity.this.b(true, true);
                                return;
                            }
                        }
                        else {
                            if(v7.equals("NOTIFICATION_DID_LOG")) {
                                String v7_3 = (String)arg8.getExtras().get("log");
                                String v8 = AppsRunningPhoneActivity.j(AppsRunningPhoneActivity.this).getText().toString();
                                if(!apps.c.d.strNotEmpty(v8)) {
                                    v7_3 = v8 + "\n" + v7_3;
                                }

                                AppsRunningPhoneActivity.j(AppsRunningPhoneActivity.this).setText(v7_3);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_DID_STOP_WORKOUT")) {
                                if(arg8.getExtras() != null && arg8.getExtras().get("StopWorkoutInfo") != null) {
                                    StopWorkoutInfo v8_1 = (StopWorkoutInfo)arg8.getExtras().get("StopWorkoutInfo");
                                    AppsRunningPhoneActivity.a(AppsRunningPhoneActivity.this, v8_1);
                                }

                                AppsRunner.get(AppsRunningPhoneActivity.this.getApplicationContext()).r();
                                AppsRunningPhoneActivity.this.u();
                                return;
                            }

                            if(v7.equals("NOTIFICATION_DID_PAUSE_WORKOUT")) {
                                if(!AppsRunningPhoneActivity.k(AppsRunningPhoneActivity.this)) {
                                    AppsRunningPhoneActivity.this.p();
                                    return;
                                }

                                AppsRunningPhoneActivity.this.handleStartCoolDown_111.removeMessages(0x6F);
                                AppsRunningPhoneActivity.this.l();
                                AppsRunningPhoneActivity.b(AppsRunningPhoneActivity.this, false);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_DID_DEVICE_PAUSE_WORKOUT")) {
                                AppsRunningPhoneActivity.this.p();
                                return;
                            }

                            if(v7.equals("NOTIFICATION_DID_RESTART_WORKOUT")) {
                                AppsRunningPhoneActivity.this.q();
                                return;
                            }

                            if(v7.equals("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE")) {
                                if(((int)(((Integer)arg8.getExtras().get("Extra_Key_SafetyKey_State")))) == 1) {
                                    AppsRunningPhoneActivity.c(AppsRunningPhoneActivity.this, true);
                                    return;
                                }

                                AppsRunningPhoneActivity.c(AppsRunningPhoneActivity.this, false);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS")) {
                                if(!AppsRunner.get(AppsRunningPhoneActivity.this.getApplicationContext()).a) {
                                    if(arg8.getExtras() != null && arg8.getExtras().get("Extra_Key_Workout_State") != null) {
                                        int v7_4 = (int)(((Integer)arg8.getExtras().get("Extra_Key_Workout_State")));
                                        AppsRunningPhoneActivity.b(AppsRunningPhoneActivity.this, v7_4);
                                    }

                                    return;
                                }

                                int v7_5 = (int)(((Integer)arg8.getExtras().get("Extra_Key_Workout_State")));
                                AppsRunningPhoneActivity.b(AppsRunningPhoneActivity.this, v7_5);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_DID_STOPWORKOUT_TIME_OUT")) {
                                AppsRunningPhoneActivity.d(AppsRunningPhoneActivity.this, false);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_DID_STOP_WORKOUT_FAIL")) {
                                AppsRunningPhoneActivity.d(AppsRunningPhoneActivity.this, false);
                                AppsRunningPhoneActivity.this.u();
                                return;
                            }

                            if((v7.equals("NOTIFICATION_DID_CHANGEWORKOUT_TIME_OUT")) || (v7.equals("NOTIFICATION_DID_CHANGE_WORKOUT"))) {
                                AppsRunningPhoneActivity.e(AppsRunningPhoneActivity.this, false);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_SHOW_NO_HR_TIP")) {
                                int v7_6 = AppsRunner.get(AppsRunningPhoneActivity.this).k(AppsRunningPhoneActivity.this);
                                j.a("===NOTIFICATION_SHOW_NO_HR_TIP==", v7_6 + " |");
                                if(v7_6 != 3 && v7_6 != 8) {
                                    j.a("===not support ==", " |");
                                    return;
                                }

                                j.a("===support ==", " |");
                                int v7_7 = (int)(((Integer)arg8.getExtras().get("disappearTime")));
                                AppsRunningPhoneActivity.this.showNoHR(v7_7);
                                return;
                            }

                            if(v7.equals("NOTIFICATION_STARTING_SYN_USER_INFO")) {
                                AppsRunningPhoneActivity.this.handleStartCoolDown_111.removeMessages(0x6F);
                                return;
                                AppsRunningPhoneActivity.e(AppsRunningPhoneActivity.this, false);
                                return;
                            }
                        }
                    }
                }
            }
        };
        this.handle_showNoHR_111111 = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                if(arg2.what == 0x1B207) {
                    AppsRunningPhoneActivity.this.dismissNoHR();
                }
            }
        };
        this.j = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsRunningPhoneActivity.f(AppsRunningPhoneActivity.this, false);
                AppsRunningPhoneActivity.l(AppsRunningPhoneActivity.this);
            }
        };
        this.bq = false;
        this.fromRunningDate = null;
        this.bs = false;
        this.bt = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsRunningPhoneActivity.e(AppsRunningPhoneActivity.this, false);
            }
        };
        this.k = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                j.a("===", "==timeout app stopworkout");
                ((AppsApplication)AppsRunningPhoneActivity.this.getApplication()).b(0x7F0B0057, deviceCommandEnum.stop_workout.ordinal());  // string:STR_FAILED_TO_STOP_WORKOUT "FAILED TO STOP WORKOUT"
                Intent v3 = new Intent();
                v3.setAction("NOTIFICATION_DID_STOPWORKOUT_TIME_OUT");
                AppsRunningPhoneActivity.this.sendBroadcast(v3);
            }
        };
    }

    private void A() {
        Intent v0;
        this.f();
        if(AppsRunner.get(this).k(this) == 5) {
            if(((AppsApplication)this.getApplication()).b()) {
                return;
            }

            v0 = new Intent(this, AppsSettingPhoneActivity.class);
            v0.putExtra("Extra_Key_fromRunningDate", f.a(this.fromRunningDate, "yyyy-MM-dd HH:mm:ss"));
            v0.putExtra("StopWorkoutInfo", this.bg);
        }
        else {
            v0 = new Intent(this, AppsHistoryPhoneActivity.class);
            v0.putExtra("Extra_Key_fromRunning", true);
            v0.putExtra("Extra_Key_fromRunningDate", f.a(this.fromRunningDate, "yyyy-MM-dd HH:mm:ss"));
            v0.putExtra("shouldStopSafetyKeyTip", this.shouldStopSafetyKeyTip);
        }

        this.startActivity(v0);
        this.finish();
    }

    static int a(AppsRunningPhoneActivity arg0, int arg1) {
        arg0.bn = arg1;
        return arg1;
    }

    static LinearLayout a(AppsRunningPhoneActivity arg0) {
        return arg0.ap;
    }

    static StopWorkoutInfo a(AppsRunningPhoneActivity arg0, StopWorkoutInfo arg1) {
        arg0.bg = arg1;
        return arg1;
    }

    private void a(int arg3, int arg4) {
        this.aybe_sprint8(arg3, arg4);
        this.aT.setText(this.aN);
        this.aE.setText(this.aO);
        this.aF.setText(this.aP);
        this.aH.setText(apps.c.d.doubleToStr(AppsRunner.get(this).heartRate, 0));
    }

    static boolean a(AppsRunningPhoneActivity arg0, boolean arg1) {
        arg0.aX = arg1;
        return arg1;
    }

    public void showNoHR(int delay) {
        j.a("==showNoHR==", "==" + delay + "==");
        this.noHRTip.setVisibility(0);
        this.handle_showNoHR_111111.removeMessages(0x1B207);
        if(delay == 0xA5) {
            return;
        }

        if(delay == 0) {
            delay = 3;
        }

        Message v0 = new Message();
        v0.what = 0x1B207;
        this.handle_showNoHR_111111.sendMessageDelayed(v0, ((long)(delay * 1000)));
    }

    @Override  // com.xtremeprog.shell.treadmillv2.AppsRunner$a
    public void a(AppsRunner arg1) {
        this.z();
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsISMeterView$a
    public void setSpeedIncline(AppsISMeterView arg2, double arg3, int arg5) {
        if(this.s.getVisibility() == 0) {
            return;
        }

        if(arg2 == this.w) {
            AppsRunner.get(this).incline(arg3, arg5);
            return;
        }

        if(arg2 == this.x) {
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                AppsRunner.get(this).resistance(arg3, arg5);
                return;
            }

            AppsRunner.get(this).speed(arg3, arg5);
        }
    }

    public void a(boolean arg2) {
        if(!arg2) {
            goto label_104;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.bo, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.bo, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_DID_LOG");
            this.registerReceiver(this.bo, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_DID_STOP_WORKOUT");
            this.registerReceiver(this.bo, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE");
            this.registerReceiver(this.bo, v2_5);
            IntentFilter v2_6 = new IntentFilter();
            v2_6.addAction("NOTIFICATION_DID_PAUSE_WORKOUT");
            this.registerReceiver(this.bo, v2_6);
            IntentFilter v2_7 = new IntentFilter();
            v2_7.addAction("NOTIFICATION_DID_DEVICE_PAUSE_WORKOUT");
            this.registerReceiver(this.bo, v2_7);
            IntentFilter v2_8 = new IntentFilter();
            v2_8.addAction("NOTIFICATION_DID_RESTART_WORKOUT");
            this.registerReceiver(this.bo, v2_8);
            IntentFilter v2_9 = new IntentFilter();
            v2_9.addAction("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS");
            this.registerReceiver(this.bo, v2_9);
            IntentFilter v2_10 = new IntentFilter();
            v2_10.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.bo, v2_10);
            IntentFilter v2_11 = new IntentFilter();
            v2_11.addAction("NOTIFICATION_DID_STOPWORKOUT_TIME_OUT");
            this.registerReceiver(this.bo, v2_11);
            IntentFilter v2_12 = new IntentFilter();
            v2_12.addAction("NOTIFICATION_DID_STOP_WORKOUT_FAIL");
            this.registerReceiver(this.bo, v2_12);
            IntentFilter v2_13 = new IntentFilter();
            v2_13.addAction("NOTIFICATION_DID_CHANGEWORKOUT_TIME_OUT");
            this.registerReceiver(this.bo, v2_13);
            IntentFilter v2_14 = new IntentFilter();
            v2_14.addAction("NOTIFICATION_DID_CHANGE_WORKOUT");
            this.registerReceiver(this.bo, v2_14);
            IntentFilter v2_15 = new IntentFilter();
            v2_15.addAction("NOTIFICATION_SHOW_NO_HR_TIP");
            this.registerReceiver(this.bo, v2_15);
            IntentFilter v2_16 = new IntentFilter();
            v2_16.addAction("NOTIFICATION_STARTING_SYN_USER_INFO");
            this.registerReceiver(this.bo, v2_16);
            IntentFilter v2_17 = new IntentFilter();
            v2_17.addAction("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER");
            this.registerReceiver(this.bo, v2_17);
            return;
        label_104:
            this.unregisterReceiver(this.bo);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    public void startCooldown(boolean arg8, boolean arg9) {
        j.a("startCountDown==", ((boolean)(((int)arg8))) + " | " + ((boolean)(((int)arg9))));
        if(arg8) {
            this.handleStartCoolDown_111.removeMessages(0x6F);
            this.am.setVisibility(0);
            this.ap.setVisibility(0);
            this.ao.setVisibility(8);
            this.an.setVisibility(8);
            this.bl = 3;
            Message _1 = new Message();
            Message _2 = new Message();
            Message _3 = new Message();
            _1.what = 1;
            _2.what = 2;
            _3.what = 3;
            this.handleStartCoolDown_1_2_3.removeMessages(1);
            this.handleStartCoolDown_1_2_3.removeMessages(2);
            this.handleStartCoolDown_1_2_3.removeMessages(3);
            this.handleStartCoolDown_1_2_3.sendMessageDelayed(_1, 1000L);
            this.handleStartCoolDown_1_2_3.sendMessageDelayed(_2, 2000L);
            this.handleStartCoolDown_1_2_3.sendMessageDelayed(_3, 3000L);
            if(arg9) {
                this.w();
                return;
            }
        }
        else {
            this.am.setVisibility(8);
            this.ap.setVisibility(0);
            this.ao.setVisibility(8);
            this.an.setVisibility(8);
            this.handleStartCoolDown_1_2_3.removeMessages(1);
            this.handleStartCoolDown_1_2_3.removeMessages(2);
            this.handleStartCoolDown_1_2_3.removeMessages(3);
        }
    }

    public boolean a(View arg9) {
        RelativeLayout v1_1;
        RelativeLayout v9_4;
        RelativeLayout v0_5;
        String v0_2;  // Lock add, temporarily not send change workout
        String v3;
        StringBuilder v1;
        boolean v9_1;
        if(arg9 != this.l && arg9 != this.m) {
            if(arg9 == this.n) {
                this.bs = false;
                AppsRunner.get(this).pauseWorkout();
                return true;
            }

            if(arg9 == this.o) {
                this.bs = false;
                AppsRunner.get(this).resumeWorkout();
                return true;
            }

            if(arg9 == this.p) {
                j.a("===", "==锁住stop button==");
                if(this.bi) {
                    j.a("===", "==已经锁住stop，不能再发stop==");
                    return true;
                }

                this.bi = true;
                this.stopWorkout();
                return true;
            }

            if(arg9 != this.z && arg9 != this.A && arg9 != this.B) {
                if(arg9 != this.I && arg9 != this.J && arg9 != this.G && arg9 != this.H) {
                    if(arg9 != this.C && arg9 != this.D) {
                        if(arg9 != this.E && arg9 != this.F) {
                            if(arg9 != this.aD && arg9 != this.aC) {
                                if(arg9 != this.K && arg9 != this.L && arg9 != this.M && arg9 != this.N) {
                                    if(arg9 != this.O && arg9 != this.P && arg9 != this.Q) {
                                        long v6 = 0xFAL;
                                        if(arg9 == this.aq) {
                                            int v9 = AppsRunner.get(this).k(this);
                                            if(v9 != 4 && v9 != 2) {
                                                if(!this.bj) {
                                                    v9_1 = AppsRunner.get(this).b(60);
                                                    if(v9_1) {
                                                        this.bj = true;
                                                        int v0 = AppsRunner.get(this).c(60);
                                                        AppsRunner.get(this).e(v0);
                                                        this.bt.removeMessages(0xD903);
                                                        Message v0_1 = new Message();
                                                        v0_1.what = 0xD903;
                                                        this.bt.sendMessageDelayed(v0_1, v6);
                                                    }

                                                    j.a("---", "--将要增加时间:" + ((boolean)(((int)v9_1))) + "   " + this.bj);  // Will add time:
                                                    v1 = new StringBuilder();
                                                    v3 = "---add time----";
                                                    v1.append(v3);
                                                    v1.append(((boolean)(((int)v9_1))));
                                                    j.a("---", v1.toString());
                                                    return true;
                                                }

                                                v0_2 = "---锁住add，暂时不发change workout---";  // Lock add, temporarily not send change workout
                                                j.a("---", v0_2);
                                                return true;
                                            }

                                            return true;
                                        }

                                        if(arg9 == this.ar) {
                                            int v9_2 = AppsRunner.get(this).k(this);
                                            if(v9_2 != 4 && v9_2 != 2) {
                                                if(!this.bj) {
                                                    v9_1 = AppsRunner.get(this).b(-60);
                                                    if(v9_1) {
                                                        this.bj = true;
                                                        int v0_3 = AppsRunner.get(this).c(-60);
                                                        AppsRunner.get(this).e(v0_3);
                                                        this.bt.removeMessages(0xD903);
                                                        Message v0_4 = new Message();
                                                        v0_4.what = 0xD903;
                                                        this.bt.sendMessageDelayed(v0_4, v6);
                                                    }

                                                    j.a("---", "--将要减少时间:" + ((boolean)(((int)v9_1))) + "   " + this.bj);
                                                    v1 = new StringBuilder();
                                                    v3 = "---minus time----";
                                                    v1.append(v3);
                                                    v1.append(((boolean)(((int)v9_1))));
                                                    j.a("---", v1.toString());
                                                    return true;
                                                }

                                                v0_2 = "---锁住minus，暂时不发change workout---";
                                                j.a("---", v0_2);
                                                return true;
                                            }

                                            return true;
                                        }

                                        if(arg9 == this.al) {
                                            Intent v9_3 = new Intent();
                                            v9_3.setAction("NOTIFICATION_DIDCONNECT");
                                            this.getApplicationContext().sendBroadcast(v9_3);
                                            return true;
                                        }

                                        if(arg9 == this.at) {
                                            if(AppsRunnerConnector.get(this).g().size() == 0) {
                                                return true;
                                            }

                                            this.startActivityForResult(new Intent(this, AppsMIODeviceListPhoneActivity.class), 0x6F);
                                            return true;
                                        }

                                        return true;
                                    }

                                    this.b(4);
                                    v0_5 = this.O;
                                    if(arg9 == v0_5) {
                                        v9_4 = this.Q;
                                        v9_4.setVisibility(0);
                                        return true;
                                    }

                                    v1_1 = this.P;
                                    if(arg9 != v1_1) {
                                        v1_1.setVisibility(0);
                                        return true;
                                    }

                                    v0_5.setVisibility(0);
                                    return true;
                                }

                                this.b(3);
                                v0_5 = this.K;
                                if(arg9 == v0_5) {
                                    v9_4 = this.N;
                                    v9_4.setVisibility(0);
                                    return true;
                                }

                                v1_1 = this.L;
                                if(arg9 == v1_1) {
                                    v0_5.setVisibility(0);
                                    return true;
                                }

                                v0_5 = this.M;
                                if(arg9 != v0_5) {
                                    v0_5.setVisibility(0);
                                    return true;
                                }

                                v1_1.setVisibility(0);
                                return true;
                            }

                            this.b(6);
                            LinearLayout v0_6 = this.aD;
                            if(arg9 == v0_6) {
                                this.aC.setVisibility(0);
                                return true;
                            }

                            v0_6.setVisibility(0);
                            return true;
                        }

                        this.b(5);
                        v0_5 = this.E;
                        if(arg9 != v0_5) {
                            v0_5.setVisibility(0);
                            return true;
                        }

                        v9_4 = this.F;
                        v9_4.setVisibility(0);
                        return true;
                    }

                    this.b(1);
                    v0_5 = this.C;
                    if(arg9 != v0_5) {
                        v0_5.setVisibility(0);
                        return true;
                    }

                    v9_4 = this.D;
                    v9_4.setVisibility(0);
                    return true;
                }

                this.b(2);
                v0_5 = this.H;
                if(arg9 == v0_5) {
                    v9_4 = this.G;
                    v9_4.setVisibility(0);
                    return true;
                }

                if(arg9 == this.G) {
                    v9_4 = this.I;
                    v9_4.setVisibility(0);
                    return true;
                }

                if(arg9 != this.I) {
                    v0_5.setVisibility(0);
                    return true;
                }

                v9_4 = this.J;
                v9_4.setVisibility(0);
                return true;
            }

            this.b(0);
            v0_5 = this.z;
            if(arg9 == v0_5) {
                v9_4 = this.B;
                v9_4.setVisibility(0);
                return true;
            }

            if(arg9 == this.B) {
                v9_4 = this.A;
                v9_4.setVisibility(0);
                return true;
            }

            v0_5.setVisibility(0);
            return true;
        }
        else {
            if(arg9 == this.m) {
                this.handleStartCoolDown_111.removeMessages(0x6F);
                this.m();
                return true;
            }

            if(AppsRunner.get(this).g()) {
                this.handleStartCoolDown_111.removeMessages(0x6F);
                this.l();
                this.bs = false;
                return true;
            }

            this.bs = true;
        }

        AppsRunner.get(this).pauseWorkout();
        return true;
    }

    static int b(AppsRunningPhoneActivity arg0, int arg1) {
        arg0.bb = arg1;
        return arg1;
    }

    static LinearLayout b(AppsRunningPhoneActivity arg0) {
        return arg0.ao;
    }

    private void b(int arg3) {
        RelativeLayout v3;
        if(arg3 == 0) {
            this.z.setVisibility(8);
            this.A.setVisibility(8);
            v3 = this.B;
            v3.setVisibility(8);
            return;
        }

        if(arg3 == 1) {
            this.C.setVisibility(8);
            v3 = this.D;
            v3.setVisibility(8);
            return;
        }

        if(arg3 == 2) {
            this.H.setVisibility(8);
            this.G.setVisibility(8);
            this.I.setVisibility(8);
            v3 = this.J;
            v3.setVisibility(8);
            return;
        }

        if(arg3 == 3) {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            v3 = this.N;
            v3.setVisibility(8);
            return;
        }

        if(arg3 == 4) {
            this.O.setVisibility(8);
            this.P.setVisibility(8);
            v3 = this.Q;
            v3.setVisibility(8);
            return;
        }

        if(arg3 == 5) {
            this.E.setVisibility(8);
            v3 = this.F;
            v3.setVisibility(8);
            return;
        }

        if(arg3 == 6) {
            this.aD.setVisibility(8);
            this.aC.setVisibility(8);
        }
    }

    private void aybe_sprint8(int arg11, int arg12) {
        List v12_17;
        String v4_8;
        StringBuilder v3_16;
        List v12_16;
        String v6_7;
        StringBuilder v3_15;
        List v12_15;
        String v4_7;
        StringBuilder v3_14;
        List v12_14;
        String v6_6;
        StringBuilder v3_13;
        List v12_13;
        String v4_6;
        StringBuilder v3_12;
        List v12_12;
        String v6_5;
        StringBuilder v3_11;
        List v12_11;
        String v4_5;
        StringBuilder v3_10;
        List v12_10;
        String v6_4;
        StringBuilder v3_9;
        List v12_9;
        String v4_4;
        StringBuilder v3_8;
        List v12_8;
        String v6_3;
        StringBuilder v3_7;
        List v12_7;
        String v4_3;
        StringBuilder v3_6;
        List v12_6;
        String v6_2;
        StringBuilder v3_5;
        List v12_5;
        String v3_4;
        StringBuilder v2_3;
        List v12_4;
        String v6_1;
        StringBuilder v3_3;
        List v12_3;
        String v5_1;
        StringBuilder v3_2;
        List v12_2;
        String v7;
        StringBuilder v3_1;
        float v12_1;
        List v12;
        StringBuilder v11_4;
        String v3;
        StringBuilder v2_1;
        String v5;
        StringBuilder v4;
        int v0 = AppsRunner.get(this).R() - 1;
        int v11 = arg11 - arg12;
        int v2 = v11 / 60;
        int v11_1 = v11 % 60;
        if(v11_1 < 10) {
            v4 = new StringBuilder();
            v5 = "0";
        }
        else {
            v4 = new StringBuilder();
            v5 = "";
        }

        v4.append(v5);
        v4.append(v11_1);
        this.aO = v2 + ":" + v4.toString();
        if(arg12 <= 180) {
            this.aN = this.getString(0x7F0B0143);  // string:warm_up "WARM UP"
            int v11_2 = 180 - arg12;
            int v1 = v11_2 / 60;
            int v11_3 = v11_2 % 60;
            if(v11_3 < 10) {
                v2_1 = new StringBuilder();
                v3 = "0";
            }
            else {
                v2_1 = new StringBuilder();
                v3 = "";
            }

            v2_1.append(v3);
            v2_1.append(v11_3);
            this.aP = v1 + ":" + v2_1.toString();
            this.y.setTotal(180.0);
            this.y.setProgress(((double)arg12));
            this.y.b();
            this.aM = 0;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).a() + "";
                v11_4 = new StringBuilder();
                v12 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).a() + "";
                v11_4 = new StringBuilder();
                v12 = h.a;
            }

            v12_1 = ((b)v12.get(v0)).a();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        double v4_1 = 30.0;
        if(arg12 > 180 && arg12 <= 210) {
            this.aN = this.getString(0x7F0B0137) + " 1";  // string:sprint "SPRINT"
            int v11_5 = 210 - arg12;
            int v6 = v11_5 / 60;
            int v11_6 = v11_5 % 60;
            if(v11_6 < 10) {
                v3_1 = new StringBuilder();
                v7 = "0";
            }
            else {
                v3_1 = new StringBuilder();
                v7 = "";
            }

            v3_1.append(v7);
            v3_1.append(v11_6);
            this.aP = v6 + ":" + v3_1.toString();
            this.y.setTotal(v4_1);
            this.y.setProgress(((double)(arg12 - 180)));
            this.y.b();
            this.aM = arg12 == 210 ? 1 : 0;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).c() + "";
                v11_4 = new StringBuilder();
                v12_2 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).c() + "";
                v11_4 = new StringBuilder();
                v12_2 = h.a;
            }

            v12_1 = ((b)v12_2.get(v0)).c();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        double v7_1 = 90.0;
        if(arg12 > 210 && arg12 <= 300) {
            this.aN = this.getString(0x7F0B0135);  // string:rcovery "RECOVERY"
            int v11_7 = 300 - arg12;
            int v4_2 = v11_7 / 60;
            int v11_8 = v11_7 % 60;
            if(v11_8 < 10) {
                v3_2 = new StringBuilder();
                v5_1 = "0";
            }
            else {
                v3_2 = new StringBuilder();
                v5_1 = "";
            }

            v3_2.append(v5_1);
            v3_2.append(v11_8);
            this.aP = v4_2 + ":" + v3_2.toString();
            this.y.setTotal(v7_1);
            this.y.setProgress(((double)(arg12 - 210)));
            this.y.b();
            this.aM = 1;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).k() + "";
                v11_4 = new StringBuilder();
                v12_3 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).k() + "";
                v11_4 = new StringBuilder();
                v12_3 = h.a;
            }

            v12_1 = ((b)v12_3.get(v0)).k();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 300 && arg12 <= 330) {
            this.aN = this.getString(0x7F0B0137) + " 2";  // string:sprint "SPRINT"
            int v11_9 = 330 - arg12;
            int v2_2 = v11_9 / 60;
            int v11_10 = v11_9 % 60;
            if(v11_10 < 10) {
                v3_3 = new StringBuilder();
                v6_1 = "0";
            }
            else {
                v3_3 = new StringBuilder();
                v6_1 = "";
            }

            v3_3.append(v6_1);
            v3_3.append(v11_10);
            this.aP = v2_2 + ":" + v3_3.toString();
            this.y.setTotal(v4_1);
            this.y.setProgress(((double)(arg12 - 300)));
            this.y.b();
            this.aM = arg12 == 330 ? 2 : 1;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).d() + "";
                v11_4 = new StringBuilder();
                v12_4 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).d() + "";
                v11_4 = new StringBuilder();
                v12_4 = h.a;
            }

            v12_1 = ((b)v12_4.get(v0)).d();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 330 && arg12 <= 420) {
            this.aN = this.getString(0x7F0B0135);  // string:rcovery "RECOVERY"
            int v11_11 = 420 - arg12;
            int v1_1 = v11_11 / 60;
            int v11_12 = v11_11 % 60;
            if(v11_12 < 10) {
                v2_3 = new StringBuilder();
                v3_4 = "0";
            }
            else {
                v2_3 = new StringBuilder();
                v3_4 = "";
            }

            v2_3.append(v3_4);
            v2_3.append(v11_12);
            this.aP = v1_1 + ":" + v2_3.toString();
            this.y.setTotal(v7_1);
            this.y.setProgress(((double)(arg12 - 330)));
            this.y.b();
            this.aM = 2;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).l() + "";
                v11_4 = new StringBuilder();
                v12_5 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).l() + "";
                v11_4 = new StringBuilder();
                v12_5 = h.a;
            }

            v12_1 = ((b)v12_5.get(v0)).l();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 420 && arg12 <= 450) {
            this.aN = this.getString(0x7F0B0137) + " 3";  // string:sprint "SPRINT"
            int v11_13 = 450 - arg12;
            int v1_2 = v11_13 / 60;
            int v11_14 = v11_13 % 60;
            if(v11_14 < 10) {
                v3_5 = new StringBuilder();
                v6_2 = "0";
            }
            else {
                v3_5 = new StringBuilder();
                v6_2 = "";
            }

            v3_5.append(v6_2);
            v3_5.append(v11_14);
            this.aP = v1_2 + ":" + v3_5.toString();
            this.y.setTotal(v4_1);
            this.y.setProgress(((double)(arg12 - 420)));
            this.y.b();
            this.aM = arg12 == 450 ? 3 : 2;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).e() + "";
                v11_4 = new StringBuilder();
                v12_6 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).e() + "";
                v11_4 = new StringBuilder();
                v12_6 = h.a;
            }

            v12_1 = ((b)v12_6.get(v0)).e();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 450 && arg12 <= 540) {
            this.aN = this.getString(0x7F0B0135);  // string:rcovery "RECOVERY"
            int v11_15 = 540 - arg12;
            int v1_3 = v11_15 / 60;
            int v11_16 = v11_15 % 60;
            if(v11_16 < 10) {
                v3_6 = new StringBuilder();
                v4_3 = "0";
            }
            else {
                v3_6 = new StringBuilder();
                v4_3 = "";
            }

            v3_6.append(v4_3);
            v3_6.append(v11_16);
            this.aP = v1_3 + ":" + v3_6.toString();
            this.y.setTotal(v7_1);
            this.y.setProgress(((double)(arg12 - 450)));
            this.y.b();
            this.aM = 3;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).m() + "";
                v11_4 = new StringBuilder();
                v12_7 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).m() + "";
                v11_4 = new StringBuilder();
                v12_7 = h.a;
            }

            v12_1 = ((b)v12_7.get(v0)).m();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 540 && arg12 <= 570) {
            this.aN = this.getString(0x7F0B0137) + " 4";  // string:sprint "SPRINT"
            int v11_17 = 570 - arg12;
            int v1_4 = v11_17 / 60;
            int v11_18 = v11_17 % 60;
            if(v11_18 < 10) {
                v3_7 = new StringBuilder();
                v6_3 = "0";
            }
            else {
                v3_7 = new StringBuilder();
                v6_3 = "";
            }

            v3_7.append(v6_3);
            v3_7.append(v11_18);
            this.aP = v1_4 + ":" + v3_7.toString();
            this.y.setTotal(v4_1);
            this.y.setProgress(((double)(arg12 - 540)));
            this.y.b();
            this.aM = arg12 == 570 ? 4 : 3;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).f() + "";
                v11_4 = new StringBuilder();
                v12_8 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).f() + "";
                v11_4 = new StringBuilder();
                v12_8 = h.a;
            }

            v12_1 = ((b)v12_8.get(v0)).f();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 570 && arg12 <= 660) {
            this.aN = this.getString(0x7F0B0135);  // string:rcovery "RECOVERY"
            int v11_19 = 660 - arg12;
            int v1_5 = v11_19 / 60;
            int v11_20 = v11_19 % 60;
            if(v11_20 < 10) {
                v3_8 = new StringBuilder();
                v4_4 = "0";
            }
            else {
                v3_8 = new StringBuilder();
                v4_4 = "";
            }

            v3_8.append(v4_4);
            v3_8.append(v11_20);
            this.aP = v1_5 + ":" + v3_8.toString();
            this.y.setTotal(v7_1);
            this.y.setProgress(((double)(arg12 - 570)));
            this.y.b();
            this.aM = 4;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).n() + "";
                v11_4 = new StringBuilder();
                v12_9 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).n() + "";
                v11_4 = new StringBuilder();
                v12_9 = h.a;
            }

            v12_1 = ((b)v12_9.get(v0)).n();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 660 && arg12 <= 690) {
            this.aN = this.getString(0x7F0B0137) + " 5";  // string:sprint "SPRINT"
            int v11_21 = 690 - arg12;
            int v1_6 = v11_21 / 60;
            int v11_22 = v11_21 % 60;
            if(v11_22 < 10) {
                v3_9 = new StringBuilder();
                v6_4 = "0";
            }
            else {
                v3_9 = new StringBuilder();
                v6_4 = "";
            }

            v3_9.append(v6_4);
            v3_9.append(v11_22);
            this.aP = v1_6 + ":" + v3_9.toString();
            this.y.setTotal(v4_1);
            this.y.setProgress(((double)(arg12 - 660)));
            this.y.b();
            this.aM = arg12 == 690 ? 5 : 4;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).g() + "";
                v11_4 = new StringBuilder();
                v12_10 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).g() + "";
                v11_4 = new StringBuilder();
                v12_10 = h.a;
            }

            v12_1 = ((b)v12_10.get(v0)).g();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 690 && arg12 <= 780) {
            this.aN = this.getString(0x7F0B0135);  // string:rcovery "RECOVERY"
            int v11_23 = 780 - arg12;
            int v1_7 = v11_23 / 60;
            int v11_24 = v11_23 % 60;
            if(v11_24 < 10) {
                v3_10 = new StringBuilder();
                v4_5 = "0";
            }
            else {
                v3_10 = new StringBuilder();
                v4_5 = "";
            }

            v3_10.append(v4_5);
            v3_10.append(v11_24);
            this.aP = v1_7 + ":" + v3_10.toString();
            this.y.setTotal(v7_1);
            this.y.setProgress(((double)(arg12 - 690)));
            this.y.b();
            this.aM = 5;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).o() + "";
                v11_4 = new StringBuilder();
                v12_11 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).o() + "";
                v11_4 = new StringBuilder();
                v12_11 = h.a;
            }

            v12_1 = ((b)v12_11.get(v0)).o();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 780 && arg12 <= 810) {
            this.aN = this.getString(0x7F0B0137) + " 6";  // string:sprint "SPRINT"
            int v11_25 = 810 - arg12;
            int v1_8 = v11_25 / 60;
            int v11_26 = v11_25 % 60;
            if(v11_26 < 10) {
                v3_11 = new StringBuilder();
                v6_5 = "0";
            }
            else {
                v3_11 = new StringBuilder();
                v6_5 = "";
            }

            v3_11.append(v6_5);
            v3_11.append(v11_26);
            this.aP = v1_8 + ":" + v3_11.toString();
            this.y.setTotal(v4_1);
            this.y.setProgress(((double)(arg12 - 780)));
            this.y.b();
            this.aM = arg12 == 810 ? 6 : 5;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).h() + "";
                v11_4 = new StringBuilder();
                v12_12 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).h() + "";
                v11_4 = new StringBuilder();
                v12_12 = h.a;
            }

            v12_1 = ((b)v12_12.get(v0)).h();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 810 && arg12 <= 900) {
            this.aN = this.getString(0x7F0B0135);  // string:rcovery "RECOVERY"
            int v11_27 = 900 - arg12;
            int v1_9 = v11_27 / 60;
            int v11_28 = v11_27 % 60;
            if(v11_28 < 10) {
                v3_12 = new StringBuilder();
                v4_6 = "0";
            }
            else {
                v3_12 = new StringBuilder();
                v4_6 = "";
            }

            v3_12.append(v4_6);
            v3_12.append(v11_28);
            this.aP = v1_9 + ":" + v3_12.toString();
            this.y.setTotal(v7_1);
            this.y.setProgress(((double)(arg12 - 810)));
            this.y.b();
            this.aM = 6;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).p() + "";
                v11_4 = new StringBuilder();
                v12_13 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).p() + "";
                v11_4 = new StringBuilder();
                v12_13 = h.a;
            }

            v12_1 = ((b)v12_13.get(v0)).p();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 900 && arg12 <= 930) {
            this.aN = this.getString(0x7F0B0137) + " 7";  // string:sprint "SPRINT"
            int v11_29 = 930 - arg12;
            int v1_10 = v11_29 / 60;
            int v11_30 = v11_29 % 60;
            if(v11_30 < 10) {
                v3_13 = new StringBuilder();
                v6_6 = "0";
            }
            else {
                v3_13 = new StringBuilder();
                v6_6 = "";
            }

            v3_13.append(v6_6);
            v3_13.append(v11_30);
            this.aP = v1_10 + ":" + v3_13.toString();
            this.y.setTotal(v4_1);
            this.y.setProgress(((double)(arg12 - 900)));
            this.y.b();
            this.aM = arg12 == 930 ? 7 : 6;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).i() + "";
                v11_4 = new StringBuilder();
                v12_14 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).i() + "";
                v11_4 = new StringBuilder();
                v12_14 = h.a;
            }

            v12_1 = ((b)v12_14.get(v0)).i();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 930 && arg12 <= 1020) {
            this.aN = this.getString(0x7F0B0135);  // string:rcovery "RECOVERY"
            int v11_31 = 1020 - arg12;
            int v1_11 = v11_31 / 60;
            int v11_32 = v11_31 % 60;
            if(v11_32 < 10) {
                v3_14 = new StringBuilder();
                v4_7 = "0";
            }
            else {
                v3_14 = new StringBuilder();
                v4_7 = "";
            }

            v3_14.append(v4_7);
            v3_14.append(v11_32);
            this.aP = v1_11 + ":" + v3_14.toString();
            this.y.setTotal(v7_1);
            this.y.setProgress(((double)(arg12 - 930)));
            this.y.b();
            this.aM = 7;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).q() + "";
                v11_4 = new StringBuilder();
                v12_15 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).q() + "";
                v11_4 = new StringBuilder();
                v12_15 = h.a;
            }

            v12_1 = ((b)v12_15.get(v0)).q();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 1020 && arg12 <= 1050) {
            this.aN = this.getString(0x7F0B0137) + " 8";  // string:sprint "SPRINT"
            int v11_33 = 1050 - arg12;
            int v2_4 = v11_33 / 60;
            int v11_34 = v11_33 % 60;
            if(v11_34 < 10) {
                v3_15 = new StringBuilder();
                v6_7 = "0";
            }
            else {
                v3_15 = new StringBuilder();
                v6_7 = "";
            }

            v3_15.append(v6_7);
            v3_15.append(v11_34);
            this.aP = v2_4 + ":" + v3_15.toString();
            this.y.setTotal(v4_1);
            this.y.setProgress(((double)(arg12 - 1020)));
            this.y.b();
            if(arg12 == 1050) {
                this.aM = 8;
            }

            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).j() + "";
                v11_4 = new StringBuilder();
                v12_16 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).j() + "";
                v11_4 = new StringBuilder();
                v12_16 = h.a;
            }

            v12_1 = ((b)v12_16.get(v0)).j();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }

        if(arg12 > 1050 && arg12 <= 1200) {
            this.aN = this.getString(0x7F0B012F);  // string:cool_down "COOL DOWN"
            int v11_35 = 1200 - arg12;
            int v2_5 = v11_35 / 60;
            int v11_36 = v11_35 % 60;
            if(v11_36 < 10) {
                v3_16 = new StringBuilder();
                v4_8 = "0";
            }
            else {
                v3_16 = new StringBuilder();
                v4_8 = "";
            }

            v3_16.append(v4_8);
            v3_16.append(v11_36);
            this.aP = v2_5 + ":" + v3_16.toString();
            this.y.setTotal(150.0);
            this.y.setProgress(((double)(arg12 - 1050)));
            this.y.b();
            this.aM = 8;
            if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
                this.aQ = ((b)h.d.get(v0)).b() + "";
                v11_4 = new StringBuilder();
                v12_17 = h.c;
            }
            else {
                this.aQ = ((b)h.b.get(v0)).b() + "";
                v11_4 = new StringBuilder();
                v12_17 = h.a;
            }

            v12_1 = ((b)v12_17.get(v0)).b();
            v11_4.append(v12_1);
            v11_4.append("");
            this.aR = v11_4.toString();
            return;
        }
    }

    static boolean b(AppsRunningPhoneActivity arg0, boolean arg1) {
        arg0.bs = arg1;
        return arg1;
    }

    @Override  // com.xtremeprog.shell.treadmillv2.AppsRunner$a
    public void b(AppsRunner arg1) {
        this.z();
    }

    public void b(boolean arg4, boolean arg5) {
        if(arg4) {
            AppsRunner.get(this).i();
            this.startCooldown(false, false);
            this.ak.setVisibility(0);
            this.handleStartCoolDown_111.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.handleStartCoolDown_111.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.ak.setVisibility(8);
        this.handleStartCoolDown_111.removeMessages(0x6F);
        if(arg5) {
            this.startCooldown(true, false);
        }
    }

    static LinearLayout c(AppsRunningPhoneActivity arg0) {
        return arg0.an;
    }

    static boolean c(AppsRunningPhoneActivity arg0, boolean arg1) {
        arg0.shouldStopSafetyKeyTip = arg1;
        return arg1;
    }

    @Override  // com.xtremeprog.shell.treadmillv2.AppsRunner$a
    public void c(AppsRunner arg1) {
    }

    static boolean d(AppsRunningPhoneActivity arg0) {
        return arg0.aX;
    }

    static boolean d(AppsRunningPhoneActivity arg0, boolean arg1) {
        arg0.bi = arg1;
        return arg1;
    }

    @Override  // com.xtremeprog.shell.treadmillv2.AppsRunner$a
    public void d(AppsRunner arg1) {
        this.o();
    }

    static int e(AppsRunningPhoneActivity arg0) {
        return arg0.bb;
    }

    static boolean e(AppsRunningPhoneActivity arg0, boolean arg1) {
        arg0.bj = arg1;
        return arg1;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        int v2;
        ImageView v1;
        AppsRunningPhoneActivity v0 = this;
        n.a().e(v0, 0x7F070183).setText(this.getResources().getString(0x7F0B00B0));  // id:pauseTextView
        n.a().e(v0, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(v0, 0x7F070194).setText(this.getResources().getString(0x7F0B00C5));  // id:resumeTextView
        n.a().e(v0, 0x7F07027B).setText(this.getResources().getString(0x7F0B00C8));  // id:stopTextView
        n.a().e(v0, 0x7F0702C9).setText(this.getResources().getString(0x7F0B0017));  // id:tv_title_average_pace
        n.a().e(v0, 0x7F0702D3).setText(this.getResources().getString(0x7F0B00AF));  // id:tv_title_pace
        n.a().e(v0, 0x7F0702D6).setText(this.getResources().getString(0x7F0B00C3));  // id:tv_title_speed
        n.a().e(v0, 0x7F0702D1).setText(this.getResources().getString(0x7F0B0084));  // id:tv_title_mets
        n.a().e(v0, 0x7F0702D9).setText(this.getResources().getString(0x7F0B0103));  // id:tv_title_watts
        n.a().e(v0, 0x7F0702CA).setText(this.getResources().getString(0x7F0B001C));  // id:tv_title_calhr
        n.a().e(v0, 0x7F0702CB).setText(this.getResources().getString(0x7F0B001F));  // id:tv_title_calories
        n.a().e(v0, 0x7F0702CF).setText(this.getResources().getString(0x7F0B00D2));  // id:tv_title_incline
        n.a().e(v0, 0x7F0702D5).setText(this.getResources().getString(0x7F0B00D6));  // id:tv_title_resistance
        n.a().e(v0, 0x7F0702D0).setText(this.getResources().getString(0x7F0B0079));  // id:tv_title_km
        n.a().e(v0, 0x7F0702D2).setText(this.getResources().getString(0x7F0B0085));  // id:tv_title_miles
        n.a().e(v0, 0x7F0702D7).setText(this.getResources().getString(0x7F0B00CC));  // id:tv_title_target_hr
        n.a().e(v0, 0x7F0702C8).setText(this.getResources().getString(0x7F0B0016));  // id:tv_title_average_hr
        n.a().e(v0, 0x7F0702CE).setText(this.getResources().getString(0x7F0B006A));  // id:tv_title_heart_rate
        n.a().e(v0, 0x7F0702CC).setText(this.getResources().getString(0x7F0B001E));  // id:tv_title_clock
        n.a().e(v0, 0x7F0702D8).setText(this.getResources().getString(0x7F0B00E1));  // id:tv_title_total_time
        n.a().e(v0, 0x7F0702D4).setText(this.getResources().getString(0x7F0B00CF));  // id:tv_title_remaining_time
        n.a().e(v0, 0x7F0702CD).setText(this.getResources().getString(0x7F0B00CE));  // id:tv_title_elapsed_time
        n.a().e(v0, 0x7F0702DA).setText(this.getResources().getString(0x7F0B0105));  // id:tv_title_workout
        v0.aT.setText(v0.aN);
        n.a().e(v0, 0x7F07024D).setText(v0.getString(0x7F0B0141));  // id:sprint8_data_title1
        n.a().e(v0, 0x7F07024E).setText(v0.getString(0x7F0B013F));  // id:sprint8_data_title2
        n.a().e(v0, 0x7F07024F).setText(v0.getString(0x7F0B013C));  // id:sprint8_data_title3
        n.a().e(v0, 0x7F070250).setText(v0.getString(0x7F0B013D));  // id:sprint8_data_title4
        n.a().e(v0, 0x7F070251).setText(v0.getString(0x7F0B013E));  // id:sprint8_data_title5
        n.a().e(v0, 0x7F070252).setText(v0.getString(0x7F0B0140));  // id:sprint8_data_title6
        n.a().e(v0, 0x7F070253).setText(v0.getString(0x7F0B00D6));  // id:sprint8_data_title7
        n.a().e(v0, 0x7F070185).setText(v0.getString(0x7F0B00B0));  // id:pause_text
        n.a().e(v0, 0x7F0702C9).setSingleLine(true);  // id:tv_title_average_pace
        n.a().e(v0, 0x7F0702D3).setSingleLine(true);  // id:tv_title_pace
        n.a().e(v0, 0x7F0702D6).setSingleLine(true);  // id:tv_title_speed
        n.a().e(v0, 0x7F0702D1).setSingleLine(true);  // id:tv_title_mets
        n.a().e(v0, 0x7F0702D9).setSingleLine(true);  // id:tv_title_watts
        n.a().e(v0, 0x7F0702CA).setSingleLine(true);  // id:tv_title_calhr
        n.a().e(v0, 0x7F0702CB).setSingleLine(true);  // id:tv_title_calories
        n.a().e(v0, 0x7F0702CF).setSingleLine(true);  // id:tv_title_incline
        n.a().e(v0, 0x7F0702D5).setSingleLine(true);  // id:tv_title_resistance
        n.a().e(v0, 0x7F0702D0).setSingleLine(true);  // id:tv_title_km
        n.a().e(v0, 0x7F0702D2).setSingleLine(true);  // id:tv_title_miles
        n.a().e(v0, 0x7F0702D7).setSingleLine(true);  // id:tv_title_target_hr
        n.a().e(v0, 0x7F0702C8).setSingleLine(true);  // id:tv_title_average_hr
        n.a().e(v0, 0x7F0702CE).setSingleLine(true);  // id:tv_title_heart_rate
        n.a().e(v0, 0x7F0702CC).setSingleLine(true);  // id:tv_title_clock
        n.a().e(v0, 0x7F0702D8).setSingleLine(true);  // id:tv_title_total_time
        n.a().e(v0, 0x7F0702D4).setSingleLine(true);  // id:tv_title_remaining_time
        n.a().e(v0, 0x7F0702CD).setSingleLine(true);  // id:tv_title_elapsed_time
        n.a().e(v0, 0x7F0702DA).setSingleLine(true);  // id:tv_title_workout
        n.a().e(v0, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(v0, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        v0.x.g();
        v0.w.g();
        if(AppsRunner.get(this).k(v0) == 9) {
            v0.y.setBottomTitle(this.getResources().getString(0x7F0B00C5));  // string:STR_START "START"
            v1 = v0.aS;
            v2 = 0;
        }
        else {
            v0.y.setBottomTitle(this.getResources().getString(0x7F0B00C5));  // string:STR_START "START"
            v1 = v0.aS;
            v2 = 4;
        }

        v1.setVisibility(v2);
        v0.aT.setVisibility(v2);
    }

    @Override  // com.xtremeprog.shell.treadmillv2.AppsRunner$a
    public void e(AppsRunner arg29) {
        String v2_5;
        StringBuilder v2_3;
        StringBuilder v1_3;
        double v1_1;
        AppsRunningPhoneActivity v0 = this;
        int v2 = AppsRunner.get(this).A();
        int v3 = AppsRunner.get(this).D();
        int v4 = AppsRunner.get(this).z();
        String v5 = apps.c.d.a(v2);
        String v3_1 = apps.c.d.a(v3);
        int v6 = arg29.F;
        int v7 = arg29.heartRate;
        double v8 = arg29.O;
        double v10 = arg29.N;
        int v12 = arg29.N();
        int v15 = arg29.v;
        String v16 = v5;
        int v5_1 = arg29.E;
        double v17 = arg29.P;
        double v13 = arg29.Q;
        double v19 = v10;
        double v10_1 = arg29.R;
        double v21 = v8;
        double v23 = arg29.J();
        String v25 = v3_1;
        double v26 = arg29.M();
        double v8_1 = arg29.L();
        int v3_2 = AppsRunner.get(this).k(v0);
        if(v3_2 != 3 && v3_2 == 8) {
            int v1 = v2 <= 0xF0 || v2 >= v4 - 0xF0 ? ((int)(((float)(220 - v0.bk)) * 0.75f)) : AppsRunner.get(this).D;
            v0.S.setText(apps.c.d.doubleToStr(v1, 0));
        }

        if(v7 == 0) {
            v0.at.setVisibility(4);
            v0.au.setVisibility(4);
            v1_1 = 2.0;
        }
        else {
            v0.at.setVisibility(0);
            v0.au.setVisibility(0);
            v1_1 = (double)(60.0f / ((float)v7));
        }

        v0.aZ = v1_1;
        if(v7 != 0) {
            int v1_2 = ((int)(v0.aZ * 1000.0)) <= 1000 ? ((int)(v0.aZ * 1000.0)) : 1000;
            c.a(v0.at, v1_2);
            c.a(v0.au, v1_2);
        }

        if(AppsRunner.get(this).inclineSupportsHalfDegree(v0)) {
            v0.E.setOnTouchListener(v0);
            v0.F.setOnTouchListener(v0);
            v0.aC.setOnTouchListener(v0);
            v0.aD.setOnTouchListener(v0);
            v0.av.setVisibility(0);
        }
        else {
            v0.E.setOnTouchListener(null);
            v0.F.setOnTouchListener(null);
            v0.aC.setOnTouchListener(null);
            v0.aD.setOnTouchListener(null);
            v0.aw.setVisibility(8);
            v0.F.setVisibility(8);
            v0.E.setVisibility(0);
            v0.av.setVisibility(8);
        }

        String[] v2_1 = apps.c.d.doubleToStr(v13 / 100.0, 2).split("[.]");
        int v3_3 = (int)apps.c.d.a(v2_1[0], 0);
        int v13_1 = Math.round(((float)(((int)apps.c.d.a(v2_1[1])))) * 100.0f / 100.0f);
        StringBuilder v14 = new StringBuilder();
        v14.append(v3_3 >= 10 ? v2_1[0] : "0" + v2_1[0]);
        v14.append(":");
        if(v13_1 < 10) {
            v1_3 = new StringBuilder();
            v1_3.append("0");
            v1_3.append(v13_1);
        }
        else {
            v1_3 = new StringBuilder();
            v1_3.append(v13_1);
            v1_3.append("");
        }

        v14.append(v1_3.toString());
        String v1_4 = v14.toString();
        String[] v2_2 = apps.c.d.doubleToStr(v10_1, 2).split("[.]");
        int v3_4 = (int)apps.c.d.a(v2_2[0], 0);
        int v10_2 = Math.round(((float)(((int)apps.c.d.a(v2_2[1])))) * 100.0f / 100.0f);
        StringBuilder v11 = new StringBuilder();
        v11.append(v3_4 >= 10 ? v2_2[0] : "0" + v2_2[0]);
        v11.append(":");
        if(v10_2 < 10) {
            v2_3 = new StringBuilder();
            v2_3.append("0");
            v2_3.append(v10_2);
        }
        else {
            v2_3 = new StringBuilder();
            v2_3.append(v10_2);
            v2_3.append("");
        }

        v11.append(v2_3.toString());
        v0.ah.setText(v1_4);
        v0.ai.setText(v11.toString());
        v0.R.setText(apps.c.d.doubleToStr(v6, 0));
        v0.T.setText(apps.c.d.doubleToStr(v7, 0));
        v0.U.setText(apps.c.d.doubleToStr(v21, 2));
        v0.V.setText(apps.c.d.doubleToStr(v19, 2));
        v0.ab.setText(apps.c.d.doubleToStr(v12, 0));
        v0.ae.setText(apps.c.d.doubleToStr(v17, 2));
        v0.af.setText(apps.c.d.doubleToStr(v15, 0));
        v0.ag.setText(apps.c.d.doubleToStr(v5_1, 0));
        double v2_4 = v23;
        v0.aj.setText(apps.c.d.doubleToStr(v2_4, 1));
        double v5_2 = v26;
        v0.ac.setText(apps.c.d.doubleToStr(v5_2, 1));
        v0.ad.setText(apps.c.d.doubleToStr(v8_1, 1));
        v0.aG.setText(arg29.T + "");
        v0.aI.setText(apps.c.d.doubleToStr(v5_2, 1));
        v0.aJ.setText(apps.c.d.doubleToStr(v2_4, 1));
        v0.aK.setText(apps.c.d.doubleToStr(v8_1, 1));
        v0.aa.setText(v25);
        v0.Z.setText(v16);
        if(!v0.w.b) {
            v0.w.setValue(v5_2);
        }

        if(!v0.x.b) {
            if(AppsRunner.get(this).inclineSupportsHalfDegree(v0)) {
                v0.x.setValue(v8_1);
                v2_5 = v8_1 + " |";
            }
            else {
                v0.x.setValue(v2_4);
                v2_5 = v2_4 + " |";
            }

            j.a("----speed----", v2_5);
        }

        this.z();
    }

    static int f(AppsRunningPhoneActivity arg0) {
        return arg0.bn;
    }

    static boolean f(AppsRunningPhoneActivity arg0, boolean arg1) {
        arg0.bq = arg1;
        return arg1;
    }

    @Override  // com.xtremeprog.shell.treadmillv2.AppsRunner$a
    public void f(AppsRunner arg2) {
        this.W.setText("10:54:45");
    }

    static RelativeLayout g(AppsRunningPhoneActivity arg0) {
        return arg0.ak;
    }

    static int h(AppsRunningPhoneActivity arg2) {
        int v0 = arg2.bn;
        arg2.bn = v0 + 1;
        return v0;
    }

    static boolean i(AppsRunningPhoneActivity arg0) {
        return arg0.bh;
    }

    static TextView j(AppsRunningPhoneActivity arg0) {
        return arg0.aV;
    }

    static boolean k(AppsRunningPhoneActivity arg0) {
        return arg0.bs;
    }

    static void l(AppsRunningPhoneActivity arg0) {
        arg0.A();
    }

    public void l() {
        this.u();
        AppsRunner.get(this).U = AppsRunner.get(this).k(this);
        this.handleStartCoolDown_111.removeMessages(0x6F);
        AppsRunner.get(this).h();
        this.setResult(-1, this.getIntent());
        this.finish();
    }

    static Date m(AppsRunningPhoneActivity arg0) {
        return arg0.fromRunningDate;
    }

    public void m() {
        this.u();
        ((AppsApplication)this.getApplication()).h(true);
        this.handleStartCoolDown_111.removeMessages(0x6F);
        AppsRunner.get(this).h();
        this.setResult(-1, this.getIntent());
        this.finish();
    }

    public void dismissNoHR() {
        j.a("==dismissNoHR==", "====");
        this.noHRTip.setVisibility(8);
    }

    public void o() {
        if(this.bq) {
            return;
        }

        this.bq = true;
        this.b(this, this.getResources().getString(0x7F0B000F), false);  // string:STR_ALERT_TIP_SAVE_SESSION "Save workout result..."
        this.fromRunningDate = new Date();
        if(AppsRunner.get(this).k(this) == 5) {
            String v0 = f.a(this.fromRunningDate, "yyyy-MM-dd HH:mm:ss");
            ContextSharedPreferences.SharedPreferencesEditor(this, "MyFirst5KSportDate_" + AppsRunner.get(this).getPref_CurrentUserID(this), v0, 5);
        }

        new Thread() {
            @Override
            public void run() {
                AppsRunner.get(AppsRunningPhoneActivity.this.getApplicationContext()).a(AppsRunningPhoneActivity.this.getApplicationContext(), AppsRunningPhoneActivity.m(AppsRunningPhoneActivity.this));
                Message v0 = new Message();
                AppsRunningPhoneActivity.this.j.sendMessage(v0);
            }
        }.start();
    }

    @Override  // android.app.Activity
    public void onActivityResult(int arg1, int arg2, Intent arg3) {
        if(arg2 == -1 && arg1 == 0x6F) {
            this.handleStartCoolDown_111.removeMessages(0x6F);
            this.onBackPressed();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        if(this.t()) {
            this.bs = true;
            AppsRunner.get(this).pauseWorkout();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg5) {
        AppsRunner.get(this).b(this);
        super.onCreate(arg5);
        this.getWindow().setFlags(0x80, 0x80);
        this.setContentView(apps.c.d.d() ? 0x7F09003C : 0x7F09003B);  // layout:activity_running_phone_s9
        AppsRunner.get(this).a(((a)this));
        this.bk = apps.database.d.a().g(this, AppsRunner.get(this).getPref_CurrentUserID(this));
        this.x();
        this.y();
        this.a(true);
        this.bn = 0;
        if(AppsRunner.get(this).g()) {
            AppsRunner.get(this).resumeRun2();
        }
        else {
            AppsRunner.get(this).startRun();
        }

        this.aU = n.a().h(this, 0x7F07010E);  // id:logScrollView
        this.aV = n.a().e(this, 0x7F07010F);  // id:logTextView
        this.aU.setVisibility(8);
        this.aV.setVisibility(8);
        int v0 = AppsRunner.get(this).securitySwitch;
        j.a("==来到running了，看下安全锁状态==", " | " + v0);  // Come to running, check the safety lock status
        if(v0 == 1) {
            AppsRunner.get(this.getApplicationContext()).r();
            this.u();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        super.onDestroy();
        this.a(false);
        AppsRunner.get(this).a(null);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        this.bh = true;
        AppsRunner.get(this).b(this);
        this.shouldStopSafetyKeyTip = false;
        this.s();
        AppsApplication v2 = (AppsApplication)this.getApplication();
        boolean v3 = AppsRunnerConnector.get(this).isConnected();
        v2.n();
        v2.o();
        if(!v3) {
            this.b(true, true);
            return;
        }

        this.b(false, false);
    }

    @Override  // android.app.Activity
    public void onStart() {
        super.onStart();
        AppsRunner.get(this).a = true;
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        this.bh = false;
        AppsRunner.get(this).a = false;
        this.handle_showNoHR_111111.removeMessages(0x1B207);
        this.bt.removeMessages(0xD903);
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg1, MotionEvent arg2) {
        if(arg2.getAction() == 0) {
            this.a(arg1);
        }

        return true;
    }

    public void p() {
        AppsRunner.get(this).h();
        int v0 = AppsRunner.get(this).k(this);
        AppsRunner.get(this).a(v0);
        this.s.setVisibility(0);
        this.n.setVisibility(8);
        this.u.setVisibility(8);
        this.r.setVisibility(8);
        this.q.setVisibility(0);
        this.o.setVisibility(0);
        this.v.setVisibility(0);
    }

    public void q() {
        this.s.setVisibility(8);
        this.n.setVisibility(0);
        this.u.setVisibility(0);
        this.r.setVisibility(0);
        this.q.setVisibility(8);
        this.o.setVisibility(8);
        this.v.setVisibility(8);
        this.startCooldown(true, false);
    }

    public void stopWorkout() {
        j.a("=====发STOP WORKOUT======", "==========");
        ((AppsApplication)this.getApplication()).a(true);
        AppsRunner.get(this).q();
        this.v();
    }

    public void s() {
        float v3;
        int v0 = AppsRunner.get(this).k(this);
        if(v0 != 3 && v0 != 11 && v0 != 7 && v0 != 10 && v0 != 5 && v0 != 8) {
            v3 = 1.0f;
            this.t.setAlpha(1.0f);
            this.l.setOnTouchListener(this);
        }
        else {
            v3 = 0.3f;
            this.t.setAlpha(0.3f);
            this.l.setOnTouchListener(null);
        }

        this.l.setAlpha(v3);
        if(AppsRunner.get(this).inclineSupportsHalfDegree(this)) {
            this.E.setOnTouchListener(this);
            this.F.setOnTouchListener(this);
            this.av.setVisibility(0);
            this.aC.setOnTouchListener(this);
            this.aD.setOnTouchListener(this);
            return;
        }

        this.E.setOnTouchListener(null);
        this.F.setOnTouchListener(null);
        this.aC.setOnTouchListener(null);
        this.aD.setOnTouchListener(null);
        this.aC.setVisibility(8);
        this.aD.setVisibility(0);
        this.aw.setVisibility(8);
        this.F.setVisibility(8);
        this.E.setVisibility(0);
        this.av.setVisibility(8);
    }

    public boolean t() {
        int v0 = AppsRunner.get(this).k(this);
        return v0 != 3 && v0 != 11 && v0 != 7 && v0 != 10 && v0 != 5 && v0 != 8;
    }

    public void u() {
        this.k.removeMessages(0x8235);
    }

    public void v() {
        this.u();
        Message v0 = new Message();
        v0.what = 0x8235;
        this.k.sendMessageDelayed(v0, 8000L);
    }

    private void w() {
        AppsRunner.get(this).startWorkout();
    }

    private void x() {
        int v0_1;
        this.b();
        this.y = (AppsRunningDoubleTrackView)this.findViewById(0x7F070299);  // id:trackView
        this.y.setOutterStrokeWidth(k.a(this, 2.242078E-44f));
        this.y.setOutterStrokeColor(Color.parseColor("#FD7E2D"));
        this.y.setInnerStrokeWidth(k.a(this, 1.121039E-44f));
        this.y.setInnerStrokeColor(Color.parseColor("#FFFFFF"));
        this.y.a(k.a(this, 3.923636E-43f), k.a(this, 2.522337E-43f), k.a(this, 8.407791E-44f));
        this.y.setTotal(1000.0);
        this.y.setProgress(0.0);
        this.y.setTitileColor(Color.parseColor("#0065A6"));
        this.y.setTitleSize(14);
        this.y.setLeftTitle("3/4");
        this.y.setTopTitle("1/2");
        this.y.setRightTitle("1/4");
        this.y.setBottomTitle(this.getResources().getString(0x7F0B00C6));  // string:STR_START2 "Start"
        this.y.a();
        this.t = n.a().e(this, 0x7F0700CE);  // id:homeTextView
        this.u = n.a().e(this, 0x7F070183);  // id:pauseTextView
        this.v = n.a().e(this, 0x7F070194);  // id:resumeTextView
        this.l = n.a().a(this, 0x7F0700C8, this);  // id:homeButton
        this.m = n.a().a(this, 0x7F0700C9, this);  // id:homeButton2
        this.n = n.a().a(this, 0x7F070180, this);  // id:pauseButton
        this.o = n.a().a(this, 0x7F070192, this);  // id:resumeButton
        this.p = n.a().a(this, 0x7F070279, this);  // id:stopButton
        this.q = n.a().c(this, 0x7F070193);  // id:resumeButtonLayout
        this.r = n.a().c(this, 0x7F070181);  // id:pauseButtonLayout
        this.w = (AppsISMeterView)n.a().g(this, 0x7F0700D7);  // id:inclineRulerView
        this.x = (AppsISMeterView)n.a().g(this, 0x7F070242);  // id:speedRulerView
        this.s = n.a().b(this, 0x7F070182);  // id:pauseLayout
        this.aq = n.a().b(this, 0x7F070012, this);  // id:addTimeButton
        this.ar = n.a().b(this, 0x7F07011F, this);  // id:minusTimeButton
        this.R = n.a().e(this, 0x7F07029C);  // id:tv_average_hr
        this.S = n.a().e(this, 0x7F0702C4);  // id:tv_target_hr
        this.T = n.a().e(this, 0x7F0702AE);  // id:tv_heart_rate
        this.U = n.a().e(this, 0x7F0702B0);  // id:tv_km
        this.V = n.a().e(this, 0x7F0702B4);  // id:tv_miles
        this.X = n.a().e(this, 0x7F0702DD);  // id:tv_total_time
        this.Y = n.a().e(this, 0x7F0702DE);  // id:tv_total_time2
        this.W = n.a().e(this, 0x7F0702A8);  // id:tv_clock
        this.Z = n.a().e(this, 0x7F0702AC);  // id:tv_elapsed_time
        this.aa = n.a().e(this, 0x7F0702BA);  // id:tv_remaining_time
        this.ae = n.a().e(this, 0x7F0702B3);  // id:tv_mets
        this.af = n.a().e(this, 0x7F0702E5);  // id:tv_watts
        this.ag = n.a().e(this, 0x7F0702A6);  // id:tv_cal_hr
        this.ab = n.a().e(this, 0x7F0702A7);  // id:tv_calories
        this.ac = n.a().e(this, 0x7F0702AF);  // id:tv_incline
        this.ad = n.a().e(this, 0x7F0702BB);  // id:tv_resistance
        this.ah = n.a().e(this, 0x7F07029E);  // id:tv_average_pace
        this.ai = n.a().e(this, 0x7F0702B8);  // id:tv_pace
        this.aj = n.a().e(this, 0x7F0702BE);  // id:tv_speed
        this.ak = n.a().c(this, 0x7F070176);  // id:noBluetoothLayout
        this.am = n.a().c(this, 0x7F07004C);  // id:countDownLayout
        this.an = n.a().b(this, 0x7F070049);  // id:count1_layout
        this.ao = n.a().b(this, 0x7F07004A);  // id:count2_layout
        this.ap = n.a().b(this, 0x7F07004B);  // id:count3_layout
        this.bf = n.a().c(this, 0x7F07017A);  // id:noRPM6080Layout
        this.noHRTip = n.a().c(this, 0x7F070179);  // id:noHeartRateLayout
        this.at = n.a().d(this, 0x7F0700BE);  // id:heartRateImageView
        this.au = n.a().d(this, 0x7F070255);  // id:sprint8_heart_iv
        this.al = n.a().a(this, 0x7F070280, this);  // id:testConnectButton
        this.av = n.a().d(this, 0x7F0700DC);  // id:iv_incline_hand
        this.z = n.a().c(this, 0x7F0700F7, this);  // id:layout_heart_rate
        this.A = n.a().c(this, 0x7F070101, this);  // id:layout_target_hr
        this.B = n.a().c(this, 0x7F0700F1, this);  // id:layout_average_hr
        this.C = n.a().c(this, 0x7F0700F9, this);  // id:layout_km
        this.D = n.a().c(this, 0x7F0700FB, this);  // id:layout_miles
        this.E = n.a().c(this, 0x7F0700F8, this);  // id:layout_incline
        this.F = n.a().c(this, 0x7F0700FE, this);  // id:layout_resistance
        this.G = n.a().c(this, 0x7F0700F5, this);  // id:layout_clock
        this.H = n.a().c(this, 0x7F070102, this);  // id:layout_total_time
        this.I = n.a().c(this, 0x7F0700F6, this);  // id:layout_elapsed_time
        this.J = n.a().c(this, 0x7F0700FD, this);  // id:layout_remaining_time
        this.K = n.a().c(this, 0x7F0700FA, this);  // id:layout_mets
        this.L = n.a().c(this, 0x7F070103, this);  // id:layout_watts
        this.M = n.a().c(this, 0x7F0700F3, this);  // id:layout_cal_hr
        this.N = n.a().c(this, 0x7F0700F4, this);  // id:layout_calories
        this.O = n.a().c(this, 0x7F0700F2, this);  // id:layout_average_pace
        this.P = n.a().c(this, 0x7F0700FC, this);  // id:layout_pace
        this.Q = n.a().c(this, 0x7F070100, this);  // id:layout_speed
        this.ax = n.a().e(this, 0x7F070104);  // id:leftMeterTextView
        this.ay = n.a().e(this, 0x7F070195);  // id:rightMeterTextView
        this.aS = n.a().d(this, 0x7F070260);  // id:sprint8_run_logo
        this.aT = n.a().e(this, 0x7F07025F);  // id:sprint8_run_lab
        this.az = n.a().c(this, 0x7F07017D);  // id:params_normal
        this.aB = n.a().b(this, 0x7F07017E);  // id:params_sprint
        this.aA = n.a().c(this, 0x7F07027E);  // id:switch_i_r
        this.aw = n.a().d(this, 0x7F070188);  // id:r_i_hand
        this.aD = n.a().b(this, 0x7F070256);  // id:sprint8_incline_layout
        this.aC = n.a().b(this, 0x7F07025E);  // id:sprint8_resistance_layout
        this.aK = n.a().e(this, 0x7F070249);  // id:sprint8_data_resistance
        this.aE = n.a().e(this, 0x7F070254);  // id:sprint8_data_total
        this.aF = n.a().e(this, 0x7F07024A);  // id:sprint8_data_segment
        this.aG = n.a().e(this, 0x7F070246);  // id:sprint8_data_count
        this.aH = n.a().e(this, 0x7F070247);  // id:sprint8_data_heart
        this.aI = n.a().e(this, 0x7F070248);  // id:sprint8_data_incline
        this.aJ = n.a().e(this, 0x7F07024B);  // id:sprint8_data_speed
        this.aL = n.a().c(this, 0x7F07024C, this);  // id:sprint8_data_speed_layout
        if(AppsRunner.get(this).k(this) == 9) {
            this.az.setVisibility(8);
            this.aB.setVisibility(0);
            this.aS.setVisibility(0);
            this.aT.setVisibility(0);
        }
        else {
            this.az.setVisibility(0);
            this.aB.setVisibility(8);
            this.aS.setVisibility(4);
            this.aT.setVisibility(4);
        }

        boolean v0 = AppsRunner.get(this).inclineSupportsHalfDegree(this);
        this.w.a.k = 0;
        this.x.a.k = v0 ? 2 : 1;
        int v4 = AppsRunner.get(this).k(this);
        int v7 = AppsRunner.get(this).l(this);
        this.w.a(0x7F0B00D2, v4, v7, 0);  // string:STR_TITLE_INCLINE "Incline"
        this.x.a(v0 ? 0x7F0B00D6 : 0x7F0B00D8, v4, v7, v0 ? 2 : 1);  // string:STR_TITLE_RESISTENCE "Resistance"
        this.w.setVisibility(0);
        this.w.setVisibility(8);
        this.ba = AppsRunner.get(this).Y();
        if(this.ba == 1) {
            this.C.setVisibility(0);
            this.D.setVisibility(8);
        }
        else {
            this.C.setVisibility(8);
            this.D.setVisibility(0);
        }

        this.al.setVisibility(8);
        if(v4 == 3) {
            v0_1 = AppsRunner.get(this).getTargetHR();
        }
        else {
            v0_1 = v4 == 8 ? ((int)(((float)(220 - this.bk)) * 0.75f)) : AppsRunner.get(this).d();
        }

        this.S.setText(apps.c.d.doubleToStr(v0_1, 0));
        j.a("==running跑步模式：==", v4 + " |");
        if(v4 != 5 && v4 != 4 && v4 != 2 && v4 != 11 && v4 != 10 && v4 != 7) {
            this.aq.setVisibility(0);
            this.ar.setVisibility(0);
            if(v4 != 0) {
                goto label_523;
            }

            int v0_2 = AppsRunner.get(this).f();
            j.a("==manual计时状态：==", v0_2 + " |");
            if(v0_2 != 1) {
                goto label_523;
            }

            goto label_519;
        }
        else {
        label_519:
            this.aq.setVisibility(8);
            this.ar.setVisibility(8);
        }

    label_523:
        this.x.a(false);
    }

    private void y() {
        this.w.setListener(this);
        this.x.setListener(this);
        this.at.setOnTouchListener(this);
    }

    private void z() {
        int v0 = AppsRunner.get(this).z();
        int v1 = AppsRunner.get(this).A();
        String v2 = apps.c.d.a(v0);
        if(AppsRunner.get(this).k(this) == 9) {
            this.a(v0, v1);
            return;
        }

        this.X.setText(v2);
        this.Y.setText(v2);
        this.y.setTotal(((double)v0));
        this.y.setProgress(((double)v1));
        this.y.b();
    }
}
