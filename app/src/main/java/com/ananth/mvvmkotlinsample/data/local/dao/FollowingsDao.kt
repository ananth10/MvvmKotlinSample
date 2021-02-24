package com.ananth.mvvmkotlinsample.data.local.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ananth.mvvmkotlinsample.model.local.FollowingsEntity
import kotlinx.coroutines.flow.Flow

/**
 * @FollowingsDao - it helps us to access following data object from the database
 * */
@Dao
interface FollowingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFollowingsList(followingList:List<FollowingsEntity>)

    @Query("SELECT * from followings")
    fun retrieveFollowingsList(): Flow<List<FollowingsEntity>>

    @Query("DELETE FROM followings")
    fun deleteFollowingsTable()
}