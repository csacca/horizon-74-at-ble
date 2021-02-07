package com.xtremeprog.shell.treadmillv2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import apps.activity.base.AppsRootActivity;
import apps.views.d.a;

public class AppsUnMatchPhoneActivity extends AppsRootActivity {
    private BroadcastReceiver i;

    public AppsUnMatchPhoneActivity() {
        this.i = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg1, Intent arg2) {
                if(arg2.getAction().equals("NOTIFICATION_MATCH_MACHINE")) {
                    AppsUnMatchPhoneActivity.this.finish();
                }
            }
        };
    }

    public void a(boolean arg2) {
        if(arg2) {
            try {
                IntentFilter v2_1 = new IntentFilter();
                v2_1.addAction("NOTIFICATION_MATCH_MACHINE");
                this.registerReceiver(this.i, v2_1);
            }
            catch(Exception v2) {
                v2.printStackTrace();
            }

            return;
        }
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        try {
            a v0_1 = new a(this);
            v0_1.b(0x7F0B0134);  // string:prompt "Warning"
            v0_1.a(0x7F0B004C);  // string:STR_EXIT "Exit?"
            v0_1.a(this.getResources().getString(0x7F0B000A), new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_CONFIRM "Yes"
                @Override  // android.content.DialogInterface$OnClickListener
                public void onClick(DialogInterface arg1, int arg2) {
                    try {
                        arg1.dismiss();
                    }
                    catch(Exception v1) {
                        v1.printStackTrace();
                    }

                    apps.b.a.a().b();
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
        super.onCreate(arg2);
        this.getWindow().setFlags(0x80, 0x80);
        this.setContentView(0x7F09005D);  // layout:activity_unmatch_phone
        this.b();
        this.a(true);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        this.a(false);
        super.onDestroy();
    }
}
