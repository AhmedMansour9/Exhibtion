package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.adapter.ReasonSpinnerAdapter;
import com.example.alshimaa.exhibtion.presenter.CallUsPresenter;
import com.example.alshimaa.exhibtion.view.CallUsView;
import com.fourhcode.forhutils.FUtilsValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallUsFragment extends Fragment implements CallUsView{

    CallUsPresenter callUsPresenter;
    EditText userNameEtext,userPhoneEtext,userMsgEtext,userEmailEtext;
    Button sendBtn;

    NetworkConnection networkConnection;

  /* String[] SpinnerValue = {
            getResources().getString(R.string.AddingOffer),
           getResources().getString(R.string.Visit_the_exhibition),
           getResources().getString(R.string.Request_an_Offer)
    };*/
  String[] SpinnerValue = {
          "اضافة عرض",
          "زيارة معرض",
          "طلب عرض"
  };
   /* List<String> SpinnerValueList = new ArrayList<>();
        SpinnerValueList.add("Item 1");
        SpinnerValueList.add("Item 2");
        SpinnerValueList.add("Item 3");*/

    ReasonSpinnerAdapter reasonSpinnerAdapter;
    Spinner reasonSpinner;
String SelectedItemSpinner;

    public CallUsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_call_us, container, false);
        init();
        networkConnection=new NetworkConnection(getContext());
        callUs();


        ReasonSpinnerAdapter reasonSpinnerAdapter = new ReasonSpinnerAdapter(getContext(), R.layout.spinner_item);

       /* for (int i=0;i<SpinnerValueList.size();i++)
        {
            SelectedItemSpinner=SpinnerValueList.get(i);
        }*/
        reasonSpinnerAdapter.addAll(SpinnerValue);
        reasonSpinnerAdapter.add(getResources().getString(R.string.Reason));
        reasonSpinner.setAdapter(reasonSpinnerAdapter);
        reasonSpinner.setPrompt(getResources().getString(R.string.Reason));

        reasonSpinner.setSelection(reasonSpinnerAdapter.getCount());

        reasonSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub

                if(reasonSpinner.getSelectedItem() == getResources().getString(R.string.Reason))
                {

                    //Do nothing.
                }
                else{

                  //  SpinnerValue=reasonSpinner.getSelectedItem();
                    SelectedItemSpinner=reasonSpinner.getSelectedItem().toString();
                    /*callUsPresenter.getCallUsResult( userNameEtext.getText().toString(),
                            userEmailEtext.getText().toString(),userPhoneEtext.getText().toString()
                            ,userMsgEtext.getText().toString(),SelectedItemSpinner);*/

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        sendBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSend();
            }
        } );
        return view;
    }

    private void performSend() {
        FUtilsValidation.isEmpty( userNameEtext,getResources().getString(R.string.Pleasewriteyourname) );
        FUtilsValidation.isEmpty( userEmailEtext,getResources().getString( R.string.Pleasewriteyouremailaddress ));
        FUtilsValidation.isEmpty( userPhoneEtext,getResources().getString( R.string.Pleasewriteyourphone ));
        FUtilsValidation.isEmpty( userMsgEtext,getResources().getString( R.string.Pleaseleaveyourmsg));
        NetworkConnection networkConnection=new NetworkConnection( getContext() );
        if (networkConnection.isNetworkAvailable( getContext() ))
        {
            if(!userNameEtext.getText().toString().equals( "" )&&
                    !userEmailEtext.getText().toString().equals( "" )&&
                    !userPhoneEtext.getText().toString().equals("")&&
                    !userMsgEtext.getText().toString().equals("")&&SelectedItemSpinner!=null&&
                    validateEmail())
            {

                callUsPresenter.getCallUsResult( userNameEtext.getText().toString(),
                        userEmailEtext.getText().toString(),userPhoneEtext.getText().toString()
                ,userMsgEtext.getText().toString(),SelectedItemSpinner);
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

    private void callUs() {
        callUsPresenter=new CallUsPresenter(getContext(),this);
    }

    private void init() {
        userNameEtext=view.findViewById(R.id.call_us_edit_text_name);
        userEmailEtext=view.findViewById(R.id.call_us_edit_text_email);
        userPhoneEtext=view.findViewById(R.id.call_us_edit_text_phone);
        userMsgEtext=view.findViewById(R.id.call_us_edit_text_msg);
        sendBtn=view.findViewById(R.id.call_us_btn_send);
        reasonSpinner=view.findViewById( R.id.call_us_reason_spinner);
    }


    @Override
    public void showCallUsData(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {

    }
}
