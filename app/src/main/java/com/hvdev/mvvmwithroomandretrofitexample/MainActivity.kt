package com.hvdev.mvvmwithroomandretrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.hvdev.mvvmwithroomandretrofitexample.api.QuoteService
import com.hvdev.mvvmwithroomandretrofitexample.api.RetrofitHelper
import com.hvdev.mvvmwithroomandretrofitexample.repository.QuoteRepository
import com.hvdev.mvvmwithroomandretrofitexample.viewmodels.MainViewModel
import com.hvdev.mvvmwithroomandretrofitexample.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, {
            Toast.makeText(this@MainActivity,it.results.size.toString(),Toast.LENGTH_SHORT).show()
        })
    }
}