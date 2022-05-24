package com.example.hervmed2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hervmed2.tabs.BenefitsFragment;
import com.example.hervmed2.tabs.HistoryFragment;
import com.example.hervmed2.tabs.HowToUseFragment;
import com.example.hervmed2.tabs.adapter.ViewStateAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    TextView textView, textView2;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Hervmed3);
        setContentView(R.layout.activity_information);

        fragmentLoader(new HistoryFragment());
        initialize();
        backButton();
        switchTabs();

    }



    public void fragmentLoader(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainerHistory, fragment)
                .commit();
    }//FRAGMENT LOADER


    public void initialize(){
        Intent intent = getIntent();
        HerbItems herbItems = intent.getParcelableExtra("Example");

        tabLayout = findViewById(R.id.tabLayout);

        int imageRes = herbItems.getImgResource();
        String title = herbItems.getTitle();
        String description = herbItems.getDescription();

        ImageView imageView = findViewById(R.id.imageHerb);
        imageView.setImageResource(imageRes);

        textView = findViewById(R.id.titleHerb);
        textView.setText(title);

        textView2 = findViewById(R.id.descriptionHerb);
        textView2.setText(description);


        tabLayout.addTab(tabLayout.newTab().setText("History"));
        tabLayout.addTab(tabLayout.newTab().setText("Benefits"));
        tabLayout.addTab(tabLayout.newTab().setText("How to use"));

    }

    public void backButton(){


        ImageButton backButton = (ImageButton) findViewById(R.id.backButtonXML);
        backButton.setOnClickListener(view -> {
            finish();
        });

    }

    public void switchTabs(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        ViewStateAdapter viewStateAdapter = new ViewStateAdapter(fragmentManager, getLifecycle());
        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(viewStateAdapter);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setTitle("");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


    }


}