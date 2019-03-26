package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionResponse;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionResponse;
import com.example.alshimaa.exhibtion.view.CurrentExhibtionView;
import com.example.alshimaa.exhibtion.view.PreviousExhibtionView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreviousExhibtionPresenter {
    Context context;
    PreviousExhibtionView previousExhibtionView;

    public PreviousExhibtionPresenter(Context context, PreviousExhibtionView previousExhibtionView) {
        this.context = context;
        this.previousExhibtionView = previousExhibtionView;
    }

    public void getPreviousExhibtionResult(String Lang)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        Service service = Client.getClient().create( Service.class );
        Call<PreviousExhibtionResponse> call = service.getPreviousExhibtionData(map );
        call.enqueue( new Callback<PreviousExhibtionResponse>() {
            @Override
            public void onResponse(Call<PreviousExhibtionResponse> call, Response<PreviousExhibtionResponse> response) {
                if(response.isSuccessful()) {
                    previousExhibtionView.showPreviousExhibtionList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<PreviousExhibtionResponse> call, Throwable t) {
                previousExhibtionView.showError();
            }
        } );
    }

    public void getSearchPreviousExhibtionResult(String Lang,String Key)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("key",Key);
        Service service = Client.getClient().create( Service.class );
        Call<PreviousExhibtionResponse> call = service.getSearchPreviousExhibtionData(map );
        call.enqueue( new Callback<PreviousExhibtionResponse>() {
            @Override
            public void onResponse(Call<PreviousExhibtionResponse> call, Response<PreviousExhibtionResponse> response) {
                if(response.isSuccessful()) {
                    previousExhibtionView.showSearchPreviousExhibtionList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<PreviousExhibtionResponse> call, Throwable t) {
                previousExhibtionView.showErrorSearchPrevious(context.getResources().getString(R.string.NoResultFound));
            }
        } );
    }

}
