package com.onix.internship.entity.controllers

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 *   A
 * D   B
 *   C
 * */

@Entity
data class ControllerData(
    @ColumnInfo(name = "a_value") val aValue: String = "f",
    @ColumnInfo(name = "b_value") val bValue: String = "r",
    @ColumnInfo(name = "c_value") val cValue: String = "b",
    @ColumnInfo(name = "d_value") val dValue: String = "l"
)