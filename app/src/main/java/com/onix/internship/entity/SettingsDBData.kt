package com.onix.internship.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.onix.internship.entity.controllers.ControllerData
import com.onix.internship.entity.controllers.SeekBarData

@Entity
data class SettingsDBData(
    @PrimaryKey val id: Int = 0,
    @ColumnInfo(name = "title") var title: String = "Default settings",
    @ColumnInfo(name = "left_controller_data") var leftController: ControllerData = ControllerData(),
    @ColumnInfo(name = "right_controller_data") var rightController: ControllerData = ControllerData(),
    @ColumnInfo(name = "seek_bar_data") var seekBarData: SeekBarData = SeekBarData()
)