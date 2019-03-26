package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.HomeSliderData;

import java.util.List;

public interface HomeSliderView {
    void showHomeSliderResult(List<HomeSliderData> homeSliderDataList);
    void showError();
}
