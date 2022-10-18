package com.onix.internship.entity

import com.onix.internship.entity.controllers.ControllerData
import com.onix.internship.entity.controllers.SeekBarData

data class SettingsDBData(
    var leftController: ControllerData = ControllerData(),
    var rightController: ControllerData = ControllerData(),
    var seekBarData: SeekBarData = SeekBarData()
)