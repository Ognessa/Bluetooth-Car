package com.onix.internship.ui.devices

import android.bluetooth.BluetoothManager
import android.content.Context
import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.FragmentDevicesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DevicesFragment : BaseFragment<FragmentDevicesBinding>(R.layout.fragment_devices) {

    override val viewModel: DevicesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bluetoothManager =
            requireContext().getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val list = bluetoothManager.adapter.bondedDevices
        binding.pairedDevices.text = list.toString()
    }

}