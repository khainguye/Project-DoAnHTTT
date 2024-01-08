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
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderfood.Adapter.OptionAdapter;
import com.example.orderfood.LoginActivity;
import com.example.orderfood.MainActivity;
import com.example.orderfood.Model.Option;
import com.example.orderfood.R;
import com.example.orderfood.UpdateActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class UserFragment extends Fragment {
    View view;
    CircleImageView circleImgUser;
    TextView tvNameUser;
    List<Option> listOption;
    ListView lvOption;
    OptionAdapter optionAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user, container, false);
        mapping();
        return view;
    }

    private void mapping() {
        listOption = new ArrayList<>();
        addList();
        lvOption = view.findViewById(R.id.lvOption);
        circleImgUser = view.findViewById(R.id.circleImgUser);
        tvNameUser = view.findViewById(R.id.tvNameUser);
        if(LoginActivity.user != null){
            tvNameUser.setText(LoginActivity.user.getTen());
        }
        optionAdapter = new OptionAdapter(getActivity(),R.layout.custom_list_option,listOption);
        lvOption.setAdapter(optionAdapter);
        lvOption.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if(listOption.get(i).getName() == "Log in"){
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else if(listOption.get(i).getName() == "Log out"){
                    //clearData
                    LoginActivity.user = null;
//                    MainActivity.listGioHang = null;
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else if(listOption.get(i).getName() == "Update profile"){
                   if (LoginActivity.user != null){
                       Intent intent = new Intent(getActivity(), UpdateActivity.class);
                       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                       startActivity(intent);
                   }
                }
            }
        });
    }
    private void addList() {
        listOption.add(new Option(R.drawable.profile,"Update profile"));
        listOption.add(new Option(R.drawable.setting,"Setting"));
        listOption.add(new Option(R.drawable.help,"Help Center"));
        listOption.add(new Option(R.drawable.privacy,"Privacy Policy"));
        listOption.add(new Option(R.drawable.friend,"Invites Friends"));
        if(LoginActivity.user != null){
            listOption.add(new Option(R.drawable.logout,"Log out"));
        }else{
            listOption.add(new Option(R.drawable.logout,"Log in"));
        }
    }


}