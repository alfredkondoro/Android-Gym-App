package com.example.infinitygym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class menu extends AppCompatActivity {
    ImageButton session, signgym, nutrition, store;
    Button btnlogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnlogout = (Button) findViewById(R.id.btnlogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance ().signOut ();
                Intent backLogin = new Intent(menu.this, login.class);
                startActivity (backLogin);
            }
        });

        signgym = (ImageButton)findViewById (R.id.imgsign);
        session = (ImageButton)findViewById (R.id.imgsession);
        nutrition = (ImageButton)findViewById (R.id.imgnutrition);
        store= (ImageButton)findViewById (R.id.imgstore);

        signgym.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent signgymI = new Intent (menu.this, signIntoTheGym.class);
                startActivity (signgymI);
            }
        });

        session.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sessionI = new Intent (menu.this, todaysSession.class);
                startActivity (sessionI);
            }
        });

        nutrition.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent nutritionI = new Intent(menu.this, products.class);
                startActivity (nutritionI);
            }
        });

        store.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent storeI = new Intent(menu.this, nutritionHighlights.class);
                startActivity (storeI);
            }
        });
    }
}