package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.DetailsNavItemServiceProvData;

import java.util.List;

public interface DetailsNavItemServiceProvView {
    void showDetailsNavItemServiceProvList(List<DetailsNavItemServiceProvData> detailsNavItemServiceProvDataList);
    void showError();
}
