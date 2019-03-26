package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.AboutUsData;
import com.example.alshimaa.exhibtion.model.HomeServiceProviderData;

import java.util.List;

public interface AboutUsView {
    void showAboutUsResult(List<AboutUsData> aboutUsDataList);
    void showError();
}
