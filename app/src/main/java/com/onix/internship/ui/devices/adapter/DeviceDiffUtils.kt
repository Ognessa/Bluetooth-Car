package com.onix.internship.ui.devices.adapter

import android.bluetooth.BluetoothDevice
import androidx.recyclerview.widget.DiffUtil

class DeviceDiffUtils : DiffUtil.ItemCallback<BluetoothDevice>() {
    override fun areItemsTheSame(oldItem: BluetoothDevice, newItem: BluetoothDevice): Boolean {
        return oldItem.address == newItem.address
    }

    override fun areContentsTheSame(oldItem: BluetoothDevice, newItem: BluetoothDevice): Boolean {
        return oldItem == newItem
    }
}