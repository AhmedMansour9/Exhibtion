package com.example.alshimaa.exhibtion.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.alshimaa.exhibtion.R;

public class ChangeLanguageActivity extends AppCompatActivity {
    SharedPreferences.Editor share;
    ImageView arabicLangImg,enlishLangImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog dialog=new Dialog( this );
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable( false );
        setContentView(R.layout.activity_change_language);
        init();
        share=getSharedPreferences("Language",MODE_PRIVATE).edit();
        arabicLangImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLangToArabic();
            }
        });
        enlishLangImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLangToEnglish();
            }
        });
    }

       private void changeLangToEnglish() {
        share.putString("Lann","en");
        share.commit();
        startActivity(new Intent(this, NavigationActivity.class));
        this.finish();
    }

    private void changeLangToArabic() {
        share.putString("Lann","ar");
        share.commit();
        startActivity(new Intent(this, NavigationActivity.class));
        this.finish();
    }

    private void init() {
        arabicLangImg=findViewById(R.id.change_language_arabic);
        enlishLangImg=findViewById(R.id.change_language_english);
    }
}
