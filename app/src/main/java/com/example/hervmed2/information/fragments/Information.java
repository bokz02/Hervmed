package com.example.hervmed2.information.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hervmed2.R;


public class Information extends Fragment {

    View view;
    TextView informationTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_information, container, false);

        initialize();
        getDataFromActivity();

        return view;
    }

    public void initialize(){
        informationTextView = view.findViewById(R.id.informationTextView);
    }

    // GET DATA FROM BOTTOM NAVI THE NEEDS to DISPLAY SPECIFIC DATA FROM EACH SUBJECT
    public void getDataFromActivity() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            informationTextView.setText(bundle.getString("Content"));
        }
    }
}