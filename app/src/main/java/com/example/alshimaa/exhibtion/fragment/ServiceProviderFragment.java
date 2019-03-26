package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.presenter.CallUsPresenter;
import com.example.alshimaa.exhibtion.presenter.NavigationServiceProviderPresenter;
import com.example.alshimaa.exhibtion.view.NavigationServiceProviderView;
import com.fourhcode.forhutils.FUtilsValidation;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceProviderFragment extends Fragment implements NavigationServiceProviderView{
    NavigationServiceProviderPresenter navigationServiceProviderPresenter;
    EditText userNameEtext,userEmailEtext,userPhoneEtext,userMsgEtext,userTypeEtext;
    Button submitBtn;
    NetworkConnection networkConnection;

    public ServiceProviderFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_service, container, false);
        init();
        networkConnection=new NetworkConnection(getContext());
        NavServiceProvider();

        submitBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSubmit();
            }
        } );
        return view;
    }

    private void performSubmit() {
        FUtilsValidation.isEmpty( userNameEtext,getResources().getString(R.string.Pleasewriteyourname) );
        FUtilsValidation.isEmpty( userEmailEtext,getResources().getString( R.string.Pleasewriteyouremailaddress ));
        FUtilsValidation.isEmpty( userPhoneEtext,getResources().getString( R.string.Pleasewriteyourphone ));
        FUtilsValidation.isEmpty( userMsgEtext,getResources().getString( R.string.Pleaseleaveyourmsg));
        FUtilsValidation.isEmpty( userTypeEtext,getResources().getString( R.string.PleaseWriteServiceProvidedType));
        NetworkConnection networkConnection=new NetworkConnection( getContext() );
        if (networkConnection.isNetworkAvailable( getContext() ))
        {
            if(!userNameEtext.getText().toString().equals( "" )&&
                    !userEmailEtext.getText().toString().equals( "" )&&
                    !userPhoneEtext.getText().toString().equals("")&&
                    !userMsgEtext.getText().toString().equals("")&&
                    !userTypeEtext.getText().toString().equals("")&&validateEmail())
            {
                navigationServiceProviderPresenter.getNavigationServiceProviderResult( userNameEtext.getText().toString(),
                        userEmailEtext.getText().toString(),userPhoneEtext.getText().toString()
                        ,userMsgEtext.getText().toString(),userTypeEtext.getText().toString());
            }
            else
            {
                Toast.makeText( getContext(), R.string.Pleasefullyourinformation, Toast.LENGTH_SHORT ).show();
            }

        }
        else
        {
            Toast.makeText( getContext(), R.string.checkNetworkConnection
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

    private void NavServiceProvider() {
        navigationServiceProviderPresenter=new NavigationServiceProviderPresenter(getContext(),this);
    }

    private void init() {
        userNameEtext=view.findViewById(R.id.nav_service_provider_edit_text_name);
        userEmailEtext=view.findViewById(R.id.nav_service_provider_edit_text_email);
        userPhoneEtext=view.findViewById(R.id.nav_service_provider_edit_text_phone);
        userMsgEtext=view.findViewById(R.id.nav_service_provider_edit_text_msg);
        submitBtn=view.findViewById(R.id.nav_service_provider_btn_submit);
        userTypeEtext=view.findViewById(R.id.nav_service_provider_edit_text_type);
    }

    @Override
    public void showNavServiceProviderData(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {

    }

    @Override
    public void showRegisterAsVisitorData(String Msg) {

    }
}
