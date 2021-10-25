package com.example.bnsp_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class cashFlowActivity extends AppCompatActivity {
    private ArrayList<CourseModal> courseModalArrayList;
    DBHelper databaseHelper;
    private CustomCursorAdapter courseRVAdapter;
    private RecyclerView coursesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_flow);

        courseModalArrayList = new ArrayList<>();
        databaseHelper = new DBHelper(cashFlowActivity.this);

        courseModalArrayList = databaseHelper.readCourses();

        courseRVAdapter = new CustomCursorAdapter(courseModalArrayList, cashFlowActivity.this);
        coursesRV = findViewById(R.id.idRVCourses);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(cashFlowActivity.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        coursesRV.setAdapter(courseRVAdapter);
    }

}