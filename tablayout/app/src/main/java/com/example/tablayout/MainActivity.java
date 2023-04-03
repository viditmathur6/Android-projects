package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tableLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        newpagerAdapter adapter = new newpagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tableLayout.setupWithViewPager(viewPager);
    }
}