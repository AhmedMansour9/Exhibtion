package com.example.alshimaa.exhibtion.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.alshimaa.exhibtion.R;

public class ConfirmRegisterNowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog dialog=new Dialog(this);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
       // dialog.setCancelable(false);
        setContentView(R.layout.activity_confirm_register_now);
    }
}
