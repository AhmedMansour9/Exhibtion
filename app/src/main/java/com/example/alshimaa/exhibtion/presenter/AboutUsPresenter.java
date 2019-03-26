package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.AboutUsResponse;
import com.example.alshimaa.exhibtion.model.HomeServiceProviderResponse;
import com.example.alshimaa.exhibtion.view.AboutUsView;
import com.example.alshimaa.exhibtion.view.HomeServiceProviderView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutUsPresenter {
    Context context;
    AboutUsView aboutUsView;

    public AboutUsPresenter(Context context, AboutUsView aboutUsView) {
        this.context = context;
        this.aboutUsView = aboutUsView;
    }

    public void getAboutUsResult(String Lang)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        Service service = Client.getClient().create( Service.class );
        Call<AboutUsResponse> call = service.getAboutUsData(map );
        call.enqueue( new Callback<AboutUsResponse>() {
            @Override
            public void onResponse(Call<AboutUsResponse> call, Response<AboutUsResponse> response) {
                if(response.isSuccessful()) {
                    aboutUsView.showAboutUsResult(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<AboutUsResponse> call, Throwable t) {

                aboutUsView.showError();
            }
        } );
    }
}
