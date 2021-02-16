package com.ananth.mvvmkotlinsample.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ananth.mvvmkotlinsample.model.local.FollowingsEntity

@Dao
interface FollowingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFollowingsList(followingList:List<FollowingsEntity>)

    @Query("SELECT * from followings")
    fun getFollowingList(): LiveData<List<FollowingsEntity>>

    @Query("DELETE FROM followings")
    fun deleteFollowingTable()
}