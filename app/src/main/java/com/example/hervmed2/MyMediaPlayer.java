package com.example.hervmed2;

import android.content.Context;
import android.media.MediaPlayer;

public class MyMediaPlayer {

    private static MyMediaPlayer Instance;
    MediaPlayer myMediaPlayer;

    static MyMediaPlayer getMediaPlayerInstance() {
        if (Instance == null) {
            return Instance = new MyMediaPlayer();
        }
        return Instance;
    }

    public void playAudioFile(Context context, int sampleAudio) {
        myMediaPlayer = MediaPlayer.create(context, sampleAudio);
        myMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

    public void stopAudioFile() {
        if (myMediaPlayer != null) {
            myMediaPlayer.pause();
        }
    }
}
