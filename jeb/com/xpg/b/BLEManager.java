package com.xpg.b;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import apps.c.j;
import com.xpg.a.BLEDevice;
import com.xpg.a.c.CRC;
import com.xpg.a.c.LEBE_Int;
import com.xpg.d.a;
import com.xpg.d.logger_maybe;
import com.xtremeprog.shell.treadmillv2.AppsRunnerConnector;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@SuppressLint({"NewApi"})
public class BLEManager {
    class maybe_ble_message {
        final BLEManager a;
        private byte[] b;
        private int c;
        private int d;

        public maybe_ble_message(byte[] arg2, int arg3, int arg4) {
            this.b = arg2;
            this.c = arg3;
            this.d = arg4;
        }

        public byte[] data() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }
    }

    private int A;
    private int B;
    private Timer mTimer;
    private StringBuffer mRecievedMessageBuffer;
    private final BluetoothGattCallback mBluetoothGattCallback;
    private byte[] F;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    public static String mAddress;
    protected static final UUID[] heartRateServiceUUID;
    public boolean something_about_ble_scanning;
    private final int d;
    private byte[] remainingDataToWriteToCharacterisitic;
    private Context mContext;
    private interface_a g;
    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattService mBluetoothGattService;
    private BluetoothGattCharacteristic mWriteCharacteristic;
    private BluetoothGattCharacteristic mReadCharacteristic;
    private BluetoothGattDescriptor mBluetoothGattDescriptor;
    private static final UUID UUID_FFF0;
    private static final UUID UUID_FFF4;
    private static final UUID UUID_FFF3_maybe_write_characteristic;
    private static final UUID clientCharacteristicConfigurationDescriptorUUID;
    private static BLEManager s_instance;
    private boolean mIsConnected;
    private int u;
    private List v;
    private int w;
    private boolean x;
    private LinkedList maybe_messages_to_send;
    private int z;

    static {
        BLEManager.UUID_FFF0 = UUID.fromString("0000fff0-0000-1000-8000-00805f9b34fb");
        BLEManager.UUID_FFF4 = UUID.fromString("0000fff4-0000-1000-8000-00805f9b34fb");
        BLEManager.UUID_FFF3_maybe_write_characteristic = UUID.fromString("0000fff3-0000-1000-8000-00805f9b34fb");
        BLEManager.clientCharacteristicConfigurationDescriptorUUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        BLEManager.heartRateServiceUUID = new UUID[]{UUID.fromString("0000180D-0000-1000-8000-00805f9b34fb")};
    }

    private BLEManager(Context context) {
        this.d = 20;
        this.mIsConnected = false;
        this.u = 0;
        this.v = new ArrayList();
        this.w = -1;
        this.maybe_messages_to_send = new LinkedList();
        this.A = 0;
        this.mTimer = new Timer();
        this.mRecievedMessageBuffer = new StringBuffer();
        this.mBluetoothGattCallback = new BluetoothGattCallback() {
            @Override  // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
                byte[] returnData = characteristic.getValue();
                if(returnData == null) {
                    logger_maybe.log("BLEManager", "返回数据为null");
                    return;
                }

                BLEManager.s_appendDataReceivedMessages(BLEManager.this, returnData);
            }

            @Override  // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
                characteristic.getValue();
            }

            @Override  // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
                super.onCharacteristicWrite(gatt, characteristic, status);
                if(status == 0) {
                    if(characteristic.getValue() == null) {
                        logger_maybe.log("BLEManager", "发送命令不完整：" + status);
                    }

                    logger_maybe.log("BLEManager", "发送命令成功！是否发完：" + ((boolean)BLEManager.getRemainingDataToWriteToCharacteristic(BLEManager.this) == null ? 1 : 0));
                    if(BLEManager.getRemainingDataToWriteToCharacteristic(BLEManager.this) != null) {
                        byte[] data = BLEManager.getRemainingDataToWriteToCharacteristic(BLEManager.this);
                        BLEManager.s_sendDataToWriteChar0xFFF3(BLEManager.this, data);
                        return;
                    }
                }
                else {
                    if(BLEManager.getTimer(BLEManager.this) != null) {
                        BLEManager.getTimer(BLEManager.this).cancel();
                    }

                    logger_maybe.a("BLEManager", "发送失败，错误信息为：error" + status);
                }
            }

            @Override  // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
                if(newState == 2) {
                    logger_maybe.log("BLEManager", "Connected to GATT server.");
                    logger_maybe.log("BLEManager", "Attempting to start service discovery:" + BLEManager.getBluetoothGatt(BLEManager.this).discoverServices());
                    if(BLEManager.get_maybe_messages_to_send(BLEManager.this) != null) {
                        BLEManager.get_maybe_messages_to_send(BLEManager.this).clear();
                    }

                    if(BLEManager.getTimer(BLEManager.this) != null) {
                        BLEManager.getTimer(BLEManager.this).cancel();
                        return;
                    }
                }
                else if(newState == 0) {
                    BLEManager.f(BLEManager.this).handleConnection(false, 1);
                    if(BLEManager.s_isConnected(BLEManager.this)) {
                        BLEManager.setIsConnected(BLEManager.this, false);
                        logger_maybe.log("BLEManager", "蓝牙中途断开了");
                        BLEManager.this.disconnect();
                        return;
                    }

                    logger_maybe.log("BLEManager", "连接失败");
                    if(BLEManager.getBluetoothGatt(BLEManager.this) != null) {
                        BLEManager.getBluetoothGatt(BLEManager.this).close();
                    }

                    BLEManager.setService(BLEManager.this, null);
                    BLEManager.setCharacteristic(BLEManager.this, null);
                    BLEManager.setReadCharacteristic(BLEManager.this, null);
                    BLEManager.setDescriptor(BLEManager.this, null);
                }
            }

            @Override  // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt gatt, int status) {
                logger_maybe.log("BLEManager", "发现服务");
                if(status == 0) {
                    logger_maybe.log("BLEManager", "发现服务成功");
                    String v6 = "uuids: ";
                    for(Object service: BLEManager.getBluetoothGatt(BLEManager.this).getServices()) {
                        v6 = v6 + ((BluetoothGattService)service).getUuid().toString() + " - ";
                    }

                    logger_maybe.log("BLEManager", v6);
                    if(BLEManager.getBluetoothGattService(BLEManager.this) != null) {
                        goto label_106;
                    }

                    BluetoothGattService service = BLEManager.getBluetoothGatt(BLEManager.this).getService(BLEManager.getUUID_FFF0());
                    BLEManager.setService(BLEManager.this, service);
                    if(BLEManager.getBluetoothGattService(BLEManager.this) == null) {
                        BLEManager.i(BLEManager.this);
                        if(BLEManager.j(BLEManager.this) >= 2) {
                            goto label_149;
                        }

                        BluetoothGatt v0_1 = BLEManager.getBluetoothGatt(BLEManager.this);
                        BLEManager.sRefreshDevice(BLEManager.this, v0_1);
                        logger_maybe.log("BLEManager", "找不到服务，清空蓝牙缓存，然后重新连接");
                        if(BLEManager.getBluetoothGatt(BLEManager.this) == null) {
                            BLEManager.this.connect(BLEManager.mAddress);
                            return;
                        }

                        BLEManager.getBluetoothGatt(BLEManager.this).close();
                        BLEManager.setWriteCharacteristic(BLEManager.this, null);
                        BLEManager.this.connect(BLEManager.mAddress);
                        return;
                    }

                    logger_maybe.log("BLEManager", "连接成功");
                    BLEManager.f(BLEManager.this).handleConnection(true, 1);
                    BLEManager.setIsConnected(BLEManager.this, true);
                    if(BLEManager.getReadCharacteristic(BLEManager.this) == null) {
                        logger_maybe.log("BLEManager", "mReadCharacteristic");
                        BluetoothGattCharacteristic v7_1 = BLEManager.getBluetoothGattService(BLEManager.this).getCharacteristic(BLEManager.getUUID_FFF4());
                        BLEManager.setReadCharacteristic(BLEManager.this, v7_1);
                        BLEManager.getBluetoothGatt(BLEManager.this).setCharacteristicNotification(BLEManager.getReadCharacteristic(BLEManager.this), true);
                    }

                    if(BLEManager.getReadCharacteristic(BLEManager.this) != null && BLEManager.getBluetoothGattDescriptor(BLEManager.this) == null) {
                        logger_maybe.log("BLEManager", "readDescriptor");
                        BluetoothGattDescriptor CCDesc = BLEManager.getReadCharacteristic(BLEManager.this).getDescriptor(BLEManager.getClientCharacteristicConfigurationDescriptorUUID());
                        BLEManager.setDescriptor(BLEManager.this, CCDesc);
                        BLEManager.getBluetoothGattDescriptor(BLEManager.this).setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                        BLEManager.getBluetoothGatt(BLEManager.this).writeDescriptor(BLEManager.getBluetoothGattDescriptor(BLEManager.this));
                        return;
                    label_106:
                        if(BLEManager.getBluetoothGattService(BLEManager.this).getCharacteristic(BLEManager.getUUID_FFF3()) != null && BLEManager.getBluetoothGattService(BLEManager.this).getCharacteristic(BLEManager.getUUID_FFF4()) != null) {
                            logger_maybe.log("BLEManager", "连接成功！！！");
                            BLEManager.setIsConnected(BLEManager.this, true);
                            BLEManager.f(BLEManager.this).handleConnection(true, 1);
                            return;
                        }

                        BLEManager.i(BLEManager.this);
                        if(BLEManager.j(BLEManager.this) < 2) {
                            BluetoothGatt v0_2 = BLEManager.getBluetoothGatt(BLEManager.this);
                            BLEManager.sRefreshDevice(BLEManager.this, v0_2);
                            logger_maybe.log("BLEManager", "找不到特征值，清空蓝牙缓存，然后重新连接");
                            if(BLEManager.getBluetoothGatt(BLEManager.this) != null) {
                                BLEManager.getBluetoothGatt(BLEManager.this).close();
                                BLEManager.setWriteCharacteristic(BLEManager.this, null);
                            }

                            BLEManager.this.connect(BLEManager.mAddress);
                            return;
                        }

                    label_149:
                        BLEManager.a(BLEManager.this, 0);
                        BLEManager.f(BLEManager.this).handleConnection(false, 1);
                        BLEManager.setIsConnected(BLEManager.this, false);
                        BLEManager.this.disconnect();
                        return;
                    }
                }
                else {
                    logger_maybe.d("BLEManager", "发现服务失败，错误信息为：" + status);
                }
            }
        };
        this.mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
            @Override  // android.bluetooth.BluetoothAdapter$LeScanCallback
            public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
                String v1;
                logger_maybe.b("BLEManager", scanRecord.length + "scanRecord长度");
                new ArrayList();
                String deviceName = device.getName();
                logger_maybe.b("BLEManager", "start analysis: ");
                List scanRecordArrayList = BLEManager.s_toArrayList(BLEManager.this, scanRecord);
                ArrayList arrayList = new ArrayList();
                List v7_1 = BLEManager.a(BLEManager.this, scanRecordArrayList, 9, arrayList);
                if(v7_1.size() >= 1) {
                    try {
                        v1 = new String(((byte[])v7_1.get(v7_1.size() - 1)), "ASCII");
                    }
                    catch(UnsupportedEncodingException v7_2) {
                        v7_2.printStackTrace();
                        goto label_38;
                    }

                    deviceName = v1;
                }

            label_38:
                BLEManager.f(BLEManager.this).sendMessage(new BLEDevice(deviceName, device.getAddress(), rssi, device), 1);
            }
        };
        this.mContext = context;
        this.mBluetoothManager = (BluetoothManager)this.mContext.getSystemService("bluetooth");
        this.mBluetoothAdapter = this.mBluetoothManager.getAdapter();
    }

    static int a(BLEManager manager, int arg1) {
        manager.u = arg1;
        return arg1;
    }

    static BluetoothGatt setWriteCharacteristic(BLEManager manager, BluetoothGatt gatt) {
        manager.mBluetoothGatt = gatt;
        return gatt;
    }

    static BluetoothGattCharacteristic setCharacteristic(BLEManager manager, BluetoothGattCharacteristic characteristic) {
        manager.mWriteCharacteristic = characteristic;
        return characteristic;
    }

    static BluetoothGattDescriptor setDescriptor(BLEManager manager, BluetoothGattDescriptor descriptor) {
        manager.mBluetoothGattDescriptor = descriptor;
        return descriptor;
    }

    static BluetoothGattService setService(BLEManager manager, BluetoothGattService service) {
        manager.mBluetoothGattService = service;
        return service;
    }

    static Context getContext(BLEManager manager) {
        return manager.mContext;
    }

    public static BLEManager get(Context context) {
        if(BLEManager.s_instance == null) {
            BLEManager.s_instance = new BLEManager(context);
        }

        return BLEManager.s_instance;
    }

    static List a(BLEManager manager, List src, byte len, List dest) {
        return manager.copyBytes(src, len, dest);
    }

    private List copyBytes(List src, byte len, List dest) {
        if(src.size() < 2) {
            return dest;
        }

        int b0 = ((byte)(((Byte)src.get(0)))) & 0xFF;
        if((((byte)(((Byte)src.get(1)))) & 0xFF) == (len & 0xFF)) {
            int v3 = b0 + 1;
            byte[] v4 = new byte[v3];
            int v5;
            for(v5 = 0; v5 < v3; ++v5) {
                v4[v5] = (byte)(((Byte)src.get(v5)));
            }

            dest.add(v4);
        }

        if(b0 == 0) {
            src.clear();
            return this.copyBytes(src, len, dest);
        }

        int v3_1;
        for(v3_1 = 0; v3_1 < b0 + 1; ++v3_1) {
            src.remove(0);
        }

        return this.copyBytes(src, len, dest);
    }

    static void s_sendDataToWriteChar0xFFF3(BLEManager arg0, byte[] arg1) {
        arg0.sendDataToWriteChar0xFFF3(arg1);
    }

    private boolean refreshDevice(BluetoothGatt gatt) {
        try {
            Method refresh = gatt.getClass().getMethod("refresh");
            if(refresh != null) {
                return ((Boolean)refresh.invoke(gatt)).booleanValue();
            }
        }
        catch(Exception unused_ex) {
            logger_maybe.e("BLEManager", "An exception occured while refreshing device");
        }

        return false;
    }

    static boolean setIsConnected(BLEManager manager, boolean arg1) {
        manager.mIsConnected = arg1;
        return arg1;
    }

    public void requestBluetoothEnable() {
        if(this.mBluetoothAdapter == null || !this.mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent  = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
            ((Activity)this.mContext).startActivityForResult(enableBtIntent , 1);
        }
    }

    public void a(interface_a arg1) {
        this.g = arg1;
    }

    public void maybe_send_message_1(byte[] arg2) {
        this.maybe_send_message2(arg2, 0, 0);
    }

    public void maybe_send_message2(byte[] arg3, int arg4, int arg5) {
        this.maybe_messages_to_send.add(new maybe_ble_message(this, arg3, arg4, arg5));
        this.pollSendMessages();
    }

    public boolean connect(String address) {
        String v1_2;
        this.mIsConnected = false;
        this.x = false;
        this.mRecievedMessageBuffer = new StringBuffer();
        if(this.mBluetoothAdapter != null && address != null) {
            BluetoothGatt gatt = this.mBluetoothGatt;
            if(gatt != null) {
                gatt.close();
            }

            BluetoothDevice device = this.mBluetoothAdapter.getRemoteDevice(address);
            if(device == null) {
                v1_2 = "Device not found.  Unable to connect.";
                logger_maybe.d("BLEManager", v1_2);
                return false;
            }

            new Handler(this.mContext.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Context v2 = BLEManager.getContext(BLEManager.this);
                    BluetoothGattCallback gattCallback = BLEManager.getBluetoothGattCallback(BLEManager.this);
                    BluetoothGatt v1 = device.connectGatt(v2, false, gattCallback);
                    BLEManager.setWriteCharacteristic(BLEManager.this, v1);
                    logger_maybe.b("BLEManager", "Trying to create a new connection.");
                    BLEManager.mAddress = address;
                }
            });
            return true;
        }
        else {
            v1_2 = "BluetoothAdapter not initialized or unspecified address.";
        }

        logger_maybe.d("BLEManager", v1_2);
        return false;
    }

    static BluetoothGattCallback getBluetoothGattCallback(BLEManager manager) {
        return manager.mBluetoothGattCallback;
    }

    static BluetoothGattCharacteristic setReadCharacteristic(BLEManager manager, BluetoothGattCharacteristic characteristic) {
        manager.mReadCharacteristic = characteristic;
        return characteristic;
    }

    static void s_appendDataReceivedMessages(BLEManager manager, byte[] data) {
        manager.appendDataReceivedMessages(data);
    }

    static boolean sRefreshDevice(BLEManager manager, BluetoothGatt gatt) {
        return manager.refreshDevice(gatt);
    }

    static boolean b(BLEManager manager, boolean arg1) {
        manager.x = arg1;
        return arg1;
    }

    public void maybe_send_message1(byte[] arg1) {
        this.sendDataToWriteChar0xFFF3(arg1);
    }

    public boolean isAdapterEnabled() {
        return this.mBluetoothAdapter == null ? false : this.mBluetoothAdapter.isEnabled();
    }

    static BluetoothGatt getBluetoothGatt(BLEManager manager) {
        return manager.mBluetoothGatt;
    }

    static void s_writeData_withtimer(BLEManager manager, byte[] arg1) {
        manager.writeData_withtimer(arg1);
    }

    private void writeData_withtimer(byte[] data) {
        this.x = true;
        this.sendDataToWriteChar0xFFF3(data);
        ++this.A;
        this.mTimer = new Timer();
        com.xpg.b.BLEManager.3 v0 = new TimerTask() {
            @Override
            public void run() {
                if(BLEManager.n(BLEManager.this) <= BLEManager.o(BLEManager.this)) {
                    BLEManager.s_writeData_withtimer(BLEManager.this, data);
                    return;
                }

                int v0 = -1;
                byte[] v1 = data;
                if(v1[5] == 0 && v1.length >= 12) {
                    v0 = v1[11] & 0xFF;
                }

                BLEManager.f(BLEManager.this).receiveData(new byte[]{101, BLEManager.p(BLEManager.this)[4], BLEManager.p(BLEManager.this)[5], ((byte)v0)}, 1);
                BLEManager.b(BLEManager.this, false);
                BLEManager.q(BLEManager.this);
            }
        };
        this.mTimer.schedule(v0, ((long)this.B));
    }

    public void enableAdapter() {
        if(this.mBluetoothAdapter != null && !this.isAdapterEnabled()) {
            Log.d("BLEManager", "SDK打开蓝牙");
            this.mBluetoothAdapter.enable();
        }
    }

    static LinkedList get_maybe_messages_to_send(BLEManager manager) {
        return manager.maybe_messages_to_send;
    }

    static List s_toArrayList(BLEManager manager, byte[] bytes) {
        return manager.toArrayList(bytes);
    }

    private void sendDataToWriteChar0xFFF3(byte[] data) {
        String v0_2;
        BluetoothGattService mBluetoothGattService = this.mBluetoothGattService;
        if(mBluetoothGattService == null) {
            v0_2 = "mBlzuetoothGattService is null";
        }
        else {
            this.mWriteCharacteristic = mBluetoothGattService.getCharacteristic(BLEManager.UUID_FFF3_maybe_write_characteristic);
            if(this.mWriteCharacteristic != null && this.mBluetoothGatt != null) {
                logger_maybe.log("BLEManager", "data长度：" + data.length);
                if(data.length > 20) {
                    this.remainingDataToWriteToCharacterisitic = new byte[data.length - 20];
                    byte[] v0_1 = new byte[20];
                    int v2;
                    for(v2 = 0; v2 < data.length; ++v2) {
                        if(v2 < 20) {
                            v0_1[v2] = data[v2];
                        }
                        else {
                            this.remainingDataToWriteToCharacterisitic[v2 - 20] = data[v2];
                        }
                    }

                    this.mWriteCharacteristic.setValue(v0_1);
                }
                else {
                    this.remainingDataToWriteToCharacterisitic = null;
                    this.mWriteCharacteristic.setValue(data);
                }

                this.mBluetoothGatt.writeCharacteristic(this.mWriteCharacteristic);
                return;
            }

            v0_2 = "mWriteCharacteristic or mBluetoothGatt is null";
        }

        logger_maybe.log("BLEManager", v0_2);
    }

    public void disableBluetooth() {
        if(this.mBluetoothAdapter != null && (this.isAdapterEnabled())) {
            Log.d("BLEManager", "SDK关闭蓝牙");
            this.mBluetoothAdapter.disable();
        }
    }

    static Timer getTimer(BLEManager manager) {
        return manager.mTimer;
    }

    private void appendDataReceivedMessages(byte[] bytes) {
        synchronized(this) {
            this.mRecievedMessageBuffer.append(a.a(bytes));
            this.parseReceivedMessage();
        }
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }

    static interface_a f(BLEManager arg0) {
        return arg0.g;
    }

    private List toArrayList(byte[] bytes) {
        ArrayList arrayList = new ArrayList();
        int v1;
        for(v1 = 0; v1 < bytes.length; ++v1) {
            arrayList.add(Byte.valueOf(bytes[v1]));
        }

        return arrayList;
    }

    public boolean startScan() {
        try {
            Log.d("BLEManager", "SDK尝试开始蓝牙搜索");
            if(this.mBluetoothAdapter == null) {
                this.mBluetoothManager = (BluetoothManager)this.mContext.getSystemService("bluetooth");
                this.mBluetoothAdapter = this.mBluetoothManager.getAdapter();
            }

            if(!this.mBluetoothAdapter.isEnabled()) {
                this.something_about_ble_scanning = false;
                return false;
            }

            if(AppsRunnerConnector.get(this.mContext).isConnected()) {
                this.something_about_ble_scanning = false;
                Log.d("BLEManager", "连接上的，SDK不用蓝牙搜索1");
                return false;
            }

            if(this.something_about_ble_scanning) {
                goto label_41;
            }

            this.something_about_ble_scanning = true;
            Log.d("BLEManager", "SDK已经蓝牙搜索1");
        }
        catch(Exception v1) {
            v1.printStackTrace();
            return false;
        }

        try {
            this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
            return this.something_about_ble_scanning;
        }
        catch(Exception v1_1) {
        }

        try {
            v1_1.printStackTrace();
            return this.something_about_ble_scanning;
        label_41:
            Log.d("BLEManager", "SDK已经蓝牙搜索11");
            return this.something_about_ble_scanning;
        }
        catch(Exception v1) {
        }

        v1.printStackTrace();
        return false;
    }

    static boolean s_isConnected(BLEManager arg0) {
        return arg0.mIsConnected;
    }

    public boolean stopScan() {
        try {
            if(this.mBluetoothAdapter == null) {
                this.mBluetoothManager = (BluetoothManager)this.mContext.getSystemService("bluetooth");
                this.mBluetoothAdapter = this.mBluetoothManager.getAdapter();
            }

            if(this.mBluetoothAdapter.isEnabled()) {
                if(this.something_about_ble_scanning) {
                    this.something_about_ble_scanning = false;
                    j.a("===", "==关闭Machine搜索==");
                    Log.d("BLEManager", "SDK停止蓝牙搜索");
                    this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
                    return true;
                }

                Log.d("BLEManager", "SDK已经是停止蓝牙搜索");
                return this.something_about_ble_scanning;
            }

            j.a("===", "==关闭Machine搜索==");
        }
        catch(Exception v1) {
            v1.printStackTrace();
        }

        this.something_about_ble_scanning = false;
        return false;
    }

    static BluetoothGattService getBluetoothGattService(BLEManager manager) {
        return manager.mBluetoothGattService;
    }

    public void disconnect() {
        this.mIsConnected = false;
        this.x = false;
        this.mBluetoothGattService = null;
        this.mWriteCharacteristic = null;
        this.mReadCharacteristic = null;
        this.mBluetoothGattDescriptor = null;
        this.mRecievedMessageBuffer = new StringBuffer();
        logger_maybe.log("BLEManager", "disconnect");
        if(this.mBluetoothAdapter != null) {
            BluetoothGatt gatt = this.mBluetoothGatt;
            if(gatt != null) {
                if(gatt != null) {
                    gatt.close();
                    this.mBluetoothGatt.disconnect();
                }

                return;
            }
        }

        logger_maybe.d("BLEManager", "BluetoothAdapter not initialized");
    }

    static int i(BLEManager manager) {
        int v0 = manager.u;
        manager.u = v0 + 1;
        return v0;
    }

    static UUID getUUID_FFF0() {
        return BLEManager.UUID_FFF0;
    }

    static int j(BLEManager arg0) {
        return arg0.u;
    }

    static UUID getUUID_FFF4() {
        return BLEManager.UUID_FFF4;
    }

    static BluetoothGattCharacteristic getReadCharacteristic(BLEManager manager) {
        return manager.mReadCharacteristic;
    }

    static UUID getClientCharacteristicConfigurationDescriptorUUID() {
        return BLEManager.clientCharacteristicConfigurationDescriptorUUID;
    }

    static BluetoothGattDescriptor getBluetoothGattDescriptor(BLEManager arg0) {
        return arg0.mBluetoothGattDescriptor;
    }

    static UUID getUUID_FFF3() {
        return BLEManager.UUID_FFF3_maybe_write_characteristic;
    }

    private void pollSendMessages() {
        if(!this.x) {
            maybe_ble_message msg = (maybe_ble_message)this.maybe_messages_to_send.poll();
            if(msg != null) {
                this.z = msg.b();
                this.B = this.z >= 1 ? msg.c() : 2000;
                this.A = 0;
                this.F = msg.data();
                this.writeData_withtimer(msg.data());
            }
        }
    }

    static byte[] getRemainingDataToWriteToCharacteristic(BLEManager arg0) {
        return arg0.remainingDataToWriteToCharacterisitic;
    }

    static int n(BLEManager arg0) {
        return arg0.A;
    }

    private void parseReceivedMessage() {
        int idx = this.mRecievedMessageBuffer.indexOf("55aa");
        if(this.mRecievedMessageBuffer.length() == 0) {
            return;
        }

        if(idx == -1) {
            if(this.mRecievedMessageBuffer.length() < 2 || !this.mRecievedMessageBuffer.substring(this.mRecievedMessageBuffer.length() - 2, this.mRecievedMessageBuffer.length()).equals("55")) {
                this.mRecievedMessageBuffer.delete(0, this.mRecievedMessageBuffer.length());
                logger_maybe.b("BLEManager_D", "不存在消息头55aa,丢弃了1");
            }

            logger_maybe.b("BLEManager_D", "不存在消息头55aa,丢弃了2");
            return;
        }

        this.mRecievedMessageBuffer.delete(0, idx);
        if(this.mRecievedMessageBuffer.length() < 20) {
            return;
        }

        int length = a.decodeInt(this.mRecievedMessageBuffer.substring(12, 16));
        logger_maybe.b("BLEManager_D", "待接收长度:" + length);
        if(length >= 0 && length <= 1000) {
            int l = (length + 10) * 2;
            if(this.mRecievedMessageBuffer.length() < l) {
                return;
            }

            byte[] msg = a.byteStrToByteArray(this.mRecievedMessageBuffer.substring(0, l));
            byte[] body = new byte[msg.length - 10];
            System.arraycopy(msg, 10, body, 0, body.length);
            int CRC = CRC.getCRC(body, body.length);
            if(msg[8] == LEBE_Int.encode(CRC)[0] && msg[9] == LEBE_Int.encode(CRC)[1]) {
                this.mRecievedMessageBuffer.delete(0, l);
                if(this.mRecievedMessageBuffer.indexOf("55aa") >= 0) {
                    this.parseReceivedMessage();
                }
                else {
                    if((msg[4] & 0xFF) == 1 && (msg[5] & 0xFF) == 2) {
                        logger_maybe.b("BLEManager_D", "开始下发:");
                        if(this.F[4] == msg[4] && this.F[5] == msg[5]) {
                            this.mTimer.cancel();
                            this.x = false;
                            this.g.receiveData(msg, 1);
                            this.pollSendMessages();
                            return;
                        }

                        this.g.receiveData(msg, 1);
                        return;
                    }

                    if((msg[4] & 0xFF) == 1 && (msg[5] & 0xFF) == 27) {
                        this.g.receiveData(msg, 1);
                        return;
                    }

                    if((msg[4] & 0xFF) == 1 && (msg[5] & 0xFF) == 18) {
                        logger_maybe.b("BLEManager", "收到workout data，不清除其他指令的超时");
                        this.g.receiveData(msg, 1);
                        return;
                    }

                    if((msg[4] & 0xFF) == 1 && (msg[5] & 0xFF) == 22) {
                        this.g.receiveData(msg, 1);
                        return;
                    }

                    if((msg[5] & 0xFF) == 0) {
                        if(this.F[4] != msg[4] || this.F[5] != msg[10]) {
                            this.g.receiveData(msg, 1);
                            return;
                        }

                        this.mTimer.cancel();
                        this.x = false;
                        this.g.receiveData(msg, 1);
                        this.pollSendMessages();
                        return;
                    }

                    this.mTimer.cancel();
                    this.x = false;
                    this.g.receiveData(msg, 1);
                    this.pollSendMessages();
                    return;
                }

                this.g.receiveData(msg, 1);
                return;
            }

            logger_maybe.b("BLEManager_D", "CRC错误:" + CRC);
            this.mRecievedMessageBuffer.delete(0, 4);
            this.parseReceivedMessage();
            return;
        }

        this.mRecievedMessageBuffer.delete(0, 4);
        this.parseReceivedMessage();
    }

    static int o(BLEManager arg0) {
        return arg0.z;
    }

    static byte[] p(BLEManager arg0) {
        return arg0.F;
    }

    static void q(BLEManager arg0) {
        arg0.pollSendMessages();
    }
}
