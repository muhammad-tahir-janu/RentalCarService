package com.mad.v1.rentalcarservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
        EditText etName,etUserName,etPassword,etConfirmPassword;
        Button btnSignUp,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String userName = etUserName.getText().toString().trim();
                String password = etPassword.getText().toString();
                String confirmPassWord = etConfirmPassword.getText().toString();

                checkValidation(name,userName,password,confirmPassWord);
                if(!name.isEmpty() && !userName.isEmpty() && !password.isEmpty() &&!confirmPassWord.isEmpty()){
                    if (password.equals(confirmPassWord)) {

                        Intent intent =new Intent();
                        intent.putExtra("name",name);
                        intent.putExtra("userName",userName);
                        intent.putExtra("password",password);
                        setResult(RESULT_OK, intent) ;
                        finish();
                    }else {
                        etConfirmPassword.setError("Confirm Password dose not Match");
                    }
                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();

            }
        });
    }

    private void checkValidation(String name, String userName, String password, String confirmPassWord) {
        if(name.isEmpty()){
            etName.setError("Name Can't be Empty");
        } if(userName.isEmpty()){
            etUserName.setError("UserName Can't be Empty");
        } if(password.isEmpty()){
            etPassword.setError("Password Can't be Empty");
        } if(confirmPassWord.isEmpty()){
            etConfirmPassword.setError("Confirm Password Can't be Empty");
        }
    }

    private void init() {
        etName =findViewById(R.id.etName);
        etUserName =findViewById(R.id.etUserName);
        etPassword =findViewById(R.id.etPassword);
        etConfirmPassword =findViewById(R.id.etConformPassword);
        btnSignUp = findViewById(R.id.btnSignUP);
        btnCancel = findViewById(R.id.btnCancel);

    }
}