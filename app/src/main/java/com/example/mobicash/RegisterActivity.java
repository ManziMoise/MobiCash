package com.example.mobicash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    EditText usernameText;
    EditText passwordText;
    EditText confPasswordText;
    Button registerBut;
    TextView loginTextV;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        usernameText = (EditText) findViewById(R.id.usernameET);
        passwordText = (EditText) findViewById(R.id.passwordET);
        confPasswordText = (EditText) findViewById(R.id.conf_passwordET);
        registerBut = (Button) findViewById(R.id.registerBTN);
        loginTextV = (TextView) findViewById(R.id.loginTV);

        loginTextV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        registerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usernameText.getText().toString().trim();
                String pwd = passwordText.getText().toString().trim();
                String cnf_pwd = confPasswordText.getText().toString().trim();

                if (pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                            if( val > 0 ){
                                Toast.makeText(RegisterActivity.this, "Successfully  Registered", Toast.LENGTH_SHORT).show();
                                Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(moveToLogin);
                            } else{
                                Toast.makeText(RegisterActivity.this, "Registration error", Toast.LENGTH_SHORT).show();
                            }

                }else{
                    Toast.makeText(RegisterActivity.this, "The passwords don't match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
