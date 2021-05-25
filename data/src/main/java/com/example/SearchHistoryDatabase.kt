package com.example

import androidx.room.Database
import com.example.data.local.dao.SearchHistoryDao
import com.example.data.local.entity.SearchHistoryEntity

@Database(
    entities = [SearchHistoryEntity::class], version = 1
)

abstract class SearchHistoryDatabase(){
    abstract fun searchHistory() : SearchHistoryDao
}