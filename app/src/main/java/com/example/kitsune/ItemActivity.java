package com.example.kitsune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kitsune.CheckoutActivity;
import com.example.kitsune.R;

public class ItemActivity extends AppCompatActivity {

    private Button addToCartButton;
    private Button buyNowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_page);

        addToCartButton = (Button) findViewById(R.id.addToCartButton);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemActivity();
            }
        });

        buyNowButton = (Button) findViewById(R.id.buyNowButton);
        buyNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCheckoutActivity();
            }
        });
    }
    public void openItemActivity() {
        Intent intent = new Intent(ItemActivity.this, CartActivity.class);
        startActivity(intent);
    }

    public void openCheckoutActivity() {
        Intent intent = new Intent(ItemActivity.this, CheckoutActivity.class);
        startActivity(intent);
    }
}