package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.ExhibtorsResponse;
import com.example.alshimaa.exhibtion.view.ExhibtorsView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExhibtorsPresenter {
    Context context;
    ExhibtorsView exhibtorsView;

    public ExhibtorsPresenter(Context context, ExhibtorsView exhibtorsView) {
        this.context = context;
        this.exhibtorsView = exhibtorsView;
    }

    public void getExhibtorsResult(String Lang,String Id_User)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("id_user",Id_User);
        Service service = Client.getClient().create( Service.class );
        Call<ExhibtorsResponse> call = service.getExhibtorsData(map );
        call.enqueue( new Callback<ExhibtorsResponse>() {
            @Override
            public void onResponse(Call<ExhibtorsResponse> call, Response<ExhibtorsResponse> response) {
                if(response.isSuccessful()) {
                    exhibtorsView.showExhibtorsList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ExhibtorsResponse> call, Throwable t) {
                exhibtorsView.showError();
            }
        } );
    }
}
