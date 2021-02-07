package com.xtremeprog.shell.treadmillv2.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import apps.c.d;
import apps.c.j;
import apps.c.k;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"NewApi"})
public class AppsRunningDisplayView extends RelativeLayout {
    public interface a {
        void a(float arg1, int arg2, double arg3, int arg4);

        void a(float arg1, int arg2, int arg3, int arg4);

        void setSpeedCursorText(float arg1, int arg2, double arg3, int arg4);

        void b(float arg1, int arg2, int arg3, int arg4);

        void c(float arg1, int arg2, double arg3, int arg4);
    }

    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private boolean J;
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public Map speed;
    public Map i;
    public Map j;
    public Map k;
    public Map l;
    public int m;
    public a n;
    private Context o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public AppsRunningDisplayView(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.E = 0;
        this.F = 15;
        this.G = 12;
        this.H = 12;
        this.I = 20;
        this.a = false;
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.speed = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.J = false;
        this.m = 0;
        this.a(arg2);
    }

    public AppsRunningDisplayView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.E = 0;
        this.F = 15;
        this.G = 12;
        this.H = 12;
        this.I = 20;
        this.a = false;
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.speed = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.J = false;
        this.m = 0;
        this.a(arg1);
    }

    private void a(Context arg8) {
        int v0_2;
        int v0_1;
        int v3;
        this.o = arg8;
        this.F = AppsRunner.get(arg8).aa();
        this.G = AppsRunner.get(arg8).aa();
        this.H = AppsRunner.get(arg8).aa();
        this.I = AppsRunner.get(arg8).aa();
        boolean v0 = d.h(this.o);
        boolean v1 = d.b();
        int v2 = 0;
        if(v0) {
            v3 = 200;
        }
        else {
            v3 = v1 ? 50 : 0;
        }

        int v3_1 = v3 + 550;
        if(v0) {
            v2 = 170;
        }
        else if(v1) {
            v2 = 80;
        }

        this.x = k.a(arg8, 32.0f);
        this.w = k.a(arg8, 35.0f);
        this.y = k.a(arg8, 18.0f);
        this.z = k.a(arg8, 22.0f);
        this.A = k.a(arg8, 10.0f);
        this.E = k.a(arg8, 20.0f);
        float v1_1 = (float)v3_1;
        this.C = k.a(arg8, v1_1);
        this.D = k.a(arg8, v1_1) - this.E * 2;
        this.B = k.a(arg8, ((float)(v2 + 0xFA)));
        this.p = (int)(((double)this.B) / (((double)this.F) + 0.5));
        if(v0) {
            this.x = k.a(arg8, 48.0f);
            this.z = k.a(arg8, 26.0f);
            this.w = k.a(arg8, 50.0f);
            this.A = k.a(arg8, 13.0f);
            if(this.F != 12 && this.F != 15) {
                v0_1 = this.p;
                this.q = v0_1 / 4;
            }
            else {
                v0_1 = this.p;
            }

            v0_2 = v0_1 / 4 - k.a(arg8, 5.0f);
        }
        else {
            v0_2 = this.p / 4;
        }

        this.q = v0_2;
        this.r = k.a(arg8, 4.0f);
        this.s = this.G * this.p;
        this.t = this.I * this.p;
        this.u = this.H * this.p;
        this.v = this.p * this.F;
    }

    @Override  // android.view.View
    public void onDraw(Canvas arg50) {
        int v1_20;
        int v1_18;
        int v6_16;
        float v2_16;
        Context v1_16;
        int v1_15;
        int v6_15;
        float v2_15;
        Context v1_14;
        int v1_13;
        float v2_14;
        Context v1_12;
        int v1_11;
        int v6_14;
        int v8_11;
        int v9_16;
        int v22_6;
        int v21_3;
        int v15_5;
        int v23_6;
        int v9_15;
        int v22_5;
        int v21_2;
        int v6_10;
        int v15_4;
        int v9_14;
        int v8_8;
        double v25_3;
        int v32_1;
        int v27_1;
        int v31_2;
        int v32;
        int v31_1;
        int v27;
        double v25_2;
        int v6_7;
        double v11_11;
        int v9_12;
        double v29_2;
        int v37_3;
        int v37_2;
        double v29_1;
        int v9_8;
        double v11_8;
        double v34_2;
        int v37_1;
        double v34_1;
        double v11_5;
        int v8_6;
        float v41_1;
        float v23_4;
        int v39_1;
        float v41;
        float v40;
        float v23_3;
        int v39;
        int v18_2;
        int v8_1;
        boolean v19_1;
        ConcurrentHashMap v23_1;
        ConcurrentHashMap v22_1;
        ConcurrentHashMap v25;
        float v9_1;
        ConcurrentHashMap v21;
        boolean v24;
        int v18_1;
        float v11_1;
        float v2_1;
        float v12_1;
        int v10;
        int v1;
        AppsRunningDisplayView v0 = this;
        Canvas v7 = arg50;
        super.onDraw(arg50);
        boolean v8 = d.h(v0.o);
        boolean v9 = d.a();
        j.a("-----", "======onDraw======" + v0.F);
        if(v0.a) {
            v1 = v0.c;
            v10 = v1;
        }
        else {
            v10 = AppsRunner.get(v0.o).z();
            v1 = AppsRunner.get(v0.o).A();
        }

        int v13 = v10 == 0 || v1 == 0 ? 0 : 1;
        Paint v14 = new Paint(1);
        v14.setStyle(Paint.Style.STROKE);
        ConcurrentHashMap speedHashMap = new ConcurrentHashMap();
        ConcurrentHashMap v6 = new ConcurrentHashMap();
        ConcurrentHashMap v5 = new ConcurrentHashMap();
        ConcurrentHashMap v4 = new ConcurrentHashMap();
        ConcurrentHashMap v3 = new ConcurrentHashMap();
        if(v0.a) {
            speedHashMap.putAll(v0.speed);
            v6.putAll(v0.j);
            v5.putAll(v0.i);
            v3.putAll(v0.k);
            v4.putAll(v0.l);
            float v2 = (float)v0.e;
            float v11 = (float)v0.f;
            int v12 = v0.G * 15;
            float v18 = (float)v0.d;
            if(v0.m == 0) {
                v12_1 = v2;
                v2_1 = v11;
                v11_1 = v18;
                v18_1 = v12;
            }
            else {
                v12_1 = v2;
                v2_1 = v11;
                v11_1 = v18;
                v18_1 = 180;
            }
        }
        else {
            speedHashMap.putAll(AppsRunner.get(v0.o).K());
            v6.putAll(AppsRunner.get(v0.o).f);
            v5.putAll(AppsRunner.get(v0.o).g);
            v4.putAll(AppsRunner.get(v0.o).h);
            v3.putAll(AppsRunner.get(v0.o).j);
            float v1_1 = v0.a ? AppsRunner.get(v0.o).c().n : ((float)AppsRunner.get(v0.o).X());
            float v2_2 = AppsRunner.get(v0.o).c().r;
            float v11_2 = AppsRunner.get(v0.o).c().p;
            v18_1 = AppsRunner.get(v0.o).c().u;
            v12_1 = v2_2;
            v2_1 = v11_2;
            v11_1 = v1_1;
        }

        ConcurrentHashMap v19 = v3;
        v0.s = (int)(((float)v0.p) * v11_1);
        v0.t = (int)(((float)v0.p) * v12_1);
        v0.u = (int)(((float)v0.p) * v2_1);
        v7.drawColor(v0.o.getResources().getColor(0x7F04003D));  // color:fullAlpha
        boolean v20 = AppsRunner.get(v0.o).ab();
        v14.setColor(Color.parseColor("#88A3B6C7"));
        v14.setStrokeWidth(1.5f);
        int v1_2 = 0;
        while(v1_2 < v0.F + 1) {
            int v3_1 = v0.p * v1_2;
            float v22 = v2_1;
            ConcurrentHashMap v23 = v4;
            int v2_3 = v0.C + v0.w;
            if(v1_2 % 2 != 0 && (v20)) {
                v24 = v9;
                v21 = v19;
                v9_1 = v22;
                v25 = v23;
                v22_1 = v5;
                v23_1 = v6;
                v19_1 = v8;
                v8_1 = v18_1;
                v18_2 = v1_2;
            }
            else {
                v18_2 = v1_2;
                v24 = v9;
                v9_1 = v22;
                v19_1 = v8;
                v8_1 = v18_1;
                v21 = v19;
                v22_1 = v5;
                v25 = v23;
                v23_1 = v6;
                arg50.drawLine(((float)v0.w), ((float)(v0.B - v3_1 + v0.q)), ((float)v2_3), ((float)(v0.B - v3_1 + v0.q)), v14);
            }

            v1_2 = v18_2 + 1;
            v18_1 = v8_1;
            v2_1 = v9_1;
            v8 = v19_1;
            v19 = v21;
            v5 = v22_1;
            v6 = v23_1;
            v9 = v24;
            v4 = v25;
        }

        ConcurrentHashMap v25_1 = v4;
        ConcurrentHashMap v22_2 = v5;
        ConcurrentHashMap v23_2 = v6;
        boolean v24_1 = v9;
        ConcurrentHashMap v21_1 = v19;
        float v9_2 = v2_1;
        boolean v19_2 = v8;
        int v8_2 = v18_1;
        if(((AppsRunner.get(v0.o).inclineSupportsHalfDegree(v0.o)) || (v0.a)) && v23_2.size() > 1 && v13 != 0) {
            v14.setColor(v0.o.getResources().getColor(0x7F04002C));  // color:color_incline2
            v14.setStrokeWidth(2.0f);
            v14.setStyle(Paint.Style.STROKE);
            v14.setAntiAlias(true);
            Path v1_3 = new Path();
            int v2_4 = -1;
            int v5_1 = 1;
            int v6_1 = -1;
            int v26 = 0xFFFE7961;
            double v34 = 0.0;
            while(v5_1 < v23_2.size()) {
                Integer v3_2 = new Integer(v5_1);
                ConcurrentHashMap v4_1 = v23_2;
                if(v4_1.containsKey(v3_2)) {
                    Double v3_3 = (Double)v4_1.get(v3_2);
                    double v37 = (double)v3_3;
                    v39 = v8_2;
                    v23_3 = v9_2;
                    double v8_3 = (double)v12_1;
                    if(v37 > v8_3) {
                        v37 = v8_3;
                    }

                    v40 = v12_1;
                    v41 = v11_1;
                    float v11_3 = ((float)v5_1) * 1.0f / ((float)v10);
                    float v8_4 = (float)(v37 * 1.0 / v8_3);
                    if(v11_3 > 1.0f) {
                        v11_3 = 1.0f;
                    }

                    float v43 = v8_4 <= 1.0f ? v8_4 : 1.0f;
                    int v9_3 = (int)(((float)v0.t) * v43);
                    int v8_5 = ((int)(v11_3 * ((float)v0.D))) + v0.w + v0.E;
                    int v11_4 = v0.B - v9_3 + v0.q;
                    int v44 = v9_3 + v0.q + v0.r;
                    if(v6_1 != -1 && v2_4 != -1) {
                        v1_3.quadTo(((float)v6_1), ((float)v2_4), ((float)v8_5), ((float)v11_4));
                    }
                    else {
                        v1_3.moveTo(((float)v8_5), ((float)v11_4));
                    }

                    if(v5_1 == v4_1.size() - 1) {
                        double v26_1 = (double)v3_3;
                        a v2_5 = v0.n;
                        if(v2_5 != null) {
                            v2_5.a(v43, v44, v3_3.doubleValue(), v0.q);
                        }

                        v6_1 = v8_5;
                        v2_4 = v11_4;
                        v34 = v26_1;
                        v26 = v2_4;
                    }
                    else {
                        v6_1 = v8_5;
                        v2_4 = v11_4;
                    }
                }
                else {
                    v39 = v8_2;
                    v23_3 = v9_2;
                    v41 = v11_1;
                    v40 = v12_1;
                }

                ++v5_1;
                v9_2 = v23_3;
                v8_2 = v39;
                v12_1 = v40;
                v11_1 = v41;
                v23_2 = v4_1;
            }

            v39_1 = v8_2;
            v23_4 = v9_2;
            v41_1 = v11_1;
            v7.drawPath(v1_3, v14);
            v8_6 = v26;
            v11_5 = v34;
        }
        else {
            v39_1 = v8_2;
            v23_4 = v9_2;
            v41_1 = v11_1;
            v8_6 = 0xFFFE7961;
            v11_5 = 0.0;
        }

        if(speedHashMap.size() > 1 && v13 != 0) {
            v14.setColor(v0.o.getResources().getColor(0x7F040034));  // color:color_speed
            v14.setStrokeWidth(2.0f);
            v14.setStyle(Paint.Style.STROKE);
            v14.setAntiAlias(true);
            Path v1_4 = new Path();
            int v2_6 = 1;
            int v3_4 = -1;
            int v4_2 = -1;
            int v5_2 = 0xFFFE7961;
            double v29 = 0.0;
            while(v2_6 < speedHashMap.size()) {
                Integer v6_2 = new Integer(v2_6);
                if(speedHashMap.containsKey(v6_2)) {
                    Double speed = (Double)speedHashMap.get(v6_2);
                    double v26_2 = (double)speed;
                    v34_1 = v11_5;
                    float v9_4 = v41_1;
                    double v11_6 = (double)v9_4;
                    if(v26_2 > v11_6) {
                        v37_1 = v5_2;
                        v26_2 = v11_6;
                    }
                    else {
                        v37_1 = v5_2;
                    }

                    v41_1 = v9_4;
                    float v5_3 = ((float)v2_6) * 1.0f / ((float)v10);
                    float v9_5 = (float)(v26_2 * 1.0 / v11_6);
                    if(v5_3 > 1.0f) {
                        v5_3 = 1.0f;
                    }

                    float v43_1 = v9_5 <= 1.0f ? v9_5 : 1.0f;
                    int v9_6 = (int)(((float)v0.s) * v43_1);
                    int v5_4 = ((int)(v5_3 * ((float)v0.D))) + v0.w + v0.E;
                    int v11_7 = v0.B - v9_6 + v0.q;
                    int v44_1 = v9_6 + v0.q + v0.r;
                    if(v3_4 != -1 && v4_2 != -1) {
                        v1_4.quadTo(((float)v3_4), ((float)v4_2), ((float)v5_4), ((float)v11_7));
                    }
                    else {
                        v1_4.moveTo(((float)v5_4), ((float)v11_7));
                    }

                    if(v2_6 == speedHashMap.size() - 1) {
                        double v3_5 = (double)speed;
                        a v9_7 = v0.n;
                        if(v9_7 != null) {
                            v9_7.setSpeedCursorText(v43_1, v44_1, speed.doubleValue(), v0.q);
                        }

                        v29 = v3_5;
                        v3_4 = v5_4;
                        v4_2 = v11_7;
                        v5_2 = v4_2;
                    }
                    else {
                        v3_4 = v5_4;
                        v4_2 = v11_7;
                        v5_2 = v37_1;
                    }
                }
                else {
                    v34_1 = v11_5;
                }

                ++v2_6;
                v11_5 = v34_1;
            }

            v34_2 = v11_5;
            v7.drawPath(v1_4, v14);
            v11_8 = v29;
            v9_8 = v5_2;
        }
        else {
            v34_2 = v11_5;
            v9_8 = 0xFFFE7961;
            v11_8 = 0.0;
        }

        if(v22_2.size() > 1 && v13 != 0) {
            v14.setColor(v0.o.getResources().getColor(0x7F04002B));  // color:color_incline
            v14.setStrokeWidth(2.0f);
            v14.setStyle(Paint.Style.STROKE);
            v14.setAntiAlias(true);
            Path v1_5 = new Path();
            int v2_7 = 1;
            int v3_6 = -1;
            int v4_3 = -1;
            int v5_5 = 0xFFFE7961;
            double v31 = 0.0;
            while(v2_7 < v22_2.size()) {
                Integer v6_4 = new Integer(v2_7);
                ConcurrentHashMap v15_1 = v22_2;
                if(v15_1.containsKey(v6_4)) {
                    Double v6_5 = (Double)v15_1.get(v6_4);
                    double v26_3 = (double)v6_5;
                    int v22_3 = v5_5;
                    v29_1 = v11_8;
                    float v5_6 = v23_4;
                    double v11_9 = (double)v5_6;
                    if(v26_3 > v11_9) {
                        v23_4 = v5_6;
                        v26_3 = v11_9;
                    }
                    else {
                        v23_4 = v5_6;
                    }

                    v37_2 = v9_8;
                    float v5_7 = ((float)v2_7) * 1.0f / ((float)v10);
                    float v9_9 = (float)(v26_3 * 1.0 / v11_9);
                    if(v5_7 > 1.0f) {
                        v5_7 = 1.0f;
                    }

                    float v41_2 = v9_9 <= 1.0f ? v9_9 : 1.0f;
                    int v9_10 = (int)(((float)v0.u) * v41_2);
                    int v5_8 = ((int)(v5_7 * ((float)v0.D))) + v0.w + v0.E;
                    int v11_10 = v0.B - v9_10 + v0.q;
                    int v42 = v9_10 + v0.q + v0.r;
                    if(v3_6 != -1 && v4_3 != -1) {
                        v1_5.quadTo(((float)v3_6), ((float)v4_3), ((float)v5_8), ((float)v11_10));
                    }
                    else {
                        v1_5.moveTo(((float)v5_8), ((float)v11_10));
                    }

                    if(v2_7 == v15_1.size() - 1) {
                        double v3_7 = (double)v6_5;
                        a v9_11 = v0.n;
                        if(v9_11 != null) {
                            v9_11.c(v41_2, v42, v6_5.doubleValue(), v0.q);
                        }

                        v31 = v3_7;
                        v3_6 = v5_8;
                        v4_3 = v11_10;
                        v5_5 = v4_3;
                    }
                    else {
                        v3_6 = v5_8;
                        v4_3 = v11_10;
                        v5_5 = v22_3;
                    }
                }
                else {
                    v37_2 = v9_8;
                    v29_1 = v11_8;
                }

                ++v2_7;
                v22_2 = v15_1;
                v11_8 = v29_1;
                v9_8 = v37_2;
            }

            v37_3 = v9_8;
            v29_2 = v11_8;
            v7.drawPath(v1_5, v14);
            v9_12 = v5_5;
            v11_11 = v31;
        }
        else {
            v37_3 = v9_8;
            v29_2 = v11_8;
            v9_12 = 0xFFFE7961;
            v11_11 = 0.0;
        }

        if(v25_1.size() > 1 && v13 != 0) {
            v14.setColor(v0.o.getResources().getColor(0x7F040025));  // color:color_calories
            v14.setStrokeWidth(2.0f);
            v14.setStyle(Paint.Style.STROKE);
            v14.setAntiAlias(true);
            Path v1_6 = new Path();
            int v2_8 = 1;
            int v3_8 = -1;
            int v4_4 = -1;
            int v5_9 = 0xFFFE7961;
            int v6_6 = 0;
            while(v2_8 < v25_1.size()) {
                Integer v15_2 = new Integer(v2_8);
                int v22_4 = v5_9;
                ConcurrentHashMap v5_10 = v25_1;
                if(v5_10.containsKey(v15_2)) {
                    int v15_3 = (int)(((Integer)v5_10.get(v15_2)));
                    int v23_5 = v6_6;
                    if(v15_3 > AppsRunner.get(v0.o).Z()) {
                        v6_7 = AppsRunner.get(v0.o).Z();
                        v25_2 = v11_11;
                    }
                    else {
                        v25_2 = v11_11;
                        v6_7 = v15_3;
                    }

                    float v11_12 = ((float)v2_8) * 1.0f / ((float)v10);
                    v27 = v9_12;
                    int v12_2 = v39_1;
                    float v6_8 = ((float)v6_7) * 1.0f / ((float)v12_2);
                    if(v11_12 > 1.0f) {
                        v11_12 = 1.0f;
                    }

                    if(v6_8 > 1.0f) {
                        v6_8 = 1.0f;
                    }

                    int v11_13 = (int)(((float)v0.v) * v6_8);
                    v31_1 = v8_6;
                    int v9_13 = ((int)(v11_12 * ((float)v0.D))) + v0.w + v0.E;
                    v39_1 = v12_2;
                    int v8_7 = v0.B - v11_13 + v0.q;
                    int v11_14 = v11_13 + v0.q + v0.r;
                    if(v3_8 != -1 && v4_4 != -1) {
                        v32 = v10;
                        v1_6.quadTo(((float)v3_8), ((float)v4_4), ((float)v9_13), ((float)v8_7));
                    }
                    else {
                        v32 = v10;
                        v1_6.moveTo(((float)v9_13), ((float)v8_7));
                    }

                    if(v2_8 == v5_10.size() - 1) {
                        a v3_9 = v0.n;
                        if(v3_9 != null) {
                            v3_9.a(v6_8, v11_14, v15_3, v0.q);
                        }

                        v4_4 = v8_7;
                        v22_4 = v4_4;
                        v3_8 = v9_13;
                        v6_6 = v15_3;
                    }
                    else {
                        v4_4 = v8_7;
                        v3_8 = v9_13;
                        v6_6 = v23_5;
                    }
                }
                else {
                    v31_1 = v8_6;
                    v27 = v9_12;
                    v32 = v10;
                    v25_2 = v11_11;
                }

                ++v2_8;
                v11_11 = v25_2;
                v9_12 = v27;
                v8_6 = v31_1;
                v10 = v32;
                v25_1 = v5_10;
                v5_9 = v22_4;
            }

            v31_2 = v8_6;
            v27_1 = v9_12;
            v32_1 = v10;
            v25_3 = v11_11;
            v7.drawPath(v1_6, v14);
            v8_8 = v5_9;
            v9_14 = v6_6;
        }
        else {
            v31_2 = v8_6;
            v27_1 = v9_12;
            v32_1 = v10;
            v25_3 = v11_11;
            v8_8 = 0xFFFE7961;
            v9_14 = 0;
        }

        if(v21_1.size() > 1 && v13 != 0) {
            v14.setColor(v0.o.getResources().getColor(0x7F040024));  // color:color_blue
            v14.setStrokeWidth(2.0f);
            v14.setStyle(Paint.Style.STROKE);
            v14.setAntiAlias(true);
            Path v1_7 = new Path();
            int v2_9 = 1;
            int v3_10 = -1;
            int v4_5 = -1;
            int v5_11 = 0xFFFE7961;
            int v11_15 = 0;
            while(v2_9 < v21_1.size()) {
                Integer v6_9 = new Integer(v2_9);
                ConcurrentHashMap v10_1 = v21_1;
                if(v10_1.containsKey(v6_9)) {
                    double v12_3 = (double)(((Double)v10_1.get(v6_9)));
                    if(v0.a) {
                        v15_4 = v5_11;
                        v6_10 = 1;
                    }
                    else {
                        v6_10 = 5;
                        v15_4 = v5_11;
                    }

                    int v5_12 = (int)(v12_3 * ((double)v6_10));
                    double v12_4 = (double)v5_12;
                    v21_2 = v8_8;
                    v22_5 = v9_14;
                    if(v12_4 > ((double)AppsRunner.get(v0.o).Z())) {
                        v12_4 = (double)AppsRunner.get(v0.o).Z();
                    }

                    float v6_11 = ((float)v2_9) * 1.0f / ((float)v32_1);
                    v9_15 = v39_1;
                    float v7_1 = (float)(v12_4 * 1.0 / ((double)v9_15));
                    if(v6_11 > 1.0f) {
                        v6_11 = 1.0f;
                    }

                    if(v7_1 > 1.0f) {
                        v7_1 = 1.0f;
                    }

                    int v8_9 = (int)(((float)v0.v) * v7_1);
                    int v6_12 = ((int)(v6_11 * ((float)v0.D))) + v0.w + v0.E;
                    int v12_5 = v0.B - v8_9 + v0.q;
                    int v8_10 = v8_9 + v0.q + v0.r;
                    if(v3_10 != -1 && v4_5 != -1) {
                        v23_6 = v11_15;
                        v1_7.quadTo(((float)v3_10), ((float)v4_5), ((float)v6_12), ((float)v12_5));
                    }
                    else {
                        v23_6 = v11_15;
                        v1_7.moveTo(((float)v6_12), ((float)v12_5));
                    }

                    if(v2_9 == v10_1.size() - 1) {
                        a v3_11 = v0.n;
                        if(v3_11 != null) {
                            v3_11.b(v7_1, v8_10, v5_12, v0.q);
                        }

                        v11_15 = v5_12;
                        v3_10 = v6_12;
                        v4_5 = v12_5;
                        v5_11 = v4_5;
                    }
                    else {
                        v3_10 = v6_12;
                        v4_5 = v12_5;
                        v5_11 = v15_4;
                        v11_15 = v23_6;
                    }
                }
                else {
                    v21_2 = v8_8;
                    v22_5 = v9_14;
                    v9_15 = v39_1;
                }

                ++v2_9;
                v39_1 = v9_15;
                v8_8 = v21_2;
                v9_14 = v22_5;
                v7 = arg50;
                v21_1 = v10_1;
            }

            v15_5 = v5_11;
            v21_3 = v8_8;
            v22_6 = v9_14;
            v9_16 = v39_1;
            v7.drawPath(v1_7, v14);
            v8_11 = v11_15;
        }
        else {
            v21_3 = v8_8;
            v22_6 = v9_14;
            v9_16 = v39_1;
            v8_11 = 0;
            v15_5 = 0xFFFE7961;
        }

        v14.setStyle(Paint.Style.FILL);
        v14.setColor(v0.o.getResources().getColor(0x7F04006F));  // color:white
        v14.setStrokeWidth(1.5f);
        v7.drawRect(new Rect(v0.w, 0, v0.E + v0.w, v0.B + v0.p * 2 + v0.q * 2), v14);
        v14.setColor(v0.o.getResources().getColor(0x7F04006F));  // color:white
        v14.setStrokeWidth(1.5f);
        v7.drawRect(new Rect(v0.C - v0.E + v0.w, 0, v0.C + v0.w, v0.B + v0.p * 2 + v0.q * 2), v14);
        v14.setTextAlign(Paint.Align.CENTER);
        v14.setTextSize(((float)k.b(v0.o, 11.0f)));
        v14.setColor(v0.o.getResources().getColor(0x7F040014));  // color:black
        int v1_8;
        for(v1_8 = 0; v1_8 < v0.F + 1; ++v1_8) {
            String v2_10 = v1_8 + "";
            if(v1_8 % 2 == 0 || !v20) {
                v7.drawText(v2_10, ((float)(v0.E / 2 + v0.w)), ((float)(v0.B - v0.p * v1_8 + v0.q + v0.r)), v14);
            }
        }

        v14.setTextSize(((float)k.b(v0.o, 11.0f)));
        int v1_9 = v0.F + 1;
        j.a("====111111====", v0.m + " | " + v9_16);
        int v2_11 = v0.m;
        if(v2_11 == 0) {
            float v2_13 = ((float)v9_16) * 1.0f / ((float)v0.F);
            int v3_13;
            for(v3_13 = 0; v3_13 < v1_9; ++v3_13) {
                String v4_7 = ((int)(((float)v3_13) * v2_13)) + "";
                if(v3_13 % 2 == 0 || !v20) {
                    v7.drawText(v4_7, ((float)(v0.C - v0.E + v0.E / 2 + v0.w)), ((float)(v0.B - v0.p * v3_13 + v0.q + v0.r)), v14);
                }
            }
        }
        else {
            float v1_10 = (float)v2_11;
            int v2_12 = (int)(((float)v9_16) * 1.0f / ((float)v2_11));
            int v3_12 = (int)(((double)v0.B) / (((double)v2_12) + 0.5));
            int v4_6 = v3_12 / 4 - k.a(v0.o, 5.0f);
            int v5_13;
            for(v5_13 = 0; v5_13 < v2_12 + 1; ++v5_13) {
                String v6_13 = ((int)(((float)v5_13) * v1_10)) + "";
                if(v5_13 % 2 == 0 || !v20) {
                    v7.drawText(v6_13, ((float)(v0.C - v0.E + v0.E / 2 + v0.w)), ((float)(v0.B - v3_12 * v5_13 + v4_6 + v0.r)), v14);
                }
            }
        }

        if(v0.J) {
            return;
        }

        boolean v9_17 = AppsRunner.get(v0.o).inclineSupportsHalfDegree(v0.o);
        v14.setStyle(Paint.Style.FILL);
        if(!v9_17 && !v0.a) {
            v6_14 = v37_3;
        }
        else {
            if(!v0.b) {
                int v3_14 = v31_2;
                if(v3_14 != 0xFFFE7961) {
                    v14.setColor(v0.o.getResources().getColor(0x7F04002C));  // color:color_incline2
                    v14.setStrokeWidth(2.0f);
                    v14.setStyle(Paint.Style.STROKE);
                    float v5_14 = (float)v3_14;
                    int v33 = v3_14;
                    arg50.drawLine(((float)v0.w), v5_14, ((float)(v0.E + v0.w)), v5_14, v14);
                    v14.setStrokeWidth(1.5f);
                    v14.setColor(v0.o.getResources().getColor(0x7F040026));  // color:color_cursor_mask
                    v14.setStyle(Paint.Style.FILL);
                    v7.drawRoundRect(new RectF(((float)(v0.w - v0.x)), ((float)(v33 - v0.z / 2)), ((float)v0.w), ((float)(v33 + v0.z / 2))), ((float)v0.A), ((float)v0.A), v14);
                    v14.setStrokeWidth(3.0f);
                    v14.setColor(v0.o.getResources().getColor(0x7F04002C));  // color:color_incline2
                    v14.setStyle(Paint.Style.STROKE);
                    v7.drawRoundRect(new RectF(((float)(v0.w - v0.x)), ((float)(v33 - v0.z / 2)), ((float)v0.w), ((float)(v33 + v0.z / 2))), ((float)v0.A), ((float)v0.A), v14);
                    v14.setStrokeWidth(1.5f);
                    v14.setTextAlign(Paint.Align.CENTER);
                    if(v19_2) {
                        v1_11 = k.b(v0.o, 18.0f);
                    }
                    else {
                        if(v24_1) {
                            v1_12 = v0.o;
                            v2_14 = 14.0f;
                        }
                        else {
                            v1_12 = v0.o;
                            v2_14 = 12.0f;
                        }

                        v1_11 = k.b(v1_12, v2_14);
                    }

                    v14.setTextSize(((float)v1_11));
                    v14.setColor(v0.o.getResources().getColor(0x7F04006F));  // color:white
                    v7.drawText(d.doubleToStr(v34_2, 0) + "", ((float)(v0.w - v0.x + v0.x / 2)), ((float)(v33 + v0.z / 4)), v14);
                }
            }

            v6_14 = v37_3;
        }

        if(v6_14 == 0xFFFE7961) {
            v6_15 = v27_1;
        }
        else {
            v14.setColor(v0.o.getResources().getColor(0x7F040034));  // color:color_speed
            v14.setStrokeWidth(2.0f);
            v14.setStyle(Paint.Style.STROKE);
            float v3_15 = (float)v6_14;
            int v33_1 = v6_14;
            arg50.drawLine(((float)v0.w), v3_15, ((float)(v0.E + v0.w)), v3_15, v14);
            v14.setStrokeWidth(1.5f);
            v14.setColor(v0.o.getResources().getColor(0x7F040026));  // color:color_cursor_mask
            v14.setStyle(Paint.Style.FILL);
            v7.drawRoundRect(new RectF(((float)(v0.w - v0.x)), ((float)(v33_1 - v0.z / 2)), ((float)v0.w), ((float)(v33_1 + v0.z / 2))), ((float)v0.A), ((float)v0.A), v14);
            v14.setStrokeWidth(3.0f);
            v14.setColor(v0.o.getResources().getColor(0x7F040034));  // color:color_speed
            v14.setStyle(Paint.Style.STROKE);
            v7.drawRoundRect(new RectF(((float)(v0.w - v0.x)), ((float)(v33_1 - v0.z / 2)), ((float)v0.w), ((float)(v33_1 + v0.z / 2))), ((float)v0.A), ((float)v0.A), v14);
            v14.setStrokeWidth(1.5f);
            v14.setTextAlign(Paint.Align.CENTER);
            if(v19_2) {
                v1_13 = k.b(v0.o, 18.0f);
            }
            else {
                if(v24_1) {
                    v1_14 = v0.o;
                    v2_15 = 14.0f;
                }
                else {
                    v1_14 = v0.o;
                    v2_15 = 12.0f;
                }

                v1_13 = k.b(v1_14, v2_15);
            }

            v14.setTextSize(((float)v1_13));
            v14.setColor(v0.o.getResources().getColor(0x7F04006F));  // color:white
            v7.drawText(d.doubleToStr(v29_2, 1) + "", ((float)(v0.w - v0.x + v0.x / 2)), ((float)(v33_1 + v0.z / 4)), v14);
            v6_15 = v27_1;
        }

        if(v6_15 == 0xFFFE7961) {
            v6_16 = v21_3;
        }
        else {
            v14.setColor(v0.o.getResources().getColor(0x7F04002B));  // color:color_incline
            v14.setStrokeWidth(2.0f);
            v14.setStyle(Paint.Style.STROKE);
            float v3_16 = (float)v6_15;
            int v33_2 = v6_15;
            arg50.drawLine(((float)v0.w), v3_16, ((float)(v0.E + v0.w)), v3_16, v14);
            v14.setStrokeWidth(1.5f);
            v14.setColor(v0.o.getResources().getColor(0x7F040026));  // color:color_cursor_mask
            v14.setStyle(Paint.Style.FILL);
            v7.drawRoundRect(new RectF(((float)(v0.w - v0.x)), ((float)(v33_2 - v0.z / 2)), ((float)v0.w), ((float)(v33_2 + v0.z / 2))), ((float)v0.A), ((float)v0.A), v14);
            v14.setStrokeWidth(3.0f);
            v14.setColor(v0.o.getResources().getColor(0x7F04002B));  // color:color_incline
            v14.setStyle(Paint.Style.STROKE);
            v7.drawRoundRect(new RectF(((float)(v0.w - v0.x)), ((float)(v33_2 - v0.z / 2)), ((float)v0.w), ((float)(v33_2 + v0.z / 2))), ((float)v0.A), ((float)v0.A), v14);
            v14.setStrokeWidth(1.5f);
            v14.setTextAlign(Paint.Align.CENTER);
            if(v19_2) {
                v1_15 = k.b(v0.o, 18.0f);
            }
            else {
                if(v24_1) {
                    v1_16 = v0.o;
                    v2_16 = 14.0f;
                }
                else {
                    v1_16 = v0.o;
                    v2_16 = 12.0f;
                }

                v1_15 = k.b(v1_16, v2_16);
            }

            v14.setTextSize(((float)v1_15));
            v14.setColor(v0.o.getResources().getColor(0x7F04006F));  // color:white
            v7.drawText(v9_17 ? d.doubleToStr(v25_3, 0) + "" : d.doubleToStr(v25_3, 1) + "", ((float)(v0.w - v0.x + v0.x / 2)), ((float)(v33_2 + v0.z / 4)), v14);
            v6_16 = v21_3;
        }

        if(v6_16 != 0xFFFE7961) {
            v14.setColor(v0.o.getResources().getColor(0x7F040025));  // color:color_calories
            v14.setStrokeWidth(2.0f);
            v14.setStyle(Paint.Style.STROKE);
            float v17 = (float)v6_16;
            int v33_3 = v6_16;
            arg50.drawLine(((float)(v0.w + v0.C - v0.E)), v17, ((float)(v0.C + v0.w)), v17, v14);
            v14.setStrokeWidth(1.5f);
            v14.setColor(v0.o.getResources().getColor(0x7F040026));  // color:color_cursor_mask
            v14.setStyle(Paint.Style.FILL);
            RectF v1_17 = new RectF(((float)(v0.w + v0.C)), ((float)(v33_3 - v0.z / 2)), ((float)(v0.w + v0.C + v0.x)), ((float)(v33_3 + v0.z / 2)));
            v7.drawRoundRect(v1_17, ((float)v0.A), ((float)v0.A), v14);
            v14.setStrokeWidth(3.0f);
            v14.setColor(v0.o.getResources().getColor(0x7F040025));  // color:color_calories
            v14.setStyle(Paint.Style.STROKE);
            RectF v2_17 = new RectF(v1_17.left, ((float)(v33_3 - v0.z / 2)), ((float)(v0.w + v0.C + v0.x)), ((float)(v33_3 + v0.z / 2)));
            v7.drawRoundRect(v2_17, ((float)v0.A), ((float)v0.A), v14);
            v14.setStrokeWidth(1.5f);
            v14.setTextAlign(Paint.Align.CENTER);
            int v3_17 = v22_6;
            if(v3_17 > 999) {
                v1_18 = k.b(v0.o, 10.0f);
            }
            else if(v19_2) {
                v1_18 = k.b(v0.o, 18.0f);
            }
            else {
                v1_18 = v24_1 ? k.b(v0.o, 14.0f) : k.b(v0.o, 12.0f);
            }

            v14.setTextSize(((float)v1_18));
            v14.setColor(v0.o.getResources().getColor(0x7F04006F));  // color:white
            v7.drawText(d.doubleToStr(v3_17, 0) + "", v2_17.left + ((float)(v0.x / 2)), ((float)(v33_3 + v0.z / 4)), v14);
        }

        if(v15_5 != 0xFFFE7961) {
            v14.setColor(v0.o.getResources().getColor(0x7F040024));  // color:color_blue
            v14.setStrokeWidth(2.0f);
            v14.setStyle(Paint.Style.STROKE);
            float v5_15 = (float)v15_5;
            arg50.drawLine(((float)(v0.w + v0.C - v0.E)), v5_15, ((float)(v0.C + v0.w)), v5_15, v14);
            v14.setStrokeWidth(1.5f);
            v14.setColor(v0.o.getResources().getColor(0x7F040026));  // color:color_cursor_mask
            v14.setStyle(Paint.Style.FILL);
            RectF v1_19 = new RectF(((float)(v0.w + v0.C)), ((float)(v15_5 - v0.z / 2)), ((float)(v0.w + v0.C + v0.x)), ((float)(v0.z / 2 + v15_5)));
            v7.drawRoundRect(v1_19, ((float)v0.A), ((float)v0.A), v14);
            v14.setStrokeWidth(3.0f);
            v14.setColor(v0.o.getResources().getColor(0x7F040024));  // color:color_blue
            v14.setStyle(Paint.Style.STROKE);
            RectF v2_18 = new RectF(v1_19.left, ((float)(v15_5 - v0.z / 2)), ((float)(v0.w + v0.C + v0.x)), ((float)(v0.z / 2 + v15_5)));
            v7.drawRoundRect(v2_18, ((float)v0.A), ((float)v0.A), v14);
            v14.setStrokeWidth(1.5f);
            v14.setTextAlign(Paint.Align.CENTER);
            if(v8_11 > 999) {
                v1_20 = k.b(v0.o, 10.0f);
            }
            else if(v19_2) {
                v1_20 = k.b(v0.o, 18.0f);
            }
            else {
                v1_20 = v24_1 ? k.b(v0.o, 14.0f) : k.b(v0.o, 12.0f);
            }

            v14.setTextSize(((float)v1_20));
            v14.setColor(v0.o.getResources().getColor(0x7F04006F));  // color:white
            v7.drawText(d.doubleToStr(v8_11 / v0.a ? 1 : 5, 0) + "", v2_18.left + ((float)(v0.x / 2)), ((float)(v15_5 + v0.z / 4)), v14);
        }
    }

    public void setExtraMaxHRDraw(int arg1) {
        this.m = arg1;
    }

    public void setIsHistory(boolean arg1) {
        this.J = arg1;
    }

    public void setListener(a arg1) {
        this.n = arg1;
    }
}
