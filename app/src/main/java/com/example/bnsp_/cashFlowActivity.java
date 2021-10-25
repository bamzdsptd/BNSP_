package com.example.bnsp_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bnsp_.javaClass.CourseModal;
import com.example.bnsp_.javaClass.CustomCursorAdapter;
import com.example.bnsp_.javaClass.DBHelper;

import java.util.ArrayList;

public class cashFlowActivity extends AppCompatActivity {
    private ArrayList<CourseModal> courseModalArrayList;
    DBHelper databaseHelper;
    private CustomCursorAdapter courseRVAdapter;
    private RecyclerView coursesRV;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_flow);

        btnKembali = (Button) findViewById(R.id.btnKembali);


        courseModalArrayList = new ArrayList<>();
        databaseHelper = new DBHelper(cashFlowActivity.this);

        courseModalArrayList = databaseHelper.readCourses();

        courseRVAdapter = new CustomCursorAdapter(courseModalArrayList, cashFlowActivity.this);
        coursesRV = findViewById(R.id.idRVCourses);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(cashFlowActivity.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        coursesRV.setAdapter(courseRVAdapter);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                startActivity(intent);
            }
        });
    }

}