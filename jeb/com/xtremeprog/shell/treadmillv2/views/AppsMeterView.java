package com.xtremeprog.shell.treadmillv2.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import apps.c.d;
import apps.c.j;
import apps.c.k;
import apps.views.AutofitTextView;
import com.xtremeprog.shell.treadmillv2.AppsRunner;

@SuppressLint({"NewApi"})
public class AppsMeterView extends LinearLayout implements View.OnTouchListener, a {
    public interface com.xtremeprog.shell.treadmillv2.views.AppsMeterView.a {
        void a(AppsMeterView arg1, double arg2);
    }

    public AppsMeterRulerView a;
    public com.xtremeprog.shell.treadmillv2.views.AppsMeterView.a b;
    final Handler c;
    private Context d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private double i;
    private float j;
    private int k;
    private AutofitTextView l;
    private AutofitTextView m;
    private Button n;
    private Button o;

    public AppsMeterView(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.h = false;
        this.k = -1;
        this.c = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x2B67) {
                    AppsMeterView.this.b();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsMeterView.this.c();
                }
            }
        };
        this.a(arg1);
    }

    public AppsMeterView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.h = false;
        this.k = -1;
        this.c = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x2B67) {
                    AppsMeterView.this.b();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsMeterView.this.c();
                }
            }
        };
        this.a(arg1);
    }

    private void a(Context arg12) {
        this.d = arg12;
        this.setOrientation(0);
        this.setGravity(17);
        this.setBackgroundColor(arg12.getResources().getColor(0x7F04003D));  // color:fullAlpha
        LinearLayout v2 = new LinearLayout(arg12);
        v2.setGravity(17);
        v2.setOrientation(1);
        this.addView(v2, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout v4 = new RelativeLayout(arg12);
        v4.setGravity(17);
        LinearLayout.LayoutParams v6 = new LinearLayout.LayoutParams(k.a(arg12, 110.0f), -1);
        v6.leftMargin = k.a(arg12, 5.0f);
        v6.rightMargin = k.a(arg12, 5.0f);
        this.addView(v4, v6);
        this.l = new AutofitTextView(arg12);
        this.l.setBackgroundResource(0x7F060114);  // drawable:pad_data_display_l
        this.l.setTextColor(arg12.getResources().getColor(0x7F04006F));  // color:white
        this.l.setTypeface(Typeface.defaultFromStyle(1));
        this.l.setTextSize(16.0f);
        this.l.setGravity(17);
        LinearLayout.LayoutParams v6_1 = new LinearLayout.LayoutParams(k.a(arg12, 70.0f), k.a(arg12, 70.0f));
        v2.addView(this.l, v6_1);
        this.m = new AutofitTextView(arg12);
        this.m.setTextColor(arg12.getResources().getColor(0x7F040015));  // color:blue
        this.m.setTypeface(Typeface.defaultFromStyle(1));
        this.m.setTextSize(12.0f);
        this.m.setGravity(17);
        this.m.setMaxLines(2);
        LinearLayout.LayoutParams v1 = new LinearLayout.LayoutParams(k.a(arg12, 70.0f), -2);
        v1.topMargin = k.a(arg12, 5.0f);
        v2.addView(this.m, v1);
        this.n = new Button(arg12);
        this.n.setBackgroundResource(0x7F06010A);  // drawable:pad_btn_plus2
        RelativeLayout.LayoutParams v1_1 = new RelativeLayout.LayoutParams(k.a(arg12, 60.0f), k.a(arg12, 60.0f));
        v1_1.addRule(10);
        v1_1.addRule(14);
        v4.addView(this.n, v1_1);
        d.h(this.d);
        d.b();
        this.a = new AppsMeterRulerView(arg12);
        RelativeLayout.LayoutParams v1_2 = new RelativeLayout.LayoutParams(k.a(arg12, 100.0f), this.a.getTotalHeight());
        v1_2.addRule(13);
        v4.addView(this.a, v1_2);
        this.a.setListener(this);
        this.o = new Button(arg12);
        this.o.setBackgroundResource(0x7F060107);  // drawable:pad_btn_minus
        RelativeLayout.LayoutParams v1_3 = new RelativeLayout.LayoutParams(k.a(arg12, 59.0f), k.a(arg12, 59.0f));
        v1_3.addRule(12);
        v1_3.addRule(14);
        v4.addView(this.o, v1_3);
        v4.bringChildToFront(this.n);
        v4.bringChildToFront(this.o);
        this.n.setOnTouchListener(this);
        this.o.setOnTouchListener(this);
        this.setClipChildren(false);
        v2.setClipChildren(false);
        v4.setClipChildren(false);
        this.a.setClipChildren(false);
    }

    private void a(boolean arg6, boolean arg7) {
        String v1;
        AutofitTextView v0;
        if(this.f != 1 && this.f != 8 && this.f != 5 && this.f != 15 && this.f != 18) {
            if(this.a.a) {
                v0 = this.l;
                v1 = d.doubleToStr(this.a.k, 1) + "";
            }
            else {
                v0 = this.l;
                v1 = d.doubleToStr(((int)this.i), 0) + "";
            }

            v0.setText(v1);
        }
        else {
            int v0_1 = ((int)this.a.j) * 60;
            String v0_2 = d.d(v0_1) <= 0 ? d.c(v0_1 + "") : d.d(v0_1 + "") + ":00";
            this.l.setText(v0_2);
        }

        if(arg6) {
            this.a.a(((boolean)(((int)arg7))));
        }
    }

    public void a() {
        this.m.setText(this.d.getResources().getText(this.k));
    }

    public void a(int arg8, int arg9, int arg10) {
        this.e = arg8;
        this.g = arg9;
        this.f = arg10;
        this.a.setMode(this.e);
        this.a.setMachineType(this.g);
        this.a.setSettingType(this.f);
        if(this.g == 5) {
            int v8 = this.f;
            if(v8 == 13) {
                goto label_52;
            }

            if(v8 == 25) {
                this.setVisibility(0);
                return;
            }

            if(v8 == 12 || v8 == 7 || v8 == 2) {
                goto label_52;
            }

            if(v8 != 3) {
                return;
            }
        }
        else {
            int v8_1 = this.f;
            if(v8_1 != 13) {
                if(v8_1 == 25) {
                    goto label_52;
                }

                if(v8_1 == 12 || v8_1 == 7 || v8_1 == 2) {
                    this.setVisibility(0);
                    return;
                }

                if(v8_1 == 3) {
                    goto label_52;
                }

                return;
            }
        }

        this.setVisibility(0);
        return;
    label_52:
        this.setVisibility(8);
    }

    public void a(int arg17, int arg18, int arg19, int arg20) {
        double v5_3;
        double v8_2;
        AppsMeterRulerView v1_10;
        double v5_2;
        AppsMeterRulerView v1_9;
        double v5_1;
        AppsMeterView v0 = this;
        v0.k = arg17;
        v0.m.setText(v0.d.getResources().getText(arg17));
        v0.a(arg18, arg19, arg20);
        AppsMeterRulerView v1 = v0.a;
        v1.c = 1;
        v1.d = 1;
        v1.e = 1;
        v1.f = 1;
        double v3 = 1.0;
        v1.g = v3;
        v1.h = v3;
        v1.l = v3;
        int v5 = v0.f;
        double v6 = 15.0;
        double v8 = 30.0;
        if(v5 == 18) {
        label_375:
            v1.f = 10;
            v1.c = 0;
            v1.d = 100;
            v1.e = 99;
            v1.g = v3;
            v1.h = v8;
            v1.i = v6;
        label_382:
            v1.l = v3;
            v1.a = false;
        }
        else {
            if(v5 == 19) {
                v1.f = 20;
            }
            else {
                v6 = 0.0;
                if(v5 == 1) {
                    goto label_375;
                }

                double v8_1 = 0.1;
                double v10 = 0.8;
                double v6_1 = 0.5;
                if(v5 == 2) {
                    v1.f = AppsRunner.get(v0.d).W();
                    AppsMeterRulerView v1_1 = v0.a;
                    v1_1.c = 0;
                    v1_1.d = AppsRunner.get(v0.d).W();
                    AppsMeterRulerView v1_2 = v0.a;
                    v1_2.e = AppsRunner.get(v0.d).W();
                    v0.a.g = v8_1;
                    if(AppsRunner.get(v0.d).Y() != 1) {
                        goto label_284;
                    }

                    v0.a.h = v10;
                    v0.a.i = v10;
                    goto label_287;
                }

                if(v5 != 3) {
                    goto label_80;
                }

                if(v0.g == 5) {
                    v1.f = 10;
                }
                else {
                    v1.f = 20;
                    v1.c = 0;
                    v1.d = 20;
                    v1.e = 20;
                    v1.g = v3;
                    v1.h = v3;
                    v1.i = v3;
                    goto label_382;
                label_80:
                    if(v5 == 4) {
                        if(v0.g != 5) {
                            goto label_321;
                        }

                        v1.f = 10;
                        goto label_313;
                    }

                    if(v5 == 7) {
                        v1.f = AppsRunner.get(v0.d).W();
                        AppsMeterRulerView v1_3 = v0.a;
                        v1_3.c = 0;
                        v1_3.d = AppsRunner.get(v0.d).W();
                        AppsMeterRulerView v1_4 = v0.a;
                        v1_4.e = AppsRunner.get(v0.d).W();
                        v0.a.g = v8_1;
                        if(AppsRunner.get(v0.d).Y() != 1) {
                            goto label_284;
                        }

                        goto label_278;
                    }

                    if(v5 == 6) {
                        goto label_366;
                    }

                    if(v5 == 10) {
                        v1.f = 20;
                        v1.c = 0;
                        v1.d = 1000;
                        v1.e = 980;
                        v1.g = 20.0;
                        v1.h = 100.0;
                        v5_1 = 20.0;
                        v1.i = v5_1;
                        goto label_382;
                    }

                    if(v5 == 12) {
                        v1.f = AppsRunner.get(v0.d).W();
                        AppsMeterRulerView v1_5 = v0.a;
                        v1_5.c = 0;
                        v1_5.d = AppsRunner.get(v0.d).W();
                        AppsMeterRulerView v1_6 = v0.a;
                        v1_6.e = AppsRunner.get(v0.d).W();
                        v0.a.g = v8_1;
                        if(AppsRunner.get(v0.d).Y() != 1) {
                            goto label_284;
                        }

                        goto label_278;
                    }

                    if(v5 == 11) {
                        goto label_366;
                    }

                    if(v5 == 8) {
                        goto label_353;
                    }

                    if(v5 == 9) {
                        goto label_366;
                    }

                    if(v5 == 5) {
                        goto label_353;
                    }

                    if(v5 == 26) {
                        goto label_366;
                    }

                    if(v5 == 22) {
                        v1.f = AppsRunner.get(v0.d).W();
                        AppsMeterRulerView v1_7 = v0.a;
                        v1_7.c = 0;
                        v1_7.d = AppsRunner.get(v0.d).W();
                        AppsMeterRulerView v1_8 = v0.a;
                        v1_8.e = AppsRunner.get(v0.d).W();
                        v0.a.g = v8_1;
                        if(AppsRunner.get(v0.d).Y() == 1) {
                            v1_9 = v0.a;
                            v5_2 = 3.2;
                            goto label_220;
                        }

                        v1_10 = v0.a;
                        v8_2 = 2.0;
                        v1_10.h = v8_2;
                        goto label_286;
                    }

                    if(v5 == 23) {
                        v1.f = AppsRunner.get(v0.d).W();
                        AppsMeterRulerView v1_11 = v0.a;
                        v1_11.c = 0;
                        v1_11.d = AppsRunner.get(v0.d).W();
                        AppsMeterRulerView v1_12 = v0.a;
                        v1_12.e = AppsRunner.get(v0.d).W();
                        v0.a.g = v8_1;
                        if(AppsRunner.get(v0.d).Y() == 1) {
                            v1_9 = v0.a;
                            v5_2 = 5.6;
                        label_220:
                            v1_9.h = v5_2;
                            v5_3 = 0.8;
                            goto label_282;
                        }

                        v1_10 = v0.a;
                        v8_2 = 3.5;
                        v1_10.h = v8_2;
                        goto label_286;
                    }

                    if(v5 == 24) {
                        if(v0.g != 5) {
                            goto label_321;
                        }

                        goto label_310;
                    }

                    if(v5 == 15) {
                        goto label_353;
                    }

                    if(v5 == 16) {
                        v1.f = 10;
                        v1.c = 0;
                        v1.d = 100;
                        v1.e = 99;
                        v1.g = v3;
                        v1.h = (double)AppsRunner.get(v0.d).ad();
                        v1 = v0.a;
                        v5_1 = 13.0;
                        v1.i = v5_1;
                        goto label_382;
                    }

                    if(v5 != 17) {
                        if(v5 == 13) {
                            v1.f = AppsRunner.get(v0.d).W();
                            AppsMeterRulerView v1_13 = v0.a;
                            v1_13.c = 0;
                            v1_13.d = AppsRunner.get(v0.d).W();
                            AppsMeterRulerView v1_14 = v0.a;
                            v1_14.e = AppsRunner.get(v0.d).W();
                            v0.a.g = v8_1;
                            if(AppsRunner.get(v0.d).Y() == 1) {
                            label_278:
                                v1_9 = v0.a;
                                v5_3 = 0.8;
                                v1_9.h = v5_3;
                            label_282:
                                v1_9.i = v5_3;
                            }
                            else {
                            label_284:
                                v1_10 = v0.a;
                                v1_10.h = v6_1;
                            label_286:
                                v1_10.i = v6_1;
                            }

                        label_287:
                            AppsMeterRulerView v1_15 = v0.a;
                            v1_15.a = true;
                            v1_15.l = v3;
                            goto label_385;
                        }

                        if(v5 == 25) {
                            goto label_347;
                        }

                        if(v5 == 20) {
                            v1.f = 10;
                            v1.c = 0;
                            v1.d = 100;
                            v1.e = 99;
                            v1.g = v3;
                            v1.h = 30.0;
                            v5_1 = 10.0;
                            v1.i = v5_1;
                            goto label_382;
                        }

                        if(v5 == 14) {
                            if(v0.g == 5) {
                            label_310:
                                v1.f = 20;
                            label_313:
                                v1.c = 0;
                                v1.d = 20;
                                v1.e = 20;
                                v1.g = v3;
                                v1.h = 0.0;
                                v1.i = 0.0;
                                goto label_382;
                            }

                        label_321:
                            v1.f = 15;
                            v1.c = 0;
                            v1.d = 15;
                            v1.e = 15;
                            v1.g = v6_1;
                            v1.h = 0.0;
                            v1.i = 0.0;
                            v1.a = true;
                            v1.l = 2.0;
                            goto label_385;
                        }

                        if(v5 != 21) {
                            goto label_385;
                        }
                    }

                    v1.f = 10;
                    v1.c = 0;
                    v1.d = 90;
                    v1.e = 90;
                    v1.g = v3;
                    v1.h = 85.0;
                    v5_1 = 50.0;
                    v1.i = v5_1;
                    goto label_382;
                label_347:
                    v1.f = 20;
                }
            }

            v1.c = 0;
            v1.d = 20;
            v1.e = 20;
            v1.g = v3;
            v1.h = v3;
            v1.i = v3;
            goto label_382;
        label_353:
            v1.f = 10;
            v1.c = 0;
            v1.d = 100;
            v1.e = 99;
            v1.g = v3;
            v1.h = 30.0;
            v5_1 = 15.0;
            v1.i = v5_1;
            goto label_382;
        label_366:
            v1.f = 10;
            v1.c = 0;
            v1.d = 10;
            v1.e = 10;
            v1.g = v3;
            v1.h = v3;
            v1.i = v3;
            goto label_382;
        }

    label_385:
        this.f();
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterRulerView$a
    public void a(AppsMeterRulerView arg1, double arg2) {
        this.i = arg2;
        this.a(false, false);
        com.xtremeprog.shell.treadmillv2.views.AppsMeterView.a v1 = this.b;
        if(v1 != null) {
            v1.a(this, this.i);
        }
    }

    public void b() {
        this.a.b();
        this.c.removeMessages(0x2B67);
        Message v0 = new Message();
        v0.what = 0x2B67;
        this.c.sendMessageDelayed(v0, 0xFAL);
    }

    public void c() {
        this.a.c();
        this.c.removeMessages(0x56CE);
        Message v0 = new Message();
        v0.what = 0x56CE;
        this.c.sendMessageDelayed(v0, 0xFAL);
    }

    public void d() {
        this.c.removeMessages(0x2B67);
    }

    public void e() {
        this.c.removeMessages(0x56CE);
    }

    private void f() {
        this.a.j = this.a.h;
        this.a(true, false);
    }

    public float getDefaultValue() {
        return this.j;
    }

    public double getValue() {
        int v0;
        double v3;
        j.a("---finalValue1---", this.i + " |");
        if(this.a.a) {
            v3 = this.i;
            v0 = 1;
        }
        else {
            v3 = (double)(((int)this.i));
            v0 = 0;
        }

        double v0_1 = d.a(d.doubleToStr(v3, v0), 0.0);
        j.a("---finalValue2---", v0_1 + " |");
        return v0_1;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg5, MotionEvent arg6) {
        if(arg6.getAction() == 0) {
            Button v6 = this.n;
            if(arg5 == v6) {
                v6.setBackgroundResource(0x7F060109);  // drawable:pad_btn_plus
                this.b();
                return true;
            }

            Button v6_1 = this.o;
            if(arg5 == v6_1) {
                v6_1.setBackgroundResource(0x7F060107);  // drawable:pad_btn_minus
                this.c();
                return true;
            }
        }
        else if(arg6.getAction() == 1 || arg6.getAction() == 3) {
            Button v6_2 = this.n;
            if(arg5 == v6_2) {
                v6_2.setBackgroundResource(0x7F060109);  // drawable:pad_btn_plus
                this.d();
                return true;
            }

            Button v6_3 = this.o;
            if(arg5 == v6_3) {
                v6_3.setBackgroundResource(0x7F060107);  // drawable:pad_btn_minus
                this.e();
            }
        }

        return true;
    }

    public void setCurrentValue(float arg4) {
        double v1 = (double)arg4;
        this.a.j = v1;
        this.a.k = v1;
        this.i = v1;
        this.a(true, true);
    }

    public void setListener(com.xtremeprog.shell.treadmillv2.views.AppsMeterView.a arg1) {
        this.b = arg1;
    }

    public void setTitleViewLines(int arg2) {
        if(arg2 == 1) {
            this.m.setSingleLine();
            return;
        }

        this.m.setMaxLines(arg2);
    }
}
