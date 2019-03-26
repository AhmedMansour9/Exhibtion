package com.example.alshimaa.exhibtion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.alshimaa.exhibtion.activity.LoginActivity;
import com.example.alshimaa.exhibtion.activity.MainActivity;
import com.example.alshimaa.exhibtion.activity.NavigationActivity;
import com.example.alshimaa.exhibtion.activity.VisitorActivity;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences shared;
    String Lan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView( R.layout.activity_splash );

        shared=getSharedPreferences("Language",MODE_PRIVATE);
        Lan=shared.getString("Lann",null);


        Thread timer=new Thread(  )
        {
            @Override
            public void run() {
                super.run();
                try {
                    sleep( 4000 );

                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }finally {
                    if(Lan!=null) {
                        Locale locale = new Locale(Lan);
                        Locale.setDefault(locale);
                        Configuration config = new Configuration();
                        config.locale = locale;
                        getBaseContext().getResources().updateConfiguration(config,
                                getBaseContext().getResources().getDisplayMetrics());
                    }
                        Intent intent=new Intent( SplashActivity.this,NavigationActivity.class);
                        startActivity( intent );
                    finish();
                }
            }
        };

        timer.start();

    }

}
