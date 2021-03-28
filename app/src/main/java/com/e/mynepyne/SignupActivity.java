package com.e.mynepyne;

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

public class SignupActivity extends AppCompatActivity {

    EditText emailId, password;
    Button btnSignUp;
    TextView tvLogin;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editTextTextEmailAddress3);
        password = findViewById(R.id.editTextTextPassword4);
        btnSignUp = findViewById(R.id.button2);
        tvLogin = findViewById(R.id.textView1);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please enter your email");
                    emailId.requestFocus();
                }
                else if (pwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignupActivity.this, "Sign up Unsuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(SignupActivity.this, HomeActivity.class));
                            }

                        }
                    });
                }
                else {
                    Toast.makeText(SignupActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intoLogin = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intoLogin);
            }
        });
    }
}








