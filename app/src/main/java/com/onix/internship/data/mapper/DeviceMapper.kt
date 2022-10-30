package com.onix.internship.data.mapper

import android.bluetooth.BluetoothDevice
import androidx.databinding.ObservableBoolean
import com.onix.internship.arch.mapper.Mapper
import com.onix.internship.entity.bluetooth.Device
import com.onix.internship.repository.BluetoothConnectedDeviceRepository

class DeviceMapper(
    private val repository: BluetoothConnectedDeviceRepository
) : Mapper<BluetoothDevice, Device>() {

    override fun map(from: BluetoothDevice): Device {
        return Device(
            deviceData = from,
            connected = ObservableBoolean(repository.isConnected())
        )
    }
}