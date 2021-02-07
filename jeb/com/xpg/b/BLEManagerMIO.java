package com.xpg.b;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import apps.c.j;
import com.xpg.a.BLEDevice;
import com.xpg.d.a;
import com.xpg.d.logger_maybe;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

@SuppressLint({"NewApi"})
public class BLEManagerMIO {
    private final BluetoothGattCallback A;
    private BluetoothAdapter.LeScanCallback B;
    public static String a;
    protected static final UUID[] heartRateServiceUUIDString;
    public boolean c;
    private final int d;
    private byte[] e;
    private Context f;
    private interface_a g;
    private BluetoothManager h;
    private BluetoothAdapter i;
    private BluetoothGatt j;
    private BluetoothGattService mBluetoothGattService;
    private BluetoothGattCharacteristic l;
    private BluetoothGattCharacteristic m;
    private BluetoothGattDescriptor n;
    private static UUID heartRateServiceUUID;
    private static UUID heartRateMeasurementCharacteristicUUID;
    private static final UUID bodySensorLocationCharacteristicUUID;
    private static final UUID clientCharacteristicConfigurationDescriptorUUID;
    private static BLEManagerMIO s_instance;
    private boolean t;
    private int u;
    private List v;
    private int w;
    private LinkedList x;
    private int y;
    private Timer z;

    static {
        BLEManagerMIO.heartRateServiceUUID = UUID.fromString("0000180D-0000-1000-8000-00805F9B34FB");
        BLEManagerMIO.heartRateMeasurementCharacteristicUUID = UUID.fromString("00002A37-0000-1000-8000-805F9B34FB");
        BLEManagerMIO.bodySensorLocationCharacteristicUUID = UUID.fromString("00002A38-0000-1000-8000-805F9B34FB");
        BLEManagerMIO.clientCharacteristicConfigurationDescriptorUUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        BLEManagerMIO.heartRateServiceUUIDString = new UUID[]{UUID.fromString("0000180D-0000-1000-8000-00805f9b34fb")};
    }

    private BLEManagerMIO(Context arg3) {
        this.d = 20;
        this.t = false;
        this.u = 0;
        this.v = new ArrayList();
        this.w = -1;
        this.x = new LinkedList();
        this.y = 0;
        this.z = new Timer();
        this.A = new BluetoothGattCallback() {
            @Override  // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt arg5, BluetoothGattCharacteristic arg6) {
                String v3;
                int v0;
                byte[] v5 = arg6.getValue();
                if((arg6.getProperties() & 1) == 0) {
                    v0 = 17;
                    v3 = "Heart rate format UINT8.";
                }
                else {
                    v0 = 18;
                    v3 = "Heart rate format UINT16.";
                }

                logger_maybe.b("BLEManagerDevice", v3);
                int v6 = (int)arg6.getIntValue(v0, 1);
                if(v5 == null) {
                    logger_maybe.log("BLEManagerDevice", "返回数据为null");
                    return;
                }

                BLEManagerMIO.b(BLEManagerMIO.this, new byte[]{((byte)v6)});
            }

            @Override  // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicRead(BluetoothGatt arg1, BluetoothGattCharacteristic arg2, int arg3) {
                arg2.getValue();
            }

            @Override  // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt arg2, BluetoothGattCharacteristic arg3, int arg4) {
                super.onCharacteristicWrite(arg2, arg3, arg4);
                if(arg4 == 0) {
                    logger_maybe.log("BLEManagerDevice", "发送命令成功！是否发完：" + ((boolean)BLEManagerMIO.i(BLEManagerMIO.this) == null ? 1 : 0));
                    if(BLEManagerMIO.i(BLEManagerMIO.this) != null) {
                        byte[] v3 = BLEManagerMIO.i(BLEManagerMIO.this);
                        BLEManagerMIO.a(BLEManagerMIO.this, v3);
                        return;
                    }
                }
                else {
                    logger_maybe.a("BLEManagerDevice", "发送失败，错误信息为：error" + arg4);
                }
            }

            @Override  // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt arg1, int arg2, int arg3) {
                if(arg3 == 2) {
                    logger_maybe.log("BLEManagerDevice", "Connected to GATT server.");
                    logger_maybe.log("BLEManagerDevice", "Attempting to start service discovery:" + BLEManagerMIO.a(BLEManagerMIO.this).discoverServices());
                    return;
                }

                if(arg3 == 0) {
                    BLEManagerMIO.b(BLEManagerMIO.this).handleConnection(false, 2);
                    if(BLEManagerMIO.c(BLEManagerMIO.this)) {
                        BLEManagerMIO.a(BLEManagerMIO.this, false);
                        logger_maybe.log("BLEManagerDevice", "蓝牙中途断开了");
                        BLEManagerMIO.a(BLEManagerMIO.this, null);
                        BLEManagerMIO.a(BLEManagerMIO.this, null);
                        BLEManagerMIO.b(BLEManagerMIO.this, null);
                        BLEManagerMIO.a(BLEManagerMIO.this, null);
                        BLEManagerMIO.this.b();
                        return;
                    }

                    logger_maybe.log("BLEManagerDevice", "连接失败");
                    if(BLEManagerMIO.a(BLEManagerMIO.this) != null) {
                        BLEManagerMIO.a(BLEManagerMIO.this).close();
                    }

                    BLEManagerMIO.a(BLEManagerMIO.this, null);
                    BLEManagerMIO.a(BLEManagerMIO.this, null);
                    BLEManagerMIO.b(BLEManagerMIO.this, null);
                    BLEManagerMIO.a(BLEManagerMIO.this, null);
                }
            }

            @Override  // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt arg7, int arg8) {
                logger_maybe.log("BLEManagerDevice", "发现服务");
                if(arg8 == 0) {
                    logger_maybe.log("BLEManagerDevice", "发现服务成功");
                    String v7 = "uuids: ";
                    for(Object v0: BLEManagerMIO.a(BLEManagerMIO.this).getServices()) {
                        v7 = v7 + ((BluetoothGattService)v0).getUuid().toString() + " - ";
                    }

                    logger_maybe.log("BLEManagerDevice", v7);
                    if(BLEManagerMIO.d(BLEManagerMIO.this) != null) {
                        goto label_150;
                    }

                    int v7_1 = 0;
                label_36:
                    while(v7_1 < BLEManagerMIO.heartRateServiceUUIDString.length) {
                        BluetoothGattService v4 = BLEManagerMIO.a(BLEManagerMIO.this).getService(BLEManagerMIO.heartRateServiceUUIDString[v7_1]);
                        BLEManagerMIO.a(BLEManagerMIO.this, v4);
                        if(BLEManagerMIO.d(BLEManagerMIO.this) == null) {
                            ++v7_1;
                            continue label_36;
                        }

                        int v3 = 0;
                        while(true) {
                        label_49:
                            if(v3 >= BLEManagerMIO.d(BLEManagerMIO.this).getCharacteristics().size()) {
                                break label_36;
                            }

                            if(((BluetoothGattCharacteristic)BLEManagerMIO.d(BLEManagerMIO.this).getCharacteristics().get(v7_1)).getProperties() == 16) {
                                BLEManagerMIO.a(((BluetoothGattCharacteristic)BLEManagerMIO.d(BLEManagerMIO.this).getCharacteristics().get(v7_1)).getUuid());
                                logger_maybe.b("BLEManagerDevice", "找到Notify特征值：00002a37-0000-1000-8000-00805f9b34fb");
                                break label_36;
                            }

                            ++v3;
                            goto label_49;
                            ++v7_1;
                            continue label_36;
                        }
                    }

                    if(BLEManagerMIO.d(BLEManagerMIO.this) == null) {
                        BLEManagerMIO.e(BLEManagerMIO.this);
                        if(BLEManagerMIO.f(BLEManagerMIO.this) >= 2) {
                            goto label_193;
                        }

                        BluetoothGatt v0_1 = BLEManagerMIO.a(BLEManagerMIO.this);
                        BLEManagerMIO.a(BLEManagerMIO.this, v0_1);
                        logger_maybe.log("BLEManagerDevice", "找不到服务，清空蓝牙缓存，然后重新连接");
                        if(BLEManagerMIO.a(BLEManagerMIO.this) == null) {
                            BLEManagerMIO.this.a(BLEManagerMIO.a);
                            return;
                        }

                        BLEManagerMIO.a(BLEManagerMIO.this).close();
                        BLEManagerMIO.b(BLEManagerMIO.this, null);
                        BLEManagerMIO.this.a(BLEManagerMIO.a);
                        return;
                    }

                    logger_maybe.log("BLEManagerDevice", "连接成功");
                    BLEManagerMIO.b(BLEManagerMIO.this).handleConnection(true, 2);
                    BLEManagerMIO.a(BLEManagerMIO.this, true);
                    if(BLEManagerMIO.g(BLEManagerMIO.this) == null) {
                        logger_maybe.log("BLEManagerDevice", "mReadCharacteristic");
                        BluetoothGattCharacteristic v8_1 = BLEManagerMIO.d(BLEManagerMIO.this).getCharacteristic(BLEManagerMIO.c());
                        BLEManagerMIO.b(BLEManagerMIO.this, v8_1);
                        BLEManagerMIO.a(BLEManagerMIO.this).setCharacteristicNotification(BLEManagerMIO.g(BLEManagerMIO.this), true);
                    }

                    if(BLEManagerMIO.g(BLEManagerMIO.this) != null && BLEManagerMIO.h(BLEManagerMIO.this) == null) {
                        logger_maybe.log("BLEManagerDevice", "readDescriptor");
                        BluetoothGattDescriptor v8_2 = BLEManagerMIO.g(BLEManagerMIO.this).getDescriptor(BLEManagerMIO.d());
                        BLEManagerMIO.a(BLEManagerMIO.this, v8_2);
                        BLEManagerMIO.h(BLEManagerMIO.this).setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                        BLEManagerMIO.a(BLEManagerMIO.this).writeDescriptor(BLEManagerMIO.h(BLEManagerMIO.this));
                        return;
                    label_150:
                        if(BLEManagerMIO.d(BLEManagerMIO.this).getCharacteristic(BLEManagerMIO.e()) != null && BLEManagerMIO.d(BLEManagerMIO.this).getCharacteristic(BLEManagerMIO.c()) != null) {
                            logger_maybe.log("BLEManagerDevice", "连接成功！！！");
                            BLEManagerMIO.a(BLEManagerMIO.this, true);
                            BLEManagerMIO.b(BLEManagerMIO.this).handleConnection(true, 2);
                            return;
                        }

                        BLEManagerMIO.e(BLEManagerMIO.this);
                        if(BLEManagerMIO.f(BLEManagerMIO.this) < 2) {
                            BluetoothGatt v0_2 = BLEManagerMIO.a(BLEManagerMIO.this);
                            BLEManagerMIO.a(BLEManagerMIO.this, v0_2);
                            logger_maybe.log("BLEManagerDevice", "找不到特征值，清空蓝牙缓存，然后重新连接");
                            if(BLEManagerMIO.a(BLEManagerMIO.this) != null) {
                                BLEManagerMIO.a(BLEManagerMIO.this).close();
                                BLEManagerMIO.b(BLEManagerMIO.this, null);
                            }

                            BLEManagerMIO.this.a(BLEManagerMIO.a);
                            return;
                        }

                    label_193:
                        BLEManagerMIO.a(BLEManagerMIO.this, 0);
                        BLEManagerMIO.b(BLEManagerMIO.this).handleConnection(false, 2);
                        BLEManagerMIO.a(BLEManagerMIO.this, false);
                        BLEManagerMIO.this.b();
                        return;
                    }
                }
                else {
                    logger_maybe.d("BLEManagerDevice", "发现服务失败，错误信息为：" + arg8);
                }
            }
        };
        this.B = new BluetoothAdapter.LeScanCallback() {
            @Override  // android.bluetooth.BluetoothAdapter$LeScanCallback
            public void onLeScan(BluetoothDevice arg4, int arg5, byte[] arg6) {
                BLEManagerMIO.b(BLEManagerMIO.this).sendMessage(new BLEDevice(arg4.getName(), arg4.getAddress(), arg5, arg4), 2);
            }
        };
        this.f = arg3;
        this.h = (BluetoothManager)this.f.getSystemService("bluetooth");
        this.i = this.h.getAdapter();
    }

    static int a(BLEManagerMIO arg0, int arg1) {
        arg0.u = arg1;
        return arg1;
    }

    static BluetoothGatt a(BLEManagerMIO arg0) {
        return arg0.j;
    }

    static BluetoothGattCharacteristic a(BLEManagerMIO arg0, BluetoothGattCharacteristic arg1) {
        arg0.l = arg1;
        return arg1;
    }

    static BluetoothGattDescriptor a(BLEManagerMIO arg0, BluetoothGattDescriptor arg1) {
        arg0.n = arg1;
        return arg1;
    }

    static BluetoothGattService a(BLEManagerMIO arg0, BluetoothGattService arg1) {
        arg0.mBluetoothGattService = arg1;
        return arg1;
    }

    public static BLEManagerMIO get(Context arg1) {
        if(BLEManagerMIO.s_instance == null) {
            BLEManagerMIO.s_instance = new BLEManagerMIO(arg1);
        }

        return BLEManagerMIO.s_instance;
    }

    static UUID a(UUID arg0) {
        BLEManagerMIO.heartRateMeasurementCharacteristicUUID = arg0;
        return arg0;
    }

    static void a(BLEManagerMIO arg0, byte[] arg1) {
        arg0.a(arg1);
    }

    private void a(byte[] arg7) {
        BluetoothGattService v0 = this.mBluetoothGattService;
        if(v0 == null) {
            logger_maybe.log("BLEManagerDevice", "mBlzuetoothGattService is null");
        }
        else {
            this.l = v0.getCharacteristic(BLEManagerMIO.bodySensorLocationCharacteristicUUID);
            if(this.l != null && this.j != null) {
                logger_maybe.log("BLEManagerDevice", "data长度：" + arg7.length);
                if(arg7.length > 20) {
                    this.e = new byte[arg7.length - 20];
                    byte[] v0_1 = new byte[20];
                    int v2;
                    for(v2 = 0; v2 < arg7.length; ++v2) {
                        if(v2 < 20) {
                            v0_1[v2] = arg7[v2];
                        }
                        else {
                            this.e[v2 - 20] = arg7[v2];
                        }
                    }

                    this.l.setValue(v0_1);
                    this.j.writeCharacteristic(this.l);
                    a.a("sendData", v0_1);
                    return;
                }

                this.e = null;
                this.l.setValue(arg7);
                this.j.writeCharacteristic(this.l);
                a.a("sendData", arg7);
                return;
            }
        }
    }

    private boolean a(BluetoothGatt arg5) {
        try {
            Method v1 = arg5.getClass().getMethod("refresh");
            if(v1 != null) {
                return ((Boolean)v1.invoke(arg5)).booleanValue();
            }
        }
        catch(Exception unused_ex) {
            logger_maybe.e("BLEManagerDevice", "An exception occured while refreshing device");
        }

        return false;
    }

    static boolean a(BLEManagerMIO arg0, BluetoothGatt arg1) {
        return arg0.a(arg1);
    }

    static boolean a(BLEManagerMIO arg0, boolean arg1) {
        arg0.t = arg1;
        return arg1;
    }

    public void a(interface_a arg1) {
        this.g = arg1;
    }

    public boolean a() {
        if(this.i.isEnabled()) {
            if(this.c) {
                this.c = false;
                j.a("===", "==关闭MIO搜索==");
                this.i.stopLeScan(this.B);
                return true;
            }

            j.a("===", "==MIO搜索已经是关闭的==");
            return true;
        }

        j.a("===", "==蓝牙未打开，关闭不了MIO搜索==");
        this.c = false;
        return false;
    }

    public boolean a(int arg3) {
        if(this.i.isEnabled()) {
            if(!this.c) {
                j.a("===", "==打开MIO搜索==");
                this.c = true;
                return this.i.startLeScan(BLEManagerMIO.heartRateServiceUUIDString, this.B);
            }

            j.a("===", "==MIO搜索已经是开启的==");
            return this.c;
        }

        j.a("===", "==蓝牙未打开，打开不了MIO搜索==");
        this.c = false;
        return false;
    }

    public boolean a(String arg5) {
        String v1_2;
        this.t = false;
        if(this.i != null && arg5 != null) {
            BluetoothGatt v1 = this.j;
            if(v1 != null) {
                v1.close();
            }

            BluetoothDevice v1_1 = this.i.getRemoteDevice(arg5);
            if(v1_1 == null) {
                v1_2 = "Device not found.  Unable to connect.";
                logger_maybe.d("BLEManagerDevice", v1_2);
                return false;
            }

            this.j = v1_1.connectGatt(this.f, false, this.A);
            logger_maybe.b("BLEManagerDevice", "Trying to create a new connection.");
            BLEManagerMIO.a = arg5;
            return true;
        }
        else {
            v1_2 = "BluetoothAdapter not initialized or unspecified address.";
        }

        logger_maybe.d("BLEManagerDevice", v1_2);
        return false;
    }

    static BluetoothGatt b(BLEManagerMIO arg0, BluetoothGatt arg1) {
        arg0.j = arg1;
        return arg1;
    }

    static BluetoothGattCharacteristic b(BLEManagerMIO arg0, BluetoothGattCharacteristic arg1) {
        arg0.m = arg1;
        return arg1;
    }

    static interface_a b(BLEManagerMIO arg0) {
        return arg0.g;
    }

    static void b(BLEManagerMIO arg0, byte[] arg1) {
        arg0.b(arg1);
    }

    private void b(byte[] arg3) {
        this.g.receiveData(arg3, 2);
    }

    public void b() {
        this.t = false;
        logger_maybe.log("BLEManagerDevice", "disconnect");
        if(this.i != null) {
            BluetoothGatt v0 = this.j;
            if(v0 != null) {
                if(v0 != null) {
                    v0.close();
                }

                this.mBluetoothGattService = null;
                this.l = null;
                this.m = null;
                this.n = null;
                return;
            }
        }

        logger_maybe.d("BLEManagerDevice", "BluetoothAdapter not initialized");
    }

    static UUID c() {
        return BLEManagerMIO.heartRateMeasurementCharacteristicUUID;
    }

    static boolean c(BLEManagerMIO arg0) {
        return arg0.t;
    }

    static BluetoothGattService d(BLEManagerMIO arg0) {
        return arg0.mBluetoothGattService;
    }

    static UUID d() {
        return BLEManagerMIO.clientCharacteristicConfigurationDescriptorUUID;
    }

    static int e(BLEManagerMIO arg2) {
        int v0 = arg2.u;
        arg2.u = v0 + 1;
        return v0;
    }

    static UUID e() {
        return BLEManagerMIO.bodySensorLocationCharacteristicUUID;
    }

    static int f(BLEManagerMIO arg0) {
        return arg0.u;
    }

    static BluetoothGattCharacteristic g(BLEManagerMIO arg0) {
        return arg0.m;
    }

    static BluetoothGattDescriptor h(BLEManagerMIO arg0) {
        return arg0.n;
    }

    static byte[] i(BLEManagerMIO arg0) {
        return arg0.e;
    }
}
