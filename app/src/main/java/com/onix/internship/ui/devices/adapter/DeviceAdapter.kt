package com.onix.internship.ui.devices.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.onix.internship.R
import com.onix.internship.arch.adapter.BaseRecyclerListAdapter
import com.onix.internship.arch.adapter.BaseViewHolder
import com.onix.internship.entity.bluetooth.Device

class DeviceAdapter(
    private val deviceClick: (Device) -> Unit
) : BaseRecyclerListAdapter<Device>(DeviceDiffUtils()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Device, out ViewDataBinding> {
        return DeviceViewHolder(
            binding = inflate(parent, R.layout.item_bluetooth_device),
            deviceClick = deviceClick
        )
    }
}