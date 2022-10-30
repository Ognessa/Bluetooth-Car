package com.onix.internship.entity.settings

import com.onix.internship.entity.settings.controllers.ControllerData
import com.onix.internship.entity.settings.controllers.SeekBarData

data class SettingsDBData(
    var leftController: ControllerData = ControllerData(),
    var rightController: ControllerData = ControllerData(),
    var stop: String = "s",
    var seekBarData: SeekBarData = SeekBarData()
)