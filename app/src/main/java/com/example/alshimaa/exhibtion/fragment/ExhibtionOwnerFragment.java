package com.example.alshimaa.exhibtion.fragment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.activity.RegisterNowActivity;
import com.example.alshimaa.exhibtion.presenter.ExhibtionOwnerPresenter;
import com.example.alshimaa.exhibtion.presenter.NavigationServiceProviderPresenter;
import com.example.alshimaa.exhibtion.view.ExhibtionOwnerView;
import com.fourhcode.forhutils.FUtilsValidation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExhibtionOwnerFragment extends Fragment implements ExhibtionOwnerView{
TextView dateFromTxt,dateTotxt;

    ExhibtionOwnerPresenter exhibtionOwnerPresenter;
    EditText userNameEtext,userEmailEtext,userPhoneEtext,userLocation,userMsg;

    NetworkConnection networkConnection;
    Button submitBtn;
    final Calendar myCalendar = Calendar.getInstance();
    final Calendar myCalendar2 = Calendar.getInstance();

    public ExhibtionOwnerFragment() {
        // Required empty public constructor
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_exhibtion_owner, container, false);
        init();

        exhibtionOwnerPresenter=new ExhibtionOwnerPresenter(getContext(),this);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }


        };

        dateFromTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar2.set(Calendar.YEAR, year);
                myCalendar2.set(Calendar.MONTH, monthOfYear);
                myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel2();

            }


        };
        dateTotxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date2, myCalendar2
                        .get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH),
                        myCalendar2.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSubmit();
            }
        });
        return view;
    }

    private void updateLabel2() {
        String myFormat2 = "yy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf2 = new SimpleDateFormat(myFormat2, Locale.US);

        dateTotxt.setText(sdf2.format(myCalendar2.getTime()));
    }

    private void performSubmit() {
        FUtilsValidation.isEmpty( userNameEtext,getResources().getString(R.string.Pleasewriteyourname) );
        FUtilsValidation.isEmpty( userEmailEtext,getResources().getString( R.string.Pleasewriteyouremailaddress ));
        FUtilsValidation.isEmpty( userPhoneEtext,getResources().getString( R.string.Pleasewriteyourphone ));
        FUtilsValidation.isEmpty( userLocation,getResources().getString( R.string.pleaseWriteExhibtionLocation ));
        FUtilsValidation.isEmpty( userMsg,getResources().getString( R.string.pleaseleaveYourMessage));


        NetworkConnection networkConnection=new NetworkConnection( getContext() );
        if (networkConnection.isNetworkAvailable( getContext() ))
        {
            if(!userNameEtext.getText().toString().equals( "" )&&
                    !userEmailEtext.getText().toString().equals( "" )&&
                    !userPhoneEtext.getText().toString().equals("")&&
                    !dateFromTxt.getText().toString().equals("")&&
                    !dateTotxt.getText().toString().equals("")&&
                    !userLocation.getText().toString().equals("")&&
                    !userMsg.getText().toString().equals("")&&validateEmail())
            {
               /* Toast.makeText(getContext(), dateFromTxt.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), dateFromTxt.getText().toString()+" gettt", Toast.LENGTH_SHORT).show();
                */
                    exhibtionOwnerPresenter.getExhibtionOwnerResult( userNameEtext.getText().toString(),
                            userEmailEtext.getText().toString(),userPhoneEtext.getText().toString()
                            ,dateFromTxt.getText().toString(),dateTotxt.getText().toString(),
                    userLocation.getText().toString(),userMsg.getText().toString());



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

    private void updateLabel() {
        String myFormat = "yy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateFromTxt.setText(sdf.format(myCalendar.getTime()));

    }

    private void init() {
        dateFromTxt=view.findViewById(R.id.owner_text_start_date);
        dateTotxt=view.findViewById(R.id.owner_text_end_date);
        submitBtn=view.findViewById(R.id.owner_btn_submit);
        userNameEtext=view.findViewById(R.id.owner_edit_text_name);
        userEmailEtext=view.findViewById(R.id.owner_edit_text_email);
        userPhoneEtext=view.findViewById(R.id.owner_edit_text_phone);

        userLocation=view.findViewById(R.id.owner_edit_text_exhibtion_location);
        userMsg=view.findViewById(R.id.owner_edit_text_msg);


    }

    @Override
    public void showExhibtionOwnerMsg(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {

    }
}
