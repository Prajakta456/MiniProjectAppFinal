package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivityRegister extends AppCompatActivity {

    EditText username,password,retypepassword;
    Button signup,signin;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);


        username=(EditText) findViewById(R.id.userName);
        password=(EditText) findViewById(R.id.password);
        retypepassword=(EditText) findViewById(R.id.retypePassword);
        signin=(Button) findViewById(R.id.btnSignIn);
        signup=(Button)findViewById(R.id.btnSignUp);
        db=new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=retypepassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass==""){
                    Toast.makeText(MainActivityRegister.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else{
                    if(pass.equals(repass)){
                        Boolean checkuser=db.checkusername(user);

                        if(checkuser==false){
                            Boolean insert=db.insertData(user, pass);

                            if(insert==true){
                                Toast.makeText(MainActivityRegister.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(MainActivityRegister.this, "Registered failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivityRegister.this, "User already exists!Please sign in", Toast.LENGTH_SHORT).show();
                        }

                    }

                    else{
                        Toast.makeText(MainActivityRegister.this, "Passwords not matching!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
