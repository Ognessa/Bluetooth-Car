package com.onix.internship.di

import com.onix.internship.data.repository.DataStore
import com.onix.internship.data.repository.PreferenceStorage
import com.onix.internship.repository.BluetoothConnectedDeviceRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { DataStore(get()) }
    single { PreferenceStorage(get()) }
    single { BluetoothConnectedDeviceRepository() }
}