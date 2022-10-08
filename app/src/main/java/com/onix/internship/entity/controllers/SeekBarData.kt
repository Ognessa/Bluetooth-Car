package com.onix.internship.entity.controllers

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class SeekBarData(
    @ColumnInfo(name = "min_value") val minValue: String = "0",
    @ColumnInfo(name = "max_value") val maxValue: String = "10"
)