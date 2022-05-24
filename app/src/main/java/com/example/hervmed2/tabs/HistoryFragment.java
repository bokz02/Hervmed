package com.example.hervmed2.tabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hervmed2.HerbItems;
import com.example.hervmed2.R;


public class HistoryFragment extends Fragment {

    TextView historyText;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_history, container, false);

        initialize();

        return view;
    }


    public void initialize(){
        historyText = (TextView) view.findViewById(R.id.historyTextFragment);
        Bundle bundle = this.getArguments();


        if (getArguments()!=null){
            HerbItems herbItems = bundle.getParcelable("History");
            String string = herbItems.getTitle();
            historyText.setText(string);
        }


    }

}