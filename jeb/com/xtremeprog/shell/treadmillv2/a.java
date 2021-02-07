package com.xtremeprog.shell.treadmillv2;

import android.content.Context;
import android.content.Intent;
import com.xtremeprog.shell.treadmillv2.activity.AppsRunningActivity;

public class a {
    public static void startWorkout(Context contect) {
        Intent v0 = new Intent();
        v0.setAction("NOTIFICATION_DID_START_WORKOUT");
        contect.sendBroadcast(v0);
        contect.startActivity(new Intent(contect, AppsRunningActivity.class));
    }

    public static void stopWorkout(Context context) {
        Intent v0 = new Intent();
        v0.setAction("NOTIFICATION_DID_STOP_WORKOUT");
        context.sendBroadcast(v0);
    }
}
