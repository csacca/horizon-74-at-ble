package com.xpg.a.b;

import com.xpg.a.Enums.deviceCommandEnum;
import com.xpg.a.a.ReceiveData;
import com.xpg.a.bleVersionEnum;
import com.xpg.a.c.CRC;
import com.xpg.a.c.LEBE_Int;
import java.io.PrintStream;
import java.util.List;

public class DeviceCommand {
    private static short a = 1;

    static {
    }

    public static deviceCommandEnum timeOutMsg(byte arg5, byte arg6, byte arg7) {
        deviceCommandEnum v0 = deviceCommandEnum.not_initialized;
        System.out.println("SDK_log: TimeOut");
        System.out.println(((int)arg5) + ": " + ((int)arg6) + " :" + ((int)arg7));
        if(arg5 == 1) {
            if(arg6 != 20) {
                switch(arg6) {
                    case 1: {
                        return deviceCommandEnum.set_user;
                    }
                    case 2: {
                        break;
                    }
                    default: {
                        switch(arg6) {
                            case 23: {
                                return deviceCommandEnum.set_5k;
                            }
                            case 24: {
                                return deviceCommandEnum.set_custom_program;
                            }
                            case 25: {
                                return deviceCommandEnum.set_custom_hrp;
                            }
                        }

                        return v0;
                    }
                }

                return deviceCommandEnum.get_machine_info;
            }

            return deviceCommandEnum.stop_workout;
        }

        if(arg5 == 2) {
            if(arg6 == 16) {
                return deviceCommandEnum.select_program;
            }

            return arg6 == 18 ? deviceCommandEnum.delete_user : v0;
        }

        if(arg5 == 3) {
            if(arg6 != 16) {
                if(arg6 != 18) {
                    switch(arg6) {
                        case 1: {
                            return deviceCommandEnum.select_user;
                        }
                        case 2: {
                            return deviceCommandEnum.start_workout;
                        }
                        case 3: {
                            int v5 = arg7 & 0xFF;
                            return v5 != 1 || v5 != 3 ? deviceCommandEnum.pause_workout : deviceCommandEnum.continue_workout;
                        }
                        case 4: {
                            return deviceCommandEnum.change_workout;
                        }
                        case 5: {
                            return deviceCommandEnum.set_speed;
                        }
                        case 6: {
                            return deviceCommandEnum.set_incline;
                        }
                        case 7: {
                            break;
                        }
                        default: {
                            return v0;
                        }
                    }

                    return deviceCommandEnum.set_resistance;
                }

                return deviceCommandEnum.delete_user;
            }

            return deviceCommandEnum.select_program;
        }

        return v0;
    }

    public static byte[] stopWorkoutMsg() {
        ReceiveData.b = false;
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DeviceCommand.addHeader(v0, 1, 20);
        return v0;
    }

    public static byte[] setResistanceMsg(byte resistance, int arg3) {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, resistance, ((byte)arg3)};
        DeviceCommand.addHeader(v0, 3, 7);
        return v0;
    }

    public static byte[] setSpeedMsg(byte msg10, short speed, int msg13) {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, msg10, LEBE_Int.encode(speed)[0], LEBE_Int.encode(speed)[1], ((byte)msg13)};
        DeviceCommand.addHeader(v0, 3, 5);
        return v0;
    }

    public static byte[] deleteUserDataMsg(int arg2) {
        return DeviceCommand.addHeader(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ((byte)arg2)}, 3, 18);
    }

    public static byte[] msg_msg5_0(int msg10, int msg11, int msg4) {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ((byte)msg10), ((byte)msg11)};
        DeviceCommand.addHeader(v0, ((byte)msg4), 0);
        return v0;
    }

    public static byte[] timeSyncMsg(int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, LEBE_Int.encode(arg3)[0], LEBE_Int.encode(arg3)[1], ((byte)arg4), ((byte)arg5), ((byte)arg6), ((byte)arg7), ((byte)arg8), ((byte)arg9)};
        DeviceCommand.addHeader(v0, 3, 20);
        return v0;
    }

    public static byte[] setCustomHRProgramMsg(CustomHRProgram arg5) {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ((byte)arg5.a()), LEBE_Int.encode(arg5.b())[0], LEBE_Int.encode(arg5.b())[1], ((byte)arg5.c()), LEBE_Int.encode(arg5.d())[0], LEBE_Int.encode(arg5.d())[1], ((byte)arg5.e()), ((byte)arg5.f()), LEBE_Int.encode(arg5.g())[0], LEBE_Int.encode(arg5.g())[1], ((byte)arg5.h()), ((byte)arg5.i()), LEBE_Int.encode(arg5.j())[0], LEBE_Int.encode(arg5.j())[1], ((byte)arg5.k()), ((byte)arg5.l()), LEBE_Int.encode(arg5.m())[0], LEBE_Int.encode(arg5.m())[1], ((byte)arg5.n())};
        DeviceCommand.addHeader(v0, 1, 25);
        return v0;
    }

    public static byte[] setCustomProgramMsg(CustomProgram arg9) {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ((byte)arg9.getUserId()), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        List v1 = arg9.setCustom1();
        List v2 = arg9.setCustom2();
        v0[11] = (byte)arg9.getTimeSegmentNumber();
        v0[12] = (byte)arg9.getDistanceSegmentNumber();
        v0[13] = (byte)arg9.getUnit();
        int v3;
        for(v3 = 0; v3 < v1.size(); ++v3) {
            b v4 = (b)v1.get(v3);
            int v6 = v3 * 5;
            v0[v6 + 14] = LEBE_Int.encode(v4.a())[0];
            v0[v6 + 15] = LEBE_Int.encode(v4.a())[1];
            v0[v6 + 16] = LEBE_Int.encode(v4.b())[0];
            v0[v6 + 17] = LEBE_Int.encode(v4.b())[1];
            v0[v6 + 18] = (byte)v4.c();
        }

        int v1_1;
        for(v1_1 = 0; v1_1 < v2.size(); ++v1_1) {
            a v3_1 = (a)v2.get(v1_1);
            int v4_1 = v1_1 * 5 + 92;
            v0[v4_1 + 2] = LEBE_Int.encode(v3_1.a())[0];
            v0[v4_1 + 3] = LEBE_Int.encode(v3_1.a())[1];
            v0[v4_1 + 4] = LEBE_Int.encode(v3_1.b())[0];
            v0[v4_1 + 5] = LEBE_Int.encode(v3_1.b())[1];
            v0[v4_1 + 6] = (byte)v3_1.c();
        }

        DeviceCommand.addHeader(v0, 1, 24);
        return v0;
    }

    public static byte[] startWorkoutMsg(Workout arg5) {
        System.err.println("SDK_log:startWorkout");
        byte[] msg = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int v2 = 0;
        msg[10] = LEBE_Int.encode(arg5.a())[0];
        msg[11] = LEBE_Int.encode(arg5.a())[1];
        msg[12] = LEBE_Int.encode(arg5.b())[0];
        msg[13] = LEBE_Int.encode(arg5.b())[1];
        msg[14] = LEBE_Int.encode(arg5.c())[0];
        msg[15] = LEBE_Int.encode(arg5.c())[1];
        msg[16] = LEBE_Int.encode(arg5.d())[0];
        msg[17] = LEBE_Int.encode(arg5.d())[1];
        msg[18] = (byte)arg5.e();
        msg[19] = LEBE_Int.encode(arg5.f())[0];
        msg[20] = LEBE_Int.encode(arg5.f())[1];
        msg[21] = LEBE_Int.encode(arg5.g())[0];
        msg[22] = LEBE_Int.encode(arg5.g())[1];
        msg[23] = (byte)arg5.h();
        msg[24] = LEBE_Int.encode(arg5.i())[0];
        msg[25] = LEBE_Int.encode(arg5.i())[1];
        msg[26] = (byte)arg5.j();
        DeviceCommand.addHeader(msg, 3, 2);
        System.out.print("SDK_log:<");
        while(v2 < msg.length) {
            System.out.print(((int)msg[v2]));
            ++v2;
            if(v2 % 4 != 0) {
                continue;
            }

            System.out.print(" ");
        }

        return msg;
    }

    public static byte[] setMyFirst5K(MyFirst5k arg3) {
        return DeviceCommand.addHeader(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ((byte)arg3.a()), ((byte)arg3.getWeek()), ((byte)arg3.getWorkout()), ((byte)arg3.getWalkSpeed()), ((byte)arg3.getJogSpeed()), LEBE_Int.encode(arg3.getResetCount())[0], LEBE_Int.encode(arg3.getResetCount())[1]}, 1, 23);
    }

    public static byte[] setUser(UserInfo user) {
        int v8_1;
        StringBuilder v2_5;
        PrintStream v1_1;
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("SDK_log:set User mmf" + user.mmfTokenId());
        System.out.println("SDK_log:set User mfp t" + user.mfpTokenId());
        System.out.println("SDK_log:set User mfp u" + user.mfpUserId());
        v0[10] = (byte)user.a();
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < 14; ++v2) {
            v0[v2 + 11] = 0;
        }

        v0[29] = (byte)user.b();
        v0[30] = LEBE_Int.encode(user.c())[0];
        v0[0x1F] = LEBE_Int.encode(user.c())[1];
        v0[0x20] = (byte)user.d();
        v0[33] = LEBE_Int.encode(user.e())[0];
        v0[34] = LEBE_Int.encode(user.e())[1];
        v0[35] = (byte)user.f();
        v0[36] = (byte)user.g();
        v0[37] = (byte)user.h();
        v0[38] = (byte)user.i();
        byte[] v2_1 = user.userName().getBytes();
        if(v2_1 != null) {
            int v3;
            for(v3 = 0; v3 < v2_1.length; ++v3) {
                if(v3 >= 65) {
                    System.out.print("Gizwits==BLe==TreadmillSDK :userName超过65位，SDK只取前65位");
                    break;
                }

                v0[v3 + 39] = v2_1[v3];
            }
        }

        byte[] v2_2 = user.mmfTokenId().getBytes();
        if(v2_2 != null) {
            int v3_1;
            for(v3_1 = 0; v3_1 < v2_2.length; ++v3_1) {
                if(v3_1 >= 40) {
                    System.out.print("Gizwits==BLe==TreadmillSDK :mmfTokenid超过40位，SDK只取前40位");
                    break;
                }

                v0[v3_1 + 106] = v2_2[v3_1];
            }
        }

        byte[] v2_3 = user.mfpTokenId().getBytes();
        if(v2_3 != null) {
            int v3_2;
            for(v3_2 = 0; v3_2 < v2_3.length; ++v3_2) {
                if(v3_2 >= 320) {
                    System.out.print("Gizwits==BLe==TreadmillSDK :mfpTokenid超过320位，SDK只取前320位");
                    break;
                }

                v0[v3_2 + 0x92] = v2_3[v3_2];
            }
        }

        if(ReceiveData.bleVersion == bleVersionEnum.BleVersion_FITBIT) {
            byte[] v2_4 = user.fitbitToken().getBytes();
            if(v2_4 != null) {
                int v3_3;
                for(v3_3 = 0; v3_3 < v2_4.length; ++v3_3) {
                    if(v3_3 >= 274) {
                        System.out.print("Gizwits==BLe==TreadmillSDK :fitbitToken超过273位，SDK只取前273位");
                        break;
                    }

                    v0[v3_3 + 466] = v2_4[v3_3];
                }
            }

            byte[] v8 = user.mfpUserId().getBytes();
            if(v8 == null) {
                return DeviceCommand.addHeader(v0, 1, 15);
            }

            while(v1 < v8.length) {
                if(v1 >= 15) {
                    v1_1 = System.out;
                    v2_5 = new StringBuilder();
                    v2_5.append("Gizwits==BLe==TreadmillSDK :mfpUserId超过15位，SDK只取前15位,实际上mfpUserId的长度是：");
                    v8_1 = v8.length;
                    v2_5.append(v8_1);
                    v1_1.print(v2_5.toString());
                    return DeviceCommand.addHeader(v0, 1, 15);
                }

                v0[v1 + 739] = v8[v1];
                ++v1;
            }
        }
        else {
            byte[] v8_2 = user.mfpUserId().getBytes();
            if(v8_2 == null) {
                return DeviceCommand.addHeader(v0, 1, 15);
            }

            while(v1 < v8_2.length) {
                if(v1 >= 15) {
                    v1_1 = System.out;
                    v2_5 = new StringBuilder();
                    v2_5.append("Gizwits==BLe==TreadmillSDK :mfpUserId超过15位，SDK只取前15位,实际上mfpUserId的长度是：");
                    v8_1 = v8_2.length;
                    v2_5.append(v8_1);
                    v1_1.print(v2_5.toString());
                    return DeviceCommand.addHeader(v0, 1, 15);
                }

                v0[v1 + 466] = v8_2[v1];
                ++v1;
            }
        }

        return DeviceCommand.addHeader(v0, 1, 15);
    }

    public static byte[] setUserInfoMsg(UserSync userInfo) {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ((byte)userInfo.getUserSlot()), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] v1 = userInfo.getUserName().getBytes();
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1.length; ++v3) {
            if(v3 >= 0x40) {
                System.out.print("Gizwits==BLe==TreadmillSDK :userName超过64位，SDK只取前64位");
                break;
            }

            v0[v3 + 11] = v1[v3];
            userInfo.setMyFirst5kWalkSpeed(2);
            userInfo.setCustomHeartrateCRC(12);
        }

        v0[76] = LEBE_Int.encode(userInfo.getUserWeight())[0];
        v0[77] = LEBE_Int.encode(userInfo.getUserWeight())[1];
        v0[78] = LEBE_Int.encode(userInfo.getUserBirthYear())[0];
        v0[0x4F] = LEBE_Int.encode(userInfo.getUserBirthYear())[1];
        v0[80] = (byte)userInfo.getUserBirthMonth();
        v0[81] = (byte)userInfo.getUserBirthday();
        v0[82] = (byte)userInfo.getUnits();
        v0[83] = LEBE_Int.encode(userInfo.getCustomProgramCRC())[0];
        v0[84] = LEBE_Int.encode(userInfo.getCustomProgramCRC())[1];
        v0[85] = LEBE_Int.encode(userInfo.getCustomHeartrateCRC())[0];
        v0[86] = LEBE_Int.encode(userInfo.getCustomHeartrateCRC())[1];
        v0[87] = (byte)userInfo.getMyFirst5kWeek();
        v0[88] = (byte)userInfo.getMyFirst5kWorkout();
        v0[89] = (byte)userInfo.getMyFirst5kWalkSpeed();
        v0[90] = (byte)userInfo.getMyFirst5kJogSpeed();
        v0[91] = LEBE_Int.encode(userInfo.getMyFirst5kResetCounter())[0];
        v0[92] = LEBE_Int.encode(userInfo.getMyFirst5kResetCounter())[1];
        byte[] v1_1 = userInfo.getMMFTokenId().getBytes();
        int v3_1;
        for(v3_1 = 0; v3_1 < v1_1.length; ++v3_1) {
            if(v3_1 >= 40) {
                System.out.print("Gizwits==BLe==TreadmillSDK :mmfTokenid超过40位，SDK只取前40位");
                break;
            }

            v0[v3_1 + 93] = v1_1[v3_1];
        }

        byte[] v1_2 = userInfo.getMFPTokenId().getBytes();
        int v3_2;
        for(v3_2 = 0; v3_2 < v1_2.length; ++v3_2) {
            if(v3_2 >= 320) {
                System.out.print("Gizwits==BLe==TreadmillSDK :mfpTokenid超过320位，SDK只取前320位");
                break;
            }

            v0[v3_2 + 0x85] = v1_2[v3_2];
        }

        if(ReceiveData.bleVersion == bleVersionEnum.BleVersion_FITBIT) {
            if(userInfo.getFitbitToken() != null) {
                byte[] v1_3 = userInfo.getFitbitToken().getBytes();
                if(v1_3 != null) {
                    int v3_3;
                    for(v3_3 = 0; v3_3 < v1_3.length; ++v3_3) {
                        if(v3_3 >= 274) {
                            System.out.print("Gizwits==BLe==TreadmillSDK :fitbitToken超过273位，SDK只取前273位");
                            break;
                        }

                        v0[v3_3 + 453] = v1_3[v3_3];
                    }
                }
            }

            byte[] v8 = userInfo.getMFP_UserId().getBytes();
            while(v2 < v8.length) {
                if(v2 < 15) {
                    v0[v2 + 726] = v8[v2];
                    ++v2;
                    continue;
                }

                System.out.print("Gizwits==BLe==TreadmillSDK :mfpUserId超过15位，SDK只取前15位");
                break;
            }
        }
        else {
            byte[] v8_1 = userInfo.getMFP_UserId().getBytes();
            while(v2 < v8_1.length) {
                if(v2 >= 15) {
                    System.out.print("Gizwits==BLe==TreadmillSDK :mfpUserId超过15位，SDK只取前15位");
                    break;
                }

                v0[v2 + 453] = v8_1[v2];
                ++v2;
            }
        }

        DeviceCommand.addHeader(v0, 1, 22);
        return v0;
    }

    public static byte[] setInclineMsg(short incline, int arg4) {
        byte[] msg = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, LEBE_Int.encode(incline)[0], LEBE_Int.encode(incline)[1], ((byte)arg4)};
        DeviceCommand.addHeader(msg, 3, 6);
        return msg;
    }

    private static byte[] addHeader(byte[] msg, byte msg_4, byte msg_5) {
        if(DeviceCommand.a > 0x7FFD) {
            DeviceCommand.a = 1;
        }

        msg[0] = 85;
        msg[1] = -86;
        msg[2] = 1;
        DeviceCommand.a = (short)(DeviceCommand.a + 1);
        msg[3] = 0;
        msg[4] = msg_4;
        msg[5] = msg_5;
        short msg_len = (short)(msg.length - 10);
        msg[6] = LEBE_Int.encode(msg_len)[0];
        msg[7] = LEBE_Int.encode(msg_len)[1];
        byte[] body = new byte[msg.length - 10];
        System.arraycopy(msg, 10, body, 0, body.length);
        int crc = CRC.getCRC(body, body.length);
        msg[8] = LEBE_Int.encode(crc)[0];
        msg[9] = LEBE_Int.encode(crc)[1];
        return msg;
    }

    public static byte[] pauseWorkoutMsg() {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DeviceCommand.addHeader(v0, 3, 3);
        return v0;
    }

    public static byte[] selectProgramMsg(int program) {
        return DeviceCommand.addHeader(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ((byte)program)}, 3, 16);
    }

    public static byte[] changeWorkoutMsg(Workout arg5) {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, LEBE_Int.encode(arg5.a())[0], LEBE_Int.encode(arg5.a())[1], LEBE_Int.encode(arg5.b())[0], LEBE_Int.encode(arg5.b())[1], LEBE_Int.encode(arg5.c())[0], LEBE_Int.encode(arg5.c())[1], LEBE_Int.encode(arg5.d())[0], LEBE_Int.encode(arg5.d())[1]};
        DeviceCommand.addHeader(v0, 3, 4);
        return v0;
    }

    public static byte[] continueWorkoutMsg() {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        DeviceCommand.addHeader(v0, 3, 3);
        return v0;
    }

    public static byte[] setHeartValueMsg(int heartrate_value) {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ((byte)heartrate_value)};
        DeviceCommand.addHeader(v0, 3, 19);
        return v0;
    }

    public static byte[] getMachineInfoMsg() {
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DeviceCommand.addHeader(v0, 1, 2);
        return v0;
    }

    public static byte[] selectUserMsg(int arg2) {
        System.out.println(" ========= diao yong le select   =======");
        System.out.println(" ================");
        byte[] v0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ((byte)arg2)};
        DeviceCommand.addHeader(v0, 3, 1);
        return v0;
    }

    // String Decryptor: 20 succeeded, 0 failed
    private static byte[] e(int arg3) {
        byte[] v0 = new byte[arg3];
        int v2;
        for(v2 = 0; v2 < arg3; ++v2) {
            v0[v2] = 0;
        }

        return v0;
    }
}
