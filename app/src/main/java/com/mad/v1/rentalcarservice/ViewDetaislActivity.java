package com.mad.v1.rentalcarservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewDetaislActivity extends AppCompatActivity {
        TextView tvName,tvReNUmber,tvChessisNumber;
        ImageView ivPhone,ivLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detaisl);
        init();
        Intent intent =getIntent();
        String name =intent.getStringExtra("name");
        String phone =intent.getStringExtra("phone");
        String loc =intent.getStringExtra("loc");
        String reg =intent.getStringExtra("reg");
        String che =intent.getStringExtra("chassis");
        tvName.setText("Driver Name  :  "+name);
        tvReNUmber.setText("Car Registration Number  :  "+reg);
        tvChessisNumber.setText("Chassis Number  :  "+che);
        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent1);
            }
        });
        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?"+loc));
                startActivity(intent1);
            }
        });
    }

    private void init() {
        tvName =findViewById(R.id.tvDriverNamw);
        tvReNUmber =findViewById(R.id.tvCarRegNumber);
        tvChessisNumber =findViewById(R.id.tvChessisNumber);
        ivPhone =findViewById(R.id.ivPhone);
        ivLocation =findViewById(R.id.ivlocation);
    }
}