package com.example.newsapi.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.newsapi.MainAdapter;
import com.example.newsapi.NewsListener;
import com.example.newsapi.R;
import com.example.newsapi.model.ArticlesItem;
import com.example.newsapi.service.NewsService;

import java.util.List;

public class HomeFragment extends Fragment implements NewsListener {

    public HomeFragment() {
        // Required empty public constructor
    }

    RecyclerView rvRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvRecyclerView = view.findViewById(R.id.rv_recyclerview);
        new NewsService().getNews(this);
    }

    @Override
    public void onSuccess(List<ArticlesItem> items) {
        for(int i = 0; i < items.size(); i++){
            System.out.println("ISI DATA : " + items.get(i).getTitle());
            System.out.println(items.get(i).getDescription());
            System.out.println();
        }

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRecyclerView.setLayoutManager(linearLayoutManager);
        rvRecyclerView.setAdapter(new MainAdapter(items,getContext()));
    }

    @Override
    public void onFailed(String msg) {
        Log.d("ISI ERROR", msg);
    }
}