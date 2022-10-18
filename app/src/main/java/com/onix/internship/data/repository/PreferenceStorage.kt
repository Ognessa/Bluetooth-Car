package com.onix.internship.data.repository

import android.content.Context
import com.onix.internship.entity.SettingsDBData
import com.onix.internship.entity.controllers.ControllerData
import com.onix.internship.entity.controllers.SeekBarData

const val PREFS_FILE_NAME = "storage"

class PreferenceStorage constructor(private val context: Context) {

    private val LEFT_CONTROLLER_A = "left_controller_a"
    private val LEFT_CONTROLLER_B = "left_controller_b"
    private val LEFT_CONTROLLER_C = "left_controller_c"
    private val LEFT_CONTROLLER_D = "left_controller_d"

    private val RIGHT_CONTROLLER_A = "right_controller_a"
    private val RIGHT_CONTROLLER_B = "right_controller_b"
    private val RIGHT_CONTROLLER_C = "right_controller_c"
    private val RIGHT_CONTROLLER_D = "right_controller_d"

    private val SEEK_BAR_MIN = "seek_bar_min"
    private val SEEK_BAR_MAX = "seek_bar_max"

    fun saveSettings(settings: SettingsDBData) {
        save(LEFT_CONTROLLER_A, settings.leftController.aValue)
        save(LEFT_CONTROLLER_B, settings.leftController.bValue)
        save(LEFT_CONTROLLER_C, settings.leftController.cValue)
        save(LEFT_CONTROLLER_D, settings.leftController.dValue)

        save(RIGHT_CONTROLLER_A, settings.rightController.aValue)
        save(RIGHT_CONTROLLER_B, settings.rightController.bValue)
        save(RIGHT_CONTROLLER_C, settings.rightController.cValue)
        save(RIGHT_CONTROLLER_D, settings.rightController.dValue)

        save(SEEK_BAR_MIN, settings.seekBarData.minValue)
        save(SEEK_BAR_MAX, settings.seekBarData.maxValue)
    }

    fun getSettings(): SettingsDBData {
        return SettingsDBData(
            leftController = ControllerData(
                aValue = getString(LEFT_CONTROLLER_A) ?: "",
                bValue = getString(LEFT_CONTROLLER_B) ?: "",
                cValue = getString(LEFT_CONTROLLER_C) ?: "",
                dValue = getString(LEFT_CONTROLLER_D) ?: ""
            ),
            rightController = ControllerData(
                aValue = getString(RIGHT_CONTROLLER_A) ?: "",
                bValue = getString(RIGHT_CONTROLLER_B) ?: "",
                cValue = getString(RIGHT_CONTROLLER_C) ?: "",
                dValue = getString(RIGHT_CONTROLLER_D) ?: ""
            ),
            seekBarData = SeekBarData(
                minValue = getString(SEEK_BAR_MIN) ?: "",
                maxValue = getString(SEEK_BAR_MAX) ?: ""
            )
        )
    }

    fun checkSettingsExists(): Boolean {
        return getString(LEFT_CONTROLLER_A).isNullOrEmpty() &&
                getString(LEFT_CONTROLLER_B).isNullOrEmpty() &&
                getString(LEFT_CONTROLLER_C).isNullOrEmpty() &&
                getString(LEFT_CONTROLLER_D).isNullOrEmpty() &&
                getString(RIGHT_CONTROLLER_A).isNullOrEmpty() &&
                getString(RIGHT_CONTROLLER_B).isNullOrEmpty() &&
                getString(RIGHT_CONTROLLER_C).isNullOrEmpty() &&
                getString(RIGHT_CONTROLLER_D).isNullOrEmpty() &&
                getString(SEEK_BAR_MIN).isNullOrEmpty() &&
                getString(SEEK_BAR_MAX).isNullOrEmpty()
    }

    fun save(_key: String, _value: String) {
        val prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
        val prefsEdit = prefs.edit()

        prefsEdit.putString(_key, _value)
        prefsEdit.apply()
    }

    fun getString(_key: String, default: String = ""): String? {
        val prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
        return prefs.getString(_key, default)
    }

}
