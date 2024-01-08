package com.example.myapplication2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication2.Model.GioHang;
import com.example.myapplication2.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GioHangAdapter extends BaseAdapter {
    Context context;
            int layout;
    List<GioHang> list;

    public GioHangAdapter(Context context, int layout, List<GioHang> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        TextView tvTen = convertView.findViewById(R.id.tvTenMonGioHang);
        TextView tvSl = convertView.findViewById(R.id.tvSLGioHang);
        ImageView img = convertView.findViewById(R.id.imgGioHang);
        ImageView btnCong = convertView.findViewById(R.id.btnCong);
        ImageView btnTru = convertView.findViewById(R.id.btnTru);
        GioHang gh = list.get(position);
        tvTen.setText(gh.getIdMon());
        tvSl.setText(String.valueOf(gh.getSoLuong()));
        Picasso.with(context).load(gh.getAnh()).into(img);
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = gh.getSoLuong()-1;
                tvSl.setText(String.valueOf(sl));
                updateGioHang(sl,gh);
            }
        });
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = gh.getSoLuong()+1;
                tvSl.setText(String.valueOf(sl));
                updateGioHang(sl,gh);
            }
        });
        return convertView;
    }

    private void updateGioHang(int sl, GioHang gh) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, Server.updateGioHang, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Success")){
                    Toast.makeText(context, "update ok", Toast.LENGTH_SHORT).show();
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
                map.put("idKhach", "1");
                map.put("idMon",String.valueOf(gh.getIdMon()));
                map.put("soLuong",String.valueOf(sl));
                return map;
            }
        };
        queue.add(request);
    }
}
