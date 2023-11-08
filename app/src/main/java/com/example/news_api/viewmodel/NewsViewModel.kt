package com.example.news_api.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_api.model.NewsArticle
import com.example.news_api.service.NewsApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
public class NewsViewModel @Inject constructor(
    private val newsApiService: NewsApiService
) : ViewModel() {

    val newsList = MutableLiveData<List<NewsArticle>>()

    fun fetchNews() {
        viewModelScope.launch {
            val response = newsApiService.getNews("tesla", "2023-10-07", "publishedAt", "aec2d0d9b7b1449dbb6fad6bf6a1a201")
            if (response.isSuccessful) {
                newsList.postValue(response.body()?.articles)
            }
        }
    }
}