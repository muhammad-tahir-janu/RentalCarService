package com.mad.v1.rentalcarservice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ManagerActivity extends AppCompatActivity {
        TextView etManagerName;
        Button btnAddCarDetails,btnCheckCarDetails;
        private  final int ADD_CAR_DETAILS =2;
        String name,phoneNumber,location,carRegNumber,chassisNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        init();
        Intent intent = getIntent();
        String name  = intent.getStringExtra("name");
        etManagerName.setText("Hello Mr "+name);


        btnAddCarDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ManagerActivity.this,com.mad.v1.rentalcarservice.AddCarDetailsActivity.class);
                startActivityForResult(intent1,ADD_CAR_DETAILS);
            }
        });
        btnCheckCarDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ManagerActivity.this,com.mad.v1.rentalcarservice.ViewDetaislActivity.class);
                intent2.putExtra("name",name);
                intent2.putExtra("phone",phoneNumber);
                intent2.putExtra("loc",location);
                intent2.putExtra("reg",carRegNumber);
                intent2.putExtra("chassis",chassisNumber);
                startActivity(intent2);
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADD_CAR_DETAILS){
            if(resultCode == RESULT_OK){
                name= data.getStringExtra("name");
                phoneNumber= data.getStringExtra("phone");
                location= data.getStringExtra("location");
                carRegNumber= data.getStringExtra("regNum");
                chassisNumber= data.getStringExtra("chassis");
                btnCheckCarDetails.setVisibility(View.VISIBLE);

            }else if(resultCode==RESULT_CANCELED){
                Toast.makeText(this, "You have To Add CAR and Driver Details Before Check Details", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void init() {
        etManagerName = findViewById(R.id.tvShowUserName);
        btnAddCarDetails = findViewById(R.id.btnEnterCarDetails);
        btnCheckCarDetails= findViewById(R.id.btnCheckDetails);
        btnCheckCarDetails.setVisibility(View.INVISIBLE);

    }
}