package com.example.infinitygym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class todaysSession extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays_session);
        button = (Button) findViewById(R.id.button14);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(todaysSession.this, login.class);
                startActivity(intent);
            }
        });
    }
}