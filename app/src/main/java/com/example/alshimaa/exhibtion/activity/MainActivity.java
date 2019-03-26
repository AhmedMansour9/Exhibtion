package com.example.alshimaa.exhibtion.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container
        ,new HomeFragment()).commit();
    }
}
