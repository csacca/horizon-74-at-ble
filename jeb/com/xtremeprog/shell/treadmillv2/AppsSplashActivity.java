package com.xtremeprog.shell.treadmillv2;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import apps.activity.base.AppsPredoActivity;
import apps.c.d;
import apps.c.j;
import com.xpg.a.c.CRC;
import com.xpg.d.logger_maybe;
import com.xtremeprog.shell.treadmillv2.activity.AppsModeChooseActivity;
import com.xtremeprog.shell.treadmillv2.activity.AppsModeChoosePhoneActivity;

public class AppsSplashActivity extends AppsPredoActivity {
    final Handler i;
    private boolean j;

    public AppsSplashActivity() {
        this.j = false;
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg5) {
                Intent v5 = d.g(AppsSplashActivity.this) ? new Intent(AppsSplashActivity.this, AppsModeChooseActivity.class) : new Intent(AppsSplashActivity.this, AppsModeChoosePhoneActivity.class);
                AppsSplashActivity.this.startActivity(v5);
                AppsSplashActivity.this.overridePendingTransition(0x7F01000B, 0x7F01000C);  // anim:zoom_enter
                AppsSplashActivity.this.finish();
            }
        };
    }

    static boolean a(AppsSplashActivity arg0) {
        return arg0.j;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public Boolean d() {
        return Boolean.valueOf(false);
    }

    public void l() {
        AppsRunnerConnector.get(this).m();
        AppsRunnerConnector.get(this).n();
        AppsRunner.get(this).v();
        new Handler().postDelayed(() -> {
            AppsSplashActivity.this.j = true;
            return true;
        }, 1000L);

        class com.xtremeprog.shell.treadmillv2.AppsSplashActivity.4 implements Runnable {
            @Override
            public void run() {
                AppsSplashActivity.a(AppsSplashActivity.this, true);
            }
        }

    }

    public void m() {
        if(Build.VERSION.SDK_INT >= 23) {
            if(ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.ACCESS_FINE_LOCATION");
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 0x56CE);
                return;
            }

            this.o();
            return;
        }

        this.l();
    }

    public boolean n() {
        if(Build.VERSION.SDK_INT >= 19) {
            try {
                return Settings.Secure.getInt(this.getContentResolver(), "location_mode") != 0;
            }
            catch(Settings.SettingNotFoundException v1) {
                v1.printStackTrace();
                return false;
            }
        }

        return TextUtils.isEmpty(Settings.Secure.getString(this.getContentResolver(), "location_providers_allowed")) ^ 1;
    }

    private void o() {
        if(!this.n()) {
            this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0xD05);
            return;
        }

        this.l();
    }

    @Override  // android.app.Activity
    protected void onActivityResult(int arg1, int arg2, Intent arg3) {
        super.onActivityResult(arg1, arg2, arg3);
        if(arg1 == 0xD05) {
            this.n();
            this.l();
        }
    }

    @Override  // apps.activity.base.AppsPredoActivity
    public void onCreate(Bundle arg8) {
        String v0_2;
        String v8_1;
        int v2;
        this.j();
        byte[] v0 = {65, 84, 43, 83, 80, 80, 76, 69, 83, 69, 78, 68, 61, 52, 0x30, 0x30, 44, 0x30, 120, 66, 0x30, 67, 53, 53, 57, 66, 52, 51, 55, 70, 54, 13, 10, 85, -86, 0, 0, 1, 22, -37, 2, -34, -5, 0, 0x20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -36, 5, -63, 7, 1, 1, 0, -45, -118, 0, 0, 1, 1, 20, 35, 0, 0, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30};
        logger_maybe.e("CRC测试", CRC.getCRC(v0, v0.length) + "");
        AppsRunner.get(this).b(this);
        ((AppsApplication)this.getApplication()).h(true);
        super.onCreate(arg8);
        this.getWindow().setFlags(0x80, 0x80);
        if(d.g(this)) {
            boolean v8 = d.h(this);
            boolean v0_1 = d.b();
            boolean v1 = d.a();
            if(v8) {
                v2 = 0x7F090057;  // layout:activity_splash_galaxytab10
            }
            else {
                v2 = v0_1 ? 0x7F090058 : 0x7F090056;  // layout:activity_splash_nexus9
            }

            this.setContentView(v2);
            j.a("===isSumsungGalaxyTab10===", ((boolean)(((int)v8))) + " |");
            j.a("===isNexus7===", ((boolean)(((int)v1))) + " |");
            v8_1 = "===isNexus9===";
            v0_2 = ((boolean)(((int)v0_1))) + " |";
        }
        else {
            this.setContentView(0x7F090059);  // layout:activity_splash_phone
            v8_1 = "===isPhone===";
            v0_2 = "isPhone |";
        }

        j.a(v8_1, v0_2);
        this.m();
        new Thread() {
            @Override
            public void run() {
                while(!AppsSplashActivity.a(AppsSplashActivity.this)) {
                }

                Message v0 = new Message();
                v0.obj = "";
                AppsSplashActivity.this.i.sendMessage(v0);
            }
        }.start();
        DisplayMetrics v0_3 = this.getApplicationContext().getResources().getDisplayMetrics();
        j.b("1", "屏幕分辨率为:" + v0_3.widthPixels + " * " + v0_3.heightPixels + "\n" + "绝对宽度:" + String.valueOf(v0_3.widthPixels) + "pixels\n" + "绝对高度:" + String.valueOf(v0_3.heightPixels) + "pixels\n" + "逻辑密度:" + String.valueOf(v0_3.density) + '|' + String.valueOf(v0_3.densityDpi) + "\n" + "X 维 :" + String.valueOf(v0_3.xdpi) + "像素每英尺\n" + "Y 维 :" + String.valueOf(v0_3.ydpi) + "像素每英尺\n" + "机 型 :" + Build.MODEL);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        super.onDestroy();
        new Thread() {
            @Override
            public void run() {
                System.gc();
            }
        }.start();
    }

    @Override  // android.app.Activity
    public void onRequestPermissionsResult(int arg2, String[] arg3, int[] arg4) {
        if(arg2 == 0x56CE) {
            if(arg4.length > 0 && arg4[0] == 0) {
                this.o();
            }
            else {
                this.l();
            }
        }

        super.onRequestPermissionsResult(arg2, arg3, arg4);
    }
}
