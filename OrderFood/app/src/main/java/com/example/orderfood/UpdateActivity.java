package com.example.orderfood;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {
    TextInputEditText edtName, edtAddress, edtPassword;
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        mapping();
        btnChange.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            String address = edtAddress.getText().toString().trim();
            updateInfo(name,password,address);
        });
    }

    private void updateInfo(String name, String password, String address) {
        RequestQueue queue = Volley.newRequestQueue(UpdateActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, Server.updateInfo, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Success")){
                    Toast.makeText(UpdateActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    LoginActivity.user.setTen(name);
                    LoginActivity.user.setPassword(password);
                    LoginActivity.user.setDiaChi(address);
                    Intent i = new Intent(UpdateActivity.this, MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }else{
                    throw new RuntimeException("loi: "+response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                throw new RuntimeException("loi: "+error);
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("idKhach", String.valueOf(LoginActivity.user.getIdKhach()));
                map.put("ten",name);
                map.put("matkhau",password);
                map.put("diaChi",address);
                return map;
            }
        };
        queue.add(request);
    }

    private void mapping() {
        edtName = findViewById(R.id.edtNameUpdate);
        edtPassword = findViewById(R.id.edtPasswordUpdate);
        edtAddress = findViewById(R.id.edtAddressUpdate);
        btnChange = findViewById(R.id.btnChangeInfo);
        edtName.setText(LoginActivity.user.getTen());
        edtPassword.setText(LoginActivity.user.getPassword());
        edtAddress.setText(LoginActivity.user.getDiaChi());
    }
}