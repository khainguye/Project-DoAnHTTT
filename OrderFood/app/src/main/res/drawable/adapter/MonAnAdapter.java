package com.example.myapplication2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MonAnAdapter extends RecyclerView.Adapter<MonAnAdapter.ItemHolder> {
    Context context;
    ArrayList<MonAn> arrMonAn;

    public MonAnAdapter(Context context, ArrayList<MonAn> arrMonAn) {
        this.context = context;
        this.arrMonAn = arrMonAn;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_mon_an, null);
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
        holder.imgAnhMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "123", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,ChiTietMon.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrMonAn.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imgAnhMon;
        public TextView txtTenMon, txtGia;
        public ItemHolder(View itemView){
            super(itemView);
            imgAnhMon = itemView.findViewById(R.id.imgMonAn);
            txtTenMon = itemView.findViewById(R.id.txtTenMon);
            txtGia = itemView.findViewById(R.id.txtGiaMon);
        }

    }
}
