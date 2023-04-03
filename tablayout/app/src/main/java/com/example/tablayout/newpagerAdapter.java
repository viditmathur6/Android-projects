package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class newpagerAdapter extends FragmentPagerAdapter {


    public newpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new CallFragment();
        }
        else if(position==1){
            return new chatFragment();
        }
        else if(position==2){
            return new StatusFragment();
        }
        else {
            return new BlankFragment();
        }

    }

    @Override
    public int getCount() {
        return 4;  // of tab
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "call";
        }
        else if(position==1){
            return "chat";
        }
        else if (position==2){
            return "group";
        }
        else {
            return "Status";
        }
    }
}
