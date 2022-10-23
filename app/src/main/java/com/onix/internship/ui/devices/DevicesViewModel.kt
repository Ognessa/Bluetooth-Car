package com.onix.internship.ui.devices

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel

class DevicesViewModel : BaseViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun loading(boolean: Boolean) {
        _isLoading.value = boolean
    }
}