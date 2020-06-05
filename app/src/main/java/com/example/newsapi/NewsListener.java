package com.example.newsapi;

import com.example.newsapi.model.ArticlesItem;

import java.util.List;

public interface NewsListener {
    void onSuccess(List<ArticlesItem> items);
    void onFailed(String msg);
}
