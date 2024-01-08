package com.example.orderfood.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.orderfood.DetailActivity;
import com.example.orderfood.LoginActivity;
import com.example.orderfood.MainActivity;
import com.example.orderfood.Model.GioHang;
import com.example.orderfood.R;
import com.example.orderfood.Model.MonAn;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.orderfood.Server;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MonAnAdapter extends RecyclerView.Adapter<MonAnAdapter.ItemHolder> implements Filterable {

    Context context;
    List<MonAn> arrMonAn;
    List<MonAn> mList;

    public MonAnAdapter(Context context, List<MonAn> arrMonAn) {
        this.context = context;
        this.arrMonAn = arrMonAn;
        this.mList = arrMonAn;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_mon_an,null);
        ItemHolder itemHolder= new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        MonAn monAn = arrMonAn.get(position);
        holder.txtTenMon.setText(monAn.getTenMon());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGia.setText("Gia : "+decimalFormat.format(monAn.getGia())+"Đ");
        Picasso.with(context).load(monAn.getAnh()).into(holder.imgAnhMon);
        holder.imgAnhMon.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("detail",monAn);
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtras(bundle);
            context.startActivity(intent);
        });
        holder.btnAddCart.setOnClickListener(v -> {
            if(LoginActivity.user != null) {
                if(LoginActivity.listGioHangUser.size() > 0 ){
                    for(int i = 0; i < LoginActivity.listGioHangUser.size(); i++){
                        if(LoginActivity.listGioHangUser.get(i).getIdMon() == monAn.getIdMon()){
                            int Sl = LoginActivity.listGioHangUser.get(i).getSoLuong()+1;
                            LoginActivity.listGioHangUser.get(i).setSoLuong(Sl);
                            updateDataGioHang(Sl, monAn);
                            break;
                        }else{
                            Toast.makeText(context, "add1", Toast.LENGTH_SHORT).show();
                            addDataGioHang(monAn);
                        }
                    }

                }else {
                    Toast.makeText(context, "add2", Toast.LENGTH_SHORT).show();
                    addDataGioHang(monAn);
                }
            }else {
                //
            }
        });

    }

    private void updateDataGioHang(int sl, MonAn monAn) {
        Toast.makeText(context, "vao update gio hang", Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, Server.updateGioHang, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Success")){
                    Toast.makeText(context, "update thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(context, MainActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent1);
                }else{
                    Toast.makeText(context, ""+response, Toast.LENGTH_LONG).show();
                    throw new RuntimeException(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, ""+error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("idKhach", String.valueOf(LoginActivity.user.getIdKhach()));
                map.put("idMon",String.valueOf(monAn.getIdMon()));
                map.put("soLuong",String.valueOf(sl));
                return map;
            }
        };
        queue.add(request);
    }

    private void addDataGioHang(MonAn monAn) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, Server.addGioHang, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Success")){
                    LoginActivity.listGioHangUser.add(new GioHang(0,LoginActivity.user.getIdKhach(),monAn.getIdMon(),monAn.getAnh(),1));
                    Intent intent1 = new Intent(context, MainActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent1);
                }else if(response.equals("Error")) {
                    Toast.makeText(context, "insert ko thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, ""+error.getMessage(), Toast.LENGTH_LONG).show();
                throw new RuntimeException("loi:"+error);
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("idKhach", String.valueOf(LoginActivity.user.getIdKhach()));
                map.put("idMon",String.valueOf(monAn.getIdMon()));
                map.put("anh",monAn.getAnh());
                map.put("soLuong","1");
                return map;
            }
        };
        queue.add(request);
    }

    @Override
    public int getItemCount() {
        return arrMonAn.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String stringSearch = constraint.toString();
                if (stringSearch.isEmpty()){
                    arrMonAn = mList;
                }else {
                    List<MonAn> listMon = new ArrayList<>();
                    for(MonAn ma: mList) {
                        if(ma.getTenMon().toLowerCase().contains(stringSearch.toLowerCase())) {
                            listMon.add(ma);
                        }
                    }
                    arrMonAn = listMon;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = arrMonAn;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                arrMonAn = (List<MonAn>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imgAnhMon;
        public TextView txtTenMon, txtGia;
        public CircleImageView btnAddCart;
        public ItemHolder(View itemView){
            super(itemView);
            imgAnhMon = itemView.findViewById(R.id.imgMonAn);
            txtTenMon = itemView.findViewById(R.id.txtTenMon);
            txtGia = itemView.findViewById(R.id.txtGiaMon);
            btnAddCart = itemView.findViewById(R.id.btnAddCart);
        }

    }
}
