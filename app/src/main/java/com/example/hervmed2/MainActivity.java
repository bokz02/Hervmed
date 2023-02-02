package com.example.hervmed2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.view.WindowManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity{


    BottomNavigationView bottomNavigationView;
    RecyclerView popularRecView;
    MediaPlayer mediaPlayer;


    public void fragmentLoader(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_Container, fragment)
                .commit();
    }//FRAGMENT LOADER


    public void hideActionBarInFragment() {
        ActionBar supportActionBar = ((AppCompatActivity) this).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.hide();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                            finish();
                        }
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void initialize(){
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.hermed_music);
        mediaPlayer.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Hervmed2);
        setContentView(R.layout.activity_main);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        MyMediaPlayer.getMediaPlayerInstance().playAudioFile(this, R.raw.hermed_music);

        //initialize();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        fragmentLoader(new Fragment1());

        //SWITCHING DIFFERENT FRAGMENTS
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        fragmentLoader(new Fragment1());
                        break;
                    case R.id.search:
                        fragmentLoader(new Fragment2());
                        break;
                    case R.id.favorite:
                        fragmentLoader(new Fragment3());
                        break;
                }
                return true;
            }
        });



    }
}
