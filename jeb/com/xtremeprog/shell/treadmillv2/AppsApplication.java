package com.xtremeprog.shell.treadmillv2;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import apps.c.AppsCrashHandler;
import apps.c.ContextSharedPreferences;
import apps.c.f;
import apps.c.j;
import apps.c.m.b;
import apps.c.m;
import apps.c.o;
import apps.database.c;
import apps.database.entity.SummaryArticle;
import apps.database.entity.UserArticle;
import apps.views.a.a;
import apps.views.d;
import apps.vo.AppsArticle;
import com.xpg.a.BLEDevice;
import com.xpg.a.Enums.deviceCommandEnum;
import com.xpg.a.a.CustomHRProgramReceive;
import com.xpg.a.a.DeviceInfo;
import com.xpg.a.a.ReceiveData;
import com.xpg.a.a.Segment;
import com.xpg.a.a.StopWorkoutInfo;
import com.xpg.a.a.WorkoutData;
import com.xpg.a.a.WorkoutListMember;
import com.xpg.a.a.WorkoutSummary;
import com.xpg.a.b.CustomProgram;
import com.xpg.a.b.DeviceCommand;
import com.xpg.a.b.MyFirst5k;
import com.xpg.a.b.UserSync;
import com.xpg.a.b.Workout;
import com.xpg.a.c.Factory;
import com.xpg.b.BLEManager;
import com.xpg.b.BLEManagerMIO;
import com.xpg.b.interface_a;
import com.xpg.c.UserSlow;
import com.xpg.c.running_hr_treadmill_class;
import com.xtremeprog.sdk.ble.base.WorkDataStatus;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import org.acra.annotation.ReportsCrashes;

@ReportsCrashes(formKey = "", mailTo = "1305907498@qq.com")
public class AppsApplication extends Application implements a, interface_a {
    public interface com.xtremeprog.shell.treadmillv2.AppsApplication.a {
        void a();

        void b();
    }

    public int myFirst5k_week;
    public int myFirst5k_workout;
    public double myFirst5k_walkSpeed;
    public double myFirst5k_jogSpeed;
    public int myFirst5k_resetCount;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public String Q;
    public String R;
    public String S;
    final Handler T;
    final Handler U;
    final Handler V;
    final Handler W;
    final Handler X;
    final Handler Y;
    final Handler Z;
    final Handler a;
    private boolean aA;
    private boolean aB;
    private Handler aC;
    private int mCommandOrdinal;
    private Handler aE;
    private Handler aF;
    private Timer aG;
    private Timer aH;
    private Timer aI;
    private TimerTask aJ;
    private TimerTask aK;
    private TimerTask aL;
    private boolean aM;
    private boolean aN;
    private boolean aO;
    private Handler aP;
    private Handler aQ;
    private Handler aR;
    private Timer aS;
    private TimerTask aT;
    private int aU;
    private Handler aV;
    private Handler aW;
    private Handler aX;
    private ConcurrentHashMap aY;
    private ConcurrentHashMap aZ;
    final Handler aa;
    private final String ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private CustomProgram customProgram;
    private CustomHRProgramReceive customHRProgram;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private boolean as;
    private boolean at;
    private Handler handleConnectToDevice;
    private Handler handleConnectToMIODevice;
    private Context ctx;
    private boolean ax;
    private boolean ay;
    private boolean az;
    final Handler b;
    private ConcurrentHashMap ba;
    final Handler c;
    final Handler d;
    final Handler e;
    final Handler f;
    final Handler g;
    final Handler h;
    final Handler i;
    d j;
    d k;
    d l;
    d m;
    d n;
    d o;
    d p;
    d q;
    d r;
    d s;
    final Handler t;
    final Handler u;
    final Handler v;
    public Handler w;
    final Handler x;
    apps.views.a y;
    public int myFirst5k_userId;

    public AppsApplication() {
        this.ab = "AppsApplication";
        this.ac = false;
        this.ad = false;
        this.ae = false;
        this.af = false;
        this.ag = false;
        this.ah = false;
        this.ai = false;
        this.aj = false;
        this.ak = false;
        this.al = false;
        this.am = false;
        this.customProgram = null;
        this.customHRProgram = null;
        this.ap = false;
        this.aq = false;
        this.ar = false;
        this.as = false;
        this.at = false;
        this.handleConnectToDevice = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg5) {
                BLEDevice device = (BLEDevice)arg5.obj;
                if(((BluetoothDevice)device.getDevice()) == null) {
                    return;
                }

                String v0 = device.getDeviceName();
                if(apps.c.d.b(v0).toLowerCase().indexOf("afg pro") == -1 && apps.c.d.b(v0).toLowerCase().indexOf("afg sport") == -1 && apps.c.d.b(v0).toLowerCase().indexOf("horizon") == -1) {
                    return;
                }

                AppsRunnerConnector.get(AppsApplication.this.getApplicationContext()).parseDeviceVersion(device);
                if(AppsApplication.a(AppsApplication.this)) {
                    AppsRunnerConnector.get(AppsApplication.this.getApplicationContext()).tryToConnectPreviousDevice();
                }
                else {
                    AppsRunnerConnector.get(AppsApplication.this.getApplicationContext()).tryToConnectPreviousDevice2();
                }

                j.a("===搜索到===", v0 + " | " + AppsRunnerConnector.get(AppsApplication.this.getApplicationContext()).mDeviceList);  // found
                Intent v5_1 = new Intent();
                v5_1.setAction("NOTIFICATION_DID_FIND_DEVICE");
                AppsApplication.this.getApplicationContext().sendBroadcast(v5_1);
            }
        };
        this.handleConnectToMIODevice = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg3) {
                BLEDevice v3 = (BLEDevice)arg3.obj;
                if(v3 == null) {
                    return;
                }

                String v0 = v3.getDeviceName();
                AppsRunnerConnector.get(AppsApplication.this.getApplicationContext()).h(v3);
                j.a("===搜索到MIO===", v0 + " | " + AppsRunnerConnector.get(AppsApplication.this.getApplicationContext()).i);  // Searched to MIO
                if(AppsApplication.this.isConnectionCorrect()) {
                    j.a("===同步完的===", "==可以尝试连接==");  // After syncing, you can try to connect
                    AppsApplication.this.A();
                }
                else {
                    j.a("===未同步完的===", "==等同步完再尝试连接==");  // Unsynchronized, Wait until the synchronization is complete and then try to connect
                }

                Intent v3_1 = new Intent();
                v3_1.setAction("NOTIFICATION_MIO_DID_FIND_DEVICE");
                AppsApplication.this.getApplicationContext().sendBroadcast(v3_1);
            }
        };
        this.a = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                Intent v2 = (Intent)arg2.obj;
                AppsApplication.this.getApplicationContext().sendBroadcast(v2);
            }
        };
        this.b = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg1) {
                AppsApplication.this.p();
            }
        };
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.c = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg5) {
                int v5 = AppsRunner.get(AppsApplication.b(AppsApplication.this)).getPref_CurrentUserID(AppsApplication.b(AppsApplication.this));
                AppsApplication.this.doRefreshMMFToken2WithCallbackWithStep(v5 + "", 1);
                AppsApplication.this.doRefreshMFPToken2WithCallbackWithStep(v5 + "", 1);
                AppsApplication.this.doRefreshFBToken2WithCallbackWithStep(v5 + "", 1);
            }
        };
        this.d = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                j.a("=====", "===开始弹出loading===");
                AppsApplication.this.n(true);
                AppsApplication.this.refreshToken(false);
                AppsApplication.this.p(false);
                try {
                    Context v4_1 = AppsRunner.get(AppsApplication.b(AppsApplication.this)).a();
                    AppsApplication.this.a(v4_1, "", false);
                }
                catch(Exception v4) {
                    v4.printStackTrace();
                }
            }
        };
        this.e = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                j.a("====", "===关闭loading===");
                AppsApplication.this.B();
                AppsApplication.this.n(false);
            }
        };
        this.aC = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg1) {
                AppsRunnerConnector.get(AppsApplication.this.getApplicationContext()).getMachineInfo();
            }
        };
        this.f = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.what == 0x6F) {
                    int v4 = ((WorkDataStatus)arg4.obj).getHeadTag();
                    if(AppsApplication.this.J()) {
                        AppsApplication.this.a(v4);
                        return;
                    }
                }
                else if(arg4.what == 0xDE) {
                    int v4_1 = (int)(((Integer)arg4.obj));
                    if(AppsApplication.this.J()) {
                        AppsApplication.this.showSafetyAlert(v4_1, -1, true);
                        return;
                    }
                }
                else {
                    if(arg4.what == 333) {
                        Intent v4_2 = new Intent();
                        v4_2.setAction("NOTIFICATION_RECEIVE_START_RUNNING_ACTIVITY");
                        AppsApplication.this.getApplicationContext().sendBroadcast(v4_2);
                        return;
                    }

                    if(arg4.what == 444) {
                        int v4_3 = (int)(((Integer)arg4.obj));
                        if(AppsApplication.this.J()) {
                            AppsApplication.this.a(v4_3);
                        }

                        new Thread() {
                            @Override
                            public void run() {
                                if(!AppsRunner.get(AppsApplication.this.getApplicationContext()).a) {
                                    AppsRunner.get(AppsApplication.this.getApplicationContext()).b(AppsApplication.this.getApplicationContext(), new Date());
                                }
                            }
                        }.start();
                        return;
                    }

                    if(arg4.what == 555) {
                        int v4_4 = (int)(((Integer)arg4.obj));
                        Intent v0 = new Intent();
                        v0.setAction("NOTIFICATION_DID_GET_MACHINE_INFO_SUCCESS");
                        v0.putExtra("Extra_Key_Workout_State", v4_4);
                        AppsApplication.this.getApplicationContext().sendBroadcast(v0);
                        return;
                    }

                    if(arg4.what == 666) {
                        int v4_5 = (int)(((Integer)arg4.obj));
                        if(AppsApplication.this.J()) {
                            AppsApplication.this.showStopAlert(v4_5);
                        }
                    }
                }
            }
        };
        this.g = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg6) {
                int v0 = (int)(((Integer)arg6.obj));
                int v6 = arg6.what;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        AppsApplication.this.d(v0, v6);
                    }
                }, 500L);
            }
        };
        this.h = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message msg) {
                int obj = (int)(((Integer)msg.obj));
                int command = msg.what;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        AppsApplication.this.retryCommand(obj, command);
                    }
                }, 500L);
            }
        };
        this.i = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg5) {
                int v5 = (int)(((Integer)arg5.obj));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        AppsApplication.this.e(v5);
                    }
                }, 500L);
            }
        };
        this.mCommandOrdinal = -1;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.aE = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg1) {
                if(AppsRunnerConnector.get(AppsApplication.this.getApplicationContext()).isConnected()) {
                    AppsApplication.this.setHeartValueMaybe();
                }
            }
        };
        this.aF = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg1) {
                if(AppsRunnerConnector.get(AppsApplication.this.getApplicationContext()).isConnected()) {
                    AppsApplication.this.setHeartValueMaybe();
                }
            }
        };
        this.t = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg1) {
                AppsApplication.this.w();
            }
        };
        this.u = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg1) {
                AppsApplication.this.x();
            }
        };
        this.v = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg8) {
                int v1;
                AppsApplication v0_2;
                int v0 = arg8.what;
                int v8 = (int)(((Integer)arg8.obj));
                if(v0 == 0) {
                    j.a("====", "==无心率==" + AppsApplication.this.J());
                    if(AppsApplication.this.J()) {
                        Intent v0_1 = new Intent();
                        v0_1.putExtra("disappearTime", v8);
                        v0_1.setAction("NOTIFICATION_SHOW_NO_HR_TIP");
                        AppsApplication.this.getApplicationContext().sendBroadcast(v0_1);
                        j.a("==send no hr broadcast==", "" + v8);
                        return;
                    }
                }
                else if(v0 == 2) {
                    j.a("====", "==安全锁被拨出==");
                    if(AppsApplication.this.J()) {
                        AppsRunner.get(AppsApplication.b(AppsApplication.this)).securitySwitch = 1;
                        AppsApplication.a(AppsApplication.this, false);
                        AppsApplication.this.a(0);
                        AppsApplication.this.showSafetyAlert(1, v8, true);
                        return;
                    }
                }
                else if(v0 == 1) {
                    j.a("====", "==安全锁正常==");
                    if(AppsApplication.this.J()) {
                        AppsRunner.get(AppsApplication.b(AppsApplication.this)).securitySwitch = 0;
                        AppsApplication.a(AppsApplication.this, false);
                        AppsApplication.this.a(0);
                        AppsApplication.this.showSafetyAlert(0, v8, true);
                        j.a("===", AppsRunner.get(AppsApplication.b(AppsApplication.this)).getPref_CurrentUserID(AppsApplication.b(AppsApplication.this)) == 0 ? "安全锁插上 set user" : "安全锁插上 select user");
                        return;
                    }
                }
                else if(v0 == 3) {
                    j.a("====", "==SLOW DOWN==");
                    if(!AppsApplication.this.J()) {
                        return;
                    }

                    v0_2 = AppsApplication.this;
                    v1 = 0x7F0B00C2;  // string:STR_SLOW_DOWN "SLOW DOWN"
                    v0_2.f(v1, v8);
                    return;
                }
                else {
                    if(v0 == 4) {
                        j.a("====", "SPEED UP");
                        if(!AppsApplication.this.J()) {
                            return;
                        }

                        v0_2 = AppsApplication.this;
                        v1 = 0x7F0B00C4;  // string:STR_SPEED_UP "SPEED UP"
                        v0_2.f(v1, v8);
                        return;
                    }

                    if(v0 == 5) {
                        j.a("====", "1 WEEK MISSED.REPEAT LAST WEEK");
                        if(AppsApplication.this.J()) {
                            int v0_3 = AppsRunner.get(AppsApplication.b(AppsApplication.this)).k(AppsApplication.b(AppsApplication.this));
                            j.a("====", "isInSetting:" + AppsApplication.this.b() + "  mode:" + v0_3);
                            if((AppsApplication.this.b()) && v0_3 == 5) {
                                AppsApplication.this.e(0x7F0B0002, v8);  // string:STR_1_WEEK_MISSED "1 WEEK MISSED.\nREPEAT LAST WEEK."
                                int v8_1 = AppsRunner.get(AppsApplication.b(AppsApplication.this)).getPref_CurrentUserID(AppsApplication.b(AppsApplication.this));
                                AppsRunner.get(AppsApplication.b(AppsApplication.this)).o(AppsApplication.b(AppsApplication.this), 0, v8_1);
                                return;
                            }

                            int v0_4 = AppsRunner.get(AppsApplication.b(AppsApplication.this)).getPref_CurrentUserID(AppsApplication.b(AppsApplication.this));
                            AppsRunner.get(AppsApplication.b(AppsApplication.this)).o(AppsApplication.b(AppsApplication.this), 1, v0_4);
                            AppsRunner.get(AppsApplication.b(AppsApplication.this)).p(AppsApplication.b(AppsApplication.this), v8, v0_4);
                            return;
                        }
                    }
                    else if(v0 == 6) {
                        j.a("====", "2 WEEKS MISSED.START OVER.");
                        if(AppsApplication.this.J()) {
                            int v0_5 = AppsRunner.get(AppsApplication.b(AppsApplication.this)).k(AppsApplication.b(AppsApplication.this));
                            j.a("====", "isInSetting:" + AppsApplication.this.b() + "  mode:" + v0_5);
                            if((AppsApplication.this.b()) && v0_5 == 5) {
                                AppsApplication.this.e(0x7F0B0003, v8);  // string:STR_2_WEEKS_MISSED "2 WEEKS MISSED.\nSTART OVER."
                                int v8_2 = AppsRunner.get(AppsApplication.b(AppsApplication.this)).getPref_CurrentUserID(AppsApplication.b(AppsApplication.this));
                                AppsRunner.get(AppsApplication.b(AppsApplication.this)).q(AppsApplication.b(AppsApplication.this), 0, v8_2);
                                return;
                            }

                            int v0_6 = AppsRunner.get(AppsApplication.b(AppsApplication.this)).getPref_CurrentUserID(AppsApplication.b(AppsApplication.this));
                            AppsRunner.get(AppsApplication.b(AppsApplication.this)).q(AppsApplication.b(AppsApplication.this), 1, v0_6);
                            AppsRunner.get(AppsApplication.b(AppsApplication.this)).r(AppsApplication.b(AppsApplication.this), v8, v0_6);
                        }
                    }
                }
            }
        };
        this.w = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsRunner.get(AppsApplication.b(AppsApplication.this)).getPref_CurrentUserID(AppsApplication.b(AppsApplication.this));
                AppsRunner.get(AppsApplication.b(AppsApplication.this)).selectUserInfo();
                AppsApplication.this.y();
            }
        };
        this.x = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                if(AppsApplication.c(AppsApplication.this)) {
                    j.a("===", "==select or set user time out==");
                    Message v0 = new Message();
                    AppsApplication.this.e.sendMessage(v0);
                    AppsApplication.this.refreshToken(true);
                    Intent v2 = new Intent();
                    v2.setAction("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER");
                    AppsApplication.this.getApplicationContext().sendBroadcast(v2);
                    AppsApplication.b(AppsApplication.this, false);
                    AppsApplication.this.A();
                }
                else {
                    j.a("===", "==select or set user do not time out==");
                }

                Intent v2_1 = new Intent();
                v2_1.setAction("NOTIFICATION_CANCEL_SELECT_USER_LOADING");
                AppsApplication.this.getApplicationContext().sendBroadcast(v2_1);
            }
        };
        this.T = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(arg4.obj != null) {
                    try {
                        j.a("===", "将会保存1");
                        AppsArticle v4_1 = (AppsArticle)arg4.obj;
                        j.a("===", "将会保存2" + v4_1);
                        AppsApplication.this.a(v4_1);
                        j.a("===", "将会保存3");
                    }
                    catch(Exception v4) {
                        v4.printStackTrace();
                        j.a("===", "保存出错");
                    }

                    return;
                }
            }
        };
        this.aM = false;
        this.aN = false;
        this.aO = false;
        this.U = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg6) {
                String v0;
                String v6;
                if(AppsApplication.d(AppsApplication.this)) {
                    v6 = "====";
                    v0 = "==正在调用MMF分享中，等下再分享下一条==";
                    j.a(v6, v0);
                    return;
                }

                if(!apps.c.d.d(AppsApplication.b(AppsApplication.this))) {
                    AppsApplication.c(AppsApplication.this, false);
                    v6 = "====";
                    v0 = "==没有网络，暂不分享==";
                    j.a(v6, v0);
                    return;
                }

                if(!AppsApplication.this.isConnectionCorrect()) {
                    AppsApplication.c(AppsApplication.this, false);
                    v6 = "==MMF==";
                    v0 = "==未完成同步，暂不分享==";
                    j.a(v6, v0);
                    return;
                }

                List v6_1 = c.a().a(AppsApplication.b(AppsApplication.this));
                if(v6_1 != null && v6_1.size() > 0) {
                    j.a("====", "==有网络，开始分享MMF离线数据==");
                    if(!AppsApplication.d(AppsApplication.this)) {
                        AppsApplication.c(AppsApplication.this, true);
                        Map v6_2 = (Map)v6_1.get(0);
                        try {
                            String v1 = (String)v6_2.get("mmfToken");
                            int v3 = (int)(((Integer)v6_2.get("id")));
                            if(!apps.c.d.strNotEmpty(v1) && !apps.c.d.a(v1, "0000000000000000000000000000000000000000")) {
                                goto label_67;
                            }

                            c.a().a(AppsApplication.b(AppsApplication.this), v3);
                            AppsApplication.c(AppsApplication.this, false);
                            return;
                        }
                        catch(Exception v0_1) {
                            v0_1.printStackTrace();
                        }

                    label_67:
                        AppsApplication.this.MMFRefreshToken(v6_2, 1);
                        return;
                    }
                }
                else {
                    j.a("====", "==有网络，但没有MMF离线数据需要分享==");
                    AppsApplication.c(AppsApplication.this, false);
                }
            }
        };
        this.V = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg7) {
                String v0;
                String v7;
                if(AppsApplication.e(AppsApplication.this)) {
                    v7 = "====";
                    v0 = "==正在调用MFP分享中，等下再分享下一条==";
                    j.a(v7, v0);
                    return;
                }

                if(!apps.c.d.d(AppsApplication.b(AppsApplication.this))) {
                    AppsApplication.d(AppsApplication.this, false);
                    v7 = "====";
                    v0 = "==没有网络，暂不分享==";
                    j.a(v7, v0);
                    return;
                }

                if(!AppsApplication.this.isConnectionCorrect()) {
                    AppsApplication.d(AppsApplication.this, false);
                    v7 = "==MFP==";
                    v0 = "==未完成同步，暂不分享==";
                    j.a(v7, v0);
                    return;
                }

                List v7_1 = c.a().b(AppsApplication.b(AppsApplication.this));
                if(v7_1 != null && v7_1.size() > 0) {
                    j.a("====", "==有网络，开始分享MFP离线数据==");
                    if(!AppsApplication.e(AppsApplication.this)) {
                        AppsApplication.d(AppsApplication.this, true);
                        Map v7_2 = (Map)v7_1.get(0);
                        try {
                            String v1 = (String)v7_2.get("mfpUserId");
                            String v3 = (String)v7_2.get("mfpToken");
                            int v4 = (int)(((Integer)v7_2.get("id")));
                            if(!apps.c.d.strNotEmpty(v1) && !apps.c.d.strNotEmpty(v3) && !apps.c.d.a(v3, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000") && !apps.c.d.a(v1, "000000000000000")) {
                                goto label_75;
                            }

                            c.a().b(AppsApplication.b(AppsApplication.this), v4);
                            AppsApplication.d(AppsApplication.this, false);
                            return;
                        }
                        catch(Exception v0_1) {
                            v0_1.printStackTrace();
                        }

                    label_75:
                        AppsApplication.this.shareMFP(v7_2, 1);
                        return;
                    }
                }
                else {
                    j.a("====", "==有网络，但没有MFP离线数据需要分享==");
                    AppsApplication.d(AppsApplication.this, false);
                }
            }
        };
        this.W = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg7) {
                String v0;
                String v7;
                if(AppsApplication.f(AppsApplication.this)) {
                    v7 = "====";
                    v0 = "==正在调用FB分享中，等下再分享下一条==";
                    j.a(v7, v0);
                    return;
                }

                if(!apps.c.d.d(AppsApplication.b(AppsApplication.this))) {
                    AppsApplication.e(AppsApplication.this, false);
                    v7 = "====";
                    v0 = "==没有网络，暂不分享==";
                    j.a(v7, v0);
                    return;
                }

                if(!AppsApplication.this.isConnectionCorrect()) {
                    AppsApplication.e(AppsApplication.this, false);
                    v7 = "==FB==";
                    v0 = "==未完成同步，暂不分享==";
                    j.a(v7, v0);
                    return;
                }

                List v7_1 = c.a().c(AppsApplication.b(AppsApplication.this));
                if(v7_1 != null && v7_1.size() > 0) {
                    j.a("====", "==有网络，开始分享FB离线数据==");
                    if(!AppsApplication.f(AppsApplication.this)) {
                        AppsApplication.e(AppsApplication.this, true);
                        Map v7_2 = (Map)v7_1.get(0);
                        try {
                            String v1 = (String)v7_2.get("key2");
                            String v3 = (String)v7_2.get("key1");
                            int v4 = (int)(((Integer)v7_2.get("id")));
                            if(!apps.c.d.strNotEmpty(v1) && !apps.c.d.strNotEmpty(v3) && !apps.c.d.a(v3, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000") && !apps.c.d.a(v1, "000000")) {
                                goto label_75;
                            }

                            c.a().c(AppsApplication.b(AppsApplication.this), v4);
                            AppsApplication.e(AppsApplication.this, false);
                            return;
                        }
                        catch(Exception v0_1) {
                            v0_1.printStackTrace();
                        }

                    label_75:
                        AppsApplication.this.shareFB(v7_2, 1);
                        return;
                    }
                }
                else {
                    j.a("====", "==有网络，但没有FB离线数据需要分享==");  // There is a network, but there is no FB offline data to share
                    AppsApplication.e(AppsApplication.this, false);
                }
            }
        };
        this.aP = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                Map v0 = (Map)arg4.obj;
                int v4 = arg4.arg1;
                AppsApplication.d(AppsApplication.this, true);
                AppsApplication.this.shareMFP(v0, v4);
            }
        };
        this.aQ = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                Map v0 = (Map)arg4.obj;
                int v4 = arg4.arg1;
                AppsApplication.e(AppsApplication.this, true);
                AppsApplication.this.shareFB(v0, v4);
            }
        };
        this.aR = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                Map v0 = (Map)arg4.obj;
                int v4 = arg4.arg1;
                AppsApplication.c(AppsApplication.this, true);
                AppsApplication.this.MMFRefreshToken(v0, v4);
            }
        };
        this.aU = 0;
        this.X = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                if(AppsRunnerConnector.get(AppsApplication.b(AppsApplication.this)).f().size() == 0) {
                    AppsApplication.g(AppsApplication.this);
                }
                else {
                    AppsApplication.a(AppsApplication.this, 0);
                }

                j.a("===", "===检测搜索状态 " + AppsApplication.h(AppsApplication.this) + "===");  // Check search status
                if(AppsApplication.h(AppsApplication.this) >= 7) {
                    j.a("===", "==长时间无设备，关闭下蓝牙==");  // No device for a long time, turn off Bluetooth
                    BLEManager.get(AppsApplication.b(AppsApplication.this)).stopScan();
                    BLEManager.get(AppsApplication.b(AppsApplication.this)).disableBluetooth();
                    AppsApplication.this.d(false, 0, 0);
                    Message v0 = new Message();
                    AppsApplication.this.Y.sendMessageDelayed(v0, 2000L);
                    Message v0_1 = new Message();
                    AppsApplication.this.Z.sendMessageDelayed(v0_1, 3000L);
                }
            }
        };
        this.Y = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg4) {
                j.a("===", "==重新打开蓝牙==");  // Turn on Bluetooth again
                BLEManager.get(AppsApplication.b(AppsApplication.this)).enableAdapter();
                AppsApplication.this.d(true, 5000, 1000);
            }
        };
        this.Z = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                j.a("===", "==打开蓝牙后开启搜索==");  // Start search after turning on Bluetooth
                BLEManager.get(AppsApplication.b(AppsApplication.this)).startScan();
            }
        };
        this.aa = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg1) {
                AppsApplication.this.doRefreshToken();
            }
        };
        this.aV = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsApplication.this.doMMFLogin(((String)arg2.obj));
            }
        };
        this.aW = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsApplication.this.g(((String)arg2.obj));
            }
        };
        this.aX = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message arg2) {
                AppsApplication.this.h(((String)arg2.obj));
            }
        };
        this.aY = new ConcurrentHashMap();
        this.aZ = new ConcurrentHashMap();
        this.ba = new ConcurrentHashMap();
    }

    public void A() {
        List v0 = AppsRunnerConnector.get(this.getApplicationContext()).i();
        j.a("===同步完后的select或setUser若完成===", "===尝试连接MIO设备=== : " + v0);  // If the select or setUser after synchronization is completed, try to connect to the MIO device
        if(v0.size() > 0) {
            AppsRunnerConnector.get(this.getApplicationContext()).connectMIODevice();
        }
    }

    public void B() {
        if(this.y != null && (this.y.isShowing())) {
            this.y.cancel();
            this.y = null;
        }
    }

    public boolean C() {
        return this.ad;
    }

    public void resendSelectProgram() {
        int v0 = AppsRunner.get(this.ctx).k(this.ctx);
        j.a("==resend select program==", v0 + " |");
        AppsRunnerConnector.get(this).selectProgram(v0);
    }

    public void resendSetMyFirst5k() {
        int userId = this.myFirst5k_userId;
        int week = this.myFirst5k_week;
        int workout = this.myFirst5k_workout;
        double walkSpeed = this.myFirst5k_walkSpeed;
        double jogSpeed = this.myFirst5k_jogSpeed;
        int resetCount = this.myFirst5k_resetCount;
        j.a("===resend setMyFirst5K===", userId + " | " + week + " | " + workout + " | " + walkSpeed + " | " + jogSpeed + " | ");
        BLEManager.get(this).maybe_send_message2(DeviceCommand.setMyFirst5K(Factory.MyFirst5K(userId, week, workout, walkSpeed, jogSpeed, resetCount)), 4, 4000);  // MyFirst5K(int arg1, int week, int workout, double walkSpeed, double jogSpeed, int resetCount)
    }

    public void deleteUser() {
        AppsRunner.get(this).g(this.F);
    }

    public void resendSelectUser() {
        int v0 = this.G;
        j.a("===resend select user===", v0 + " |");
        AppsRunner.get(this).selectUserInfo(v0);
    }

    public void resendUserEdit() {
        AppsApplication ctx = this;
        int userId = AppsRunner.get(this).getPref_CurrentUserID(ctx);
        String token_mmf = ShareFitness.get(this).getPrefsMapMyFitnessTokenKey(userId + "");
        String token_mfp = ShareFitness.get(this).getPrefsMFPTokenId(userId + "");
        String token_fb = ShareFitness.get(this).getPrefsFitbitTokenId(userId + "");
        String v5 = ShareFitness.get(this).getPrefsMFP_UserId(userId + "");
        String v1_1 = ShareFitness.get(this).getPrefsFitbitUserId(userId + "");
        if(apps.c.d.strNotEmpty(token_mmf)) {
            token_mmf = "0000000000000000000000000000000000000000";
        }

        if(apps.c.d.strNotEmpty(token_mfp)) {
            token_mfp = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        }

        if(apps.c.d.strNotEmpty(token_fb)) {
            token_fb = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        }

        if(apps.c.d.strNotEmpty(v5)) {
            v5 = "000000000000000";
        }

        if(apps.c.d.strNotEmpty(v1_1)) {
            v1_1 = "000000";
        }

        j.a("==三个token为==", "MMF : " + token_mmf + "  |   MFP:" + token_mfp + "  |  " + v5 + "  |  FB:" + token_fb + "  |  " + v1_1);
        j.a("===resend USER EDIT===", ctx.H + " | " + ctx.Q + " | " + ctx.P + " | " + ctx.I + " | " + ctx.L + " | " + ctx.M + " | " + ctx.N + " | " + ctx.K + " | " + ctx.J + " | " + token_mmf + " | " + token_mfp + " | " + v5 + " | " + token_fb + " | " + v1_1);
        AppsRunner.get(this).setUserData(ctx.H, ctx.I, ctx.J, ctx.K, ctx.L, ctx.M, ctx.N, ctx.O, ctx.P, ctx.Q, token_mmf, token_mfp, v5, token_fb, v1_1);
    }

    public boolean isConnectionCorrect() {
        return (AppsRunnerConnector.get(this.getApplicationContext()).isConnected()) && (this.ay) && (this.ai) && (this.az);
    }

    public boolean J() {
        return this.ai;
    }

    public void K() {
        if(apps.c.d.c(this.ctx)) {
            this.a(false, 0, 0);
            return;
        }

        Message v1 = new Message();
        this.U.sendMessage(v1);
    }

    public void L() {
        if(apps.c.d.c(this.ctx)) {
            this.b(false, 0, 0);
            return;
        }

        Message v1 = new Message();
        this.V.sendMessage(v1);
    }

    public void M() {
        if(apps.c.d.c(this.ctx)) {
            this.c(false, 0, 0);
            return;
        }

        Message v1 = new Message();
        this.W.sendMessage(v1);
    }

    public void N() {
        this.d(true, 0, 1000);
    }

    public void O() {
    }

    public boolean P() {
        return true;
    }

    public boolean Q() {
        return true;
    }

    public boolean R() {
        return true;
    }

    public void doRefreshToken() {
        if(!this.isConnectionCorrect()) {
            j.a("==doRefreshToken==", "==未同步完，先不刷新==");
            return;
        }

        int v0 = AppsRunner.get(this).getPref_CurrentUserID(this.ctx);
        if(this.P()) {
            ShareFitness.get(this.ctx).a(this.ctx, v0 + "", 1);
        }

        if(this.Q()) {
            ShareFitness.get(this.ctx).b(this.ctx, v0 + "", 1);
        }
    }

    static int a(AppsApplication arg0, int arg1) {
        arg0.aU = arg1;
        return arg1;
    }

    static boolean a(AppsApplication arg0) {
        return arg0.am;
    }

    static boolean a(AppsApplication arg0, boolean arg1) {
        arg0.ae = arg1;
        return arg1;
    }

    public String a(String arg2) {
        if(apps.c.d.a(arg2, "USER 1")) {
            return "USER1";
        }

        if(apps.c.d.a(arg2, "USER 2")) {
            return "USER2";
        }

        if(apps.c.d.a(arg2, "USER 3")) {
            return "USER3";
        }

        if(apps.c.d.a(arg2, "USER 4")) {
            return "USER4";
        }

        if(apps.c.d.a(arg2, "USER 5")) {
            return "USER5";
        }

        if(apps.c.d.a(arg2, "USER 6")) {
            return "USER6";
        }

        if(apps.c.d.a(arg2, "Usuario 1")) {
            return "Usuario1";
        }

        if(apps.c.d.a(arg2, "Usuario 2")) {
            return "Usuario2";
        }

        if(apps.c.d.a(arg2, "Usuario 3")) {
            return "Usuario3";
        }

        if(apps.c.d.a(arg2, "Usuario 4")) {
            return "Usuario4";
        }

        if(apps.c.d.a(arg2, "Usuario 5")) {
            return "Usuario5";
        }

        if(apps.c.d.a(arg2, "Usuario 6")) {
            return "Usuario6";
        }

        if(apps.c.d.a(arg2, "Utilisateur 1")) {
            return "Utilisateur1";
        }

        if(apps.c.d.a(arg2, "Utilisateur 2")) {
            return "Utilisateur2";
        }

        if(apps.c.d.a(arg2, "Utilisateur 3")) {
            return "Utilisateur3";
        }

        if(apps.c.d.a(arg2, "Utilisateur 4")) {
            return "Utilisateur4";
        }

        if(apps.c.d.a(arg2, "Utilisateur 5")) {
            return "Utilisateur5";
        }

        return apps.c.d.a(arg2, "Utilisateur 6") ? "Utilisateur6" : arg2;
    }

    public void a(int arg4) {
        Intent v0_1;
        j.a("==showStopAlert==", arg4 + " |");
        if(arg4 != 1 && arg4 != 2) {
            this.ae = false;
            if(this.k == null || !this.k.isShowing()) {
                return;
            }

            try {
                this.k.dismiss();
            }
            catch(Exception v0) {
                v0.printStackTrace();
            }

            this.k = null;
            v0_1 = new Intent();
        }
        else {
            this.ae = true;
            if(this.k != null) {
                return;
            }

            try {
                apps.views.d.a v0_3 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                v0_3.b(0x7F0B0134);  // string:prompt "Warning"
                v0_3.a(0x7F0B00C1);  // string:STR_SHOULD_STOP_RUNNER "A program is currently running. Please end the program before starting a new one."
                this.k = v0_3.a();
                this.k.setCancelable(false);
                this.k.setCanceledOnTouchOutside(false);
                this.k.show();
            }
            catch(Exception v0_2) {
                v0_2.printStackTrace();
            }

            v0_1 = new Intent();
        }

        v0_1.setAction("NOTIFICATION_RECEIVE_WORKOUT_STATUS_FROM_DEVICE");
        v0_1.putExtra("Extra_Key_Workout_State", arg4);
        this.getApplicationContext().sendBroadcast(v0_1);
    }

    public void a(int arg4, int arg5) {
        Message v0 = new Message();
        v0.what = arg5;
        v0.obj = new Integer(arg4);
        this.g.sendMessageDelayed(v0, 500L);
    }

    public void showSafetyAlert(int arg7, int arg8, boolean arg9) {
        Intent v8_1;
        if(AppsRunner.get(this.getApplicationContext()).l(this.getApplicationContext()) == 5) {
            arg7 = 0;
        }

        if(arg7 == 1) {
            if(arg9) {
                Intent v9 = new Intent();
                v9.setAction("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE_BEFORE_SHOW");
                this.getApplicationContext().sendBroadcast(v9);
            }

            j.a("=====", "==这里如果有弹出stop的提示，要让stop的提示给消失掉==");
            if(this.J()) {
                this.a(0);
            }

            j.a("====showSafetyAlert()1====" + arg7, this.j + " |");
            if(!this.aj) {
                if(this.j == null) {
                    try {
                        apps.views.d.a v9_1 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                        v9_1.b(0x7F0B0134);  // string:prompt "Warning"
                        v9_1.a(0x7F0B00B9);  // string:STR_SAVE_KEY_LOST "INSERT SAFETY KEY"
                        v9_1.a(0x7F0B000D, new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_OK "OK"
                            @Override  // android.content.DialogInterface$OnClickListener
                            public void onClick(DialogInterface arg1, int arg2) {
                                try {
                                    arg1.dismiss();
                                }
                                catch(Exception v1) {
                                    v1.printStackTrace();
                                }

                                AppsApplication.this.j = null;
                            }
                        });
                        this.j = v9_1.a();
                        this.j.setCanceledOnTouchOutside(false);
                        this.j.show();
                        if(arg8 != -1 && arg8 != 0xA5) {
                            if(arg8 == 0) {
                                arg8 = 3;
                            }

                            new Handler().postDelayed(() -> if(AppsApplication.this.j != null && (AppsApplication.this.j.isShowing())) {
                                try {
                                    AppsApplication.this.j.dismiss();
                                }
                                catch(Exception v0) {
                                    v0.printStackTrace();
                                    AppsApplication.this.j = null;
                                    return;
                                }

                                AppsApplication.this.j = null;
                            }, ((long)(arg8 * 1000)));
                        }
                    }
                    catch(Exception v8) {
                        v8.printStackTrace();
                        j.a("====showSafetyAlert()2====", v8.getMessage() + " |");
                    }
                }

                v8_1 = new Intent();
                v8_1.setAction("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE");
                v8_1.putExtra("Extra_Key_SafetyKey_State", arg7);
                this.getApplicationContext().sendBroadcast(v8_1);
                return;
            }

            if(this.j != null && (this.j.isShowing())) {
                try {
                    this.j.dismiss();
                }
                catch(Exception v8_2) {
                    v8_2.printStackTrace();
                    j.a("====showSafetyAlert()2====", v8_2.getMessage() + " |");
                    this.j = null;
                    goto label_114;
                }

                this.j = null;
            }

        label_114:
            if(this.j != null) {
                return;
            }

            try {
                apps.views.d.a v8_4 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                v8_4.b(0x7F0B0134);  // string:prompt "Warning"
                v8_4.a(0x7F0B00B9);  // string:STR_SAVE_KEY_LOST "INSERT SAFETY KEY"
                v8_4.a(0x7F0B000D, new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_OK "OK"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        AppsApplication.this.j = null;
                    }
                });
                this.j = v8_4.a();
                this.j.setCanceledOnTouchOutside(false);
                this.j.show();
            }
            catch(Exception v8_3) {
                v8_3.printStackTrace();
                j.a("====showSafetyAlert()2====", v8_3.getMessage() + " |");
            }
        }
        else {
            String v0 = this.j == null ? "false" : this.j.isShowing() + "";
            j.a("====showSafetyAlert()1====" + arg7, this.j + " | " + v0);
            if(this.j == null || !this.j.isShowing()) {
                return;
            }

            try {
                this.j.dismiss();
            }
            catch(Exception v8_5) {
                v8_5.printStackTrace();
                j.a("====showSafetyAlert()2====", v8_5.getMessage() + " |");
            }

            this.j = null;
        }

        v8_1 = new Intent();
        v8_1.setAction("NOTIFICATION_RECEIVE_SAFE_KEY_FROM_DEVICE");
        v8_1.putExtra("Extra_Key_SafetyKey_State", arg7);
        this.getApplicationContext().sendBroadcast(v8_1);

        class com.xtremeprog.shell.treadmillv2.AppsApplication.3 implements Runnable {
            @Override
            public void run() {
                AppsApplication.this.u();
            }
        }

    }

    public void a(Context arg1) {
        this.ctx = arg1;
    }

    public void a(Context arg2, String arg3, boolean arg4) {
        if(this.y == null) {
            this.y = new apps.views.a(arg2, this);
        }

        this.y.setCancelable(((boolean)(((int)arg4))));
        if(!this.y.isShowing()) {
            this.y.a(arg3);
        }
    }

    public void a(AppsArticle arg2) {
        new Thread() {
            @Override
            public void run() {
                j.a("===", "==在线程中保存summary==");  // Save summary in thread
                AppsRunner.get(AppsApplication.b(AppsApplication.this)).summarySession(AppsApplication.b(AppsApplication.this), arg2);
            }
        }.start();
    }

    @Override  // com.xpg.b.interface_a
    public void sendMessage(BLEDevice device, int type) {
        Handler handler;
        Message msg;
        if(type == 2) {
            msg = new Message();
            msg.obj = device;
            handler = this.handleConnectToMIODevice;
        }
        else {
            msg = new Message();
            msg.obj = device;
            handler = this.handleConnectToDevice;
        }

        handler.sendMessage(msg);
    }

    @Override  // com.xpg.b.interface_a
    public void receiveData(Object msg, int type) {
        float v15_2;
        float v14_3;
        float v3_21;
        Message v1_31;
        String v2_27;
        String v2_25;
        Intent v1_26;
        String v2_21;
        Intent v1_24;
        Intent v2_16;
        Integer v3_17;
        Message v1_14;
        String v4_10;
        Intent v3_15;
        StringBuilder v7_4;
        String v5_6;  // Get the model
        Intent v1_13;
        String v2_6;
        Intent v1_8;
        StringBuilder v5_5;
        String v4_8;
        String v27_1;
        int userId;
        float maxSpeed;
        int maxHR;
        int units;
        int result;
        String __prefsFitbitUserId;
        Intent v0_4;
        String v1_1;
        Intent v0_3;
        AppsApplication app = this;
        if(type == 2) {
            return;
        }

        ReceiveData receiveData = (ReceiveData)msg;
        double v9 = 0.0;
        double v11 = 1.0;
        int v13 = 0;
        switch(receiveData.getDeviceResponse()) {
            case timeout: {
                AppsApplication app = app;
                deviceCommandEnum v0_1 = receiveData.getDeviceCommand();
                if(v0_1 == deviceCommandEnum.set_user) {
                    j.a("==timeout==", "==set user 超时==");
                    if(this.g()) {
                        if(this.J()) {
                            app.a(0x7F0B005A, -1);  // string:STR_FAILED_TO_UPDATE_USER_TOKEN_OF_CONSOLE "FAILED TO UPDATE USER TOKEN OF CONSOLE"
                        }
                    }
                    else if(this.J()) {
                        app.b(0x7F0B0053, v0_1.ordinal());  // string:STR_FAILED_TO_SAVE_USER "FAILED TO SAVE USER OF CONSOLE"
                    }
                }
                else if(v0_1 == deviceCommandEnum.select_user) {
                    j.a("==timeout==", "==select user 超时==");
                    if(this.J()) {
                        if(!app.ak && !app.al) {
                            j.a("===", "不是在home或user list，不弹select user超时");
                        }
                        else {
                            app.b(0x7F0B0055, v0_1.ordinal());  // string:STR_FAILED_TO_SELECT_USER "FAILED TO SELECT USER"
                        }
                    }

                    if(app.ap) {
                        Message v1 = new Message();
                        app.e.sendMessage(v1);
                        app.refreshToken(true);
                        Intent v0_2 = new Intent();
                        v0_2.setAction("NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER");
                        this.getApplicationContext().sendBroadcast(v0_2);
                        this.A();
                    }

                    v0_3 = new Intent();
                    v1_1 = "NOTIFICATION_CANCEL_SELECT_USER_LOADING";
                    v0_3.setAction(v1_1);
                    this.getApplicationContext().sendBroadcast(v0_3);
                }
                else {
                    if(v0_1 != deviceCommandEnum.delete_user) {
                        goto label_93;
                    }

                    j.a("==timeout==", "==delete user 超时==");
                    if(this.J()) {
                        app.b(0x7F0B004F, v0_1.ordinal());  // string:STR_FAILED_TO_DELETE_USER "FAILED TO DELETE USER OF CONSOLE"
                        goto label_258;
                    label_93:
                        if(v0_1 == deviceCommandEnum.start_workout) {
                            j.a("==timeout==", "==start workout 超时==");
                            if(this.J()) {
                                app.b(0x7F0B0056, v0_1.ordinal());  // string:STR_FAILED_TO_START_WORKOUT "FAILED TO START WORKOUT"
                            }

                            v0_3 = new Intent();
                            v1_1 = "NOTIFICATION_DID_START_WORKOUT_TIMEOUT";
                            v0_3.setAction(v1_1);
                            this.getApplicationContext().sendBroadcast(v0_3);
                            goto label_258;
                        }

                        if(v0_1 == deviceCommandEnum.stop_workout) {
                            j.a("==timeout==", "==stop workout 超时==");
                            if(this.J()) {
                                app.b(0x7F0B0057, v0_1.ordinal());  // string:STR_FAILED_TO_STOP_WORKOUT "FAILED TO STOP WORKOUT"
                            }

                            v0_3 = new Intent();
                            v1_1 = "NOTIFICATION_DID_STOPWORKOUT_TIME_OUT";
                            v0_3.setAction(v1_1);
                            this.getApplicationContext().sendBroadcast(v0_3);
                            goto label_258;
                        }

                        if(v0_1 != deviceCommandEnum.pause_workout) {
                            goto label_133;
                        }

                        j.a("==timeout==", "==pause workout 超时==");
                        if(this.J()) {
                            app.b(0x7F0B0051, v0_1.ordinal());  // string:STR_FAILED_TO_PAUSE_WORKOUT "FAILED TO PAUSE WORKOUT"
                            goto label_258;
                        label_133:
                            if(v0_1 != deviceCommandEnum.continue_workout) {
                                goto label_145;
                            }

                            j.a("==timeout==", "==continue workout 超时==");
                            if(this.J()) {
                                app.b(0x7F0B004E, v0_1.ordinal());  // string:STR_FAILED_TO_CONTINUE_WORKOUT "FAILED TO CONTINUE WORKOUT"
                                goto label_258;
                            label_145:
                                if(v0_1 == deviceCommandEnum.change_workout) {
                                    j.a("==timeout==", "==change workout 超时==");
                                    v0_3 = new Intent();
                                    v1_1 = "NOTIFICATION_DID_CHANGEWORKOUT_TIME_OUT";
                                    v0_3.setAction(v1_1);
                                    this.getApplicationContext().sendBroadcast(v0_3);
                                    goto label_258;
                                }

                                if(v0_1 == deviceCommandEnum.select_program) {
                                    j.a("==timeout==", "==select program 超时==");
                                    if((this.J()) && ((app.al) || (app.aj))) {
                                        app.b(0x7F0B0054, v0_1.ordinal());  // string:STR_FAILED_TO_SELECT_PROGRAM "FAILED TO SELECT PROGRAM"
                                    }
                                }
                                else if(v0_1 == deviceCommandEnum.set_5k) {
                                    j.a("==timeout==", "==set5k 超时==");
                                    if(this.J()) {
                                        app.b(0x7F0B0052, v0_1.ordinal());  // string:STR_FAILED_TO_RESET_MY_FIRST_5K "FAILED TO RESET MY FIRST 5K PROGRAM"
                                    }
                                }
                                else if(v0_1 == deviceCommandEnum.set_custom_program) {
                                    j.a("==timeout==", "==set custom program 超时==");
                                    if(this.J()) {
                                        app.b(0x7F0B0059, v0_1.ordinal());  // string:STR_FAILED_TO_UPDATE_CUSTOM_PROGRAM "FAILED TO UPDATE CUSTOM PROGRAM OF CONSOLE"
                                    }
                                }
                                else if(v0_1 == deviceCommandEnum.set_custom_hrp) {
                                    j.a("==timeout==", "==set custom heart rate program 超时==");
                                    if(this.J()) {
                                        app.b(0x7F0B0058, v0_1.ordinal());  // string:STR_FAILED_TO_UPDATE_CUSTOM_HR_PROGRAM "FAILED TO UPDATE CUSTOM HR PROGRAM OF CONSOLE"
                                    }
                                }
                                else if(v0_1 == deviceCommandEnum.set_incline) {
                                    j.a("==timeout==", "==set incline 超时==");
                                }
                                else if(v0_1 == deviceCommandEnum.set_speed) {
                                    j.a("==timeout==", "==set speed 超时==");
                                }
                                else if(v0_1 == deviceCommandEnum.set_resistance) {
                                    j.a("==timeout==", "==set resistance 超时==");
                                }
                                else if(v0_1 == deviceCommandEnum.get_machine_info) {
                                    j.a("==timeout==", "==get machine info 超时 : " + this.J() + "==");
                                    Message v1_2 = new Message();
                                    app.e.sendMessage(v1_2);
                                    app.d(0x7F0B0050);  // string:STR_FAILED_TO_GET_MACHINE_INFORMATIONS "FAILED TO GET MACHINE INFORMATION"
                                }
                                else if(v0_1 == deviceCommandEnum.not_initialized) {
                                    j.a("==timeout==", "==not initialized 超时==");
                                }
                            }
                        }
                    }
                }

            label_258:
                j.a("==receiveData==", "timeout");
                v0_4 = new Intent();
                v0_4.setAction("NOTIFICATION_DID_TIME_OUT");
                this.getApplicationContext().sendBroadcast(v0_4);
                return;
            }
            case keyPress: {
                int v0_5 = receiveData.h();
                j.a("==receiveData==", "keyPress " + v0_5);
                Intent v1_3 = new Intent();
                v1_3.setAction("NOTIFICATION_DID_PRESS_KEY");
                v1_3.putExtra("keyValue", v0_5);
                this.getApplicationContext().sendBroadcast(v1_3);
                return;
            }
            case userInfo: {
                UserSync v0_6 = receiveData.getUserSync();
                j.a("==receiveData==", "userInfo : " + v0_6.toString());
                if(v0_6 == null) {
                    return;
                }

                int v1_4 = v0_6.getUserSlot();
                int v2_1 = v0_6.getMyFirst5kWeek();
                int v4 = v0_6.getMyFirst5kWorkout();
                int v5 = v0_6.getMyFirst5kWalkSpeed();
                int v6 = v0_6.getMyFirst5kJogSpeed();
                int v7 = v0_6.getMyFirst5kResetCounter();
                int v8 = v0_6.getCustomProgramCRC();
                int v0_7 = v0_6.getCustomHeartrateCRC();
                j.a("===userInfo===", "=== userId:" + v1_4 + " | myFirst5kWeek:" + v2_1 + " | myFirst5kWorkout:" + v4 + " | myFirst5kWalkSpeed:" + v5 + " | myFirst5kJogSpeed:" + v6 + " | myFirst5kResetCount:" + v7 + " | customProgramCRC:" + v8 + " | customHRProgramCRC:" + v0_7);
                AppsRunner.get(this.getApplicationContext()).h(this.getApplicationContext(), v2_1, v1_4);
                AppsRunner.get(this.getApplicationContext()).i(this.getApplicationContext(), v4, v1_4);
                AppsRunner.get(this.getApplicationContext()).j(this.getApplicationContext(), v5, v1_4);
                AppsRunner.get(this.getApplicationContext()).k(this.getApplicationContext(), v6, v1_4);
                AppsRunner.get(this.getApplicationContext()).l(this.getApplicationContext(), v7, v1_4);
                AppsRunner.get(this.getApplicationContext()).m(this.getApplicationContext(), v8, v1_4);
                AppsRunner.get(this.getApplicationContext()).n(this.getApplicationContext(), v0_7, v1_4);
                v0_4 = new Intent();
                v0_4.setAction("NOTIFICATION_DID_GET_USER");
                v0_4.putExtra("Extra_Key_UserId", v1_4);
                this.getApplicationContext().sendBroadcast(v0_4);
                return;
            }
            case workoutSummary: {
                WorkoutSummary workoutSummary = receiveData.getWorkoutSummary();
                j.a("==receiveData==", "workoutSummary : " + workoutSummary.toString() + "  |  summaryId:" + workoutSummary.getUserId());
                int userId = workoutSummary.getUserId();
                if(userId > 0 && userId <= 5) {
                    Intent v3_1 = new Intent();
                    v3_1.setAction("NOTIFICATION_DID_GET_WORKOUT_SUMMARY");
                    v3_1.putExtra("workoutSummary", workoutSummary);
                    this.getApplicationContext().sendBroadcast(v3_1);
                    UserArticle userArticle = (UserArticle)apps.database.d.a().b(app.ctx).get(userId);
                    String v4_1 = app.a(userArticle.getNickname());
                    int v5_1 = apps.c.d.a(this.getApplicationContext(), "string", v4_1);
                    if(v5_1 != 0) {
                        v4_1 = this.getResources().getString(v5_1);
                    }

                    String name = app.a(v4_1);
                    String v3_3 = apps.c.d.b(userArticle.getUserid()).replaceAll("User", "");
                    String prefsMMFTokenId = ShareFitness.get(app.ctx).getPrefsMapMyFitnessTokenKey(v3_3);
                    String prefsMFPTokenId = ShareFitness.get(app.ctx).getPrefsMFPTokenId(v3_3);
                    String prefsFitbitTokenId = ShareFitness.get(app.ctx).getPrefsFitbitTokenId(v3_3);
                    String prefsMFP_UserId = ShareFitness.get(app.ctx).getPrefsMFP_UserId(v3_3);
                    String prefsFitbitUserId = ShareFitness.get(app.ctx).getPrefsFitbitUserId(v3_3);
                    String userName = workoutSummary.getUserName();
                    String MMFTokenId = workoutSummary.getMMFTokenId();
                    String MFPTokenId = workoutSummary.getMFPTokenId();
                    String fitbitToken = workoutSummary.getFitbitToken();
                    String MFP_UserId = workoutSummary.getMFP_UserId();
                    String v14 = "";
                    String v20 = app.a(userName);
                    String userId = v3_3;
                    int v3_4 = apps.c.d.a(this.getApplicationContext(), "string", name);
                    String prefsName = app.a(v3_4 == 0 ? v20 : this.getResources().getString(v3_4));
                    if(apps.c.d.strNotEmpty(prefsMMFTokenId)) {
                        prefsMMFTokenId = "0000000000000000000000000000000000000000";
                    }

                    if(apps.c.d.strNotEmpty(prefsMFPTokenId)) {
                        prefsMFPTokenId = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
                    }

                    if(apps.c.d.strNotEmpty(prefsFitbitTokenId)) {
                        prefsFitbitTokenId = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
                    }

                    if(apps.c.d.strNotEmpty(prefsMFP_UserId)) {
                        prefsMFP_UserId = "000000000000000";
                    }

                    if(apps.c.d.strNotEmpty(prefsFitbitUserId)) {
                        prefsFitbitUserId = "000000";
                    }

                    if((apps.c.d.strNotEmpty(MMFTokenId)) || (apps.c.d.a(MMFTokenId, "\u0000"))) {
                        MMFTokenId = "0000000000000000000000000000000000000000";
                    }

                    if((apps.c.d.strNotEmpty(MFPTokenId)) || (apps.c.d.a(MFPTokenId, "\u0000"))) {
                        MFPTokenId = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
                    }

                    if((apps.c.d.strNotEmpty(fitbitToken)) || (apps.c.d.a(fitbitToken, "\u0000"))) {
                        fitbitToken = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
                    }

                    if((apps.c.d.strNotEmpty(MFP_UserId)) || (apps.c.d.a(MFP_UserId, "\u0000"))) {
                        MFP_UserId = "000000000000000";
                    }

                    if((apps.c.d.strNotEmpty("")) || (apps.c.d.a("", "\u0000"))) {
                        v14 = "000000";
                    }

                    if(apps.c.d.strNotEmpty(MFPTokenId)) {
                        MFPTokenId = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
                    }

                    if(apps.c.d.strNotEmpty(fitbitToken)) {
                        fitbitToken = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
                    }

                    String _prefsFitbitUserId = prefsFitbitUserId;
                    j.a("===WorkSummary===", userId + " |");
                    j.a("=====", "===收到WorkoutSummary，将开始分享===");  // Receive WorkoutSummary, will start sharing
                    List workoutInfoList = workoutSummary.getWorkoutInfoList();
                    j.a("====", "Summary " + userId + " " + workoutInfoList.size() == 0 ? "没有离线数据" : "有离线数据");  // "No offline data" : "There is offline data"
                    j.a("===", "==这里开始比较location,name,ua==");  // Here starts to compare location, name, ua
                    if((apps.c.d.a(prefsName, name)) && (apps.c.d.a(prefsMMFTokenId, MMFTokenId)) && (apps.c.d.a(prefsMFPTokenId, MFPTokenId)) && (apps.c.d.a(MFP_UserId, prefsMFP_UserId)) && (apps.c.d.a(prefsFitbitTokenId, fitbitToken))) {
                        __prefsFitbitUserId = _prefsFitbitUserId;
                        result = apps.c.d.a(v14, __prefsFitbitUserId) ? 1 : 0;
                    }
                    else {
                        __prefsFitbitUserId = _prefsFitbitUserId;
                        result = 0;
                    }

                    int userInfoCount = userId;
                    List _workoutInfoList = workoutInfoList;
                    j.a("===", "==比较后 : name : " + prefsName + " = " + name + "  token1 : " + prefsMMFTokenId + " = " + MMFTokenId + "  token2 : " + prefsMFPTokenId + " = " + MFPTokenId + "   " + prefsMFP_UserId + " = " + MFP_UserId + "    " + fitbitToken + "  =  " + prefsFitbitTokenId + "   " + v14 + "   =   " + __prefsFitbitUserId + "   ___ 结果：" + ((boolean)result));
                    int i = 0;
                    while(i < _workoutInfoList.size()) {
                        WorkoutListMember workListMember = (WorkoutListMember)_workoutInfoList.get(i);
                        int startYear = workListMember.getStartYear();
                        int startMonth = workListMember.getStartMonth();
                        int startDay = workListMember.getStartDay();
                        int startHour = workListMember.getStartHour();
                        int startMinute = workListMember.getStartMinute();
                        int startSecond = workListMember.getStartSecond();
                        int time = workListMember.getTime();
                        float distance = ((float)workListMember.getDistance()) / 1000.0f;
                        int _result = result;
                        float averageSpeed = ((float)workListMember.getAverageSpeed()) / 10.0f;
                        String ___prefsFitbitUserId = __prefsFitbitUserId;
                        int averageHR = workListMember.getAverageHR();
                        String _fitbitToken = fitbitToken;
                        int calories = workListMember.getCalories();
                        String _prefsMFP_UserId = prefsMFP_UserId;
                        float _maxSpeed = ((float)workListMember.getMaxSpeed()) / 1000.0f;
                        String _MFPTokenId = MFPTokenId;
                        int maxHR = workListMember.getMaxHR();
                        int units = workListMember.getUnits();
                        String v28 = MMFTokenId;
                        if(units == 1) {
                            units = units;
                            maxHR = maxHR;
                            j.a("==averageSpeed Metric==", averageSpeed + " |");
                            maxSpeed = _maxSpeed;
                            averageSpeed = (float)(Conversions.a(averageSpeed) * 1.0);
                            j.a("==averageSpeed Metric to US==", averageSpeed + " |");
                        }
                        else {
                            units = units;
                            maxSpeed = _maxSpeed;
                            maxHR = maxHR;
                        }

                        int pace = averageSpeed == 0.0f ? 0 : ((int)(60.0f / averageSpeed * 100.0f));
                        Date date = f.stringToDate(startYear + "-" + (startMonth + 1) + "-" + startDay + " " + startHour + ":" + startMinute + ":" + startSecond, "yyyy-M-d H:m:s");
                        if(date == null) {
                            date = f.stringToDate("2000-01-01", "yyyy-MM-dd");
                        }

                        String date = f.a(date, "yyyy-MM-dd HH:mm:ss");
                        int pace = pace;
                        int v33 = i;
                        int maxHR = maxHR;
                        j.a("== Summary " + i + " ==", "startYear:" + startYear + " startMonth:" + startMonth + " startDay:" + startDay + " startHour:" + startHour + " startMinute:" + startMinute + " startSecond:" + startSecond + " time:" + time + " distance:" + distance + " averageSpeed:" + averageSpeed + " averageHR:" + averageHR + " calories:" + calories + " maxSpeed:" + maxSpeed + " maxHR:" + maxHR + " date:" + date);
                        HashMap v4_4 = new HashMap();
                        v4_4.put("startDate", f.stringToDate(date, "yyyy-MM-dd HH:mm:ss"));
                        v4_4.put("totalTime", Integer.valueOf(time));
                        v4_4.put("elapsedTime", Integer.valueOf(time));
                        v4_4.put("totalDistance", Float.valueOf(((float)(apps.c.d.a(distance + "", 0.0) * 1.0))));
                        v4_4.put("averageSpeed", Float.valueOf(((float)(apps.c.d.a(averageSpeed + "", 0.0) * 1.0))));
                        v4_4.put("averageHR", apps.c.d.a(averageHR + "", 0));
                        v4_4.put("calories", apps.c.d.a(calories + "", 0));
                        v4_4.put("maxSpeed", Float.valueOf(((float)(apps.c.d.a(maxSpeed + "", 0.0) * 1.0))));
                        v4_4.put("maxSpeedKPH", Float.valueOf(((float)(apps.c.d.a(Conversions.b(maxSpeed) + "", 0.0) * 1.0))));
                        v4_4.put("maxHR", apps.c.d.a(maxHR + "", 0));
                        AppsApplication app = this;
                        boolean v4_5 = AppsRunner.get(app.ctx).inclineSupportsHalfDegree(app.ctx);
                        SummaryArticle summaryArticle = new SummaryArticle();
                        Date date = date;
                        summaryArticle.setSummaryDate(f.a(date, "yyyy-MM-dd HH:mm:ss"));
                        MMFTokenId = v28;
                        summaryArticle.setMmfToken(MMFTokenId);
                        String __MFPTokenId = _MFPTokenId;
                        summaryArticle.setMfpToken(__MFPTokenId);
                        String __MFP_UserID = _prefsMFP_UserId;
                        summaryArticle.setMfpUserId(__MFP_UserID);
                        String __fitbitToken = _fitbitToken;
                        summaryArticle.setFitbitToken(__fitbitToken);
                        summaryArticle.setFitbitUserId(___prefsFitbitUserId);
                        summaryArticle.setCalories(apps.c.d.a(calories + "", 0).intValue());
                        summaryArticle.setElapsedTime(time);
                        summaryArticle.setTotalTime(time);
                        summaryArticle.setTotalDistance(apps.c.d.a(distance + "", 0.0f));
                        summaryArticle.setAverageSpeed(apps.c.d.a(averageSpeed + "", 0.0f));
                        summaryArticle.setAverageHR(averageHR);
                        summaryArticle.setIsEp(((int)v4_5));
                        summaryArticle.setUnits(units);
                        summaryArticle.setUserid(userId + "");
                        summaryArticle.setUnits(0);
                        c.a().a(app, userId + "", summaryArticle);
                        if(_result == 0) {
                            v27_1 = __MFPTokenId;
                            userId = userInfoCount;
                        }
                        else {
                            j.a("===", "==这里保存到本地==");  // Save to local here
                            AppsArticle appsArticle = new AppsArticle();
                            appsArticle.setDate(date);
                            userId = userInfoCount;
                            appsArticle.setUserid(userId + "");
                            appsArticle.setElapsedTime(time + "");
                            appsArticle.setTotalTime(time + "");
                            appsArticle.setCalories(calories + "");
                            appsArticle.setSummarypace(pace + "");
                            appsArticle.setSpeed(averageSpeed + "");
                            v27_1 = __MFPTokenId;
                            appsArticle.setSpeedkph(Conversions.b(averageSpeed) + "");
                            appsArticle.setMiles(distance + "");
                            appsArticle.setKm(Conversions.mi_to_km(distance) + "");
                            appsArticle.setDistance(distance + "");
                            appsArticle.setAverageSpeed(averageSpeed + "");
                            appsArticle.setHeartRate(averageHR + "");
                            appsArticle.setAverageHeartRate(averageHR + "");
                            appsArticle.setCalhr(calories + "");
                            appsArticle.setResistance("0");
                            appsArticle.setIncline("0");
                            appsArticle.setPace("0");
                            appsArticle.setAveragePace("0");
                            appsArticle.setMaxHeartRate(maxHR + "");
                            appsArticle.setMinmiles("0");
                            j.a("===", "==将要保存0" + appsArticle);  // About to save 0
                            Message v0_11 = new Message();
                            v0_11.obj = appsArticle;
                            app.T.sendMessage(v0_11);
                            j.a("===", "==保存中===");
                        }

                        i = v33 + 1;
                        userInfoCount = userId;
                        prefsMFP_UserId = __MFP_UserID;
                        fitbitToken = __fitbitToken;
                        result = _result;
                        __prefsFitbitUserId = ___prefsFitbitUserId;
                        MFPTokenId = v27_1;
                    }

                    if(userInfoCount == 5) {
                        j.a("===", "===收到第5个user info，同步完成===");  // Receive the 5th user info, synchronization is complete
                        return;
                    }

                    return;
                }

                return;
            }
            case setCustomHRProgram: {
                CustomHRProgramReceive customHRProgram = receiveData.getCustomHRProgram();
                j.a("==receiveData==", "customHRProgramReceive : " + customHRProgram.toString());
                if(customHRProgram == null) {
                    return;
                }

                app.customHRProgram = customHRProgram;
                j.a("==userId : ==", app.customHRProgram.getUserId() + " |");
                j.a("==age : ==", app.customHRProgram.getSegments()[0].getAge() + " |");
                j.a("==totalTime : ==", app.customHRProgram.getTotalTime() + " |");
                Segment[] v2_5 = app.customHRProgram.getSegments();
                while(v13 < v2_5.length) {
                    Segment v3_10 = v2_5[v13];
                    int v4_7 = v3_10.getTargetHR();
                    int v3_11 = v3_10.getSegmentTime();
                    if(v13 == 0) {
                        j.a("hr1", v4_7 + " |");
                        v4_8 = "time1";
                        v5_5 = new StringBuilder();
                        goto label_1201;
                    }
                    else {
                        if(v13 == 1) {
                            j.a("hr2", v4_7 + " |");
                            v4_8 = "time2";
                        }
                        else {
                            if(v13 == 2) {
                                j.a("hr3", v4_7 + " |");
                                v4_8 = "time3";
                                v5_5 = new StringBuilder();
                                goto label_1201;
                            }

                            if(v13 != 3) {
                                goto label_1207;
                            }

                            j.a("hr4", v4_7 + " |");
                            v4_8 = "time4";
                        }

                        v5_5 = new StringBuilder();
                    label_1201:
                        v5_5.append(v3_11);
                        v5_5.append(" |");
                        j.a(v4_8, v5_5.toString());
                    }

                label_1207:
                    ++v13;
                }

                app.j(true);
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_DEVICE_SET_CUSTOM_HR_PROGRAM";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case setCustomProgram: {
                CustomProgram customProgram = receiveData.getCustomProgram();
                j.a("==receiveData==", "setCustomProgram : " + customProgram.toString());
                if(customProgram == null) {
                    return;
                }

                app.customProgram = customProgram;
                j.a("==userId : ==", app.customProgram.getUserId() + " |");
                j.a("==单位： : ==", app.customProgram.getUnit() + " |");
                j.a("==time段号 : ==", app.customProgram.getTimeSegmentNumber() + " |");
                j.a("==distance段号 : ==", app.customProgram.getDistanceSegmentNumber() + " |");
                j.a("==仪表setCustom过来1 : ==", app.customProgram.setCustom1() + " |");
                j.a("==仪表setCustom过来2 : ==", app.customProgram.setCustom2() + " |");
                app.i(true);
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_DEVICE_SET_CUSTOM_PROGRAM";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case setPopupInfo: {
                int v1_10 = receiveData.getPopupType();
                int v2_7 = receiveData.getDisappearTime();
                j.a("==receiveData==", "popupType : " + v1_10 + "   disappearTime : " + v2_7);
                Intent v3_12 = new Intent();
                v3_12.setAction("NOTIFICATION_DID_SET_POPUP_INFO");
                v3_12.putExtra("popupType", v1_10);
                v3_12.putExtra("disappearTime", v2_7);
                this.getApplicationContext().sendBroadcast(v3_12);
                Message v3_13 = new Message();
                v3_13.what = v1_10;
                v3_13.obj = new Integer(v2_7);
                app.v.sendMessage(v3_13);
                return;
            }
            case stopWorkout: {
                int responseCode = receiveData.getResponseCode();
                j.a("==receiveData==", "stopWorkout1 : responseCode : " + responseCode);
                if(responseCode == 0) {
                    app.a(true);
                    StopWorkoutInfo stopWorkoutInfo = receiveData.getStopWorkoutInfo();
                    app.c(true);
                    j.a("==receiveData==", "stopWorkoutInfo1  : " + stopWorkoutInfo);
                    AppsRunner.get(app.ctx).setCurrentStopWorkoutInfo(stopWorkoutInfo);
                    Message v2_8 = new Message();
                    v2_8.what = 444;
                    v2_8.obj = new Integer(0);
                    app.f.sendMessage(v2_8);
                    Intent v2_9 = new Intent();
                    v2_9.putExtra("StopWorkoutInfo", stopWorkoutInfo);
                    v2_9.setAction("NOTIFICATION_DID_STOP_WORKOUT");
                    this.getApplicationContext().sendBroadcast(v2_9);
                    v1_13 = new Intent();
                    goto label_1646;
                }

                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_STOP_WORKOUT_FAIL";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case response_getMachineInfo: {
                DeviceInfo machineInfo = receiveData.getMachineInfo();
                j.a("==receiveData==", "getMachineInfo : " + machineInfo.toString());
                this.q();
                if(machineInfo == null) {
                    return;
                }

                int machineType = machineInfo.getMachineType();
                int modelType = machineInfo.getModelType();
                if(modelType == 1) {
                    AppsRunner.get(app.ctx).g(app.ctx, 5);
                    AppsRunner.get(app.ctx).h(app.ctx, machineType);
                    v5_6 = "=====MyApplication 获取到型号:EP=====";  // Get the model
                }
                else if(modelType == 0) {
                    AppsRunner.get(app.ctx).g(app.ctx, 6);
                    AppsRunner.get(app.ctx).h(app.ctx, machineType);
                    v5_6 = "=====MyApplication 获取到型号:TM=====";
                }
                else {
                    AppsRunner.get(app.ctx).h(app.ctx, 0);
                    AppsRunner.get(app.ctx).h(app.ctx, 0);
                    v5_6 = "=====MyApplication 获取到型号但有异常:非EP非TM=====";  // The model is obtained but there is an exception: not EP, not TM
                }

                j.a(v5_6, machineType + " | " + modelType);
                if((modelType == 0 || modelType == 1) && machineType >= 50 && machineType <= 61) {
                    app.ai = true;
                    AppsRunnerConnector.get(app.ctx).b(app.ai);
                    AppsRunnerConnector.get(app.ctx).a(false);
                    v3_15 = new Intent();
                    v4_10 = "NOTIFICATION_MATCH_MACHINE";
                }
                else {
                    app.ai = false;
                    AppsRunnerConnector.get(app.ctx).b(app.ai);
                    AppsRunnerConnector.get(app.ctx).a(true);
                    v3_15 = new Intent();
                    v4_10 = "NOTIFICATION_UN_MATCH_MACHINE";
                }

                v3_15.setAction(v4_10);
                this.getApplicationContext().sendBroadcast(v3_15);
                j.a("AppsApplication", "获取到机型型号：" + machineInfo);  // Get the model number:
                int securitySwitch = machineInfo.getSecuritySwitch();
                AppsRunner.get(app.ctx).securitySwitch = securitySwitch;
                Message v4_11 = new Message();
                v4_11.what = 0xDE;
                v4_11.obj = new Integer(securitySwitch);
                app.f.sendMessage(v4_11);
                int runStatus = machineInfo.getRunStatus();
                j.a("====GET SOME STATE : ====", runStatus + " | " + securitySwitch + " | " + app.ac);
                j.a("====WORKOUT STATE : " + runStatus + "====", " ==== 要弹出提示STOP ==== " + app.ac);
                if(runStatus != 1 && runStatus != 2) {
                    j.a("===", "==设备为idle状态==");
                    app.ad = false;
                    AppsRunner.get(app.ctx).c(false);
                }
                else {
                    j.a("===", "==设备正在跑或暂停状态==");  // The device is running or suspended
                    app.ad = true;
                }

                j.a("==shouldResetWhenConnect==", app.ac + " | " + app.ai);
                if(app.ac) {
                    if(!app.ai) {
                        goto label_1560;
                    }

                    v1_14 = new Message();
                    v1_14.what = 444;
                    v3_17 = new Integer(runStatus);
                    goto label_1557;
                }
                else if(app.ai) {
                    v1_14 = new Message();
                    v1_14.what = 666;
                    v3_17 = new Integer(runStatus);
                label_1557:
                    v1_14.obj = v3_17;
                    app.f.sendMessage(v1_14);
                }

            label_1560:
                Message v1_15 = new Message();
                v1_15.what = 555;
                v1_15.obj = new Integer(runStatus);
                app.f.sendMessage(v1_15);
                app.h(false);
                if(!this.J()) {
                    j.a("=====", "==类型不正常，关闭同步的转圈==");  // The type is abnormal, turn off the synchronous rotation
                    Message v2_12 = new Message();
                    app.e.sendMessage(v2_12);
                    app.refreshToken(true);
                    app.n(false);
                    app.p(false);
                    return;
                }

                j.a("====", "===getMachineInfo成功，开始要同步用户===");  // getMachineInfo succeeded, start to synchronize users
                this.q();
                Intent v1_16 = new Intent();
                v1_16.setAction("NOTIFICATION_STARTING_SYN_USER_INFO");
                this.getApplicationContext().sendBroadcast(v1_16);
                Message v2_13 = new Message();
                app.d.sendMessageDelayed(v2_13, 0L);
                return;
            }
            case response_stopWorkout: {
                int responseCode = receiveData.getResponseCode();
                j.a("==receiveData==", "stopWorkout2 : responseCode : " + responseCode);
                if(responseCode == 0) {
                    app.a(true);
                    StopWorkoutInfo stopWorkoutInfo = receiveData.getStopWorkoutInfo();
                    app.c(false);
                    j.a("==receiveData==", "stopWorkoutInfoResponse2 : " + stopWorkoutInfo.toString());
                    AppsRunner.get(app.ctx).setCurrentStopWorkoutInfo(stopWorkoutInfo);
                    Message v2_14 = new Message();
                    v2_14.what = 444;
                    v2_14.obj = new Integer(0);
                    app.f.sendMessage(v2_14);
                    app.c(deviceCommandEnum.stop_workout.ordinal());
                    Intent v2_15 = new Intent();
                    v2_15.putExtra("StopWorkoutInfo", stopWorkoutInfo);
                    v2_15.setAction("NOTIFICATION_DID_STOP_WORKOUT");
                    this.getApplicationContext().sendBroadcast(v2_15);
                    v1_13 = new Intent();
                label_1646:
                    v1_13.setAction("NOTIFICATION_DID_STOP_WORKOUT_FINISH");
                    this.getApplicationContext().sendBroadcast(v1_13);
                    app.ad = false;
                    AppsRunner.get(app.ctx).c(false);
                    return;
                }

                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_STOP_WORKOUT_FAIL";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case response_changeWorkout: {
                j.a("==receiveData==", "changeWorkout : " + receiveData.getResponseCode());
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_CHANGE_WORKOUT";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case response_customProgram: {
                int v1_19 = receiveData.getResponseCode();
                if(v1_19 == 0) {
                    app.c(deviceCommandEnum.set_custom_program.ordinal());
                }

                j.a("==receiveData==", "customProgram : " + v1_19);
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_SET_CUSTOM";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case response_deleteUser: {
                int v1_20 = receiveData.getResponseCode();
                if(v1_20 == 0) {
                    app.c(deviceCommandEnum.delete_user.ordinal());
                }

                j.a("==receiveData==", "deleteUser : " + v1_20);
                v2_16 = new Intent();
                v2_16.setAction("NOTIFICATION_DID_SET_USER_DATA");
                v2_16.putExtra("responseCode", v1_20);
                this.getApplicationContext().sendBroadcast(v2_16);
                return;
            }
            case response_selectProgram: {
                int responseCode = receiveData.getResponseCode();
                if(responseCode == 0) {
                    app.c(deviceCommandEnum.select_program.ordinal());
                }

                j.a("==receiveData==", "selectProgram : " + responseCode);
                v2_16 = new Intent();
                v2_16.putExtra("responseCode", responseCode);
                v2_16.setAction("NOTIFICATION_DID_SELECT_PROGRAM");
                this.getApplicationContext().sendBroadcast(v2_16);
                return;
            }
            case response_setCustomHRProgram: {
                j.a("==receiveData==", "setCustomHRProgram : " + receiveData.getResponseCode());
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_SET_CUSTOM_HR";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case response_setIncline: {
                j.a("==receiveData==", "setIncline : " + receiveData.getResponseCode());
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_SET_INCLINE";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case setMyFirst5k: {
                int setMyFirst5k = receiveData.getResponseCode();
                if(setMyFirst5k == 0) {
                    app.c(deviceCommandEnum.set_5k.ordinal());
                }

                MyFirst5k myFirst5k = receiveData.getMyFirst5k();
                int device_week = myFirst5k.getWeek();
                int device_workout = myFirst5k.getWorkout();
                int device_resetCount = myFirst5k.getResetCount();
                int walkSpeed = myFirst5k.getWalkSpeed();
                int jogSpeed = myFirst5k.getJogSpeed();
                int currentUserId = AppsRunner.get(app.ctx).getPref_CurrentUserID(app.ctx);
                AppsRunner.get(app.ctx).setDeviceWeek(app.ctx, device_week, currentUserId);
                AppsRunner.get(app.ctx).setDeviceWorkout(app.ctx, device_workout, currentUserId);
                AppsRunner.get(app.ctx).setDeviceResetCount(app.ctx, device_resetCount, currentUserId);
                AppsRunner.get(app.ctx).setWalkSpeed(app.ctx, walkSpeed, currentUserId);
                AppsRunner.get(app.ctx).setJogSpeed(app.ctx, jogSpeed, currentUserId);
                j.a("==setMyFirst5k device_week==", device_week + " ");
                j.a("==setMyFirst5k device_workout==", device_workout + " ");
                j.a("==setMyFirst5k device_resetCount==", device_resetCount + " ");
                j.a("==setMyFirst5k walkSpeed==", walkSpeed + " ");
                j.a("==setMyFirst5k jogSpeed==", jogSpeed + " ");
                j.a("==receiveData==", "setMyFirst5K : " + setMyFirst5k);
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_SET_MY_FIRST_5K";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case response_setResistance: {
                j.a("==receiveData==", "setResistance : " + receiveData.getResponseCode());
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_SET_RESISTANCE";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case response_setSpeed: {
                j.a("==receiveData==", "setSpeed : " + receiveData.getResponseCode());
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_SET_SPEED";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case response_setUser: {
                int v1_23 = receiveData.getResponseCode();
                if(v1_23 == 0) {
                    app.c(deviceCommandEnum.set_user.ordinal());
                }

                j.a("==receiveData==", "setUser : " + v1_23);
                app.g(false);
                Intent v2_19 = new Intent();
                v2_19.setAction("NOTIFICATION_DID_SET_USER_DATA");
                v2_19.putExtra("responseCode", v1_23);
                this.getApplicationContext().sendBroadcast(v2_19);
                if(v1_23 == 0) {
                    if(!app.ap) {
                        this.z();
                        app.ap = false;
                        return;
                    }

                    j.a("===收到setUser ack1===", "==要关闭掉同步的loading==");
                    Message v2_20 = new Message();
                    app.e.sendMessage(v2_20);
                    app.refreshToken(true);
                    if((this.J()) && !app.ae) {
                        v1_24 = new Intent();
                        v2_21 = "NOTIFICATION_SYN_USER_INFO_FINISH";
                        goto label_1925;
                    }
                }
                else {
                    if(!app.ap) {
                        this.z();
                        app.ap = false;
                        return;
                    }

                    Message v2_22 = new Message();
                    app.e.sendMessage(v2_22);
                    app.refreshToken(true);
                    v1_24 = new Intent();
                    v2_21 = "NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER";
                label_1925:
                    v1_24.setAction(v2_21);
                    this.getApplicationContext().sendBroadcast(v1_24);
                }

                this.A();
                this.z();
                app.ap = false;
                return;
            }
            case response_selectUser: {
                int v1_25 = receiveData.getResponseCode();
                j.a("==receiveData==", "selectUser : " + v1_25);
                app.g(false);
                Intent v2_23 = new Intent();
                v2_23.setAction("NOTIFICATION_DID_SELECT_USER_DATA");
                v2_23.putExtra("responseCode", v1_25);
                this.getApplicationContext().sendBroadcast(v2_23);
                if(v1_25 == 0) {
                    if(!app.ap) {
                        goto label_1985;
                    }

                    j.a("===收到selectUser ack2===", "==要关闭掉同步的loading==");
                    Message v2_24 = new Message();
                    app.e.sendMessage(v2_24);
                    app.refreshToken(true);
                    if((this.J()) && !app.ae) {
                        v1_26 = new Intent();
                        v2_25 = "NOTIFICATION_SYN_USER_INFO_FINISH";
                        goto label_1981;
                    }
                }
                else {
                    if(!app.ap) {
                        goto label_1985;
                    }

                    Message v2_26 = new Message();
                    app.e.sendMessage(v2_26);
                    app.refreshToken(true);
                    v1_26 = new Intent();
                    v2_25 = "NOTIFICATION_SYN_USER_INFO_FINISH_BUT_FAILED_SELECT_OR_SET_USER";
                label_1981:
                    v1_26.setAction(v2_25);
                    this.getApplicationContext().sendBroadcast(v1_26);
                }

                this.A();
            label_1985:
                this.z();
                app.ap = false;
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_CANCEL_SELECT_USER_LOADING";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case response_startWorkout: {
                int v1_27 = receiveData.getResponseCode();
                j.a("==receiveData==", "startWorkout : " + v1_27);
                if(v1_27 == 0) {
                    app.a(false);
                    if(AppsRunner.get(app.ctx).securitySwitch == 1) {
                        v2_27 = "==收到start也不能响应==";
                        j.a("==安全锁拨开==", v2_27);
                        return;
                    }

                    Message v2_28 = new Message();
                    app.e.sendMessage(v2_28);
                    app.c(deviceCommandEnum.start_workout.ordinal());
                    if(!AppsRunner.get(app.ctx).g()) {
                        double v5_8 = Conversions.b(0.5);
                        AppsRunner.get(app.ctx).J = 0.5;
                        AppsRunner.get(app.ctx).K = v5_8;
                        AppsRunner.get(app.ctx).I = v11;
                        AppsRunner.get(app.ctx).H = v9;
                        AppsRunner.get(app.ctx).d.put(new Integer(AppsRunner.get(app.ctx).elapsedTime), Double.valueOf(AppsRunner.get(app.ctx).J));
                        AppsRunner.get(app.ctx).e.put(new Integer(AppsRunner.get(app.ctx).elapsedTime), Double.valueOf(AppsRunner.get(app.ctx).K));
                        AppsRunner.get(app.ctx).f.put(new Integer(AppsRunner.get(app.ctx).elapsedTime), Double.valueOf(AppsRunner.get(app.ctx).I));
                        AppsRunner.get(app.ctx).g.put(new Integer(AppsRunner.get(app.ctx).elapsedTime), Double.valueOf(AppsRunner.get(app.ctx).H));
                    }

                    Intent v1_28 = new Intent();
                    v1_28.setAction("NOTIFICATION_JUST_KNOW_WORKOUT");
                    this.getApplicationContext().sendBroadcast(v1_28);
                    Intent v1_29 = new Intent();
                    v1_29.setAction("NOTIFICATION_DID_START_WORKOUT");
                    this.getApplicationContext().sendBroadcast(v1_29);
                    Intent v1_30 = new Intent();
                    v1_30.setAction("NOTIFICATION_DID_APP_START_WORKOUT");
                    this.getApplicationContext().sendBroadcast(v1_30);
                    v1_31 = new Message();
                    v1_31.what = 333;
                    app.f.sendMessage(v1_31);
                    return;
                }

                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_START_WORKOUT_FAIL";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case device_workoutData: {
                WorkoutData v1_32 = receiveData.getWorkoutData();
                j.a("=====获取到WorkoutData数据： workOutData=====", v1_32 + " | ");
                AppsRunner.get(this.getApplicationContext()).setWorkoutData(v1_32);
                return;
            }
            case device_startWorkout: {
                int responseCode = receiveData.getResponseCode();
                j.a("==receiveData==", "收到跑步机的START命令1 : " + responseCode);  // Treadmill received the START command 1:
                if(responseCode == 0) {
                    app.a(false);
                    if(AppsRunner.get(app.ctx).securitySwitch == 1) {
                        v2_27 = "==收到start也不能响应2==";
                        j.a("==安全锁拨开==", v2_27);
                        return;
                    }

                    int v1_34 = AppsRunner.get(app.ctx).getPref_CurrentUserID(app.ctx);
                    AppsRunner.get(app.ctx).f(app.ctx, -10, v1_34);
                    AppsRunner.get(app.ctx).g(app.ctx, -10, v1_34);
                    Message v3_19 = new Message();
                    app.e.sendMessage(v3_19);
                    Workout v1_35 = receiveData.getWorkout();
                    j.a("==receiveData==", "收到跑步机的START命令2 : " + v1_35);
                    int v2_29 = v1_35.a();
                    j.a("==deviceStartWorkoutProgramType==", v2_29 + " |");
                    boolean v3_20 = AppsRunner.get(this).inclineSupportsHalfDegree(app);
                    com.xtremeprog.shell.treadmillv2.f v5_9 = new com.xtremeprog.shell.treadmillv2.f();
                    int v6_5 = v1_35.b();
                    if(v6_5 == 0) {
                        v6_5 = 5940;
                        v5_9.H = 1;
                    }
                    else {
                        v5_9.H = 0;
                    }

                    v5_9.a = v6_5;
                    float v6_6 = (float)AppsRunner.get(this).W();
                    float v7_6 = (float)AppsRunner.get(this).aa();
                    float v9_4 = (float)(v1_35.f() / 10);
                    float v10_2 = (float)(v1_35.g() / 10);
                    int v1_36 = (int)apps.c.d.a(Integer.valueOf(v1_35.h()), 1);
                    apps.database.d.a().e(app, AppsRunner.get(this).getPref_CurrentUserID(app));
                    if(v3_20) {
                        v3_21 = 100.0f;
                        v14_3 = 120.0f;
                        v15_2 = 5.0f;
                    }
                    else {
                        v3_21 = 15.0f;
                        v14_3 = 15.0f;
                        v15_2 = 0.5f;
                    }

                    v5_9.p = v3_21;
                    v5_9.q = v14_3;
                    v5_9.w = 0.0f;
                    v5_9.l = v10_2;
                    v5_9.E = v15_2;
                    v5_9.n = v6_6;
                    v5_9.o = v7_6;
                    v5_9.v = 0.5f;
                    v5_9.k = v9_4;
                    v5_9.D = 0.1f;
                    v5_9.m = (float)v1_36;
                    v5_9.r = 20.0f;
                    v5_9.s = 20.0f;
                    v5_9.x = 1.0f;
                    v5_9.b = AppsRunner.get(this).ad();
                    v5_9.e = AppsRunner.get(this).ag();
                    v5_9.d = AppsRunner.get(this).af();
                    AppsRunner.get(this).f(app, v2_29);
                    AppsRunner.get(this).a(v5_9);
                    Intent v1_37 = new Intent();
                    v1_37.setAction("NOTIFICATION_JUST_KNOW_WORKOUT");
                    this.getApplicationContext().sendBroadcast(v1_37);
                    Intent v1_38 = new Intent();
                    v1_38.setAction("NOTIFICATION_DID_START_WORKOUT");
                    this.getApplicationContext().sendBroadcast(v1_38);
                    v1_31 = new Message();
                    v1_31.what = 333;
                    app.f.sendMessage(v1_31);
                    return;
                }

                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_START_WORKOUT_FAIL";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case device_puaseWorkout: {
                int v1_39 = receiveData.getResponseCode();
                j.a("==receiveData==", "devicePauseWorkout : " + v1_39);
                if(v1_39 != 0) {
                    return;
                }

                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_DEVICE_PAUSE_WORKOUT";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case response_pauseWorkout: {
                int v1_40 = receiveData.getResponseCode();
                j.a("==receiveData==", "pauseWorkout : " + v1_40);
                if(v1_40 != 0) {
                    return;
                }

                app.c(deviceCommandEnum.pause_workout.ordinal());
                app.ad = true;
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_PAUSE_WORKOUT";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case continueWorkout: {
                int v1_41 = receiveData.getResponseCode();
                j.a("==receiveData==", "continueWorkout : " + v1_41);
                if(v1_41 != 1) {
                    return;
                }

                app.c(deviceCommandEnum.continue_workout.ordinal());
                app.ad = true;
                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_RESTART_WORKOUT";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case deviceContinueWorkout: {
                int v1_42 = receiveData.getResponseCode();
                j.a("==receiveData==", "deviceContinueWorkout : " + v1_42);
                if(v1_42 != 0) {
                    return;
                }

                v1_8 = new Intent();
                v2_6 = "NOTIFICATION_DID_RESTART_WORKOUT";
                v1_8.setAction(v2_6);
                this.getApplicationContext().sendBroadcast(v1_8);
                return;
            }
            case A: {
                if(receiveData.getPopupType() == 2) {
                    if(!this.J()) {
                        return;
                    }

                    app.showSafetyAlert(1, -1, true);
                    return;
                }

                if(this.J()) {
                    app.showSafetyAlert(0, -1, true);
                    return;
                }

                return;
            }
            case device_timeSync: {
                break;
            }
            default: {
                return;
            }
        }

        app.p(true);
        j.a("===", "===同步时间完成，发select program : " + this.J() + "  deviceIsRunningState : " + app.ae + "  isTimeSynced : " + app.az + "===");  // Synchronization time is complete, send select program
        if((this.J()) && (this.o())) {
            j.a("==", "符合发selectProgram的条件==");  // Meet the conditions for sending selectProgram
            j.a("==", "==不发selectProgram，换成发setUser或selectUser==");  // Do not send selectProgram, instead send setUser or selectUser
            app.ap = true;
            app.w.removeMessages(0x1B207);
            Message v1_43 = new Message();
            v1_43.what = 0x1B207;
            app.w.sendMessageDelayed(v1_43, 1000L);
            return;
        }

        j.a("==", "不符合发selectProgram的条件==");  // Does not meet the conditions for sending selectProgram
    }

    public void doRefreshMMFToken2(String arg4, int arg5) {
        if(!this.isConnectionCorrect()) {
            j.a("==doRefreshMMFToken2==", "==未同步完，先不刷新==");
            return;
        }

        if(this.P()) {
            ShareFitness.get(this.ctx).a(this.ctx, arg4 + "", arg5);
        }
    }

    public void setRefreshingMMFToken(String arg3, boolean arg4) {
        this.aY.put(arg3, Boolean.valueOf(((boolean)(((int)arg4)))));
        j.a("==setRefreshingMMFToken==", arg3 + " = " + ((boolean)(((int)arg4))));
    }

    public void MMFRefreshToken(Map arg25, int arg26) {
        AppsApplication v6 = this;
        Map v5 = arg25;
        int v3 = (int)(((Integer)v5.get("id")));
        Date v0 = (Date)v5.get("startDate");
        String v2 = (String)v5.get("userid");
        int v1 = (int)(((Integer)v5.get("units")));
        String v4 = (String)v5.get("mfpUserId");
        int v4_1 = (int)(((Integer)v5.get("isEp")));
        String v7 = (String)v5.get("mmfToken");
        int v8 = (int)(((Integer)v5.get("calories")));
        int v9 = (int)(((Integer)v5.get("elapsedTime")));
        int v10 = (int)(((Integer)v5.get("totalTime")));
        double v11 = (double)(((float)(((Float)v5.get("totalDistance")))));
        double v13 = (double)(((float)(((Float)v5.get("averageSpeed")))));
        Integer v15 = (Integer)v5.get("averageHR");
        Float v15_1 = (Float)v5.get("maxSpeed");
        Float v15_2 = (Float)v5.get("maxSpeedKPH");
        Integer v15_3 = (Integer)v5.get("averageHR");
        int v15_4 = (int)(((Integer)v5.get("averageHR")));
        int v17 = v3;
        if(!apps.c.d.d(this)) {
            v6.aM = false;
            return;
        }

        if(v9 > 0 && !apps.c.d.strNotEmpty(v7) && !apps.c.d.a(v7, "0000000000000000000000000000000000000000")) {
            if(v6.isRefreshingMMFTokeni(v2)) {
                j.a("====", "==分享中，但MMF正在refresh token，2秒后再分享==");  // Sharing, but MMF is refreshing token, share it after 2 seconds
                v6.aM = false;
                v6.aR.removeMessages(0x1B669);
                Message v0_1 = new Message();
                v0_1.arg1 = arg26;
                v0_1.obj = v5;
                v0_1.what = 0x1B669;
                v6.aR.sendMessageDelayed(v0_1, 2000L);
                return;
            }

            int v8_1 = Conversions.kilocalorie_to_joule(v6, v8);
            if(v1 == 0) {
                v11 = Conversions.mi_to_km(v11);
            }

            double v1_1 = v1 == 0 ? Conversions.b(v13) * 1000.0 : v13 * 1000.0 / 3600.0;
            j.a("===", "2_mmf avg_speed : " + v13 + "  " + v1_1);
            j.a("==开始分享==", "====" + v7 + "  |||  " + ShareFitness.get(this).p(v7));
            HashMap v3_1 = new HashMap();
            v3_1.put("startDate", v0);
            v3_1.put("totalTime", Integer.valueOf(v10));
            v3_1.put("elapsedTime", Integer.valueOf(v9));
            v3_1.put("totalDistance", Float.valueOf(((float)(v11 * 1000.0))));
            v3_1.put("averageSpeed", Float.valueOf(((float)(v1_1 * 1.0))));
            v3_1.put("averageHR", Integer.valueOf(v15_4));
            v3_1.put("calories", Integer.valueOf(v8_1));
            m.a(new apps.c.m.a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().a(AppsApplication.b(AppsApplication.this), "55xtz5n5kmdphxxsmbvgn68byrvnqbxj", "t8WV9adqUT6D47yvqd9gFu65MZUFcNKWtNwC9GCHJG6", v7, v4_1, v3_1);
                    if(!apps.c.d.strNotEmpty(v0)) {
                        AppsArticle v1 = AppsArticle.toAppsArticle(v0);
                        if(v1 != null) {
                            v1.setJson(v0);
                        }

                        j.a("==SMMF json ==", v0 + " |");
                        return v1;
                    }

                    return null;
                }
            }, new b() {
                @Override  // apps.c.m$b
                public void a(Object arg6) {
                    int v6_3;
                    if(arg6 == null) {
                        v6_3 = 0;
                    }
                    else {
                        try {
                            AppsArticle v6_1 = (AppsArticle)arg6;
                            String v2 = v6_1.getStart_datetime();
                            String v6_2 = v6_1.getJson();
                            if(apps.c.d.b(v6_2).indexOf("ACCESSTOKEN_EXPIRED") != -1 || apps.c.d.b(v6_2).indexOf("ACCESSTOKEN_NOT_FOUND") != -1) {
                                AppsApplication.this.doRefreshMMFToken2WithCallbackWithStep(v2, 1);
                                v6_3 = 0;
                            }
                            else if(apps.c.d.strNotEmpty(v2)) {
                                v6_3 = 0;
                            }
                            else {
                                v6_3 = 1;
                            }
                        }
                        catch(Exception v6) {
                            v6.printStackTrace();
                            v6_3 = 0;
                        }
                    }

                    if(v6_3 != 0) {
                        j.a("====", "SMMF SUCCESS TO SHARE");
                        c.a().d(AppsApplication.b(AppsApplication.this), v17);
                    }
                    else if(arg26 < 5) {
                        j.a("====", "SMMF RETRY TO SHARE");
                        AppsApplication.this.MMFRefreshToken(arg25, arg26 + 1);
                    }
                    else {
                        j.a("====", "SMMF FAILED TO SHARE");
                        c.a().a(AppsApplication.b(AppsApplication.this), v17);
                    }

                    AppsApplication.c(AppsApplication.this, false);
                }
            });
            return;
        }

        j.a("==mmfToken为空或其他==", "==暂不分享MMF===");  // mmfToken is empty or other, Do not share MMF temporarily
        c.a().a(v6.ctx, v17);
        v6.aM = false;
    }

    public void a(boolean arg1) {
        this.ar = arg1;
    }

    @Override  // com.xpg.b.interface_a
    public void handleConnection(boolean connectionResult, int type) {
        long v0 = 3000L;
        if(type == 2) {
            j.a("AppsApplication", "MIO蓝牙连接结果：" + ((boolean)(((int)connectionResult))) + " |");  // MIO Bluetooth connection result:
            if(!this.isConnectionCorrect()) {
                j.a("AppsApplication", "==刚好仪表!isConnectionCorrect的，所以不能连接MIO==");  // Just the meter! isConnectionCorrect, so you can't connect to MIO
                AppsRunnerConnector.get(this.ctx).maybe_onMIODisconnect();
                BLEManagerMIO.get(this.getApplicationContext()).a();
                return;
            }

            Intent v12 = new Intent();
            if(connectionResult) {
                v12.setAction("NOTIFICATION_STATE_MIO_DIDCONNECTSTATE");
                AppsRunnerConnector.get(this.getApplicationContext()).m = 2;
                AppsRunnerConnector.get(this.getApplicationContext()).A();
                AppsRunnerConnector.get(this.getApplicationContext()).rememberThisMIODevicey();
                AppsRunnerConnector.get(this.getApplicationContext()).setMIOIsConnected(true);
                AppsRunnerConnector.get(this.getApplicationContext()).rememberThisMIODevicey();
                Intent v11 = new Intent();
                v11.setAction("NOTIFICATION_MIO_DID_FIND_SERVICE");
                this.getApplicationContext().sendBroadcast(v11);
                Intent v11_1 = new Intent();
                v11_1.setAction("NOTIFICATION_MIO_DIDCONNECT");
                this.getApplicationContext().sendBroadcast(v11_1);
                this.u.removeMessages(0x56CE);
                j.a("==已连上MIO设备==", "==要停掉搜索MIO==");  // Connected to MIO device, stop searching for MIO
                BLEManagerMIO.get(this.getApplicationContext()).a();
                return;
            }

            AppsRunnerConnector.get(this.getApplicationContext()).m = 0;
            AppsRunnerConnector.get(this.getApplicationContext()).setMIOIsConnected(false);
            v12.setAction("NOTIFICATION_MIO_DISCONNECT");
            Intent v11_2 = new Intent();
            v11_2.setAction("NOTIFICATION_MIO_DID_NOT_FIND_SERVICE");
            this.getApplicationContext().sendBroadcast(v11_2);
            if(AppsRunnerConnector.get(this.getApplicationContext()).isConnected()) {
                j.a("==MIO断开==", "==发2次0心率值给仪表==");  // MIO disconnect, Send 0 heart rate value to the meter twice
                this.aE.removeMessages(0x1046A);
                this.aF.removeMessages(0x12FD1);
                Message v11_3 = new Message();
                v11_3.what = 0x1046A;
                this.aE.sendMessageDelayed(v11_3, 0L);
                Message v12_1 = new Message();
                v11_3.what = 0x12FD1;
                this.aF.sendMessageDelayed(v12_1, 2000L);
            }
            else {
                j.a("==MIO断开==", "==仪表没连上，不用发0心率==");  // MIO disconnected, the meter is not connected, no need to send 0 heart rate
            }

            if(this.l()) {
                j.a("===", "==MIODevice断开的，不用尝试重连==");  // MIODevice disconnected, don’t try to reconnect
            }
            else {
                j.a("===", "==MIO连接断开，尝试重连==");  // MIO disconnected, try to reconnect
                this.u.removeMessages(0x56CE);
                Message v11_4 = new Message();
                v11_4.what = 0x56CE;
                this.u.sendMessageDelayed(v11_4, v0);
            }

            this.m(false);
            return;
        }

        j.a("AppsApplication", "蓝牙连接结果：" + ((boolean)(((int)connectionResult))) + " |");  // Bluetooth connection result
        Intent v5 = new Intent();
        if(connectionResult) {
            if(AppsRunnerConnector.get(this.getApplicationContext()).getCurrentConnectingDevice() != null) {
                String name = AppsRunnerConnector.get(this.getApplicationContext()).getCurrentConnectingDevice().getDeviceName();
                String address = AppsRunnerConnector.get(this.getApplicationContext()).getCurrentConnectingDevice().getDeviceAddress();
                j.a("==连接上了名字为" + name + "的设备" + address, "==");  // The device named xxx is connected
                Map v12_3 = AppsRunnerConnector.get(this.ctx).mHashMap;
                String v8 = v12_3.get(address) == null ? "V2" : ((String)v12_3.get(address));
                boolean v12_4 = apps.c.d.a(v8, "V1");
                j.a("==flag==", v8 + " | " + ((boolean)(((int)v12_4))));
                if(v12_4) {
                    j.a("==连接上了一期的设备==", "==");  // Connected on one device
                    AppsRunner.get(this.ctx).h(this.ctx, 0);
                    AppsRunner.get(this.ctx).h(this.ctx, 0);
                    this.ai = false;
                    AppsRunnerConnector.get(this.ctx).b(this.ai);
                    AppsRunnerConnector.get(this.ctx).a(true);
                    Intent v11_5 = new Intent();
                    v11_5.setAction("NOTIFICATION_UN_MATCH_MACHINE");
                    this.getApplicationContext().sendBroadcast(v11_5);
                    return;
                }

                j.a("==连接的不是一期的设备==", "==");  // Not one of the devices connected
            }

            v5.setAction("NOTIFICATION_STATE_DIDCONNECTSTATE");
            AppsRunnerConnector.get(this.getApplicationContext()).l = 2;
            AppsRunnerConnector.get(this.getApplicationContext()).maybeDeviceConnected();
            AppsRunnerConnector.get(this.getApplicationContext()).rememberThisDevicew();
            AppsRunnerConnector.get(this.getApplicationContext()).setIsConnected(true);
            AppsRunnerConnector.get(this.getApplicationContext()).rememberThisDevicew();
            Intent v12_5 = new Intent();
            v12_5.setAction("NOTIFICATION_DID_FIND_SERVICE");
            this.getApplicationContext().sendBroadcast(v12_5);
            Intent v12_6 = new Intent();
            v12_6.setAction("NOTIFICATION_DIDCONNECT");
            this.getApplicationContext().sendBroadcast(v12_6);
            Intent v12_7 = new Intent();
            v12_7.setAction("NOTIFICATION_START_SYN_USER_INFO");
            this.getApplicationContext().sendBroadcast(v12_7);
            this.t.removeMessages(0x2B67);
            Message v2 = new Message();
            this.b.sendMessage(v2);
            j.a("==已连上Machine设备==", "==要停掉搜索Machine==");  // Connected to Machine equipment, To stop searching for Machine
            BLEManager.get(this.getApplicationContext()).stopScan();
        }
        else {
            j.a("断开连接", "断开类型：" + type);  // Disconnect, Disconnect type:
            AppsRunnerConnector.get(this.getApplicationContext()).l = 0;
            AppsRunnerConnector.get(this.getApplicationContext()).setIsConnected(false);
            v5.setAction("NOTIFICATION_DISCONNECT");
            Intent v12_8 = new Intent();
            v12_8.setAction("NOTIFICATION_DID_NOT_FIND_SERVICE");
            this.getApplicationContext().sendBroadcast(v12_8);
            this.aC.removeMessages(0x3640E);
            this.w.removeMessages(0x1B207);
            this.z();
            if(AppsRunnerConnector.get(this.getApplicationContext()).e()) {
                AppsRunnerConnector.get(this.ctx).maybe_onMIODisconnect();
            }
        }

        Message v12_9 = new Message();
        v12_9.obj = v5;
        this.a.sendMessage(v12_9);
        if(!connectionResult) {
            Message v12_10 = new Message();
            this.e.sendMessage(v12_10);
            this.n(false);
            this.refreshToken(false);
            this.p(false);
            if(this.k()) {
                j.a("===", "==Device断开的，不用尝试重连==");  // Device is disconnected, don’t try to reconnect
            }
            else {
                j.a("===", "==连接断开，尝试重连==");  // Disconnected, try to reconnect
                this.t.removeMessages(0x2B67);
                Message v11_6 = new Message();
                v11_6.what = 0x2B67;
                this.t.sendMessageDelayed(v11_6, v0);
            }

            this.l(false);
        }
    }

    public void a(boolean arg7, int arg8, int arg9) {
        if(arg7) {
            try {
                if(this.aG != null) {
                    this.aG.cancel();
                    this.aG = null;
                }

                if(this.aJ != null) {
                    this.aJ.cancel();
                    this.aJ = null;
                }

                this.aG = new Timer();
                this.aJ = new TimerTask() {
                    @Override
                    public void run() {
                        AppsApplication.this.K();
                    }
                };
                this.aG.scheduleAtFixedRate(this.aJ, ((long)arg8), ((long)arg9));
                return;
            label_24:
                if(this.aG != null) {
                    this.aG.cancel();
                    this.aG = null;
                }

                if(this.aJ != null) {
                    this.aJ.cancel();
                    this.aJ = null;
                    return;
                }
            }
            catch(Exception v7) {
                v7.printStackTrace();
            }

            return;
        }

        goto label_24;
    }

    public boolean a() {
        return this.ar;
    }

    static Context b(AppsApplication arg0) {
        return arg0.ctx;
    }

    static boolean b(AppsApplication arg0, boolean arg1) {
        arg0.ap = arg1;
        return arg1;
    }

    public String b(String arg4) {
        String v4 = apps.database.d.a().c(this.ctx, apps.c.d.a(arg4, 0).intValue());
        try {
            if((apps.c.d.a(v4, "USER 1")) || (apps.c.d.a(v4, "User 1"))) {
                v4 = "USER1";
            }
            else if((apps.c.d.a(v4, "USER 2")) || (apps.c.d.a(v4, "User 2"))) {
                v4 = "USER2";
            }
            else if((apps.c.d.a(v4, "USER 3")) || (apps.c.d.a(v4, "User 3"))) {
                v4 = "USER3";
            }
            else if((apps.c.d.a(v4, "USER 4")) || (apps.c.d.a(v4, "User 4"))) {
                v4 = "USER4";
            }
            else if((apps.c.d.a(v4, "USER 5")) || (apps.c.d.a(v4, "User 5"))) {
                v4 = "USER5";
            }
            else if((apps.c.d.a(v4, "USER 6")) || (apps.c.d.a(v4, "User 6"))) {
                v4 = "USER6";
            }
            else if(apps.c.d.a(v4, "Usuario 1")) {
                v4 = "Usuario1";
            }
            else if(apps.c.d.a(v4, "Usuario 2")) {
                v4 = "Usuario2";
            }
            else if(apps.c.d.a(v4, "Usuario 3")) {
                v4 = "Usuario3";
            }
            else if(apps.c.d.a(v4, "Usuario 4")) {
                v4 = "Usuario4";
            }
            else if(apps.c.d.a(v4, "Usuario 5")) {
                v4 = "Usuario5";
            }
            else if(apps.c.d.a(v4, "Usuario 6")) {
                v4 = "Usuario6";
            }
            else if(apps.c.d.a(v4, "Utilisateur 1")) {
                v4 = "Utilisateur1";
            }
            else if(apps.c.d.a(v4, "Utilisateur 2")) {
                v4 = "Utilisateur2";
            }
            else if(apps.c.d.a(v4, "Utilisateur 3")) {
                v4 = "Utilisateur3";
            }
            else if(apps.c.d.a(v4, "Utilisateur 4")) {
                v4 = "Utilisateur4";
            }
            else if(apps.c.d.a(v4, "Utilisateur 5")) {
                v4 = "Utilisateur5";
            }
            else if(apps.c.d.a(v4, "Utilisateur 6")) {
                v4 = "Utilisateur6";
            }

            int v0_1 = apps.c.d.a(this.getApplicationContext(), "string", v4);
            return this.getResources().getString(v0_1);
        }
        catch(Exception v0) {
            v0.printStackTrace();
            return v4;
        }
    }

    public void showStopAlert(int arg4) {
        j.a("==showStopAlert==", arg4 + " |");
        if(arg4 != 1 && arg4 != 2) {
            this.ae = false;
            if(this.k != null && (this.k.isShowing())) {
                try {
                    this.k.dismiss();
                }
                catch(Exception v0) {
                    v0.printStackTrace();
                }

                this.k = null;
                Intent v0_1 = new Intent();
                v0_1.setAction("NOTIFICATION_RECEIVE_WORKOUT_STATUS_FROM_DEVICE");
                v0_1.putExtra("Extra_Key_Workout_State", arg4);
                this.getApplicationContext().sendBroadcast(v0_1);
            }
        }
    }

    public void b(int arg4, int arg5) {
        Message msg = new Message();
        msg.what = arg5;
        msg.obj = new Integer(arg4);
        this.mCommandOrdinal = arg5;
        this.h.sendMessageDelayed(msg, 500L);
    }

    public void doRefreshToken(Context arg4) {
        if(!this.isConnectionCorrect()) {
            j.a("==doRefreshToken==", "==未同步完，先不刷新==");  // Not finished syncing, do not refresh first
            return;
        }

        int v4 = AppsRunner.get(this).getPref_CurrentUserID(arg4);
        if(this.P()) {
            this.doRefreshMMFToken2WithCallbackWithStep(v4 + "", 1);
        }

        if(this.Q()) {
            this.doRefreshMFPToken2WithCallbackWithStep(v4 + "", 1);
        }

        if(this.R()) {
            this.doRefreshFBToken2WithCallbackWithStep(v4 + "", 1);
        }
    }

    public void doRefreshMFPToken2(String arg4, int arg5) {
        if(!this.isConnectionCorrect()) {
            j.a("==doRefreshMFPToken2==", "==未同步完，先不刷新==");  // Not finished syncing, do not refresh first
            return;
        }

        if(this.Q()) {
            ShareFitness.get(this.ctx).b(this.ctx, arg4 + "", arg5);
        }
    }

    public void setRefreshingMFPTokenb(String arg3, boolean arg4) {
        this.aZ.put(arg3, Boolean.valueOf(((boolean)(((int)arg4)))));
        j.a("==setRefreshingMFPToken==", arg3 + " = " + ((boolean)(((int)arg4))));
    }

    public void shareMFP(Map arg21, int arg22) {
        AppsApplication v7 = this;
        Map v8 = arg21;
        int v9 = (int)(((Integer)v8.get("id")));
        Date v0 = (Date)v8.get("startDate");
        String v10 = (String)v8.get("userid");
        int v4 = (int)(((Integer)v8.get("units")));
        String v5 = (String)v8.get("mfpUserId");
        int v3 = (int)(((Integer)v8.get("isEp")));
        String v2 = (String)v8.get("mfpToken");
        int v1 = (int)(((Integer)v8.get("calories")));
        int v6 = (int)(((Integer)v8.get("elapsedTime")));
        int v11 = (int)(((Integer)v8.get("totalTime")));
        float v12 = (float)(((Float)v8.get("totalDistance")));
        float v13 = (float)(((Float)v8.get("averageSpeed")));
        int v14 = (int)(((Integer)v8.get("averageHR")));
        float v15 = (float)(((Float)v8.get("maxSpeed")));
        int v16 = v9;
        float v9_1 = (float)(((Float)v8.get("maxSpeedKPH")));
        String v17 = v5;
        int v5_1 = (int)(((Integer)v8.get("averageHR")));
        int v18 = v4;
        Integer v4_1 = (Integer)v8.get("averageHR");
        int v19 = v3;
        if(!apps.c.d.d(this)) {
            v7.aN = false;
            return;
        }

        if(v1 > 0 && v6 > 0 && !apps.c.d.strNotEmpty(v2) && !apps.c.d.a(v2, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
            if(v7.isRefreshingMFPTokenj(v10)) {
                j.a("====", "==分享中，但MFP正在refresh token，2秒后再分享==");  // Sharing, but MFP is refreshing token, share it after 2 seconds
                v7.aN = false;
                v7.aP.removeMessages(0x511B3);
                Message msg = new Message();
                msg.arg1 = arg22;
                msg.obj = v8;
                msg.what = 0x511B3;
                v7.aP.sendMessageDelayed(msg, 2000L);
                return;
            }

            j.a("==开始分享==", "====" + v2 + "  |||  " + ShareFitness.get(this).q(v2));  // Start sharing
            HashMap v6_1 = new HashMap();
            v6_1.put("startDate", v0);
            v6_1.put("totalTime", Integer.valueOf(v11));
            v6_1.put("elapsedTime", Integer.valueOf(v6 < 60 ? 60 : v6));
            v6_1.put("totalDistance", Float.valueOf(v12));
            v6_1.put("averageSpeed", Float.valueOf(v13));
            v6_1.put("averageHR", Integer.valueOf(v14));
            v6_1.put("calories", Integer.valueOf(v1));
            v6_1.put("maxSpeed", Float.valueOf(v15));
            v6_1.put("maxSpeedKPH", Float.valueOf(v9_1));
            v6_1.put("maxHR", Integer.valueOf(v5_1));
            m.a(new apps.c.m.a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().a(AppsApplication.b(AppsApplication.this), "afgfitness", "c7e6915ed48f7befbaa3", v2, v19, v18, v17, v6_1);
                    if(!apps.c.d.strNotEmpty(v0)) {
                        AppsArticle v1 = AppsArticle.toAppsArticle(v0);
                        if(v1 != null) {
                            v1.setJson(v0);
                        }

                        j.a("==SMFP json ==", v0 + " |");
                        return v1;
                    }

                    return null;
                }
            }, new b() {
                @Override  // apps.c.m$b
                public void a(Object arg5) {
                    int v5_2;
                    boolean v5_3;
                    if(arg5 == null) {
                        v5_2 = 0;
                    }
                    else {
                        try {
                            AppsArticle v5_1 = (AppsArticle)arg5;
                            String v2 = v5_1.getError();
                            if(apps.c.d.b(v5_1.getJson()).indexOf("Expired token") == -1) {
                                v5_3 = apps.c.d.strNotEmpty(v2);
                                goto label_24;
                            }
                            else {
                                AppsApplication.this.doRefreshMFPToken2WithCallbackWithStep(v10, 1);
                                v5_2 = 0;
                            }
                        }
                        catch(Exception v5) {
                            v5.printStackTrace();
                            v5_2 = 0;
                        }

                        goto label_30;
                    label_24:
                        v5_2 = v5_3 ? 1 : 0;
                    }

                label_30:
                    if(v5_2 != 0) {
                        j.a("====", "SMFP SUCCESS TO SHARE");
                        c.a().e(AppsApplication.b(AppsApplication.this), v16);
                    }
                    else if(arg22 < 5) {
                        j.a("====", "SMFP RETRY TO SHARE");
                        AppsApplication.this.shareMFP(arg21, arg22 + 1);
                    }
                    else {
                        j.a("====", "SMFP FAILED TO SHARE");
                        c.a().b(AppsApplication.b(AppsApplication.this), v16);
                    }

                    AppsApplication.d(AppsApplication.this, false);
                }
            });
            return;
        }

        j.a("==mfpToken为空或其他==", "==暂不分享MFP===");  // mfpToken is empty or other, Do not share MFP temporarily
        c.a().b(this.ctx, v16);
        this.aN = false;
    }

    public void b(boolean arg1) {
        this.am = arg1;
    }

    public void b(boolean arg7, int arg8, int arg9) {
        if(arg7) {
            try {
                if(this.aH != null) {
                    this.aH.cancel();
                    this.aH = null;
                }

                if(this.aK != null) {
                    this.aK.cancel();
                    this.aK = null;
                }

                this.aH = new Timer();
                this.aK = new TimerTask() {
                    @Override
                    public void run() {
                        AppsApplication.this.L();
                    }
                };
                this.aH.scheduleAtFixedRate(this.aK, ((long)arg8), ((long)arg9));
                return;
            label_24:
                if(this.aH != null) {
                    this.aH.cancel();
                    this.aH = null;
                }

                if(this.aK != null) {
                    this.aK.cancel();
                    this.aK = null;
                    return;
                }
            }
            catch(Exception v7) {
                v7.printStackTrace();
            }

            return;
        }

        goto label_24;
    }

    public boolean b() {
        return this.aj;
    }

    static boolean c(AppsApplication arg0) {
        return arg0.ap;
    }

    static boolean c(AppsApplication arg0, boolean arg1) {
        arg0.aM = arg1;
        return arg1;
    }

    public void c() {
        this.customProgram = null;
    }

    public void c(int command_ordinal) {
        if(command_ordinal == this.mCommandOrdinal && (this.o != null && (this.o.isShowing()))) {
            try {
                this.o.dismiss();
            }
            catch(Exception v2) {
                v2.printStackTrace();
                this.o = null;
                return;
            }

            this.o = null;
        }
    }

    public void retryCommand(int arg3, int command) {
        if(this.o != null && (this.o.isShowing())) {
            try {
                this.o.dismiss();
            }
            catch(Exception v0) {
                v0.printStackTrace();
                this.o = null;
                goto label_16;
            }

            this.o = null;
        }

    label_16:
        if(this.o == null) {
            try {
                apps.views.d.a v0_1 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                v0_1.b(0x7F0B0134);  // string:prompt "Warning"
                v0_1.a(arg3);
                v0_1.a(0x7F0B000E, new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_RETRY "RETRY"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        AppsApplication.this.o = null;
                        AppsApplication.this.resend(command);
                    }
                });
                v0_1.b(0x7F0B001D, new DialogInterface.OnClickListener() {  // string:STR_CANCEL "CANCEL"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        arg1.dismiss();
                        AppsApplication.this.o = null;
                    }
                });
                this.o = v0_1.a();
                this.o.setCancelable(false);
                this.o.setCanceledOnTouchOutside(false);
                this.o.show();
            }
            catch(Exception v3) {
                v3.printStackTrace();
            }

            return;
        }
    }

    public void c(String arg2) {
        Message v0 = new Message();
        v0.obj = arg2;
        this.aV.sendMessage(v0);
    }

    public void doRefreshFBToken2(String arg4, int arg5) {
        if(!this.isConnectionCorrect()) {
            j.a("==doRefreshFBToken2==", "==未同步完，先不刷新==");  // Not finished syncing, do not refresh first
            return;
        }

        if(this.R()) {
            ShareFitness.get(this.ctx).c(this.ctx, arg4 + "", arg5);
        }
    }

    public void setRefreshingFBTokenc(String arg3, boolean arg4) {
        this.ba.put(arg3, Boolean.valueOf(((boolean)(((int)arg4)))));
        j.a("==setRefreshingFBToken==", arg3 + " = " + ((boolean)(((int)arg4))));
    }

    public void shareFB(Map arg21, int arg22) {
        AppsApplication v7 = this;
        Map v8 = arg21;
        int v9 = (int)(((Integer)v8.get("id")));
        Date v0 = (Date)v8.get("startDate");
        String v10 = (String)v8.get("userid");
        int v4 = (int)(((Integer)v8.get("units")));
        String v5 = (String)v8.get("key2");
        int v3 = (int)(((Integer)v8.get("isEp")));
        String v2 = (String)v8.get("key1");
        int v1 = (int)(((Integer)v8.get("calories")));
        int v6 = (int)(((Integer)v8.get("elapsedTime")));
        int v11 = (int)(((Integer)v8.get("totalTime")));
        float v12 = (float)(((Float)v8.get("totalDistance")));
        float v13 = (float)(((Float)v8.get("averageSpeed")));
        int v14 = (int)(((Integer)v8.get("averageHR")));
        float v15 = (float)(((Float)v8.get("maxSpeed")));
        int v16 = v9;
        float v9_1 = (float)(((Float)v8.get("maxSpeedKPH")));
        String v17 = v5;
        int v5_1 = (int)(((Integer)v8.get("averageHR")));
        int v18 = v4;
        Integer v4_1 = (Integer)v8.get("averageHR");
        int v19 = v3;
        if(!apps.c.d.d(this)) {
            v7.aO = false;
            return;
        }

        if(v1 > 0 && v6 > 0 && !apps.c.d.strNotEmpty(v2) && !apps.c.d.a(v2, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
            if(v7.isRefreshingFBToken(v10)) {
                j.a("====", "==分享中，但FB正在refresh token，2秒后再分享==");  // Sharing, but FB is refreshing token, share it after 2 seconds
                v7.aO = false;
                v7.aQ.removeMessages(0x511B3);
                Message v0_1 = new Message();
                v0_1.arg1 = arg22;
                v0_1.obj = v8;
                v0_1.what = 0x511B3;
                v7.aQ.sendMessageDelayed(v0_1, 2000L);
                return;
            }

            j.a("==开始分享==", "====" + v2 + "  |||  " + ShareFitness.get(this).r(v2));
            HashMap v6_1 = new HashMap();
            v6_1.put("startDate", v0);
            v6_1.put("totalTime", Integer.valueOf(v11));
            v6_1.put("elapsedTime", Integer.valueOf(v6 < 60 ? 60 : v6));
            v6_1.put("totalDistance", Float.valueOf(v12));
            v6_1.put("averageSpeed", Float.valueOf(v13));
            v6_1.put("averageHR", Integer.valueOf(v14));
            v6_1.put("calories", Integer.valueOf(v1));
            v6_1.put("maxSpeed", Float.valueOf(v15));
            v6_1.put("maxSpeedKPH", Float.valueOf(v9_1));
            v6_1.put("maxHR", Integer.valueOf(v5_1));
            m.a(new apps.c.m.a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().b(AppsApplication.b(AppsApplication.this), "227WN7", "2a036801e9f03a1186a4204415354c90", v2, v19, v18, v17, v6_1);
                    if(!apps.c.d.strNotEmpty(v0)) {
                        AppsArticle v1 = AppsArticle.toAppsArticle(v0);
                        if(v1 != null) {
                            v1.setJson(v0);
                        }

                        j.a("==SMFP json ==", v0 + " |");
                        return v1;
                    }

                    return null;
                }
            }, new b() {
                @Override  // apps.c.m$b
                public void a(Object arg7) {
                    int v7_3;
                    if(arg7 == null) {
                        v7_3 = 0;
                    }
                    else {
                        try {
                            AppsArticle v7_1 = (AppsArticle)arg7;
                            String v2 = v7_1.getError();
                            String v7_2 = v7_1.getJson();
                            if(apps.c.d.b(v7_2).indexOf("Expired token") != -1 || apps.c.d.b(v7_2).indexOf("ACCESSTOKEN_EXPIRED") != -1 || apps.c.d.b(v7_2).indexOf("ACCESSTOKEN_NOT_FOUND") != -1) {
                                AppsApplication.this.doRefreshMFPToken2WithCallbackWithStep(v10, 1);
                                v7_3 = 0;
                            }
                            else if(apps.c.d.strNotEmpty(v2)) {
                                v7_3 = 1;
                            }
                            else {
                                v7_3 = 0;
                            }
                        }
                        catch(Exception v7) {
                            v7.printStackTrace();
                            v7_3 = 0;
                        }
                    }

                    if(v7_3 != 0) {
                        j.a("====", "SMFP SUCCESS TO SHARE");
                        c.a().e(AppsApplication.b(AppsApplication.this), v16);
                    }
                    else if(arg22 < 5) {
                        j.a("====", "SMFP RETRY TO SHARE");
                        AppsApplication.this.shareMFP(arg21, arg22 + 1);
                    }
                    else {
                        j.a("====", "SMFP FAILED TO SHARE");
                        c.a().b(AppsApplication.b(AppsApplication.this), v16);
                    }

                    AppsApplication.d(AppsApplication.this, false);
                }
            });
            return;
        }

        j.a("==fbToken为空或其他==", "==暂不分享FB===");  // fbToken is empty or other, not sharing FB
        c.a().c(this.ctx, v16);
        this.aO = false;
    }

    public void c(boolean arg1) {
        this.aq = arg1;
    }

    public void c(boolean arg7, int arg8, int arg9) {
        if(arg7) {
            try {
                if(this.aI != null) {
                    this.aI.cancel();
                    this.aI = null;
                }

                if(this.aL != null) {
                    this.aL.cancel();
                    this.aL = null;
                }

                this.aI = new Timer();
                this.aL = new TimerTask() {
                    @Override
                    public void run() {
                        AppsApplication.this.M();
                    }
                };
                this.aI.scheduleAtFixedRate(this.aL, ((long)arg8), ((long)arg9));
                return;
            label_24:
                if(this.aI != null) {
                    this.aI.cancel();
                    this.aI = null;
                }

                if(this.aL != null) {
                    this.aL.cancel();
                    this.aL = null;
                    return;
                }
            }
            catch(Exception v7) {
                v7.printStackTrace();
            }

            return;
        }

        goto label_24;
    }

    static boolean d(AppsApplication arg0) {
        return arg0.aM;
    }

    static boolean d(AppsApplication arg0, boolean arg1) {
        arg0.aN = arg1;
        return arg1;
    }

    public void d() {
        this.customHRProgram = null;
    }

    public void d(int arg4) {
        Message v0 = new Message();
        v0.obj = new Integer(arg4);
        this.i.sendMessageDelayed(v0, 500L);
    }

    public void d(int arg3, int arg4) {
        if(this.l != null && (this.l.isShowing())) {
            try {
                this.l.dismiss();
            }
            catch(Exception v0) {
                v0.printStackTrace();
                this.l = null;
                goto label_16;
            }

            this.l = null;
        }

    label_16:
        if(this.l == null) {
            try {
                apps.views.d.a v0_1 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                v0_1.b(0x7F0B0134);  // string:prompt "Warning"
                v0_1.a(arg3);
                v0_1.a(0x7F0B000D, new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_OK "OK"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg3, int arg4) {
                        try {
                            arg3.dismiss();
                        }
                        catch(Exception v3) {
                            v3.printStackTrace();
                        }

                        AppsApplication.this.l = null;
                        if(arg4 == 0xBDE31) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    j.a("====", "===get machine info超时，点击重新get machine info===");  // get machine info timed out, click to get machine info again
                                    AppsApplication.this.start_sync_user_info();
                                }
                            }, 500L);
                        }
                    }
                });
                this.l = v0_1.a();
                this.l.setCancelable(false);
                this.l.setCanceledOnTouchOutside(false);
                this.l.show();
            }
            catch(Exception v3) {
                v3.printStackTrace();
            }

            return;
        }
    }

    public void doMMFLogin(String arg4) {
        String v0;
        try {
            v0 = ShareFitness.get(this.ctx).getPrefsMapMyFitnessTokenKey(arg4);
            if(apps.c.d.strNotEmpty(v0)) {
                v0 = "0000000000000000000000000000000000000000";
            }
        }
        catch(Exception v4) {
            v4.printStackTrace();
            return;
        }

        if(this.q == null) {
            try {
                if(!apps.c.d.strNotEmpty(v0) && !apps.c.d.a(v0, "0000000000000000000000000000000000000000")) {
                    c.a().a(this.ctx, v0);
                }

                ShareFitness.get(this.ctx).n(arg4);
                String v4_2 = this.b(arg4);
                apps.views.d.a v0_1 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                v0_1.b(0x7F0B0134);  // string:prompt "Warning"
                v0_1.a("Your account for " + v4_2 + " has expired.Please log in again.");
                v0_1.a(0x7F0B000D, new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_OK "OK"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        Intent v1_1 = new Intent();
                        v1_1.setAction("NOTIFICATION_TO_MMF_LOGIN");
                        AppsApplication.this.getApplicationContext().sendBroadcast(v1_1);
                        AppsApplication.this.q = null;
                    }
                });
                v0_1.b(0x7F0B001D, new DialogInterface.OnClickListener() {  // string:STR_CANCEL "CANCEL"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        Intent v1_1 = new Intent();
                        v1_1.setAction("NOTIFICATION_TO_MMF_LOGIN_BUT_NOT_JUMP");
                        AppsApplication.this.getApplicationContext().sendBroadcast(v1_1);
                        AppsApplication.this.q = null;
                    }
                });
                this.q = v0_1.a();
                this.q.setCancelable(false);
                this.q.setCanceledOnTouchOutside(false);
                this.q.show();
                return;
            }
            catch(Exception v4_1) {
            }

            try {
                v4_1.printStackTrace();
                return;
            }
            catch(Exception v4) {
            }

            v4.printStackTrace();
            return;
        }
    }

    public void doRefreshMMFToken2WithCallbackWithStep(String arg7, int arg8) {
        int v1 = (int)apps.c.d.a(arg7, 0);
        if(!this.isConnectionCorrect()) {
            j.a("==doRefreshMMFToken2WithCallbackWithStep==", "==未同步完，先不刷新==");  // Not finished syncing, do not refresh first
            this.setRefreshingMMFToken(v1 + "", false);
            return;
        }

        j.a("==doRefreshMMFToken2WithCallbackWithStep==", this.isRefreshingMMFTokeni(v1 + "") + " | step : " + arg8);
        if(this.isRefreshingMMFTokeni(v1 + "")) {
            j.a("==正在刷新MMF token中==", "===");  // Refreshing MMF token
            return;
        }

        this.setRefreshingMMFToken(v1 + "", true);
        if(this.P()) {
            ShareFitness.get(this.ctx).a(this.ctx, v1 + "", new com.xtremeprog.shell.treadmillv2.AppsApplication.a() {
                @Override  // com.xtremeprog.shell.treadmillv2.AppsApplication$a
                public void a() {
                    AppsApplication.this.setRefreshingMMFToken(v1 + "", false);
                }

                @Override  // com.xtremeprog.shell.treadmillv2.AppsApplication$a
                public void b() {
                    if(arg8 < 5) {
                        AppsApplication.this.setRefreshingMMFToken(v1 + "", false);
                        AppsApplication.this.doRefreshMMFToken2WithCallbackWithStep(arg7, arg8 + 1);
                        return;
                    }

                    AppsApplication.this.setRefreshingMMFToken(v1 + "", false);
                    AppsApplication.this.c(arg7);
                }
            });
            return;
        }

        this.setRefreshingMMFToken(v1 + "", false);
    }

    public void d(boolean arg1) {
        this.aj = arg1;
    }

    public void d(boolean arg7, int arg8, int arg9) {
        if(arg7) {
            try {
                this.aU = 0;
                if(this.aS != null) {
                    this.aS.cancel();
                    this.aS = null;
                }

                if(this.aT != null) {
                    this.aT.cancel();
                    this.aT = null;
                }

                this.aS = new Timer();
                this.aT = new TimerTask() {
                    @Override
                    public void run() {
                        AppsApplication.this.O();
                    }
                };
                this.aS.scheduleAtFixedRate(this.aT, ((long)arg8), ((long)arg9));
                return;
            label_26:
                this.aU = 0;
                if(this.aS != null) {
                    this.aS.cancel();
                    this.aS = null;
                }

                if(this.aT != null) {
                    this.aT.cancel();
                    this.aT = null;
                    return;
                }
            }
            catch(Exception v7) {
                v7.printStackTrace();
            }

            return;
        }

        goto label_26;
    }

    static boolean e(AppsApplication arg0) {
        return arg0.aN;
    }

    static boolean e(AppsApplication arg0, boolean arg1) {
        arg0.aO = arg1;
        return arg1;
    }

    public void get_setcustomhrprogram() {
        StringBuilder v4_1;
        String v3_3;
        j.a("===", "==读取HRCONSOLE的参数 : " + this.customHRProgram + " ==");  // Read HRCONSOLE parameters
        CustomHRProgramReceive v0 = this.customHRProgram;
        if(v0 != null) {
            j.a("==userId : ==", this.customHRProgram.getUserId() + " |");
            int v4 = 0;
            j.a("==age : ==", v0.getSegments()[0].getAge() + " |");
            j.a("==totalTime : ==", this.customHRProgram.getTotalTime() + " |");
            int v1 = AppsRunner.get(this.ctx).getPref_CurrentUserID(this.ctx);
            int v2 = v0.getSegments()[0].getAge();
            int v0_1 = v0.getTotalTime();
            int v3 = AppsRunner.get(this.ctx).ad();
            if(v2 == 0) {
                v2 = v3;
            }

            int v5 = v3 - v2;
            j.a("==CONSOLE年龄改变了吗==", v5 + " = " + v3 + " - " + v2);  // Has the age of CONSOLE changed?
            if(v5 != 0) {
                String v3_1 = AppsRunner.get(this.ctx).ae();
                Date v6 = f.stringToDate(v3_1, "yyyy/MM/dd");
                if(v6 == null) {
                    v6 = f.stringToDate("2000-01-01", "yyyy-MM-dd");
                }

                String v7 = f.a(v6, "yyyy");
                String v6_1 = f.a(v6, "MM/dd");
                String v5_1 = ((int)apps.c.d.a(v7, 2000)) + v5 + "/" + v6_1;
                int v8 = v1 + 1;
                UserArticle v6_2 = apps.database.d.a().b(this.ctx, v8);
                v6_2.setBirthday(v5_1);
                j.a(v1 + "==console 修改user的birthday==" + v6_2.getId(), v5_1 + " |" + v3_1);  // console modify user's birthday
                apps.database.d.a().a(this.ctx, v6_2);
                j.a("==console newBirthday==", apps.database.d.a().b(this.ctx, v8).getBirthday() + " |||");
            }

            ContextSharedPreferences.SharedPreferencesEditor(this, v1 + "_age_hr", Integer.valueOf(v2), 1);
            ContextSharedPreferences.SharedPreferencesEditor(this, v1 + "_time_hr", Integer.valueOf(v0_1), 1);
            Segment[] v0_2 = this.customHRProgram.getSegments();
            while(v4 < v0_2.length) {
                Segment v2_1 = v0_2[v4];
                int v3_2 = v2_1.getTargetHR();
                int v2_2 = v2_1.getSegmentTime();
                int v8_1 = v4 + 1;
                ContextSharedPreferences.SharedPreferencesEditor(this, v1 + "_hr_hr_" + v8_1, Float.valueOf(((float)v3_2) * 1.0f), 3);
                ContextSharedPreferences.SharedPreferencesEditor(this, v1 + "_segmentLength_hr_" + v8_1, Float.valueOf(((float)v2_2) / 60.0f), 3);
                if(v4 == 0) {
                    j.a("hr1", v3_2 + " |");
                    v3_3 = "time1";
                    v4_1 = new StringBuilder();
                    goto label_235;
                }
                else {
                    if(v4 == 1) {
                        j.a("hr2", v3_2 + " |");
                        v3_3 = "time2";
                    }
                    else {
                        if(v4 == 2) {
                            j.a("hr3", v3_2 + " |");
                            v3_3 = "time3";
                            v4_1 = new StringBuilder();
                            goto label_235;
                        }

                        if(v4 != 3) {
                            goto label_241;
                        }

                        j.a("hr4", v3_2 + " |");
                        v3_3 = "time4";
                    }

                    v4_1 = new StringBuilder();
                label_235:
                    v4_1.append(v2_2);
                    v4_1.append(" |");
                    j.a(v3_3, v4_1.toString());
                }

            label_241:
                v4 = v8_1;
            }

            Intent v0_3 = new Intent();
            v0_3.setAction("NOTIFICATION_DID_GET_SETCUSTOMHRPROGRAM");
            this.getApplicationContext().sendBroadcast(v0_3);
        }
    }

    public void e(int arg3) {
        if(this.p != null && (this.p.isShowing())) {
            try {
                this.p.dismiss();
            }
            catch(Exception v0) {
                v0.printStackTrace();
                this.p = null;
                goto label_16;
            }

            this.p = null;
        }

    label_16:
        if(this.p == null) {
            try {
                apps.views.d.a v0_1 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                v0_1.b(0x7F0B0134);  // string:prompt "Warning"
                v0_1.a(arg3);
                v0_1.a(0x7F0B000E, new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_RETRY "RETRY"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        AppsApplication.this.p = null;
                        AppsApplication.this.resend(deviceCommandEnum.get_machine_info.ordinal());
                    }
                });
                v0_1.b(0x7F0B001D, new DialogInterface.OnClickListener() {  // string:STR_CANCEL "CANCEL"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        AppsApplication.this.p = null;
                        AppsRunnerConnector.get(AppsApplication.this.getApplicationContext()).maybe_onDisconnect();
                    }
                });
                this.p = v0_1.a();
                this.p.setCancelable(false);
                this.p.setCanceledOnTouchOutside(false);
                this.p.show();
            }
            catch(Exception v3) {
                v3.printStackTrace();
            }

            return;
        }
    }

    public void e(int arg4, int arg5) {
        this.s();
        if(this.m == null) {
            try {
                apps.views.d.a v0 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                v0.b(0x7F0B0134);  // string:prompt "Warning"
                v0.a(arg4);
                v0.a(0x7F0B000D, new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_OK "OK"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        AppsApplication.this.m = null;
                    }
                });
                this.m = v0.a();
                this.m.setCancelable(false);
                this.m.setCanceledOnTouchOutside(false);
                if(arg4 == 0x7F0B00AC) {  // string:STR_NO_HEART_RATE_DETECTED "No Heart Rate Detected"
                    v0.b(true);
                }

                this.m.show();
            }
            catch(Exception v4) {
                v4.printStackTrace();
            }

            if(arg5 != -1 && arg5 != 0xA5) {
                if(arg5 == 0) {
                    arg5 = 3;
                }

                new Handler().postDelayed(() -> if(AppsApplication.this.m != null && (AppsApplication.this.m.isShowing())) {
                    try {
                        AppsApplication.this.m.dismiss();
                    }
                    catch(Exception v0) {
                        v0.printStackTrace();
                        AppsApplication.this.m = null;
                        return;
                    }

                    AppsApplication.this.m = null;
                }, ((long)(arg5 * 1000)));
            }
        }

        class com.xtremeprog.shell.treadmillv2.AppsApplication.15 implements Runnable {
            @Override
            public void run() {
                AppsApplication.this.s();
            }
        }

    }

    public void e(String arg2) {
        Message v0 = new Message();
        v0.obj = arg2;
        this.aW.sendMessage(v0);
    }

    public void doRefreshMFPToken2WithCallbackWithStep(String arg7, int arg8) {
        int v1 = (int)apps.c.d.a(arg7, 0);
        if(!this.isConnectionCorrect()) {
            j.a("==MFPToken2WithCallBackWithStep==", "==未同步完，先不刷新==");  // Not finished syncing, do not refresh first
            this.setRefreshingMFPTokenb(v1 + "", false);
            return;
        }

        j.a("==doRefreshMFPToken2WithCallbackWithStep==", this.isRefreshingMFPTokenj(v1 + "") + " | step : " + arg8);
        if(this.isRefreshingMFPTokenj(v1 + "")) {
            j.a("==正在刷新MFP token中==", "===");  // Refreshing MFP token
            return;
        }

        this.setRefreshingMFPTokenb(v1 + "", true);
        if(this.Q()) {
            ShareFitness.get(this.ctx).b(this.ctx, v1 + "", new com.xtremeprog.shell.treadmillv2.AppsApplication.a() {
                @Override  // com.xtremeprog.shell.treadmillv2.AppsApplication$a
                public void a() {
                    AppsApplication.this.setRefreshingMFPTokenb(v1 + "", false);
                }

                @Override  // com.xtremeprog.shell.treadmillv2.AppsApplication$a
                public void b() {
                    if(arg8 < 5) {
                        AppsApplication.this.setRefreshingMFPTokenb(v1 + "", false);
                        AppsApplication.this.doRefreshMFPToken2WithCallbackWithStep(arg7, arg8 + 1);
                        return;
                    }

                    AppsApplication.this.setRefreshingMFPTokenb(v1 + "", false);
                    AppsApplication.this.e(arg7);
                }
            });
            return;
        }

        this.setRefreshingMFPTokenb(v1 + "", false);
    }

    public void e(boolean arg1) {
        this.ak = arg1;
    }

    static boolean f(AppsApplication arg0) {
        return arg0.aO;
    }

    public void get_setcustomprogram() {
        String v14;
        StringBuilder v7_1;
        String v9_2;
        StringBuilder v8_1;
        AppsApplication v0 = this;
        j.a("===", "==读取CONSOLE的参数 : " + v0.customProgram + " ==");  // Read the parameters of CONSOLE
        CustomProgram v1 = v0.customProgram;
        if(v1 != null) {
            v1.getUnit();
            int v2 = AppsRunner.get(this).getPref_CurrentUserID(v0);
            int v5 = 0;
            ContextSharedPreferences.SharedPreferencesEditor(v0.ctx, v2 + "_saveProgramUnit", Integer.valueOf(0), 1);
            List v3 = v1.setCustom1();
            List v4 = v1.setCustom2();
            boolean v6 = AppsRunner.get(this).inclineSupportsHalfDegree(v0);
            int v8 = v1.getTimeSegmentNumber();
            int v1_1 = v1.getDistanceSegmentNumber();
            if(v8 <= 0) {
                v8 = 1;
            }

            if(v1_1 <= 0) {
                v1_1 = 1;
            }

            int v9 = AppsRunner.get(this).getPref_CurrentUserID(v0.ctx);
            ContextSharedPreferences.SharedPreferencesEditor(v0, v9 + "_maxSegment", Integer.valueOf(v8), 1);
            ContextSharedPreferences.SharedPreferencesEditor(v0, v9 + "_maxSegmentDis", Integer.valueOf(v1_1), 1);
            int v1_2 = 0;
            while(v1_2 < 16) {
                com.xpg.a.b.CustomProgram.b v9_1 = (com.xpg.a.b.CustomProgram.b)v3.get(v1_2);
                float v10 = v6 ? ((float)v9_1.b()) : ((float)v9_1.b()) / 1000.0f;
                float v13 = ((float)v9_1.c()) / v6 ? 5.0f : 10.0f;
                float v7 = ((float)v9_1.a()) / 60.0f;
                j.a("===", "==customProgram : speed : " + v10 + " incline : " + v13 + " segmentLength : " + v7);
                if(v6) {
                    v8_1 = new StringBuilder();
                    v8_1.append(v2);
                    v9_2 = "_resistance_";
                }
                else {
                    v8_1 = new StringBuilder();
                    v8_1.append(v2);
                    v9_2 = "_speed_";
                }

                v8_1.append(v9_2);
                v8_1.append(v1_2 + 1);
                ContextSharedPreferences.SharedPreferencesEditor(v0, v8_1.toString(), Float.valueOf(v10 * 1.0f), 3);
                ++v1_2;
                ContextSharedPreferences.SharedPreferencesEditor(v0, v2 + "_incline_" + v1_2, Float.valueOf(v13 * 1.0f), 3);
                ContextSharedPreferences.SharedPreferencesEditor(v0, v2 + "_segmentLength_" + v1_2, Float.valueOf(v7 * 1.0f), 3);
            }

            while(v5 < 16) {
                com.xpg.a.b.CustomProgram.a v1_3 = (com.xpg.a.b.CustomProgram.a)v4.get(v5);
                float v3_1 = v6 ? ((float)v1_3.b()) : ((float)v1_3.b()) / 1000.0f;
                float v13_1 = ((float)v1_3.c()) / v6 ? 5.0f : 10.0f;
                float v1_4 = ((float)v1_3.a()) / 1000.0f;
                j.a("===", "==customProgram : speed_dis : " + v3_1 + " incline : " + v13_1 + " segmentLength : " + v1_4);
                if(v6) {
                    v7_1 = new StringBuilder();
                    v7_1.append(v2);
                    v14 = "_resistance_dis_";
                }
                else {
                    v7_1 = new StringBuilder();
                    v7_1.append(v2);
                    v14 = "_speed_dis_";
                }

                v7_1.append(v14);
                v7_1.append(v5 + 1);
                ContextSharedPreferences.SharedPreferencesEditor(v0, v7_1.toString(), Float.valueOf(v3_1 * 1.0f), 3);
                ++v5;
                ContextSharedPreferences.SharedPreferencesEditor(v0, v2 + "_incline_dis_" + v5, Float.valueOf(v13_1 * 1.0f), 3);
                ContextSharedPreferences.SharedPreferencesEditor(v0, v2 + "_segmentLengthDis_" + v5, Float.valueOf(v1_4 * 1.0f), 3);
            }

            Intent v1_5 = new Intent();
            v1_5.setAction("NOTIFICATION_DID_GET_SETCUSTOMPROGRAM");
            this.getApplicationContext().sendBroadcast(v1_5);
        }
    }

    public void resend(int command) {
        String v0;
        String v3_1;
        j.a("===", "==重发指令==");  // Resending command
        if(command == deviceCommandEnum.set_user.ordinal()) {
            j.a("==timeout==", "==setUser user 超时==");
            this.resendUserEdit();
            return;
        }

        if(command == deviceCommandEnum.select_user.ordinal()) {
            j.a("==timeout==", "==select user 超时==");
            Intent v3 = new Intent();
            v3.setAction("NOTIFICATION_SHOW_SELECT_USER_LOADING_WHEN_RESEND");
            this.sendBroadcast(v3);
            this.resendSelectUser();
            return;
        }

        if(command == deviceCommandEnum.delete_user.ordinal()) {
            j.a("==timeout==", "==delete user 超时==");
            this.deleteUser();
            return;
        }

        if(command == deviceCommandEnum.start_workout.ordinal()) {
            j.a("==timeout==", "==start workout 超时==");
            AppsRunner.get(this.ctx).startWorkout();
            return;
        }

        if(command == deviceCommandEnum.stop_workout.ordinal()) {
            j.a("==timeout==", "==stop workout 超时==");
            AppsRunner.get(this.ctx).stopWorkout();
            return;
        }

        if(command == deviceCommandEnum.pause_workout.ordinal()) {
            j.a("==timeout==", "==pause workout 超时==");
            AppsRunner.get(this.ctx).pauseWorkout();
            return;
        }

        if(command == deviceCommandEnum.continue_workout.ordinal()) {
            j.a("==timeout==", "==continue workout 超时==");
            AppsRunner.get(this.ctx).resumeWorkout();
            return;
        }

        if(command == deviceCommandEnum.change_workout.ordinal()) {
            v3_1 = "==timeout==";
            v0 = "==change workout 超时==";
            j.a(v3_1, v0);
            return;
        }

        if(command != deviceCommandEnum.select_program.ordinal()) {
            goto label_94;
        }

        j.a("==timeout==", "==select program 超时==");
        if((this.al) || (this.aj)) {
            Intent v3_2 = new Intent();
            v3_2.setAction("NOTIFICATION_RE_SHOW_LOADING");
            this.sendBroadcast(v3_2);
            this.resendSelectProgram();
            return;
        label_94:
            if(command == deviceCommandEnum.set_5k.ordinal()) {
                j.a("==timeout==", "==set5k 超时==");
                this.resendSetMyFirst5k();
                return;
            }

            if(command != deviceCommandEnum.set_custom_program.ordinal()) {
                goto label_110;
            }

            j.a("==timeout==", "==set custom program 超时==");
        }

        this.resendSelectProgram();
        return;
    label_110:
        if(command == deviceCommandEnum.set_custom_hrp.ordinal()) {
            v3_1 = "==timeout==";
            v0 = "==set custom heart rate program 超时==";
            j.a(v3_1, v0);
            return;
        }

        if(command == deviceCommandEnum.set_incline.ordinal()) {
            v3_1 = "==timeout==";
            v0 = "==set incline 超时==";  // set incline timeout
            j.a(v3_1, v0);
            return;
        }

        if(command == deviceCommandEnum.set_speed.ordinal()) {
            v3_1 = "==timeout==";
            v0 = "==set speed 超时==";
            j.a(v3_1, v0);
            return;
        }

        if(command == deviceCommandEnum.set_resistance.ordinal()) {
            v3_1 = "==timeout==";
            v0 = "==set resistance 超时==";
            j.a(v3_1, v0);
            return;
        }

        if(command == deviceCommandEnum.get_machine_info.ordinal()) {
            j.a("==timeout resend==", "==get machine info 超时==");
            AppsRunnerConnector.get(this.ctx).getMachineInfo();
            return;
        }

        if(command == deviceCommandEnum.not_initialized.ordinal()) {
            v3_1 = "==timeout resend==";
            v0 = "==not initialized 超时==";
            j.a(v3_1, v0);
            return;
        }
    }

    public void f(int arg4, int arg5) {
        if(this.n == null) {
            try {
                apps.views.d.a v0 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                v0.b(0x7F0B0134);  // string:prompt "Warning"
                v0.a(arg4);
                this.n = v0.a();
                this.n.setCancelable(false);
                this.n.setCanceledOnTouchOutside(false);
                this.n.show();
            }
            catch(Exception v4) {
                v4.printStackTrace();
            }

            if(arg5 != -1 && arg5 != 0xA5) {
                if(arg5 == 0) {
                    arg5 = 3;
                }

                new Handler().postDelayed(() -> if(AppsApplication.this.n != null && (AppsApplication.this.n.isShowing())) {
                    try {
                        AppsApplication.this.n.dismiss();
                    }
                    catch(Exception v0) {
                        v0.printStackTrace();
                        AppsApplication.this.n = null;
                        return;
                    }

                    AppsApplication.this.n = null;
                }, ((long)(arg5 * 1000)));
            }
        }

        class com.xtremeprog.shell.treadmillv2.AppsApplication.16 implements Runnable {
            @Override
            public void run() {
                AppsApplication.this.t();
            }
        }

    }

    public void f(String arg2) {
        Message v0 = new Message();
        v0.obj = arg2;
        this.aX.sendMessage(v0);
    }

    public void doRefreshFBToken2WithCallbackWithStep(String arg7, int step) {
        int v1 = (int)apps.c.d.a(arg7, 0);
        if(!this.isConnectionCorrect()) {
            j.a("==FBToken2WithCallBackWithStep==", "==未同步完，先不刷新==");
            this.setRefreshingFBTokenc(v1 + "", false);
            return;
        }

        j.a("==doRefreshFBToken2WithCallbackWithStep==", this.isRefreshingFBToken(v1 + "") + " | step : " + step);
        if(this.isRefreshingMFPTokenj(v1 + "")) {
            j.a("==正在刷新FB token中==", "===");  // Refreshing FB token
            return;
        }

        this.setRefreshingFBTokenc(v1 + "", true);
        if(this.R()) {
            ShareFitness.get(this.ctx).c(this.ctx, v1 + "", new com.xtremeprog.shell.treadmillv2.AppsApplication.a() {
                @Override  // com.xtremeprog.shell.treadmillv2.AppsApplication$a
                public void a() {
                    AppsApplication.this.setRefreshingFBTokenc(v1 + "", false);
                }

                @Override  // com.xtremeprog.shell.treadmillv2.AppsApplication$a
                public void b() {
                    if(step < 5) {
                        AppsApplication.this.setRefreshingFBTokenc(v1 + "", false);
                        AppsApplication.this.doRefreshFBToken2WithCallbackWithStep(arg7, step + 1);
                        return;
                    }

                    AppsApplication.this.setRefreshingFBTokenc(v1 + "", false);
                    AppsApplication.this.f(arg7);
                }
            });
            return;
        }

        this.setRefreshingFBTokenc(v1 + "", false);
    }

    public void f(boolean arg1) {
        this.al = arg1;
    }

    static int g(AppsApplication arg2) {
        int v0 = arg2.aU;
        arg2.aU = v0 + 1;
        return v0;
    }

    public void g(String arg4) {
        String v0;
        try {
            v0 = ShareFitness.get(this.ctx).getPrefsMFPTokenId(arg4);
            if(apps.c.d.strNotEmpty(v0)) {
                v0 = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
            }

            if(!apps.c.d.strNotEmpty(v0) && !apps.c.d.a(v0, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
                goto label_12;
            }
        }
        catch(Exception v4) {
            v4.printStackTrace();
        }

        return;
    label_12:
        if(this.r == null) {
            try {
                if(!apps.c.d.strNotEmpty(v0) && !apps.c.d.a(v0, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
                    c.a().b(this.ctx, v0);
                }

                ShareFitness.get(this.ctx).m(arg4);
                String v4_2 = this.b(arg4);
                apps.views.d.a v0_1 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                v0_1.b(0x7F0B0134);  // string:prompt "Warning"
                v0_1.a("Your account for " + v4_2 + " has expired.Please log in again.");
                v0_1.a(0x7F0B000D, new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_OK "OK"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        Intent v1_1 = new Intent();
                        v1_1.setAction("NOTIFICATION_TO_MFP_LOGIN");
                        AppsApplication.this.getApplicationContext().sendBroadcast(v1_1);
                        AppsApplication.this.r = null;
                    }
                });
                v0_1.b(0x7F0B001D, new DialogInterface.OnClickListener() {  // string:STR_CANCEL "CANCEL"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        Intent v1_1 = new Intent();
                        v1_1.setAction("NOTIFICATION_TO_MFP_LOGIN_BUT_NOT_JUMP");
                        AppsApplication.this.getApplicationContext().sendBroadcast(v1_1);
                        AppsApplication.this.r = null;
                    }
                });
                this.r = v0_1.a();
                this.r.setCancelable(false);
                this.r.setCanceledOnTouchOutside(false);
                this.r.show();
                return;
            }
            catch(Exception v4_1) {
            }

            try {
                v4_1.printStackTrace();
                return;
            }
            catch(Exception v4) {
            }

            v4.printStackTrace();
            return;
        }
    }

    public void g(boolean arg1) {
        this.af = arg1;
    }

    public boolean g() {
        return this.af;
    }

    static int h(AppsApplication arg0) {
        return arg0.aU;
    }

    @Override  // apps.views.a$a
    public void h() {
    }

    public void h(String arg4) {
        String v0;
        try {
            v0 = ShareFitness.get(this.ctx).getPrefsFitbitTokenId(arg4);
            if(apps.c.d.strNotEmpty(v0)) {
                v0 = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
            }

            if(!apps.c.d.strNotEmpty(v0) && !apps.c.d.a(v0, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
                goto label_12;
            }
        }
        catch(Exception v4) {
            v4.printStackTrace();
        }

        return;
    label_12:
        if(this.s == null) {
            try {
                if(!apps.c.d.strNotEmpty(v0) && !apps.c.d.a(v0, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
                    c.a().c(this.ctx, v0);
                }

                ShareFitness.get(this.ctx).o(arg4);
                String v4_2 = this.b(arg4);
                apps.views.d.a v0_1 = new apps.views.d.a(AppsRunner.get(this.ctx).a());
                v0_1.b(0x7F0B0134);  // string:prompt "Warning"
                v0_1.a("Your account for " + v4_2 + " has expired.Please log in again.");
                v0_1.a(0x7F0B000D, new DialogInterface.OnClickListener() {  // string:STR_ALERT_TIP_OK "OK"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        Intent v1_1 = new Intent();
                        v1_1.setAction("NOTIFICATION_TO_FB_LOGIN");
                        AppsApplication.this.getApplicationContext().sendBroadcast(v1_1);
                        AppsApplication.this.s = null;
                    }
                });
                v0_1.b(0x7F0B001D, new DialogInterface.OnClickListener() {  // string:STR_CANCEL "CANCEL"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface arg1, int arg2) {
                        try {
                            arg1.dismiss();
                        }
                        catch(Exception v1) {
                            v1.printStackTrace();
                        }

                        Intent v1_1 = new Intent();
                        v1_1.setAction("NOTIFICATION_TO_FB_LOGIN_BUT_NOT_JUMP");
                        AppsApplication.this.getApplicationContext().sendBroadcast(v1_1);
                        AppsApplication.this.s = null;
                    }
                });
                this.s = v0_1.a();
                this.s.setCancelable(false);
                this.s.setCanceledOnTouchOutside(false);
                this.s.show();
                return;
            }
            catch(Exception v4_1) {
            }

            try {
                v4_1.printStackTrace();
                return;
            }
            catch(Exception v4) {
            }

            v4.printStackTrace();
            return;
        }
    }

    public void h(boolean arg1) {
        this.ac = arg1;
    }

    public void i(boolean arg1) {
        this.ag = arg1;
    }

    public boolean i() {
        return this.ag;
    }

    public boolean isRefreshingMMFTokeni(String arg4) {
        boolean v0 = this.aY.get(arg4) == null ? 0 : ((Boolean)this.aY.get(arg4)).booleanValue();
        j.a("==isRefreshingMMFToken==", arg4 + " = " + ((boolean)(((int)v0))));
        return v0;
    }

    public void j(boolean arg1) {
        this.ah = arg1;
    }

    public boolean j() {
        return this.ah;
    }

    public boolean isRefreshingMFPTokenj(String arg4) {
        boolean v0 = this.aZ.get(arg4) == null ? 0 : ((Boolean)this.aZ.get(arg4)).booleanValue();
        j.a("==isRefreshingMFPToken==", arg4 + " = " + ((boolean)(((int)v0))));
        return v0;
    }

    public void k(boolean arg2) {
        if(arg2) {
            this.a(false, 0, 0);
            this.b(false, 0, 0);
            this.c(false, 0, 0);
            this.a(true, 3000, 3000);
            this.b(true, 3000, 3000);
            this.c(true, 3000, 3000);
            return;
        }

        this.a(false, 0, 0);
        this.b(false, 0, 0);
        this.c(false, 0, 0);
    }

    public boolean k() {
        return this.aA;
    }

    public boolean isRefreshingFBToken(String arg4) {
        boolean v0 = this.ba.get(arg4) == null ? 0 : ((Boolean)this.ba.get(arg4)).booleanValue();
        j.a("==isRefreshingFBToken==", arg4 + " = " + ((boolean)(((int)v0))));
        return v0;
    }

    public void l(boolean arg2) {
        this.aA = arg2;
        AppsRunnerConnector.get(this.ctx).c(((boolean)(((int)arg2))));
    }

    public boolean l() {
        return this.aB;
    }

    public void m(boolean arg2) {
        this.aB = arg2;
        AppsRunnerConnector.get(this.ctx).d(((boolean)(((int)arg2))));
    }

    public boolean m() {
        return this.ax;
    }

    public void n(boolean arg2) {
        this.ax = arg2;
        AppsRunnerConnector v2 = AppsRunnerConnector.get(this.ctx);
        v2.a = this.ax;
    }

    public boolean n() {
        return this.ay;
    }

    public void refreshToken(boolean arg4) {
        this.ay = arg4;
        AppsRunnerConnector connector = AppsRunnerConnector.get(this.ctx);
        connector.b = this.ay;
        if(this.ay) {
            j.a("==同步完了,开始refresh token了==", "==");  // Synchronization is complete, start refresh token
            int v4_1 = AppsRunner.get(this).getPref_CurrentUserID(this);
            if(this.isConnectionCorrect()) {
                j.a("==同步完的，可以刷新token==", "==" + v4_1);  // After synchronization, token can be refreshed
                Message v4_2 = new Message();
                this.c.sendMessage(v4_2);
                return;
            }

            j.a("==未同步完，不刷新token==", "==" + v4_1);  // The token is not refreshed if the synchronization is not completed
        }
    }

    public boolean o() {
        return this.az;
    }

    @Override  // android.app.Application
    public void onCreate() {
        super.onCreate();
        AppsCrashHandler.get(this);
        BLEManager.get(this).a(((interface_a)this));
        UserSlow.get(this).setParent(((interface_a)this));
        BLEManagerMIO.get(this).a(((interface_a)this));
        running_hr_treadmill_class.get(this, this).set_b(((interface_a)this));
        this.aY.put("0", Boolean.valueOf(false));
        this.aY.put("1", Boolean.valueOf(false));
        this.aY.put("2", Boolean.valueOf(false));
        this.aY.put("3", Boolean.valueOf(false));
        this.aY.put("4", Boolean.valueOf(false));
        this.aY.put("5", Boolean.valueOf(false));
        this.aZ.put("0", Boolean.valueOf(false));
        this.aZ.put("1", Boolean.valueOf(false));
        this.aZ.put("2", Boolean.valueOf(false));
        this.aZ.put("3", Boolean.valueOf(false));
        this.aZ.put("4", Boolean.valueOf(false));
        this.aZ.put("5", Boolean.valueOf(false));
        this.ba.put("0", Boolean.valueOf(false));
        this.ba.put("1", Boolean.valueOf(false));
        this.ba.put("2", Boolean.valueOf(false));
        this.ba.put("3", Boolean.valueOf(false));
        this.ba.put("4", Boolean.valueOf(false));
        this.ba.put("5", Boolean.valueOf(false));
    }

    public void p() {
        this.aC.removeMessages(0x3640E);
        Message v0 = new Message();
        v0.what = 0x3640E;
        this.aC.sendMessageDelayed(v0, 2000L);
    }

    public void p(boolean arg2) {
        this.az = arg2;
        AppsRunnerConnector v2 = AppsRunnerConnector.get(this.ctx);
        v2.c = this.az;
    }

    public void q() {
        try {
            if(this.p != null) {
                boolean v0_1 = this.p.isShowing();
                goto label_4;
            }
        }
        catch(Exception v0) {
            v0.printStackTrace();
        }

        return;
    label_4:
        if(v0_1) {
            try {
                this.p.dismiss();
                this.p = null;
                return;
            }
            catch(Exception v0_2) {
            }

            try {
                v0_2.printStackTrace();
                this.p = null;
                return;
            }
            catch(Exception v0) {
            }

            v0.printStackTrace();
            return;
        }
    }

    public void start_sync_user_info() {
        Intent v0 = new Intent();
        v0.setAction("NOTIFICATION_START_SYN_USER_INFO");
        this.getApplicationContext().sendBroadcast(v0);
        AppsRunnerConnector.get(this.getApplicationContext()).getMachineInfo();
    }

    // Detected as a lambda impl.
    public void s() {
        if(this.m != null && (this.m.isShowing())) {
            try {
                this.m.dismiss();
            }
            catch(Exception v0) {
                v0.printStackTrace();
                this.m = null;
                return;
            }

            this.m = null;
        }
    }

    // Detected as a lambda impl.
    public void t() {
        if(this.n != null && (this.n.isShowing())) {
            try {
                this.n.dismiss();
            }
            catch(Exception v0) {
                v0.printStackTrace();
                this.n = null;
                return;
            }

            this.n = null;
        }
    }

    // Detected as a lambda impl.
    public void u() {
        if(this.j != null && (this.j.isShowing())) {
            try {
                this.j.dismiss();
            }
            catch(Exception v0) {
                v0.printStackTrace();
                this.j = null;
                return;
            }

            this.j = null;
        }
    }

    public void setHeartValueMaybe() {
        BLEManager.get(this.ctx).maybe_send_message_1(new byte[]{85, -86, 1, 0, 3, 19, 1, 0, -16, -31, 0});  // 55AA 0100 0313 0100 f0e1 00
    }

    public void w() {
        AppsRunnerConnector.get(this.getApplicationContext()).tryToConnectPreviousDevice();
        this.t.removeMessages(0x2B67);
        Message v0 = new Message();
        v0.what = 0x2B67;
        this.t.sendMessageDelayed(v0, 5000L);
    }

    public void x() {
        if(this.isConnectionCorrect()) {
            AppsRunnerConnector.get(this.getApplicationContext()).connectMIODevice();
        }
        else {
            AppsRunnerConnector.get(this.getApplicationContext()).p = false;
        }

        this.u.removeMessages(0x56CE);
        Message v0 = new Message();
        v0.what = 0x56CE;
        this.u.sendMessageDelayed(v0, 5000L);
    }

    public void y() {
        Message v0 = new Message();
        v0.what = 0x6F;
        this.x.sendMessageDelayed(v0, 12000L);
    }

    public void z() {
        this.x.removeMessages(0x6F);
    }
}
