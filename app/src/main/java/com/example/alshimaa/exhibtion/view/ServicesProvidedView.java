package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.ServicesProvidedData;

import java.util.List;

public interface ServicesProvidedView {
    void showServicesProvidedList(List<ServicesProvidedData> servicesProvidedDataList);
    void showError();
}
