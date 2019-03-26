package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.HomeSliderResponse;
import com.example.alshimaa.exhibtion.view.HomeSliderView;


import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeSliderPresenter {
    Context context;
    HomeSliderView homeSliderView;

    public HomeSliderPresenter(Context context, HomeSliderView homeSliderView) {
        this.context = context;
        this.homeSliderView = homeSliderView;
    }

    public void getHomeSliderResult(String Lang)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        Service service = Client.getClient().create( Service.class );
        Call<HomeSliderResponse> call = service.getHomeSliderData(map );
        call.enqueue( new Callback<HomeSliderResponse>() {
            @Override
            public void onResponse(Call<HomeSliderResponse> call, Response<HomeSliderResponse> response) {
                if(response.isSuccessful()) {
                    homeSliderView.showHomeSliderResult(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HomeSliderResponse> call, Throwable t) {

                homeSliderView.showError();
            }
        } );
    }
}
