package com.example.eatup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.eatup.customerFoodPanel.CustomerCartFragment;
import com.example.eatup.customerFoodPanel.CustomerHomeFragment;
import com.example.eatup.customerFoodPanel.CustomerOrderFragment;
import com.example.eatup.customerFoodPanel.CustomerProfileFragment;
import com.example.eatup.customerFoodPanel.CustomerTrackFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CustomerFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_food_panel__bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.cust_Home:
                fragment=new CustomerHomeFragment();
                break;
            case R.id.cust_profile:
                fragment=new CustomerProfileFragment();
                break;
            case R.id.Cust_order:
                fragment=new CustomerOrderFragment();
                break;
            case R.id.cust_track:
                fragment=new CustomerTrackFragment();
                break;
            case R.id.cust_Cart:
                fragment=new CustomerCartFragment();
                break;
        }
        return loadcheffragment(fragment);
    }

    private boolean loadcheffragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,fragment).commit();
            return true;
        }
        return false;

    }

}