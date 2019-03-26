package com.example.alshimaa.exhibtion.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alshimaa.exhibtion.R;

public class VisitorActivity extends AppCompatActivity {
/*Button registerAsVisitorBtn;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);
      /*  init();
        registerAsVisitorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegisterAsVisitor();
            }
        });*/
    }

    /*private void performRegisterAsVisitor() {
        Intent intent=new Intent(VisitorActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    private void init() {
        registerAsVisitorBtn=findViewById(R.id.visitor_btn_register);
    }*/
}
