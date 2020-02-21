package com.example.mobicash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameText;
    EditText passwordText;
    Button loginBut;
    TextView registerTextV;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        usernameText = (EditText) findViewById(R.id.usernameET);
        passwordText = (EditText) findViewById(R.id.passwordET);
        loginBut = (Button) findViewById(R.id.loginBTN);
        registerTextV = (TextView) findViewById(R.id.registerTV);

        registerTextV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usernameText.getText().toString().trim();
                String pwd = passwordText.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if(res == true)
                {
                    Toast.makeText(LoginActivity.this, "successfully logged in", Toast.LENGTH_SHORT).show();
                    Intent LoginScreen = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(LoginScreen);
                }
                else
                    Toast.makeText(LoginActivity.this, "login error", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
