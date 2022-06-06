package com.example.hervmed2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hervmed2.adapter.ViewPagerAdapter;
import com.example.hervmed2.information.fragments.Information;
import com.google.android.material.tabs.TabLayout;

public class InformationActivity2 extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    TextView title, description, content;
    ImageView imageView;
    FragmentStateAdapter fragmentStateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.hervmed4);
        setContentView(R.layout.activity_information2);

        initialize();
        adapter();
        getDataFromRecyclerView();
        loadDataToFragment();


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
    }

    public void getDataFromRecyclerView(){
        Intent intent = getIntent();
        HerbItems herbItems = intent.getParcelableExtra("Example");

        int imageRes = herbItems.getImgResource();
        int contentHerb = herbItems.getContent();
        String titleHerb = herbItems.getTitle();
        String descriptionHerb = herbItems.getDescription();

        imageView.setImageResource(imageRes);
        title.setText(titleHerb);
        content.setText(contentHerb);
        description.setText(descriptionHerb);

    }


    public void loadDataToFragment(){

        Bundle bundle = new Bundle();
        bundle.putString("Content", content.getText().toString());
        Information information = new Information();
        information.setArguments(bundle);

    }





    public void adapter(){
        fragmentStateAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(fragmentStateAdapter);

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
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

    public void initialize(){
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        title = findViewById(R.id.titleHerb);
        description = findViewById(R.id.descriptionHerb);
        imageView = findViewById(R.id.imageHerb);
        content = findViewById(R.id.contentActivity);
    }
}