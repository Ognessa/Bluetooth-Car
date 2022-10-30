package com.onix.internship.ui.devices.adapter

import androidx.recyclerview.widget.DiffUtil
import com.onix.internship.entity.bluetooth.Device

class DeviceDiffUtils : DiffUtil.ItemCallback<Device>() {
    override fun areItemsTheSame(oldItem: Device, newItem: Device): Boolean {
        return oldItem.deviceData.address == newItem.deviceData.address
    }

    override fun areContentsTheSame(oldItem: Device, newItem: Device): Boolean {
        return oldItem.deviceData == newItem.deviceData
    }
}