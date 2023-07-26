package com.hvdev.mvvmwithroomandretrofitexample.models

import com.hvdev.mvvmwithroomandretrofitexample.models.Result

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)