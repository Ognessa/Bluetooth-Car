package com.onix.internship.ui.settings

import android.util.Log
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.data.repository.DataStore
import com.onix.internship.entity.SettingsDBData

class SettingsViewModel(
    private val dataStore: DataStore
) : BaseViewModel() {

    val model = SettingsModel()

    fun saveControllersData() {
        if (model.checkDataIsNotEmpty()) {

//            Log.d(
//                "DEBUG",
//                SettingsDBData(
//                    leftController = model.getLeftData(),
//                    rightController = model.getRightData(),
//                    seekBarData = model.getSeekBarData()
//                ).toString()
//            )

//            dataStore.addNewSettings(
//                SettingsDBData(
//                    leftController = model.getLeftData(),
//                    rightController = model.getRightData(),
//                    seekBarData = model.getSeekBarData()
//                )
//            )
        } else {
            Log.d("DEBUG", "Fill all data")
        }
    }

}