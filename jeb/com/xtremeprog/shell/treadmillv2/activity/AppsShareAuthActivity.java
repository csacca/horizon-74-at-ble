package com.xtremeprog.shell.treadmillv2.activity;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import apps.activity.base.AppsRootActivity;
import apps.b.b;
import apps.c.f;
import apps.c.j;
import apps.c.m.a;
import apps.c.m;
import apps.c.n;
import apps.c.o;
import apps.database.d;
import apps.database.entity.UserArticle;
import apps.vo.AppsArticle;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import com.xtremeprog.shell.treadmillv2.Conversions;
import com.xtremeprog.shell.treadmillv2.ShareFitness;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

public class AppsShareAuthActivity extends AppsRootActivity implements View.OnTouchListener {
    final Handler i;
    private static final int j;
    private Button k;
    private Button l;
    private Button m;
    private WebView n;
    private ProgressBar o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private AlertDialog t;
    private boolean u;
    private BroadcastReceiver v;
    private RelativeLayout w;

    static {
        AppsShareAuthActivity.j = AppsShareAuthActivity.class.hashCode();
    }

    public AppsShareAuthActivity() {
        this.p = false;
        this.q = false;
        this.r = false;
        this.u = false;
        this.v = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context arg2, Intent arg3) {
                String v2 = arg3.getAction();
                if(v2.equals("NOTIFICATION_DIDCONNECT")) {
                    AppsShareAuthActivity.e(AppsShareAuthActivity.this);
                    return;
                }

                if(v2.equals("NOTIFICATION_DISCONNECT")) {
                    if(AppsShareAuthActivity.e(AppsShareAuthActivity.this)) {
                        AppsShareAuthActivity.this.b(true);
                        return;
                    }
                }
                else if(v2.equals("NOTIFICATION_SYN_USER_INFO_FINISH")) {
                    if(AppsShareAuthActivity.e(AppsShareAuthActivity.this)) {
                        AppsShareAuthActivity.this.b(false);
                        AppsShareAuthActivity.this.i.removeMessages(0x6F);
                        Intent v0 = AppsShareAuthActivity.this.getIntent();
                        AppsShareAuthActivity.this.setResult(-1, v0);
                        AppsShareAuthActivity.this.finish();
                        return;
                    }
                }
                else if(v2.equals("NOTIFICATION_START_SYN_USER_INFO")) {
                    AppsShareAuthActivity.this.i.removeMessages(0x6F);
                }
            }
        };
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    Intent v4 = new Intent(AppsShareAuthActivity.this, AppsDeviceListActivity.class);
                    AppsShareAuthActivity.this.startActivity(v4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppsShareAuthActivity.this.b(false);
                        }
                    }, 500L);
                }
            }
        };
    }

    static AlertDialog a(AppsShareAuthActivity arg0) {
        return arg0.t;
    }

    static AlertDialog a(AppsShareAuthActivity arg0, AlertDialog arg1) {
        arg0.t = arg1;
        return arg1;
    }

    private void a(int arg24) {
        String v0_4;
        String v5;
        StringBuilder v4;
        if(this.q) {
            return;
        }

        boolean v2 = AppsRunnerConnector.get(this.getApplicationContext()).isConnected();
        if(arg24 == 0) {
            v4 = new StringBuilder();
            v5 = "==MMF授权登录成功，发setUser : ";
            goto label_28;
        }
        else {
            if(arg24 == 1) {
                v4 = new StringBuilder();
                v5 = "==MFP授权登录成功，发setUser : ";
            }
            else {
                if(arg24 != 2) {
                    goto label_35;
                }

                v4 = new StringBuilder();
                v5 = "==FB授权登录成功，发setUser : ";
            }

        label_28:
            v4.append(v5);
            v4.append(((boolean)(((int)v2))));
            v4.append("==");
            j.a("===", v4.toString());
        }

    label_35:
        if(!v2) {
            return;
        }

        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this) + 1;
        UserArticle v0_1 = d.a().b(this, v0);
        int v2_1 = v0_1.getId();
        String v4_1 = v0_1.getBirthday();
        String v5_1 = v0_1.getWeight();
        String v6 = v0_1.getNickname();
        int v15 = v0_1.getUnit();
        int v9 = v0_1.getGender();
        apps.c.d.a(v5_1, 0).intValue();
        try {
            int v0_3 = apps.c.d.a(this, "string", v6);
            if(v0_3 != 0) {
                v0_4 = this.getResources().getString(v0_3);
                goto label_70;
            }
        }
        catch(Exception v0_2) {
            v0_2.printStackTrace();
        }

        goto label_72;
    label_70:
        v6 = v0_4;
    label_72:
        Date v0_5 = f.stringToDate(v4_1, "yyyy/MM/dd");
        if(v0_5 == null) {
            v0_5 = f.stringToDate("2000-01-01", "yyyy-MM-dd");
        }

        int v12 = (int)apps.c.d.a(f.a(v0_5, "yyyy"), 1970);
        int v13 = (int)apps.c.d.a(f.a(v0_5, "MM"), 1);
        int v14 = (int)apps.c.d.a(f.a(v0_5, "dd"), 1);
        int v11 = apps.c.d.a(v0_5);
        int v0_6 = (int)apps.c.d.a(v5_1, 0);
        if(v15 == 1) {
            v0_6 = Conversions.kg_to_lb(v0_6);
        }

        String v4_2 = apps.c.d.a(v6, "INVITÉ") ? "INVITE" : v6;
        int v5_2 = AppsRunner.get(this).getPref_CurrentUserID(this);
        String v6_1 = ShareFitness.get(this).getPrefsMapMyFitnessTokenKey(v5_2 + "");
        String v7 = ShareFitness.get(this).getPrefsMFPTokenId(v5_2 + "");
        String v3 = ShareFitness.get(this).getPrefsFitbitTokenId(v5_2 + "");
        int v24 = v0_6;
        String v0_7 = ShareFitness.get(this).getPrefsMFP_UserId(v5_2 + "");
        String v5_3 = ShareFitness.get(this).getPrefsFitbitUserId(v5_2 + "");
        if(apps.c.d.strNotEmpty(v6_1)) {
            v6_1 = "0000000000000000000000000000000000000000";
        }

        if(apps.c.d.strNotEmpty(v7)) {
            v7 = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        }

        String v10 = v7;
        if(apps.c.d.strNotEmpty(v3)) {
            v3 = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        }

        if(apps.c.d.strNotEmpty(v0_7)) {
            v0_7 = "000000000000000";
        }

        if(apps.c.d.strNotEmpty(v5_3)) {
            v5_3 = "000000";
        }

        j.a("==三个token为==", "MMF : " + v6_1 + "  |   MFP:" + v10 + "  |  mfpUserId: " + v0_7 + "  |  FB:" + v3 + "  |  fbUserId:" + v5_3);
        int v11_1 = b.a().c(this);
        int v2_2 = v2_1 - 1;
        int v5_4 = v24 * 10;
        j.a("===USER EDIT===", v2_2 + " | " + v4_2 + " | " + v15 + " | " + v9 + " | " + v12 + " | " + v13 + " | " + v14 + " | " + v11 + " | " + v5_4 + " | " + v6_1 + " | " + v10 + " | " + v3);
        AppsApplication v0_8 = (AppsApplication)this.getApplication();
        v0_8.H = v2_2;
        v0_8.I = v9;
        v0_8.J = v5_4;
        v0_8.K = v11;
        v0_8.L = v12;
        v0_8.M = v13;
        v0_8.N = v14;
        v0_8.O = v11_1;
        v0_8.P = v15;
        v0_8.Q = v4_2;
        v0_8.R = v0_7;
        v0_8.S = v5_3;
        v0_8.g(true);
        AppsRunner.get(this).setUserData(v2_2, v9, v5_4, v11, v12, v13, v14, v11_1, v15, v4_2, v6_1, v10, v0_7, v3, v5_3);
        Intent v0_9 = new Intent();
        v0_9.setAction("NOTIFICATION_DID_GET_SHARE_ACCESS_TOKEN");
        this.sendBroadcast(v0_9);
    }

    static void a(AppsShareAuthActivity arg0, int arg1) {
        arg0.a(arg1);
    }

    static boolean a(AppsShareAuthActivity arg0, boolean arg1) {
        arg0.u = arg1;
        return arg1;
    }

    public void a(boolean arg2) {
        if(!arg2) {
            goto label_26;
        }

        try {
            IntentFilter v2_1 = new IntentFilter();
            v2_1.addAction("NOTIFICATION_DIDCONNECT");
            this.registerReceiver(this.v, v2_1);
            IntentFilter v2_2 = new IntentFilter();
            v2_2.addAction("NOTIFICATION_DISCONNECT");
            this.registerReceiver(this.v, v2_2);
            IntentFilter v2_3 = new IntentFilter();
            v2_3.addAction("NOTIFICATION_SYN_USER_INFO_FINISH");
            this.registerReceiver(this.v, v2_3);
            IntentFilter v2_4 = new IntentFilter();
            v2_4.addAction("NOTIFICATION_START_SYN_USER_INFO");
            this.registerReceiver(this.v, v2_4);
            return;
        label_26:
            this.unregisterReceiver(this.v);
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }
    }

    static boolean b(AppsShareAuthActivity arg0) {
        return arg0.u;
    }

    public void b(boolean arg4) {
        if(this.q) {
            j.a("==SHARE_AUTH_ACTIVITY==", "==come from tip==");
            return;
        }

        j.a("===", "===showBluetoothView=== : " + ((boolean)(((int)arg4))));
        if(arg4) {
            this.w.setVisibility(0);
            this.i.removeMessages(0x6F);
            if(((AppsApplication)this.getApplication()).m()) {
                return;
            }

            Message v4 = new Message();
            v4.what = 0x6F;
            this.i.sendMessageDelayed(v4, 30000L);
            return;
        }

        this.w.setVisibility(8);
        this.i.removeMessages(0x6F);
    }

    static ProgressBar c(AppsShareAuthActivity arg0) {
        return arg0.o;
    }

    static boolean d(AppsShareAuthActivity arg0) {
        return arg0.p;
    }

    static boolean e(AppsShareAuthActivity arg0) {
        return arg0.r;
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void e() {
        n.a().e(this, 0x7F0700CE).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView
        n.a().e(this, 0x7F070019).setText(this.getResources().getString(0x7F0B0018));  // id:backTextView
        n.a().e(this, 0x7F070177).setText(this.getResources().getString(0x7F0B001A));  // id:noBluetoothTextView
        n.a().e(this, 0x7F0700CF).setText(this.getResources().getString(0x7F0B0075));  // id:homeTextView2
    }

    public void l() {
        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        String v0_1 = ShareFitness.get(this).j(v0 + "");
        this.n.setVisibility(4);
        this.n.setWebViewClient(null);
        this.o.setVisibility(8);
        this.a(this, "");
        m.a(new a() {
            @Override  // apps.c.m$a
            public Object a() {
                String v0 = o.a().a("55xtz5n5kmdphxxsmbvgn68byrvnqbxj", "t8WV9adqUT6D47yvqd9gFu65MZUFcNKWtNwC9GCHJG6", v0_1);
                return apps.c.d.strNotEmpty(v0) ? null : AppsArticle.toAppsArticle(v0);
            }
        }, new apps.c.m.b() {
            @Override  // apps.c.m$b
            public void a(Object arg10) {
                int v1 = 0;
                try {
                    AppsShareAuthActivity.this.f();
                    if(arg10 == null) {
                        AppsShareAuthActivity.this.c("FAILED TO GET ACCESS TOKEN");
                        return;
                    }

                    v1 = 1;
                    AppsArticle v10_1 = (AppsArticle)arg10;
                    String v2 = v10_1.getAccess_token();
                    String v3 = v10_1.getRefresh_token();
                    String v4 = v10_1.getUser_id();
                    String v10_2 = v10_1.getExpires_in();
                    int v5 = AppsRunner.get(AppsShareAuthActivity.this).getPref_CurrentUserID(AppsShareAuthActivity.this);
                    ShareFitness.get(AppsShareAuthActivity.this).h(v4, v5 + "");
                    ShareFitness.get(AppsShareAuthActivity.this).b(v2, v5 + "");
                    ShareFitness.get(AppsShareAuthActivity.this).e(v3, v5 + "");
                    ShareFitness.get(AppsShareAuthActivity.this).a(v5 + "", apps.c.d.a(v10_2, 0).intValue());
                    j.a("==access_token==", v2 + " |");
                    if(AppsShareAuthActivity.d(AppsShareAuthActivity.this)) {
                        AppsShareAuthActivity.this.o();
                    }
                    else {
                        AppsShareAuthActivity.a(AppsShareAuthActivity.this, 0);
                        AppsShareAuthActivity.this.onBackPressed();
                        goto label_79;
                        AppsShareAuthActivity.this.c("FAILED TO GET ACCESS TOKEN");
                        return;
                    }
                }
                catch(Exception v10) {
                    v10.printStackTrace();
                }

            label_79:
                if(v1 == 0) {
                    AppsShareAuthActivity.this.c("FAILED TO GET ACCESS TOKEN");
                }
            }
        });
    }

    public void m() {
        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        String v0_1 = ShareFitness.get(this).j(v0 + "");
        this.n.setVisibility(4);
        this.n.setWebViewClient(null);
        this.o.setVisibility(8);
        this.a(this, "");
        m.a(new a() {
            @Override  // apps.c.m$a
            public Object a() {
                String v0 = o.a().a("afgfitness", "c7e6915ed48f7befbaa3", v0_1, "https://johnsondemo.herokuapp.com/authorization_callback/");
                return apps.c.d.strNotEmpty(v0) ? null : AppsArticle.toAppsArticle(v0);
            }
        }, new apps.c.m.b() {
            @Override  // apps.c.m$b
            public void a(Object arg10) {
                try {
                    AppsShareAuthActivity.this.f();
                    if(arg10 != null) {
                        AppsArticle v10_1 = (AppsArticle)arg10;
                        String v2 = v10_1.getAccess_token();
                        String v3 = v10_1.getRefresh_token();
                        String v4 = v10_1.getUser_id();
                        String v10_2 = v10_1.getExpires_in();
                        int v5 = AppsRunner.get(AppsShareAuthActivity.this).getPref_CurrentUserID(AppsShareAuthActivity.this);
                        ShareFitness.get(AppsShareAuthActivity.this).setPrefsMyFitnessPalTokenKey(v2, v5 + "");
                        ShareFitness.get(AppsShareAuthActivity.this).d(v3, v5 + "");
                        ShareFitness.get(AppsShareAuthActivity.this).setPrefsMFP_UserId(v4, v5 + "");
                        ShareFitness.get(AppsShareAuthActivity.this).b(v4 + "", apps.c.d.a(v10_2, 0).intValue());
                        j.a("==access_token==", v2 + " | " + v4);
                        if(AppsShareAuthActivity.d(AppsShareAuthActivity.this)) {
                            AppsShareAuthActivity.this.p();
                            return;
                        }

                        AppsShareAuthActivity.a(AppsShareAuthActivity.this, 1);
                        AppsShareAuthActivity.this.onBackPressed();
                        return;
                    }

                    AppsShareAuthActivity.this.c("FAILED TO GET ACCESS TOKEN");
                }
                catch(Exception v10) {
                    v10.printStackTrace();
                }
            }
        });
    }

    public void n() {
        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        String v0_1 = ShareFitness.get(this).j(v0 + "");
        this.n.setVisibility(4);
        this.n.setWebViewClient(null);
        this.o.setVisibility(8);
        this.a(this, "");
        m.a(new a() {
            @Override  // apps.c.m$a
            public Object a() {
                String v0 = o.a().b("227WN7", "2a036801e9f03a1186a4204415354c90", v0_1, "https://johnsondemo.herokuapp.com/authorization_callback/");
                return apps.c.d.strNotEmpty(v0) ? null : AppsArticle.toAppsArticle(v0);
            }
        }, new apps.c.m.b() {
            @Override  // apps.c.m$b
            public void a(Object arg10) {
                int v1 = 0;
                try {
                    AppsShareAuthActivity.this.f();
                    if(arg10 == null) {
                        AppsShareAuthActivity.this.c("FAILED TO GET ACCESS TOKEN");
                        return;
                    }

                    v1 = 1;
                    AppsArticle v10_1 = (AppsArticle)arg10;
                    String v2 = v10_1.getAccess_token();
                    String v3 = v10_1.getRefresh_token();
                    String v4 = v10_1.getUser_id();
                    String v10_2 = v10_1.getExpires_in();
                    int v5 = AppsRunner.get(AppsShareAuthActivity.this).getPref_CurrentUserID(AppsShareAuthActivity.this);
                    ShareFitness.get(AppsShareAuthActivity.this).c(v2, v5 + "");
                    ShareFitness.get(AppsShareAuthActivity.this).f(v3, v5 + "");
                    ShareFitness.get(AppsShareAuthActivity.this).i(v4, v5 + "");
                    ShareFitness.get(AppsShareAuthActivity.this).c(v4 + "", apps.c.d.a(v10_2, 0).intValue());
                    j.a("==access_token==", v2 + " | " + v4);
                    if(AppsShareAuthActivity.d(AppsShareAuthActivity.this)) {
                        AppsShareAuthActivity.this.q();
                    }
                    else {
                        AppsShareAuthActivity.a(AppsShareAuthActivity.this, 2);
                        AppsShareAuthActivity.this.onBackPressed();
                        goto label_81;
                        AppsShareAuthActivity.this.c("FAILED TO GET ACCESS TOKEN");
                        return;
                    }
                }
                catch(Exception v10) {
                    v10.printStackTrace();
                }

            label_81:
                if(v1 == 0) {
                    AppsShareAuthActivity.this.c("FAILED TO GET ACCESS TOKEN");
                }
            }
        });
    }

    public void o() {
    }

    @Override  // android.app.Activity
    public void onActivityResult(int arg1, int arg2, Intent arg3) {
        super.onActivityResult(arg1, arg2, arg3);
        j.a("MFP Example onActivityResult with requestCode %s", arg1 + " |");
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onBackPressed() {
        this.i.removeMessages(0x6F);
        super.onBackPressed();
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onCreate(Bundle arg3) {
        AppsRunner.get(this).b(this);
        super.onCreate(arg3);
        if(this.getIntent().getExtras() != null && this.getIntent().getExtras().get("isFromRefreshToken") != null) {
            this.q = ((Boolean)this.getIntent().getExtras().get("isFromRefreshToken")).booleanValue();
        }

        this.getWindow().setSoftInputMode(18);
        this.getWindow().setFlags(0x80, 0x80);
        this.a(0x7F090052, 0x7F090053, 0x7F090054);  // layout:activity_share_auth
        apps.c.b.a(this);
        if(this.getIntent().getExtras() != null && this.getIntent().getExtras().get("shouldShare") != null) {
            this.p = ((Boolean)this.getIntent().getExtras().get("shouldShare")).booleanValue();
        }

        this.s();
        this.a(true);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onDestroy() {
        super.onDestroy();
        this.a(false);
    }

    @Override  // apps.activity.base.AppsRootActivity
    public void onResume() {
        super.onResume();
        int v0 = 1;
        this.r = true;
        AppsRunner.get(this).b(this);
        AppsApplication v1 = (AppsApplication)this.getApplication();
        if((AppsRunnerConnector.get(this).isConnected()) && (v1.n())) {
            j.a("===", "===ShareAuth已连接===");
            v0 = 0;
        }
        else {
            j.a("===", "===ShareAuth未连接===");
        }

        this.b(((boolean)v0));
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        this.r = false;
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View arg2, MotionEvent arg3) {
        if(arg3.getAction() == 0) {
            if(arg2 == this.k || arg2 == this.l) {
                this.r();
                if(arg2 == this.l) {
                    this.i.removeMessages(0x6F);
                    ((AppsApplication)this.getApplication()).h(true);
                }

                this.setResult(-1, this.getIntent());
                this.finish();
            }
            else if(arg2 == this.m) {
                this.onBackPressed();
                return true;
            }
        }

        return true;
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this);
        int v1 = ShareFitness.get(this).a();
        if(v1 == 1) {
            String v1_1 = ShareFitness.get(this).getPrefsMFPTokenId(v0 + "");
            if((apps.c.d.strNotEmpty(v1_1)) || (apps.c.d.a(v1_1, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))) {
                ShareFitness.get(this).m(v0 + "");
                return;
            }
        }
        else if(v1 == 0) {
            String v1_2 = ShareFitness.get(this).getPrefsMapMyFitnessTokenKey(v0 + "");
            if((apps.c.d.strNotEmpty(v1_2)) || (apps.c.d.a(v1_2, "0000000000000000000000000000000000000000"))) {
                ShareFitness.get(this).n(v0 + "");
                return;
            }
        }
        else if(v1 == 2) {
            String v1_3 = ShareFitness.get(this).getPrefsFitbitTokenId(v0 + "");
            if((apps.c.d.strNotEmpty(v1_3)) || (apps.c.d.a(v1_3, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))) {
                ShareFitness.get(this).o(v0 + "");
            }
        }
    }

    private void s() {
        this.b();
        this.k = n.a().a(this, 0x7F0700C8, this);  // id:homeButton
        this.l = n.a().a(this, 0x7F0700C9, this);  // id:homeButton2
        this.m = n.a().a(this, 0x7F070017, this);  // id:backButton
        this.n = (WebView)n.a().g(this, 0x7F0702FE);  // id:webView
        this.o = (ProgressBar)n.a().g(this, 0x7F07010D);  // id:loadingView
        this.w = n.a().c(this, 0x7F070176);  // id:noBluetoothLayout
        this.s = ShareFitness.get(this).a();
        if(this.s != 0 && (this.s != 1 && this.s != 2)) {
            return;
        }

        this.t();
    }

    private void t() {
        WebSettings v0 = this.n.getSettings();
        v0.setJavaScriptEnabled(true);
        v0.setPluginState(WebSettings.PluginState.ON);
        v0.setAllowFileAccess(true);
        v0.setBuiltInZoomControls(false);
        v0.setUseWideViewPort(true);
        v0.setLoadWithOverviewMode(true);
        if(this.s == 2) {
            v0.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            v0.setSupportZoom(true);
            v0.setBuiltInZoomControls(true);
            DisplayMetrics v1 = new DisplayMetrics();
            this.getWindowManager().getDefaultDisplay().getMetrics(v1);
            int v1_1 = v1.densityDpi;
            if(v1_1 == 120) {
                v0.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
            }
            else if(v1_1 == 0xA0) {
                v0.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
            }
            else if(v1_1 == 0xF0) {
                v0.setDefaultZoom(WebSettings.ZoomDensity.FAR);
            }
        }

        this.n.setWebViewClient(new WebViewClient() {
            @Override  // android.webkit.WebViewClient
            public void onPageFinished(WebView arg5, String arg6) {
                new URLDecoder();
                try {
                    arg6 = URLDecoder.decode(arg6, "UTF-8");
                }
                catch(UnsupportedEncodingException v0) {
                    v0.printStackTrace();
                }

                j.a("===onPageFinished===", arg6 + " |");
                AppsShareAuthActivity.c(AppsShareAuthActivity.this).setVisibility(8);
                int v0_1 = ShareFitness.get(AppsShareAuthActivity.this).a();
                if(!apps.c.d.strNotEmpty(arg6)) {
                    int v2 = arg6.indexOf("https://johnsondemo.herokuapp.com/authorization_callback/");
                    int v3 = arg6.indexOf("https://johnsondemo.herokuapp.com/authorization_callback/");
                    if(arg6.indexOf("https://johnsondemo.herokuapp.com/authorization_callback/") == 0 && v0_1 == 0) {
                        int v0_2 = AppsRunner.get(AppsShareAuthActivity.this).getPref_CurrentUserID(AppsShareAuthActivity.this);
                        String v1 = arg6.replaceAll("https://johnsondemo.herokuapp.com/authorization_callback/\\?code=", "");
                        ShareFitness.get(AppsShareAuthActivity.this).j(v1, v0_2 + "");
                        j.a("==code==", v1 + " |");
                        if(apps.c.d.strNotEmpty(v1)) {
                            apps.views.b.a(AppsShareAuthActivity.this, "FAILED TO GET ACCESS TOKEN");
                        }
                        else {
                            AppsShareAuthActivity.this.l();
                        }
                    }
                    else if(v2 == 0 && v0_1 == 1) {
                        String v0_3 = arg6.replaceAll("https://johnsondemo.herokuapp.com/authorization_callback/\\?code=", "");
                        int v1_1 = AppsRunner.get(AppsShareAuthActivity.this).getPref_CurrentUserID(AppsShareAuthActivity.this);
                        ShareFitness.get(AppsShareAuthActivity.this).j(v0_3, v1_1 + "");
                        j.a("==code==", v0_3 + " |");
                        if(apps.c.d.strNotEmpty(v0_3)) {
                            apps.views.b.a(AppsShareAuthActivity.this, "FAILED TO GET ACCESS TOKEN");
                        }
                        else {
                            AppsShareAuthActivity.this.m();
                        }
                    }
                    else if(v3 == 0 && v0_1 == 2) {
                        String v0_4 = arg6.replaceAll("https://johnsondemo.herokuapp.com/authorization_callback/\\?code=", "");
                        if(!apps.c.d.strNotEmpty(v0_4)) {
                            int v1_2 = v0_4.indexOf("#_=_");
                            if(v1_2 != -1) {
                                v0_4 = v0_4.substring(0, v1_2);
                            }
                        }

                        int v1_3 = AppsRunner.get(AppsShareAuthActivity.this).getPref_CurrentUserID(AppsShareAuthActivity.this);
                        ShareFitness.get(AppsShareAuthActivity.this).j(v0_4, v1_3 + "");
                        j.a("==code==", v0_4 + " |");
                        if(apps.c.d.strNotEmpty(v0_4)) {
                            apps.views.b.a(AppsShareAuthActivity.this, "FAILED TO GET ACCESS TOKEN");
                        }
                        else {
                            AppsShareAuthActivity.this.n();
                        }
                    }
                }

                super.onPageFinished(arg5, arg6);
            }

            @Override  // android.webkit.WebViewClient
            public void onPageStarted(WebView arg4, String arg5, Bitmap arg6) {
                j.a("===onPageStarted===", arg5 + " |");
                AppsShareAuthActivity.c(AppsShareAuthActivity.this).setVisibility(0);
                super.onPageStarted(arg4, arg5, arg6);
            }

            @Override  // android.webkit.WebViewClient
            public void onReceivedError(WebView arg4, int arg5, String arg6, String arg7) {
                j.a("===onReceivedError===", arg5 + " : " + arg6 + " : " + arg7);
                super.onReceivedError(arg4, arg5, arg6, arg7);
            }

            @Override  // android.webkit.WebViewClient
            public void onReceivedSslError(WebView arg2, SslErrorHandler arg3, SslError arg4) {
                if(AppsShareAuthActivity.a(AppsShareAuthActivity.this) == null && !AppsShareAuthActivity.b(AppsShareAuthActivity.this)) {
                    AlertDialog.Builder v2 = new AlertDialog.Builder(AppsShareAuthActivity.this);
                    v2.setMessage("Received an ssl certificate，do you want to trust and continue？");
                    v2.setPositiveButton("continue", new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface arg1, int arg2) {
                            arg3.proceed();
                            AppsShareAuthActivity.a(AppsShareAuthActivity.this, true);
                            AppsShareAuthActivity.a(AppsShareAuthActivity.this, null);
                        }
                    });
                    v2.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface arg1, int arg2) {
                            arg3.cancel();
                            AppsShareAuthActivity.a(AppsShareAuthActivity.this, null);
                        }
                    });
                    v2.setOnKeyListener(new DialogInterface.OnKeyListener() {
                        @Override  // android.content.DialogInterface$OnKeyListener
                        public boolean onKey(DialogInterface arg3, int arg4, KeyEvent arg5) {
                            if(arg5.getAction() == 1 && arg4 == 4) {
                                arg3.cancel();
                                arg3.dismiss();
                                AppsShareAuthActivity.a(AppsShareAuthActivity.this, null);
                                return true;
                            }

                            AppsShareAuthActivity.a(AppsShareAuthActivity.this, null);
                            return false;
                        }
                    });
                    AlertDialog v2_1 = v2.create();
                    AppsShareAuthActivity.a(AppsShareAuthActivity.this, v2_1);
                    AppsShareAuthActivity.a(AppsShareAuthActivity.this).show();
                    return;
                }

                if(AppsShareAuthActivity.b(AppsShareAuthActivity.this)) {
                    arg3.proceed();
                }
            }

            @Override  // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView arg2, String arg3) {
                arg2.loadUrl(arg3);
                j.a("===shouldOverrideUrlLoading===", arg3 + " |");
                return true;
            }
        });
        String v0_1 = ShareFitness.get(this).c();
        this.n.loadUrl(v0_1);
    }
}
