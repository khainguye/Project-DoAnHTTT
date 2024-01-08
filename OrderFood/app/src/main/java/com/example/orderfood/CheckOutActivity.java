package com.example.orderfood;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.orderfood.Adapter.OrderListAdapter;
import com.example.orderfood.Model.HoaDon;
import com.example.orderfood.Model.MonAn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CheckOutActivity extends AppCompatActivity {
    ListView lvOrder;
    OrderListAdapter mOrderListAdapter;
    TextView tvTotal, tvAddress;
    ImageView btnChangeAdd, btnChangeShip;
    String address, phone , ngayDat;
    int idHoaDon;
    Button btnPayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Bundle bundle = getIntent().getExtras();
        mapping();
        if (bundle != null) {
            address = bundle.getString("address");
            phone = bundle.getString("phone");
            Toast.makeText(this, ""+address, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ""+phone, Toast.LENGTH_SHORT).show();
            tvAddress.setText(address);
        }


        btnChangeAdd.setOnClickListener(v -> {
            Intent intent = new Intent(CheckOutActivity.this, AddressActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
        // su kien nut payment
        btnPayment.setOnClickListener(v -> {
            addHoaDon();
        });
    }

    private void getIdHoaDon() {
        RequestQueue requestQueue = Volley.newRequestQueue(CheckOutActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.getIdHoaDon, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i<response.length();i++)
                {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        idHoaDon = jsonObject.getInt("idHoaDon");
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), ""+e, Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "onResponse: "+e);
                        throw new RuntimeException(e+"loi o day");
                    }
                }
                LoginActivity.listHoaDon.add(new HoaDon(Integer.valueOf(idHoaDon), LoginActivity.user.getIdKhach(),phone,address,ngayDat,Integer.valueOf(tvTotal.getText().toString().trim())));
                Toast.makeText(CheckOutActivity.this, "them bang hoa don", Toast.LENGTH_SHORT).show();
                MonAn itemMon;
                for(int i = 0; i < LoginActivity.listGioHangUser.size(); i++){
                    for(int j = 0; j < LoginActivity.listMon.size(); j++){
                        if(LoginActivity.listGioHangUser.get(i).getIdMon() == LoginActivity.listMon.get(j).getIdMon()){
                            itemMon = LoginActivity.listMon.get(j);
                            addChiTietHoaDon(LoginActivity.listGioHangUser.get(i).getIdMon(),LoginActivity.listGioHangUser.get(i).getSoLuong(),itemMon.getGia());
                        }
                    }
                }
                Intent intent = new Intent(CheckOutActivity.this, SuccessfulActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle bundle = new Bundle();
                bundle.putInt("idHoaDon", idHoaDon);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("loiGetId", "onErrorResponse: "+error);
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void addChiTietHoaDon(int idMon, int soLuong, int gia) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, Server.addChiTietHoaDon, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Success")){
                    for(int i = 0; i < LoginActivity.listGioHangUser.size(); i++) {
                        if(LoginActivity.listGioHangUser.get(i).getIdMon() == idMon){
                            LoginActivity.listGioHangUser.remove(i);
                            Toast.makeText(CheckOutActivity.this, "da xoa", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    throw new RuntimeException("loiADDChiTiet1: "+response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                throw new RuntimeException("loiADDChiTiet2: "+error);
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("idHoaDon", String.valueOf(idHoaDon));
                map.put("idMon", String.valueOf(idMon));
                map.put("soLuong", String.valueOf(soLuong));
                map.put("gia",String.valueOf(gia));
                return map;
            }
        };
        queue.add(request);
    }


    private void addHoaDon() {
        Toast.makeText(CheckOutActivity.this, ""+tvTotal.getText().toString(), Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, Server.addHoaDon, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Success")){
                    getIdHoaDon();

                }else{
                    throw new RuntimeException("loiAddHD: "+response);
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
                map.put("sdt", phone);
                map.put("diaChi", address);
                map.put("ngayDat",ngayDat);
                map.put("tong", tvTotal.getText().toString());
                return map;
            }
        };
        queue.add(request);
    }

    private void mapping() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ngayDat = currentDate.format(formatter);
        phone = LoginActivity.user.getSdt();
        address = LoginActivity.user.getDiaChi();
        btnPayment = findViewById(R.id.btnPayment);
        btnChangeAdd = findViewById(R.id.btnChangeAddress);
        btnChangeShip = findViewById(R.id.btnChangeShip);
        tvAddress = findViewById(R.id.tvAddress);
        lvOrder = findViewById(R.id.lvOrder);
        tvTotal = findViewById(R.id.tvTotalOrder);
        tvAddress.setText(LoginActivity.user.getDiaChi());
        mOrderListAdapter = new OrderListAdapter(CheckOutActivity.this, R.layout.item_order_list,LoginActivity.listGioHangUser);
        lvOrder.setAdapter(mOrderListAdapter);
        loadPrice();
    }
    public void loadPrice() {
        int toTal = 20000;
        for(int i = 0; i < LoginActivity.listGioHangUser.size(); i++) {
            for(int j = 0; j < LoginActivity.listMon.size(); j++) {
                if(LoginActivity.listGioHangUser.get(i).getIdMon() == LoginActivity.listMon.get(j).getIdMon()) {
                    toTal = toTal + LoginActivity.listGioHangUser.get(i).getSoLuong() * LoginActivity.listMon.get(j).getGia();
                }
            }
        }
        tvTotal.setText(String.valueOf(toTal));
    }
}