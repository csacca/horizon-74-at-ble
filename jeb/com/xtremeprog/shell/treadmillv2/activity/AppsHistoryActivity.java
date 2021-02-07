package com.xtremeprog.shell.treadmillv2.activity;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apps.activity.base.AppsRootActivity;
import apps.b.b;
import apps.c.d;
import apps.c.f;
import apps.c.j;
import apps.c.m.a;
import apps.c.m;
import apps.c.n;
import apps.c.o;
import apps.database.c;
import apps.database.entity.SummaryArticle;
import apps.database.entity.UserArticle;
import apps.vo.AppsArticle;
import com.xpg.a.a.StopWorkoutInfo;
import com.xpg.a.a.WorkoutListMember;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.Conversions;
import com.xtremeprog.shell.treadmillv2.ShareFitness;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class AppsHistoryActivity extends AppsRootActivity implements View.OnTouchListener {
    private TextView A;
    private TextView B;
    private TextView C;
    private Date D;
    private Date E;
    private boolean F;
    private boolean G;
    private boolean H;
    private String I;
    private DatePickerDialog J;
    private DatePickerDialog K;
    private DatePickerDialog.OnDateSetListener L;
    private DatePickerDialog.OnDateSetListener M;
    private BroadcastReceiver N;
    private RelativeLayout O;
    final Handler i;
    private boolean j;
    private boolean k;
    private boolean l;
    private String m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private Button r;
    private Button s;
    private Button t;
    private Button u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public AppsHistoryActivity() {
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = null;
        this.D = new Date();
        this.E = new Date();
        this.F = true;
        this.G = false;
        this.H = false;
        this.I = null;
        this.L = new DatePickerDialog.OnDateSetListener() {
            @Override  // android.app.DatePickerDialog$OnDateSetListener
            public void onDateSet(DatePicker arg6, int arg7, int arg8, int arg9) {
                StringBuilder v6 = new StringBuilder();
                v6.append(arg7);
                v6.append("/");
                int v8 = arg8 + 1;
                String v8_1 = v8 < 10 ? "0" + v8 : ((int)v8);
                v6.append(v8_1);
                v6.append("/");
                String v7 = arg9 < 10 ? "0" + arg9 : ((int)arg9);
                v6.append(v7);
                String v6_1 = v6.toString();
                Date v7_1 = f.stringToDate(v6_1, "yyyy/MM/dd");
                Date v8_2 = f.stringToDate("2016/01/01", "yyyy/MM/dd");
                Date v9 = f.stringToDate("2116/01/01", "yyyy/MM/dd");
                if(v7_1.getTime() < v8_2.getTime()) {
                    v7_1 = v8_2;
                }

                if(v7_1.getTime() > v9.getTime()) {
                    v7_1 = v9;
                }

                if(v7_1.getTime() > AppsHistoryActivity.a(AppsHistoryActivity.this).getTime()) {
                    String v8_3 = b.a().d(AppsHistoryActivity.this);
                    AppsHistoryActivity.b(AppsHistoryActivity.this).setText(f.a(v7_1, "MMMM dd,yyyy", v8_3));
                    Date v0 = f.stringToDate(v6_1, "yyyy/MM/dd");
                    AppsHistoryActivity.a(AppsHistoryActivity.this, v0);
                    AppsHistoryActivity.c(AppsHistoryActivity.this).setText(f.a(v7_1, "MMMM dd,yyyy", v8_3));
                    Date v6_2 = f.stringToDate(v6_1, "yyyy/MM/dd");
                    AppsHistoryActivity.b(AppsHistoryActivity.this, v6_2);
                }
                else {
                    String v8_4 = b.a().d(AppsHistoryActivity.this);
                    AppsHistoryActivity.b(AppsHistoryActivity.this).setText(f.a(v7_1, "MMMM dd,yyyy", v8_4));
                    Date v6_3 = f.stringToDate(v6_1, "yyyy/MM/dd");
                    AppsHistoryActivity.a(AppsHistoryActivity.this, v6_3);
                }

                AppsHistoryActivity.d(AppsHistoryActivity.this);
            }
        };
        this.M = new DatePickerDialog.OnDateSetListener() {
            @Override  // android.app.DatePickerDialog$OnDateSetListener
            public void onDateSet(DatePicker arg6, int arg7, int arg8, int arg9) {
                StringBuilder v6 = new StringBuilder();
                v6.append(arg7);
                v6.append("/");
                int v8 = arg8 + 1;
                String v8_1 = v8 < 10 ? "0" + v8 : ((int)v8);
                v6.append(v8_1);
                v6.append("/");
                String v7 = arg9 < 10 ? "0" + arg9 : ((int)arg9);
                v6.append(v7);
                String v6_1 = v6.toString();
                Date v7_1 = f.stringToDate(v6_1, "yyyy/MM/dd");
                Date v8_2 = AppsHistoryActivity.e(AppsHistoryActivity.this);
                Date v9 = f.stringToDate("2116/01/01", "yyyy/MM/dd");
                if(v7_1.getTime() < v8_2.getTime()) {
                    v7_1 = v8_2;
                }

                if(v7_1.getTime() > v9.getTime()) {
                    v7_1 = v9;
                }

                String v8_3 = b.a().d(AppsHistoryActivity.this);
                AppsHistoryActivity.c(AppsHistoryActivity.this).setText(f.a(v7_1, "MMMM dd,yyyy", v8_3));
                Date v6_2 = f.stringToDate(v6_1, "yyyy/MM/dd");
                AppsHistoryActivity.b(AppsHistoryActivity.this, v6_2);
                AppsHistoryActivity.d(AppsHistoryActivity.this);
            }
        };
        this.N = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg2, Intent arg3) {
                String v2 = arg3.getAction();
                if(v2.equals("NOTIFICATION_DID_START_WORKOUT")) {
                    AppsRunner.get(AppsHistoryActivity.this).u();
                    AppsHistoryActivity.this.finish();
                    return;
                }

                if(!v2.equals("NOTIFICATION_DIDCONNECT") && !v2.equals("NOTIFICATION_DISCONNECT")) {
                    if(v2.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                        if(!AppsHistoryActivity.f(AppsHistoryActivity.this)) {
                            return;
                        }

                        AppsHistoryActivity.this.b(false);
                        AppsHistoryActivity.this.i.removeMessages(0x6F);
                        AppsRunner.get(AppsHistoryActivity.this).u();
                        if(AppsHistoryActivity.g(AppsHistoryActivity.this) != null) {
                            AppsHistoryActivity.this.onBackPressed();
                            Intent v2_1 = new Intent();
                            v2_1.setAction("NOTIFICATION_HISTORY_HOME");
                            AppsHistoryActivity.this.sendBroadcast(v2_1);
                            return;
                        }

                        AppsHistoryActivity.this.onBackPressed();
                        return;
                    }

                    if(v2.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                        AppsHistoryActivity.this.i.removeMessages(0x6F);
                    }

                    return;
                }

                AppsHistoryActivity.f(AppsHistoryActivity.this);
            }
        };
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    Intent v4 = new Intent(AppsHistoryActivity.this, AppsDeviceListActivity.class);
                    AppsHistoryActivity.this.startActivity(v4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsHistoryActivity.this.b(false);
                        }
                    }, 500L);
                }
            }
        };
    }

    static Date a(AppsHistoryActivity arg0) {
        return arg0.E;
    }

    static Date a(AppsHistoryActivity arg0, Date arg1) {
        arg0.D = arg1;
        return arg1;
    }

    public void a(int arg28, boolean arg29) {
        AppsHistoryActivity v15 = this;
        Date v2 = AppsRunner.get(this).getRunDate();
        int v14 = AppsRunner.get(this).getPref_CurrentUserID(v15);
        String v3 = ShareFitness.get(this).getPrefsMapMyFitnessTokenKey(v14 + "");
        int v0 = (int)d.a(v15.x.getText(), 0);
        int v4 = AppsRunner.get(this).A();
        int v6 = AppsRunner.get(this).z();
        if(AppsRunner.get(this).getCurrentStopWorkoutInfom() != null) {
            v4 = AppsRunner.get(this).getCurrentStopWorkoutInfom().g();
        }

        int v5 = v4;
        double v9 = d.a(v15.w.getText(), 0.0) * 1.0;
        double v7 = d.a(v15.z.getText(), 0.0);
        int v13 = (int)d.a(v15.A.getText(), 0);
        boolean v4_1 = AppsRunner.get(this).inclineSupportsHalfDegree(v15);
        int v1 = AppsRunner.get(this).Y();
        double v18 = 1000.0;
        double v11 = v1 == 0 ? Conversions.b(v7) * v18 : v7 * v18 / 3600.0;
        int v20 = v14;
        int v21 = v1;
        j.a("===", "mmf avg_speed : " + v7 + "  " + v11);
        if(!d.d(this)) {
            SummaryArticle v1_1 = new SummaryArticle();
            v1_1.setSummaryDate(f.a(v2, "yyyy-MM-dd HH:mm:ss"));
            v1_1.setMmfToken(v3);
            v1_1.setMfpToken("");
            v1_1.setMfpUserId("");
            v1_1.setCalories(v0);
            v1_1.setElapsedTime(v5);
            v1_1.setTotalTime(v6);
            v1_1.setTotalDistance(((float)v9));
            v1_1.setAverageSpeed(((float)v7));
            v1_1.setAverageHR(v13);
            v1_1.setIsEp(((int)v4_1));
            v1_1.setUnits(v21);
            v1_1.setUserid(v20 + "");
            c.a().a(this, v20 + "", v1_1);
            j.a("====", "无网络，先保存到本地ＭMF : " + v1_1);
            return;
        }

        int v15_1 = v20;
        int v14_1 = v21;
        AppsHistoryActivity v1_2 = this;
        if(v5 > 0 && !d.strNotEmpty(v3)) {
            boolean v20_1 = v4_1;
            if(!d.a(v3, "0000000000000000000000000000000000000000")) {
                int v4_2 = Conversions.kilocalorie_to_joule(v1_2, v0);
                if(v14_1 == 0) {
                    v9 = Conversions.mi_to_km(v9);
                }

                j.a("==开始分享==", "====" + v3 + "  ||  " + ShareFitness.get(this).p(v3));
                HashMap v0_1 = new HashMap();
                v0_1.put("startDate", v2);
                v0_1.put("totalTime", Integer.valueOf(v6));
                v0_1.put("elapsedTime", Integer.valueOf(v5));
                v0_1.put("totalDistance", Float.valueOf(((float)(v9 * v18))));
                v0_1.put("averageSpeed", Float.valueOf(((float)(v11 * 1.0))));
                v0_1.put("averageHR", Integer.valueOf(v13));
                v0_1.put("calories", Integer.valueOf(v4_2));
                m.a(new a() {
                    @Override  // apps.c.m$a
                    public Object a() {
                        String v0 = o.a().a(AppsHistoryActivity.this, "55xtz5n5kmdphxxsmbvgn68byrvnqbxj", "t8WV9adqUT6D47yvqd9gFu65MZUFcNKWtNwC9GCHJG6", v3, ((int)AppsRunner.get(this).inclineSupportsHalfDegree(v1_2)), v0_1);
                        if(!d.strNotEmpty(v0)) {
                            AppsArticle v1 = AppsArticle.toAppsArticle(v0);
                            if(v1 != null) {
                                v1.setJson(v0);
                            }

                            j.a("==MMF json ==", v0 + " |");
                            return v1;
                        }

                        return null;
                    }
                }, new apps.c.m.b() {
                    @Override  // apps.c.m$b
                    public void a(Object arg8) {
                        int v0 = 0;
                        if(arg8 != null) {
                            try {
                                AppsArticle v8_1 = (AppsArticle)arg8;
                                String v2 = v8_1.getStart_datetime();
                                String v3 = v8_1.getJson();
                                if(d.b(v3).indexOf("ACCESSTOKEN_EXPIRED") != -1 || d.b(v3).indexOf("ACCESSTOKEN_NOT_FOUND") != -1) {
                                    goto label_20;
                                }

                                if(!d.strNotEmpty(v2)) {
                                    v0 = 1;
                                    goto label_96;
                                label_20:
                                    SummaryArticle v2_1 = new SummaryArticle();
                                    v2_1.setSummaryDate(f.a(v2, "yyyy-MM-dd HH:mm:ss"));
                                    v2_1.setMmfToken(v3);
                                    v2_1.setMfpToken("");
                                    v2_1.setMfpUserId("");
                                    v2_1.setCalories(v4_2);
                                    v2_1.setElapsedTime(v5);
                                    v2_1.setTotalTime(v6);
                                    v2_1.setTotalDistance(((float)v9));
                                    v2_1.setAverageSpeed(((float)v7));
                                    v2_1.setAverageHR(v13);
                                    v2_1.setIsEp(v20_1 ? 1 : 0);
                                    v2_1.setUnits(v14_1);
                                    v2_1.setUserid(v15_1 + "");
                                    c.a().a(AppsHistoryActivity.this, v15_1 + "", v2_1);
                                    j.a("====", "等MMF refresh token，先保存到本地MMF : " + v8_1);
                                    ((AppsApplication)AppsHistoryActivity.this.getApplication()).doRefreshMMFToken2(v15_1 + "", 1);
                                    return;
                                }
                            }
                            catch(Exception v8) {
                                v8.printStackTrace();
                            }
                        }

                    label_96:
                        if(v0 == 0) {
                            if(arg28 < 999) {
                                j.a("====", "MMF RETRY TO SHARE");
                                AppsHistoryActivity.this.a(arg28 + 1, arg29);
                                return;
                            }

                            j.a("====", "MMF FAILED TO SHARE");
                        }
                        else {
                            j.a("====", "MMF SUCCESS TO SHARE");
                            if(arg29) {
                                String v0_1 = AppsHistoryActivity.this.getResources().getString(0x7F0B00BF);  // string:STR_SHARE_SUCCESS "Successfully Shared"
                                AppsHistoryActivity.this.b(v0_1);
                                return;
                            }
                        }
                    }
                });
                return;
            }
        }

        j.a("==mmfToken为空或其他==", "==暂不分享MMF===");
    }

    public void a(boolean arg2) {
        if(!arg2) {
            goto label_32;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DID_START_WORKOUT");
            this.registerReceiver(this.N, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.N, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.N, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.N, v2_4);
            IntentFilter v2_5 = new IntentFilter();
            v2_5.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.N, v2_5);
            return;
        label_32:
            this.unregisterReceiver(this.N);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static Button b(AppsHistoryActivity arg0) {
        return arg0.t;
    }

    static Date b(AppsHistoryActivity arg0, Date arg1) {
        arg0.E = arg1;
        return arg1;
    }

    public void b(int arg23, boolean arg24) {
        AppsHistoryActivity v15 = this;
        Date v7 = AppsRunner.get(this).getRunDate();
        int v13 = AppsRunner.get(this).getPref_CurrentUserID(v15);
        int v12 = apps.database.d.a().e(v15, v13);
        String v8 = ShareFitness.get(this).getPrefsMFP_UserId(v13 + "");
        boolean v11 = AppsRunner.get(this).inclineSupportsHalfDegree(v15);
        String v9 = ShareFitness.get(this).getPrefsMFPTokenId(v13 + "");
        int v10 = (int)d.a(v15.x.getText(), 0);
        int v14 = AppsRunner.get(this).B();
        int v0 = AppsRunner.get(this).getCurrentStopWorkoutInfom() == null ? 0 : AppsRunner.get(this).getCurrentStopWorkoutInfom().g();
        float v6 = (float)(d.a(v15.w.getText(), 0.0) * 1.0);
        float v5 = (float)(d.a(v15.z.getText(), 0.0) * 1.0);
        int v2 = (int)d.a(v15.A.getText(), 0);
        float v3 = AppsRunner.get(this).T();
        float v4 = AppsRunner.get(this).U();
        int v16 = AppsRunner.get(this).V();
        float v17 = v4;
        int v4_1 = (int)d.a(v15.A.getText(), 0);
        if(!d.d(this)) {
            SummaryArticle v1 = new SummaryArticle();
            v1.setSummaryDate(f.a(v7, "yyyy-MM-dd HH:mm:ss"));
            v1.setMmfToken("");
            v1.setMfpToken(v9);
            v1.setMfpUserId(v8);
            v1.setCalories(v10);
            v1.setElapsedTime(v0);
            v1.setTotalTime(v14);
            v1.setTotalDistance(v6);
            v1.setAverageSpeed(v5);
            v1.setAverageHR(v4_1);
            v1.setIsEp(((int)v11));
            v1.setUnits(v12);
            v1.setUserid(v13 + "");
            c.a().a(v15, v13 + "", v1);
            j.a("====", "无网络，先保存到本地ＭFP : " + v1);
            return;
        }

        if(v10 > 0 && v0 > 0 && !d.strNotEmpty(v9) && !d.a(v9, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
            int v18 = v0 >= 60 ? v0 : 60;
            j.a("==开始分享==", "====" + v9 + "  ||| " + ShareFitness.get(this).q(v9));
            HashMap v15_1 = new HashMap();
            v15_1.put("startDate", v7);
            v15_1.put("totalTime", Integer.valueOf(v14));
            v15_1.put("elapsedTime", Integer.valueOf(v18));
            v15_1.put("totalDistance", Float.valueOf(v6));
            v15_1.put("averageSpeed", Float.valueOf(v5));
            v15_1.put("averageHR", Integer.valueOf(v2));
            v15_1.put("calories", Integer.valueOf(v10));
            v15_1.put("maxSpeed", Float.valueOf(v3));
            v15_1.put("maxSpeedKPH", Float.valueOf(v17));
            v15_1.put("maxHR", Integer.valueOf(v16));
            m.a(new a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().a(AppsHistoryActivity.this, "afgfitness", "c7e6915ed48f7befbaa3", v9, ((int)v11), v12, v8, v15_1);
                    if(!d.strNotEmpty(v0)) {
                        AppsArticle v1 = AppsArticle.toAppsArticle(v0);
                        if(v1 != null) {
                            v1.setJson(v0);
                        }

                        j.a("==MFP json ==", v0 + " |");
                        return v1;
                    }

                    return null;
                }
            }, new apps.c.m.b() {
                @Override  // apps.c.m$b
                public void a(Object arg8) {
                    int v0 = 0;
                    if(arg8 != null) {
                        try {
                            AppsArticle v8_1 = (AppsArticle)arg8;
                            String v2 = v8_1.getError();
                            if(d.b(v8_1.getJson()).indexOf("Expired token") != -1) {
                                SummaryArticle v2_1 = new SummaryArticle();
                                v2_1.setSummaryDate(f.a(v7, "yyyy-MM-dd HH:mm:ss"));
                                v2_1.setMmfToken("");
                                v2_1.setMfpToken(v9);
                                v2_1.setMfpUserId(v8);
                                v2_1.setCalories(v10);
                                v2_1.setElapsedTime(v18);
                                v2_1.setTotalTime(v14);
                                v2_1.setTotalDistance(v6);
                                v2_1.setAverageSpeed(v5);
                                v2_1.setAverageHR(v4_1);
                                v2_1.setIsEp(((int)v11));
                                v2_1.setUnits(v12);
                                v2_1.setUserid(v13 + "");
                                c.a().a(AppsHistoryActivity.this, v13 + "", v2_1);
                                j.a("====", "等MFP refresh token，先保存到本地MFP : " + v8_1);
                                ((AppsApplication)AppsHistoryActivity.this.getApplication()).doRefreshMFPToken2(v13 + "", 1);
                                return;
                            }

                            boolean v8_2 = d.strNotEmpty(v2);
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
                        if(arg23 < 999) {
                            j.a("====", "MFP RETRY TO SHARE");
                            AppsHistoryActivity.this.b(arg23 + 1, arg24);
                            return;
                        }

                        j.a("====", "MFP FAILED TO SHARE");
                    }
                    else {
                        j.a("====", "MFP SUCCESS TO SHARE");
                        if(arg24) {
                            String v0_1 = AppsHistoryActivity.this.getResources().getString(0x7F0B00BF);  // string:STR_SHARE_SUCCESS "Successfully Shared"
                            AppsHistoryActivity.this.b(v0_1);
                            return;
                        }
                    }
                }
            });
            return;
        }

        j.a("==mfpToken为空或其他==", "==暂不分享MFP===");
    }

    public void b(boolean arg4) {
        j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)arg4))));
        if(arg4) {
            this.O.setVisibility(0);
            this.i.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.i.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.O.setVisibility(8);
        this.i.removeMessages(0x6F);
    }

    static Button c(AppsHistoryActivity arg0) {
        return arg0.u;
    }

    public void c(int arg23, boolean arg24) {
        AppsHistoryActivity v15 = this;
        Date v7 = AppsRunner.get(this).getRunDate();
        int v13 = AppsRunner.get(this).getPref_CurrentUserID(v15);
        int v12 = apps.database.d.a().e(v15, v13);
        String v8 = ShareFitness.get(this).getPrefsFitbitUserId(v13 + "");
        boolean v11 = AppsRunner.get(this).inclineSupportsHalfDegree(v15);
        String v9 = ShareFitness.get(this).getPrefsFitbitTokenId(v13 + "");
        int v10 = (int)d.a(v15.x.getText(), 0);
        int v14 = AppsRunner.get(this).B();
        int v0 = AppsRunner.get(this).getCurrentStopWorkoutInfom() == null ? 0 : AppsRunner.get(this).getCurrentStopWorkoutInfom().g();
        float v6 = (float)(d.a(v15.w.getText(), 0.0) * 1.0);
        float v5 = (float)(d.a(v15.z.getText(), 0.0) * 1.0);
        int v2 = (int)d.a(v15.A.getText(), 0);
        float v3 = AppsRunner.get(this).T();
        float v4 = AppsRunner.get(this).U();
        int v16 = AppsRunner.get(this).V();
        float v17 = v4;
        int v4_1 = (int)d.a(v15.A.getText(), 0);
        if(!d.d(this)) {
            SummaryArticle v1 = new SummaryArticle();
            v1.setSummaryDate(f.a(v7, "yyyy-MM-dd HH:mm:ss"));
            v1.setMmfToken("");
            v1.setFitbitToken(v9);
            v1.setFitbitUserId(v8);
            v1.setCalories(v10);
            v1.setElapsedTime(v0);
            v1.setTotalTime(v14);
            v1.setTotalDistance(v6);
            v1.setAverageSpeed(v5);
            v1.setAverageHR(v4_1);
            v1.setIsEp(((int)v11));
            v1.setUnits(v12);
            v1.setUserid(v13 + "");
            c.a().a(v15, v13 + "", v1);
            j.a("====", "无网络，先保存到本地FB : " + v1);
            return;
        }

        if(v10 > 0 && v0 > 0 && !d.strNotEmpty(v9) && !d.a(v9, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
            int v18 = v0 >= 60 ? v0 : 60;
            j.a("==开始分享==", "====" + v9 + "  ||| " + ShareFitness.get(this).r(v9));
            HashMap v15_1 = new HashMap();
            v15_1.put("startDate", v7);
            v15_1.put("totalTime", Integer.valueOf(v14));
            v15_1.put("elapsedTime", Integer.valueOf(v18));
            v15_1.put("totalDistance", Float.valueOf(v6));
            v15_1.put("averageSpeed", Float.valueOf(v5));
            v15_1.put("averageHR", Integer.valueOf(v2));
            v15_1.put("calories", Integer.valueOf(v10));
            v15_1.put("maxSpeed", Float.valueOf(v3));
            v15_1.put("maxSpeedKPH", Float.valueOf(v17));
            v15_1.put("maxHR", Integer.valueOf(v16));
            m.a(new a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().b(AppsHistoryActivity.this, "227WN7", "2a036801e9f03a1186a4204415354c90", v9, ((int)v11), v12, v8, v15_1);
                    if(!d.strNotEmpty(v0)) {
                        AppsArticle v1 = AppsArticle.toAppsArticle(v0);
                        if(v1 != null) {
                            v1.setJson(v0);
                        }

                        j.a("==FB json ==", v0 + " |");
                        return v1;
                    }

                    return null;
                }
            }, new apps.c.m.b() {
                @Override  // apps.c.m$b
                public void a(Object arg8) {
                    int v0 = 0;
                    if(arg8 != null) {
                        try {
                            AppsArticle v8_1 = (AppsArticle)arg8;
                            String v2 = v8_1.getError();
                            String v3 = v8_1.getJson();
                            if(d.b(v3).indexOf("Expired token") != -1 || d.b(v3).indexOf("ACCESSTOKEN_EXPIRED") != -1 || d.b(v3).indexOf("ACCESSTOKEN_NOT_FOUND") != -1) {
                                goto label_24;
                            }

                            if(d.strNotEmpty(v2)) {
                                v0 = 1;
                                goto label_94;
                            label_24:
                                SummaryArticle v2_1 = new SummaryArticle();
                                v2_1.setSummaryDate(f.a(v7, "yyyy-MM-dd HH:mm:ss"));
                                v2_1.setMmfToken("");
                                v2_1.setFitbitToken(v9);
                                v2_1.setFitbitUserId(v8);
                                v2_1.setCalories(v10);
                                v2_1.setElapsedTime(v18);
                                v2_1.setTotalTime(v14);
                                v2_1.setTotalDistance(v6);
                                v2_1.setAverageSpeed(v5);
                                v2_1.setAverageHR(v4_1);
                                v2_1.setIsEp(((int)v11));
                                v2_1.setUnits(v12);
                                v2_1.setUserid(v13 + "");
                                c.a().a(AppsHistoryActivity.this, v13 + "", v2_1);
                                j.a("====", "等FB refresh token，先保存到本地FB : " + v8_1);
                                ((AppsApplication)AppsHistoryActivity.this.getApplication()).doRefreshFBToken2(v13 + "", 1);
                                return;
                            }
                        }
                        catch(Exception v8) {
                            v8.printStackTrace();
                        }
                    }

                label_94:
                    if(v0 == 0) {
                        if(arg23 < 999) {
                            j.a("====", "FB RETRY TO SHARE");
                            AppsHistoryActivity.this.c(arg23 + 1, arg24);
                            return;
                        }

                        j.a("====", "FB FAILED TO SHARE");
                    }
                    else {
                        j.a("====", "FB SUCCESS TO SHARE");
                        if(arg24) {
                            String v0_1 = AppsHistoryActivity.this.getResources().getString(0x7F0B00BF);  // string:STR_SHARE_SUCCESS "Successfully Shared"
                            AppsHistoryActivity.this.b(v0_1);
                            return;
                        }
                    }
                }
            });
            return;
        }

        j.a("==fbToken为空或其他==", "==暂不分享FB===");
    }

    static void d(AppsHistoryActivity arg0) {
        arg0.p();
    }

    static Date e(AppsHistoryActivity arg0) {
        return arg0.D;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        n.a().e(this, 0x7F07028D).setText(this.getResources().getString(0x7F0B00CA));  // id:titleTextView
        n.a().e(this, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(this, 0x7F0702E4).setText(this.getResources().getString(0x7F0B00F4));  // id:tv_unit_time
        n.a().e(this, 0x7F0702E1).setText(this.getResources().getString(0x7F0B00EC));  // id:tv_unit_distance
        n.a().e(this, 0x7F0702E0).setText(this.getResources().getString(0x7F0B00EB));  // id:tv_unit_calories
        n.a().e(this, 0x7F0702E3).setText(this.getResources().getString(0x7F0B00AF));  // id:tv_unit_pace
        n.a().e(this, 0x7F0702DF).setText(this.getResources().getString(0x7F0B00EA));  // id:tv_unit_averageSpeed
        n.a().e(this, 0x7F0702E2).setText(this.getResources().getString(0x7F0B00E7));  // id:tv_unit_maxHeartRate
        n.a().e(this, 0x7F0702A4).setText(this.getResources().getString(0x7F0B00C7));  // id:tv_before_startDate
        n.a().e(this, 0x7F0702A1).setText(this.getResources().getString(0x7F0B004B));  // id:tv_before_endDate
        n.a().e(this, 0x7F0702E6).setText(this.getResources().getString(0x7F0B0106));  // id:tv_workoutHistory
        n.a().e(this, 0x7F07029F).setText(this.getResources().getString(0x7F0B0008));  // id:tv_before_age
        n.a().e(this, 0x7F0702A5).setText(this.getResources().getString(0x7F0B0104));  // id:tv_before_weight
        n.a().e(this, 0x7F0702A2).setText(this.getResources().getString(0x7F0B0068));  // id:tv_before_gender
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
        n.a().e(this, 0x7F0702A4).setSingleLine();  // id:tv_before_startDate
        n.a().e(this, 0x7F0702A1).setSingleLine();  // id:tv_before_endDate
        String v0 = b.a().d(this);
        this.t.setText(f.a(this.D, "MMMM dd,yyyy", v0));
        this.u.setText(f.a(this.E, "MMMM dd,yyyy", v0));
        this.o();
    }

    static boolean f(AppsHistoryActivity arg0) {
        return arg0.H;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void finish() {
        super.finish();
    }

    static String g(AppsHistoryActivity arg0) {
        return arg0.I;
    }

    public void l() {
        Calendar v0 = Calendar.getInstance();
        v0.setTime(this.D);
        this.J = new DatePickerDialog(this, this.L, v0.get(1), v0.get(2), v0.get(5));
        this.J.show();
    }

    public void m() {
        Calendar v0 = Calendar.getInstance();
        v0.setTime(this.E);
        this.K = new DatePickerDialog(this, this.M, v0.get(1), v0.get(2), v0.get(5));
        this.K.show();
    }

    private void n() {
        this.b();
        this.v = n.a().e(this, 0x7F070287);  // id:timeTextView
        this.w = n.a().e(this, 0x7F070095);  // id:distanceTextView
        this.x = n.a().e(this, 0x7F07003D);  // id:caloriesTextView
        this.y = n.a().e(this, 0x7F07011E);  // id:minMilesTextView
        this.z = n.a().e(this, 0x7F070016);  // id:averageSpeedTextView
        this.A = n.a().e(this, 0x7F070118);  // id:maxHeartRateTextView
        this.n = n.a().e(this, 0x7F0702F4);  // id:userNameTextView
        this.o = n.a().e(this, 0x7F070013);  // id:ageTextView
        this.p = n.a().e(this, 0x7F0700B8);  // id:genderTextView
        this.q = n.a().e(this, 0x7F0702FF);  // id:weightTextView
        this.B = n.a().e(this, 0x7F0702FC);  // id:versionTextView
        this.C = n.a().e(this, 0x7F07028D);  // id:titleTextView
        this.r = n.a().a(this, 0x7F0700C8, this);  // id:homeButton
        this.s = n.a().a(this, 0x7F0700C9, this);  // id:homeButton2
        this.t = n.a().a(this, 0x7F070271, this);  // id:startDateButton
        this.u = n.a().a(this, 0x7F0700A2, this);  // id:endDateButton
        this.O = n.a().c(this, 0x7F070176);  // id:noBluetoothLayout
        String v0 = b.a().d(this);
        this.t.setText(f.a(this.D, "MMMM dd,yyyy", v0));
        this.u.setText(f.a(this.E, "MMMM dd,yyyy", v0));
        this.B.setText("Ver " + d.e(this));
    }

    private void o() {
        int v1_1;
        TextView v0_3;
        UserArticle v0 = apps.database.d.a().b(this, AppsRunner.get(this).getPref_CurrentUserID(this) + 1);
        if(v0 != null) {
            String v1 = v0.getNickname();
            String v3 = v0.getWeight();
            String v4 = v0.getBirthday();
            int v5 = v0.getGender();
            v0.getModifyflag();
            Date v0_1 = f.stringToDate(v4, "yyyy/MM/dd");
            if(v0_1 == null) {
                v0_1 = f.stringToDate("2000-01-01", "yyyy-MM-dd");
            }

            try {
                if((d.a(v1, "USER 1")) || (d.a(v1, "User 1"))) {
                    v1 = "USER1";
                }
                else if((d.a(v1, "USER 2")) || (d.a(v1, "User 2"))) {
                    v1 = "USER2";
                }
                else if((d.a(v1, "USER 3")) || (d.a(v1, "User 3"))) {
                    v1 = "USER3";
                }
                else if((d.a(v1, "USER 4")) || (d.a(v1, "User 4"))) {
                    v1 = "USER4";
                }
                else if((d.a(v1, "USER 5")) || (d.a(v1, "User 5"))) {
                    v1 = "USER5";
                }
                else if((d.a(v1, "USER 6")) || (d.a(v1, "User 6"))) {
                    v1 = "USER6";
                }
                else if(d.a(v1, "Usuario 1")) {
                    v1 = "Usuario1";
                }
                else if(d.a(v1, "Usuario 2")) {
                    v1 = "Usuario2";
                }
                else if(d.a(v1, "Usuario 3")) {
                    v1 = "Usuario3";
                }
                else if(d.a(v1, "Usuario 4")) {
                    v1 = "Usuario4";
                }
                else if(d.a(v1, "Usuario 5")) {
                    v1 = "Usuario5";
                }
                else if(d.a(v1, "Usuario 6")) {
                    v1 = "Usuario6";
                }
                else if(d.a(v1, "Utilisateur 1")) {
                    v1 = "Utilisateur1";
                }
                else if(d.a(v1, "Utilisateur 2")) {
                    v1 = "Utilisateur2";
                }
                else if(d.a(v1, "Utilisateur 3")) {
                    v1 = "Utilisateur3";
                }
                else if(d.a(v1, "Utilisateur 4")) {
                    v1 = "Utilisateur4";
                }
                else if(d.a(v1, "Utilisateur 5")) {
                    v1 = "Utilisateur5";
                }
                else if(d.a(v1, "Utilisateur 6")) {
                    v1 = "Utilisateur6";
                }

                int v4_2 = d.a(this.getApplicationContext(), "string", v1);
                v1 = this.getResources().getString(v4_2);
            }
            catch(Exception v4_1) {
                v4_1.printStackTrace();
            }

            int v0_2 = d.a(v0_1);
            int v4_3 = d.a(this.getApplicationContext(), "string", v1);
            if(v4_3 == 0) {
                this.n.setText(v1);
            }
            else {
                this.n.setText(v4_3);
            }

            this.o.setText(v0_2 + "");
            this.q.setText(v3);
            if(v5 == 0) {
                v0_3 = this.p;
                v1_1 = 0x7F0B007E;  // string:STR_MALE "Male"
            }
            else {
                if(v5 == 1) {
                    v0_3 = this.p;
                    v1_1 = 0x7F0B005E;  // string:STR_FEMALE "Female"
                    v0_3.setText(v1_1);
                    return;
                }

                if(v5 != 2) {
                    return;
                }

                v0_3 = this.p;
                v1_1 = 0x7F0B0069;  // string:STR_GUEST "Guest"
            }

            v0_3.setText(v1_1);
            return;
        }
    }

    @Override  // android.app.Activity
    public void onActivityResult(int arg2, int arg3, Intent arg4) {
        if(arg3 == -1 && arg2 == 0x6F && (arg4 == null || arg4.getExtras() == null || arg4.getExtras().get("fromHome") == null || !d.a(arg4.getExtras().getString("fromHome"), "1"))) {
            this.onBackPressed();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        this.i.removeMessages(0x6F);
        if(this.j) {
            j.a("====从History back====", "===要清空一下数据===");
        label_13:
            AppsRunner.get(this).clear();
            this.setResult(-1, this.getIntent());
        }
        else if(this.l) {
            goto label_13;
        }

        AppsRunner.get(this).u();
        this.j = false;
        this.finish();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg6) {
        AppsRunner.get(this).b(this);
        super.onCreate(arg6);
        this.getWindow().setFlags(0x80, 0x80);
        this.a(0x7F090024, 0x7F090025, 0x7F090026);  // layout:activity_history
        if(this.getIntent().getExtras() != null) {
            if(this.getIntent().getExtras().get("shouldStopSafetyKeyTip") != null) {
                this.G = ((Boolean)this.getIntent().getExtras().get("shouldStopSafetyKeyTip")).booleanValue();
            }

            if(this.getIntent().getExtras().get("Extra_Key_fromRunning") != null) {
                this.j = ((Boolean)this.getIntent().getExtras().get("Extra_Key_fromRunning")).booleanValue();
            }

            if(this.getIntent().getExtras().get("Extra_Key_fromAppStop") != null) {
                this.l = ((Boolean)this.getIntent().getExtras().get("Extra_Key_fromAppStop")).booleanValue();
            }

            if(this.getIntent().getExtras().get("Extra_Key_fromRunningDate") != null) {
                this.m = (String)this.getIntent().getExtras().get("Extra_Key_fromRunningDate");
            }

            if(this.getIntent().getExtras().get("Extra_Key_from") != null) {
                this.I = (String)this.getIntent().getExtras().get("Extra_Key_from");
            }

            if(this.getIntent().getExtras().get("Extra_Key_from5KStop") != null) {
                this.k = ((Boolean)this.getIntent().getExtras().get("Extra_Key_from5KStop")).booleanValue();
            }

            if(!d.strNotEmpty(this.m)) {
                this.D = f.stringToDate(this.m, "yyyy-MM-dd HH:mm:ss");
                this.E = f.stringToDate(this.m, "yyyy-MM-dd HH:mm:ss");
            }
        }

        this.n();
        this.o();
        this.p();
        this.a(true);
        int v0 = AppsRunner.get(this).securitySwitch;
        j.a("==来到history了==", this.G + " | " + v0);
        if((this.G) && v0 == 1) {
            ((AppsApplication)this.getApplication()).showSafetyAlert(1, -1, true);
        }

        if((this.j) && !this.k) {
            int v0_1 = AppsRunner.get(this).getPref_CurrentUserID(this);
            String v1 = ShareFitness.get(this).getPrefsMapMyFitnessTokenKey(v0_1 + "");
            String v2 = ShareFitness.get(this).getPrefsMFPTokenId(v0_1 + "");
            String v0_2 = ShareFitness.get(this).getPrefsFitbitTokenId(v0_1 + "");
            if(d.strNotEmpty(v1)) {
                j.a("==MMFtoken为空==", "==不分享==");
            }
            else {
                j.a("==MMFtoken不为空==", "==分享==");
                this.a(1, true);
            }

            if(d.strNotEmpty(v2)) {
                j.a("==MFPtoken为空==", "==不分享==");
            }
            else {
                j.a("==MFPtoken不为空==", "==分享==");
                this.b(1, true);
            }

            if(!d.strNotEmpty(v0_2)) {
                j.a("==FBtoken不为空==", "==分享==");
                this.c(1, true);
                return;
            }

            j.a("==FBtoken为空==", "==不分享==");
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        super.onDestroy();
        this.a(false);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        this.H = true;
        AppsRunner.get(this).b(this);
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        this.H = false;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg3, MotionEvent arg4) {
        if(arg4.getAction() == 0) {
            if(arg3 != this.r && arg3 != this.s) {
                if(arg3 == this.t) {
                    this.l();
                    return true;
                }

                if(arg3 == this.u) {
                    this.m();
                    return true;
                }
            }
            else {
                if((this.j) || (this.l)) {
                    j.a("===", "history 按 home select user");
                    AppsRunner.get(this).selectUserInfo();
                }

                if(arg3 == this.s) {
                    this.i.removeMessages(0x6F);
                    ((AppsApplication)this.getApplication()).h(true);
                }

                AppsRunner.get(this).u();
                if(this.I != null) {
                    this.onBackPressed();
                    Intent v3 = new Intent();
                    v3.setAction("NOTIFICATION_HISTORY_HOME");
                    this.sendBroadcast(v3);
                    return true;
                }

                this.onBackPressed();
            }
        }

        return true;
    }

    private void p() {
        StringBuilder v3_1;
        StringBuilder v10_1;
        String v7_2;
        double v2_3;
        int v2_2;
        double v4;
        double v7_1;
        double v9_1;
        double v3;
        AppsHistoryActivity v6 = this;
        int v7 = AppsRunner.get(this).getPref_CurrentUserID(v6);
        String v0 = v6.F ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd";
        if(!v6.j && !v6.l) {
            v0 = "yyyy-MM-dd";
        }

        if(!v6.F) {
            v0 = "yyyy-MM-dd";
        }

        String v8 = f.a(v6.D, v0);
        String v9 = f.a(v6.E, v0);
        int v10 = apps.database.d.a().e(v6, AppsRunner.get(this).getPref_CurrentUserID(v6));
        int v11 = apps.database.b.a().a(v6, v8, v9, v7);
        double v12 = apps.database.b.a().a(this, v8, v9, v7, v10);
        int v14 = apps.database.b.a().b(v6, v8, v9, v7);
        double v8_1 = apps.database.b.a().c(v6, v8, v9, v7);
        double v0_1 = apps.database.b.a().b(this, v8, v9, v7, v10);
        double v15 = 0.0;
        if((v6.j) && (v6.F)) {
            StopWorkoutInfo v2 = AppsRunner.get(this).getCurrentStopWorkoutInfom();
            j.a("==stopWorkoutInfo===", v2 + " |");
            if(v2 == null) {
                v9_1 = v8_1;
                v3 = v15;
                v7_1 = v3;
            }
            else {
                AppsRunner.get(this).B();
                AppsRunner.get(this).C();
                v3 = (double)(((float)v2.b()) / 100.0f);
                v11 = v2.g();
                WorkoutListMember v2_1 = v2.a();
                if(v2_1 == null) {
                    v9_1 = v8_1;
                }
                else {
                    v12 = (double)(((float)v2_1.getDistance()) / 100.0f);
                    v14 = v2_1.getCalories();
                    v15 = (double)(((float)v2_1.getAverageSpeed()) / 10.0f);
                    v9_1 = (double)v2_1.getAverageHR();
                }

                v7_1 = v15;
            }

            j.a("==fromRunning==", v11 + " = " + v11 + " = " + v3 + " = " + v12 + " = " + v14 + " = " + v7_1 + " = " + v9_1);
            v4 = v3;
            v2_2 = 1;
        }
        else {
            double v19 = 1.0;
            if((v6.l) && (v6.F)) {
                AppsRunner.get(this).B();
                v2_3 = v11 == 0 ? v15 : v12 / (((double)v11) * v19 / 3600.0);
                if(v2_3 != v15) {
                    v15 = 60.0 / v2_3;
                }

                v4 = v15;
                v7_2 = "==fromAppStop==";
                v10_1 = new StringBuilder();
            }
            else {
                v2_3 = v11 == 0 ? v15 : v12 / (((double)v11) * v19 / 3600.0);
                if(v2_3 != v15) {
                    v15 = 60.0 / v2_3;
                }

                v4 = v15;
                v7_2 = "==fromHistory==";
                v10_1 = new StringBuilder();
            }

            v10_1.append(v11);
            v10_1.append(" = ");
            v10_1.append(v11);
            v10_1.append(" = ");
            v10_1.append(v4);
            v10_1.append(" = ");
            v10_1.append(v12);
            v10_1.append(" = ");
            v10_1.append(v14);
            v10_1.append(" = ");
            v10_1.append(v2_3);
            v10_1.append(" = ");
            v10_1.append(v8_1);
            j.a(v7_2, v10_1.toString());
            v9_1 = v8_1;
            v7_1 = v2_3;
            v2_2 = 0;
        }

        String[] v4_1 = d.doubleToStr(v4, 2).split("[.]");
        int v5 = (int)d.a(v4_1[0], 0);
        int v15_1 = v2_2 == 0 ? Math.round(((float)(((int)d.a(v4_1[1])))) * 60.0f / 100.0f) : Math.round(((float)(((int)d.a(v4_1[1])))) * 100.0f / 100.0f);
        StringBuilder v2_4 = new StringBuilder();
        v2_4.append(v5 >= 10 ? v4_1[0] : "0" + v4_1[0]);
        v2_4.append(":");
        if(v15_1 < 10) {
            v3_1 = new StringBuilder();
            v3_1.append("0");
            v3_1.append(v15_1);
        }
        else {
            v3_1 = new StringBuilder();
            v3_1.append(v15_1);
            v3_1.append("");
        }

        v2_4.append(v3_1.toString());
        String v2_5 = v2_4.toString();
        j.a("====totalTime====", v11 + " |");
        j.a("====elapsedTime====", v11 + " |");
        j.a("====totalDistance====", v12 + " |");
        j.a("====totalCalories====", v14 + " |");
        j.a("====averageSpeed====", v7_1 + " | " + 60.0 / v7_1);
        j.a("====maxHeartRate====", v9_1 + " |");
        j.a("====minMiles====", v0_1 + " |");
        j.a("====paceStr====", v2_5 + " |");
        v6.v.setText(d.a(v11));
        v6.w.setText(d.doubleToStr(v12, 2));
        v6.x.setText(v14 + "");
        v6.y.setText(v2_5);
        v6.z.setText(d.doubleToStr(v7_1, 1));
        v6.A.setText(d.doubleToStr(v9_1, 0));
        v6.F = false;
    }
}
