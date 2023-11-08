package com.example.news_api.service

import com.example.news_api.model.NewsArticle

data class NewsApiResponse(
    val articles: List<NewsArticle>
)