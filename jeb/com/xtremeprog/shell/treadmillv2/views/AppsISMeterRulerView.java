package com.xtremeprog.shell.treadmillv2.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"NewApi"})
public class AppsISMeterRulerView extends RelativeLayout implements b {
    public interface a {
        void a(AppsISMeterRulerView arg1, double arg2);
    }

    public boolean a;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;
    public float g;
    public double h;
    public float i;
    public int j;
    public int k;
    final Handler l;
    public a m;
    private Context n;
    private boolean o;
    private LinearLayout p;
    private LinearLayout q;
    private LinearLayout r;
    private TextView s;
    private GestureDetector t;
    private apps.b.a.a u;
    private int v;
    private List w;
    private Timer x;
    private TimerTask y;

    public AppsISMeterRulerView(Context arg3) {
        super(arg3);
        this.o = false;
        this.a = false;
        this.i = 1.0f;
        this.k = -1;
        this.v = 0;
        this.w = new ArrayList();
        this.l = new Handler() {
        };
        this.x = new Timer();
        this.y = new TimerTask() {
            @Override
            public void run() {
                AppsISMeterRulerView.a(AppsISMeterRulerView.this, false);
            }
        };
        this.a(arg3);
    }

    public AppsISMeterRulerView(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.o = false;
        this.a = false;
        this.i = 1.0f;
        this.k = -1;
        this.v = 0;
        this.w = new ArrayList();
        this.l = new Handler() {
        };
        this.x = new Timer();
        this.y = new TimerTask() {
            @Override
            public void run() {
                AppsISMeterRulerView.a(AppsISMeterRulerView.this, false);
            }
        };
        this.a(arg2);
    }

    public AppsISMeterRulerView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.o = false;
        this.a = false;
        this.i = 1.0f;
        this.k = -1;
        this.v = 0;
        this.w = new ArrayList();
        this.l = new Handler() {
        };
        this.x = new Timer();
        this.y = new TimerTask() {
            @Override
            public void run() {
                AppsISMeterRulerView.a(AppsISMeterRulerView.this, false);
            }
        };
        this.a(arg1);
    }

    static GestureDetector a(AppsISMeterRulerView arg0) {
        return arg0.t;
    }

    private void a(Context arg10) {
        LinearLayout.LayoutParams v0_2;
        this.n = arg10;
        this.q = new LinearLayout(arg10);
        this.q.setOrientation(1);
        this.q.setGravity(81);
        RelativeLayout.LayoutParams v0 = new RelativeLayout.LayoutParams(-1, 0);
        this.addView(this.q, v0);
        this.setClipChildren(false);
        this.q.setClipChildren(false);
        this.s = new TextView(arg10);
        this.s.setSingleLine();
        this.s.setTextColor(arg10.getResources().getColor(0x7F04006F));  // color:white
        int v4 = 17;
        this.s.setGravity(17);
        boolean v0_1 = d.h(this.n);
        boolean v5 = AppsRunner.get(arg10).inclineSupportsHalfDegree(arg10);
        boolean v6 = AppsRunner.get(arg10).ac();
        int v7 = v0_1 ? 13 : 8;
        if(!v0_1) {
            v4 = 12;
        }

        if(this.k == 1) {
            this.s.setTextSize(v6 ? ((float)v7) : ((float)v4));
        }
        else {
            this.s.setTextSize(v5 ? ((float)v7) : ((float)v4));
        }

        if(v0_1) {
            this.s.setBackgroundResource(0x7F0600BB);  // drawable:apps_meter_orange_round_shape_galaxytab10
            v0_2 = new LinearLayout.LayoutParams(k.a(arg10, 40.0f), k.a(arg10, 40.0f));
        }
        else {
            this.s.setBackgroundResource(0x7F0600BA);  // drawable:apps_meter_orange_round_shape
            v0_2 = new LinearLayout.LayoutParams(k.a(arg10, 30.0f), k.a(arg10, 30.0f));
        }

        this.q.addView(this.s, v0_2);
        this.q.setPadding(0, 0, 0, 0);
        RelativeLayout v0_3 = new RelativeLayout(arg10);
        this.addView(v0_3, new RelativeLayout.LayoutParams(-1, -1));
        this.setClipChildren(false);
        this.bringChildToFront(this.q);
        this.r = new LinearLayout(arg10);
        RelativeLayout.LayoutParams v2 = new RelativeLayout.LayoutParams(k.a(arg10, 25.0f), this.getTotalHeight());
        v2.addRule(14);
        this.r.setBackgroundColor(Color.parseColor("#00000000"));
        v0_3.addView(this.r, v2);
        this.p = new LinearLayout(arg10);
        this.p.setOrientation(1);
        RelativeLayout.LayoutParams v1 = new RelativeLayout.LayoutParams(k.a(arg10, 25.0f), 0);
        v1.addRule(14);
        v0_3.addView(this.p, v1);
        v0_3.setClipChildren(false);
        this.u = new apps.b.a.a(this);
        this.t = new GestureDetector(arg10, this.u);
        this.t.setIsLongpressEnabled(false);
        this.setOnTouchListener(new View.OnTouchListener() {
            @Override  // android.view.View$OnTouchListener
            public boolean onTouch(View arg1, MotionEvent arg2) {
                return AppsISMeterRulerView.a(AppsISMeterRulerView.this).onTouchEvent(arg2);
            }
        });
    }

    static boolean a(AppsISMeterRulerView arg0, boolean arg1) {
        arg0.o = arg1;
        return arg1;
    }

    public void a() {
        float v15_2;
        float v11_1;
        AppsISMeterRulerView v0 = this;
        v0.h = (double)v0.f;
        v0.u.a(v0.c);
        v0.u.b(((int)(v0.g * v0.i)));
        v0.u.a(((double)v0.i));
        v0.u.b(v0.h);
        v0.u.a(false);
        v0.v = (int)d.c(v0.h / ((double)v0.e), 1);
        int v3 = (int)(((float)this.getTotalHeight()) * 1.0f / ((float)this.getN()));
        RelativeLayout.LayoutParams v5 = (RelativeLayout.LayoutParams)v0.r.getLayoutParams();
        v5.height = this.getN() * v3;
        v0.r.setLayoutParams(v5);
        RelativeLayout.LayoutParams v5_1 = (RelativeLayout.LayoutParams)v0.q.getLayoutParams();
        v5_1.height = this.getN() * v3;
        v0.q.setLayoutParams(v5_1);
        v0.q.setClipChildren(false);
        RelativeLayout.LayoutParams v5_2 = (RelativeLayout.LayoutParams)v0.p.getLayoutParams();
        v5_2.height = this.getN() * v3;
        v5_2.topMargin = v3 / 2;
        v0.p.setLayoutParams(v5_2);
        v0.p.setClipChildren(false);
        LinearLayout.LayoutParams v5_3 = (LinearLayout.LayoutParams)v0.s.getLayoutParams();
        v0.s.setLayoutParams(v5_3);
        this.d();
        v0.p.removeAllViews();
        float v5_4 = ((float)v0.c) * 1.0f / ((float)v0.d);
        boolean v4 = AppsRunner.get(v0.n).inclineSupportsHalfDegree(v0.n);
        boolean v6 = AppsRunner.get(v0.n).ac();
        boolean v7 = d.h(v0.n);
        d.b();
        int v8 = 10;
        int v9 = v7 ? 10 : 6;
        if(v7) {
            v8 = 14;
        }

        if(v0.j == 0) {
            int v10;
            for(v10 = this.getN(); v10 > -1; --v10) {
                TextView v15 = new TextView(v0.n);
                int v11 = v10 - 1;
                int v12 = Math.round(((float)v11) * v5_4) - ((int)v7);
                if(v11 > -1) {
                    v15.setText(v0.a ? d.doubleToStr(v12, 1) : d.doubleToStr(v12, 0));
                }

                v15.setTextColor(v0.n.getResources().getColor(0x7F04006F));  // color:white
                v15.setGravity(17);
                if(v0.k != 1) {
                    v11_1 = v4 ? ((float)v9) : ((float)v8);
                }
                else if(v6) {
                    v11_1 = (float)v9;
                }
                else {
                    v11_1 = (float)v8;
                }

                v15.setTextSize(v11_1);
                if(v7) {
                    v15.setPadding(0, 0, 0, 0);
                }
                else {
                    v15.setPadding(0, k.a(v0.n, 2.0f), 0, 0);
                }

                LinearLayout.LayoutParams v11_2 = new LinearLayout.LayoutParams(-1, v3);
                v11_2.height = v3;
                v0.p.addView(v15, v11_2);
                if((v7) && (v10 == this.getN() || v10 == 1)) {
                    v15.setVisibility(4);
                }
            }
        }
        else {
            int v10_1;
            for(v10_1 = this.getN(); v10_1 > 0; --v10_1) {
                TextView v11_3 = new TextView(v0.n);
                int v12_1 = v10_1 - 1;
                int v15_1 = Math.round(((float)v12_1) * v5_4);
                if(v12_1 != 0) {
                    v11_3.setText(v0.a ? d.doubleToStr(v15_1, 1) : d.doubleToStr(v15_1, 0));
                }

                v11_3.setTextColor(v0.n.getResources().getColor(0x7F04006F));  // color:white
                v11_3.setGravity(17);
                if(v0.k != 1) {
                    v15_2 = v4 ? ((float)v9) : ((float)v8);
                }
                else if(v6) {
                    v15_2 = (float)v9;
                }
                else {
                    v15_2 = (float)v8;
                }

                v11_3.setTextSize(v15_2);
                if(v7) {
                    v11_3.setPadding(0, 0, 0, 0);
                }
                else {
                    v11_3.setPadding(0, k.a(v0.n, 2.0f), 0, 0);
                }

                LinearLayout.LayoutParams v15_3 = new LinearLayout.LayoutParams(-1, v3);
                v15_3.height = v3;
                v0.p.addView(v11_3, v15_3);
            }
        }

        this.c();
        a v1 = v0.m;
        if(v1 != null) {
            v1.a(v0, v0.h);
        }

        this.h();
        this.b();
    }

    @Override  // apps.b.a.b
    public void a(double arg1, apps.b.a.a arg3) {
    }

    @Override  // apps.b.a.b
    public void a(double arg3, boolean arg5) {
        float v5 = this.e;
        this.h = (double)(((float)(((int)(arg3 / ((double)v5))))) * v5);
        this.v = (int)(this.h / ((double)v5));
        this.c();
        this.h();
        this.b();
        a v3 = this.m;
        if(v3 != null) {
            v3.a(this, this.h);
        }
    }

    public void b() {
    }

    @Override  // apps.b.a.b
    public void b(double arg1, apps.b.a.a arg3) {
    }

    public void c() {
        this.d();
    }

    public void d() {
        float v3_1;
        Context v1_1;
        int v0_2;
        LinearLayout v2_1;
        int v0 = (int)(((float)this.getTotalHeight()) * 1.0f / ((float)this.getN()));
        boolean v1 = AppsRunner.get(this.n).inclineSupportsHalfDegree(this.n);
        boolean v2 = d.h(this.n);
        boolean v3 = d.a();
        boolean v4 = d.b();
        double v0_1 = (double)(((float)!v2 || this.j != 0 ? v0 * this.v : v0 * (this.v + (((int)v1) ^ 1) + 1)) / this.i);
        if(v2) {
            v2_1 = this.q;
            v0_2 = (int)v0_1;
            v1_1 = this.n;
            v3_1 = 22.0f;
            v2_1.setPadding(0, 0, 0, v0_2 - k.a(v1_1, v3_1));
            return;
        }

        if(!v3 && (v4)) {
            v2_1 = this.q;
            v0_2 = (int)v0_1;
            v1_1 = this.n;
            v3_1 = 16.0f;
            v2_1.setPadding(0, 0, 0, v0_2 - k.a(v1_1, v3_1));
            return;
        }

        this.q.setPadding(0, 0, 0, ((int)v0_1) - k.a(this.n, 18.0f));
    }

    public void e() {
        Timer v0 = this.x;
        if(v0 != null) {
            v0.cancel();
            this.x = null;
        }

        TimerTask v0_1 = this.y;
        if(v0_1 != null) {
            v0_1.cancel();
            this.y = null;
        }

        this.x = new Timer();
        this.y = new TimerTask() {
            @Override
            public void run() {
                AppsISMeterRulerView.a(AppsISMeterRulerView.this, false);
            }
        };
    }

    public void f() {
        this.o = true;
        this.e();
        this.x.schedule(this.y, 2000L);
        this.h += (double)this.e;
        int v3 = this.c;
        if(this.h > ((double)v3)) {
            this.h = (double)v3;
        }

        this.u.b(this.h);
        this.v = (int)d.c(this.h / ((double)this.e), 1);
        this.c();
        this.h();
        this.b();
        a v0 = this.m;
        if(v0 != null) {
            v0.a(this, this.h);
        }
    }

    public void g() {
        this.o = true;
        this.e();
        this.x.schedule(this.y, 2000L);
        this.h -= (double)this.e;
        float v3 = this.g;
        if(this.h < ((double)v3)) {
            this.h = (double)v3;
        }

        this.u.b(this.h);
        this.v = (int)d.c(this.h / ((double)this.e), 1);
        this.c();
        this.h();
        this.b();
        a v0 = this.m;
        if(v0 != null) {
            v0.a(this, this.h);
        }
    }

    public int getN() {
        return !d.h(this.n) || this.j != 0 ? this.d + 1 : this.d + 3;
    }

    public int getTotalHeight() {
        boolean v0 = d.h(this.n);
        boolean v1 = d.b();
        Context v2 = this.n;
        if(v0) {
            return k.a(v2, 5.324934E-43f);
        }

        return v1 ? k.a(v2, 4.904545E-43f) : k.a(v2, 3.503246E-43f);
    }

    public double getValue() {
        return this.h;
    }

    private void h() {
        String v1_1;
        TextView v0_1;
        j.a("====setTrackText====", this.h + "  |  " + this.v);
        String v0 = ((int)Math.rint(this.h)) + ".0";
        String v1 = ((int)Math.rint(this.h)) + "";
        String v2 = d.c(this.h, 1) + "";
        j.a("setTrackText", "a : " + v0 + " b : " + v2 + " result : " + d.a(v0, v2) + " c : " + v1);
        if(d.a(v0, v2)) {
            v0_1 = this.s;
            v1_1 = v1 + "";
        }
        else {
            v0_1 = this.s;
            v1_1 = d.c(this.h, 1) + "";
        }

        v0_1.setText(v1_1);
    }

    public void setListener(a arg1) {
        this.m = arg1;
    }

    public void setValue(double arg7) {
        if(this.o) {
            return;
        }

        this.h = arg7;
        int v2 = this.c;
        if(this.h > ((double)v2)) {
            this.h = (double)v2;
        }

        float v2_1 = this.g;
        if(this.h < ((double)v2_1)) {
            this.h = (double)v2_1;
        }

        this.v = (int)d.c(this.h / ((double)this.e), 1);
        j.a("---speed setValue---", this.o + " | " + arg7 + " | " + this.v + " | " + this.h);
        this.c();
        this.h();
        this.b();
        a v7 = this.m;
        if(v7 != null) {
            v7.a(this, this.h);
        }
    }
}
