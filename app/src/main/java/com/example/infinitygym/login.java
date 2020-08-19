package com.example.infinitygym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    Button buttonSignIn, buttonSignUp;
    EditText emailId, password;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance ();
        emailId = findViewById (R.id.loginEmailText);
        password = findViewById (R.id.loginPasswordText);
        buttonSignIn = findViewById (R.id.loginButtonLogin);
        buttonSignUp = findViewById (R.id.loginButtonRegister);

        mAuthStateListener = new FirebaseAuth.AuthStateListener () {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser= mFirebaseAuth.getCurrentUser ();
                if(mFirebaseUser != null){
                    Toast.makeText (login.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent loggedIn = new Intent(login.this, menu.class);
                    startActivity (loggedIn);
                }
                else{
                    Toast.makeText (login.this, "Sign In Unsuccessful", Toast.LENGTH_SHORT).show ();
                }
            }
        };

        buttonSignIn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String email = emailId.getText ().toString ();
                String pwd = password.getText ().toString ();
                if (email.isEmpty ()) {
                    emailId.setError ("Please enter the Email");
                    emailId.requestFocus ();
                } else if (pwd.isEmpty ()) {
                    password.setError ("Please enter the password");
                    password.requestFocus ();
                }
                else if (email.isEmpty () && pwd.isEmpty ()) {
                    Toast.makeText (login.this, "Fields are empty", Toast.LENGTH_SHORT).show ();
                }
                else if (!(email.isEmpty () && pwd.isEmpty ())) {
                    mFirebaseAuth.signInWithEmailAndPassword (email, pwd).addOnCompleteListener (login.this, new OnCompleteListener<AuthResult> () {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful ()) {
                                Toast.makeText (login.this, "Login Error, try again!", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity (new Intent (login.this, menu.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText (login.this, "Error Occurred", Toast.LENGTH_SHORT).show ();
                }
            }
        });

        buttonSignUp.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(login.this, register.class);
                startActivity (signUp);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart ();
        mFirebaseAuth.addAuthStateListener (mAuthStateListener);
    }
}