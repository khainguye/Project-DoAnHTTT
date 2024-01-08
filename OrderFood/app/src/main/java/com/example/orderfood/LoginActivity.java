package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.orderfood.Model.GioHang;
import com.example.orderfood.Model.HoaDon;
import com.example.orderfood.Model.KhachHang;
import com.example.orderfood.Model.MonAn;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText edtPhoneLogin, edtPasswordLogin;
    Button btnSignIn;
    public static KhachHang user;
    public static List<GioHang> listGioHangUser = new ArrayList<>();
    public static List<MonAn> listMon = new ArrayList<>();
    public static List<HoaDon> listHoaDon = new ArrayList<>();
    TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mapping();
        loadListMon();
        btnSignIn.setOnClickListener(v -> {
            SignIn();
        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void loadListMon() {
        if(listMon.size() > 0) {
            listMon.clear();
        }
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.duongDanSanPham, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                listMonAn.clear();

                for (int i = 0; i<response.length();i++)
                {
                    try {
                        JSONObject j = response.getJSONObject(i);
                        MonAn monAn = new MonAn(j.getInt("idMon"),
                                j.getString("tenMon"),
                                j.getString("moTa"),
                                j.getInt("gia"),
                                j.getString("anh"),
                                j.getInt("idLoai"));
                        listMon.add(monAn);
                    } catch (JSONException e) {
                        Log.d("TAG", "onResponse: "+e);
                        throw new RuntimeException(e+"loi");
                    }
                }
                Log.d(" mon LOGI", "listMon: "+listMon);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("loi", "onErrorResponse: "+error);
            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    private void SignIn() {
        String phone = edtPhoneLogin.getText().toString().trim();
        String password = edtPasswordLogin.getText().toString().trim();
        if (phone.equals("") || password.equals("")){
            Toast.makeText(this, "Nhập thiếu thông tin", Toast.LENGTH_SHORT).show();
        } else {
            RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://"+Server.localhost+"/serverTest/login.php?sdt="+phone
                    +"&matkhauL="+password, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i<response.length();i++)
                    {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            user = new KhachHang(jsonObject.getInt("idKhach"), jsonObject.getString("ten"), phone,
                                    password, jsonObject.getString("diaChi"));
                            if(user != null) {
                                loadGioHangUser(user);
                                loadHoaDon(user);
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }

                        } catch (JSONException e) {

                        }
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("loi", "onErrorResponse: "+error);
                    Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();

                }
            });
            requestQueue.add(jsonArrayRequest);
        }
    }

    private void loadHoaDon(KhachHang user) {
        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.getHoaDon+user.getIdKhach(), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i<response.length();i++)
                {
                    try {

                        JSONObject jsonObject = response.getJSONObject(i);
                        listHoaDon.add(new HoaDon(
                                jsonObject.getInt("idHoaDon"),
                                jsonObject.getInt("idKhach"),
                                jsonObject.getString("ngayDat"),
                                jsonObject.getString("diaChi"),
                                jsonObject.getString("sdt"),
                                jsonObject.getInt("tong")
                        ));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), ""+e, Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "onResponse: "+e);
                        throw new RuntimeException(e+"loi o day");
                    }
                }
                Log.d("LIST HD", "onResponse: "+listHoaDon);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("loi", "onErrorResponse: "+error);
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void loadGioHangUser(KhachHang user) {
        listGioHangUser.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.getGioHang+user.getIdKhach(), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i<response.length();i++)
                {
                    try {

                        JSONObject jsonObject = response.getJSONObject(i);
                        listGioHangUser.add(new GioHang(0,
                                jsonObject.getInt("idKhach"),
                                jsonObject.getInt("idMon"),
                                jsonObject.getString("anh"),
                                jsonObject.getInt("soLuong")
                        ));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), ""+e, Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "onResponse: "+e);
                        throw new RuntimeException(e+"loi o day");
                    }
                }
                Log.d("danh sahc gio LoGIN", "onResponse: "+listGioHangUser);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("loi", "onErrorResponse: "+error);
            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    private void mapping() {
        edtPhoneLogin = findViewById(R.id.edtPhoneLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvSignUp = findViewById(R.id.tvSignup);
    }

}