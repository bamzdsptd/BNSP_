package com.example.bnsp_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class homeActivity extends AppCompatActivity {

    private ImageButton btnPemasukkan, btnPengeluaran, btnCashFlow, btnPengaturan;
    private TextView txtPemasukkan, txtPengeluaran;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnPemasukkan = (ImageButton) findViewById(R.id.btnPemasukkan);
        btnPengeluaran = (ImageButton) findViewById(R.id.btnPengeluaran);
        btnCashFlow = (ImageButton) findViewById(R.id.btnCashFlow);
        btnPengaturan = (ImageButton) findViewById(R.id.btnPengaturan);
        txtPemasukkan = (TextView) findViewById(R.id.txtPemasukkan);
        txtPengeluaran = (TextView) findViewById(R.id.txtPengeluaran);
        DB = new DBHelper(this);

        String pemasukkan = "pemasukkan";
        String pengeluaran = "pengeluaran";

        Integer totalPemasukkan = DB.total(pemasukkan);
        Integer totalPengeluaran = DB.total(pengeluaran);

        String fixPemasukkan = "Pemasukkan : Rp. " + totalPemasukkan.toString();
        String fixPengeluaran = "Pengeluaran: Rp. " + totalPengeluaran.toString();

        txtPemasukkan.setText(fixPemasukkan);
        txtPengeluaran.setText(fixPengeluaran);

        btnPemasukkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pemasukkanActivity.class);
                startActivity(intent);
            }
        });

        btnPengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pengeluaranActivity.class);
                startActivity(intent);
            }
        });

        btnCashFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), cashFlowActivity.class);
                startActivity(intent);
            }
        });

        btnPengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pengaturanActivity.class);
                startActivity(intent);
            }
        });

    }
}
