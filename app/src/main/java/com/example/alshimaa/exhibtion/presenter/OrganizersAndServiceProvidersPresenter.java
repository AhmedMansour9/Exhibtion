package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.HomeServiceProviderResponse;
import com.example.alshimaa.exhibtion.model.OrganizersAndServiceProvidersResponse;
import com.example.alshimaa.exhibtion.model.SponsorResponse;
import com.example.alshimaa.exhibtion.view.HomeServiceProviderView;
import com.example.alshimaa.exhibtion.view.OrganizersAndServiceProvidersView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrganizersAndServiceProvidersPresenter {
    Context context;
    OrganizersAndServiceProvidersView organizersAndServiceProvidersView;


    public OrganizersAndServiceProvidersPresenter(Context context, OrganizersAndServiceProvidersView organizersAndServiceProvidersView) {
        this.context = context;
        this.organizersAndServiceProvidersView = organizersAndServiceProvidersView;
    }

    public void getOrganizersAndServiceProvidersResult(String Lang,String Id_Fair)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("id_fair",Id_Fair);
        Service service = Client.getClient().create( Service.class );
        Call<OrganizersAndServiceProvidersResponse> call = service.getOrganizersAndServiceProvidersData(map );
        call.enqueue( new Callback<OrganizersAndServiceProvidersResponse>() {
            @Override
            public void onResponse(Call<OrganizersAndServiceProvidersResponse> call, Response<OrganizersAndServiceProvidersResponse> response) {
                if(response.isSuccessful()) {
                    organizersAndServiceProvidersView.showOrganizersAndServiceProvidersList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<OrganizersAndServiceProvidersResponse> call, Throwable t) {

                organizersAndServiceProvidersView.showError();
            }
        } );
    }
    public void getSponsorList(String Lang,String Id_Fair)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("id_fair",Id_Fair);
        Service service = Client.getClient().create( Service.class );
        Call<OrganizersAndServiceProvidersResponse> call = service.getSponsorData(map );
        call.enqueue( new Callback<OrganizersAndServiceProvidersResponse>() {
            @Override
            public void onResponse(Call<OrganizersAndServiceProvidersResponse> call, Response<OrganizersAndServiceProvidersResponse> response) {
                if(response.isSuccessful()) {
                   organizersAndServiceProvidersView.showSponsorData(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<OrganizersAndServiceProvidersResponse> call, Throwable t) {

                organizersAndServiceProvidersView.showError();
            }
        } );
    }
}
