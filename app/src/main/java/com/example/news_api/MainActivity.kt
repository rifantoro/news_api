package com.example.news_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.news_api.adapter.NewsAdapter
import com.example.news_api.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModels()
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.newsRecyclerView)
        adapter = NewsAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel.newsList.observe(this, Observer { newsList ->
            adapter.newsList = newsList ?: emptyList()
            adapter.notifyDataSetChanged()
        })

        viewModel.fetchNews()
    }
}