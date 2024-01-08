package com.example.orderfood.Fragment;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.ViewFlipper;
import com.example.orderfood.Adapter.MonAnAdapter;
import com.example.orderfood.DetailActivity;
import com.example.orderfood.LoginActivity;
import com.example.orderfood.Model.MonAn;
import com.example.orderfood.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
    View mView;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    MonAnAdapter mMonAnAdapter;
    AutoCompleteTextView autoCompleteTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView =  inflater.inflate(R.layout.fragment_home, container, false);
        mapping();
        actionViewPlipper();
        List<String> listTenMon = new ArrayList<>();
        for (MonAn ma : LoginActivity.listMon) {
            listTenMon.add(ma.getTenMon());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, listTenMon);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedUserName = (String) parent.getItemAtPosition(position);
                // Xử lý sự kiện khi người dùng chọn một item
                handleUserSelection(selectedUserName);
            }
        });
        return mView;
    }

    private void handleUserSelection(String selectedUserName) {
        MonAn monAn = null;
        for(MonAn ma : LoginActivity.listMon){
            if(ma.getTenMon() == selectedUserName){
                monAn = ma;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("detail",monAn);
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void mapping() {
        viewFlipper = mView.findViewById(R.id.fliper_trangChu);
        recyclerView = mView.findViewById(R.id.reclerview_trangChu);
        //
        mMonAnAdapter = new MonAnAdapter(getActivity(), LoginActivity.listMon);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(mMonAnAdapter);
        autoCompleteTextView = mView.findViewById(R.id.autoComplete);

    }
    private void actionViewPlipper() {
        List<String> mangQuangCao = new ArrayList<>();
        mangQuangCao.add("https://images.pexels.com/photos/2313682/pexels-photo-2313682.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        mangQuangCao.add("https://images.pexels.com/photos/2647936/pexels-photo-2647936.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        for(int i = 0; i< mangQuangCao.size(); i++){
            ImageView imageView = new ImageView(getActivity());
            Picasso.with(getActivity()).load(mangQuangCao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        //su kien tu chay
        viewFlipper.setFlipInterval(10000);
        viewFlipper.setAutoStart(true);
        Animation animation_in = AnimationUtils.loadAnimation(getActivity(),R.anim.slid_in_right);
        Animation animation_out = AnimationUtils.loadAnimation(getActivity(),R.anim.slid_in_left);
        viewFlipper.setInAnimation(animation_in);
        viewFlipper.setOutAnimation(animation_out);
    }
}