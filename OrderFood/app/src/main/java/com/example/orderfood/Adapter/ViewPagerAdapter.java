package com.example.orderfood.Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.orderfood.Fragment.CartFragment;
import com.example.orderfood.Fragment.HistoryFragment;
import com.example.orderfood.Fragment.HomeFragment;
import com.example.orderfood.Fragment.UserFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    Fragment currentItem;
    private FragmentManager fragmentManager;
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragmentManager = fm;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return new HomeFragment();
            case 1:
                return new CartFragment();
            case 2:
                return new HistoryFragment();
            case 3:
                return new UserFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

}
