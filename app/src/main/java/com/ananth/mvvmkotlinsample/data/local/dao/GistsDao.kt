package com.ananth.mvvmkotlinsample.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ananth.mvvmkotlinsample.model.local.GistsEntity
import kotlinx.coroutines.flow.Flow

/**
 * @GistsDao - it helps us to access gist data object from the database
 * */
@Dao
interface GistsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGistsList(gistList:List<GistsEntity>)

    @Query("SELECT * FROM gists")
    fun retrieveGistsList():Flow<List<GistsEntity>>

    @Query("DELETE FROM gists")
    fun deleteGistsTable()
}