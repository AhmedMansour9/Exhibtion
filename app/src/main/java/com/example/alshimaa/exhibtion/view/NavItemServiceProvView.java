package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.NavItemServiceProviderData;

import java.util.List;

public interface NavItemServiceProvView {
    void showNavItemServiceProvList(List<NavItemServiceProviderData> navItemServiceProviderDataList);
    void showError();

    void showSearchNavItemServiceProvList(List<NavItemServiceProviderData> navItemServiceProviderData);
    void showErrorSearch(String Msg);
}
