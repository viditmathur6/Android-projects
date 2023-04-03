package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomview);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.home){
                    load(new HomeFragment(),0);
                }
                else if(id == R.id.Contect){
                    load(new ContectFragment(),1);
                }
                else if(id == R.id.earn){
                    load(new EarnFragment(), 1);
                }
                else if(id == R.id.faculty){
                    load(new faclutyFragment(),1);
                }
                else{
                    load(new profileFragment(),1);
                }


                return true;

            }
        });

        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    private void load(Fragment fragment, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag == 0)
            ft.add(R.id.cointer, fragment);
        else
            ft.replace(R.id.cointer, fragment);
        ft.commit();

    }
}