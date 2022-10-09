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
        binding.buttonA.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, "f")
        }
        binding.buttonB.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, "r")
        }
        binding.buttonC.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, "b")
        }
        binding.buttonD.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, "l")
        }
        binding.buttonE.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, "E")
        }
        binding.buttonF.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, "F")
        }
        binding.buttonK.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, "K")
        }
        binding.buttonL.setOnTouchListener { v, event ->
            viewModel.onButtonTouchListener(v, event, "L")
        }
    }

    private fun setupNavigation() {
        binding.deviceTitleContainer.setOnClickListener {
            navigate(ControllerFragmentDirections.actionControllerFragmentToDevicesFragment())
        }
        binding.settingsTitleContainer.setOnClickListener {
            showSnack("Don`t work now")
            //navigate(ControllerFragmentDirections.actionControllerFragmentToSettingsFragment())
        }
    }

}