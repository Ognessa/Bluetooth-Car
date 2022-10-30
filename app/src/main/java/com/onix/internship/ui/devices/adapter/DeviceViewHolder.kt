package com.onix.internship.ui.devices.adapter

import androidx.databinding.ViewDataBinding
import com.onix.internship.arch.adapter.BaseViewHolder
import com.onix.internship.databinding.ItemBluetoothDeviceBinding
import com.onix.internship.entity.bluetooth.Device

class DeviceViewHolder(
    binding: ViewDataBinding,
    private val deviceClick: (Device) -> Unit
) : BaseViewHolder<Device, ItemBluetoothDeviceBinding>(binding) {

    override fun bindView(position: Int) {
        binding.data = item
        binding.itemContainer.setOnClickListener {
            deviceClick.invoke(item)
        }
    }
}