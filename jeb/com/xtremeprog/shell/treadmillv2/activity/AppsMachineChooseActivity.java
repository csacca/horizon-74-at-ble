package com.xtremeprog.shell.treadmillv2.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import apps.activity.base.AppsRootActivity;
import apps.c.n;
import apps.views.d.a;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;

public class AppsMachineChooseActivity extends AppsRootActivity implements View.OnTouchListener {
    private Button i;
    private Button j;
    private TextView k;

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        this.k.setText(0x7F0B00BC);  // string:STR_SELECT_MACHINE_TYPE "Please select your fitness machine type."
    }

    private void l() {
        this.i = n.a().a(this, 0x7F070033, this);  // id:button1
        this.j = n.a().a(this, 0x7F070034, this);  // id:button2
        this.k = n.a().e(this, 0x7F07028B);  // id:tipTextView
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        try {
            a v0_1 = new a(this);
            v0_1.b(0x7F0B0134);  // string:prompt "Warning"
            v0_1.a("是否退出APP？");
            v0_1.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                @Override  // android.content.DialogInterface$OnClickListener
                public void onClick(DialogInterface arg1, int arg2) {
                    try {
                        arg1.dismiss();
                    }
                    catch(Exception v1) {
                        v1.printStackTrace();
                    }

                    AppsMachineChooseActivity.this.finish();
                }
            });
            v0_1.b(this.getResources().getString(0x7F0B0009), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CANCEL "No"
                @Override  // android.content.DialogInterface$OnClickListener
                public void onClick(DialogInterface arg1, int arg2) {
                    try {
                        arg1.dismiss();
                    }
                    catch(Exception v1) {
                        v1.printStackTrace();
                    }
                }
            });
            v0_1.a().show();
        }
        catch(Exception v0) {
            v0.printStackTrace();
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg2) {
        AppsRunner.get(this).b(this);
        super.onCreate(arg2);
        this.getWindow().setFlags(0x80, 0x80);
        this.setContentView(0x7F090028);  // layout:activity_machine_choose
        this.l();
        AppsRunnerConnector.get(this).p();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        AppsRunner.get(this).b(this);
        this.i.setBackgroundResource(0x7F0600D3);  // drawable:elliptical_silouette_active
        this.j.setBackgroundResource(0x7F0601CA);  // drawable:treadmill_silouette_active
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg1, MotionEvent arg2) {
        if(arg2.getAction() == 0) {
            if(arg1 == this.i) {
                AppsRunner.get(this).i(this, 5);
                this.i.setBackgroundResource(0x7F0600D4);  // drawable:elliptical_silouette_non_active
                this.j.setBackgroundResource(0x7F0601CA);  // drawable:treadmill_silouette_active
            }
            else if(arg1 == this.j) {
                AppsRunner.get(this).i(this, 6);
                this.i.setBackgroundResource(0x7F0600D3);  // drawable:elliptical_silouette_active
                this.j.setBackgroundResource(0x7F0601CB);  // drawable:treadmill_silouette_non_active
            }

            this.startActivity(new Intent(this, AppsModeChooseActivity.class));
            this.finish();
        }

        return true;
    }
}
