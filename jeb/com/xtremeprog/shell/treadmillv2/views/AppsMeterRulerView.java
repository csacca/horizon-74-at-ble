package com.xtremeprog.shell.treadmillv2.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apps.b.a.b;
import apps.c.d;
import apps.c.j;
import apps.c.k;
import com.xtremeprog.shell.treadmillv2.AppsRunner;

@SuppressLint({"NewApi"})
public class AppsMeterRulerView extends RelativeLayout implements b {
    public interface a {
        void a(AppsMeterRulerView arg1, double arg2);
    }

    public boolean a;
    public double b;
    public int c;
    public int d;
    public int e;
    public int f;
    public double g;
    public double h;
    public double i;
    public double j;
    public double k;
    public double l;
    public a m;
    private Context n;
    private int o;
    private int p;
    private int q;
    private int r;
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private LinearLayout v;
    private GestureDetector w;
    private apps.b.a.a x;

    public AppsMeterRulerView(Context arg4) {
        super(arg4);
        this.a = false;
        this.l = 1.0;
        this.r = 0;
        this.a(arg4);
    }

    public AppsMeterRulerView(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        this.a = false;
        this.l = 1.0;
        this.r = 0;
        this.a(arg3);
    }

    public AppsMeterRulerView(Context arg3, AttributeSet arg4, int arg5) {
        super(arg3, arg4, arg5);
        this.a = false;
        this.l = 1.0;
        this.r = 0;
        this.a(arg3);
    }

    static GestureDetector a(AppsMeterRulerView arg0) {
        return arg0.w;
    }

    private void a(Context arg8) {
        this.n = arg8;
        LinearLayout v0 = new LinearLayout(arg8);
        this.addView(v0, new RelativeLayout.LayoutParams(-1, -1));
        v0.setOrientation(0);
        v0.setPadding(0, 0, 0, 0);
        this.s = new LinearLayout(arg8);
        this.s.setOrientation(1);
        LinearLayout.LayoutParams v3 = new LinearLayout.LayoutParams(k.a(arg8, 30.0f), -1);
        v0.addView(this.s, v3);
        this.u = new LinearLayout(arg8);
        this.u.setOrientation(1);
        RelativeLayout.LayoutParams v3_1 = new RelativeLayout.LayoutParams(k.a(arg8, 48.0f), -1);
        v3_1.leftMargin = k.a(arg8, 26.0f);
        this.addView(this.u, v3_1);
        this.v = new LinearLayout(arg8);
        this.v.setBackgroundColor(arg8.getResources().getColor(0x7F04006F));  // color:white
        this.v.setOrientation(1);
        this.v.setGravity(80);
        LinearLayout.LayoutParams v3_2 = new LinearLayout.LayoutParams(k.a(arg8, 40.0f), -1);
        v0.addView(this.v, v3_2);
        this.t = new LinearLayout(arg8);
        LinearLayout.LayoutParams v0_1 = new LinearLayout.LayoutParams(k.a(arg8, 40.0f), -2);
        this.v.addView(this.t, v0_1);
        this.t.setBackgroundColor(arg8.getResources().getColor(0x7F040057));  // color:orange
        this.x = new apps.b.a.a(this);
        this.w = new GestureDetector(arg8, this.x);
        this.w.setIsLongpressEnabled(false);
        this.setOnTouchListener(new View.OnTouchListener() {
            @Override  // android.view.View$OnTouchListener
            public boolean onTouch(View arg1, MotionEvent arg2) {
                return AppsMeterRulerView.a(AppsMeterRulerView.this).onTouchEvent(arg2);
            }
        });
    }

    public void a() {
        int v0 = this.f;
        int v1 = 0;
        while(v0 > 0) {
            v1 += (int)(((double)this.getTotalHeight2()) * 1.0 / ((double)this.f));
            --v0;
        }

        double v4 = this.j;
        int v0_1 = this.d;
        double v8 = (double)v1;
        int v6 = (int)(v4 / ((double)v0_1) * v8);
        int v7 = this.q;
        if(v7 != 18 && v7 != 1 && v7 != 8 && v7 != 5 && v7 != 15 && v7 != 20) {
            if(v7 == 10 && ((int)v4) >= 980) {
                v6 = 1000 / v0_1 * v1;
            }
        }
        else if(((int)this.j) == 99) {
            v6 = (int)(100.0 / ((double)this.d) * v8);
        }

        int v0_2 = (int)(v8 * 1.0 / ((double)this.f));
        k.a(this.n, 5.0f);
        LinearLayout.LayoutParams v2 = (LinearLayout.LayoutParams)this.t.getLayoutParams();
        v2.height = v6 - v0_2 / 2;
        j.b(".drawSlider.max", this.d + " | " + this.j + "  " + v1 + "   " + v6);
        this.t.setLayoutParams(v2);
    }

    @Override  // apps.b.a.b
    public void a(double arg1, apps.b.a.a arg3) {
    }

    @Override  // apps.b.a.b
    public void a(double arg13, boolean arg15) {
        double v0 = this.g;
        double v0_1 = ((double)Math.round(((int)Math.round(arg13 / v0)))) * this.g;
        j.a("----", arg13 + " : " + this.g + " : " + arg13 / v0 * v0 + " : " + v0_1);
        this.j = v0_1;
        this.k = v0_1;
        if(this.q == 1) {
            if(arg15) {
                if(this.j == 0.0 || this.j == 1.0 || this.j == 2.0 || this.j == 3.0 || this.j == 4.0) {
                    this.j = 5.0;
                    this.k = this.j;
                }
            }
            else if(this.j == 0.0 || this.j == 1.0 || this.j == 2.0 || this.j == 3.0 || this.j == 4.0) {
                this.j = 0.0;
                this.k = this.j;
            }
        }

        int v15 = this.e;
        if(this.j > ((double)v15)) {
            this.j = (double)v15;
        }

        double v2 = this.i;
        if(this.j < v2) {
            this.j = v2;
        }

        int v15_1 = this.e;
        if(this.k > ((double)v15_1)) {
            this.k = (double)v15_1;
        }

        double v2_1 = this.i;
        if(this.k < v2_1) {
            this.k = v2_1;
        }

        this.a();
        a v13 = this.m;
        if(v13 != null) {
            v13.a(this, v0_1);
        }
    }

    public void a(boolean arg21) {
        if(!arg21) {
            this.j = this.h;
            this.k = this.h;
        }

        this.x.a(this.e);
        this.x.b(((int)(this.i * this.l)));
        this.x.a(this.l);
        this.x.b(this.j);
        this.s.removeAllViews();
        int v1 = this.getTotalHeight();
        int v2 = this.getTotalHeight2();
        int v1_1 = v1 - v2;
        LinearLayout.LayoutParams v3 = (LinearLayout.LayoutParams)this.s.getLayoutParams();
        v3.topMargin = v1_1;
        this.s.setLayoutParams(v3);
        LinearLayout.LayoutParams v3_1 = (LinearLayout.LayoutParams)this.v.getLayoutParams();
        v3_1.topMargin = v1_1;
        RelativeLayout.LayoutParams v4 = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
        v4.topMargin = v1_1;
        this.u.setLayoutParams(v4);
        boolean v1_2 = d.h(this.n);
        int v4_1 = apps.database.d.a().e(this.n, AppsRunner.get(this.n).getPref_CurrentUserID(this.n));
        int v9 = this.f;
        double v5 = ((double)this.d) * 1.0 / ((double)v9);
        int v11 = 0;
        while(v9 > 0) {
            TextView v12 = new TextView(this.n);
            LinearLayout v13 = new LinearLayout(this.n);
            v13.setGravity(17);
            TextView v14 = new TextView(this.n);
            v14.setBackgroundColor(this.n.getResources().getColor(0x7F040015));  // color:blue
            v13.addView(v14, new LinearLayout.LayoutParams(k.a(this.n, 40.0f), 1));
            int v8 = (int)Math.round(((double)v9) * v5);
            v12.setText(this.a ? d.doubleToStr(v8, 1) : d.doubleToStr(v8, 0));
            v12.setTextColor(this.n.getResources().getColor(0x7F040015));  // color:blue
            v12.setGravity(19);
            if(!v1_2) {
                int v10 = this.q;
                if(v10 == 10) {
                    v12.setTextSize(8.0f);
                }
                else if(v10 != 12 && v10 != 13 && v10 != 7 && v10 != 2 && v10 != 23 && v10 != 22 && v10 != 14 && v10 != 4 && v10 != 24 || v4_1 == 1) {
                    v12.setTextSize(6.0f);
                }
                else {
                    v12.setTextSize(8.0f);
                }
            }
            else if(this.q != 10 && (this.q != 12 && this.q != 13 && this.q != 7 && this.q != 2 && this.q != 23 && this.q != 22 && this.q != 14 && this.q != 4 && this.q != 24 || v4_1 == 1)) {
                v12.setTextSize(6.0f);
            }
            else {
                v12.setTextSize(8.0f);
            }

            v12.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams v10_1 = new LinearLayout.LayoutParams(-1, -2);
            double v7 = ((double)v2) * 1.0;
            boolean v19 = v1_2;
            int v18 = v2;
            v10_1.height = (int)(v7 / ((double)this.f));
            this.s.addView(v12, v10_1);
            v11 += v10_1.height;
            LinearLayout.LayoutParams v1_3 = new LinearLayout.LayoutParams(-1, -2);
            v1_3.height = (int)(v7 / ((double)this.f));
            this.u.addView(v13, v1_3);
            if((this.q == 18 || this.q == 1 || this.q == 8 || this.q == 5 || this.q == 15 || this.q == 20 || this.q == 16) && v9 == this.f) {
                v12.setText("99");
            }

            if(this.q == 10 && v9 == this.f) {
                v12.setText("980");
            }

            --v9;
            v2 = v18;
            v1_2 = v19;
        }

        v3_1.height = v11;
        this.v.setLayoutParams(v3_1);
        this.a();
        a v1_4 = this.m;
        if(v1_4 != null) {
            v1_4.a(this, this.j);
        }
    }

    public void b() {
        this.j += this.g;
        this.k += this.g;
        if(this.q == 1 && (this.j == 0.0 || this.j == 1.0 || this.j == 2.0 || this.j == 3.0 || this.j == 4.0)) {
            this.j = 5.0;
            this.k = this.j;
        }

        j.a("===currentValue: ====", this.j + " | " + this.g + " | " + this.d + " | " + this.i);
        int v2 = this.e;
        if(this.j > ((double)v2)) {
            this.j = (double)v2;
        }

        int v2_1 = this.e;
        if(this.k > ((double)v2_1)) {
            this.k = (double)v2_1;
        }

        this.x.b(this.j);
        this.a();
        a v0 = this.m;
        if(v0 != null) {
            v0.a(this, this.j);
        }
    }

    @Override  // apps.b.a.b
    public void b(double arg1, apps.b.a.a arg3) {
    }

    public void c() {
        this.j -= this.g;
        this.k -= this.g;
        if(this.q == 1 && (this.j == 0.0 || this.j == 1.0 || this.j == 2.0 || this.j == 3.0 || this.j == 4.0)) {
            this.j = 0.0;
            this.k = this.j;
        }

        j.a("===currentValue: ====", this.j + " | " + this.g + " | " + this.d + " | " + this.i);
        double v2 = this.i;
        if(this.j < v2) {
            this.j = v2;
        }

        double v2_1 = this.i;
        if(this.k < v2_1) {
            this.k = v2_1;
        }

        this.x.b(this.j);
        this.a();
        a v0 = this.m;
        if(v0 != null) {
            v0.a(this, this.j);
        }
    }

    public double getDefaultValue() {
        return this.h;
    }

    public int getTotalHeight() {
        boolean v0 = d.h(this.n);
        boolean v1 = d.b();
        boolean v2 = d.a();
        Context v3 = this.n;
        int v4 = 0;
        int v5 = (v0) || (v1) ? 60 : 0 + 0xE1;
        if(v2) {
            v4 = 20;
        }

        return k.a(v3, ((float)(v5 - v4)));
    }

    public int getTotalHeight2() {
        boolean v0 = d.h(this.n);
        boolean v1 = d.b();
        boolean v2 = d.a();
        Context v3 = this.n;
        int v4 = 0;
        int v5 = (v0) || (v1) ? 60 : 0 + 0xD7;
        if(v2) {
            v4 = 20;
        }

        return k.a(v3, ((float)(v5 - v4)));
    }

    public double getValue() {
        return this.b;
    }

    public void setListener(a arg1) {
        this.m = arg1;
    }

    public void setMachineType(int arg1) {
        this.p = arg1;
    }

    public void setMode(int arg1) {
        this.o = arg1;
    }

    public void setSettingType(int arg1) {
        this.q = arg1;
    }
}
