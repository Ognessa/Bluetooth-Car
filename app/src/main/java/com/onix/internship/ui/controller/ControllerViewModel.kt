package com.onix.internship.ui.controller

import android.view.MotionEvent
import android.view.View
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.data.repository.PreferenceStorage
import com.onix.internship.entity.SettingsDBData
import com.onix.internship.repository.BluetoothConnectedDeviceRepository

class ControllerViewModel(
    private val repository: BluetoothConnectedDeviceRepository,
    private val preferenceStorage: PreferenceStorage
) : BaseViewModel() {

    fun onButtonTouchListener(v: View, event: MotionEvent, signal: String): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> sendSignal(signal.toByteArray())
            MotionEvent.ACTION_UP -> sendSignal(getSettingsData().stop.toByteArray())
        }
        return true
    }

    fun sendSignal(signal: ByteArray) {
        val s = repository.socket
        if (s != null && s.isConnected) {
            s.outputStream.write(signal)
            s.outputStream.flush()
        } else {
            showSnack("Device is not connected")
        }
    }

    fun getSettingsData(): SettingsDBData {
        return preferenceStorage.getSettings()
    }

}