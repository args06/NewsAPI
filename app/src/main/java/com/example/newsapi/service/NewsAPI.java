package com.example.newsapi.service;

import com.example.newsapi.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsAPI {
    static final String URL_BASE = "https://newsapi.org/";

    @GET("v2/top-headlines?country=us&apiKey=d2890b74ad774387bbf8258f8996075d")
    Call<NewsResponse> getNews();
}
