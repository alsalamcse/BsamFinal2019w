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

public class BarberLogIn extends AppCompatActivity {
    private EditText etEmail,etPassword;
    private Button btnSignIn;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_log_in);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
               signIn(etEmail.getText().toString(),etPassword.getText().toString());

            }
        });
    }
    private void dataHandler() {
        boolean isk=true;
        String email=etEmail.getText().toString();
        String passw1=etPassword.getText().toString();
        boolean isok = true;
        if (email.equalsIgnoreCase("thebarber@gmail.com")) {
            etEmail.setError("wrong email");
            isok = false;
        }
        if (passw1.equalsIgnoreCase("barber123456")){
            etPassword.setError("Have to be at least 8 char");
            isok = false;
        }
        if (isok) {
            signIn(email, passw1);
        }
    }

    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(BarberLogIn.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(BarberLogIn.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), AllDatesList.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(BarberLogIn.this, "signIn Failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

}

