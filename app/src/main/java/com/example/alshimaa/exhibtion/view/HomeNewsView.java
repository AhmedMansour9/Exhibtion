package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.HomeServiceProviderData;
import com.example.alshimaa.exhibtion.model.NewsData;

import java.util.List;

public interface HomeNewsView {
    void showHomeNewsList(List<NewsData> newsDataList);
    void showError();
}
