package com.example.bnsp_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bnsp_.javaClass.DBHelper;

public class registerActivity extends AppCompatActivity {
    EditText username, password;
    Button btnRegist;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnRegist = (Button) findViewById(R.id.btnRegist1);
        DB = new DBHelper(this);

        btnRegist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(registerActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuser = DB.checkusername(user);
                    if(checkuser == false){
                        Boolean insert = DB.insertDataUsers(user,pass);
                        if(insert == true){
                            Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                            startActivity(intent);
                        }
                    }

                }


            }
        });


    }
}