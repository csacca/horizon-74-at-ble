package com.xtremeprog.shell.treadmillv2.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

public class AppsRunningTrackView extends RelativeLayout {
    private Context a;
    private double b;
    private double c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Point l;
    private int m;
    private final Paint n;
    private final Path o;

    public AppsRunningTrackView(Context arg2) {
        super(arg2);
        this.n = new Paint();
        this.o = new Path();
        this.a = arg2;
    }

    public AppsRunningTrackView(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.n = new Paint();
        this.o = new Path();
        this.a = arg1;
    }

    public AppsRunningTrackView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.n = new Paint();
        this.o = new Path();
        this.a = arg1;
    }

    public void a() {
        this.n.setAntiAlias(true);
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setStrokeWidth(((float)this.d));
        this.n.setColor(this.j);
        this.n.setStrokeCap(Paint.Cap.ROUND);
        this.n.setStrokeJoin(Paint.Join.ROUND);
        this.n.setAntiAlias(true);
        this.b();
        this.invalidate();
    }

    public void a(Canvas arg14) {
        Log.e("==draw2==", this.k + " : " + this.b);
        this.o.reset();
        int v0 = this.k;
        if(v0 != 0) {
            double v1 = this.b;
            if(v1 != 0.0) {
                int v0_1 = (int)(this.c / v1 * ((double)v0) + ((double)this.l.x));
                Log.e("==draw2==", "position : " + v0_1 + "   " + (this.l.x + this.i / 2 + this.e + this.h + this.e) + "  " + (this.l.x + this.i / 2 + this.e + this.h + this.e + this.g) + "  " + this.g);
                if(v0_1 >= this.l.x + this.m && v0_1 < this.l.x + this.i / 2) {
                    Log.e("==1==", "==1==");
                    float v0_2 = ((float)(v0_1 - this.l.x)) / (((float)(this.i / 2)) * 1.0f) * ((float)(this.i / 2));
                    this.o.moveTo(((float)(this.m + this.l.x + this.d / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    this.o.lineTo(((float)(this.l.x + this.d / 2)) + v0_2, ((float)(this.d / 2 + this.e + this.f + this.e)));
                }
                else if(v0_1 >= this.l.x + this.i / 2 && v0_1 < this.l.x + this.i / 2 + this.e) {
                    Log.e("==2==", "==2==");
                    this.o.moveTo(((float)(this.m + this.l.x + this.d / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    float v0_3 = ((float)(v0_1 - (this.l.x + this.i / 2))) / (((float)this.e) * 1.0f) * 90.0f;
                    RectF v1_1 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), ((float)(this.f + this.e - this.e)), ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.f + this.e + this.e)));
                    v1_1.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_1, 90.0f, -v0_3);
                }
                else if(v0_1 >= this.l.x + this.i / 2 + this.e && v0_1 < this.l.x + this.i / 2 + this.e + this.h) {
                    Log.e("==3==", "==3==");
                    this.o.moveTo(((float)(this.m + this.l.x + this.d / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    RectF v1_2 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), ((float)(this.f + this.e - this.e)), ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.f + this.e + this.e)));
                    v1_2.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_2, 90.0f, -90.0f);
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2 + this.e)), ((float)(this.e + this.d / 2 + this.h)) - ((float)(v0_1 - (this.l.x + this.i / 2 + this.e))) / (((float)this.h) * 1.0f) * ((float)this.h));
                }
                else if(v0_1 >= this.l.x + this.i / 2 + this.e + this.h && v0_1 < this.l.x + this.i / 2 + this.e + this.h + this.e) {
                    Log.e("==4==", "==4 : " + (this.l.x + this.i / 2 + this.e + this.h) + "==");
                    this.o.moveTo(((float)(this.m + this.l.x + this.d / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    RectF v1_3 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), ((float)(this.f + this.e - this.e)), ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.f + this.e + this.e)));
                    v1_3.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_3, 90.0f, -90.0f);
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2 + this.e)), ((float)(this.e + this.d / 2)));
                    float v0_4 = ((float)(v0_1 - (this.l.x + this.i / 2 + this.e + this.h))) / (((float)this.e) * 1.0f) * 90.0f;
                    RectF v1_4 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), 0.0f, ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.e * 2)));
                    v1_4.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_4, 0.0f, -v0_4);
                }
                else if(v0_1 >= this.l.x + this.i / 2 + this.e + this.h + this.e && v0_1 < this.l.x + this.i / 2 + this.e + this.h + this.e + this.g) {
                    Log.e("==5==", "==5==");
                    this.o.moveTo(((float)(this.m + this.l.x + this.d / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    RectF v1_5 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), ((float)(this.f + this.e - this.e)), ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.f + this.e + this.e)));
                    v1_5.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_5, 90.0f, -90.0f);
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2 + this.e)), ((float)(this.e + this.d / 2)));
                    RectF v1_6 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), 0.0f, ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.e * 2)));
                    v1_6.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_6, 0.0f, -90.0f);
                    this.o.lineTo(((float)(this.e + this.d / 2)) + (((float)this.g) - ((float)(v0_1 - (this.l.x + this.i / 2 + this.e + this.h + this.e))) / (((float)this.g) * 1.0f) * ((float)this.g)), ((float)(this.d / 2)));
                }
                else if(v0_1 >= this.l.x + this.i / 2 + this.e + this.h + this.e + this.g && v0_1 < this.l.x + this.i / 2 + this.e + this.h + this.e + this.g + this.e) {
                    Log.e("==6==", "==6 : " + (this.l.x + this.i / 2 + this.e + this.h + this.e + this.g) + "==");
                    this.o.moveTo(((float)(this.m + this.l.x + this.d / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    RectF v1_7 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), ((float)(this.f + this.e - this.e)), ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.f + this.e + this.e)));
                    v1_7.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_7, 90.0f, -90.0f);
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2 + this.e)), ((float)(this.e + this.d / 2)));
                    RectF v1_8 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), 0.0f, ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.e * 2)));
                    v1_8.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_8, 0.0f, -90.0f);
                    this.o.lineTo(((float)(this.e + this.d / 2)), ((float)(this.d / 2)));
                    int v4 = this.e;
                    float v0_5 = ((float)(v0_1 - (this.l.x + this.i / 2 + v4 + this.h + v4 + this.g))) / (((float)v4) * 1.0f) * 90.0f;
                    RectF v1_9 = new RectF(0.0f, 0.0f, ((float)(v4 * 2)), ((float)(v4 * 2)));
                    v1_9.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_9, 270.0f, -v0_5);
                }
                else if(v0_1 >= this.l.x + this.i / 2 + this.e + this.h + this.e + this.g + this.e && v0_1 < this.l.x + this.i / 2 + this.e + this.h + this.e + this.g + this.e + this.f) {
                    Log.e("==7==", "==7==");
                    this.o.moveTo(((float)(this.m + this.l.x + this.d / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    RectF v1_10 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), ((float)(this.f + this.e - this.e)), ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.f + this.e + this.e)));
                    v1_10.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_10, 90.0f, -90.0f);
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2 + this.e)), ((float)(this.e + this.d / 2)));
                    RectF v1_11 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), 0.0f, ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.e * 2)));
                    v1_11.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_11, 0.0f, -90.0f);
                    this.o.lineTo(((float)(this.e + this.d / 2)), ((float)(this.d / 2)));
                    RectF v1_12 = new RectF(0.0f, 0.0f, ((float)(this.e * 2)), ((float)(this.e * 2)));
                    v1_12.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_12, 270.0f, -90.0f);
                    this.o.lineTo(((float)(this.d / 2)), ((float)this.e) + ((float)(v0_1 - (this.l.x + this.i / 2 + this.e + this.h + this.e + this.g + this.e))) / (((float)this.f) * 1.0f) * ((float)this.f));
                }
                else if(v0_1 >= this.l.x + this.i / 2 + this.e + this.h + this.e + this.g + this.e + this.f && v0_1 < this.l.x + this.i / 2 + this.e + this.h + this.e + this.g + this.e + this.f + this.e) {
                    Log.e("==8==", "==8==");
                    this.o.moveTo(((float)(this.m + this.l.x + this.d / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    RectF v1_13 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), ((float)(this.f + this.e - this.e)), ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.f + this.e + this.e)));
                    v1_13.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_13, 90.0f, -90.0f);
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2 + this.e)), ((float)(this.e + this.d / 2)));
                    RectF v1_14 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), 0.0f, ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.e * 2)));
                    v1_14.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_14, 0.0f, -90.0f);
                    this.o.lineTo(((float)(this.e + this.d / 2)), ((float)(this.d / 2)));
                    RectF v1_15 = new RectF(0.0f, 0.0f, ((float)(this.e * 2)), ((float)(this.e * 2)));
                    v1_15.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_15, 270.0f, -90.0f);
                    this.o.lineTo(((float)(this.d / 2)), ((float)(this.e + this.f)));
                    int v4_1 = this.e;
                    int v6 = this.f;
                    float v0_6 = ((float)(v0_1 - (this.l.x + this.i / 2 + v4_1 + this.h + v4_1 + this.g + v4_1 + v6))) / (((float)v4_1) * 1.0f) * 90.0f;
                    RectF v1_16 = new RectF(0.0f, ((float)(v4_1 + v6 - v4_1)), ((float)(v4_1 * 2)), ((float)(v6 + v4_1 + v4_1)));
                    v1_16.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_16, 180.0f, -v0_6);
                }
                else if(v0_1 >= this.l.x + this.i / 2 + this.e + this.h + this.e + this.g + this.e + this.f + this.e && v0_1 <= this.l.x + this.i / 2 + this.e + this.h + this.e + this.g + this.e + this.f + this.e + this.i / 2 + this.m) {
                    Log.e("==9==", "==9==");
                    this.o.moveTo(((float)(this.m + this.l.x + this.d / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                    RectF v1_17 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), ((float)(this.f + this.e - this.e)), ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.f + this.e + this.e)));
                    v1_17.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_17, 90.0f, -90.0f);
                    this.o.lineTo(((float)(this.l.x + this.d / 2 + this.i / 2 + this.e)), ((float)(this.e + this.d / 2)));
                    RectF v1_18 = new RectF(((float)(this.l.x + this.i / 2 - this.e)), 0.0f, ((float)(this.l.x + this.i / 2 + this.e)), ((float)(this.e * 2)));
                    v1_18.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_18, 0.0f, -90.0f);
                    this.o.lineTo(((float)(this.e + this.d / 2)), ((float)(this.d / 2)));
                    RectF v1_19 = new RectF(0.0f, 0.0f, ((float)(this.e * 2)), ((float)(this.e * 2)));
                    v1_19.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_19, 270.0f, -90.0f);
                    this.o.lineTo(((float)(this.d / 2)), ((float)(this.e + this.f)));
                    RectF v1_20 = new RectF(0.0f, ((float)(this.e + this.f - this.e)), ((float)(this.e * 2)), ((float)(this.f + this.e + this.e)));
                    v1_20.offset(((float)(this.d / 2)), ((float)(this.d / 2)));
                    this.o.arcTo(v1_20, 180.0f, -90.0f);
                    this.o.lineTo(((float)(this.d / 2 + this.e)) + ((float)(v0_1 - (this.l.x + this.i / 2 + this.e + this.h + this.e + this.g + this.e + this.f + this.e))) / (((float)(this.i / 2)) * 1.0f) * ((float)(this.i / 2 + this.m)), ((float)(this.d / 2 + this.e + this.f + this.e)));
                }

                arg14.drawPath(this.o, this.n);
            }
        }
    }

    private void b() {
        this.k = this.g + this.f + this.h + this.i + this.e * 4;
        this.l = new Point(this.i / 2 + this.e, this.f + this.e + this.e);
        this.m = this.d / 2;
    }

    public int getBottomWidth() {
        return this.i;
    }

    public int getCornerRadius() {
        return this.e;
    }

    public int getLeftHeight() {
        return this.f;
    }

    public double getProgress() {
        return this.c;
    }

    public int getRightHeight() {
        return this.h;
    }

    public int getStrokeColor() {
        return this.j;
    }

    public int getStrokeWidth() {
        return this.d;
    }

    public int getTopWidth() {
        return this.g;
    }

    public double getTotal() {
        return this.b;
    }

    @Override  // android.view.View
    protected void onDraw(Canvas arg1) {
        super.onDraw(arg1);
        this.a(arg1);
    }

    public void setBottomWidth(int arg1) {
        this.i = arg1;
    }

    public void setCornerRadius(int arg1) {
        this.e = arg1;
    }

    public void setLeftHeight(int arg1) {
        this.f = arg1;
    }

    public void setProgress(double arg1) {
        this.c = arg1;
    }

    public void setRightHeight(int arg1) {
        this.h = arg1;
    }

    public void setStrokeColor(int arg1) {
        this.j = arg1;
    }

    public void setStrokeWidth(int arg1) {
        this.d = arg1;
    }

    public void setTopWidth(int arg1) {
        this.g = arg1;
    }

    public void setTotal(double arg1) {
        this.b = arg1;
    }
}
