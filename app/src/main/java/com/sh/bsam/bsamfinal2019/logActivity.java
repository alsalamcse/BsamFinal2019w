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

    }

        private void signIn (String email, String passw){
            auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(logActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(logActivity.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), todayActivity.class);
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






