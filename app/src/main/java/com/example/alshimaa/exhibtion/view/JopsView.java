package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.JopsData;

import java.util.List;

public interface JopsView {
    void showJopsList(List<JopsData> jopsDataList);
    void showError();
}
