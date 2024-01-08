package com.example.orderfood;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.orderfood.Model.HoaDon;
import com.example.orderfood.Model.MonAn;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    TextInputEditText edtName, edtPhone, edtPasswordS, edtAddress;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mapping();
        btnSignUp.setOnClickListener(v -> {
            if (edtName.getText().toString().equals("") || edtPhone.getText().toString().equals("") || edtPasswordS.getText().toString().equals("")
            || edtAddress.getText().toString().equals("")) {
                Toast.makeText(this, "Nhập thiếu thông tin!", Toast.LENGTH_SHORT).show();
            }else {
                int sdt = Integer.valueOf(edtPhone.getText().toString().trim());
                kiemTraTrungSdt(sdt);
            }

        });
    }

    private void kiemTraTrungSdt(int sdt) {
        RequestQueue requestQueue = Volley.newRequestQueue(SignUpActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.kiemTraSdt+sdt, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<String> kt = new ArrayList<>();
                for (int i = 0; i<response.length();i++)
                {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        kt.add(jsonObject.getString("sdt"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), ""+e, Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "onResponse: "+e);
                        throw new RuntimeException(e+"loi o day");
                    }
                }
                if(kt.size()>0){
                    Toast.makeText(SignUpActivity.this, "Số điện thoại này đã đươc đăng ký!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                signUp(edtName.getText().toString().trim(),edtPhone.getText().toString().trim(),
                        edtPasswordS.getText().toString().trim(),edtAddress.getText().toString().trim());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void mapping() {
        edtAddress = findViewById(R.id.edtAddressS);
        edtName = findViewById(R.id.edtNameSignUp);
        edtPasswordS = findViewById(R.id.edtPasswordS);
        edtPhone = findViewById(R.id.edtPhoneSignUp);
        btnSignUp = findViewById(R.id.btnSignUp);
    }
    private void signUp(String ten, String sdt, String matKhau, String diaChi) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, Server.addKhachHang, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equals("Success")){
                    Toast.makeText(SignUpActivity.this, "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    throw new RuntimeException(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("LOI SU", "onErrorResponse: "+error);
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("ten", ten);
                map.put("sdt",sdt);
                map.put("matkhau",matKhau);
                map.put("diaChi",diaChi);
                return map;
            }
        };
        queue.add(request);
    }

}