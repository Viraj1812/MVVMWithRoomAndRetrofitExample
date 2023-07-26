package com.hvdev.mvvmwithroomandretrofitexample.api

import com.hvdev.mvvmwithroomandretrofitexample.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuote(@Query("page") page : Int) : Response<QuoteList>
}