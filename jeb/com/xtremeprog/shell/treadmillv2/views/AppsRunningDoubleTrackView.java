package com.xtremeprog.shell.treadmillv2.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AppsRunningDoubleTrackView extends RelativeLayout {
    private Context a;
    private AppsRunningTrackView b;
    private AppsRunningTrackView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private int h;
    private int i;
    private String j;
    private String k;
    private String l;
    private String m;

    public AppsRunningDoubleTrackView(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.h = 16;
        this.i = 0x106000B;
        this.a = arg1;
        this.c();
    }

    public AppsRunningDoubleTrackView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.h = 16;
        this.i = 0x106000B;
        this.a = arg1;
        this.c();
    }

    public void a() {
        this.b.a();
        this.c.a();
        int v0 = (this.b.getStrokeWidth() - this.c.getStrokeWidth()) / 2;
        RelativeLayout.LayoutParams v1 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
        v1.leftMargin = v0;
        v1.topMargin = v0;
        this.c.setLayoutParams(v1);
    }

    public void a(int arg2, int arg3, int arg4) {
        this.b.setCornerRadius(arg4);
        this.c.setCornerRadius(arg4);
        int v4 = arg4 * 2;
        int v2 = arg2 - v4;
        this.b.setTopWidth(v2);
        this.c.setTopWidth(v2);
        this.b.setBottomWidth(v2);
        this.c.setBottomWidth(v2);
        int v3 = arg3 - v4;
        this.b.setLeftHeight(v3);
        this.c.setLeftHeight(v3);
        this.b.setRightHeight(v3);
        this.c.setRightHeight(v3);
    }

    public void b() {
        this.c.a();
    }

    private void c() {
        this.b = new AppsRunningTrackView(this.a);
        this.c = new AppsRunningTrackView(this.a);
        this.b.setBackgroundColor(this.getResources().getColor(0x106000D));
        this.c.setBackgroundColor(this.getResources().getColor(0x106000D));
        RelativeLayout.LayoutParams v0 = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams v2 = new RelativeLayout.LayoutParams(-1, -1);
        this.addView(this.b, v0);
        this.addView(this.c, v2);
        this.d = new TextView(this.a);
        this.e = new TextView(this.a);
        this.f = new TextView(this.a);
        this.g = new TextView(this.a);
        this.d.setTypeface(Typeface.defaultFromStyle(1));
        this.e.setTypeface(Typeface.defaultFromStyle(1));
        this.f.setTypeface(Typeface.defaultFromStyle(1));
        this.g.setTypeface(Typeface.defaultFromStyle(1));
        RelativeLayout.LayoutParams v0_1 = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams v2_1 = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams v3 = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams v4 = new RelativeLayout.LayoutParams(-2, -2);
        v0_1.addRule(9);
        v0_1.addRule(15);
        v2_1.addRule(10);
        v2_1.addRule(14);
        v3.addRule(11);
        v3.addRule(15);
        v4.addRule(12);
        v4.addRule(14);
        this.addView(this.d, v0_1);
        this.addView(this.e, v2_1);
        this.addView(this.f, v3);
        this.addView(this.g, v4);
        this.d.setTextColor(this.i);
        this.e.setTextColor(this.i);
        this.f.setTextColor(this.i);
        this.g.setTextColor(this.i);
        this.d.setTextSize(((float)this.h));
        this.e.setTextSize(((float)this.h));
        this.f.setTextSize(((float)this.h));
        this.g.setTextSize(((float)this.h));
        this.m = "Start";
        this.g.setText(this.m);
    }

    public String getBottomTitle() {
        return this.m;
    }

    public int getBottomWidth() {
        return this.b.getBottomWidth();
    }

    public int getCornerRadius() {
        return this.b.getCornerRadius();
    }

    public int getInnerStrokeColor() {
        return this.c.getStrokeColor();
    }

    public int getInnerStrokeWidth() {
        return this.c.getStrokeWidth();
    }

    public AppsRunningTrackView getInnerTrackView() {
        return this.c;
    }

    public int getLeftHeight() {
        return this.b.getLeftHeight();
    }

    public String getLeftTitle() {
        return this.j;
    }

    public int getOutterStrokeColor() {
        return this.b.getStrokeColor();
    }

    public int getOutterStrokeWidth() {
        return this.b.getStrokeWidth();
    }

    public AppsRunningTrackView getOutterTrackView() {
        return this.b;
    }

    public double getProgress() {
        return this.c.getProgress();
    }

    public int getRightHeight() {
        return this.b.getRightHeight();
    }

    public String getRightTitle() {
        return this.l;
    }

    public int getTitileColor() {
        return this.i;
    }

    public int getTitleSize() {
        return this.h;
    }

    public String getTopTitle() {
        return this.k;
    }

    public int getTopWidth() {
        return this.b.getTopWidth();
    }

    public double getTotal() {
        return this.c.getTotal();
    }

    public void setBottomTitle(String arg2) {
        this.m = arg2;
        TextView v2 = this.g;
        if(v2 != null) {
            v2.setText(this.m);
        }
    }

    public void setCornerRadius(int arg2) {
        this.b.setCornerRadius(arg2);
        this.c.setCornerRadius(arg2);
    }

    public void setInnerStrokeColor(int arg2) {
        this.c.setStrokeColor(arg2);
    }

    public void setInnerStrokeWidth(int arg2) {
        this.c.setStrokeWidth(arg2);
    }

    public void setInnerTrackView(AppsRunningTrackView arg1) {
        this.c = arg1;
    }

    public void setLeftTitle(String arg2) {
        this.j = arg2;
        TextView v2 = this.d;
        if(v2 != null) {
            v2.setText(this.j);
        }
    }

    public void setOutterStrokeColor(int arg2) {
        this.b.setStrokeColor(arg2);
    }

    public void setOutterStrokeWidth(int arg8) {
        this.b.setStrokeWidth(arg8);
        TextView v8 = this.d;
        if(v8 != null) {
            RelativeLayout.LayoutParams v8_1 = (RelativeLayout.LayoutParams)v8.getLayoutParams();
            RelativeLayout.LayoutParams v0 = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
            RelativeLayout.LayoutParams v1 = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
            RelativeLayout.LayoutParams v2 = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
            v8_1.leftMargin = (int)(((double)this.b.getStrokeWidth()) * 1.4);
            v0.topMargin = (int)(((double)this.b.getStrokeWidth()) * 1.4);
            v1.rightMargin = (int)(((double)this.b.getStrokeWidth()) * 1.4);
            v2.bottomMargin = (int)(((double)this.b.getStrokeWidth()) * 1.4);
            this.d.setLayoutParams(v8_1);
            this.e.setLayoutParams(v0);
            this.f.setLayoutParams(v1);
            this.g.setLayoutParams(v2);
        }
    }

    public void setOutterTrackView(AppsRunningTrackView arg1) {
        this.b = arg1;
    }

    public void setProgress(double arg2) {
        this.c.setProgress(arg2);
    }

    public void setRightTitle(String arg2) {
        this.l = arg2;
        TextView v2 = this.f;
        if(v2 != null) {
            v2.setText(this.l);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void setTitileColor(int arg2) {
        this.i = arg2;
        TextView v2 = this.d;
        if(v2 != null) {
            v2.setTextColor(this.i);
            this.e.setTextColor(this.i);
            this.f.setTextColor(this.i);
            this.g.setTextColor(this.i);
        }
    }

    public void setTitleSize(int arg2) {
        this.h = arg2;
        TextView v2 = this.d;
        if(v2 != null) {
            v2.setTextSize(((float)this.h));
            this.e.setTextSize(((float)this.h));
            this.f.setTextSize(((float)this.h));
            this.g.setTextSize(((float)this.h));
        }
    }

    public void setTopTitle(String arg2) {
        this.k = arg2;
        TextView v2 = this.e;
        if(v2 != null) {
            v2.setText(this.k);
        }
    }

    public void setTotal(double arg2) {
        this.b.setTotal(arg2);
        this.b.setProgress(arg2);
        this.c.setTotal(arg2);
    }
}
