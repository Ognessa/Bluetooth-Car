package com.onix.internship.data.repository

import android.content.Context
import androidx.room.Room
import com.onix.internship.data.database.AppDatabase
import com.onix.internship.entity.SettingsDBData

class DataStore(context: Context) {
    private val db = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, "settingsdbdata"
    ).build()

    fun gelAllData(): List<SettingsDBData> {
        return db.settingsDao().getAll()
    }

    fun getById(id: Int): SettingsDBData {
        return db.settingsDao().getById(id)
    }

    fun addNewSettings(settings: SettingsDBData) {
        db.settingsDao().insert(settings)
    }

    fun editSettings(settings: SettingsDBData) {
        db.settingsDao().update(settings)
    }

    fun clearDB() {
        db.settingsDao().deleteAll()
    }

    fun delete(settings: SettingsDBData) {
        db.settingsDao().delete(settings)
    }
}