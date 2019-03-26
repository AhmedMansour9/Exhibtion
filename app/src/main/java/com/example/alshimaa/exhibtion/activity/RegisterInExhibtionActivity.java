package com.example.alshimaa.exhibtion.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.adapter.PreviousExhibtionAdapter;
import com.example.alshimaa.exhibtion.adapter.PuthesAdapter;
import com.example.alshimaa.exhibtion.fragment.DetailsExhibtionFragment;
import com.example.alshimaa.exhibtion.model.PuthesData;
import com.example.alshimaa.exhibtion.presenter.NavigationServiceProviderPresenter;
import com.example.alshimaa.exhibtion.presenter.PreviousExhibtionPresenter;
import com.example.alshimaa.exhibtion.presenter.PuthesPresenter;
import com.example.alshimaa.exhibtion.presenter.PuthesRegisterPresenter;
import com.example.alshimaa.exhibtion.view.OnClickMultipleChoiceCheckBox;
import com.example.alshimaa.exhibtion.view.PuthesRegisterView;
import com.example.alshimaa.exhibtion.view.PuthesView;
import com.fourhcode.forhutils.FUtilsValidation;

import java.util.List;

public class RegisterInExhibtionActivity extends AppCompatActivity implements PuthesView,PuthesRegisterView
,OnClickMultipleChoiceCheckBox{
Button registerNowBtn;

    RecyclerView recyclerViewPuthes;
    PuthesAdapter puthesAdapter;
    PuthesPresenter puthesPresenter;

    PuthesRegisterPresenter puthesRegisterPresenter;
    EditText userNameEtext,userEmailEtext,userPhoneEtext;
     String PartitionId="";
    NetworkConnection networkConnection;
    //Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_in_exhibtion);
        init();


       // Toast.makeText(this, RegisterNowActivity.FairId, Toast.LENGTH_SHORT).show();
        puthes();
        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent(RegisterInExhibtionActivity.this,ConfirmRegisterNowActivity.class);
                startActivity(intent);*/
                performRegisterNow();
            }
        });


    }

    private void performRegisterNow() {
        FUtilsValidation.isEmpty( userNameEtext,getResources().getString(R.string.Pleasewriteyourname) );
        FUtilsValidation.isEmpty( userEmailEtext,getResources().getString( R.string.Pleasewriteyouremailaddress ));
        FUtilsValidation.isEmpty( userPhoneEtext,getResources().getString( R.string.Pleasewriteyourphone ));
       for (int i=0;i<PuthesAdapter.IdList.size();i++){
            int L_Postion=PuthesAdapter.IdList.size()-1;
            if(L_Postion==i){
                PartitionId=PartitionId+PuthesAdapter.IdList.get(i).getId();
            }else {
                PartitionId=PartitionId+PuthesAdapter.IdList.get(i).getId()+",";
            }
        }

      //Toast.makeText(this, PartitionId, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "fair "+RegisterNowActivity.FairId+"  "+String.valueOf(PartitionId), Toast.LENGTH_SHORT).show();
        NetworkConnection networkConnection=new NetworkConnection( this );
        if (networkConnection.isNetworkAvailable( this ))
        {
            if(!userNameEtext.getText().toString().equals( "" )&&
                    !userEmailEtext.getText().toString().equals( "" )&&
                    !userPhoneEtext.getText().toString().equals("")&&
                   !RegisterNowActivity.FairId.equals("")&&validateEmail()
                    && !PartitionId.equals("")) //  partition id !=null
            {
                    puthesRegisterPresenter=new PuthesRegisterPresenter(getApplicationContext(),this);
                    puthesRegisterPresenter.getPuthesRegisterResult( userNameEtext.getText().toString()
                            ,
                            userEmailEtext.getText().toString()
                            ,userPhoneEtext.getText().toString()
                            ,RegisterNowActivity.FairId,PartitionId);

            }
            else
            {
                Toast.makeText( this, R.string.Pleasefullyourinformation, Toast.LENGTH_SHORT ).show();
            }

        }
        else
        {
            Toast.makeText( this, R.string.checkNetworkConnection
                    , Toast.LENGTH_SHORT ).show();
        }
    }

    private boolean validateEmail() {
        String EMAIL=userEmailEtext.getText().toString().trim();
        if (EMAIL.isEmpty()||!isValidEmail(EMAIL)){
            userEmailEtext.setError(getResources().getString(R.string.Invalidemail));

            return false;
        }else if(!userEmailEtext.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            userEmailEtext.setError(getResources().getString(R.string.Invalidemail));
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty( email )&&  android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void puthes() {
        puthesPresenter=new PuthesPresenter(getApplicationContext(),this);
        puthesPresenter.getPuthesResult(String.valueOf(RegisterNowActivity.FairId)); //id fair
    }

    private void init() {
        registerNowBtn=findViewById(R.id.register_in_exhibtion_btn_register);
        recyclerViewPuthes=findViewById(R.id.register_in_exhibtion_recycler_pollutant);
        userNameEtext=findViewById(R.id.register_in_exhibtion_edit_text_name);
        userEmailEtext=findViewById(R.id.register_in_exhibtion_edit_text_email);
        userPhoneEtext=findViewById(R.id.register_in_exhibtion_edit_text_phone);

    }

    @Override
    public void showPuthesList(List<PuthesData> puthesDataList) {
        puthesAdapter=new PuthesAdapter(getApplicationContext(),puthesDataList );
      puthesAdapter.onClick(this);
        recyclerViewPuthes.setLayoutManager( new LinearLayoutManager(getApplicationContext()));
        recyclerViewPuthes.setAdapter( puthesAdapter);
    }


    @Override
    public void showOnClickMultipleChoiceCheckBoxResult(String selectedPosition) {

    }

    @Override
    public void showPuthesRegisterMsg(String Msg) {
        Toast.makeText(this, Msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {

    }
}
