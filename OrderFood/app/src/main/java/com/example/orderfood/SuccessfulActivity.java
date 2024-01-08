package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SuccessfulActivity extends AppCompatActivity {
    TextView tvIdHoaDon, btnContinue;
    int idHoaDon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful);
        mapping();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            idHoaDon = bundle.getInt("idHoaDon");
            tvIdHoaDon.setText(String.valueOf(idHoaDon));
        }
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessfulActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    private void mapping() {
        tvIdHoaDon = findViewById(R.id.tvIdHoaDon);
        btnContinue = findViewById(R.id.btnContinue);
    }
}