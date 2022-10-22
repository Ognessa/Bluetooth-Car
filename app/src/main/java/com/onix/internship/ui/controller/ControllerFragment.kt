package com.onix.internship.ui.controller

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.FragmentControllerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ControllerFragment : BaseFragment<FragmentControllerBinding>(R.layout.fragment_controller) {

    override val viewModel: ControllerViewModel by viewModel()
    private var currentValue = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
    }

    override fun onResume() {
        super.onResume()
        setupClickEvents()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupClickEvents() {
        val data = viewModel.getSettingsData()

        with(binding) {
            buttonA.setOnTouchListener { v, event ->
                viewModel.onButtonTouchListener(v, event, data.leftController.aValue)
            }
            buttonB.setOnTouchListener { v, event ->
                viewModel.onButtonTouchListener(v, event, data.leftController.bValue)
            }
            buttonC.setOnTouchListener { v, event ->
                viewModel.onButtonTouchListener(v, event, data.leftController.cValue)
            }
            buttonD.setOnTouchListener { v, event ->
                viewModel.onButtonTouchListener(v, event, data.leftController.dValue)
            }
            buttonE.setOnTouchListener { v, event ->
                viewModel.onButtonTouchListener(v, event, data.rightController.aValue)
            }
            buttonF.setOnTouchListener { v, event ->
                viewModel.onButtonTouchListener(v, event, data.rightController.bValue)
            }
            buttonK.setOnTouchListener { v, event ->
                viewModel.onButtonTouchListener(v, event, data.rightController.cValue)
            }
            buttonL.setOnTouchListener { v, event ->
                viewModel.onButtonTouchListener(v, event, data.rightController.dValue)
            }
        }

        with(binding.seekBar) {
            currentValue = 0
            min = data.seekBarData.minValue.toInt()
            max = data.seekBarData.maxValue.toInt()
            progress = currentValue

            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    currentValue = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    viewModel.sendSignal(
                        signal = currentValue.toString().toByteArray()
                    )
                }
            })
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