package com.nahid.qr_scanner;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton btnScan, btnGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnGenerate = findViewById(R.id.btnQrGenerate);
        btnScan = findViewById(R.id.btnScan);

        btnScan.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ScannerActivity.class)));
        btnGenerate.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,QRGenerateActivity.class)));

    }

}