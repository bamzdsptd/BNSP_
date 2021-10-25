package com.example.bnsp_;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bnsp_.javaClass.DBHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class pengeluaranActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText nominal, keterangan, tanggal;
    private ImageButton btnDatePicker;
    private Button btnSimpan, btnKembali;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tanggal = (EditText) findViewById(R.id.tanggal);
        nominal = (EditText) findViewById(R.id.nominal);
        keterangan = (EditText) findViewById(R.id.keterangan);
        btnDatePicker = (ImageButton) findViewById(R.id.btnDatePicker);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnKembali = (Button) findViewById(R.id.btnKembali);
        DB = new DBHelper(this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tanggals = tanggal.getText().toString();
                String nominals = nominal.getText().toString();
                Integer finalNominal = Integer.parseInt(nominals);
                String keterangans = keterangan.getText().toString();
                String status = "pengeluaran";

                Boolean insert = DB.insertDataCashFlow(tanggals,finalNominal,keterangans,status);
                if(insert==true){
                    Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), pengeluaranActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
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

    private void showDateDialog(){

        Calendar newCalendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tanggal.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
}