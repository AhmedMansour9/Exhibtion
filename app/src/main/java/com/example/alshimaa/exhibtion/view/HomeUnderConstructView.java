package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.AboutUsData;
import com.example.alshimaa.exhibtion.model.HomeUnderConstructData;

import java.util.List;

public interface HomeUnderConstructView {
    void showHomeUnderConstructList(List<HomeUnderConstructData> homeUnderConstructDataList);
    void showError();
}
