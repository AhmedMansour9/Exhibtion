package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.adapter.HomeNewsAdapter;
import com.example.alshimaa.exhibtion.model.NewsData;
import com.example.alshimaa.exhibtion.presenter.HomeNewsPresenter;
import com.example.alshimaa.exhibtion.view.HomeNewsView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment /*implements HomeNewsView*/ {

    RecyclerView recyclerViewNews;
    HomeNewsAdapter homeNewsAdapter;
    HomeNewsPresenter homeNewsPresenter;
    public NewsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_news, container, false);
       /* init();
        News();*/
        return view;
    }

   /* private void init() {

        recyclerViewNews=view.findViewById(R.id.news_recycler);


    }
    private void News() {
        homeNewsPresenter=new HomeNewsPresenter(getContext(),this);
        if (Language.isRTL())
        {
            homeNewsPresenter.getHomeNewsResult("ar");
        }else
        {
            homeNewsPresenter.getHomeNewsResult("en");
        }
    }
    @Override
    public void showHomeNewsList(List<NewsData> newsDataList) {
        homeNewsAdapter=new HomeNewsAdapter( getContext(),newsDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewNews.setLayoutManager(linearLayoutManager);
        recyclerViewNews.setAdapter( homeNewsAdapter );
    }

    @Override
    public void showError() {

    }*/
}
