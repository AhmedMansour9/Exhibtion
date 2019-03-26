package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.EShopData;

import java.util.List;

public interface EShopView {
    void showEshopDataList(List<EShopData> eShopDataList);
    void showError();
}
