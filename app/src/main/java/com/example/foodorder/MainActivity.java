package com.example.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.foodorder.Fragment.CartFragment;
import com.example.foodorder.Fragment.HelpFragment;
import com.example.foodorder.Fragment.HomeFragment;
import com.example.foodorder.Fragment.ProfileFragment;
import com.example.foodorder.Fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.BottomNav);
        loadFrag(new HomeFragment(),true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.home){
                    loadFrag(new HomeFragment(),true);
                }
                 else if(id==R.id.profile){
                    loadFrag(new ProfileFragment(),false);
                }
                else if(id==R.id.Cart){
                    loadFrag(new CartFragment(),false);
                }
                else if(id==R.id.help){
                    loadFrag(new HelpFragment(),false);
                }
                else{
                    loadFrag(new SettingFragment(),false);
                }
                return true;
            }
        });
    }

    public void loadFrag(Fragment fragment,boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag){
            ft.add(R.id.FrameLayout, fragment);
        }
        else{
            ft.replace(R.id.FrameLayout, fragment);
        }

        ft.commit();
    }
}