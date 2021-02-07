package com.xtremeprog.shell.treadmillv2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import apps.activity.base.AppsRootActivity;
import apps.c.j;
import apps.c.n;
import com.xtremeprog.shell.treadmillv2.AppsRunner;

public class Apps321Activity extends AppsRootActivity {
    private RelativeLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private int m;
    private Handler n;

    public Apps321Activity() {
        this.m = 3;
        this.n = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg5) {
                if(arg5.what == 1) {
                    Apps321Activity.a(Apps321Activity.this).setVisibility(8);
                    Apps321Activity.b(Apps321Activity.this).setVisibility(0);
                    Apps321Activity.c(Apps321Activity.this).setVisibility(8);
                    return;
                }

                if(arg5.what == 2) {
                    Apps321Activity.a(Apps321Activity.this).setVisibility(8);
                    Apps321Activity.b(Apps321Activity.this).setVisibility(8);
                    Apps321Activity.c(Apps321Activity.this).setVisibility(0);
                    Apps321Activity.this.a(false, false);
                    Intent v5 = new Intent(Apps321Activity.this, AppsRunningActivity.class);
                    Apps321Activity.this.startActivity(v5);
                    Apps321Activity.this.finish();
                }
            }
        };
    }

    static LinearLayout a(Apps321Activity arg0) {
        return arg0.l;
    }

    public void a(boolean arg6, boolean arg7) {
        if(arg6) {
            this.i.setVisibility(0);
            this.l.setVisibility(0);
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            this.m = 3;
            Message v7 = new Message();
            Message v0 = new Message();
            Message v1 = new Message();
            v7.what = 1;
            v0.what = 2;
            v1.what = 3;
            this.n.removeMessages(1);
            this.n.removeMessages(2);
            this.n.removeMessages(3);
            this.n.sendMessageDelayed(v7, 1000L);
            this.n.sendMessageDelayed(v0, 2000L);
            this.n.sendMessageDelayed(v1, 3000L);
        }
    }

    static LinearLayout b(Apps321Activity arg0) {
        return arg0.k;
    }

    static LinearLayout c(Apps321Activity arg0) {
        return arg0.j;
    }

    private void l() {
        this.i = n.a().c(this, 0x7F07004C);  // id:countDownLayout
        this.j = n.a().b(this, 0x7F070049);  // id:count1_layout
        this.k = n.a().b(this, 0x7F07004A);  // id:count2_layout
        this.l = n.a().b(this, 0x7F07004B);  // id:count3_layout
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg3) {
        AppsRunner.get(this).b(this);
        j.a("===321Activity===", "====");
        super.onCreate(arg3);
        this.getWindow().setFlags(0x80, 0x80);
        this.a(0x7F090019, 0x7F09001A, 0x7F09001B);  // layout:activity_321
        this.l();
        this.a(true, false);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        AppsRunner.get(this).b(this);
    }
}
