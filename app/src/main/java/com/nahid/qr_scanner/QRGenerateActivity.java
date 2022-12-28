package com.nahid.qr_scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRGenerateActivity extends AppCompatActivity {

    private MaterialButton btnQrGenerate;
    private ImageView qrImage;
    private EditText qrGenerateText;

    private MultiFormatWriter multiFormatWriter;
    private BitMatrix bitMatrix;
    private BarcodeEncoder encoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrgenerate);

        getSupportActionBar().hide();

        qrGenerateText = findViewById(R.id.txtQR);
        qrImage = findViewById(R.id.imgQr);
        btnQrGenerate = findViewById(R.id.btnGenerate);

        btnQrGenerate.setOnClickListener(view -> generateQrCode());
    }

    private void generateQrCode() {
        String qrText = qrGenerateText.getText().toString().trim();
        multiFormatWriter = new MultiFormatWriter();

        try {
            bitMatrix = multiFormatWriter.encode(qrText, BarcodeFormat.QR_CODE, 600, 600);
            encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(bitMatrix);
            qrImage.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}