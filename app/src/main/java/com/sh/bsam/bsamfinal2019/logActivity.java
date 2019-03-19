package com.sh.bsam.bsamfinal2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.sh.bsam.bsamfinal2019.BarberLogIn;
import com.sh.bsam.bsamfinal2019.PickDateActivity;
import com.sh.bsam.bsamfinal2019.R;
import com.sh.bsam.bsamfinal2019.SignUp;

public class logActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText etEmail,etPassword;
    private Button btnSignIn,btnTheBarber,btnSignUp,INTENT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnTheBarber = (Button) findViewById(R.id.btnTheBarber);
        INTENT = (Button) findViewById(R.id.INTENT);
        auth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });
        btnTheBarber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BarberLogIn.class);
                startActivity(intent);

            }
        });
        INTENT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PickDateActivity.class);
                startActivity(intent);

            }
        });
    }
        private void signIn (String email, String passw){
            auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(logActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(logActivity.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), PickDateActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(logActivity.this, "signIn Failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        task.getException().printStackTrace();
                    }
                }
            });
        }
    }





