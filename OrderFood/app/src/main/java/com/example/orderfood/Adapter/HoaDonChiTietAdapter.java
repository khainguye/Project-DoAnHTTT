package com.example.orderfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfood.LoginActivity;
import com.example.orderfood.MainActivity;
import com.example.orderfood.Model.GioHang;
import com.example.orderfood.Model.HoaDon;
import com.example.orderfood.Model.HoaDonChiTiet;
import com.example.orderfood.Model.MonAn;
import com.example.orderfood.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class HoaDonChiTietAdapter extends BaseAdapter {
    Context mContext;
    int mLayout;
    List<HoaDonChiTiet> mList;

    public HoaDonChiTietAdapter(Context mContext, int mLayout, List<HoaDonChiTiet> mList) {
        this.mContext = mContext;
        this.mLayout = mLayout;
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
        convertView =layoutInflater.inflate(mLayout, null);
        TextView tvTenOrder = convertView.findViewById(R.id.tvTenOrder);
        TextView tvSlOrder = convertView.findViewById(R.id.tvSlOrder);
        TextView tvGiaOrder = convertView.findViewById(R.id.tvGiaOrder);
        ImageView imgAnhOrder = convertView.findViewById(R.id.imgAnhOrder);
        HoaDonChiTiet chiTiet = mList.get(position);
        tvSlOrder.setText(String.valueOf(chiTiet.getSoLuong()));
        MonAn monAn = new MonAn();
        for(int i = 0; i < LoginActivity.listMon.size(); i++){
            if(chiTiet.getIdMon() == LoginActivity.listMon.get(i).getIdMon()){
                monAn = MainActivity.listMonAn.get(i);
                break;
            }
        }
        Picasso.with(mContext).load(monAn.getAnh()).into(imgAnhOrder);
        tvTenOrder.setText(monAn.getTenMon());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvGiaOrder.setText("Gia : "+decimalFormat.format(chiTiet.getGia()));
        return convertView;
    }
}
