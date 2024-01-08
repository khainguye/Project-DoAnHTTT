package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class AddressActivity extends AppCompatActivity {
    Button btnSave;
    TextInputEditText edtAddress, edtPhoneAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        mapping();
        btnSave.setOnClickListener(v -> {
            Intent intent = new Intent(AddressActivity.this, CheckOutActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("address",edtAddress.getText().toString());
            bundle.putString("phone",edtPhoneAddress.getText().toString());
            intent.putExtras(bundle);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }

    private void mapping() {
        btnSave = findViewById(R.id.btnSave);
        edtAddress = findViewById(R.id.edtAddressChange);
        edtPhoneAddress = findViewById(R.id.edtPhoneAddress);
    }
}