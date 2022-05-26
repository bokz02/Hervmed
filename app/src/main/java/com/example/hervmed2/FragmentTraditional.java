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
        herbItems.add(new HerbItems(R.drawable.acapulco, "Acapulco", "Senna Alata",R.string.acapulco_content));
        herbItems.add(new HerbItems(R.drawable.bitter_melon, "Bitter melon", "Momordica charantia", R.string.bitter_melon_content));
        herbItems.add(new HerbItems(R.drawable.chaste_tree, "Chaste tree", "Vitex agnus-castus", R.string.chaste_tree_content));
        herbItems.add(new HerbItems(R.drawable.fukien_tea_tree, "Fukien tea tree", "Ehretia microphylla", R.string.fukien_tea_tree_content));
        herbItems.add(new HerbItems(R.drawable.garlic, "Garlic", "Allium sativum", R.string.garlic_content));
        herbItems.add(new HerbItems(R.drawable.guava, "Guava", "Psidium guajava", R.string.guava_content));
        herbItems.add(new HerbItems(R.drawable.pepper_elder, "Pepper elder", "Peperomia pellucida", R.string.pepper_elder_content));
        herbItems.add(new HerbItems(R.drawable.rangoon_creeper, "Rangoon creeper", "Combretum indicum", R.string.rangoon_creeper_content));
        herbItems.add(new HerbItems(R.drawable.sambong, "Sambong", "Blumea balsamifera", R.string.sambong_content));
        herbItems.add(new HerbItems(R.drawable.yerba_buena, "Yerba buena", "Combretum indicum", R.string.yerba_buena_content));
      return herbItems;
    }

    @Override
    public void onNoteClick(int position) {


        Intent intent = new Intent(getActivity(), InformationActivity.class);
        intent.putExtra("Example", herbItems.get(position));

        startActivity(intent);
    }
}


