package com.xtremeprog.shell.treadmillv2.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import java.util.ArrayList;
import java.util.List;

public class SprintLevelView extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private Paint o;
    private b p;
    private List q;
    private List r;

    public SprintLevelView(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        this.a = Color.rgb(0xEE, 0x7A, 0x3F);
        this.b = Color.rgb(57, 91, 0x8F);
        this.c = Color.rgb(50, 0xA2, 106);
        this.d = Color.rgb(91, 0xA3, 209);
        this.g = 24;
        this.h = 24;
        this.i = 60;
        this.j = 80;
        this.k = 90;
        this.l = 4;
        this.m = 16;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.a();
    }

    public SprintLevelView(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4);
        this.a = Color.rgb(0xEE, 0x7A, 0x3F);
        this.b = Color.rgb(57, 91, 0x8F);
        this.c = Color.rgb(50, 0xA2, 106);
        this.d = Color.rgb(91, 0xA3, 209);
        this.g = 24;
        this.h = 24;
        this.i = 60;
        this.j = 80;
        this.k = 90;
        this.l = 4;
        this.m = 16;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.a();
    }

    private void a() {
        this.o = new Paint();
        this.o.setAntiAlias(true);
        this.p = AppsRunner.get(this.getContext()).inclineSupportsHalfDegree(this.getContext()) ? new b(4.0f, 4.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f) : new b(1.0f, 1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f, 3.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
        this.b();
    }

    private void a(Canvas arg6) {
        this.o.setColor(this.c);
        arg6.drawRect(new Rect(0, ((int)(((float)this.f) - ((float)this.n) * this.p.a())), this.k, this.f), this.o);
    }

    private void b() {
        this.q.clear();
        this.r.clear();
        this.q.add(Float.valueOf(this.p.c()));
        this.q.add(Float.valueOf(this.p.d()));
        this.q.add(Float.valueOf(this.p.e()));
        this.q.add(Float.valueOf(this.p.f()));
        this.q.add(Float.valueOf(this.p.g()));
        this.q.add(Float.valueOf(this.p.h()));
        this.q.add(Float.valueOf(this.p.i()));
        this.q.add(Float.valueOf(this.p.j()));
        this.r.add(Float.valueOf(this.p.k()));
        this.r.add(Float.valueOf(this.p.l()));
        this.r.add(Float.valueOf(this.p.m()));
        this.r.add(Float.valueOf(this.p.n()));
        this.r.add(Float.valueOf(this.p.o()));
        this.r.add(Float.valueOf(this.p.p()));
        this.r.add(Float.valueOf(this.p.q()));
    }

    private void b(Canvas arg6) {
        this.o.setColor(this.d);
        arg6.drawRect(new Rect(this.k + this.h * 8 + this.i * 7 + this.l * 16, ((int)(((float)this.f) - ((float)this.n) * this.p.b())), this.e, this.f), this.o);
    }

    private void c(Canvas arg9) {
        this.o.setColor(this.a);
        int v0;
        for(v0 = 0; v0 < this.q.size(); ++v0) {
            arg9.drawRect(new Rect(this.k + this.l + (this.h + this.l * 2 + this.i) * v0, ((int)(((float)this.f) - ((float)this.n) * ((float)(((Float)this.q.get(v0)))))), this.k + this.l + (this.l * 2 + this.h + this.i) * v0 + this.h, this.f), this.o);
        }
    }

    private void d(Canvas arg9) {
        this.o.setColor(this.b);
        int v0;
        for(v0 = 0; v0 < this.r.size(); ++v0) {
            arg9.drawRect(new Rect(this.k + this.l * 2 + this.h + (this.i + this.h + this.l * 2) * v0, ((int)(((float)this.f) - ((float)this.n) * ((float)(((Float)this.r.get(v0)))))), this.k + this.l * 2 + this.h + (this.h + this.i + this.l * 2) * v0 + this.i, this.f), this.o);
        }
    }

    @Override  // android.view.View
    protected void onDraw(Canvas arg1) {
        super.onDraw(arg1);
        this.a(arg1);
        this.b(arg1);
        this.c(arg1);
        this.d(arg1);
    }

    @Override  // android.view.View
    protected void onMeasure(int arg1, int arg2) {
        super.onMeasure(arg1, arg2);
        this.e = View.MeasureSpec.getSize(arg1);
        this.f = View.MeasureSpec.getSize(arg2);
        this.g = (this.e - this.l * 16) / 40;
        this.n = this.f / this.m;
        this.k = this.g * 6;
        this.j = this.g * 5;
        this.h = this.g;
        this.i = this.g * 3;
    }

    public void setData(b arg1) {
        this.p = arg1;
        this.b();
        this.invalidate();
    }
}
