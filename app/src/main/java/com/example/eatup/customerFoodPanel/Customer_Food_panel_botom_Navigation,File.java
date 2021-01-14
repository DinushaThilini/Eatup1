package com.example.eatup.customerFoodPanel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.eatup.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import my.foodOn.app.R;

public class ChefPendingOrderFragment extends AppCompatActivity implements BottomNavigationView, BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(savedInstaceState);
        setContentView( R.layout. customer_food_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.delivery_bottom_navigation);
        navigationView.setOnNavigationItemReselectedListener(this);
    }
    @Override
    public boolean onNavigationItemSelected (@NonNull MenuItem item) {


        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.cust_Home;
            fragment=new CustomerHomeFragment();
            break;
        }
        switch (item.getItemId()){
            case R.id.cust_Cart;
            fragment=new CustomerCartFragment();
                break;
        }
        switch (item.getItemId()){
            case R.id.cust_profile;
                fragment=new CustomerProfileFragment();
                break;

        }
        switch (item.getItemId()){
            case R.id.cust_Orders;
                fragment=new CustomerOrderFragment();
                break;
        }

        return loadcheffragment(fragment);

    }

    private boolean loadcheffragment(Fragment fragment) {

        if(fragment !=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}