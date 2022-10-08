package com.onix.internship.data.database

import androidx.room.*
import com.onix.internship.entity.SettingsDBData

@Dao
interface SettingsDao {

    @Query("SELECT * FROM settingsdbdata")
    fun getAll(): List<SettingsDBData>

    @Query("SELECT * FROM settingsdbdata WHERE id = :id")
    fun getById(id: Int): SettingsDBData

    @Insert
    fun insert(settings: SettingsDBData)

    @Update
    fun update(settings: SettingsDBData)

    @Query("DELETE FROM settingsdbdata")
    fun deleteAll()

    @Delete
    fun delete(settings: SettingsDBData)
}