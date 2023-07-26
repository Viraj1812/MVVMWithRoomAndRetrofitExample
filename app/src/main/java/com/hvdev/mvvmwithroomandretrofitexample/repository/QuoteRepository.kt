package com.hvdev.mvvmwithroomandretrofitexample.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hvdev.mvvmwithroomandretrofitexample.api.QuoteService
import com.hvdev.mvvmwithroomandretrofitexample.db.QuoteDatabase
import com.hvdev.mvvmwithroomandretrofitexample.models.QuoteList
import com.hvdev.mvvmwithroomandretrofitexample.utils.NetworkUtils

class QuoteRepository(private val quoteService: QuoteService, private val quoteDatabase: QuoteDatabase,private val applicationContext: Context) {

    private val quoteLiveData = MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList>
    get() = quoteLiveData

    suspend fun getQuotes(page: Int){

        if(NetworkUtils.isOnline(applicationContext)){
            val result = quoteService.getQuote(page)
            if(result?.body() != null)
            {
                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                quoteLiveData.postValue(result.body())
            }
        }
        else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,1,1,quotes,1,1)
            quoteLiveData.postValue(quoteList)
        }


    }

}