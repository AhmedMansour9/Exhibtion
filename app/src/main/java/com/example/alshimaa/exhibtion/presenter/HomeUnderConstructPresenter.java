package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.HomeUnderConstructResponse;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionResponse;
import com.example.alshimaa.exhibtion.view.HomeUnderConstructView;
import com.example.alshimaa.exhibtion.view.PreviousExhibtionView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeUnderConstructPresenter {
    Context context;
    HomeUnderConstructView homeUnderConstructView;

    public HomeUnderConstructPresenter(Context context, HomeUnderConstructView homeUnderConstructView) {
        this.context = context;
        this.homeUnderConstructView = homeUnderConstructView;
    }

    public void getHomeUnderConstructResult(String Lang)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        Service service = Client.getClient().create( Service.class );
        Call<HomeUnderConstructResponse> call = service.getHomeUnderConstructData(map );
        call.enqueue( new Callback<HomeUnderConstructResponse>() {
            @Override
            public void onResponse(Call<HomeUnderConstructResponse> call, Response<HomeUnderConstructResponse> response) {
                if(response.isSuccessful()) {
                    homeUnderConstructView.showHomeUnderConstructList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HomeUnderConstructResponse> call, Throwable t) {
                homeUnderConstructView.showError();
            }
        } );
    }
}
