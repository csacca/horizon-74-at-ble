package com.xpg.a;

public class Enums {
    public static enum deviceResponseEnum {
        device_return_error_data,
        response_getMachineInfo,
        userInfo,
        workoutSummary,
        keyPress,
        response_setUser,
        response_deleteUser,
        response_startWorkout,
        response_setMyFirst5k,
        stopWorkout,
        response_stopWorkout,
        setCustomProgram,
        response_selectUser,
        response_customProgram,
        setCustomHRProgram,
        response_setCustomHRProgram,
        response_selectProgram,
        response_pauseWorkout,
        continueWorkout,
        response_setIncline,
        response_setResistance,
        response_setSpeed,
        response_changeWorkout,
        setPopupInfo,
        setMyFirst5k,
        timeout,
        safeKey,
        device_puaseWorkout,
        deviceContinueWorkout,
        device_startWorkout,
        device_workoutData,
        device_timeSync,
        response_setHeartValue;

    }

    public static enum deviceCommandEnum {
        set_user,
        delete_user,
        start_workout,
        stop_workout,
        pause_workout,
        continue_workout,
        change_workout,
        select_program,
        set_5k,
        set_custom_program,
        set_custom_hrp,
        set_incline,
        set_resistance,
        set_speed,
        get_machine_info,
        select_user,
        not_initialized;

    }

    public static final String[] machineVersion;
    public static final String[] polar;

    static {
        Enums.machineVersion = new String[]{"AFG-7.0AT", "AFG-7.2AT", "AFG-7.4AT", "AFG-7.8AT", "AFG-7.0AE", "AFG-7.2AE", "AFG-7.4AE", "AFG-7.8AE", "AFG-6.0AT", "AFG-6.2AT", "AFG-6.0AE", "AFG-6.2AE"};
        Enums.polar = new String[]{"Polar"};
    }
}
