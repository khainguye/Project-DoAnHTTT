package com.example.orderfood.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.orderfood.Adapter.CartAdapter;
import com.example.orderfood.CheckOutActivity;
import com.example.orderfood.LoginActivity;
import com.example.orderfood.MainActivity;
import com.example.orderfood.Model.GioHang;
import com.example.orderfood.Model.MonAn;
import com.example.orderfood.R;
import com.example.orderfood.Server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartFragment extends Fragment {
    View mView;
    ListView lvCart;
    static TextView tvGiaGio;
    Button btnCheckOut;
    CartAdapter cartAdapter;
    public CartFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView =  inflater.inflate(R.layout.fragment_cart, container, false);
        mapping();
        if(LoginActivity.user != null) {
            if(LoginActivity.listGioHangUser.size() > 0){
                cartAdapter = new CartAdapter(getActivity(),R.layout.item_cart, LoginActivity.listGioHangUser);
                lvCart.setAdapter(cartAdapter);
                loadPrice();
                btnCheckOut.setEnabled(true);
            }else {
                btnCheckOut.setEnabled(false);
            }

            btnCheckOut.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), CheckOutActivity.class);
                startActivity(intent);
            });
            //su kie xoa item trong gio hang
            lvCart.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                    alertDialogBuilder.setTitle("Xác nhận xóa..!!!");
                    alertDialogBuilder.setMessage("Bạn có chắc xóa?");
                    alertDialogBuilder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteGioHang(LoginActivity.listGioHangUser.get(i));
                            LoginActivity.listGioHangUser.remove(LoginActivity.listGioHangUser.get(i));
                        }
                    });
                    alertDialogBuilder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertDialogBuilder.show();
                    return false;
                }
            });
        }
        return mView;
    }

    private void deleteGioHang(GioHang gioHang) {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.POST, Server.delGioHang, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Success")){
                    cartAdapter.notifyDataSetChanged();
                    loadPrice();
                    if(LoginActivity.listGioHangUser.size() == 0){
                        btnCheckOut.setEnabled(false);
                    }else {
                        btnCheckOut.setEnabled(true);
                    }
                }else if(response.equals("Error")) {
                    Toast.makeText(getActivity(), "xoa ko thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                throw new RuntimeException("loi:"+error);
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("idKhach", String.valueOf(gioHang.getIdKhach()));
                map.put("idMon",String.valueOf(gioHang.getIdMon()));
                return map;
            }
        };
        queue.add(request);
    }

    public static void loadPrice() {

        int toTal = 0;
        for(int i = 0; i < LoginActivity.listGioHangUser.size(); i++) {
            for(int j = 0; j < LoginActivity.listMon.size(); j++) {
                if(LoginActivity.listGioHangUser.get(i).getIdMon() == LoginActivity.listMon.get(j).getIdMon()) {
                    toTal = toTal + LoginActivity.listGioHangUser.get(i).getSoLuong() * LoginActivity.listMon.get(j).getGia();
                }
            }
        }
        tvGiaGio.setText(String.valueOf(toTal));
    }

    private void mapping() {
        lvCart = mView.findViewById(R.id.lvCart);
        btnCheckOut = mView.findViewById(R.id.btnCheckOut);
        tvGiaGio = mView.findViewById(R.id.tvGiaGio);
    }

}