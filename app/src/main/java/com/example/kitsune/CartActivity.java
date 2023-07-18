package com.example.kitsune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kitsune.CheckoutActivity;
import com.example.kitsune.R;

public class CartActivity extends AppCompatActivity {

    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cartpage);

        checkoutButton = (Button) findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View view) {
              openItemActivity();
           }
      });
    }
  public void openItemActivity() {
       Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
     startActivity(intent);
   }
}