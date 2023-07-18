package com.example.kitsune;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ShoppingActivity extends AppCompatActivity {

    private ImageView cartIcon;
    private RelativeLayout leggingsButton;
    private RelativeLayout mensTankButton;
    private RelativeLayout sportsBraButton;
    private RelativeLayout shortsButton;
    private RelativeLayout womensTankButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_page);

        cartIcon = (ImageView) findViewById(R.id.cartIcon);
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCartActivity();
            }
        });

        leggingsButton = (RelativeLayout) findViewById(R.id.leggingsButton);
        leggingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemActivity();
            }
        });

        mensTankButton = (RelativeLayout) findViewById(R.id.mensTankButton);
        mensTankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemActivity();
            }
        });

        sportsBraButton = (RelativeLayout) findViewById(R.id.sportsBraButton);
        sportsBraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemActivity();
            }
        });

        shortsButton = (RelativeLayout) findViewById(R.id.shortsButton);
        shortsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemActivity();
            }
        });

        womensTankButton = (RelativeLayout) findViewById(R.id.womensTankButton);
        womensTankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemActivity();
            }
        });
    }
    public void openItemActivity() {
        Intent intent = new Intent(ShoppingActivity.this, ItemActivity.class);
        startActivity(intent);
    }

    public void openCartActivity() {
        Intent intent = new Intent(ShoppingActivity.this, CartActivity.class);
        startActivity(intent);
    }
}