package com.example.alshimaa.exhibtion.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.fragment.HomeFragment;

public class LoginActivity extends AppCompatActivity {
TextView createNewAccount;
Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performcreateNewAccount();
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,NavigationActivity.class);
                startActivity(intent);
            }
        });

    }

    private void performcreateNewAccount() {
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    private void init() {
        createNewAccount=findViewById(R.id.login_text_create_account);
        loginBtn=findViewById(R.id.login_btn_login);
    }
}
