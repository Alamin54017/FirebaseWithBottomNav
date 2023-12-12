package com.example.bottomnavapp;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomView);
        getSupportFragmentManager().beginTransaction().replace(R.id.relativeLayout,new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.homeFragment);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String i=item.toString();
                switch (i){
                    case "Home":
                        getSupportFragmentManager().beginTransaction().replace(R.id.relativeLayout,new HomeFragment()).commit();
                        break;
                    case "Profile":
                        getSupportFragmentManager().beginTransaction().replace(R.id.relativeLayout,new ProfileFragment()).commit();
                        break;
                    case "Settings":
                        getSupportFragmentManager().beginTransaction().replace(R.id.relativeLayout,new SettingFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }

}