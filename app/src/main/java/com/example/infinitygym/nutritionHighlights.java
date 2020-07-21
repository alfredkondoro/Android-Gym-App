package com.example.infinitygym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nutritionHighlights extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_highlights);
        button = (Button) findViewById(R.id.button18);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(nutritionHighlights.this, login.class);
                startActivity(intent);
            }
        });
    }
}