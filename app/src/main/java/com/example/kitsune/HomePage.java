package com.example.kitsune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    private Button onlineStoreButton;
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
    }
    public void openShoppingActivity() {
        Intent intent = new Intent(HomePage.this, ShoppingActivity.class);
        startActivity(intent);
    }
}