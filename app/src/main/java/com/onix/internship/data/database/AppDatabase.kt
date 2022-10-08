package com.onix.internship.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onix.internship.entity.SettingsDBData

@Database(entities = [SettingsDBData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun settingsDao(): SettingsDao
}