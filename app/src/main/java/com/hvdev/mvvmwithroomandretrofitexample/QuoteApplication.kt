package com.hvdev.mvvmwithroomandretrofitexample

import android.app.Application
import com.hvdev.mvvmwithroomandretrofitexample.api.QuoteService
import com.hvdev.mvvmwithroomandretrofitexample.api.RetrofitHelper
import com.hvdev.mvvmwithroomandretrofitexample.db.QuoteDatabase
import com.hvdev.mvvmwithroomandretrofitexample.repository.QuoteRepository

class QuoteApplication: Application() {

    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize(){

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService,database,applicationContext)

    }

}