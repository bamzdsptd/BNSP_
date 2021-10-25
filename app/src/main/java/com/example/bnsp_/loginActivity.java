package com.example.bnsp_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btnLogin, btnRegist;
    private DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView imgView = (ImageView)findViewById(R.id.imageView);
        imgView.setBackgroundResource(R.drawable.actualstore);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        DB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(loginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{

                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass == true) {
                        Toast.makeText(loginActivity.this, "Sign In Successfully", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(loginActivity.this, "Failed to Login, Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}