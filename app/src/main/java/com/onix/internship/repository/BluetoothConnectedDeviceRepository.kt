package com.onix.internship.repository

import android.bluetooth.BluetoothSocket
import com.onix.internship.entity.bluetooth.Device

class BluetoothConnectedDeviceRepository {
    var device: Device? = null
    var socket: BluetoothSocket? = null

    fun isConnected(): Boolean {
        return device != null && socket != null && socket!!.isConnected
    }
}