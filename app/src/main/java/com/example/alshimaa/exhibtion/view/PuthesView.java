package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.PuthesData;

import java.util.List;

public interface PuthesView {
    void showPuthesList(List<PuthesData> puthesDataList);
    void showError();
}
