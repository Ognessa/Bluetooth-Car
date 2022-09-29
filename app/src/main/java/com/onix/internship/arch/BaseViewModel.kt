package com.onix.internship.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val loading = MutableLiveData(false)
    val massageEvent = SingleLiveEvent<String>()

    private val _navigate = MutableLiveData<NavDirections>()
    val navigate: LiveData<NavDirections> get() = _navigate

    protected fun showSnack(msg: String?) {
        msg?.let { massageEvent.postValue(it) }
    }

    protected fun launch(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(block = block)

    protected fun onLoading(state: Boolean) {
        loading.postValue(state)
    }

    protected fun navigate(direction: NavDirections) {
        _navigate.value = direction
    }

}