package com.onix.internship.ui.settings

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.data.repository.PreferenceStorage
import com.onix.internship.entity.SettingsDBData

class SettingsViewModel(
    private val preferences: PreferenceStorage
) : BaseViewModel() {

    val model = SettingsModel()

    fun saveControllersData() {
        if (model.checkDataIsNotEmpty()) {
            preferences.saveSettings(
                SettingsDBData(
                    leftController = model.getLeftData(),
                    rightController = model.getRightData(),
                    seekBarData = model.getSeekBarData()
                )
            )
        } else {
            showSnack("Fill all data, please!")
        }
    }

    fun getDataFromStorage(): SettingsDBData {
        return preferences.getSettings()
    }

}