package com.example.alshimaa.exhibtion.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.fragment.DetailsExhibtionFragment;
import com.example.alshimaa.exhibtion.fragment.HomeFragment;
import com.example.alshimaa.exhibtion.presenter.NavigationServiceProviderPresenter;
import com.example.alshimaa.exhibtion.view.NavigationServiceProviderView;
import com.fourhcode.forhutils.FUtilsValidation;

public class RegisterActivity extends AppCompatActivity implements NavigationServiceProviderView {
    NavigationServiceProviderPresenter navigationServiceProviderPresenter;
    EditText userNameEtext,userEmailEtext,userPhoneEtext;

    NetworkConnection networkConnection;
    Button registerBtn;

/*
Intent intent;
String FairId;
*/
public static String RegisterFromCurExhib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        RegisterFromCurExhib = getIntent().getStringExtra("registerFromCurExhib");
        networkConnection=new NetworkConnection(this);


        RegisterAsVisitor();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegister();
            }
        });
    }

    private void performRegister() {
        FUtilsValidation.isEmpty( userNameEtext,getResources().getString(R.string.Pleasewriteyourname) );
        FUtilsValidation.isEmpty( userEmailEtext,getResources().getString( R.string.Pleasewriteyouremailaddress ));
        FUtilsValidation.isEmpty( userPhoneEtext,getResources().getString( R.string.Pleasewriteyourphone ));

        NetworkConnection networkConnection=new NetworkConnection( this );
        if (networkConnection.isNetworkAvailable( this ))
        {
            if(!userNameEtext.getText().toString().equals( "" )&&
                    !userEmailEtext.getText().toString().equals( "" )&&
                    !userPhoneEtext.getText().toString().equals("")&&
                    String.valueOf(RegisterNowActivity.FairId)!=null&&validateEmail())
            {
                        if(RegisterFromCurExhib.equals("yes"))
                        {
                            navigationServiceProviderPresenter.getRegisterAsVisitorResult( userNameEtext.getText().toString(),
                                    userEmailEtext.getText().toString(),userPhoneEtext.getText().toString()
                                    ,DetailsExhibtionFragment.ID);
                        }else{
                            navigationServiceProviderPresenter.getRegisterAsVisitorResult( userNameEtext.getText().toString(),
                                    userEmailEtext.getText().toString(),userPhoneEtext.getText().toString()
                                    ,String.valueOf(RegisterNowActivity.FairId));
                        }


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

    private void RegisterAsVisitor() {
        navigationServiceProviderPresenter=new NavigationServiceProviderPresenter(this,this);

    }

    private void init() {
        userNameEtext=findViewById(R.id.register_edit_text_name);
        userEmailEtext=findViewById(R.id.register_edit_text_email);
        userPhoneEtext=findViewById(R.id.register_edit_text_phone);
        /*FairId = getIntent().getStringExtra("idd");*/
        registerBtn=findViewById(R.id.register_btn_register);


    }

    @Override
    public void showNavServiceProviderData(String Msg) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showRegisterAsVisitorData(String Msg) {
        Toast.makeText(this, Msg, Toast.LENGTH_SHORT).show();
       Intent intent=new Intent(this,NavigationActivity.class);
       startActivity(intent);
    }
}
