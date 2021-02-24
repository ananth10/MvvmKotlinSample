package com.ananth.mvvmkotlinsample.data.local.dao

import androidx.room.*
import com.ananth.mvvmkotlinsample.model.local.RepositoryEntity
import kotlinx.coroutines.flow.Flow

/**
 * @RepositoryDao - it helps us to access repo data object from the database
 * */

@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepositoryList(repositoryList:List<RepositoryEntity>)

    @Query("SELECT * FROM repository")
    fun retrieveRepositoryList():Flow<List<RepositoryEntity>>

    @Query("DELETE FROM repository")
    fun deleteRepositoryTable()
}