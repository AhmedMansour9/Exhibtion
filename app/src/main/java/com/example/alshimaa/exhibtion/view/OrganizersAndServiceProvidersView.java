package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.OrganizersAndServiceProvidersData;
import com.example.alshimaa.exhibtion.model.SponsorData;

import java.util.List;

public interface OrganizersAndServiceProvidersView {
    void showOrganizersAndServiceProvidersList(List<OrganizersAndServiceProvidersData> organizersAndServiceProvidersDataList);
    void  showSponsorData(List<OrganizersAndServiceProvidersData> organizersAndServiceProvidersDataList);
    void showError();
}
