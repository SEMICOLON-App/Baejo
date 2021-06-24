package com.example.data.local.dao

import androidx.room.*
import com.example.data.local.entity.SearchHistoryEntity
import io.reactivex.Completable

@Dao
interface SearchHistoryDao {

    @Query("SELECT * FROM SearchHistoryEntity")
    fun getSearchHistoryList() : List<SearchHistoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchHistory(searchHistoryEntity: SearchHistoryEntity) : Completable

    @Delete
    fun deleteSearchHistory(searchHistoryEntity: SearchHistoryEntity) : Completable

    @Query("DELETE FROM SearchHistoryEntity")
    fun deleteAllSearchHistory() : Completable

}