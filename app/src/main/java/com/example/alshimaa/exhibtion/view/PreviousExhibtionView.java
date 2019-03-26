package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionData;

import java.util.List;

public interface PreviousExhibtionView {
    void showPreviousExhibtionList(List<PreviousExhibtionData> previousExhibtionDataList);
    void showError();

    void showSearchPreviousExhibtionList(List<PreviousExhibtionData> previousExhibtionDataList);
    void showErrorSearchPrevious(String Msg);
}
