package com.xtremeprog.shell.treadmillv2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import apps.c.ContextSharedPreferences;
import apps.c.d;
import apps.c.j;
import apps.database.b;
import apps.database.entity.RecordArticle;
import apps.database.entity.UserArticle;
import apps.vo.AppsArticle;
import com.xpg.a.a.StopWorkoutInfo;
import com.xpg.a.a.WorkoutData;
import com.xpg.a.a.WorkoutListMember;
import com.xpg.a.b.DeviceCommand;
import com.xpg.a.c.Factory;
import com.xpg.b.BLEManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class AppsRunner {
    public interface a {
        void a(AppsRunner arg1);

        void b(AppsRunner arg1);

        void c(AppsRunner arg1);

        void d(AppsRunner arg1);

        void e(AppsRunner arg1);

        void f(AppsRunner arg1);
    }

    public double A;
    public double B;
    public int C;
    public int D;
    public int E;
    public int F;
    public double G;
    public double H;
    public double I;
    public double J;
    public double K;
    public int L;
    public double M;
    public double N;
    public double O;
    public double P;
    public double Q;
    public double R;
    public double S;
    public int T;
    public int U;
    private WorkoutData workoutData1;
    private WorkoutData workoutData2;
    private static Context mContext;
    private Context Y;
    private static AppsRunner s_instance;
    public boolean a;
    private f aa;
    private Date runDate;
    private boolean ac;
    private int ad;
    private int ae;
    private int mCurrentUser;
    private Timer ag;
    private TimerTask ah;
    private Timer ai;
    private TimerTask aj;
    private StopWorkoutInfo mCurrentStopWorkoutInfo;
    @SuppressLint({"HandlerLeak"})
    private Handler al;
    private Handler am;
    private a an;
    public int securitySwitch;
    public int elapsedTime;
    public ConcurrentHashMap d;
    public ConcurrentHashMap e;
    public ConcurrentHashMap f;
    public ConcurrentHashMap g;
    public ConcurrentHashMap h;
    public ConcurrentHashMap i;
    public ConcurrentHashMap j;
    public ConcurrentHashMap k;
    public ConcurrentHashMap l;
    public ConcurrentHashMap m;
    public ConcurrentHashMap n;
    public ConcurrentHashMap o;
    public ConcurrentHashMap p;
    public ConcurrentHashMap q;
    public ConcurrentHashMap r;
    public ConcurrentHashMap s;
    public ConcurrentHashMap t;
    public int u;
    public int v;
    public double w;
    public int x;
    public int heartRate;
    public int z;

    static {
    }

    private AppsRunner() {
        this.workoutData1 = new WorkoutData();
        this.workoutData2 = new WorkoutData();
        this.Y = null;
        this.runDate = null;
        this.a = false;
        this.securitySwitch = 0;
        this.ac = false;
        this.ad = 0;
        this.ae = 0;
        this.elapsedTime = 0;
        this.mCurrentUser = 0;
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = new ConcurrentHashMap();
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.m = new ConcurrentHashMap();
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.p = new ConcurrentHashMap();
        this.q = new ConcurrentHashMap();
        this.r = new ConcurrentHashMap();
        this.s = new ConcurrentHashMap();
        this.t = new ConcurrentHashMap();
        this.U = 0;
        this.mCurrentStopWorkoutInfo = null;
        this.al = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg5) {
                String v5_1;  // HR time is up, need to stop
                if(arg5.what == 0x6F) {
                    ++AppsRunner.this.elapsedTime;
                    int v5 = 0;
                    if(AppsRunner.this.elapsedTime > AppsRunner.a(AppsRunner.this) && AppsRunner.a(AppsRunner.this) > 0) {
                        AppsRunner.this.elapsedTime = AppsRunner.a(AppsRunner.this);
                        v5 = 1;
                    }

                    j.a("----elapsedTime----", AppsRunner.this.elapsedTime + "," + AppsRunner.a(AppsRunner.this));
                    Context v2 = AppsRunner.ak();
                    int v0 = AppsRunner.this.k(v2);
                    if(v0 == 5) {
                        j.a("----km----", AppsRunner.this.O + ",");
                        AppsRunnerConnector.get(AppsRunner.ak()).v();
                        AppsRunner.this.E();
                        if(AppsRunner.b(AppsRunner.this) == null) {
                            return;
                        }
                    }
                    else if(v0 == 3) {
                        int targetHR = AppsRunner.this.getTargetHR() + 25;
                        j.a("=-=-=-=-=", AppsRunner.this.elapsedTime + " > " + AppsRunner.a(AppsRunner.this));
                        j.a("=-=-=-=-=", AppsRunner.this.heartRate + " > " + targetHR);
                        if(v5 != 0) {
                            v5_1 = "----HR时间到点，需要停止了----";  // HR time is up, need to stop
                            j.a(v5_1, "------");
                            return;
                        }

                        if(AppsRunner.this.heartRate >= targetHR) {
                            j.a("----HR大于目标心率，需要停止了----", "------");  // HR is greater than target heart rate, need to stop
                            AppsRunner.this.q();
                            return;
                        }

                        AppsRunnerConnector.get(AppsRunner.ak()).v();
                        AppsRunner.this.E();
                        if(AppsRunner.b(AppsRunner.this) == null) {
                            return;
                        }
                    }
                    else {
                        if(v0 == 0) {
                            j.a("-------MODE MANUAL DID UPDATE-----", AppsRunner.this.elapsedTime + " | " + AppsRunner.a(AppsRunner.this) + " | " + ((boolean)v5));
                            if(v5 != 0 && AppsRunner.this.f() == 0) {
                                v5_1 = "----MANUAL倒计时时间到点，\uFFFD?要停止了----";  // MANUAL countdown time is up, \uFFFD? is going to stop
                                j.a(v5_1, "------");
                                return;
                            }

                            if(v5 != 0 && AppsRunner.this.f() == 1) {
                                v5_1 = "----MANUAL正计时时间到点，但不\uFFFD?要停止了----";
                                j.a(v5_1, "------");
                                return;
                            }

                            AppsRunnerConnector.get(AppsRunner.ak()).v();
                            AppsRunner.this.E();
                            if(AppsRunner.b(AppsRunner.this) == null) {
                                return;
                            }

                            AppsRunner.b(AppsRunner.this).e(AppsRunner.this);
                            return;
                        }

                        if(v5 != 0) {
                            v5_1 = "----其他模式时间到点，需要停止了----";  // The other modes are up and need to stop
                            j.a(v5_1, "------");
                            return;
                        }

                        AppsRunnerConnector.get(AppsRunner.ak()).v();
                        AppsRunner.this.E();
                        if(AppsRunner.b(AppsRunner.this) == null) {
                            return;
                        }
                    }

                    AppsRunner.b(AppsRunner.this).e(AppsRunner.this);
                    return;
                }
            }
        };
        this.am = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                if(arg2.what == 0xDE && AppsRunner.b(AppsRunner.this) != null) {
                    AppsRunner.b(AppsRunner.this).f(AppsRunner.this);
                }
            }
        };
    }

    public int A() {
        return this.elapsedTime;
    }

    public int B() {
        return this.ad;
    }

    public int C() {
        int v0 = this.elapsedTime;
        StopWorkoutInfo v1 = AppsRunner.get(AppsRunner.mContext).getCurrentStopWorkoutInfom();
        return v1 == null ? v0 : v1.g();
    }

    public int D() {
        int v0 = this.ad - this.elapsedTime;
        return v0 >= 0 ? v0 : 0;
    }

    public void E() {
        WorkoutData v0 = this.workoutData1;
        if(v0 != null) {
            this.v = v0.getWatts();
            this.x = this.workoutData1.getRPM();
            this.H = (double)this.inclineSupportsHalfDegree(AppsRunner.mContext) ? ((float)this.workoutData1.getIncline()) / 5.0f : ((float)this.workoutData1.getIncline()) / 10.0f;
            this.I = (double)this.workoutData1.getResistanceLevel();
            double v3 = 1000.0;
            if(this.mCurrentUser == 1) {
                this.K = ((double)this.workoutData1.getMPH()) / v3;
                this.J = Conversions.a(this.K);
            }
            else {
                this.J = ((double)this.workoutData1.getMPH()) / v3;
                this.K = Conversions.b(this.J);
            }

            this.L = this.workoutData1.getTotalCalories();
            this.D = this.workoutData1.getTargetHeartRate();
            this.heartRate = this.workoutData1.getHeartRate();
            int v0_1 = this.heartRate;
            if(v0_1 > this.z) {
                this.z = v0_1;
            }

            double v3_1 = this.J;
            if(v3_1 > this.A) {
                this.A = v3_1;
            }

            double v3_2 = this.K;
            if(v3_2 > this.B) {
                this.B = v3_2;
            }

            this.F = this.workoutData1.getAverageHeartRate();
            this.N = (double)(((float)this.workoutData1.getMiles()) / 100.0f);
            this.O = Conversions.mi_to_km(this.N);
            this.P = (double)(((float)this.workoutData1.getMets()) / 10.0f);
            this.E = this.workoutData1.getCaloriesPerHour();
            this.Q = (double)this.workoutData1.getAveragePace();
            this.G = (double)(((float)this.workoutData1.getMiles()) / 100.0f);
            this.R = (double)(((float)this.workoutData1.getNextIncline()) / 100.0f);
            this.M = this.N / ((double)(((float)this.elapsedTime) * 1.0f / 60.0f));
        }

        this.d.put(new Integer(this.elapsedTime), Double.valueOf(this.J));
        this.e.put(new Integer(this.elapsedTime), Double.valueOf(this.K));
        this.f.put(new Integer(this.elapsedTime), Double.valueOf(this.I));
        this.g.put(new Integer(this.elapsedTime), Double.valueOf(this.H));
        this.h.put(new Integer(this.elapsedTime), Integer.valueOf(this.L));
        this.i.put(new Integer(this.elapsedTime), new Double(((double)this.D)));
        this.j.put(new Integer(this.elapsedTime), new Double(((double)this.heartRate)));
        this.k.put(new Integer(this.elapsedTime), new Double(((double)this.F)));
        this.l.put(new Integer(this.elapsedTime), new Double(this.O));
        this.m.put(new Integer(this.elapsedTime), new Double(this.N));
        this.n.put(new Integer(this.elapsedTime), new Double(this.P));
        this.o.put(new Integer(this.elapsedTime), new Double(((double)this.v)));
        this.p.put(new Integer(this.elapsedTime), new Double(((double)this.E)));
        this.q.put(new Integer(this.elapsedTime), new Double(this.R));
        this.r.put(new Integer(this.elapsedTime), new Double(this.Q));
        this.s.put(new Integer(this.elapsedTime), new Double(this.S));
        this.t.put(new Integer(this.elapsedTime), new Double(this.G));
        if(this.elapsedTime == 1) {
            this.d.put(new Integer(0), Double.valueOf(this.J));
            this.e.put(new Integer(0), Double.valueOf(this.K));
            this.f.put(new Integer(0), Double.valueOf(this.I));
            this.g.put(new Integer(0), Double.valueOf(this.H));
            this.h.put(new Integer(0), Integer.valueOf(this.L));
            this.i.put(new Integer(0), new Double(((double)this.D)));
            this.j.put(new Integer(0), new Double(((double)this.heartRate)));
            this.k.put(new Integer(0), new Double(((double)this.F)));
            this.l.put(new Integer(0), new Double(this.O));
            this.m.put(new Integer(0), new Double(this.N));
            this.n.put(new Integer(0), new Double(this.P));
            this.o.put(new Integer(0), new Double(((double)this.v)));
            this.p.put(new Integer(0), new Double(((double)this.E)));
            this.q.put(new Integer(0), new Double(this.R));
            this.r.put(new Integer(0), new Double(this.Q));
            this.s.put(new Integer(0), new Double(this.S));
            this.t.put(new Integer(0), new Double(this.G));
        }
    }

    public void startWorkout() {
        int v0 = this.k(AppsRunner.mContext);
        int v2 = v0 == 11 ? 7 : v0;
        int v0_1 = this.y();
        int v4 = Conversions.a(this.k(AppsRunner.mContext));
        int v5 = Conversions.b(this.k(AppsRunner.mContext));
        int v7 = (int)(this.O() * 10.0);
        int v1 = this.inclineSupportsHalfDegree(AppsRunner.mContext) ? 5 : 10;
        int v8 = (int)(this.P() * ((double)v1));
        int v9 = (int)this.Q();
        int v3 = v0_1 - (v4 + v5);
        int v11 = this.R();
        int v10 = this.S();
        j.a("==AppsRunner==", "===Start Work Out===(" + v2 + "," + v3 + "," + v4 + "," + v5 + ")(" + v7 + "," + v8 + "," + v9 + "," + v10 + "," + v11 + ")");
        AppsRunnerConnector.get(AppsRunner.mContext).startWorkout(v2, v3, v4, v5, this.mCurrentUser, v7, v8, v9, v10, v11);
    }

    public void stopWorkout() {
        j.a("==Stop Workout==", "==Stop Workout==");
        BLEManager.get(AppsRunner.mContext).maybe_send_message1(new byte[]{85, -86, 1, 0, 1, 20, 0, 0, 0, 0});
    }

    public void pauseWorkout() {
        j.a("==Pause Workout==", "==Pause Workout==");
        AppsRunnerConnector.get(AppsRunner.mContext).pauseWorkout();
    }

    public void resumeWorkout() {
        j.a("==Resume Workout==", "==Resume Workout==");
        AppsRunnerConnector.get(AppsRunner.mContext).continueWorkout();
    }

    public double J() {
        try {
            if(this.mCurrentUser == 1) {
                if(this.e != null && (this.e.containsKey(new Integer(this.elapsedTime)))) {
                    return (double)(((Double)this.e.get(new Integer(this.elapsedTime))));
                }
            }
            else if(this.d != null && (this.d.containsKey(new Integer(this.elapsedTime)))) {
                return (double)(((Double)this.d.get(new Integer(this.elapsedTime))));
            }
        }
        catch(Exception v0) {
            v0.printStackTrace();
        }

        return 0.0;
    }

    public Map K() {
        return this.mCurrentUser == 1 ? this.e : this.d;
    }

    public double L() {
        return this.f == null || !this.f.containsKey(new Integer(this.elapsedTime)) ? 0.0 : ((double)(((Double)this.f.get(new Integer(this.elapsedTime)))));
    }

    public double M() {
        return this.g == null || !this.g.containsKey(new Integer(this.elapsedTime)) ? 0.0 : ((double)(((Double)this.g.get(new Integer(this.elapsedTime)))));
    }

    public int N() {
        return this.h == null || !this.h.containsKey(new Integer(this.elapsedTime)) ? 0 : ((int)(((Integer)this.h.get(new Integer(this.elapsedTime)))));
    }

    public double O() {
        if(this.aa == null) {
            return 0.0;
        }

        return this.k(AppsRunner.mContext) == 5 ? d.a(this.aa.i, 1) : d.a(this.aa.k, 1);
    }

    public double P() {
        return this.aa == null ? 0.0 : ((double)this.aa.l);
    }

    public double Q() {
        return this.aa == null ? 0.0 : ((double)this.aa.m);
    }

    public int R() {
        return this.aa == null ? 1 : this.aa.f;
    }

    public int S() {
        if(this.aa == null) {
            return 0;
        }

        return this.k(AppsRunner.mContext) == 5 ? ((int)(d.a(this.aa.j, 1) * 10.0)) : this.aa.g;
    }

    public float T() {
        return (float)(this.A * 1.0);
    }

    public float U() {
        return (float)(this.B * 1.0);
    }

    public int V() {
        return this.z;
    }

    public int W() {
        return apps.database.d.a().e(AppsRunner.mContext, this.getPref_CurrentUserID(AppsRunner.mContext)) == 1 ? 20 : 12;
    }

    public int X() {
        return this.mCurrentUser == 1 ? 20 : 12;
    }

    public int Y() {
        return apps.database.d.a().e(AppsRunner.mContext, this.getPref_CurrentUserID(AppsRunner.mContext));
    }

    public int Z() {
        return 900;
    }

    static int a(AppsRunner arg0) {
        return arg0.ad;
    }

    public static AppsRunner get(Context context) {
        AppsRunner.mContext = context;
        if(AppsRunner.s_instance == null) {
            AppsRunner.s_instance = new AppsRunner();
        }

        return AppsRunner.s_instance;
    }

    public int a(Context arg3, String arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg3, "CURRENT_USER_ID_" + arg4 + "_week", Integer.valueOf(1), 1)));
    }

    public Context a() {
        return this.Y;
    }

    public void resistance(double resistance, int arg4) {
        int _resistance = (int)resistance;
        AppsRunnerConnector.get(AppsRunner.mContext).resistance(_resistance, arg4);
        j.a("调节resistance为：", _resistance + " |");
        this.a("＝＝手动调整(resistance : " + _resistance + ")＝＝");
    }

    public void a(int arg1) {
        this.U = arg1;
    }

    public void setUserData(int arg18, int arg19, int arg20, int arg21, int arg22, int arg23, int arg24, int arg25, int arg26, String arg27, String arg28, String arg29, String arg30, String arg31, String arg32) {
        if(!AppsRunnerConnector.get(AppsRunner.mContext).isConnected()) {
            return;
        }

        AppsRunnerConnector.get(AppsRunner.mContext).setUserData(arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32);
    }

    public void a(int arg3, int arg4, Map arg5) {
        while(true) {
            ++arg3;
            if(arg3 > arg4) {
                return;
            }

            arg5.put(new Integer(arg3), this.b(arg3, arg5));
        }
    }

    public void a(int arg5, Map arg6) {
        ArrayList v0 = new ArrayList();
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < arg6.size(); ++v2) {
            if(v2 > arg5) {
                v0.add(new Integer(v2));
            }
        }

        while(v1 < v0.size()) {
            arg6.remove(v0.get(v1));
            ++v1;
        }
    }

    public void a(Context arg3, int arg4) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID", Integer.valueOf(arg4), 1);
    }

    public void setDeviceWeek(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_week", Integer.valueOf(arg4), 1);
    }

    public void summarySession(Context arg28, AppsArticle appsArticle) {
        Date v17_1;
        String heartRate;
        RecordArticle recordArticle;
        double v13_1;
        double v25;
        double v23;
        double v21;
        double v19;
        float v10;
        int v8;
        int v6;
        String v5;
        String v4;
        int v2;
        ArrayList v0_1;
        Date v1 = null;
        if(appsArticle != null) {
            try {
                if(appsArticle.getDate() != null) {
                    v1 = appsArticle.getDate();
                }

            label_6:
                if(v1 == null) {
                    j.a("===", "==summary session date为空==");
                    return;
                }

                goto label_11;
            }
            catch(Exception v0) {
                goto label_228;
            }
        }

        goto label_6;
        return;
        try {
        label_11:
            j.a("==AppsRunner==", "＝＝开始保summary session＝＝" + v1);
            v0_1 = new ArrayList();
            v2 = (int)d.a(appsArticle.getUserid(), -1);
            v4 = apps.c.f.a(v1, "yyyy-MM-dd HH:mm:ss");
            v5 = apps.c.f.a(v1, "yyyy-MM-dd HH:mm:ss");
            v6 = (int)d.a(appsArticle.getElapsedTime(), 0);
            v8 = (int)d.a(appsArticle.getTotalTime(), 0);
            String v9 = appsArticle.getSummarypace();
            v10 = ((float)(((int)d.a(v9, 0)))) / 100.0f;
            j.a("===", "==summaryPace2 : " + d.a(v9, 0) + "  " + ((float)(((int)d.a(v9, 0)))) / 100.0f + "==");
            j.a("===", "endTime2 : " + v6 + " total : " + v8);
        }
        catch(Exception v0) {
            goto label_228;
        }

        double v11 = 0.0;
        double v13 = v11;
        double v15 = v13;
        double v17 = v15;
        int v9_1 = 0;
        while(true) {
            v19 = 1.0;
            if(v9_1 >= v6) {
                break;
            }

            try {
                v21 = d.a(appsArticle.getSpeed(), v11);
                v23 = d.a(appsArticle.getSpeedkph(), v11);
            }
            catch(Exception v0) {
                goto label_228;
            }

            if(v21 != v11) {
                v15 += v21;
                v13 += v19;
            }

            if(v23 != v11) {
                v17 += v23;
            }

            ++v9_1;
        }

        if(v13 > v11) {
            v25 = v17 * v19 / v13;
            v13_1 = v15 * v19 / v13;
        }
        else {
            v13_1 = v11;
            v25 = v13_1;
        }

        int v3 = 0;
        while(true) {
        label_104:
            if(v3 >= v6) {
                goto label_218;
            }

            int v9_2 = v3 == 0 ? 1 : v3;
            if(v3 == v6 - 1) {
                try {
                    recordArticle = new RecordArticle();
                    recordArticle.setUserid(v2);
                    recordArticle.setTimepoint(v3);
                    recordArticle.setElapsedtime(v6);
                    recordArticle.setTotaltime(v8);
                    recordArticle.setMachinetype(0);
                    recordArticle.setDevicetype(0);
                    recordArticle.setMode(-1);
                    heartRate = appsArticle.getHeartRate();
                }
                catch(Exception v0) {
                    goto label_228;
                }

                v17_1 = v1;
                int v18 = v2;
                try {
                    recordArticle.setHeartrate(d.a(heartRate, v11));
                    recordArticle.setAverageheartrate(d.a(appsArticle.getAverageHeartRate(), v11));
                    recordArticle.setKm(d.a(appsArticle.getKm(), v11));
                    recordArticle.setMiles(d.a(appsArticle.getMiles(), v11));
                    recordArticle.setWatts(d.a(appsArticle.getWatts(), v11));
                    recordArticle.setCalhr(d.a(appsArticle.getCalhr(), v11));
                    recordArticle.setCalories(d.a(appsArticle.getCalories(), 0).intValue());
                    int v7_1 = v3;
                    recordArticle.setSpeed(d.a(appsArticle.getSpeed(), v11));
                    recordArticle.setSpeedkph(d.a(appsArticle.getSpeedkph(), v11));
                    recordArticle.setResistance(d.a(appsArticle.getResistance(), v11));
                    recordArticle.setIncline(d.a(appsArticle.getIncline(), v11));
                    recordArticle.setPace(d.a(appsArticle.getPace(), v11));
                    recordArticle.setAveragepace(d.a(appsArticle.getAveragePace(), v11));
                    recordArticle.setDistance(d.a(appsArticle.getDistance(), v11));
                    recordArticle.setMaximumheartrate(d.a(appsArticle.getMaxHeartRate(), v11));
                    recordArticle.setAveragespeed(d.a(appsArticle.getAverageSpeed(), v11));
                    recordArticle.setMinmiles(d.a(appsArticle.getMinmiles(), v11));
                    recordArticle.setStartdate(v4);
                    recordArticle.setEnddate(v5);
                    recordArticle.setAvgspeed(v13_1);
                    double v1_1 = v25;
                    recordArticle.setAvgspeedkph(v1_1);
                    recordArticle.setSummarypace(((double)v10));
                    j.a("===" + v9_2 + "===", recordArticle + " | " + recordArticle.getCalories());
                    v0_1.add(recordArticle);
                    goto label_211;
                label_207:
                    v17_1 = v1;
                    v18 = v2;
                    v7_1 = v3;
                    v1_1 = v25;
                label_211:
                    v3 = v7_1 + 1;
                    v25 = v1_1;
                    v1 = v17_1;
                    v2 = v18;
                    v11 = 0.0;
                    goto label_104;
                label_218:
                    v17_1 = v1;
                    if(v0_1.size() > 0) {
                        b.a().a(arg28, v0_1);
                    }

                    goto label_239;
                }
                catch(Exception v0) {
                    break;
                }
            }
            else {
                goto label_207;
            }

            goto label_211;
        }

        v1 = v17_1;
    label_228:
        v0.printStackTrace();
        j.a("==AppsRunner==", "＝＝保存summary session出错＝＝" + v1);
    label_239:
        j.a("==AppsRunner==", "＝＝保存summary session完成＝＝");
    }

    public void a(Context arg29, Date arg30) {
        ArrayList v4_3;
        double v26;
        int v23;
        int v22_1;
        int v21;
        int v20_1;
        int v19;
        ArrayList v18_1;
        double v12_2;
        double v2_2;
        double v22;
        AppsRunner v1 = this;
        Date v2 = arg30;
        try {
            j.a("==AppsRunner==", "＝＝\uFFFD?始保\uFFFD?111＝＝" + v2);
            ArrayList v3 = new ArrayList();
            int v4 = this.getPref_CurrentUserID(arg29);
            int v5 = this.l(arg29);
            int v6 = this.n(arg29);
            int v7 = this.k(arg29);
            String v8 = apps.c.f.a(v2, "yyyy-MM-dd HH:mm:ss");
            String v9 = apps.c.f.a(v2, "yyyy-MM-dd HH:mm:ss");
            int v10 = this.z();
            int v11 = this.A();
            if(v1.mCurrentStopWorkoutInfo != null) {
                v11 = v1.mCurrentStopWorkoutInfo.a().getTime();
            }

            int v15 = 0;
            double v16 = 0.0;
            double v18 = 0.0;
            double v20 = 0.0;
            while(true) {
                v22 = 1.0;
                if(v15 >= v11) {
                    break;
                }

                int v12 = v15 == 0 ? 1 : v15;
                ArrayList v14 = v3;
                double v2_1 = 0.0;
                double v24 = d.a(v1.d.get(Integer.valueOf(v12)), v2_1);
                double v12_1 = d.a(v1.e.get(Integer.valueOf(v12)), v2_1);
                if(v24 != v2_1) {
                    v18 += v24;
                    v16 += v22;
                }

                if(v12_1 != v2_1) {
                    v20 += v12_1;
                }

                ++v15;
                v3 = v14;
            }

            ArrayList v14_1 = v3;
            if(v16 > 0.0) {
                v2_2 = v18 * v22 / v16;
                v12_2 = v20 * v22 / v16;
            }
            else {
                v2_2 = 0.0;
                v12_2 = 0.0;
            }

            if(v1.mCurrentStopWorkoutInfo == null) {
                v18_1 = v14_1;
            }
            else {
                v18_1 = v14_1;
                j.a("===", "==summaryPace : " + v1.mCurrentStopWorkoutInfo.b() + "  " + ((float)v1.mCurrentStopWorkoutInfo.b()) / 100.0f + "==");
            }

            j.a("===", "endTime : " + v11 + " total : " + v10);
            int v0_1 = 0;
            while(v0_1 < v11) {
                int v14_2 = v0_1 == 0 ? 1 : v0_1;
                if(v0_1 == v11 - 1) {
                    RecordArticle v15_1 = new RecordArticle();
                    v15_1.setUserid(v4);
                    v15_1.setTimepoint(v0_1);
                    v15_1.setElapsedtime(v11);
                    v15_1.setTotaltime(v10);
                    v15_1.setMachinetype(v5);
                    v15_1.setDevicetype(v6);
                    v15_1.setMode(v7);
                    v19 = v4;
                    v20_1 = v5;
                    v21 = v6;
                    v22_1 = v10;
                    v23 = v11;
                    v15_1.setHeartrate(d.a(v1.j.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setAverageheartrate(((double)v1.F));
                    v15_1.setKm(v1.O);
                    v15_1.setMiles(v1.N);
                    v15_1.setWatts(d.a(v1.o.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setCalhr(d.a(v1.p.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setCalories(v1.L);
                    v15_1.setSpeed(d.a(v1.d.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setSpeedkph(d.a(v1.e.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setResistance(d.a(v1.f.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setIncline(d.a(v1.g.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setPace(d.a(v1.q.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setAveragepace(d.a(v1.r.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setDistance(d.a(v1.t.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setMaximumheartrate(((double)v1.z));
                    v15_1.setAveragespeed(d.a(v1.s.get(Integer.valueOf(v14_2)), 0.0));
                    v15_1.setMinmiles(v1.M);
                    v15_1.setStartdate(v8);
                    v15_1.setEnddate(v9);
                    v15_1.setAvgspeed(v2_2);
                    v15_1.setAvgspeedkph(v12_2);
                    if(v1.mCurrentStopWorkoutInfo == null) {
                    label_241:
                        v26 = v12_2;
                    }
                    else {
                        v15_1.setSummarypace(((double)(((float)v1.mCurrentStopWorkoutInfo.b()) / 100.0f)));
                        WorkoutListMember v4_1 = v1.mCurrentStopWorkoutInfo.a();
                        if(v4_1 == null) {
                            goto label_241;
                        }

                        v15_1.setCalories(v4_1.getCalories());
                        float v10_1 = ((float)v4_1.getDistance()) / 100.0f;
                        int v4_2 = v4_1.getAverageHR();
                        if(apps.database.d.a().e(arg29, AppsRunner.get(arg29).getPref_CurrentUserID(arg29)) == 1) {
                            v26 = v12_2;
                            v15_1.setKm(((double)v10_1));
                            v15_1.setMiles(Conversions.km_to_mi(v10_1));
                        }
                        else {
                            v26 = v12_2;
                            double v10_2 = (double)v10_1;
                            v15_1.setMiles(v10_2);
                            v15_1.setKm(Conversions.mi_to_km(v10_2));
                        }

                        v15_1.setAverageheartrate(((double)v4_2));
                    }

                    j.a("===" + v14_2 + "===", v15_1 + " | " + v15_1.getCalories());
                    v4_3 = v18_1;
                    v4_3.add(v15_1);
                }
                else {
                    v19 = v4;
                    v20_1 = v5;
                    v21 = v6;
                    v22_1 = v10;
                    v23 = v11;
                    v26 = v12_2;
                    v4_3 = v18_1;
                }

                ++v0_1;
                v18_1 = v4_3;
                v4 = v19;
                v5 = v20_1;
                v6 = v21;
                v10 = v22_1;
                v11 = v23;
                v12_2 = v26;
            }

            ArrayList v4_4 = v18_1;
            Context v6_1 = arg29;
            if(v4_4.size() > 0) {
                b.a().a(v6_1, v4_4);
            }
        }
        catch(Exception v0) {
            v0.printStackTrace();
            j.a("==AppsRunner==", "＝＝\uFFFD?始保\uFFFD?111报错＝＝" + arg30);
        }

        j.a("==AppsRunner==", "＝＝保存成功＝＝");
    }

    public void setCurrentStopWorkoutInfo(StopWorkoutInfo arg3) {
        this.mCurrentStopWorkoutInfo = arg3;
        j.a("----setCurrentStopWorkoutInfo---", this.mCurrentStopWorkoutInfo + " |");
    }

    public void setWorkoutData(WorkoutData arg4) {
        f v0;
        j.a("==AppsRunner==", "===WorkoutData== : " + arg4);
        this.workoutData1 = arg4;
        this.T = arg4.getSprintCount();
        int v4 = this.workoutData1.getWorkoutTime();
        if(v4 != 0 && v4 < this.ad) {
            try {
                this.d(v4);
            }
            catch(Exception v4_1) {
                v4_1.printStackTrace();
            }
        }

        int v4_2 = this.workoutData1.setTotalTime();
        if(v4_2 < 0) {
            v4_2 = 0;
        }

        int v4_3 = v4_2;
        if(this.k(AppsRunner.mContext) == 0 && this.f() == 1) {
            v0 = this.aa;
            if(v0 != null) {
                v0.a = v4_3;
            }
        }
        else {
            v0 = this.aa;
            if(v0 != null) {
                v0.a = v4_3;
            }
        }

        this.p();
    }

    public void a(a arg1) {
        this.an = arg1;
    }

    public void a(f arg3) {
        this.aa = arg3;
        j.a("===seting===", this.aa + "");
    }

    public void a(String arg3) {
        Intent v0 = new Intent();
        v0.setAction("NOTIFICATION_DID_LOG");
        v0.putExtra("log", arg3);
        AppsRunner.mContext.sendBroadcast(v0);
    }

    public void a(boolean arg7) {
        Timer v0 = this.ag;
        if(v0 != null) {
            v0.cancel();
        }

        TimerTask v0_1 = this.ah;
        if(v0_1 != null) {
            v0_1.cancel();
        }

        if(!arg7) {
            return;
        }

        this.ag = new Timer();
        this.ah = new TimerTask() {
            @Override
            public void run() {
                AppsRunner.c(AppsRunner.this).sendEmptyMessage(0x6F);
            }
        };
        this.ag.schedule(this.ah, 1000L, 1000L);
    }

    public int aa() {
        int v0 = apps.database.d.a().e(AppsRunner.mContext, this.getPref_CurrentUserID(AppsRunner.mContext));
        if(this.inclineSupportsHalfDegree(AppsRunner.mContext)) {
            return 20;
        }

        return v0 == 1 ? 20 : 15;
    }

    public boolean ab() {
        return false;
    }

    public boolean ac() {
        int v0 = apps.database.d.a().e(AppsRunner.mContext, this.getPref_CurrentUserID(AppsRunner.mContext));
        if(!this.q(AppsRunner.mContext)) {
            return this.p(AppsRunner.mContext) ? v0 == 1 : v0 == 1;
        }

        return true;
    }

    public int ad() {
        return apps.database.d.a().g(AppsRunner.mContext, this.getPref_CurrentUserID(AppsRunner.mContext));
    }

    public String ae() {
        return apps.database.d.a().h(AppsRunner.mContext, this.getPref_CurrentUserID(AppsRunner.mContext));
    }

    public int af() {
        return apps.database.d.a().f(AppsRunner.mContext, this.getPref_CurrentUserID(AppsRunner.mContext));
    }

    public int ag() {
        return apps.database.d.a().d(AppsRunner.mContext, this.getPref_CurrentUserID(AppsRunner.mContext));
    }

    public void selectUserInfo() {
        int v3;
        int v2;
        byte[] v0_1;
        BLEManager v1;
        if(!AppsRunnerConnector.get(AppsRunner.mContext).isConnected()) {
            j.a("===", "==蓝牙是未连接的，不发selectUserInfo==");
            return;
        }

        j.a("===runner 发select user===", "====");
        int v0 = AppsRunner.get(AppsRunner.mContext).getPref_CurrentUserID(AppsRunner.mContext);
        ((AppsApplication)((Activity)AppsRunner.mContext).getApplication()).G = v0;
        if(d.f(AppsRunner.mContext)) {
            v1 = BLEManager.get(AppsRunner.mContext);
            v0_1 = DeviceCommand.selectUserMsg(v0);
            v2 = 3;
            v3 = 3000;
        }
        else {
            v1 = BLEManager.get(AppsRunner.mContext);
            v0_1 = DeviceCommand.selectUserMsg(v0);
            v2 = 1;
            v3 = 1000;
        }

        v1.maybe_send_message2(v0_1, v2, v3);
    }

    public void setUserInfo() {
        String v1_2;
        AppsApplication v0_8;
        String v0_5;
        if(!AppsRunnerConnector.get(AppsRunner.mContext).isConnected()) {
            j.a("===", "==蓝牙是未连接的，不发setUserInfo==");
            return;
        }

        j.a("===runner 发set user===", "====");
        j.a("===", "==蓝牙是连接的，可以发setUserInfo==");
        int v1 = AppsRunner.get(AppsRunner.mContext).getPref_CurrentUserID(AppsRunner.mContext);
        j.a("====USER INFO 1===", v1 + " |");
        UserArticle v0 = apps.database.d.a().b(AppsRunner.mContext, v1 + 1);
        int v2 = v0.getId();
        String v3 = v0.getBirthday();
        String v4 = v0.getWeight();
        String v5 = v0.getNickname();
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

        int v14 = v0.getUnit();
        int v7 = v0.getGender();
        Date v0_1 = apps.c.f.stringToDate(v3, "yyyy/MM/dd");
        if(v0_1 == null) {
            v0_1 = apps.c.f.stringToDate("2000-01-01", "yyyy-MM-dd");
        }

        int v10 = (int)d.a(apps.c.f.a(v0_1, "yyyy"), 1970);
        int v11 = (int)d.a(apps.c.f.a(v0_1, "MM"), 1);
        int v12 = (int)d.a(apps.c.f.a(v0_1, "dd"), 1);
        int v9 = d.a(v0_1);
        int v0_2 = (int)d.a(v4, 0);
        if(v14 == 1) {
            v0_2 = Conversions.kg_to_lb(v0_2);
        }

        int v3_1 = v0_2;
        try {
            int v0_4 = d.a(AppsRunner.mContext, "string", v5);
            if(v0_4 == 0) {
                goto label_130;
            }
            else {
                v0_5 = AppsRunner.mContext.getResources().getString(v0_4);
            }
        }
        catch(Exception v0_3) {
            v0_3.printStackTrace();
            v0_5 = v5;
        }

        goto label_131;
    label_130:
        v0_5 = v5;
    label_131:
        if(d.a(v0_5, "INVITÉ")) {
            v0_5 = "INVITE";
        }

        String v15 = v0_5;
        int v6 = v2 - 1;
        int v8 = v3_1 * 10;
        j.a("----\uFFFD? set user info----", v6 + " |  | " + v5 + " | " + v15 + " |  | " + v14 + " | " + v7 + " | " + v10 + " | " + v11 + " | " + v12 + " | " + v9 + " | " + v8);
        String v0_6 = ShareFitness.get(AppsRunner.mContext).getPrefsMapMyFitnessTokenKey(v1 + "");
        String v2_1 = ShareFitness.get(AppsRunner.mContext).getPrefsMFPTokenId(v1 + "");
        String v3_2 = ShareFitness.get(AppsRunner.mContext).getPrefsFitbitTokenId(v1 + "");
        String v4_1 = ShareFitness.get(AppsRunner.mContext).getPrefsMFP_UserId(v1 + "");
        String v1_1 = ShareFitness.get(AppsRunner.mContext).getPrefsFitbitUserId(v1 + "");
        if(d.strNotEmpty(v0_6)) {
            v0_6 = "0000000000000000000000000000000000000000";
        }

        String v5_1 = v0_6;
        if(d.strNotEmpty(v2_1)) {
            v2_1 = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        }

        if(d.strNotEmpty(v3_2)) {
            v3_2 = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        }

        if(d.strNotEmpty(v4_1)) {
            v4_1 = "000000000000000";
        }

        if(d.strNotEmpty(v1_1)) {
            v1_1 = "000000";
        }

        String v20 = v1_1;
        j.a("==三个token为==", "MMF : " + v5_1 + "  |   MFP:" + v2_1 + "  |   FB:" + v3_2);
        int v13 = apps.b.b.a().c(AppsRunner.mContext);
        try {
            v0_8 = (AppsApplication)((Activity)AppsRunner.mContext).getApplication();
            v0_8.H = v6;
            v0_8.I = v7;
            v0_8.J = v8;
            v0_8.K = v9;
            v0_8.L = v10;
            v0_8.M = v11;
            v0_8.N = v12;
            v0_8.O = v13;
            v0_8.P = v14;
            v0_8.Q = v15;
            v0_8.R = v4_1;
        }
        catch(Exception v0_7) {
            v1_2 = v20;
            v0_7.printStackTrace();
            goto label_279;
        }

        v1_2 = v20;
        v0_8.S = v1_2;
    label_279:
        BLEManager.get(AppsRunner.mContext).maybe_send_message2(DeviceCommand.setUser(Factory.userData(v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v5_1, v2_1, v4_1, v3_2, v1_2)), 2, 5000);
    }

    public boolean aj() {
        int v0 = this.m(AppsRunner.mContext);
        return v0 == 54 || v0 == 55 || v0 == 60 || v0 == 53 || v0 == 59;
    }

    static Context ak() {
        return AppsRunner.mContext;
    }

    private void setCurrentUserIdFromPrefs() {
        this.mCurrentUser = apps.database.d.a().e(AppsRunner.mContext, AppsRunner.get(AppsRunner.mContext).getPref_CurrentUserID(AppsRunner.mContext));
    }

    static a b(AppsRunner arg0) {
        return arg0.an;
    }

    public int b() {
        return this.U;
    }

    public int b(Context arg3, int arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg3, "CURRENT_USER_ID_" + arg4 + "_1weekmissed", Integer.valueOf(0), 1)));
    }

    public int b(Context arg3, String arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg3, "CURRENT_USER_ID_" + arg4 + "_workout", Integer.valueOf(1), 1)));
    }

    public int b(f arg4) {
        int v0 = this.k(AppsRunner.mContext);
        int v1 = arg4.a;
        if(v0 == 2) {
            double v0_1 = (double)(((float)arg4.g) * 1.0f);
            return (int)this.Y() == 1 ? Conversions.mi_to_km(v0_1) : ((double)(((float)arg4.g) * 1.0f));
        }

        if(v0 == 4) {
            return arg4.g;
        }

        return v0 == 9 ? 1200 : v1;
    }

    public Double b(int arg3, Map arg4) {
        if(arg3 < 0) {
            return (double)0.0;
        }

        int v3 = arg3 - 1;
        Integer v0 = new Integer(v3);
        return arg4.containsKey(v0) ? ((Double)arg4.get(v0)) : this.b(v3, arg4);
    }

    public void speed(double speed, int arg7) {
        int speed = (int)Math.round(10.0 * speed);
        int currentUser = this.mCurrentUser == 1 ? 1 : 0;
        AppsRunnerConnector.get(AppsRunner.mContext).speed(currentUser, speed, arg7);
        j.a("调节speed为：", speed + " | " + speed);
        this.a("＝＝手动调整(speed : " + speed + ")＝＝");
    }

    public void b(int arg3, int arg4, Map arg5) {
        while(true) {
            ++arg3;
            if(arg3 > arg4) {
                return;
            }

            arg5.put(new Integer(arg3), this.c(arg3, arg5));
        }
    }

    public void b(Context arg2) {
        this.Y = arg2;
        try {
            ((AppsApplication)((Activity)arg2).getApplication()).a(this.Y);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    public void setDeviceWorkout(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_workout", Integer.valueOf(arg4), 1);
    }

    public void b(Context arg44, Date arg45) {
        ArrayList v2_12;
        int v0_3;
        int v35;
        double v33;
        int v31;
        int v32_1;
        double v12_3;
        double v41;
        double v34;
        ConcurrentHashMap v27;
        ConcurrentHashMap v26;
        AppsRunner v1 = this;
        Date v2 = arg45;
        try {
            int v3 = v1.mCurrentStopWorkoutInfo == null ? 0 : v1.mCurrentStopWorkoutInfo.a().getTime();
            if(v3 > 0 && (v1.ac)) {
                j.a("==AppsRunner==", "＝＝\uFFFD?始保\uFFFD?222＝＝" + v2);
                ConcurrentHashMap v5 = new ConcurrentHashMap();
                v5.putAll(v1.j);
                ConcurrentHashMap v6 = new ConcurrentHashMap();
                v6.putAll(v1.l);
                ConcurrentHashMap v7 = new ConcurrentHashMap();
                v7.putAll(v1.m);
                ConcurrentHashMap v8 = new ConcurrentHashMap();
                v8.putAll(v1.o);
                ConcurrentHashMap v9 = new ConcurrentHashMap();
                v9.putAll(v1.p);
                new ConcurrentHashMap().putAll(v1.h);
                ConcurrentHashMap v10 = new ConcurrentHashMap();
                v10.putAll(v1.d);
                ConcurrentHashMap v11 = new ConcurrentHashMap();
                v11.putAll(v1.e);
                ConcurrentHashMap v12 = new ConcurrentHashMap();
                v12.putAll(v1.f);
                ConcurrentHashMap v13 = new ConcurrentHashMap();
                v13.putAll(v1.g);
                ConcurrentHashMap v14 = new ConcurrentHashMap();
                v14.putAll(v1.q);
                ConcurrentHashMap v15 = new ConcurrentHashMap();
                v15.putAll(v1.r);
                ConcurrentHashMap v4 = new ConcurrentHashMap();
                v4.putAll(v1.t);
                ConcurrentHashMap v0_1 = new ConcurrentHashMap();
                ConcurrentHashMap v17 = v4;
                v0_1.putAll(v1.s);
                ArrayList v18 = new ArrayList();
                int v4_1 = this.getPref_CurrentUserID(arg44);
                ConcurrentHashMap v19 = v0_1;
                int v0_2 = this.l(arg44);
                ConcurrentHashMap v20 = v15;
                int v15_1 = this.n(arg44);
                ConcurrentHashMap v21 = v14;
                int v14_1 = this.k(arg44);
                ConcurrentHashMap v22 = v13;
                String v23 = apps.c.f.a(v2, "yyyy-MM-dd HH:mm:ss");
                String v13_1 = apps.c.f.a(v2, "yyyy-MM-dd HH:mm:ss");
                int v2_1 = this.z();
                String v24 = v13_1;
                if(v1.mCurrentStopWorkoutInfo == null) {
                    v27 = v9;
                    v26 = v12;
                }
                else {
                    v26 = v12;
                    v27 = v9;
                    j.a("===", "==summaryPace0 : " + v1.mCurrentStopWorkoutInfo.b() + "  " + ((float)v1.mCurrentStopWorkoutInfo.b()) / 100.0f + "==");
                }

                j.a("===", "endTime0 : " + v3 + " total : " + v2_1);
                int v9_1 = 0;
                double v28 = 0.0;
                double v30 = 0.0;
                double v32 = 0.0;
                while(true) {
                    v34 = 1.0;
                    if(v9_1 >= v3) {
                        break;
                    }

                    int v12_1 = v9_1 == 0 ? 1 : v9_1;
                    double v38 = (double)(((Double)v10.get(Integer.valueOf(v12_1))));
                    double v12_2 = (double)(((Double)v11.get(Integer.valueOf(v12_1))));
                    double v36 = 0.0;
                    if(v38 != v36) {
                        v30 += v38;
                        v28 += v34;
                    }

                    if(v12_2 != v36) {
                        v32 += v12_2;
                    }

                    ++v9_1;
                }

                double v36_1 = 0.0;
                if(v28 > v36_1) {
                    v41 = v32 * v34 / v28;
                    v12_3 = v30 * v34 / v28;
                }
                else {
                    v12_3 = v36_1;
                    v41 = v12_3;
                }

                int v9_2 = 0;
                while(v9_2 < v3) {
                    int v16 = v9_2 == 0 ? 1 : v9_2;
                    double v29 = v12_3;
                    if(v9_2 == v3 - 1) {
                        RecordArticle v12_4 = new RecordArticle();
                        v12_4.setUserid(v4_1);
                        v12_4.setTimepoint(v9_2);
                        v12_4.setElapsedtime(v3);
                        v12_4.setTotaltime(v2_1);
                        v12_4.setMachinetype(v0_2);
                        v12_4.setDevicetype(v15_1);
                        v12_4.setMode(v14_1);
                        v32_1 = v2_1;
                        v31 = v3;
                        v12_4.setHeartrate(((Double)v5.get(Integer.valueOf(v16))).doubleValue());
                        v12_4.setAverageheartrate(((double)v1.F));
                        v12_4.setKm(((Double)v6.get(Integer.valueOf(v16))).doubleValue());
                        v12_4.setMiles(((Double)v7.get(Integer.valueOf(v16))).doubleValue());
                        v12_4.setWatts(((Double)v8.get(Integer.valueOf(v16))).doubleValue());
                        Double v2_2 = (Double)v27.get(Integer.valueOf(v16));
                        v27 = v27;
                        v12_4.setCalhr(v2_2.doubleValue());
                        v12_4.setCalories(v1.L);
                        v12_4.setSpeed(((Double)v10.get(Integer.valueOf(v16))).doubleValue());
                        v12_4.setSpeedkph(((Double)v11.get(Integer.valueOf(v16))).doubleValue());
                        Double v2_3 = (Double)v26.get(Integer.valueOf(v16));
                        v26 = v26;
                        v12_4.setResistance(v2_3.doubleValue());
                        Double v2_4 = (Double)v22.get(Integer.valueOf(v16));
                        v22 = v22;
                        v12_4.setIncline(v2_4.doubleValue());
                        Double v2_5 = (Double)v21.get(Integer.valueOf(v16));
                        v21 = v21;
                        v12_4.setPace(v2_5.doubleValue());
                        Double v2_6 = (Double)v20.get(Integer.valueOf(v16));
                        v20 = v20;
                        v12_4.setAveragepace(v2_6.doubleValue());
                        Double v2_7 = (Double)v17.get(Integer.valueOf(v16));
                        v17 = v17;
                        v12_4.setDistance(v2_7.doubleValue());
                        v12_4.setMaximumheartrate(((double)v1.z));
                        Double v2_8 = (Double)v19.get(Integer.valueOf(v16));
                        v19 = v19;
                        v12_4.setAveragespeed(v2_8.doubleValue());
                        v12_4.setMinmiles(v1.M);
                        v12_4.setStartdate(v23);
                        v12_4.setEnddate(v24);
                        v23 = v23;
                        v24 = v24;
                        v12_4.setAvgspeed(v29);
                        v29 = v29;
                        double v2_9 = v41;
                        v12_4.setAvgspeedkph(v2_9);
                        if(v1.mCurrentStopWorkoutInfo == null) {
                            v35 = v0_2;
                            v33 = v2_9;
                        label_336:
                            v0_3 = v14_1;
                        }
                        else {
                            v33 = v2_9;
                            v12_4.setSummarypace(((double)(((float)v1.mCurrentStopWorkoutInfo.b()) / 100.0f)));
                            WorkoutListMember v2_10 = v1.mCurrentStopWorkoutInfo.a();
                            if(v2_10 != null) {
                                v12_4.setCalories(v2_10.getCalories());
                                float v3_1 = ((float)v2_10.getDistance()) / 100.0f;
                                int v2_11 = v2_10.getAverageHR();
                                v35 = v0_2;
                                if(apps.database.d.a().e(arg44, AppsRunner.get(arg44).getPref_CurrentUserID(arg44)) == 1) {
                                    v0_3 = v14_1;
                                    v12_4.setKm(((double)v3_1));
                                    v12_4.setMiles(Conversions.km_to_mi(v3_1));
                                }
                                else {
                                    v0_3 = v14_1;
                                    double v13_2 = (double)v3_1;
                                    v12_4.setMiles(v13_2);
                                    v12_4.setKm(Conversions.mi_to_km(v13_2));
                                }

                                v12_4.setAverageheartrate(((double)v2_11));
                                goto label_338;
                            }

                            v35 = v0_2;
                            goto label_336;
                        }

                    label_338:
                        j.a("===" + v16 + "===", v12_4 + " | " + v12_4.getCalories());
                        v2_12 = v18;
                        v2_12.add(v12_4);
                    }
                    else {
                        v35 = v0_2;
                        v32_1 = v2_1;
                        v31 = v3;
                        v0_3 = v14_1;
                        v2_12 = v18;
                        v33 = v41;
                    }

                    ++v9_2;
                    v14_1 = v0_3;
                    v18 = v2_12;
                    v12_3 = v29;
                    v3 = v31;
                    v2_1 = v32_1;
                    v41 = v33;
                    v0_2 = v35;
                    v1 = this;
                }

                ArrayList v2_13 = v18;
                Context v1_1 = arg44;
                if(v2_13.size() > 0) {
                    b.a().a(v1_1, v2_13);
                    this.s();
                }

                goto label_397;
            }

            return;
        }
        catch(Exception v0) {
            v0.printStackTrace();
            j.a("==AppsRunner==", "＝＝\uFFFD?始保\uFFFD?222报错＝＝" + arg45);
        }

    label_397:
        j.a("==AppsRunner==", "＝＝保存成功222＝＝");
    }

    public void b(boolean arg7) {
        Timer v0 = this.ai;
        if(v0 != null) {
            v0.cancel();
        }

        TimerTask v0_1 = this.aj;
        if(v0_1 != null) {
            v0_1.cancel();
        }

        if(!arg7) {
            return;
        }

        this.ai = new Timer();
        this.aj = new TimerTask() {
            @Override
            public void run() {
                AppsRunner.d(AppsRunner.this).sendEmptyMessage(0xDE);
            }
        };
        this.ai.schedule(this.aj, 0L, 1000L);
    }

    public boolean b(int arg8) {
        int v0 = this.k(AppsRunner.mContext);
        int v1 = this.f();
        int v2 = 1;
        if(arg8 < 0) {
            if(v0 != 0) {
                j.a("---NOT MANUAL----", this.ae + " | " + arg8 + " | " + this.elapsedTime + " | ");
                if(this.ae <= arg8 || this.elapsedTime >= this.ae + arg8 || this.ae + arg8 < 900) {
                    return false;
                }
            }
            else if(v1 == 1) {
                j.a("---COUNT UP----", this.ae + " | " + arg8 + " | " + this.elapsedTime + " | ");
                if(this.ae <= arg8 || this.elapsedTime >= this.ae + arg8 || this.ae + arg8 < 60) {
                    return false;
                }
            }
            else {
                j.a("---COUNT DOWN----", this.ae + " | " + arg8 + " | " + this.elapsedTime + " | ");
                if(this.ae <= arg8 || this.elapsedTime >= this.ae + arg8 || this.ae + arg8 < 300) {
                    return false;
                }
            }
        }

        if(v0 == 0) {
            if(v1 == 1) {
                int v8 = arg8 + this.ae;
                if(v8 > 5940) {
                    v8 = 5940;
                    v2 = 0;
                }
                else if(v8 < 0) {
                    v8 = 0;
                    v2 = 0;
                }

                this.aa.a = v8;
                this.p();
                if(v2 != 0) {
                    a v8_1 = this.an;
                    if(v8_1 != null) {
                        v8_1.e(this);
                    }
                }

                return false;
            }

            int v0_1 = this.ae + arg8;
            return v0_1 <= 5940 && v0_1 >= 0;
        }

        if(v0 != 6 && v0 != 1 && v0 != 9 && v0 != 8 && v0 != 3) {
            return true;
        }

        int v0_2 = this.ae + arg8;
        return v0_2 <= 5940 && v0_2 >= 0;
    }

    static Handler c(AppsRunner arg0) {
        return arg0.al;
    }

    public int c(int arg3) {
        int v0 = this.ae + arg3;
        return this.k(AppsRunner.mContext) != 0 || v0 <= 5940 ? v0 : 5940;
    }

    public int getPref_CurrentUserID(Context arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg4, "CURRENT_USER_ID", Integer.valueOf(0), 1)));
    }

    public int getPref_CurrentUserID_1weekmissed_time(Context arg3, int arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg3, "CURRENT_USER_ID_" + arg4 + "_1weekmissed_time", Integer.valueOf(0), 1)));
    }

    public int getPref_CurrentUserID_walkSpeed(Context arg5, String arg6) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg5, "CURRENT_USER_ID_" + arg6 + "_walkSpeed", Integer.valueOf(AppsRunner.get(arg5).Y() == 1 ? 0x20 : 20), 1)));
    }

    public f c() {
        return this.aa;
    }

    public Integer c(int arg3, Map arg4) {
        if(arg3 < 0) {
            return (int)0;
        }

        int v3 = arg3 - 1;
        Integer v0 = new Integer(v3);
        return arg4.containsKey(v0) ? ((Integer)arg4.get(v0)) : this.c(v3, arg4);
    }

    public void incline(double incline, int arg6) {
        int incline_increment = (int)(((double)this.inclineSupportsHalfDegree(AppsRunner.mContext) ? 5 : 10) * incline);
        AppsRunnerConnector.get(AppsRunner.mContext).incline(incline_increment, arg6);
        j.a("调节incline为：", incline_increment + " | " + incline);  // The adjustment incline is:
        this.a("＝＝手动调整(incline : " + incline_increment + ")＝＝");  // Manual adjustment (incline
    }

    public void setWalkSpeed(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_walkSpeed", Integer.valueOf(arg4), 1);
    }

    public void c(boolean arg1) {
        this.ac = arg1;
    }

    static Handler d(AppsRunner arg0) {
        return arg0.am;
    }

    public int d() {
        return (int)(((float)(220 - this.aa.b)) * 0.75f);
    }

    public int _week(Context context) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(context, "CURRENT_USER_ID_" + this.getPref_CurrentUserID(context) + "_week", Integer.valueOf(1), 1)));
    }

    public int _2weekmissed(Context arg3, int arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg3, "CURRENT_USER_ID_" + arg4 + "_2weekmissed", Integer.valueOf(0), 1)));
    }

    public int _jogSpeed(Context arg5, String arg6) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg5, "CURRENT_USER_ID_" + arg6 + "_jogSpeed", Integer.valueOf(AppsRunner.get(arg5).Y() == 1 ? 56 : 35), 1)));
    }

    public void d(int arg4) {
        if(this.elapsedTime != arg4) {
            j.a("====时间上不\uFFFD?致，\uFFFD?修正(APP: %d != 设备: %d)=====", this.elapsedTime + "->" + arg4);
            int v0 = this.elapsedTime;
            if(v0 > arg4) {
                this.a(arg4, this.f);
                this.a(arg4, this.d);
                this.a(arg4, this.e);
                this.a(arg4, this.g);
                this.a(arg4, this.h);
                this.a(arg4, this.i);
                this.a(arg4, this.j);
                this.a(arg4, this.k);
                this.a(arg4, this.l);
                this.a(arg4, this.m);
                this.a(arg4, this.n);
                this.a(arg4, this.o);
                this.a(arg4, this.p);
                this.a(arg4, this.q);
                this.a(arg4, this.r);
                this.a(arg4, this.s);
                this.a(arg4, this.t);
            }
            else {
                this.a(v0, arg4, this.f);
                this.a(v0, arg4, this.d);
                this.a(v0, arg4, this.e);
                this.a(v0, arg4, this.g);
                this.b(v0, arg4, this.h);
                this.a(v0, arg4, this.i);
                this.a(v0, arg4, this.j);
                this.a(v0, arg4, this.k);
                this.a(v0, arg4, this.l);
                this.a(v0, arg4, this.m);
                this.a(v0, arg4, this.n);
                this.a(v0, arg4, this.o);
                this.a(v0, arg4, this.p);
                this.a(v0, arg4, this.q);
                this.a(v0, arg4, this.r);
                this.a(v0, arg4, this.s);
                this.a(v0, arg4, this.t);
            }

            this.elapsedTime = arg4;
        }
    }

    public void setJogSpeed(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_jogSpeed", Integer.valueOf(arg4), 1);
    }

    public int getTargetHR() {
        return this.aa == null ? 0 : this.aa.c;
    }

    public int _workout(Context arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg4, "CURRENT_USER_ID_" + this.getPref_CurrentUserID(arg4) + "_workout", Integer.valueOf(1), 1)));
    }

    public int e(Context arg3, int arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg3, "CURRENT_USER_ID_" + arg4 + "_2weekmissed_time", Integer.valueOf(0), 1)));
    }

    public int e(Context arg3, String arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg3, "CURRENT_USER_ID_" + arg4 + "_resetCount", Integer.valueOf(0), 1)));
    }

    public void e(int arg13) {
        int v0 = this.k(AppsRunner.mContext);
        int v4 = Conversions.a(this.k(AppsRunner.mContext));
        int v5 = Conversions.b(this.k(AppsRunner.mContext));
        int v7 = (int)(this.O() * 10.0);
        double v0_1 = this.P();
        int v3 = this.inclineSupportsHalfDegree(AppsRunner.mContext) ? 5 : 10;
        int v9 = (int)this.Q();
        int v11 = this.R();
        int v10 = this.S();
        j.a("==AppsRunner==", "===Change Work Out===(" + arg13 + "," + v4 + "," + v5 + ")");
        AppsRunnerConnector.get(AppsRunner.mContext).changeWorkout(v0 == 11 ? 7 : v0, arg13, v4, v5, this.mCurrentUser, v7, ((int)(v0_1 * ((double)v3))), v9, v10, v11);
        AppsRunnerConnector.get(AppsRunner.mContext).v();
        this.E();
    }

    public void setDeviceResetCount(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_resetCount", Integer.valueOf(arg4), 1);
    }

    public int f() {
        return this.aa == null ? 0 : this.aa.H;
    }

    public int shouldStopWhenChangeRunMode(int arg4) {
        j.a("===shouldStopWhenChangeRunMode===", arg4 + "  |  " + this.k(AppsRunner.mContext) + "  |  " + this.ac);
        return 0;
    }

    public int f(Context arg6) {
        int v1 = AppsRunner.get(arg6).Y() == 1 ? 0x20 : 20;
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg6, "CURRENT_USER_ID_" + this.getPref_CurrentUserID(arg6) + "_walkSpeed", Integer.valueOf(v1), 1)));
    }

    public int f(Context arg3, String arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg3, "CURRENT_USER_ID_" + arg4 + "_customProgramCRC_device", Integer.valueOf(0), 1)));
    }

    public void f(Context arg3, int arg4) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "MODE", Integer.valueOf(arg4), 1);
    }

    public void f(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_walkSpeed_app_start", Integer.valueOf(arg4), 1);
    }

    public int g(Context arg6) {
        int v1 = AppsRunner.get(arg6).Y() == 1 ? 56 : 35;
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg6, "CURRENT_USER_ID_" + this.getPref_CurrentUserID(arg6) + "_jogSpeed", Integer.valueOf(v1), 1)));
    }

    public int g(Context arg3, String arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg3, "CURRENT_USER_ID_" + arg4 + "_customHRProgramCRC_device", Integer.valueOf(0), 1)));
    }

    public void g(int arg2) {
        if(!AppsRunnerConnector.get(AppsRunner.mContext).isConnected()) {
            return;
        }

        AppsRunnerConnector.get(AppsRunner.mContext).deleteUserData(arg2);
    }

    public void g(Context arg3, int arg4) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "MACHINE_TYPE", Integer.valueOf(arg4), 1);
    }

    public void g(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_jogSpeed_app_start", Integer.valueOf(arg4), 1);
    }

    public boolean g() {
        return this.ac;
    }

    public int h(Context arg6) {
        int v1 = AppsRunner.get(arg6).Y() == 1 ? 0x20 : 20;
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg6, "CURRENT_USER_ID_" + this.getPref_CurrentUserID(arg6) + "_walkSpeed_app_start", Integer.valueOf(v1), 1)));
    }

    public void h() {
        this.ac = true;
        this.a(false);
        a v0 = this.an;
        if(v0 != null) {
            v0.c(this);
        }
    }

    public void selectUserInfo(int arg4) {
        if(!AppsRunnerConnector.get(AppsRunner.mContext).isConnected()) {
            j.a("===", "==蓝牙是未连接的，不发selectUserInfo==");  // Bluetooth is not connected, selectUserInfo is not sent
            return;
        }

        j.a("===runner 发select user===", "====");
        (AppsRunner.mContext instanceof AppsApplication) ? ((AppsApplication)AppsRunner.mContext) : ((AppsApplication)((Activity)AppsRunner.mContext).getApplication()).G = arg4;
        BLEManager.get(AppsRunner.mContext).maybe_send_message2(DeviceCommand.selectUserMsg(arg4), 2, 1000);
    }

    public void h(Context arg3, int arg4) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "MACHINE_TYPE2", Integer.valueOf(arg4), 1);
    }

    public void h(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_week_device", Integer.valueOf(arg4), 1);
    }

    public int i(Context arg6) {
        int v1 = AppsRunner.get(arg6).Y() == 1 ? 56 : 35;
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg6, "CURRENT_USER_ID_" + this.getPref_CurrentUserID(arg6) + "_jogSpeed_app_start", Integer.valueOf(v1), 1)));
    }

    public void i() {
        if(this.ad == 0) {
            return;
        }

        this.ac = true;
        this.a(false);
    }

    public void i(Context arg3, int arg4) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "MACHINE", Integer.valueOf(arg4), 1);
    }

    public void i(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_workout_device", Integer.valueOf(arg4), 1);
    }

    public int j(Context arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg4, "CURRENT_USER_ID_" + this.getPref_CurrentUserID(arg4) + "_resetCount", Integer.valueOf(0), 1)));
    }

    public void justResumeRun() {
        j.a("====恢复跑===", "==justResumeRun===" + this.elapsedTime);
        if(this.ad == 0) {
            return;
        }

        this.ac = false;
        this.p();
        this.a(true);
    }

    public void j(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_walkSpeed_device", Integer.valueOf(arg4), 1);
    }

    public int k(Context arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg4, "MODE", Integer.valueOf(0), 1)));
    }

    public void resumeRun() {
        j.a("====恢复跑===", "==resumeRun===" + this.elapsedTime);
        this.setCurrentUserIdFromPrefs();
        this.ac = false;
        this.p();
        this.a(true);
        a v0 = this.an;
        if(v0 != null) {
            v0.b(this);
        }
    }

    public void k(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_jogSpeed_device", Integer.valueOf(arg4), 1);
    }

    public int l(Context arg4) {
        int v4 = (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg4, "MACHINE_TYPE", Integer.valueOf(3), 1)));
        return v4 == 0 ? 6 : v4;
    }

    public void resumeRun2() {
        j.a("====恢复跑===", "==resumeRun===" + this.elapsedTime);
        this.setCurrentUserIdFromPrefs();
        this.ac = false;
        this.p();
        this.a(true);
        a v0 = this.an;
        if(v0 != null) {
            v0.b(this);
        }

        a v0_1 = this.an;
        if(v0_1 != null) {
            v0_1.f(this);
        }

        a v0_2 = this.an;
        if(v0_2 != null) {
            v0_2.e(this);
        }
    }

    public void l(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_resetCount_device", Integer.valueOf(arg4), 1);
    }

    public int m(Context arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg4, "MACHINE_TYPE2", Integer.valueOf(0), 1)));
    }

    public StopWorkoutInfo getCurrentStopWorkoutInfom() {
        j.a("----getCurrentStopWorkoutInfo---", this.mCurrentStopWorkoutInfo + " |");
        return this.mCurrentStopWorkoutInfo;
    }

    public void m(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_customProgramCRC_device", Integer.valueOf(arg4), 1);
    }

    public int n(Context arg4) {
        return (int)(((Integer)ContextSharedPreferences.SharedPreferences(arg4, "MACHINE", Integer.valueOf(5), 1)));
    }

    public void startRun() {
        this.mCurrentStopWorkoutInfo = null;
        j.a("----startRun---", this.mCurrentStopWorkoutInfo + " |");
        this.runDate = new Date();
        this.setCurrentUserIdFromPrefs();
        this.ac = false;
        this.p();
        this.b(true);
        this.a(true);
        a v0 = this.an;
        if(v0 != null) {
            v0.a(this);
        }
    }

    public void n(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_customHRProgramCRC_device", Integer.valueOf(arg4), 1);
    }

    public Date getRunDate() {
        return this.runDate;
    }

    public void o(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_1weekmissed", Integer.valueOf(arg4), 1);
    }

    public boolean inclineSupportsHalfDegree(Context ctx) {
        return this.l(ctx) == 5;
    }

    public void p() {
        this.ad = this.y();
        int v0 = Conversions.a(this.k(AppsRunner.mContext));
        int v1 = Conversions.b(this.k(AppsRunner.mContext));
        this.ae = this.ad - v0 - v1;
        this.f();
        if(this.k(AppsRunner.mContext) == 0 && this.ad == 0) {
            this.ad = 5940;
        }
    }

    public void p(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_1weekmissed_time", Integer.valueOf(arg4), 1);
    }

    public boolean p(Context arg2) {
        return this.l(arg2) == 1;
    }

    public void q() {
        this.stopWorkout();
    }

    public void q(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_2weekmissed", Integer.valueOf(arg4), 1);
    }

    public boolean q(Context arg2) {
        return this.l(arg2) == 2;
    }

    public void r() {
        this.ac = false;
        this.b(false);
        this.a(false);
        a v0 = this.an;
        if(v0 != null) {
            v0.d(this);
        }
    }

    public void r(Context arg3, int arg4, int arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(arg3, "CURRENT_USER_ID_" + arg5 + "_2weekmissed_time", Integer.valueOf(arg4), 1);
    }

    public boolean r(Context arg2) {
        int v2 = this.m(arg2);
        return v2 == 54 || v2 == 55 || v2 == 60 || v2 == 53 || v2 == 59;
    }

    public void s() {
        this.ac = false;
        this.b(false);
        this.a(false);
        this.setCurrentUserIdFromPrefs();
        this.clear();
    }

    public void clear() {
        this.setCurrentUserIdFromPrefs();
        j.a("====clear===", "==clear===");
        this.ac = false;
        this.elapsedTime = 0;
        this.ad = 0;
        f v1 = this.aa;
        if(v1 != null) {
            v1.a();
        }

        this.g.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.h.clear();
        this.j.clear();
        this.heartRate = 0;
        this.v = 0;
        this.u = 0;
        this.x = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0.0;
        this.M = 0.0;
        this.N = 0.0;
        this.O = 0.0;
        this.P = 0.0;
        this.Q = 0.0;
        this.R = 0.0;
        this.S = 0.0;
        this.z = 0;
        this.B = 0.0;
        this.A = 0.0;
        double v7 = Conversions.b(0.5);
        this.H = 0.0;
        this.J = 0.5;
        this.K = v7;
        this.I = 1.0;
        this.L = 0;
        this.w = 0.0;
        this.C = 0;
        WorkoutData v0 = this.workoutData1;
        if(v0 != null) {
            v0.clear();
            this.workoutData1 = null;
        }

        j.a("====清空数据====", "===" + this.O + " | " + this.N + "===");  // Clear data
    }

    public void u() {
    }

    public void v() {
        this.clear();
        this.securitySwitch = 0;
        AppsRunner.s_instance = null;
    }

    public double w() {
        return this.Y() == 1 ? this.O * 1000.0 : this.N * 1000.0;
    }

    public int x() {
        return this.L;
    }

    public int y() {
        if(this.aa == null) {
            return 0;
        }

        this.k(AppsRunner.mContext);
        return this.aa.a;
    }

    public int z() {
        return this.ad;
    }
}
