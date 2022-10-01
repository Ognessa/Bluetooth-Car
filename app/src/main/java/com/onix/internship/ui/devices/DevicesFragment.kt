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
import com.onix.internship.databinding.FragmentDevicesBinding
import com.onix.internship.ui.devices.adapter.DeviceAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.DataOutputStream
import java.util.*


class DevicesFragment : BaseFragment<FragmentDevicesBinding>(R.layout.fragment_devices) {

    override val viewModel: DevicesViewModel by viewModel()

    private lateinit var bluetoothAdapter: BluetoothAdapter
    private lateinit var socket: BluetoothSocket

    private var myUUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")

    //TODO finish when get my car

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBluetoothAdapter()

        val list = bluetoothAdapter.bondedDevices.toList()

        val adapter = DeviceAdapter(
            deviceClick = {
                Thread().run {
                    deviceConnect(it)
                }
            }
        )

        binding.bluetoothDevicesList.adapter = adapter
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
        var result = ""

        try {
            socket = device.createRfcommSocketToServiceRecord(device.uuids[0].uuid)

            bluetoothAdapter.cancelDiscovery()
            socket.connect()

            val outS = DataOutputStream(socket.outputStream)
            result = "Connected"
        } catch (e: Exception) {
            e.printStackTrace()
            result = "Failed"
        }

        showSnack(result)
    }
}