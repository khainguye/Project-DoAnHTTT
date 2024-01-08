package com.example.orderfood.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.orderfood.Adapter.HoaDonAdapter;
import com.example.orderfood.LoginActivity;
import com.example.orderfood.OrderDetalActivity;
import com.example.orderfood.R;

public class HistoryFragment extends Fragment {
    View mView;

    ListView lvHoaDon;
    HoaDonAdapter mHoaDonAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView =  inflater.inflate(R.layout.fragment_history, container, false);
        mapping();
        lvHoaDon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), OrderDetalActivity.class);
                i.putExtra("HoaDon", LoginActivity.listHoaDon.get(position));
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        return mView;
    }

    private void mapping() {
        lvHoaDon = mView.findViewById(R.id.lvHoaDon);
        mHoaDonAdapter = new HoaDonAdapter(getActivity(), R.layout.item_history, LoginActivity.listHoaDon);
        lvHoaDon.setAdapter(mHoaDonAdapter);
    }

}