package com.example.kitsune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    private Button onlineStoreButton;
    private Button monitorHealthButton;
    private Button workoutsButton;
    private Button socialNetworkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        onlineStoreButton = (Button) findViewById(R.id.onlineStoreButton);
        onlineStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShoppingActivity();
            }
        });

        monitorHealthButton = (Button) findViewById(R.id.monitorHealthButton);
        monitorHealthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHealthInfo();
            }
        });

        workoutsButton = (Button) findViewById(R.id.workoutsButton);
        workoutsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWorkoutInfo();
            }
        });

        socialNetworkButton = (Button) findViewById(R.id.socialNetworkButton);
        socialNetworkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSocialNetworkInfo();
            }
        });
    }
    public void openShoppingActivity() {
        Intent intent = new Intent(HomePage.this, ShoppingActivity.class);
        startActivity(intent);
    }
    public void openHealthInfo() {
        Intent intent = new Intent(HomePage.this, HealthInfo.class);
        startActivity(intent);
    }
    public void openWorkoutInfo() {
        Intent intent = new Intent(HomePage.this, WorkoutPage.class);
        startActivity(intent);
    }
    public void openSocialNetworkInfo() {
        Intent intent = new Intent(HomePage.this, FeedActivity.class);
        startActivity(intent);
    }
}