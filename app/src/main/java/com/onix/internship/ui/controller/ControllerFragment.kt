package com.onix.internship.ui.controller

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.FragmentControllerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ControllerFragment : BaseFragment<FragmentControllerBinding>(R.layout.fragment_controller) {
    override val viewModel: ControllerViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
        setupClickEvents()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupClickEvents() {
        val data = viewModel.getSettingsData()

        binding.buttonA.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, data.leftController.aValue)
        }
        binding.buttonB.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, data.leftController.bValue)
        }
        binding.buttonC.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, data.leftController.cValue)
        }
        binding.buttonD.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, data.leftController.dValue)
        }
        binding.buttonE.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, data.rightController.aValue)
        }
        binding.buttonF.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, data.rightController.bValue)
        }
        binding.buttonK.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, data.rightController.cValue)
        }
        binding.buttonL.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, data.rightController.dValue)
        }
    }

    private fun setupNavigation() {
        binding.deviceTitleContainer.setOnClickListener {
            navigate(ControllerFragmentDirections.actionControllerFragmentToDevicesFragment())
        }
        binding.settingsTitleContainer.setOnClickListener {
            navigate(ControllerFragmentDirections.actionControllerFragmentToSettingsFragment())
        }
    }

}