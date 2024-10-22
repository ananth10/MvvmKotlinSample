package com.ananth.mvvmkotlinsample.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ananth.mvvmkotlinsample.model.local.FollowersEntity
import kotlinx.coroutines.flow.Flow

/**
 * @FollowersDao - it helps us to access followers data object from the database
 * */
@Dao
interface FollowersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFollowersList(followersList:List<FollowersEntity>)

    @Query("SELECT * from followers")
    fun retrieveFollowersList(): Flow<List<FollowersEntity>>

    @Query("DELETE FROM followers")
    fun deleteFollowersTable()
}