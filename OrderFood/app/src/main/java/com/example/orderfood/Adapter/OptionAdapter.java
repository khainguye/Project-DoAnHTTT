package com.example.orderfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfood.Model.Option;
import com.example.orderfood.R;

import java.util.List;

public class OptionAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Option> mList;

    public OptionAdapter(Context context, int layout, List<Option> mList) {
        this.context = context;
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        ImageView imgOption = convertView.findViewById(com.example.orderfood.R.id.imgOption);
        TextView tvOption = convertView.findViewById(R.id.tvOption);
        Option ot = mList.get(position);
        imgOption.setImageResource(ot.getImg());
        tvOption.setText(ot.getName());
        return convertView;
    }
}
