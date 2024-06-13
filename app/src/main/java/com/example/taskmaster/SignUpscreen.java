package com.example.taskmaster;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpscreen extends AppCompatActivity {

    TextView login;
    EditText userName;
    EditText password;
    EditText confirmPassword;
    EditText email;
    Button signup;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_upscreen);

        login=findViewById(R.id.textLogin);
        userName=findViewById(R.id.editUserName);
        password=findViewById(R.id.editTextpw);
        confirmPassword=findViewById(R.id.editTextconfirmpw);
        email=findViewById(R.id.editTextemail);
        signup=findViewById(R.id.SignUp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpscreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString();
                String pass = password.getText().toString();
                String confirmPass = confirmPassword.getText().toString();
                String mail = email.getText().toString();

                if (user.isEmpty() || pass.isEmpty() || confirmPass.isEmpty() || mail.isEmpty()) {
                    Toast.makeText(SignUpscreen.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!pass.equals(confirmPass)) {
                    Toast.makeText(SignUpscreen.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save user data to SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Username", user);
                editor.putString("Password", pass);
                editor.putString("Email", mail);
                editor.apply();

                Toast.makeText(SignUpscreen.this, "User registered successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SignUpscreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(SignUpscreen.this,MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }


    }
