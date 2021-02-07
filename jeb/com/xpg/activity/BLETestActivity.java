package com.xpg.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import apps.database.d;
import com.xpg.a.BLEDevice;
import com.xpg.a.a.CustomHRProgramReceive;
import com.xpg.a.a.DeviceInfo;
import com.xpg.a.a.ReceiveData;
import com.xpg.a.a.StopWorkoutInfo;
import com.xpg.a.a.WorkoutData;
import com.xpg.a.a.WorkoutSummary;
import com.xpg.a.b.DeviceCommand;
import com.xpg.a.b.UserSync;
import com.xpg.a.c.Factory;
import com.xpg.b.BLEManager;
import com.xpg.b.BLEManagerMIO;
import com.xpg.b.interface_a;
import com.xpg.c.UserSlow;
import com.xpg.c.running_hr_treadmill_class;
import com.xtremeprog.shell.treadmillv2.AppsApplication;
import com.xtremeprog.shell.treadmillv2.AppsRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BLETestActivity extends Activity implements View.OnClickListener, interface_a {
    private List A;
    private UserSlow B;
    private BLEManager bleManager;
    private BLEManagerMIO D;
    private running_hr_treadmill_class E;
    private TextView a;
    private Button b;
    private Button c;
    private Button d;
    private Button e;
    private Button f;
    private Button g;
    private Button h;
    private Button i;
    private Button j;
    private Button k;
    private Button l;
    private Button m;
    private Button n;
    private Button o;
    private Button p;
    private Button q;
    private Button r;
    private Button s;
    private Button t;
    private EditText u;
    private EditText incline;
    private EditText resistance;
    private EditText speed;
    private EditText y;
    private StringBuffer z;

    public BLETestActivity() {
        this.z = new StringBuffer();
    }

    static BLEManagerMIO a(BLETestActivity arg0) {
        return arg0.D;
    }

    private void a() {
        this.a = (TextView)this.findViewById(0x7F0702B1);  // id:tv_log
        this.b = (Button)this.findViewById(0x7F070030);  // id:btn_start_scan
        this.c = (Button)this.findViewById(0x7F070025);  // id:btn_disconnect
        this.d = (Button)this.findViewById(0x7F070022);  // id:btn_connect_device
        this.f = (Button)this.findViewById(0x7F07002E);  // id:btn_set_user_01
        this.g = (Button)this.findViewById(0x7F070024);  // id:btn_delete_user
        this.h = (Button)this.findViewById(0x7F07002F);  // id:btn_start_exc
        this.i = (Button)this.findViewById(0x7F070031);  // id:btn_stop_exc
        this.j = (Button)this.findViewById(0x7F070026);  // id:btn_pause_exc
        this.k = (Button)this.findViewById(0x7F070023);  // id:btn_continue_exc
        this.l = (Button)this.findViewById(0x7F070020);  // id:btn_change_exc
        this.m = (Button)this.findViewById(0x7F070027);  // id:btn_select_program
        this.n = (Button)this.findViewById(0x7F07002B);  // id:btn_set_inclint
        this.p = (Button)this.findViewById(0x7F07002D);  // id:btn_set_speed
        this.o = (Button)this.findViewById(0x7F07002C);  // id:btn_set_resistance
        this.r = (Button)this.findViewById(0x7F070028);  // id:btn_set_5k_program
        this.s = (Button)this.findViewById(0x7F07002A);  // id:btn_set_custom_program
        this.t = (Button)this.findViewById(0x7F070029);  // id:btn_set_HR_program
        this.p = (Button)this.findViewById(0x7F07002D);  // id:btn_set_speed
        this.q = (Button)this.findViewById(0x7F070032);  // id:btn_sync
        this.e = (Button)this.findViewById(0x7F070021);  // id:btn_connect_MIO
        this.y = (EditText)this.findViewById(0x7F0700A8);  // id:et_mac
        this.u = (EditText)this.findViewById(0x7F0700A9);  // id:et_select_program
        this.incline = (EditText)this.findViewById(0x7F0700AA);  // id:et_set_inclint
        this.resistance = (EditText)this.findViewById(0x7F0700AB);  // id:et_set_resistance
        this.speed = (EditText)this.findViewById(0x7F0700AC);  // id:et_set_speed
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.e.setOnClickListener(this);
    }

    @Override  // com.xpg.b.interface_a
    public void sendMessage(BLEDevice arg4, int arg5) {
        if(!this.A.contains(arg4.getDeviceAddress())) {
            this.A.add(arg4.getDeviceAddress());
            this.z.insert(0, "序号" + this.A.size() + ": " + arg4.getDeviceName() + "  :  " + arg4.getDeviceAddress() + "  :  " + arg4.getDeviceRSSI() + "\n");
            this.b();
        }
    }

    @Override  // com.xpg.b.interface_a
    public void receiveData(Object arg5, int arg6) {
        String v2_1;
        StopWorkoutInfo v5_7;
        String v5_3;
        String v2;
        int v5_1;
        StringBuffer v6;
        ReceiveData v5 = (ReceiveData)arg5;
        switch(v5.getDeviceResponse()) {
            case device_return_error_data: {
                this.z.insert(0, "\ndevice_return_error_data\n");
                this.b();
                return;
            }
            case timeout: {
                v6 = this.z;
                v6.insert(0, "\ntimeout\n" + v5.getDeviceCommand());
                this.b();
                return;
            }
            case keyPress: {
                v5_1 = v5.h();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nkeyPress --> keyValue:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case userInfo: {
                UserSync v5_2 = v5.getUserSync();
                v6 = this.z;
                v1 = new StringBuilder();
                v1.append("\nuserInfo:");
                v5_3 = v5_2.toString();
                goto label_172;
            }
            case workoutSummary: {
                WorkoutSummary v5_4 = v5.getWorkoutSummary();
                v6 = this.z;
                v1 = new StringBuilder();
                v1.append("\nworkoutSummary:");
                v5_3 = v5_4.toString();
                goto label_172;
            }
            case setCustomHRProgram: {
                CustomHRProgramReceive v5_5 = v5.getCustomHRProgram();
                v6 = this.z;
                v1 = new StringBuilder();
                v1.append("\nsetCustomHRProgram:");
                v5_3 = v5_5.toString();
                goto label_172;
            }
            case setPopupInfo: {
                int v6_1 = v5.getPopupType();
                int v5_6 = v5.getDisappearTime();
                this.z.insert(0, "\nsetPopupInfo --> popupType:" + v6_1 + " - disappearTime:" + v5_6 + "\n");
                this.b();
                return;
            }
            case stopWorkout: {
                v5_7 = v5.getStopWorkoutInfo();
                v6 = this.z;
                v1 = new StringBuilder();
                v2_1 = "\nstopWorkout:";
                v1.append(v2_1);
                v5_3 = v5_7.toString();
                goto label_172;
            }
            case response_getMachineInfo: {
                DeviceInfo v5_8 = v5.getMachineInfo();
                v6 = this.z;
                v1 = new StringBuilder();
                v1.append("\nresponse_getMachineInfo:");
                v5_3 = v5_8.toString();
                goto label_172;
            }
            case response_stopWorkout: {
                v5_7 = v5.getStopWorkoutInfo();
                v6 = this.z;
                v1 = new StringBuilder();
                v2_1 = "\nresponse_stopWorkout:";
                v1.append(v2_1);
                v5_3 = v5_7.toString();
                goto label_172;
            }
            case response_changeWorkout: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_changeWorkout --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_customProgram: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_customProgram --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_deleteUser: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_deleteUser --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_pauseWorkout: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_pauseWorkout --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_selectProgram: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_selectProgram --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_setCustomHRProgram: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_setCustomHRProgram --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_setIncline: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_setIncline --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_setMyFirst5k: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_setMyFirst5k --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_setResistance: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_setResistance --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_setSpeed: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_setSpeed --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_setUser: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_setUser --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case response_startWorkout: {
                v5_1 = v5.getResponseCode();
                v6 = this.z;
                v1 = new StringBuilder();
                v2 = "\nresponse_startWorkout --> responseCode:";
                v1.append(v2);
                v1.append(v5_1);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            case device_workoutData: {
                WorkoutData v5_9 = v5.getWorkoutData();
                v6 = this.z;
                v1 = new StringBuilder();
                v1.append("\nworkoutData:");
                v5_3 = v5_9.toString();
            label_172:
                v1.append(v5_3);
                v1.append("\n");
                v6.insert(0, v1.toString());
                this.b();
                return;
            }
            default: {
                this.b();
                return;
            }
        }
    }

    @Override  // com.xpg.b.interface_a
    public void handleConnection(boolean arg3, int arg4) {
        this.z.insert(0, "\nconnect status:" + ((boolean)(((int)arg3))) + "\n");
        this.b();
    }

    static EditText b(BLETestActivity arg0) {
        return arg0.y;
    }

    private void b() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BLETestActivity.e(BLETestActivity.this).setText(BLETestActivity.d(BLETestActivity.this).toString());
            }
        });
    }

    static List c(BLETestActivity arg0) {
        return arg0.A;
    }

    static StringBuffer d(BLETestActivity arg0) {
        return arg0.z;
    }

    static TextView e(BLETestActivity arg0) {
        return arg0.a;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View arg19) {
        byte[] msg;
        BLEManager bleManager;
        com.xpg.activity.BLETestActivity.2 v2_1;
        Timer v1_1;
        int v6 = 0;
        switch(arg19.getId()) {
            case 0x7F070020: {  // id:btn_change_exc
                this.bleManager.maybe_send_message_1(new byte[]{85, -86, 8, 0, 3, 4, 8, 0, -66, 74, 1, 0, -124, 3, 0, 0, 0, 0});
                goto label_58;
            }
            case 0x7F070021: {  // id:btn_connect_MIO
                this.bleManager.stopScan();
                v1_1 = new Timer();
                v2_1 = new TimerTask() {
                    @Override
                    public void run() {
                        BLETestActivity.a(BLETestActivity.this).a(((String)BLETestActivity.c(BLETestActivity.this).get(Integer.parseInt(BLETestActivity.b(BLETestActivity.this).getText().toString()) - 1)));
                    }
                };
                v1_1.schedule(((com.xpg.activity.BLETestActivity.1)v2_1), 2000L);
                return;
            }
            case 0x7F070022: {  // id:btn_connect_device
                this.bleManager.stopScan();
                this.bleManager.connect(((String)this.A.get(Integer.parseInt(this.y.getText().toString()) - 1)));
                return;
            }
            case 0x7F070023: {  // id:btn_continue_exc
                bleManager = this.bleManager;
                msg = new byte[]{85, -86, 7, 0, 3, 3, 1, 0, -47, -15, 1};
                bleManager.maybe_send_message_1(msg);
                return;
            }
            case 0x7F070024: {  // id:btn_delete_user
                bleManager = this.bleManager;
                msg = new byte[]{85, -86, 6, 0, 3, 18, 1, 0, -78, -63, 2};
                bleManager.maybe_send_message_1(msg);
                return;
            }
            case 0x7F070025: {  // id:btn_disconnect
                this.bleManager.disconnect();
                this.z.insert(0, "\ndisconnect\n");
                this.b();
                return;
            }
            case 0x7F070026: {  // id:btn_pause_exc
                bleManager = this.bleManager;
                msg = new byte[]{85, -86, 5, 0, 3, 3, 1, 0, -16, -31, 0};
                bleManager.maybe_send_message_1(msg);
                return;
            }
            case 0x7F070027: {  // id:btn_select_program
            label_58:
                if(this.u.getText().toString().isEmpty()) {
                    return;
                }

                bleManager = this.bleManager;
                msg = DeviceCommand.selectProgramMsg(Integer.parseInt(this.u.getText().toString()));
                bleManager.maybe_send_message_1(msg);
                return;
            }
            case 0x7F070028: {  // id:btn_set_5k_program
                this.bleManager.maybe_send_message2(new byte[]{85, -86, 4, 0, 1, 23, 7, 0, 49, -49, 1, 1, 1, 30, 40, 5, 0}, 5, 500);
                return;
            }
            case 0x7F070029: {  // id:btn_set_HR_program
                int v2_3 = AppsRunner.get(this).getPref_CurrentUserID(this);
                int v13 = d.a().g(this, AppsRunner.get(this).getPref_CurrentUserID(this));
                bleManager = this.bleManager;
                msg = DeviceCommand.setCustomHRProgramMsg(Factory.a(v2_3, 1, v13, 1, 1, v13, 2, 2, v13, 3, 3, v13, 4, 4));
                bleManager.maybe_send_message_1(msg);
                return;
            }
            case 0x7F07002A: {  // id:btn_set_custom_program
                ArrayList v1_2 = new ArrayList();
                ArrayList v2_2 = new ArrayList();
                this.bleManager.maybe_send_message_1(DeviceCommand.setCustomProgramMsg(Factory.customProgram(AppsRunner.get(this).getPref_CurrentUserID(this), v1_2, v2_2)));
                return;
            }
            case 0x7F07002B: {  // id:btn_set_inclint
                if(!this.incline.getText().toString().isEmpty()) {
                    bleManager = this.bleManager;
                    msg = DeviceCommand.setInclineMsg(((short)Short.parseShort(this.incline.getText().toString())), ((short)0));
                    bleManager.maybe_send_message_1(msg);
                    return;
                }

                return;
            }
            case 0x7F07002C: {  // id:btn_set_resistance
                if(this.resistance.getText().toString().isEmpty()) {
                    return;
                }

                bleManager = this.bleManager;
                msg = DeviceCommand.setResistanceMsg(((byte)Integer.parseInt(this.resistance.getText().toString())), ((byte)0));
                bleManager.maybe_send_message_1(msg);
                return;
            }
            case 0x7F07002D: {  // id:btn_set_speed
                if(this.speed.getText().toString().isEmpty()) {
                    return;
                }

                bleManager = this.bleManager;
                msg = DeviceCommand.setSpeedMsg(((byte)1), ((short)Short.parseShort(this.speed.getText().toString())), ((byte)0));
                bleManager.maybe_send_message_1(msg);
                return;
            }
            case 0x7F07002E: {  // id:btn_set_user_01
                bleManager = this.bleManager;
                msg = new byte[]{85, -86, 3, 0, 1, 15, -41, 1, -54, -38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 15, -58, 7, 1, 1, 0, 0, 84, 101, 0x73, 0x74, 101, 0x72, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 51, 50, 51, 49, 50, 51, 107, 108, 106, 108, 107, 49, 106, 108, 50, 51, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0x73, 102, 107, 108, 106, 97, 108, 0x73, 100, 102, 106, 107, 108, 97, 106, 0x73, 100, 102, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 49, 50, 51, 49, 50, 51, 49, 50, 51, 0, 0, 0, 0, 0, 0};
                bleManager.maybe_send_message_1(msg);
                return;
            }
            case 0x7F07002F: {  // id:btn_start_exc
                bleManager = this.bleManager;
                msg = new byte[]{85, -86, 2, 0, 3, 2, 17, 0, -117, -97, 1, 0, -124, 3, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 2, 0, 1};
                bleManager.maybe_send_message_1(msg);
                return;
            }
            case 0x7F070030: {  // id:btn_start_scan
                this.A.clear();
                this.D.a();
                v1_1 = new Timer();
                v2_1 = new TimerTask() {
                    @Override
                    public void run() {
                        BLETestActivity.a(BLETestActivity.this).a(1);
                    }
                };
                v1_1.schedule(((com.xpg.activity.BLETestActivity.1)v2_1), 2000L);
                return;
            }
            case 0x7F070031: {  // id:btn_stop_exc
                bleManager = this.bleManager;
                msg = new byte[]{85, -86, 1, 0, 1, 20, 0, 0, 0, 0};
                bleManager.maybe_send_message_1(msg);
                return;
            }
            case 0x7F070032: {  // id:btn_sync
                UserSync[] userSyncArray = new UserSync[5];
                while(v6 < userSyncArray.length) {
                    userSyncArray[v6] = new UserSync();
                    ++v6;
                }

                this.B.getMachineInfo(userSyncArray);
                return;
            }
            default: {
                return;
            }
        }
    }

    @Override  // android.app.Activity
    protected void onCreate(Bundle arg2) {
        super.onCreate(arg2);
        this.setContentView(0x7F09001D);  // layout:activity_ble_test
        AppsApplication v2 = (AppsApplication)this.getApplication();
        this.bleManager = BLEManager.get(this);
        this.D = BLEManagerMIO.get(this);
        this.B = UserSlow.get(this);
        this.E = running_hr_treadmill_class.get(this, v2);
        this.B.setParent(((interface_a)this));
        this.a();
        this.z.append("Start Log");
        this.A = new ArrayList();
        this.bleManager.requestBluetoothEnable();
    }
}
