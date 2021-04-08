package com.mad.v1.rentalcarservice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText etLoginUserName , etLoginPassword;
        Button btnLogin , btnSignUp;
        final int SIGNUP_ACTIVITY=1;
        private Manager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginUserName = etLoginUserName.getText().toString().trim();
                String loginPassword = etLoginPassword.getText().toString();
                if (loginUserName.isEmpty()) {
                    etLoginUserName.setError("Please Enter UserName");
                }
                if (loginPassword.isEmpty()) {
                    etLoginPassword.setError("Pleae Enter Password");
                }
                String managerName = manager.getName();
                if (!loginUserName.isEmpty() && !loginPassword.isEmpty()) {
                    if (loginUserName.equals(manager.getUserName()) && loginPassword.equals(manager.getPassword())) {
                        Intent intent = new Intent(MainActivity.this, com.mad.v1.rentalcarservice.ManagerActivity.class);
                        intent.putExtra("name", managerName);
                        startActivity(intent);
                        finish();
                    } else {
                        etLoginPassword.setError("Invalid userName Or Password");
                    }
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.mad.v1.rentalcarservice.SignUp.class);
                startActivityForResult(intent,SIGNUP_ACTIVITY);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGNUP_ACTIVITY){
                if(resultCode==RESULT_OK){
                    manager.setName(data.getStringExtra("name"));
                    manager.setUserName(data.getStringExtra("userName"));
                    manager.setPassword(data.getStringExtra("password"));
                }else if(resultCode== RESULT_CANCELED){
                    Toast.makeText(this, "You Have SignUp before Login", Toast.LENGTH_LONG).show();
                }
        }
    }

    private void init() {
        etLoginUserName = findViewById(R.id.etLoginUserName);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.bntLogin);
        btnSignUp = findViewById(R.id.btnSignup);
        manager = new Manager();
    }
}