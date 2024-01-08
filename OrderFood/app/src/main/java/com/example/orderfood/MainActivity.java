package com.example.orderfood;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;
import android.app.SearchManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.orderfood.Adapter.ViewPagerAdapter;
import com.example.orderfood.Model.MonAn;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;
    ViewPager mViewPager;
    ViewPagerAdapter mViewPagerAdapter;
    public static List<MonAn> listMonAn = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadListMonAn();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        if(LoginActivity.user != null){

        }else{

        }
        //viewpager
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        mBottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.action_cart).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.action_history).setChecked(true);
                        break;
                    case 3:
                        mBottomNavigationView.getMenu().findItem(R.id.action_personal).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //su kine na nut trne naviBar
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId() == R.id.action_home){
                mViewPager.setCurrentItem(0);
            } else if (item.getItemId() == R.id.action_cart) {
                mViewPager.setCurrentItem(1);
            } else if (item.getItemId() == R.id.action_history) {
                mViewPager.setCurrentItem(2);
            }else {
                mViewPager.setCurrentItem(3);
            }
            return true;
        });
    }


    private void loadListMonAn() {
        if(listMonAn.size() > 0) {
            listMonAn.clear();
        }
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.duongDanSanPham, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                listMonAn.clear();

                for (int i = 0; i<response.length();i++)
                {
                    try {
                        JSONObject j = response.getJSONObject(i);
                        MonAn monAn = new MonAn(j.getInt("idMon"),
                                j.getString("tenMon"),
                                j.getString("moTa"),
                                j.getInt("gia"),
                                j.getString("anh"),
                                j.getInt("idLoai"));
                        listMonAn.add(monAn);
                    } catch (JSONException e) {
                        Log.d("TAG", "onResponse: "+e);
                        throw new RuntimeException(e+"loi");
                    }
                }
                Log.d("danh sach mon", "listMon: "+listMonAn);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("loi", "onErrorResponse: "+error);
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
    private void mapping() {
        mViewPager = findViewById(R.id.viewpager);
        mBottomNavigationView = findViewById(R.id.bottom_navi);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(0);
    }


}