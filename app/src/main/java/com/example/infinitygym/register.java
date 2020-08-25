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

public class register extends AppCompatActivity {
    Button buttonSignUp;
    EditText emailId, password;
    TextView txtSignIn;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance ();
        emailId = findViewById (R.id.registerEmailText);
        password = findViewById (R.id.registerPasswordText);
        buttonSignUp = findViewById (R.id.registerButton);
        txtSignIn = findViewById (R.id.registerLoginText);
        buttonSignUp.setOnClickListener (new View.OnClickListener () {
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

                } else  if(email.isEmpty() && pwd.isEmpty()){
                        Toast.makeText(register.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                    }
                    else  if(!(email.isEmpty() && pwd.isEmpty())){
                        mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(!task.isSuccessful()){
                                    Toast.makeText(register.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    startActivity(new Intent(register.this, menu.class));
                                }
                            }
                        });
                    } else{
                        Toast.makeText(register.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                    }
                }
            });

        txtSignIn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent moveLogin = new Intent(register.this, login.class);
                startActivity (moveLogin);
            }
        });
    }
}