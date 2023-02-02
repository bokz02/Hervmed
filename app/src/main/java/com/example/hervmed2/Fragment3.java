package com.example.hervmed2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    ImageButton aboutButton, helpButton;
    View view;
    ToggleButton toggleButton;
    MediaPlayer mediaPlayer;
    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (ViewGroup) inflater.inflate(R.layout.fragment3,container,false);

        onStop();
        ((MainActivity) requireActivity()).hideActionBarInFragment();
        initialize();
        goToAboutActivity();
        goToHelpActivity();
        toggleMusic();

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        onStop();
        ((MainActivity) requireActivity()).hideActionBarInFragment();
        initialize();
        goToAboutActivity();
    }

    @Override
    public void onPause() {

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }

        super.onPause();
    }

    public void initialize(){
        aboutButton = view.findViewById(R.id.aboutButton);
        helpButton = view.findViewById(R.id.helpImageButton);
        toggleButton = view.findViewById(R.id.musicToggle);
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.hermed_music);
    }


    public void goToAboutActivity(){
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), About.class);
                startActivity(intent);
            }
        });
    }

    public void goToHelpActivity(){
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Help.class);
                startActivity(intent);
            }
        });
    }

    //Remove action bar animation when hiding
    @SuppressLint("RestrictedApi")
    @Override
    public void onStop() {
        super.onStop();
        ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setShowHideAnimationEnabled(false);
        assert supportActionBar != null;
        supportActionBar.show();
    }

    public void toggleMusic(){
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (toggleButton.isChecked()){
                    //MyMediaPlayer.getMediaPlayerInstance().playAudioFile(getContext(), R.raw.hermed_music);
                    MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
                }else {
                    MyMediaPlayer.getMediaPlayerInstance().playAudioFile(getContext(), R.raw.hermed_music);
                }
            }
        });

    }

}
