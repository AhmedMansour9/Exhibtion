package com.example.alshimaa.exhibtion.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.R;

public class RegisterNowActivity extends AppCompatActivity {
    Typeface customFontRegular;
    TextView titleTxt;
    Button exhibtorBtn,visitorBtn;

    Intent intent;
    public   static String FairId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog dialog=new Dialog( this );
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable( false );
        setContentView(R.layout.activity_register_now);
        init();
        customFontRegular = Typeface.createFromAsset( getAssets(), "DroidKufi-Regular.ttf" );
        titleTxt.setTypeface( customFontRegular );
        exhibtorBtn.setTypeface(customFontRegular);
        visitorBtn.setTypeface(customFontRegular);

        FairId = getIntent().getStringExtra("fair_id");// id=11



        exhibtorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterNowActivity.this
                        ,RegisterInExhibtionActivity.class);
                startActivity(intent);
            }
        });
        visitorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Intent intent=new Intent(RegisterNowActivity.this,RegisterActivity.class);
                intent.putExtra("idd",FairId);
              //  Toast.makeText(RegisterNowActivity.this,FairId, Toast.LENGTH_SHORT).show();
                startActivity(intent);*/
                intent=new Intent(RegisterNowActivity.this
                        ,RegisterActivity.class);
                intent.putExtra("registerFromCurExhib","no");
                startActivity(intent);
            }
        });
    }

    private void init() {
        titleTxt=findViewById(R.id.register_now_text_title);
        exhibtorBtn=findViewById(R.id.register_now_btn_exhibtor);
        visitorBtn=findViewById(R.id.register_now_btn_visitor);
    }
}
