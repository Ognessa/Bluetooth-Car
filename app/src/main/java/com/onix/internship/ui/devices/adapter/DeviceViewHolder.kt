package com.onix.internship.ui.devices.adapter

import android.bluetooth.BluetoothDevice
import androidx.databinding.ViewDataBinding
import com.onix.internship.arch.adapter.BaseViewHolder
import com.onix.internship.databinding.ItemBluetoothDeviceBinding

class DeviceViewHolder(
    binding: ViewDataBinding,
    private val deviceClick: (BluetoothDevice) -> Unit
) : BaseViewHolder<BluetoothDevice, ItemBluetoothDeviceBinding>(binding) {

    override fun bindView(position: Int) {
        binding.data = item
        binding.itemContainer.setOnClickListener {
            deviceClick.invoke(item)
        }
    }
}