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
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import apps.c.d;
import apps.c.j;
import apps.c.k;
import apps.views.AutofitTextView;
import com.xtremeprog.shell.treadmillv2.AppsRunner;

@SuppressLint({"NewApi"})
public class AppsMeterView_Phone extends RelativeLayout implements View.OnTouchListener, a {
    public interface com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone.a {
        void a(AppsMeterView_Phone arg1, double arg2);
    }

    public int a;
    public AppsMeterRulerView_Phone b;
    public com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone.a c;
    final Handler d;
    private Context e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private double j;
    private float k;
    private int l;
    private AutofitTextView m;
    private AutofitTextView n;
    private Button o;
    private Button p;

    public AppsMeterView_Phone(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.i = false;
        this.l = -1;
        this.d = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x2B67) {
                    AppsMeterView_Phone.this.d();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsMeterView_Phone.this.e();
                }
            }
        };
        this.a(arg1);
    }

    public AppsMeterView_Phone(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.i = false;
        this.l = -1;
        this.d = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                if(arg3.what == 0x2B67) {
                    AppsMeterView_Phone.this.d();
                    return;
                }

                if(arg3.what == 0x56CE) {
                    AppsMeterView_Phone.this.e();
                }
            }
        };
        this.a(arg1);
    }

    private void a(Context arg17) {
        LinearLayout v2 = new LinearLayout(arg17);
        this.addView(v2, new RelativeLayout.LayoutParams(-1, -1));
        this.e = arg17;
        v2.setOrientation(1);
        v2.setGravity(17);
        this.setBackgroundColor(arg17.getResources().getColor(0x7F04003D));  // color:fullAlpha
        LinearLayout v6 = new LinearLayout(arg17);
        v6.setGravity(17);
        v6.setOrientation(0);
        v2.addView(v6, new RelativeLayout.LayoutParams(-2, -2));
        RelativeLayout v8 = new RelativeLayout(arg17);
        v8.setGravity(17);
        RelativeLayout.LayoutParams v10 = new RelativeLayout.LayoutParams(-1, k.a(arg17, 60.0f));
        v10.topMargin = k.a(arg17, 10.0f);
        v10.bottomMargin = k.a(arg17, 5.0f);
        v2.addView(v8, v10);
        LinearLayout v10_1 = new LinearLayout(arg17);
        v10_1.setGravity(21);
        v10_1.setOrientation(0);
        v10_1.setPadding(0, 0, k.a(arg17, 5.0f), 0);
        v6.addView(v10_1, new RelativeLayout.LayoutParams(k.a(arg17, 80.0f), -2));
        this.n = new AutofitTextView(arg17);
        this.n.setTextColor(arg17.getResources().getColor(0x7F040015));  // color:blue
        this.n.setTypeface(Typeface.defaultFromStyle(1));
        this.n.setTextSize(10.0f);
        this.n.setGravity(17);
        this.n.setMaxLines(2);
        RelativeLayout.LayoutParams v4 = new RelativeLayout.LayoutParams(k.a(arg17, 60.0f), -2);
        v10_1.addView(this.n, v4);
        this.m = new AutofitTextView(arg17);
        this.m.setBackgroundResource(0x7F060114);  // drawable:pad_data_display_l
        this.m.setTextColor(arg17.getResources().getColor(0x7F04006F));  // color:white
        this.m.setTypeface(Typeface.defaultFromStyle(1));
        this.m.setTextSize(14.0f);
        this.m.setGravity(17);
        RelativeLayout.LayoutParams v4_1 = new RelativeLayout.LayoutParams(k.a(arg17, 60.0f), k.a(arg17, 60.0f));
        v6.addView(this.m, v4_1);
        AutofitTextView v4_2 = new AutofitTextView(arg17);
        v4_2.setTypeface(Typeface.defaultFromStyle(1));
        v4_2.setTextSize(14.0f);
        v4_2.setMaxLines(2);
        v4_2.setVisibility(4);
        v4_2.setPadding(k.a(arg17, 5.0f), 0, 0, 0);
        v6.addView(v4_2, new RelativeLayout.LayoutParams(k.a(arg17, 80.0f), -2));
        this.o = new Button(arg17);
        this.o.setBackgroundResource(0x7F060109);  // drawable:pad_btn_plus
        RelativeLayout.LayoutParams v3 = new RelativeLayout.LayoutParams(k.a(arg17, 45.0f), k.a(arg17, 45.0f));
        v3.topMargin = k.a(arg17, 5.0f);
        v3.addRule(11);
        v8.addView(this.o, v3);
        this.b = new AppsMeterRulerView_Phone(arg17);
        RelativeLayout.LayoutParams v3_1 = new RelativeLayout.LayoutParams(this.b.getTotalHeight(), k.a(arg17, 85.0f));
        v3_1.topMargin = k.a(arg17, 5.0f);
        v3_1.addRule(14);
        v8.addView(this.b, v3_1);
        this.b.setListener(this);
        this.p = new Button(arg17);
        this.p.setBackgroundResource(0x7F060107);  // drawable:pad_btn_minus
        RelativeLayout.LayoutParams v3_2 = new RelativeLayout.LayoutParams(k.a(arg17, 45.0f), k.a(arg17, 45.0f));
        v3_2.topMargin = k.a(arg17, 5.0f);
        v3_2.addRule(9);
        v8.addView(this.p, v3_2);
        v8.bringChildToFront(this.o);
        v8.bringChildToFront(this.p);
        this.o.setOnTouchListener(this);
        this.p.setOnTouchListener(this);
        this.setClipChildren(false);
        v2.setClipChildren(false);
        v6.setClipChildren(false);
        v10_1.setClipChildren(false);
        v8.setClipChildren(false);
        this.b.setClipChildren(false);
    }

    private void a(boolean arg7, boolean arg8) {
        if(this.g == 1 || this.g == 8 || this.g == 5 || this.g == 15 || this.g == 18) {
            int v0_1 = ((int)this.b.j) * 60;
            String v0_2 = d.d(v0_1) <= 0 ? d.c(v0_1 + "") : d.d(v0_1 + "") + ":00";
            this.m.setText(v0_2);
        }
        else if(this.b.a) {
            double v2 = this.b.k >= this.b.i ? this.b.k : this.b.i;
            if(v2 > ((double)this.b.e)) {
                v2 = (double)this.b.e;
            }

            this.m.setText(d.doubleToStr(v2, 1) + "");
        }
        else {
            double v0 = this.j >= this.b.i ? this.j : this.b.i;
            if(v0 > ((double)this.b.e)) {
                v0 = (double)this.b.e;
            }

            this.m.setText(d.doubleToStr(((int)v0), 0) + "");
        }

        if(arg7) {
            this.b.a(((boolean)(((int)arg8))));
        }
    }

    public void a() {
        this.n.setText(this.e.getResources().getText(this.l));
    }

    public void a(int arg8, int arg9, int arg10) {
        this.f = arg8;
        this.h = arg9;
        this.g = arg10;
        this.b.setMode(this.f);
        this.b.setMachineType(this.h);
        this.b.setSettingType(this.g);
        if(this.h == 5) {
            int v8 = this.g;
            if(v8 == 13) {
                goto label_54;
            }

            if(v8 == 25) {
                this.setVisibility(0);
                return;
            }

            if(v8 == 12) {
                this.setVisibility(4);
                return;
            }

            if(v8 == 7 || v8 == 2) {
                goto label_54;
            }

            if(v8 != 3) {
                return;
            }
        }
        else {
            int v8_1 = this.g;
            if(v8_1 != 13) {
                if(v8_1 == 25) {
                    goto label_54;
                }

                if(v8_1 == 12 || v8_1 == 7 || v8_1 == 2) {
                    this.setVisibility(0);
                    return;
                }

                if(v8_1 == 3) {
                    goto label_54;
                }

                return;
            }
        }

        this.setVisibility(0);
        return;
    label_54:
        this.setVisibility(8);
    }

    public void a(int arg17, int arg18, int arg19, int arg20) {
        double v5_4;
        double v5_3;
        AppsMeterRulerView_Phone v1_10;
        double v5_2;
        AppsMeterRulerView_Phone v1_9;
        double v5_1;
        AppsMeterView_Phone v0 = this;
        v0.l = arg17;
        v0.n.setText(v0.e.getResources().getText(arg17));
        v0.a(arg18, arg19, arg20);
        AppsMeterRulerView_Phone v1 = v0.b;
        v1.c = 1;
        v1.d = 1;
        v1.e = 1;
        v1.f = 1;
        double v3 = 1.0;
        v1.g = v3;
        v1.h = v3;
        v1.l = v3;
        int v5 = v0.g;
        double v6 = 0.5;
        if(v5 == 27) {
            v1.f = 10;
            v1.c = 0;
            v1.d = 10;
            v1.e = 10;
            v1.g = v6;
            v1.h = v3;
            v1.i = v6;
            v1.l = v3;
            v1.a = true;
        }
        else {
            if(v5 == 28) {
                v1.f = 10;
                v1.c = 0;
                v1.d = 2;
                v1.e = 2;
                v1.g = 0.1;
                v1.h = 0.1;
                v1.i = 0.1;
                v1.l = v3;
                v1.a = true;
                goto label_398;
            }

            double v11 = 15.0;
            double v13 = 30.0;
            if(v5 == 18) {
            label_388:
                v1.f = 10;
                v1.c = 0;
                v1.d = 100;
                v1.e = 99;
                v1.g = v3;
                v1.h = v13;
                v1.i = v11;
            label_395:
                v1.l = v3;
                v1.a = false;
            }
            else {
                if(v5 == 19) {
                    v1.f = 20;
                }
                else {
                    v11 = 0.0;
                    if(v5 == 1) {
                        goto label_388;
                    }

                    double v13_1 = 0.1;
                    double v11_1 = 0.8;
                    if(v5 == 2) {
                        v1.f = AppsRunner.get(v0.e).W();
                        AppsMeterRulerView_Phone v1_1 = v0.b;
                        v1_1.c = 0;
                        v1_1.d = AppsRunner.get(v0.e).W();
                        AppsMeterRulerView_Phone v1_2 = v0.b;
                        v1_2.e = AppsRunner.get(v0.e).W();
                        v0.b.g = v13_1;
                        if(AppsRunner.get(v0.e).Y() != 1) {
                            goto label_305;
                        }

                        goto label_300;
                    }

                    if(v5 != 3) {
                        goto label_102;
                    }

                    if(v0.h == 5) {
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
                        goto label_395;
                    label_102:
                        if(v5 == 4) {
                            if(v0.h != 5) {
                                goto label_333;
                            }

                            v1.f = 10;
                            goto label_325;
                        }

                        if(v5 == 7) {
                            v1.f = AppsRunner.get(v0.e).W();
                            AppsMeterRulerView_Phone v1_3 = v0.b;
                            v1_3.c = 0;
                            v1_3.d = AppsRunner.get(v0.e).W();
                            AppsMeterRulerView_Phone v1_4 = v0.b;
                            v1_4.e = AppsRunner.get(v0.e).W();
                            v0.b.g = v13_1;
                            if(AppsRunner.get(v0.e).Y() != 1) {
                                goto label_305;
                            }

                            goto label_300;
                        }

                        if(v5 == 6) {
                            goto label_379;
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
                            goto label_395;
                        }

                        if(v5 == 12) {
                            v1.f = AppsRunner.get(v0.e).W();
                            AppsMeterRulerView_Phone v1_5 = v0.b;
                            v1_5.c = 0;
                            v1_5.d = AppsRunner.get(v0.e).W();
                            AppsMeterRulerView_Phone v1_6 = v0.b;
                            v1_6.e = AppsRunner.get(v0.e).W();
                            v0.b.g = v13_1;
                            if(AppsRunner.get(v0.e).Y() != 1) {
                                goto label_305;
                            }

                            goto label_300;
                        }

                        if(v5 == 11) {
                            goto label_379;
                        }

                        if(v5 == 8) {
                            goto label_366;
                        }

                        if(v5 == 9) {
                            goto label_379;
                        }

                        if(v5 == 5) {
                            goto label_366;
                        }

                        if(v5 == 26) {
                            goto label_379;
                        }

                        if(v5 == 22) {
                            v1.f = AppsRunner.get(v0.e).W();
                            AppsMeterRulerView_Phone v1_7 = v0.b;
                            v1_7.c = 0;
                            v1_7.d = AppsRunner.get(v0.e).W();
                            AppsMeterRulerView_Phone v1_8 = v0.b;
                            v1_8.e = AppsRunner.get(v0.e).W();
                            v0.b.g = v13_1;
                            if(AppsRunner.get(v0.e).Y() == 1) {
                                v1_9 = v0.b;
                                v5_2 = 3.2;
                                v1_9.h = v5_2;
                                v1_9.i = v11_1;
                                v0.b.a = true;
                                v0.b.l = v3;
                                goto label_398;
                            }

                            v1_10 = v0.b;
                            v5_3 = 2.0;
                            goto label_247;
                        }

                        if(v5 == 23) {
                            v1.f = AppsRunner.get(v0.e).W();
                            AppsMeterRulerView_Phone v1_11 = v0.b;
                            v1_11.c = 0;
                            v1_11.d = AppsRunner.get(v0.e).W();
                            AppsMeterRulerView_Phone v1_12 = v0.b;
                            v1_12.e = AppsRunner.get(v0.e).W();
                            v0.b.g = v13_1;
                            if(AppsRunner.get(v0.e).Y() == 1) {
                                v1_9 = v0.b;
                                v5_2 = 5.6;
                                v1_9.h = v5_2;
                                v1_9.i = v11_1;
                                v0.b.a = true;
                                v0.b.l = v3;
                                goto label_398;
                            }

                            v1_10 = v0.b;
                            v5_3 = 3.5;
                        label_247:
                            v1_10.h = v5_3;
                            v5_4 = 0.5;
                            v1_10.i = v5_4;
                            v0.b.a = true;
                            v0.b.l = v3;
                            goto label_398;
                        }

                        if(v5 == 24) {
                            if(v0.h != 5) {
                                goto label_333;
                            }

                            goto label_322;
                        }

                        if(v5 == 15) {
                            goto label_366;
                        }

                        if(v5 == 16) {
                            v1.f = 10;
                            v1.c = 0;
                            v1.d = 100;
                            v1.e = 99;
                            v1.g = v3;
                            v1.h = (double)AppsRunner.get(v0.e).ad();
                            v1 = v0.b;
                            v5_1 = 13.0;
                            v1.i = v5_1;
                            goto label_395;
                        }

                        if(v5 != 17) {
                            if(v5 == 13) {
                                v1.f = AppsRunner.get(v0.e).W();
                                AppsMeterRulerView_Phone v1_13 = v0.b;
                                v1_13.c = 0;
                                v1_13.d = AppsRunner.get(v0.e).W();
                                AppsMeterRulerView_Phone v1_14 = v0.b;
                                v1_14.e = AppsRunner.get(v0.e).W();
                                v0.b.g = v13_1;
                                if(AppsRunner.get(v0.e).Y() == 1) {
                                label_300:
                                    v1_9 = v0.b;
                                    v1_9.h = v11_1;
                                    v1_9.i = v11_1;
                                }
                                else {
                                label_305:
                                    v1_10 = v0.b;
                                    v5_4 = 0.5;
                                    v1_10.h = v5_4;
                                    v1_10.i = v5_4;
                                }

                                v0.b.a = true;
                                v0.b.l = v3;
                                goto label_398;
                            }

                            if(v5 == 25) {
                                goto label_360;
                            }

                            if(v5 == 20) {
                                goto label_366;
                            }

                            if(v5 == 14) {
                                if(v0.h == 5) {
                                label_322:
                                    v1.f = 20;
                                label_325:
                                    v1.c = 0;
                                    v1.d = 20;
                                    v1.e = 20;
                                    v1.g = v3;
                                    v1.h = 0.0;
                                    v1.i = 0.0;
                                    goto label_395;
                                }

                            label_333:
                                v1.f = 15;
                                v1.c = 0;
                                v1.d = 15;
                                v1.e = 15;
                                v1.g = 0.5;
                                v1.h = 0.0;
                                v1.i = 0.0;
                                v1.a = true;
                                v1.l = 2.0;
                                goto label_398;
                            }

                            if(v5 != 21) {
                                goto label_398;
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
                        goto label_395;
                    label_360:
                        v1.f = 20;
                    }
                }

                v1.c = 0;
                v1.d = 20;
                v1.e = 20;
                v1.g = v3;
                v1.h = v3;
                v1.i = v3;
                goto label_395;
            label_366:
                v1.f = 10;
                v1.c = 0;
                v1.d = 100;
                v1.e = 99;
                v1.g = v3;
                v1.h = 30.0;
                v5_1 = 15.0;
                v1.i = v5_1;
                goto label_395;
            label_379:
                v1.f = 10;
                v1.c = 0;
                v1.d = 10;
                v1.e = 10;
                v1.g = v3;
                v1.h = v3;
                v1.i = v3;
                goto label_395;
            }
        }

    label_398:
        this.h();
    }

    @Override  // com.xtremeprog.shell.treadmillv2.views.AppsMeterRulerView_Phone$a
    public void a(AppsMeterRulerView_Phone arg3, double arg4) {
        this.j = arg4;
        j.a("=appsMeterRulerDidChangeValue1=", this.j + " |");
        this.a(false, false);
        com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone.a v3 = this.c;
        if(v3 != null) {
            v3.a(this, this.j);
        }
    }

    public void b() {
        this.b.b();
    }

    public void c() {
        this.b.c();
    }

    public void d() {
        this.b.b();
        this.d.removeMessages(0x2B67);
        Message v0 = new Message();
        v0.what = 0x2B67;
        this.d.sendMessageDelayed(v0, 0xFAL);
    }

    public void e() {
        this.b.c();
        this.d.removeMessages(0x56CE);
        Message v0 = new Message();
        v0.what = 0x56CE;
        this.d.sendMessageDelayed(v0, 0xFAL);
    }

    public void f() {
        this.d.removeMessages(0x2B67);
    }

    public void g() {
        this.d.removeMessages(0x56CE);
    }

    public float getDefaultValue() {
        return this.k;
    }

    public double getValue() {
        int v0;
        double v3;
        j.a("---finalValue1---", this.j + " |");
        if(this.b.a) {
            v3 = this.j;
            v0 = 1;
        }
        else {
            v3 = (double)(((int)this.j));
            v0 = 0;
        }

        double v0_1 = d.a(d.doubleToStr(v3, v0), 0.0);
        j.a("---finalValue2---", v0_1 + " |");
        return v0_1;
    }

    private void h() {
        this.b.j = this.b.h;
        this.a(true, false);
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg5, MotionEvent arg6) {
        if(arg6.getAction() == 0) {
            Button v6 = this.o;
            if(arg5 == v6) {
                v6.setBackgroundResource(0x7F060109);  // drawable:pad_btn_plus
                this.d();
                return true;
            }

            Button v6_1 = this.p;
            if(arg5 == v6_1) {
                v6_1.setBackgroundResource(0x7F060107);  // drawable:pad_btn_minus
                this.e();
                return true;
            }
        }
        else if(arg6.getAction() == 1 || arg6.getAction() == 3) {
            Button v6_2 = this.o;
            if(arg5 == v6_2) {
                v6_2.setBackgroundResource(0x7F060109);  // drawable:pad_btn_plus
                this.f();
                return true;
            }

            Button v6_3 = this.p;
            if(arg5 == v6_3) {
                v6_3.setBackgroundResource(0x7F060107);  // drawable:pad_btn_minus
                this.g();
            }
        }

        return true;
    }

    public void setCurrentValue(float arg4) {
        double v1 = (double)arg4;
        this.b.j = v1;
        this.b.k = v1;
        this.j = v1;
        this.a(true, true);
    }

    public void setListener(com.xtremeprog.shell.treadmillv2.views.AppsMeterView_Phone.a arg1) {
        this.c = arg1;
    }

    public void setTitleViewLines(int arg2) {
        if(arg2 == 1) {
            this.n.setSingleLine();
            return;
        }

        this.n.setMaxLines(arg2);
    }
}
