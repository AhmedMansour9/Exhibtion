package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.NavigationServiceProviderResponse;
import com.example.alshimaa.exhibtion.model.PuthesRegisterResponse;
import com.example.alshimaa.exhibtion.view.NavigationServiceProviderView;
import com.example.alshimaa.exhibtion.view.PuthesRegisterView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuthesRegisterPresenter {
    Context context;
    PuthesRegisterView puthesRegisterView;

    public PuthesRegisterPresenter(Context context, PuthesRegisterView puthesRegisterView) {
        this.context = context;
        this.puthesRegisterView = puthesRegisterView;
    }

    public void getPuthesRegisterResult(String Name, String Email, String Phone, String Id_Fair, String Id_Partion)
    {
        Map<String,String> map=new HashMap<>(  );
        {
            map.put( "name",Name );
            map.put("email",Email);
            map.put("phone", Phone);
            map.put( "id_fair",Id_Fair );
            map.put("id_partion",Id_Partion);

            Service service= Client.getClient().create( Service.class );
            Call<PuthesRegisterResponse> call =service.getPuthesRegisterData(  map);
            call.enqueue( new Callback<PuthesRegisterResponse>() {
                @Override
                public void onResponse(Call<PuthesRegisterResponse> call, Response<PuthesRegisterResponse> response) {
                    if (response.isSuccessful())
                    {
                        puthesRegisterView.showPuthesRegisterMsg(response.body().getData());

                    }

                }

                @Override
                public void onFailure(Call<PuthesRegisterResponse> call, Throwable t) {
                    Toast.makeText( context, R.string.NoResultFound,
                            Toast.LENGTH_SHORT).show();
                }
            } );
        }
    }
}
