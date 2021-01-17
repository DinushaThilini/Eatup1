package com.example.eatup;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.eatup.chefFoodPanel.ChefHomeFragment;
import com.example.eatup.chefFoodPanel.ChefOrderFragment;
import com.example.eatup.chefFoodPanel.ChefPendingOrderFragment;
import com.example.eatup.chefFoodPanel.ChefProfileFragment;
import com.example.eatup.customerFoodPanel.CustomerProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChefFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_food_panel__bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.chef_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.chefHome:
                fragment=new ChefHomeFragment();
                break;
            case R.id.PendingOrders:
                fragment= new ChefPendingOrderFragment();
                break;
            case R.id.Orders:
                fragment=new ChefOrderFragment();
                break;
            case R.id.chefProfile:
                fragment=new ChefProfileFragment();
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