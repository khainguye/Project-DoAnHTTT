package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.orderfood.Adapter.HoaDonChiTietAdapter;
import com.example.orderfood.Model.HoaDon;
import com.example.orderfood.Model.HoaDonChiTiet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OrderDetalActivity extends AppCompatActivity {
    TextView tvPhone, tvAddress, tvTotal;
    ListView lvOrder;
    List<HoaDonChiTiet> mListChiTietHoaDon = new ArrayList<>();
    HoaDonChiTietAdapter mHoaDonChiTietAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detal);
        mapping();
        Intent intent = getIntent();
        HoaDon hd = (HoaDon) intent.getSerializableExtra("HoaDon");
        int idHoaDon = hd.getIdHoaDon();
        loadChiTietHoaDon(idHoaDon);

    }

    private void loadChiTietHoaDon(int idHoaDon) {
        mListChiTietHoaDon.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(OrderDetalActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.getHoaDonChiTiet+idHoaDon, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i<response.length();i++)
                {
                    try {

                        JSONObject jsonObject = response.getJSONObject(i);
                        mListChiTietHoaDon.add(new HoaDonChiTiet(
                                jsonObject.getInt("idHoaDon"),
                                jsonObject.getInt("idMon"),
                                jsonObject.getInt("soLuong"),
                                jsonObject.getInt("gia")
                        ));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), ""+e, Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "onResponse: "+e);
                        throw new RuntimeException(e+"loi o day");
                    }
                }
                mHoaDonChiTietAdapter.notifyDataSetChanged();
                Log.d("LIST HDCT", "onResponse: "+mListChiTietHoaDon);
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
        tvPhone = findViewById(R.id.tvPhoneDetail);
        tvAddress = findViewById(R.id.tvAddressDetail);
        tvTotal = findViewById(R.id.tvTotalOrderDetail);
        lvOrder = findViewById(R.id.lvOrderDetail);
        mHoaDonChiTietAdapter = new HoaDonChiTietAdapter(this, R.layout.item_order_list, mListChiTietHoaDon);
        lvOrder.setAdapter(mHoaDonChiTietAdapter);
    }
}