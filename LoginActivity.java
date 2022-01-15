package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button lg;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText) findViewById(R.id.userName1);
        password=(EditText) findViewById(R.id.password1);
        lg=findViewById(R.id.btnSignIn1);
        db=new DBHelper(this);

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else{
                    Boolean checkuserpass=db.checkusernamepassword(user,pass);

                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}