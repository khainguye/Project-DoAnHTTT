package com.example.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.orderfood.Fragment.HomeFragment;
import com.example.orderfood.Model.GioHang;
import com.example.orderfood.Model.MonAn;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    TextView tvTenMon, tvGia, tvMoTa;
    Button btnThem;
    CircleImageView btnBack;
    ImageView imgMonAn;
//    Spinner spinner;
    MonAn mMonAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_mon);
        mapping();
        Intent intent = getIntent();
        Bundle receivedBundle = intent.getExtras();
        mMonAn = (MonAn) receivedBundle.getSerializable("detail");
        loadThongtinChiTiet();
        btnBack.setOnClickListener(v -> {

        });
        btnThem.setOnClickListener(v -> {
           if(LoginActivity.user != null) {
               if(LoginActivity.listGioHangUser.size() > 0 ){
                   for(int i = 0; i < LoginActivity.listGioHangUser.size(); i++){
                       if(LoginActivity.listGioHangUser.get(i).getIdMon() == mMonAn.getIdMon()){
                           int Sl = LoginActivity.listGioHangUser.get(i).getSoLuong()+1;
                           LoginActivity.listGioHangUser.get(i).setSoLuong(Sl);
                           updateDataGioHang(Sl);
                           break;
                       }else{
                           Toast.makeText(this, "add1", Toast.LENGTH_SHORT).show();
                           LoginActivity.listGioHangUser.add(new GioHang(0,LoginActivity.user.getIdKhach(),mMonAn.getIdMon(),mMonAn.getAnh(),1));
                           addDataGioHang();
                       }
                   }

               }else {
                   Toast.makeText(this, "add2", Toast.LENGTH_SHORT).show();
                   LoginActivity.listGioHangUser.add(new GioHang(0,LoginActivity.user.getIdKhach(),mMonAn.getIdMon(),mMonAn.getAnh(),1));
                   addDataGioHang();
               }
           }else {
               //
           }


        });
    }


    private void updateDataGioHang(int sl) {
        Toast.makeText(this, "vao update gio hang", Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.POST, Server.updateGioHang, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Success")){
                    Toast.makeText(DetailActivity.this, "update thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                }else{
                    Toast.makeText(DetailActivity.this, ""+response, Toast.LENGTH_LONG).show();
                    throw new RuntimeException(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), ""+error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("idKhach", String.valueOf(LoginActivity.user.getIdKhach()));
                map.put("idMon",String.valueOf(mMonAn.getIdMon()));
                map.put("soLuong",String.valueOf(sl));
                return map;
            }
        };
        queue.add(request);
    }

    private void addDataGioHang() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.POST,Server.addGioHang, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Success")){
                    Intent intent2 = new Intent(DetailActivity.this, MainActivity.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent2);

                }else if(response.equals("Error")) {
                    Toast.makeText(DetailActivity.this, "insert ko thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), ""+error.getMessage(), Toast.LENGTH_LONG).show();
                throw new RuntimeException("loi:"+error);
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("idKhach", String.valueOf(LoginActivity.user.getIdKhach()));
                map.put("idMon",String.valueOf(mMonAn.getIdMon()));
                map.put("anh",mMonAn.getAnh());
                map.put("soLuong","1");
                return map;
            }
        };
        queue.add(request);
    }



    private void loadThongtinChiTiet() {
        Picasso.with(getApplicationContext()).load(mMonAn.getAnh()).into(imgMonAn);
        tvTenMon.setText(mMonAn.getTenMon());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvGia.setText("$ "+decimalFormat.format(mMonAn.getGia())+"");
        tvMoTa.setText(mMonAn.getMoTa());
    }

    private void mapping() {
        btnThem = findViewById(R.id.btnThemGioHang);
        tvGia = findViewById(R.id.tvGiaMonChiTiet);
        tvMoTa = findViewById(R.id.tvMoTa);
        tvTenMon = findViewById(R.id.tvTenMonChiTiet);
        imgMonAn = findViewById(R.id.imgAnhChiTiet);
        btnBack = findViewById(R.id.btnBack);
    }

}