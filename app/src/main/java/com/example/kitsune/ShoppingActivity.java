package com.example.kitsune;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ShoppingActivity extends AppCompatActivity {

    private Button homeButtonShopping;
    private RelativeLayout leggingsButton;
    private RelativeLayout mensTankButton;
    private RelativeLayout sportsBraButton;
    private RelativeLayout shortsButton;
    private RelativeLayout womensTankButton;
    private TextView leggingsPrice;
    private TextView leggingsName;
    private TextView mensTankPrice;
    private TextView mensTankName;
    private TextView sportsBraPrice;
    private TextView sportsBraName;
    private TextView shortsPrice;
    private TextView shortsName;
    private TextView womensTankPrice;
    private TextView womensTankName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_page);

        homeButtonShopping = (Button) findViewById(R.id.homeButtonShopping);
        homeButtonShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });

        leggingsPrice = (TextView) findViewById(R.id.leggingsPrice);
        String leggingsPriceToString = leggingsPrice.getText().toString();
        leggingsName = (TextView) findViewById(R.id.leggingsName);
        String leggingsNameToString = leggingsName.getText().toString();
        leggingsButton = (RelativeLayout) findViewById(R.id.leggingsButton);
        leggingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingActivity.this, ItemActivity.class);
                intent.putExtra("leggingsId", R.drawable.leggings);
                intent.putExtra("leggingsPrice", leggingsPriceToString);
                intent.putExtra("leggingsName", leggingsNameToString);
                startActivity(intent);
            }
        });

        mensTankPrice = (TextView) findViewById(R.id.mensTankPrice);
        String mensTankPriceToString = mensTankPrice.getText().toString();
        mensTankName = (TextView) findViewById(R.id.mensTankName);
        String mensTankNameToString = mensTankName.getText().toString();
        mensTankButton = (RelativeLayout) findViewById(R.id.mensTankButton);
        mensTankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingActivity.this, ItemActivity.class);
                intent.putExtra("mensTankId", R.drawable.menstank);
                intent.putExtra("mensTankPrice", mensTankPriceToString);
                intent.putExtra("mensTankName", mensTankNameToString);
                startActivity(intent);
            }
        });

        sportsBraPrice = (TextView) findViewById(R.id.sportsBraPrice);
        String sportsBraPriceToString = sportsBraPrice.getText().toString();
        sportsBraName = (TextView) findViewById(R.id.sportsBraName);
        String sportsBraNameToString = sportsBraName.getText().toString();
        sportsBraButton = (RelativeLayout) findViewById(R.id.sportsBraButton);
        sportsBraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingActivity.this, ItemActivity.class);
                intent.putExtra("sportsBraId", R.drawable.sportsbra);
                intent.putExtra("sportsBraPrice", sportsBraPriceToString);
                intent.putExtra("sportsBraName", sportsBraNameToString);
                startActivity(intent);
            }
        });

        shortsPrice = (TextView) findViewById(R.id.shortsPrice);
        String shortsPriceToString = shortsPrice.getText().toString();
        shortsName = (TextView) findViewById(R.id.shortsName);
        String shortsNameToString = shortsName.getText().toString();
        shortsButton = (RelativeLayout) findViewById(R.id.shortsButton);
        shortsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingActivity.this, ItemActivity.class);
                intent.putExtra("shortsId", R.drawable.mensshorts);
                intent.putExtra("shortsPrice", shortsPriceToString);
                intent.putExtra("shortsName", shortsNameToString);
                startActivity(intent);
            }
        });

        womensTankPrice = (TextView) findViewById(R.id.womensTankPrice);
        String womensTankPriceToString = womensTankPrice.getText().toString();
        womensTankName = (TextView) findViewById(R.id.womensTankName);
        String womensTankNameToString = womensTankName.getText().toString();
        womensTankButton = (RelativeLayout) findViewById(R.id.womensTankButton);
        womensTankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingActivity.this, ItemActivity.class);
                intent.putExtra("womensTankId", R.drawable.womenstank);
                intent.putExtra("womensTankPrice", womensTankPriceToString);
                intent.putExtra("womensTankName", womensTankNameToString);
                startActivity(intent);
            }
        });
    }

    public void openHomePage() {
        Intent intent = new Intent(ShoppingActivity.this, HomePage.class);
        startActivity(intent);
    }
}