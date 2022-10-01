package com.onix.internship.ui.controller

import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.onix.internship.arch.BaseViewModel

class ControllerViewModel : BaseViewModel() {

    fun onButtonTouchListener(v: View, event: MotionEvent, signal: String) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> Log.v("Send: ", signal)
            MotionEvent.ACTION_UP -> Log.v("Stop sending: ", signal)
        }
        return true
    }

}