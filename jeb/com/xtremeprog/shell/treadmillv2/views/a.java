package com.xtremeprog.shell.treadmillv2.views;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.DatePickerDialog;
import android.content.Context;

public class a extends DatePickerDialog {
    public a(Context arg1, DatePickerDialog.OnDateSetListener arg2, int arg3, int arg4, int arg5) {
        super(arg1, arg2, arg3, arg4, arg5);
    }

    @Override  // android.app.Dialog
    protected void onStop() {
    }
}
