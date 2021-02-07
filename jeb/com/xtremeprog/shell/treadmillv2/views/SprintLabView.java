package com.xtremeprog.shell.treadmillv2.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;

public class SprintLabView extends View {
    private int a;
    private int b;
    private Paint c;
    private int d;
    private int e;

    public SprintLabView(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.d = Color.rgb(50, 0xA2, 106);
        this.e = Color.rgb(91, 0xA3, 209);
        this.a();
    }

    public SprintLabView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.d = Color.rgb(50, 0xA2, 106);
        this.e = Color.rgb(91, 0xA3, 209);
        this.a();
    }

    private void a() {
        this.c = new Paint();
        this.c.setAntiAlias(true);
    }

    @Override  // android.view.View
    protected void onDraw(Canvas arg5) {
        super.onDraw(arg5);
        this.c.setColor(this.d);
        Path v0 = new Path();
        v0.moveTo(0.0f, 0.0f);
        v0.lineTo(0.0f, ((float)this.b));
        v0.lineTo(((float)this.a), 0.0f);
        v0.close();
        arg5.drawPath(v0, this.c);
        this.c.setColor(this.e);
        Path v0_1 = new Path();
        v0_1.moveTo(((float)this.a), ((float)this.b));
        v0_1.lineTo(0.0f, ((float)this.b));
        v0_1.lineTo(((float)this.a), 0.0f);
        v0_1.close();
        arg5.drawPath(v0_1, this.c);
    }

    @Override  // android.view.View
    protected void onMeasure(int arg1, int arg2) {
        super.onMeasure(arg1, arg2);
        this.a = View.MeasureSpec.getSize(arg1);
        this.b = View.MeasureSpec.getSize(arg2);
    }
}
