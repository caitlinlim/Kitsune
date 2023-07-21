package com.example.kitsune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kitsune.CheckoutActivity;
import com.example.kitsune.R;

public class ItemActivity extends AppCompatActivity {
    private Button buyNowButton;
    private Button homeButtonItem;
    private int leggingsId;
    private String leggingsPrice;
    private String leggingsName;
    private ImageView transferredLeggingsImage;
    private TextView transferredLeggingsPrice;
    private TextView transferredLeggingsName;
    private int mensTankId;
    private String mensTankPrice;
    private String mensTankName;
    private ImageView transferredMensTankImage;
    private TextView transferredMensTankPrice;
    private TextView transferredMensTankName;
    private int sportsBraId;
    private String sportsBraPrice;
    private String sportsBraName;
    private ImageView transferredSportsBraImage;
    private TextView transferredSportsBraPrice;
    private TextView transferredSportsBraName;
    private int shortsId;
    private String shortsPrice;
    private String shortsName;
    private ImageView transferredShortsImage;
    private TextView transferredShortsPrice;
    private TextView transferredShortsName;
    private int womensTankId;
    private String womensTankPrice;
    private String womensTankName;
    private ImageView transferredWomensTankImage;
    private TextView transferredWomensTankPrice;
    private TextView transferredWomensTankName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_page);

        buyNowButton = (Button) findViewById(R.id.buyNowButton);
        buyNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCheckoutActivity();
            }
        });

        homeButtonItem = (Button) findViewById(R.id.homeButtonItem);
        homeButtonItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getString("leggingsPrice") != null) {
                transferredLeggingsImage = (ImageView) findViewById(R.id.productImage);
                transferredLeggingsPrice = (TextView) findViewById(R.id.productPrice);
                transferredLeggingsName = (TextView) findViewById(R.id.productName);
                leggingsId = bundle.getInt("leggingsId");
                leggingsPrice = bundle.getString("leggingsPrice");
                leggingsName = bundle.getString("leggingsName");
                transferredLeggingsImage.setImageResource(leggingsId);
                transferredLeggingsPrice.setText(leggingsPrice);
                transferredLeggingsName.setText(leggingsName);
            }
            else if (bundle.getString("mensTankPrice") != null) {
                transferredMensTankImage = (ImageView) findViewById(R.id.productImage);
                transferredMensTankPrice = (TextView) findViewById(R.id.productPrice);
                transferredMensTankName = (TextView) findViewById(R.id.productName);
                mensTankId = bundle.getInt("mensTankId");
                mensTankPrice = bundle.getString("mensTankPrice");
                mensTankName = bundle.getString("mensTankName");
                transferredMensTankImage.setImageResource(mensTankId);
                transferredMensTankPrice.setText(mensTankPrice);
                transferredMensTankName.setText(mensTankName);
            }
            else if (bundle.getString("sportsBraPrice") != null) {
                transferredSportsBraImage = (ImageView) findViewById(R.id.productImage);
                transferredSportsBraPrice = (TextView) findViewById(R.id.productPrice);
                transferredSportsBraName = (TextView) findViewById(R.id.productName);
                sportsBraId = bundle.getInt("sportsBraId");
                sportsBraPrice = bundle.getString("sportsBraPrice");
                sportsBraName = bundle.getString("sportsBraName");
                transferredSportsBraImage.setImageResource(sportsBraId);
                transferredSportsBraPrice.setText(sportsBraPrice);
                transferredSportsBraName.setText(sportsBraName);
            }
            else if (bundle.getString("shortsPrice") != null) {
                transferredShortsImage = (ImageView) findViewById(R.id.productImage);
                transferredShortsPrice = (TextView) findViewById(R.id.productPrice);
                transferredShortsName = (TextView) findViewById(R.id.productName);
                shortsId = bundle.getInt("shortsId");
                shortsPrice = bundle.getString("shortsPrice");
                shortsName = bundle.getString("shortsName");
                transferredShortsImage.setImageResource(shortsId);
                transferredShortsPrice.setText(shortsPrice);
                transferredShortsName.setText(shortsName);
            }
            else if (bundle.getString("womensTankPrice") != null) {
                transferredWomensTankImage = (ImageView) findViewById(R.id.productImage);
                transferredWomensTankPrice = (TextView) findViewById(R.id.productPrice);
                transferredWomensTankName = (TextView) findViewById(R.id.productName);
                womensTankId = bundle.getInt("womensTankId");
                womensTankPrice = bundle.getString("womensTankPrice");
                womensTankName = bundle.getString("womensTankName");
                transferredWomensTankImage.setImageResource(womensTankId);
                transferredWomensTankPrice.setText(womensTankPrice);
                transferredWomensTankName.setText(womensTankName);
            }
        }
    }

    public void openCheckoutActivity() {
        Intent intent = new Intent(ItemActivity.this, CheckoutActivity.class);
        startActivity(intent);
    }

    public void openHomePage() {
        Intent intent = new Intent(ItemActivity.this, HomePage.class);
        startActivity(intent);
    }
}