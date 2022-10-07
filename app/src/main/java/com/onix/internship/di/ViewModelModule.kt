package com.onix.internship.di

import com.onix.internship.ui.controller.ControllerViewModel
import com.onix.internship.ui.devices.DevicesViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DevicesViewModel() }
    viewModel { ControllerViewModel(get()) }
    viewModel { SettingsViewModel() }
    viewModel { MainViewModel() }
}