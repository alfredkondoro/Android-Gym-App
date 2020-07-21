package com.example.infinitygym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu.this, signIntoTheGym.class);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.button14);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu.this, todaysSession.class);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.button15);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu.this, products.class);
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.button16);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu.this, nutritionHighlights.class);
                startActivity(intent);
            }
        });

        button5 = (Button) findViewById(R.id.button17);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu.this, account.class);
                startActivity(intent);
            }
        });
    }
}