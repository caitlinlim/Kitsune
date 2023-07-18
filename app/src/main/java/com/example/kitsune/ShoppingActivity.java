package com.example.kitsune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShoppingActivity extends AppCompatActivity {

    private Button viewMore1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_page);

        viewMore1 = (Button) findViewById(R.id.viewMore1);
        viewMore1.setOnClickListener(new View.OnClickListener() {
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
}