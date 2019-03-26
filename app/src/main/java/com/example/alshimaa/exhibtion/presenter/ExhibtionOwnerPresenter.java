package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.CallUsResponse;
import com.example.alshimaa.exhibtion.model.ExhibtionOwnerResponse;
import com.example.alshimaa.exhibtion.view.CallUsView;
import com.example.alshimaa.exhibtion.view.ExhibtionOwnerView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExhibtionOwnerPresenter {
    Context context;
    ExhibtionOwnerView exhibtionOwnerView;

    public ExhibtionOwnerPresenter(Context context, ExhibtionOwnerView exhibtionOwnerView) {
        this.context = context;
        this.exhibtionOwnerView = exhibtionOwnerView;
    }

    public void getExhibtionOwnerResult(String Name, String Email, String Phone,String Date_from,String Date_to
            ,String Location,String Msg)
    {
        Map<String,String> map=new HashMap<>(  );
        {
            map.put( "name",Name );
            map.put("email",Email);
            map.put("phone", Phone);
            map.put( "date_from",Date_from );
            map.put("date_to",Date_to);
            map.put( "location",Location );
            map.put("message",Msg);

            Service service= Client.getClient().create( Service.class );
            Call<ExhibtionOwnerResponse> call =service.getExhibtionOwnerData(  map);
            call.enqueue( new Callback<ExhibtionOwnerResponse>() {
                @Override
                public void onResponse(Call<ExhibtionOwnerResponse> call, Response<ExhibtionOwnerResponse> response) {
                    if (response.isSuccessful())
                    {
                        exhibtionOwnerView.showExhibtionOwnerMsg(response.body().getData());

                    }

                }

                @Override
                public void onFailure(Call<ExhibtionOwnerResponse> call, Throwable t) {
                    Toast.makeText( context, R.string.NoResultFound,
                            Toast.LENGTH_SHORT).show();
                }
            } );
        }
    }
}
