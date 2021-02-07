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
import apps.b.a.c;
import apps.b.a.d;
import apps.c.j;
import apps.c.k;

@SuppressLint({"NewApi"})
public class AppsMeterRulerView_Phone extends RelativeLayout implements d {
    public interface a {
        void a(AppsMeterRulerView_Phone arg1, double arg2);
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
    private c x;

    public AppsMeterRulerView_Phone(Context arg4) {
        super(arg4);
        this.a = false;
        this.l = 1.0;
        this.r = 0;
        this.a(arg4);
    }

    public AppsMeterRulerView_Phone(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        this.a = false;
        this.l = 1.0;
        this.r = 0;
        this.a(arg3);
    }

    public AppsMeterRulerView_Phone(Context arg3, AttributeSet arg4, int arg5) {
        super(arg3, arg4, arg5);
        this.a = false;
        this.l = 1.0;
        this.r = 0;
        this.a(arg3);
    }

    static GestureDetector a(AppsMeterRulerView_Phone arg0) {
        return arg0.w;
    }

    private void a(Context arg7) {
        this.n = arg7;
        LinearLayout v0 = new LinearLayout(arg7);
        RelativeLayout.LayoutParams v1 = new RelativeLayout.LayoutParams(-1, -1);
        v0.setOrientation(1);
        this.addView(v0, v1);
        v0.setPadding(k.a(arg7, 1.0f), 0, 0, 0);
        this.u = new LinearLayout(arg7);
        this.u.setOrientation(0);
        RelativeLayout.LayoutParams v3 = new RelativeLayout.LayoutParams(-1, k.a(arg7, 39.0f));
        v3.topMargin = k.a(arg7, 3.0f);
        this.u.setPadding(k.a(arg7, 1.0f), 0, 0, 0);
        this.addView(this.u, v3);
        this.setClipChildren(false);
        this.v = new LinearLayout(arg7);
        this.v.setBackgroundColor(arg7.getResources().getColor(0x7F04006F));  // color:white
        this.v.setOrientation(0);
        this.v.setGravity(3);
        LinearLayout.LayoutParams v1_1 = new LinearLayout.LayoutParams(-1, k.a(arg7, 35.0f));
        v1_1.topMargin = k.a(arg7, 5.0f);
        v0.addView(this.v, v1_1);
        this.s = new LinearLayout(arg7);
        this.s.setGravity(80);
        this.s.setOrientation(0);
        LinearLayout.LayoutParams v1_2 = new LinearLayout.LayoutParams(-1, -1);
        v0.addView(this.s, v1_2);
        this.t = new LinearLayout(arg7);
        LinearLayout.LayoutParams v0_1 = new LinearLayout.LayoutParams(-2, k.a(arg7, 40.0f));
        this.v.addView(this.t, v0_1);
        this.t.setBackgroundColor(arg7.getResources().getColor(0x7F040057));  // color:orange
        this.x = new c(this);
        this.w = new GestureDetector(arg7, this.x);
        this.w.setIsLongpressEnabled(false);
        this.setOnTouchListener(new View.OnTouchListener() {
            @Override  // android.view.View$OnTouchListener
            public boolean onTouch(View arg1, MotionEvent arg2) {
                return AppsMeterRulerView_Phone.a(AppsMeterRulerView_Phone.this).onTouchEvent(arg2);
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

        double v2 = this.j;
        int v0_1 = this.d;
        double v6 = (double)v1;
        int v4 = (int)(v2 / ((double)v0_1) * v6);
        int v5 = this.q;
        if(v5 != 18 && v5 != 1 && v5 != 8 && v5 != 5 && v5 != 15 && v5 != 20) {
            if(v5 == 10 && ((int)v2) >= 980) {
                v4 = 1000 / v0_1 * v1;
            }
        }
        else if(((int)this.j) == 99) {
            v4 = (int)(100.0 / ((double)this.d) * v6);
        }

        LinearLayout.LayoutParams v0_2 = (LinearLayout.LayoutParams)this.t.getLayoutParams();
        v0_2.width = v4;
        j.b(".drawSlider.max", this.d + " | " + this.j + "  " + v1 + "   " + v4);
        this.t.setLayoutParams(v0_2);
    }

    @Override  // apps.b.a.d
    public void a(double arg1, c arg3) {
    }

    @Override  // apps.b.a.d
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

        int v13 = this.e;
        if(v0_1 > ((double)v13)) {
            v0_1 = (double)v13;
        }

        double v13_1 = v0_1 < this.i ? this.i : v0_1;
        this.a();
        a v15_2 = this.m;
        if(v15_2 != null) {
            v15_2.a(this, v13_1);
        }
    }

    public void a(boolean arg20) {
        if(!arg20) {
            this.j = this.h;
            this.k = this.h;
        }

        this.x.a(this.e);
        this.x.b(((int)(this.i * this.l)));
        this.x.a(this.l);
        this.x.b(this.j);
        this.s.removeAllViews();
        this.getTotalHeight();
        int v1 = this.getTotalHeight2();
        LinearLayout.LayoutParams v2 = (LinearLayout.LayoutParams)this.s.getLayoutParams();
        this.s.setLayoutParams(v2);
        LinearLayout.LayoutParams v2_1 = (LinearLayout.LayoutParams)this.v.getLayoutParams();
        RelativeLayout.LayoutParams v3 = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
        this.u.setLayoutParams(v3);
        double v3_1 = ((double)this.d) * 1.0 / ((double)this.f);
        int v9 = 1;
        int v10 = 0;
        int v11;
        for(v11 = 0; v9 <= this.f; v11 = v6) {
            TextView v11_1 = new TextView(this.n);
            v11_1.setSingleLine();
            LinearLayout v12 = new LinearLayout(this.n);
            v12.setGravity(17);
            TextView v14 = new TextView(this.n);
            v14.setBackgroundColor(this.n.getResources().getColor(0x7F040014));  // color:black
            v12.addView(v14, new LinearLayout.LayoutParams(1, k.a(this.n, 35.0f)));
            v11_1.setText(this.q == 28 ? apps.c.d.doubleToStr(((double)v9) * v3_1, 1) : apps.c.d.doubleToStr(((int)Math.round(((double)v9) * v3_1)), 0));
            v11_1.setTextColor(this.n.getResources().getColor(0x7F040015));  // color:blue
            v11_1.setGravity(17);
            v11_1.setTextSize(this.q == 10 ? 6.0f : 8.0f);
            v11_1.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams v5 = new LinearLayout.LayoutParams(-1, -2);
            double v14_1 = ((double)v1) * 1.0;
            v5.width = (int)(v14_1 / ((double)this.f));
            if(v9 == 1) {
                v5.leftMargin = v5.width / 2;
            }

            int v6 = v5.width / 2;
            this.s.addView(v11_1, v5);
            v10 += v5.width;
            LinearLayout.LayoutParams v7 = new LinearLayout.LayoutParams(-1, -1);
            v7.width = (int)(v14_1 / ((double)this.f));
            int v8 = v9;
            if(v8 == 1) {
                v7.leftMargin = v5.width / 2;
            }

            this.u.addView(v12, v7);
            if((this.q == 18 || this.q == 1 || this.q == 8 || this.q == 5 || this.q == 15 || this.q == 20 || this.q == 16) && v8 == this.f) {
                v11_1.setText("99");
            }

            if(this.q == 10 && v8 == this.f) {
                v11_1.setText("980");
            }

            v9 = v8 + 1;
        }

        v2_1.width = v10 + v11;
        this.v.setLayoutParams(v2_1);
        double v3_2 = this.i;
        if(this.j < v3_2) {
            this.j = v3_2;
        }

        int v3_3 = this.e;
        if(this.j > ((double)v3_3)) {
            this.j = (double)v3_3;
        }

        this.a();
        a v1_1 = this.m;
        if(v1_1 != null) {
            v1_1.a(this, this.j);
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

        double v2_2 = this.i;
        if(this.j < v2_2) {
            this.j = v2_2;
        }

        double v2_3 = this.i;
        if(this.k < v2_3) {
            this.k = v2_3;
        }

        this.x.b(this.j);
        this.a();
        a v0 = this.m;
        if(v0 != null) {
            v0.a(this, this.j);
        }
    }

    @Override  // apps.b.a.d
    public void b(double arg1, c arg3) {
    }

    public void c() {
        this.j -= this.g;
        this.k -= this.g;
        if(this.q == 1 && (this.j == 0.0 || this.j == 1.0 || this.j == 2.0 || this.j == 3.0 || this.j == 4.0)) {
            this.j = 0.0;
            this.k = this.j;
        }

        j.a("=1111=", "==currentValue: " + this.j + " | " + this.g + " | " + this.d + " | " + this.i);
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
        return k.a(this.n, 245.0f);
    }

    public int getTotalHeight2() {
        return k.a(this.n, 235.0f);
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
