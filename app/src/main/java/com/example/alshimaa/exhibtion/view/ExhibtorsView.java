package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.ExhibtorsData;

import java.util.List;

public interface ExhibtorsView {
    void showExhibtorsList(List<ExhibtorsData> exhibtorsDataList);
    void showError();
}
