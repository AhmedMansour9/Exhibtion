package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.HomeServiceProviderResponse;
import com.example.alshimaa.exhibtion.model.HomeSliderResponse;
import com.example.alshimaa.exhibtion.view.HomeServiceProviderView;
import com.example.alshimaa.exhibtion.view.HomeSliderView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeServiceProviderPresenter {
   /* Context context;
    HomeServiceProviderView homeServiceProviderView;

    public HomeServiceProviderPresenter(Context context, HomeServiceProviderView homeServiceProviderView) {
        this.context = context;
        this.homeServiceProviderView = homeServiceProviderView;
    }

    public void getHomeServiceResult(String Lang)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        Service service = Client.getClient().create( Service.class );
        Call<HomeServiceProviderResponse> call = service.getHomeServiceProviderData(map );
        call.enqueue( new Callback<HomeServiceProviderResponse>() {
            @Override
            public void onResponse(Call<HomeServiceProviderResponse> call, Response<HomeServiceProviderResponse> response) {
                if(response.isSuccessful()) {
                    homeServiceProviderView.showHomeServiceProviderList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HomeServiceProviderResponse> call, Throwable t) {

                homeServiceProviderView.showError();
            }
        } );
    }*/
}
