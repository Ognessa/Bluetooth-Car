package com.onix.internship.ui.settings

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.FragmentSettingsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings) {

    override val viewModel: SettingsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.model = viewModel.model
        binding.viewModel = viewModel
        initData()
    }

    private fun initData() {
        val data = viewModel.getDataFromStorage()

        with(binding) {
            aValue.setText(data.leftController.aValue)
            bValue.setText(data.leftController.bValue)
            cValue.setText(data.leftController.cValue)
            dValue.setText(data.leftController.dValue)

            eValue.setText(data.rightController.aValue)
            fValue.setText(data.rightController.bValue)
            kValue.setText(data.rightController.cValue)
            lValue.setText(data.rightController.dValue)

            minValue.setText(data.seekBarData.minValue)
            maxValue.setText(data.seekBarData.maxValue)
        }
    }

}