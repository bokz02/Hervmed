package com.example.hervmed2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.hervmed2.information.fragments.Benefits;
import com.example.hervmed2.information.fragments.HowToUse;
import com.example.hervmed2.information.fragments.Information;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private static final int PAGES = 3;


    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:

                return new Benefits();
            case 2:
                return new HowToUse();
            default:
                return new Information();
        }
    }

    @Override
    public int getItemCount() {
        return PAGES;
    }


}

