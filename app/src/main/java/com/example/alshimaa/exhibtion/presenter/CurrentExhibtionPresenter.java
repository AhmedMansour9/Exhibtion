package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.AboutUsResponse;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionResponse;
import com.example.alshimaa.exhibtion.view.AboutUsView;
import com.example.alshimaa.exhibtion.view.CurrentExhibtionView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentExhibtionPresenter {
    Context context;
    CurrentExhibtionView currentExhibtionView;

    public CurrentExhibtionPresenter(Context context, CurrentExhibtionView currentExhibtionView) {
        this.context = context;
        this.currentExhibtionView = currentExhibtionView;
    }

    public void getCurrentExhibtionResult(String Lang)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        Service service = Client.getClient().create( Service.class );
        Call<CurrentExhibtionResponse> call = service.getCurrentExhibtionData(map );
        call.enqueue( new Callback<CurrentExhibtionResponse>() {
            @Override
            public void onResponse(Call<CurrentExhibtionResponse> call, Response<CurrentExhibtionResponse> response) {
                if(response.isSuccessful()) {
                    currentExhibtionView.showCurrentExhibtionList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<CurrentExhibtionResponse> call, Throwable t) {
                currentExhibtionView.showError();
            }
        } );
    }

    public void getSearchCurrentExhibtionResult(String Lang,String Key)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("key",Key);
        Service service = Client.getClient().create( Service.class );
        Call<CurrentExhibtionResponse> call = service.getsearchCurrentExhibtionData(map );
        call.enqueue( new Callback<CurrentExhibtionResponse>() {
            @Override
            public void onResponse(Call<CurrentExhibtionResponse> call, Response<CurrentExhibtionResponse> response) {
                if(response.isSuccessful()) {
                    currentExhibtionView.showSearchCurrentExhibtionList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<CurrentExhibtionResponse> call, Throwable t) {
                currentExhibtionView.showErrorSearch(context.getResources().getString(R.string.NoResultFound));
            }
        } );
    }



}
