package com.xtremeprog.shell.treadmillv2.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apps.c.d;
import apps.c.k;
import apps.c.n;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
public class AppsRunningView extends RelativeLayout implements a {
    private LinearLayout inclineTipTitleLayout;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private LinearLayout inclineCursorLayout;
    private LinearLayout speedCursorLayout;
    private LinearLayout N;
    private TextView inclineCursorTextView;
    private TextView speedCursorTextView;
    private TextView Q;
    private int R;
    private int S;
    private int T;
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public Map h;
    public Map i;
    public Map j;
    public Map k;
    public Map l;
    public int m;
    private Context n;
    private int o;
    private int p;
    private int q;
    private int r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private AppsRunningTimeView w;
    private AppsRunningDisplayView x;
    private RelativeLayout y;
    private LinearLayout speedTipTitleLayoutz;

    public AppsRunningView(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.a = false;
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = 0;
        this.a(arg3, arg4);
    }

    public AppsRunningView(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4);
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.a = false;
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = 0;
        this.a(arg2, arg3);
    }

    private void a(Context arg8, AttributeSet arg9) {
        float v0_1;
        int v4_1;
        int v4;
        Context v2;
        this.n = arg8;
        boolean v0 = d.h(this.n);
        boolean v1 = d.b();
        int v3 = 0;
        this.o = k.a(this.n, ((float)(v0 ? 170 : 0 + 0xFA)));
        if(!v0 && !v1) {
            v2 = this.n;
            v4 = v0 ? 200 : 0;
        }
        else {
            v2 = this.n;
            if(v0) {
                v4 = 230;
            }
            else {
                v4 = v1 ? 80 : 0;
            }
        }

        this.p = k.a(v2, ((float)(v4 + 550)));
        this.T = k.a(arg8, 4.0f);
        this.R = k.a(arg8, 3.0f);
        this.S = k.a(arg8, 2.0f);
        LayoutInflater v2_1 = LayoutInflater.from(arg8);
        if(v0) {
            v4_1 = 0x7F0900B8;  // layout:view_running_galaxytab10
        }
        else {
            v4_1 = v1 ? 0x7F0900B9 : 0x7F0900B7;  // layout:view_running_nexus9
        }

        View v2_2 = v2_1.inflate(v4_1, null);
        this.addView(v2_2, new RelativeLayout.LayoutParams(-2, -2));
        v2_2.setBackgroundDrawable(null);
        this.y = n.a().b(v2_2, 0x7F07019A);  // id:runningDisplayContainerView
        this.x = (AppsRunningDisplayView)n.a().d(v2_2, 0x7F07019B);  // id:runningDisplayView
        this.w = (AppsRunningTimeView)n.a().d(v2_2, 0x7F07019C);  // id:runningTimeView
        this.t = n.a().c(v2_2, 0x7F070302);  // id:zeroTimeTextView
        this.s = n.a().c(v2_2, 0x7F070298);  // id:totalTimeTextView
        this.v = n.a().c(v2_2, 0x7F07008F);  // id:displayViewTimeTipTextView
        this.u = n.a().c(v2_2, 0x7F07004D);  // id:currentTimeTextView
        this.inclineCursorLayout = n.a().a(v2_2, 0x7F0700D5);  // id:inclineCursorLayout
        this.speedCursorLayout = n.a().a(v2_2, 0x7F070240);  // id:speedCursorLayout
        this.N = n.a().a(v2_2, 0x7F07003A);  // id:caloriesCursorLayout
        this.inclineCursorTextView = n.a().c(v2_2, 0x7F0700D6);  // id:inclineCursorTextView
        this.speedCursorTextView = n.a().c(v2_2, 0x7F070241);  // id:speedCursorTextView
        this.Q = n.a().c(v2_2, 0x7F07003B);  // id:caloriesCursorTextView
        this.speedTipTitleLayoutz = n.a().a(v2_2, 0x7F070243);  // id:speedTipTitleLayout
        this.inclineTipTitleLayout = n.a().a(v2_2, 0x7F0700D8);  // id:inclineTipTitleLayout
        this.B = n.a().a(v2_2, 0x7F07018F);  // id:resistanceTipTitleLayout
        this.D = n.a().a(v2_2, 0x7F07003E);  // id:caloriesTipTitleLayout
        this.C = n.a().a(v2_2, 0x7F0700C0);  // id:heartRateTipTitleLayout
        this.E = n.a().a(v2_2, 0x7F070288);  // id:timeTipTitleLayout
        this.F = n.a().c(v2_2, 0x7F0700D9);  // id:inclineTipTitleTextView
        this.G = n.a().c(v2_2, 0x7F070190);  // id:resistanceTipTitleTextView
        this.H = n.a().c(v2_2, 0x7F07003F);  // id:caloriesTipTitleTextView
        this.I = n.a().c(v2_2, 0x7F0700D1);  // id:hrTipTitleTextView
        this.J = n.a().c(v2_2, 0x7F070289);  // id:timeTipTitleTextView
        this.K = n.a().c(v2_2, 0x7F070244);  // id:speedTitleTextView
        this.F.setSingleLine(true);
        this.G.setSingleLine(true);
        this.I.setSingleLine(true);
        this.J.setSingleLine(true);
        this.K.setSingleLine(true);
        this.F.setSingleLine(true);
        this.F.setSingleLine(true);
        LinearLayout.LayoutParams v2_3 = (LinearLayout.LayoutParams)this.y.getLayoutParams();
        RelativeLayout.LayoutParams v5 = (RelativeLayout.LayoutParams)this.x.getLayoutParams();
        if(v0) {
            v0_1 = 850.0f;
            goto label_189;
        }
        else if(v1) {
            v0_1 = 670.0f;
        label_189:
            v2_3.width = k.a(arg8, v0_1);
            v5.width = k.a(arg8, v0_1);
        }

        this.y.setLayoutParams(v2_3);
        this.x.setLayoutParams(v5);
        int v8 = arg9 == null ? 0 : arg8.obtainStyledAttributes(arg9, com.xtremeprog.shell.treadmillv2.g.a.isHistory).getInt(0, 0);
        AppsRunningDisplayView v9 = this.x;
        if(v8 == 1) {
            v3 = 1;
        }

        v9.setIsHistory(((boolean)v3));
        this.x.setListener(this);
    }

    public void a() {
        this.N.setVisibility(8);
        this.speedCursorLayout.setVisibility(8);
        this.inclineCursorLayout.setVisibility(8);
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsRunningDisplayView$a
    public void a(float arg1, int arg2, double arg3, int arg5) {
        if(AppsRunner.get(this.n).inclineSupportsHalfDegree(this.n)) {
            String v1 = d.doubleToStr(arg3, 1);
            this.inclineCursorTextView.setText(v1);
            RelativeLayout.LayoutParams v1_1 = (RelativeLayout.LayoutParams)this.inclineCursorLayout.getLayoutParams();
            v1_1.height = arg2 + k.a(this.n, 16.0f) / 2;
            this.inclineCursorLayout.setLayoutParams(v1_1);
        }
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsRunningDisplayView$a
    public void a(float arg1, int arg2, int arg3, int arg4) {
        String v1 = d.doubleToStr(arg3, 0);
        this.Q.setText(v1);
        RelativeLayout.LayoutParams v1_1 = (RelativeLayout.LayoutParams)this.N.getLayoutParams();
        v1_1.height = arg2 + k.a(this.n, 16.0f) / 2;
        this.N.setLayoutParams(v1_1);
    }

    public void b() {
        this.F.setText(this.n.getResources().getText(0x7F0B00D2));  // string:STR_TITLE_INCLINE "Incline"
        this.G.setText(this.n.getResources().getText(0x7F0B00D6));  // string:STR_TITLE_RESISTENCE "Resistance"
        this.H.setText(this.n.getResources().getText(0x7F0B001F));  // string:STR_COLORIES "Calories"
        this.I.setText(this.n.getResources().getText(0x7F0B006A));  // string:STR_HEART_RATE "Heart Rate"
        this.J.setText(this.n.getResources().getText(0x7F0B00D9));  // string:STR_TITLE_TIME "Time"
        this.K.setText(this.n.getResources().getText(0x7F0B00D8));  // string:STR_TITLE_SPEED "Speed"
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsRunningDisplayView$a
    public void setSpeedCursorText(float arg2, int arg3, double speed, int arg6) {
        AppsRunner.get(this.n).inclineSupportsHalfDegree(this.n);
        String speedStr = d.doubleToStr(speed, 1);
        this.speedCursorTextView.setText(speedStr);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.speedCursorLayout.getLayoutParams();
        layoutParams.height = arg3 + k.a(this.n, 16.0f) / 2;
        this.speedCursorLayout.setLayoutParams(layoutParams);
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsRunningDisplayView$a
    public void b(float arg1, int arg2, int arg3, int arg4) {
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsRunningDisplayView$a
    public void c(float arg1, int arg2, double arg3, int arg5) {
        if(!AppsRunner.get(this.n).inclineSupportsHalfDegree(this.n)) {
            String v1 = d.doubleToStr(arg3, 1);
            this.inclineCursorTextView.setText(v1);
            RelativeLayout.LayoutParams v1_1 = (RelativeLayout.LayoutParams)this.inclineCursorLayout.getLayoutParams();
            v1_1.height = arg2 + k.a(this.n, 16.0f) / 2;
            this.inclineCursorLayout.setLayoutParams(v1_1);
            this.inclineCursorLayout.setBackgroundColor(Color.parseColor("#ff0000"));
        }
    }

    @Override  // android.view.View
    public void invalidate() {
        super.invalidate();
        this.x.invalidate();
    }

    public void setCurrentTime(int arg3) {
        this.r = arg3;
        String v3 = d.a(arg3);
        this.u.setText(v3);
        this.w.a(this.r, this.q);
        this.invalidate();
        int v3_1 = this.q;
        if(v3_1 == 0) {
            return;
        }

        int v3_2 = (int)(((float)this.p) * (((float)this.r) * 1.0f / ((float)v3_1)));
        RelativeLayout.LayoutParams v0 = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
        v0.leftMargin = v3_2;
        this.u.setLayoutParams(v0);
    }

    public void setExtraMaxHRDraw(int arg2) {
        this.m = arg2;
        this.x.setExtraMaxHRDraw(this.m);
    }

    public void setFateCaloriesDataSource(Map arg2) {
        this.l = arg2;
        this.x.l = this.l;
    }

    public void setFateHeartRateDataSource(Map arg2) {
        this.k = arg2;
        this.x.k = this.k;
    }

    public void setFateInclineDataSource(Map arg2) {
        this.i = arg2;
        this.x.i = this.i;
    }

    public void setFateResistanceDataSource(Map arg2) {
        this.j = arg2;
        this.x.j = this.j;
    }

    public void setFateSpeedDataSource(Map arg2) {
        this.h = arg2;
        this.x.speed = this.h;
    }

    public void setFateTotalTime(int arg2) {
        this.c = arg2;
        this.x.c = this.c;
    }

    public void setIsFate(boolean arg2) {
        this.a = arg2;
        boolean v0 = this.a;
        this.x.a = v0;
        this.w.a = v0;
    }

    public void setIsWorkoutSummary(boolean arg2) {
        this.b = arg2;
        this.x.b = this.b;
    }

    public void setMaxHeartRate(int arg2) {
        this.g = arg2;
        this.x.g = this.g;
    }

    public void setMaxIncline(int arg2) {
        this.f = arg2;
        this.x.f = this.f;
    }

    public void setMaxResistance(int arg2) {
        this.e = arg2;
        this.x.e = this.e;
    }

    public void setMaxSpeed(int arg2) {
        this.d = arg2;
        this.x.d = this.d;
    }

    public void setShowCaloriesTipTitle(boolean arg2) {
        this.D.setVisibility(arg2 ? 0 : 8);
    }

    public void setShowDisplayElapsedTimeTipTitle(boolean arg2) {
        this.u.setVisibility(arg2 ? 0 : 4);
    }

    public void setShowDisplayTimeTipTitle(boolean arg2) {
        this.v.setVisibility(arg2 ? 0 : 4);
    }

    public void setShowHeartRateTipTitle(boolean arg2) {
        this.C.setVisibility(arg2 ? 0 : 8);
    }

    public void setShowInclineTipTitle(boolean arg2) {
        this.inclineTipTitleLayout.setVisibility(arg2 ? 0 : 8);
    }

    public void setShowResistanceTipTitle(boolean arg2) {
        this.B.setVisibility(arg2 ? 0 : 8);
    }

    public void setShowSpeedTipTitle(boolean arg2) {
        this.speedTipTitleLayoutz.setVisibility(arg2 ? 0 : 8);
    }

    public void setShowTimeTipTitle(boolean arg2) {
        this.E.setVisibility(arg2 ? 0 : 8);
    }

    public void setTotalTime(int arg2) {
        this.q = arg2;
        String v2 = d.b(arg2);
        this.s.setText(v2);
    }

    public void setTotalTimeStr(String arg2) {
        this.s.setText(arg2);
    }

    public void setZeroTimeStr(String arg2) {
        this.t.setText(arg2);
    }
}
