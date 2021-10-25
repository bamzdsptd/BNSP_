package com.example.bnsp_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pengaturanActivity extends AppCompatActivity {
    private Button btnKembali, btnSimpan;
    private EditText pwdNow, pwdNew;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        btnKembali = (Button) findViewById(R.id.btnKembali);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        pwdNow = (EditText) findViewById(R.id.pwdNow);
        pwdNew = (EditText) findViewById(R.id.pwdNew);
        DB = new DBHelper(this);


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pwNow = pwdNow.getText().toString();
                String pwNew = pwdNew.getText().toString();
                Boolean cekpwNow = DB.checkpassword(pwNow);

                if(cekpwNow == true){
                    DB.updatePassword(pwNew);
                    Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), pengaturanActivity.class);
                    startActivity(intent);
                }
//                if(pwNew.equals(" ") || pwNow.equals(" "))
//                    Toast.makeText(pengaturanActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
//                else {
//                    if(pwNew.equals(pwNow)){
//                        Toast.makeText(pengaturanActivity.this, "Failed !!", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Boolean checkpass = DB.checkpassword(pwNow);
//                        if(checkpass == false){
//
//                        }
//                        Intent intent = new Intent(getApplicationContext(), homeActivity.class);
//                        startActivity(intent);
//                    }
//
//                }
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                startActivity(intent);
            }
        });
    }
}