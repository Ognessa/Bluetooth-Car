package com.onix.internship.ui.devices.adapter

import android.bluetooth.BluetoothDevice
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.onix.internship.R
import com.onix.internship.arch.adapter.BaseRecyclerListAdapter
import com.onix.internship.arch.adapter.BaseViewHolder

class DeviceAdapter(
    private val deviceClick: (BluetoothDevice) -> Unit
) : BaseRecyclerListAdapter<BluetoothDevice>(DeviceDiffUtils()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<BluetoothDevice, out ViewDataBinding> {
        return DeviceViewHolder(
            binding = inflate(parent, R.layout.item_bluetooth_device),
            deviceClick = deviceClick
        )
    }
}