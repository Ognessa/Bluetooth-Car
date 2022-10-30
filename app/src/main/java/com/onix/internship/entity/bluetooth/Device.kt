package com.onix.internship.entity.bluetooth

import android.bluetooth.BluetoothDevice
import androidx.databinding.ObservableBoolean

data class Device(
    val deviceData: BluetoothDevice,
    val connected: ObservableBoolean = ObservableBoolean(false)
)