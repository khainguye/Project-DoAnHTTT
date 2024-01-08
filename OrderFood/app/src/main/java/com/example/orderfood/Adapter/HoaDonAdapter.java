package com.example.orderfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.orderfood.Model.HoaDon;
import com.example.orderfood.R;

import java.util.List;

public class HoaDonAdapter extends BaseAdapter {
    Context mContext;
    int mLayout;
    List<HoaDon> mList;

    public HoaDonAdapter(Context mContext, int mLayout, List<HoaDon> mList) {
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
        TextView tvDateOrder = convertView.findViewById(R.id.tvDateOrder);
        TextView tvPhoneOrder = convertView.findViewById(R.id.tvPhoneOrder);
        TextView tvAddressOrder = convertView.findViewById(R.id.tvAddressOrder);
        TextView tvTotalOrder = convertView.findViewById(R.id.tvTotalOrder1);
        HoaDon hd = mList.get(position);
        tvDateOrder.setText(hd.getDate());
        tvPhoneOrder.setText(hd.getPhone());
        tvAddressOrder.setText(hd.getAddress());
        tvTotalOrder.setText(String.valueOf(hd.getTotal()));
        return convertView;
    }
}
