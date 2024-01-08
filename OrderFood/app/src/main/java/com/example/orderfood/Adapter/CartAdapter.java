package com.example.orderfood.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.orderfood.Fragment.CartFragment;

import com.example.orderfood.LoginActivity;

import com.example.orderfood.Model.GioHang;
import com.example.orderfood.Model.MonAn;
import com.example.orderfood.R;
import com.example.orderfood.Server;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class CartAdapter extends BaseAdapter {
    Context mContext;
    int layout;
    List<GioHang> mList;

    public CartAdapter(Context mContext, int layout, List<GioHang> mList) {
        this.mContext = mContext;
        this.layout = layout;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
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
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =layoutInflater.inflate(layout, null);
        ImageView imgMonCart = convertView.findViewById(R.id.imgMonCart);
        TextView tvTenMonCart = convertView.findViewById(R.id.tvTenMonCart);
        TextView tvGiaCart = convertView.findViewById(R.id.tvGiaCart);
        TextView tvSlCart = convertView.findViewById(R.id.tvSlCart);
        CircleImageView btnMinus = convertView.findViewById(R.id.btnMinus);
        CircleImageView btnPlus = convertView.findViewById(R.id.btnPlus);
        GioHang gh = mList.get(position);
        // neu khach da dang nhap
//        if(MainActivity.user != null){
            Picasso.with(mContext).load(gh.getAnh()).into(imgMonCart);
            tvSlCart.setText(String.valueOf(gh.getSoLuong()));
            MonAn monAn = new MonAn();
            for(int i = 0; i < LoginActivity.listMon.size(); i++){
                if(gh.getIdMon() == LoginActivity.listMon.get(i).getIdMon()){
                    monAn = LoginActivity.listMon.get(i);
                }
            }
            Log.d("tenMon", " "+monAn);
            tvTenMonCart.setText(monAn.getTenMon());
            tvGiaCart.setText(String.valueOf(monAn.getGia()));
            if(gh.getSoLuong() == 1){
                btnMinus.setEnabled(false);
            }else {
                btnMinus.setEnabled(true);
            }
            //su kien nut tru
            btnMinus.setOnClickListener(v -> {
                int soLuongMoi = gh.getSoLuong() - 1;
                tvSlCart.setText(String.valueOf(soLuongMoi));
                LoginActivity.listGioHangUser.get(position).setSoLuong(soLuongMoi);
                CartFragment.loadPrice();
                if(LoginActivity.user != null) {
                    updateCart(soLuongMoi, gh);
                }

            });
            // event nut cong
            btnPlus.setOnClickListener(v -> {
                int soLuongMoi = gh.getSoLuong() + 1;
                tvSlCart.setText(String.valueOf(soLuongMoi));
                LoginActivity.listGioHangUser.get(position).setSoLuong(soLuongMoi);
                CartFragment.loadPrice();
                if(LoginActivity.user != null) {
                    updateCart(soLuongMoi, gh);
                }
            });
//        }else { // khach chua dang nhap
//
//        }
        return convertView;
    }



    private void updateCart(int soLuongMoi, GioHang gh) {
        RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest request = new StringRequest(Request.Method.POST, Server.updateGioHang, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Success")){

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
                map.put("idMon",String.valueOf(gh.getIdMon()));
                map.put("soLuong",String.valueOf(soLuongMoi));
                return map;
            }
        };
        queue.add(request);
    }
}
