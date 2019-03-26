package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;

import java.util.List;

public interface SearchHomeView {
    void showSearchHomeExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList);
    void showErrorHomeSearch(String Msg);
}
