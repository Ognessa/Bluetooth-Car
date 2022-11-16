package com.onix.internship.ui.devices

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigateToPrevious
import com.onix.internship.data.mapper.DeviceMapper
import com.onix.internship.databinding.FragmentDevicesBinding
import com.onix.internship.entity.bluetooth.Device
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
        val mapper = DeviceMapper(bluetoothRepository)
        val adapter = DeviceAdapter(
            deviceClick = {
                Thread().run {
                    deviceConnect(it)
                }
            }
        )

        binding.bluetoothDevicesList.adapter = adapter
        updateList(adapter, mapper)

        binding.arrowBack.setOnClickListener {
            navigateToPrevious()
        }

        binding.swipeRefresh.setOnRefreshListener {
            updateList(adapter, mapper)
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun updateList(adapter: DeviceAdapter, mapper: DeviceMapper) {
        val list = bluetoothAdapter.bondedDevices.toList()
        val newList = list.map {
            mapper.map(it)
        }
        adapter.item = newList
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

    private fun deviceConnect(device: Device) {
        var result: String
        try {
            if (bluetoothRepository.isConnected(device.deviceData)) {
                with(bluetoothRepository) {
                    socket?.close()
                    this.device = null
                    socket = null
                }
                device.connected.set(false)
                result = "Disconnected"
            } else {
                socket =
                    device.deviceData.createRfcommSocketToServiceRecord(device.deviceData.uuids[0].uuid)
                bluetoothAdapter.cancelDiscovery()

                socket.connect()
                bluetoothRepository.device = device
                bluetoothRepository.socket = socket
                device.connected.set(true)

                result = "Connected"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            result = "Failed"
        }

        showSnack(result)
    }
}