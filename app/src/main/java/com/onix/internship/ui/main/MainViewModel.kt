package com.onix.internship.ui.main

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.data.repository.PreferenceStorage
import com.onix.internship.entity.settings.SettingsDBData

class MainViewModel(
    preferences: PreferenceStorage
) : BaseViewModel() {

    init {
        if (preferences.checkSettingsExists()) {
            preferences.saveSettings(SettingsDBData())
        }
    }

}