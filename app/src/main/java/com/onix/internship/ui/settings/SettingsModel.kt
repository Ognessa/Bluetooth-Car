package com.onix.internship.ui.settings

import androidx.databinding.ObservableField
import com.onix.internship.entity.settings.controllers.ControllerData
import com.onix.internship.entity.settings.controllers.SeekBarData

data class SettingsModel(
    val A_value: ObservableField<String> = ObservableField(""),
    val B_value: ObservableField<String> = ObservableField(""),
    val C_value: ObservableField<String> = ObservableField(""),
    val D_value: ObservableField<String> = ObservableField(""),
    val E_value: ObservableField<String> = ObservableField(""),
    val F_value: ObservableField<String> = ObservableField(""),
    val K_value: ObservableField<String> = ObservableField(""),
    val L_value: ObservableField<String> = ObservableField(""),
    val stop: ObservableField<String> = ObservableField(""),
    val min_value: ObservableField<String> = ObservableField(""),
    val max_value: ObservableField<String> = ObservableField("")
) {

    fun checkDataIsNotEmpty(): Boolean {
        return !A_value.get().isNullOrEmpty() &&
                !B_value.get().isNullOrEmpty() &&
                !C_value.get().isNullOrEmpty() &&
                !D_value.get().isNullOrEmpty() &&
                !E_value.get().isNullOrEmpty() &&
                !F_value.get().isNullOrEmpty() &&
                !K_value.get().isNullOrEmpty() &&
                !L_value.get().isNullOrEmpty() &&
                !stop.get().isNullOrEmpty() &&
                !min_value.get().isNullOrEmpty() &&
                !max_value.get().isNullOrEmpty()
    }

    fun checkDataIsCorrect(): Boolean {
        return max_value.get()?.toInt()!! > min_value.get()?.toInt()!!
    }

    fun getLeftData(): ControllerData {
        return ControllerData(
            aValue = A_value.get()!!,
            bValue = B_value.get()!!,
            cValue = C_value.get()!!,
            dValue = D_value.get()!!
        )
    }

    fun getRightData(): ControllerData {
        return ControllerData(
            aValue = E_value.get()!!,
            bValue = F_value.get()!!,
            cValue = K_value.get()!!,
            dValue = L_value.get()!!
        )
    }

    fun getSeekBarData(): SeekBarData {
        return SeekBarData(
            minValue = min_value.get()!!,
            maxValue = max_value.get()!!
        )
    }
}