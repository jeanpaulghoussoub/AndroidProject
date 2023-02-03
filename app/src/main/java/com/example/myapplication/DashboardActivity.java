package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        LinearLayout profileCard = findViewById(R.id.profile_card);
        LinearLayout weatherCard = findViewById(R.id.weather_card);
        LinearLayout contactListCard = findViewById(R.id.contact_list_card);
        LinearLayout emailCard = findViewById(R.id.email_card);

        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(DashboardActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
            }
        });

        weatherCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent weatherIntent = new Intent(DashboardActivity.this, WeatherActivity.class);
                startActivity(weatherIntent);
            }
        });

        contactListCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactListIntent = new Intent(DashboardActivity.this, ContactListActivity.class);
                startActivity(contactListIntent);
            }
        });

//        emailCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent emailIntent = new Intent(DashboardActivity.this, EmailActivity.class);
//                startActivity(emailIntent);
//            }
//        });
    }
}