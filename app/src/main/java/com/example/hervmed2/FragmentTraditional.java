package com.example.hervmed2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentTraditional extends Fragment implements HerbAdapter.OnNoteListenerHerb{
    ArrayList<HerbItems> herbItems = new ArrayList<>();

    private static final String TAG = "Main Activity";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_recyclerview_container, container, false);

        RecyclerView popularRecView = view.findViewById(R.id.reyclerViewContainer);
        popularRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        HerbAdapter hAdapter = new HerbAdapter(initHerb(), this);
        popularRecView.setAdapter(hAdapter);

        return view;
    }

    private ArrayList<HerbItems> initHerb(){
        herbItems.add(new HerbItems(R.drawable.borage, "Borage", "Borago officinalis"));
        herbItems.add(new HerbItems(R.drawable.chamomile2, "Chamomile", "This is sample description"));
      return herbItems;
    }

    @Override
    public void onNoteClick(int position) {


        Intent intent = new Intent(getActivity(), InformationActivity.class);
        intent.putExtra("Example", herbItems.get(position));

        startActivity(intent);
    }
}


