package com.example.hervmed2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Random;

public class Fragment1 extends Fragment {
    TextView textDidYouKnow;
    ImageButton btnPopular,btnTraditional, btnRare, btnCommon, btnDrugs, btnPoisonous, btnEdible;
    private View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment1,container,false);

        initViews();
        onStop();
        ((MainActivity) requireActivity()).hideActionBarInFragment();
         btnPopular1();
         BtnTraditional();
         btnRare();
         btnCommon();
         btnDrug();
         btnPoison();
         btnEdiblee();
         randomFacts();

        return v;
    }

    public void BtnTraditional(){
        initViews();
        btnTraditional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Traditional", Toast.LENGTH_SHORT).show();

                getActivity().setTitle(Html .fromHtml("<font color = \"#FFFFFF\">" + "Traditional" + "</font>"));

                Fragment fragment = new FragmentTraditional();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_Container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
    }


    public void btnPopular1(){
        initViews();
        btnPopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Popular", Toast.LENGTH_SHORT).show();

                getActivity().setTitle(Html.fromHtml("<font color = \"#FFFFFF\">" + "Popular" + "</font>"));

                Fragment fragment = new FragmentPopular();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_Container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
    public void btnRare(){
        initViews();
        btnRare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Rare", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void btnCommon(){
        initViews();
        btnCommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Common", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void btnDrug(){
        initViews();
        btnDrugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Drugs", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void btnPoison(){
        initViews();
        btnPoisonous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Poisonous", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void btnEdiblee(){
        initViews();
        btnEdible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Edible", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initViews(){
        btnPopular = (ImageButton)v.findViewById(R.id.heart1);
        btnTraditional = (ImageButton) v.findViewById(R.id.leaf2);
        btnRare = (ImageButton) v.findViewById(R.id.leaf3);
        btnCommon = (ImageButton) v.findViewById(R.id.leaf4);
        btnDrugs = (ImageButton) v.findViewById(R.id.drug);
        btnPoisonous = (ImageButton) v.findViewById(R.id.poison);
        btnEdible = (ImageButton) v.findViewById(R.id.edible);
        textDidYouKnow = (TextView) v.findViewById(R.id.textViewDidYouKnow);

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

    public void randomFacts(){
        String[] myArray = getResources().getStringArray(R.array.DidYouKnow);
        Random random = new Random();
        textDidYouKnow.setText(myArray[random.nextInt(myArray.length - 1)]);
    }


}
