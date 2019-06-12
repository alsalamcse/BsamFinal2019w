package com.sh.bsam.bsamfinal2019;

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
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    private EditText etFirstName,etLastName,etEmail,etPassword,etPhoneNumber,etConfirmPassword;
    private Button btnSave;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
        btnSave = (Button) findViewById(R.id.btnSave);


        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();

            }
        });

    }



    private void dataHandler() {
        boolean isk=true;
        String email=etEmail.getText().toString();
        String passw1=etPassword.getText().toString();
        String passw2=etConfirmPassword.getText().toString();
        String fname=etFirstName.getText().toString();
        String lname=etLastName.getText().toString();
        String phone=etPhoneNumber.getText().toString();
        boolean isok = true;
        if (
                email.length() < 4 || email.indexOf('@') < 0 || email.indexOf('.') < 0
                ) {
            etEmail.setError("wrong email");
            isok = false;
        }
        if (passw1.length()<8){
            etPassword.setError("Have to be at least 8 char");
            isok = false;
        }
        if (!passw1.equals(passw2)){
            etConfirmPassword.setError("passwords have to be matched");
            isok = false;
        }

    }


    private void creatAcount (String email , String passw)
    {
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUp.this, "Authentication Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(SignUp.this,"Authentication Failed"+task.getException().toString(),Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });

    }


}



