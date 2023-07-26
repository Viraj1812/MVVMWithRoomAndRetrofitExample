package com.hvdev.mvvmwithroomandretrofitexample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hvdev.mvvmwithroomandretrofitexample.models.Result

@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes() : List<Result>
}