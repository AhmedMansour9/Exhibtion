package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.AboutUsResponse;
import com.example.alshimaa.exhibtion.model.HomeSiteOptionResponse;
import com.example.alshimaa.exhibtion.view.AboutUsView;
import com.example.alshimaa.exhibtion.view.HomeSiteOptionView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeSiteOptionPresenter {
    /*Context context;
    HomeSiteOptionView homeSiteOptionView;

    public HomeSiteOptionPresenter(Context context, HomeSiteOptionView homeSiteOptionView) {
        this.context = context;
        this.homeSiteOptionView = homeSiteOptionView;
    }

    public void getHomeSiteOptionResult()
    {

        Service service = Client.getClient().create( Service.class );
        Call<HomeSiteOptionResponse> call = service.getHomeSiteOptionData( );
        call.enqueue( new Callback<HomeSiteOptionResponse>() {
            @Override
            public void onResponse(Call<HomeSiteOptionResponse> call, Response<HomeSiteOptionResponse> response) {
                if(response.isSuccessful()) {
                    homeSiteOptionView.showHomeSiteOptionResult(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HomeSiteOptionResponse> call, Throwable t) {

                homeSiteOptionView.showError();
            }
        } );
    }*/
}
