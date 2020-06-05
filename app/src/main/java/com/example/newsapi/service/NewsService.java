package com.example.newsapi.service;

import com.example.newsapi.NewsListener;
import com.example.newsapi.model.NewsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsService {
    private Retrofit retrofit = null;

    public NewsAPI getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(NewsAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(NewsAPI.class);
    }

    public void getNews(final NewsListener listener){
        getAPI().getNews().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse data = response.body();

                if (data != null && data.getArticles() != null){
                    listener.onSuccess(data.getArticles()); //kayak return
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
