package com.xtremeprog.shell.treadmillv2.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apps.b.a.b;
import apps.c.d;
import apps.c.k;
import apps.views.AutofitTextView;
import com.xtremeprog.shell.treadmillv2.AppsRunner;

@SuppressLint({"NewApi"})
public class AppsISMeterView extends RelativeLayout implements View.OnTouchListener, b, a {
    public interface com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.a {
        void setSpeedIncline(AppsISMeterView arg1, double arg2, int arg3);
    }

    public AppsISMeterRulerView a;
    public boolean b;
    public boolean c;
    public com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.a d;
    final Handler e;
    private Context f;
    private TextView g;
    private Button h;
    private Button i;
    private Button j;
    private Button k;
    private GestureDetector l;
    private apps.b.a.a m;
    private GestureDetector n;
    private apps.b.a.a o;
    private int p;
    private View.OnTouchListener q;
    private View.OnTouchListener r;

    public AppsISMeterView(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.p = -1;
        this.b = false;
        this.c = true;
        this.q = null;
        this.r = null;
        this.e = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x2B67) {
                    AppsISMeterView.this.a();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsISMeterView.this.b();
                }
            }
        };
        this.a(arg1);
    }

    public AppsISMeterView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.p = -1;
        this.b = false;
        this.c = true;
        this.q = null;
        this.r = null;
        this.e = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x2B67) {
                    AppsISMeterView.this.a();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsISMeterView.this.b();
                }
            }
        };
        this.a(arg1);
    }

    static GestureDetector a(AppsISMeterView arg0) {
        return arg0.l;
    }

    private void a(Context arg17) {
        int v7_2;
        int v15;
        AppsISMeterView v0 = this;
        Context v1 = arg17;
        v0.f = v1;
        LinearLayout v2 = new LinearLayout(v1);
        v0.addView(v2, new RelativeLayout.LayoutParams(-1, -2));
        v2.setOrientation(1);
        v2.setGravity(17);
        v2.setBackgroundColor(arg17.getResources().getColor(0x7F04003D));  // color:fullAlpha
        v0.h = new Button(v1);
        v0.h.setBackgroundResource(0x7F060109);  // drawable:pad_btn_plus
        LinearLayout.LayoutParams v7 = new LinearLayout.LayoutParams(k.a(v1, 50.0f), k.a(v1, 50.0f));
        v2.addView(v0.h, v7);
        boolean v7_1 = d.h(v0.f);
        boolean v10 = d.b();
        v0.a = new AppsISMeterRulerView(v1);
        int v13 = k.a(v1, 80.0f);
        if(v7_1) {
            v15 = 130;
        }
        else {
            v15 = v10 ? 100 : 0;
        }

        LinearLayout.LayoutParams v11 = new LinearLayout.LayoutParams(v13, k.a(v1, ((float)(v15 + 0xFA))));
        v11.topMargin = k.a(v1, 5.0f);
        v11.bottomMargin = k.a(v1, 5.0f);
        v0.setClipChildren(false);
        v2.setClipChildren(false);
        v2.addView(v0.a, v11);
        v0.a.setListener(v0);
        v0.i = new Button(v1);
        v0.i.setBackgroundResource(0x7F060107);  // drawable:pad_btn_minus
        LinearLayout.LayoutParams v11_1 = new LinearLayout.LayoutParams(k.a(v1, 50.0f), k.a(v1, 50.0f));
        v11_1.topMargin = k.a(v1, 10.0f);
        v2.addView(v0.i, v11_1);
        v0.g = new AutofitTextView(v1);
        v0.g.setTextColor(arg17.getResources().getColor(0x7F04006F));  // color:white
        v0.g.setTypeface(Typeface.defaultFromStyle(1));
        v0.g.setTextSize(14.0f);
        v0.g.setGravity(17);
        v0.g.setSingleLine();
        LinearLayout.LayoutParams v9 = new LinearLayout.LayoutParams(k.a(v1, 80.0f), -2);
        v9.topMargin = k.a(v1, 5.0f);
        v2.addView(v0.g, v9);
        LinearLayout v2_1 = new LinearLayout(v1);
        v0.addView(v2_1, new RelativeLayout.LayoutParams(-1, -2));
        v2_1.setOrientation(1);
        v2_1.setGravity(17);
        v2_1.setBackgroundColor(arg17.getResources().getColor(0x7F04003D));  // color:fullAlpha
        v0.j = new Button(v1);
        LinearLayout.LayoutParams v8 = new LinearLayout.LayoutParams(-1, k.a(v1, 70.0f));
        v2_1.addView(v0.j, v8);
        v0.j.setBackgroundDrawable(null);
        LinearLayout v8_1 = new LinearLayout(v1);
        int v14 = k.a(v1, 80.0f);
        if(v7_1) {
            v7_2 = 130;
        }
        else {
            v7_2 = v10 ? 100 : 0;
        }

        v2_1.addView(v8_1, new LinearLayout.LayoutParams(v14, k.a(v1, ((float)(v7_2 + 210)))));
        v0.k = new Button(v1);
        LinearLayout.LayoutParams v7_3 = new LinearLayout.LayoutParams(-1, k.a(v1, 70.0f));
        v2_1.addView(v0.k, v7_3);
        v0.k.setBackgroundDrawable(null);
        TextView v5 = new TextView(v1);
        v5.setTypeface(Typeface.defaultFromStyle(1));
        v5.setTextSize(14.0f);
        v5.setGravity(17);
        v5.setSingleLine();
        v2_1.addView(v5, new LinearLayout.LayoutParams(k.a(v1, 80.0f), -2));
        v0.m = new apps.b.a.a(v0);
        v0.l = new GestureDetector(v1, v0.m);
        v0.l.setIsLongpressEnabled(true);
        com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.1 v2_2 = new View.OnTouchListener() {
            @Override  // android.view.View$OnTouchListener
            public boolean onTouch(View arg3, MotionEvent arg4) {
                if(AppsISMeterView.this.c) {
                    if(arg4.getAction() == 0) {
                        AppsISMeterView.this.b = true;
                        return AppsISMeterView.a(AppsISMeterView.this).onTouchEvent(arg4);
                    }

                    if((arg4.getAction() == 1 || arg4.getAction() == 3) && (arg3 == AppsISMeterView.b(AppsISMeterView.this) || arg3 == AppsISMeterView.c(AppsISMeterView.this))) {
                        AppsISMeterView.this.e();
                        AppsISMeterView.this.b = false;
                    }
                }

                return AppsISMeterView.a(AppsISMeterView.this).onTouchEvent(arg4);
            }
        };
        v0.r = v2_2;
        v0.h.setOnTouchListener(v2_2);
        v0.j.setOnTouchListener(v2_2);
        v0.o = new apps.b.a.a(v0);
        v0.n = new GestureDetector(v1, v0.o);
        v0.n.setIsLongpressEnabled(true);
        com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.2 v1_1 = new View.OnTouchListener() {
            @Override  // android.view.View$OnTouchListener
            public boolean onTouch(View arg3, MotionEvent arg4) {
                if(AppsISMeterView.this.c) {
                    if(arg4.getAction() == 0) {
                        AppsISMeterView.this.b = true;
                        return AppsISMeterView.d(AppsISMeterView.this).onTouchEvent(arg4);
                    }

                    if((arg4.getAction() == 1 || arg4.getAction() == 3) && (arg3 == AppsISMeterView.e(AppsISMeterView.this) || arg3 == AppsISMeterView.f(AppsISMeterView.this))) {
                        AppsISMeterView.this.f();
                        AppsISMeterView.this.b = false;
                    }
                }

                return AppsISMeterView.d(AppsISMeterView.this).onTouchEvent(arg4);
            }
        };
        v0.q = v1_1;
        v0.i.setOnTouchListener(v1_1);
        v0.k.setOnTouchListener(v1_1);
    }

    public void a() {
        this.a.f();
        com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.a v0 = this.d;
        if(v0 != null) {
            v0.setSpeedIncline(this, this.a.getValue(), 1);
        }

        this.e.removeMessages(0x2B67);
        Message v0_1 = new Message();
        v0_1.what = 0x2B67;
        this.e.sendMessageDelayed(v0_1, 0xFAL);
    }

    @Override  // apps.b.a.b
    public void a(double arg3, apps.b.a.a arg5) {
        if(!this.c) {
            return;
        }

        if(arg5 == this.m) {
            this.a.f();
            com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.a v3 = this.d;
            if(v3 != null) {
                v3.setSpeedIncline(this, this.a.getValue(), 0);
            }

            this.e();
            this.b = false;
            return;
        }

        if(arg5 == this.o) {
            this.a.g();
            com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.a v3_1 = this.d;
            if(v3_1 != null) {
                v3_1.setSpeedIncline(this, this.a.getValue(), 0);
            }

            this.f();
            this.b = false;
            return;
        }
    }

    @Override  // apps.b.a.b
    public void a(double arg1, boolean arg3) {
    }

    public void a(int arg5, int arg6, int arg7, int arg8) {
        this.p = arg5;
        this.g.setText(this.f.getResources().getText(arg5));
        AppsISMeterRulerView v5 = this.a;
        v5.b = 1;
        v5.c = 1;
        v5.d = 1;
        v5.e = 1.0f;
        v5.f = 1.0f;
        v5.i = 1.0f;
        v5.j = arg8;
        if(arg8 == 0) {
            if(arg7 == 5) {
                v5.d = 20;
                v5.b = 0;
                v5.c = 20;
                v5.e = 1.0f;
                v5.f = 0.0f;
                v5.g = 0.0f;
                v5.i = 1.0f;
            }
            else {
                v5.d = 15;
                v5.b = 0;
                v5.c = 15;
                v5.e = 0.5f;
                v5.f = 0.0f;
                v5.g = 0.0f;
                v5.i = 2.0f;
            }
        }
        else if(arg8 == 1) {
            v5.d = AppsRunner.get(this.f).W();
            AppsISMeterRulerView v5_1 = this.a;
            v5_1.b = 0;
            v5_1.c = AppsRunner.get(this.f).W();
            this.a.e = 0.1f;
            this.a.i = 10.0f;
            if(AppsRunner.get(this.f).Y() == 1) {
                this.a.f = 0.8f;
                this.a.g = 0.8f;
            }
            else {
                this.a.f = 0.5f;
                this.a.g = 0.5f;
            }
        }
        else if(arg8 == 2) {
            v5.d = 20;
            v5.b = 1;
            v5.c = 20;
            v5.e = 1.0f;
            v5.f = 1.0f;
            v5.g = 1.0f;
            v5.i = 1.0f;
        }

        this.h();
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsISMeterRulerView$a
    public void a(AppsISMeterRulerView arg1, double arg2) {
        this.b(false);
    }

    public void a(boolean arg3) {
        if(arg3) {
            this.h.setVisibility(4);
            this.i.setVisibility(4);
            this.h.setOnTouchListener(null);
            this.i.setOnTouchListener(null);
            this.j.setVisibility(4);
            this.k.setVisibility(4);
            this.j.setOnTouchListener(null);
            this.k.setOnTouchListener(null);
            return;
        }

        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.h.setOnTouchListener(this.r);
        this.i.setOnTouchListener(this.q);
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.j.setOnTouchListener(this.r);
        this.k.setOnTouchListener(this.q);
    }

    static Button b(AppsISMeterView arg0) {
        return arg0.h;
    }

    private void b(boolean arg1) {
        if(arg1) {
            this.a.a();
        }
    }

    public void b() {
        this.a.g();
        com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.a v0 = this.d;
        if(v0 != null) {
            v0.setSpeedIncline(this, this.a.getValue(), 1);
        }

        this.e.removeMessages(0x56CE);
        Message v0_1 = new Message();
        v0_1.what = 0x56CE;
        this.e.sendMessageDelayed(v0_1, 0xFAL);
    }

    @Override  // apps.b.a.b
    public void b(double arg1, apps.b.a.a arg3) {
        if(!this.c) {
            return;
        }

        if(arg3 == this.m) {
            this.b = true;
            this.c();
            return;
        }

        if(arg3 == this.o) {
            this.b = true;
            this.d();
        }
    }

    static Button c(AppsISMeterView arg0) {
        return arg0.j;
    }

    public void c() {
        this.a.f();
        com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.a v0 = this.d;
        if(v0 != null) {
            v0.setSpeedIncline(this, this.a.getValue(), 0);
        }

        this.e.removeMessages(0x2B67);
        Message v0_1 = new Message();
        v0_1.what = 0x2B67;
        this.e.sendMessageDelayed(v0_1, 0xFAL);
    }

    static GestureDetector d(AppsISMeterView arg0) {
        return arg0.n;
    }

    public void d() {
        this.a.g();
        com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.a v0 = this.d;
        if(v0 != null) {
            v0.setSpeedIncline(this, this.a.getValue(), 0);
        }

        this.e.removeMessages(0x56CE);
        Message v0_1 = new Message();
        v0_1.what = 0x56CE;
        this.e.sendMessageDelayed(v0_1, 0xFAL);
    }

    static Button e(AppsISMeterView arg0) {
        return arg0.i;
    }

    public void e() {
        this.e.removeMessages(0x2B67);
    }

    static Button f(AppsISMeterView arg0) {
        return arg0.k;
    }

    public void f() {
        this.e.removeMessages(0x56CE);
    }

    public void g() {
        this.g.setText(this.f.getResources().getText(this.p));
    }

    public double getValue() {
        return this.a.getValue();
    }

    private void h() {
        this.a.h = (double)this.a.f;
        this.b(true);
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg3, MotionEvent arg4) {
        if(this.c) {
            if(arg4.getAction() == 0) {
                if(arg3 == this.h || arg3 == this.j) {
                    this.b = true;
                    this.a();
                    return true;
                }

                if(arg3 == this.i || arg3 == this.k) {
                    this.b = true;
                    this.b();
                    return true;
                    this.b = true;
                    this.a();
                    return true;
                }
            }
            else if(arg4.getAction() == 1 || arg4.getAction() == 3) {
                if(arg3 == this.h || arg3 == this.j) {
                    this.e();
                    this.b = false;
                }
                else if(arg3 == this.i || arg3 == this.k) {
                    this.f();
                    this.b = false;
                    return true;
                }
            }
        }

        return true;
    }

    public void setListener(com.xtremeprog.shell.treadmillv2.views.AppsISMeterView.a arg1) {
        this.d = arg1;
    }

    public void setValue(double arg2) {
        this.a.setValue(arg2);
    }
}
