package com.xpg.a.a;

import com.xpg.a.Enums.deviceCommandEnum;
import com.xpg.a.Enums.deviceResponseEnum;
import com.xpg.a.b.CustomProgram.a;
import com.xpg.a.b.CustomProgram.b;
import com.xpg.a.b.CustomProgram;
import com.xpg.a.b.DeviceCommand;
import com.xpg.a.b.MyFirst5k;
import com.xpg.a.b.UserSync;
import com.xpg.a.b.Workout;
import com.xpg.a.bleVersionEnum;
import com.xpg.a.c.LEBE_Int;
import java.util.ArrayList;
import java.util.List;

public class ReceiveData {
    public static bleVersionEnum bleVersion;
    public static boolean b;
    private deviceResponseEnum mDeviceResponse;
    private DeviceInfo mDeviceInfo;
    private UserSync mUserSync;
    private WorkoutSummary mWorkoutSummary;
    private CustomHRProgramReceive mCustomHRProgram;
    private StopWorkoutInfo mStopWorkoutInfo;
    private WorkoutData mWorkoutData;
    private CustomProgram customProgram;
    private Workout mWorkout;
    private int l;
    private int mResponseCodeMaybe;
    private int mPopupType;
    private int mDisappearTime;
    private deviceCommandEnum mDeviceCommand;
    private MyFirst5k q;

    static {
        ReceiveData.bleVersion = bleVersionEnum.BleVersion_First;
        ReceiveData.b = false;
    }

    public ReceiveData(byte[] msg) {
        byte workoutsCounter;
        WorkoutSummary workoutSummary;
        deviceResponseEnum deviceResponse;
        try {
            System.out.print("ReceiveData:in data");
            int v2 = 0;
            if(msg.length == 4 && msg[0] == 101) {
                this.mDeviceResponse = deviceResponseEnum.timeout;
                this.mDeviceCommand = DeviceCommand.timeOutMsg(msg[1], msg[2], msg[3]);
                return;
            }

            byte msg5 = msg[5];
            if(msg[5] == 1 && msg[4] == 3) {
                this.mDeviceResponse = deviceResponseEnum.response_selectUser;
            }

            if(msg5 == 0) {
                this.parseDeviceResponseSub(msg);
                return;
            }

            if(msg5 == 20) {
                if(msg[4] == 3) {
                    deviceResponse = deviceResponseEnum.device_timeSync;
                    this.mDeviceResponse = deviceResponse;
                    return;
                }

                if(msg[4] == 1) {
                    this.mDeviceResponse = deviceResponseEnum.stopWorkout;
                    this.stopWorkoutInfo(msg, 10);
                    ReceiveData.b = false;
                    return;
                    this.parseDeviceResponseSub(msg);
                    return;
                }
            }
            else {
                switch(msg5) {
                    case 2: {
                        goto label_586;
                    }
                    case 3: {
                        goto label_678;
                    }
                }

                switch(msg5) {
                    case 17: {
                        this.mDeviceResponse = deviceResponseEnum.keyPress;
                        this.l = msg[10] & 0xFF;
                        return;
                    }
                    case 18: {
                        this.mDeviceResponse = deviceResponseEnum.device_workoutData;
                        this.mWorkoutData = new WorkoutData();
                        this.mWorkoutData.setUserExternalId(LEBE_Int.toString(msg, 10, 46));
                        this.mWorkoutData.setProgramType(msg[46] & 0xFF);
                        this.mWorkoutData.setWorkoutState(msg[0x2F] & 0xFF);
                        this.mWorkoutData.setWorkoutStage(msg[0x30] & 0xFF);
                        this.mWorkoutData.setStageTime(LEBE_Int.decode(msg[50], msg[49]));
                        this.mWorkoutData.setWorkoutTime(LEBE_Int.decode(msg[52], msg[51]));
                        this.mWorkoutData.setWarmUpTime(LEBE_Int.decode(msg[54], msg[53]));
                        this.mWorkoutData.setCoolDownTime(LEBE_Int.decode(msg[56], msg[55]));
                        this.mWorkoutData.setTimeInState(LEBE_Int.decode(msg[58], msg[57]));
                        this.mWorkoutData.setTimeInStage(LEBE_Int.decode(msg[60], msg[59]));
                        this.mWorkoutData.setMPH(LEBE_Int.decode(msg[62], msg[61]));
                        this.mWorkoutData.setIncline(LEBE_Int.decode(msg[0x40], msg[0x3F]));
                        this.mWorkoutData.setAveragePace(LEBE_Int.decode(msg[66], msg[65]));
                        this.mWorkoutData.setTotalCalories(LEBE_Int.decode(msg[68], msg[67]));
                        this.mWorkoutData.setCaloriesPerHour(LEBE_Int.decode(msg[70], msg[69]));
                        this.mWorkoutData.setMets(LEBE_Int.decode(msg[72], msg[71]));
                        this.mWorkoutData.setWatts(LEBE_Int.decode(msg[74], msg[73]));
                        this.mWorkoutData.setMiles(LEBE_Int.decode(msg[76], msg[75]));
                        this.mWorkoutData.setHeartRate(LEBE_Int.decode(msg[78], msg[77]));
                        this.mWorkoutData.setAverageHeartRate(LEBE_Int.decode(msg[80], msg[0x4F]));
                        this.mWorkoutData.setRPM(LEBE_Int.decode(msg[82], msg[81]));
                        this.mWorkoutData.setProgramLevel(LEBE_Int.decode(msg[84], msg[83]));
                        this.mWorkoutData.setResistanceLevel(LEBE_Int.decode(msg[86], msg[85]));
                        this.mWorkoutData.setTargetHeartRate(LEBE_Int.decode(msg[88], msg[87]));
                        this.mWorkoutData.setTargetWatts(LEBE_Int.decode(msg[90], msg[89]));
                        this.mWorkoutData.setNextIncline(LEBE_Int.decode(msg[92], msg[91]));
                        this.mWorkoutData.setNextSpeed(LEBE_Int.decode(msg[94], msg[93]));
                        this.mWorkoutData.setNextResistance(msg[0x5F] & 0xFF);
                        this.mWorkoutData.setTotalTime(LEBE_Int.decode(msg[97], msg[0x60]));
                        if(msg.length > 98) {
                            this.mWorkoutData.setSprintCount(msg[98] & 0xFF);
                            return;
                        label_586:
                            if(msg[4] == 1) {
                                this.mDeviceResponse = deviceResponseEnum.response_getMachineInfo;
                                this.mDeviceInfo = new DeviceInfo();
                                this.mDeviceInfo.setMachineType(msg[11] & 0xFF);
                                this.mDeviceInfo.setModelType(msg[12] & 0xFF);
                                this.mDeviceInfo.setSecuritySwitch(msg[0x8D] & 0xFF);
                                this.mDeviceInfo.setRunStatus(msg[0x8E] & 0xFF);
                                return;
                            }

                            if(msg[4] == 3) {
                                ReceiveData.b = true;
                                this.mDeviceResponse = deviceResponseEnum.device_startWorkout;
                                this.mWorkout = new Workout();
                                this.mWorkout.s_16_17(LEBE_Int.decode(msg[17], msg[16]));
                                this.mWorkout.b_26(msg[26] & 0xFF);
                                this.mWorkout.b_23(msg[23] & 0xFF);
                                this.mWorkout.b_18(msg[18] & 0xFF);
                                this.mWorkout.s_10_11(LEBE_Int.decode(msg[11], msg[10]));
                                this.mWorkout.s_21_22_maybe_incline(LEBE_Int.decode(msg[22], msg[21]));
                                this.mWorkout.s_19_20_maybe_speed(LEBE_Int.decode(msg[20], msg[19]));
                                this.mWorkout.s_24_25(LEBE_Int.decode(msg[25], msg[24]));
                                this.mWorkout.s_14_15(LEBE_Int.decode(msg[15], msg[14]));
                                this.mWorkout.s_12_13(LEBE_Int.decode(msg[13], msg[12]));
                                return;
                            label_678:
                                deviceResponse = (msg[10] & 0xFF) == 1 ? deviceResponseEnum.deviceContinueWorkout : deviceResponseEnum.device_puaseWorkout;
                                this.mDeviceResponse = deviceResponse;
                                return;
                            }
                        }

                        return;
                    }
                    default: {
                        switch(msg5) {
                            case 22: {
                                this.mDeviceResponse = deviceResponseEnum.userInfo;
                                bleVersionEnum bleVersion = LEBE_Int.decode(msg[7], msg[6]) == 731 ? bleVersionEnum.BleVersion_FITBIT : bleVersionEnum.BleVersion_First;
                                ReceiveData.bleVersion = bleVersion;
                                this.mUserSync = new UserSync();
                                this.mUserSync.setUserSlot(msg[10] & 0xFF);
                                this.mUserSync.setUserName(LEBE_Int.toString(msg, 11, 65));
                                this.mUserSync.setUserWeight(LEBE_Int.decode(msg[77], msg[76]));
                                this.mUserSync.setUserBirthYear(LEBE_Int.decode(msg[0x4F], msg[78]));
                                this.mUserSync.setUserBirthMonth(msg[80] & 0xFF);
                                this.mUserSync.setUserBirthDay(msg[81] & 0xFF);
                                this.mUserSync.setUnits(msg[82] & 0xFF);
                                this.mUserSync.setCustomProgramCRC(LEBE_Int.decode(msg[84], msg[83]));
                                this.mUserSync.setCustomHeartrateCRC(LEBE_Int.decode(msg[86], msg[85]));
                                this.mUserSync.setMyFirst5kWeek(msg[87] & 0xFF);
                                this.mUserSync.setMyFirst5kWorkout(msg[88] & 0xFF);
                                this.mUserSync.setMyFirst5kWalkSpeed(msg[89] & 0xFF);
                                this.mUserSync.setMyFirst5kJogSpeed(msg[90] & 0xFF);
                                this.mUserSync.setMyFirst5kResetCounter(LEBE_Int.decode(msg[92], msg[91]));
                                this.mUserSync.setMMFTokenId(LEBE_Int.toString(msg, 93, 40));
                                this.mUserSync.setMFPTokenId(LEBE_Int.toString(msg, 0x85, 320));
                                if(ReceiveData.bleVersion == bleVersionEnum.BleVersion_FITBIT) {
                                    this.mUserSync.setFitbitToken(LEBE_Int.toString(msg, 453, 273));
                                    return;
                                }

                                return;
                            }
                            case 23: {
                                this.mDeviceResponse = deviceResponseEnum.setMyFirst5k;
                                this.q = new MyFirst5k();
                                this.q.setWeek(msg[11] & 0xFF);
                                this.q.setWorkout(msg[12] & 0xFF);
                                this.q.setWalkSpeed(msg[13] & 0xFF);
                                this.q.setJogSpeed(msg[14] & 0xFF);
                                this.q.setResetCount(LEBE_Int.decode(msg[16], msg[15]));
                                return;
                            }
                            case 24: {
                                this.mDeviceResponse = deviceResponseEnum.setCustomProgram;
                                this.customProgram = new CustomProgram();
                                ArrayList v0_1 = new ArrayList();
                                ArrayList v1 = new ArrayList();
                                this.customProgram.c(msg[12] & 0xFF);
                                this.customProgram.b(msg[11] & 0xFF);
                                this.customProgram.a(msg[13] & 0xFF);
                                this.customProgram.d(msg[10] & 0xFF);
                                int v3;
                                for(v3 = 0; v3 < 16; ++v3) {
                                    CustomProgram v5_1 = this.customProgram;
                                    v5_1.getClass();
                                    b v4 = new b(v5_1);
                                    int v5_2 = v3 * 5;
                                    v4.a(LEBE_Int.decode(msg[v5_2 + 15], msg[v5_2 + 14]));
                                    v4.b(LEBE_Int.decode(msg[v5_2 + 17], msg[v5_2 + 16]));
                                    v4.c(msg[v5_2 + 18] & 0xFF);
                                    v0_1.add(v4);
                                }

                                while(v2 < 16) {
                                    CustomProgram v4_1 = this.customProgram;
                                    v4_1.getClass();
                                    a v3_1 = new a(v4_1);
                                    int v4_2 = v2 * 5;
                                    v3_1.a(LEBE_Int.decode(msg[v4_2 + 0x5F], msg[v4_2 + 94]));
                                    v3_1.b(LEBE_Int.decode(msg[v4_2 + 97], msg[v4_2 + 0x60]));
                                    v3_1.c(msg[v4_2 + 98] & 0xFF);
                                    v1.add(v3_1);
                                    ++v2;
                                }

                                this.customProgram.b(v1);
                                this.customProgram.a(v0_1);
                                return;
                            }
                            case 25: {
                                this.mDeviceResponse = deviceResponseEnum.setCustomHRProgram;
                                this.mCustomHRProgram = new CustomHRProgramReceive();
                                this.mCustomHRProgram.setUserId(msg[10] & 0xFF);
                                this.mCustomHRProgram.setTotalTime(LEBE_Int.decode(msg[12], msg[11]));
                                this.mCustomHRProgram.a(this.b(msg));
                                return;
                            }
                            case 26: {
                                this.mDeviceResponse = deviceResponseEnum.workoutSummary;
                                this.mWorkoutSummary = new WorkoutSummary();
                                this.mWorkoutSummary.setUserName(LEBE_Int.toString(msg, 10, 65));
                                this.mWorkoutSummary.setUserId(msg[75] & 0xFF);
                                this.mWorkoutSummary.setMMFTokenId(LEBE_Int.toString(msg, 76, 40));
                                this.mWorkoutSummary.setMFPTokenId(LEBE_Int.toString(msg, 0x74, 320));
                                if(ReceiveData.bleVersion == bleVersionEnum.BleVersion_FITBIT) {
                                    this.mWorkoutSummary.setFitbitToken(LEBE_Int.toString(msg, 436, 273));
                                    this.mWorkoutSummary.setMFPUserId(LEBE_Int.toString(msg, 709, 15));
                                    this.mWorkoutSummary.setWorkoutsCounter(msg[724] & 0xFF);
                                    System.out.println("WorkoutsCounter:fitbit" + (msg[724] & 0xFF));
                                    workoutSummary = this.mWorkoutSummary;
                                    workoutsCounter = msg[724];
                                }
                                else {
                                    this.mWorkoutSummary.setMFPUserId(LEBE_Int.toString(msg, 436, 15));
                                    this.mWorkoutSummary.setWorkoutsCounter(msg[451] & 0xFF);
                                    System.out.println("WorkoutsCounter:first" + (msg[451] & 0xFF));
                                    workoutSummary = this.mWorkoutSummary;
                                    workoutsCounter = msg[451];
                                }

                                workoutSummary.setWorkoutInfoList(this.parseWorkoutInfoList(msg, workoutsCounter & 0xFF));
                                return;
                            }
                            case 27: {
                                break;
                            }
                            default: {
                                return;
                            }
                        }

                        this.mDeviceResponse = deviceResponseEnum.setPopupInfo;
                        this.mPopupType = msg[10] & 0xFF;
                        this.mDisappearTime = msg[11] & 0xFF;
                        return;
                    }
                }
            }
        }
        catch(Exception unused_ex) {
            this.mDeviceResponse = deviceResponseEnum.device_return_error_data;
        }
    }

    private void parseDeviceResponseSub(byte[] msg) {
        byte msg11;
        switch(msg[10]) {
            case 1: {
                this.mDeviceResponse = deviceResponseEnum.response_selectUser;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 2: {
                this.mDeviceResponse = deviceResponseEnum.response_startWorkout;
                this.mResponseCodeMaybe = msg[11] & 0xFF;
                ReceiveData.b = true;
                return;
            }
            case 3: {
                this.mResponseCodeMaybe = msg[11] & 0xFF;
                this.mDeviceResponse = this.mResponseCodeMaybe == 0 || this.mResponseCodeMaybe == 2 ? deviceResponseEnum.response_pauseWorkout : deviceResponseEnum.continueWorkout;
                return;
            }
            case 4: {
                this.mDeviceResponse = deviceResponseEnum.response_changeWorkout;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 5: {
                this.mDeviceResponse = deviceResponseEnum.response_setSpeed;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 6: {
                this.mDeviceResponse = deviceResponseEnum.response_setIncline;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 7: {
                this.mDeviceResponse = deviceResponseEnum.response_setResistance;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 15: {
                this.mDeviceResponse = deviceResponseEnum.response_setUser;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 16: {
                this.mDeviceResponse = deviceResponseEnum.response_selectProgram;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 18: {
                this.mDeviceResponse = deviceResponseEnum.response_deleteUser;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 19: {
                this.mDeviceResponse = deviceResponseEnum.response_setHeartValue;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 20: {
                this.mDeviceResponse = deviceResponseEnum.response_stopWorkout;
                this.stopWorkoutInfo(msg, 11);
                return;
            }
            case 23: {
                this.mDeviceResponse = deviceResponseEnum.response_setMyFirst5k;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 24: {
                this.mDeviceResponse = deviceResponseEnum.response_customProgram;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            case 25: {
                this.mDeviceResponse = deviceResponseEnum.response_setCustomHRProgram;
                msg11 = msg[11];
                this.mResponseCodeMaybe = msg11 & 0xFF;
                return;
            }
            default: {
                return;
            }
        }
    }

    private void stopWorkoutInfo(byte[] arg4, int arg5) {
        this.mStopWorkoutInfo = new StopWorkoutInfo();
        this.mStopWorkoutInfo.a(this.parseWorkoutInfo(arg4, arg5));
        int v5 = arg5 + 19;
        this.mStopWorkoutInfo.a(LEBE_Int.decode(arg4[v5 + 1], arg4[v5]));
        this.mStopWorkoutInfo.b(arg4[v5 + 2] & 0xFF);
        this.mStopWorkoutInfo.c(arg4[v5 + 3] & 0xFF);
        this.mStopWorkoutInfo.d(arg4[v5 + 4] & 0xFF);
        this.mStopWorkoutInfo.e(arg4[v5 + 5] & 0xFF);
        this.mStopWorkoutInfo.f(arg4[17] & 0xFF);
        this.mStopWorkoutInfo.g(LEBE_Int.decode(arg4[11], arg4[10]));
    }

    public deviceResponseEnum getDeviceResponse() {
        return this.mDeviceResponse;
    }

    private List parseWorkoutInfoList(byte[] msg, int workoutsCounter) {
        ArrayList workoutInfoList = new ArrayList();
        int i;
        for(i = 0; i < workoutsCounter; ++i) {
            workoutInfoList.add(this.parseWorkoutInfo(msg, i * 19 + 452));
        }

        return workoutInfoList;
    }

    private Segment[] b(byte[] arg7) {
        Segment[] v0 = new Segment[4];
        int v1;
        for(v1 = 0; v1 < v0.length; ++v1) {
            v0[v1] = new Segment();
            int v2 = v1 * 4 + 13;
            v0[v1].setAge(((int)arg7[v2]));
            v0[v1].setSegmentTime(LEBE_Int.decode(arg7[v2 + 2], arg7[v2 + 1]));
            v0[v1].setTargetHR(arg7[v2 + 3] & 0xFF);
        }

        return v0;
    }

    public DeviceInfo getMachineInfo() {
        return this.mDeviceInfo;
    }

    private WorkoutListMember parseWorkoutInfo(byte[] msg, int start) {
        WorkoutListMember v0 = new WorkoutListMember();
        v0.setTime(LEBE_Int.decode(msg[start + 1], msg[start]));
        v0.setCalories(LEBE_Int.decode(msg[start + 3], msg[start + 2]));
        v0.setDistance(LEBE_Int.decode(msg[start + 5], msg[start + 4]));
        v0.setMaxSpeed(msg[start + 6] & 0xFF);
        v0.setAverageSpeed(msg[start + 7] & 0xFF);
        v0.setMaxHR(msg[start + 8] & 0xFF);
        v0.setAverageHR(msg[start + 9] & 0xFF);
        v0.h(msg[start + 10] & 0xFF);
        v0.setUnits(msg[start + 11] & 0xFF);
        v0.setStartYear(LEBE_Int.decode(msg[start + 13], msg[start + 12]));
        v0.setStartMonth(msg[start + 14] & 0xFF);
        v0.setStartDay(msg[start + 15] & 0xFF);
        v0.setStartHour(msg[start + 16] & 0xFF);
        v0.setStartMinute(msg[start + 17] & 0xFF);
        v0.setStartSecond(msg[start + 18] & 0xFF);
        return v0;
    }

    public UserSync getUserSync() {
        return this.mUserSync;
    }

    public WorkoutSummary getWorkoutSummary() {
        return this.mWorkoutSummary;
    }

    public CustomHRProgramReceive getCustomHRProgram() {
        return this.mCustomHRProgram;
    }

    public StopWorkoutInfo getStopWorkoutInfo() {
        return this.mStopWorkoutInfo;
    }

    public WorkoutData getWorkoutData() {
        return this.mWorkoutData;
    }

    public int h() {
        return this.l;
    }

    public int getResponseCode() {
        return this.mResponseCodeMaybe;
    }

    public int getPopupType() {
        return this.mPopupType;
    }

    public int getDisappearTime() {
        return this.mDisappearTime;
    }

    public Workout getWorkout() {
        return this.mWorkout;
    }

    public deviceCommandEnum getDeviceCommand() {
        return this.mDeviceCommand;
    }

    public CustomProgram getCustomProgram() {
        return this.customProgram;
    }

    public MyFirst5k getMyFirst5k() {
        return this.q;
    }

    @Override
    public String toString() {
        return "ReceiveData{dataType=" + this.mDeviceResponse + ", deviceInfo=" + this.mDeviceInfo + ", workoutData=" + this.mWorkoutData + '}';
    }
}
