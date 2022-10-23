package com.onix.internship.ui.devices

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigateToPrevious
import com.onix.internship.databinding.FragmentDevicesBinding
import com.onix.internship.repository.BluetoothConnectedDeviceRepository
import com.onix.internship.ui.devices.adapter.DeviceAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class DevicesFragment : BaseFragment<FragmentDevicesBinding>(R.layout.fragment_devices) {

    override val viewModel: DevicesViewModel by viewModel()

    private val bluetoothRepository: BluetoothConnectedDeviceRepository by inject()

    private lateinit var bluetoothAdapter: BluetoothAdapter
    private lateinit var socket: BluetoothSocket

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBluetoothAdapter()
        binding.viewModel = viewModel
        val adapter = DeviceAdapter(
            deviceClick = {
                Thread().run {
                    deviceConnect(it)
                }
            }
        )

        binding.bluetoothDevicesList.adapter = adapter
        updateList(adapter)

        binding.arrowBack.setOnClickListener {
            navigateToPrevious()
        }

        binding.swipeRefresh.setOnRefreshListener {
            updateList(adapter)
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun updateList(adapter: DeviceAdapter) {
        val list = bluetoothAdapter.bondedDevices.toList()
        adapter.item = list
    }

    private fun setupBluetoothAdapter() {
        val bluetoothManager =
            requireContext().getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter

        if (!bluetoothAdapter.isEnabled) {
            val enableAdapter = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            requireActivity().startActivity(enableAdapter)
        }
    }

    private fun deviceConnect(device: BluetoothDevice) {
        var result: String
        try {
            socket = device.createRfcommSocketToServiceRecord(device.uuids[0].uuid)
            bluetoothAdapter.cancelDiscovery()
//            viewModel.loading(true)

            socket.connect()
            bluetoothRepository.device = device
            bluetoothRepository.socket = socket

            result = "Connected"
        } catch (e: Exception) {
            e.printStackTrace()
            result = "Failed"
        }
//        viewModel.loading(false)
        showSnack(result)
    }
}