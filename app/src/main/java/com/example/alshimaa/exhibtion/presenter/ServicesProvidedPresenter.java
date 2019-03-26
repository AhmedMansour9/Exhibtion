package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionResponse;
import com.example.alshimaa.exhibtion.model.ServicesProvidedResponse;
import com.example.alshimaa.exhibtion.view.CurrentExhibtionView;
import com.example.alshimaa.exhibtion.view.ServicesProvidedView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicesProvidedPresenter {
    Context context;
    ServicesProvidedView servicesProvidedView;

    public ServicesProvidedPresenter(Context context, ServicesProvidedView servicesProvidedView) {
        this.context = context;
        this.servicesProvidedView = servicesProvidedView;
    }

    public void getServicesProvidedResult(String Lang,String Fairs_Id,String Id_user)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("fairs_id",Fairs_Id);
        map.put("id_user",Id_user);
        Service service = Client.getClient().create( Service.class );
        Call<ServicesProvidedResponse> call = service.getServicesProvidedData(map );
        call.enqueue( new Callback<ServicesProvidedResponse>() {
            @Override
            public void onResponse(Call<ServicesProvidedResponse> call, Response<ServicesProvidedResponse> response) {
                if(response.isSuccessful()) {
                    servicesProvidedView.showServicesProvidedList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ServicesProvidedResponse> call, Throwable t) {
                servicesProvidedView.showError();
            }
        } );
    }
}
