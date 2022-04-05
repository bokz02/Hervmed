package com.example.hervmed2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class InformationActivity extends AppCompatActivity {

    TextView contentText;

    public void hideActionBarInFragment() {
        ActionBar supportActionBar = ((AppCompatActivity) this).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.hide();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Hervmed3);
        setContentView(R.layout.activity_information);

        ImageButton backButton = (ImageButton) findViewById(R.id.backButtonXML);
        backButton.setOnClickListener(view -> {
            finish();
        });


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setTitle("");

        Intent intent = getIntent();
        HerbItems herbItems = intent.getParcelableExtra("Example");


        int imageRes = herbItems.getImgResource();
        String title = herbItems.getTitle();
        String description = herbItems.getDescription();


        ImageView imageView = findViewById(R.id.imageHerb);
        imageView.setImageResource(imageRes);

        TextView textView = findViewById(R.id.titleHerb);
        textView.setText(title);

        TextView textView2 = findViewById(R.id.descriptionHerb);
        textView2.setText(description);

        TextView textView3 = findViewById(R.id.contentHerb);
        if(textView.getText().toString().equals("Chamomile")){
            textView3.setText(R.string.chamomile_content);
        }
        else if (textView.getText().toString().equals("Borage")){
            textView3.setText(R.string.borage_content);
        }



    }
}