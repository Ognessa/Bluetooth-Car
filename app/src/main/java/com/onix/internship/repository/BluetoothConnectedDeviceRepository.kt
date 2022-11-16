package com.onix.internship.repository

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import com.onix.internship.entity.bluetooth.Device

class BluetoothConnectedDeviceRepository {
    var device: Device? = null
    var socket: BluetoothSocket? = null

    fun isConnected(device: BluetoothDevice): Boolean {
        return this.device?.deviceData == device && socket != null && socket?.isConnected == true
    }
}