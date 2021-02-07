package com.xpg.c;

import android.content.Context;
import android.util.Log;
import com.xpg.a.BLEDevice;
import com.xpg.a.a.ReceiveData;
import com.xpg.a.b.DeviceCommand;
import com.xpg.a.b.UserSync;
import com.xpg.b.BLEManager;
import com.xpg.b.interface_a;
import java.util.Calendar;

public class UserSlow implements interface_a {
    private final String a;
    private interface_a parent;
    private BLEManager c;
    private UserSync[] userSyncArray;
    private boolean e;
    private static UserSlow s_instance;

    private UserSlow(Context arg2) {
        this.a = "==== UserSlow ====";
        this.e = false;
        this.c = BLEManager.get(arg2);
        this.c.a(((interface_a)this));
    }

    public static UserSlow get(Context context) {
        if(UserSlow.s_instance == null) {
            UserSlow.s_instance = new UserSlow(context);
        }

        return UserSlow.s_instance;
    }

    @Override  // com.xpg.b.interface_a
    public void sendMessage(BLEDevice arg2, int arg3) {
        this.parent.sendMessage(arg2, arg3);
    }

    public void setParent(interface_a arg1) {
        this.parent = arg1;
    }

    @Override  // com.xpg.b.interface_a
    public void receiveData(Object arg12, int arg13) {
        int msg10;
        BLEManager bleManager;
        ReceiveData receivedData = new ReceiveData(((byte[])arg12));
        int msg11 = this.e ^ 1;
        switch(receivedData.getDeviceResponse()) {
            case userInfo: {
                UserSync userSync = receivedData.getUserSync();
                if(userSync.getUserSlot() > -1) {
                    UserSync[] userSyncArray = this.userSyncArray;
                    UserSync storedUserSync = userSyncArray[userSync.getUserSlot()];
                    Log.d("==== UserSlow ====", userSync.toString());
                    Log.e("==== UserSlow ====", storedUserSync.toString());
                    if(userSync.toString().equals(storedUserSync.toString())) {
                        this.c.maybe_send_message_1(DeviceCommand.msg_msg5_0(22, 0, 1));
                    }
                    else {
                        this.c.maybe_send_message_1(DeviceCommand.setUserInfoMsg(storedUserSync));
                    }
                }

                this.parent.receiveData(receivedData, arg13);
                return;
            }
            case workoutSummary: {
                this.c.maybe_send_message_1(DeviceCommand.msg_msg5_0(26, 0, 1));
                this.parent.receiveData(receivedData, arg13);
                return;
            }
            case setPopupInfo: {
                this.c.maybe_send_message_1(DeviceCommand.msg_msg5_0(27, 0, 1));
                this.parent.receiveData(receivedData, arg13);
                return;
            }
            case device_puaseWorkout:
            case deviceContinueWorkout: {
                this.c.maybe_send_message_1(new byte[]{85, -86, 1, 0, 3, 0, 2, 0, 92, 72, 3, 0});
                this.parent.receiveData(receivedData, arg13);
                return;
            }
            case stopWorkout: {
                bleManager = this.c;
                msg10 = 20;
                bleManager.maybe_send_message_1(DeviceCommand.msg_msg5_0(msg10, msg11, 1));
                this.parent.receiveData(receivedData, arg13);
                return;
            }
            case device_startWorkout: {
                this.c.maybe_send_message_1(DeviceCommand.msg_msg5_0(2, msg11, 3));
                this.parent.receiveData(receivedData, arg13);
                return;
            }
            case device_timeSync: {
                Calendar v12_2 = Calendar.getInstance();
                int v4 = v12_2.get(1);
                int v5 = v12_2.get(2);
                int v6 = v12_2.get(5);
                int v7 = v12_2.get(11);
                int v8 = v12_2.get(12);
                int v9 = v12_2.get(13);
                this.c.maybe_send_message_1(DeviceCommand.timeSyncMsg(v4, v5, v6, v7, v8, v9, 0));
                this.e = true;
                this.parent.receiveData(receivedData, arg13);
                return;
            }
            case setMyFirst5k: {
                bleManager = this.c;
                msg10 = 23;
                bleManager.maybe_send_message_1(DeviceCommand.msg_msg5_0(msg10, msg11, 1));
                this.parent.receiveData(receivedData, arg13);
                return;
            }
            case setCustomProgram: {
                bleManager = this.c;
                msg10 = 24;
                bleManager.maybe_send_message_1(DeviceCommand.msg_msg5_0(msg10, msg11, 1));
                this.parent.receiveData(receivedData, arg13);
                return;
            }
            case setCustomHRProgram: {
                bleManager = this.c;
                msg10 = 25;
                bleManager.maybe_send_message_1(DeviceCommand.msg_msg5_0(msg10, msg11, 1));
                this.parent.receiveData(receivedData, arg13);
                return;
            }
            default: {
                this.parent.receiveData(receivedData, arg13);
                return;
            }
        }
    }

    @Override  // com.xpg.b.interface_a
    public void handleConnection(boolean arg2, int arg3) {
        this.parent.handleConnection(((boolean)(((int)arg2))), arg3);
    }

    public void getMachineInfo(UserSync[] arg5) {
        this.e = false;
        Log.e("==== UserSlow ====", "调用了SDK的同步方法，进行get machine info : " + arg5.length);
        this.c.maybe_send_message2(new byte[]{85, -86, 1, 0, 1, 2, 0, 0, 0, 0}, 5, 4000);
        this.userSyncArray = arg5;
    }
}
