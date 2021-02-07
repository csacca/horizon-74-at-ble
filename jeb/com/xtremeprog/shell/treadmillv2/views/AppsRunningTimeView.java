package com.xtremeprog.shell.treadmillv2.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import apps.c.d;
import apps.c.k;

@SuppressLint({"NewApi"})
public class AppsRunningTimeView extends RelativeLayout {
    public boolean a;
    private Context b;
    private LinearLayout c;

    public AppsRunningTimeView(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.a = false;
        this.a(arg1);
    }

    public AppsRunningTimeView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.a = false;
        this.a(arg1);
    }

    private void a(Context arg4) {
        this.b = arg4;
        this.c = new LinearLayout(arg4);
        this.c.setBackgroundColor(arg4.getResources().getColor(0x7F040035));  // color:color_time
        RelativeLayout.LayoutParams v0 = new RelativeLayout.LayoutParams(-2, -1);
        v0.leftMargin = k.a(arg4, 20.0f);
        v0.rightMargin = k.a(arg4, 20.0f);
        v0.topMargin = k.a(arg4, 1.0f);
        v0.bottomMargin = k.a(arg4, 1.0f);
        this.addView(this.c, v0);
    }

    public void a(int arg7, int arg8) {
        int v0_1;
        Context v5;
        if(arg8 == 0) {
            return;
        }

        boolean v0 = d.h(this.b);
        boolean v1 = d.b();
        int v2 = 50;
        int v3 = 0;
        if(v0) {
            v5 = this.b;
            if(v0) {
                v2 = 200;
            }
            else if(!v1) {
                v2 = 0;
            }

            v0_1 = k.a(v5, ((float)(v2 + 510)));
        }
        else if(v1) {
            v5 = this.b;
            if(v0) {
                v2 = 200;
            }
            else if(!v1) {
                v2 = 0;
            }

            v0_1 = k.a(v5, ((float)(v2 + 550)));
        }
        else {
            Context v1_1 = this.b;
            if(v0) {
                v3 = 200;
            }

            v0_1 = k.a(v1_1, ((float)(v3 + 510)));
        }

        RelativeLayout.LayoutParams v8 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
        v8.width = (int)(((float)v0_1) * (((float)arg7) * 1.0f / ((float)arg8)));
        this.c.setLayoutParams(v8);
    }
}
