package com.mad.v1.rentalcarservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCarDetailsActivity extends AppCompatActivity {
        EditText etDriverName,etDriverPhoneNumber,etDriverLocation,etCarRegistrationNumber, etCarChassisNumber;
        Button btnAdd,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_details);
        init();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =etDriverName.getText().toString().trim();
                String phoneNumber =etDriverPhoneNumber.getText().toString().trim();
                String location =etDriverLocation.getText().toString().trim();
                String registrationNumber =etCarRegistrationNumber.getText().toString().trim();
                String chassisNumber =etCarChassisNumber.getText().toString().trim();

                checkValidAtion(name,phoneNumber,location,registrationNumber,chassisNumber);
                if(!name.isEmpty() && !phoneNumber.isEmpty() && ! location.isEmpty() && !registrationNumber.isEmpty() && !chassisNumber.isEmpty()){
                    Intent intent = new Intent();
                    intent.putExtra("name",name);
                    intent.putExtra("phone",phoneNumber);
                    intent.putExtra("location",location);
                    intent.putExtra("regNum",registrationNumber);
                    intent.putExtra("chassis",chassisNumber);
                    setResult(RESULT_OK,intent);
                    finish();
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

    private void checkValidAtion(String name, String phoneNumber, String location, String registrationNumber, String chassisNumber) {
        if(name.isEmpty())
                etDriverName.setError("Name Can't be Empty");
        if(phoneNumber.isEmpty())
            etDriverPhoneNumber.setError("PhoneNumber Can't be Empty");
        if(location.isEmpty())
            etDriverLocation.setError("Location Can't be Empty");
        if(registrationNumber.isEmpty())
            etCarRegistrationNumber.setError("Name Can't be Empty");
        if(chassisNumber.isEmpty())
            etCarChassisNumber.setError("Name Can't be Empty");
    }

    private void init() {
        etDriverLocation = findViewById(R.id.etDriverLocation);
        etDriverName = findViewById(R.id.etDriverName);
        etDriverPhoneNumber = findViewById(R.id.etDriverPhoneNumber);
        etCarChassisNumber = findViewById(R.id.etChessisNumber);
        etCarRegistrationNumber = findViewById(R.id.etCarRegistration);
        btnAdd= findViewById(R.id.btnAdd);
        btnCancel =findViewById(R.id.btn_Cancel);
    }
}