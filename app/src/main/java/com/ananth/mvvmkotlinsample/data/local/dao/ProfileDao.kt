package com.ananth.mvvmkotlinsample.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ananth.mvvmkotlinsample.model.local.ProfileEntity
import kotlinx.coroutines.flow.Flow

/**
 * @ProfileDao - it helps us to access profile data object from the database
 * */
@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfileData(profileEntity: ProfileEntity)

    @Query("SELECT * from profile")
    fun retrieveProfileData(): Flow<ProfileEntity>

    @Query("DELETE FROM profile")
    fun deleteProfileData()
}